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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView bnu;
    private LoadingView gOL;
    private TbListCommonPullView hWe;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hWf;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hWg;
    private boolean hWh = false;
    private TbListCommonPullView.ListPullRefreshListener hWi = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hWg != null) {
                a.this.hWg.refreshData();
            }
        }
    };
    private a.InterfaceC0685a hWj = new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.bnu = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hWe = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hWe.changeSkin(0);
        this.hWe.setSkinType(0);
        this.hWe.setListPullRefreshListener(this.hWi);
        this.bnu.setPullRefresh(this.hWe);
        this.hWf = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bnu);
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
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.hWg != null) {
            this.hWg.onDestroy();
        }
        if (this.hWf != null) {
            this.hWf.onDestroy();
            this.hWf = null;
        }
        if (this.gOL != null) {
            this.gOL.release();
            this.gOL = null;
        }
        if (this.hWe != null) {
            this.hWe = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
