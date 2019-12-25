package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.b.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.PersonEmptyView;
/* loaded from: classes2.dex */
public class b {
    private LoadingView erh;
    private BdUniqueId erl;
    private a.InterfaceC0462a flV;
    private com.baidu.tieba.ala.person.adapter.a flX;
    private BdListView flY;
    private com.baidu.tieba.ala.person.c.c flZ;
    private com.baidu.tieba.ala.person.view.d fma;
    private PersonEmptyView fmb;
    private int fmc;
    private boolean fmd;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fme = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fma.qz(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fma.hide();
            } else {
                b.this.fma.mr(a.i.sdk_loading);
            }
            b.this.flX.a(b.this.fmd, dVar.user_list, b.this.fmc);
            if (b.this.fmd) {
                b.this.fmd = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.flX.a(true, null, b.this.fmc);
            if (b.this.fmb != null) {
                b.this.flY.setEmptyView(b.this.fmb);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.erl = null;
        this.mPageContext = tbPageContext;
        this.fmc = i;
        this.mUserId = str;
        this.erl = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.flY = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.flX = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.flY.setAdapter((ListAdapter) this.flX);
        this.fma = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fma.createView();
        this.fma.lw();
        this.fma.mr(a.i.sdk_loading);
        this.flY.setNextPage(this.fma);
        this.fmb = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fmc == 0) {
            this.fmb.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fmb.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.flY.setEmptyView(this.fmb);
        this.flZ = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.flZ.a(this.fme);
    }

    public void refreshData() {
        this.flZ.setPn(0);
        this.fmd = true;
        showLoadingView();
        this.flZ.g(this.fmc, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.flZ.g(this.fmc, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.flX != null) {
            this.flX.Z(str, z);
        }
    }

    public View aFx() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0462a interfaceC0462a) {
        this.flV = interfaceC0462a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.flY.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fma.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.flX != null && b.this.flX.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.flX.a(new a.InterfaceC0461a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0461a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eGw == 0) {
                        bVar.eGw = 1;
                        com.baidu.live.view.a.yy().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.erl));
                    } else {
                        bVar.eGw = 0;
                        com.baidu.live.view.a.yy().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.erl));
                    }
                    b.this.flX.notifyDataSetChanged();
                }
            }
        });
        this.flX.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.flV != null) {
                    b.this.flV.a(bVar, view, b.this.fmc);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.flX == null || this.flX.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.erh != null) {
            this.erh.setSkinType(i);
            this.erh.onChangeSkinType();
        }
        if (this.flX != null) {
            this.flX.setSkinType(i);
            this.flX.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.flZ != null) {
            this.flZ.cancel();
        }
    }
}
