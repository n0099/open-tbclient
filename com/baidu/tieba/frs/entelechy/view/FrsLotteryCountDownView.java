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
/* loaded from: classes7.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long gwD = TimeUnit.DAYS.toMillis(1);
    private static final long gwE = TimeUnit.HOURS.toMillis(1);
    private static final long gwF = TimeUnit.MINUTES.toMillis(1);
    private static final long gwG = TimeUnit.SECONDS.toMillis(1);
    private TextView gwH;
    private TextView gwI;
    private TextView gwJ;
    private TextView gwK;
    private TextView gwL;
    private TextView gwM;
    private TextView gwN;
    private TextView gwO;
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
        this.gwH = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gwI = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gwJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gwK = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gwL = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gwM = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gwN = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gwO = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gwH, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gwI, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gwH, R.color.common_color_10060);
        am.setViewTextColor(this.gwJ, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gwK, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gwJ, R.color.common_color_10060);
        am.setViewTextColor(this.gwL, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gwM, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gwL, R.color.common_color_10060);
        am.setViewTextColor(this.gwN, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gwO, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gwN, R.color.common_color_10060);
        if (j <= gwG) {
            this.gwH.setText("0");
            this.gwJ.setText("0");
            this.gwL.setText("0");
            this.gwN.setText("0");
            return;
        }
        if (j / gwD <= 0) {
            this.gwH.setVisibility(8);
            this.gwI.setVisibility(8);
        } else {
            this.gwH.setVisibility(0);
            this.gwI.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes7.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> gwP;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.gwP = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gwP.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gwH.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gwD)));
                frsLotteryCountDownView.gwJ.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gwD) / FrsLotteryCountDownView.gwE)));
                frsLotteryCountDownView.gwL.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gwD) % FrsLotteryCountDownView.gwE) / FrsLotteryCountDownView.gwF)));
                frsLotteryCountDownView.gwN.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gwD) % FrsLotteryCountDownView.gwE) % FrsLotteryCountDownView.gwF) / FrsLotteryCountDownView.gwG)));
                return;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.gwP.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gwN.setText("0");
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> gwP;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.gwP = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.gwP.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
