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
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.live.liveroom.a.a hig;
    private boolean hsA;
    AlaLiveGuardUpSlideView.a hsB;
    private AlaLiveGuardUpSlideView hsy;
    private ViewGroup hsz;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hsB = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void nJ(boolean z2) {
                c.this.cfL();
            }
        };
        this.hig = aVar;
        this.hsA = z;
    }

    public boolean cfK() {
        return this.hsy != null && this.hsy.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        if (this.hsz != null && this.hsy != null) {
            if (this.hsy != null) {
                this.hsy.onDestroy();
                this.hsy.setVisibility(8);
            }
            if (this.hsz.indexOfChild(this.hsy) >= 0) {
                this.hsz.removeView(this.hsy);
            }
            if (this.hig != null) {
                this.hig.fi(3);
            }
        }
    }

    private void cfM() {
        if (this.hsz != null && this.hsy != null && this.hsz.indexOfChild(this.hsy) < 0) {
            this.hsz.addView(this.hsy, new FrameLayout.LayoutParams(this.hsz.getWidth(), this.hsz.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aw(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.BM().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hsy == null) {
            this.hsz = viewGroup;
            this.hsy = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hsA);
            this.hsy.setVisibility(0);
            this.hsy.setOnEndListener(this.hsB);
        } else if (this.hsy.getVisibility() == 0) {
            cfL();
            return true;
        }
        cfM();
        this.hsy.setVisibility(0);
        this.hsy.cfN();
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
        if (this.hsz != null && this.hsy != null) {
            if (this.hsz.indexOfChild(this.hsy) > 0) {
                this.hsz.removeView(this.hsy);
            }
            this.hsy.onDestroy();
            this.hsy = null;
        }
    }
}
