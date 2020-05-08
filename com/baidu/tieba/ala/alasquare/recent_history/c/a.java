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
    private BdListView Ua;
    private FrameLayout bMV;
    private CustomMessageListener dzL;
    private PbListView ePr;
    private AlaRecentHistoryActivity eUG;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a eUH;
    private b eUI;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.eUG = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.eUG).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eUG.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bMV = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Ua = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.eUG.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.eUG.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Ua.setDivider(colorDrawable);
        this.Ua.setDividerHeight(this.eUG.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.eUG.getUniqueId());
        this.Ua.setPullRefresh(this.mPullView);
        this.ePr = new PbListView(this.eUG);
        this.ePr.createView();
        blT();
    }

    private void blT() {
        blU();
    }

    private void blU() {
        if (this.mType == 0) {
            this.eUH = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.eUH = new c(this.mPageContext);
            registerListener();
            ((c) this.eUH).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.eUI = bVar;
                    a.this.a(bVar.dqE.aKC(), bVar.isFollow);
                }
            });
        }
        this.Ua.setAdapter((ListAdapter) this.eUH);
        this.Ua.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().bjX();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.eUI != null) {
                        if (a.this.eUI.dqE != null && a.this.eUI.dqE.aKC() != null) {
                            j = a.this.eUI.dqE.aKC().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.eUI.isFollow = true;
                                if (a.this.eUH instanceof c) {
                                    a.this.eUH.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.eUI.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dzL);
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

    public ViewGroup blV() {
        return this.bMV;
    }

    public void completePullRefresh() {
        this.Ua.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.eUH instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.eUH.setData(list);
        } else if (this.eUH instanceof c) {
            this.eUH.setData(list);
        }
        if (z) {
            blo();
        } else {
            bln();
        }
    }

    private void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Ua.setNextPage(this.ePr);
            }
            this.ePr.setText(this.eUG.getPageContext().getResources().getString(R.string.list_no_more));
            this.ePr.endLoadData();
        }
    }

    private void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Ua.setNextPage(this.ePr);
            }
            this.ePr.showLoadingViewWithoutEmptyView();
            this.ePr.startLoadData();
        }
    }

    public void blW() {
        this.Ua.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Ua.setOnSrollToBottomListener(eVar);
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
        if (this.dzL != null) {
            MessageManager.getInstance().unRegisterListener(this.dzL);
        }
    }
}
