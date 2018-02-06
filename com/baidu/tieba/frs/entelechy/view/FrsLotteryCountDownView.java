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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dMQ = TimeUnit.MINUTES.toMillis(1);
    private static final long dMR = TimeUnit.SECONDS.toMillis(1);
    private TextView dMS;
    private TextView dMT;
    private TextView dMU;
    private TextView dMV;
    private TextView dMW;
    private TextView dMX;
    private TextView dMY;
    private TextView dMZ;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.dMS = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dMT = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dMU = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dMV = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dMW = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dMX = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dMY = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dMZ = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        aj.r(this.dMS, d.C0140d.cp_cont_g);
        aj.r(this.dMT, d.C0140d.cp_cont_c);
        aj.t(this.dMS, d.C0140d.common_color_10060);
        aj.r(this.dMU, d.C0140d.cp_cont_g);
        aj.r(this.dMV, d.C0140d.cp_cont_c);
        aj.t(this.dMU, d.C0140d.common_color_10060);
        aj.r(this.dMW, d.C0140d.cp_cont_g);
        aj.r(this.dMX, d.C0140d.cp_cont_c);
        aj.t(this.dMW, d.C0140d.common_color_10060);
        aj.r(this.dMY, d.C0140d.cp_cont_g);
        aj.r(this.dMZ, d.C0140d.cp_cont_c);
        aj.t(this.dMY, d.C0140d.common_color_10060);
        if (j <= dMR) {
            this.dMS.setText("0");
            this.dMU.setText("0");
            this.dMW.setText("0");
            this.dMY.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dMS.setVisibility(8);
            this.dMT.setVisibility(8);
        } else {
            this.dMS.setVisibility(0);
            this.dMT.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dNa;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dNa = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dNa.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dMS.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dMU.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dMW.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dMQ)));
                frsLotteryCountDownView.dMY.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dMQ) / FrsLotteryCountDownView.dMR)));
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dNa.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dMY.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dNa;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dNa = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dNa.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
