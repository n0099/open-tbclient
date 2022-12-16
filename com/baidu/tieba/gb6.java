package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class gb6 extends pb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public za6 a;
    public SparseArray<String> b;
    public HashMap<String, String> c;
    public Gson d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb6(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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
        this.d = new Gson();
        a();
    }

    public final void a() {
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new SparseArray<>();
            ArrayList<HttpMessageTask> findHttpTasks = MessageManager.getInstance().findHttpTasks();
            if (ListUtils.isEmpty(findHttpTasks)) {
                return;
            }
            for (int i = 0; i < findHttpTasks.size(); i++) {
                String url = findHttpTasks.get(i).getUrl();
                if (!xi.isEmpty(url) && url.contains("?")) {
                    String[] split = url.split("[?]");
                    String str = split[1];
                    String str2 = split[0];
                    if (!xi.isEmpty(str) && str.contains("=") && (e = xg.e(str.split("[=]")[1], 0)) != 0) {
                        this.b.put(e, str2.replace(TbConfig.SERVER_ADDRESS, ""));
                    }
                }
            }
        }
    }

    public void b(za6 za6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, za6Var) == null) {
            this.a = za6Var;
        }
    }

    public void c(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            this.c = hashMap;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // com.baidu.tieba.kb
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        process2(socketMessage2, socketMessageTask);
        return socketMessage2;
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public SocketMessage process2(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, socketMessage, socketMessageTask)) == null) {
            String str = this.b.get(socketMessage.getCmd());
            if (str == null) {
                return socketMessage;
            }
            HashMap<String, String> hashMap = this.c;
            if (hashMap != null && hashMap.get(str) != null && this.a != null) {
                this.a.a(str, this.d.toJson(this.c.get(str)), this.d.toJson(this.d.toJson(socketMessage.getData())));
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }
}
