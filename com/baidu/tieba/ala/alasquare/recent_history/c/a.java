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
/* loaded from: classes2.dex */
public class a {
    private BdListView Ak;
    private FrameLayout bjw;
    private CustomMessageListener cVS;
    private PbListView egU;
    private AlaRecentHistoryActivity elk;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a ell;
    private b elm;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.elk = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.elk).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.elk.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bjw = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Ak = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.elk.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.elk.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Ak.setDivider(colorDrawable);
        this.Ak.setDividerHeight(this.elk.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.elk.getUniqueId());
        this.Ak.setPullRefresh(this.mPullView);
        this.egU = new PbListView(this.elk);
        this.egU.createView();
        bam();
    }

    private void bam() {
        ban();
    }

    private void ban() {
        if (this.mType == 0) {
            this.ell = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.ell = new c(this.mPageContext);
            registerListener();
            ((c) this.ell).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.elm = bVar;
                    a.this.a(bVar.cMR.azE(), bVar.isFollow);
                }
            });
        }
        this.Ak.setAdapter((ListAdapter) this.ell);
        this.Ak.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().aZg();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.elm != null) {
                        if (a.this.elm.cMR != null && a.this.elm.cMR.azE() != null) {
                            j = a.this.elm.cMR.azE().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.elm.isFollow = true;
                                if (a.this.ell instanceof c) {
                                    a.this.ell.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.elm.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cVS);
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

    public ViewGroup bao() {
        return this.bjw;
    }

    public void completePullRefresh() {
        this.Ak.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.ell instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.ell.setData(list);
        } else if (this.ell instanceof c) {
            this.ell.setData(list);
        }
        if (z) {
            aZH();
        } else {
            aZG();
        }
    }

    private void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Ak.setNextPage(this.egU);
            }
            this.egU.setText(this.elk.getPageContext().getResources().getString(R.string.list_no_more));
            this.egU.endLoadData();
        }
    }

    private void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Ak.setNextPage(this.egU);
            }
            this.egU.showLoadingViewWithoutEmptyView();
            this.egU.startLoadData();
        }
    }

    public void bap() {
        this.Ak.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Ak.setOnSrollToBottomListener(eVar);
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
        if (this.cVS != null) {
            MessageManager.getInstance().unRegisterListener(this.cVS);
        }
    }
}
