package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ck7 implements y35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck7() {
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

    @Override // com.baidu.tieba.y35
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("dialogName", "frsShield");
            hashMap.putAll(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.y35
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            boolean z4 = false;
            if (!LooperBlockSwitch.getIsOn()) {
                return false;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (!(currentActivity instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "吧内屏蔽弹窗策略校验失败：当前Activity非FrsActivity");
                return false;
            }
            FrsFragment v1 = ((FrsActivity) currentActivity).v1();
            if (v1 != null && !v1.i4() && TbSingleton.getInstance().getFrsResponseData() != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                zk8 yunDialogLog = YunDialogLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("吧内屏蔽弹窗策略校验失败：FrsFragment为空->");
                if (v1 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb.append(z2);
                sb.append("|");
                sb.append("Frs是否展示过弹窗->");
                if (v1 != null && v1.i4()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                sb.append(z3);
                sb.append("|");
                sb.append("是否存在FRS数据->");
                if (TbSingleton.getInstance().getFrsResponseData() != null) {
                    z4 = true;
                }
                sb.append(z4);
                yunDialogLog.b("YunDialogManager", sb.toString());
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
