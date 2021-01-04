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
    private long bvY;
    private CommonEmptyView bxT;
    private PbListView gPy;
    private long gqJ;
    private a hAA;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hAz;
    private long huC;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void cgZ();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.huC = j;
        this.bvY = j2;
        this.gqJ = j3;
        if (this.hAz != null) {
            this.hAz.b(this.mType, this.bvY, this.gqJ, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hAA != null) {
                    c.this.hAA.onScrollToBottom();
                }
            }
        });
        this.hAz = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hAz);
        this.gPy = new PbListView(this.mTbPageContext.getPageActivity());
        this.gPy.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gPy.setSkinType(0);
        this.gPy.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gPy.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hAz != null) {
            this.hAz.setData(list);
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

    public void bUD() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.mListView.setNextPage(this.gPy);
            }
            this.gPy.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gPy.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gPy.endLoadData();
        }
    }

    public void bUE() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.mListView.setNextPage(this.gPy);
            }
            this.gPy.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gPy.startLoadData();
            this.gPy.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gPy.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bUP() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hAA = aVar;
    }

    public void cF(boolean z) {
        if (this.bxT != null) {
            this.bxT.reset();
            if (z) {
                this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hAA != null) {
                            c.this.hAA.cgZ();
                        }
                    }
                });
                this.bxT.setTitle(a.h.sdk_net_no);
                this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bxT.setTitle(a.h.sdk_list_empty_text);
                this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bxT.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Rx() {
        if (this.bxT != null) {
            this.bxT.setVisibility(8);
        }
    }
}
