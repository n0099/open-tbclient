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
    private float bVQ;
    private long fmc;
    private long fmd;
    private boolean gOC;
    private boolean gOD;
    private boolean gOE;
    private float gOF;
    private float gOG;
    private Runnable gOH;
    private AlaLiveFocusCircleView gOI;
    private a gOJ;
    private AlaLiveExposureView gOK;
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
        this.gOE = true;
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
        this.gOK = new AlaLiveExposureView(context);
        this.gOK.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.gOJ != null) {
                    AlaLiveFoucsExposureViewContainer.this.gOJ.onExposure(f);
                }
            }
        });
        addView(this.gOK, getNewLayoutParams());
        this.gOK.setVisibility(4);
        bYI();
    }

    public void setFoucsListener(a aVar) {
        this.gOJ = aVar;
    }

    public boolean Q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.gOG = x;
                float y = motionEvent.getY();
                this.bVQ = y;
                this.gOF = y;
                this.fmc = System.currentTimeMillis();
                this.gOD = true;
                this.gOC = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fmc < 100 && currentTimeMillis - this.fmd < 500) {
                    this.gOC = true;
                } else {
                    this.gOC = false;
                }
                if (!R(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fmd = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean R(MotionEvent motionEvent) {
        if (this.gOC) {
            return Math.abs(this.gOG - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.gOF - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.gOE) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.gOC && this.gOD && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bVQ - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.gOH);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.gOH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.gOC && AlaLiveFoucsExposureViewContainer.this.gOD && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.S(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.gOH, 100L);
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
                    if (this.gOJ != null) {
                        this.gOJ.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.gOI == null) {
                        bYI();
                    } else {
                        int width = this.gOI.getWidth();
                        int height = this.gOI.getHeight();
                        this.gOI.setTranslationX(motionEvent.getX() - (width / 2));
                        this.gOI.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.gOI.bYH();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.gOK.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.gOK.setLayoutParams(newLayoutParams2);
                    }
                    if (this.gOJ != null) {
                        float exposure = this.gOJ.getExposure();
                        if (exposure == -1.0f) {
                            this.gOK.setExposureValue(0.5f);
                        } else {
                            this.gOK.setExposureValue(exposure);
                        }
                    }
                    this.gOK.setVisibility(0);
                    this.gOK.bYF();
                    break;
                }
                break;
        }
        return true;
    }

    private void bYI() {
        if (this.gOI == null) {
            this.gOI = new AlaLiveFocusCircleView(getContext());
            addView(this.gOI, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
