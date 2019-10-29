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
    private FrameLayout aLx;
    private CustomMessageListener cjZ;
    private AlaRecentHistoryActivity dBc;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a dBd;
    private b dBe;
    private PbListView dwJ;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private i mPullView;
    private View mRootView;
    private int mType;
    private BdListView yl;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.dBc = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.dBc).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.dBc.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.aLx = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.yl = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.dBc.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.dBc.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.yl.setDivider(colorDrawable);
        this.yl.setDividerHeight(this.dBc.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new i(this.mPageContext);
        this.mPullView.setTag(this.dBc.getUniqueId());
        this.yl.setPullRefresh(this.mPullView);
        this.dwJ = new PbListView(this.dBc);
        this.dwJ.createView();
        aJP();
    }

    private void aJP() {
        aJQ();
    }

    private void aJQ() {
        if (this.mType == 0) {
            this.dBd = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.dBd = new c(this.mPageContext);
            registerListener();
            ((c) this.dBd).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.dBe = bVar;
                    a.this.a(bVar.cbq.aiG(), bVar.isFollow);
                }
            });
        }
        this.yl.setAdapter((ListAdapter) this.dBd);
        this.yl.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().aIL();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.dBe != null) {
                        if (a.this.dBe.cbq != null && a.this.dBe.cbq.aiG() != null) {
                            j = a.this.dBe.cbq.aiG().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.dBe.isFollow = true;
                                if (a.this.dBd instanceof c) {
                                    a.this.dBd.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.dBe.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.cjZ);
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

    public ViewGroup aJR() {
        return this.aLx;
    }

    public void completePullRefresh() {
        this.yl.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.dBd instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.dBd.setData(list);
        } else if (this.dBd instanceof c) {
            this.dBd.setData(list);
        }
        if (z) {
            aJl();
        } else {
            aJk();
        }
    }

    private void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.yl.setNextPage(this.dwJ);
            }
            this.dwJ.setText(this.dBc.getPageContext().getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    private void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.yl.setNextPage(this.dwJ);
            }
            this.dwJ.showLoadingViewWithoutEmptyView();
            this.dwJ.startLoadData();
        }
    }

    public void aJS() {
        this.yl.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.yl.setOnSrollToBottomListener(eVar);
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
        if (this.cjZ != null) {
            MessageManager.getInstance().unRegisterListener(this.cjZ);
        }
    }
}
