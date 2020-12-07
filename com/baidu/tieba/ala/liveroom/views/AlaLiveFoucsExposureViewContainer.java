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
import okhttp3.internal.http.StatusLine;
/* loaded from: classes4.dex */
public class AlaLiveFoucsExposureViewContainer extends RelativeLayout {
    private float cBL;
    private long fTP;
    private long fTQ;
    private float hEA;
    private float hEB;
    private Runnable hEC;
    private AlaLiveFocusCircleView hED;
    private a hEE;
    private AlaLiveExposureView hEF;
    private boolean hEx;
    private boolean hEy;
    private boolean hEz;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface a {
        void chl();

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
        this.hEz = true;
        init(context);
    }

    private RelativeLayout.LayoutParams getNewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100), this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds240));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
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
        this.hEF = new AlaLiveExposureView(context);
        this.hEF.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hEE != null) {
                    AlaLiveFoucsExposureViewContainer.this.hEE.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void chl() {
                if (AlaLiveFoucsExposureViewContainer.this.hEE != null) {
                    AlaLiveFoucsExposureViewContainer.this.hEE.chl();
                }
            }
        });
        addView(this.hEF, getNewLayoutParams());
        this.hEF.setVisibility(4);
        clc();
    }

    public void setFoucsListener(a aVar) {
        this.hEE = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hEB = x;
                float y = motionEvent.getY();
                this.cBL = y;
                this.hEA = y;
                this.fTP = System.currentTimeMillis();
                this.hEy = true;
                this.hEx = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fTP < 100 && currentTimeMillis - this.fTQ < 500) {
                    this.hEx = true;
                } else {
                    this.hEx = false;
                }
                if (!S(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fTQ = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hEx) {
            return Math.abs(this.hEB - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hEA - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hEz) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.hEx && this.hEy && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cBL - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hEC);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hEC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hEx && AlaLiveFoucsExposureViewContainer.this.hEy && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.T(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hEC, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.mScreenHeight && x >= TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds64)) {
                    int clamp = CameraUtils.clamp(x, Opcodes.IFNE, this.mScreenWidth - 154);
                    int clamp2 = CameraUtils.clamp(y, Opcodes.IFNE, this.mScreenHeight - 154);
                    if (this.hEE != null) {
                        this.hEE.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hED == null) {
                        clc();
                    } else {
                        int width = this.hED.getWidth();
                        int height = this.hED.getHeight();
                        this.hED.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hED.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hED.clb();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hEF.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hEF.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hEE != null) {
                        float exposure = this.hEE.getExposure();
                        if (exposure == -1.0f) {
                            this.hEF.setExposureValue(0.5f);
                        } else {
                            this.hEF.setExposureValue(exposure);
                        }
                    }
                    this.hEF.setVisibility(0);
                    this.hEF.ckZ();
                    break;
                }
                break;
        }
        return true;
    }

    private void clc() {
        if (this.hED == null) {
            this.hED = new AlaLiveFocusCircleView(getContext());
            addView(this.hED, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
