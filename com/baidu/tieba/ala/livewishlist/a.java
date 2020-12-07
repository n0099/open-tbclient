package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.l.a, ScrollTextView.c {
    private w aFN;
    private ViewGroup bNk;
    private ViewGroup hGQ;
    protected WishListEntryView hGR;
    private ViewGroup.LayoutParams hin;
    private Context mContext;
    private BdUniqueId gEP = BdUniqueId.gen();
    private boolean gEn = true;
    private boolean hGS = true;
    private boolean hGT = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.l.a
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bNk = viewGroup;
            this.hin = layoutParams;
            bUj();
        }
    }

    private void bUj() {
        this.hGQ = new FrameLayout(this.bNk.getContext());
        this.hGQ.setBackgroundColor(0);
        this.hGQ.setId(a.f.wish_layout_id);
        this.bNk.addView(this.hGQ, this.hin);
    }

    @Override // com.baidu.live.l.a
    public void a(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.aFN = wVar;
            if (this.hGQ == null || this.bNk.indexOfChild(this.hGQ) < 0) {
                bUj();
                this.hGQ.setVisibility(this.gEn ? 0 : 8);
            }
            if (this.hGR == null) {
                this.hGR = new WishListEntryView(this.mContext);
                this.hGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Mq();
                    }
                });
                this.hGR.setOnScrollTextViewChangeListener(this);
            }
            if (this.hGQ != null && this.hGQ.indexOfChild(this.hGR) < 0) {
                this.hGQ.addView(this.hGR, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hGT) {
                if (this.hGR != null) {
                    this.hGR.ai(this.aFN.aKw);
                }
                this.hGT = false;
            }
            if (ListUtils.isEmpty(this.aFN.aKw) || this.aFN.aKw.size() == 1) {
                this.hGT = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, wVar));
        }
    }

    @Override // com.baidu.live.l.a
    public void Mq() {
        if (this.aFN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.w(this.mContext, this.aFN, String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.aJV.userId), this.hGS)));
        }
    }

    @Override // com.baidu.live.l.a
    public void a(q qVar) {
    }

    @Override // com.baidu.live.l.a
    public void cd(boolean z) {
        this.hGS = z;
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.hGR != null && this.hGR.getView() != null) {
            this.hGR.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hGR != null && this.aFN != null) {
            this.hGR.ah(this.aFN.aKw);
        }
    }

    @Override // com.baidu.live.l.a
    public void Do() {
        lY(true);
    }

    @Override // com.baidu.live.l.a
    public void onDestroy() {
        lY(true);
    }

    private void reset(boolean z) {
        this.gEn = true;
        lY(z);
    }

    private void lY(boolean z) {
        if (this.hGR != null && (this.hGR.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGR.getParent()).removeView(this.hGR);
        }
        if (z && this.hGQ != null && (this.hGQ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGQ.getParent()).removeView(this.hGQ);
        }
    }
}
