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
    private BdTypeListView bdX;
    private LoadingView fUk;
    private TbListCommonPullView gTL;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gTM;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a gTN;
    private boolean gTO = false;
    private TbListCommonPullView.ListPullRefreshListener gTP = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gTN != null) {
                a.this.gTN.refreshData();
            }
        }
    };
    private a.InterfaceC0648a gTQ = new a.InterfaceC0648a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.bdX = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gTL = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gTL.changeSkin(0);
        this.gTL.setSkinType(0);
        this.gTL.setListPullRefreshListener(this.gTP);
        this.bdX.setPullRefresh(this.gTL);
        this.gTM = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bdX);
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
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        if (this.gTN != null) {
            this.gTN.onDestroy();
        }
        if (this.gTM != null) {
            this.gTM.onDestroy();
            this.gTM = null;
        }
        if (this.fUk != null) {
            this.fUk.release();
            this.fUk = null;
        }
        if (this.gTL != null) {
            this.gTL = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
