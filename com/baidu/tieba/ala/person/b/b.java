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
    private LoadingView ewR;
    private BdUniqueId ewV;
    private a.InterfaceC0474a frW;
    private com.baidu.tieba.ala.person.adapter.a frY;
    private BdListView frZ;
    private com.baidu.tieba.ala.person.c.c fsa;
    private com.baidu.tieba.ala.person.view.d fsb;
    private PersonEmptyView fsc;
    private int fsd;
    private boolean fse;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a fsf = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.d dVar) {
            b.this.hideLoadingView();
            if (dVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.fsb.qL(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = dVar.has_more == 1;
            if (dVar.has_more != 1) {
                b.this.fsb.hide();
            } else {
                b.this.fsb.mI(a.i.sdk_loading);
            }
            b.this.frY.a(b.this.fse, dVar.user_list, b.this.fsd);
            if (b.this.fse) {
                b.this.fse = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.frY.a(true, null, b.this.fsd);
            if (b.this.fsc != null) {
                b.this.frZ.setEmptyView(b.this.fsc);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewV = null;
        this.mPageContext = tbPageContext;
        this.fsd = i;
        this.mUserId = str;
        this.ewV = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.frZ = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.frY = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.frZ.setAdapter((ListAdapter) this.frY);
        this.fsb = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.fsb.createView();
        this.fsb.display();
        this.fsb.mI(a.i.sdk_loading);
        this.frZ.setNextPage(this.fsb);
        this.fsc = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.fsd == 0) {
            this.fsc.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.fsc.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.frZ.setEmptyView(this.fsc);
        this.fsa = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.fsa.a(this.fsf);
    }

    public void refreshData() {
        this.fsa.setPn(0);
        this.fse = true;
        showLoadingView();
        this.fsa.g(this.fsd, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.fsa.g(this.fsd, this.mUserId, "");
        }
    }

    public void Z(String str, boolean z) {
        if (this.frY != null) {
            this.frY.Z(str, z);
        }
    }

    public View aIi() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        this.frW = interfaceC0474a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.frZ.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.fsb.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.fsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.frY != null && b.this.frY.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.frY.a(new a.InterfaceC0473a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0473a
            public void a(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (bVar != null && bVar.portrait != null && bVar.id != null) {
                    if (bVar.eLO == 0) {
                        bVar.eLO = 1;
                        com.baidu.live.view.a.Bj().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", true, b.this.ewV));
                    } else {
                        bVar.eLO = 0;
                        com.baidu.live.view.a.Bj().a(bVar.id, new com.baidu.live.data.b(bVar.portrait, bVar.id, bVar.metaKey, "1", false, b.this.ewV));
                    }
                    b.this.frY.notifyDataSetChanged();
                }
            }
        });
        this.frY.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(com.baidu.tieba.ala.person.a.b bVar, View view) {
                if (b.this.frW != null) {
                    b.this.frW.a(bVar, view, b.this.fsd);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.frY == null || this.frY.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.ewR != null) {
            this.ewR.setSkinType(i);
            this.ewR.onChangeSkinType();
        }
        if (this.frY != null) {
            this.frY.setSkinType(i);
            this.frY.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.fsa != null) {
            this.fsa.cancel();
        }
    }
}
