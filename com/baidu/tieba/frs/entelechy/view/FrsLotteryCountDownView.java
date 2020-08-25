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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private TextView ifC;
    private TextView ifD;
    private TextView ifE;
    private TextView ifF;
    private TextView ifG;
    private TextView ifH;
    private TextView ifI;
    private TextView ifJ;
    private Context mContext;
    private View mRootView;
    private CountDownTimer mTimer;
    private static final long ify = TimeUnit.DAYS.toMillis(1);
    private static final long ifz = TimeUnit.HOURS.toMillis(1);
    private static final long ifA = TimeUnit.MINUTES.toMillis(1);
    private static final long ifB = TimeUnit.SECONDS.toMillis(1);

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
        this.ifC = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.ifD = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.ifE = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.ifF = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.ifG = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.ifH = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.ifI = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.ifJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.ifC, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifD, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifC, R.color.common_color_10060);
        ap.setViewTextColor(this.ifE, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifF, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifE, R.color.common_color_10060);
        ap.setViewTextColor(this.ifG, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifH, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifG, R.color.common_color_10060);
        ap.setViewTextColor(this.ifI, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifJ, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifI, R.color.common_color_10060);
        if (j <= ifB) {
            this.ifC.setText("0");
            this.ifE.setText("0");
            this.ifG.setText("0");
            this.ifI.setText("0");
            return;
        }
        if (j / ify <= 0) {
            this.ifC.setVisibility(8);
            this.ifD.setVisibility(8);
        } else {
            this.ifC.setVisibility(0);
            this.ifD.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes16.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> reference;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.reference = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.ifC.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.ify)));
                frsLotteryCountDownView.ifE.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.ify) / FrsLotteryCountDownView.ifz)));
                frsLotteryCountDownView.ifG.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.ify) % FrsLotteryCountDownView.ifz) / FrsLotteryCountDownView.ifA)));
                frsLotteryCountDownView.ifI.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.ify) % FrsLotteryCountDownView.ifz) % FrsLotteryCountDownView.ifA) / FrsLotteryCountDownView.ifB)));
                return;
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.ifI.setText("0");
            }
        }
    }

    /* loaded from: classes16.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> reference;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.reference = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.reference.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
