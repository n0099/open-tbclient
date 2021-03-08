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
/* loaded from: classes10.dex */
public class b {
    private LoadingView gQu;
    private BdUniqueId gQz;
    private a.InterfaceC0689a hYD;
    private com.baidu.tieba.ala.person.adapter.a hYF;
    private BdListView hYG;
    private com.baidu.tieba.ala.person.c.c hYH;
    private e hYI;
    private PersonEmptyView hYJ;
    private int hYK;
    private boolean hYL;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hYM = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hYI.wr(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hYI.hide();
            } else {
                b.this.hYI.rs(a.h.sdk_loading);
            }
            b.this.hYF.a(b.this.hYL, cVar.user_list, b.this.hYK);
            if (b.this.hYL) {
                b.this.hYL = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hYF.a(true, null, b.this.hYK);
            if (b.this.hYJ != null) {
                b.this.hYG.setEmptyView(b.this.hYJ);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gQz = null;
        this.mPageContext = tbPageContext;
        this.hYK = i;
        this.mUserId = str;
        this.gQz = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hYG = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hYF = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hYG.setAdapter((ListAdapter) this.hYF);
        this.hYI = new e(this.mPageContext);
        this.hYI.createView();
        this.hYI.display();
        this.hYI.rs(a.h.sdk_loading);
        this.hYG.setNextPage(this.hYI);
        this.hYJ = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hYK == 0) {
            this.hYJ.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hYJ.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hYG.setEmptyView(this.hYJ);
        this.hYH = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hYH.a(this.hYM);
    }

    public void refreshData() {
        this.hYH.setPn(0);
        this.hYL = true;
        showLoadingView();
        this.hYH.e(this.hYK, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hYH.e(this.hYK, this.mUserId, "");
        }
    }

    public void aD(String str, boolean z) {
        if (this.hYF != null) {
            this.hYF.aD(str, z);
        }
    }

    public View cmR() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0689a interfaceC0689a) {
        this.hYD = interfaceC0689a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hYG.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hYI.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hYF != null && b.this.hYF.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hYF.a(new a.InterfaceC0688a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0688a
            public void a(bl blVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (blVar != null && blVar.portrait != null && blVar.id != null) {
                    if (blVar.aQz == 0) {
                        blVar.aQz = 1;
                        f fVar = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", true, b.this.gQz);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xr().a(blVar.id, fVar);
                    } else {
                        blVar.aQz = 0;
                        f fVar2 = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", false, b.this.gQz);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xr().a(blVar.id, fVar2);
                    }
                    b.this.hYF.notifyDataSetChanged();
                }
            }
        });
        this.hYF.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bl blVar, View view) {
                if (b.this.hYD != null) {
                    b.this.hYD.a(blVar, view, b.this.hYK);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hYF == null || this.hYF.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gQu != null) {
            this.gQu.setSkinType(i);
            this.gQu.onChangeSkinType();
        }
        if (this.hYF != null) {
            this.hYF.setSkinType(i);
            this.hYF.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hYH != null) {
            this.hYH.cancel();
        }
    }
}
