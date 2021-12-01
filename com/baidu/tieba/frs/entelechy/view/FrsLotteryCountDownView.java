package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.m.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f44249e;

    /* renamed from: f  reason: collision with root package name */
    public View f44250f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44251g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44252h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44253i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44254j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f44255k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTimer o;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTimer> f44256e;

        public /* synthetic */ b(WeakReference weakReference, a aVar) {
            this(weakReference);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTimer = this.f44256e.get()) == null) {
                return;
            }
            countDownTimer.cancel();
        }

        public b(WeakReference<CountDownTimer> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44256e = weakReference;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FrsLotteryCountDownView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WeakReference<FrsLotteryCountDownView> weakReference, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            FrsLotteryCountDownView frsLotteryCountDownView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frsLotteryCountDownView = this.a.get()) == null) {
                return;
            }
            frsLotteryCountDownView.m.setText("0");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                FrsLotteryCountDownView frsLotteryCountDownView = this.a.get();
                if (frsLotteryCountDownView != null) {
                    frsLotteryCountDownView.f44251g.setText(StringUtils.string(Long.valueOf(j2 / FrsLotteryCountDownView.p)));
                    frsLotteryCountDownView.f44253i.setText(StringUtils.string(Long.valueOf((j2 % FrsLotteryCountDownView.p) / FrsLotteryCountDownView.q)));
                    frsLotteryCountDownView.f44255k.setText(StringUtils.string(Long.valueOf(((j2 % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) / FrsLotteryCountDownView.r)));
                    frsLotteryCountDownView.m.setText(StringUtils.string(Long.valueOf((((j2 % FrsLotteryCountDownView.p) % FrsLotteryCountDownView.q) % FrsLotteryCountDownView.r) / FrsLotteryCountDownView.s)));
                    return;
                }
                e.a().postDelayed(new b(new WeakReference(this), null), TimeUnit.SECONDS.toSeconds(3L));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609325165, "Lcom/baidu/tieba/frs/entelechy/view/FrsLotteryCountDownView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1609325165, "Lcom/baidu/tieba/frs/entelechy/view/FrsLotteryCountDownView;");
                return;
            }
        }
        p = TimeUnit.DAYS.toMillis(1L);
        q = TimeUnit.HOURS.toMillis(1L);
        r = TimeUnit.MINUTES.toMillis(1L);
        s = TimeUnit.SECONDS.toMillis(1L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLotteryCountDownView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44249e = null;
        this.o = null;
        this.f44249e = context;
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f44249e).inflate(R.layout.frs_lottery_count_down, (ViewGroup) this, true);
            this.f44250f = inflate;
            this.f44251g = (TextView) inflate.findViewById(R.id.lottery_count_day);
            this.f44252h = (TextView) this.f44250f.findViewById(R.id.lottery_count_day_txt);
            this.f44253i = (TextView) this.f44250f.findViewById(R.id.lottery_count_hour);
            this.f44254j = (TextView) this.f44250f.findViewById(R.id.lottery_count_hour_txt);
            this.f44255k = (TextView) this.f44250f.findViewById(R.id.lottery_count_minute);
            this.l = (TextView) this.f44250f.findViewById(R.id.lottery_count_minute_txt);
            this.m = (TextView) this.f44250f.findViewById(R.id.lottery_count_second);
            this.n = (TextView) this.f44250f.findViewById(R.id.lottery_count_second_txt);
        }
    }

    public void setData(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            SkinManager.setViewTextColor(this.f44251g, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f44252h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f44251g, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.f44253i, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f44254j, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f44253i, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.f44255k, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f44255k, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.m, R.color.common_color_10060);
            if (j2 <= s) {
                this.f44251g.setText("0");
                this.f44253i.setText("0");
                this.f44255k.setText("0");
                this.m.setText("0");
                return;
            }
            if (j2 / p <= 0) {
                this.f44251g.setVisibility(8);
                this.f44252h.setVisibility(8);
            } else {
                this.f44251g.setVisibility(0);
                this.f44252h.setVisibility(0);
            }
            CountDownTimer countDownTimer = this.o;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.o = new c(new WeakReference(this), j2, 1000L).start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44249e = null;
        this.o = null;
        this.f44249e = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f44249e = null;
        this.o = null;
        this.f44249e = context;
        init();
    }
}
