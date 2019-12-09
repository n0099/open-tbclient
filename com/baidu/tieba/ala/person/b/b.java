package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.b.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.PersonEmptyView;
/* loaded from: classes6.dex */
public class b {
    private LoadingView dFe;
    private BdUniqueId dFi;
    private com.baidu.tieba.ala.person.adapter.a euB;
    private BdListView euC;
    private com.baidu.tieba.ala.person.c.c euD;
    private com.baidu.tieba.ala.person.view.d euE;
    private PersonEmptyView euF;
    private int euG;
    private boolean euH;
    private a.InterfaceC0373a euz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a euI = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.euE.oh(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.euE.hide();
            } else {
                b.this.euE.kd(a.i.sdk_loading);
            }
            b.this.euB.a(b.this.euH, dVar.user_list, b.this.euG);
            if (b.this.euH) {
                b.this.euH = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.euB.a(true, null, b.this.euG);
            if (b.this.euF != null) {
                b.this.euC.setEmptyView(b.this.euF);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.dFi = null;
        this.mPageContext = tbPageContext;
        this.euG = i;
        this.mUserId = str;
        this.dFi = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.euC = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.euB = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.euC.setAdapter((ListAdapter) this.euB);
        this.euE = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.euE.createView();
        this.euE.le();
        this.euE.kd(a.i.sdk_loading);
        this.euC.setNextPage(this.euE);
        this.euF = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.euG == 0) {
            this.euF.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.euF.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.euC.setEmptyView(this.euF);
        this.euD = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.euD.a(this.euI);
    }

    public void refreshData() {
        this.euD.setPn(0);
        this.euH = true;
        showLoadingView();
        this.euD.i(this.euG, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.euD.i(this.euG, this.mUserId, "");
        }
    }

    public void V(String str, boolean z) {
        if (this.euB != null) {
            this.euB.V(str, z);
        }
    }

    public View aod() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0373a interfaceC0373a) {
        this.euz = interfaceC0373a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.euC.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.euE.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.euE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.euB != null && b.this.euB.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.euB.a(new a.InterfaceC0372a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0372a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.dQP == 0) {
                        bVar.dQP = 1;
                        com.baidu.live.view.a.wy().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.dFi));
                    } else {
                        bVar.dQP = 0;
                        com.baidu.live.view.a.wy().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.dFi));
                    }
                    b.this.euB.notifyDataSetChanged();
                }
            }
        });
        this.euB.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.euz != null) {
                    b.this.euz.a(bVar, view, b.this.euG);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.euB == null || this.euB.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.dFe != null) {
            this.dFe.setSkinType(i);
            this.dFe.onChangeSkinType();
        }
        if (this.euB != null) {
            this.euB.setSkinType(i);
            this.euB.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.euD != null) {
            this.euD.cancel();
        }
    }
}
