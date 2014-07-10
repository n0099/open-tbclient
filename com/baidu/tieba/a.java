package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d a = null;
    private Handler b = new Handler();
    private Object c = null;
    private final int d = KirinConfig.CONNECT_TIME_OUT;
    private final int e = 1000;
    private Runnable f = new b(this);

    public void a(d dVar) {
        this.a = dVar;
    }

    public void a(Activity activity, Object obj) {
        this.c = obj;
        String g = com.baidu.tbadk.b.a.a().g();
        long f = com.baidu.tbadk.b.a.a().f();
        boolean c = com.baidu.tbadk.b.a.a().c();
        if (TextUtils.isEmpty(g) || !c || f <= 0) {
            if (this.a != null) {
                this.a.a(obj);
                return;
            }
            return;
        }
        long j = f >= 1000 ? f : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setEvent(new c(this, activity.getWindow().getDecorView().findViewById(16908290), tbImageView, activity));
        tbImageView.a(g, 10, false);
        this.b.postDelayed(this.f, j2);
    }
}
