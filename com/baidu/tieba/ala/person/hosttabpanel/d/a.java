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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.liveroom.d.d {
    private BdTypeListView boU;
    private LoadingView gQu;
    private TbListCommonPullView hXN;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hXO;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hXP;
    private boolean hXQ = false;
    private TbListCommonPullView.ListPullRefreshListener hXR = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hXP != null) {
                a.this.hXP.refreshData();
            }
        }
    };
    private a.InterfaceC0691a hXS = new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.boU = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hXN = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hXN.changeSkin(0);
        this.hXN.setSkinType(0);
        this.hXN.setListPullRefreshListener(this.hXR);
        this.boU.setPullRefresh(this.hXN);
        this.hXO = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.boU);
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
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.hXP != null) {
            this.hXP.onDestroy();
        }
        if (this.hXO != null) {
            this.hXO.onDestroy();
            this.hXO = null;
        }
        if (this.gQu != null) {
            this.gQu.release();
            this.gQu = null;
        }
        if (this.hXN != null) {
            this.hXN = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
