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
    private static final long fFb = TimeUnit.DAYS.toMillis(1);
    private static final long fFc = TimeUnit.HOURS.toMillis(1);
    private static final long fFd = TimeUnit.MINUTES.toMillis(1);
    private static final long fFe = TimeUnit.SECONDS.toMillis(1);
    private TextView fFf;
    private TextView fFg;
    private TextView fFh;
    private TextView fFi;
    private TextView fFj;
    private TextView fFk;
    private TextView fFl;
    private TextView fFm;
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
        this.fFf = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fFg = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fFh = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fFi = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fFj = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fFk = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fFl = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fFm = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.fFf, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFg, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFf, R.color.common_color_10060);
        am.setViewTextColor(this.fFh, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFi, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFh, R.color.common_color_10060);
        am.setViewTextColor(this.fFj, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFk, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFj, R.color.common_color_10060);
        am.setViewTextColor(this.fFl, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fFm, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.fFl, R.color.common_color_10060);
        if (j <= fFe) {
            this.fFf.setText("0");
            this.fFh.setText("0");
            this.fFj.setText("0");
            this.fFl.setText("0");
            return;
        }
        if (j / fFb <= 0) {
            this.fFf.setVisibility(8);
            this.fFg.setVisibility(8);
        } else {
            this.fFf.setVisibility(0);
            this.fFg.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
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
                frsLotteryCountDownView.fFf.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.fFb)));
                frsLotteryCountDownView.fFh.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.fFb) / FrsLotteryCountDownView.fFc)));
                frsLotteryCountDownView.fFj.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.fFb) % FrsLotteryCountDownView.fFc) / FrsLotteryCountDownView.fFd)));
                frsLotteryCountDownView.fFl.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.fFb) % FrsLotteryCountDownView.fFc) % FrsLotteryCountDownView.fFd) / FrsLotteryCountDownView.fFe)));
                return;
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fFl.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
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
