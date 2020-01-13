package com.baidu.tieba.ala.person.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.b.a;
import com.baidu.tieba.ala.person.c.c;
import com.baidu.tieba.ala.person.view.PersonEmptyView;
/* loaded from: classes2.dex */
public class b {
    private LoadingView est;
    private BdUniqueId esx;
    private a.InterfaceC0466a fpe;
    private com.baidu.tieba.ala.person.adapter.a fpg;
    private BdListView fph;
    private com.baidu.tieba.ala.person.c.c fpi;
    private com.baidu.tieba.ala.person.view.d fpj;
    private PersonEmptyView fpk;
    private int fpl;
    private boolean fpm;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fpn = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fpj.qE(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fpj.hide();
            } else {
                b.this.fpj.mr(a.i.sdk_loading);
            }
            b.this.fpg.a(b.this.fpm, dVar.user_list, b.this.fpl);
            if (b.this.fpm) {
                b.this.fpm = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.fpg.a(true, null, b.this.fpl);
            if (b.this.fpk != null) {
                b.this.fph.setEmptyView(b.this.fpk);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.esx = null;
        this.mPageContext = tbPageContext;
        this.fpl = i;
        this.mUserId = str;
        this.esx = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.fph = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.fpg = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.fph.setAdapter((ListAdapter) this.fpg);
        this.fpj = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fpj.createView();
        this.fpj.display();
        this.fpj.mr(a.i.sdk_loading);
        this.fph.setNextPage(this.fpj);
        this.fpk = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fpl == 0) {
            this.fpk.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fpk.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.fph.setEmptyView(this.fpk);
        this.fpi = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.fpi.a(this.fpn);
    }

    public void refreshData() {
        this.fpi.setPn(0);
        this.fpm = true;
        showLoadingView();
        this.fpi.g(this.fpl, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.fpi.g(this.fpl, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.fpg != null) {
            this.fpg.Z(str, z);
        }
    }

    public View aFQ() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0466a interfaceC0466a) {
        this.fpe = interfaceC0466a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.fph.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fpj.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fpj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fpg != null && b.this.fpg.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.fpg.a(new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0465a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eHG == 0) {
                        bVar.eHG = 1;
                        com.baidu.live.view.a.yR().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.esx));
                    } else {
                        bVar.eHG = 0;
                        com.baidu.live.view.a.yR().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.esx));
                    }
                    b.this.fpg.notifyDataSetChanged();
                }
            }
        });
        this.fpg.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.fpe != null) {
                    b.this.fpe.a(bVar, view, b.this.fpl);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.fpg == null || this.fpg.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.est != null) {
            this.est.setSkinType(i);
            this.est.onChangeSkinType();
        }
        if (this.fpg != null) {
            this.fpg.setSkinType(i);
            this.fpg.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.fpi != null) {
            this.fpi.cancel();
        }
    }
}
