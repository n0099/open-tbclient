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
import com.baidu.live.data.bf;
import com.baidu.live.data.f;
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
    private CustomMessageListener gDs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
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
                        if (PersonListFragment.this.hIT != null) {
                            PersonListFragment.this.hIT.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
                        }
                        if (!com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonListFragment.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListFragment.this.getUniqueId())) {
                            PersonListFragment.this.showToast(updateAttentionMessage.getData().errorString);
                            return;
                        }
                        return;
                    }
                    if (z && personCardActivity != null && PersonListFragment.this.type == 1) {
                        personCardActivity.op(updateAttentionMessage.isAttention());
                    }
                    if (PersonListFragment.this.hIT != null) {
                        PersonListFragment.this.hIT.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonListFragment.this.getUniqueId())) {
                        if (updateAttentionMessage.getData().isAttention) {
                            PersonListFragment.this.showToast(PersonListFragment.this.getResources().getString(a.h.sdk_attention_success_toast));
                        } else {
                            PersonListFragment.this.showToast(PersonListFragment.this.getResources().getString(a.h.sdk_unfollow_success_toast));
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.ala.person.adapter.a hIT;
    private BdListView hIU;
    private c hIV;
    private boolean hIW;
    private d hIX;
    private boolean hIY;
    private Object hIZ;
    private AlaListEmptyView hJa;
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
        personListFragment.au(obj);
        return personListFragment;
    }

    public void au(Object obj) {
        this.hIZ = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.gDs);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_list, (ViewGroup) null);
        initData();
        an(inflate);
        initListener();
        cmw();
        return inflate;
    }

    private void bjF() {
        b(true, this.hIZ);
    }

    private void initListener() {
        this.hIU.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.hIW) {
                    PersonListFragment.this.hIX.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hIX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.hIT != null && PersonListFragment.this.hIT.getCount() == 0) {
                    PersonListFragment.this.hIV.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hIT.a(new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0706a
            public void a(bf bfVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(PersonListFragment.this.getActivity());
                } else if (bfVar != null && bfVar.portrait != null && bfVar.id != null) {
                    if (bfVar.aQa == 0) {
                        bfVar.aQa = 1;
                        f fVar = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", true, PersonListFragment.this.getUniqueId());
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar);
                    } else {
                        bfVar.aQa = 0;
                        f fVar2 = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", false, PersonListFragment.this.getUniqueId());
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar2);
                    }
                    PersonListFragment.this.hIT.notifyDataSetChanged();
                }
            }
        });
        this.hIT.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bf bfVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).c(com.baidu.tieba.ala.person.d.a.a(bfVar));
                }
            }
        });
    }

    private void initData() {
        this.hIV = new c(getPageContext());
        this.hIV.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.hIY, cVar);
                    if (PersonListFragment.this.hIY) {
                        PersonListFragment.this.hIY = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonListFragment.this.hIX.xy(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.hIT.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.c)) {
            this.hIW = ((com.baidu.tieba.ala.person.a.c) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.c) obj).has_more != 1) {
                this.hIX.hide();
            } else {
                this.hIX.sG(a.h.sdk_loading);
            }
            this.hIT.a(z, ((com.baidu.tieba.ala.person.a.c) obj).user_list, this.type);
        }
    }

    private void cmw() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hIT.a(true, null, this.type);
        } else if (this.hIZ == null) {
            if (this.hIV != null) {
                this.hIV.setPn(0);
            }
            this.hIY = true;
            loadData();
        } else {
            if (this.hIV != null) {
                this.hIV.setPn(1);
            }
            this.hIY = false;
            bjF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hIW) {
            if ((this.type == 1 || this.type == 0) && this.hIV != null) {
                this.hIV.e(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void an(View view) {
        this.hIU = (BdListView) view.findViewById(a.f.listview);
        this.hIT = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hIU.setAdapter((ListAdapter) this.hIT);
        this.hIX = new d(getPageContext());
        this.hIX.createView();
        this.hIU.setNextPage(this.hIX);
        this.hIX.su();
        this.hIX.sG(a.h.sdk_loading);
        this.hJa = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.hJa.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.hJa.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_fans);
            } else {
                this.hJa.setParams(a.e.sdk_pic_live_empty01_hk, a.h.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.hJa.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.hJa.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_fans);
        } else {
            this.hJa.setParams(a.e.sdk_pic_live_empty01_qm, a.h.sdk_list_empty_text);
        }
        this.hIU.setEmptyView(this.hJa);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hIV != null) {
            this.hIV.cancel();
        }
    }
}
