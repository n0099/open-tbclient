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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long hLo = TimeUnit.DAYS.toMillis(1);
    private static final long hLp = TimeUnit.HOURS.toMillis(1);
    private static final long hLq = TimeUnit.MINUTES.toMillis(1);
    private static final long hLr = TimeUnit.SECONDS.toMillis(1);
    private TextView hLs;
    private TextView hLt;
    private TextView hLu;
    private TextView hLv;
    private TextView hLw;
    private TextView hLx;
    private TextView hLy;
    private TextView hLz;
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
        this.hLs = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hLt = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hLu = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hLv = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hLw = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hLx = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hLy = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hLz = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        an.setViewTextColor(this.hLs, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hLt, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.hLs, R.color.common_color_10060);
        an.setViewTextColor(this.hLu, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hLv, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.hLu, R.color.common_color_10060);
        an.setViewTextColor(this.hLw, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hLx, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.hLw, R.color.common_color_10060);
        an.setViewTextColor(this.hLy, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hLz, (int) R.color.cp_cont_c);
        an.setBackgroundColor(this.hLy, R.color.common_color_10060);
        if (j <= hLr) {
            this.hLs.setText("0");
            this.hLu.setText("0");
            this.hLw.setText("0");
            this.hLy.setText("0");
            return;
        }
        if (j / hLo <= 0) {
            this.hLs.setVisibility(8);
            this.hLt.setVisibility(8);
        } else {
            this.hLs.setVisibility(0);
            this.hLt.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hLA;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hLA = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hLA.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hLs.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hLo)));
                frsLotteryCountDownView.hLu.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hLo) / FrsLotteryCountDownView.hLp)));
                frsLotteryCountDownView.hLw.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hLo) % FrsLotteryCountDownView.hLp) / FrsLotteryCountDownView.hLq)));
                frsLotteryCountDownView.hLy.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hLo) % FrsLotteryCountDownView.hLp) % FrsLotteryCountDownView.hLq) / FrsLotteryCountDownView.hLr)));
                return;
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hLA.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hLy.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hLA;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hLA = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hLA.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
