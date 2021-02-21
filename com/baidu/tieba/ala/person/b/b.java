package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bl;
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
import com.baidu.tieba.ala.person.view.e;
/* loaded from: classes11.dex */
public class b {
    private LoadingView gOL;
    private BdUniqueId gOQ;
    private a.InterfaceC0683a hWU;
    private com.baidu.tieba.ala.person.adapter.a hWW;
    private BdListView hWX;
    private com.baidu.tieba.ala.person.c.c hWY;
    private e hWZ;
    private PersonEmptyView hXa;
    private int hXb;
    private boolean hXc;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hXd = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hWZ.wq(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hWZ.hide();
            } else {
                b.this.hWZ.rr(a.h.sdk_loading);
            }
            b.this.hWW.a(b.this.hXc, cVar.user_list, b.this.hXb);
            if (b.this.hXc) {
                b.this.hXc = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hWW.a(true, null, b.this.hXb);
            if (b.this.hXa != null) {
                b.this.hWX.setEmptyView(b.this.hXa);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gOQ = null;
        this.mPageContext = tbPageContext;
        this.hXb = i;
        this.mUserId = str;
        this.gOQ = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hWX = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hWW = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hWX.setAdapter((ListAdapter) this.hWW);
        this.hWZ = new e(this.mPageContext);
        this.hWZ.createView();
        this.hWZ.display();
        this.hWZ.rr(a.h.sdk_loading);
        this.hWX.setNextPage(this.hWZ);
        this.hXa = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hXb == 0) {
            this.hXa.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hXa.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hWX.setEmptyView(this.hXa);
        this.hWY = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hWY.a(this.hXd);
    }

    public void refreshData() {
        this.hWY.setPn(0);
        this.hXc = true;
        showLoadingView();
        this.hWY.e(this.hXb, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hWY.e(this.hXb, this.mUserId, "");
        }
    }

    public void aD(String str, boolean z) {
        if (this.hWW != null) {
            this.hWW.aD(str, z);
        }
    }

    public View cmL() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0683a interfaceC0683a) {
        this.hWU = interfaceC0683a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hWX.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hWZ.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hWW != null && b.this.hWW.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hWW.a(new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0682a
            public void a(bl blVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (blVar != null && blVar.portrait != null && blVar.id != null) {
                    if (blVar.aOZ == 0) {
                        blVar.aOZ = 1;
                        f fVar = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", true, b.this.gOQ);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xo().a(blVar.id, fVar);
                    } else {
                        blVar.aOZ = 0;
                        f fVar2 = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", false, b.this.gOQ);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xo().a(blVar.id, fVar2);
                    }
                    b.this.hWW.notifyDataSetChanged();
                }
            }
        });
        this.hWW.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bl blVar, View view) {
                if (b.this.hWU != null) {
                    b.this.hWU.a(blVar, view, b.this.hXb);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hWW == null || this.hWW.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gOL != null) {
            this.gOL.setSkinType(i);
            this.gOL.onChangeSkinType();
        }
        if (this.hWW != null) {
            this.hWW.setSkinType(i);
            this.hWW.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hWY != null) {
            this.hWY.cancel();
        }
    }
}
