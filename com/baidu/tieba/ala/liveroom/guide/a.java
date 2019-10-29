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
    private com.baidu.tieba.ala.liveroom.b dYQ;
    private AlaLiveGuardUpSlideView eha;
    private ViewGroup ehb;
    private boolean ehc;
    AlaLiveGuardUpSlideView.a ehd;

    public a(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        super(tbPageContext);
        this.ehd = new AlaLiveGuardUpSlideView.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.AlaLiveGuardUpSlideView.a
            public void hO(boolean z2) {
                a.this.aSd();
            }
        };
        this.dYQ = bVar;
        this.ehc = z;
    }

    public boolean aSc() {
        return this.eha != null && this.eha.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSd() {
        if (this.ehb != null && this.eha != null) {
            if (this.eha != null) {
                this.eha.onDestroy();
                this.eha.setVisibility(8);
            }
            if (this.ehb.indexOfChild(this.eha) >= 0) {
                this.ehb.removeView(this.eha);
            }
            if (this.dYQ != null) {
                this.dYQ.nc(3);
            }
        }
    }

    private void aSe() {
        if (this.ehb != null && this.eha != null && this.ehb.indexOfChild(this.eha) < 0) {
            this.ehb.addView(this.eha, new FrameLayout.LayoutParams(this.ehb.getWidth(), this.ehb.getHeight()));
        }
    }

    public void aO(int i, int i2) {
    }

    public boolean ad(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("LIVE_ROOM_SHAREDPRE_KEY_GUARD_SWIPE", false);
        if (c.np().getBoolean("ala_live_play_has_up_down_scrolled", false) || z) {
            return false;
        }
        if (this.eha == null) {
            this.ehb = viewGroup;
            this.eha = new AlaLiveGuardUpSlideView((Context) getPageContext().getPageActivity(), true, this.ehc);
            this.eha.setVisibility(0);
            this.eha.setOnEndListener(this.ehd);
        } else if (this.eha.getVisibility() == 0) {
            aSd();
            return true;
        }
        aSe();
        this.eha.setVisibility(0);
        this.eha.aSf();
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
        if (this.ehb != null && this.eha != null) {
            if (this.ehb.indexOfChild(this.eha) > 0) {
                this.ehb.removeView(this.eha);
            }
            this.eha.onDestroy();
            this.eha = null;
        }
    }
}
