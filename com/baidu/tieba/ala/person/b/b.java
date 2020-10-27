package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bc;
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
    private LoadingView gqG;
    private BdUniqueId gqL;
    private com.baidu.tieba.ala.person.view.d hvA;
    private PersonEmptyView hvB;
    private int hvC;
    private boolean hvD;
    private a.InterfaceC0680a hvv;
    private com.baidu.tieba.ala.person.adapter.a hvx;
    private BdListView hvy;
    private com.baidu.tieba.ala.person.c.c hvz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hvE = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.hvA.wi(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hvA.hide();
            } else {
                b.this.hvA.rx(a.i.sdk_loading);
            }
            b.this.hvx.a(b.this.hvD, cVar.user_list, b.this.hvC);
            if (b.this.hvD) {
                b.this.hvD = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hvx.a(true, null, b.this.hvC);
            if (b.this.hvB != null) {
                b.this.hvy.setEmptyView(b.this.hvB);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gqL = null;
        this.mPageContext = tbPageContext;
        this.hvC = i;
        this.mUserId = str;
        this.gqL = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hvy = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.hvx = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hvy.setAdapter((ListAdapter) this.hvx);
        this.hvA = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hvA.createView();
        this.hvA.display();
        this.hvA.rx(a.i.sdk_loading);
        this.hvy.setNextPage(this.hvA);
        this.hvB = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.hvC == 0) {
            this.hvB.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.hvB.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.hvy.setEmptyView(this.hvB);
        this.hvz = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hvz.a(this.hvE);
    }

    public void refreshData() {
        this.hvz.setPn(0);
        this.hvD = true;
        showLoadingView();
        this.hvz.c(this.hvC, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hvz.c(this.hvC, this.mUserId, "");
        }
    }

    public void aC(String str, boolean z) {
        if (this.hvx != null) {
            this.hvx.aC(str, z);
        }
    }

    public View bqA() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hvv = interfaceC0680a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hvy.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hvA.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hvx != null && b.this.hvx.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hvx.a(new a.InterfaceC0679a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0679a
            public void a(bc bcVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bcVar != null && bcVar.portrait != null && bcVar.id != null) {
                    if (bcVar.aNJ == 0) {
                        bcVar.aNJ = 1;
                        f fVar = new f(bcVar.portrait, bcVar.id, bcVar.metaKey, "1", true, b.this.gqL);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.TX().a(bcVar.id, fVar);
                    } else {
                        bcVar.aNJ = 0;
                        f fVar2 = new f(bcVar.portrait, bcVar.id, bcVar.metaKey, "1", false, b.this.gqL);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.TX().a(bcVar.id, fVar2);
                    }
                    b.this.hvx.notifyDataSetChanged();
                }
            }
        });
        this.hvx.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bc bcVar, View view) {
                if (b.this.hvv != null) {
                    b.this.hvv.a(bcVar, view, b.this.hvC);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hvx == null || this.hvx.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gqG != null) {
            this.gqG.setSkinType(i);
            this.gqG.onChangeSkinType();
        }
        if (this.hvx != null) {
            this.hvx.setSkinType(i);
            this.hvx.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hvz != null) {
            this.hvz.cancel();
        }
    }
}
