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
import com.baidu.tbadk.core.util.bh;
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
    private BdListView Wa;
    private FrameLayout bId;
    private CustomMessageListener eMu;
    private PbListView giV;
    private AlaRecentHistoryActivity gow;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gox;
    private b goy;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gow = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gow).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gow.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bId = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Wa = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gow.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gow.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.Wa.setDivider(colorDrawable);
        this.Wa.setDividerHeight(this.gow.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gow.getUniqueId());
        this.Wa.setPullRefresh(this.mPullView);
        this.giV = new PbListView(this.gow);
        this.giV.createView();
        bOW();
    }

    private void bOW() {
        bOX();
    }

    private void bOX() {
        if (this.mType == 0) {
            this.gox = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gox = new c(this.mPageContext);
            registerListener();
            ((c) this.gox).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.goy = bVar;
                    a.this.a(bVar.evQ.blC(), bVar.isFollow);
                }
            });
        }
        this.Wa.setAdapter((ListAdapter) this.gox);
        this.Wa.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().bLI();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.goy != null) {
                        if (a.this.goy.evQ != null && a.this.goy.evQ.blC() != null) {
                            j = a.this.goy.evQ.blC().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.goy.isFollow = true;
                                if (a.this.gox instanceof c) {
                                    a.this.gox.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.goy.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eMu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            bh.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ViewGroup bOY() {
        return this.bId;
    }

    public void completePullRefresh() {
        this.Wa.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gox instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gox.setData(list);
        } else if (this.gox instanceof c) {
            this.gox.setData(list);
        }
        if (z) {
            bOq();
        } else {
            bOp();
        }
    }

    private void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Wa.setNextPage(this.giV);
            }
            this.giV.setText(this.gow.getPageContext().getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    private void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Wa.setNextPage(this.giV);
            }
            this.giV.showLoadingViewWithoutEmptyView();
            this.giV.startLoadData();
        }
    }

    public void bOZ() {
        this.Wa.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Wa.setOnSrollToBottomListener(eVar);
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
        if (this.eMu != null) {
            MessageManager.getInstance().unRegisterListener(this.eMu);
        }
    }
}
