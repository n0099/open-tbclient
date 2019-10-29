package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.hosttabpanel.c.a;
/* loaded from: classes6.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private BdTypeListView agS;
    private LoadingView dFV;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a euA;
    private boolean euB = false;
    private TbListCommonPullView.ListPullRefreshListener euC = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.euA != null) {
                a.this.euA.refreshData();
            }
        }
    };
    private a.InterfaceC0380a euD = new a.InterfaceC0380a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbListCommonPullView euy;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a euz;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.agS = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.euy = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.euy.changeSkin(0);
        this.euy.setSkinType(0);
        this.euy.setListPullRefreshListener(this.euC);
        this.agS.setPullRefresh(this.euy);
        this.euz = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.agS);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
        return (short) 2;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        TiebaInitialize.log("c12555");
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.euA != null) {
            this.euA.onDestroy();
        }
        if (this.euz != null) {
            this.euz.onDestroy();
            this.euz = null;
        }
        if (this.dFV != null) {
            this.dFV.release();
            this.dFV = null;
        }
        if (this.euy != null) {
            this.euy = null;
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
