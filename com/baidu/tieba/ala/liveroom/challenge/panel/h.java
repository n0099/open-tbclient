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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends e {
    private ImageView eQA;
    private g eQB;
    private TextView eQC;
    public a eQv;
    private CommonEmptyView eqt;
    private View.OnClickListener esy;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private int pn;

    /* loaded from: classes2.dex */
    public interface a {
        void g(com.baidu.live.challenge.d dVar);
    }

    public h(Context context, k kVar) {
        super(context, kVar);
        this.pn = 1;
        this.esy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                h.this.eQe.bj(h.this.pn, 30);
            }
        };
        this.eQv = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eQe.s(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == h.this.eQA) {
                    h.this.eQe.bik();
                }
            }
        };
        this.eQA = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.eQA.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.eQB = new g(context);
        this.eQB.a(this.eQv);
        this.mListView.setAdapter((ListAdapter) this.eQB);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    h.this.eQe.bj(h.this.pn, 30);
                }
            }
        });
        this.eQC = new TextView(this.mContext);
        this.eQC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.eQC.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.eQC.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.eQC.setGravity(17);
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
        this.eQe.bik();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eQB != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.eQC);
            this.eQB.bip();
        }
        aZK();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.eQB != null) {
            this.eQB.e(dVar);
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.eqt == null) {
                this.eqt = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.eqt.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.eqt.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.eqt.setTitle(i);
            this.eqt.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.eqt.setRefreshButton(a.i.ala_click_retry, this.esy);
            }
            this.eqt.setVisibility(0);
        }
    }

    public void aZK() {
        if (this.eqt != null) {
            this.eqt.setVisibility(8);
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
            aZK();
            if (bVar.pn == 1) {
                this.eQB.setDatas(list);
            } else {
                this.eQB.bD(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                baF();
            } else {
                baG();
            }
        }
    }

    private void baF() {
        this.eQC.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.eQC);
        this.mListView.addFooterView(this.eQC);
    }

    private void baG() {
        this.eQC.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.eQC);
        this.mListView.addFooterView(this.eQC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.eQB.getCount() <= 0) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }
    }
}
