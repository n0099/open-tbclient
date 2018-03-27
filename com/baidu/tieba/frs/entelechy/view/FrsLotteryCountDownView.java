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
    private static final long dMJ = TimeUnit.MINUTES.toMillis(1);
    private static final long dMK = TimeUnit.SECONDS.toMillis(1);
    private TextView dML;
    private TextView dMM;
    private TextView dMN;
    private TextView dMO;
    private TextView dMP;
    private TextView dMQ;
    private TextView dMR;
    private TextView dMS;
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
        this.dML = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dMM = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dMN = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dMO = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dMP = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dMQ = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dMR = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dMS = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        aj.r(this.dML, d.C0141d.cp_cont_g);
        aj.r(this.dMM, d.C0141d.cp_cont_c);
        aj.t(this.dML, d.C0141d.common_color_10060);
        aj.r(this.dMN, d.C0141d.cp_cont_g);
        aj.r(this.dMO, d.C0141d.cp_cont_c);
        aj.t(this.dMN, d.C0141d.common_color_10060);
        aj.r(this.dMP, d.C0141d.cp_cont_g);
        aj.r(this.dMQ, d.C0141d.cp_cont_c);
        aj.t(this.dMP, d.C0141d.common_color_10060);
        aj.r(this.dMR, d.C0141d.cp_cont_g);
        aj.r(this.dMS, d.C0141d.cp_cont_c);
        aj.t(this.dMR, d.C0141d.common_color_10060);
        if (j <= dMK) {
            this.dML.setText("0");
            this.dMN.setText("0");
            this.dMP.setText("0");
            this.dMR.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dML.setVisibility(8);
            this.dMM.setVisibility(8);
        } else {
            this.dML.setVisibility(0);
            this.dMM.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dMT;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dMT = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dMT.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dML.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dMN.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dMP.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dMJ)));
                frsLotteryCountDownView.dMR.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dMJ) / FrsLotteryCountDownView.dMK)));
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dMT.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dMR.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dMT;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dMT = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dMT.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
