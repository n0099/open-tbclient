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
/* loaded from: classes9.dex */
public class a {
    private BdListView Yj;
    private FrameLayout bSC;
    private CustomMessageListener fci;
    private PbListView gCf;
    private AlaRecentHistoryActivity gHM;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gHN;
    private b gHO;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gHM = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gHM).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gHM.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bSC = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Yj = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gHM.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gHM.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.Yj.setDivider(colorDrawable);
        this.Yj.setDividerHeight(this.gHM.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gHM.getUniqueId());
        this.Yj.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.gHM);
        this.gCf.createView();
        bSl();
    }

    private void bSl() {
        bSm();
    }

    private void bSm() {
        if (this.mType == 0) {
            this.gHN = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gHN = new c(this.mPageContext);
            registerListener();
            ((c) this.gHN).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gHO = bVar;
                    a.this.a(bVar.eLr.bnS(), bVar.isFollow);
                }
            });
        }
        this.Yj.setAdapter((ListAdapter) this.gHN);
        this.Yj.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().bOS();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gHO != null) {
                        if (a.this.gHO.eLr != null && a.this.gHO.eLr.bnS() != null) {
                            j = a.this.gHO.eLr.bnS().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gHO.isFollow = true;
                                if (a.this.gHN instanceof c) {
                                    a.this.gHN.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gHO.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fci);
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

    public ViewGroup bSn() {
        return this.bSC;
    }

    public void completePullRefresh() {
        this.Yj.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gHN instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gHN.setData(list);
        } else if (this.gHN instanceof c) {
            this.gHN.setData(list);
        }
        if (z) {
            bRE();
        } else {
            bRD();
        }
    }

    private void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yj.setNextPage(this.gCf);
            }
            this.gCf.setText(this.gHM.getPageContext().getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    private void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yj.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void bSo() {
        this.Yj.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Yj.setOnSrollToBottomListener(eVar);
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
        if (this.fci != null) {
            MessageManager.getInstance().unRegisterListener(this.fci);
        }
    }
}
