package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbGoodsInfo;
/* loaded from: classes5.dex */
public class b6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbGoodsInfo pbGoodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbGoodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "goods_title", pbGoodsInfo.goods_title);
            ltc.a(jSONObject, "goods_image", pbGoodsInfo.goods_image);
            ltc.a(jSONObject, "goods_price", pbGoodsInfo.goods_price);
            ltc.a(jSONObject, "goods_url", pbGoodsInfo.goods_url);
            ltc.a(jSONObject, QuickPersistConfigConst.KEY_SPLASH_SORT, pbGoodsInfo.sort);
            ltc.a(jSONObject, "goods_from", pbGoodsInfo.goods_from);
            ltc.a(jSONObject, "goods_url_h5", pbGoodsInfo.goods_url_h5);
            ltc.a(jSONObject, "goods_id", pbGoodsInfo.goods_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
