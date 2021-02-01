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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.l.a, ScrollTextView.c {
    private ab aDd;
    private ViewGroup bRb;
    private ViewGroup hSI;
    protected WishListEntryView hSJ;
    private ViewGroup.LayoutParams htQ;
    private Context mContext;
    private BdUniqueId gOC = BdUniqueId.gen();
    private boolean gNZ = true;
    private boolean hSK = true;
    private boolean hSL = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.l.a
    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bRb = viewGroup;
            this.htQ = layoutParams;
            bNS();
        }
    }

    private void bNS() {
        this.hSI = new FrameLayout(this.bRb.getContext());
        this.hSI.setBackgroundColor(0);
        this.hSI.setId(a.f.wish_layout_id);
        this.bRb.addView(this.hSI, this.htQ);
    }

    @Override // com.baidu.live.l.a
    public void a(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.aDd = abVar;
            if (this.hSI == null || this.bRb.indexOfChild(this.hSI) < 0) {
                bNS();
                this.hSI.setVisibility(this.gNZ ? 0 : 8);
            }
            if (this.hSJ == null) {
                this.hSJ = new WishListEntryView(this.mContext);
                this.hSJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Jo();
                    }
                });
                this.hSJ.setOnScrollTextViewChangeListener(this);
            }
            if (this.hSI != null && this.hSI.indexOfChild(this.hSJ) < 0) {
                this.hSI.addView(this.hSJ, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hSL) {
                if (this.hSJ != null) {
                    this.hSJ.ac(this.aDd.aIE);
                }
                this.hSL = false;
            }
            if (ListUtils.isEmpty(this.aDd.aIE) || this.aDd.aIE.size() == 1) {
                this.hSL = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, abVar));
        }
    }

    @Override // com.baidu.live.l.a
    public void Jo() {
        if (this.aDd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this.mContext, this.aDd, String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.aId.userId), this.hSK)));
        }
    }

    @Override // com.baidu.live.l.a
    public void a(v vVar) {
    }

    @Override // com.baidu.live.l.a
    public void ch(boolean z) {
        this.hSK = z;
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.hSJ != null && this.hSJ.getView() != null) {
            this.hSJ.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hSJ != null && this.aDd != null) {
            this.hSJ.ab(this.aDd.aIE);
        }
    }

    @Override // com.baidu.live.l.a
    public void xh() {
        mv(true);
    }

    @Override // com.baidu.live.l.a
    public void onDestroy() {
        mv(true);
    }

    private void reset(boolean z) {
        this.gNZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.hSJ != null && (this.hSJ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSJ.getParent()).removeView(this.hSJ);
        }
        if (z && this.hSI != null && (this.hSI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSI.getParent()).removeView(this.hSI);
        }
    }
}
