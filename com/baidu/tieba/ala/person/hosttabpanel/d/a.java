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
    private BdTypeListView biP;
    private LoadingView gwb;
    private TbListCommonPullView hAj;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hAk;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hAl;
    private boolean hAm = false;
    private TbListCommonPullView.ListPullRefreshListener hAn = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hAl != null) {
                a.this.hAl.refreshData();
            }
        }
    };
    private a.InterfaceC0696a hAo = new a.InterfaceC0696a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.biP = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hAj = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hAj.changeSkin(0);
        this.hAj.setSkinType(0);
        this.hAj.setListPullRefreshListener(this.hAn);
        this.biP.setPullRefresh(this.hAj);
        this.hAk = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.biP);
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
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.hAl != null) {
            this.hAl.onDestroy();
        }
        if (this.hAk != null) {
            this.hAk.onDestroy();
            this.hAk = null;
        }
        if (this.gwb != null) {
            this.gwb.release();
            this.gwb = null;
        }
        if (this.hAj != null) {
            this.hAj = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
