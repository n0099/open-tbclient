package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes6.dex */
public class i35 extends tha {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p1;
    public transient /* synthetic */ FieldHolder $fh;
    public String g1;
    public String h1;
    public String i1;
    public String j1;
    public String k1;
    public String l1;
    public List<String> m1;
    public String n1;
    public String o1;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802590, "Lcom/baidu/tieba/i35;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802590, "Lcom/baidu/tieba/i35;");
                return;
            }
        }
        p1 = BdUniqueId.gen();
    }

    public i35() {
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

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.j1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tha, com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return p1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void E1(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recommendBook) != null) || recommendBook == null) {
            return;
        }
        this.g1 = recommendBook.recommend_text;
        this.h1 = recommendBook.suggest_text;
        this.i1 = recommendBook.suggest_url;
        this.j1 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.k1 = recommendBook.book_cover;
        this.l1 = recommendBook.book_title;
        this.m1 = recommendBook.book_tips;
        this.n1 = recommendBook.botton_text;
        this.o1 = recommendBook.subscript_icon;
    }
}
