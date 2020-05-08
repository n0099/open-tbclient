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
    private a.InterfaceC0531a fWV;
    private com.baidu.tieba.ala.person.adapter.a fWX;
    private BdListView fWY;
    private com.baidu.tieba.ala.person.c.c fWZ;
    private com.baidu.tieba.ala.person.view.d fXa;
    private PersonEmptyView fXb;
    private int fXc;
    private boolean fXd;
    private BdUniqueId fbA;
    private LoadingView fbv;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fXe = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fXa.rg(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fXa.hide();
            } else {
                b.this.fXa.mV(a.i.sdk_loading);
            }
            b.this.fWX.a(b.this.fXd, dVar.user_list, b.this.fXc);
            if (b.this.fXd) {
                b.this.fXd = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.fWX.a(true, null, b.this.fXc);
            if (b.this.fXb != null) {
                b.this.fWY.setEmptyView(b.this.fXb);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fbA = null;
        this.mPageContext = tbPageContext;
        this.fXc = i;
        this.mUserId = str;
        this.fbA = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.fWY = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.fWX = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.fWY.setAdapter((ListAdapter) this.fWX);
        this.fXa = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fXa.createView();
        this.fXa.display();
        this.fXa.mV(a.i.sdk_loading);
        this.fWY.setNextPage(this.fXa);
        this.fXb = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fXc == 0) {
            this.fXb.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fXb.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.fWY.setEmptyView(this.fXb);
        this.fWZ = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.fWZ.a(this.fXe);
    }

    public void refreshData() {
        this.fWZ.setPn(0);
        this.fXd = true;
        showLoadingView();
        this.fWZ.h(this.fXc, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.fWZ.h(this.fXc, this.mUserId, "");
        }
    }

    public void af(String str, boolean z) {
        if (this.fWX != null) {
            this.fWX.af(str, z);
        }
    }

    public View aQF() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0531a interfaceC0531a) {
        this.fWV = interfaceC0531a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.fWY.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fXa.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fWX != null && b.this.fWX.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.fWX.a(new a.InterfaceC0530a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0530a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fqH == 0) {
                        bVar.fqH = 1;
                        com.baidu.live.data.b bVar2 = new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fbA);
                        bVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Hs().a(bVar.id, bVar2);
                    } else {
                        bVar.fqH = 0;
                        com.baidu.live.data.b bVar3 = new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fbA);
                        bVar3.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Hs().a(bVar.id, bVar3);
                    }
                    b.this.fWX.notifyDataSetChanged();
                }
            }
        });
        this.fWX.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.fWV != null) {
                    b.this.fWV.a(bVar, view, b.this.fXc);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.fWX == null || this.fWX.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fbv != null) {
            this.fbv.setSkinType(i);
            this.fbv.onChangeSkinType();
        }
        if (this.fWX != null) {
            this.fWX.setSkinType(i);
            this.fWX.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.fWZ != null) {
            this.fWZ.cancel();
        }
    }
}
