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
    private TextView iBD;
    private TextView iBE;
    private TextView iBF;
    private TextView iBG;
    private TextView iBH;
    private TextView iBI;
    private TextView iBJ;
    private TextView iBK;
    private Context mContext;
    private View mRootView;
    private CountDownTimer mTimer;
    private static final long iBz = TimeUnit.DAYS.toMillis(1);
    private static final long iBA = TimeUnit.HOURS.toMillis(1);
    private static final long iBB = TimeUnit.MINUTES.toMillis(1);
    private static final long iBC = TimeUnit.SECONDS.toMillis(1);

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
        this.iBD = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.iBE = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.iBF = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.iBG = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.iBH = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.iBI = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.iBJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.iBK = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        ap.setViewTextColor(this.iBD, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iBE, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iBD, R.color.common_color_10060);
        ap.setViewTextColor(this.iBF, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iBG, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iBF, R.color.common_color_10060);
        ap.setViewTextColor(this.iBH, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iBI, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iBH, R.color.common_color_10060);
        ap.setViewTextColor(this.iBJ, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iBK, (int) R.color.cp_cont_c);
        ap.setBackgroundColor(this.iBJ, R.color.common_color_10060);
        if (j <= iBC) {
            this.iBD.setText("0");
            this.iBF.setText("0");
            this.iBH.setText("0");
            this.iBJ.setText("0");
            return;
        }
        if (j / iBz <= 0) {
            this.iBD.setVisibility(8);
            this.iBE.setVisibility(8);
        } else {
            this.iBD.setVisibility(0);
            this.iBE.setVisibility(0);
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
                frsLotteryCountDownView.iBD.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.iBz)));
                frsLotteryCountDownView.iBF.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.iBz) / FrsLotteryCountDownView.iBA)));
                frsLotteryCountDownView.iBH.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.iBz) % FrsLotteryCountDownView.iBA) / FrsLotteryCountDownView.iBB)));
                frsLotteryCountDownView.iBJ.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.iBz) % FrsLotteryCountDownView.iBA) % FrsLotteryCountDownView.iBB) / FrsLotteryCountDownView.iBC)));
                return;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.reference.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.iBJ.setText("0");
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
