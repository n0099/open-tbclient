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
    private LoadingView ggD;
    private BdUniqueId ggI;
    private com.baidu.tieba.ala.person.adapter.a hjB;
    private BdListView hjC;
    private com.baidu.tieba.ala.person.c.c hjD;
    private com.baidu.tieba.ala.person.view.d hjE;
    private PersonEmptyView hjF;
    private int hjG;
    private boolean hjH;
    private a.InterfaceC0664a hjz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mSkinType;
    private String mUserId;
    private boolean mIsLoading = false;
    private c.a hjI = new c.a() { // from class: com.baidu.tieba.ala.person.b.b.5
        @Override // com.baidu.tieba.ala.person.c.c.a
        public void c(com.baidu.tieba.ala.person.a.c cVar) {
            b.this.hideLoadingView();
            if (cVar == null) {
                CustomToast.newInstance().showToast(a.i.ala_person_load_fail);
                b.this.hjE.vO(a.i.ala_person_load_fail_click);
                return;
            }
            b.this.mHasMore = cVar.has_more == 1;
            if (cVar.has_more != 1) {
                b.this.hjE.hide();
            } else {
                b.this.hjE.rm(a.i.sdk_loading);
            }
            b.this.hjB.a(b.this.hjH, cVar.user_list, b.this.hjG);
            if (b.this.hjH) {
                b.this.hjH = false;
            }
        }

        @Override // com.baidu.tieba.ala.person.c.c.a
        public void onFail(String str) {
            b.this.hideLoadingView();
            CustomToast.newInstance().showToast(str);
            b.this.hjB.a(true, null, b.this.hjG);
            if (b.this.hjF != null) {
                b.this.hjC.setEmptyView(b.this.hjF);
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ggI = null;
        this.mPageContext = tbPageContext;
        this.hjG = i;
        this.mUserId = str;
        this.ggI = bdUniqueId;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_person_card_list_view_layout, (ViewGroup) null);
        this.hjC = (BdListView) this.mRootView.findViewById(a.g.ala_person_card_list_view);
        this.hjB = new com.baidu.tieba.ala.person.adapter.a(this.mPageContext.getPageActivity(), 2);
        this.hjC.setAdapter((ListAdapter) this.hjB);
        this.hjE = new com.baidu.tieba.ala.person.view.d(this.mPageContext);
        this.hjE.createView();
        this.hjE.display();
        this.hjE.rm(a.i.sdk_loading);
        this.hjC.setNextPage(this.hjE);
        this.hjF = (PersonEmptyView) this.mRootView.findViewById(a.g.ala_person_card_emptyview);
        if (this.hjG == 0) {
            this.hjF.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_fans);
        } else {
            this.hjF.setParams(a.f.sdk_emotion07, -1, a.i.ala_person_no_attention_desc);
        }
        this.hjC.setEmptyView(this.hjF);
        this.hjD = new com.baidu.tieba.ala.person.c.c(this.mPageContext);
        this.hjD.a(this.hjI);
    }

    public void refreshData() {
        this.hjD.setPn(0);
        this.hjH = true;
        showLoadingView();
        this.hjD.i(this.hjG, this.mUserId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mHasMore) {
            this.hjD.i(this.hjG, this.mUserId, "");
        }
    }

    public void aA(String str, boolean z) {
        if (this.hjB != null) {
            this.hjB.aA(str, z);
        }
    }

    public View boH() {
        return this.mRootView;
    }

    public void a(a.InterfaceC0664a interfaceC0664a) {
        this.hjz = interfaceC0664a;
    }

    public void showLoadingView() {
    }

    public void hideLoadingView() {
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    private void initListener() {
        this.hjC.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.b.b.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!b.this.mHasMore) {
                    b.this.hjE.hide();
                } else {
                    b.this.loadData();
                }
            }
        });
        this.hjE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hjB != null && b.this.hjB.getCount() == 0) {
                    b.this.loadData();
                }
            }
        });
        this.hjB.a(new a.InterfaceC0663a() { // from class: com.baidu.tieba.ala.person.b.b.3
            @Override // com.baidu.tieba.ala.person.adapter.a.InterfaceC0663a
            public void a(az azVar, View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (azVar != null && azVar.portrait != null && azVar.id != null) {
                    if (azVar.aNe == 0) {
                        azVar.aNe = 1;
                        e eVar = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", true, b.this.ggI);
                        eVar.setFrom("source_person_card_list");
                        com.baidu.live.view.a.SY().a(azVar.id, eVar);
                    } else {
                        azVar.aNe = 0;
                        e eVar2 = new e(azVar.portrait, azVar.id, azVar.metaKey, "1", false, b.this.ggI);
                        eVar2.setFrom("source_person_card_list");
                        com.baidu.live.view.a.SY().a(azVar.id, eVar2);
                    }
                    b.this.hjB.notifyDataSetChanged();
                }
            }
        });
        this.hjB.a(new a.c() { // from class: com.baidu.tieba.ala.person.b.b.4
            @Override // com.baidu.tieba.ala.person.adapter.a.c
            public void b(az azVar, View view) {
                if (b.this.hjz != null) {
                    b.this.hjz.a(azVar, view, b.this.hjG);
                }
            }
        });
    }

    public boolean isEmpty() {
        return this.hjB == null || this.hjB.getCount() <= 0;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.ggD != null) {
            this.ggD.setSkinType(i);
            this.ggD.onChangeSkinType();
        }
        if (this.hjB != null) {
            this.hjB.setSkinType(i);
            this.hjB.notifyDataSetChanged();
        }
    }

    public void onDestory() {
        if (this.hjD != null) {
            this.hjD.cancel();
        }
    }
}
