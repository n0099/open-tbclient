package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.r;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private m alp;
    private ViewGroup ewN;
    private ViewGroup.LayoutParams ewO;
    private ViewGroup ewP;
    protected WishListEntryView fpg;
    private Context mContext;
    private BdUniqueId exr = BdUniqueId.gen();
    private boolean ewT = true;
    private boolean fph = true;
    private boolean fpi = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewN = viewGroup;
        this.ewO = layoutParams;
        bdY();
    }

    private void bdY() {
        this.ewP = new FrameLayout(this.ewN.getContext());
        this.ewP.setBackgroundColor(0);
        this.ewN.addView(this.ewP, this.ewO);
    }

    @Override // com.baidu.live.i.a
    public void a(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.alp = mVar;
            if (this.ewP == null || this.ewN.indexOfChild(this.ewP) < 0) {
                bdY();
                this.ewP.setVisibility(this.ewT ? 0 : 8);
            }
            if (this.fpg == null || (this.ewP != null && this.ewP.indexOfChild(this.fpg) < 0)) {
                this.fpg = new WishListEntryView(this.ewP.getContext());
                this.ewP.addView(this.fpg, new FrameLayout.LayoutParams(-2, -2));
                this.fpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.vT();
                    }
                });
                this.fpg.setOnScrollTextViewChangeListener(this);
            }
            if (this.fpi) {
                if (this.fpg != null) {
                    this.fpg.Y(this.alp.Yq);
                }
                this.fpi = false;
            }
            if (ListUtils.isEmpty(this.alp.Yq) || this.alp.Yq.size() == 1) {
                this.fpi = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, mVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void vT() {
        if (this.alp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.alp, String.valueOf(this.alp.mLiveInfo.live_id), String.valueOf(this.alp.Ya.userId), this.fph)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void aP(boolean z) {
        this.fph = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.fpg != null && this.fpg.getView() != null) {
            this.fpg.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fpg != null && this.alp != null) {
            this.fpg.X(this.alp.Yq);
        }
    }

    @Override // com.baidu.live.i.a
    public void vQ() {
        hT(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        hT(true);
    }

    private void reset(boolean z) {
        this.ewT = true;
        hT(z);
    }

    private void hT(boolean z) {
        if (this.fpg != null && (this.fpg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fpg.getParent()).removeView(this.fpg);
        }
        if (z && this.ewP != null && (this.ewP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewP.getParent()).removeView(this.ewP);
        }
    }
}
