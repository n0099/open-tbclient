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
/* loaded from: classes11.dex */
public class c {
    private long buN;
    private CommonEmptyView bwJ;
    private PbListView gNy;
    private long goL;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hAd;
    private a hAe;
    private long hug;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void ced();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.hug = j;
        this.buN = j2;
        this.goL = j3;
        if (this.hAd != null) {
            this.hAd.b(this.mType, this.buN, this.goL, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hAe != null) {
                    c.this.hAe.onScrollToBottom();
                }
            }
        });
        this.hAd = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hAd);
        this.gNy = new PbListView(this.mTbPageContext.getPageActivity());
        this.gNy.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gNy.setSkinType(0);
        this.gNy.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gNy.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hAd != null) {
            this.hAd.setData(list);
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

    public void bRq() {
        if (this.gNy != null) {
            if (this.gNy.getView().getParent() == null) {
                this.mListView.setNextPage(this.gNy);
            }
            this.gNy.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gNy.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gNy.endLoadData();
        }
    }

    public void bRr() {
        if (this.gNy != null) {
            if (this.gNy.getView().getParent() == null) {
                this.mListView.setNextPage(this.gNy);
            }
            this.gNy.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gNy.startLoadData();
            this.gNy.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gNy.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bRC() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hAe = aVar;
    }

    public void cK(boolean z) {
        if (this.bwJ != null) {
            this.bwJ.reset();
            if (z) {
                this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hAe != null) {
                            c.this.hAe.ced();
                        }
                    }
                });
                this.bwJ.setTitle(a.h.sdk_net_no);
                this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bwJ.setTitle(a.h.sdk_list_empty_text);
                this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bwJ.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Pb() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }
}
