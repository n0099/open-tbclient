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
    private AlaLiveGuardUpSlideView fHg;
    private ViewGroup fHh;
    private boolean fHi;
    AlaLiveGuardUpSlideView.a fHj;
    private com.baidu.live.liveroom.a.a fyI;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fHj = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void ku(boolean z2) {
                c.this.bvP();
            }
        };
        this.fyI = aVar;
        this.fHi = z;
    }

    public boolean bvO() {
        return this.fHg != null && this.fHg.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvP() {
        if (this.fHh != null && this.fHg != null) {
            if (this.fHg != null) {
                this.fHg.onDestroy();
                this.fHg.setVisibility(8);
            }
            if (this.fHh.indexOfChild(this.fHg) >= 0) {
                this.fHh.removeView(this.fHg);
            }
            if (this.fyI != null) {
                this.fyI.ct(3);
            }
        }
    }

    private void bvQ() {
        if (this.fHh != null && this.fHg != null && this.fHh.indexOfChild(this.fHg) < 0) {
            this.fHh.addView(this.fHg, new FrameLayout.LayoutParams(this.fHh.getWidth(), this.fHh.getHeight()));
        }
    }

    public void bm(int i, int i2) {
    }

    public boolean aj(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.tG().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fHg == null) {
            this.fHh = viewGroup;
            this.fHg = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fHi);
            this.fHg.setVisibility(0);
            this.fHg.setOnEndListener(this.fHj);
        } else if (this.fHg.getVisibility() == 0) {
            bvP();
            return true;
        }
        bvQ();
        this.fHg.setVisibility(0);
        this.fHg.bvR();
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
        if (this.fHh != null && this.fHg != null) {
            if (this.fHh.indexOfChild(this.fHg) > 0) {
                this.fHh.removeView(this.fHg);
            }
            this.fHg.onDestroy();
            this.fHg = null;
        }
    }
}
