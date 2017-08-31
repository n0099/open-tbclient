package com.baidu.tieba.i;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private volatile boolean dZu;
    private RelativeLayout evR;
    private TextView evS;
    private Runnable evT;
    private Runnable evU;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    /* loaded from: classes.dex */
    public interface a {
        c getSplash();
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void aMw() {
        if (!this.dZu && isMainProcess() && aMy()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.evT == null) {
                this.evT = new Runnable() { // from class: com.baidu.tieba.i.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.evR != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.evR);
                            c.this.aMx();
                        }
                    }
                };
            }
            if (this.evU == null) {
                this.evU = new Runnable() { // from class: com.baidu.tieba.i.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oG(c.this.mContext.getString(d.l.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.evU);
            this.mHandler.postAtFrontOfQueue(this.evU);
            this.dZu = true;
            this.mHandler.postDelayed(this.evT, 20000L);
        }
    }

    public void hide() {
        if (this.evR != null && this.evS != null) {
            this.mHandler.removeCallbacks(this.evT);
            this.mHandler.post(this.evT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMx() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.evT);
            this.mHandler.removeCallbacks(this.evU);
            this.evU = null;
            this.evT = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.evS != null) {
            this.evS = null;
        }
        if (this.evR != null) {
            this.evR = null;
        }
        this.dZu = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG(String str) {
        if (this.evS == null) {
            this.evS = new b(this.mContext);
            this.evS.setTextSize(1, 18.0f);
        }
        this.evS.setText(str);
        this.evR = new RelativeLayout(this.mContext);
        this.evR.setBackgroundResource(d.g.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.evR.addView(this.evS, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.evR, layoutParams2);
    }

    private boolean isMainProcess() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.mContext.getPackageName();
        int myPid = Process.myPid();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            if (runningAppProcesses.get(i).pid == myPid && TextUtils.equals(runningAppProcesses.get(i).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aMy() {
        List<String> bL = bL(this.mContext);
        if (bL == null || bL.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bL) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (it.hasNext()) {
                arrayList.add("{" + packageName + "/" + it.next().activityInfo.name + "}");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends TextView {
        private LinearGradient evW;
        private Matrix evX;
        private int evY;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.evY = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.evX != null) {
                this.evY += this.mViewWidth / 10;
                if (this.evY > this.mViewWidth * 2) {
                    this.evY = -this.mViewWidth;
                }
                this.evX.setTranslate(this.evY, 0.0f);
                this.evW.setLocalMatrix(this.evX);
                postInvalidateDelayed(50L);
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.mViewWidth == 0) {
                this.mViewWidth = getMeasuredWidth();
                if (this.mViewWidth > 0) {
                    this.mPaint = getPaint();
                    this.evW = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.evW);
                    this.evX = new Matrix();
                }
            }
        }
    }
}
