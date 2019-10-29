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
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long fFS = TimeUnit.DAYS.toMillis(1);
    private static final long fFT = TimeUnit.HOURS.toMillis(1);
    private static final long fFU = TimeUnit.MINUTES.toMillis(1);
    private static final long fFV = TimeUnit.SECONDS.toMillis(1);
    private TextView fFW;
    private TextView fFX;
    private TextView fFY;
    private TextView fFZ;
    private TextView fGa;
    private TextView fGb;
    private TextView fGc;
    private TextView fGd;
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
        this.fFW = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fFX = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fFY = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fFZ = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fGa = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fGb = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fGc = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fGd = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.fFW, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFX, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFW, R.color.common_color_10060);
        am.setViewTextColor(this.fFY, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFZ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFY, R.color.common_color_10060);
        am.setViewTextColor(this.fGa, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fGb, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fGa, R.color.common_color_10060);
        am.setViewTextColor(this.fGc, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fGd, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fGc, R.color.common_color_10060);
        if (j <= fFV) {
            this.fFW.setText("0");
            this.fFY.setText("0");
            this.fGa.setText("0");
            this.fGc.setText("0");
            return;
        }
        if (j / fFS <= 0) {
            this.fFW.setVisibility(8);
            this.fFX.setVisibility(8);
        } else {
            this.fFW.setVisibility(0);
            this.fFX.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> reference;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.reference = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fFW.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.fFS)));
                frsLotteryCountDownView.fFY.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.fFS) / FrsLotteryCountDownView.fFT)));
                frsLotteryCountDownView.fGa.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.fFS) % FrsLotteryCountDownView.fFT) / FrsLotteryCountDownView.fFU)));
                frsLotteryCountDownView.fGc.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.fFS) % FrsLotteryCountDownView.fFT) % FrsLotteryCountDownView.fFU) / FrsLotteryCountDownView.fFV)));
                return;
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fGc.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> reference;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.reference = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.reference.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
