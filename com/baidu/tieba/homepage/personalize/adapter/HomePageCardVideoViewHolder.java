package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.il6;
import com.baidu.tieba.p8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class HomePageCardVideoViewHolder<T extends il6> extends CardViewHolder<T> implements p8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.p8a
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
    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (T) this.a;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p8a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return 0;
            }
            return ((il6) t).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.p8a
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((il6) t).y();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p8a
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((il6) t).z();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p8a
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((il6) t).H();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p8a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((il6) t).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p8a
    public void startPlay() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (t = this.a) != 0) {
            ((il6) t).startPlay();
        }
    }

    @Override // com.baidu.tieba.p8a
    public void stopPlay() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (t = this.a) != 0) {
            ((il6) t).stopPlay();
        }
    }
}
