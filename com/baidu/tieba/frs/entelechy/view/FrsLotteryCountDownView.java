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
/* loaded from: classes21.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long iUE = TimeUnit.DAYS.toMillis(1);
    private static final long iUF = TimeUnit.HOURS.toMillis(1);
    private static final long iUG = TimeUnit.MINUTES.toMillis(1);
    private static final long iUH = TimeUnit.SECONDS.toMillis(1);
    private TextView iUI;
    private TextView iUJ;
    private TextView iUK;
    private TextView iUL;
    private TextView iUM;
    private TextView iUN;
    private TextView iUO;
    private TextView iUP;
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
        this.iUI = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.iUJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.iUK = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.iUL = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.iUM = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.iUN = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.iUO = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.iUP = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.iUI, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.iUJ, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.iUI, R.color.common_color_10060);
        ap.setViewTextColor(this.iUK, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.iUL, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.iUK, R.color.common_color_10060);
        ap.setViewTextColor(this.iUM, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.iUN, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.iUM, R.color.common_color_10060);
        ap.setViewTextColor(this.iUO, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.iUP, (int) R.color.CAM_X0108);
        ap.setBackgroundColor(this.iUO, R.color.common_color_10060);
        if (j <= iUH) {
            this.iUI.setText("0");
            this.iUK.setText("0");
            this.iUM.setText("0");
            this.iUO.setText("0");
            return;
        }
        if (j / iUE <= 0) {
            this.iUI.setVisibility(8);
            this.iUJ.setVisibility(8);
        } else {
            this.iUI.setVisibility(0);
            this.iUJ.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes21.dex */
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
                frsLotteryCountDownView.iUI.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.iUE)));
                frsLotteryCountDownView.iUK.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.iUE) / FrsLotteryCountDownView.iUF)));
                frsLotteryCountDownView.iUM.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.iUE) % FrsLotteryCountDownView.iUF) / FrsLotteryCountDownView.iUG)));
                frsLotteryCountDownView.iUO.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.iUE) % FrsLotteryCountDownView.iUF) % FrsLotteryCountDownView.iUG) / FrsLotteryCountDownView.iUH)));
                return;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.iUO.setText("0");
            }
        }
    }

    /* loaded from: classes21.dex */
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
