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
import com.baidu.tieba.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private TextView dvB;
    private TextView dvC;
    private TextView dvD;
    private TextView dvE;
    private TextView dvF;
    private TextView dvG;
    private TextView dvH;
    private TextView dvI;
    private Context mContext;
    private View mRootView;
    private CountDownTimer mTimer;
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dvz = TimeUnit.MINUTES.toMillis(1);
    private static final long dvA = TimeUnit.SECONDS.toMillis(1);

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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.dvB = (TextView) this.mRootView.findViewById(f.g.lottery_count_day);
        this.dvC = (TextView) this.mRootView.findViewById(f.g.lottery_count_day_txt);
        this.dvD = (TextView) this.mRootView.findViewById(f.g.lottery_count_hour);
        this.dvE = (TextView) this.mRootView.findViewById(f.g.lottery_count_hour_txt);
        this.dvF = (TextView) this.mRootView.findViewById(f.g.lottery_count_minute);
        this.dvG = (TextView) this.mRootView.findViewById(f.g.lottery_count_minute_txt);
        this.dvH = (TextView) this.mRootView.findViewById(f.g.lottery_count_second);
        this.dvI = (TextView) this.mRootView.findViewById(f.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.h(this.dvB, f.d.cp_cont_g);
        am.h(this.dvC, f.d.cp_cont_c);
        am.j(this.dvB, f.d.common_color_10060);
        am.h(this.dvD, f.d.cp_cont_g);
        am.h(this.dvE, f.d.cp_cont_c);
        am.j(this.dvD, f.d.common_color_10060);
        am.h(this.dvF, f.d.cp_cont_g);
        am.h(this.dvG, f.d.cp_cont_c);
        am.j(this.dvF, f.d.common_color_10060);
        am.h(this.dvH, f.d.cp_cont_g);
        am.h(this.dvI, f.d.cp_cont_c);
        am.j(this.dvH, f.d.common_color_10060);
        if (j <= dvA) {
            this.dvB.setText("0");
            this.dvD.setText("0");
            this.dvF.setText("0");
            this.dvH.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dvB.setVisibility(8);
            this.dvC.setVisibility(8);
        } else {
            this.dvB.setVisibility(0);
            this.dvC.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dvJ;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dvJ = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dvJ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dvB.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dvD.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dvF.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dvz)));
                frsLotteryCountDownView.dvH.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dvz) / FrsLotteryCountDownView.dvA)));
                return;
            }
            com.baidu.adp.lib.g.e.in().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dvJ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dvH.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dvJ;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dvJ = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dvJ.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
