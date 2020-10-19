package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.t;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private u aDU;
    private ViewGroup bBk;
    private ViewGroup.LayoutParams gHd;
    private ViewGroup hfI;
    protected WishListEntryView hfJ;
    private Context mContext;
    private BdUniqueId ggI = BdUniqueId.gen();
    private boolean ggf = true;
    private boolean hfK = true;
    private boolean hfL = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bBk = viewGroup;
            this.gHd = layoutParams;
            bMe();
        }
    }

    private void bMe() {
        this.hfI = new FrameLayout(this.bBk.getContext());
        this.hfI.setBackgroundColor(0);
        this.hfI.setId(a.g.wish_layout_id);
        this.bBk.addView(this.hfI, this.gHd);
    }

    @Override // com.baidu.live.i.a
    public void a(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null) {
            this.aDU = uVar;
            if (this.hfI == null || this.bBk.indexOfChild(this.hfI) < 0) {
                bMe();
                this.hfI.setVisibility(this.ggf ? 0 : 8);
            }
            if (this.hfJ == null) {
                this.hfJ = new WishListEntryView(this.mContext);
                this.hfJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Kd();
                    }
                });
                this.hfJ.setOnScrollTextViewChangeListener(this);
            }
            if (this.hfI != null && this.hfI.indexOfChild(this.hfJ) < 0) {
                this.hfI.addView(this.hfJ, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hfL) {
                if (this.hfJ != null) {
                    this.hfJ.ag(this.aDU.aIi);
                }
                this.hfL = false;
            }
            if (ListUtils.isEmpty(this.aDU.aIi) || this.aDU.aIi.size() == 1) {
                this.hfL = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, uVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void Kd() {
        if (this.aDU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this.mContext, this.aDU, String.valueOf(this.aDU.mLiveInfo.live_id), String.valueOf(this.aDU.aHD.userId), this.hfK)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(n nVar) {
    }

    @Override // com.baidu.live.i.a
    public void bP(boolean z) {
        this.hfK = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.hfJ != null && this.hfJ.getView() != null) {
            this.hfJ.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hfJ != null && this.aDU != null) {
            this.hfJ.af(this.aDU.aIi);
        }
    }

    @Override // com.baidu.live.i.a
    public void JQ() {
        lb(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        lb(true);
    }

    private void reset(boolean z) {
        this.ggf = true;
        lb(z);
    }

    private void lb(boolean z) {
        if (this.hfJ != null && (this.hfJ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hfJ.getParent()).removeView(this.hfJ);
        }
        if (z && this.hfI != null && (this.hfI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hfI.getParent()).removeView(this.hfI);
        }
    }
}
