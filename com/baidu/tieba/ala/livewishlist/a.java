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
    private n aDK;
    protected WishListEntryView fTH;
    private ViewGroup faV;
    private ViewGroup.LayoutParams faW;
    private ViewGroup faX;
    private Context mContext;
    private BdUniqueId fbA = BdUniqueId.gen();
    private boolean fbb = true;
    private boolean fTI = true;
    private boolean fTJ = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.faV = viewGroup;
        this.faW = layoutParams;
        bni();
    }

    private void bni() {
        this.faX = new FrameLayout(this.faV.getContext());
        this.faX.setBackgroundColor(0);
        this.faV.addView(this.faX, this.faW);
    }

    @Override // com.baidu.live.i.a
    public void a(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null) {
            this.aDK = nVar;
            if (this.faX == null || this.faV.indexOfChild(this.faX) < 0) {
                bni();
                this.faX.setVisibility(this.fbb ? 0 : 8);
            }
            if (this.fTH == null || (this.faX != null && this.faX.indexOfChild(this.fTH) < 0)) {
                this.fTH = new WishListEntryView(this.faX.getContext());
                this.faX.addView(this.fTH, new FrameLayout.LayoutParams(-2, -2));
                this.fTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Ay();
                    }
                });
                this.fTH.setOnScrollTextViewChangeListener(this);
            }
            if (this.fTJ) {
                if (this.fTH != null) {
                    this.fTH.Z(this.aDK.aqG);
                }
                this.fTJ = false;
            }
            if (ListUtils.isEmpty(this.aDK.aqG) || this.aDK.aqG.size() == 1) {
                this.fTJ = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, nVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void Ay() {
        if (this.aDK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aDK, String.valueOf(this.aDK.mLiveInfo.live_id), String.valueOf(this.aDK.aqk.userId), this.fTI)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void bs(boolean z) {
        this.fTI = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.fTH != null && this.fTH.getView() != null) {
            this.fTH.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fTH != null && this.aDK != null) {
            this.fTH.Y(this.aDK.aqG);
        }
    }

    @Override // com.baidu.live.i.a
    public void Av() {
        iS(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        iS(true);
    }

    private void reset(boolean z) {
        this.fbb = true;
        iS(z);
    }

    private void iS(boolean z) {
        if (this.fTH != null && (this.fTH.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fTH.getParent()).removeView(this.fTH);
        }
        if (z && this.faX != null && (this.faX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.faX.getParent()).removeView(this.faX);
        }
    }
}
