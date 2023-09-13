package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class hb extends gb<SocketMessage, SocketMessageTask, cb, SocketResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ia i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(MessageManager messageManager) {
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
        this.i = new ia(messageManager);
        this.e = lb.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x9
    /* renamed from: A */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, socketMessage, socketMessageTask) == null) {
            this.i.f(socketMessage, socketMessageTask);
        }
    }

    @Override // com.baidu.tieba.x9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bdUniqueId)) == null) {
            return this.i.e(i, bdUniqueId);
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.x9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bdUniqueId) == null) {
            this.i.h(i, bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gb
    /* renamed from: y */
    public SocketMessage m(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, socketMessage, socketMessageTask)) == null) {
            return this.a.getController().k(socketMessage, socketMessageTask);
        }
        return (SocketMessage) invokeLL.objValue;
    }

    public ia x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (ia) invokeV.objValue;
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.i.B(bdUniqueId);
        }
    }
}
