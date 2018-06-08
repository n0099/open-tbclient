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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long dpF = TimeUnit.MINUTES.toMillis(1);
    private static final long dpG = TimeUnit.SECONDS.toMillis(1);
    private TextView dpH;
    private TextView dpI;
    private TextView dpJ;
    private TextView dpK;
    private TextView dpL;
    private TextView dpM;
    private TextView dpN;
    private TextView dpO;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.frs_lottery_count_down, (ViewGroup) this, true);
        this.dpH = (TextView) this.mRootView.findViewById(d.g.lottery_count_day);
        this.dpI = (TextView) this.mRootView.findViewById(d.g.lottery_count_day_txt);
        this.dpJ = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour);
        this.dpK = (TextView) this.mRootView.findViewById(d.g.lottery_count_hour_txt);
        this.dpL = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute);
        this.dpM = (TextView) this.mRootView.findViewById(d.g.lottery_count_minute_txt);
        this.dpN = (TextView) this.mRootView.findViewById(d.g.lottery_count_second);
        this.dpO = (TextView) this.mRootView.findViewById(d.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.h(this.dpH, d.C0141d.cp_cont_g);
        al.h(this.dpI, d.C0141d.cp_cont_c);
        al.j(this.dpH, d.C0141d.common_color_10060);
        al.h(this.dpJ, d.C0141d.cp_cont_g);
        al.h(this.dpK, d.C0141d.cp_cont_c);
        al.j(this.dpJ, d.C0141d.common_color_10060);
        al.h(this.dpL, d.C0141d.cp_cont_g);
        al.h(this.dpM, d.C0141d.cp_cont_c);
        al.j(this.dpL, d.C0141d.common_color_10060);
        al.h(this.dpN, d.C0141d.cp_cont_g);
        al.h(this.dpO, d.C0141d.cp_cont_c);
        al.j(this.dpN, d.C0141d.common_color_10060);
        if (j <= dpG) {
            this.dpH.setText("0");
            this.dpJ.setText("0");
            this.dpL.setText("0");
            this.dpN.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.dpH.setVisibility(8);
            this.dpI.setVisibility(8);
        } else {
            this.dpH.setVisibility(0);
            this.dpI.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes3.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> dpP;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.dpP = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dpP.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dpH.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.dpJ.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.dpL.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.dpF)));
                frsLotteryCountDownView.dpN.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.dpF) / FrsLotteryCountDownView.dpG)));
                return;
            }
            com.baidu.adp.lib.g.e.im().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.dpP.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.dpN.setText("0");
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> dpP;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.dpP = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.dpP.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
