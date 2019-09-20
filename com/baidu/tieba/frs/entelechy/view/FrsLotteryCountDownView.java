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
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long fGB = TimeUnit.DAYS.toMillis(1);
    private static final long fGC = TimeUnit.HOURS.toMillis(1);
    private static final long fGD = TimeUnit.MINUTES.toMillis(1);
    private static final long fGE = TimeUnit.SECONDS.toMillis(1);
    private TextView fGF;
    private TextView fGG;
    private TextView fGH;
    private TextView fGI;
    private TextView fGJ;
    private TextView fGK;
    private TextView fGL;
    private TextView fGM;
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
        this.fGF = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fGG = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fGH = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fGI = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fGJ = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fGK = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fGL = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fGM = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        am.j(this.fGF, R.color.cp_cont_g);
        am.j(this.fGG, R.color.cp_cont_c);
        am.l(this.fGF, R.color.common_color_10060);
        am.j(this.fGH, R.color.cp_cont_g);
        am.j(this.fGI, R.color.cp_cont_c);
        am.l(this.fGH, R.color.common_color_10060);
        am.j(this.fGJ, R.color.cp_cont_g);
        am.j(this.fGK, R.color.cp_cont_c);
        am.l(this.fGJ, R.color.common_color_10060);
        am.j(this.fGL, R.color.cp_cont_g);
        am.j(this.fGM, R.color.cp_cont_c);
        am.l(this.fGL, R.color.common_color_10060);
        if (j <= fGE) {
            this.fGF.setText("0");
            this.fGH.setText("0");
            this.fGJ.setText("0");
            this.fGL.setText("0");
            return;
        }
        if (j / fGB <= 0) {
            this.fGF.setVisibility(8);
            this.fGG.setVisibility(8);
        } else {
            this.fGF.setVisibility(0);
            this.fGG.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fGN;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fGN = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fGN.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fGF.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.fGB)));
                frsLotteryCountDownView.fGH.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.fGB) / FrsLotteryCountDownView.fGC)));
                frsLotteryCountDownView.fGJ.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.fGB) % FrsLotteryCountDownView.fGC) / FrsLotteryCountDownView.fGD)));
                frsLotteryCountDownView.fGL.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.fGB) % FrsLotteryCountDownView.fGC) % FrsLotteryCountDownView.fGD) / FrsLotteryCountDownView.fGE)));
                return;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fGN.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fGL.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fGN;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fGN = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fGN.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
