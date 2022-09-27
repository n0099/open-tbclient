package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d94 extends f94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d94(@NonNull Context context) {
        super(BaiduMap.e, context.getString(R.string.obfuscated_res_0x7f0f0d19), "com.baidu.BaiduMap");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
    }

    @Override // com.baidu.tieba.f94
    public void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048576, this, context, latLng, latLng2, str, str2) == null) || latLng == null || latLng2 == null) {
            return;
        }
        Intent intent = new Intent();
        Uri.Builder buildUpon = Uri.parse("baidumap://map/direction?").buildUpon();
        buildUpon.appendQueryParameter("origin", "name:" + str + "|latlng:" + latLng.latitude + "," + latLng.longitude);
        buildUpon.appendQueryParameter("destination", "name:" + str2 + "|latlng:" + latLng2.latitude + "," + latLng2.longitude);
        buildUpon.appendQueryParameter("mode", "driving");
        buildUpon.appendQueryParameter("target", "1");
        buildUpon.appendQueryParameter("src", context.getPackageName());
        intent.setData(buildUpon.build());
        context.startActivity(intent);
    }
}
