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
    private m ald;
    private ViewGroup ewd;
    private ViewGroup.LayoutParams ewe;
    private ViewGroup ewf;
    protected WishListEntryView fot;
    private Context mContext;
    private BdUniqueId ewH = BdUniqueId.gen();
    private boolean ewj = true;
    private boolean fou = true;
    private boolean fov = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewd = viewGroup;
        this.ewe = layoutParams;
        bdQ();
    }

    private void bdQ() {
        this.ewf = new FrameLayout(this.ewd.getContext());
        this.ewf.setBackgroundColor(0);
        this.ewd.addView(this.ewf, this.ewe);
    }

    @Override // com.baidu.live.i.a
    public void a(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.ald = mVar;
            if (this.ewf == null || this.ewd.indexOfChild(this.ewf) < 0) {
                bdQ();
                this.ewf.setVisibility(this.ewj ? 0 : 8);
            }
            if (this.fot == null || (this.ewf != null && this.ewf.indexOfChild(this.fot) < 0)) {
                this.fot = new WishListEntryView(this.ewf.getContext());
                this.ewf.addView(this.fot, new FrameLayout.LayoutParams(-2, -2));
                this.fot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.vO();
                    }
                });
                this.fot.setOnScrollTextViewChangeListener(this);
            }
            if (this.fov) {
                if (this.fot != null) {
                    this.fot.Y(this.ald.Yg);
                }
                this.fov = false;
            }
            if (ListUtils.isEmpty(this.ald.Yg) || this.ald.Yg.size() == 1) {
                this.fov = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, mVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void vO() {
        if (this.ald != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.ald, String.valueOf(this.ald.mLiveInfo.live_id), String.valueOf(this.ald.XQ.userId), this.fou)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void aP(boolean z) {
        this.fou = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.fot != null && this.fot.getView() != null) {
            this.fot.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fot != null && this.ald != null) {
            this.fot.X(this.ald.Yg);
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
        this.ewj = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.fot != null && (this.fot.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fot.getParent()).removeView(this.fot);
        }
        if (z && this.ewf != null && (this.ewf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewf.getParent()).removeView(this.ewf);
        }
    }
}
