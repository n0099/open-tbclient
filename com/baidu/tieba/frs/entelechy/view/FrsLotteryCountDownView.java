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
    private static final long dLn = TimeUnit.MINUTES.toMillis(1);
    private static final long dLo = TimeUnit.SECONDS.toMillis(1);
    private TextView dLp;
    private TextView dLq;
    private TextView dLr;
    private TextView dLs;
    private TextView dLt;
    private TextView dLu;
    private TextView dLv;
    private TextView dLw;
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
        this.dLp = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dLq = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dLr = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dLs = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dLt = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dLu = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dLv = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dLw = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dLp, e.d.cp_cont_g);
        al.h(this.dLq, e.d.cp_cont_c);
        al.j(this.dLp, e.d.common_color_10060);
        al.h(this.dLr, e.d.cp_cont_g);
        al.h(this.dLs, e.d.cp_cont_c);
        al.j(this.dLr, e.d.common_color_10060);
        al.h(this.dLt, e.d.cp_cont_g);
        al.h(this.dLu, e.d.cp_cont_c);
        al.j(this.dLt, e.d.common_color_10060);
        al.h(this.dLv, e.d.cp_cont_g);
        al.h(this.dLw, e.d.cp_cont_c);
        al.j(this.dLv, e.d.common_color_10060);
        if (j <= dLo) {
            this.dLp.setText("0");
            this.dLr.setText("0");
            this.dLt.setText("0");
            this.dLv.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dLp.setVisibility(8);
            this.dLq.setVisibility(8);
        } else {
            this.dLp.setVisibility(0);
            this.dLq.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dLx;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dLx = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dLx.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dLp.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dLr.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dLt.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dLn)));
                frsLotteryCountDownView.dLv.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dLn) / FrsLotteryCountDownView.dLo)));
                return;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dLx.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dLv.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dLx;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dLx = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dLx.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
