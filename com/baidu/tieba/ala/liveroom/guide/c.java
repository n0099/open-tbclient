package com.baidu.tieba.ala.liveroom.guide;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private AlaLiveGuardUpSlideView hFU;
    private ViewGroup hFV;
    private boolean hFW;
    AlaLiveGuardUpSlideView.a hFX;
    private com.baidu.live.liveroom.a.a hvE;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hFX = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void op(boolean z2) {
                c.this.cfQ();
            }
        };
        this.hvE = aVar;
        this.hFW = z;
    }

    public boolean cfP() {
        return this.hFU != null && this.hFU.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfQ() {
        if (this.hFV != null && this.hFU != null) {
            if (this.hFU != null) {
                this.hFU.onDestroy();
                this.hFU.setVisibility(8);
            }
            if (this.hFV.indexOfChild(this.hFU) >= 0) {
                this.hFV.removeView(this.hFU);
            }
            if (this.hvE != null) {
                this.hvE.dH(3);
            }
        }
    }

    private void cfR() {
        if (this.hFV != null && this.hFU != null && this.hFV.indexOfChild(this.hFU) < 0) {
            this.hFV.addView(this.hFU, new FrameLayout.LayoutParams(this.hFV.getWidth(), this.hFV.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aI(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.xf().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hFU == null) {
            this.hFV = viewGroup;
            this.hFU = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hFW);
            this.hFU.setVisibility(0);
            this.hFU.setOnEndListener(this.hFX);
        } else if (this.hFU.getVisibility() == 0) {
            cfQ();
            return true;
        }
        cfR();
        this.hFU.setVisibility(0);
        this.hFU.cfS();
        SharedPrefHelper.getInstance().putBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", true);
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", "guide");
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hFV != null && this.hFU != null) {
            if (this.hFV.indexOfChild(this.hFU) > 0) {
                this.hFV.removeView(this.hFU);
            }
            this.hFU.onDestroy();
            this.hFU = null;
        }
    }
}
