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
import com.baidu.live.data.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private n aDE;
    protected WishListEntryView fTC;
    private ViewGroup faQ;
    private ViewGroup.LayoutParams faR;
    private ViewGroup faS;
    private Context mContext;
    private BdUniqueId fbv = BdUniqueId.gen();
    private boolean faW = true;
    private boolean fTD = true;
    private boolean fTE = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.faQ = viewGroup;
        this.faR = layoutParams;
        bnk();
    }

    private void bnk() {
        this.faS = new FrameLayout(this.faQ.getContext());
        this.faS.setBackgroundColor(0);
        this.faQ.addView(this.faS, this.faR);
    }

    @Override // com.baidu.live.i.a
    public void a(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null) {
            this.aDE = nVar;
            if (this.faS == null || this.faQ.indexOfChild(this.faS) < 0) {
                bnk();
                this.faS.setVisibility(this.faW ? 0 : 8);
            }
            if (this.fTC == null || (this.faS != null && this.faS.indexOfChild(this.fTC) < 0)) {
                this.fTC = new WishListEntryView(this.faS.getContext());
                this.faS.addView(this.fTC, new FrameLayout.LayoutParams(-2, -2));
                this.fTC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Az();
                    }
                });
                this.fTC.setOnScrollTextViewChangeListener(this);
            }
            if (this.fTE) {
                if (this.fTC != null) {
                    this.fTC.Z(this.aDE.aqA);
                }
                this.fTE = false;
            }
            if (ListUtils.isEmpty(this.aDE.aqA) || this.aDE.aqA.size() == 1) {
                this.fTE = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, nVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void Az() {
        if (this.aDE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aDE, String.valueOf(this.aDE.mLiveInfo.live_id), String.valueOf(this.aDE.aqe.userId), this.fTD)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void bs(boolean z) {
        this.fTD = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.fTC != null && this.fTC.getView() != null) {
            this.fTC.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fTC != null && this.aDE != null) {
            this.fTC.Y(this.aDE.aqA);
        }
    }

    @Override // com.baidu.live.i.a
    public void Aw() {
        iS(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        iS(true);
    }

    private void reset(boolean z) {
        this.faW = true;
        iS(z);
    }

    private void iS(boolean z) {
        if (this.fTC != null && (this.fTC.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fTC.getParent()).removeView(this.fTC);
        }
        if (z && this.faS != null && (this.faS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.faS.getParent()).removeView(this.faS);
        }
    }
}
