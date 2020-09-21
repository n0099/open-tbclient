package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.az;
import com.baidu.live.data.e;
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
    private LoadingView fUk;
    private BdUniqueId fUp;
    private a.InterfaceC0646a gUB;
    private com.baidu.tieba.ala.person.adapter.a gUD;
    private BdListView gUE;
    private com.baidu.tieba.ala.person.c.c gUF;
    private com.baidu.tieba.ala.person.view.d gUG;
    private PersonEmptyView gUH;
    private int gUI;
    private boolean gUJ;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a gUK = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.gUG.vi(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.gUG.hide();
            } else {
                b.this.gUG.qO(a.i.sdk_loading);
            }
            b.this.gUD.a(b.this.gUJ, cVar.user_list, b.this.gUI);
            if (b.this.gUJ) {
                b.this.gUJ = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.gUD.a(true, null, b.this.gUI);
            if (b.this.gUH != null) {
                b.this.gUE.setEmptyView(b.this.gUH);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fUp = null;
        this.mPageContext = tbPageContext;
        this.gUI = i;
        this.mUserId = str;
        this.fUp = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.gUE = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.gUD = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.gUE.setAdapter((ListAdapter) this.gUD);
        this.gUG = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.gUG.createView();
        this.gUG.display();
        this.gUG.qO(a.i.sdk_loading);
        this.gUE.setNextPage(this.gUG);
        this.gUH = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.gUI == 0) {
            this.gUH.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.gUH.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.gUE.setEmptyView(this.gUH);
        this.gUF = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.gUF.a(this.gUK);
    }

    public void refreshData() {
        this.gUF.setPn(0);
        this.gUJ = true;
        showLoadingView();
        this.gUF.i(this.gUI, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.gUF.i(this.gUI, this.mUserId, "");
        }
    }

    public void aw(String str, boolean z) {
        if (this.gUD != null) {
            this.gUD.aw(str, z);
        }
    }

    public View blX() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0646a interfaceC0646a) {
        this.gUB = interfaceC0646a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.gUE.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.gUG.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.gUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gUD != null && b.this.gUD.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.gUD.a(new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0645a
            public void a(az azVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (azVar != null && azVar.portrait != null && azVar.id != null) {
                    if (azVar.aJZ == 0) {
                        azVar.aJZ = 1;
                        e eVar = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", true, b.this.fUp);
                        eVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Rg().a(azVar.id, eVar);
                    } else {
                        azVar.aJZ = 0;
                        e eVar2 = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", false, b.this.fUp);
                        eVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Rg().a(azVar.id, eVar2);
                    }
                    b.this.gUD.notifyDataSetChanged();
                }
            }
        });
        this.gUD.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(az azVar, View view) {
                if (b.this.gUB != null) {
                    b.this.gUB.a(azVar, view, b.this.gUI);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.gUD == null || this.gUD.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fUk != null) {
            this.fUk.setSkinType(i);
            this.fUk.onChangeSkinType();
        }
        if (this.gUD != null) {
            this.gUD.setSkinType(i);
            this.gUD.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.gUF != null) {
            this.gUF.cancel();
        }
    }
}
