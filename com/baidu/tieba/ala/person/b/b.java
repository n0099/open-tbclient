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
/* loaded from: classes3.dex */
public class b {
    private LoadingView fAu;
    private BdUniqueId fAz;
    private a.InterfaceC0590a gyO;
    private com.baidu.tieba.ala.person.adapter.a gyQ;
    private BdListView gyR;
    private com.baidu.tieba.ala.person.c.c gyS;
    private com.baidu.tieba.ala.person.view.d gyT;
    private PersonEmptyView gyU;
    private int gyV;
    private boolean gyW;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gyX = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gyT.sj(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.gyT.hide();
            } else {
                b.this.gyT.nU(a.i.sdk_loading);
            }
            b.this.gyQ.a(b.this.gyW, dVar.user_list, b.this.gyV);
            if (b.this.gyW) {
                b.this.gyW = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gyQ.a(true, null, b.this.gyV);
            if (b.this.gyU != null) {
                b.this.gyR.setEmptyView(b.this.gyU);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fAz = null;
        this.mPageContext = tbPageContext;
        this.gyV = i;
        this.mUserId = str;
        this.fAz = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gyR = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gyQ = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gyR.setAdapter((ListAdapter) this.gyQ);
        this.gyT = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gyT.createView();
        this.gyT.display();
        this.gyT.nU(a.i.sdk_loading);
        this.gyR.setNextPage(this.gyT);
        this.gyU = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gyV == 0) {
            this.gyU.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gyU.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gyR.setEmptyView(this.gyU);
        this.gyS = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gyS.a(this.gyX);
    }

    public void refreshData() {
        this.gyS.setPn(0);
        this.gyW = true;
        showLoadingView();
        this.gyS.h(this.gyV, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gyS.h(this.gyV, this.mUserId, "");
        }
    }

    public void au(String str, boolean z) {
        if (this.gyQ != null) {
            this.gyQ.au(str, z);
        }
    }

    public View aYH() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0590a interfaceC0590a) {
        this.gyO = interfaceC0590a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gyR.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gyT.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gyT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gyQ != null && b.this.gyQ.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gyQ.a(new a.InterfaceC0589a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0589a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fPV == 0) {
                        bVar.fPV = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fAz);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ky().a(bVar.id, dVar);
                    } else {
                        bVar.fPV = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fAz);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ky().a(bVar.id, dVar2);
                    }
                    b.this.gyQ.notifyDataSetChanged();
                }
            }
        });
        this.gyQ.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.gyO != null) {
                    b.this.gyO.a(bVar, view, b.this.gyV);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gyQ == null || this.gyQ.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fAu != null) {
            this.fAu.setSkinType(i);
            this.fAu.onChangeSkinType();
        }
        if (this.gyQ != null) {
            this.gyQ.setSkinType(i);
            this.gyQ.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gyS != null) {
            this.gyS.cancel();
        }
    }
}
