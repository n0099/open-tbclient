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
    private long aZc;
    private CommonEmptyView baQ;
    private PbListView fEE;
    private long fjn;
    private long gdz;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gjH;
    private a gjI;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bGY();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gdz = j;
        this.aZc = j2;
        this.fjn = j3;
        if (this.gjH != null) {
            this.gjH.a(this.mType, this.aZc, this.fjn, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.baQ = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gjI != null) {
                    c.this.gjI.onScrollToBottom();
                }
            }
        });
        this.gjH = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gjH);
        this.fEE = new PbListView(this.mTbPageContext.getPageActivity());
        this.fEE.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fEE.setSkinType(0);
        this.fEE.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.fEE.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gjH != null) {
            this.gjH.setData(list);
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

    public void bwS() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.mListView.setNextPage(this.fEE);
            }
            this.fEE.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fEE.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.fEE.endLoadData();
        }
    }

    public void bwT() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.mListView.setNextPage(this.fEE);
            }
            this.fEE.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fEE.startLoadData();
            this.fEE.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.fEE.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bGZ() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gjI = aVar;
    }

    public void bX(boolean z) {
        if (this.baQ != null) {
            this.baQ.reset();
            if (z) {
                this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gjI != null) {
                            c.this.gjI.bGY();
                        }
                    }
                });
                this.baQ.setTitle(a.i.sdk_net_no);
                this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.baQ.setTitle(a.i.sdk_list_empty_text);
                this.baQ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.baQ.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Gq() {
        if (this.baQ != null) {
            this.baQ.setVisibility(8);
        }
    }
}
