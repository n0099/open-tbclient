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
    private CustomMessageListener gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.PersonListFragment.6
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
                        if (PersonListFragment.this.hIV != null) {
                            PersonListFragment.this.hIV.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention() ? false : true);
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
                    if (PersonListFragment.this.hIV != null) {
                        PersonListFragment.this.hIV.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
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
    private com.baidu.tieba.ala.person.adapter.a hIV;
    private BdListView hIW;
    private c hIX;
    private boolean hIY;
    private d hIZ;
    private boolean hJa;
    private Object hJb;
    private AlaListEmptyView hJc;
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
        this.hJb = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.type = getArguments().getInt("type");
        this.metaKey = getArguments().getString("meta_key");
        this.userId = getArguments().getString("user_id");
        registerListener(this.gDu);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_list, (ViewGroup) null);
        initData();
        an(inflate);
        initListener();
        cmx();
        return inflate;
    }

    private void bjF() {
        b(true, this.hJb);
    }

    private void initListener() {
        this.hIW.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonListFragment.this.hIY) {
                    PersonListFragment.this.hIZ.hide();
                } else {
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hIZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.PersonListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonListFragment.this.hIV != null && PersonListFragment.this.hIV.getCount() == 0) {
                    PersonListFragment.this.hIX.setPn(-1);
                    PersonListFragment.this.loadData();
                }
            }
        });
        this.hIV.a(new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.3
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
                    PersonListFragment.this.hIV.notifyDataSetChanged();
                }
            }
        });
        this.hIV.a(new a.c() { // from class: com.baidu.tieba.ala.person.PersonListFragment.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bf bfVar, View view) {
                if (PersonListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    ((PersonCardActivity) PersonListFragment.this.getPageContext().getOrignalPage()).c(com.baidu.tieba.ala.person.d.a.a(bfVar));
                }
            }
        });
    }

    private void initData() {
        this.hIX = new c(getPageContext());
        this.hIX.a(new c.a() { // from class: com.baidu.tieba.ala.person.PersonListFragment.5
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null) {
                    PersonListFragment.this.b(PersonListFragment.this.hJa, cVar);
                    if (PersonListFragment.this.hJa) {
                        PersonListFragment.this.hJa = false;
                        return;
                    }
                    return;
                }
                PersonListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonListFragment.this.hIZ.xy(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
                PersonListFragment.this.showToast(str);
                PersonListFragment.this.hIV.a(true, null, PersonListFragment.this.type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.c)) {
            this.hIY = ((com.baidu.tieba.ala.person.a.c) obj).has_more == 1;
            if (((com.baidu.tieba.ala.person.a.c) obj).has_more != 1) {
                this.hIZ.hide();
            } else {
                this.hIZ.sG(a.h.sdk_loading);
            }
            this.hIV.a(z, ((com.baidu.tieba.ala.person.a.c) obj).user_list, this.type);
        }
    }

    private void cmx() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hIV.a(true, null, this.type);
        } else if (this.hJb == null) {
            if (this.hIX != null) {
                this.hIX.setPn(0);
            }
            this.hJa = true;
            loadData();
        } else {
            if (this.hIX != null) {
                this.hIX.setPn(1);
            }
            this.hJa = false;
            bjF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hIY) {
            if ((this.type == 1 || this.type == 0) && this.hIX != null) {
                this.hIX.e(this.type, this.userId, this.metaKey);
            }
        }
    }

    private void an(View view) {
        this.hIW = (BdListView) view.findViewById(a.f.listview);
        this.hIV = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hIW.setAdapter((ListAdapter) this.hIV);
        this.hIZ = new d(getPageContext());
        this.hIZ.createView();
        this.hIW.setNextPage(this.hIZ);
        this.hIZ.su();
        this.hIZ.sG(a.h.sdk_loading);
        this.hJc = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (this.type == 1) {
                this.hJc.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_attention_desc);
            } else if (this.type == 0) {
                this.hJc.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_fans);
            } else {
                this.hJc.setParams(a.e.sdk_pic_live_empty01_hk, a.h.sdk_list_empty_text);
            }
        } else if (this.type == 1) {
            this.hJc.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_attention_desc);
        } else if (this.type == 0) {
            this.hJc.setParams(a.e.sdk_pic_live_empty01_qm, a.h.hk_ala_person_no_fans);
        } else {
            this.hJc.setParams(a.e.sdk_pic_live_empty01_qm, a.h.sdk_list_empty_text);
        }
        this.hIW.setEmptyView(this.hJc);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hIX != null) {
            this.hIX.cancel();
        }
    }
}
