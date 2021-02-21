package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long jtp = TimeUnit.DAYS.toMillis(1);
    private static final long jtq = TimeUnit.HOURS.toMillis(1);
    private static final long jtr = TimeUnit.MINUTES.toMillis(1);
    private static final long jts = TimeUnit.SECONDS.toMillis(1);
    private TextView jtA;
    private TextView jtt;
    private TextView jtu;
    private TextView jtv;
    private TextView jtw;
    private TextView jtx;
    private TextView jty;
    private TextView jtz;
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
        this.jtt = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.jtu = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.jtv = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.jtw = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.jtx = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.jty = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.jtz = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.jtA = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.jtt, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtu, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtt, R.color.common_color_10060);
        ap.setViewTextColor(this.jtv, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtw, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtv, R.color.common_color_10060);
        ap.setViewTextColor(this.jtx, R.color.CAM_X0111);
        ap.setViewTextColor(this.jty, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtx, R.color.common_color_10060);
        ap.setViewTextColor(this.jtz, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtA, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtz, R.color.common_color_10060);
        if (j <= jts) {
            this.jtt.setText("0");
            this.jtv.setText("0");
            this.jtx.setText("0");
            this.jtz.setText("0");
            return;
        }
        if (j / jtp <= 0) {
            this.jtt.setVisibility(8);
            this.jtu.setVisibility(8);
        } else {
            this.jtt.setVisibility(0);
            this.jtu.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes2.dex */
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
                frsLotteryCountDownView.jtt.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.jtp)));
                frsLotteryCountDownView.jtv.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.jtp) / FrsLotteryCountDownView.jtq)));
                frsLotteryCountDownView.jtx.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.jtp) % FrsLotteryCountDownView.jtq) / FrsLotteryCountDownView.jtr)));
                frsLotteryCountDownView.jtz.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.jtp) % FrsLotteryCountDownView.jtq) % FrsLotteryCountDownView.jtr) / FrsLotteryCountDownView.jts)));
                return;
            }
            e.mA().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.jtz.setText("0");
            }
        }
    }

    /* loaded from: classes2.dex */
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
