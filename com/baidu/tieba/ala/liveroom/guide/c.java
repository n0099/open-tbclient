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
    private com.baidu.live.liveroom.a.a gSJ;
    private AlaLiveGuardUpSlideView hdw;
    private ViewGroup hdx;
    private boolean hdy;
    AlaLiveGuardUpSlideView.a hdz;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hdz = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void ne(boolean z2) {
                c.this.bZX();
            }
        };
        this.gSJ = aVar;
        this.hdy = z;
    }

    public boolean bZW() {
        return this.hdw != null && this.hdw.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZX() {
        if (this.hdx != null && this.hdw != null) {
            if (this.hdw != null) {
                this.hdw.onDestroy();
                this.hdw.setVisibility(8);
            }
            if (this.hdx.indexOfChild(this.hdw) >= 0) {
                this.hdx.removeView(this.hdw);
            }
            if (this.gSJ != null) {
                this.gSJ.eP(3);
            }
        }
    }

    private void bZY() {
        if (this.hdx != null && this.hdw != null && this.hdx.indexOfChild(this.hdw) < 0) {
            this.hdx.addView(this.hdw, new FrameLayout.LayoutParams(this.hdx.getWidth(), this.hdx.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean ay(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.AZ().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hdw == null) {
            this.hdx = viewGroup;
            this.hdw = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hdy);
            this.hdw.setVisibility(0);
            this.hdw.setOnEndListener(this.hdz);
        } else if (this.hdw.getVisibility() == 0) {
            bZX();
            return true;
        }
        bZY();
        this.hdw.setVisibility(0);
        this.hdw.bZZ();
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
        if (this.hdx != null && this.hdw != null) {
            if (this.hdx.indexOfChild(this.hdw) > 0) {
                this.hdx.removeView(this.hdw);
            }
            this.hdw.onDestroy();
            this.hdw = null;
        }
    }
}
