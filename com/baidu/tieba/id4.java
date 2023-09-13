package com.baidu.tieba;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class id4 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public DatagramSocket b;
    public int c;
    public md4 d;
    public cd4 e;
    public ArrayList<JsFunction> f;
    public ArrayList<JsFunction> g;
    public ArrayList<JsFunction> h;
    public ArrayList<JsFunction> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public id4(JSRuntime jsRuntime) {
        super(jsRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.a = "%s:fail %s";
        this.d = new md4();
        this.e = new cd4();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    public final void F(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ed4Var) != null) || ld4.c.c(this)) {
            return;
        }
        try {
            if (!this.d.a().offer(new dd4(new DatagramPacket(ed4Var.b(), ed4Var.d(), ed4Var.c(), InetAddress.getByName(ed4Var.a()), ed4Var.e()), this))) {
                C("send", "send queue is full");
                return;
            }
            if (!this.d.b()) {
                this.d.c(true);
                this.d.start();
            }
            if (!this.e.a()) {
                this.e.b(true);
                this.e.c(this);
                D();
                this.e.start();
            }
        } catch (Throwable unused) {
        }
    }

    public final void y(DatagramPacket dp) {
        String str;
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dp) == null) {
            Intrinsics.checkNotNullParameter(dp, "dp");
            try {
                byte[] bArr = new byte[dp.getLength()];
                System.arraycopy(dp.getData(), dp.getOffset(), bArr, 0, dp.getLength());
                InetAddress address2 = dp.getAddress();
                if (address2 != null && (address = address2.getAddress()) != null && address.length == 4) {
                    str = "IPv4";
                } else {
                    str = "IPv6";
                }
                Iterator<JsFunction> it = this.f.iterator();
                while (it.hasNext()) {
                    String inetAddress = dp.getAddress().toString();
                    Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                    it.next().call(new gd4(bArr, new hd4(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    x(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            for (int i = 49152; i <= 65535; i++) {
                try {
                    this.b = new DatagramSocket(i);
                    w(i);
                    return i;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (DatagramSocket) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<JsFunction> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void C(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.h.iterator();
            while (it.hasNext()) {
                x(it.next(), method, error);
            }
        }
    }

    public final o32 E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            if (F == null) {
                return new o32();
            }
            return F;
        }
        return (o32) invokeL.objValue;
    }

    @JavascriptInterface
    public final int bind(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != -1 && !ld4.c.d(i)) {
                try {
                    this.b = new DatagramSocket(i);
                    w(i);
                    return i;
                } catch (Throwable unused) {
                    return A();
                }
            }
            return A();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.i.remove(p54.e(o32.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.h.remove(p54.e(o32.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.remove(p54.e(o32.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f.remove(p54.e(o32.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            o32 E = E(jsObject);
            if (E != null) {
                this.i.add(p54.e(E).a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            o32 E = E(jsObject);
            if (E != null) {
                this.h.add(p54.e(E).a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.add(p54.e(o32.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        o32 E;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (!ld4.c.c(this) && (E = E(jsObject)) != null) {
                this.f.add(p54.e(E).a);
            }
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            ld4.c.a(i);
            this.c = i;
        }
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                DatagramSocket datagramSocket = this.b;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.d.c(false);
                this.d.interrupt();
                this.e.b(false);
                this.e.interrupt();
                ld4.c.e(this);
                Iterator<JsFunction> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                C("close", "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            o32 F = o32.F(jsObject);
            ed4 ed4Var = new ed4();
            String C = F.C("address", "");
            Intrinsics.checkNotNullExpressionValue(C, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            ed4Var.f(C);
            String B = F.B("message");
            boolean z2 = false;
            if (B != null && B.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                byte[] buffer = F.s("message").buffer();
                if (buffer != null) {
                    ed4Var.h(F.r("length", buffer.length));
                    ed4Var.i(F.q("offset"));
                    ed4Var.g(buffer);
                }
            } else {
                Charset charset = Charsets.UTF_8;
                if (B != null) {
                    byte[] bytes = B.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    ed4Var.g(bytes);
                    Charset charset2 = Charsets.UTF_8;
                    if (B != null) {
                        byte[] bytes2 = B.getBytes(charset2);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                        ed4Var.h(bytes2.length);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            ed4Var.j(F.r(ClientCookie.PORT_ATTR, -1));
            if (ed4Var.e() == -1) {
                C("send", "port is empty");
                return;
            }
            if (ed4Var.a().length() == 0) {
                z2 = true;
            }
            if (z2) {
                C("send", "address is empty");
            } else {
                F(ed4Var);
            }
        }
    }

    public final void x(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.a, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new fd4(format));
            }
        }
    }
}
