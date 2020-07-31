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
    private BdTypeListView aWh;
    private LoadingView fFE;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gDA;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a gDB;
    private boolean gDC = false;
    private TbListCommonPullView.ListPullRefreshListener gDD = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gDB != null) {
                a.this.gDB.refreshData();
            }
        }
    };
    private a.InterfaceC0601a gDE = new a.InterfaceC0601a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbListCommonPullView gvo;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.aWh = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gvo = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gvo.changeSkin(0);
        this.gvo.setSkinType(0);
        this.gvo.setListPullRefreshListener(this.gDD);
        this.aWh.setPullRefresh(this.gvo);
        this.gDA = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.aWh);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        if (this.gDB != null) {
            this.gDB.onDestroy();
        }
        if (this.gDA != null) {
            this.gDA.onDestroy();
            this.gDA = null;
        }
        if (this.fFE != null) {
            this.fFE.release();
            this.fFE = null;
        }
        if (this.gvo != null) {
            this.gvo = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
