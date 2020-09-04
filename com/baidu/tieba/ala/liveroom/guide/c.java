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
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private AlaLiveGuardUpSlideView gAb;
    private ViewGroup gAc;
    private boolean gAd;
    AlaLiveGuardUpSlideView.a gAe;
    private com.baidu.live.liveroom.a.a gpl;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gAe = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void mj(boolean z2) {
                c.this.bSi();
            }
        };
        this.gpl = aVar;
        this.gAd = z;
    }

    public boolean bSh() {
        return this.gAb != null && this.gAb.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSi() {
        if (this.gAc != null && this.gAb != null) {
            if (this.gAb != null) {
                this.gAb.onDestroy();
                this.gAb.setVisibility(8);
            }
            if (this.gAc.indexOfChild(this.gAb) >= 0) {
                this.gAc.removeView(this.gAb);
            }
            if (this.gpl != null) {
                this.gpl.ez(3);
            }
        }
    }

    private void bSj() {
        if (this.gAc != null && this.gAb != null && this.gAc.indexOfChild(this.gAb) < 0) {
            this.gAc.addView(this.gAb, new FrameLayout.LayoutParams(this.gAc.getWidth(), this.gAc.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean av(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.AD().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gAb == null) {
            this.gAc = viewGroup;
            this.gAb = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gAd);
            this.gAb.setVisibility(0);
            this.gAb.setOnEndListener(this.gAe);
        } else if (this.gAb.getVisibility() == 0) {
            bSi();
            return true;
        }
        bSj();
        this.gAb.setVisibility(0);
        this.gAb.bSk();
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
        if (this.gAc != null && this.gAb != null) {
            if (this.gAc.indexOfChild(this.gAb) > 0) {
                this.gAc.removeView(this.gAb);
            }
            this.gAb.onDestroy();
            this.gAb = null;
        }
    }
}
