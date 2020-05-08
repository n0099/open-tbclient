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
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long hjs = TimeUnit.DAYS.toMillis(1);
    private static final long hjt = TimeUnit.HOURS.toMillis(1);
    private static final long hju = TimeUnit.MINUTES.toMillis(1);
    private static final long hjv = TimeUnit.SECONDS.toMillis(1);
    private TextView hjA;
    private TextView hjB;
    private TextView hjC;
    private TextView hjD;
    private TextView hjw;
    private TextView hjx;
    private TextView hjy;
    private TextView hjz;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.frs_lottery_count_down, (ViewGroup) this, true);
        this.hjw = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hjx = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hjy = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hjz = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hjA = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hjB = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hjC = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hjD = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.hjw, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjx, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjw, R.color.common_color_10060);
        am.setViewTextColor(this.hjy, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjz, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjy, R.color.common_color_10060);
        am.setViewTextColor(this.hjA, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjB, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjA, R.color.common_color_10060);
        am.setViewTextColor(this.hjC, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjD, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjC, R.color.common_color_10060);
        if (j <= hjv) {
            this.hjw.setText("0");
            this.hjy.setText("0");
            this.hjA.setText("0");
            this.hjC.setText("0");
            return;
        }
        if (j / hjs <= 0) {
            this.hjw.setVisibility(8);
            this.hjx.setVisibility(8);
        } else {
            this.hjw.setVisibility(0);
            this.hjx.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hjE;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hjE = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hjE.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hjw.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hjs)));
                frsLotteryCountDownView.hjy.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hjs) / FrsLotteryCountDownView.hjt)));
                frsLotteryCountDownView.hjA.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hjs) % FrsLotteryCountDownView.hjt) / FrsLotteryCountDownView.hju)));
                frsLotteryCountDownView.hjC.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hjs) % FrsLotteryCountDownView.hjt) % FrsLotteryCountDownView.hju) / FrsLotteryCountDownView.hjv)));
                return;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hjE.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hjC.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hjE;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hjE = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hjE.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
