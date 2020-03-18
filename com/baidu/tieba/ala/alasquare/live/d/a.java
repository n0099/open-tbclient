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
    private BdTypeListView ekE;
    private NoNetworkView elL;
    private PbListView elM;
    private b elN;
    private i elO = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bj bjVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bdd().a(a.this.isSmallFollow, "c12118", i, str, bjVar));
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
        this.elL = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.elL.setVisibility(8);
        }
        this.mRootView.addView(this.elL);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.ekE = new BdTypeListView(this.mPageContext.getPageActivity());
        this.ekE.setDivider(null);
        this.mContentView.addView(this.ekE, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.ekE.setPullRefresh(this.mPullView);
        this.elM = new PbListView(tbPageContext.getPageActivity());
        this.elM.createView();
        this.elN = new b(tbPageContext, this.ekE);
        this.elN.a(this.elO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCr().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            alaLiveInfoCoreData.userName = bjVar.aCr().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bcx() {
        return this.mContentView;
    }

    public void c(List<m> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.elN.setDatas(list);
        this.elN.oD(i);
        if (z) {
            bcz();
        } else {
            bcy();
        }
    }

    public void completePullRefresh() {
        this.ekE.completePullRefresh();
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.elM.endLoadData();
        }
    }

    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.ekE.setNextPage(this.elM);
            }
            this.elM.showLoadingViewWithoutEmptyView();
            this.elM.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.ekE.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.ekE.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ekE.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.elM.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.elN.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.elL.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bcA() {
        return this.ekE;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.elN.a(iAlaSquareTabController);
    }
}
