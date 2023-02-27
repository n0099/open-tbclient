package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ht8 extends jt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData P0;
    public VideoSerializeVideoThreadInfo Q0;
    public ThreadData R0;

    @Override // com.baidu.tieba.jt8
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht8(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 5000;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ht8(Context context, View view2, boolean z) {
        this(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o0(z);
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0(this.f);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.p;
            if (i == this.e || i == this.n) {
                A0();
            }
        }
    }

    @Override // com.baidu.tieba.jt8
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = 32;
        }
    }

    @Override // com.baidu.tieba.jt8
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.e0();
            this.Q.setOnTouchListener(null);
            this.Q.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            startPlay();
        }
    }

    @Override // com.baidu.tieba.jt8, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.video_mute) {
            X();
        } else if (id == R.id.obfuscated_res_0x7f091d6d) {
            q0(this.b);
            startPlay();
        } else {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ej.P(this.O, R.string.no_network_guide);
            } else {
                z0(ThreadCardUtils.computeViewArea(this.Q));
            }
            View.OnClickListener onClickListener = this.B0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            super.setData(threadData);
            this.R0 = threadData;
            if (this.T) {
                VideoItemData videoItemData = new VideoItemData();
                this.P0 = videoItemData;
                videoItemData.buildWithThreadData(threadData);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.Q0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(threadData);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.Q0;
            videoSerializeVideoThreadInfo2.source = threadData.mRecomSource;
            videoSerializeVideoThreadInfo2.extra = threadData.mRecomExtra;
            videoSerializeVideoThreadInfo2.ab_tag = threadData.mRecomAbTag;
            videoSerializeVideoThreadInfo2.weight = threadData.mRecomWeight;
        }
    }

    public final void z0(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, rect) != null) || this.R0 == null) {
            return;
        }
        if (this.P0 == null) {
            this.P0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.P0.buildWithThreadData(this.R0);
        arrayList.add(this.P0);
        String str = null;
        ThreadData threadData = this.R0;
        if (threadData != null && threadData.getBaijiahaoData() != null) {
            str = this.R0.getBaijiahaoData().oriUgcNid;
        }
        String str2 = str;
        Context context = this.O;
        boolean z = this.T;
        String str3 = this.b0;
        ThreadData threadData2 = this.R0;
        iq5.e(context, arrayList, str2, z, 0, rect, "from_nani_video", "personalize_page", "", str3, str3, false, threadData2.isJumpToFrsVideoTabPlay, true, threadData2.getFid());
    }
}
