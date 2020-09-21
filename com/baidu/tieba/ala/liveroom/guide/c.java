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
    private AlaLiveGuardUpSlideView gDq;
    private ViewGroup gDr;
    private boolean gDs;
    AlaLiveGuardUpSlideView.a gDt;
    private com.baidu.live.liveroom.a.a gsz;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        super(tbPageContext);
        this.gDt = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.c.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void mm(boolean z2) {
                c.this.bTF();
            }
        };
        this.gsz = aVar;
        this.gDs = z;
    }

    public boolean bTE() {
        return this.gDq != null && this.gDq.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTF() {
        if (this.gDr != null && this.gDq != null) {
            if (this.gDq != null) {
                this.gDq.onDestroy();
                this.gDq.setVisibility(8);
            }
            if (this.gDr.indexOfChild(this.gDq) >= 0) {
                this.gDr.removeView(this.gDq);
            }
            if (this.gsz != null) {
                this.gsz.eD(3);
            }
        }
    }

    private void bTG() {
        if (this.gDr != null && this.gDq != null && this.gDr.indexOfChild(this.gDq) < 0) {
            this.gDr.addView(this.gDq, new FrameLayout.LayoutParams(this.gDr.getWidth(), this.gDr.getHeight()));
        }
    }

    public void D(int i, int i2) {
    }

    public boolean aw(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (com.baidu.live.c.AR().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.gDq == null) {
            this.gDr = viewGroup;
            this.gDq = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.gDs);
            this.gDq.setVisibility(0);
            this.gDq.setOnEndListener(this.gDt);
        } else if (this.gDq.getVisibility() == 0) {
            bTF();
            return true;
        }
        bTG();
        this.gDq.setVisibility(0);
        this.gDq.bTH();
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
        if (this.gDr != null && this.gDq != null) {
            if (this.gDr.indexOfChild(this.gDq) > 0) {
                this.gDr.removeView(this.gDq);
            }
            this.gDq.onDestroy();
            this.gDq = null;
        }
    }
}
