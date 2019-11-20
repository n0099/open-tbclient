package com.baidu.tieba.ala.liveroom.guide;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.tieba.ala.liveroom.b dXZ;
    private AlaLiveGuardUpSlideView egj;
    private ViewGroup egk;
    private boolean egl;
    AlaLiveGuardUpSlideView.a egm;

    public a(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        super(tbPageContext);
        this.egm = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void hO(boolean z2) {
                a.this.aSb();
            }
        };
        this.dXZ = bVar;
        this.egl = z;
    }

    public boolean aSa() {
        return this.egj != null && this.egj.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSb() {
        if (this.egk != null && this.egj != null) {
            if (this.egj != null) {
                this.egj.onDestroy();
                this.egj.setVisibility(8);
            }
            if (this.egk.indexOfChild(this.egj) >= 0) {
                this.egk.removeView(this.egj);
            }
            if (this.dXZ != null) {
                this.dXZ.nb(3);
            }
        }
    }

    private void aSc() {
        if (this.egk != null && this.egj != null && this.egk.indexOfChild(this.egj) < 0) {
            this.egk.addView(this.egj, new FrameLayout.LayoutParams(this.egk.getWidth(), this.egk.getHeight()));
        }
    }

    public void aM(int i, int i2) {
    }

    public boolean ad(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (c.np().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.egj == null) {
            this.egk = viewGroup;
            this.egj = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.egl);
            this.egj.setVisibility(0);
            this.egj.setOnEndListener(this.egm);
        } else if (this.egj.getVisibility() == 0) {
            aSb();
            return true;
        }
        aSc();
        this.egj.setVisibility(0);
        this.egj.aSd();
        SharedPrefHelper.getInstance().putBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", true);
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_GUIDE);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.egk != null && this.egj != null) {
            if (this.egk.indexOfChild(this.egj) > 0) {
                this.egk.removeView(this.egj);
            }
            this.egj.onDestroy();
            this.egj = null;
        }
    }
}
