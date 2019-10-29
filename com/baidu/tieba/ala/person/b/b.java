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
    private LoadingView dFV;
    private BdUniqueId dFZ;
    private a.InterfaceC0378a evq;
    private com.baidu.tieba.ala.person.adapter.a evs;
    private BdListView evt;
    private com.baidu.tieba.ala.person.c.c evu;
    private com.baidu.tieba.ala.person.view.d evv;
    private PersonEmptyView evw;
    private int evx;
    private boolean evy;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a evz = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.evv.oi(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.evv.hide();
            } else {
                b.this.evv.ke(a.i.sdk_loading);
            }
            b.this.evs.a(b.this.evy, dVar.user_list, b.this.evx);
            if (b.this.evy) {
                b.this.evy = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.evs.a(true, null, b.this.evx);
            if (b.this.evw != null) {
                b.this.evt.setEmptyView(b.this.evw);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.dFZ = null;
        this.mPageContext = tbPageContext;
        this.evx = i;
        this.mUserId = str;
        this.dFZ = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.evt = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.evs = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.evt.setAdapter((ListAdapter) this.evs);
        this.evv = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.evv.createView();
        this.evv.le();
        this.evv.ke(a.i.sdk_loading);
        this.evt.setNextPage(this.evv);
        this.evw = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.evx == 0) {
            this.evw.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.evw.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.evt.setEmptyView(this.evw);
        this.evu = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.evu.a(this.evz);
    }

    public void refreshData() {
        this.evu.setPn(0);
        this.evy = true;
        showLoadingView();
        this.evu.i(this.evx, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.evu.i(this.evx, this.mUserId, "");
        }
    }

    public void V(String str, boolean z) {
        if (this.evs != null) {
            this.evs.V(str, z);
        }
    }

    public View aof() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0378a interfaceC0378a) {
        this.evq = interfaceC0378a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.evt.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.evv.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.evv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.evs != null && b.this.evs.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.evs.a(new a.InterfaceC0377a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0377a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.dRG == 0) {
                        bVar.dRG = 1;
                        com.baidu.live.view.a.wx().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.dFZ));
                    } else {
                        bVar.dRG = 0;
                        com.baidu.live.view.a.wx().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.dFZ));
                    }
                    b.this.evs.notifyDataSetChanged();
                }
            }
        });
        this.evs.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.evq != null) {
                    b.this.evq.a(bVar, view, b.this.evx);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.evs == null || this.evs.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.dFV != null) {
            this.dFV.setSkinType(i);
            this.dFV.onChangeSkinType();
        }
        if (this.evs != null) {
            this.evs.setSkinType(i);
            this.evs.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.evu != null) {
            this.evu.cancel();
        }
    }
}
