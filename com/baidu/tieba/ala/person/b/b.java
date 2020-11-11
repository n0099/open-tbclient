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
    private LoadingView gwu;
    private BdUniqueId gwz;
    private boolean hBA;
    private a.InterfaceC0694a hBs;
    private com.baidu.tieba.ala.person.adapter.a hBu;
    private BdListView hBv;
    private com.baidu.tieba.ala.person.c.c hBw;
    private com.baidu.tieba.ala.person.view.d hBx;
    private PersonEmptyView hBy;
    private int hBz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hBB = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.h.ala_person_load_fail);
                b.this.hBx.wv(a.h.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hBx.hide();
            } else {
                b.this.hBx.rH(a.h.sdk_loading);
            }
            b.this.hBu.a(b.this.hBA, cVar.user_list, b.this.hBz);
            if (b.this.hBA) {
                b.this.hBA = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hBu.a(true, null, b.this.hBz);
            if (b.this.hBy != null) {
                b.this.hBv.setEmptyView(b.this.hBy);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gwz = null;
        this.mPageContext = tbPageContext;
        this.hBz = i;
        this.mUserId = str;
        this.gwz = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hBv = (BdListView) this.mRootView.findViewById(a.f.ala_person_card_list_view);
        this.hBu = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hBv.setAdapter((ListAdapter) this.hBu);
        this.hBx = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hBx.createView();
        this.hBx.display();
        this.hBx.rH(a.h.sdk_loading);
        this.hBv.setNextPage(this.hBx);
        this.hBy = (PersonEmptyView) this.mRootView.findViewById(a.f.ala_person_card_emptyview);
        if (this.hBz == 0) {
            this.hBy.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_fans);
        } else {
            this.hBy.setParams(a.e.sdk_emotion07, -1, a.h.ala_person_no_attention_desc);
        }
        this.hBv.setEmptyView(this.hBy);
        this.hBw = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hBw.a(this.hBB);
    }

    public void refreshData() {
        this.hBw.setPn(0);
        this.hBA = true;
        showLoadingView();
        this.hBw.c(this.hBz, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hBw.c(this.hBz, this.mUserId, "");
        }
    }

    public void aC(String str, boolean z) {
        if (this.hBu != null) {
            this.hBu.aC(str, z);
        }
    }

    public View bta() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        this.hBs = interfaceC0694a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hBv.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hBx.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hBu != null && b.this.hBu.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hBu.a(new a.InterfaceC0693a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0693a
            public void a(be beVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (beVar != null && beVar.portrait != null && beVar.id != null) {
                    if (beVar.aOM == 0) {
                        beVar.aOM = 1;
                        f fVar = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", true, b.this.gwz);
                        fVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Wx().a(beVar.id, fVar);
                    } else {
                        beVar.aOM = 0;
                        f fVar2 = new f(beVar.portrait, beVar.id, beVar.metaKey, "1", false, b.this.gwz);
                        fVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.Wx().a(beVar.id, fVar2);
                    }
                    b.this.hBu.notifyDataSetChanged();
                }
            }
        });
        this.hBu.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(be beVar, View view) {
                if (b.this.hBs != null) {
                    b.this.hBs.a(beVar, view, b.this.hBz);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hBu == null || this.hBu.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.gwu != null) {
            this.gwu.setSkinType(i);
            this.gwu.onChangeSkinType();
        }
        if (this.hBu != null) {
            this.hBu.setSkinType(i);
            this.hBu.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hBw != null) {
            this.hBw.cancel();
        }
    }
}
