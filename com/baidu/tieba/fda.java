package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sprite.funnysprite.data.SpriteTipHttpResponseMessage;
import com.baidu.tieba.sprite.homepage.HomeSpriteEdgeFloatManager;
import com.baidu.tieba.sprite.tips.HomePageSpriteBottomTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fda implements eda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fda() {
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

    @Override // com.baidu.tieba.eda
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return fna.i.a().h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eda
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && HomeSpriteEdgeFloatManager.l.c().V()) {
            HomeSpriteEdgeFloatManager.l.c().Z();
        }
    }

    @Override // com.baidu.tieba.eda
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HomeSpriteEdgeFloatManager.l.c().P();
        }
    }

    @Override // com.baidu.tieba.eda
    public void b(ifa hotEventShowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hotEventShowData) == null) {
            Intrinsics.checkNotNullParameter(hotEventShowData, "hotEventShowData");
            HomeSpriteEdgeFloatManager.l.c().W(hotEventShowData);
        }
    }

    @Override // com.baidu.tieba.eda
    public void c(Activity context, SpriteTipHttpResponseMessage response, HomePageSpriteBottomTipView spriteTipView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, response, spriteTipView) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(spriteTipView, "spriteTipView");
            o55.g(CollectionsKt__CollectionsJVMKt.listOf(new yoa(context, response, spriteTipView, null, 8, null)));
        }
    }
}
