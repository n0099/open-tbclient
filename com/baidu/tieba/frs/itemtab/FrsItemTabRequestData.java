package com.baidu.tieba.frs.itemtab;

import b.a.e.e.p.l;
import b.a.q0.d1.z;
import b.a.q0.k0.b.g;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ItemPage.DataReq;
import tbclient.ItemPage.ItemPageReqIdl;
/* loaded from: classes9.dex */
public class FrsItemTabRequestData extends OrmObject implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int itemId;

    public FrsItemTabRequestData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.q0.k0.b.i
    public Object e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.item_id = Integer.valueOf(this.itemId);
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) l.h(TbadkCoreApplication.getInst()));
            z.c(builder, true, false, true);
            ItemPageReqIdl.Builder builder2 = new ItemPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    @Override // b.a.q0.k0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // b.a.q0.k0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }
}
