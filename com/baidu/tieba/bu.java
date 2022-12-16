package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class bu extends tt<TaskResponseData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vt a;

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "response" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(vt vtVar) {
        super(vtVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vtVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vt) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tt
    /* renamed from: c */
    public TaskResponseData a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                jSONObject = new JSONObject(str);
                optInt = jSONObject.optInt(TaskResponseData.keyUiType);
            } catch (Exception e) {
                e = e;
            }
            try {
                tt a = this.a.a(TaskUIData.key);
                String optString = jSONObject.optString(TaskUIData.key);
                Intrinsics.checkExpressionValueIsNotNull(optString, "responseObj.optString(TaskUIData.key)");
                TaskUIData taskUIData = (TaskUIData) a.a(optString);
                if (taskUIData == null) {
                    taskUIData = new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("progress");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                int optInt2 = optJSONObject.optInt("total");
                int optInt3 = optJSONObject.optInt(TaskProcessData.keyComplete);
                boolean optBoolean = optJSONObject.optBoolean("done");
                JSONObject optJSONObject2 = jSONObject.optJSONObject(TaskResponseData.keyNextActive);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                long optLong = optJSONObject2.optLong(NextActive.keyUtil, 0L);
                String taskInfo = optJSONObject2.optString(NextActive.keyTaskInfo, "");
                TaskProcessData taskProcessData = new TaskProcessData(optInt2, optInt3, optBoolean);
                Intrinsics.checkExpressionValueIsNotNull(taskInfo, "taskInfo");
                return new TaskResponseData(optInt, taskProcessData, taskUIData, new NextActive(optLong, taskInfo));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return new TaskResponseData(0, null, null, null, 15, null);
            }
        }
        return (TaskResponseData) invokeL.objValue;
    }
}
