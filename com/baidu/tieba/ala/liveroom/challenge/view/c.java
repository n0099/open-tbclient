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
    private long blh;
    private CommonEmptyView bmS;
    private long fKh;
    private long gHv;
    private com.baidu.tieba.ala.liveroom.challenge.adapter.a gNv;
    private a gNw;
    private PbListView gfD;
    private boolean mIsHost;
    private BdListView mListView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bVt();

        void onScrollToBottom();
    }

    public c(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        initView();
    }

    public void c(long j, long j2, long j3) {
        this.gHv = j;
        this.blh = j2;
        this.fKh = j3;
        if (this.gNv != null) {
            this.gNv.a(this.mType, this.blh, this.fKh, this.mIsHost);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_jinzhu_list_layout, (ViewGroup) null);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list);
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.id_challenge_jinzhu_list_empty_view);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.gNw != null) {
                    c.this.gNw.onScrollToBottom();
                }
            }
        });
        this.gNv = new com.baidu.tieba.ala.liveroom.challenge.adapter.a(this.mTbPageContext);
        this.mListView.setAdapter((ListAdapter) this.gNv);
        this.gfD = new PbListView(this.mTbPageContext.getPageActivity());
        this.gfD.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gfD.setSkinType(0);
        this.gfD.setContainerBackgroundColorResId(a.d.sdk_transparent);
        this.gfD.createView();
    }

    public void setData(List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
        if (this.gNv != null) {
            this.gNv.setData(list);
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

    public void bJU() {
        if (this.gfD != null) {
            if (this.gfD.getView().getParent() == null) {
                this.mListView.setNextPage(this.gfD);
            }
            this.gfD.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.gfD.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_no_more));
            this.gfD.endLoadData();
        }
    }

    public void bJV() {
        if (this.gfD != null) {
            if (this.gfD.getView().getParent() == null) {
                this.mListView.setNextPage(this.gfD);
            }
            this.gfD.setHeight(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds64));
            this.gfD.startLoadData();
            this.gfD.setNoMoreTextColorId(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha50));
            this.gfD.setText(this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_list_is_loading));
        }
    }

    public void bKg() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
        }
    }

    public void onDestroy() {
    }

    public void a(a aVar) {
        this.gNw = aVar;
    }

    public void cj(boolean z) {
        if (this.bmS != null) {
            this.bmS.reset();
            if (z) {
                this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gNw != null) {
                            c.this.gNw.bVt();
                        }
                    }
                });
                this.bmS.setTitle(a.i.sdk_net_no);
                this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bmS.setTitle(a.i.sdk_list_empty_text);
                this.bmS.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            }
            this.bmS.setVisibility(0);
        }
        this.mListView.setVisibility(8);
    }

    public void NM() {
        if (this.bmS != null) {
            this.bmS.setVisibility(8);
        }
    }
}
