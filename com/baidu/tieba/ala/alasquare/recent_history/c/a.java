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
/* loaded from: classes6.dex */
public class a {
    private BdListView WX;
    private FrameLayout bNl;
    private CustomMessageListener eTG;
    private PbListView gre;
    private AlaRecentHistoryActivity gwF;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gwG;
    private b gwH;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gwF = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gwF).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gwF.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bNl = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.WX = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gwF.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gwF.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.WX.setDivider(colorDrawable);
        this.WX.setDividerHeight(this.gwF.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gwF.getUniqueId());
        this.WX.setPullRefresh(this.mPullView);
        this.gre = new PbListView(this.gwF);
        this.gre.createView();
        bSH();
    }

    private void bSH() {
        bSI();
    }

    private void bSI() {
        if (this.mType == 0) {
            this.gwG = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gwG = new c(this.mPageContext);
            registerListener();
            ((c) this.gwG).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gwH = bVar;
                    a.this.a(bVar.eCR.boP(), bVar.isFollow);
                }
            });
        }
        this.WX.setAdapter((ListAdapter) this.gwG);
        this.WX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().bPr();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gwH != null) {
                        if (a.this.gwH.eCR != null && a.this.gwH.eCR.boP() != null) {
                            j = a.this.gwH.eCR.boP().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gwH.isFollow = true;
                                if (a.this.gwG instanceof c) {
                                    a.this.gwG.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gwH.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eTG);
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

    public ViewGroup bSJ() {
        return this.bNl;
    }

    public void completePullRefresh() {
        this.WX.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gwG instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gwG.setData(list);
        } else if (this.gwG instanceof c) {
            this.gwG.setData(list);
        }
        if (z) {
            bSb();
        } else {
            bSa();
        }
    }

    private void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.WX.setNextPage(this.gre);
            }
            this.gre.setText(this.gwF.getPageContext().getResources().getString(R.string.list_no_more));
            this.gre.endLoadData();
        }
    }

    private void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.WX.setNextPage(this.gre);
            }
            this.gre.showLoadingViewWithoutEmptyView();
            this.gre.startLoadData();
        }
    }

    public void bSK() {
        this.WX.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WX.setOnSrollToBottomListener(eVar);
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
        if (this.eTG != null) {
            MessageManager.getInstance().unRegisterListener(this.eTG);
        }
    }
}
