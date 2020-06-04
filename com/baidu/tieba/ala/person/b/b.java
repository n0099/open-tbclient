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
    private LoadingView fpi;
    private BdUniqueId fpn;
    private a.InterfaceC0581a gma;
    private com.baidu.tieba.ala.person.adapter.a gmc;
    private BdListView gmd;
    private com.baidu.tieba.ala.person.c.c gme;
    private com.baidu.tieba.ala.person.view.d gmf;
    private PersonEmptyView gmg;
    private int gmh;
    private boolean gmi;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gmj = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gmf.rL(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.gmf.hide();
            } else {
                b.this.gmf.nz(a.i.sdk_loading);
            }
            b.this.gmc.a(b.this.gmi, dVar.user_list, b.this.gmh);
            if (b.this.gmi) {
                b.this.gmi = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gmc.a(true, null, b.this.gmh);
            if (b.this.gmg != null) {
                b.this.gmd.setEmptyView(b.this.gmg);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fpn = null;
        this.mPageContext = tbPageContext;
        this.gmh = i;
        this.mUserId = str;
        this.fpn = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gmd = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gmc = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gmd.setAdapter((ListAdapter) this.gmc);
        this.gmf = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gmf.createView();
        this.gmf.display();
        this.gmf.nz(a.i.sdk_loading);
        this.gmd.setNextPage(this.gmf);
        this.gmg = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gmh == 0) {
            this.gmg.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gmg.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gmd.setEmptyView(this.gmg);
        this.gme = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gme.a(this.gmj);
    }

    public void refreshData() {
        this.gme.setPn(0);
        this.gmi = true;
        showLoadingView();
        this.gme.h(this.gmh, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gme.h(this.gmh, this.mUserId, "");
        }
    }

    public void as(String str, boolean z) {
        if (this.gmc != null) {
            this.gmc.as(str, z);
        }
    }

    public View aWO() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0581a interfaceC0581a) {
        this.gma = interfaceC0581a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gmd.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gmf.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gmc != null && b.this.gmc.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gmc.a(new a.InterfaceC0580a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0580a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fEM == 0) {
                        bVar.fEM = 1;
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fpn);
                        dVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Jl().a(bVar.id, dVar);
                    } else {
                        bVar.fEM = 0;
                        com.baidu.live.data.d dVar2 = new com.baidu.live.data.d(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fpn);
                        dVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Jl().a(bVar.id, dVar2);
                    }
                    b.this.gmc.notifyDataSetChanged();
                }
            }
        });
        this.gmc.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.gma != null) {
                    b.this.gma.a(bVar, view, b.this.gmh);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gmc == null || this.gmc.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fpi != null) {
            this.fpi.setSkinType(i);
            this.fpi.onChangeSkinType();
        }
        if (this.gmc != null) {
            this.gmc.setSkinType(i);
            this.gmc.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gme != null) {
            this.gme.cancel();
        }
    }
}
