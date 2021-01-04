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
/* loaded from: classes11.dex */
public class AlaLiveFoucsExposureViewContainer extends RelativeLayout {
    private float cGB;
    private long gdt;
    private long gdu;
    private boolean hQA;
    private boolean hQB;
    private float hQC;
    private float hQD;
    private Runnable hQE;
    private AlaLiveFocusCircleView hQF;
    private a hQG;
    private AlaLiveExposureView hQH;
    private boolean hQz;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public interface a {
        void cka();

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
        this.hQB = true;
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
        this.hQH = new AlaLiveExposureView(context);
        this.hQH.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hQG != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQG.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void cka() {
                if (AlaLiveFoucsExposureViewContainer.this.hQG != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQG.cka();
                }
            }
        });
        addView(this.hQH, getNewLayoutParams());
        this.hQH.setVisibility(4);
        cnU();
    }

    public void setFoucsListener(a aVar) {
        this.hQG = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hQD = x;
                float y = motionEvent.getY();
                this.cGB = y;
                this.hQC = y;
                this.gdt = System.currentTimeMillis();
                this.hQA = true;
                this.hQz = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gdt < 100 && currentTimeMillis - this.gdu < 500) {
                    this.hQz = true;
                } else {
                    this.hQz = false;
                }
                if (!S(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.gdu = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hQz) {
            return Math.abs(this.hQD - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hQC - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hQB) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.hQz && this.hQA && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cGB - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hQE);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hQE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hQz && AlaLiveFoucsExposureViewContainer.this.hQA && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.T(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hQE, 100L);
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
                    if (this.hQG != null) {
                        this.hQG.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hQF == null) {
                        cnU();
                    } else {
                        int width = this.hQF.getWidth();
                        int height = this.hQF.getHeight();
                        this.hQF.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hQF.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hQF.cnT();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hQH.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hQH.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hQG != null) {
                        float exposure = this.hQG.getExposure();
                        if (exposure == -1.0f) {
                            this.hQH.setExposureValue(0.5f);
                        } else {
                            this.hQH.setExposureValue(exposure);
                        }
                    }
                    this.hQH.setVisibility(0);
                    this.hQH.cnR();
                    break;
                }
                break;
        }
        return true;
    }

    private void cnU() {
        if (this.hQF == null) {
            this.hQF = new AlaLiveFocusCircleView(getContext());
            addView(this.hQF, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
