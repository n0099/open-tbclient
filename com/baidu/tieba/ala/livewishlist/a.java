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
    private r aAh;
    private ViewGroup fZu;
    private ViewGroup gNr;
    protected WishListEntryView gNs;
    private ViewGroup.LayoutParams gpq;
    private Context mContext;
    private BdUniqueId fRa = BdUniqueId.gen();
    private boolean fQy = true;
    private boolean gNt = true;
    private boolean gNu = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.fZu = viewGroup;
            this.gpq = layoutParams;
            bIl();
        }
    }

    private void bIl() {
        this.gNr = new FrameLayout(this.fZu.getContext());
        this.gNr.setBackgroundColor(0);
        this.fZu.addView(this.gNr, this.gpq);
    }

    @Override // com.baidu.live.i.a
    public void a(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.aAh = rVar;
            if (this.gNr == null || this.fZu.indexOfChild(this.gNr) < 0) {
                bIl();
                this.gNr.setVisibility(this.fQy ? 0 : 8);
            }
            if (this.gNs == null || (this.gNr != null && this.gNr.indexOfChild(this.gNs) < 0)) {
                this.gNs = new WishListEntryView(this.gNr.getContext());
                this.gNr.addView(this.gNs, new FrameLayout.LayoutParams(-2, -2));
                this.gNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.It();
                    }
                });
                this.gNs.setOnScrollTextViewChangeListener(this);
            }
            if (this.gNu) {
                if (this.gNs != null) {
                    this.gNs.ag(this.aAh.aEg);
                }
                this.gNu = false;
            }
            if (ListUtils.isEmpty(this.aAh.aEg) || this.aAh.aEg.size() == 1) {
                this.gNu = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, rVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void It() {
        if (this.aAh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this.mContext, this.aAh, String.valueOf(this.aAh.mLiveInfo.live_id), String.valueOf(this.aAh.aDE.userId), this.gNt)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bK(boolean z) {
        this.gNt = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.gNs != null && this.gNs.getView() != null) {
            this.gNs.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.gNs != null && this.aAh != null) {
            this.gNs.af(this.aAh.aEg);
        }
    }

    @Override // com.baidu.live.i.a
    public void Iq() {
        kz(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        kz(true);
    }

    private void reset(boolean z) {
        this.fQy = true;
        kz(z);
    }

    private void kz(boolean z) {
        if (this.gNs != null && (this.gNs.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gNs.getParent()).removeView(this.gNs);
        }
        if (z && this.gNr != null && (this.gNr.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gNr.getParent()).removeView(this.gNr);
        }
    }
}
