package com.baidu.tieba.ala.alasquare.live.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeListView eOj;
    private NoNetworkView ePq;
    private PbListView ePr;
    private b ePs;
    private i ePt = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.blS().a(a.this.isSmallFollow, "c12118", i, str, bjVar));
            a.this.a(a.this.mPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
        }
    };
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private h mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.ePq = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.ePq.setVisibility(8);
        }
        this.mRootView.addView(this.ePq);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.eOj = new BdTypeListView(this.mPageContext.getPageActivity());
        this.eOj.setDivider(null);
        this.mContentView.addView(this.eOj, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.eOj.setPullRefresh(this.mPullView);
        this.ePr = new PbListView(tbPageContext.getPageActivity());
        this.ePr.createView();
        this.ePs = new b(tbPageContext, this.eOj);
        this.ePs.a(this.ePt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
            alaLiveInfoCoreData.userName = bjVar.aKC().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout blm() {
        return this.mContentView;
    }

    public void c(List<m> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.ePs.setDatas(list);
        this.ePs.oW(i);
        if (z) {
            blo();
        } else {
            bln();
        }
    }

    public void completePullRefresh() {
        this.eOj.completePullRefresh();
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.ePr.endLoadData();
        }
    }

    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.eOj.setNextPage(this.ePr);
            }
            this.ePr.showLoadingViewWithoutEmptyView();
            this.ePr.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.eOj.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.eOj.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eOj.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.ePr.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.ePs.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.ePq.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView blp() {
        return this.eOj;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ePs.a(iAlaSquareTabController);
    }
}
