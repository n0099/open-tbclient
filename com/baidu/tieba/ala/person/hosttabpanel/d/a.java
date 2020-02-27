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
    private LoadingView ewD;
    private TbListCommonPullView fqR;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a fqS;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a fqT;
    private boolean fqU = false;
    private TbListCommonPullView.ListPullRefreshListener fqV = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fqT != null) {
                a.this.fqT.refreshData();
            }
        }
    };
    private a.InterfaceC0476a fqW = new a.InterfaceC0476a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
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
        this.fqR = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.fqR.changeSkin(0);
        this.fqR.setSkinType(0);
        this.fqR.setListPullRefreshListener(this.fqV);
        this.asG.setPullRefresh(this.fqR);
        this.fqS = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.asG);
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
        if (this.fqT != null) {
            this.fqT.onDestroy();
        }
        if (this.fqS != null) {
            this.fqS.onDestroy();
            this.fqS = null;
        }
        if (this.ewD != null) {
            this.ewD.release();
            this.ewD = null;
        }
        if (this.fqR != null) {
            this.fqR = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
