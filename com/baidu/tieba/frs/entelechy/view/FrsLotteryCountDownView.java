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
    private static final long dfm = TimeUnit.MINUTES.toMillis(1);
    private static final long dfn = TimeUnit.SECONDS.toMillis(1);
    private TextView dfo;
    private TextView dfp;
    private TextView dfq;
    private TextView dfr;
    private TextView dfs;
    private TextView dft;
    private TextView dfu;
    private TextView dfv;
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
        this.dfo = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dfp = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dfq = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dfr = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dfs = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dft = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dfu = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dfv = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        ak.h(this.dfo, d.C0126d.cp_cont_g);
        ak.h(this.dfp, d.C0126d.cp_cont_c);
        ak.j(this.dfo, d.C0126d.common_color_10060);
        ak.h(this.dfq, d.C0126d.cp_cont_g);
        ak.h(this.dfr, d.C0126d.cp_cont_c);
        ak.j(this.dfq, d.C0126d.common_color_10060);
        ak.h(this.dfs, d.C0126d.cp_cont_g);
        ak.h(this.dft, d.C0126d.cp_cont_c);
        ak.j(this.dfs, d.C0126d.common_color_10060);
        ak.h(this.dfu, d.C0126d.cp_cont_g);
        ak.h(this.dfv, d.C0126d.cp_cont_c);
        ak.j(this.dfu, d.C0126d.common_color_10060);
        if (j <= dfn) {
            this.dfo.setText("0");
            this.dfq.setText("0");
            this.dfs.setText("0");
            this.dfu.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dfo.setVisibility(8);
            this.dfp.setVisibility(8);
        } else {
            this.dfo.setVisibility(0);
            this.dfp.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dfw;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dfw = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dfw.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dfo.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dfq.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dfs.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dfm)));
                frsLotteryCountDownView.dfu.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dfm) / FrsLotteryCountDownView.dfn)));
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dfw.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dfu.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dfw;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dfw = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dfw.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
