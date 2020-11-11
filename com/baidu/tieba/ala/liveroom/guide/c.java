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
    private com.baidu.live.liveroom.a.a gYO;
    private AlaLiveGuardUpSlideView hjs;
    private ViewGroup hjt;
    private boolean hju;
    AlaLiveGuardUpSlideView.a hjv;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hjv = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void nn(boolean z2) {
                c.this.ccz();
            }
        };
        this.gYO = aVar;
        this.hju = z;
    }

    public boolean ccy() {
        return this.hjs != null && this.hjs.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        if (this.hjt != null && this.hjs != null) {
            if (this.hjs != null) {
                this.hjs.onDestroy();
                this.hjs.setVisibility(8);
            }
            if (this.hjt.indexOfChild(this.hjs) >= 0) {
                this.hjt.removeView(this.hjs);
            }
            if (this.gYO != null) {
                this.gYO.eP(3);
            }
        }
    }

    private void ccA() {
        if (this.hjt != null && this.hjs != null && this.hjt.indexOfChild(this.hjs) < 0) {
            this.hjt.addView(this.hjs, new FrameLayout.LayoutParams(this.hjt.getWidth(), this.hjt.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean aA(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.AZ().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hjs == null) {
            this.hjt = viewGroup;
            this.hjs = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hju);
            this.hjs.setVisibility(0);
            this.hjs.setOnEndListener(this.hjv);
        } else if (this.hjs.getVisibility() == 0) {
            ccz();
            return true;
        }
        ccA();
        this.hjs.setVisibility(0);
        this.hjs.ccB();
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
        if (this.hjt != null && this.hjs != null) {
            if (this.hjt.indexOfChild(this.hjs) > 0) {
                this.hjt.removeView(this.hjs);
            }
            this.hjs.onDestroy();
            this.hjs = null;
        }
    }
}
