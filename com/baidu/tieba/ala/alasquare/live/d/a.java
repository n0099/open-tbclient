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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.a.b;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private NoNetworkView gAv;
    private PbListView gAw;
    private b gAx;
    private g gAy = new g() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(int i, String str, cb cbVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.b.a.bSe().a(a.this.isSmallFollow, "c12118", i, str, cbVar));
            a.this.a(a.this.mPageContext, cbVar, str);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
        public void a(c cVar) {
        }
    };
    private BdTypeListView gzp;
    private int isSmallFollow;
    private FrameLayout mContentView;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private LinearLayout mRootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        this.mPageContext = tbPageContext;
        this.mRootView = new LinearLayout(tbPageContext.getPageActivity());
        this.mRootView.setOrientation(1);
        this.gAv = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.gAv.setVisibility(8);
        }
        this.mRootView.addView(this.gAv);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.gzp = new BdTypeListView(this.mPageContext.getPageActivity());
        this.gzp.setDivider(null);
        this.mContentView.addView(this.gzp, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gzp.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(tbPageContext.getPageActivity());
        this.gAw.createView();
        this.gAx = new b(tbPageContext, this.gzp);
        this.gAx.a(this.gAy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar, String str) {
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bRw() {
        return this.mContentView;
    }

    public void c(List<n> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.gAx.setDatas(list);
        this.gAx.tG(i);
        if (z) {
            bRy();
        } else {
            bRx();
        }
    }

    public void completePullRefresh() {
        this.gzp.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.gzp.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gzp.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gAx.notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gAv.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bRz() {
        return this.gzp;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gAx.a(iAlaSquareTabController);
    }
}
