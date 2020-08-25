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
    private long bew;
    private CommonEmptyView bgl;
    private PbListView fPV;
    private long fuJ;
    private long gpI;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gvN;
    private a gvO;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void bQC();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gpI = j;
        this.bew = j2;
        this.fuJ = j3;
        if (this.gvN != null) {
            this.gvN.a(this.mType, this.bew, this.fuJ, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gvO != null) {
                    c.this.gvO.onScrollToBottom();
                }
            }
        });
        this.gvN = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gvN);
        this.fPV = new PbListView(this.mTbPageContext.getPageActivity());
        this.fPV.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fPV.setSkinType(0);
        this.fPV.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.fPV.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gvN != null) {
            this.gvN.setData(list);
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

    public void bFR() {
        if (this.fPV != null) {
            if (this.fPV.getView().getParent() == null) {
                this.mListView.setNextPage(this.fPV);
            }
            this.fPV.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fPV.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.fPV.endLoadData();
        }
    }

    public void bFS() {
        if (this.fPV != null) {
            if (this.fPV.getView().getParent() == null) {
                this.mListView.setNextPage(this.fPV);
            }
            this.fPV.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fPV.startLoadData();
            this.fPV.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.fPV.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bQD() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gvO = aVar;
    }

    public void cf(boolean z) {
        if (this.bgl != null) {
            this.bgl.reset();
            if (z) {
                this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gvO != null) {
                            c.this.gvO.bQC();
                        }
                    }
                });
                this.bgl.setTitle(a.i.sdk_net_no);
                this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bgl.setTitle(a.i.sdk_list_empty_text);
                this.bgl.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bgl.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Me() {
        if (this.bgl != null) {
            this.bgl.setVisibility(8);
        }
    }
}
