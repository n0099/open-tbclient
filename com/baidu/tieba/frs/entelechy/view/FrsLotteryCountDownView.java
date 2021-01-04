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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long jsb = TimeUnit.DAYS.toMillis(1);
    private static final long jsc = TimeUnit.HOURS.toMillis(1);
    private static final long jsd = TimeUnit.MINUTES.toMillis(1);
    private static final long jse = TimeUnit.SECONDS.toMillis(1);
    private TextView jsf;
    private TextView jsg;
    private TextView jsh;
    private TextView jsi;
    private TextView jsj;
    private TextView jsk;
    private TextView jsl;
    private TextView jsm;
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
        this.jsf = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.jsg = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.jsh = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.jsi = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.jsj = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.jsk = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.jsl = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.jsm = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ao.setViewTextColor(this.jsf, R.color.CAM_X0111);
        ao.setViewTextColor(this.jsg, R.color.CAM_X0108);
        ao.setBackgroundColor(this.jsf, R.color.common_color_10060);
        ao.setViewTextColor(this.jsh, R.color.CAM_X0111);
        ao.setViewTextColor(this.jsi, R.color.CAM_X0108);
        ao.setBackgroundColor(this.jsh, R.color.common_color_10060);
        ao.setViewTextColor(this.jsj, R.color.CAM_X0111);
        ao.setViewTextColor(this.jsk, R.color.CAM_X0108);
        ao.setBackgroundColor(this.jsj, R.color.common_color_10060);
        ao.setViewTextColor(this.jsl, R.color.CAM_X0111);
        ao.setViewTextColor(this.jsm, R.color.CAM_X0108);
        ao.setBackgroundColor(this.jsl, R.color.common_color_10060);
        if (j <= jse) {
            this.jsf.setText("0");
            this.jsh.setText("0");
            this.jsj.setText("0");
            this.jsl.setText("0");
            return;
        }
        if (j / jsb <= 0) {
            this.jsf.setVisibility(8);
            this.jsg.setVisibility(8);
        } else {
            this.jsf.setVisibility(0);
            this.jsg.setVisibility(0);
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
                frsLotteryCountDownView.jsf.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.jsb)));
                frsLotteryCountDownView.jsh.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.jsb) / FrsLotteryCountDownView.jsc)));
                frsLotteryCountDownView.jsj.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.jsb) % FrsLotteryCountDownView.jsc) / FrsLotteryCountDownView.jsd)));
                frsLotteryCountDownView.jsl.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.jsb) % FrsLotteryCountDownView.jsc) % FrsLotteryCountDownView.jsd) / FrsLotteryCountDownView.jse)));
                return;
            }
            e.mB().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.jsl.setText("0");
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
