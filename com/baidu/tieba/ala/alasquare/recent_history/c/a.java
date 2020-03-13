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
    private BdListView AG;
    private FrameLayout box;
    private CustomMessageListener dag;
    private PbListView elw;
    private AlaRecentHistoryActivity eqI;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a eqJ;
    private b eqK;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.eqI = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.eqI).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eqI.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.box = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.AG = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.eqI.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.eqI.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.AG.setDivider(colorDrawable);
        this.AG.setDividerHeight(this.eqI.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.eqI.getUniqueId());
        this.AG.setPullRefresh(this.mPullView);
        this.elw = new PbListView(this.eqI);
        this.elw.createView();
        bcZ();
    }

    private void bcZ() {
        bda();
    }

    private void bda() {
        if (this.mType == 0) {
            this.eqJ = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.eqJ = new c(this.mPageContext);
            registerListener();
            ((c) this.eqJ).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.eqK = bVar;
                    a.this.a(bVar.cRg.aCo(), bVar.isFollow);
                }
            });
        }
        this.AG.setAdapter((ListAdapter) this.eqJ);
        this.AG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().bbS();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.eqK != null) {
                        if (a.this.eqK.cRg != null && a.this.eqK.cRg.aCo() != null) {
                            j = a.this.eqK.cRg.aCo().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.eqK.isFollow = true;
                                if (a.this.eqJ instanceof c) {
                                    a.this.eqJ.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.eqK.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dag);
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

    public ViewGroup bdb() {
        return this.box;
    }

    public void completePullRefresh() {
        this.AG.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.eqJ instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.eqJ.setData(list);
        } else if (this.eqJ instanceof c) {
            this.eqJ.setData(list);
        }
        if (z) {
            bcv();
        } else {
            bcu();
        }
    }

    private void bcu() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.AG.setNextPage(this.elw);
            }
            this.elw.setText(this.eqI.getPageContext().getResources().getString(R.string.list_no_more));
            this.elw.endLoadData();
        }
    }

    private void bcv() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.AG.setNextPage(this.elw);
            }
            this.elw.showLoadingViewWithoutEmptyView();
            this.elw.startLoadData();
        }
    }

    public void bdc() {
        this.AG.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.AG.setOnSrollToBottomListener(eVar);
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
        if (this.dag != null) {
            MessageManager.getInstance().unRegisterListener(this.dag);
        }
    }
}
