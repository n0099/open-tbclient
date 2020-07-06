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
    private com.baidu.live.liveroom.a.a fXS;
    private AlaLiveGuardUpSlideView gij;
    private ViewGroup gik;
    private boolean gil;
    AlaLiveGuardUpSlideView.a gim;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gim = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void la(boolean z2) {
                c.this.bEY();
            }
        };
        this.fXS = aVar;
        this.gil = z;
    }

    public boolean bEX() {
        return this.gij != null && this.gij.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEY() {
        if (this.gik != null && this.gij != null) {
            if (this.gij != null) {
                this.gij.onDestroy();
                this.gij.setVisibility(8);
            }
            if (this.gik.indexOfChild(this.gij) >= 0) {
                this.gik.removeView(this.gij);
            }
            if (this.fXS != null) {
                this.fXS.cI(3);
            }
        }
    }

    private void bEZ() {
        if (this.gik != null && this.gij != null && this.gik.indexOfChild(this.gij) < 0) {
            this.gik.addView(this.gij, new FrameLayout.LayoutParams(this.gik.getWidth(), this.gik.getHeight()));
        }
    }

    public void bt(int i, int i2) {
    }

    public boolean at(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.vf().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gij == null) {
            this.gik = viewGroup;
            this.gij = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gil);
            this.gij.setVisibility(0);
            this.gij.setOnEndListener(this.gim);
        } else if (this.gij.getVisibility() == 0) {
            bEY();
            return true;
        }
        bEZ();
        this.gij.setVisibility(0);
        this.gij.bFa();
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
        if (this.gik != null && this.gij != null) {
            if (this.gik.indexOfChild(this.gij) > 0) {
                this.gik.removeView(this.gij);
            }
            this.gij.onDestroy();
            this.gij = null;
        }
    }
}
