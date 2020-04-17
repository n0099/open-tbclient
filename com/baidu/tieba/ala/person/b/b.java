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
    private a.InterfaceC0510a fWQ;
    private com.baidu.tieba.ala.person.adapter.a fWS;
    private BdListView fWT;
    private com.baidu.tieba.ala.person.c.c fWU;
    private com.baidu.tieba.ala.person.view.d fWV;
    private PersonEmptyView fWW;
    private int fWX;
    private boolean fWY;
    private LoadingView fbq;
    private BdUniqueId fbv;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fWZ = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fWV.rg(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fWV.hide();
            } else {
                b.this.fWV.mV(a.i.sdk_loading);
            }
            b.this.fWS.a(b.this.fWY, dVar.user_list, b.this.fWX);
            if (b.this.fWY) {
                b.this.fWY = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.fWS.a(true, null, b.this.fWX);
            if (b.this.fWW != null) {
                b.this.fWT.setEmptyView(b.this.fWW);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fbv = null;
        this.mPageContext = tbPageContext;
        this.fWX = i;
        this.mUserId = str;
        this.fbv = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.fWT = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.fWS = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.fWT.setAdapter((ListAdapter) this.fWS);
        this.fWV = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fWV.createView();
        this.fWV.display();
        this.fWV.mV(a.i.sdk_loading);
        this.fWT.setNextPage(this.fWV);
        this.fWW = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fWX == 0) {
            this.fWW.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fWW.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.fWT.setEmptyView(this.fWW);
        this.fWU = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.fWU.a(this.fWZ);
    }

    public void refreshData() {
        this.fWU.setPn(0);
        this.fWY = true;
        showLoadingView();
        this.fWU.h(this.fWX, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.fWU.h(this.fWX, this.mUserId, "");
        }
    }

    public void af(String str, boolean z) {
        if (this.fWS != null) {
            this.fWS.af(str, z);
        }
    }

    public View aQI() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0510a interfaceC0510a) {
        this.fWQ = interfaceC0510a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.fWT.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fWV.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fWV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fWS != null && b.this.fWS.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.fWS.a(new a.InterfaceC0509a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0509a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.fqC == 0) {
                        bVar.fqC = 1;
                        com.baidu.live.data.b bVar2 = new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.fbv);
                        bVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ht().a(bVar.id, bVar2);
                    } else {
                        bVar.fqC = 0;
                        com.baidu.live.data.b bVar3 = new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.fbv);
                        bVar3.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Ht().a(bVar.id, bVar3);
                    }
                    b.this.fWS.notifyDataSetChanged();
                }
            }
        });
        this.fWS.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.fWQ != null) {
                    b.this.fWQ.a(bVar, view, b.this.fWX);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.fWS == null || this.fWS.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.fbq != null) {
            this.fbq.setSkinType(i);
            this.fbq.onChangeSkinType();
        }
        if (this.fWS != null) {
            this.fWS.setSkinType(i);
            this.fWS.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.fWU != null) {
            this.fWU.cancel();
        }
    }
}
