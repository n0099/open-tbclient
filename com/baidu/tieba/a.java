package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class a {
    private d atv = null;
    private Handler mHandler = new Handler();
    private Object atw = null;
    private final int atx = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    private final int MIN_SHOW_TIME = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.atv = dVar;
    }

    public void a(Activity activity, Object obj) {
        com.baidu.tbadk.performanceLog.ai.CW().z(System.currentTimeMillis());
        this.atw = obj;
        String Dg = com.baidu.tbadk.util.a.Db().Dg();
        long Df = com.baidu.tbadk.util.a.Db().Df();
        boolean Dd = com.baidu.tbadk.util.a.Db().Dd();
        if (TextUtils.isEmpty(Dg) || !Dd || Df <= 0) {
            if (this.atv != null) {
                this.atv.C(obj);
                return;
            }
            return;
        }
        long j = Df >= 1000 ? Df : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        TiebaStatic.eventStat(activity, "lpage_tg_pic_load", null);
        tbImageView.setEvent(new c(this, tbImageView, findViewById, activity));
        tbImageView.c(Dg, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
