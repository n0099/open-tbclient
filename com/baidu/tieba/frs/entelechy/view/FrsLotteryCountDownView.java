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
    private static final long hyg = TimeUnit.DAYS.toMillis(1);
    private static final long hyh = TimeUnit.HOURS.toMillis(1);
    private static final long hyi = TimeUnit.MINUTES.toMillis(1);
    private static final long hyj = TimeUnit.SECONDS.toMillis(1);
    private TextView hyk;
    private TextView hyl;
    private TextView hym;
    private TextView hyn;
    private TextView hyo;
    private TextView hyp;
    private TextView hyq;
    private TextView hyr;
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
        this.hyk = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.hyl = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.hym = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.hyn = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.hyo = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.hyp = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.hyq = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.hyr = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.setViewTextColor(this.hyk, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyl, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyk, R.color.common_color_10060);
        am.setViewTextColor(this.hym, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyn, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hym, R.color.common_color_10060);
        am.setViewTextColor(this.hyo, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyp, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyo, R.color.common_color_10060);
        am.setViewTextColor(this.hyq, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hyr, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.hyq, R.color.common_color_10060);
        if (j <= hyj) {
            this.hyk.setText("0");
            this.hym.setText("0");
            this.hyo.setText("0");
            this.hyq.setText("0");
            return;
        }
        if (j / hyg <= 0) {
            this.hyk.setVisibility(8);
            this.hyl.setVisibility(8);
        } else {
            this.hyk.setVisibility(0);
            this.hyl.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes9.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> hys;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.hys = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hys.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hyk.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.hyg)));
                frsLotteryCountDownView.hym.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.hyg) / FrsLotteryCountDownView.hyh)));
                frsLotteryCountDownView.hyo.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.hyg) % FrsLotteryCountDownView.hyh) / FrsLotteryCountDownView.hyi)));
                frsLotteryCountDownView.hyq.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.hyg) % FrsLotteryCountDownView.hyh) % FrsLotteryCountDownView.hyi) / FrsLotteryCountDownView.hyj)));
                return;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.hys.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.hyq.setText("0");
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> hys;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.hys = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.hys.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
