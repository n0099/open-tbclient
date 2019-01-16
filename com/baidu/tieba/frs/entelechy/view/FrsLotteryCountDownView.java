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
    private static final long dVn = TimeUnit.MINUTES.toMillis(1);
    private static final long dVo = TimeUnit.SECONDS.toMillis(1);
    private TextView dVp;
    private TextView dVq;
    private TextView dVr;
    private TextView dVs;
    private TextView dVt;
    private TextView dVu;
    private TextView dVv;
    private TextView dVw;
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
        this.dVp = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dVq = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dVr = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dVs = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dVt = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dVu = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dVv = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dVw = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dVp, e.d.cp_cont_g);
        al.h(this.dVq, e.d.cp_cont_c);
        al.j(this.dVp, e.d.common_color_10060);
        al.h(this.dVr, e.d.cp_cont_g);
        al.h(this.dVs, e.d.cp_cont_c);
        al.j(this.dVr, e.d.common_color_10060);
        al.h(this.dVt, e.d.cp_cont_g);
        al.h(this.dVu, e.d.cp_cont_c);
        al.j(this.dVt, e.d.common_color_10060);
        al.h(this.dVv, e.d.cp_cont_g);
        al.h(this.dVw, e.d.cp_cont_c);
        al.j(this.dVv, e.d.common_color_10060);
        if (j <= dVo) {
            this.dVp.setText("0");
            this.dVr.setText("0");
            this.dVt.setText("0");
            this.dVv.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dVp.setVisibility(8);
            this.dVq.setVisibility(8);
        } else {
            this.dVp.setVisibility(0);
            this.dVq.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dVx;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dVx = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dVx.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dVp.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dVr.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dVt.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dVn)));
                frsLotteryCountDownView.dVv.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dVn) / FrsLotteryCountDownView.dVo)));
                return;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dVx.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dVv.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dVx;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dVx = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dVx.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
