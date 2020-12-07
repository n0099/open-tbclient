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
    private long brr;
    private CommonEmptyView btg;
    private PbListView gDK;
    private long ggj;
    private long hiF;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hoC;
    private a hoD;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void cei();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.hiF = j;
        this.brr = j2;
        this.ggj = j3;
        if (this.hoC != null) {
            this.hoC.a(this.mType, this.brr, this.ggj, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hoD != null) {
                    c.this.hoD.onScrollToBottom();
                }
            }
        });
        this.hoC = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hoC);
        this.gDK = new PbListView(this.mTbPageContext.getPageActivity());
        this.gDK.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gDK.setSkinType(0);
        this.gDK.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gDK.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hoC != null) {
            this.hoC.setData(list);
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

    public void bSa() {
        if (this.gDK != null) {
            if (this.gDK.getView().getParent() == null) {
                this.mListView.setNextPage(this.gDK);
            }
            this.gDK.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gDK.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gDK.endLoadData();
        }
    }

    public void bSb() {
        if (this.gDK != null) {
            if (this.gDK.getView().getParent() == null) {
                this.mListView.setNextPage(this.gDK);
            }
            this.gDK.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gDK.startLoadData();
            this.gDK.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gDK.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bSm() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hoD = aVar;
    }

    public void cC(boolean z) {
        if (this.btg != null) {
            this.btg.reset();
            if (z) {
                this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hoD != null) {
                            c.this.hoD.cei();
                        }
                    }
                });
                this.btg.setTitle(a.h.sdk_net_no);
                this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.btg.setTitle(a.h.sdk_list_empty_text);
                this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.btg.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void Qt() {
        if (this.btg != null) {
            this.btg.setVisibility(8);
        }
    }
}
