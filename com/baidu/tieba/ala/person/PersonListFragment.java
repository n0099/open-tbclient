package com.baidu.tieba.ala.person;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.a.b;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.d;
/* loaded from: classes3.dex */
public class PersonListFragment extends BaseFragment {
    private Context context;
    private CustomMessageListener ewi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
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
                        if (PersonListFragment.this.fqJ != null) {
                            PersonListFragment.this.fqJ.Z(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
                        }
                        if (!com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), PersonListFragment.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListFragment.this.getUniqueId())) {
                            PersonListFragment.this.showToast(updateAttentionMessage.getData().errorString);
                            return;
                        }
                        return;
                    }
                    if (z && personCardActivity != null && PersonListFragment.this.type == 1) {
                        personCardActivity.jV(updateAttentionMessage.isAttention());
                    }
                    if (PersonListFragment.this.fqJ != null) {
                        PersonListFragment.this.fqJ.Z(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
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
    private com.baidu.tieba.ala.person.adapter.a fqJ;
    private BdListView fqK;
    private c fqL;
    private boolean fqM;
    private d fqN;
    private boolean fqO;
    private Object fqP;
    private AlaListEmptyView fqQ;
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
        personListFragment.ai(obj);
        return personListFragment;
    }

    public void ai(Object obj) {
        this.fqP = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.ewi);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_list, (ViewGroup) null);
        initData();
        initView(inflate);
        initListener();
        brZ();
        return inflate;
    }

    private void ayh() {
        b(true, this.fqP);
    }

    private void initListener() {
        this.fqK.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.fqM) {
                    PersonListFragment.this.fqN.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.fqN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.fqJ != null && PersonListFragment.this.fqJ.getCount() == 0) {
                    PersonListFragment.this.fqL.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.fqJ.a(new a.InterfaceC0473a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0473a
            public void a(b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(PersonListFragment.this.getActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eMk == 0) {
                        bVar.eMk = 1;
                        com.baidu.live.view.a.Bq().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, PersonListFragment.this.getUniqueId()));
                    } else {
                        bVar.eMk = 0;
                        com.baidu.live.view.a.Bq().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, PersonListFragment.this.getUniqueId()));
                    }
                    PersonListFragment.this.fqJ.notifyDataSetChanged();
                }
            }
        });
        this.fqJ.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(b bVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).b(com.baidu.tieba.ala.person.d.a.a(bVar));
                }
            }
        });
    }

    private void initData() {
        this.fqL = new c(getPageContext());
        this.fqL.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.fqO, dVar);
                    if (PersonListFragment.this.fqO) {
                        PersonListFragment.this.fqO = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.i.ala_person_load_fail);
                PersonListFragment.this.fqN.qN(a.i.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.fqJ.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.d)) {
            this.fqM = ((com.baidu.tieba.ala.person.a.d) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.d) obj).has_more != 1) {
                this.fqN.hide();
            } else {
                this.fqN.mK(a.i.sdk_loading);
            }
            this.fqJ.a(z, ((com.baidu.tieba.ala.person.a.d) obj).user_list, this.type);
        }
    }

    private void brZ() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.fqJ.a(true, null, this.type);
        } else if (this.fqP == null) {
            if (this.fqL != null) {
                this.fqL.setPn(0);
            }
            this.fqO = true;
            loadData();
        } else {
            if (this.fqL != null) {
                this.fqL.setPn(1);
            }
            this.fqO = false;
            ayh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.fqM) {
            if ((this.type == 1 || this.type == 0) && this.fqL != null) {
                this.fqL.g(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void initView(View view) {
        this.fqK = (BdListView) view.findViewById(a.g.listview);
        this.fqJ = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.fqK.setAdapter((ListAdapter) this.fqJ);
        this.fqN = new d(getPageContext());
        this.fqN.createView();
        this.fqK.setNextPage(this.fqN);
        this.fqN.display();
        this.fqN.mK(a.i.sdk_loading);
        this.fqQ = (AlaListEmptyView) view.findViewById(a.g.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.fqQ.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.fqQ.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_fans);
            } else {
                this.fqQ.setParams(a.f.sdk_pic_live_empty01_hk, a.i.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.fqQ.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.fqQ.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_fans);
        } else {
            this.fqQ.setParams(a.f.sdk_pic_live_empty01_qm, a.i.sdk_list_empty_text);
        }
        this.fqK.setEmptyView(this.fqQ);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fqL != null) {
            this.fqL.cancel();
        }
    }
}
