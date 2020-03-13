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
    private BdTypeListView asH;
    private LoadingView ewR;
    private TbListCommonPullView frf;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a frg;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a frh;
    private boolean fri = false;
    private TbListCommonPullView.ListPullRefreshListener frj = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.frh != null) {
                a.this.frh.refreshData();
            }
        }
    };
    private a.InterfaceC0476a frk = new a.InterfaceC0476a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.asH = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.frf = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.frf.changeSkin(0);
        this.frf.setSkinType(0);
        this.frf.setListPullRefreshListener(this.frj);
        this.asH.setPullRefresh(this.frf);
        this.frg = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.asH);
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
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
        if (this.frh != null) {
            this.frh.onDestroy();
        }
        if (this.frg != null) {
            this.frg.onDestroy();
            this.frg = null;
        }
        if (this.ewR != null) {
            this.ewR.release();
            this.ewR = null;
        }
        if (this.frf != null) {
            this.frf = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
