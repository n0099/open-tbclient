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
/* loaded from: classes9.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long gyE = TimeUnit.DAYS.toMillis(1);
    private static final long gyF = TimeUnit.HOURS.toMillis(1);
    private static final long gyG = TimeUnit.MINUTES.toMillis(1);
    private static final long gyH = TimeUnit.SECONDS.toMillis(1);
    private TextView gyI;
    private TextView gyJ;
    private TextView gyK;
    private TextView gyL;
    private TextView gyM;
    private TextView gyN;
    private TextView gyO;
    private TextView gyP;
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
        this.gyI = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gyJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gyK = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gyL = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gyM = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gyN = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gyO = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gyP = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gyI, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyJ, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyI, R.color.common_color_10060);
        am.setViewTextColor(this.gyK, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyL, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyK, R.color.common_color_10060);
        am.setViewTextColor(this.gyM, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyN, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyM, R.color.common_color_10060);
        am.setViewTextColor(this.gyO, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyP, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyO, R.color.common_color_10060);
        if (j <= gyH) {
            this.gyI.setText("0");
            this.gyK.setText("0");
            this.gyM.setText("0");
            this.gyO.setText("0");
            return;
        }
        if (j / gyE <= 0) {
            this.gyI.setVisibility(8);
            this.gyJ.setVisibility(8);
        } else {
            this.gyI.setVisibility(0);
            this.gyJ.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> gyQ;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.gyQ = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gyQ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gyI.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gyE)));
                frsLotteryCountDownView.gyK.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gyE) / FrsLotteryCountDownView.gyF)));
                frsLotteryCountDownView.gyM.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gyE) % FrsLotteryCountDownView.gyF) / FrsLotteryCountDownView.gyG)));
                frsLotteryCountDownView.gyO.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gyE) % FrsLotteryCountDownView.gyF) % FrsLotteryCountDownView.gyG) / FrsLotteryCountDownView.gyH)));
                return;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gyQ.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gyO.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> gyQ;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.gyQ = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.gyQ.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
