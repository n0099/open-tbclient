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
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private AlaLiveGuardUpSlideView hEl;
    private ViewGroup hEm;
    private boolean hEn;
    AlaLiveGuardUpSlideView.a hEo;
    private com.baidu.live.liveroom.a.a htV;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hEo = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void op(boolean z2) {
                c.this.cfK();
            }
        };
        this.htV = aVar;
        this.hEn = z;
    }

    public boolean cfJ() {
        return this.hEl != null && this.hEl.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfK() {
        if (this.hEm != null && this.hEl != null) {
            if (this.hEl != null) {
                this.hEl.onDestroy();
                this.hEl.setVisibility(8);
            }
            if (this.hEm.indexOfChild(this.hEl) >= 0) {
                this.hEm.removeView(this.hEl);
            }
            if (this.htV != null) {
                this.htV.dG(3);
            }
        }
    }

    private void cfL() {
        if (this.hEm != null && this.hEl != null && this.hEm.indexOfChild(this.hEl) < 0) {
            this.hEm.addView(this.hEl, new FrameLayout.LayoutParams(this.hEm.getWidth(), this.hEm.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aI(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.xc().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hEl == null) {
            this.hEm = viewGroup;
            this.hEl = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hEn);
            this.hEl.setVisibility(0);
            this.hEl.setOnEndListener(this.hEo);
        } else if (this.hEl.getVisibility() == 0) {
            cfK();
            return true;
        }
        cfL();
        this.hEl.setVisibility(0);
        this.hEl.cfM();
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
        if (this.hEm != null && this.hEl != null) {
            if (this.hEm.indexOfChild(this.hEl) > 0) {
                this.hEm.removeView(this.hEl);
            }
            this.hEl.onDestroy();
            this.hEl = null;
        }
    }
}
