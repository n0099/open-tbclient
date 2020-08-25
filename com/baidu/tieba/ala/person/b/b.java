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
/* loaded from: classes7.dex */
public class b {
    private LoadingView fQV;
    private BdUniqueId fRa;
    private a.InterfaceC0649a gQP;
    private com.baidu.tieba.ala.person.adapter.a gQR;
    private BdListView gQS;
    private com.baidu.tieba.ala.person.c.c gQT;
    private com.baidu.tieba.ala.person.view.d gQU;
    private PersonEmptyView gQV;
    private int gQW;
    private boolean gQX;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gQY = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gQU.uP(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.gQU.hide();
            } else {
                b.this.gQU.qx(a.i.sdk_loading);
            }
            b.this.gQR.a(b.this.gQX, dVar.user_list, b.this.gQW);
            if (b.this.gQX) {
                b.this.gQX = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gQR.a(true, null, b.this.gQW);
            if (b.this.gQV != null) {
                b.this.gQS.setEmptyView(b.this.gQV);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fRa = null;
        this.mPageContext = tbPageContext;
        this.gQW = i;
        this.mUserId = str;
        this.fRa = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gQS = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gQR = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gQS.setAdapter((ListAdapter) this.gQR);
        this.gQU = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gQU.createView();
        this.gQU.display();
        this.gQU.qx(a.i.sdk_loading);
        this.gQS.setNextPage(this.gQU);
        this.gQV = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gQW == 0) {
            this.gQV.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gQV.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gQS.setEmptyView(this.gQV);
        this.gQT = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gQT.a(this.gQY);
    }

    public void refreshData() {
        this.gQT.setPn(0);
        this.gQX = true;
        showLoadingView();
        this.gQT.h(this.gQW, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gQT.h(this.gQW, this.mUserId, "");
        }
    }

    public void aw(String str, boolean z) {
        if (this.gQR != null) {
            this.gQR.aw(str, z);
        }
    }

    public View blc() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        this.gQP = interfaceC0649a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gQS.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gQU.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gQU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gQR != null && b.this.gQR.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gQR.a(new a.InterfaceC0648a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0648a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.ghn == 0) {
                        bVar.ghn = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fRa);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Qx().a(bVar.id, dVar);
                    } else {
                        bVar.ghn = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fRa);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Qx().a(bVar.id, dVar2);
                    }
                    b.this.gQR.notifyDataSetChanged();
                }
            }
        });
        this.gQR.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.gQP != null) {
                    b.this.gQP.a(bVar, view, b.this.gQW);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gQR == null || this.gQR.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fQV != null) {
            this.fQV.setSkinType(i);
            this.fQV.onChangeSkinType();
        }
        if (this.gQR != null) {
            this.gQR.setSkinType(i);
            this.gQR.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gQT != null) {
            this.gQT.cancel();
        }
    }
}
