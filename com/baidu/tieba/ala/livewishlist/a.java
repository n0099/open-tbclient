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
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private q aJj;
    private ViewGroup foI;
    private ViewGroup.LayoutParams foJ;
    private ViewGroup foK;
    protected WishListEntryView giL;
    private Context mContext;
    private BdUniqueId fpn = BdUniqueId.gen();
    private boolean foO = true;
    private boolean giM = true;
    private boolean giN = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.foI = viewGroup;
        this.foJ = layoutParams;
        btc();
    }

    private void btc() {
        this.foK = new FrameLayout(this.foI.getContext());
        this.foK.setBackgroundColor(0);
        this.foI.addView(this.foK, this.foJ);
    }

    @Override // com.baidu.live.i.a
    public void a(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.aJj = qVar;
            if (this.foK == null || this.foI.indexOfChild(this.foK) < 0) {
                btc();
                this.foK.setVisibility(this.foO ? 0 : 8);
            }
            if (this.giL == null || (this.foK != null && this.foK.indexOfChild(this.giL) < 0)) {
                this.giL = new WishListEntryView(this.foK.getContext());
                this.foK.addView(this.giL, new FrameLayout.LayoutParams(-2, -2));
                this.giL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.BO();
                    }
                });
                this.giL.setOnScrollTextViewChangeListener(this);
            }
            if (this.giN) {
                if (this.giL != null) {
                    this.giL.Z(this.aJj.avF);
                }
                this.giN = false;
            }
            if (ListUtils.isEmpty(this.aJj.avF) || this.aJj.avF.size() == 1) {
                this.giN = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, qVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void BO() {
        if (this.aJj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aJj, String.valueOf(this.aJj.mLiveInfo.live_id), String.valueOf(this.aJj.avj.userId), this.giM)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bC(boolean z) {
        this.giM = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.giL != null && this.giL.getView() != null) {
            this.giL.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.giL != null && this.aJj != null) {
            this.giL.Y(this.aJj.avF);
        }
    }

    @Override // com.baidu.live.i.a
    public void BL() {
        jk(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        jk(true);
    }

    private void reset(boolean z) {
        this.foO = true;
        jk(z);
    }

    private void jk(boolean z) {
        if (this.giL != null && (this.giL.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.giL.getParent()).removeView(this.giL);
        }
        if (z && this.foK != null && (this.foK.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foK.getParent()).removeView(this.foK);
        }
    }
}
