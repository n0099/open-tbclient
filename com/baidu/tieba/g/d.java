package com.baidu.tieba.g;

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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private RelativeLayout dOS;
    private TextView dOT;
    private Runnable dOU;
    private Runnable dOV;
    private volatile boolean dsO;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    /* loaded from: classes.dex */
    public interface a {
        d getSplash();
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void aDk() {
        if (!this.dsO && isMainProcess() && aDl()) {
            if (this.mHandlerThread == null) {
                this.mHandlerThread = new HandlerThread("splash-thread");
                this.mHandlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mHandlerThread.getLooper());
            }
            if (this.dOU == null) {
                this.dOU = new e(this);
            }
            if (this.dOV == null) {
                this.dOV = new f(this);
            }
            this.mHandler.removeCallbacks(this.dOV);
            this.mHandler.postAtFrontOfQueue(this.dOV);
            this.dsO = true;
            this.mHandler.postDelayed(this.dOU, 20000L);
        }
    }

    public void hide() {
        if (this.dOS != null && this.dOT != null) {
            this.mHandler.removeCallbacks(this.dOU);
            this.mHandler.post(this.dOU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dOU);
            this.mHandler.removeCallbacks(this.dOV);
            this.dOV = null;
            this.dOU = null;
            this.mHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
        }
        if (this.dOT != null) {
            this.dOT = null;
        }
        if (this.dOS != null) {
            this.dOS = null;
        }
        this.dsO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(String str) {
        if (this.dOT == null) {
            this.dOT = new b(this.mContext);
            this.dOT.setTextSize(1, 18.0f);
        }
        this.dOT.setText(str);
        this.dOS = new RelativeLayout(this.mContext);
        this.dOS.setBackgroundResource(w.g.bg_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.dOS.addView(this.dOT, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 256;
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.dOS, layoutParams2);
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aDl() {
        List<String> bI = bI(this.mContext);
        if (bI == null || bI.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1).get(0);
        String shortString = runningTaskInfo.baseActivity.toShortString();
        String shortString2 = runningTaskInfo.topActivity.toShortString();
        for (String str : bI) {
            if (shortString.equals(str) || shortString2.equals(str)) {
                return true;
            }
            while (r3.hasNext()) {
            }
        }
        return false;
    }

    private List<String> bI(Context context) {
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
        private LinearGradient dOX;
        private Matrix dOY;
        private int dOZ;
        private boolean mAnimating;
        private Paint mPaint;
        private int mViewWidth;

        public b(Context context) {
            super(context);
            this.mViewWidth = 0;
            this.dOZ = 0;
            this.mAnimating = true;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.mAnimating && this.dOY != null) {
                this.dOZ += this.mViewWidth / 10;
                if (this.dOZ > this.mViewWidth * 2) {
                    this.dOZ = -this.mViewWidth;
                }
                this.dOY.setTranslate(this.dOZ, 0.0f);
                this.dOX.setLocalMatrix(this.dOY);
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
                    this.dOX = new LinearGradient(-this.mViewWidth, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.mPaint.setShader(this.dOX);
                    this.dOY = new Matrix();
                }
            }
        }
    }
}
