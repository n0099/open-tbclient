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
    private com.baidu.live.liveroom.a.a gGU;
    private AlaLiveGuardUpSlideView gRJ;
    private ViewGroup gRK;
    private boolean gRL;
    AlaLiveGuardUpSlideView.a gRM;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gRM = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void mO(boolean z2) {
                c.this.bWY();
            }
        };
        this.gGU = aVar;
        this.gRL = z;
    }

    public boolean bWX() {
        return this.gRJ != null && this.gRJ.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWY() {
        if (this.gRK != null && this.gRJ != null) {
            if (this.gRJ != null) {
                this.gRJ.onDestroy();
                this.gRJ.setVisibility(8);
            }
            if (this.gRK.indexOfChild(this.gRJ) >= 0) {
                this.gRK.removeView(this.gRJ);
            }
            if (this.gGU != null) {
                this.gGU.eM(3);
            }
        }
    }

    private void bWZ() {
        if (this.gRK != null && this.gRJ != null && this.gRK.indexOfChild(this.gRJ) < 0) {
            this.gRK.addView(this.gRJ, new FrameLayout.LayoutParams(this.gRK.getWidth(), this.gRK.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean ay(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.AZ().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gRJ == null) {
            this.gRK = viewGroup;
            this.gRJ = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gRL);
            this.gRJ.setVisibility(0);
            this.gRJ.setOnEndListener(this.gRM);
        } else if (this.gRJ.getVisibility() == 0) {
            bWY();
            return true;
        }
        bWZ();
        this.gRJ.setVisibility(0);
        this.gRJ.bXa();
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
        if (this.gRK != null && this.gRJ != null) {
            if (this.gRK.indexOfChild(this.gRJ) > 0) {
                this.gRK.removeView(this.gRJ);
            }
            this.gRJ.onDestroy();
            this.gRJ = null;
        }
    }
}
