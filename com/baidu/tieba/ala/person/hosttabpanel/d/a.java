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
    private BdTypeListView bkb;
    private LoadingView gLR;
    private TbListCommonPullView hRv;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hRw;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hRx;
    private TbPageContext mPageContext;
    private View mRootView;
    private boolean hRy = false;
    private TbListCommonPullView.ListPullRefreshListener hRz = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hRx != null) {
                a.this.hRx.refreshData();
            }
        }
    };
    private a.InterfaceC0684a hRA = new a.InterfaceC0684a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.bkb = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hRv = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hRv.changeSkin(0);
        this.hRv.setSkinType(0);
        this.hRv.setListPullRefreshListener(this.hRz);
        this.bkb.setPullRefresh(this.hRv);
        this.hRw = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bkb);
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
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.hRx != null) {
            this.hRx.onDestroy();
        }
        if (this.hRw != null) {
            this.hRw.onDestroy();
            this.hRw = null;
        }
        if (this.gLR != null) {
            this.gLR.release();
            this.gLR = null;
        }
        if (this.hRv != null) {
            this.hRv = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
