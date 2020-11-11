package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.v;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.j.a, ScrollTextView.c {
    private w aES;
    private ViewGroup bJN;
    private ViewGroup.LayoutParams gYX;
    private ViewGroup hxE;
    protected WishListEntryView hxF;
    private Context mContext;
    private BdUniqueId gwz = BdUniqueId.gen();
    private boolean gvW = true;
    private boolean hxG = true;
    private boolean hxH = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.j.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bJN = viewGroup;
            this.gYX = layoutParams;
            bRg();
        }
    }

    private void bRg() {
        this.hxE = new FrameLayout(this.bJN.getContext());
        this.hxE.setBackgroundColor(0);
        this.hxE.setId(a.f.wish_layout_id);
        this.bJN.addView(this.hxE, this.gYX);
    }

    @Override // com.baidu.live.j.a
    public void a(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.aES = wVar;
            if (this.hxE == null || this.bJN.indexOfChild(this.hxE) < 0) {
                bRg();
                this.hxE.setVisibility(this.gvW ? 0 : 8);
            }
            if (this.hxF == null) {
                this.hxF = new WishListEntryView(this.mContext);
                this.hxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.KX();
                    }
                });
                this.hxF.setOnScrollTextViewChangeListener(this);
            }
            if (this.hxE != null && this.hxE.indexOfChild(this.hxF) < 0) {
                this.hxE.addView(this.hxF, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hxH) {
                if (this.hxF != null) {
                    this.hxF.ah(this.aES.aJw);
                }
                this.hxH = false;
            }
            if (ListUtils.isEmpty(this.aES.aJw) || this.aES.aJw.size() == 1) {
                this.hxH = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, wVar));
        }
    }

    @Override // com.baidu.live.j.a
    public void KX() {
        if (this.aES != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(this.mContext, this.aES, String.valueOf(this.aES.mLiveInfo.live_id), String.valueOf(this.aES.aIV.userId), this.hxG)));
        }
    }

    @Override // com.baidu.live.j.a
    public void a(q qVar) {
    }

    @Override // com.baidu.live.j.a
    public void bS(boolean z) {
        this.hxG = z;
    }

    @Override // com.baidu.live.j.a
    public void setCanVisible(boolean z) {
        if (this.hxF != null && this.hxF.getView() != null) {
            this.hxF.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hxF != null && this.aES != null) {
            this.hxF.ag(this.aES.aJw);
        }
    }

    @Override // com.baidu.live.j.a
    public void KJ() {
        lC(true);
    }

    @Override // com.baidu.live.j.a
    public void onDestroy() {
        lC(true);
    }

    private void reset(boolean z) {
        this.gvW = true;
        lC(z);
    }

    private void lC(boolean z) {
        if (this.hxF != null && (this.hxF.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hxF.getParent()).removeView(this.hxF);
        }
        if (z && this.hxE != null && (this.hxE.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hxE.getParent()).removeView(this.hxE);
        }
    }
}
