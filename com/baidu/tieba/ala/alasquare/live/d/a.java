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
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView gwr;
    private g gxA = new g() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, bz bzVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.b.a.bRu().a(a.this.isSmallFollow, "c12118", i, str, bzVar));
            a.this.a(a.this.mPageContext, bzVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(c cVar) {
        }
    };
    private NoNetworkView gxx;
    private PbListView gxy;
    private b gxz;
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.gxx = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.gxx.setVisibility(8);
        }
        this.mRootView.addView(this.gxx);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.gwr = new BdTypeListView(this.mPageContext.getPageActivity());
        this.gwr.setDivider(null);
        this.mContentView.addView(this.gwr, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gwr.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(tbPageContext.getPageActivity());
        this.gxy.createView();
        this.gxz = new b(tbPageContext, this.gwr);
        this.gxz.a(this.gxA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bQL() {
        return this.mContentView;
    }

    public void c(List<n> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.gxz.setDatas(list);
        this.gxz.tA(i);
        if (z) {
            bQN();
        } else {
            bQM();
        }
    }

    public void completePullRefresh() {
        this.gwr.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.gwr.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gwr.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gxz.notifyDataSetChanged();
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gxx.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bQO() {
        return this.gwr;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gxz.a(iAlaSquareTabController);
    }
}
