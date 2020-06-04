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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.tieba.ala.alasquare.recent_history.a.c;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdListView Um;
    private FrameLayout bWe;
    private CustomMessageListener dNP;
    private PbListView fcj;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fhA;
    private b fhB;
    private AlaRecentHistoryActivity fhz;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fhz = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fhz).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fhz.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bWe = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Um = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fhz.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fhz.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Um.setDivider(colorDrawable);
        this.Um.setDividerHeight(this.fhz.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fhz.getUniqueId());
        this.Um.setPullRefresh(this.mPullView);
        this.fcj = new PbListView(this.fhz);
        this.fcj.createView();
        brt();
    }

    private void brt() {
        bru();
    }

    private void bru() {
        if (this.mType == 0) {
            this.fhA = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fhA = new c(this.mPageContext);
            registerListener();
            ((c) this.fhA).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fhB = bVar;
                    a.this.a(bVar.dEA.aQx(), bVar.isFollow);
                }
            });
        }
        this.Um.setAdapter((ListAdapter) this.fhA);
        this.Um.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().bpt();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fhB != null) {
                        if (a.this.fhB.dEA != null && a.this.fhB.dEA.aQx() != null) {
                            j = a.this.fhB.dEA.aQx().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fhB.isFollow = true;
                                if (a.this.fhA instanceof c) {
                                    a.this.fhA.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fhB.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dNP);
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

    public ViewGroup brv() {
        return this.bWe;
    }

    public void completePullRefresh() {
        this.Um.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fhA instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fhA.setData(list);
        } else if (this.fhA instanceof c) {
            this.fhA.setData(list);
        }
        if (z) {
            bqM();
        } else {
            bqL();
        }
    }

    private void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Um.setNextPage(this.fcj);
            }
            this.fcj.setText(this.fhz.getPageContext().getResources().getString(R.string.list_no_more));
            this.fcj.endLoadData();
        }
    }

    private void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Um.setNextPage(this.fcj);
            }
            this.fcj.showLoadingViewWithoutEmptyView();
            this.fcj.startLoadData();
        }
    }

    public void brw() {
        this.Um.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Um.setOnSrollToBottomListener(eVar);
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
        if (this.dNP != null) {
            MessageManager.getInstance().unRegisterListener(this.dNP);
        }
    }
}
