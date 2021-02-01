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
    private BdUniqueId gOC;
    private LoadingView gOx;
    private a.InterfaceC0682a hWG;
    private com.baidu.tieba.ala.person.adapter.a hWI;
    private BdListView hWJ;
    private com.baidu.tieba.ala.person.c.c hWK;
    private e hWL;
    private PersonEmptyView hWM;
    private int hWN;
    private boolean hWO;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hWP = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hWL.wq(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hWL.hide();
            } else {
                b.this.hWL.rr(a.h.sdk_loading);
            }
            b.this.hWI.a(b.this.hWO, cVar.user_list, b.this.hWN);
            if (b.this.hWO) {
                b.this.hWO = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hWI.a(true, null, b.this.hWN);
            if (b.this.hWM != null) {
                b.this.hWJ.setEmptyView(b.this.hWM);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gOC = null;
        this.mPageContext = tbPageContext;
        this.hWN = i;
        this.mUserId = str;
        this.gOC = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hWJ = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hWI = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hWJ.setAdapter((ListAdapter) this.hWI);
        this.hWL = new e(this.mPageContext);
        this.hWL.createView();
        this.hWL.display();
        this.hWL.rr(a.h.sdk_loading);
        this.hWJ.setNextPage(this.hWL);
        this.hWM = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hWN == 0) {
            this.hWM.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hWM.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hWJ.setEmptyView(this.hWM);
        this.hWK = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hWK.a(this.hWP);
    }

    public void refreshData() {
        this.hWK.setPn(0);
        this.hWO = true;
        showLoadingView();
        this.hWK.e(this.hWN, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hWK.e(this.hWN, this.mUserId, "");
        }
    }

    public void aD(String str, boolean z) {
        if (this.hWI != null) {
            this.hWI.aD(str, z);
        }
    }

    public View cmE() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        this.hWG = interfaceC0682a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hWJ.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hWL.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hWL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hWI != null && b.this.hWI.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hWI.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0681a
            public void a(bl blVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (blVar != null && blVar.portrait != null && blVar.id != null) {
                    if (blVar.aOZ == 0) {
                        blVar.aOZ = 1;
                        f fVar = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", true, b.this.gOC);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xo().a(blVar.id, fVar);
                    } else {
                        blVar.aOZ = 0;
                        f fVar2 = new f(blVar.portrait, blVar.id, blVar.metaKey, "1", false, b.this.gOC);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Xo().a(blVar.id, fVar2);
                    }
                    b.this.hWI.notifyDataSetChanged();
                }
            }
        });
        this.hWI.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bl blVar, View view) {
                if (b.this.hWG != null) {
                    b.this.hWG.a(blVar, view, b.this.hWN);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hWI == null || this.hWI.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gOx != null) {
            this.gOx.setSkinType(i);
            this.gOx.onChangeSkinType();
        }
        if (this.hWI != null) {
            this.hWI.setSkinType(i);
            this.hWI.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hWK != null) {
            this.hWK.cancel();
        }
    }
}
