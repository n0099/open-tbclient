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
import com.baidu.live.data.r;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private r aAj;
    private ViewGroup fZy;
    private ViewGroup gNv;
    protected WishListEntryView gNw;
    private ViewGroup.LayoutParams gpu;
    private Context mContext;
    private BdUniqueId fRe = BdUniqueId.gen();
    private boolean fQC = true;
    private boolean gNx = true;
    private boolean gNy = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.fZy = viewGroup;
            this.gpu = layoutParams;
            bIm();
        }
    }

    private void bIm() {
        this.gNv = new FrameLayout(this.fZy.getContext());
        this.gNv.setBackgroundColor(0);
        this.fZy.addView(this.gNv, this.gpu);
    }

    @Override // com.baidu.live.i.a
    public void a(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.aAj = rVar;
            if (this.gNv == null || this.fZy.indexOfChild(this.gNv) < 0) {
                bIm();
                this.gNv.setVisibility(this.fQC ? 0 : 8);
            }
            if (this.gNw == null || (this.gNv != null && this.gNv.indexOfChild(this.gNw) < 0)) {
                this.gNw = new WishListEntryView(this.gNv.getContext());
                this.gNv.addView(this.gNw, new FrameLayout.LayoutParams(-2, -2));
                this.gNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.It();
                    }
                });
                this.gNw.setOnScrollTextViewChangeListener(this);
            }
            if (this.gNy) {
                if (this.gNw != null) {
                    this.gNw.ag(this.aAj.aEi);
                }
                this.gNy = false;
            }
            if (ListUtils.isEmpty(this.aAj.aEi) || this.aAj.aEi.size() == 1) {
                this.gNy = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, rVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void It() {
        if (this.aAj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this.mContext, this.aAj, String.valueOf(this.aAj.mLiveInfo.live_id), String.valueOf(this.aAj.aDG.userId), this.gNx)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bK(boolean z) {
        this.gNx = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.gNw != null && this.gNw.getView() != null) {
            this.gNw.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.gNw != null && this.aAj != null) {
            this.gNw.af(this.aAj.aEi);
        }
    }

    @Override // com.baidu.live.i.a
    public void Iq() {
        kB(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        kB(true);
    }

    private void reset(boolean z) {
        this.fQC = true;
        kB(z);
    }

    private void kB(boolean z) {
        if (this.gNw != null && (this.gNw.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gNw.getParent()).removeView(this.gNw);
        }
        if (z && this.gNv != null && (this.gNv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gNv.getParent()).removeView(this.gNv);
        }
    }
}
