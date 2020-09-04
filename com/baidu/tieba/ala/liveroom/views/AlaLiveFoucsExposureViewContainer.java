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
/* loaded from: classes7.dex */
public class AlaLiveFoucsExposureViewContainer extends RelativeLayout {
    private long fjk;
    private long fjl;
    private boolean gLm;
    private boolean gLn;
    private boolean gLo;
    private float gLp;
    private float gLq;
    private Runnable gLr;
    private AlaLiveFocusCircleView gLs;
    private a gLt;
    private AlaLiveExposureView gLu;
    private Context mContext;
    private float mDownX;
    private float mDownY;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes7.dex */
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
        this.gLo = true;
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
        this.gLu = new AlaLiveExposureView(context);
        this.gLu.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.gLt != null) {
                    AlaLiveFoucsExposureViewContainer.this.gLt.onExposure(f);
                }
            }
        });
        addView(this.gLu, getNewLayoutParams());
        this.gLu.setVisibility(4);
        bXb();
    }

    public void setFoucsListener(a aVar) {
        this.gLt = aVar;
    }

    public boolean Q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.gLq = x;
                float y = motionEvent.getY();
                this.mDownY = y;
                this.gLp = y;
                this.fjk = System.currentTimeMillis();
                this.gLn = true;
                this.gLm = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fjk < 100 && currentTimeMillis - this.fjl < 500) {
                    this.gLm = true;
                } else {
                    this.gLm = false;
                }
                if (!R(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fjl = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean R(MotionEvent motionEvent) {
        if (this.gLm) {
            return Math.abs(this.gLq - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.gLp - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.gLo) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.gLm && this.gLn && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.mDownY - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.gLr);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.gLr = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.gLm && AlaLiveFoucsExposureViewContainer.this.gLn && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.S(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.gLr, 100L);
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
                    if (this.gLt != null) {
                        this.gLt.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.gLs == null) {
                        bXb();
                    } else {
                        int width = this.gLs.getWidth();
                        int height = this.gLs.getHeight();
                        this.gLs.setTranslationX(motionEvent.getX() - (width / 2));
                        this.gLs.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.gLs.bXa();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.gLu.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.gLu.setLayoutParams(newLayoutParams2);
                    }
                    if (this.gLt != null) {
                        float exposure = this.gLt.getExposure();
                        if (exposure == -1.0f) {
                            this.gLu.setExposureValue(0.5f);
                        } else {
                            this.gLu.setExposureValue(exposure);
                        }
                    }
                    this.gLu.setVisibility(0);
                    this.gLu.bWY();
                    break;
                }
                break;
        }
        return true;
    }

    private void bXb() {
        if (this.gLs == null) {
            this.gLs = new AlaLiveFocusCircleView(getContext());
            addView(this.gLs, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
