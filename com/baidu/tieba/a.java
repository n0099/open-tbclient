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
    private d atn = null;
    private Handler mHandler = new Handler();
    private Object ato = null;
    private final int atp = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
    private final int MIN_SHOW_TIME = 1000;
    private Runnable mRunnable = new b(this);

    public void a(d dVar) {
        this.atn = dVar;
    }

    public void a(Activity activity, Object obj) {
        com.baidu.tbadk.performanceLog.ai.CQ().z(System.currentTimeMillis());
        this.ato = obj;
        String Da = com.baidu.tbadk.util.a.CV().Da();
        long CZ = com.baidu.tbadk.util.a.CV().CZ();
        boolean CX = com.baidu.tbadk.util.a.CV().CX();
        if (TextUtils.isEmpty(Da) || !CX || CZ <= 0) {
            if (this.atn != null) {
                this.atn.C(obj);
                return;
            }
            return;
        }
        long j = CZ >= 1000 ? CZ : 1000L;
        long j2 = j <= 3000 ? j : 3000L;
        TbImageView tbImageView = new TbImageView(activity);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        TiebaStatic.eventStat(activity, "lpage_tg_pic_load", null);
        tbImageView.setEvent(new c(this, tbImageView, findViewById, activity));
        tbImageView.c(Da, 10, false);
        this.mHandler.postDelayed(this.mRunnable, j2);
    }
}
