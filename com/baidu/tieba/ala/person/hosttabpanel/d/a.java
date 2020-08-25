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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView bbw;
    private LoadingView fQV;
    private TbListCommonPullView gPZ;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gQa;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a gQb;
    private boolean gQc = false;
    private TbListCommonPullView.ListPullRefreshListener gQd = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gQb != null) {
                a.this.gQb.refreshData();
            }
        }
    };
    private a.InterfaceC0651a gQe = new a.InterfaceC0651a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.bbw = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gPZ = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gPZ.changeSkin(0);
        this.gPZ.setSkinType(0);
        this.gPZ.setListPullRefreshListener(this.gQd);
        this.bbw.setPullRefresh(this.gPZ);
        this.gQa = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bbw);
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
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        if (this.gQb != null) {
            this.gQb.onDestroy();
        }
        if (this.gQa != null) {
            this.gQa.onDestroy();
            this.gQa = null;
        }
        if (this.fQV != null) {
            this.fQV.release();
            this.fQV = null;
        }
        if (this.gPZ != null) {
            this.gPZ = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
