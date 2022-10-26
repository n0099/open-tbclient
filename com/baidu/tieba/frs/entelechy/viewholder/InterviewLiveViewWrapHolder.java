package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.ua8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements ua8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsCardVideoViewHolder a;

    @Override // com.baidu.tieba.ua8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return 0;
            }
            return frsCardVideoViewHolder.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ua8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return "";
            }
            return frsCardVideoViewHolder.getPlayUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ua8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return null;
            }
            return frsCardVideoViewHolder.getVideoContainer();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ua8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsCardVideoViewHolder frsCardVideoViewHolder = this.a;
            if (frsCardVideoViewHolder == null) {
                return false;
            }
            return frsCardVideoViewHolder.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua8
    public void startPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (frsCardVideoViewHolder = this.a) == null) {
            return;
        }
        frsCardVideoViewHolder.startPlay();
    }

    @Override // com.baidu.tieba.ua8
    public void stopPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (frsCardVideoViewHolder = this.a) == null) {
            return;
        }
        frsCardVideoViewHolder.stopPlay();
    }
}
