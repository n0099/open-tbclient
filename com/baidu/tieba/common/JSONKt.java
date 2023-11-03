package com.baidu.tieba.common;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u001a%\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u0002H\n¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"safeParseJSONString", "", "jsonString", "", "safeBlock", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "safeParseJson", "Lkotlin/Function0;", "safePut", ExifInterface.GPS_DIRECTION_TRUE, "key", "value", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSONKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(final String jsonString, final Function1<? super JSONObject, Unit> safeBlock) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jsonString, safeBlock) == null) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            Intrinsics.checkNotNullParameter(safeBlock, "safeBlock");
            if (StringUtils.isNotNull(jsonString)) {
                b(new Function0<Unit>(safeBlock, jsonString) { // from class: com.baidu.tieba.common.JSONKt$safeParseJSONString$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $jsonString;
                    public final /* synthetic */ Function1<JSONObject, Unit> $safeBlock;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {safeBlock, jsonString};
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
                        this.$safeBlock = safeBlock;
                        this.$jsonString = jsonString;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.$safeBlock.invoke(new JSONObject(this.$jsonString));
                        }
                    }
                });
            }
        }
    }

    public static final void b(Function0<Unit> safeBlock) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, safeBlock) == null) {
            Intrinsics.checkNotNullParameter(safeBlock, "safeBlock");
            try {
                safeBlock.invoke();
            } catch (JSONException e) {
                e.printStackTrace();
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return;
                }
                throw e;
            }
        }
    }

    public static final <T> void c(JSONObject jSONObject, String key, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, jSONObject, key, t) == null) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                jSONObject.put(key, t);
            } catch (JSONException unused) {
            }
        }
    }
}
