package com.baidu.tieba.ala.alasquare.recent_history.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.tieba.ala.alasquare.recent_history.a.c;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView Vo;
    private FrameLayout chl;
    private CustomMessageListener ekL;
    private PbListView fEa;
    private AlaRecentHistoryActivity fJr;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fJs;
    private b fJt;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fJr = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fJr).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fJr.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.chl = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Vo = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fJr.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fJr.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Vo.setDivider(colorDrawable);
        this.Vo.setDividerHeight(this.fJr.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fJr.getUniqueId());
        this.Vo.setPullRefresh(this.mPullView);
        this.fEa = new PbListView(this.fJr);
        this.fEa.createView();
        bGz();
    }

    private void bGz() {
        bGA();
    }

    private void bGA() {
        if (this.mType == 0) {
            this.fJs = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fJs = new c(this.mPageContext);
            registerListener();
            ((c) this.fJs).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fJt = bVar;
                    a.this.a(bVar.dUW.beE(), bVar.isFollow);
                }
            });
        }
        this.Vo.setAdapter((ListAdapter) this.fJs);
        this.Vo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().bDW();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fJt != null) {
                        if (a.this.fJt.dUW != null && a.this.fJt.dUW.beE() != null) {
                            j = a.this.fJt.dUW.beE().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fJt.isFollow = true;
                                if (a.this.fJs instanceof c) {
                                    a.this.fJs.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fJt.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ekL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            bg.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ViewGroup bGB() {
        return this.chl;
    }

    public void completePullRefresh() {
        this.Vo.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fJs instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fJs.setData(list);
        } else if (this.fJs instanceof c) {
            this.fJs.setData(list);
        }
        if (z) {
            bFT();
        } else {
            bFS();
        }
    }

    private void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Vo.setNextPage(this.fEa);
            }
            this.fEa.setText(this.fJr.getPageContext().getResources().getString(R.string.list_no_more));
            this.fEa.endLoadData();
        }
    }

    private void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Vo.setNextPage(this.fEa);
            }
            this.fEa.showLoadingViewWithoutEmptyView();
            this.fEa.startLoadData();
        }
    }

    public void bGC() {
        this.Vo.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Vo.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void onDestroy() {
        if (this.ekL != null) {
            MessageManager.getInstance().unRegisterListener(this.ekL);
        }
    }
}
