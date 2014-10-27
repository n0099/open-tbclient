package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d acv = null;
    private Handler mHandler = new Handler();
    private Object acw = null;
    private final int acx = 3000;
    private final int acy = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.acv = dVar;
    }

    public void a(Activity activity, Object obj) {
        this.acw = obj;
        String uW = com.baidu.tbadk.util.a.uR().uW();
        long uV = com.baidu.tbadk.util.a.uR().uV();
        boolean uT = com.baidu.tbadk.util.a.uR().uT();
        if (TextUtils.isEmpty(uW) || !uT || uV <= 0) {
            if (this.acv != null) {
                this.acv.t(obj);
                return;
            }
            return;
        }
        long j = uV >= 1000 ? uV : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, tbImageView, activity.getWindow().getDecorView().findViewById(16908290), activity));
        tbImageView.c(uW, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
