package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.p2.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCardVideoViewHolder f51221e;

    /* renamed from: f  reason: collision with root package name */
    public InterviewLiveViewHolder f51222f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.w0.n1.g.e f51223g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterviewLiveViewWrapHolder(c.a.r0.w0.n1.g.e eVar) {
        super(eVar.c());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51221e = new FrsCardVideoViewHolder(eVar.b());
        this.f51222f = new InterviewLiveViewHolder(eVar.a());
        this.f51223g = eVar;
    }

    @Override // c.a.r0.p2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            if (frsCardVideoViewHolder == null) {
                return 0;
            }
            return frsCardVideoViewHolder.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public FrsCardVideoViewHolder getFrsCardVideoViewHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51221e : (FrsCardVideoViewHolder) invokeV.objValue;
    }

    public InterviewLiveViewHolder getInterviewLiveViewHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51222f : (InterviewLiveViewHolder) invokeV.objValue;
    }

    @Override // c.a.r0.p2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            return frsCardVideoViewHolder == null ? "" : frsCardVideoViewHolder.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    public c.a.r0.w0.n1.g.e getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51223g : (c.a.r0.w0.n1.g.e) invokeV.objValue;
    }

    @Override // c.a.r0.p2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            if (frsCardVideoViewHolder == null) {
                return null;
            }
            return frsCardVideoViewHolder.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.p2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f51221e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p2.e
    public void startPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsCardVideoViewHolder = this.f51221e) == null) {
            return;
        }
        frsCardVideoViewHolder.startPlay();
    }

    @Override // c.a.r0.p2.e
    public void stopPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsCardVideoViewHolder = this.f51221e) == null) {
            return;
        }
        frsCardVideoViewHolder.stopPlay();
    }
}
