package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes6.dex */
public class h2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarTaskInfo starTaskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starTaskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "task_title", starTaskInfo.task_title);
            ktc.a(jSONObject, "task_desc", starTaskInfo.task_desc);
            ktc.a(jSONObject, "task_score_desc", starTaskInfo.task_score_desc);
            ktc.a(jSONObject, "task_status", starTaskInfo.task_status);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
