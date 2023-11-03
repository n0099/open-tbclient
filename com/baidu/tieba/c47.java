package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.component.uistate.CardPicUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c47 extends h47 implements PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i57 g;
    public String h;
    public final Function5<Context, Integer, Rect, String, c47, Unit> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public c47(i57 cardPicData, String schema, Map<String, String> businessInfo, Map<String, String> logInfo, Function5<? super Context, ? super Integer, ? super Rect, ? super String, ? super c47, Unit> onImageClick) {
        super(businessInfo, logInfo, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {cardPicData, schema, businessInfo, logInfo, onImageClick};
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
        Intrinsics.checkNotNullParameter(cardPicData, "cardPicData");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(logInfo, "logInfo");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        this.g = cardPicData;
        this.h = schema;
        this.i = onImageClick;
    }

    public /* synthetic */ c47(i57 i57Var, String str, Map map, Map map2, Function5 function5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i57Var, (i & 2) != 0 ? "" : str, map, map2, (i & 16) != 0 ? CardPicUiStateKt.a : function5);
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            List<e77> list = this.g.a;
            Intrinsics.checkNotNullExpressionValue(list, "cardPicData.picDataList");
            for (e77 e77Var : CollectionsKt___CollectionsKt.take(list, 3)) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.imgUrl = e77Var.a;
                preLoadImageInfo.procType = 13;
                if (this.g.a.size() == 1) {
                    preLoadImageInfo.preloadType = 1;
                } else {
                    preLoadImageInfo.preloadType = 2;
                }
                arrayList.add(preLoadImageInfo);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final i57 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (i57) invokeV.objValue;
    }

    public final Function5<Context, Integer, Rect, String, c47, Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (Function5) invokeV.objValue;
    }

    public final String n(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i >= this.g.a.size()) {
                return this.h;
            }
            e77 e77Var = this.g.a.get(i);
            String str = e77Var.g;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String str2 = e77Var.g;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            data.scheme\n        }");
                return str2;
            }
            return this.h;
        }
        return (String) invokeI.objValue;
    }
}
