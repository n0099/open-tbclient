package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedPicComponent;
import tbclient.PicInfo;
/* loaded from: classes3.dex */
public final class b07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final tx6 a(List<PicInfo> picInfoList, String schema, uy6 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            ly6 ly6Var = new ly6();
            ArrayList arrayList = new ArrayList();
            for (PicInfo picInfo : picInfoList) {
                iz6 iz6Var = new iz6();
                iz6Var.a = picInfo.small_pic_url;
                Integer num = picInfo.width;
                Intrinsics.checkNotNullExpressionValue(num, "component.width");
                iz6Var.b = num.intValue();
                Integer num2 = picInfo.height;
                Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                iz6Var.c = num2.intValue();
                Double d = picInfo.crop_point_width_ratio;
                Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                iz6Var.d = d.doubleValue();
                Double d2 = picInfo.crop_point_height_ratio;
                Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                iz6Var.e = d2.doubleValue();
                arrayList.add(iz6Var);
            }
            ly6Var.a = arrayList;
            return new tx6(ly6Var, schema, vy6.b(feedExtraData, "image_click"), null, 8, null);
        }
        return (tx6) invokeLLL.objValue;
    }

    public static final void b(FeedPicComponent feedPicComponent, List<s17<?>> dataList, uy6 feedExtraData) {
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
            dataList.add(new t17(a(pics, schema, feedExtraData), "pic"));
        }
    }
}
