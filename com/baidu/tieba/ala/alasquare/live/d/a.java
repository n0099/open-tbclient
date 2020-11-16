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
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeListView ghN;
    private NoNetworkView giU;
    private PbListView giV;
    private b giW;
    private i giX = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bx bxVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bOV().a(a.this.isSmallFollow, "c12118", i, str, bxVar));
            a.this.a(a.this.mPageContext, bxVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(c cVar) {
        }
    };
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private g mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.giU = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.giU.setVisibility(8);
        }
        this.mRootView.addView(this.giU);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.ghN = new BdTypeListView(this.mPageContext.getPageActivity());
        this.ghN.setDivider(null);
        this.mContentView.addView(this.ghN, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.ghN.setPullRefresh(this.mPullView);
        this.giV = new PbListView(tbPageContext.getPageActivity());
        this.giV.createView();
        this.giW = new b(tbPageContext, this.ghN);
        this.giW.a(this.giX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bx bxVar, String str) {
        if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bxVar.blC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            alaLiveInfoCoreData.userName = bxVar.blC().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bOo() {
        return this.mContentView;
    }

    public void c(List<q> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.giW.setDatas(list);
        this.giW.uq(i);
        if (z) {
            bOq();
        } else {
            bOp();
        }
    }

    public void completePullRefresh() {
        this.ghN.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.ghN.setNextPage(this.giV);
            }
            this.giV.showLoadingViewWithoutEmptyView();
            this.giV.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.ghN.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.ghN.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ghN.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.giV.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.giW.notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.giU.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bOr() {
        return this.ghN;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.giW.a(iAlaSquareTabController);
    }
}
