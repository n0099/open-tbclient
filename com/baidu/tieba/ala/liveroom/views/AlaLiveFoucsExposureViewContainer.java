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
/* loaded from: classes10.dex */
public class AlaLiveFoucsExposureViewContainer extends RelativeLayout {
    private float cBP;
    private long fYK;
    private long fYL;
    private boolean hLT;
    private boolean hLU;
    private boolean hLV;
    private float hLW;
    private float hLX;
    private Runnable hLY;
    private AlaLiveFocusCircleView hLZ;
    private a hMa;
    private AlaLiveExposureView hMb;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes10.dex */
    public interface a {
        void cgj();

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
        this.hLV = true;
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
        this.hMb = new AlaLiveExposureView(context);
        this.hMb.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hMa != null) {
                    AlaLiveFoucsExposureViewContainer.this.hMa.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void cgj() {
                if (AlaLiveFoucsExposureViewContainer.this.hMa != null) {
                    AlaLiveFoucsExposureViewContainer.this.hMa.cgj();
                }
            }
        });
        addView(this.hMb, getNewLayoutParams());
        this.hMb.setVisibility(4);
        ckd();
    }

    public void setFoucsListener(a aVar) {
        this.hMa = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hLX = x;
                float y = motionEvent.getY();
                this.cBP = y;
                this.hLW = y;
                this.fYK = System.currentTimeMillis();
                this.hLU = true;
                this.hLT = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fYK < 100 && currentTimeMillis - this.fYL < 500) {
                    this.hLT = true;
                } else {
                    this.hLT = false;
                }
                if (!S(motionEvent)) {
                    T(motionEvent);
                }
                this.fYL = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hLT) {
            return Math.abs(this.hLX - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hLW - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hLV) {
        }
        return false;
    }

    private void T(MotionEvent motionEvent) {
        if (!this.hLT && this.hLU && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cBP - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hLY);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hLY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hLT && AlaLiveFoucsExposureViewContainer.this.hLU && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.U(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hLY, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= this.mScreenHeight && x >= TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds64)) {
                    int clamp = CameraUtils.clamp(x, Opcodes.IFNE, this.mScreenWidth - 154);
                    int clamp2 = CameraUtils.clamp(y, Opcodes.IFNE, this.mScreenHeight - 154);
                    if (this.hMa != null) {
                        this.hMa.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hLZ == null) {
                        ckd();
                    } else {
                        int width = this.hLZ.getWidth();
                        int height = this.hLZ.getHeight();
                        this.hLZ.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hLZ.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hLZ.ckc();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hMb.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hMb.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hMa != null) {
                        float exposure = this.hMa.getExposure();
                        if (exposure == -1.0f) {
                            this.hMb.setExposureValue(0.5f);
                        } else {
                            this.hMb.setExposureValue(exposure);
                        }
                    }
                    this.hMb.setVisibility(0);
                    this.hMb.cka();
                    break;
                }
                break;
        }
        return true;
    }

    private void ckd() {
        if (this.hLZ == null) {
            this.hLZ = new AlaLiveFocusCircleView(getContext());
            addView(this.hLZ, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
