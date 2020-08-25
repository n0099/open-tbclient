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
/* loaded from: classes4.dex */
public class a {
    private BdListView Vo;
    private FrameLayout chh;
    private CustomMessageListener ekH;
    private PbListView fDW;
    private AlaRecentHistoryActivity fJn;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fJo;
    private b fJp;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fJn = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fJn).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fJn.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.chh = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.Vo = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fJn.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fJn.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.Vo.setDivider(colorDrawable);
        this.Vo.setDividerHeight(this.fJn.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fJn.getUniqueId());
        this.Vo.setPullRefresh(this.mPullView);
        this.fDW = new PbListView(this.fJn);
        this.fDW.createView();
        bGy();
    }

    private void bGy() {
        bGz();
    }

    private void bGz() {
        if (this.mType == 0) {
            this.fJo = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fJo = new c(this.mPageContext);
            registerListener();
            ((c) this.fJo).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fJp = bVar;
                    a.this.a(bVar.dUS.beE(), bVar.isFollow);
                }
            });
        }
        this.Vo.setAdapter((ListAdapter) this.fJo);
        this.Vo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().bDV();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fJp != null) {
                        if (a.this.fJp.dUS != null && a.this.fJp.dUS.beE() != null) {
                            j = a.this.fJp.dUS.beE().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fJp.isFollow = true;
                                if (a.this.fJo instanceof c) {
                                    a.this.fJo.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fJp.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ekH);
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

    public ViewGroup bGA() {
        return this.chh;
    }

    public void completePullRefresh() {
        this.Vo.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fJo instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fJo.setData(list);
        } else if (this.fJo instanceof c) {
            this.fJo.setData(list);
        }
        if (z) {
            bFS();
        } else {
            bFR();
        }
    }

    private void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Vo.setNextPage(this.fDW);
            }
            this.fDW.setText(this.fJn.getPageContext().getResources().getString(R.string.list_no_more));
            this.fDW.endLoadData();
        }
    }

    private void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Vo.setNextPage(this.fDW);
            }
            this.fDW.showLoadingViewWithoutEmptyView();
            this.fDW.startLoadData();
        }
    }

    public void bGB() {
        this.Vo.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Vo.setOnSrollToBottomListener(eVar);
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
        if (this.ekH != null) {
            MessageManager.getInstance().unRegisterListener(this.ekH);
        }
    }
}
