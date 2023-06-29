package com.baidu.tieba;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ActivityPage.ActivityPageReqIdl;
import tbclient.ActivityPage.DataReq;
/* loaded from: classes5.dex */
public class ev7 implements zu5<ActivityPageReqIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final tu5 b;

    @Override // com.baidu.tieba.zu5
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
        }
    }

    public ev7(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new tu5(false);
        this.a = str2;
    }

    @Override // com.baidu.tieba.zu5
    public tu5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (tu5) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zu5
    /* renamed from: d */
    public ActivityPageReqIdl b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.activity_name = this.a;
                builder.pn = Integer.valueOf(this.b.c);
                builder.rn = 20;
                builder.scr_h = Integer.valueOf(xi.j(TbadkCoreApplication.getInst()));
                builder.scr_w = Integer.valueOf(xi.l(TbadkCoreApplication.getInst()));
                builder.scr_dip = Integer.valueOf((int) xi.i(TbadkCoreApplication.getInst()));
                builder.q_type = Integer.valueOf(r05.c().e());
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    gx5.a(builder, true);
                }
                ActivityPageReqIdl.Builder builder2 = new ActivityPageReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ActivityPageReqIdl) invokeZ.objValue;
    }
}
