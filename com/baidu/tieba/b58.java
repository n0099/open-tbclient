package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AutoPayInfo;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipInfo;
import tbclient.GetVipInfo.VipUpgrade;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes3.dex */
public class b58 implements Cdo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947596068, "Lcom/baidu/tieba/b58;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947596068, "Lcom/baidu/tieba/b58;");
                return;
            }
        }
        a = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public b58(DataRes dataRes) {
        VipUser vipUser;
        VipUpgrade vipUpgrade;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (dataRes != null && (vipUser = dataRes.user) != null && (vipUpgrade = dataRes.upgrade) != null) {
            String str = vipUser.card_id;
            String str2 = vipUser.total_scores_link;
            String str3 = vipUser.speed_link;
            String str4 = vipUser.task_scores_link;
            vipUser.task_scores.intValue();
            String str5 = vipUser.name;
            vipUser.id.longValue();
            String str6 = vipUser.portrait;
            String str7 = vipUser.name_show;
            String str8 = vipUser.vip_link;
            VipInfo vipInfo = vipUser.vipInfo;
            if (vipInfo != null) {
                String str9 = vipInfo.icon_url;
                vipInfo.s_time.intValue();
                vipUser.vipInfo.e_time.intValue();
                vipUser.now_time.intValue();
                vipUser.vipInfo.v_status.intValue();
                vipUser.vipInfo.v_level.intValue();
                vipUser.vipInfo.ext_score.intValue();
                vipUser.vipInfo.a_score.intValue();
                vipUser.vipInfo.n_score.intValue();
            }
            dataRes.today_get_score.intValue();
            dataRes.today_unget_score.intValue();
            vipUpgrade.normal.intValue();
            vipUpgrade.pay.intValue();
            AutoPayInfo autoPayInfo = dataRes.autopay_info;
        }
    }
}
