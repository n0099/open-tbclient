package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.q;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.g;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.h.a, ScrollTextView.c {
    private k aio;
    private ViewGroup eqG;
    private ViewGroup.LayoutParams eqH;
    private ViewGroup eqI;
    protected WishListEntryView fiF;
    private Context mContext;
    private BdUniqueId erl = BdUniqueId.gen();
    private boolean eqM = true;
    private boolean fiG = true;
    private boolean fiH = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.h.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.eqG = viewGroup;
        this.eqH = layoutParams;
        bbg();
    }

    private void bbg() {
        this.eqI = new FrameLayout(this.eqG.getContext());
        this.eqI.setBackgroundColor(0);
        this.eqG.addView(this.eqI, this.eqH);
    }

    @Override // com.baidu.live.h.a
    public void a(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null) {
            this.aio = kVar;
            if (this.eqI == null || this.eqG.indexOfChild(this.eqI) < 0) {
                bbg();
                this.eqI.setVisibility(this.eqM ? 0 : 8);
            }
            if (this.fiF == null || (this.eqI != null && this.eqI.indexOfChild(this.fiF) < 0)) {
                this.fiF = new WishListEntryView(this.eqI.getContext());
                this.eqI.addView(this.fiF, new FrameLayout.LayoutParams(-2, -2));
                this.fiF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.tS();
                    }
                });
                this.fiF.setOnScrollTextViewChangeListener(this);
            }
            if (this.fiH) {
                if (this.fiF != null) {
                    this.fiF.X(this.aio.We);
                }
                this.fiH = false;
            }
            if (ListUtils.isEmpty(this.aio.We) || this.aio.We.size() == 1) {
                this.fiH = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913145, kVar));
        }
    }

    @Override // com.baidu.live.h.a
    public void tS() {
        if (this.aio != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(this.mContext, this.aio, String.valueOf(this.aio.mLiveInfo.live_id), String.valueOf(this.aio.VP.userId), this.fiG)));
        }
    }

    @Override // com.baidu.live.h.a
    public void a(g gVar) {
    }

    @Override // com.baidu.live.h.a
    public void aK(boolean z) {
        this.fiG = z;
    }

    @Override // com.baidu.live.h.a
    public void setCanVisible(boolean z) {
        if (this.fiF != null && this.fiF.getView() != null) {
            this.fiF.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fiF != null && this.aio != null) {
            this.fiF.W(this.aio.We);
        }
    }

    @Override // com.baidu.live.h.a
    public void tT() {
        hG(true);
    }

    @Override // com.baidu.live.h.a
    public void onDestroy() {
        hG(true);
    }

    private void reset(boolean z) {
        this.eqM = true;
        hG(z);
    }

    private void hG(boolean z) {
        if (this.fiF != null && (this.fiF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fiF.getParent()).removeView(this.fiF);
        }
        if (z && this.eqI != null && (this.eqI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eqI.getParent()).removeView(this.eqI);
        }
    }
}
