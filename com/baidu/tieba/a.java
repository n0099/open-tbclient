package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d akN = null;
    private Handler mHandler = new Handler();
    private Object akO = null;
    private final int akP = 3000;
    private final int MIN_SHOW_TIME = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.akN = dVar;
    }

    public void a(Activity activity, Object obj) {
        com.baidu.tbadk.performanceLog.ad.zw().z(System.currentTimeMillis());
        this.akO = obj;
        String zG = com.baidu.tbadk.util.a.zB().zG();
        long zF = com.baidu.tbadk.util.a.zB().zF();
        boolean zD = com.baidu.tbadk.util.a.zB().zD();
        if (TextUtils.isEmpty(zG) || !zD || zF <= 0) {
            if (this.akN != null) {
                this.akN.A(obj);
                return;
            }
            return;
        }
        long j = zF >= 1000 ? zF : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, tbImageView, activity.getWindow().getDecorView().findViewById(16908290), activity));
        tbImageView.d(zG, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
