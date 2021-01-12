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
/* loaded from: classes10.dex */
public class c {
    private long brk;
    private CommonEmptyView btf;
    private PbListView gKS;
    private long gmc;
    private long hpW;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hvT;
    private a hvU;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void cdi();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.hpW = j;
        this.brk = j2;
        this.gmc = j3;
        if (this.hvT != null) {
            this.hvT.b(this.mType, this.brk, this.gmc, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hvU != null) {
                    c.this.hvU.onScrollToBottom();
                }
            }
        });
        this.hvT = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hvT);
        this.gKS = new PbListView(this.mTbPageContext.getPageActivity());
        this.gKS.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gKS.setSkinType(0);
        this.gKS.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gKS.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hvT != null) {
            this.hvT.setData(list);
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

    public void bQM() {
        if (this.gKS != null) {
            if (this.gKS.getView().getParent() == null) {
                this.mListView.setNextPage(this.gKS);
            }
            this.gKS.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gKS.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gKS.endLoadData();
        }
    }

    public void bQN() {
        if (this.gKS != null) {
            if (this.gKS.getView().getParent() == null) {
                this.mListView.setNextPage(this.gKS);
            }
            this.gKS.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gKS.startLoadData();
            this.gKS.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gKS.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bQY() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hvU = aVar;
    }

    public void cB(boolean z) {
        if (this.btf != null) {
            this.btf.reset();
            if (z) {
                this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hvU != null) {
                            c.this.hvU.cdi();
                        }
                    }
                });
                this.btf.setTitle(a.h.sdk_net_no);
                this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.btf.setTitle(a.h.sdk_list_empty_text);
                this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.btf.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void NC() {
        if (this.btf != null) {
            this.btf.setVisibility(8);
        }
    }
}
