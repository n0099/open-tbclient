package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.s;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private q aLQ;
    private ViewGroup fIb;
    private ViewGroup.LayoutParams fYb;
    private ViewGroup gvx;
    protected WishListEntryView gvy;
    private Context mContext;
    private BdUniqueId fAz = BdUniqueId.gen();
    private boolean fAa = true;
    private boolean gvz = true;
    private boolean gvA = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.fIb = viewGroup;
            this.fYb = layoutParams;
            bvX();
        }
    }

    private void bvX() {
        this.gvx = new FrameLayout(this.fIb.getContext());
        this.gvx.setBackgroundColor(0);
        this.fIb.addView(this.gvx, this.fYb);
    }

    @Override // com.baidu.live.i.a
    public void a(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.aLQ = qVar;
            if (this.gvx == null || this.fIb.indexOfChild(this.gvx) < 0) {
                bvX();
                this.gvx.setVisibility(this.fAa ? 0 : 8);
            }
            if (this.gvy == null || (this.gvx != null && this.gvx.indexOfChild(this.gvy) < 0)) {
                this.gvy = new WishListEntryView(this.gvx.getContext());
                this.gvx.addView(this.gvy, new FrameLayout.LayoutParams(-2, -2));
                this.gvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Co();
                    }
                });
                this.gvy.setOnScrollTextViewChangeListener(this);
            }
            if (this.gvA) {
                if (this.gvy != null) {
                    this.gvy.Z(this.aLQ.axL);
                }
                this.gvA = false;
            }
            if (ListUtils.isEmpty(this.aLQ.axL) || this.aLQ.axL.size() == 1) {
                this.gvA = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, qVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void Co() {
        if (this.aLQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aLQ, String.valueOf(this.aLQ.mLiveInfo.live_id), String.valueOf(this.aLQ.axp.userId), this.gvz)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.live.i.a
    public void bC(boolean z) {
        this.gvz = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.gvy != null && this.gvy.getView() != null) {
            this.gvy.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.gvy != null && this.aLQ != null) {
            this.gvy.Y(this.aLQ.axL);
        }
    }

    @Override // com.baidu.live.i.a
    public void Cl() {
        jx(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        jx(true);
    }

    private void reset(boolean z) {
        this.fAa = true;
        jx(z);
    }

    private void jx(boolean z) {
        if (this.gvy != null && (this.gvy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvy.getParent()).removeView(this.gvy);
        }
        if (z && this.gvx != null && (this.gvx.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvx.getParent()).removeView(this.gvx);
        }
    }
}
