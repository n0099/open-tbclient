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
    private BdListView AG;
    private FrameLayout bov;
    private CustomMessageListener dae;
    private PbListView eli;
    private AlaRecentHistoryActivity equ;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a eqv;
    private b eqw;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private h mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.equ = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.equ).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.equ.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bov = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.AG = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.equ.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.equ.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.AG.setDivider(colorDrawable);
        this.AG.setDividerHeight(this.equ.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new h(this.mPageContext);
        this.mPullView.setTag(this.equ.getUniqueId());
        this.AG.setPullRefresh(this.mPullView);
        this.eli = new PbListView(this.equ);
        this.eli.createView();
        bcW();
    }

    private void bcW() {
        bcX();
    }

    private void bcX() {
        if (this.mType == 0) {
            this.eqv = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.eqv = new c(this.mPageContext);
            registerListener();
            ((c) this.eqv).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.eqw = bVar;
                    a.this.a(bVar.cRe.aCm(), bVar.isFollow);
                }
            });
        }
        this.AG.setAdapter((ListAdapter) this.eqv);
        this.AG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().bbP();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.eqw != null) {
                        if (a.this.eqw.cRe != null && a.this.eqw.cRe.aCm() != null) {
                            j = a.this.eqw.cRe.aCm().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.eqw.isFollow = true;
                                if (a.this.eqv instanceof c) {
                                    a.this.eqv.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.eqw.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dae);
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

    public ViewGroup bcY() {
        return this.bov;
    }

    public void completePullRefresh() {
        this.AG.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.eqv instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.eqv.setData(list);
        } else if (this.eqv instanceof c) {
            this.eqv.setData(list);
        }
        if (z) {
            bcs();
        } else {
            bcr();
        }
    }

    private void bcr() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.AG.setNextPage(this.eli);
            }
            this.eli.setText(this.equ.getPageContext().getResources().getString(R.string.list_no_more));
            this.eli.endLoadData();
        }
    }

    private void bcs() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.AG.setNextPage(this.eli);
            }
            this.eli.showLoadingViewWithoutEmptyView();
            this.eli.startLoadData();
        }
    }

    public void bcZ() {
        this.AG.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.AG.setOnSrollToBottomListener(eVar);
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
        if (this.dae != null) {
            MessageManager.getInstance().unRegisterListener(this.dae);
        }
    }
}
