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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.tieba.ala.alasquare.recent_history.a.c;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private FrameLayout aLf;
    private CustomMessageListener cji;
    private AlaRecentHistoryActivity dAl;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a dAm;
    private b dAn;
    private PbListView dvS;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private i mPullView;
    private View mRootView;
    private int mType;
    private BdListView xL;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.dAl = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.dAl).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.dAl.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.aLf = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.xL = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.dAl.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.dAl.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.xL.setDivider(colorDrawable);
        this.xL.setDividerHeight(this.dAl.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.dAl.getUniqueId());
        this.xL.setPullRefresh(this.mPullView);
        this.dvS = new PbListView(this.dAl);
        this.dvS.createView();
        aJN();
    }

    private void aJN() {
        aJO();
    }

    private void aJO() {
        if (this.mType == 0) {
            this.dAm = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.dAm = new c(this.mPageContext);
            registerListener();
            ((c) this.dAm).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.dAn = bVar;
                    a.this.a(bVar.caz.aiE(), bVar.isFollow);
                }
            });
        }
        this.xL.setAdapter((ListAdapter) this.dAm);
        this.xL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().aIJ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.dAn != null) {
                        if (a.this.dAn.caz != null && a.this.dAn.caz.aiE() != null) {
                            j = a.this.dAn.caz.aiE().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.dAn.isFollow = true;
                                if (a.this.dAm instanceof c) {
                                    a.this.dAm.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.dAn.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cji);
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

    public ViewGroup aJP() {
        return this.aLf;
    }

    public void completePullRefresh() {
        this.xL.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.dAm instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.dAm.setData(list);
        } else if (this.dAm instanceof c) {
            this.dAm.setData(list);
        }
        if (z) {
            aJj();
        } else {
            aJi();
        }
    }

    private void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.xL.setNextPage(this.dvS);
            }
            this.dvS.setText(this.dAl.getPageContext().getResources().getString(R.string.list_no_more));
            this.dvS.endLoadData();
        }
    }

    private void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.xL.setNextPage(this.dvS);
            }
            this.dvS.showLoadingViewWithoutEmptyView();
            this.dvS.startLoadData();
        }
    }

    public void aJQ() {
        this.xL.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.xL.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(this.mPageContext, i);
        }
    }

    public void onDestroy() {
        if (this.cji != null) {
            MessageManager.getInstance().unRegisterListener(this.cji);
        }
    }
}
