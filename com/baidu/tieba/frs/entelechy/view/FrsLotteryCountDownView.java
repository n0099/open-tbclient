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
    private static final long dRQ = TimeUnit.MINUTES.toMillis(1);
    private static final long dRR = TimeUnit.SECONDS.toMillis(1);
    private TextView dRS;
    private TextView dRT;
    private TextView dRU;
    private TextView dRV;
    private TextView dRW;
    private TextView dRX;
    private TextView dRY;
    private TextView dRZ;
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
        this.dRS = (TextView) this.mRootView.findViewById(e.g.lottery_count_day);
        this.dRT = (TextView) this.mRootView.findViewById(e.g.lottery_count_day_txt);
        this.dRU = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour);
        this.dRV = (TextView) this.mRootView.findViewById(e.g.lottery_count_hour_txt);
        this.dRW = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute);
        this.dRX = (TextView) this.mRootView.findViewById(e.g.lottery_count_minute_txt);
        this.dRY = (TextView) this.mRootView.findViewById(e.g.lottery_count_second);
        this.dRZ = (TextView) this.mRootView.findViewById(e.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dRS, e.d.cp_cont_g);
        al.h(this.dRT, e.d.cp_cont_c);
        al.j(this.dRS, e.d.common_color_10060);
        al.h(this.dRU, e.d.cp_cont_g);
        al.h(this.dRV, e.d.cp_cont_c);
        al.j(this.dRU, e.d.common_color_10060);
        al.h(this.dRW, e.d.cp_cont_g);
        al.h(this.dRX, e.d.cp_cont_c);
        al.j(this.dRW, e.d.common_color_10060);
        al.h(this.dRY, e.d.cp_cont_g);
        al.h(this.dRZ, e.d.cp_cont_c);
        al.j(this.dRY, e.d.common_color_10060);
        if (j <= dRR) {
            this.dRS.setText("0");
            this.dRU.setText("0");
            this.dRW.setText("0");
            this.dRY.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dRS.setVisibility(8);
            this.dRT.setVisibility(8);
        } else {
            this.dRS.setVisibility(0);
            this.dRT.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dSa;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dSa = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dSa.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dRS.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dRU.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dRW.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dRQ)));
                frsLotteryCountDownView.dRY.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dRQ) / FrsLotteryCountDownView.dRR)));
                return;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dSa.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dRY.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dSa;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dSa = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dSa.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
