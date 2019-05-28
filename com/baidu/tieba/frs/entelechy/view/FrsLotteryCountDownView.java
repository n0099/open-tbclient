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
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long fzc = TimeUnit.MINUTES.toMillis(1);
    private static final long fzd = TimeUnit.SECONDS.toMillis(1);
    private TextView fze;
    private TextView fzf;
    private TextView fzg;
    private TextView fzh;
    private TextView fzi;
    private TextView fzj;
    private TextView fzk;
    private TextView fzl;
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
        this.fze = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fzf = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fzg = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fzh = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fzi = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fzj = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fzk = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fzl = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.j(this.fze, R.color.cp_cont_g);
        al.j(this.fzf, R.color.cp_cont_c);
        al.l(this.fze, R.color.common_color_10060);
        al.j(this.fzg, R.color.cp_cont_g);
        al.j(this.fzh, R.color.cp_cont_c);
        al.l(this.fzg, R.color.common_color_10060);
        al.j(this.fzi, R.color.cp_cont_g);
        al.j(this.fzj, R.color.cp_cont_c);
        al.l(this.fzi, R.color.common_color_10060);
        al.j(this.fzk, R.color.cp_cont_g);
        al.j(this.fzl, R.color.cp_cont_c);
        al.l(this.fzk, R.color.common_color_10060);
        if (j <= fzd) {
            this.fze.setText("0");
            this.fzg.setText("0");
            this.fzi.setText("0");
            this.fzk.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.fze.setVisibility(8);
            this.fzf.setVisibility(8);
        } else {
            this.fze.setVisibility(0);
            this.fzf.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fzm;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fzm = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fzm.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fze.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.fzg.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.fzi.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.fzc)));
                frsLotteryCountDownView.fzk.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.fzc) / FrsLotteryCountDownView.fzd)));
                return;
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fzm.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fzk.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fzm;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fzm = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fzm.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
