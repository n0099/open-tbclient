package com.baidu.tieba;

import com.baidu.tbadk.editortools.meme.SpriteMemeShowStrategy;
import com.baidu.tbadk.editortools.meme.muti.MutiSpriteMemeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
/* loaded from: classes5.dex */
public final class ag5 implements dm5<MutiSpriteMemeEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag5() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dm5
    /* renamed from: a */
    public boolean onEvent(MutiSpriteMemeEvent mutiSpriteMemeEvent) {
        InterceptResult invokeL;
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mutiSpriteMemeEvent)) == null) {
            if (mutiSpriteMemeEvent != null) {
                SpriteMemeShowStrategy.a.o(mutiSpriteMemeEvent.getAccountId());
                SpriteMemeShowStrategy.a.n(mutiSpriteMemeEvent.getConfigData());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
