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
    private static final long hyr = TimeUnit.DAYS.toMillis(1);
    private static final long hys = TimeUnit.HOURS.toMillis(1);
    private static final long hyt = TimeUnit.MINUTES.toMillis(1);
    private static final long hyu = TimeUnit.SECONDS.toMillis(1);
    private TextView hyA;
    private TextView hyB;
    private TextView hyC;
    private TextView hyv;
    private TextView hyw;
    private TextView hyx;
    private TextView hyy;
    private TextView hyz;
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
        this.hyv = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hyw = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hyx = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hyy = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hyz = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hyA = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hyB = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hyC = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.hyv, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyw, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyv, R.color.common_color_10060);
        am.setViewTextColor(this.hyx, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyy, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyx, R.color.common_color_10060);
        am.setViewTextColor(this.hyz, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyA, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyz, R.color.common_color_10060);
        am.setViewTextColor(this.hyB, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyC, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyB, R.color.common_color_10060);
        if (j <= hyu) {
            this.hyv.setText("0");
            this.hyx.setText("0");
            this.hyz.setText("0");
            this.hyB.setText("0");
            return;
        }
        if (j / hyr <= 0) {
            this.hyv.setVisibility(8);
            this.hyw.setVisibility(8);
        } else {
            this.hyv.setVisibility(0);
            this.hyw.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hyD;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hyD = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hyD.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hyv.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hyr)));
                frsLotteryCountDownView.hyx.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hyr) / FrsLotteryCountDownView.hys)));
                frsLotteryCountDownView.hyz.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hyr) % FrsLotteryCountDownView.hys) / FrsLotteryCountDownView.hyt)));
                frsLotteryCountDownView.hyB.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hyr) % FrsLotteryCountDownView.hys) % FrsLotteryCountDownView.hyt) / FrsLotteryCountDownView.hyu)));
                return;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hyD.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hyB.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hyD;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hyD = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hyD.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
