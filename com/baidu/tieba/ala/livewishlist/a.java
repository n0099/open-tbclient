package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.t;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private q avf;
    private ViewGroup fNw;
    private ViewGroup gAU;
    protected WishListEntryView gAV;
    private ViewGroup.LayoutParams gdi;
    private Context mContext;
    private BdUniqueId fFJ = BdUniqueId.gen();
    private boolean fFh = true;
    private boolean gAW = true;
    private boolean gAX = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.fNw = viewGroup;
            this.gdi = layoutParams;
            bzi();
        }
    }

    private void bzi() {
        this.gAU = new FrameLayout(this.fNw.getContext());
        this.gAU.setBackgroundColor(0);
        this.fNw.addView(this.gAU, this.gdi);
    }

    @Override // com.baidu.live.i.a
    public void a(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.avf = qVar;
            if (this.gAU == null || this.fNw.indexOfChild(this.gAU) < 0) {
                bzi();
                this.gAU.setVisibility(this.fFh ? 0 : 8);
            }
            if (this.gAV == null || (this.gAU != null && this.gAU.indexOfChild(this.gAV) < 0)) {
                this.gAV = new WishListEntryView(this.gAU.getContext());
                this.gAU.addView(this.gAV, new FrameLayout.LayoutParams(-2, -2));
                this.gAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.CQ();
                    }
                });
                this.gAV.setOnScrollTextViewChangeListener(this);
            }
            if (this.gAX) {
                if (this.gAV != null) {
                    this.gAV.aa(this.avf.ayY);
                }
                this.gAX = false;
            }
            if (ListUtils.isEmpty(this.avf.ayY) || this.avf.ayY.size() == 1) {
                this.gAX = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, qVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void CQ() {
        if (this.avf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this.mContext, this.avf, String.valueOf(this.avf.mLiveInfo.live_id), String.valueOf(this.avf.ayC.userId), this.gAW)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bF(boolean z) {
        this.gAW = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.gAV != null && this.gAV.getView() != null) {
            this.gAV.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.gAV != null && this.avf != null) {
            this.gAV.Z(this.avf.ayY);
        }
    }

    @Override // com.baidu.live.i.a
    public void CN() {
        kb(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        kb(true);
    }

    private void reset(boolean z) {
        this.fFh = true;
        kb(z);
    }

    private void kb(boolean z) {
        if (this.gAV != null && (this.gAV.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gAV.getParent()).removeView(this.gAV);
        }
        if (z && this.gAU != null && (this.gAU.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gAU.getParent()).removeView(this.gAU);
        }
    }
}
