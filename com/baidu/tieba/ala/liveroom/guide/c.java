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
    private com.baidu.live.liveroom.a.a gcZ;
    private AlaLiveGuardUpSlideView gnh;
    private ViewGroup gni;
    private boolean gnj;
    AlaLiveGuardUpSlideView.a gnk;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gnk = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void lD(boolean z2) {
                c.this.bIg();
            }
        };
        this.gcZ = aVar;
        this.gnj = z;
    }

    public boolean bIf() {
        return this.gnh != null && this.gnh.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIg() {
        if (this.gni != null && this.gnh != null) {
            if (this.gnh != null) {
                this.gnh.onDestroy();
                this.gnh.setVisibility(8);
            }
            if (this.gni.indexOfChild(this.gnh) >= 0) {
                this.gni.removeView(this.gnh);
            }
            if (this.gcZ != null) {
                this.gcZ.cJ(3);
            }
        }
    }

    private void bIh() {
        if (this.gni != null && this.gnh != null && this.gni.indexOfChild(this.gnh) < 0) {
            this.gni.addView(this.gnh, new FrameLayout.LayoutParams(this.gni.getWidth(), this.gni.getHeight()));
        }
    }

    public void bw(int i, int i2) {
    }

    public boolean au(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.vf().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gnh == null) {
            this.gni = viewGroup;
            this.gnh = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gnj);
            this.gnh.setVisibility(0);
            this.gnh.setOnEndListener(this.gnk);
        } else if (this.gnh.getVisibility() == 0) {
            bIg();
            return true;
        }
        bIh();
        this.gnh.setVisibility(0);
        this.gnh.bIi();
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
        if (this.gni != null && this.gnh != null) {
            if (this.gni.indexOfChild(this.gnh) > 0) {
                this.gni.removeView(this.gnh);
            }
            this.gnh.onDestroy();
            this.gnh = null;
        }
    }
}
