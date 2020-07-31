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
import com.baidu.tbadk.core.util.bf;
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
    private BdListView UL;
    private FrameLayout cbm;
    private CustomMessageListener eaY;
    private PbListView fsC;
    private AlaRecentHistoryActivity fxV;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fxW;
    private b fxX;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fxV = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fxV).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fxV.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.cbm = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.UL = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fxV.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fxV.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.UL.setDivider(colorDrawable);
        this.UL.setDividerHeight(this.fxV.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fxV.getUniqueId());
        this.UL.setPullRefresh(this.mPullView);
        this.fsC = new PbListView(this.fxV);
        this.fsC.createView();
        bxz();
    }

    private void bxz() {
        bxA();
    }

    private void bxA() {
        if (this.mType == 0) {
            this.fxW = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fxW = new c(this.mPageContext);
            registerListener();
            ((c) this.fxW).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fxX = bVar;
                    a.this.a(bVar.dLK.aWl(), bVar.isFollow);
                }
            });
        }
        this.UL.setAdapter((ListAdapter) this.fxW);
        this.UL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().bva();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fxX != null) {
                        if (a.this.fxX.dLK != null && a.this.fxX.dLK.aWl() != null) {
                            j = a.this.fxX.dLK.aWl().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fxX.isFollow = true;
                                if (a.this.fxW instanceof c) {
                                    a.this.fxW.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fxX.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eaY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            bf.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ViewGroup bxB() {
        return this.cbm;
    }

    public void completePullRefresh() {
        this.UL.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fxW instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fxW.setData(list);
        } else if (this.fxW instanceof c) {
            this.fxW.setData(list);
        }
        if (z) {
            bwT();
        } else {
            bwS();
        }
    }

    private void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.UL.setNextPage(this.fsC);
            }
            this.fsC.setText(this.fxV.getPageContext().getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    private void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.UL.setNextPage(this.fsC);
            }
            this.fsC.showLoadingViewWithoutEmptyView();
            this.fsC.startLoadData();
        }
    }

    public void bxC() {
        this.UL.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.UL.setOnSrollToBottomListener(eVar);
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
        if (this.eaY != null) {
            MessageManager.getInstance().unRegisterListener(this.eaY);
        }
    }
}
