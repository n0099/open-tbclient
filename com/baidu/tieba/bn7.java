package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes3.dex */
public class bn7 implements Cdo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public rm7 a;
    public List<cn7> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947650814, "Lcom/baidu/tieba/bn7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947650814, "Lcom/baidu/tieba/bn7;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public bn7(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        rm7 rm7Var = new rm7();
        this.a = rm7Var;
        rm7Var.e(1);
        this.a.d(vipSpecialList.class_name);
        this.a.f(vipSpecialList.class_url_name);
        this.a.g(vipSpecialList.class_url);
        this.b = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.b.add(new cn7(vipSpecialItem));
        }
    }

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c : (BdUniqueId) invokeV.objValue;
    }
}
