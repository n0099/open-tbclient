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
    private BdTypeListView agA;
    private LoadingView dFe;
    private TbListCommonPullView etH;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a etI;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a etJ;
    private boolean etK = false;
    private TbListCommonPullView.ListPullRefreshListener etL = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.etJ != null) {
                a.this.etJ.refreshData();
            }
        }
    };
    private a.InterfaceC0380a etM = new a.InterfaceC0380a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.agA = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.etH = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.etH.changeSkin(0);
        this.etH.setSkinType(0);
        this.etH.setListPullRefreshListener(this.etL);
        this.agA.setPullRefresh(this.etH);
        this.etI = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.agA);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
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
        if (this.etJ != null) {
            this.etJ.onDestroy();
        }
        if (this.etI != null) {
            this.etI.onDestroy();
            this.etI = null;
        }
        if (this.dFe != null) {
            this.dFe.release();
            this.dFe = null;
        }
        if (this.etH != null) {
            this.etH = null;
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
