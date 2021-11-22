package com.baidu.tieba.ala;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class LiveRoomClosedQueryMessage extends CustomMessage<List<Object>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> mIds;
    public List<Object> mOriginData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomClosedQueryMessage(List<Long> list, List<Object> list2) {
        super(2921025);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOriginData = new ArrayList();
        this.mIds = new ArrayList();
        if (ListUtils.isEmpty(list2) || ListUtils.isEmpty(list)) {
            return;
        }
        this.mOriginData.addAll(list2);
        this.mIds.addAll(list);
    }

    public List<Long> getIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIds : (List) invokeV.objValue;
    }

    public List<Object> getOriginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOriginData : (List) invokeV.objValue;
    }
}
