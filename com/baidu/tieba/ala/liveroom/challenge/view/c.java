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
/* loaded from: classes4.dex */
public class c {
    private long bmk;
    private CommonEmptyView bnY;
    private long fXY;
    private long gYW;
    private PbListView gvb;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a heU;
    private a heV;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void can();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gYW = j;
        this.bmk = j2;
        this.fXY = j3;
        if (this.heU != null) {
            this.heU.a(this.mType, this.bmk, this.fXY, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.heV != null) {
                    c.this.heV.onScrollToBottom();
                }
            }
        });
        this.heU = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.heU);
        this.gvb = new PbListView(this.mTbPageContext.getPageActivity());
        this.gvb.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gvb.setSkinType(0);
        this.gvb.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gvb.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.heU != null) {
            this.heU.setData(list);
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

    public void bOp() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.mListView.setNextPage(this.gvb);
            }
            this.gvb.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gvb.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gvb.endLoadData();
        }
    }

    public void bOq() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.mListView.setNextPage(this.gvb);
            }
            this.gvb.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gvb.startLoadData();
            this.gvb.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gvb.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bOB() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.heV = aVar;
    }

    public void co(boolean z) {
        if (this.bnY != null) {
            this.bnY.reset();
            if (z) {
                this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.heV != null) {
                            c.this.heV.can();
                        }
                    }
                });
                this.bnY.setTitle(a.h.sdk_net_no);
                this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bnY.setTitle(a.h.sdk_list_empty_text);
                this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bnY.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Oa() {
        if (this.bnY != null) {
            this.bnY.setVisibility(8);
        }
    }
}
