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
    private PbListView gNM;
    private long goZ;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a hAr;
    private a hAs;
    private long huu;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void cek();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.huu = j;
        this.buN = j2;
        this.goZ = j3;
        if (this.hAr != null) {
            this.hAr.b(this.mType, this.buN, this.goZ, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.hAs != null) {
                    c.this.hAs.onScrollToBottom();
                }
            }
        });
        this.hAr = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.hAr);
        this.gNM = new PbListView(this.mTbPageContext.getPageActivity());
        this.gNM.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.gNM.setSkinType(0);
        this.gNM.setContainerBackgroundColorResId(a.c.sdk_transparent);
        this.gNM.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.hAr != null) {
            this.hAr.setData(list);
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

    public void bRx() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.mListView.setNextPage(this.gNM);
            }
            this.gNM.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gNM.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_no_more));
            this.gNM.endLoadData();
        }
    }

    public void bRy() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.mListView.setNextPage(this.gNM);
            }
            this.gNM.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds64));
            this.gNM.startLoadData();
            this.gNM.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha50));
            this.gNM.setText(this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bRJ() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.hAs = aVar;
    }

    public void cK(boolean z) {
        if (this.bwJ != null) {
            this.bwJ.reset();
            if (z) {
                this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.hAs != null) {
                            c.this.hAs.cek();
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
