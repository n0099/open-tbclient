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
    private com.baidu.live.liveroom.a.a fMU;
    private AlaLiveGuardUpSlideView fVm;
    private ViewGroup fVn;
    private boolean fVo;
    AlaLiveGuardUpSlideView.a fVp;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.fVp = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void kP(boolean z2) {
                c.this.bBQ();
            }
        };
        this.fMU = aVar;
        this.fVo = z;
    }

    public boolean bBP() {
        return this.fVm != null && this.fVm.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBQ() {
        if (this.fVn != null && this.fVm != null) {
            if (this.fVm != null) {
                this.fVm.onDestroy();
                this.fVm.setVisibility(8);
            }
            if (this.fVn.indexOfChild(this.fVm) >= 0) {
                this.fVn.removeView(this.fVm);
            }
            if (this.fMU != null) {
                this.fMU.cC(3);
            }
        }
    }

    private void bBR() {
        if (this.fVn != null && this.fVm != null && this.fVn.indexOfChild(this.fVm) < 0) {
            this.fVn.addView(this.fVm, new FrameLayout.LayoutParams(this.fVn.getWidth(), this.fVn.getHeight()));
        }
    }

    public void bp(int i, int i2) {
    }

    public boolean aq(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.uN().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.fVm == null) {
            this.fVn = viewGroup;
            this.fVm = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.fVo);
            this.fVm.setVisibility(0);
            this.fVm.setOnEndListener(this.fVp);
        } else if (this.fVm.getVisibility() == 0) {
            bBQ();
            return true;
        }
        bBR();
        this.fVm.setVisibility(0);
        this.fVm.bBS();
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
        if (this.fVn != null && this.fVm != null) {
            if (this.fVn.indexOfChild(this.fVm) > 0) {
                this.fVn.removeView(this.fVm);
            }
            this.fVm.onDestroy();
            this.fVm = null;
        }
    }
}
