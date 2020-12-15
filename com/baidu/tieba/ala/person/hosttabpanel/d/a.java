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
    private BdTypeListView bnh;
    private LoadingView gEM;
    private TbListCommonPullView hJQ;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hJR;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hJS;
    private boolean hJT = false;
    private TbListCommonPullView.ListPullRefreshListener hJU = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hJS != null) {
                a.this.hJS.refreshData();
            }
        }
    };
    private a.InterfaceC0709a hJV = new a.InterfaceC0709a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
    };
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_new_host_tab_view, (ViewGroup) null);
        this.bnh = (BdTypeListView) this.mRootView.findViewById(a.f.list_view);
        this.hJQ = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hJQ.changeSkin(0);
        this.hJQ.setSkinType(0);
        this.hJQ.setListPullRefreshListener(this.hJU);
        this.bnh.setPullRefresh(this.hJQ);
        this.hJR = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bnh);
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
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.hJS != null) {
            this.hJS.onDestroy();
        }
        if (this.hJR != null) {
            this.hJR.onDestroy();
            this.hJR = null;
        }
        if (this.gEM != null) {
            this.gEM.release();
            this.gEM = null;
        }
        if (this.hJQ != null) {
            this.hJQ = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
