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
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.live.liveroom.a.a hpw;
    private AlaLiveGuardUpSlideView hzN;
    private ViewGroup hzO;
    private boolean hzP;
    AlaLiveGuardUpSlideView.a hzQ;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hzQ = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void of(boolean z2) {
                c.this.ceK();
            }
        };
        this.hpw = aVar;
        this.hzP = z;
    }

    public boolean ceJ() {
        return this.hzN != null && this.hzN.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceK() {
        if (this.hzO != null && this.hzN != null) {
            if (this.hzN != null) {
                this.hzN.onDestroy();
                this.hzN.setVisibility(8);
            }
            if (this.hzO.indexOfChild(this.hzN) >= 0) {
                this.hzO.removeView(this.hzN);
            }
            if (this.hpw != null) {
                this.hpw.dA(3);
            }
        }
    }

    private void ceL() {
        if (this.hzO != null && this.hzN != null && this.hzO.indexOfChild(this.hzN) < 0) {
            this.hzO.addView(this.hzN, new FrameLayout.LayoutParams(this.hzO.getWidth(), this.hzO.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aI(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.xf().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hzN == null) {
            this.hzO = viewGroup;
            this.hzN = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hzP);
            this.hzN.setVisibility(0);
            this.hzN.setOnEndListener(this.hzQ);
        } else if (this.hzN.getVisibility() == 0) {
            ceK();
            return true;
        }
        ceL();
        this.hzN.setVisibility(0);
        this.hzN.ceM();
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
        if (this.hzO != null && this.hzN != null) {
            if (this.hzO.indexOfChild(this.hzN) > 0) {
                this.hzO.removeView(this.hzN);
            }
            this.hzN.onDestroy();
            this.hzN = null;
        }
    }
}
