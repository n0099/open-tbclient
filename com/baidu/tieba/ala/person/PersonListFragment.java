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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.a.b;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.d;
/* loaded from: classes3.dex */
public class PersonListFragment extends BaseFragment {
    private Context context;
    private CustomMessageListener fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
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
                        if (PersonListFragment.this.gxe != null) {
                            PersonListFragment.this.gxe.au(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
                        }
                        if (!com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonListFragment.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListFragment.this.getUniqueId())) {
                            PersonListFragment.this.showToast(updateAttentionMessage.getData().errorString);
                            return;
                        }
                        return;
                    }
                    if (z && personCardActivity != null && PersonListFragment.this.type == 1) {
                        personCardActivity.lE(updateAttentionMessage.isAttention());
                    }
                    if (PersonListFragment.this.gxe != null) {
                        PersonListFragment.this.gxe.au(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
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
    private com.baidu.tieba.ala.person.adapter.a gxe;
    private BdListView gxf;
    private c gxg;
    private boolean gxh;
    private d gxi;
    private boolean gxj;
    private Object gxk;
    private AlaListEmptyView gxl;
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
        personListFragment.ao(obj);
        return personListFragment;
    }

    public void ao(Object obj) {
        this.gxk = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.fzf);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_list, (ViewGroup) null);
        initData();
        ag(inflate);
        initListener();
        bLc();
        return inflate;
    }

    private void aNp() {
        b(true, this.gxk);
    }

    private void initListener() {
        this.gxf.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.gxh) {
                    PersonListFragment.this.gxi.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.gxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.gxe != null && PersonListFragment.this.gxe.getCount() == 0) {
                    PersonListFragment.this.gxg.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.gxe.a(new a.InterfaceC0589a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0589a
            public void a(b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(PersonListFragment.this.getActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fPV == 0) {
                        bVar.fPV = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, PersonListFragment.this.getUniqueId());
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ky().a(bVar.id, dVar);
                    } else {
                        bVar.fPV = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, PersonListFragment.this.getUniqueId());
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ky().a(bVar.id, dVar2);
                    }
                    PersonListFragment.this.gxe.notifyDataSetChanged();
                }
            }
        });
        this.gxe.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(b bVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).b(com.baidu.tieba.ala.person.d.a.a(bVar));
                }
            }
        });
    }

    private void initData() {
        this.gxg = new c(getPageContext());
        this.gxg.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.gxj, dVar);
                    if (PersonListFragment.this.gxj) {
                        PersonListFragment.this.gxj = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.i.ala_person_load_fail);
                PersonListFragment.this.gxi.sj(a.i.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.gxe.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.d)) {
            this.gxh = ((com.baidu.tieba.ala.person.a.d) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.d) obj).has_more != 1) {
                this.gxi.hide();
            } else {
                this.gxi.nU(a.i.sdk_loading);
            }
            this.gxe.a(z, ((com.baidu.tieba.ala.person.a.d) obj).user_list, this.type);
        }
    }

    private void bLc() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.gxe.a(true, null, this.type);
        } else if (this.gxk == null) {
            if (this.gxg != null) {
                this.gxg.setPn(0);
            }
            this.gxj = true;
            loadData();
        } else {
            if (this.gxg != null) {
                this.gxg.setPn(1);
            }
            this.gxj = false;
            aNp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.gxh) {
            if ((this.type == 1 || this.type == 0) && this.gxg != null) {
                this.gxg.h(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void ag(View view) {
        this.gxf = (BdListView) view.findViewById(a.g.listview);
        this.gxe = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.gxf.setAdapter((ListAdapter) this.gxe);
        this.gxi = new d(getPageContext());
        this.gxi.createView();
        this.gxf.setNextPage(this.gxi);
        this.gxi.display();
        this.gxi.nU(a.i.sdk_loading);
        this.gxl = (AlaListEmptyView) view.findViewById(a.g.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.gxl.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.gxl.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_fans);
            } else {
                this.gxl.setParams(a.f.sdk_pic_live_empty01_hk, a.i.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.gxl.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.gxl.setParams(a.f.sdk_pic_live_empty01_qm, a.i.hk_ala_person_no_fans);
        } else {
            this.gxl.setParams(a.f.sdk_pic_live_empty01_qm, a.i.sdk_list_empty_text);
        }
        this.gxf.setEmptyView(this.gxl);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxg != null) {
            this.gxg.cancel();
        }
    }
}
