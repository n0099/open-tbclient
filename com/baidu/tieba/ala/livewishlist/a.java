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
    private m ale;
    private ViewGroup ewr;
    private ViewGroup.LayoutParams ews;
    private ViewGroup ewt;
    protected WishListEntryView foH;
    private Context mContext;
    private BdUniqueId ewV = BdUniqueId.gen();
    private boolean ewx = true;
    private boolean foI = true;
    private boolean foJ = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewr = viewGroup;
        this.ews = layoutParams;
        bdT();
    }

    private void bdT() {
        this.ewt = new FrameLayout(this.ewr.getContext());
        this.ewt.setBackgroundColor(0);
        this.ewr.addView(this.ewt, this.ews);
    }

    @Override // com.baidu.live.i.a
    public void a(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.ale = mVar;
            if (this.ewt == null || this.ewr.indexOfChild(this.ewt) < 0) {
                bdT();
                this.ewt.setVisibility(this.ewx ? 0 : 8);
            }
            if (this.foH == null || (this.ewt != null && this.ewt.indexOfChild(this.foH) < 0)) {
                this.foH = new WishListEntryView(this.ewt.getContext());
                this.ewt.addView(this.foH, new FrameLayout.LayoutParams(-2, -2));
                this.foH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.vO();
                    }
                });
                this.foH.setOnScrollTextViewChangeListener(this);
            }
            if (this.foJ) {
                if (this.foH != null) {
                    this.foH.Y(this.ale.Yg);
                }
                this.foJ = false;
            }
            if (ListUtils.isEmpty(this.ale.Yg) || this.ale.Yg.size() == 1) {
                this.foJ = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, mVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void vO() {
        if (this.ale != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.ale, String.valueOf(this.ale.mLiveInfo.live_id), String.valueOf(this.ale.XQ.userId), this.foI)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void aP(boolean z) {
        this.foI = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.foH != null && this.foH.getView() != null) {
            this.foH.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.foH != null && this.ale != null) {
            this.foH.X(this.ale.Yg);
        }
    }

    @Override // com.baidu.live.i.a
    public void vL() {
        hS(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        hS(true);
    }

    private void reset(boolean z) {
        this.ewx = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.foH != null && (this.foH.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foH.getParent()).removeView(this.foH);
        }
        if (z && this.ewt != null && (this.ewt.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewt.getParent()).removeView(this.ewt);
        }
    }
}
