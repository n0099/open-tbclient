package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.be;
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
/* loaded from: classes4.dex */
public class b {
    private LoadingView gwb;
    private BdUniqueId gwg;
    private a.InterfaceC0694a hAZ;
    private com.baidu.tieba.ala.person.adapter.a hBb;
    private BdListView hBc;
    private com.baidu.tieba.ala.person.c.c hBd;
    private com.baidu.tieba.ala.person.view.d hBe;
    private PersonEmptyView hBf;
    private int hBg;
    private boolean hBh;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hBi = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hBe.wT(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hBe.hide();
            } else {
                b.this.hBe.sf(a.h.sdk_loading);
            }
            b.this.hBb.a(b.this.hBh, cVar.user_list, b.this.hBg);
            if (b.this.hBh) {
                b.this.hBh = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hBb.a(true, null, b.this.hBg);
            if (b.this.hBf != null) {
                b.this.hBc.setEmptyView(b.this.hBf);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gwg = null;
        this.mPageContext = tbPageContext;
        this.hBg = i;
        this.mUserId = str;
        this.gwg = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hBc = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hBb = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hBc.setAdapter((ListAdapter) this.hBb);
        this.hBe = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hBe.createView();
        this.hBe.display();
        this.hBe.sf(a.h.sdk_loading);
        this.hBc.setNextPage(this.hBe);
        this.hBf = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hBg == 0) {
            this.hBf.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hBf.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hBc.setEmptyView(this.hBf);
        this.hBd = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hBd.a(this.hBi);
    }

    public void refreshData() {
        this.hBd.setPn(0);
        this.hBh = true;
        showLoadingView();
        this.hBd.c(this.hBg, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hBd.c(this.hBg, this.mUserId, "");
        }
    }

    public void aC(String str, boolean z) {
        if (this.hBb != null) {
            this.hBb.aC(str, z);
        }
    }

    public View bsq() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        this.hAZ = interfaceC0694a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hBc.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hBe.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hBb != null && b.this.hBb.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hBb.a(new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0693a
            public void a(be beVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (beVar != null && beVar.portrait != null && beVar.id != null) {
                    if (beVar.aNb == 0) {
                        beVar.aNb = 1;
                        f fVar = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", true, b.this.gwg);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VO().a(beVar.id, fVar);
                    } else {
                        beVar.aNb = 0;
                        f fVar2 = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", false, b.this.gwg);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.VO().a(beVar.id, fVar2);
                    }
                    b.this.hBb.notifyDataSetChanged();
                }
            }
        });
        this.hBb.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(be beVar, View view) {
                if (b.this.hAZ != null) {
                    b.this.hAZ.a(beVar, view, b.this.hBg);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hBb == null || this.hBb.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gwb != null) {
            this.gwb.setSkinType(i);
            this.gwb.onChangeSkinType();
        }
        if (this.hBb != null) {
            this.hBb.setSkinType(i);
            this.hBb.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hBd != null) {
            this.hBd.cancel();
        }
    }
}
