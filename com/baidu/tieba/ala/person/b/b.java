package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.b.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.PersonEmptyView;
/* loaded from: classes4.dex */
public class b {
    private LoadingView fFE;
    private BdUniqueId fFJ;
    private a.InterfaceC0599a gEp;
    private com.baidu.tieba.ala.person.adapter.a gEr;
    private BdListView gEs;
    private com.baidu.tieba.ala.person.c.c gEt;
    private com.baidu.tieba.ala.person.view.d gEu;
    private PersonEmptyView gEv;
    private int gEw;
    private boolean gEx;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gEy = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gEu.sB(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.gEu.hide();
            } else {
                b.this.gEu.om(a.i.sdk_loading);
            }
            b.this.gEr.a(b.this.gEx, dVar.user_list, b.this.gEw);
            if (b.this.gEx) {
                b.this.gEx = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gEr.a(true, null, b.this.gEw);
            if (b.this.gEv != null) {
                b.this.gEs.setEmptyView(b.this.gEv);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fFJ = null;
        this.mPageContext = tbPageContext;
        this.gEw = i;
        this.mUserId = str;
        this.fFJ = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gEs = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gEr = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gEs.setAdapter((ListAdapter) this.gEr);
        this.gEu = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gEu.createView();
        this.gEu.display();
        this.gEu.om(a.i.sdk_loading);
        this.gEs.setNextPage(this.gEu);
        this.gEv = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gEw == 0) {
            this.gEv.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gEv.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gEs.setEmptyView(this.gEv);
        this.gEt = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gEt.a(this.gEy);
    }

    public void refreshData() {
        this.gEt.setPn(0);
        this.gEx = true;
        showLoadingView();
        this.gEt.h(this.gEw, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gEt.h(this.gEw, this.mUserId, "");
        }
    }

    public void as(String str, boolean z) {
        if (this.gEr != null) {
            this.gEr.as(str, z);
        }
    }

    public View bcE() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0599a interfaceC0599a) {
        this.gEp = interfaceC0599a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gEs.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gEu.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gEr != null && b.this.gEr.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gEr.a(new a.InterfaceC0598a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0598a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fVo == 0) {
                        bVar.fVo = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fFJ);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.KF().a(bVar.id, dVar);
                    } else {
                        bVar.fVo = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fFJ);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.KF().a(bVar.id, dVar2);
                    }
                    b.this.gEr.notifyDataSetChanged();
                }
            }
        });
        this.gEr.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.gEp != null) {
                    b.this.gEp.a(bVar, view, b.this.gEw);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gEr == null || this.gEr.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fFE != null) {
            this.fFE.setSkinType(i);
            this.fFE.onChangeSkinType();
        }
        if (this.gEr != null) {
            this.gEr.setSkinType(i);
            this.gEr.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gEt != null) {
            this.gEt.cancel();
        }
    }
}
