package com.baidu.tieba.frs.itemtab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ItemPage.DataReq;
import tbclient.ItemPage.ItemPageReqIdl;
/* loaded from: classes6.dex */
public class FrsItemTabRequestData extends OrmObject implements INetRequestData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int itemId;

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, String> getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, Object> makeHttpParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public FrsItemTabRequestData() {
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

    @Override // com.baidu.tbadk.mvc.data.ISocketProtobufRequestData
    public Object encodeSocketRequestData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.item_id = Integer.valueOf(this.itemId);
            builder.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            ItemPageReqIdl.Builder builder2 = new ItemPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
