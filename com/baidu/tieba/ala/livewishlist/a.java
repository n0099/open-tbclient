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
    private ViewGroup hSW;
    protected WishListEntryView hSX;
    private ViewGroup.LayoutParams hue;
    private Context mContext;
    private BdUniqueId gOQ = BdUniqueId.gen();
    private boolean gOn = true;
    private boolean hSY = true;
    private boolean hSZ = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.l.a
    public void d(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.bRb = viewGroup;
            this.hue = layoutParams;
            bNZ();
        }
    }

    private void bNZ() {
        this.hSW = new FrameLayout(this.bRb.getContext());
        this.hSW.setBackgroundColor(0);
        this.hSW.setId(a.f.wish_layout_id);
        this.bRb.addView(this.hSW, this.hue);
    }

    @Override // com.baidu.live.l.a
    public void a(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.aDd = abVar;
            if (this.hSW == null || this.bRb.indexOfChild(this.hSW) < 0) {
                bNZ();
                this.hSW.setVisibility(this.gOn ? 0 : 8);
            }
            if (this.hSX == null) {
                this.hSX = new WishListEntryView(this.mContext);
                this.hSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Jo();
                    }
                });
                this.hSX.setOnScrollTextViewChangeListener(this);
            }
            if (this.hSW != null && this.hSW.indexOfChild(this.hSX) < 0) {
                this.hSW.addView(this.hSX, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.hSZ) {
                if (this.hSX != null) {
                    this.hSX.ac(this.aDd.aIE);
                }
                this.hSZ = false;
            }
            if (ListUtils.isEmpty(this.aDd.aIE) || this.aDd.aIE.size() == 1) {
                this.hSZ = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, abVar));
        }
    }

    @Override // com.baidu.live.l.a
    public void Jo() {
        if (this.aDd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this.mContext, this.aDd, String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.aId.userId), this.hSY)));
        }
    }

    @Override // com.baidu.live.l.a
    public void a(v vVar) {
    }

    @Override // com.baidu.live.l.a
    public void ch(boolean z) {
        this.hSY = z;
    }

    @Override // com.baidu.live.l.a
    public void setCanVisible(boolean z) {
        if (this.hSX != null && this.hSX.getView() != null) {
            this.hSX.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.hSX != null && this.aDd != null) {
            this.hSX.ab(this.aDd.aIE);
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
        this.gOn = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.hSX != null && (this.hSX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSX.getParent()).removeView(this.hSX);
        }
        if (z && this.hSW != null && (this.hSW.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSW.getParent()).removeView(this.hSW);
        }
    }
}
