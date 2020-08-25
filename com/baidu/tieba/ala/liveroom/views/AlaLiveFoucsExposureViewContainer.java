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
    private long fjg;
    private long fjh;
    private boolean gLi;
    private boolean gLj;
    private boolean gLk;
    private float gLl;
    private float gLm;
    private Runnable gLn;
    private AlaLiveFocusCircleView gLo;
    private a gLp;
    private AlaLiveExposureView gLq;
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
        this.gLk = true;
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
        this.gLq = new AlaLiveExposureView(context);
        this.gLq.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.gLp != null) {
                    AlaLiveFoucsExposureViewContainer.this.gLp.onExposure(f);
                }
            }
        });
        addView(this.gLq, getNewLayoutParams());
        this.gLq.setVisibility(4);
        bXa();
    }

    public void setFoucsListener(a aVar) {
        this.gLp = aVar;
    }

    public boolean Q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.gLm = x;
                float y = motionEvent.getY();
                this.mDownY = y;
                this.gLl = y;
                this.fjg = System.currentTimeMillis();
                this.gLj = true;
                this.gLi = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fjg < 100 && currentTimeMillis - this.fjh < 500) {
                    this.gLi = true;
                } else {
                    this.gLi = false;
                }
                if (!R(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fjh = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean R(MotionEvent motionEvent) {
        if (this.gLi) {
            return Math.abs(this.gLm - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.gLl - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.gLk) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.gLi && this.gLj && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.mDownY - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.gLn);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.gLn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.gLi && AlaLiveFoucsExposureViewContainer.this.gLj && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.S(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.gLn, 100L);
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
                    if (this.gLp != null) {
                        this.gLp.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.gLo == null) {
                        bXa();
                    } else {
                        int width = this.gLo.getWidth();
                        int height = this.gLo.getHeight();
                        this.gLo.setTranslationX(motionEvent.getX() - (width / 2));
                        this.gLo.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.gLo.bWZ();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.gLq.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.gLq.setLayoutParams(newLayoutParams2);
                    }
                    if (this.gLp != null) {
                        float exposure = this.gLp.getExposure();
                        if (exposure == -1.0f) {
                            this.gLq.setExposureValue(0.5f);
                        } else {
                            this.gLq.setExposureValue(exposure);
                        }
                    }
                    this.gLq.setVisibility(0);
                    this.gLq.bWX();
                    break;
                }
                break;
        }
        return true;
    }

    private void bXa() {
        if (this.gLo == null) {
            this.gLo = new AlaLiveFocusCircleView(getContext());
            addView(this.gLo, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
