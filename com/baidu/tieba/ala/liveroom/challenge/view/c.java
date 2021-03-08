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
    private long bwn;
    private CommonEmptyView byj;
    private PbListView gPv;
    private long gqI;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hCa;
    private a hCb;
    private long hwd;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void ceq();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void d(long j, long j2, long j3) {
        this.hwd = j;
        this.bwn = j2;
        this.gqI = j3;
        if (this.hCa != null) {
            this.hCa.b(this.mType, this.bwn, this.gqI, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hCb != null) {
                    c.this.hCb.onScrollToBottom();
                }
            }
        });
        this.hCa = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hCa);
        this.gPv = new PbListView(this.mTbPageContext.getPageActivity());
        this.gPv.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gPv.setSkinType(0);
        this.gPv.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gPv.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hCa != null) {
            this.hCa.setData(list);
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

    public void bRD() {
        if (this.gPv != null) {
            if (this.gPv.getView().getParent() == null) {
                this.mListView.setNextPage(this.gPv);
            }
            this.gPv.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gPv.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gPv.endLoadData();
        }
    }

    public void bRE() {
        if (this.gPv != null) {
            if (this.gPv.getView().getParent() == null) {
                this.mListView.setNextPage(this.gPv);
            }
            this.gPv.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gPv.startLoadData();
            this.gPv.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gPv.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bRP() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hCb = aVar;
    }

    public void cK(boolean z) {
        if (this.byj != null) {
            this.byj.reset();
            if (z) {
                this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hCb != null) {
                            c.this.hCb.ceq();
                        }
                    }
                });
                this.byj.setTitle(a.h.sdk_net_no);
                this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.byj.setTitle(a.h.sdk_list_empty_text);
                this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.byj.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Pe() {
        if (this.byj != null) {
            this.byj.setVisibility(8);
        }
    }
}
