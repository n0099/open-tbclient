package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class LivePlayingImageView extends ImageView implements j {
    private static /* synthetic */ int[] alt;
    private j.a als;
    private String mStatisticsKey;

    static /* synthetic */ int[] zf() {
        int[] iArr = alt;
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
            alt = iArr;
        }
        return iArr;
    }

    public String getStatisticsKey() {
        return this.mStatisticsKey;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j
    public void setStatisticsKey(String str) {
        this.mStatisticsKey = str;
    }

    public j.a getVisibleChangeCallback() {
        return this.als;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j
    public void setVisibleChangeCallback(j.a aVar) {
        this.als = aVar;
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
        setOnClickListener(new t(this));
        a(LivePlayingStatusMgr.zg().zh());
    }

    @Override // com.baidu.tbadk.coreExtra.view.j
    public void yX() {
        a(LivePlayingStatusMgr.zg().zh());
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
        if (this.als != null) {
            this.als.dv(i);
        }
    }

    public void a(LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus) {
        switch (zf()[livePlayingStatus.ordinal()]) {
            case 1:
                setVisibility(8);
                return;
            case 2:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(i.e.icon_live_play_default));
                setVisibility(0);
                return;
            case 3:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(i.e.live_play));
                setVisibility(0);
                return;
            case 4:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(i.e.icon_live_play_default));
                setVisibility(0);
                return;
            case 5:
                setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LivePlayingStatusMgr.zg().a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LivePlayingStatusMgr.zg().b(this);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j
    public ImageView getView() {
        return this;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j
    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(i == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this);
        }
        al.c(this, i.e.title_icon_bg, i);
    }
}
