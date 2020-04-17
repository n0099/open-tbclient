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
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private AlaLiveGuardUpSlideView fHb;
    private ViewGroup fHc;
    private boolean fHd;
    AlaLiveGuardUpSlideView.a fHe;
    private com.baidu.live.liveroom.a.a fyD;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fHe = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void ku(boolean z2) {
                c.this.bvR();
            }
        };
        this.fyD = aVar;
        this.fHd = z;
    }

    public boolean bvQ() {
        return this.fHb != null && this.fHb.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvR() {
        if (this.fHc != null && this.fHb != null) {
            if (this.fHb != null) {
                this.fHb.onDestroy();
                this.fHb.setVisibility(8);
            }
            if (this.fHc.indexOfChild(this.fHb) >= 0) {
                this.fHc.removeView(this.fHb);
            }
            if (this.fyD != null) {
                this.fyD.ct(3);
            }
        }
    }

    private void bvS() {
        if (this.fHc != null && this.fHb != null && this.fHc.indexOfChild(this.fHb) < 0) {
            this.fHc.addView(this.fHb, new FrameLayout.LayoutParams(this.fHc.getWidth(), this.fHc.getHeight()));
        }
    }

    public void bm(int i, int i2) {
    }

    public boolean aj(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.tH().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fHb == null) {
            this.fHc = viewGroup;
            this.fHb = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fHd);
            this.fHb.setVisibility(0);
            this.fHb.setOnEndListener(this.fHe);
        } else if (this.fHb.getVisibility() == 0) {
            bvR();
            return true;
        }
        bvS();
        this.fHb.setVisibility(0);
        this.fHb.bvT();
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
        if (this.fHc != null && this.fHb != null) {
            if (this.fHc.indexOfChild(this.fHb) > 0) {
                this.fHc.removeView(this.fHb);
            }
            this.fHb.onDestroy();
            this.fHb = null;
        }
    }
}
