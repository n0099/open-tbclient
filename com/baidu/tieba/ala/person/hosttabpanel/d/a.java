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
    private BdTypeListView bby;
    private LoadingView fQZ;
    private TbListCommonPullView gQd;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gQe;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a gQf;
    private boolean gQg = false;
    private TbListCommonPullView.ListPullRefreshListener gQh = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gQf != null) {
                a.this.gQf.refreshData();
            }
        }
    };
    private a.InterfaceC0651a gQi = new a.InterfaceC0651a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.bby = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gQd = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gQd.changeSkin(0);
        this.gQd.setSkinType(0);
        this.gQd.setListPullRefreshListener(this.gQh);
        this.bby.setPullRefresh(this.gQd);
        this.gQe = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bby);
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
        if (this.gQf != null) {
            this.gQf.onDestroy();
        }
        if (this.gQe != null) {
            this.gQe.onDestroy();
            this.gQe = null;
        }
        if (this.fQZ != null) {
            this.fQZ.release();
            this.fQZ = null;
        }
        if (this.gQd != null) {
            this.gQd = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
