package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.performanceLog.ad;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d akm = null;
    private Handler mHandler = new Handler();
    private Object akn = null;
    private final int ako = 3000;
    private final int MIN_SHOW_TIME = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.akm = dVar;
    }

    public void a(Activity activity, Object obj) {
        ad.zl().z(System.currentTimeMillis());
        this.akn = obj;
        String zv = com.baidu.tbadk.util.a.zq().zv();
        long zu = com.baidu.tbadk.util.a.zq().zu();
        boolean zs = com.baidu.tbadk.util.a.zq().zs();
        if (TextUtils.isEmpty(zv) || !zs || zu <= 0) {
            if (this.akm != null) {
                this.akm.A(obj);
                return;
            }
            return;
        }
        long j = zu >= 1000 ? zu : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, tbImageView, activity.getWindow().getDecorView().findViewById(16908290), activity));
        tbImageView.d(zv, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
