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
    private com.baidu.live.liveroom.a.a fMJ;
    private AlaLiveGuardUpSlideView fVb;
    private ViewGroup fVc;
    private boolean fVd;
    AlaLiveGuardUpSlideView.a fVe;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fVe = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void kP(boolean z2) {
                c.this.bBO();
            }
        };
        this.fMJ = aVar;
        this.fVd = z;
    }

    public boolean bBN() {
        return this.fVb != null && this.fVb.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBO() {
        if (this.fVc != null && this.fVb != null) {
            if (this.fVb != null) {
                this.fVb.onDestroy();
                this.fVb.setVisibility(8);
            }
            if (this.fVc.indexOfChild(this.fVb) >= 0) {
                this.fVc.removeView(this.fVb);
            }
            if (this.fMJ != null) {
                this.fMJ.cA(3);
            }
        }
    }

    private void bBP() {
        if (this.fVc != null && this.fVb != null && this.fVc.indexOfChild(this.fVb) < 0) {
            this.fVc.addView(this.fVb, new FrameLayout.LayoutParams(this.fVc.getWidth(), this.fVc.getHeight()));
        }
    }

    public void bp(int i, int i2) {
    }

    public boolean aq(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.uN().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fVb == null) {
            this.fVc = viewGroup;
            this.fVb = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fVd);
            this.fVb.setVisibility(0);
            this.fVb.setOnEndListener(this.fVe);
        } else if (this.fVb.getVisibility() == 0) {
            bBO();
            return true;
        }
        bBP();
        this.fVb.setVisibility(0);
        this.fVb.bBQ();
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
        if (this.fVc != null && this.fVb != null) {
            if (this.fVc.indexOfChild(this.fVb) > 0) {
                this.fVc.removeView(this.fVb);
            }
            this.fVb.onDestroy();
            this.fVb = null;
        }
    }
}
