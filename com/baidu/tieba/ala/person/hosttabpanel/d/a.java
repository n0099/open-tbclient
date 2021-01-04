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
    private BdTypeListView boO;
    private LoadingView gQx;
    private TbListCommonPullView hWc;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hWd;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hWe;
    private boolean hWf = false;
    private TbListCommonPullView.ListPullRefreshListener hWg = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hWe != null) {
                a.this.hWe.refreshData();
            }
        }
    };
    private a.InterfaceC0701a hWh = new a.InterfaceC0701a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.boO = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hWc = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hWc.changeSkin(0);
        this.hWc.setSkinType(0);
        this.hWc.setListPullRefreshListener(this.hWg);
        this.boO.setPullRefresh(this.hWc);
        this.hWd = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.boO);
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
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.hWe != null) {
            this.hWe.onDestroy();
        }
        if (this.hWd != null) {
            this.hWd.onDestroy();
            this.hWd = null;
        }
        if (this.gQx != null) {
            this.gQx.release();
            this.gQx = null;
        }
        if (this.hWc != null) {
            this.hWc = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
