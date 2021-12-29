package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.y1.g.a;
import c.a.t0.g0.b;
import c.a.t0.z2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsCardVideoViewHolder<T extends a> extends CardViewHolder<T> implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsCardVideoViewHolder(T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.t0.z2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            T t = this.mCardView;
            if (t == 0) {
                return 0;
            }
            return ((a) t).getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.z2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T t = this.mCardView;
            if (t == 0) {
                return null;
            }
            return ((a) t).G();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.mCardView;
            if (t == 0) {
                return null;
            }
            return ((a) t).H();
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            T t = this.mCardView;
            if (t == 0) {
                return false;
            }
            return ((a) t).Q();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            T t = this.mCardView;
            if (t == 0) {
                return false;
            }
            return ((a) t).isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public void startPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.mCardView) == 0) {
            return;
        }
        ((a) t).startPlay();
    }

    @Override // c.a.t0.z2.e
    public void stopPlay() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = this.mCardView) == 0) {
            return;
        }
        ((a) t).stopPlay();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    public T getCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (T) this.mCardView : (T) invokeV.objValue;
    }
}
