package com.baidu.tieba.frs;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long bjn = TimeUnit.MINUTES.toMillis(1);
    private static final long bjo = TimeUnit.SECONDS.toMillis(1);
    private TextView bjp;
    private TextView bjq;
    private TextView bjr;
    private TextView bjs;
    private TextView bjt;
    private TextView bju;
    private TextView bjv;
    private TextView bjw;
    private CountDownTimer bjx;
    private Context mContext;
    private View mRootView;

    public FrsLotteryCountDownView(Context context) {
        super(context);
        this.mContext = null;
        this.bjx = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bjx = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.bjx = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.bjp = (TextView) this.mRootView.findViewById(t.g.lottery_count_day);
        this.bjq = (TextView) this.mRootView.findViewById(t.g.lottery_count_day_txt);
        this.bjr = (TextView) this.mRootView.findViewById(t.g.lottery_count_hour);
        this.bjs = (TextView) this.mRootView.findViewById(t.g.lottery_count_hour_txt);
        this.bjt = (TextView) this.mRootView.findViewById(t.g.lottery_count_minute);
        this.bju = (TextView) this.mRootView.findViewById(t.g.lottery_count_minute_txt);
        this.bjv = (TextView) this.mRootView.findViewById(t.g.lottery_count_second);
        this.bjw = (TextView) this.mRootView.findViewById(t.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        com.baidu.tbadk.core.util.at.j((View) this.bjp, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bjq, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bjp, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bjr, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bjs, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bjr, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bjt, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bju, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bjt, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bjv, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bjw, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bjv, t.d.frs_lottery_count_bg);
        if (j <= bjo) {
            this.bjp.setText("0");
            this.bjr.setText("0");
            this.bjt.setText("0");
            this.bjv.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.bjp.setVisibility(8);
            this.bjq.setVisibility(8);
        } else {
            this.bjp.setVisibility(0);
            this.bjq.setVisibility(0);
        }
        if (this.bjx != null) {
            this.bjx.cancel();
        }
        this.bjx = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> bjy;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.bjy = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.bjy.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.bjp.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.bjr.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.bjt.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.bjn)));
                frsLotteryCountDownView.bjv.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.bjn) / FrsLotteryCountDownView.bjo)));
                return;
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(new a(new WeakReference(this), null), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.bjy.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.bjv.setText("0");
            }
        }
    }

    /* loaded from: classes.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> bjy;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.bjy = weakReference;
        }

        /* synthetic */ a(WeakReference weakReference, a aVar) {
            this(weakReference);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.bjy.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
