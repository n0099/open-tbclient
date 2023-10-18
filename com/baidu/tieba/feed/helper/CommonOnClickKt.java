package com.baidu.tieba.feed.helper;

import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.feed.widget.FeedBackReasonView;
import com.baidu.tieba.m37;
import com.baidu.tieba.n37;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\"#\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\"#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0017"}, d2 = {"DefaultOnClick", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "getDefaultOnClick", "()Lkotlin/jvm/functions/Function2;", "FeedBackOnClick", "Lcom/baidu/tieba/feed/data/FeedFeedbackData;", "Landroid/view/View;", "getFeedBackOnClick", "SchemaOnClick", "getSchemaOnClick", "getSelectedResultJsonObj", "Lorg/json/JSONObject;", "businessData", "Lcom/baidu/tieba/feed/data/FeedFeedbackPostData;", "selectedIds", "", "", "reasons", "", "Lcom/baidu/tieba/feed/widget/FeedBackReasonView$Reason;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommonOnClickKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<View, String, Unit> a;
    public static final Function2<m37, View, Unit> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868114862, "Lcom/baidu/tieba/feed/helper/CommonOnClickKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868114862, "Lcom/baidu/tieba/feed/helper/CommonOnClickKt;");
                return;
            }
        }
        a = CommonOnClickKt$SchemaOnClick$1.INSTANCE;
        CommonOnClickKt$DefaultOnClick$1 commonOnClickKt$DefaultOnClick$1 = CommonOnClickKt$DefaultOnClick$1.INSTANCE;
        b = CommonOnClickKt$FeedBackOnClick$1.INSTANCE;
    }

    public static final Function2<m37, View, Unit> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (Function2) invokeV.objValue;
    }

    public static final Function2<View, String, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (Function2) invokeV.objValue;
    }

    public static final JSONObject c(n37 businessData, List<Integer> selectedIds, List<? extends FeedBackReasonView.b> reasons) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, businessData, selectedIds, reasons)) == null) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
            Intrinsics.checkNotNullParameter(reasons, "reasons");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(reasons)) {
                for (FeedBackReasonView.b bVar : reasons) {
                    if (bVar != null) {
                        selectedIds.add(Integer.valueOf(bVar.a));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(bVar.a));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(bVar.c);
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", businessData.h());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", businessData.d());
                jSONObject.put("click_time", System.currentTimeMillis());
                jSONObject.put("extra", sb2.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
