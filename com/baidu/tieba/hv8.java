package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes6.dex */
public class hv8 extends gw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gw4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/registerInterviewNotice" : (String) invokeV.objValue;
    }

    public hv8() {
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

    @Override // com.baidu.tieba.gw4, com.baidu.tieba.jw4
    public lw4 b(Object obj, HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry<String, String> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            lw4 lw4Var = new lw4();
            if (obj instanceof au8) {
                au8 au8Var = (au8) obj;
                boolean c = au8Var.c();
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(context, AlarmReceiver.class);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.putExtra("uid", TbadkCoreApplication.getCurrentAccount());
                intent.setData(Uri.parse(currentAccount));
                long j = 0;
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                int i = 0;
                while (it.hasNext() && (next = it.next()) != null) {
                    intent.putExtra(next.getKey(), next.getValue());
                    if ("task_id".equals(next.getKey())) {
                        i = Integer.parseInt(next.getValue());
                    } else if ("s_time".equals(next.getKey())) {
                        j = Long.parseLong(next.getValue()) * 1000;
                    }
                }
                StatisticItem statisticItem = new StatisticItem(au8Var.h());
                statisticItem.param("obj_id", "");
                if (c) {
                    statisticItem.param("obj_type", "2");
                    BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f0ad0)).q();
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    if (broadcast != null) {
                        alarmManager.cancel(broadcast);
                        broadcast.cancel();
                    }
                    lw4Var.a = false;
                } else {
                    statisticItem.param("obj_type", "1");
                    BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f0adb)).q();
                    alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
                    lw4Var.a = true;
                }
                TiebaStatic.log(statisticItem);
                au8Var.k(lw4Var.a);
            }
            return lw4Var;
        }
        return (lw4) invokeLLL.objValue;
    }
}
