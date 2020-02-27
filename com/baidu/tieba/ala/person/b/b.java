package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.b.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.PersonEmptyView;
/* loaded from: classes3.dex */
public class b {
    private LoadingView ewD;
    private BdUniqueId ewH;
    private a.InterfaceC0474a frI;
    private com.baidu.tieba.ala.person.adapter.a frK;
    private BdListView frL;
    private com.baidu.tieba.ala.person.c.c frM;
    private com.baidu.tieba.ala.person.view.d frN;
    private PersonEmptyView frO;
    private int frP;
    private boolean frQ;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a frR = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.frN.qL(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.frN.hide();
            } else {
                b.this.frN.mI(a.i.sdk_loading);
            }
            b.this.frK.a(b.this.frQ, dVar.user_list, b.this.frP);
            if (b.this.frQ) {
                b.this.frQ = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.frK.a(true, null, b.this.frP);
            if (b.this.frO != null) {
                b.this.frL.setEmptyView(b.this.frO);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewH = null;
        this.mPageContext = tbPageContext;
        this.frP = i;
        this.mUserId = str;
        this.ewH = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.frL = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.frK = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.frL.setAdapter((ListAdapter) this.frK);
        this.frN = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.frN.createView();
        this.frN.display();
        this.frN.mI(a.i.sdk_loading);
        this.frL.setNextPage(this.frN);
        this.frO = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.frP == 0) {
            this.frO.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.frO.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.frL.setEmptyView(this.frO);
        this.frM = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.frM.a(this.frR);
    }

    public void refreshData() {
        this.frM.setPn(0);
        this.frQ = true;
        showLoadingView();
        this.frM.g(this.frP, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.frM.g(this.frP, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.frK != null) {
            this.frK.Z(str, z);
        }
    }

    public View aIf() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        this.frI = interfaceC0474a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.frL.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.frN.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.frN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.frK != null && b.this.frK.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.frK.a(new a.InterfaceC0473a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0473a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eLA == 0) {
                        bVar.eLA = 1;
                        com.baidu.live.view.a.Bh().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.ewH));
                    } else {
                        bVar.eLA = 0;
                        com.baidu.live.view.a.Bh().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.ewH));
                    }
                    b.this.frK.notifyDataSetChanged();
                }
            }
        });
        this.frK.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.frI != null) {
                    b.this.frI.a(bVar, view, b.this.frP);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.frK == null || this.frK.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.ewD != null) {
            this.ewD.setSkinType(i);
            this.ewD.onChangeSkinType();
        }
        if (this.frK != null) {
            this.frK.setSkinType(i);
            this.frK.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.frM != null) {
            this.frM.cancel();
        }
    }
}
