package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.person.hosttabpanel.c.a;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.liveroom.c.d {
    private BdTypeListView apn;
    private LoadingView est;
    private TbListCommonPullView fon;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a foo;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a fop;
    private boolean foq = false;

    /* renamed from: for  reason: not valid java name */
    private TbListCommonPullView.ListPullRefreshListener f3for = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fop != null) {
                a.this.fop.refreshData();
            }
        }
    };
    private a.InterfaceC0468a fos = new a.InterfaceC0468a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_new_host_tab_view, (ViewGroup) null);
        this.apn = (BdTypeListView) this.mRootView.findViewById(a.g.list_view);
        this.fon = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.fon.changeSkin(0);
        this.fon.setSkinType(0);
        this.fon.setListPullRefreshListener(this.f3for);
        this.apn.setPullRefresh(this.fon);
        this.foo = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.apn);
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext != null ? this.mPageContext.getString(a.i.ala_host_tab_title) : "";
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
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
        if (this.fop != null) {
            this.fop.onDestroy();
        }
        if (this.foo != null) {
            this.foo.onDestroy();
            this.foo = null;
        }
        if (this.est != null) {
            this.est.release();
            this.est = null;
        }
        if (this.fon != null) {
            this.fon = null;
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
