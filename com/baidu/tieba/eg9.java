package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eg9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public b d;
    public long e;
    public Handler f;

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg9 a;

        public a(eg9 eg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg9Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 2) {
                    if (i == 1 && this.a.a == 1) {
                        if (this.a.d != null) {
                            this.a.d.a();
                        }
                        this.a.a = 0;
                        this.a.b = 0L;
                        this.a.c = 0L;
                        return;
                    }
                    return;
                }
                this.a.a = 0;
                this.a.b = 0L;
                this.a.c = 0L;
            }
        }
    }

    public eg9(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0L;
        this.c = 0L;
        this.e = 500L;
        this.f = new a(this);
        this.d = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.d == null) {
                    return false;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == 1) {
                    this.b = System.currentTimeMillis();
                    this.f.sendEmptyMessageDelayed(1, this.e);
                } else if (i == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.c = currentTimeMillis;
                    if (currentTimeMillis - this.b < this.e) {
                        this.d.b();
                    }
                    this.f.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
