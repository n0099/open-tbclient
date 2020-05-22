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
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private q aJj;
    private ViewGroup fox;
    private ViewGroup.LayoutParams foy;
    private ViewGroup foz;
    protected WishListEntryView giA;
    private Context mContext;
    private BdUniqueId fpc = BdUniqueId.gen();
    private boolean foD = true;
    private boolean giB = true;
    private boolean giC = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.fox = viewGroup;
        this.foy = layoutParams;
        bta();
    }

    private void bta() {
        this.foz = new FrameLayout(this.fox.getContext());
        this.foz.setBackgroundColor(0);
        this.fox.addView(this.foz, this.foy);
    }

    @Override // com.baidu.live.i.a
    public void a(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.aJj = qVar;
            if (this.foz == null || this.fox.indexOfChild(this.foz) < 0) {
                bta();
                this.foz.setVisibility(this.foD ? 0 : 8);
            }
            if (this.giA == null || (this.foz != null && this.foz.indexOfChild(this.giA) < 0)) {
                this.giA = new WishListEntryView(this.foz.getContext());
                this.foz.addView(this.giA, new FrameLayout.LayoutParams(-2, -2));
                this.giA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.BO();
                    }
                });
                this.giA.setOnScrollTextViewChangeListener(this);
            }
            if (this.giC) {
                if (this.giA != null) {
                    this.giA.Z(this.aJj.avF);
                }
                this.giC = false;
            }
            if (ListUtils.isEmpty(this.aJj.avF) || this.aJj.avF.size() == 1) {
                this.giC = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, qVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void BO() {
        if (this.aJj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aJj, String.valueOf(this.aJj.mLiveInfo.live_id), String.valueOf(this.aJj.avj.userId), this.giB)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bC(boolean z) {
        this.giB = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.giA != null && this.giA.getView() != null) {
            this.giA.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.giA != null && this.aJj != null) {
            this.giA.Y(this.aJj.avF);
        }
    }

    @Override // com.baidu.live.i.a
    public void BL() {
        jk(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        jk(true);
    }

    private void reset(boolean z) {
        this.foD = true;
        jk(z);
    }

    private void jk(boolean z) {
        if (this.giA != null && (this.giA.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.giA.getParent()).removeView(this.giA);
        }
        if (z && this.foz != null && (this.foz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foz.getParent()).removeView(this.foz);
        }
    }
}
