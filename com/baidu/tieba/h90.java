package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.r80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h90 extends e90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r80.d b;

    @Override // com.baidu.tieba.g90.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://httpsdns.baidu.com/v6/0025" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g90.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e90, com.baidu.tieba.g90.b
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    public h90(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = context;
    }

    public void a(r80.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.b = dVar;
        }
    }

    @Override // com.baidu.tieba.g90.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Host", DnsTransmitter.IDC_HOST);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g90.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ("type=ipv4,ipv6&dn=" + v80.V(this.a).C).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g90.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            l90.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
            r80.f(true);
            r80.c(this.a).b(v80.V(this.a).C, this.b);
        }
    }

    @Override // com.baidu.tieba.g90.d
    public void onSuccess(byte[] bArr) {
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            String str = new String(bArr);
            l90.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + v80.V(this.a).C + " is " + str);
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(v80.V(this.a).C);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                if (optJSONArray2 == null) {
                    length = 0;
                } else {
                    length = optJSONArray2.length();
                }
                if (optJSONArray == null) {
                    length2 = 0;
                } else {
                    length2 = optJSONArray.length();
                }
                if (length2 + length > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && length2 > 0) {
                        arrayList.add(optJSONArray.getString(0));
                    }
                    if (optJSONArray2 != null && length > 0) {
                        arrayList.add(optJSONArray2.getString(0));
                    }
                    r80.j(arrayList);
                    if (this.b != null && r80.c.size() > 0) {
                        this.b.a(0, DnsModel.MSG_OK, r80.c.get(0));
                        if (r80.c.size() > 1) {
                            r80.d++;
                            return;
                        }
                        return;
                    }
                    return;
                }
                l90.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
                r80.f(true);
                r80.c(this.a).b(v80.V(this.a).C, this.b);
            } catch (Exception e) {
                l90.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e.getMessage());
                r80.f(true);
                r80.c(this.a).b(v80.V(this.a).C, this.b);
            }
        }
    }
}
