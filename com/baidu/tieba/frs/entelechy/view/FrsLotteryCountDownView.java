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
    private static final long jtb = TimeUnit.DAYS.toMillis(1);
    private static final long jtc = TimeUnit.HOURS.toMillis(1);
    private static final long jtd = TimeUnit.MINUTES.toMillis(1);
    private static final long jte = TimeUnit.SECONDS.toMillis(1);
    private TextView jtf;
    private TextView jtg;
    private TextView jth;
    private TextView jti;
    private TextView jtj;
    private TextView jtk;
    private TextView jtl;
    private TextView jtm;
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
        this.jtf = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.jtg = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.jth = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.jti = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.jtj = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.jtk = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.jtl = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.jtm = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.jtf, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtg, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtf, R.color.common_color_10060);
        ap.setViewTextColor(this.jth, R.color.CAM_X0111);
        ap.setViewTextColor(this.jti, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jth, R.color.common_color_10060);
        ap.setViewTextColor(this.jtj, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtk, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtj, R.color.common_color_10060);
        ap.setViewTextColor(this.jtl, R.color.CAM_X0111);
        ap.setViewTextColor(this.jtm, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jtl, R.color.common_color_10060);
        if (j <= jte) {
            this.jtf.setText("0");
            this.jth.setText("0");
            this.jtj.setText("0");
            this.jtl.setText("0");
            return;
        }
        if (j / jtb <= 0) {
            this.jtf.setVisibility(8);
            this.jtg.setVisibility(8);
        } else {
            this.jtf.setVisibility(0);
            this.jtg.setVisibility(0);
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
                frsLotteryCountDownView.jtf.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.jtb)));
                frsLotteryCountDownView.jth.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.jtb) / FrsLotteryCountDownView.jtc)));
                frsLotteryCountDownView.jtj.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.jtb) % FrsLotteryCountDownView.jtc) / FrsLotteryCountDownView.jtd)));
                frsLotteryCountDownView.jtl.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.jtb) % FrsLotteryCountDownView.jtc) % FrsLotteryCountDownView.jtd) / FrsLotteryCountDownView.jte)));
                return;
            }
            e.mA().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.jtl.setText("0");
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
