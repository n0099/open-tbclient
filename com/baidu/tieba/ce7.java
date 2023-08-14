package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class ce7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ym> a;
    public List<RecommendForumInfo> b;
    public Page c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    public ce7() {
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
        this.a = new ArrayList();
        this.d = true;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public List<ym> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void b(iy6 iy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy6Var) == null) {
            String str = iy6Var.d;
            this.c = iy6Var.c;
            List<RecommendForumInfo> list = iy6Var.a;
            this.b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.b) {
                    be7 be7Var = new be7();
                    be7Var.i(recommendForumInfo);
                    this.a.add(be7Var);
                }
            }
            Page page = this.c;
            if (page != null) {
                boolean z = true;
                if (page.has_more.intValue() != 1) {
                    z = false;
                }
                this.d = z;
                this.e = this.c.current_page.intValue();
            }
        }
    }
}
