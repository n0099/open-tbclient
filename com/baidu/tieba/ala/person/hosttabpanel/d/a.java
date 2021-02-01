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
    private LoadingView gOx;
    private TbListCommonPullView hVQ;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hVR;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hVS;
    private boolean hVT = false;
    private TbListCommonPullView.ListPullRefreshListener hVU = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hVS != null) {
                a.this.hVS.refreshData();
            }
        }
    };
    private a.InterfaceC0684a hVV = new a.InterfaceC0684a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
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
        this.hVQ = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hVQ.changeSkin(0);
        this.hVQ.setSkinType(0);
        this.hVQ.setListPullRefreshListener(this.hVU);
        this.bnu.setPullRefresh(this.hVQ);
        this.hVR = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bnu);
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
        if (this.hVS != null) {
            this.hVS.onDestroy();
        }
        if (this.hVR != null) {
            this.hVR.onDestroy();
            this.hVR = null;
        }
        if (this.gOx != null) {
            this.gOx.release();
            this.gOx = null;
        }
        if (this.hVQ != null) {
            this.hVQ = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
