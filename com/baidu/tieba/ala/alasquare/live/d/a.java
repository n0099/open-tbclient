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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
    private BdTypeListView frv;
    private NoNetworkView fsB;
    private PbListView fsC;
    private b fsD;
    private i fsE = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bv bvVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bxy().a(a.this.isSmallFollow, "c12118", i, str, bvVar));
            a.this.a(a.this.mPageContext, bvVar, str);
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
        this.fsB = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.fsB.setVisibility(8);
        }
        this.mRootView.addView(this.fsB);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.frv = new BdTypeListView(this.mPageContext.getPageActivity());
        this.frv.setDivider(null);
        this.mContentView.addView(this.frv, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.frv.setPullRefresh(this.mPullView);
        this.fsC = new PbListView(tbPageContext.getPageActivity());
        this.fsC.createView();
        this.fsD = new b(tbPageContext, this.frv);
        this.fsD.a(this.fsE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bv bvVar, String str) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bwR() {
        return this.mContentView;
    }

    public void c(List<q> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.fsD.setDatas(list);
        this.fsD.qn(i);
        if (z) {
            bwT();
        } else {
            bwS();
        }
    }

    public void completePullRefresh() {
        this.frv.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.frv.setNextPage(this.fsC);
            }
            this.fsC.showLoadingViewWithoutEmptyView();
            this.fsC.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.frv.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.frv.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fsC.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.fsD.notifyDataSetChanged();
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.fsB.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bwU() {
        return this.frv;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fsD.a(iAlaSquareTabController);
    }
}
