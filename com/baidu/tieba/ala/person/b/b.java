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
/* loaded from: classes10.dex */
public class b {
    private LoadingView gLR;
    private BdUniqueId gLW;
    private a.InterfaceC0682a hSl;
    private com.baidu.tieba.ala.person.adapter.a hSn;
    private BdListView hSo;
    private com.baidu.tieba.ala.person.c.c hSp;
    private e hSq;
    private PersonEmptyView hSr;
    private int hSs;
    private boolean hSt;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hSu = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hSq.wf(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hSq.hide();
            } else {
                b.this.hSq.rm(a.h.sdk_loading);
            }
            b.this.hSn.a(b.this.hSt, cVar.user_list, b.this.hSs);
            if (b.this.hSt) {
                b.this.hSt = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hSn.a(true, null, b.this.hSs);
            if (b.this.hSr != null) {
                b.this.hSo.setEmptyView(b.this.hSr);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gLW = null;
        this.mPageContext = tbPageContext;
        this.hSs = i;
        this.mUserId = str;
        this.gLW = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hSo = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hSn = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hSo.setAdapter((ListAdapter) this.hSn);
        this.hSq = new e(this.mPageContext);
        this.hSq.createView();
        this.hSq.rV();
        this.hSq.rm(a.h.sdk_loading);
        this.hSo.setNextPage(this.hSq);
        this.hSr = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hSs == 0) {
            this.hSr.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hSr.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hSo.setEmptyView(this.hSr);
        this.hSp = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hSp.a(this.hSu);
    }

    public void refreshData() {
        this.hSp.setPn(0);
        this.hSt = true;
        showLoadingView();
        this.hSp.e(this.hSs, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hSp.e(this.hSs, this.mUserId, "");
        }
    }

    public void aE(String str, boolean z) {
        if (this.hSn != null) {
            this.hSn.aE(str, z);
        }
    }

    public View clG() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        this.hSl = interfaceC0682a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hSo.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hSq.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hSn != null && b.this.hSn.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hSn.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0681a
            public void a(bh bhVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bhVar != null && bhVar.portrait != null && bhVar.id != null) {
                    if (bhVar.aMc == 0) {
                        bhVar.aMc = 1;
                        f fVar = new f(bhVar.portrait, bhVar.id, bhVar.metaKey, "1", true, b.this.gLW);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VF().a(bhVar.id, fVar);
                    } else {
                        bhVar.aMc = 0;
                        f fVar2 = new f(bhVar.portrait, bhVar.id, bhVar.metaKey, "1", false, b.this.gLW);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VF().a(bhVar.id, fVar2);
                    }
                    b.this.hSn.notifyDataSetChanged();
                }
            }
        });
        this.hSn.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(bh bhVar, View view) {
                if (b.this.hSl != null) {
                    b.this.hSl.a(bhVar, view, b.this.hSs);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hSn == null || this.hSn.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gLR != null) {
            this.gLR.setSkinType(i);
            this.gLR.onChangeSkinType();
        }
        if (this.hSn != null) {
            this.hSn.setSkinType(i);
            this.hSn.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hSp != null) {
            this.hSp.cancel();
        }
    }
}
