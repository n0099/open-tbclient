package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d acA = null;
    private Handler mHandler = new Handler();
    private Object acB = null;
    private final int acC = 3000;
    private final int acD = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.acA = dVar;
    }

    public void a(Activity activity, Object obj) {
        this.acB = obj;
        String uY = com.baidu.tbadk.util.a.uT().uY();
        long uX = com.baidu.tbadk.util.a.uT().uX();
        boolean uV = com.baidu.tbadk.util.a.uT().uV();
        if (TextUtils.isEmpty(uY) || !uV || uX <= 0) {
            if (this.acA != null) {
                this.acA.t(obj);
                return;
            }
            return;
        }
        long j = uX >= 1000 ? uX : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, tbImageView, activity.getWindow().getDecorView().findViewById(16908290), activity));
        tbImageView.c(uY, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
