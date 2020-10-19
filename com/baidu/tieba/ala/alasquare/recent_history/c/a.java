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
    private BdListView VX;
    private FrameLayout bBl;
    private CustomMessageListener ezk;
    private PbListView fTv;
    private AlaRecentHistoryActivity fYX;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fYY;
    private b fYZ;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fYX = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fYX).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fYX.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.bBl = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.VX = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fYX.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fYX.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.VX.setDivider(colorDrawable);
        this.VX.setDividerHeight(this.fYX.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fYX.getUniqueId());
        this.VX.setPullRefresh(this.mPullView);
        this.fTv = new PbListView(this.fYX);
        this.fTv.createView();
        bKB();
    }

    private void bKB() {
        bKC();
    }

    private void bKC() {
        if (this.mType == 0) {
            this.fYY = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fYY = new c(this.mPageContext);
            registerListener();
            ((c) this.fYY).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fYZ = bVar;
                    a.this.a(bVar.eji.bih(), bVar.isFollow);
                }
            });
        }
        this.VX.setAdapter((ListAdapter) this.fYY);
        this.VX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().bHY();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fYZ != null) {
                        if (a.this.fYZ.eji != null && a.this.fYZ.eji.bih() != null) {
                            j = a.this.fYZ.eji.bih().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fYZ.isFollow = true;
                                if (a.this.fYY instanceof c) {
                                    a.this.fYY.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fYZ.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ezk);
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

    public ViewGroup bKD() {
        return this.bBl;
    }

    public void completePullRefresh() {
        this.VX.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fYY instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fYY.setData(list);
        } else if (this.fYY instanceof c) {
            this.fYY.setData(list);
        }
        if (z) {
            bJV();
        } else {
            bJU();
        }
    }

    private void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.VX.setNextPage(this.fTv);
            }
            this.fTv.setText(this.fYX.getPageContext().getResources().getString(R.string.list_no_more));
            this.fTv.endLoadData();
        }
    }

    private void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.VX.setNextPage(this.fTv);
            }
            this.fTv.showLoadingViewWithoutEmptyView();
            this.fTv.startLoadData();
        }
    }

    public void bKE() {
        this.VX.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.VX.setOnSrollToBottomListener(eVar);
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
        if (this.ezk != null) {
            MessageManager.getInstance().unRegisterListener(this.ezk);
        }
    }
}
