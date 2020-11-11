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
    private BdTypeListView gih;
    private NoNetworkView gjn;
    private PbListView gjo;
    private b gjp;
    private i gjq = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, bw bwVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bPC().a(a.this.isSmallFollow, "c12118", i, str, bwVar));
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
        this.gjn = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.gjn.setVisibility(8);
        }
        this.mRootView.addView(this.gjn);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.gih = new BdTypeListView(this.mPageContext.getPageActivity());
        this.gih.setDivider(null);
        this.mContentView.addView(this.gih, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gih.setPullRefresh(this.mPullView);
        this.gjo = new PbListView(tbPageContext.getPageActivity());
        this.gjo.createView();
        this.gjp = new b(tbPageContext, this.gih);
        this.gjp.a(this.gjq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bOV() {
        return this.mContentView;
    }

    public void c(List<q> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.gjp.setDatas(list);
        this.gjp.tS(i);
        if (z) {
            bOX();
        } else {
            bOW();
        }
    }

    public void completePullRefresh() {
        this.gih.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gjo.endLoadData();
        }
    }

    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.gih.setNextPage(this.gjo);
            }
            this.gjo.showLoadingViewWithoutEmptyView();
            this.gjo.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.gih.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gih.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gjo.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.gjp.notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.gjn.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bOY() {
        return this.gih;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gjp.a(iAlaSquareTabController);
    }
}
