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
/* loaded from: classes10.dex */
public class a {
    private BdListView WO;
    private FrameLayout bRc;
    private CustomMessageListener faJ;
    private PbListView gAw;
    private AlaRecentHistoryActivity gGd;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gGe;
    private b gGf;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gGd = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gGd).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gGd.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bRc = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.WO = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gGd.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
        } else {
            colorDrawable = new ColorDrawable(this.gGd.getPageContext().getResources().getColor(R.color.CAM_X0204));
        }
        this.WO.setDivider(colorDrawable);
        this.WO.setDividerHeight(this.gGd.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gGd.getUniqueId());
        this.WO.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(this.gGd);
        this.gAw.createView();
        bSf();
    }

    private void bSf() {
        bSg();
    }

    private void bSg() {
        if (this.mType == 0) {
            this.gGe = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gGe = new c(this.mPageContext);
            registerListener();
            ((c) this.gGe).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gGf = bVar;
                    a.this.a(bVar.eJQ.bnQ(), bVar.isFollow);
                }
            });
        }
        this.WO.setAdapter((ListAdapter) this.gGe);
        this.WO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().bOM();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gGf != null) {
                        if (a.this.gGf.eJQ != null && a.this.gGf.eJQ.bnQ() != null) {
                            j = a.this.gGf.eJQ.bnQ().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gGf.isFollow = true;
                                if (a.this.gGe instanceof c) {
                                    a.this.gGe.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gGf.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.faJ);
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

    public ViewGroup bSh() {
        return this.bRc;
    }

    public void completePullRefresh() {
        this.WO.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gGe instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gGe.setData(list);
        } else if (this.gGe instanceof c) {
            this.gGe.setData(list);
        }
        if (z) {
            bRy();
        } else {
            bRx();
        }
    }

    private void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.WO.setNextPage(this.gAw);
            }
            this.gAw.setText(this.gGd.getPageContext().getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    private void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.WO.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void bSi() {
        this.WO.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WO.setOnSrollToBottomListener(eVar);
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
        if (this.faJ != null) {
            MessageManager.getInstance().unRegisterListener(this.faJ);
        }
    }
}
