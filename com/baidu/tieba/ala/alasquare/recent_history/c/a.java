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
    private BdListView Ao;
    private FrameLayout bkl;
    private CustomMessageListener cWc;
    private PbListView ehe;
    private AlaRecentHistoryActivity emg;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a emh;
    private b emi;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.emg = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.emg).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.emg.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bkl = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Ao = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.emg.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.emg.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Ao.setDivider(colorDrawable);
        this.Ao.setDividerHeight(this.emg.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.emg.getUniqueId());
        this.Ao.setPullRefresh(this.mPullView);
        this.ehe = new PbListView(this.emg);
        this.ehe.createView();
        baH();
    }

    private void baH() {
        baI();
    }

    private void baI() {
        if (this.mType == 0) {
            this.emh = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.emh = new c(this.mPageContext);
            registerListener();
            ((c) this.emh).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.emi = bVar;
                    a.this.a(bVar.cNb.azX(), bVar.isFollow);
                }
            });
        }
        this.Ao.setAdapter((ListAdapter) this.emh);
        this.Ao.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().aZA();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.emi != null) {
                        if (a.this.emi.cNb != null && a.this.emi.cNb.azX() != null) {
                            j = a.this.emi.cNb.azX().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.emi.isFollow = true;
                                if (a.this.emh instanceof c) {
                                    a.this.emh.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.emi.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cWc);
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

    public ViewGroup baJ() {
        return this.bkl;
    }

    public void completePullRefresh() {
        this.Ao.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.emh instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.emh.setData(list);
        } else if (this.emh instanceof c) {
            this.emh.setData(list);
        }
        if (z) {
            bac();
        } else {
            bab();
        }
    }

    private void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Ao.setNextPage(this.ehe);
            }
            this.ehe.setText(this.emg.getPageContext().getResources().getString(R.string.list_no_more));
            this.ehe.endLoadData();
        }
    }

    private void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Ao.setNextPage(this.ehe);
            }
            this.ehe.showLoadingViewWithoutEmptyView();
            this.ehe.startLoadData();
        }
    }

    public void baK() {
        this.Ao.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Ao.setOnSrollToBottomListener(eVar);
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
        if (this.cWc != null) {
            MessageManager.getInstance().unRegisterListener(this.cWc);
        }
    }
}
