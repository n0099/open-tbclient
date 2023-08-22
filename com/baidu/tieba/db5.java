package com.baidu.tieba;

import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes5.dex */
public class db5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public CardLinkInfoData j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947698802, "Lcom/baidu/tieba/db5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947698802, "Lcom/baidu/tieba/db5;");
        }
    }

    public db5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, urlParserResIdl) == null) && urlParserResIdl != null && (dataRes = urlParserResIdl.data) != null) {
            this.a = dataRes.status.intValue();
            this.b = urlParserResIdl.data.url_type.intValue();
            DataRes dataRes2 = urlParserResIdl.data;
            this.d = dataRes2.image;
            this.e = dataRes2.title;
            this.f = dataRes2.link_from;
            this.g = dataRes2.price_txt;
            boolean z = true;
            if (dataRes2.is_recognize.intValue() != 1) {
                z = false;
            }
            this.h = z;
            this.i = urlParserResIdl.data.description;
            CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
            cardLinkInfoData.parse(urlParserResIdl.data.card_link_info);
            this.j = cardLinkInfoData;
        }
    }
}
