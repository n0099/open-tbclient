package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.fm6;
import com.baidu.tieba.p16;
import com.baidu.tieba.ua8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsCardVideoViewHolder extends CardViewHolder implements ua8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ua8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsCardVideoViewHolder(fm6 fm6Var) {
        super(fm6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fm6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p16) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: b */
    public fm6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (fm6) this.a;
        }
        return (fm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ua8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            p16 p16Var = this.a;
            if (p16Var == null) {
                return 0;
            }
            return ((fm6) p16Var).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ua8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            p16 p16Var = this.a;
            if (p16Var == null) {
                return null;
            }
            return ((fm6) p16Var).H();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ua8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p16 p16Var = this.a;
            if (p16Var == null) {
                return null;
            }
            return ((fm6) p16Var).I();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ua8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            p16 p16Var = this.a;
            if (p16Var == null) {
                return false;
            }
            return ((fm6) p16Var).R();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            p16 p16Var = this.a;
            if (p16Var == null) {
                return false;
            }
            return ((fm6) p16Var).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public void startPlay() {
        p16 p16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (p16Var = this.a) != null) {
            ((fm6) p16Var).startPlay();
        }
    }

    @Override // com.baidu.tieba.ua8
    public void stopPlay() {
        p16 p16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (p16Var = this.a) != null) {
            ((fm6) p16Var).stopPlay();
        }
    }
}
