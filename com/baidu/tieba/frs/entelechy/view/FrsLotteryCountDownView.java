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
/* loaded from: classes21.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long imF = TimeUnit.DAYS.toMillis(1);
    private static final long imG = TimeUnit.HOURS.toMillis(1);
    private static final long imH = TimeUnit.MINUTES.toMillis(1);
    private static final long imI = TimeUnit.SECONDS.toMillis(1);
    private TextView imJ;
    private TextView imK;
    private TextView imL;
    private TextView imM;
    private TextView imN;
    private TextView imO;
    private TextView imP;
    private TextView imQ;
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
        this.imJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.imK = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.imL = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.imM = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.imN = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.imO = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.imP = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.imQ = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.imJ, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.imK, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.imJ, R.color.common_color_10060);
        ap.setViewTextColor(this.imL, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.imM, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.imL, R.color.common_color_10060);
        ap.setViewTextColor(this.imN, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.imO, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.imN, R.color.common_color_10060);
        ap.setViewTextColor(this.imP, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.imQ, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.imP, R.color.common_color_10060);
        if (j <= imI) {
            this.imJ.setText("0");
            this.imL.setText("0");
            this.imN.setText("0");
            this.imP.setText("0");
            return;
        }
        if (j / imF <= 0) {
            this.imJ.setVisibility(8);
            this.imK.setVisibility(8);
        } else {
            this.imJ.setVisibility(0);
            this.imK.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes21.dex */
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
                frsLotteryCountDownView.imJ.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.imF)));
                frsLotteryCountDownView.imL.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.imF) / FrsLotteryCountDownView.imG)));
                frsLotteryCountDownView.imN.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.imF) % FrsLotteryCountDownView.imG) / FrsLotteryCountDownView.imH)));
                frsLotteryCountDownView.imP.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.imF) % FrsLotteryCountDownView.imG) % FrsLotteryCountDownView.imH) / FrsLotteryCountDownView.imI)));
                return;
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.imP.setText("0");
            }
        }
    }

    /* loaded from: classes21.dex */
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
