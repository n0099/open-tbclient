package com.baidu.tieba.ala.liveroom.challenge.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private long bey;
    private CommonEmptyView bgn;
    private PbListView fPZ;
    private long fuN;
    private long gpM;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gvR;
    private a gvS;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void bQD();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gpM = j;
        this.bey = j2;
        this.fuN = j3;
        if (this.gvR != null) {
            this.gvR.a(this.mType, this.bey, this.fuN, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.bgn = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gvS != null) {
                    c.this.gvS.onScrollToBottom();
                }
            }
        });
        this.gvR = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gvR);
        this.fPZ = new PbListView(this.mTbPageContext.getPageActivity());
        this.fPZ.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fPZ.setSkinType(0);
        this.fPZ.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.fPZ.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gvR != null) {
            this.gvR.setData(list);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(0);
        }
    }

    public void completePullRefresh() {
    }

    public View getView() {
        return this.mRootView;
    }

    public void bFS() {
        if (this.fPZ != null) {
            if (this.fPZ.getView().getParent() == null) {
                this.mListView.setNextPage(this.fPZ);
            }
            this.fPZ.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fPZ.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.fPZ.endLoadData();
        }
    }

    public void bFT() {
        if (this.fPZ != null) {
            if (this.fPZ.getView().getParent() == null) {
                this.mListView.setNextPage(this.fPZ);
            }
            this.fPZ.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fPZ.startLoadData();
            this.fPZ.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.fPZ.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bQE() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gvS = aVar;
    }

    public void cf(boolean z) {
        if (this.bgn != null) {
            this.bgn.reset();
            if (z) {
                this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gvS != null) {
                            c.this.gvS.bQD();
                        }
                    }
                });
                this.bgn.setTitle(a.i.sdk_net_no);
                this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bgn.setTitle(a.i.sdk_list_empty_text);
                this.bgn.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bgn.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Me() {
        if (this.bgn != null) {
            this.bgn.setVisibility(8);
        }
    }
}
