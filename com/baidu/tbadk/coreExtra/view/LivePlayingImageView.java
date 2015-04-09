package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
public class LivePlayingImageView extends ImageView implements q {
    private static /* synthetic */ int[] afl;
    private r afk;
    private String mStatisticsKey;

    static /* synthetic */ int[] xi() {
        int[] iArr = afl;
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
            afl = iArr;
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
        return this.afk;
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void setVisibleChangeCallback(r rVar) {
        this.afk = rVar;
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
        setOnClickListener(new ah(this));
        a(LivePlayingStatusMgr.xj().xk());
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void xb() {
        a(LivePlayingStatusMgr.xj().xk());
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
        if (this.afk != null) {
            this.afk.onVisibleChange(i);
        }
    }

    public void a(LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus) {
        switch (xi()[livePlayingStatus.ordinal()]) {
            case 1:
                setVisibility(8);
                return;
            case 2:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            case 3:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.u.live_play));
                setVisibility(0);
                return;
            case 4:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            case 5:
                setImageDrawable(TbadkApplication.getInst().getResources().getDrawable(com.baidu.tieba.u.icon_live_play_default));
                setVisibility(0);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LivePlayingStatusMgr.xj().a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LivePlayingStatusMgr.xj().b(this);
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public ImageView getView() {
        return this;
    }

    @Override // com.baidu.tbadk.coreExtra.view.q
    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            ((TbPageContext) jVar).getLayoutMode().X(i == 1);
            ((TbPageContext) jVar).getLayoutMode().h(this);
        }
        ba.c(this, com.baidu.tieba.u.title_icon_bg, i);
    }
}
