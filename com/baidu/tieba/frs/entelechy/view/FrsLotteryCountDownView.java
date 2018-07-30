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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dvC = TimeUnit.MINUTES.toMillis(1);
    private static final long dvD = TimeUnit.SECONDS.toMillis(1);
    private TextView dvE;
    private TextView dvF;
    private TextView dvG;
    private TextView dvH;
    private TextView dvI;
    private TextView dvJ;
    private TextView dvK;
    private TextView dvL;
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
        this.dvE = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dvF = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dvG = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dvH = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dvI = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dvJ = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dvK = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dvL = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.h(this.dvE, d.C0140d.cp_cont_g);
        am.h(this.dvF, d.C0140d.cp_cont_c);
        am.j(this.dvE, d.C0140d.common_color_10060);
        am.h(this.dvG, d.C0140d.cp_cont_g);
        am.h(this.dvH, d.C0140d.cp_cont_c);
        am.j(this.dvG, d.C0140d.common_color_10060);
        am.h(this.dvI, d.C0140d.cp_cont_g);
        am.h(this.dvJ, d.C0140d.cp_cont_c);
        am.j(this.dvI, d.C0140d.common_color_10060);
        am.h(this.dvK, d.C0140d.cp_cont_g);
        am.h(this.dvL, d.C0140d.cp_cont_c);
        am.j(this.dvK, d.C0140d.common_color_10060);
        if (j <= dvD) {
            this.dvE.setText("0");
            this.dvG.setText("0");
            this.dvI.setText("0");
            this.dvK.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dvE.setVisibility(8);
            this.dvF.setVisibility(8);
        } else {
            this.dvE.setVisibility(0);
            this.dvF.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dvM;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dvM = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dvM.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dvE.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dvG.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dvI.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dvC)));
                frsLotteryCountDownView.dvK.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dvC) / FrsLotteryCountDownView.dvD)));
                return;
            }
            com.baidu.adp.lib.g.e.in().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dvM.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dvK.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dvM;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dvM = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dvM.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
