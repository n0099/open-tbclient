package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cq7 extends oa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq7() {
        super(2016004);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ua
    /* renamed from: c */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage)) == null) {
            if (customResponsedMessage == null) {
                return null;
            }
            if (customResponsedMessage instanceof MemoryChangedMessage) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (data != null && data.getCustomGroupType() == -8) {
                    return new MemoryChangedMessage(in7.a(data), memoryChangedMessage.isFromServer(), memoryChangedMessage.getType());
                }
                if (data != null && data.getCustomGroupType() == -7) {
                    return new MemoryChangedMessage(jn7.a(data), memoryChangedMessage.isFromServer(), memoryChangedMessage.getType());
                }
            }
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
