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
    private float cwD;
    private long fMB;
    private long fMC;
    private boolean hvn;
    private boolean hvo;
    private boolean hvp;
    private float hvq;
    private float hvr;
    private Runnable hvs;
    private AlaLiveFocusCircleView hvt;
    private a hvu;
    private AlaLiveExposureView hvv;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface a {
        void cea();

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
        this.hvp = true;
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
        this.hvv = new AlaLiveExposureView(context);
        this.hvv.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hvu != null) {
                    AlaLiveFoucsExposureViewContainer.this.hvu.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void cea() {
                if (AlaLiveFoucsExposureViewContainer.this.hvu != null) {
                    AlaLiveFoucsExposureViewContainer.this.hvu.cea();
                }
            }
        });
        addView(this.hvv, getNewLayoutParams());
        this.hvv.setVisibility(4);
        chP();
    }

    public void setFoucsListener(a aVar) {
        this.hvu = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hvr = x;
                float y = motionEvent.getY();
                this.cwD = y;
                this.hvq = y;
                this.fMB = System.currentTimeMillis();
                this.hvo = true;
                this.hvn = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fMB < 100 && currentTimeMillis - this.fMC < 500) {
                    this.hvn = true;
                } else {
                    this.hvn = false;
                }
                if (!S(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fMC = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hvn) {
            return Math.abs(this.hvr - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hvq - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hvp) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.hvn && this.hvo && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cwD - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hvs);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hvs = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hvn && AlaLiveFoucsExposureViewContainer.this.hvo && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.T(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hvs, 100L);
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
                    if (this.hvu != null) {
                        this.hvu.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.hvt == null) {
                        chP();
                    } else {
                        int width = this.hvt.getWidth();
                        int height = this.hvt.getHeight();
                        this.hvt.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hvt.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hvt.chO();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hvv.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hvv.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hvu != null) {
                        float exposure = this.hvu.getExposure();
                        if (exposure == -1.0f) {
                            this.hvv.setExposureValue(0.5f);
                        } else {
                            this.hvv.setExposureValue(exposure);
                        }
                    }
                    this.hvv.setVisibility(0);
                    this.hvv.chM();
                    break;
                }
                break;
        }
        return true;
    }

    private void chP() {
        if (this.hvt == null) {
            this.hvt = new AlaLiveFocusCircleView(getContext());
            addView(this.hvt, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
