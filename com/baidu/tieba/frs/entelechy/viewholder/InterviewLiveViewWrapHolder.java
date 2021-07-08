package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.n2.e;
/* loaded from: classes4.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCardVideoViewHolder f15609e;

    @Override // d.a.p0.n2.e
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.C();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            if (frsCardVideoViewHolder == null) {
                return 0;
            }
            return frsCardVideoViewHolder.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.n2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            return frsCardVideoViewHolder == null ? "" : frsCardVideoViewHolder.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            if (frsCardVideoViewHolder == null) {
                return null;
            }
            return frsCardVideoViewHolder.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15609e;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.e
    public void startPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (frsCardVideoViewHolder = this.f15609e) == null) {
            return;
        }
        frsCardVideoViewHolder.startPlay();
    }

    @Override // d.a.p0.n2.e
    public void stopPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (frsCardVideoViewHolder = this.f15609e) == null) {
            return;
        }
        frsCardVideoViewHolder.stopPlay();
    }
}
