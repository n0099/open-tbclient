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
    private LoadingView gEK;
    private TbListCommonPullView hJO;
    private com.baidu.tieba.ala.person.hosttabpanel.a.a hJP;
    private com.baidu.tieba.ala.person.hosttabpanel.c.a hJQ;
    private boolean hJR = false;
    private TbListCommonPullView.ListPullRefreshListener hJS = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.1
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.hJQ != null) {
                a.this.hJQ.refreshData();
            }
        }
    };
    private a.InterfaceC0709a hJT = new a.InterfaceC0709a() { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.a.2
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
        this.hJO = new TbListCommonPullView(this.mPageContext.getPageActivity());
        this.hJO.changeSkin(0);
        this.hJO.setSkinType(0);
        this.hJO.setListPullRefreshListener(this.hJS);
        this.bnh.setPullRefresh(this.hJO);
        this.hJP = new com.baidu.tieba.ala.person.hosttabpanel.a.a(this.mPageContext, this.bnh);
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
        if (this.hJQ != null) {
            this.hJQ.onDestroy();
        }
        if (this.hJP != null) {
            this.hJP.onDestroy();
            this.hJP = null;
        }
        if (this.gEK != null) {
            this.gEK.release();
            this.gEK = null;
        }
        if (this.hJO != null) {
            this.hJO = null;
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
