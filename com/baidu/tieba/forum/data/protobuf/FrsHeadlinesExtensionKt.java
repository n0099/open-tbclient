package com.baidu.tieba.forum.data.protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ag7;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.kz4;
import com.baidu.tieba.r67;
import com.baidu.tieba.rb7;
import com.baidu.tieba.sb7;
import com.baidu.tieba.va7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedToutiao;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"insertTemplateList", "", "Ltbclient/FeedToutiao;", "dataList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "feedExtraData", "Lcom/baidu/tieba/feed/data/FeedExtraData;", "schema", "", "forum_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsHeadlinesExtensionKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedToutiao feedToutiao, final List<rb7<?>> dataList, final r67 feedExtraData, final String schema) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedToutiao, dataList, feedExtraData, schema) == null) {
            Intrinsics.checkNotNullParameter(feedToutiao, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(schema, "schema");
            HashMap<String, String> a = va7.a.a(feedToutiao.business_info);
            if (a.isEmpty() || (str = a.get("task_info")) == null) {
                return;
            }
            JSONKt.a(str, new Function1<JSONObject, Unit>(feedExtraData, schema, dataList) { // from class: com.baidu.tieba.forum.data.protobuf.FrsHeadlinesExtensionKt$insertTemplateList$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ List<rb7<?>> $dataList;
                public final /* synthetic */ r67 $feedExtraData;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $schema;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {feedExtraData, schema, dataList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$feedExtraData = feedExtraData;
                    this.$schema = schema;
                    this.$dataList = dataList;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject jsonObj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonObj) == null) {
                        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                        kz4 kz4Var = new kz4();
                        kz4Var.s(jsonObj);
                        String str2 = this.$feedExtraData.a().a().get("thread_id");
                        if (str2 == null) {
                            str2 = "";
                        }
                        this.$dataList.add(new sb7(new ag7(str2, kz4Var, this.$schema, this.$feedExtraData.a().a(), this.$feedExtraData.c().a(), null, 32, null), "head_lines"));
                    }
                }
            });
        }
    }
}
