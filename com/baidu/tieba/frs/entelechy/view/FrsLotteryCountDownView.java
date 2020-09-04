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
    private static final long ifE = TimeUnit.DAYS.toMillis(1);
    private static final long ifF = TimeUnit.HOURS.toMillis(1);
    private static final long ifG = TimeUnit.MINUTES.toMillis(1);
    private static final long ifH = TimeUnit.SECONDS.toMillis(1);
    private TextView ifI;
    private TextView ifJ;
    private TextView ifK;
    private TextView ifL;
    private TextView ifM;
    private TextView ifN;
    private TextView ifO;
    private TextView ifP;
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
        this.ifI = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.ifJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.ifK = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.ifL = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.ifM = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.ifN = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.ifO = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.ifP = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.ifI, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifJ, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifI, R.color.common_color_10060);
        ap.setViewTextColor(this.ifK, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifL, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifK, R.color.common_color_10060);
        ap.setViewTextColor(this.ifM, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifN, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifM, R.color.common_color_10060);
        ap.setViewTextColor(this.ifO, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ifP, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.ifO, R.color.common_color_10060);
        if (j <= ifH) {
            this.ifI.setText("0");
            this.ifK.setText("0");
            this.ifM.setText("0");
            this.ifO.setText("0");
            return;
        }
        if (j / ifE <= 0) {
            this.ifI.setVisibility(8);
            this.ifJ.setVisibility(8);
        } else {
            this.ifI.setVisibility(0);
            this.ifJ.setVisibility(0);
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
                frsLotteryCountDownView.ifI.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.ifE)));
                frsLotteryCountDownView.ifK.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.ifE) / FrsLotteryCountDownView.ifF)));
                frsLotteryCountDownView.ifM.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.ifE) % FrsLotteryCountDownView.ifF) / FrsLotteryCountDownView.ifG)));
                frsLotteryCountDownView.ifO.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.ifE) % FrsLotteryCountDownView.ifF) % FrsLotteryCountDownView.ifG) / FrsLotteryCountDownView.ifH)));
                return;
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.ifO.setText("0");
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
