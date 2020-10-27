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
    private w aEc;
    private ViewGroup bEg;
    private ViewGroup.LayoutParams gSS;
    private ViewGroup hrH;
    protected WishListEntryView hrI;
    private Context mContext;
    private BdUniqueId gqL = BdUniqueId.gen();
    private boolean gqi = true;
    private boolean hrJ = true;
    private boolean hrK = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.j.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bEg = viewGroup;
            this.gSS = layoutParams;
            bOG();
        }
    }

    private void bOG() {
        this.hrH = new FrameLayout(this.bEg.getContext());
        this.hrH.setBackgroundColor(0);
        this.hrH.setId(a.g.wish_layout_id);
        this.bEg.addView(this.hrH, this.gSS);
    }

    @Override // com.baidu.live.j.a
    public void a(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.aEc = wVar;
            if (this.hrH == null || this.bEg.indexOfChild(this.hrH) < 0) {
                bOG();
                this.hrH.setVisibility(this.gqi ? 0 : 8);
            }
            if (this.hrI == null) {
                this.hrI = new WishListEntryView(this.mContext);
                this.hrI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Kx();
                    }
                });
                this.hrI.setOnScrollTextViewChangeListener(this);
            }
            if (this.hrH != null && this.hrH.indexOfChild(this.hrI) < 0) {
                this.hrH.addView(this.hrI, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hrK) {
                if (this.hrI != null) {
                    this.hrI.ah(this.aEc.aIF);
                }
                this.hrK = false;
            }
            if (ListUtils.isEmpty(this.aEc.aIF) || this.aEc.aIF.size() == 1) {
                this.hrK = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, wVar));
        }
    }

    @Override // com.baidu.live.j.a
    public void Kx() {
        if (this.aEc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(this.mContext, this.aEc, String.valueOf(this.aEc.mLiveInfo.live_id), String.valueOf(this.aEc.aIe.userId), this.hrJ)));
        }
    }

    @Override // com.baidu.live.j.a
    public void a(q qVar) {
    }

    @Override // com.baidu.live.j.a
    public void bR(boolean z) {
        this.hrJ = z;
    }

    @Override // com.baidu.live.j.a
    public void setCanVisible(boolean z) {
        if (this.hrI != null && this.hrI.getView() != null) {
            this.hrI.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hrI != null && this.aEc != null) {
            this.hrI.ag(this.aEc.aIF);
        }
    }

    @Override // com.baidu.live.j.a
    public void Kj() {
        lt(true);
    }

    @Override // com.baidu.live.j.a
    public void onDestroy() {
        lt(true);
    }

    private void reset(boolean z) {
        this.gqi = true;
        lt(z);
    }

    private void lt(boolean z) {
        if (this.hrI != null && (this.hrI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hrI.getParent()).removeView(this.hrI);
        }
        if (z && this.hrH != null && (this.hrH.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hrH.getParent()).removeView(this.hrH);
        }
    }
}
