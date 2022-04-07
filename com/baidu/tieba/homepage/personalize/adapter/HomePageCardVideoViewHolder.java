package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.bx5;
import com.repackage.p68;
/* loaded from: classes3.dex */
public class HomePageCardVideoViewHolder<T extends bx5> extends CardViewHolder<T> implements p68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: d */
    public T c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (T) this.a : (T) invokeV.objValue;
    }

    @Override // com.repackage.p68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return 0;
            }
            return ((bx5) t).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((bx5) t).w();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.p68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((bx5) t).x();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.p68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((bx5) t).F();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((bx5) t).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p68
    public void startPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((bx5) t).startPlay();
    }

    @Override // com.repackage.p68
    public void stopPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((bx5) t).stopPlay();
    }
}
