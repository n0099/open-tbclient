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
    private BdTypeListView aSl;
    private LoadingView fpi;
    private TbListCommonPullView gdr;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a gll;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a glm;
    private boolean gln = false;
    private TbListCommonPullView.ListPullRefreshListener glo = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.glm != null) {
                a.this.glm.refreshData();
            }
        }
    };
    private a.InterfaceC0583a glp = new a.InterfaceC0583a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.aSl = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.gdr = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.gdr.changeSkin(0);
        this.gdr.setSkinType(0);
        this.gdr.setListPullRefreshListener(this.glo);
        this.aSl.setPullRefresh(this.gdr);
        this.gll = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.aSl);
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
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        if (this.glm != null) {
            this.glm.onDestroy();
        }
        if (this.gll != null) {
            this.gll.onDestroy();
            this.gll = null;
        }
        if (this.fpi != null) {
            this.fpi.release();
            this.fpi = null;
        }
        if (this.gdr != null) {
            this.gdr = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
