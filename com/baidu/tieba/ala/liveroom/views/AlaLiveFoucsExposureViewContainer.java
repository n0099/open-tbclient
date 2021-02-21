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
    private float cEl;
    private long gbc;
    private long gbd;
    private boolean hQB;
    private boolean hQC;
    private boolean hQD;
    private float hQE;
    private float hQF;
    private Runnable hQG;
    private AlaLiveFocusCircleView hQH;
    private a hQI;
    private AlaLiveExposureView hQJ;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public interface a {
        void chj();

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
        this.hQD = true;
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
        this.hQJ = new AlaLiveExposureView(context);
        this.hQJ.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hQI != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQI.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void chj() {
                if (AlaLiveFoucsExposureViewContainer.this.hQI != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQI.chj();
                }
            }
        });
        addView(this.hQJ, getNewLayoutParams());
        this.hQJ.setVisibility(4);
        cli();
    }

    public void setFoucsListener(a aVar) {
        this.hQI = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hQF = x;
                float y = motionEvent.getY();
                this.cEl = y;
                this.hQE = y;
                this.gbc = System.currentTimeMillis();
                this.hQC = true;
                this.hQB = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gbc < 100 && currentTimeMillis - this.gbd < 500) {
                    this.hQB = true;
                } else {
                    this.hQB = false;
                }
                if (!S(motionEvent)) {
                    T(motionEvent);
                }
                this.gbd = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hQB) {
            return Math.abs(this.hQF - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hQE - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hQD) {
        }
        return false;
    }

    private void T(MotionEvent motionEvent) {
        if (!this.hQB && this.hQC && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cEl - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hQG);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hQG = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hQB && AlaLiveFoucsExposureViewContainer.this.hQC && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.U(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hQG, 100L);
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
                    if (this.hQI != null) {
                        this.hQI.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hQH == null) {
                        cli();
                    } else {
                        int width = this.hQH.getWidth();
                        int height = this.hQH.getHeight();
                        this.hQH.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hQH.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hQH.clh();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hQJ.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hQJ.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hQI != null) {
                        float exposure = this.hQI.getExposure();
                        if (exposure == -1.0f) {
                            this.hQJ.setExposureValue(0.5f);
                        } else {
                            this.hQJ.setExposureValue(exposure);
                        }
                    }
                    this.hQJ.setVisibility(0);
                    this.hQJ.clf();
                    break;
                }
                break;
        }
        return true;
    }

    private void cli() {
        if (this.hQH == null) {
            this.hQH = new AlaLiveFocusCircleView(getContext());
            addView(this.hQH, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
