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
    private float cuT;
    private long fMe;
    private long fMf;
    private boolean huU;
    private boolean huV;
    private boolean huW;
    private float huX;
    private float huY;
    private Runnable huZ;
    private AlaLiveFocusCircleView hva;
    private a hvb;
    private AlaLiveExposureView hvc;
    private Context mContext;
    private float mDownX;
    private Handler mHandler;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mTouchSlop;

    /* loaded from: classes4.dex */
    public interface a {
        void cdt();

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
        this.huW = true;
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
        this.hvc = new AlaLiveExposureView(context);
        this.hvc.setExposureListener(new AlaLiveExposureView.a() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.1
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void onExposure(float f) {
                if (AlaLiveFoucsExposureViewContainer.this.hvb != null) {
                    AlaLiveFoucsExposureViewContainer.this.hvb.onExposure(f);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveExposureView.a
            public void cdt() {
                if (AlaLiveFoucsExposureViewContainer.this.hvb != null) {
                    AlaLiveFoucsExposureViewContainer.this.hvb.cdt();
                }
            }
        });
        addView(this.hvc, getNewLayoutParams());
        this.hvc.setVisibility(4);
        chi();
    }

    public void setFoucsListener(a aVar) {
        this.hvb = aVar;
    }

    public boolean R(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                this.mDownX = x;
                this.huY = x;
                float y = motionEvent.getY();
                this.cuT = y;
                this.huX = y;
                this.fMe = System.currentTimeMillis();
                this.huV = true;
                this.huU = false;
                break;
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fMe < 100 && currentTimeMillis - this.fMf < 500) {
                    this.huU = true;
                } else {
                    this.huU = false;
                }
                if (!S(motionEvent)) {
                    handleClick(motionEvent);
                }
                this.fMf = currentTimeMillis;
                break;
        }
        return true;
    }

    private boolean S(MotionEvent motionEvent) {
        if (this.huU) {
            return Math.abs(this.huY - motionEvent.getX()) < ((float) this.mTouchSlop) && Math.abs(this.huX - motionEvent.getY()) < ((float) this.mTouchSlop);
        }
        if (!this.huW) {
        }
        return false;
    }

    private void handleClick(MotionEvent motionEvent) {
        if (!this.huU && this.huV && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.cuT - motionEvent.getY()) < 30.0f) {
            this.mHandler.removeCallbacks(this.huZ);
            final MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.huZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveFoucsExposureViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AlaLiveFoucsExposureViewContainer.this.huU && AlaLiveFoucsExposureViewContainer.this.huV && Math.abs(AlaLiveFoucsExposureViewContainer.this.mDownX - obtain.getX()) < 30.0f) {
                        AlaLiveFoucsExposureViewContainer.this.T(obtain);
                    }
                }
            };
            this.mHandler.postDelayed(this.huZ, 100L);
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
                    if (this.hvb != null) {
                        this.hvb.onFocus(308, 308, clamp, clamp2);
                    }
                    if (this.hva == null) {
                        chi();
                    } else {
                        int width = this.hva.getWidth();
                        int height = this.hva.getHeight();
                        this.hva.setTranslationX(motionEvent.getX() - (width / 2));
                        this.hva.setTranslationY((motionEvent.getY() - (height / 2)) - UtilHelper.getStatusBarHeight());
                        this.hva.chh();
                    }
                    if (Math.round(motionEvent.getRawX()) < ScreenHelper.getScreenWidth(getContext()) / 2) {
                        RelativeLayout.LayoutParams newLayoutParams = getNewLayoutParams();
                        newLayoutParams.addRule(9);
                        this.hvc.setLayoutParams(newLayoutParams);
                    } else {
                        RelativeLayout.LayoutParams newLayoutParams2 = getNewLayoutParams();
                        newLayoutParams2.addRule(11);
                        this.hvc.setLayoutParams(newLayoutParams2);
                    }
                    if (this.hvb != null) {
                        float exposure = this.hvb.getExposure();
                        if (exposure == -1.0f) {
                            this.hvc.setExposureValue(0.5f);
                        } else {
                            this.hvc.setExposureValue(exposure);
                        }
                    }
                    this.hvc.setVisibility(0);
                    this.hvc.chf();
                    break;
                }
                break;
        }
        return true;
    }

    private void chi() {
        if (this.hva == null) {
            this.hva = new AlaLiveFocusCircleView(getContext());
            addView(this.hva, getChildCount() > 0 ? 1 : 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
