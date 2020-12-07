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
    private LoadingView gEK;
    private BdUniqueId gEP;
    private a.InterfaceC0707a hKE;
    private com.baidu.tieba.ala.person.adapter.a hKG;
    private BdListView hKH;
    private com.baidu.tieba.ala.person.c.c hKI;
    private com.baidu.tieba.ala.person.view.d hKJ;
    private PersonEmptyView hKK;
    private int hKL;
    private boolean hKM;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hKN = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hKJ.xy(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hKJ.hide();
            } else {
                b.this.hKJ.sG(a.h.sdk_loading);
            }
            b.this.hKG.a(b.this.hKM, cVar.user_list, b.this.hKL);
            if (b.this.hKM) {
                b.this.hKM = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hKG.a(true, null, b.this.hKL);
            if (b.this.hKK != null) {
                b.this.hKH.setEmptyView(b.this.hKK);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gEP = null;
        this.mPageContext = tbPageContext;
        this.hKL = i;
        this.mUserId = str;
        this.gEP = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hKH = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hKG = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hKH.setAdapter((ListAdapter) this.hKG);
        this.hKJ = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hKJ.createView();
        this.hKJ.su();
        this.hKJ.sG(a.h.sdk_loading);
        this.hKH.setNextPage(this.hKJ);
        this.hKK = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hKL == 0) {
            this.hKK.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hKK.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hKH.setEmptyView(this.hKK);
        this.hKI = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hKI.a(this.hKN);
    }

    public void refreshData() {
        this.hKI.setPn(0);
        this.hKM = true;
        showLoadingView();
        this.hKI.e(this.hKL, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hKI.e(this.hKL, this.mUserId, "");
        }
    }

    public void aD(String str, boolean z) {
        if (this.hKG != null) {
            this.hKG.aD(str, z);
        }
    }

    public View bvQ() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0707a interfaceC0707a) {
        this.hKE = interfaceC0707a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hKH.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hKJ.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hKG != null && b.this.hKG.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hKG.a(new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0706a
            public void a(bf bfVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bfVar != null && bfVar.portrait != null && bfVar.id != null) {
                    if (bfVar.aQa == 0) {
                        bfVar.aQa = 1;
                        f fVar = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", true, b.this.gEP);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar);
                    } else {
                        bfVar.aQa = 0;
                        f fVar2 = new f(bfVar.portrait, bfVar.id, bfVar.metaKey, "1", false, b.this.gEP);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Yo().a(bfVar.id, fVar2);
                    }
                    b.this.hKG.notifyDataSetChanged();
                }
            }
        });
        this.hKG.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bf bfVar, View view) {
                if (b.this.hKE != null) {
                    b.this.hKE.a(bfVar, view, b.this.hKL);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hKG == null || this.hKG.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gEK != null) {
            this.gEK.setSkinType(i);
            this.gEK.onChangeSkinType();
        }
        if (this.hKG != null) {
            this.hKG.setSkinType(i);
            this.hKG.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hKI != null) {
            this.hKI.cancel();
        }
    }
}
