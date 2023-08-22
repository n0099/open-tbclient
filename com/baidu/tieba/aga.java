package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class aga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MetaData a;
    public List<AbstractData> b;

    public aga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.optString("id");
                MetaData metaData = new MetaData();
                this.a = metaData;
                metaData.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                this.b = new ArrayList();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray.getJSONObject(i));
                        this.b.add(abstractData);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
