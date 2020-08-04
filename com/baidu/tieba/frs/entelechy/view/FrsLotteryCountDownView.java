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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long hRp = TimeUnit.DAYS.toMillis(1);
    private static final long hRq = TimeUnit.HOURS.toMillis(1);
    private static final long hRr = TimeUnit.MINUTES.toMillis(1);
    private static final long hRs = TimeUnit.SECONDS.toMillis(1);
    private TextView hRA;
    private TextView hRt;
    private TextView hRu;
    private TextView hRv;
    private TextView hRw;
    private TextView hRx;
    private TextView hRy;
    private TextView hRz;
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
        this.hRt = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hRu = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hRv = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hRw = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hRx = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hRy = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hRz = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hRA = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ao.setViewTextColor(this.hRt, R.color.cp_cont_g);
        ao.setViewTextColor(this.hRu, R.color.cp_cont_c);
        ao.setBackgroundColor(this.hRt, R.color.common_color_10060);
        ao.setViewTextColor(this.hRv, R.color.cp_cont_g);
        ao.setViewTextColor(this.hRw, R.color.cp_cont_c);
        ao.setBackgroundColor(this.hRv, R.color.common_color_10060);
        ao.setViewTextColor(this.hRx, R.color.cp_cont_g);
        ao.setViewTextColor(this.hRy, R.color.cp_cont_c);
        ao.setBackgroundColor(this.hRx, R.color.common_color_10060);
        ao.setViewTextColor(this.hRz, R.color.cp_cont_g);
        ao.setViewTextColor(this.hRA, R.color.cp_cont_c);
        ao.setBackgroundColor(this.hRz, R.color.common_color_10060);
        if (j <= hRs) {
            this.hRt.setText("0");
            this.hRv.setText("0");
            this.hRx.setText("0");
            this.hRz.setText("0");
            return;
        }
        if (j / hRp <= 0) {
            this.hRt.setVisibility(8);
            this.hRu.setVisibility(8);
        } else {
            this.hRt.setVisibility(0);
            this.hRu.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes16.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hRB;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hRB = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hRB.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hRt.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hRp)));
                frsLotteryCountDownView.hRv.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hRp) / FrsLotteryCountDownView.hRq)));
                frsLotteryCountDownView.hRx.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hRp) % FrsLotteryCountDownView.hRq) / FrsLotteryCountDownView.hRr)));
                frsLotteryCountDownView.hRz.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hRp) % FrsLotteryCountDownView.hRq) % FrsLotteryCountDownView.hRr) / FrsLotteryCountDownView.hRs)));
                return;
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hRB.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hRz.setText("0");
            }
        }
    }

    /* loaded from: classes16.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hRB;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hRB = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hRB.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
