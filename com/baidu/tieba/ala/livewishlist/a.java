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
    private ViewGroup hGS;
    protected WishListEntryView hGT;
    private ViewGroup.LayoutParams hip;
    private Context mContext;
    private BdUniqueId gER = BdUniqueId.gen();
    private boolean gEp = true;
    private boolean hGU = true;
    private boolean hGV = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.l.a
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bNk = viewGroup;
            this.hip = layoutParams;
            bUk();
        }
    }

    private void bUk() {
        this.hGS = new FrameLayout(this.bNk.getContext());
        this.hGS.setBackgroundColor(0);
        this.hGS.setId(a.f.wish_layout_id);
        this.bNk.addView(this.hGS, this.hip);
    }

    @Override // com.baidu.live.l.a
    public void a(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.aFN = wVar;
            if (this.hGS == null || this.bNk.indexOfChild(this.hGS) < 0) {
                bUk();
                this.hGS.setVisibility(this.gEp ? 0 : 8);
            }
            if (this.hGT == null) {
                this.hGT = new WishListEntryView(this.mContext);
                this.hGT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Mq();
                    }
                });
                this.hGT.setOnScrollTextViewChangeListener(this);
            }
            if (this.hGS != null && this.hGS.indexOfChild(this.hGT) < 0) {
                this.hGS.addView(this.hGT, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hGV) {
                if (this.hGT != null) {
                    this.hGT.ai(this.aFN.aKw);
                }
                this.hGV = false;
            }
            if (ListUtils.isEmpty(this.aFN.aKw) || this.aFN.aKw.size() == 1) {
                this.hGV = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, wVar));
        }
    }

    @Override // com.baidu.live.l.a
    public void Mq() {
        if (this.aFN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.w(this.mContext, this.aFN, String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.aJV.userId), this.hGU)));
        }
    }

    @Override // com.baidu.live.l.a
    public void a(q qVar) {
    }

    @Override // com.baidu.live.l.a
    public void cd(boolean z) {
        this.hGU = z;
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.hGT != null && this.hGT.getView() != null) {
            this.hGT.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hGT != null && this.aFN != null) {
            this.hGT.ah(this.aFN.aKw);
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
        this.gEp = true;
        lY(z);
    }

    private void lY(boolean z) {
        if (this.hGT != null && (this.hGT.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGT.getParent()).removeView(this.hGT);
        }
        if (z && this.hGS != null && (this.hGS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hGS.getParent()).removeView(this.hGS);
        }
    }
}
