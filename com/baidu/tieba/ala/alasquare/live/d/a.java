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
import com.baidu.tbadk.core.data.bw;
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
    private BdTypeListView fCP;
    private NoNetworkView fDV;
    private PbListView fDW;
    private b fDX;
    private i fDY = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bGx().a(a.this.isSmallFollow, "c12118", i, str, bwVar));
            a.this.a(a.this.mPageContext, bwVar, str);
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
        this.fDV = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.fDV.setVisibility(8);
        }
        this.mRootView.addView(this.fDV);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.fCP = new BdTypeListView(this.mPageContext.getPageActivity());
        this.fCP.setDivider(null);
        this.mContentView.addView(this.fCP, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.fCP.setPullRefresh(this.mPullView);
        this.fDW = new PbListView(tbPageContext.getPageActivity());
        this.fDW.createView();
        this.fDX = new b(tbPageContext, this.fCP);
        this.fDX.a(this.fDY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bFQ() {
        return this.mContentView;
    }

    public void c(List<q> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.fDX.setDatas(list);
        this.fDX.sz(i);
        if (z) {
            bFS();
        } else {
            bFR();
        }
    }

    public void completePullRefresh() {
        this.fCP.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fDW.endLoadData();
        }
    }

    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.fCP.setNextPage(this.fDW);
            }
            this.fDW.showLoadingViewWithoutEmptyView();
            this.fDW.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.fCP.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.fCP.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fCP.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fDW.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.fDX.notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.fDV.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bFT() {
        return this.fCP;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fDX.a(iAlaSquareTabController);
    }
}
