package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class gw {
    public static /* synthetic */ Interceptable $ic;
    public static gw f;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;
    public ExecutorService b;
    public Handler c;
    public Handler d;
    public List<fw> e;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gw gwVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gwVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gwVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            Object obj = message.obj;
                            if (obj instanceof BdRunnable) {
                                post((BdRunnable) obj);
                            }
                        }
                    } else if (message.obj instanceof fw) {
                        this.a.e.add((fw) message.obj);
                    }
                } else if (this.a.e != null) {
                    Iterator it = this.a.e.iterator();
                    while (it.hasNext()) {
                        fw fwVar = (fw) it.next();
                        if (this.a.e(fwVar)) {
                            this.a.a.submit(fwVar);
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    public gw() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.a = Executors.newFixedThreadPool(5);
        this.b = Executors.newSingleThreadExecutor();
        this.c = new a(this, ew.a("threadpool").getLooper());
        this.d = new Handler(Looper.getMainLooper());
    }

    public void h(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdRunnable) == null) {
            this.d.post(bdRunnable);
        }
    }

    public static gw f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f == null) {
                synchronized (gw.class) {
                    if (f == null) {
                        f = new gw();
                    }
                }
            }
            return f;
        }
        return (gw) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.removeMessages(0);
            this.c.sendEmptyMessage(0);
        }
    }

    public final boolean e(fw fwVar) {
        InterceptResult invokeL;
        List<BdRunnable> e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fwVar)) == null) {
            if (fwVar != null && (e = fwVar.e()) != null) {
                for (int i = 0; i < e.size(); i++) {
                    BdRunnable bdRunnable = e.get(i);
                    if (bdRunnable != null && !bdRunnable.d()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(BdRunnable bdRunnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdRunnable) == null) && bdRunnable != null) {
            if (bdRunnable instanceof fw) {
                if (e((fw) bdRunnable)) {
                    this.a.submit(bdRunnable);
                    return;
                } else {
                    this.c.obtainMessage(1, bdRunnable).sendToTarget();
                    return;
                }
            }
            try {
                this.a.submit(bdRunnable);
            } catch (Error e) {
                bdRunnable.b(e);
            } catch (Exception e2) {
                bdRunnable.a(e2);
            }
        }
    }
}
