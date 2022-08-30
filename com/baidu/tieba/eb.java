package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class eb extends gb<CustomMessage<?>, CustomMessageTask, ra, CustomResponsedMessage<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x9 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.i = new x9(messageManager);
        this.e = jb.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t9
    /* renamed from: A */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, customMessage, customMessageTask) == null) {
            this.i.f(customMessage, customMessageTask);
        }
    }

    @Override // com.baidu.tieba.t9
    public LinkedList<CustomMessage<?>> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bdUniqueId)) == null) ? this.i.e(i, bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.t9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bdUniqueId) == null) {
            this.i.h(i, bdUniqueId);
        }
    }

    public LinkedList<CustomMessage<?>> w(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdUniqueId)) == null) ? this.i.i(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gb
    /* renamed from: x */
    public CustomMessage<?> m(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, customMessage, customMessageTask)) == null) ? this.a.getController().e(customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.i.j(bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> z(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customMessage, customMessageTask, cls)) == null) ? this.i.k(customMessage, customMessageTask, cls) : (CustomResponsedMessage) invokeLLL.objValue;
    }
}
