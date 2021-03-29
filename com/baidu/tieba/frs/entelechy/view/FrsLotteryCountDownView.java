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
import d.b.b.e.m.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    public static final long p = TimeUnit.DAYS.toMillis(1);
    public static final long q = TimeUnit.HOURS.toMillis(1);
    public static final long r = TimeUnit.MINUTES.toMillis(1);
    public static final long s = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: e  reason: collision with root package name */
    public Context f16244e;

    /* renamed from: f  reason: collision with root package name */
    public View f16245f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16246g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16247h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTimer o;

    /* loaded from: classes4.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTimer> f16248e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.f16248e.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        public b(WeakReference<CountDownTimer> weakReference) {
            this.f16248e = weakReference;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<FrsLotteryCountDownView> f16249a;

        public c(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.f16249a = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.f16249a.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.m.setText("0");
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.f16249a.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.f16246g.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.p)));
                frsLotteryCountDownView.i.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.p) / FrsLotteryCountDownView.q)));
                frsLotteryCountDownView.k.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) / FrsLotteryCountDownView.r)));
                frsLotteryCountDownView.m.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) % FrsLotteryCountDownView.r) / FrsLotteryCountDownView.s)));
                return;
            }
            e.a().postDelayed(new b(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }
    }

    public FrsLotteryCountDownView(Context context) {
        super(context);
        this.f16244e = null;
        this.o = null;
        this.f16244e = context;
        i();
    }

    public void i() {
        View inflate = LayoutInflater.from(this.f16244e).inflate(R.layout.frs_lottery_count_down, (ViewGroup) this, true);
        this.f16245f = inflate;
        this.f16246g = (TextView) inflate.findViewById(R.id.lottery_count_day);
        this.f16247h = (TextView) this.f16245f.findViewById(R.id.lottery_count_day_txt);
        this.i = (TextView) this.f16245f.findViewById(R.id.lottery_count_hour);
        this.j = (TextView) this.f16245f.findViewById(R.id.lottery_count_hour_txt);
        this.k = (TextView) this.f16245f.findViewById(R.id.lottery_count_minute);
        this.l = (TextView) this.f16245f.findViewById(R.id.lottery_count_minute_txt);
        this.m = (TextView) this.f16245f.findViewById(R.id.lottery_count_second);
        this.n = (TextView) this.f16245f.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        SkinManager.setViewTextColor(this.f16246g, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f16247h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f16246g, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.i, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.k, R.color.common_color_10060);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.m, R.color.common_color_10060);
        if (j <= s) {
            this.f16246g.setText("0");
            this.i.setText("0");
            this.k.setText("0");
            this.m.setText("0");
            return;
        }
        if (j / p <= 0) {
            this.f16246g.setVisibility(8);
            this.f16247h.setVisibility(8);
        } else {
            this.f16246g.setVisibility(0);
            this.f16247h.setVisibility(0);
        }
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.o = new c(new WeakReference(this), j, 1000L).start();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16244e = null;
        this.o = null;
        this.f16244e = context;
        i();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16244e = null;
        this.o = null;
        this.f16244e = context;
        i();
    }
}
