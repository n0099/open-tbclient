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
    private volatile boolean dSJ;
    private RelativeLayout epf;
    private TextView epg;
    private Runnable eph;
    private Runnable epi;
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

    public void aKJ() {
        if (!this.dSJ && isMainProcess() && aKK()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.eph == null) {
                this.eph = new Runnable() { // from class: com.baidu.tieba.i.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.epf != null) {
                            ((WindowManager) c.this.mContext.getSystemService("window")).removeViewImmediate(c.this.epf);
                            c.this.clean();
                        }
                    }
                };
            }
            if (this.epi == null) {
                this.epi = new Runnable() { // from class: com.baidu.tieba.i.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oo(c.this.mContext.getString(d.l.data_init));
                    }
                };
            }
            this.mHandler.removeCallbacks(this.epi);
            this.mHandler.postAtFrontOfQueue(this.epi);
            this.dSJ = true;
            this.mHandler.postDelayed(this.eph, 20000L);
        }
    }

    public void hide() {
        if (this.epf != null && this.epg != null) {
            this.mHandler.removeCallbacks(this.eph);
            this.mHandler.post(this.eph);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eph);
            this.mHandler.removeCallbacks(this.epi);
            this.epi = null;
            this.eph = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.epg != null) {
            this.epg = null;
        }
        if (this.epf != null) {
            this.epf = null;
        }
        this.dSJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(String str) {
        if (this.epg == null) {
            this.epg = new b(this.mContext);
            this.epg.setTextSize(1, 18.0f);
        }
        this.epg.setText(str);
        this.epf = new RelativeLayout(this.mContext);
        this.epf.setBackgroundResource(d.g.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.epf.addView(this.epg, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.epf, layoutParams2);
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
    private boolean aKK() {
        List<String> bC = bC(this.mContext);
        if (bC == null || bC.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bC) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bC(Context context) {
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
        private LinearGradient epk;
        private Matrix epl;
        private int epm;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.epm = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.epl != null) {
                this.epm += this.mViewWidth / 10;
                if (this.epm > this.mViewWidth * 2) {
                    this.epm = -this.mViewWidth;
                }
                this.epl.setTranslate(this.epm, 0.0f);
                this.epk.setLocalMatrix(this.epl);
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
                    this.epk = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.epk);
                    this.epl = new Matrix();
                }
            }
        }
    }
}
