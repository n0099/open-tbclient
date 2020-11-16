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
    private com.baidu.live.liveroom.a.a gYv;
    private AlaLiveGuardUpSlideView hiZ;
    private ViewGroup hja;
    private boolean hjb;
    AlaLiveGuardUpSlideView.a hjc;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hjc = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void no(boolean z2) {
                c.this.cbS();
            }
        };
        this.gYv = aVar;
        this.hjb = z;
    }

    public boolean cbR() {
        return this.hiZ != null && this.hiZ.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbS() {
        if (this.hja != null && this.hiZ != null) {
            if (this.hiZ != null) {
                this.hiZ.onDestroy();
                this.hiZ.setVisibility(8);
            }
            if (this.hja.indexOfChild(this.hiZ) >= 0) {
                this.hja.removeView(this.hiZ);
            }
            if (this.gYv != null) {
                this.gYv.eL(3);
            }
        }
    }

    private void cbT() {
        if (this.hja != null && this.hiZ != null && this.hja.indexOfChild(this.hiZ) < 0) {
            this.hja.addView(this.hiZ, new FrameLayout.LayoutParams(this.hja.getWidth(), this.hja.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean aw(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.Aq().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hiZ == null) {
            this.hja = viewGroup;
            this.hiZ = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hjb);
            this.hiZ.setVisibility(0);
            this.hiZ.setOnEndListener(this.hjc);
        } else if (this.hiZ.getVisibility() == 0) {
            cbS();
            return true;
        }
        cbT();
        this.hiZ.setVisibility(0);
        this.hiZ.cbU();
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
        if (this.hja != null && this.hiZ != null) {
            if (this.hja.indexOfChild(this.hiZ) > 0) {
                this.hja.removeView(this.hiZ);
            }
            this.hiZ.onDestroy();
            this.hiZ = null;
        }
    }
}
