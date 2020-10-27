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
    private BdTypeListView bjg;
    private LoadingView gqG;
    private TbListCommonPullView huF;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a huG;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a huH;
    private boolean huI = false;
    private TbListCommonPullView.ListPullRefreshListener huJ = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.huH != null) {
                a.this.huH.refreshData();
            }
        }
    };
    private a.InterfaceC0682a huK = new a.InterfaceC0682a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.bjg = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.huF = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.huF.changeSkin(0);
        this.huF.setSkinType(0);
        this.huF.setListPullRefreshListener(this.huJ);
        this.bjg.setPullRefresh(this.huF);
        this.huG = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bjg);
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
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.huH != null) {
            this.huH.onDestroy();
        }
        if (this.huG != null) {
            this.huG.onDestroy();
            this.huG = null;
        }
        if (this.gqG != null) {
            this.gqG.release();
            this.gqG = null;
        }
        if (this.huF != null) {
            this.huF = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
