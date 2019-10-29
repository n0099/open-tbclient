package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes6.dex */
public class h extends e {
    private CommonEmptyView dFw;
    public a ebq;
    private ImageView ebv;
    private g ebw;
    private TextView ebx;
    private View.OnClickListener eby;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private int pn;

    /* loaded from: classes6.dex */
    public interface a {
        void g(com.baidu.live.challenge.d dVar);
    }

    public h(Context context, k kVar) {
        super(context, kVar);
        this.pn = 1;
        this.eby = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                h.this.eaZ.aV(h.this.pn, 30);
            }
        };
        this.ebq = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eaZ.r(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == h.this.ebv) {
                    h.this.eaZ.aQI();
                }
            }
        };
        this.ebv = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.ebv.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.ebw = new g(context);
        this.ebw.a(this.ebq);
        this.mListView.setAdapter((ListAdapter) this.ebw);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    h.this.eaZ.aV(h.this.pn, 30);
                }
            }
        });
        this.ebx = new TextView(this.mContext);
        this.ebx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.ebx.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ebx.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.ebx.setGravity(17);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_user_choose_view, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void b(FrameLayout frameLayout, int i) {
        super.b(frameLayout, i);
        this.pn = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        this.eaZ.aQI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.ebw != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.ebx);
            this.ebw.aQN();
        }
        aJo();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.ebw != null) {
            this.ebw.e(dVar);
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.dFw == null) {
                this.dFw = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.dFw.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.dFw.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.dFw.setTitle(i);
            this.dFw.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.dFw.setRefreshButton(a.i.ala_click_retry, this.eby);
            }
            this.dFw.setVisibility(0);
        }
    }

    public void aJo() {
        if (this.dFw != null) {
            this.dFw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                a(a.i.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                return;
            }
            this.mListView.setVisibility(0);
            aJo();
            if (bVar.pn == 1) {
                this.ebw.setDatas(list);
            } else {
                this.ebw.bE(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                aKi();
            } else {
                aKj();
            }
        }
    }

    private void aKi() {
        this.ebx.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.ebx);
        this.mListView.addFooterView(this.ebx);
    }

    private void aKj() {
        this.ebx.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.ebx);
        this.mListView.addFooterView(this.ebx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.ebw.getCount() <= 0) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }
    }
}
