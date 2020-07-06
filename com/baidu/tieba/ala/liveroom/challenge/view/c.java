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
/* loaded from: classes3.dex */
public class c {
    private long aZe;
    private CommonEmptyView baR;
    private long fTw;
    private long fYs;
    private PbListView fzx;
    private a geA;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gez;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bDN();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.fYs = j;
        this.aZe = j2;
        this.fTw = j3;
        if (this.gez != null) {
            this.gez.a(this.mType, this.aZe, this.fTw, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.baR = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.geA != null) {
                    c.this.geA.onScrollToBottom();
                }
            }
        });
        this.gez = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gez);
        this.fzx = new PbListView(this.mTbPageContext.getPageActivity());
        this.fzx.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fzx.setSkinType(0);
        this.fzx.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.fzx.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gez != null) {
            this.gez.setData(list);
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

    public void btJ() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.mListView.setNextPage(this.fzx);
            }
            this.fzx.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fzx.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.fzx.endLoadData();
        }
    }

    public void btK() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.mListView.setNextPage(this.fzx);
            }
            this.fzx.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.fzx.startLoadData();
            this.fzx.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.fzx.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bDO() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.geA = aVar;
    }

    public void bW(boolean z) {
        if (this.baR != null) {
            this.baR.reset();
            if (z) {
                this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.geA != null) {
                            c.this.geA.bDN();
                        }
                    }
                });
                this.baR.setTitle(a.i.sdk_net_no);
                this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.baR.setTitle(a.i.sdk_list_empty_text);
                this.baR.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.baR.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Gw() {
        if (this.baR != null) {
            this.baR.setVisibility(8);
        }
    }
}
