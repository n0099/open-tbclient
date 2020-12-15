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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView gpZ;
    private NoNetworkView grf;
    private PbListView grg;
    private b grh;
    private i gri = new i() { // from class: com.baidu.tieba.ala.alasquare.live.d.a.1
        @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
        public void a(int i, String str, by byVar) {
            TiebaStatic.log(com.baidu.tieba.ala.alasquare.c.a.bSH().a(a.this.isSmallFollow, "c12118", i, str, byVar));
            a.this.a(a.this.mPageContext, byVar, str);
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
        this.grf = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.isNetWorkAvailable()) {
            this.grf.setVisibility(8);
        }
        this.mRootView.addView(this.grf);
        this.mContentView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.addView(this.mContentView, new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.setPadding(0, 0, 0, 0);
        this.gpZ = new BdTypeListView(this.mPageContext.getPageActivity());
        this.gpZ.setDivider(null);
        this.mContentView.addView(this.gpZ, new FrameLayout.LayoutParams(-1, -1));
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gpZ.setPullRefresh(this.mPullView);
        this.grg = new PbListView(tbPageContext.getPageActivity());
        this.grg.createView();
        this.grh = new b(tbPageContext, this.gpZ);
        this.grh.a(this.gri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, by byVar, String str) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            alaLiveInfoCoreData.userName = byVar.boP().getUserName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, null, "square_live", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public FrameLayout bSa() {
        return this.mContentView;
    }

    public void c(List<q> list, boolean z, int i) {
        if (list == null) {
            list = new LinkedList<>();
        }
        this.isSmallFollow = i;
        this.grh.setDatas(list);
        this.grh.uU(i);
        if (z) {
            bSc();
        } else {
            bSb();
        }
    }

    public void completePullRefresh() {
        this.gpZ.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gpZ.setNextPage(this.grg);
            }
            this.grg.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.grg.endLoadData();
        }
    }

    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.gpZ.setNextPage(this.grg);
            }
            this.grg.showLoadingViewWithoutEmptyView();
            this.grg.startLoadData();
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gpZ.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.d dVar, int i) {
        this.gpZ.setOnScrollStopDelayedListener(dVar, i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gpZ.setOnScrollListener(onScrollListener);
    }

    public void onChangeSkinType(int i) {
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.grg.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.grh.notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.grf.onChangeSkinType(this.mPageContext, i);
    }

    public BdTypeListView bSd() {
        return this.gpZ;
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.grh.a(iAlaSquareTabController);
    }
}
