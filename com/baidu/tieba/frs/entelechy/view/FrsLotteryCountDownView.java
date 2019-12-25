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
/* loaded from: classes6.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long gtu = TimeUnit.DAYS.toMillis(1);
    private static final long gtv = TimeUnit.HOURS.toMillis(1);
    private static final long gtw = TimeUnit.MINUTES.toMillis(1);
    private static final long gtx = TimeUnit.SECONDS.toMillis(1);
    private TextView gtA;
    private TextView gtB;
    private TextView gtC;
    private TextView gtD;
    private TextView gtE;
    private TextView gtF;
    private TextView gty;
    private TextView gtz;
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
        this.gty = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.gtz = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.gtA = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.gtB = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.gtC = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.gtD = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.gtE = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.gtF = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.gty, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gtz, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gty, R.color.common_color_10060);
        am.setViewTextColor(this.gtA, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gtB, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gtA, R.color.common_color_10060);
        am.setViewTextColor(this.gtC, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gtD, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gtC, R.color.common_color_10060);
        am.setViewTextColor(this.gtE, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gtF, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.gtE, R.color.common_color_10060);
        if (j <= gtx) {
            this.gty.setText("0");
            this.gtA.setText("0");
            this.gtC.setText("0");
            this.gtE.setText("0");
            return;
        }
        if (j / gtu <= 0) {
            this.gty.setVisibility(8);
            this.gtz.setVisibility(8);
        } else {
            this.gty.setVisibility(0);
            this.gtz.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes6.dex */
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
                frsLotteryCountDownView.gty.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.gtu)));
                frsLotteryCountDownView.gtA.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.gtu) / FrsLotteryCountDownView.gtv)));
                frsLotteryCountDownView.gtC.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.gtu) % FrsLotteryCountDownView.gtv) / FrsLotteryCountDownView.gtw)));
                frsLotteryCountDownView.gtE.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.gtu) % FrsLotteryCountDownView.gtv) % FrsLotteryCountDownView.gtw) / FrsLotteryCountDownView.gtx)));
                return;
            }
            com.baidu.adp.lib.f.e.gy().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.gtE.setText("0");
            }
        }
    }

    /* loaded from: classes6.dex */
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
