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
    private BdTypeListView aMl;
    private TbListCommonPullView fWf;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a fWg;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a fWh;
    private boolean fWi = false;
    private TbListCommonPullView.ListPullRefreshListener fWj = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fWh != null) {
                a.this.fWh.refreshData();
            }
        }
    };
    private a.InterfaceC0533a fWk = new a.InterfaceC0533a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private LoadingView fbv;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.aMl = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.fWf = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.fWf.changeSkin(0);
        this.fWf.setSkinType(0);
        this.fWf.setListPullRefreshListener(this.fWj);
        this.aMl.setPullRefresh(this.fWf);
        this.fWg = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.aMl);
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
    public String AS() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
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
        if (this.fWh != null) {
            this.fWh.onDestroy();
        }
        if (this.fWg != null) {
            this.fWg.onDestroy();
            this.fWg = null;
        }
        if (this.fbv != null) {
            this.fbv.release();
            this.fbv = null;
        }
        if (this.fWf != null) {
            this.fWf = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
