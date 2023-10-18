package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedPicComponent;
import tbclient.PicDecoration;
import tbclient.PicInfo;
/* loaded from: classes6.dex */
public final class i57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<i47> a(List<PicDecoration> decorationComponentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, decorationComponentList)) == null) {
            Intrinsics.checkNotNullParameter(decorationComponentList, "decorationComponentList");
            ArrayList arrayList = new ArrayList();
            for (PicDecoration picDecoration : decorationComponentList) {
                HashMap<String, String> a = m67.a.a(picDecoration.decoration_info);
                String str = picDecoration.name;
                Intrinsics.checkNotNullExpressionValue(str, "decorationComponent.name");
                String str2 = picDecoration.location;
                Intrinsics.checkNotNullExpressionValue(str2, "decorationComponent.location");
                arrayList.add(new i47(str, str2, a));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static final z17 b(List<PicInfo> picInfoList, String schema, k37 feedExtraData) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, picInfoList, schema, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(picInfoList, "picInfoList");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            z27 z27Var = new z27();
            ArrayList arrayList = new ArrayList();
            for (PicInfo picInfo : picInfoList) {
                h47 h47Var = new h47();
                h47Var.a = picInfo.small_pic_url;
                Integer num = picInfo.width;
                Intrinsics.checkNotNullExpressionValue(num, "component.width");
                h47Var.b = num.intValue();
                Integer num2 = picInfo.height;
                Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                h47Var.c = num2.intValue();
                Double d = picInfo.crop_point_width_ratio;
                Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                h47Var.e = d.doubleValue();
                Double d2 = picInfo.crop_point_height_ratio;
                Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                h47Var.f = d2.doubleValue();
                Integer num3 = picInfo.is_long_pic;
                if (num3 != null && num3.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                h47Var.d = z;
                h47Var.g = picInfo.scheme;
                List<PicDecoration> list = picInfo.decoration;
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    List<PicDecoration> list2 = picInfo.decoration;
                    Intrinsics.checkNotNullExpressionValue(list2, "component.decoration");
                    h47Var.h = a(list2);
                }
                h47Var.i.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new n47[]{l37.d(feedExtraData, "image_click", null, 2, null), l37.d(feedExtraData, "image_click2", null, 2, null), l37.d(feedExtraData, "image_click3", null, 2, null), l37.d(feedExtraData, "image_click4", null, 2, null), l37.d(feedExtraData, "image_click5", null, 2, null), l37.c(feedExtraData, "image_click_selector1", l37.a(feedExtraData, MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pic_type", picInfo.pic_type))))}));
                arrayList.add(h47Var);
            }
            z27Var.a = arrayList;
            return new z17(z27Var, schema, null, 4, null);
        }
        return (z17) invokeLLL.objValue;
    }

    public static final void c(FeedPicComponent feedPicComponent, List<h77<?>> dataList, k37 feedExtraData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, feedPicComponent, dataList, feedExtraData) == null) {
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
            dataList.add(new i77(b(pics, schema, feedExtraData), "pic"));
        }
    }
}
