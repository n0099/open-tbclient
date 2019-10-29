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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView dvB;
    private NoNetworkView dwI;
    private PbListView dwJ;
    private b dwK;
    private h dwL = new h() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bh bhVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.aJO().a(a.this.isSmallFollow, "c12118", i, str, bhVar));
            a.this.a(a.this.mPageContext, bhVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(c cVar) {
        }
    };
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private i mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.dwI = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.dwI.setVisibility(8);
        }
        this.mRootView.addView(this.dwI);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.dvB = new BdTypeListView(this.mPageContext.getPageActivity());
        this.dvB.setDivider(null);
        this.mContentView.addView(this.dvB, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.dvB.setPullRefresh(this.mPullView);
        this.dwJ = new PbListView(tbPageContext.getPageActivity());
        this.dwJ.createView();
        this.dwK = new b(tbPageContext, this.dvB);
        this.dwK.a(this.dwL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout aJj() {
        return this.mContentView;
    }

    public void c(List<m> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.dwK.setDatas(list);
        this.dwK.mc(i);
        if (z) {
            aJl();
        } else {
            aJk();
        }
    }

    public void completePullRefresh() {
        this.dvB.completePullRefresh();
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    public void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.dvB.setNextPage(this.dwJ);
            }
            this.dwJ.showLoadingViewWithoutEmptyView();
            this.dwJ.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.dvB.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.dvB.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.dwJ.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.dwK.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.dwI.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView aJm() {
        return this.dvB;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.dwK.a(iAlaSquareTabController);
    }
}
