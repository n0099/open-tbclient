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
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.ala.liveroom.a {
    private AlaLiveGuardUpSlideView hEt;
    private ViewGroup hEu;
    private boolean hEv;
    AlaLiveGuardUpSlideView.a hEw;
    private com.baidu.live.liveroom.a.a huc;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.hEw = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void oj(boolean z2) {
                c.this.ciC();
            }
        };
        this.huc = aVar;
        this.hEv = z;
    }

    public boolean ciB() {
        return this.hEt != null && this.hEt.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciC() {
        if (this.hEu != null && this.hEt != null) {
            if (this.hEt != null) {
                this.hEt.onDestroy();
                this.hEt.setVisibility(8);
            }
            if (this.hEu.indexOfChild(this.hEt) >= 0) {
                this.hEu.removeView(this.hEt);
            }
            if (this.huc != null) {
                this.huc.fg(3);
            }
        }
    }

    private void ciD() {
        if (this.hEu != null && this.hEt != null && this.hEu.indexOfChild(this.hEt) < 0) {
            this.hEu.addView(this.hEt, new FrameLayout.LayoutParams(this.hEu.getWidth(), this.hEu.getHeight()));
        }
    }

    public void C(int i, int i2) {
    }

    public boolean aI(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.d.Ba().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.hEt == null) {
            this.hEu = viewGroup;
            this.hEt = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.hEv);
            this.hEt.setVisibility(0);
            this.hEt.setOnEndListener(this.hEw);
        } else if (this.hEt.getVisibility() == 0) {
            ciC();
            return true;
        }
        ciD();
        this.hEt.setVisibility(0);
        this.hEt.ciE();
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
        if (this.hEu != null && this.hEt != null) {
            if (this.hEu.indexOfChild(this.hEt) > 0) {
                this.hEu.removeView(this.hEt);
            }
            this.hEt.onDestroy();
            this.hEt = null;
        }
    }
}
