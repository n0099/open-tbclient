package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes6.dex */
public class il9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String a(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            String str = "";
            if (list == null) {
                return "";
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(goodsInfo.lego_card).optJSONObject("ad_common");
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("id");
                        }
                        return str;
                    } catch (JSONException unused) {
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return -1;
            }
            Iterator<GoodsInfo> it = list.iterator();
            while (it.hasNext()) {
                GoodsInfo next = it.next();
                if (next != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(next.lego_card).optJSONObject("ad_common");
                        if (optJSONObject == null) {
                            return -1;
                        }
                        return tg.e(optJSONObject.optString("pos"), -1);
                    } catch (JSONException unused) {
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void c(@NonNull App.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, builder, i) != null) || builder.goods_info == null) {
            return;
        }
        for (int i2 = 0; i2 < builder.goods_info.size(); i2++) {
            GoodsInfo goodsInfo = (GoodsInfo) vo8.d(builder.goods_info, i2);
            if (goodsInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(goodsInfo.lego_card);
                    JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
                    if (optJSONObject != null) {
                        optJSONObject.put("pos", String.valueOf(tg.e(optJSONObject.optString("pos"), 0) + i));
                        GoodsInfo.Builder builder2 = new GoodsInfo.Builder(goodsInfo);
                        builder2.lego_card = jSONObject.toString();
                        builder.goods_info.set(i2, builder2.build(false));
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }
}
