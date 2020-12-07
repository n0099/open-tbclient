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
    private static final long jfA = TimeUnit.DAYS.toMillis(1);
    private static final long jfB = TimeUnit.HOURS.toMillis(1);
    private static final long jfC = TimeUnit.MINUTES.toMillis(1);
    private static final long jfD = TimeUnit.SECONDS.toMillis(1);
    private TextView jfE;
    private TextView jfF;
    private TextView jfG;
    private TextView jfH;
    private TextView jfI;
    private TextView jfJ;
    private TextView jfK;
    private TextView jfL;
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
        this.jfE = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.jfF = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.jfG = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.jfH = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.jfI = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.jfJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.jfK = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.jfL = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.jfE, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jfF, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.jfE, R.color.common_color_10060);
        ap.setViewTextColor(this.jfG, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jfH, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.jfG, R.color.common_color_10060);
        ap.setViewTextColor(this.jfI, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jfJ, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.jfI, R.color.common_color_10060);
        ap.setViewTextColor(this.jfK, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jfL, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.jfK, R.color.common_color_10060);
        if (j <= jfD) {
            this.jfE.setText("0");
            this.jfG.setText("0");
            this.jfI.setText("0");
            this.jfK.setText("0");
            return;
        }
        if (j / jfA <= 0) {
            this.jfE.setVisibility(8);
            this.jfF.setVisibility(8);
        } else {
            this.jfE.setVisibility(0);
            this.jfF.setVisibility(0);
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
                frsLotteryCountDownView.jfE.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.jfA)));
                frsLotteryCountDownView.jfG.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.jfA) / FrsLotteryCountDownView.jfB)));
                frsLotteryCountDownView.jfI.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.jfA) % FrsLotteryCountDownView.jfB) / FrsLotteryCountDownView.jfC)));
                frsLotteryCountDownView.jfK.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.jfA) % FrsLotteryCountDownView.jfB) % FrsLotteryCountDownView.jfC) / FrsLotteryCountDownView.jfD)));
                return;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.jfK.setText("0");
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
