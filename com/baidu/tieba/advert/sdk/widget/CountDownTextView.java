package com.baidu.tieba.advert.sdk.widget;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f31221b;

    /* renamed from: c  reason: collision with root package name */
    public b f31222c;

    /* renamed from: d  reason: collision with root package name */
    public d f31223d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f31224e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f31225f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31226g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<CountDownTextView> a;

        public /* synthetic */ c(CountDownTextView countDownTextView, a aVar) {
            this(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTextView = this.a.get()) == null) {
                return;
            }
            countDownTextView.b(1);
        }

        public c(CountDownTextView countDownTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onTimeout(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f31221b = "";
        this.f31222c = null;
        this.f31223d = null;
        this.f31224e = new Handler();
        this.f31226g = false;
        this.f31225f = new c(this, null);
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = this.a - i;
            this.a = i2;
            b bVar = this.f31222c;
            if (bVar != null && i != 0) {
                bVar.a(i2);
            }
            int i3 = this.a;
            if (i3 == 0) {
                d dVar = this.f31223d;
                if (dVar != null) {
                    dVar.onTimeout(this);
                }
                this.f31224e.removeCallbacksAndMessages(null);
                return;
            }
            if (i3 > 0) {
                if (this.f31226g) {
                    setText(String.format("%s 0%s", this.f31221b, Integer.valueOf(i3)));
                } else {
                    setText(String.format("%s %s", this.f31221b, Integer.valueOf(i3)));
                }
            }
            this.f31224e.removeCallbacks(this.f31225f);
            this.f31224e.postDelayed(this.f31225f, 1000L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31224e.removeCallbacksAndMessages(null);
        }
    }

    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            this.f31221b = str;
            if (i > 0) {
                this.a = i;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            b(0);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            c();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i == 0) {
                b(0);
            } else {
                c();
            }
        }
    }

    public void setNumTypeFromBes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f31226g = z;
        }
    }

    public void setTimeoutListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f31223d = dVar;
        }
    }

    public void setTimerChangedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f31222c = bVar;
        }
    }
}
