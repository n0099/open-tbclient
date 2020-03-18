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
    private LoadingView exn;
    private BdUniqueId exr;
    private com.baidu.tieba.ala.person.view.d fsA;
    private PersonEmptyView fsB;
    private int fsC;
    private boolean fsD;
    private a.InterfaceC0474a fsv;
    private com.baidu.tieba.ala.person.adapter.a fsx;
    private BdListView fsy;
    private com.baidu.tieba.ala.person.c.c fsz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fsE = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fsA.qN(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fsA.hide();
            } else {
                b.this.fsA.mK(a.i.sdk_loading);
            }
            b.this.fsx.a(b.this.fsD, dVar.user_list, b.this.fsC);
            if (b.this.fsD) {
                b.this.fsD = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.fsx.a(true, null, b.this.fsC);
            if (b.this.fsB != null) {
                b.this.fsy.setEmptyView(b.this.fsB);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.exr = null;
        this.mPageContext = tbPageContext;
        this.fsC = i;
        this.mUserId = str;
        this.exr = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.fsy = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.fsx = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.fsy.setAdapter((ListAdapter) this.fsx);
        this.fsA = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fsA.createView();
        this.fsA.display();
        this.fsA.mK(a.i.sdk_loading);
        this.fsy.setNextPage(this.fsA);
        this.fsB = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fsC == 0) {
            this.fsB.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fsB.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.fsy.setEmptyView(this.fsB);
        this.fsz = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.fsz.a(this.fsE);
    }

    public void refreshData() {
        this.fsz.setPn(0);
        this.fsD = true;
        showLoadingView();
        this.fsz.g(this.fsC, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.fsz.g(this.fsC, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.fsx != null) {
            this.fsx.Z(str, z);
        }
    }

    public View aIm() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        this.fsv = interfaceC0474a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.fsy.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fsA.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fsA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fsx != null && b.this.fsx.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.fsx.a(new a.InterfaceC0473a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0473a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eMk == 0) {
                        bVar.eMk = 1;
                        com.baidu.live.view.a.Bq().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.exr));
                    } else {
                        bVar.eMk = 0;
                        com.baidu.live.view.a.Bq().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.exr));
                    }
                    b.this.fsx.notifyDataSetChanged();
                }
            }
        });
        this.fsx.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.fsv != null) {
                    b.this.fsv.a(bVar, view, b.this.fsC);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.fsx == null || this.fsx.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.exn != null) {
            this.exn.setSkinType(i);
            this.exn.onChangeSkinType();
        }
        if (this.fsx != null) {
            this.fsx.setSkinType(i);
            this.fsx.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.fsz != null) {
            this.fsz.cancel();
        }
    }
}
