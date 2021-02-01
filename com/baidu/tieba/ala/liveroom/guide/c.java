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
    private AlaLiveGuardUpSlideView hDX;
    private ViewGroup hDY;
    private boolean hDZ;
    AlaLiveGuardUpSlideView.a hEa;
    private com.baidu.live.liveroom.a.a htH;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hEa = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void op(boolean z2) {
                c.this.cfD();
            }
        };
        this.htH = aVar;
        this.hDZ = z;
    }

    public boolean cfC() {
        return this.hDX != null && this.hDX.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfD() {
        if (this.hDY != null && this.hDX != null) {
            if (this.hDX != null) {
                this.hDX.onDestroy();
                this.hDX.setVisibility(8);
            }
            if (this.hDY.indexOfChild(this.hDX) >= 0) {
                this.hDY.removeView(this.hDX);
            }
            if (this.htH != null) {
                this.htH.dG(3);
            }
        }
    }

    private void cfE() {
        if (this.hDY != null && this.hDX != null && this.hDY.indexOfChild(this.hDX) < 0) {
            this.hDY.addView(this.hDX, new FrameLayout.LayoutParams(this.hDY.getWidth(), this.hDY.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aI(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.xc().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hDX == null) {
            this.hDY = viewGroup;
            this.hDX = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hDZ);
            this.hDX.setVisibility(0);
            this.hDX.setOnEndListener(this.hEa);
        } else if (this.hDX.getVisibility() == 0) {
            cfD();
            return true;
        }
        cfE();
        this.hDX.setVisibility(0);
        this.hDX.cfF();
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
        if (this.hDY != null && this.hDX != null) {
            if (this.hDY.indexOfChild(this.hDX) > 0) {
                this.hDY.removeView(this.hDX);
            }
            this.hDX.onDestroy();
            this.hDX = null;
        }
    }
}
