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
    private com.baidu.live.liveroom.a.a eTy;
    private AlaLiveGuardUpSlideView fch;
    private ViewGroup fci;
    private boolean fcj;
    AlaLiveGuardUpSlideView.a fck;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fck = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void jr(boolean z2) {
                c.this.bmu();
            }
        };
        this.eTy = aVar;
        this.fcj = z;
    }

    public boolean bmt() {
        return this.fch != null && this.fch.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmu() {
        if (this.fci != null && this.fch != null) {
            if (this.fch != null) {
                this.fch.onDestroy();
                this.fch.setVisibility(8);
            }
            if (this.fci.indexOfChild(this.fch) >= 0) {
                this.fci.removeView(this.fch);
            }
            if (this.eTy != null) {
                this.eTy.ce(3);
            }
        }
    }

    private void bmv() {
        if (this.fci != null && this.fch != null && this.fci.indexOfChild(this.fch) < 0) {
            this.fci.addView(this.fch, new FrameLayout.LayoutParams(this.fci.getWidth(), this.fci.getHeight()));
        }
    }

    public void bg(int i, int i2) {
    }

    public boolean ah(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.pr().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fch == null) {
            this.fci = viewGroup;
            this.fch = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fcj);
            this.fch.setVisibility(0);
            this.fch.setOnEndListener(this.fck);
        } else if (this.fch.getVisibility() == 0) {
            bmu();
            return true;
        }
        bmv();
        this.fch.setVisibility(0);
        this.fch.bmw();
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
        if (this.fci != null && this.fch != null) {
            if (this.fci.indexOfChild(this.fch) > 0) {
                this.fci.removeView(this.fch);
            }
            this.fch.onDestroy();
            this.fch = null;
        }
    }
}
