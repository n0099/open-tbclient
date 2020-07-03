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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView aUR;
    private LoadingView fAu;
    private TbListCommonPullView gql;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gxZ;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a gya;
    private boolean gyb = false;
    private TbListCommonPullView.ListPullRefreshListener gyc = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gya != null) {
                a.this.gya.refreshData();
            }
        }
    };
    private a.InterfaceC0592a gyd = new a.InterfaceC0592a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.aUR = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gql = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gql.changeSkin(0);
        this.gql.setSkinType(0);
        this.gql.setListPullRefreshListener(this.gyc);
        this.aUR.setPullRefresh(this.gql);
        this.gxZ = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.aUR);
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
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        if (this.gya != null) {
            this.gya.onDestroy();
        }
        if (this.gxZ != null) {
            this.gxZ.onDestroy();
            this.gxZ = null;
        }
        if (this.fAu != null) {
            this.fAu.release();
            this.fAu = null;
        }
        if (this.gql != null) {
            this.gql = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
