package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bf9 implements yn {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    public String f;
    public String g;
    public boolean h;
    public List<String> i;
    public b35 j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643188, "Lcom/baidu/tieba/bf9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643188, "Lcom/baidu/tieba/bf9;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return k;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public bf9(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        if (forumData == null) {
            return;
        }
        this.a = forumData.getName();
        this.b = forumData.getImage_url();
        this.c = forumData.getPost_num();
        this.d = forumData.getMember_num();
        this.f = forumData.getId();
        this.h = forumData.isLike() == 1;
        this.j = forumData.getForumShowInfo();
    }

    public bf9(v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v45Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = false;
        if (v45Var == null) {
            return;
        }
        this.a = v45Var.b;
        this.b = v45Var.c;
        this.c = v45Var.j;
        this.d = v45Var.k;
        this.f = v45Var.a;
        this.h = v45Var.f();
        this.i = v45Var.h();
        this.j = v45Var.e();
    }
}
