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
    private static final long fzb = TimeUnit.MINUTES.toMillis(1);
    private static final long fzc = TimeUnit.SECONDS.toMillis(1);
    private TextView fzd;
    private TextView fze;
    private TextView fzf;
    private TextView fzg;
    private TextView fzh;
    private TextView fzi;
    private TextView fzj;
    private TextView fzk;
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
        this.fzd = (TextView) this.mRootView.findViewById(R.id.lottery_count_day);
        this.fze = (TextView) this.mRootView.findViewById(R.id.lottery_count_day_txt);
        this.fzf = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour);
        this.fzg = (TextView) this.mRootView.findViewById(R.id.lottery_count_hour_txt);
        this.fzh = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute);
        this.fzi = (TextView) this.mRootView.findViewById(R.id.lottery_count_minute_txt);
        this.fzj = (TextView) this.mRootView.findViewById(R.id.lottery_count_second);
        this.fzk = (TextView) this.mRootView.findViewById(R.id.lottery_count_second_txt);
    }

    public void setData(long j) {
        al.j(this.fzd, R.color.cp_cont_g);
        al.j(this.fze, R.color.cp_cont_c);
        al.l(this.fzd, R.color.common_color_10060);
        al.j(this.fzf, R.color.cp_cont_g);
        al.j(this.fzg, R.color.cp_cont_c);
        al.l(this.fzf, R.color.common_color_10060);
        al.j(this.fzh, R.color.cp_cont_g);
        al.j(this.fzi, R.color.cp_cont_c);
        al.l(this.fzh, R.color.common_color_10060);
        al.j(this.fzj, R.color.cp_cont_g);
        al.j(this.fzk, R.color.cp_cont_c);
        al.l(this.fzj, R.color.common_color_10060);
        if (j <= fzc) {
            this.fzd.setText("0");
            this.fzf.setText("0");
            this.fzh.setText("0");
            this.fzj.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.fzd.setVisibility(8);
            this.fze.setVisibility(8);
        } else {
            this.fzd.setVisibility(0);
            this.fze.setVisibility(0);
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new b(new WeakReference(this), j, 1000L).start();
    }

    /* loaded from: classes4.dex */
    private static class b extends CountDownTimer {
        private final WeakReference<FrsLotteryCountDownView> fzl;

        public b(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            this.fzl = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fzl.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fzd.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.INTERVAL_DAY)));
                frsLotteryCountDownView.fzf.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.INTERVAL_DAY) / FrsLotteryCountDownView.INTERVAL_HOUR)));
                frsLotteryCountDownView.fzh.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) / FrsLotteryCountDownView.fzb)));
                frsLotteryCountDownView.fzj.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.INTERVAL_DAY) % FrsLotteryCountDownView.INTERVAL_HOUR) % FrsLotteryCountDownView.fzb) / FrsLotteryCountDownView.fzc)));
                return;
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new a(new WeakReference(this)), TimeUnit.SECONDS.toSeconds(3L));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView = this.fzl.get();
            if (frsLotteryCountDownView != null) {
                frsLotteryCountDownView.fzj.setText("0");
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTimer> fzl;

        private a(WeakReference<CountDownTimer> weakReference) {
            this.fzl = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer = this.fzl.get();
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
    }
}
