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
    private static final long dUH = TimeUnit.MINUTES.toMillis(1);
    private static final long dUI = TimeUnit.SECONDS.toMillis(1);
    private TextView dUJ;
    private TextView dUK;
    private TextView dUL;
    private TextView dUM;
    private TextView dUN;
    private TextView dUO;
    private TextView dUP;
    private TextView dUQ;
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
        this.dUJ = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dUK = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dUL = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dUM = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dUN = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dUO = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dUP = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dUQ = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dUJ, e.d.cp_cont_g);
        al.h(this.dUK, e.d.cp_cont_c);
        al.j(this.dUJ, e.d.common_color_10060);
        al.h(this.dUL, e.d.cp_cont_g);
        al.h(this.dUM, e.d.cp_cont_c);
        al.j(this.dUL, e.d.common_color_10060);
        al.h(this.dUN, e.d.cp_cont_g);
        al.h(this.dUO, e.d.cp_cont_c);
        al.j(this.dUN, e.d.common_color_10060);
        al.h(this.dUP, e.d.cp_cont_g);
        al.h(this.dUQ, e.d.cp_cont_c);
        al.j(this.dUP, e.d.common_color_10060);
        if (j <= dUI) {
            this.dUJ.setText("0");
            this.dUL.setText("0");
            this.dUN.setText("0");
            this.dUP.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dUJ.setVisibility(8);
            this.dUK.setVisibility(8);
        } else {
            this.dUJ.setVisibility(0);
            this.dUK.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dUR;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dUR = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dUR.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dUJ.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dUL.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dUN.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dUH)));
                frsLotteryCountDownView.dUP.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dUH) / FrsLotteryCountDownView.dUI)));
                return;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dUR.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dUP.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dUR;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dUR = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dUR.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
