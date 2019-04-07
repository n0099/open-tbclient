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
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long fiG = TimeUnit.MINUTES.toMillis(1);
    private static final long fiH = TimeUnit.SECONDS.toMillis(1);
    private TextView fiI;
    private TextView fiJ;
    private TextView fiK;
    private TextView fiL;
    private TextView fiM;
    private TextView fiN;
    private TextView fiO;
    private TextView fiP;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.fiI = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.fiJ = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.fiK = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.fiL = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.fiM = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.fiN = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.fiO = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.fiP = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.j(this.fiI, d.C0277d.cp_cont_g);
        al.j(this.fiJ, d.C0277d.cp_cont_c);
        al.l(this.fiI, d.C0277d.common_color_10060);
        al.j(this.fiK, d.C0277d.cp_cont_g);
        al.j(this.fiL, d.C0277d.cp_cont_c);
        al.l(this.fiK, d.C0277d.common_color_10060);
        al.j(this.fiM, d.C0277d.cp_cont_g);
        al.j(this.fiN, d.C0277d.cp_cont_c);
        al.l(this.fiM, d.C0277d.common_color_10060);
        al.j(this.fiO, d.C0277d.cp_cont_g);
        al.j(this.fiP, d.C0277d.cp_cont_c);
        al.l(this.fiO, d.C0277d.common_color_10060);
        if (j <= fiH) {
            this.fiI.setText("0");
            this.fiK.setText("0");
            this.fiM.setText("0");
            this.fiO.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.fiI.setVisibility(8);
            this.fiJ.setVisibility(8);
        } else {
            this.fiI.setVisibility(0);
            this.fiJ.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fiQ;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fiQ = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fiQ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fiI.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.fiK.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.fiM.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.fiG)));
                frsLotteryCountDownView.fiO.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.fiG) / FrsLotteryCountDownView.fiH)));
                return;
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fiQ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fiO.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fiQ;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fiQ = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fiQ.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
