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
    private com.baidu.live.liveroom.a.a eTx;
    private AlaLiveGuardUpSlideView fcg;
    private ViewGroup fch;
    private boolean fci;
    AlaLiveGuardUpSlideView.a fcj;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fcj = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void jr(boolean z2) {
                c.this.bms();
            }
        };
        this.eTx = aVar;
        this.fci = z;
    }

    public boolean bmr() {
        return this.fcg != null && this.fcg.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bms() {
        if (this.fch != null && this.fcg != null) {
            if (this.fcg != null) {
                this.fcg.onDestroy();
                this.fcg.setVisibility(8);
            }
            if (this.fch.indexOfChild(this.fcg) >= 0) {
                this.fch.removeView(this.fcg);
            }
            if (this.eTx != null) {
                this.eTx.ce(3);
            }
        }
    }

    private void bmt() {
        if (this.fch != null && this.fcg != null && this.fch.indexOfChild(this.fcg) < 0) {
            this.fch.addView(this.fcg, new FrameLayout.LayoutParams(this.fch.getWidth(), this.fch.getHeight()));
        }
    }

    public void bg(int i, int i2) {
    }

    public boolean ah(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.pr().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fcg == null) {
            this.fch = viewGroup;
            this.fcg = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fci);
            this.fcg.setVisibility(0);
            this.fcg.setOnEndListener(this.fcj);
        } else if (this.fcg.getVisibility() == 0) {
            bms();
            return true;
        }
        bmt();
        this.fcg.setVisibility(0);
        this.fcg.bmu();
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
        if (this.fch != null && this.fcg != null) {
            if (this.fch.indexOfChild(this.fcg) > 0) {
                this.fch.removeView(this.fcg);
            }
            this.fcg.onDestroy();
            this.fcg = null;
        }
    }
}
