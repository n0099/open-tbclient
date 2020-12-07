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
    private com.baidu.live.liveroom.a.a hie;
    private AlaLiveGuardUpSlideView hsw;
    private ViewGroup hsx;
    private boolean hsy;
    AlaLiveGuardUpSlideView.a hsz;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hsz = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void nJ(boolean z2) {
                c.this.cfK();
            }
        };
        this.hie = aVar;
        this.hsy = z;
    }

    public boolean cfJ() {
        return this.hsw != null && this.hsw.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfK() {
        if (this.hsx != null && this.hsw != null) {
            if (this.hsw != null) {
                this.hsw.onDestroy();
                this.hsw.setVisibility(8);
            }
            if (this.hsx.indexOfChild(this.hsw) >= 0) {
                this.hsx.removeView(this.hsw);
            }
            if (this.hie != null) {
                this.hie.fi(3);
            }
        }
    }

    private void cfL() {
        if (this.hsx != null && this.hsw != null && this.hsx.indexOfChild(this.hsw) < 0) {
            this.hsx.addView(this.hsw, new FrameLayout.LayoutParams(this.hsx.getWidth(), this.hsx.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aw(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.BM().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hsw == null) {
            this.hsx = viewGroup;
            this.hsw = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hsy);
            this.hsw.setVisibility(0);
            this.hsw.setOnEndListener(this.hsz);
        } else if (this.hsw.getVisibility() == 0) {
            cfK();
            return true;
        }
        cfL();
        this.hsw.setVisibility(0);
        this.hsw.cfM();
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
        if (this.hsx != null && this.hsw != null) {
            if (this.hsx.indexOfChild(this.hsw) > 0) {
                this.hsx.removeView(this.hsw);
            }
            this.hsw.onDestroy();
            this.hsw = null;
        }
    }
}
