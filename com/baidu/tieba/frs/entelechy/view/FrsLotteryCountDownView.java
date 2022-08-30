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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.sg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public CountDownTimer k;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<CountDownTimer> a;

        public /* synthetic */ b(WeakReference weakReference, a aVar) {
            this(weakReference);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTimer countDownTimer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTimer = this.a.get()) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FrsLotteryCountDownView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WeakReference<FrsLotteryCountDownView> weakReference, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weakReference, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            frsLotteryCountDownView.i.setText("0");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                FrsLotteryCountDownView frsLotteryCountDownView = this.a.get();
                if (frsLotteryCountDownView != null) {
                    frsLotteryCountDownView.c.setText(StringUtils.string(Long.valueOf(j / FrsLotteryCountDownView.l)));
                    frsLotteryCountDownView.e.setText(StringUtils.string(Long.valueOf((j % FrsLotteryCountDownView.l) / FrsLotteryCountDownView.m)));
                    frsLotteryCountDownView.g.setText(StringUtils.string(Long.valueOf(((j % FrsLotteryCountDownView.l) % FrsLotteryCountDownView.m) / FrsLotteryCountDownView.n)));
                    frsLotteryCountDownView.i.setText(StringUtils.string(Long.valueOf((((j % FrsLotteryCountDownView.l) % FrsLotteryCountDownView.m) % FrsLotteryCountDownView.n) / FrsLotteryCountDownView.o)));
                    return;
                }
                sg.a().postDelayed(new b(new WeakReference(this), null), TimeUnit.SECONDS.toSeconds(3L));
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
        l = TimeUnit.DAYS.toMillis(1L);
        m = TimeUnit.HOURS.toMillis(1L);
        n = TimeUnit.MINUTES.toMillis(1L);
        o = TimeUnit.SECONDS.toMillis(1L);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.k = null;
        this.a = context;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d032f, (ViewGroup) this, true);
            this.b = inflate;
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091424);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091425);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091426);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091427);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091428);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091429);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09142a);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09142b);
        }
    }

    public void setData(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.c, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.e, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.g, R.color.common_color_10060);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.i, R.color.common_color_10060);
            if (j <= o) {
                this.c.setText("0");
                this.e.setText("0");
                this.g.setText("0");
                this.i.setText("0");
                return;
            }
            if (j / l <= 0) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(0);
            }
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.k = new c(new WeakReference(this), j, 1000L).start();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.k = null;
        this.a = context;
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.k = null;
        this.a = context;
        i();
    }
}
