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
    private BdTypeListView bhJ;
    private LoadingView ggD;
    private TbListCommonPullView hiJ;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hiK;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hiL;
    private boolean hiM = false;
    private TbListCommonPullView.ListPullRefreshListener hiN = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hiL != null) {
                a.this.hiL.refreshData();
            }
        }
    };
    private a.InterfaceC0666a hiO = new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.bhJ = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.hiJ = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hiJ.changeSkin(0);
        this.hiJ.setSkinType(0);
        this.hiJ.setListPullRefreshListener(this.hiN);
        this.bhJ.setPullRefresh(this.hiJ);
        this.hiK = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bhJ);
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
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        if (this.hiL != null) {
            this.hiL.onDestroy();
        }
        if (this.hiK != null) {
            this.hiK.onDestroy();
            this.hiK = null;
        }
        if (this.ggD != null) {
            this.ggD.release();
            this.ggD = null;
        }
        if (this.hiJ != null) {
            this.hiJ = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
