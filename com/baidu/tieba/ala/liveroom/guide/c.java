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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.tieba.ala.liveroom.b ePv;
    private AlaLiveGuardUpSlideView eYT;
    private ViewGroup eYU;
    private boolean eYV;
    AlaLiveGuardUpSlideView.a eYW;

    public c(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        super(tbPageContext);
        this.eYW = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void jp(boolean z2) {
                c.this.bkI();
            }
        };
        this.ePv = bVar;
        this.eYV = z;
    }

    public boolean bkH() {
        return this.eYT != null && this.eYT.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkI() {
        if (this.eYU != null && this.eYT != null) {
            if (this.eYT != null) {
                this.eYT.onDestroy();
                this.eYT.setVisibility(8);
            }
            if (this.eYU.indexOfChild(this.eYT) >= 0) {
                this.eYU.removeView(this.eYT);
            }
            if (this.ePv != null) {
                this.ePv.pt(3);
            }
        }
    }

    private void bkJ() {
        if (this.eYU != null && this.eYT != null && this.eYU.indexOfChild(this.eYT) < 0) {
            this.eYU.addView(this.eYT, new FrameLayout.LayoutParams(this.eYU.getWidth(), this.eYU.getHeight()));
        }
    }

    public void bg(int i, int i2) {
    }

    public boolean ag(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.oJ().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.eYT == null) {
            this.eYU = viewGroup;
            this.eYT = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.eYV);
            this.eYT.setVisibility(0);
            this.eYT.setOnEndListener(this.eYW);
        } else if (this.eYT.getVisibility() == 0) {
            bkI();
            return true;
        }
        bkJ();
        this.eYT.setVisibility(0);
        this.eYT.bkK();
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
        if (this.eYU != null && this.eYT != null) {
            if (this.eYU.indexOfChild(this.eYT) > 0) {
                this.eYU.removeView(this.eYT);
            }
            this.eYT.onDestroy();
            this.eYT = null;
        }
    }
}
