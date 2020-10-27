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
    private BdListView VY;
    private FrameLayout bEh;
    private CustomMessageListener eHG;
    private PbListView gdy;
    private AlaRecentHistoryActivity gjc;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a gjd;
    private b gje;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.gjc = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.gjc).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.gjc.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bEh = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.VY = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.gjc.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.gjc.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.VY.setDivider(colorDrawable);
        this.VY.setDividerHeight(this.gjc.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.gjc.getUniqueId());
        this.VY.setPullRefresh(this.mPullView);
        this.gdy = new PbListView(this.gjc);
        this.gdy.createView();
        bNd();
    }

    private void bNd() {
        bNe();
    }

    private void bNe() {
        if (this.mType == 0) {
            this.gjd = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.gjd = new c(this.mPageContext);
            registerListener();
            ((c) this.gjd).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.gje = bVar;
                    a.this.a(bVar.erH.bka(), bVar.isFollow);
                }
            });
        }
        this.VY.setAdapter((ListAdapter) this.gjd);
        this.VY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().bJQ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.gje != null) {
                        if (a.this.gje.erH != null && a.this.gje.erH.bka() != null) {
                            j = a.this.gje.erH.bka().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.gje.isFollow = true;
                                if (a.this.gjd instanceof c) {
                                    a.this.gjd.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.gje.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eHG);
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

    public ViewGroup bNf() {
        return this.bEh;
    }

    public void completePullRefresh() {
        this.VY.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.gjd instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.gjd.setData(list);
        } else if (this.gjd instanceof c) {
            this.gjd.setData(list);
        }
        if (z) {
            bMx();
        } else {
            bMw();
        }
    }

    private void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.VY.setNextPage(this.gdy);
            }
            this.gdy.setText(this.gjc.getPageContext().getResources().getString(R.string.list_no_more));
            this.gdy.endLoadData();
        }
    }

    private void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.VY.setNextPage(this.gdy);
            }
            this.gdy.showLoadingViewWithoutEmptyView();
            this.gdy.startLoadData();
        }
    }

    public void bNg() {
        this.VY.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.VY.setOnSrollToBottomListener(eVar);
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
        if (this.eHG != null) {
            MessageManager.getInstance().unRegisterListener(this.eHG);
        }
    }
}
