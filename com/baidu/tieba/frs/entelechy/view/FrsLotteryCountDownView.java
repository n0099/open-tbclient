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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes22.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long iTS = TimeUnit.DAYS.toMillis(1);
    private static final long iTT = TimeUnit.HOURS.toMillis(1);
    private static final long iTU = TimeUnit.MINUTES.toMillis(1);
    private static final long iTV = TimeUnit.SECONDS.toMillis(1);
    private TextView iTW;
    private TextView iTX;
    private TextView iTY;
    private TextView iTZ;
    private TextView iUa;
    private TextView iUb;
    private TextView iUc;
    private TextView iUd;
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
        this.iTW = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.iTX = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.iTY = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.iTZ = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.iUa = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.iUb = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.iUc = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.iUd = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.iTW, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iTX, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iTW, R.color.common_color_10060);
        ap.setViewTextColor(this.iTY, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iTZ, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iTY, R.color.common_color_10060);
        ap.setViewTextColor(this.iUa, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iUb, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iUa, R.color.common_color_10060);
        ap.setViewTextColor(this.iUc, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iUd, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iUc, R.color.common_color_10060);
        if (j <= iTV) {
            this.iTW.setText("0");
            this.iTY.setText("0");
            this.iUa.setText("0");
            this.iUc.setText("0");
            return;
        }
        if (j / iTS <= 0) {
            this.iTW.setVisibility(8);
            this.iTX.setVisibility(8);
        } else {
            this.iTW.setVisibility(0);
            this.iTX.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes22.dex */
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
                frsLotteryCountDownView.iTW.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.iTS)));
                frsLotteryCountDownView.iTY.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.iTS) / FrsLotteryCountDownView.iTT)));
                frsLotteryCountDownView.iUa.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.iTS) % FrsLotteryCountDownView.iTT) / FrsLotteryCountDownView.iTU)));
                frsLotteryCountDownView.iUc.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.iTS) % FrsLotteryCountDownView.iTT) % FrsLotteryCountDownView.iTU) / FrsLotteryCountDownView.iTV)));
                return;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.iUc.setText("0");
            }
        }
    }

    /* loaded from: classes22.dex */
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
