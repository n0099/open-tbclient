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
    private ViewGroup ewe;
    private ViewGroup.LayoutParams ewf;
    private ViewGroup ewg;
    protected WishListEntryView fou;
    private Context mContext;
    private BdUniqueId ewI = BdUniqueId.gen();
    private boolean ewk = true;
    private boolean fov = true;
    private boolean fow = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewe = viewGroup;
        this.ewf = layoutParams;
        bdS();
    }

    private void bdS() {
        this.ewg = new FrameLayout(this.ewe.getContext());
        this.ewg.setBackgroundColor(0);
        this.ewe.addView(this.ewg, this.ewf);
    }

    @Override // com.baidu.live.i.a
    public void a(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null) {
            this.ald = mVar;
            if (this.ewg == null || this.ewe.indexOfChild(this.ewg) < 0) {
                bdS();
                this.ewg.setVisibility(this.ewk ? 0 : 8);
            }
            if (this.fou == null || (this.ewg != null && this.ewg.indexOfChild(this.fou) < 0)) {
                this.fou = new WishListEntryView(this.ewg.getContext());
                this.ewg.addView(this.fou, new FrameLayout.LayoutParams(-2, -2));
                this.fou.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.vO();
                    }
                });
                this.fou.setOnScrollTextViewChangeListener(this);
            }
            if (this.fow) {
                if (this.fou != null) {
                    this.fou.Y(this.ald.Yg);
                }
                this.fow = false;
            }
            if (ListUtils.isEmpty(this.ald.Yg) || this.ald.Yg.size() == 1) {
                this.fow = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, mVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void vO() {
        if (this.ald != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.ald, String.valueOf(this.ald.mLiveInfo.live_id), String.valueOf(this.ald.XQ.userId), this.fov)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(h hVar) {
    }

    @Override // com.baidu.live.i.a
    public void aP(boolean z) {
        this.fov = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.fou != null && this.fou.getView() != null) {
            this.fou.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.fou != null && this.ald != null) {
            this.fou.X(this.ald.Yg);
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
        this.ewk = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.fou != null && (this.fou.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fou.getParent()).removeView(this.fou);
        }
        if (z && this.ewg != null && (this.ewg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewg.getParent()).removeView(this.ewg);
        }
    }
}
