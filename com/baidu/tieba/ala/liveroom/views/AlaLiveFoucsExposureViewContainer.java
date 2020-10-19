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
    private float cif;
    private long fyq;
    private long fyr;
    private boolean hdA;
    private boolean hdB;
    private float hdC;
    private float hdD;
    private Runnable hdE;
    private AlaLiveFocusCircleView hdF;
    private a hdG;
    private AlaLiveExposureView hdH;
    private boolean hdz;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface a {
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
        this.hdB = true;
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
        this.hdH = new AlaLiveExposureView(context);
        this.hdH.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hdG != null) {
                    AlaLiveFoucsExposureViewContainer.this.hdG.onExposure(f);
                }
            }
        });
        addView(this.hdH, getNewLayoutParams());
        this.hdH.setVisibility(4);
        cci();
    }

    public void setFoucsListener(a aVar) {
        this.hdG = aVar;
    }

    public boolean Q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hdD = x;
                float y = motionEvent.getY();
                this.cif = y;
                this.hdC = y;
                this.fyq = System.currentTimeMillis();
                this.hdA = true;
                this.hdz = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fyq < 100 && currentTimeMillis - this.fyr < 500) {
                    this.hdz = true;
                } else {
                    this.hdz = false;
                }
                if (!R(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fyr = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean R(MotionEvent motionEvent) {
        if (this.hdz) {
            return Math.abs(this.hdD - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hdC - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hdB) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.hdz && this.hdA && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cif - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hdE);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hdE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hdz && AlaLiveFoucsExposureViewContainer.this.hdA && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.S(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hdE, 100L);
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
                    if (this.hdG != null) {
                        this.hdG.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.hdF == null) {
                        cci();
                    } else {
                        int width = this.hdF.getWidth();
                        int height = this.hdF.getHeight();
                        this.hdF.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hdF.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hdF.cch();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hdH.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hdH.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hdG != null) {
                        float exposure = this.hdG.getExposure();
                        if (exposure == -1.0f) {
                            this.hdH.setExposureValue(0.5f);
                        } else {
                            this.hdH.setExposureValue(exposure);
                        }
                    }
                    this.hdH.setVisibility(0);
                    this.hdH.ccf();
                    break;
                }
                break;
        }
        return true;
    }

    private void cci() {
        if (this.hdF == null) {
            this.hdF = new AlaLiveFocusCircleView(getContext());
            addView(this.hdF, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
