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
    private static final long hjm = TimeUnit.DAYS.toMillis(1);
    private static final long hjn = TimeUnit.HOURS.toMillis(1);
    private static final long hjo = TimeUnit.MINUTES.toMillis(1);
    private static final long hjp = TimeUnit.SECONDS.toMillis(1);
    private TextView hjq;
    private TextView hjr;
    private TextView hjs;
    private TextView hjt;
    private TextView hju;
    private TextView hjv;
    private TextView hjw;
    private TextView hjx;
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
        this.hjq = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hjr = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hjs = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hjt = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hju = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hjv = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hjw = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hjx = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.hjq, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjr, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjq, R.color.common_color_10060);
        am.setViewTextColor(this.hjs, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjt, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjs, R.color.common_color_10060);
        am.setViewTextColor(this.hju, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjv, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hju, R.color.common_color_10060);
        am.setViewTextColor(this.hjw, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hjx, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hjw, R.color.common_color_10060);
        if (j <= hjp) {
            this.hjq.setText("0");
            this.hjs.setText("0");
            this.hju.setText("0");
            this.hjw.setText("0");
            return;
        }
        if (j / hjm <= 0) {
            this.hjq.setVisibility(8);
            this.hjr.setVisibility(8);
        } else {
            this.hjq.setVisibility(0);
            this.hjr.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hjy;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hjy = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hjy.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hjq.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hjm)));
                frsLotteryCountDownView.hjs.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hjm) / FrsLotteryCountDownView.hjn)));
                frsLotteryCountDownView.hju.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hjm) % FrsLotteryCountDownView.hjn) / FrsLotteryCountDownView.hjo)));
                frsLotteryCountDownView.hjw.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hjm) % FrsLotteryCountDownView.hjn) % FrsLotteryCountDownView.hjo) / FrsLotteryCountDownView.hjp)));
                return;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hjy.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hjw.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hjy;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hjy = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hjy.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
