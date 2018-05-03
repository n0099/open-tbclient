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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dfj = TimeUnit.MINUTES.toMillis(1);
    private static final long dfk = TimeUnit.SECONDS.toMillis(1);
    private TextView dfl;
    private TextView dfm;
    private TextView dfn;
    private TextView dfo;
    private TextView dfp;
    private TextView dfq;
    private TextView dfr;
    private TextView dfs;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.frs_lottery_count_down, (ViewGroup) this, true);
        this.dfl = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dfm = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dfn = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dfo = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dfp = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dfq = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dfr = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dfs = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        ak.h(this.dfl, d.C0126d.cp_cont_g);
        ak.h(this.dfm, d.C0126d.cp_cont_c);
        ak.j(this.dfl, d.C0126d.common_color_10060);
        ak.h(this.dfn, d.C0126d.cp_cont_g);
        ak.h(this.dfo, d.C0126d.cp_cont_c);
        ak.j(this.dfn, d.C0126d.common_color_10060);
        ak.h(this.dfp, d.C0126d.cp_cont_g);
        ak.h(this.dfq, d.C0126d.cp_cont_c);
        ak.j(this.dfp, d.C0126d.common_color_10060);
        ak.h(this.dfr, d.C0126d.cp_cont_g);
        ak.h(this.dfs, d.C0126d.cp_cont_c);
        ak.j(this.dfr, d.C0126d.common_color_10060);
        if (j <= dfk) {
            this.dfl.setText("0");
            this.dfn.setText("0");
            this.dfp.setText("0");
            this.dfr.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dfl.setVisibility(8);
            this.dfm.setVisibility(8);
        } else {
            this.dfl.setVisibility(0);
            this.dfm.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dft;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dft = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dft.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dfl.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dfn.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dfp.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dfj)));
                frsLotteryCountDownView.dfr.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dfj) / FrsLotteryCountDownView.dfk)));
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dft.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dfr.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dft;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dft = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dft.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
