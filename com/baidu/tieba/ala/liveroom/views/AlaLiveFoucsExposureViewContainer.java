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
    private float cFL;
    private long gcD;
    private long gcE;
    private boolean hSk;
    private boolean hSl;
    private boolean hSm;
    private float hSn;
    private float hSo;
    private Runnable hSp;
    private AlaLiveFocusCircleView hSq;
    private a hSr;
    private AlaLiveExposureView hSs;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes10.dex */
    public interface a {
        void chp();

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
        this.hSm = true;
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
        this.hSs = new AlaLiveExposureView(context);
        this.hSs.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hSr != null) {
                    AlaLiveFoucsExposureViewContainer.this.hSr.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void chp() {
                if (AlaLiveFoucsExposureViewContainer.this.hSr != null) {
                    AlaLiveFoucsExposureViewContainer.this.hSr.chp();
                }
            }
        });
        addView(this.hSs, getNewLayoutParams());
        this.hSs.setVisibility(4);
        clo();
    }

    public void setFoucsListener(a aVar) {
        this.hSr = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hSo = x;
                float y = motionEvent.getY();
                this.cFL = y;
                this.hSn = y;
                this.gcD = System.currentTimeMillis();
                this.hSl = true;
                this.hSk = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gcD < 100 && currentTimeMillis - this.gcE < 500) {
                    this.hSk = true;
                } else {
                    this.hSk = false;
                }
                if (!S(motionEvent)) {
                    T(motionEvent);
                }
                this.gcE = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.hSk) {
            return Math.abs(this.hSo - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hSn - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hSm) {
        }
        return false;
    }

    private void T(MotionEvent motionEvent) {
        if (!this.hSk && this.hSl && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cFL - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hSp);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hSp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hSk && AlaLiveFoucsExposureViewContainer.this.hSl && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.U(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hSp, 100L);
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
                    if (this.hSr != null) {
                        this.hSr.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hSq == null) {
                        clo();
                    } else {
                        int width = this.hSq.getWidth();
                        int height = this.hSq.getHeight();
                        this.hSq.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hSq.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hSq.cln();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hSs.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hSs.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hSr != null) {
                        float exposure = this.hSr.getExposure();
                        if (exposure == -1.0f) {
                            this.hSs.setExposureValue(0.5f);
                        } else {
                            this.hSs.setExposureValue(exposure);
                        }
                    }
                    this.hSs.setVisibility(0);
                    this.hSs.cll();
                    break;
                }
                break;
        }
        return true;
    }

    private void clo() {
        if (this.hSq == null) {
            this.hSq = new AlaLiveFocusCircleView(getContext());
            addView(this.hSq, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
