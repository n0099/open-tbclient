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
    private boolean hQn;
    private boolean hQo;
    private boolean hQp;
    private float hQq;
    private float hQr;
    private Runnable hQs;
    private AlaLiveFocusCircleView hQt;
    private a hQu;
    private AlaLiveExposureView hQv;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public interface a {
        void chc();

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
        this.hQp = true;
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
        this.hQv = new AlaLiveExposureView(context);
        this.hQv.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hQu != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQu.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void chc() {
                if (AlaLiveFoucsExposureViewContainer.this.hQu != null) {
                    AlaLiveFoucsExposureViewContainer.this.hQu.chc();
                }
            }
        });
        addView(this.hQv, getNewLayoutParams());
        this.hQv.setVisibility(4);
        clb();
    }

    public void setFoucsListener(a aVar) {
        this.hQu = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.hQr = x;
                float y = motionEvent.getY();
                this.cEl = y;
                this.hQq = y;
                this.gbc = System.currentTimeMillis();
                this.hQo = true;
                this.hQn = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gbc < 100 && currentTimeMillis - this.gbd < 500) {
                    this.hQn = true;
                } else {
                    this.hQn = false;
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
        if (this.hQn) {
            return Math.abs(this.hQr - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.hQq - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.hQp) {
        }
        return false;
    }

    private void T(MotionEvent motionEvent) {
        if (!this.hQn && this.hQo && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cEl - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.hQs);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.hQs = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.hQn && AlaLiveFoucsExposureViewContainer.this.hQo && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.U(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.hQs, 100L);
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
                    if (this.hQu != null) {
                        this.hQu.onFocus(StatusLine.HTTP_PERM_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, clamp, clamp2);
                    }
                    if (this.hQt == null) {
                        clb();
                    } else {
                        int width = this.hQt.getWidth();
                        int height = this.hQt.getHeight();
                        this.hQt.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hQt.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hQt.cla();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hQv.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hQv.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hQu != null) {
                        float exposure = this.hQu.getExposure();
                        if (exposure == -1.0f) {
                            this.hQv.setExposureValue(0.5f);
                        } else {
                            this.hQv.setExposureValue(exposure);
                        }
                    }
                    this.hQv.setVisibility(0);
                    this.hQv.ckY();
                    break;
                }
                break;
        }
        return true;
    }

    private void clb() {
        if (this.hQt == null) {
            this.hQt = new AlaLiveFocusCircleView(getContext());
            addView(this.hQt, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
