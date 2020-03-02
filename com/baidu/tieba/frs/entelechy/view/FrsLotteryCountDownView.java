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
    private static final long gyG = TimeUnit.DAYS.toMillis(1);
    private static final long gyH = TimeUnit.HOURS.toMillis(1);
    private static final long gyI = TimeUnit.MINUTES.toMillis(1);
    private static final long gyJ = TimeUnit.SECONDS.toMillis(1);
    private TextView gyK;
    private TextView gyL;
    private TextView gyM;
    private TextView gyN;
    private TextView gyO;
    private TextView gyP;
    private TextView gyQ;
    private TextView gyR;
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
        this.gyK = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gyL = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gyM = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gyN = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gyO = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gyP = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gyQ = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gyR = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gyK, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyL, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyK, R.color.common_color_10060);
        am.setViewTextColor(this.gyM, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyN, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyM, R.color.common_color_10060);
        am.setViewTextColor(this.gyO, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyP, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyO, R.color.common_color_10060);
        am.setViewTextColor(this.gyQ, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gyR, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gyQ, R.color.common_color_10060);
        if (j <= gyJ) {
            this.gyK.setText("0");
            this.gyM.setText("0");
            this.gyO.setText("0");
            this.gyQ.setText("0");
            return;
        }
        if (j / gyG <= 0) {
            this.gyK.setVisibility(8);
            this.gyL.setVisibility(8);
        } else {
            this.gyK.setVisibility(0);
            this.gyL.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> gyS;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.gyS = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gyS.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gyK.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gyG)));
                frsLotteryCountDownView.gyM.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gyG) / FrsLotteryCountDownView.gyH)));
                frsLotteryCountDownView.gyO.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gyG) % FrsLotteryCountDownView.gyH) / FrsLotteryCountDownView.gyI)));
                frsLotteryCountDownView.gyQ.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gyG) % FrsLotteryCountDownView.gyH) % FrsLotteryCountDownView.gyI) / FrsLotteryCountDownView.gyJ)));
                return;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gyS.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gyQ.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> gyS;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.gyS = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.gyS.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
