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
    private LoadingView ewE;
    private BdUniqueId ewI;
    private a.InterfaceC0474a frJ;
    private com.baidu.tieba.ala.person.adapter.a frL;
    private BdListView frM;
    private com.baidu.tieba.ala.person.c.c frN;
    private com.baidu.tieba.ala.person.view.d frO;
    private PersonEmptyView frP;
    private int frQ;
    private boolean frR;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a frS = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.frO.qL(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.frO.hide();
            } else {
                b.this.frO.mI(a.i.sdk_loading);
            }
            b.this.frL.a(b.this.frR, dVar.user_list, b.this.frQ);
            if (b.this.frR) {
                b.this.frR = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.frL.a(true, null, b.this.frQ);
            if (b.this.frP != null) {
                b.this.frM.setEmptyView(b.this.frP);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewI = null;
        this.mPageContext = tbPageContext;
        this.frQ = i;
        this.mUserId = str;
        this.ewI = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.frM = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.frL = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.frM.setAdapter((ListAdapter) this.frL);
        this.frO = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.frO.createView();
        this.frO.display();
        this.frO.mI(a.i.sdk_loading);
        this.frM.setNextPage(this.frO);
        this.frP = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.frQ == 0) {
            this.frP.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.frP.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.frM.setEmptyView(this.frP);
        this.frN = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.frN.a(this.frS);
    }

    public void refreshData() {
        this.frN.setPn(0);
        this.frR = true;
        showLoadingView();
        this.frN.g(this.frQ, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.frN.g(this.frQ, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.frL != null) {
            this.frL.Z(str, z);
        }
    }

    public View aIh() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        this.frJ = interfaceC0474a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.frM.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.frO.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.frO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.frL != null && b.this.frL.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.frL.a(new a.InterfaceC0473a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0473a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eLB == 0) {
                        bVar.eLB = 1;
                        com.baidu.live.view.a.Bj().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.ewI));
                    } else {
                        bVar.eLB = 0;
                        com.baidu.live.view.a.Bj().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.ewI));
                    }
                    b.this.frL.notifyDataSetChanged();
                }
            }
        });
        this.frL.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.frJ != null) {
                    b.this.frJ.a(bVar, view, b.this.frQ);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.frL == null || this.frL.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.ewE != null) {
            this.ewE.setSkinType(i);
            this.ewE.onChangeSkinType();
        }
        if (this.frL != null) {
            this.frL.setSkinType(i);
            this.frL.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.frN != null) {
            this.frN.cancel();
        }
    }
}
