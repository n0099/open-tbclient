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
    private com.baidu.live.liveroom.a.a eUj;
    private AlaLiveGuardUpSlideView fcS;
    private ViewGroup fcT;
    private boolean fcU;
    AlaLiveGuardUpSlideView.a fcV;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fcV = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void jt(boolean z2) {
                c.this.bmA();
            }
        };
        this.eUj = aVar;
        this.fcU = z;
    }

    public boolean bmz() {
        return this.fcS != null && this.fcS.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmA() {
        if (this.fcT != null && this.fcS != null) {
            if (this.fcS != null) {
                this.fcS.onDestroy();
                this.fcS.setVisibility(8);
            }
            if (this.fcT.indexOfChild(this.fcS) >= 0) {
                this.fcT.removeView(this.fcS);
            }
            if (this.eUj != null) {
                this.eUj.ce(3);
            }
        }
    }

    private void bmB() {
        if (this.fcT != null && this.fcS != null && this.fcT.indexOfChild(this.fcS) < 0) {
            this.fcT.addView(this.fcS, new FrameLayout.LayoutParams(this.fcT.getWidth(), this.fcT.getHeight()));
        }
    }

    public void bh(int i, int i2) {
    }

    public boolean ai(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.pw().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fcS == null) {
            this.fcT = viewGroup;
            this.fcS = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fcU);
            this.fcS.setVisibility(0);
            this.fcS.setOnEndListener(this.fcV);
        } else if (this.fcS.getVisibility() == 0) {
            bmA();
            return true;
        }
        bmB();
        this.fcS.setVisibility(0);
        this.fcS.bmC();
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
        if (this.fcT != null && this.fcS != null) {
            if (this.fcT.indexOfChild(this.fcS) > 0) {
                this.fcT.removeView(this.fcS);
            }
            this.fcS.onDestroy();
            this.fcS = null;
        }
    }
}
