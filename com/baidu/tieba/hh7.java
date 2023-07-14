package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class hh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchForum a;
    public List<SearchForum> b;
    public ArrayList<yn> c;
    public String d;

    public hh7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    public ArrayList<yn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.a = dataRes.exact_match;
        this.b = dataRes.fuzzy_match;
        this.c = new ArrayList<>();
        gh7 gh7Var = new gh7(this.d);
        SearchForum searchForum = this.a;
        if (searchForum != null) {
            gh7Var.k(searchForum);
            this.c.add(gh7Var);
        }
        List<SearchForum> list = this.b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                gh7 gh7Var2 = new gh7(this.d);
                gh7Var2.k(searchForum2);
                this.c.add(gh7Var2);
            }
        }
    }
}
