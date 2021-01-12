package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.w;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.m.a, ScrollTextView.c {
    private x aBr;
    private ViewGroup bNl;
    private ViewGroup hOm;
    protected WishListEntryView hOn;
    private ViewGroup.LayoutParams hpF;
    private Context mContext;
    private BdUniqueId gLW = BdUniqueId.gen();
    private boolean gLt = true;
    private boolean hOo = true;
    private boolean hOp = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.m.a
    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bNl = viewGroup;
            this.hpF = layoutParams;
            bNr();
        }
    }

    private void bNr() {
        this.hOm = new FrameLayout(this.bNl.getContext());
        this.hOm.setBackgroundColor(0);
        this.hOm.setId(a.f.wish_layout_id);
        this.bNl.addView(this.hOm, this.hpF);
    }

    @Override // com.baidu.live.m.a
    public void a(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.aBr = xVar;
            if (this.hOm == null || this.bNl.indexOfChild(this.hOm) < 0) {
                bNr();
                this.hOm.setVisibility(this.gLt ? 0 : 8);
            }
            if (this.hOn == null) {
                this.hOn = new WishListEntryView(this.mContext);
                this.hOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.HS();
                    }
                });
                this.hOn.setOnScrollTextViewChangeListener(this);
            }
            if (this.hOm != null && this.hOm.indexOfChild(this.hOn) < 0) {
                this.hOm.addView(this.hOn, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hOp) {
                if (this.hOn != null) {
                    this.hOn.ad(this.aBr.aGi);
                }
                this.hOp = false;
            }
            if (ListUtils.isEmpty(this.aBr.aGi) || this.aBr.aGi.size() == 1) {
                this.hOp = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, xVar));
        }
    }

    @Override // com.baidu.live.m.a
    public void HS() {
        if (this.aBr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this.mContext, this.aBr, String.valueOf(this.aBr.mLiveInfo.live_id), String.valueOf(this.aBr.aFH.userId), this.hOo)));
        }
    }

    @Override // com.baidu.live.m.a
    public void a(r rVar) {
    }

    @Override // com.baidu.live.m.a
    public void bZ(boolean z) {
        this.hOo = z;
    }

    @Override // com.baidu.live.m.a
    public void setCanVisible(boolean z) {
        if (this.hOn != null && this.hOn.getView() != null) {
            this.hOn.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hOn != null && this.aBr != null) {
            this.hOn.ac(this.aBr.aGi);
        }
    }

    @Override // com.baidu.live.m.a
    public void xk() {
        mr(true);
    }

    @Override // com.baidu.live.m.a
    public void onDestroy() {
        mr(true);
    }

    private void reset(boolean z) {
        this.gLt = true;
        mr(z);
    }

    private void mr(boolean z) {
        if (this.hOn != null && (this.hOn.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hOn.getParent()).removeView(this.hOn);
        }
        if (z && this.hOm != null && (this.hOm.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hOm.getParent()).removeView(this.hOm);
        }
    }
}
