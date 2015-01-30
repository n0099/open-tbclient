package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
public class LivePlayingImageView extends ImageView implements q {
    private static /* synthetic */ int[] UZ;
    private r UY;
    private String mStatisticsKey;

    static /* synthetic */ int[] tO() {
        int[] iArr = UZ;
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
            UZ = iArr;
        }
        return iArr;
    }

    public String getStatisticsKey() {
        return this.mStatisticsKey;
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void setStatisticsKey(String str) {
        this.mStatisticsKey = str;
    }

    public r getVisibleChangeCallback() {
        return this.UY;
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void setVisibleChangeCallback(r rVar) {
        this.UY = rVar;
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
        setOnClickListener(new ai(this));
        a(LivePlayingStatusMgr.tP().tQ());
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void tI() {
        a(LivePlayingStatusMgr.tP().tQ());
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
        if (this.UY != null) {
            this.UY.onVisibleChange(i);
        }
    }

    public void a(LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus) {
        switch (tO()[livePlayingStatus.ordinal()]) {
            case 1:
                setVisibility(8);
                return;
            case 2:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.v.icon_live_play_default));
                setVisibility(0);
                return;
            case 3:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.v.live_play));
                setVisibility(0);
                return;
            case 4:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.v.icon_live_play_default));
                setVisibility(0);
                return;
            case 5:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.v.icon_live_play_default));
                setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LivePlayingStatusMgr.tP().a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LivePlayingStatusMgr.tP().b(this);
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public ImageView getView() {
        return this;
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().ab(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        bc.c(this, com.baidu.tieba.v.title_icon_bg, i);
    }
}
