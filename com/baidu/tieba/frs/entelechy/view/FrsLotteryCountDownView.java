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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes22.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long iNV = TimeUnit.DAYS.toMillis(1);
    private static final long iNW = TimeUnit.HOURS.toMillis(1);
    private static final long iNX = TimeUnit.MINUTES.toMillis(1);
    private static final long iNY = TimeUnit.SECONDS.toMillis(1);
    private TextView iNZ;
    private TextView iOa;
    private TextView iOb;
    private TextView iOc;
    private TextView iOd;
    private TextView iOe;
    private TextView iOf;
    private TextView iOg;
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
        this.iNZ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.iOa = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.iOb = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.iOc = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.iOd = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.iOe = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.iOf = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.iOg = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.iNZ, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iOa, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iNZ, R.color.common_color_10060);
        ap.setViewTextColor(this.iOb, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iOc, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iOb, R.color.common_color_10060);
        ap.setViewTextColor(this.iOd, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iOe, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iOd, R.color.common_color_10060);
        ap.setViewTextColor(this.iOf, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iOg, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iOf, R.color.common_color_10060);
        if (j <= iNY) {
            this.iNZ.setText("0");
            this.iOb.setText("0");
            this.iOd.setText("0");
            this.iOf.setText("0");
            return;
        }
        if (j / iNV <= 0) {
            this.iNZ.setVisibility(8);
            this.iOa.setVisibility(8);
        } else {
            this.iNZ.setVisibility(0);
            this.iOa.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes22.dex */
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
                frsLotteryCountDownView.iNZ.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.iNV)));
                frsLotteryCountDownView.iOb.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.iNV) / FrsLotteryCountDownView.iNW)));
                frsLotteryCountDownView.iOd.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.iNV) % FrsLotteryCountDownView.iNW) / FrsLotteryCountDownView.iNX)));
                frsLotteryCountDownView.iOf.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.iNV) % FrsLotteryCountDownView.iNW) % FrsLotteryCountDownView.iNX) / FrsLotteryCountDownView.iNY)));
                return;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.iOf.setText("0");
            }
        }
    }

    /* loaded from: classes22.dex */
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
