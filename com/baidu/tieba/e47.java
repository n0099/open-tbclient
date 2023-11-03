package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardReplyUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class e47 extends h47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i77 g;
    public final String h;
    public final String i;
    public final List<m77> j;
    public final List<m77> k;
    public final List<m77> l;
    public final Function2<Context, e47, Unit> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e47(i77 replyData, String headSchema, String schema, Map<String, String> businessInfo, Map<String, String> logInfo, List<m77> userHeadClickStatList, List<m77> userNameClickStatList, List<m77> cardClickStatList, Function2<? super Context, ? super e47, Unit> onRootClick) {
        super(businessInfo, logInfo, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyData, headSchema, schema, businessInfo, logInfo, userHeadClickStatList, userNameClickStatList, cardClickStatList, onRootClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(replyData, "replyData");
        Intrinsics.checkNotNullParameter(headSchema, "headSchema");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(logInfo, "logInfo");
        Intrinsics.checkNotNullParameter(userHeadClickStatList, "userHeadClickStatList");
        Intrinsics.checkNotNullParameter(userNameClickStatList, "userNameClickStatList");
        Intrinsics.checkNotNullParameter(cardClickStatList, "cardClickStatList");
        Intrinsics.checkNotNullParameter(onRootClick, "onRootClick");
        this.g = replyData;
        this.h = headSchema;
        this.i = schema;
        this.j = userHeadClickStatList;
        this.k = userNameClickStatList;
        this.l = cardClickStatList;
        this.m = onRootClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ e47(i77 i77Var, String str, String str2, Map map, Map map2, List list, List list2, List list3, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i77Var, str, str2, map, map2, r8, r9, r10, r11);
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Function2 function22;
        Function2 function23;
        if ((i & 32) != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        if ((i & 64) != 0) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = list2;
        }
        if ((i & 128) != 0) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = list3;
        }
        if ((i & 256) != 0) {
            function23 = CardReplyUiStateKt.a;
            function22 = function23;
        } else {
            function22 = function2;
        }
    }

    public final List<m77> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final Function2<Context, e47, Unit> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return (Function2) invokeV.objValue;
    }

    public final i77 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (i77) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final List<m77> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public final List<m77> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }
}
