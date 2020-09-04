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
    private LoadingView fQZ;
    private BdUniqueId fRe;
    private a.InterfaceC0649a gQT;
    private com.baidu.tieba.ala.person.adapter.a gQV;
    private BdListView gQW;
    private com.baidu.tieba.ala.person.c.c gQX;
    private com.baidu.tieba.ala.person.view.d gQY;
    private PersonEmptyView gQZ;
    private int gRa;
    private boolean gRb;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gRc = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gQY.uP(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.gQY.hide();
            } else {
                b.this.gQY.qx(a.i.sdk_loading);
            }
            b.this.gQV.a(b.this.gRb, dVar.user_list, b.this.gRa);
            if (b.this.gRb) {
                b.this.gRb = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gQV.a(true, null, b.this.gRa);
            if (b.this.gQZ != null) {
                b.this.gQW.setEmptyView(b.this.gQZ);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fRe = null;
        this.mPageContext = tbPageContext;
        this.gRa = i;
        this.mUserId = str;
        this.fRe = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gQW = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gQV = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gQW.setAdapter((ListAdapter) this.gQV);
        this.gQY = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gQY.createView();
        this.gQY.display();
        this.gQY.qx(a.i.sdk_loading);
        this.gQW.setNextPage(this.gQY);
        this.gQZ = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gRa == 0) {
            this.gQZ.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gQZ.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gQW.setEmptyView(this.gQZ);
        this.gQX = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gQX.a(this.gRc);
    }

    public void refreshData() {
        this.gQX.setPn(0);
        this.gRb = true;
        showLoadingView();
        this.gQX.i(this.gRa, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gQX.i(this.gRa, this.mUserId, "");
        }
    }

    public void aw(String str, boolean z) {
        if (this.gQV != null) {
            this.gQV.aw(str, z);
        }
    }

    public View blc() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        this.gQT = interfaceC0649a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gQW.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gQY.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gQV != null && b.this.gQV.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gQV.a(new a.InterfaceC0648a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0648a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.ghr == 0) {
                        bVar.ghr = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fRe);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Qx().a(bVar.id, dVar);
                    } else {
                        bVar.ghr = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fRe);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Qx().a(bVar.id, dVar2);
                    }
                    b.this.gQV.notifyDataSetChanged();
                }
            }
        });
        this.gQV.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.gQT != null) {
                    b.this.gQT.a(bVar, view, b.this.gRa);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gQV == null || this.gQV.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fQZ != null) {
            this.fQZ.setSkinType(i);
            this.fQZ.onChangeSkinType();
        }
        if (this.gQV != null) {
            this.gQV.setSkinType(i);
            this.gQV.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gQX != null) {
            this.gQX.cancel();
        }
    }
}
