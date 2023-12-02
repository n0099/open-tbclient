package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class fh9 extends jq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jq4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/checkInterviewNoticeStatus" : (String) invokeV.objValue;
    }

    public fh9() {
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

    @Override // com.baidu.tieba.jq4, com.baidu.tieba.mq4
    public oq4 b(Object obj, HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry<String, String> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context baseContext = TbadkCoreApplication.getInst().getBaseContext();
            oq4 oq4Var = new oq4();
            if (obj instanceof ag9) {
                ag9 ag9Var = (ag9) obj;
                Intent intent = new Intent(baseContext, AlarmReceiver.class);
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                boolean z = false;
                int i = 0;
                while (it.hasNext() && (next = it.next()) != null) {
                    intent.putExtra(next.getKey(), next.getValue());
                    if ("task_id".equals(next.getKey())) {
                        i = Integer.parseInt(next.getValue());
                    }
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.setData(Uri.parse(currentAccount));
                if (PendingIntent.getBroadcast(baseContext, i, intent, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != null) {
                    z = true;
                }
                oq4Var.a = z;
                ag9Var.l(true);
                ag9Var.k(oq4Var.a);
            }
            return oq4Var;
        }
        return (oq4) invokeLLL.objValue;
    }
}
