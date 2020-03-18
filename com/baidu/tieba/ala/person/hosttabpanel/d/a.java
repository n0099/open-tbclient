package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.hosttabpanel.c.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView asR;
    private LoadingView exn;
    private TbListCommonPullView frF;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a frG;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a frH;
    private boolean frI = false;
    private TbListCommonPullView.ListPullRefreshListener frJ = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.frH != null) {
                a.this.frH.refreshData();
            }
        }
    };
    private a.InterfaceC0476a frK = new a.InterfaceC0476a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.asR = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.frF = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.frF.changeSkin(0);
        this.frF.setSkinType(0);
        this.frF.setListPullRefreshListener(this.frJ);
        this.asR.setPullRefresh(this.frF);
        this.frG = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.asR);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
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
        if (this.frH != null) {
            this.frH.onDestroy();
        }
        if (this.frG != null) {
            this.frG.onDestroy();
            this.frG = null;
        }
        if (this.exn != null) {
            this.exn.release();
            this.exn = null;
        }
        if (this.frF != null) {
            this.frF = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
