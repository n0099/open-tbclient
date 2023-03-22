package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ed3<ResultDataT> extends qc3<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> g;
    public String h;
    public JSONObject i;
    public boolean j;
    public boolean k;
    public String l;

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401 : invokeI.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public abstract HttpRequest w(ed3 ed3Var);

    public abstract SwanInterfaceType z();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed3 a;

        public a(ed3 ed3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (qc3.f) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                this.a.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ ed3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(ed3 ed3Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed3Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ed3Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.b.E()) {
                    this.b.N(this.a);
                } else {
                    this.b.H(this.a, exc);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;
        public final /* synthetic */ ed3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(ed3 ed3Var, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed3Var, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ed3Var;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                t42.i("OAuthRequest", "retryRequest fail: ");
                this.b.H(this.a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                t42.i("OAuthRequest", "retryRequest success: ");
                this.b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements fo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ed3 b;

        public d(ed3 ed3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ed3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.fo1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.b.p();
                    this.b.call();
                    return;
                }
                this.b.C(null, this.a);
            }
        }
    }

    public ed3() {
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
        this.g = new HashMap();
    }

    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (Map) invokeV.objValue;
    }

    public final void D() {
        HttpRequest w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (w = w(this)) == null) {
            return;
        }
        w.executeAsync(new b(this, w));
        ye3.a(z());
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public t73 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            t73 M = t73.M();
            if (M == null) {
                if (!qc3.f) {
                    return s73.K().q();
                }
                throw new IllegalStateException("null SwanApp");
            }
            return M;
        }
        return (t73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qc3
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "OAuthRequest-onExec", 2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.k = true;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j = true;
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            M().N().f(gt2.U().getActivity(), null, new d(this, str));
        }
    }

    @Override // com.baidu.tieba.qc3
    public qc3<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = "loginApi";
            } else {
                this.l = str;
            }
            super.q(str);
            return this;
        }
        return (qc3) invokeL.objValue;
    }

    public ed3<ResultDataT> v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            this.g.put(str, str2);
            return this;
        }
        return (ed3) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void C(Response response, String str) {
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, response, str) == null) {
            this.h = str;
            try {
                JSONObject jSONObject = new JSONObject(this.h);
                this.i = jSONObject;
                optInt = jSONObject.optInt("errno");
            } catch (OAuthException e) {
                G(e.mErrorCode, str, response);
                d(e);
            } catch (Exception e2) {
                rc3.k(e2.toString(), Boolean.TRUE);
                L(str, e2);
                G(2103, str, response);
                d(new OAuthException(10005));
                me3.r(10005, null);
            }
            if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
                this.j = false;
                this.k = false;
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                }
                O(str);
            } else if (F(optInt)) {
                if (SwanAppAllianceLoginHelper.d.f()) {
                    SwanAppAllianceLoginHelper.d.b();
                    O(str);
                } else if (!qc3.f) {
                } else {
                    throw new RuntimeException("is not AllianceLogin, error number");
                }
            } else {
                if (response != null && optInt != 0) {
                    G(optInt, str, response);
                }
                r(m(this.i));
                I();
                c();
            }
        }
    }

    public final void G(int i, String str, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, str, response) == null) {
            ye3.c(z(), i, str, response);
        }
    }

    public void H(HttpRequest httpRequest, Exception exc) {
        String httpUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, httpRequest, exc) == null) {
            rc3.k(exc.toString(), Boolean.FALSE);
            if (httpRequest.getOkRequest() == null) {
                httpUrl = null;
            } else {
                httpUrl = httpRequest.getOkRequest().url().toString();
            }
            ye3.b(z(), 2101, httpUrl, null, exc.getMessage());
            d(new OAuthException(10002));
        }
    }

    public final void J(Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, response) == null) {
            if (!response.isSuccessful()) {
                rc3.k("bad response", Boolean.TRUE);
                G(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, null);
                d(new OAuthException(10002));
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                rc3.k("empty response body", Boolean.TRUE);
                G(2103, null, null);
                d(new OAuthException(10001));
                return;
            }
            try {
                C(response, body.string());
            } catch (IOException e) {
                if (qc3.f) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void L(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, exc) == null) {
            if (this.i == null) {
                rc3.t("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
                return;
            }
            rc3.t("OAuthRequest", "ex: " + exc.toString());
        }
    }

    public void N(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, httpRequest) == null) {
            t42.i("OAuthRequest", "retryRequest: " + httpRequest.toString());
            K();
            httpRequest.executeAsync(new c(this, httpRequest));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            wc3<ResultDataT> wc3Var = this.a;
            return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), e(), Integer.valueOf(this.a.b()), this.h, this.i, wc3Var.a, wc3Var.a());
        }
        return (String) invokeV.objValue;
    }
}
