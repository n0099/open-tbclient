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
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.m.a, ScrollTextView.c {
    private x aGe;
    private ViewGroup bRX;
    private ViewGroup hSS;
    protected WishListEntryView hST;
    private ViewGroup.LayoutParams hul;
    private Context mContext;
    private BdUniqueId gQC = BdUniqueId.gen();
    private boolean gPZ = true;
    private boolean hSU = true;
    private boolean hSV = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.m.a
    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bRX = viewGroup;
            this.hul = layoutParams;
            bRi();
        }
    }

    private void bRi() {
        this.hSS = new FrameLayout(this.bRX.getContext());
        this.hSS.setBackgroundColor(0);
        this.hSS.setId(a.f.wish_layout_id);
        this.bRX.addView(this.hSS, this.hul);
    }

    @Override // com.baidu.live.m.a
    public void a(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.aGe = xVar;
            if (this.hSS == null || this.bRX.indexOfChild(this.hSS) < 0) {
                bRi();
                this.hSS.setVisibility(this.gPZ ? 0 : 8);
            }
            if (this.hST == null) {
                this.hST = new WishListEntryView(this.mContext);
                this.hST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.LN();
                    }
                });
                this.hST.setOnScrollTextViewChangeListener(this);
            }
            if (this.hSS != null && this.hSS.indexOfChild(this.hST) < 0) {
                this.hSS.addView(this.hST, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hSV) {
                if (this.hST != null) {
                    this.hST.ai(this.aGe.aKV);
                }
                this.hSV = false;
            }
            if (ListUtils.isEmpty(this.aGe.aKV) || this.aGe.aKV.size() == 1) {
                this.hSV = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, xVar));
        }
    }

    @Override // com.baidu.live.m.a
    public void LN() {
        if (this.aGe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this.mContext, this.aGe, String.valueOf(this.aGe.mLiveInfo.live_id), String.valueOf(this.aGe.aKu.userId), this.hSU)));
        }
    }

    @Override // com.baidu.live.m.a
    public void a(r rVar) {
    }

    @Override // com.baidu.live.m.a
    public void cd(boolean z) {
        this.hSU = z;
    }

    @Override // com.baidu.live.m.a
    public void setCanVisible(boolean z) {
        if (this.hST != null && this.hST.getView() != null) {
            this.hST.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hST != null && this.aGe != null) {
            this.hST.ah(this.aGe.aKV);
        }
    }

    @Override // com.baidu.live.m.a
    public void Bf() {
        mv(true);
    }

    @Override // com.baidu.live.m.a
    public void onDestroy() {
        mv(true);
    }

    private void reset(boolean z) {
        this.gPZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.hST != null && (this.hST.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hST.getParent()).removeView(this.hST);
        }
        if (z && this.hSS != null && (this.hSS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSS.getParent()).removeView(this.hSS);
        }
    }
}
