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
/* loaded from: classes9.dex */
public class a {
    private BdListView WT;
    private FrameLayout bNm;
    private CustomMessageListener eYu;
    private AlaRecentHistoryActivity gDf;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gDg;
    private b gDh;
    private PbListView gxy;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gDf = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gDf).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gDf.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bNm = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.WT = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gDf.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gDf.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.WT.setDivider(colorDrawable);
        this.WT.setDividerHeight(this.gDf.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gDf.getUniqueId());
        this.WT.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(this.gDf);
        this.gxy.createView();
        bRv();
    }

    private void bRv() {
        bRw();
    }

    private void bRw() {
        if (this.mType == 0) {
            this.gDg = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gDg = new c(this.mPageContext);
            registerListener();
            ((c) this.gDg).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gDh = bVar;
                    a.this.a(bVar.eHK.bnx(), bVar.isFollow);
                }
            });
        }
        this.WT.setAdapter((ListAdapter) this.gDg);
        this.WT.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().bOb();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gDh != null) {
                        if (a.this.gDh.eHK != null && a.this.gDh.eHK.bnx() != null) {
                            j = a.this.gDh.eHK.bnx().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gDh.isFollow = true;
                                if (a.this.gDg instanceof c) {
                                    a.this.gDg.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gDh.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eYu);
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

    public ViewGroup bRx() {
        return this.bNm;
    }

    public void completePullRefresh() {
        this.WT.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gDg instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gDg.setData(list);
        } else if (this.gDg instanceof c) {
            this.gDg.setData(list);
        }
        if (z) {
            bQN();
        } else {
            bQM();
        }
    }

    private void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.WT.setNextPage(this.gxy);
            }
            this.gxy.setText(this.gDf.getPageContext().getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    private void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.WT.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void bRy() {
        this.WT.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WT.setOnSrollToBottomListener(eVar);
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
        if (this.eYu != null) {
            MessageManager.getInstance().unRegisterListener(this.eYu);
        }
    }
}
