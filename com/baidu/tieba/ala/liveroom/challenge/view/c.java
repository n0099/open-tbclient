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
    private long bmB;
    private CommonEmptyView boq;
    private long fSB;
    private long gTk;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gZj;
    private a gZk;
    private PbListView gpG;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bYs();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gTk = j;
        this.bmB = j2;
        this.fSB = j3;
        if (this.gZj != null) {
            this.gZj.a(this.mType, this.bmB, this.fSB, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gZk != null) {
                    c.this.gZk.onScrollToBottom();
                }
            }
        });
        this.gZj = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gZj);
        this.gpG = new PbListView(this.mTbPageContext.getPageActivity());
        this.gpG.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gpG.setSkinType(0);
        this.gpG.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.gpG.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gZj != null) {
            this.gZj.setData(list);
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

    public void bMw() {
        if (this.gpG != null) {
            if (this.gpG.getView().getParent() == null) {
                this.mListView.setNextPage(this.gpG);
            }
            this.gpG.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.gpG.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.gpG.endLoadData();
        }
    }

    public void bMx() {
        if (this.gpG != null) {
            if (this.gpG.getView().getParent() == null) {
                this.mListView.setNextPage(this.gpG);
            }
            this.gpG.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.gpG.startLoadData();
            this.gpG.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.gpG.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bMI() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gZk = aVar;
    }

    public void cl(boolean z) {
        if (this.boq != null) {
            this.boq.reset();
            if (z) {
                this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gZk != null) {
                            c.this.gZk.bYs();
                        }
                    }
                });
                this.boq.setTitle(a.i.sdk_net_no);
                this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.boq.setTitle(a.i.sdk_list_empty_text);
                this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.boq.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Oj() {
        if (this.boq != null) {
            this.boq.setVisibility(8);
        }
    }
}
