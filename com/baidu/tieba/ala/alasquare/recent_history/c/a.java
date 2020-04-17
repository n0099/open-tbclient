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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.tieba.ala.alasquare.recent_history.a.c;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdListView TX;
    private FrameLayout bMQ;
    private CustomMessageListener dzH;
    private PbListView ePm;
    private AlaRecentHistoryActivity eUB;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a eUC;
    private b eUD;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.eUB = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.eUB).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eUB.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bMQ = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.TX = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.eUB.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.eUB.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.TX.setDivider(colorDrawable);
        this.TX.setDividerHeight(this.eUB.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.eUB.getUniqueId());
        this.TX.setPullRefresh(this.mPullView);
        this.ePm = new PbListView(this.eUB);
        this.ePm.createView();
        blV();
    }

    private void blV() {
        blW();
    }

    private void blW() {
        if (this.mType == 0) {
            this.eUC = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.eUC = new c(this.mPageContext);
            registerListener();
            ((c) this.eUC).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.eUD = bVar;
                    a.this.a(bVar.dqA.aKE(), bVar.isFollow);
                }
            });
        }
        this.TX.setAdapter((ListAdapter) this.eUC);
        this.TX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().bjZ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.eUD != null) {
                        if (a.this.eUD.dqA != null && a.this.eUD.dqA.aKE() != null) {
                            j = a.this.eUD.dqA.aKE().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.eUD.isFollow = true;
                                if (a.this.eUC instanceof c) {
                                    a.this.eUC.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.eUD.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dzH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            bc.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ViewGroup blX() {
        return this.bMQ;
    }

    public void completePullRefresh() {
        this.TX.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.eUC instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.eUC.setData(list);
        } else if (this.eUC instanceof c) {
            this.eUC.setData(list);
        }
        if (z) {
            blq();
        } else {
            blp();
        }
    }

    private void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.TX.setNextPage(this.ePm);
            }
            this.ePm.setText(this.eUB.getPageContext().getResources().getString(R.string.list_no_more));
            this.ePm.endLoadData();
        }
    }

    private void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.TX.setNextPage(this.ePm);
            }
            this.ePm.showLoadingViewWithoutEmptyView();
            this.ePm.startLoadData();
        }
    }

    public void blY() {
        this.TX.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.TX.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void onDestroy() {
        if (this.dzH != null) {
            MessageManager.getInstance().unRegisterListener(this.dzH);
        }
    }
}
