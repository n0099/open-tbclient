package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public abstract class ej8 implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public if8 a;
    public int b;

    public ej8(if8 if8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {if8Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = if8Var;
        this.b = i;
    }

    public final LoadHistoryResponsedMessage a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
            loadHistoryResponsedMessage.setError(-18);
            return loadHistoryResponsedMessage;
        }
        return (LoadHistoryResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof LoadHistoryMessage) && this.a != null) {
                LoadHistoryMessage.a data = customMessage.getData();
                LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.b);
                LinkedList<ChatMessage> h = this.a.h(JavaTypesHelper.toLong(data.d, 0L), data.a, data.b, data.c);
                if (h == null) {
                    return a(this.b);
                }
                LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
                if (data.a == null) {
                    aVar.c = true;
                } else {
                    aVar.c = false;
                }
                aVar.a = data.d;
                aVar.b = h;
                try {
                    loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return loadHistoryResponsedMessage;
            }
            return a(this.b);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
