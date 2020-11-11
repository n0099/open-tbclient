package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.hosttabpanel.c.a;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView bkA;
    private LoadingView gwu;
    private TbListCommonPullView hAC;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hAD;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hAE;
    private boolean hAF = false;
    private TbListCommonPullView.ListPullRefreshListener hAG = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hAE != null) {
                a.this.hAE.refreshData();
            }
        }
    };
    private a.InterfaceC0696a hAH = new a.InterfaceC0696a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.bkA = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hAC = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hAC.changeSkin(0);
        this.hAC.setSkinType(0);
        this.hAC.setListPullRefreshListener(this.hAG);
        this.bkA.setPullRefresh(this.hAC);
        this.hAD = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bkA);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.h.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
        return (short) 2;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        TiebaInitialize.log("c12555");
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.hAE != null) {
            this.hAE.onDestroy();
        }
        if (this.hAD != null) {
            this.hAD.onDestroy();
            this.hAD = null;
        }
        if (this.gwu != null) {
            this.gwu.release();
            this.gwu = null;
        }
        if (this.hAC != null) {
            this.hAC = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
