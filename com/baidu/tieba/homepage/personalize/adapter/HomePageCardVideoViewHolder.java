package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.p16;
import com.baidu.tieba.ua8;
import com.baidu.tieba.z16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder extends CardViewHolder implements ua8 {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: b */
    public z16 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (z16) this.a;
        }
        return (z16) invokeV.objValue;
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
            return ((z16) p16Var).getCurrentPosition();
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
            return ((z16) p16Var).u();
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
            return ((z16) p16Var).v();
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
            return ((z16) p16Var).D();
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
            return ((z16) p16Var).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public void startPlay() {
        p16 p16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (p16Var = this.a) != null) {
            ((z16) p16Var).startPlay();
        }
    }

    @Override // com.baidu.tieba.ua8
    public void stopPlay() {
        p16 p16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (p16Var = this.a) != null) {
            ((z16) p16Var).stopPlay();
        }
    }
}
