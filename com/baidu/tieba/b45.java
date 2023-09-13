package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes5.dex */
public class b45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z25 a;
    public List<l15> b;
    public List<m15> c;
    public List<y25> d;

    public b45() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(SeniorLottery seniorLottery) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, seniorLottery) != null) || seniorLottery == null) {
            return;
        }
        z25 z25Var = new z25();
        this.a = z25Var;
        z25Var.a(seniorLottery.theme);
        this.b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            l15 l15Var = new l15();
            l15Var.a(seniorLottery.award_info.get(i));
            this.b.add(l15Var);
        }
        String str = seniorLottery.myaward;
        this.c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            m15 m15Var = new m15();
            m15Var.a(seniorLottery.luck_users.get(i2));
            this.c.add(m15Var);
        }
        String str2 = seniorLottery.act_desc;
        this.d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            y25 y25Var = new y25();
            y25Var.a(seniorLottery.act_regular.get(i3));
            this.d.add(y25Var);
        }
    }
}
