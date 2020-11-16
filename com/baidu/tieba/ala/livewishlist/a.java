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
    private w aDh;
    private ViewGroup bIc;
    private ViewGroup.LayoutParams gYE;
    private ViewGroup hxl;
    protected WishListEntryView hxm;
    private Context mContext;
    private BdUniqueId gwg = BdUniqueId.gen();
    private boolean gvD = true;
    private boolean hxn = true;
    private boolean hxo = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.j.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bIc = viewGroup;
            this.gYE = layoutParams;
            bQz();
        }
    }

    private void bQz() {
        this.hxl = new FrameLayout(this.bIc.getContext());
        this.hxl.setBackgroundColor(0);
        this.hxl.setId(a.f.wish_layout_id);
        this.bIc.addView(this.hxl, this.gYE);
    }

    @Override // com.baidu.live.j.a
    public void a(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.aDh = wVar;
            if (this.hxl == null || this.bIc.indexOfChild(this.hxl) < 0) {
                bQz();
                this.hxl.setVisibility(this.gvD ? 0 : 8);
            }
            if (this.hxm == null) {
                this.hxm = new WishListEntryView(this.mContext);
                this.hxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Ko();
                    }
                });
                this.hxm.setOnScrollTextViewChangeListener(this);
            }
            if (this.hxl != null && this.hxl.indexOfChild(this.hxm) < 0) {
                this.hxl.addView(this.hxm, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hxo) {
                if (this.hxm != null) {
                    this.hxm.ah(this.aDh.aHL);
                }
                this.hxo = false;
            }
            if (ListUtils.isEmpty(this.aDh.aHL) || this.aDh.aHL.size() == 1) {
                this.hxo = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, wVar));
        }
    }

    @Override // com.baidu.live.j.a
    public void Ko() {
        if (this.aDh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(this.mContext, this.aDh, String.valueOf(this.aDh.mLiveInfo.live_id), String.valueOf(this.aDh.aHk.userId), this.hxn)));
        }
    }

    @Override // com.baidu.live.j.a
    public void a(q qVar) {
    }

    @Override // com.baidu.live.j.a
    public void bU(boolean z) {
        this.hxn = z;
    }

    @Override // com.baidu.live.j.a
    public void setCanVisible(boolean z) {
        if (this.hxm != null && this.hxm.getView() != null) {
            this.hxm.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hxm != null && this.aDh != null) {
            this.hxm.ag(this.aDh.aHL);
        }
    }

    @Override // com.baidu.live.j.a
    public void Ka() {
        lD(true);
    }

    @Override // com.baidu.live.j.a
    public void onDestroy() {
        lD(true);
    }

    private void reset(boolean z) {
        this.gvD = true;
        lD(z);
    }

    private void lD(boolean z) {
        if (this.hxm != null && (this.hxm.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hxm.getParent()).removeView(this.hxm);
        }
        if (z && this.hxl != null && (this.hxl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hxl.getParent()).removeView(this.hxl);
        }
    }
}
