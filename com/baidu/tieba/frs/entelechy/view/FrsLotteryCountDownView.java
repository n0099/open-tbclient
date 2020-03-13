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
    private static final long gyS = TimeUnit.DAYS.toMillis(1);
    private static final long gyT = TimeUnit.HOURS.toMillis(1);
    private static final long gyU = TimeUnit.MINUTES.toMillis(1);
    private static final long gyV = TimeUnit.SECONDS.toMillis(1);
    private TextView gyW;
    private TextView gyX;
    private TextView gyY;
    private TextView gyZ;
    private TextView gza;
    private TextView gzb;
    private TextView gzc;
    private TextView gzd;
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
        this.gyW = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gyX = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gyY = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gyZ = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gza = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gzb = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gzc = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gzd = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gyW, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyX, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyW, R.color.common_color_10060);
        am.setViewTextColor(this.gyY, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyZ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyY, R.color.common_color_10060);
        am.setViewTextColor(this.gza, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gzb, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gza, R.color.common_color_10060);
        am.setViewTextColor(this.gzc, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gzd, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gzc, R.color.common_color_10060);
        if (j <= gyV) {
            this.gyW.setText("0");
            this.gyY.setText("0");
            this.gza.setText("0");
            this.gzc.setText("0");
            return;
        }
        if (j / gyS <= 0) {
            this.gyW.setVisibility(8);
            this.gyX.setVisibility(8);
        } else {
            this.gyW.setVisibility(0);
            this.gyX.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> gze;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.gze = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gze.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gyW.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gyS)));
                frsLotteryCountDownView.gyY.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gyS) / FrsLotteryCountDownView.gyT)));
                frsLotteryCountDownView.gza.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gyS) % FrsLotteryCountDownView.gyT) / FrsLotteryCountDownView.gyU)));
                frsLotteryCountDownView.gzc.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gyS) % FrsLotteryCountDownView.gyT) % FrsLotteryCountDownView.gyU) / FrsLotteryCountDownView.gyV)));
                return;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gze.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gzc.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> gze;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.gze = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.gze.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
