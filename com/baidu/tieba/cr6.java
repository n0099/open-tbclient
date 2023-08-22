package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import androidx.core.util.Pair;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.y47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cr6 implements y47.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cr6() {
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

    @Override // com.baidu.tieba.y47.o
    public SpannableString a(Context context, a77 businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            ThreadData threadData = new ThreadData();
            String str = businessInfo.a().get("tiebaplus_ad");
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    threadData.tiePlusAdSource = jSONObject.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
                    threadData.tiePlusShowUrl = jSONObject.optString("show_url");
                    threadData.tiePlusCostUrl = jSONObject.optString("cost_url");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            threadData.tiePlusMonitorShowUrl = businessInfo.a().get("exposure_monitor_url");
            threadData.tiePlusMonitorClickUrl = businessInfo.a().get("click_monitor_url");
            String str2 = businessInfo.a().get("works_info");
            if (str2 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                worksInfoData.parseJson(new JSONObject(str2));
                threadData.worksInfoData = worksInfoData;
            }
            threadData.threadType = JavaTypesHelper.toInt(businessInfo.a().get("thread_type"), 0);
            threadData.isTiebaPlusAdThread = Intrinsics.areEqual(businessInfo.a().get("is_tiebaplus_ad"), "1");
            threadData.tiebaPlusOrderId = businessInfo.a().get("tiebaplus_order_id");
            threadData.tiebaPlusToken = businessInfo.a().get("tiebaplus_token");
            threadData.tiebaPlusExtraParam = businessInfo.a().get("tiebaplus_extra_param");
            threadData.tiebaplusCantDelete = Intrinsics.areEqual(businessInfo.a().get("tiebaplus_cant_delete"), "1");
            Pair<CharSequence, o16> r = g16.r(35, threadData, br6.a(businessInfo));
            if (r != null) {
                CharSequence charSequence = r.first;
                if (charSequence instanceof SpannableString) {
                    if (charSequence != null) {
                        return (SpannableString) charSequence;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
                }
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeLL.objValue;
    }
}
