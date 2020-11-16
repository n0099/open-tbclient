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
import com.baidu.live.data.be;
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
    private CustomMessageListener guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
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
                        if (PersonListFragment.this.hzo != null) {
                            PersonListFragment.this.hzo.aC(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
                        }
                        if (!com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonListFragment.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListFragment.this.getUniqueId())) {
                            PersonListFragment.this.showToast(updateAttentionMessage.getData().errorString);
                            return;
                        }
                        return;
                    }
                    if (z && personCardActivity != null && PersonListFragment.this.type == 1) {
                        personCardActivity.nU(updateAttentionMessage.isAttention());
                    }
                    if (PersonListFragment.this.hzo != null) {
                        PersonListFragment.this.hzo.aC(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
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
    private com.baidu.tieba.ala.person.adapter.a hzo;
    private BdListView hzp;
    private c hzq;
    private boolean hzr;
    private d hzs;
    private boolean hzt;
    private Object hzu;
    private AlaListEmptyView hzv;
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
        this.hzu = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.guJ);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_list, (ViewGroup) null);
        initData();
        al(inflate);
        initListener();
        ciC();
        return inflate;
    }

    private void bgA() {
        b(true, this.hzu);
    }

    private void initListener() {
        this.hzp.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.hzr) {
                    PersonListFragment.this.hzs.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.hzo != null && PersonListFragment.this.hzo.getCount() == 0) {
                    PersonListFragment.this.hzq.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hzo.a(new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0693a
            public void a(be beVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(PersonListFragment.this.getActivity());
                } else if (beVar != null && beVar.portrait != null && beVar.id != null) {
                    if (beVar.aNb == 0) {
                        beVar.aNb = 1;
                        f fVar = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", true, PersonListFragment.this.getUniqueId());
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VO().a(beVar.id, fVar);
                    } else {
                        beVar.aNb = 0;
                        f fVar2 = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", false, PersonListFragment.this.getUniqueId());
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VO().a(beVar.id, fVar2);
                    }
                    PersonListFragment.this.hzo.notifyDataSetChanged();
                }
            }
        });
        this.hzo.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(be beVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).c(com.baidu.tieba.ala.person.d.a.a(beVar));
                }
            }
        });
    }

    private void initData() {
        this.hzq = new c(getPageContext());
        this.hzq.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.hzt, cVar);
                    if (PersonListFragment.this.hzt) {
                        PersonListFragment.this.hzt = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonListFragment.this.hzs.wT(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.hzo.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.c)) {
            this.hzr = ((com.baidu.tieba.ala.person.a.c) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.c) obj).has_more != 1) {
                this.hzs.hide();
            } else {
                this.hzs.sf(a.h.sdk_loading);
            }
            this.hzo.a(z, ((com.baidu.tieba.ala.person.a.c) obj).user_list, this.type);
        }
    }

    private void ciC() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hzo.a(true, null, this.type);
        } else if (this.hzu == null) {
            if (this.hzq != null) {
                this.hzq.setPn(0);
            }
            this.hzt = true;
            loadData();
        } else {
            if (this.hzq != null) {
                this.hzq.setPn(1);
            }
            this.hzt = false;
            bgA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hzr) {
            if ((this.type == 1 || this.type == 0) && this.hzq != null) {
                this.hzq.c(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void al(View view) {
        this.hzp = (BdListView) view.findViewById(a.f.listview);
        this.hzo = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hzp.setAdapter((ListAdapter) this.hzo);
        this.hzs = new d(getPageContext());
        this.hzs.createView();
        this.hzp.setNextPage(this.hzs);
        this.hzs.display();
        this.hzs.sf(a.h.sdk_loading);
        this.hzv = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.hzv.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.hzv.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_fans);
            } else {
                this.hzv.setParams(a.e.sdk_pic_live_empty01_hk, a.h.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.hzv.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.hzv.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_fans);
        } else {
            this.hzv.setParams(a.e.sdk_pic_live_empty01_qm, a.h.sdk_list_empty_text);
        }
        this.hzp.setEmptyView(this.hzv);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hzq != null) {
            this.hzq.cancel();
        }
    }
}
