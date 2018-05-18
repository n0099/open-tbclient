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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dgq = TimeUnit.MINUTES.toMillis(1);
    private static final long dgr = TimeUnit.SECONDS.toMillis(1);
    private TextView dgs;
    private TextView dgt;
    private TextView dgu;
    private TextView dgv;
    private TextView dgw;
    private TextView dgx;
    private TextView dgy;
    private TextView dgz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.frs_lottery_count_down, (ViewGroup) this, true);
        this.dgs = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dgt = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dgu = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dgv = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dgw = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dgx = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dgy = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dgz = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        ak.h(this.dgs, d.C0126d.cp_cont_g);
        ak.h(this.dgt, d.C0126d.cp_cont_c);
        ak.j(this.dgs, d.C0126d.common_color_10060);
        ak.h(this.dgu, d.C0126d.cp_cont_g);
        ak.h(this.dgv, d.C0126d.cp_cont_c);
        ak.j(this.dgu, d.C0126d.common_color_10060);
        ak.h(this.dgw, d.C0126d.cp_cont_g);
        ak.h(this.dgx, d.C0126d.cp_cont_c);
        ak.j(this.dgw, d.C0126d.common_color_10060);
        ak.h(this.dgy, d.C0126d.cp_cont_g);
        ak.h(this.dgz, d.C0126d.cp_cont_c);
        ak.j(this.dgy, d.C0126d.common_color_10060);
        if (j <= dgr) {
            this.dgs.setText("0");
            this.dgu.setText("0");
            this.dgw.setText("0");
            this.dgy.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dgs.setVisibility(8);
            this.dgt.setVisibility(8);
        } else {
            this.dgs.setVisibility(0);
            this.dgt.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dgA;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dgA = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dgA.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dgs.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dgu.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dgw.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dgq)));
                frsLotteryCountDownView.dgy.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dgq) / FrsLotteryCountDownView.dgr)));
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dgA.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dgy.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dgA;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dgA = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dgA.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
