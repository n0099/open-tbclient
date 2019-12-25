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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private com.baidu.tieba.ala.liveroom.b eNX;
    private AlaLiveGuardUpSlideView eWt;
    private ViewGroup eWu;
    private boolean eWv;
    AlaLiveGuardUpSlideView.a eWw;

    public c(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        super(tbPageContext);
        this.eWw = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void je(boolean z2) {
                c.this.bjM();
            }
        };
        this.eNX = bVar;
        this.eWv = z;
    }

    public boolean bjL() {
        return this.eWt != null && this.eWt.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjM() {
        if (this.eWu != null && this.eWt != null) {
            if (this.eWt != null) {
                this.eWt.onDestroy();
                this.eWt.setVisibility(8);
            }
            if (this.eWu.indexOfChild(this.eWt) >= 0) {
                this.eWu.removeView(this.eWt);
            }
            if (this.eNX != null) {
                this.eNX.ps(3);
            }
        }
    }

    private void bjN() {
        if (this.eWu != null && this.eWt != null && this.eWu.indexOfChild(this.eWt) < 0) {
            this.eWu.addView(this.eWt, new FrameLayout.LayoutParams(this.eWu.getWidth(), this.eWu.getHeight()));
        }
    }

    public void bc(int i, int i2) {
    }

    public boolean ac(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.oI().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.eWt == null) {
            this.eWu = viewGroup;
            this.eWt = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.eWv);
            this.eWt.setVisibility(0);
            this.eWt.setOnEndListener(this.eWw);
        } else if (this.eWt.getVisibility() == 0) {
            bjM();
            return true;
        }
        bjN();
        this.eWt.setVisibility(0);
        this.eWt.bjO();
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
        if (this.eWu != null && this.eWt != null) {
            if (this.eWu.indexOfChild(this.eWt) > 0) {
                this.eWu.removeView(this.eWt);
            }
            this.eWt.onDestroy();
            this.eWt = null;
        }
    }
}
