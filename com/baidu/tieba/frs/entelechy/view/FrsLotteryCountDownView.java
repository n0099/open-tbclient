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
    private static final long dME = TimeUnit.MINUTES.toMillis(1);
    private static final long dMF = TimeUnit.SECONDS.toMillis(1);
    private TextView dMG;
    private TextView dMH;
    private TextView dMI;
    private TextView dMJ;
    private TextView dMK;
    private TextView dML;
    private TextView dMM;
    private TextView dMN;
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
        this.dMG = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dMH = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dMI = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dMJ = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dMK = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dML = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dMM = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dMN = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        aj.r(this.dMG, d.C0141d.cp_cont_g);
        aj.r(this.dMH, d.C0141d.cp_cont_c);
        aj.t(this.dMG, d.C0141d.common_color_10060);
        aj.r(this.dMI, d.C0141d.cp_cont_g);
        aj.r(this.dMJ, d.C0141d.cp_cont_c);
        aj.t(this.dMI, d.C0141d.common_color_10060);
        aj.r(this.dMK, d.C0141d.cp_cont_g);
        aj.r(this.dML, d.C0141d.cp_cont_c);
        aj.t(this.dMK, d.C0141d.common_color_10060);
        aj.r(this.dMM, d.C0141d.cp_cont_g);
        aj.r(this.dMN, d.C0141d.cp_cont_c);
        aj.t(this.dMM, d.C0141d.common_color_10060);
        if (j <= dMF) {
            this.dMG.setText("0");
            this.dMI.setText("0");
            this.dMK.setText("0");
            this.dMM.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dMG.setVisibility(8);
            this.dMH.setVisibility(8);
        } else {
            this.dMG.setVisibility(0);
            this.dMH.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dMO;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dMO = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dMO.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dMG.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dMI.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dMK.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dME)));
                frsLotteryCountDownView.dMM.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dME) / FrsLotteryCountDownView.dMF)));
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dMO.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dMM.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dMO;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dMO = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dMO.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
