package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dhb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final WriteVoteData b(String str) {
        InterceptResult invokeL;
        int i;
        int i2;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                String title = jSONObject3.optString("title");
                int optInt = jSONObject3.optInt("expire_type");
                int optInt2 = jSONObject3.optInt("is_multi");
                JSONArray optJSONArray = jSONObject3.optJSONArray("options");
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                if (optJSONArray != null) {
                    i = optJSONArray.length();
                } else {
                    i = 0;
                }
                int i3 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i3 >= i) {
                        break;
                    }
                    if (optJSONArray != null && (jSONObject2 = optJSONArray.getJSONObject(i3)) != null) {
                        i2 = jSONObject2.optInt("id");
                    } else {
                        i2 = 0;
                    }
                    if (optJSONArray != null && (jSONObject = optJSONArray.getJSONObject(i3)) != null) {
                        str2 = jSONObject.optString("text");
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str2.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                        writeVoteItemData.setId(i2);
                        writeVoteItemData.setText(str2);
                        arrayList.add(writeVoteItemData);
                    }
                    i3++;
                }
                Intrinsics.checkNotNullExpressionValue(title, "title");
                if (title.length() == 0) {
                    z = true;
                }
                if (z && arrayList.isEmpty()) {
                    return null;
                }
                WriteVoteData writeVoteData = new WriteVoteData();
                writeVoteData.setTitle(title);
                writeVoteData.setExpire_type(optInt);
                writeVoteData.setIs_multi(optInt2);
                writeVoteData.setOptions(arrayList);
                return writeVoteData;
            } catch (Exception e) {
                DefaultLog.getInstance().i("write", "编辑数据异常：" + e);
                return null;
            }
        }
        return (WriteVoteData) invokeL.objValue;
    }
}
