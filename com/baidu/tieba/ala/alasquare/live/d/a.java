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
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes3.dex */
public class a {
    private BdTypeListView fbb;
    private NoNetworkView fci;
    private PbListView fcj;
    private b fck;
    private i fcl = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bk bkVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.brs().a(a.this.isSmallFollow, "c12118", i, str, bkVar));
            a.this.a(a.this.mPageContext, bkVar, str);
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
        this.fci = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.fci.setVisibility(8);
        }
        this.mRootView.addView(this.fci);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.fbb = new BdTypeListView(this.mPageContext.getPageActivity());
        this.fbb.setDivider(null);
        this.mContentView.addView(this.fbb, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.fbb.setPullRefresh(this.mPullView);
        this.fcj = new PbListView(tbPageContext.getPageActivity());
        this.fcj.createView();
        this.fck = new b(tbPageContext, this.fbb);
        this.fck.a(this.fcl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar, String str) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bqK() {
        return this.mContentView;
    }

    public void c(List<o> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.fck.setDatas(list);
        this.fck.pz(i);
        if (z) {
            bqM();
        } else {
            bqL();
        }
    }

    public void completePullRefresh() {
        this.fbb.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.fcj.endLoadData();
        }
    }

    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.fbb.setNextPage(this.fcj);
            }
            this.fcj.showLoadingViewWithoutEmptyView();
            this.fcj.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.fbb.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.fbb.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fbb.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fcj.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.fck.notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.fci.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bqN() {
        return this.fbb;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fck.a(iAlaSquareTabController);
    }
}
