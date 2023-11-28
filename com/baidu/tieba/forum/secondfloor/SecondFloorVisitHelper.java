package com.baidu.tieba.forum.secondfloor;

import android.text.TextUtils;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.hi7;
import com.baidu.tieba.ii7;
import com.baidu.tieba.ui7;
import com.baidu.tieba.ul5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/forum/secondfloor/SecondFloorVisitHelper;", "", "()V", "checkNeedShowNewBotGuide", "", "fid", "", "newBotUk", "getLastVisitedBotByFid", "Lcom/baidu/tieba/forum/data/AiBotInfoData;", "initDefaultBot", "data", "Lcom/baidu/tieba/forum/data/AiChatroomGuideInfoData;", "tryInitBotDb", "", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SecondFloorVisitHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final SecondFloorVisitHelper a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-997025401, "Lcom/baidu/tieba/forum/secondfloor/SecondFloorVisitHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-997025401, "Lcom/baidu/tieba/forum/secondfloor/SecondFloorVisitHelper;");
                return;
            }
        }
        a = new SecondFloorVisitHelper();
    }

    public SecondFloorVisitHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ((ul5) ServiceManager.getService(ul5.a.a())).b();
        }
    }

    public final boolean a(String fid, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fid, str)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intrinsics.checkNotNull(str);
            return !((ul5) ServiceManager.getService(ul5.a.a())).a(fid, str);
        }
        return invokeLL.booleanValue;
    }

    public final hi7 b(String fid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fid)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            String c = ((ul5) ServiceManager.getService(ul5.a.a())).c(fid);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Intrinsics.checkNotNull(c);
            JSONKt.a(c, new Function1<JSONObject, Unit>(objectRef) { // from class: com.baidu.tieba.forum.secondfloor.SecondFloorVisitHelper$getLastVisitedBotByFid$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Ref.ObjectRef<hi7> $bot;
                public transient /* synthetic */ FieldHolder $fh;

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
                    this.$bot = objectRef;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r8v1, types: [T, com.baidu.tieba.hi7] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject it) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String uk = it.optString("uk");
                        String optString = it.optString("paid");
                        String optString2 = it.optString(TaskUIData.keyBgUrl);
                        Ref.ObjectRef<hi7> objectRef2 = this.$bot;
                        Intrinsics.checkNotNullExpressionValue(uk, "uk");
                        objectRef2.element = new hi7(uk, JavaTypesHelper.toLong(optString, 0L), "", "", optString2);
                    }
                }
            });
            return (hi7) objectRef.element;
        }
        return (hi7) invokeL.objValue;
    }

    public final hi7 c(ii7 data, String fid) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, data, fid)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(fid, "fid");
            ui7 d = data.d();
            if (d != null) {
                str = d.a();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (data.e() && data.d() != null) {
                    return data.d().d();
                }
                return b(fid);
            }
            return b(fid);
        }
        return (hi7) invokeLL.objValue;
    }
}
