package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.w;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.ab;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.l.a, ScrollTextView.c {
    private ab aED;
    private ViewGroup bSB;
    private ViewGroup hUF;
    protected WishListEntryView hUG;
    private ViewGroup.LayoutParams hvN;
    private Context mContext;
    private BdUniqueId gQz = BdUniqueId.gen();
    private boolean gPW = true;
    private boolean hUH = true;
    private boolean hUI = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.l.a
    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bSB = viewGroup;
            this.hvN = layoutParams;
            bOf();
        }
    }

    private void bOf() {
        this.hUF = new FrameLayout(this.bSB.getContext());
        this.hUF.setBackgroundColor(0);
        this.hUF.setId(a.f.wish_layout_id);
        this.bSB.addView(this.hUF, this.hvN);
    }

    @Override // com.baidu.live.l.a
    public void a(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.aED = abVar;
            if (this.hUF == null || this.bSB.indexOfChild(this.hUF) < 0) {
                bOf();
                this.hUF.setVisibility(this.gPW ? 0 : 8);
            }
            if (this.hUG == null) {
                this.hUG = new WishListEntryView(this.mContext);
                this.hUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Jr();
                    }
                });
                this.hUG.setOnScrollTextViewChangeListener(this);
            }
            if (this.hUF != null && this.hUF.indexOfChild(this.hUG) < 0) {
                this.hUF.addView(this.hUG, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hUI) {
                if (this.hUG != null) {
                    this.hUG.ac(this.aED.aKe);
                }
                this.hUI = false;
            }
            if (ListUtils.isEmpty(this.aED.aKe) || this.aED.aKe.size() == 1) {
                this.hUI = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, abVar));
        }
    }

    @Override // com.baidu.live.l.a
    public void Jr() {
        if (this.aED != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this.mContext, this.aED, String.valueOf(this.aED.mLiveInfo.live_id), String.valueOf(this.aED.aJD.userId), this.hUH)));
        }
    }

    @Override // com.baidu.live.l.a
    public void a(v vVar) {
    }

    @Override // com.baidu.live.l.a
    public void ch(boolean z) {
        this.hUH = z;
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.hUG != null && this.hUG.getView() != null) {
            this.hUG.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hUG != null && this.aED != null) {
            this.hUG.ab(this.aED.aKe);
        }
    }

    @Override // com.baidu.live.l.a
    public void xk() {
        mv(true);
    }

    @Override // com.baidu.live.l.a
    public void onDestroy() {
        mv(true);
    }

    private void reset(boolean z) {
        this.gPW = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.hUG != null && (this.hUG.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hUG.getParent()).removeView(this.hUG);
        }
        if (z && this.hUF != null && (this.hUF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hUF.getParent()).removeView(this.hUF);
        }
    }
}
