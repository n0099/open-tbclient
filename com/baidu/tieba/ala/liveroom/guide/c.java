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
    AlaLiveGuardUpSlideView.a gAa;
    private com.baidu.live.liveroom.a.a gph;
    private AlaLiveGuardUpSlideView gzX;
    private ViewGroup gzY;
    private boolean gzZ;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gAa = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void mh(boolean z2) {
                c.this.bSh();
            }
        };
        this.gph = aVar;
        this.gzZ = z;
    }

    public boolean bSg() {
        return this.gzX != null && this.gzX.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSh() {
        if (this.gzY != null && this.gzX != null) {
            if (this.gzX != null) {
                this.gzX.onDestroy();
                this.gzX.setVisibility(8);
            }
            if (this.gzY.indexOfChild(this.gzX) >= 0) {
                this.gzY.removeView(this.gzX);
            }
            if (this.gph != null) {
                this.gph.ez(3);
            }
        }
    }

    private void bSi() {
        if (this.gzY != null && this.gzX != null && this.gzY.indexOfChild(this.gzX) < 0) {
            this.gzY.addView(this.gzX, new FrameLayout.LayoutParams(this.gzY.getWidth(), this.gzY.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean av(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.AD().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gzX == null) {
            this.gzY = viewGroup;
            this.gzX = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gzZ);
            this.gzX.setVisibility(0);
            this.gzX.setOnEndListener(this.gAa);
        } else if (this.gzX.getVisibility() == 0) {
            bSh();
            return true;
        }
        bSi();
        this.gzX.setVisibility(0);
        this.gzX.bSj();
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
        if (this.gzY != null && this.gzX != null) {
            if (this.gzY.indexOfChild(this.gzX) > 0) {
                this.gzY.removeView(this.gzX);
            }
            this.gzX.onDestroy();
            this.gzX = null;
        }
    }
}
