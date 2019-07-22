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
    private static final long fDY = TimeUnit.DAYS.toMillis(1);
    private static final long fDZ = TimeUnit.HOURS.toMillis(1);
    private static final long fEa = TimeUnit.MINUTES.toMillis(1);
    private static final long fEb = TimeUnit.SECONDS.toMillis(1);
    private TextView fEc;
    private TextView fEd;
    private TextView fEe;
    private TextView fEf;
    private TextView fEg;
    private TextView fEh;
    private TextView fEi;
    private TextView fEj;
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
        this.fEc = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fEd = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fEe = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fEf = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fEg = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fEh = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fEi = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fEj = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.j(this.fEc, R.color.cp_cont_g);
        am.j(this.fEd, R.color.cp_cont_c);
        am.l(this.fEc, R.color.common_color_10060);
        am.j(this.fEe, R.color.cp_cont_g);
        am.j(this.fEf, R.color.cp_cont_c);
        am.l(this.fEe, R.color.common_color_10060);
        am.j(this.fEg, R.color.cp_cont_g);
        am.j(this.fEh, R.color.cp_cont_c);
        am.l(this.fEg, R.color.common_color_10060);
        am.j(this.fEi, R.color.cp_cont_g);
        am.j(this.fEj, R.color.cp_cont_c);
        am.l(this.fEi, R.color.common_color_10060);
        if (j <= fEb) {
            this.fEc.setText("0");
            this.fEe.setText("0");
            this.fEg.setText("0");
            this.fEi.setText("0");
            return;
        }
        if (j / fDY <= 0) {
            this.fEc.setVisibility(8);
            this.fEd.setVisibility(8);
        } else {
            this.fEc.setVisibility(0);
            this.fEd.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fEk;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fEk = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fEk.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fEc.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.fDY)));
                frsLotteryCountDownView.fEe.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.fDY) / FrsLotteryCountDownView.fDZ)));
                frsLotteryCountDownView.fEg.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.fDY) % FrsLotteryCountDownView.fDZ) / FrsLotteryCountDownView.fEa)));
                frsLotteryCountDownView.fEi.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.fDY) % FrsLotteryCountDownView.fDZ) % FrsLotteryCountDownView.fEa) / FrsLotteryCountDownView.fEb)));
                return;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fEk.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fEi.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fEk;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fEk = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fEk.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
