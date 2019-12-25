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
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeListView efM;
    private NoNetworkView egT;
    private PbListView egU;
    private b egV;
    private h egW = new h() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(int i, String str, bj bjVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bal().a(a.this.isSmallFollow, "c12118", i, str, bjVar));
            a.this.a(a.this.mPageContext, bjVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
        public void a(c cVar) {
        }
    };
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.egT = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.egT.setVisibility(8);
        }
        this.mRootView.addView(this.egT);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.efM = new BdTypeListView(this.mPageContext.getPageActivity());
        this.efM.setDivider(null);
        this.mContentView.addView(this.efM, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.efM.setPullRefresh(this.mPullView);
        this.egU = new PbListView(tbPageContext.getPageActivity());
        this.egU.createView();
        this.egV = new b(tbPageContext, this.efM);
        this.egV.a(this.egW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.azE() != null && bjVar.azX() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
            alaLiveInfoCoreData.userName = bjVar.azE().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout aZF() {
        return this.mContentView;
    }

    public void e(List<m> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.egV.setDatas(list);
        this.egV.ok(i);
        if (z) {
            aZH();
        } else {
            aZG();
        }
    }

    public void completePullRefresh() {
        this.efM.completePullRefresh();
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.egU.endLoadData();
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.efM.setNextPage(this.egU);
            }
            this.egU.showLoadingViewWithoutEmptyView();
            this.egU.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.efM.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.efM.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.efM.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.egU.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.egV.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.egT.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView aZI() {
        return this.efM;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.egV.a(iAlaSquareTabController);
    }
}
