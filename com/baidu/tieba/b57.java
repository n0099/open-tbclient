package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.component.uistate.CardVideoUiStateKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b57 extends z47 implements f57, oa7, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l87 g;
    public final m87 h;
    public final List<e87> i;
    public final Function3<Context, Rect, b57, Unit> j;
    public SpannableString k;
    public g57 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b57(l87 videoData, m87 schemaData, List<e87> statDataList, Map<String, String> businessInfo, Map<String, String> logInfo, Function3<? super Context, ? super Rect, ? super b57, Unit> onVideoClick) {
        super(businessInfo, logInfo, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {videoData, schemaData, statDataList, businessInfo, logInfo, onVideoClick};
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
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(statDataList, "statDataList");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(logInfo, "logInfo");
        Intrinsics.checkNotNullParameter(onVideoClick, "onVideoClick");
        this.g = videoData;
        this.h = schemaData;
        this.i = statDataList;
        this.j = onVideoClick;
        this.k = new SpannableString("");
    }

    public /* synthetic */ b57(l87 l87Var, m87 m87Var, List list, Map map, Map map2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l87Var, m87Var, (i & 4) != 0 ? new ArrayList() : list, map, map2, (i & 32) != 0 ? CardVideoUiStateKt.a() : function3);
    }

    @Override // com.baidu.tieba.f57
    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            g57 g57Var = this.l;
            if (g57Var != null) {
                this.j.invoke(context, g57Var.a(), this);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.oa7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.h.d(event);
        }
    }

    public final void q(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spannableString) == null) {
            Intrinsics.checkNotNullParameter(spannableString, "<set-?>");
            this.k = spannableString;
        }
    }

    public final void r(g57 g57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g57Var) == null) {
            this.l = g57Var;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.g.a;
            preLoadImageInfo.procType = 10;
            preLoadImageInfo.preloadType = 1;
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final SpannableString l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final Function3<Context, Rect, b57, Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (Function3) invokeV.objValue;
    }

    public final m87 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (m87) invokeV.objValue;
    }

    public final List<e87> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public final l87 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (l87) invokeV.objValue;
    }
}
