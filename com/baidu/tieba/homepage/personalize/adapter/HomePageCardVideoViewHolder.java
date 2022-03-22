package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c3.e;
import c.a.p0.h0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
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

    @Override // c.a.p0.c3.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return 0;
            }
            return ((l) t).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((l) t).v();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.c3.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return null;
            }
            return ((l) t).w();
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((l) t).F();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.a;
            if (t == 0) {
                return false;
            }
            return ((l) t).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public void startPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((l) t).startPlay();
    }

    @Override // c.a.p0.c3.e
    public void stopPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = this.a) == 0) {
            return;
        }
        ((l) t).stopPlay();
    }
}
