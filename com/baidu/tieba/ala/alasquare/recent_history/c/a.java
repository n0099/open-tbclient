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
import com.baidu.tbadk.core.util.be;
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
    private BdListView US;
    private FrameLayout caS;
    private CustomMessageListener dUF;
    private PbListView fnt;
    private AlaRecentHistoryActivity fsN;
    private com.baidu.tieba.ala.alasquare.recent_history.a.a fsO;
    private b fsP;
    private NoNetworkView mNetworkView;
    private TbPageContext mPageContext;
    private g mPullView;
    private View mRootView;
    private int mType;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.fsN = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.mType = i;
        initView();
    }

    public void initView() {
        ColorDrawable colorDrawable;
        this.mRootView = LayoutInflater.from(this.fsN).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.fsN.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.caS = (FrameLayout) this.mRootView.findViewById(R.id.square_recent_history_container);
        this.US = (BdListView) this.mRootView.findViewById(R.id.square_recent_history_listview);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            colorDrawable = new ColorDrawable(this.fsN.getPageContext().getResources().getColor(R.color.cp_bg_line_c_1));
        } else {
            colorDrawable = new ColorDrawable(this.fsN.getPageContext().getResources().getColor(R.color.cp_bg_line_c));
        }
        this.US.setDivider(colorDrawable);
        this.US.setDividerHeight(this.fsN.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.square_recent_history_network);
        this.mPullView = new g(this.mPageContext);
        this.mPullView.setTag(this.fsN.getUniqueId());
        this.US.setPullRefresh(this.mPullView);
        this.fnt = new PbListView(this.fsN);
        this.fnt.createView();
        bup();
    }

    private void bup() {
        buq();
    }

    private void buq() {
        if (this.mType == 0) {
            this.fsO = new com.baidu.tieba.ala.alasquare.recent_history.a.b(this.mPageContext);
        } else if (1 == this.mType) {
            this.fsO = new c(this.mPageContext);
            registerListener();
            ((c) this.fsO).a(new c.a() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.1
                @Override // com.baidu.tieba.ala.alasquare.recent_history.a.c.a
                public void a(b bVar) {
                    a.this.fsP = bVar;
                    a.this.a(bVar.dLi.aSp(), bVar.isFollow);
                }
            });
        }
        this.US.setAdapter((ListAdapter) this.fsO);
        this.US.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    com.baidu.tieba.ala.alasquare.c.a.buo().brT();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    private void registerListener() {
        this.dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.alasquare.recent_history.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j;
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.fsP != null) {
                        if (a.this.fsP.dLi != null && a.this.fsP.dLi.aSp() != null) {
                            j = a.this.fsP.dLi.aSp().getUserIdLong();
                        } else {
                            j = -100;
                        }
                        if (updateAttentionMessage.getData().toUid.equals(String.valueOf(j))) {
                            if (updateAttentionMessage.getData().isSucc) {
                                a.this.fsP.isFollow = true;
                                if (a.this.fsO instanceof c) {
                                    a.this.fsO.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            a.this.fsP.isFollow = false;
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData, boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            be.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        String valueOf = String.valueOf(metaData.getUserId());
        AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ViewGroup bur() {
        return this.caS;
    }

    public void completePullRefresh() {
        this.US.completePullRefresh();
    }

    public void setData(List<b> list, boolean z) {
        if (this.fsO instanceof com.baidu.tieba.ala.alasquare.recent_history.a.b) {
            this.fsO.setData(list);
        } else if (this.fsO instanceof c) {
            this.fsO.setData(list);
        }
        if (z) {
            btJ();
        } else {
            btI();
        }
    }

    private void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.US.setNextPage(this.fnt);
            }
            this.fnt.setText(this.fsN.getPageContext().getResources().getString(R.string.list_no_more));
            this.fnt.endLoadData();
        }
    }

    private void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.US.setNextPage(this.fnt);
            }
            this.fnt.showLoadingViewWithoutEmptyView();
            this.fnt.startLoadData();
        }
    }

    public void bus() {
        this.US.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.US.setOnSrollToBottomListener(eVar);
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
        if (this.dUF != null) {
            MessageManager.getInstance().unRegisterListener(this.dUF);
        }
    }
}
