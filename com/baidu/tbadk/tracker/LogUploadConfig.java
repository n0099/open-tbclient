package com.baidu.tbadk.tracker;

import androidx.annotation.Keep;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.lra;
import com.baidu.tieba.pf5;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
@Service
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/tbadk/tracker/LogUploadConfig;", "Lcom/baidu/tbadk/coreExtra/parser/WlConfigParseInject;", "()V", "parseJson", "", "json", "Lorg/json/JSONObject;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogUploadConfig implements pf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LogUploadConfig() {
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

    @Override // com.baidu.tieba.pf5
    public void parseJson(JSONObject json) {
        boolean z;
        Map<String, Object> map;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject optJSONObject = json.optJSONObject("client_up_log_conf");
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("frequency_min");
                    if (optInt > 0) {
                        Tracker.i.a().s(optInt);
                    }
                    Tracker a = Tracker.i.a();
                    if (optJSONObject.optInt("global", 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.r(z);
                    lra.a.b(optJSONObject.optInt("errlog_switch", 1));
                    JSONArray optJSONArray = optJSONObject.optJSONArray("page");
                    if (optJSONArray != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"page\")");
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null && (jSONObject = jSONObject2.toString()) != null) {
                                Intrinsics.checkNotNullExpressionValue(jSONObject, "toString()");
                                map = DataExt.toMap(jSONObject);
                            } else {
                                map = null;
                            }
                            if (map != null) {
                                for (Map.Entry<String, Object> entry : map.entrySet()) {
                                    String key = entry.getKey();
                                    Object value = entry.getValue();
                                    if (Intrinsics.areEqual(value, "0")) {
                                        Tracker.i.a().i().add(key);
                                    } else if (Intrinsics.areEqual(value, "1")) {
                                        Tracker.i.a().j().add(key);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
