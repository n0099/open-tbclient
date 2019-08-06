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
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long fEM = TimeUnit.DAYS.toMillis(1);
    private static final long fEN = TimeUnit.HOURS.toMillis(1);
    private static final long fEO = TimeUnit.MINUTES.toMillis(1);
    private static final long fEP = TimeUnit.SECONDS.toMillis(1);
    private TextView fEQ;
    private TextView fER;
    private TextView fES;
    private TextView fET;
    private TextView fEU;
    private TextView fEV;
    private TextView fEW;
    private TextView fEX;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.frs_lottery_count_down, (ViewGroup) this, true);
        this.fEQ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fER = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fES = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fET = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fEU = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fEV = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fEW = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fEX = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.j(this.fEQ, R.color.cp_cont_g);
        am.j(this.fER, R.color.cp_cont_c);
        am.l(this.fEQ, R.color.common_color_10060);
        am.j(this.fES, R.color.cp_cont_g);
        am.j(this.fET, R.color.cp_cont_c);
        am.l(this.fES, R.color.common_color_10060);
        am.j(this.fEU, R.color.cp_cont_g);
        am.j(this.fEV, R.color.cp_cont_c);
        am.l(this.fEU, R.color.common_color_10060);
        am.j(this.fEW, R.color.cp_cont_g);
        am.j(this.fEX, R.color.cp_cont_c);
        am.l(this.fEW, R.color.common_color_10060);
        if (j <= fEP) {
            this.fEQ.setText("0");
            this.fES.setText("0");
            this.fEU.setText("0");
            this.fEW.setText("0");
            return;
        }
        if (j / fEM <= 0) {
            this.fEQ.setVisibility(8);
            this.fER.setVisibility(8);
        } else {
            this.fEQ.setVisibility(0);
            this.fER.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fEY;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fEY = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fEY.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fEQ.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.fEM)));
                frsLotteryCountDownView.fES.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.fEM) / FrsLotteryCountDownView.fEN)));
                frsLotteryCountDownView.fEU.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.fEM) % FrsLotteryCountDownView.fEN) / FrsLotteryCountDownView.fEO)));
                frsLotteryCountDownView.fEW.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.fEM) % FrsLotteryCountDownView.fEN) % FrsLotteryCountDownView.fEO) / FrsLotteryCountDownView.fEP)));
                return;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fEY.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fEW.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fEY;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fEY = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fEY.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
