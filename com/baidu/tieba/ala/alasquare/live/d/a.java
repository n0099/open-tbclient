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
    private BdTypeListView duK;
    private NoNetworkView dvR;
    private PbListView dvS;
    private b dvT;
    private h dvU = new h() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bh bhVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.aJM().a(a.this.isSmallFollow, "c12118", i, str, bhVar));
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
        this.dvR = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.dvR.setVisibility(8);
        }
        this.mRootView.addView(this.dvR);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.duK = new BdTypeListView(this.mPageContext.getPageActivity());
        this.duK.setDivider(null);
        this.mContentView.addView(this.duK, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.duK.setPullRefresh(this.mPullView);
        this.dvS = new PbListView(tbPageContext.getPageActivity());
        this.dvS.createView();
        this.dvT = new b(tbPageContext, this.duK);
        this.dvT.a(this.dvU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout aJh() {
        return this.mContentView;
    }

    public void a(List<m> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.dvT.setDatas(list);
        this.dvT.mb(i);
        if (z) {
            aJj();
        } else {
            aJi();
        }
    }

    public void completePullRefresh() {
        this.duK.completePullRefresh();
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dvS.endLoadData();
        }
    }

    public void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.duK.setNextPage(this.dvS);
            }
            this.dvS.showLoadingViewWithoutEmptyView();
            this.dvS.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.duK.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.duK.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.duK.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.dvS.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.dvT.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.dvR.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView aJk() {
        return this.duK;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.dvT.a(iAlaSquareTabController);
    }
}
