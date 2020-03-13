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
    private com.baidu.live.liveroom.a.a eTL;
    private AlaLiveGuardUpSlideView fcu;
    private ViewGroup fcv;
    private boolean fcw;
    AlaLiveGuardUpSlideView.a fcx;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fcx = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void jr(boolean z2) {
                c.this.bmv();
            }
        };
        this.eTL = aVar;
        this.fcw = z;
    }

    public boolean bmu() {
        return this.fcu != null && this.fcu.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmv() {
        if (this.fcv != null && this.fcu != null) {
            if (this.fcu != null) {
                this.fcu.onDestroy();
                this.fcu.setVisibility(8);
            }
            if (this.fcv.indexOfChild(this.fcu) >= 0) {
                this.fcv.removeView(this.fcu);
            }
            if (this.eTL != null) {
                this.eTL.ce(3);
            }
        }
    }

    private void bmw() {
        if (this.fcv != null && this.fcu != null && this.fcv.indexOfChild(this.fcu) < 0) {
            this.fcv.addView(this.fcu, new FrameLayout.LayoutParams(this.fcv.getWidth(), this.fcv.getHeight()));
        }
    }

    public void bg(int i, int i2) {
    }

    public boolean ah(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.pr().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fcu == null) {
            this.fcv = viewGroup;
            this.fcu = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fcw);
            this.fcu.setVisibility(0);
            this.fcu.setOnEndListener(this.fcx);
        } else if (this.fcu.getVisibility() == 0) {
            bmv();
            return true;
        }
        bmw();
        this.fcu.setVisibility(0);
        this.fcu.bmx();
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
        if (this.fcv != null && this.fcu != null) {
            if (this.fcv.indexOfChild(this.fcu) > 0) {
                this.fcv.removeView(this.fcu);
            }
            this.fcu.onDestroy();
            this.fcu = null;
        }
    }
}
