package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bf;
import com.baidu.live.data.f;
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
    private LoadingView gEM;
    private BdUniqueId gER;
    private a.InterfaceC0707a hKG;
    private com.baidu.tieba.ala.person.adapter.a hKI;
    private BdListView hKJ;
    private com.baidu.tieba.ala.person.c.c hKK;
    private com.baidu.tieba.ala.person.view.d hKL;
    private PersonEmptyView hKM;
    private int hKN;
    private boolean hKO;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hKP = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hKL.xy(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hKL.hide();
            } else {
                b.this.hKL.sG(a.h.sdk_loading);
            }
            b.this.hKI.a(b.this.hKO, cVar.user_list, b.this.hKN);
            if (b.this.hKO) {
                b.this.hKO = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hKI.a(true, null, b.this.hKN);
            if (b.this.hKM != null) {
                b.this.hKJ.setEmptyView(b.this.hKM);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gER = null;
        this.mPageContext = tbPageContext;
        this.hKN = i;
        this.mUserId = str;
        this.gER = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hKJ = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hKI = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hKJ.setAdapter((ListAdapter) this.hKI);
        this.hKL = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hKL.createView();
        this.hKL.su();
        this.hKL.sG(a.h.sdk_loading);
        this.hKJ.setNextPage(this.hKL);
        this.hKM = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hKN == 0) {
            this.hKM.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hKM.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hKJ.setEmptyView(this.hKM);
        this.hKK = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hKK.a(this.hKP);
    }

    public void refreshData() {
        this.hKK.setPn(0);
        this.hKO = true;
        showLoadingView();
        this.hKK.e(this.hKN, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hKK.e(this.hKN, this.mUserId, "");
        }
    }

    public void aD(String str, boolean z) {
        if (this.hKI != null) {
            this.hKI.aD(str, z);
        }
    }

    public View bvQ() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0707a interfaceC0707a) {
        this.hKG = interfaceC0707a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hKJ.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hKL.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hKI != null && b.this.hKI.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hKI.a(new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0706a
            public void a(bf bfVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bfVar != null && bfVar.portrait != null && bfVar.id != null) {
                    if (bfVar.aQa == 0) {
                        bfVar.aQa = 1;
                        f fVar = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", true, b.this.gER);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar);
                    } else {
                        bfVar.aQa = 0;
                        f fVar2 = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", false, b.this.gER);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar2);
                    }
                    b.this.hKI.notifyDataSetChanged();
                }
            }
        });
        this.hKI.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bf bfVar, View view) {
                if (b.this.hKG != null) {
                    b.this.hKG.a(bfVar, view, b.this.hKN);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hKI == null || this.hKI.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gEM != null) {
            this.gEM.setSkinType(i);
            this.gEM.onChangeSkinType();
        }
        if (this.hKI != null) {
            this.hKI.setSkinType(i);
            this.hKI.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hKK != null) {
            this.hKK.cancel();
        }
    }
}
