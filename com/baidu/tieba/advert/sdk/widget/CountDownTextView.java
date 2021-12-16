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
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43184e;

    /* renamed from: f  reason: collision with root package name */
    public String f43185f;

    /* renamed from: g  reason: collision with root package name */
    public b f43186g;

    /* renamed from: h  reason: collision with root package name */
    public d f43187h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f43188i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f43189j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f43190k;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes11.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f43191e;

        public /* synthetic */ c(CountDownTextView countDownTextView, a aVar) {
            this(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTextView = this.f43191e.get()) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43191e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43184e = 0;
        this.f43185f = "";
        this.f43186g = null;
        this.f43187h = null;
        this.f43188i = new Handler();
        this.f43190k = false;
        this.f43189j = new c(this, null);
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = this.f43184e - i2;
            this.f43184e = i3;
            b bVar = this.f43186g;
            if (bVar != null && i2 != 0) {
                bVar.a(i3);
            }
            int i4 = this.f43184e;
            if (i4 == 0) {
                d dVar = this.f43187h;
                if (dVar != null) {
                    dVar.onTimeout(this);
                }
                this.f43188i.removeCallbacksAndMessages(null);
                return;
            }
            if (i4 > 0) {
                if (this.f43190k) {
                    setText(String.format("%s 0%s", this.f43185f, Integer.valueOf(i4)));
                } else {
                    setText(String.format("%s %s", this.f43185f, Integer.valueOf(i4)));
                }
            }
            this.f43188i.removeCallbacks(this.f43189j);
            this.f43188i.postDelayed(this.f43189j, 1000L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f43188i.removeCallbacksAndMessages(null);
        }
    }

    public void init(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f43185f = str;
            if (i2 > 0) {
                this.f43184e = i2;
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
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 0) {
                b(0);
            } else {
                c();
            }
        }
    }

    public void setNumTypeFromBes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f43190k = z;
        }
    }

    public void setTimeoutListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f43187h = dVar;
        }
    }

    public void setTimerChangedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f43186g = bVar;
        }
    }
}
