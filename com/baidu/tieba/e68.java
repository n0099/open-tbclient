package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryReadMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryReadMessage;
import com.baidu.tieba.me;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class e68 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e68() {
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

    public static final List<String> a(List<me.b<String>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                for (me.b<String> bVar : list) {
                    String str = bVar.a;
                    if (!TextUtils.isEmpty(str)) {
                        linkedList.add(str);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof RequestSearchPersonHistoryReadMessage)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                yz4.d();
                List<String> a = a(ni.b(yz4.f("tb.searchperson_history", currentAccount)));
                ResponseSearchPersonHistoryReadMessage responseSearchPersonHistoryReadMessage = new ResponseSearchPersonHistoryReadMessage();
                responseSearchPersonHistoryReadMessage.datas.addAll(a);
                return responseSearchPersonHistoryReadMessage;
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
