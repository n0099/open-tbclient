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
    private long bnV;
    private CommonEmptyView bpJ;
    private long fYr;
    private long gZp;
    private PbListView gvu;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hfn;
    private a hfo;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void caU();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gZp = j;
        this.bnV = j2;
        this.fYr = j3;
        if (this.hfn != null) {
            this.hfn.a(this.mType, this.bnV, this.fYr, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hfo != null) {
                    c.this.hfo.onScrollToBottom();
                }
            }
        });
        this.hfn = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hfn);
        this.gvu = new PbListView(this.mTbPageContext.getPageActivity());
        this.gvu.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gvu.setSkinType(0);
        this.gvu.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gvu.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hfn != null) {
            this.hfn.setData(list);
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

    public void bOW() {
        if (this.gvu != null) {
            if (this.gvu.getView().getParent() == null) {
                this.mListView.setNextPage(this.gvu);
            }
            this.gvu.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gvu.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gvu.endLoadData();
        }
    }

    public void bOX() {
        if (this.gvu != null) {
            if (this.gvu.getView().getParent() == null) {
                this.mListView.setNextPage(this.gvu);
            }
            this.gvu.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gvu.startLoadData();
            this.gvu.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gvu.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bPi() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hfo = aVar;
    }

    public void cm(boolean z) {
        if (this.bpJ != null) {
            this.bpJ.reset();
            if (z) {
                this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hfo != null) {
                            c.this.hfo.caU();
                        }
                    }
                });
                this.bpJ.setTitle(a.h.sdk_net_no);
                this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bpJ.setTitle(a.h.sdk_list_empty_text);
                this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bpJ.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void OJ() {
        if (this.bpJ != null) {
            this.bpJ.setVisibility(8);
        }
    }
}
