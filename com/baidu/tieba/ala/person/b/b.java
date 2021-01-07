package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bh;
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
    private BdUniqueId gQC;
    private LoadingView gQx;
    private a.InterfaceC0699a hWS;
    private com.baidu.tieba.ala.person.adapter.a hWU;
    private BdListView hWV;
    private com.baidu.tieba.ala.person.c.c hWW;
    private e hWX;
    private PersonEmptyView hWY;
    private int hWZ;
    private boolean hXa;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hXb = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hWX.xL(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hWX.hide();
            } else {
                b.this.hWX.sS(a.h.sdk_loading);
            }
            b.this.hWU.a(b.this.hXa, cVar.user_list, b.this.hWZ);
            if (b.this.hXa) {
                b.this.hXa = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hWU.a(true, null, b.this.hWZ);
            if (b.this.hWY != null) {
                b.this.hWV.setEmptyView(b.this.hWY);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gQC = null;
        this.mPageContext = tbPageContext;
        this.hWZ = i;
        this.mUserId = str;
        this.gQC = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hWV = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hWU = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hWV.setAdapter((ListAdapter) this.hWU);
        this.hWX = new e(this.mPageContext);
        this.hWX.createView();
        this.hWX.rV();
        this.hWX.sS(a.h.sdk_loading);
        this.hWV.setNextPage(this.hWX);
        this.hWY = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hWZ == 0) {
            this.hWY.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hWY.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hWV.setEmptyView(this.hWY);
        this.hWW = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hWW.a(this.hXb);
    }

    public void refreshData() {
        this.hWW.setPn(0);
        this.hXa = true;
        showLoadingView();
        this.hWW.e(this.hWZ, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hWW.e(this.hWZ, this.mUserId, "");
        }
    }

    public void aE(String str, boolean z) {
        if (this.hWU != null) {
            this.hWU.aE(str, z);
        }
    }

    public View cpy() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0699a interfaceC0699a) {
        this.hWS = interfaceC0699a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hWV.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hWX.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hWX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hWU != null && b.this.hWU.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hWU.a(new a.InterfaceC0698a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0698a
            public void a(bh bhVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bhVar != null && bhVar.portrait != null && bhVar.id != null) {
                    if (bhVar.aQP == 0) {
                        bhVar.aQP = 1;
                        f fVar = new f(bhVar.portrait, bhVar.id, bhVar.metaKey, "1", true, b.this.gQC);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Zy().a(bhVar.id, fVar);
                    } else {
                        bhVar.aQP = 0;
                        f fVar2 = new f(bhVar.portrait, bhVar.id, bhVar.metaKey, "1", false, b.this.gQC);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Zy().a(bhVar.id, fVar2);
                    }
                    b.this.hWU.notifyDataSetChanged();
                }
            }
        });
        this.hWU.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bh bhVar, View view) {
                if (b.this.hWS != null) {
                    b.this.hWS.a(bhVar, view, b.this.hWZ);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hWU == null || this.hWU.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gQx != null) {
            this.gQx.setSkinType(i);
            this.gQx.onChangeSkinType();
        }
        if (this.hWU != null) {
            this.hWU.setSkinType(i);
            this.hWU.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hWW != null) {
            this.hWW.cancel();
        }
    }
}
