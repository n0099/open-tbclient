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
/* loaded from: classes10.dex */
public class a {
    private BdListView WV;
    private FrameLayout bRY;
    private CustomMessageListener fdd;
    private PbListView gCf;
    private AlaRecentHistoryActivity gHL;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gHM;
    private b gHN;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gHL = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gHL).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gHL.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bRY = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.WV = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gHL.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gHL.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.WV.setDivider(colorDrawable);
        this.WV.setDividerHeight(this.gHL.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gHL.getUniqueId());
        this.WV.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(this.gHL);
        this.gCf.createView();
        bVn();
    }

    private void bVn() {
        bVo();
    }

    private void bVo() {
        if (this.mType == 0) {
            this.gHM = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gHM = new c(this.mPageContext);
            registerListener();
            ((c) this.gHM).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gHN = bVar;
                    a.this.a(bVar.eMv.brr(), bVar.isFollow);
                }
            });
        }
        this.WV.setAdapter((ListAdapter) this.gHM);
        this.WV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.b.a.bVm().bRT();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gHN != null) {
                        if (a.this.gHN.eMv != null && a.this.gHN.eMv.brr() != null) {
                            j = a.this.gHN.eMv.brr().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gHN.isFollow = true;
                                if (a.this.gHM instanceof c) {
                                    a.this.gHM.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gHN.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fdd);
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

    public ViewGroup bVp() {
        return this.bRY;
    }

    public void completePullRefresh() {
        this.WV.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gHM instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gHM.setData(list);
        } else if (this.gHM instanceof c) {
            this.gHM.setData(list);
        }
        if (z) {
            bUF();
        } else {
            bUE();
        }
    }

    private void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.WV.setNextPage(this.gCf);
            }
            this.gCf.setText(this.gHL.getPageContext().getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    private void bUF() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.WV.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void bVq() {
        this.WV.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WV.setOnSrollToBottomListener(eVar);
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
        if (this.fdd != null) {
            MessageManager.getInstance().unRegisterListener(this.fdd);
        }
    }
}
