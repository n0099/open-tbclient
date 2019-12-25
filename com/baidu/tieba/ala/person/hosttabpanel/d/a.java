package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.hosttabpanel.c.a;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private BdTypeListView aoB;
    private LoadingView erh;
    private TbListCommonPullView fld;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a fle;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a flf;
    private boolean flg = false;
    private TbListCommonPullView.ListPullRefreshListener flh = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.flf != null) {
                a.this.flf.refreshData();
            }
        }
    };
    private a.InterfaceC0464a fli = new a.InterfaceC0464a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.aoB = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.fld = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.fld.changeSkin(0);
        this.fld.setSkinType(0);
        this.fld.setListPullRefreshListener(this.flh);
        this.aoB.setPullRefresh(this.fld);
        this.fle = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.aoB);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
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
        if (this.flf != null) {
            this.flf.onDestroy();
        }
        if (this.fle != null) {
            this.fle.onDestroy();
            this.fle = null;
        }
        if (this.erh != null) {
            this.erh.release();
            this.erh = null;
        }
        if (this.fld != null) {
            this.fld = null;
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
