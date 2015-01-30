package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d akQ = null;
    private Handler mHandler = new Handler();
    private Object akR = null;
    private final int akS = 3000;
    private final int MIN_SHOW_TIME = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.akQ = dVar;
    }

    public void a(Activity activity, Object obj) {
        com.baidu.tbadk.performanceLog.ad.zC().z(System.currentTimeMillis());
        this.akR = obj;
        String zM = com.baidu.tbadk.util.a.zH().zM();
        long zL = com.baidu.tbadk.util.a.zH().zL();
        boolean zJ = com.baidu.tbadk.util.a.zH().zJ();
        if (TextUtils.isEmpty(zM) || !zJ || zL <= 0) {
            if (this.akQ != null) {
                this.akQ.A(obj);
                return;
            }
            return;
        }
        long j = zL >= 1000 ? zL : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, tbImageView, activity.getWindow().getDecorView().findViewById(16908290), activity));
        tbImageView.d(zM, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
