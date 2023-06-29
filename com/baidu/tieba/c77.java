package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedPicComponent;
import tbclient.PicInfo;
/* loaded from: classes5.dex */
public final class c77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final u47 a(List<PicInfo> picInfoList, String schema, v57 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            m57 m57Var = new m57();
            ArrayList arrayList = new ArrayList();
            for (PicInfo picInfo : picInfoList) {
                j67 j67Var = new j67();
                j67Var.a = picInfo.small_pic_url;
                Integer num = picInfo.width;
                Intrinsics.checkNotNullExpressionValue(num, "component.width");
                j67Var.b = num.intValue();
                Integer num2 = picInfo.height;
                Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                j67Var.c = num2.intValue();
                Double d = picInfo.crop_point_width_ratio;
                Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                j67Var.d = d.doubleValue();
                Double d2 = picInfo.crop_point_height_ratio;
                Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                j67Var.e = d2.doubleValue();
                arrayList.add(j67Var);
            }
            m57Var.a = arrayList;
            return new u47(m57Var, schema, w57.b(feedExtraData, "image_click"), null, 8, null);
        }
        return (u47) invokeLLL.objValue;
    }

    public static final void b(FeedPicComponent feedPicComponent, List<t87<?>> dataList, v57 feedExtraData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, feedPicComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedPicComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<PicInfo> list = feedPicComponent.pics;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            List<PicInfo> pics = feedPicComponent.pics;
            Intrinsics.checkNotNullExpressionValue(pics, "pics");
            String schema = feedPicComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            dataList.add(new u87(a(pics, schema, feedExtraData), "pic"));
        }
    }
}
