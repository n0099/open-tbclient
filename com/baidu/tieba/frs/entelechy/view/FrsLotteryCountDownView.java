package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    public static final long p = TimeUnit.DAYS.toMillis(1);
    public static final long q = TimeUnit.HOURS.toMillis(1);
    public static final long r = TimeUnit.MINUTES.toMillis(1);
    public static final long s = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: e  reason: collision with root package name */
    public Context f15383e;

    /* renamed from: f  reason: collision with root package name */
    public View f15384f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15385g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15386h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15387i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTimer o;

    /* loaded from: classes4.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTimer> f15388e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.f15388e.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        public b(WeakReference<CountDownTimer> weakReference) {
            this.f15388e = weakReference;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<FrsLotteryCountDownView> f15389a;

        public c(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.f15389a = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.f15389a.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.m.setText("0");
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.f15389a.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.f15385g.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.p)));
                frsLotteryCountDownView.f15387i.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.p) / FrsLotteryCountDownView.q)));
                frsLotteryCountDownView.k.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) / FrsLotteryCountDownView.r)));
                frsLotteryCountDownView.m.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) % FrsLotteryCountDownView.r) / FrsLotteryCountDownView.s)));
                return;
            }
            e.a().postDelayed(new b(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }
    }

    public FrsLotteryCountDownView(Context context) {
        super(context);
        this.f15383e = null;
        this.o = null;
        this.f15383e = context;
        i();
    }

    public void i() {
        View inflate = LayoutInflater.from(this.f15383e).inflate(R.layout.frs_lottery_count_down, (ViewGroup) this, true);
        this.f15384f = inflate;
        this.f15385g = (TextView) inflate.findViewById(R.id.lottery_count_day);
        this.f15386h = (TextView) this.f15384f.findViewById(R.id.lottery_count_day_txt);
        this.f15387i = (TextView) this.f15384f.findViewById(R.id.lottery_count_hour);
        this.j = (TextView) this.f15384f.findViewById(R.id.lottery_count_hour_txt);
        this.k = (TextView) this.f15384f.findViewById(R.id.lottery_count_minute);
        this.l = (TextView) this.f15384f.findViewById(R.id.lottery_count_minute_txt);
        this.m = (TextView) this.f15384f.findViewById(R.id.lottery_count_second);
        this.n = (TextView) this.f15384f.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        SkinManager.setViewTextColor(this.f15385g, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f15386h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f15385g, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.f15387i, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f15387i, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.k, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.m, R.color.common_color_10060);
        if (j <= s) {
            this.f15385g.setText("0");
            this.f15387i.setText("0");
            this.k.setText("0");
            this.m.setText("0");
            return;
        }
        if (j / p <= 0) {
            this.f15385g.setVisibility(8);
            this.f15386h.setVisibility(8);
        } else {
            this.f15385g.setVisibility(0);
            this.f15386h.setVisibility(0);
        }
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.o = new c(new WeakReference(this), j, 1000L).start();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15383e = null;
        this.o = null;
        this.f15383e = context;
        i();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15383e = null;
        this.o = null;
        this.f15383e = context;
        i();
    }
}
