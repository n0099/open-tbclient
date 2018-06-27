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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dsO = TimeUnit.MINUTES.toMillis(1);
    private static final long dsP = TimeUnit.SECONDS.toMillis(1);
    private TextView dsQ;
    private TextView dsR;
    private TextView dsS;
    private TextView dsT;
    private TextView dsU;
    private TextView dsV;
    private TextView dsW;
    private TextView dsX;
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
        this.dsQ = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dsR = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dsS = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dsT = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dsU = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dsV = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dsW = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dsX = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.h(this.dsQ, d.C0142d.cp_cont_g);
        am.h(this.dsR, d.C0142d.cp_cont_c);
        am.j(this.dsQ, d.C0142d.common_color_10060);
        am.h(this.dsS, d.C0142d.cp_cont_g);
        am.h(this.dsT, d.C0142d.cp_cont_c);
        am.j(this.dsS, d.C0142d.common_color_10060);
        am.h(this.dsU, d.C0142d.cp_cont_g);
        am.h(this.dsV, d.C0142d.cp_cont_c);
        am.j(this.dsU, d.C0142d.common_color_10060);
        am.h(this.dsW, d.C0142d.cp_cont_g);
        am.h(this.dsX, d.C0142d.cp_cont_c);
        am.j(this.dsW, d.C0142d.common_color_10060);
        if (j <= dsP) {
            this.dsQ.setText("0");
            this.dsS.setText("0");
            this.dsU.setText("0");
            this.dsW.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dsQ.setVisibility(8);
            this.dsR.setVisibility(8);
        } else {
            this.dsQ.setVisibility(0);
            this.dsR.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dsY;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dsY = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dsY.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dsQ.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dsS.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dsU.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dsO)));
                frsLotteryCountDownView.dsW.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dsO) / FrsLotteryCountDownView.dsP)));
                return;
            }
            com.baidu.adp.lib.g.e.im().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dsY.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dsW.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dsY;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dsY = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dsY.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
