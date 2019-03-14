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
    private static final long fiU = TimeUnit.MINUTES.toMillis(1);
    private static final long fiV = TimeUnit.SECONDS.toMillis(1);
    private TextView fiW;
    private TextView fiX;
    private TextView fiY;
    private TextView fiZ;
    private TextView fja;
    private TextView fjb;
    private TextView fjc;
    private TextView fjd;
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
        this.fiW = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.fiX = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.fiY = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.fiZ = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.fja = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.fjb = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.fjc = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.fjd = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.j(this.fiW, d.C0277d.cp_cont_g);
        al.j(this.fiX, d.C0277d.cp_cont_c);
        al.l(this.fiW, d.C0277d.common_color_10060);
        al.j(this.fiY, d.C0277d.cp_cont_g);
        al.j(this.fiZ, d.C0277d.cp_cont_c);
        al.l(this.fiY, d.C0277d.common_color_10060);
        al.j(this.fja, d.C0277d.cp_cont_g);
        al.j(this.fjb, d.C0277d.cp_cont_c);
        al.l(this.fja, d.C0277d.common_color_10060);
        al.j(this.fjc, d.C0277d.cp_cont_g);
        al.j(this.fjd, d.C0277d.cp_cont_c);
        al.l(this.fjc, d.C0277d.common_color_10060);
        if (j <= fiV) {
            this.fiW.setText("0");
            this.fiY.setText("0");
            this.fja.setText("0");
            this.fjc.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.fiW.setVisibility(8);
            this.fiX.setVisibility(8);
        } else {
            this.fiW.setVisibility(0);
            this.fiX.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fje;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fje = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fje.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fiW.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.fiY.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.fja.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.fiU)));
                frsLotteryCountDownView.fjc.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.fiU) / FrsLotteryCountDownView.fiV)));
                return;
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fje.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fjc.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fje;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fje = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fje.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
