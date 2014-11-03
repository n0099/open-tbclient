package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
public class LivePlayingImageView extends ImageView {
    private static /* synthetic */ int[] OH;
    private ah OG;
    private String mStatisticsKey;

    static /* synthetic */ int[] qf() {
        int[] iArr = OH;
        if (iArr == null) {
            iArr = new int[LivePlayingStatusMgr.LivePlayingStatus.valuesCustom().length];
            try {
                iArr[LivePlayingStatusMgr.LivePlayingStatus.IDEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LivePlayingStatusMgr.LivePlayingStatus.JOINED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LivePlayingStatusMgr.LivePlayingStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LivePlayingStatusMgr.LivePlayingStatus.PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            OH = iArr;
        }
        return iArr;
    }

    public String getStatisticsKey() {
        return this.mStatisticsKey;
    }

    public void setStatisticsKey(String str) {
        this.mStatisticsKey = str;
    }

    public ah getVisibleChangeCallback() {
        return this.OG;
    }

    public void setVisibleChangeCallback(ah ahVar) {
        this.OG = ahVar;
    }

    public LivePlayingImageView(Context context) {
        super(context);
        init();
    }

    public LivePlayingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LivePlayingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setOnClickListener(new ag(this));
        a(LivePlayingStatusMgr.qg().qh());
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof AnimationDrawable)) {
            if (i == 0) {
                ((AnimationDrawable) drawable).start();
            } else {
                ((AnimationDrawable) drawable).stop();
            }
        }
        if (this.OG != null) {
            this.OG.ct(i);
        }
    }

    public void a(LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus) {
        switch (qf()[livePlayingStatus.ordinal()]) {
            case 1:
                setVisibility(8);
                return;
            case 2:
                setImageDrawable(TbadkApplication.m251getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            case 3:
                setImageDrawable(TbadkApplication.m251getInst().getResources().getDrawable(com.baidu.tieba.u.live_play));
                setVisibility(0);
                return;
            case 4:
                setImageDrawable(TbadkApplication.m251getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            case 5:
                setImageDrawable(TbadkApplication.m251getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LivePlayingStatusMgr.qg().a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LivePlayingStatusMgr.qg().b(this);
    }
}
