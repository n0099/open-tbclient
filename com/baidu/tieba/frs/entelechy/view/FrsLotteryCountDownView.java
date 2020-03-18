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
    private static final long gzQ = TimeUnit.DAYS.toMillis(1);
    private static final long gzR = TimeUnit.HOURS.toMillis(1);
    private static final long gzS = TimeUnit.MINUTES.toMillis(1);
    private static final long gzT = TimeUnit.SECONDS.toMillis(1);
    private TextView gAa;
    private TextView gAb;
    private TextView gzU;
    private TextView gzV;
    private TextView gzW;
    private TextView gzX;
    private TextView gzY;
    private TextView gzZ;
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
        this.gzU = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gzV = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gzW = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gzX = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gzY = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gzZ = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gAa = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gAb = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gzU, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gzV, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gzU, R.color.common_color_10060);
        am.setViewTextColor(this.gzW, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gzX, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gzW, R.color.common_color_10060);
        am.setViewTextColor(this.gzY, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gzZ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gzY, R.color.common_color_10060);
        am.setViewTextColor(this.gAa, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gAb, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gAa, R.color.common_color_10060);
        if (j <= gzT) {
            this.gzU.setText("0");
            this.gzW.setText("0");
            this.gzY.setText("0");
            this.gAa.setText("0");
            return;
        }
        if (j / gzQ <= 0) {
            this.gzU.setVisibility(8);
            this.gzV.setVisibility(8);
        } else {
            this.gzU.setVisibility(0);
            this.gzV.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> gAc;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.gAc = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gAc.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gzU.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gzQ)));
                frsLotteryCountDownView.gzW.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gzQ) / FrsLotteryCountDownView.gzR)));
                frsLotteryCountDownView.gzY.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gzQ) % FrsLotteryCountDownView.gzR) / FrsLotteryCountDownView.gzS)));
                frsLotteryCountDownView.gAa.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gzQ) % FrsLotteryCountDownView.gzR) % FrsLotteryCountDownView.gzS) / FrsLotteryCountDownView.gzT)));
                return;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gAc.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gAa.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> gAc;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.gAc = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.gAc.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
