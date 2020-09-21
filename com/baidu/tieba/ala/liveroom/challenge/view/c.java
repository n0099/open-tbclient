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
    private long bhr;
    private CommonEmptyView bjf;
    private PbListView fTk;
    private long fxY;
    private long gta;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gzc;
    private a gzd;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bRZ();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gta = j;
        this.bhr = j2;
        this.fxY = j3;
        if (this.gzc != null) {
            this.gzc.a(this.mType, this.bhr, this.fxY, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gzd != null) {
                    c.this.gzd.onScrollToBottom();
                }
            }
        });
        this.gzc = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gzc);
        this.fTk = new PbListView(this.mTbPageContext.getPageActivity());
        this.fTk.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fTk.setSkinType(0);
        this.fTk.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.fTk.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gzc != null) {
            this.gzc.setData(list);
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

    public void bHi() {
        if (this.fTk != null) {
            if (this.fTk.getView().getParent() == null) {
                this.mListView.setNextPage(this.fTk);
            }
            this.fTk.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fTk.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.fTk.endLoadData();
        }
    }

    public void bHj() {
        if (this.fTk != null) {
            if (this.fTk.getView().getParent() == null) {
                this.mListView.setNextPage(this.fTk);
            }
            this.fTk.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fTk.startLoadData();
            this.fTk.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.fTk.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bSa() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gzd = aVar;
    }

    public void cg(boolean z) {
        if (this.bjf != null) {
            this.bjf.reset();
            if (z) {
                this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gzd != null) {
                            c.this.gzd.bRZ();
                        }
                    }
                });
                this.bjf.setTitle(a.i.sdk_net_no);
                this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bjf.setTitle(a.i.sdk_list_empty_text);
                this.bjf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bjf.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void MH() {
        if (this.bjf != null) {
            this.bjf.setVisibility(8);
        }
    }
}
