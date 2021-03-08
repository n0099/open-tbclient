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
    private static final long juY = TimeUnit.DAYS.toMillis(1);
    private static final long juZ = TimeUnit.HOURS.toMillis(1);
    private static final long jva = TimeUnit.MINUTES.toMillis(1);
    private static final long jvb = TimeUnit.SECONDS.toMillis(1);
    private TextView jvc;
    private TextView jvd;
    private TextView jve;
    private TextView jvf;
    private TextView jvg;
    private TextView jvh;
    private TextView jvi;
    private TextView jvj;
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
        this.jvc = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.jvd = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.jve = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.jvf = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.jvg = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.jvh = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.jvi = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.jvj = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.jvc, R.color.CAM_X0111);
        ap.setViewTextColor(this.jvd, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jvc, R.color.common_color_10060);
        ap.setViewTextColor(this.jve, R.color.CAM_X0111);
        ap.setViewTextColor(this.jvf, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jve, R.color.common_color_10060);
        ap.setViewTextColor(this.jvg, R.color.CAM_X0111);
        ap.setViewTextColor(this.jvh, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jvg, R.color.common_color_10060);
        ap.setViewTextColor(this.jvi, R.color.CAM_X0111);
        ap.setViewTextColor(this.jvj, R.color.CAM_X0108);
        ap.setBackgroundColor(this.jvi, R.color.common_color_10060);
        if (j <= jvb) {
            this.jvc.setText("0");
            this.jve.setText("0");
            this.jvg.setText("0");
            this.jvi.setText("0");
            return;
        }
        if (j / juY <= 0) {
            this.jvc.setVisibility(8);
            this.jvd.setVisibility(8);
        } else {
            this.jvc.setVisibility(0);
            this.jvd.setVisibility(0);
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
                frsLotteryCountDownView.jvc.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.juY)));
                frsLotteryCountDownView.jve.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.juY) / FrsLotteryCountDownView.juZ)));
                frsLotteryCountDownView.jvg.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.juY) % FrsLotteryCountDownView.juZ) / FrsLotteryCountDownView.jva)));
                frsLotteryCountDownView.jvi.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.juY) % FrsLotteryCountDownView.juZ) % FrsLotteryCountDownView.jva) / FrsLotteryCountDownView.jvb)));
                return;
            }
            e.mA().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.jvi.setText("0");
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
