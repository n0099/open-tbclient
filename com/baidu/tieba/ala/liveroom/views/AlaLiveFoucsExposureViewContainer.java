package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ala.recorder.video.camera.CameraUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView;
/* loaded from: classes4.dex */
public class AlaLiveFoucsExposureViewContainer extends RelativeLayout {
    private float cqF;
    private long fGL;
    private long fGM;
    private boolean hpp;
    private boolean hpq;
    private boolean hpr;
    private float hps;
    private float hpt;
    private Runnable hpu;
    private AlaLiveFocusCircleView hpv;
    private a hpw;
    private AlaLiveExposureView hpx;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface a {
        void cbB();

        float getExposure();

        void onExposure(float f);

        void onFocus(int i, int i2, int i3, int i4);
    }

    public AlaLiveFoucsExposureViewContainer(Context context) {
        this(context, null);
    }

    public AlaLiveFoucsExposureViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaLiveFoucsExposureViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpr = true;
        init(context);
    }

    private RelativeLayout.LayoutParams getNewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds100), this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds240));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        layoutParams.addRule(15);
        return layoutParams;
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler();
        this.mScreenWidth = ScreenHelper.getScreenWidth(context);
        this.mScreenHeight = ScreenHelper.getScreenHeight(context);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        this.hpx = new AlaLiveExposureView(context);
        this.hpx.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hpw != null) {
                    AlaLiveFoucsExposureViewContainer.this.hpw.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void cbB() {
                if (AlaLiveFoucsExposureViewContainer.this.hpw != null) {
                    AlaLiveFoucsExposureViewContainer.this.hpw.cbB();
                }
            }
        });
        addView(this.hpx, getNewLayoutParams());
        this.hpx.setVisibility(4);
        cfm();
    }

    public void setFoucsListener(a aVar) {
        this.hpw = aVar;
    }

    public boolean Q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hpt = x;
                float y = motionEvent.getY();
                this.cqF = y;
                this.hps = y;
                this.fGL = System.currentTimeMillis();
                this.hpq = true;
                this.hpp = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fGL < 100 && currentTimeMillis - this.fGM < 500) {
                    this.hpp = true;
                } else {
                    this.hpp = false;
                }
                if (!R(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fGM = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean R(MotionEvent motionEvent) {
        if (this.hpp) {
            return Math.abs(this.hpt - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hps - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hpr) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.hpp && this.hpq && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cqF - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hpu);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hpu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hpp && AlaLiveFoucsExposureViewContainer.this.hpq && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.S(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hpu, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.mScreenHeight && x >= TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds64)) {
                    int clamp = CameraUtils.clamp(x, Opcodes.IFNE, this.mScreenWidth - 154);
                    int clamp2 = CameraUtils.clamp(y, Opcodes.IFNE, this.mScreenHeight - 154);
                    if (this.hpw != null) {
                        this.hpw.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.hpv == null) {
                        cfm();
                    } else {
                        int width = this.hpv.getWidth();
                        int height = this.hpv.getHeight();
                        this.hpv.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hpv.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hpv.cfl();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hpx.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hpx.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hpw != null) {
                        float exposure = this.hpw.getExposure();
                        if (exposure == -1.0f) {
                            this.hpx.setExposureValue(0.5f);
                        } else {
                            this.hpx.setExposureValue(exposure);
                        }
                    }
                    this.hpx.setVisibility(0);
                    this.hpx.cfj();
                    break;
                }
                break;
        }
        return true;
    }

    private void cfm() {
        if (this.hpv == null) {
            this.hpv = new AlaLiveFocusCircleView(getContext());
            addView(this.hpv, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
