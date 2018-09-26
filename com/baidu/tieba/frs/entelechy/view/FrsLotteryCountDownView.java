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
    private static final long dCj = TimeUnit.MINUTES.toMillis(1);
    private static final long dCk = TimeUnit.SECONDS.toMillis(1);
    private TextView dCl;
    private TextView dCm;
    private TextView dCn;
    private TextView dCo;
    private TextView dCp;
    private TextView dCq;
    private TextView dCr;
    private TextView dCs;
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
        this.dCl = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dCm = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dCn = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dCo = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dCp = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dCq = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dCr = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dCs = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dCl, e.d.cp_cont_g);
        al.h(this.dCm, e.d.cp_cont_c);
        al.j(this.dCl, e.d.common_color_10060);
        al.h(this.dCn, e.d.cp_cont_g);
        al.h(this.dCo, e.d.cp_cont_c);
        al.j(this.dCn, e.d.common_color_10060);
        al.h(this.dCp, e.d.cp_cont_g);
        al.h(this.dCq, e.d.cp_cont_c);
        al.j(this.dCp, e.d.common_color_10060);
        al.h(this.dCr, e.d.cp_cont_g);
        al.h(this.dCs, e.d.cp_cont_c);
        al.j(this.dCr, e.d.common_color_10060);
        if (j <= dCk) {
            this.dCl.setText("0");
            this.dCn.setText("0");
            this.dCp.setText("0");
            this.dCr.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dCl.setVisibility(8);
            this.dCm.setVisibility(8);
        } else {
            this.dCl.setVisibility(0);
            this.dCm.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dCt;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dCt = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dCt.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dCl.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dCn.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dCp.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dCj)));
                frsLotteryCountDownView.dCr.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dCj) / FrsLotteryCountDownView.dCk)));
                return;
            }
            com.baidu.adp.lib.g.e.jt().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dCt.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dCr.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dCt;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dCt = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dCt.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
