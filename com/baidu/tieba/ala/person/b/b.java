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
    private LoadingView foX;
    private BdUniqueId fpc;
    private a.InterfaceC0581a glP;
    private com.baidu.tieba.ala.person.adapter.a glR;
    private BdListView glS;
    private com.baidu.tieba.ala.person.c.c glT;
    private com.baidu.tieba.ala.person.view.d glU;
    private PersonEmptyView glV;
    private int glW;
    private boolean glX;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a glY = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.glU.rJ(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.glU.hide();
            } else {
                b.this.glU.nx(a.i.sdk_loading);
            }
            b.this.glR.a(b.this.glX, dVar.user_list, b.this.glW);
            if (b.this.glX) {
                b.this.glX = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.glR.a(true, null, b.this.glW);
            if (b.this.glV != null) {
                b.this.glS.setEmptyView(b.this.glV);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fpc = null;
        this.mPageContext = tbPageContext;
        this.glW = i;
        this.mUserId = str;
        this.fpc = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.glS = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.glR = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.glS.setAdapter((ListAdapter) this.glR);
        this.glU = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.glU.createView();
        this.glU.display();
        this.glU.nx(a.i.sdk_loading);
        this.glS.setNextPage(this.glU);
        this.glV = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.glW == 0) {
            this.glV.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.glV.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.glS.setEmptyView(this.glV);
        this.glT = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.glT.a(this.glY);
    }

    public void refreshData() {
        this.glT.setPn(0);
        this.glX = true;
        showLoadingView();
        this.glT.h(this.glW, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.glT.h(this.glW, this.mUserId, "");
        }
    }

    public void as(String str, boolean z) {
        if (this.glR != null) {
            this.glR.as(str, z);
        }
    }

    public View aWN() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0581a interfaceC0581a) {
        this.glP = interfaceC0581a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.glS.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.glU.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.glU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.glR != null && b.this.glR.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.glR.a(new a.InterfaceC0580a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0580a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fEB == 0) {
                        bVar.fEB = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fpc);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Jl().a(bVar.id, dVar);
                    } else {
                        bVar.fEB = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fpc);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Jl().a(bVar.id, dVar2);
                    }
                    b.this.glR.notifyDataSetChanged();
                }
            }
        });
        this.glR.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.glP != null) {
                    b.this.glP.a(bVar, view, b.this.glW);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.glR == null || this.glR.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.foX != null) {
            this.foX.setSkinType(i);
            this.foX.onChangeSkinType();
        }
        if (this.glR != null) {
            this.glR.setSkinType(i);
            this.glR.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.glT != null) {
            this.glT.cancel();
        }
    }
}
