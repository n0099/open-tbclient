package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.a0.l;
import d.a.p0.n2.e;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // d.a.p0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: c */
    public T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (T) this.f14550e : (T) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.f14550e;
            if (t == 0) {
                return 0;
            }
            return ((l) t).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.f14550e;
            if (t == 0) {
                return null;
            }
            return ((l) t).N();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.f14550e;
            if (t == 0) {
                return null;
            }
            return ((l) t).O();
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.f14550e;
            if (t == 0) {
                return false;
            }
            return ((l) t).a0();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.f14550e;
            if (t == 0) {
                return false;
            }
            return ((l) t).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public void startPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.f14550e) == 0) {
            return;
        }
        ((l) t).startPlay();
    }

    @Override // d.a.p0.n2.e
    public void stopPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = this.f14550e) == 0) {
            return;
        }
        ((l) t).stopPlay();
    }
}
