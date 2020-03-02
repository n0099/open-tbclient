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
    private BdTypeListView asG;
    private LoadingView ewE;
    private TbListCommonPullView fqS;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a fqT;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a fqU;
    private boolean fqV = false;
    private TbListCommonPullView.ListPullRefreshListener fqW = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fqU != null) {
                a.this.fqU.refreshData();
            }
        }
    };
    private a.InterfaceC0476a fqX = new a.InterfaceC0476a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.asG = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.fqS = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.fqS.changeSkin(0);
        this.fqS.setSkinType(0);
        this.fqS.setListPullRefreshListener(this.fqW);
        this.asG.setPullRefresh(this.fqS);
        this.fqT = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.asG);
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
        if (this.fqU != null) {
            this.fqU.onDestroy();
        }
        if (this.fqT != null) {
            this.fqT.onDestroy();
            this.fqT = null;
        }
        if (this.ewE != null) {
            this.ewE.release();
            this.ewE = null;
        }
        if (this.fqS != null) {
            this.fqS = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
