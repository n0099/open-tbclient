package com.baidu.tieba.ala.person;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.az;
import com.baidu.live.data.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.d;
/* loaded from: classes4.dex */
public class PersonListFragment extends BaseFragment {
    private Context context;
    private CustomMessageListener fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    PersonCardActivity personCardActivity = (PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage();
                    boolean z = PersonListFragment.this.userId != null && PersonListFragment.this.userId.equals(TbadkCoreApplication.getCurrentAccount());
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (PersonListFragment.this.gSQ != null) {
                            PersonListFragment.this.gSQ.aw(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
                        }
                        if (!com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonListFragment.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListFragment.this.getUniqueId())) {
                            PersonListFragment.this.showToast(updateAttentionMessage.getData().errorString);
                            return;
                        }
                        return;
                    }
                    if (z && personCardActivity != null && PersonListFragment.this.type == 1) {
                        personCardActivity.mQ(updateAttentionMessage.isAttention());
                    }
                    if (PersonListFragment.this.gSQ != null) {
                        PersonListFragment.this.gSQ.aw(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonListFragment.this.getUniqueId())) {
                        if (updateAttentionMessage.getData().isAttention) {
                            PersonListFragment.this.showToast(PersonListFragment.this.getResources().getString(a.i.sdk_attention_success_toast));
                        } else {
                            PersonListFragment.this.showToast(PersonListFragment.this.getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.ala.person.adapter.a gSQ;
    private BdListView gSR;
    private c gSS;
    private boolean gST;
    private d gSU;
    private boolean gSV;
    private Object gSW;
    private AlaListEmptyView gSX;
    private String metaKey;
    private int type;
    private String userId;

    public static PersonListFragment a(int i, String str, String str2, Object obj) {
        PersonListFragment personListFragment = new PersonListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("user_id", str);
        bundle.putString("meta_key", str2);
        personListFragment.setArguments(bundle);
        personListFragment.ar(obj);
        return personListFragment;
    }

    public void ar(Object obj) {
        this.gSW = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.fSS);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_list, (ViewGroup) null);
        initData();
        am(inflate);
        initListener();
        cah();
        return inflate;
    }

    private void bag() {
        b(true, this.gSW);
    }

    private void initListener() {
        this.gSR.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.gST) {
                    PersonListFragment.this.gSU.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.gSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.gSQ != null && PersonListFragment.this.gSQ.getCount() == 0) {
                    PersonListFragment.this.gSS.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.gSQ.a(new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0645a
            public void a(az azVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(PersonListFragment.this.getActivity());
                } else if (azVar != null && azVar.portrait != null && azVar.id != null) {
                    if (azVar.aJZ == 0) {
                        azVar.aJZ = 1;
                        e eVar = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", true, PersonListFragment.this.getUniqueId());
                        eVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Rg().a(azVar.id, eVar);
                    } else {
                        azVar.aJZ = 0;
                        e eVar2 = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", false, PersonListFragment.this.getUniqueId());
                        eVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Rg().a(azVar.id, eVar2);
                    }
                    PersonListFragment.this.gSQ.notifyDataSetChanged();
                }
            }
        });
        this.gSQ.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(az azVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).b(com.baidu.tieba.ala.person.d.a.a(azVar));
                }
            }
        });
    }

    private void initData() {
        this.gSS = new c(getPageContext());
        this.gSS.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.gSV, cVar);
                    if (PersonListFragment.this.gSV) {
                        PersonListFragment.this.gSV = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.i.ala_person_load_fail);
                PersonListFragment.this.gSU.vi(a.i.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.gSQ.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.c)) {
            this.gST = ((com.baidu.tieba.ala.person.a.c) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.c) obj).has_more != 1) {
                this.gSU.hide();
            } else {
                this.gSU.qO(a.i.sdk_loading);
            }
            this.gSQ.a(z, ((com.baidu.tieba.ala.person.a.c) obj).user_list, this.type);
        }
    }

    private void cah() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.gSQ.a(true, null, this.type);
        } else if (this.gSW == null) {
            if (this.gSS != null) {
                this.gSS.setPn(0);
            }
            this.gSV = true;
            loadData();
        } else {
            if (this.gSS != null) {
                this.gSS.setPn(1);
            }
            this.gSV = false;
            bag();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.gST) {
            if ((this.type == 1 || this.type == 0) && this.gSS != null) {
                this.gSS.i(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void am(View view) {
        this.gSR = (BdListView) view.findViewById(a.g.listview);
        this.gSQ = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.gSR.setAdapter((ListAdapter) this.gSQ);
        this.gSU = new d(getPageContext());
        this.gSU.createView();
        this.gSR.setNextPage(this.gSU);
        this.gSU.display();
        this.gSU.qO(a.i.sdk_loading);
        this.gSX = (AlaListEmptyView) view.findViewById(a.g.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.gSX.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.gSX.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_fans);
            } else {
                this.gSX.setParams(a.f.sdk_pic_live_empty01_hk, a.i.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.gSX.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.gSX.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_fans);
        } else {
            this.gSX.setParams(a.f.sdk_pic_live_empty01_qm, a.i.sdk_list_empty_text);
        }
        this.gSR.setEmptyView(this.gSX);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gSS != null) {
            this.gSS.cancel();
        }
    }
}
