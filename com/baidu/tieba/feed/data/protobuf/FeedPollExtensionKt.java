package com.baidu.tieba.feed.data.protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a57;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.hz4;
import com.baidu.tieba.k87;
import com.baidu.tieba.l87;
import com.baidu.tieba.n67;
import com.baidu.tieba.nb7;
import com.baidu.tieba.ob7;
import com.baidu.tieba.ra7;
import com.baidu.tieba.uz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tbclient.PollInfo;
import tbclient.PollOption;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"insertTemplateList", "", "Ltbclient/PollInfo;", "dataList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "feedExtraData", "Lcom/baidu/tieba/feed/data/FeedExtraData;", "schema", "", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedPollExtensionKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0114, code lost:
        if (r6 == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(PollInfo pollInfo, List<nb7<?>> dataList, n67 feedExtraData, String schema) {
        long j;
        uz4 uz4Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, pollInfo, dataList, feedExtraData, schema) == null) {
            Intrinsics.checkNotNullParameter(pollInfo, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Map<String, String> a = feedExtraData.a().a();
            ArrayList arrayList = new ArrayList();
            for (PollOption pollOption : pollInfo.options) {
                Integer num = pollOption.id;
                Intrinsics.checkNotNullExpressionValue(num, "option.id");
                int intValue = num.intValue();
                Long l = pollOption.num;
                Intrinsics.checkNotNullExpressionValue(l, "option.num");
                long longValue = l.longValue();
                String str = pollOption.text;
                Intrinsics.checkNotNullExpressionValue(str, "option.text");
                arrayList.add(new l87(intValue, longValue, str));
            }
            String str2 = a.get("thread_id");
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            String str4 = a.get("forum_id");
            if (str4 != null) {
                j = Long.parseLong(str4);
            } else {
                j = 0;
            }
            long j2 = j;
            String title = pollInfo.title;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Integer options_count = pollInfo.options_count;
            Intrinsics.checkNotNullExpressionValue(options_count, "options_count");
            int intValue2 = options_count.intValue();
            Long total_num = pollInfo.total_num;
            Intrinsics.checkNotNullExpressionValue(total_num, "total_num");
            long longValue2 = total_num.longValue();
            Integer is_multi = pollInfo.is_multi;
            Intrinsics.checkNotNullExpressionValue(is_multi, "is_multi");
            int intValue3 = is_multi.intValue();
            Integer is_polled = pollInfo.is_polled;
            Intrinsics.checkNotNullExpressionValue(is_polled, "is_polled");
            int intValue4 = is_polled.intValue();
            String polled_value = pollInfo.polled_value;
            Intrinsics.checkNotNullExpressionValue(polled_value, "polled_value");
            Integer end_time = pollInfo.end_time;
            Intrinsics.checkNotNullExpressionValue(end_time, "end_time");
            int intValue5 = end_time.intValue();
            Integer last_time = pollInfo.last_time;
            Intrinsics.checkNotNullExpressionValue(last_time, "last_time");
            int intValue6 = last_time.intValue();
            Long total_poll = pollInfo.total_poll;
            Intrinsics.checkNotNullExpressionValue(total_poll, "total_poll");
            k87 k87Var = new k87(str3, j2, title, intValue2, longValue2, intValue3, intValue4, polled_value, intValue5, intValue6, total_poll.longValue(), arrayList, schema);
            String str5 = ra7.a.a(pollInfo.business_info).get("task_info");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            boolean z2 = true;
            if (str5 != null) {
                if (str5.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            z2 = false;
            if (z2) {
                JSONKt.a(str5, new Function1<JSONObject, Unit>(objectRef) { // from class: com.baidu.tieba.feed.data.protobuf.FeedPollExtensionKt$insertTemplateList$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.ObjectRef<hz4> $taskInfo;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {objectRef};
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
                        this.$taskInfo = objectRef;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                        invoke2(jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.baidu.tieba.hz4] */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(JSONObject it) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Ref.ObjectRef<hz4> objectRef2 = this.$taskInfo;
                            ?? hz4Var = new hz4();
                            hz4Var.s(it);
                            objectRef2.element = hz4Var;
                        }
                    }
                });
            }
            hz4 hz4Var = (hz4) objectRef.element;
            if (hz4Var != null) {
                uz4Var = hz4Var.p();
            } else {
                uz4Var = null;
            }
            dataList.add(new ob7(new a57(k87Var, uz4Var), "card_vote"));
        }
    }
}
