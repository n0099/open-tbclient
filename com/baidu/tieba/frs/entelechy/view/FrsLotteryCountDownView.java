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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dKj = TimeUnit.MINUTES.toMillis(1);
    private static final long dKk = TimeUnit.SECONDS.toMillis(1);
    private TextView dKl;
    private TextView dKm;
    private TextView dKn;
    private TextView dKo;
    private TextView dKp;
    private TextView dKq;
    private TextView dKr;
    private TextView dKs;
    private Context mContext;
    private View mRootView;
    private CountDownTimer mTimer;

    public FrsLotteryCountDownView(Context context) {
        super(context);
        this.mContext = null;
        this.mTimer = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mTimer = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mTimer = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.dKl = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dKm = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dKn = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dKo = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dKp = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dKq = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dKr = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dKs = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dKl, e.d.cp_cont_g);
        al.h(this.dKm, e.d.cp_cont_c);
        al.j(this.dKl, e.d.common_color_10060);
        al.h(this.dKn, e.d.cp_cont_g);
        al.h(this.dKo, e.d.cp_cont_c);
        al.j(this.dKn, e.d.common_color_10060);
        al.h(this.dKp, e.d.cp_cont_g);
        al.h(this.dKq, e.d.cp_cont_c);
        al.j(this.dKp, e.d.common_color_10060);
        al.h(this.dKr, e.d.cp_cont_g);
        al.h(this.dKs, e.d.cp_cont_c);
        al.j(this.dKr, e.d.common_color_10060);
        if (j <= dKk) {
            this.dKl.setText("0");
            this.dKn.setText("0");
            this.dKp.setText("0");
            this.dKr.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dKl.setVisibility(8);
            this.dKm.setVisibility(8);
        } else {
            this.dKl.setVisibility(0);
            this.dKm.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dKt;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dKt = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dKt.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dKl.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dKn.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dKp.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dKj)));
                frsLotteryCountDownView.dKr.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dKj) / FrsLotteryCountDownView.dKk)));
                return;
            }
            com.baidu.adp.lib.g.e.jI().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dKt.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dKr.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dKt;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dKt = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dKt.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
