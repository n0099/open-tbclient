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
/* loaded from: classes3.dex */
public class ad8 extends cd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData N0;
    public VideoSerializeVideoThreadInfo O0;
    public ThreadData P0;

    @Override // com.baidu.tieba.cd8
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad8(Context context, View view2) {
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
    public ad8(Context context, View view2, boolean z) {
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
        m0(z);
    }

    @Override // com.baidu.tieba.cd8
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.p;
            if (i == this.e || i == this.n) {
                x0();
            }
        }
    }

    @Override // com.baidu.tieba.cd8
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = 32;
        }
    }

    @Override // com.baidu.tieba.cd8
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d0();
            this.Q.setOnTouchListener(null);
            this.Q.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            startPlay();
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o0(this.f);
        }
    }

    @Override // com.baidu.tieba.cd8, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092584) {
            W();
        } else if (id == R.id.obfuscated_res_0x7f091c4e) {
            o0(this.b);
            startPlay();
        } else {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                xi.O(this.O, R.string.obfuscated_res_0x7f0f0cba);
            } else {
                w0(ThreadCardUtils.computeViewArea(this.Q));
            }
            View.OnClickListener onClickListener = this.A0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            super.setData(threadData);
            this.P0 = threadData;
            if (this.T) {
                VideoItemData videoItemData = new VideoItemData();
                this.N0 = videoItemData;
                videoItemData.buildWithThreadData(threadData);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.O0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(threadData);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.O0;
            videoSerializeVideoThreadInfo2.source = threadData.mRecomSource;
            videoSerializeVideoThreadInfo2.extra = threadData.mRecomExtra;
            videoSerializeVideoThreadInfo2.ab_tag = threadData.mRecomAbTag;
            videoSerializeVideoThreadInfo2.weight = threadData.mRecomWeight;
        }
    }

    public final void w0(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) != null) || this.P0 == null) {
            return;
        }
        if (this.N0 == null) {
            this.N0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.N0.buildWithThreadData(this.P0);
        arrayList.add(this.N0);
        String str = null;
        ThreadData threadData = this.P0;
        if (threadData != null && threadData.getBaijiahaoData() != null) {
            str = this.P0.getBaijiahaoData().oriUgcNid;
        }
        String str2 = str;
        Context context = this.O;
        boolean z = this.T;
        String str3 = this.b0;
        ThreadData threadData2 = this.P0;
        ri5.e(context, arrayList, str2, z, 0, rect, "from_nani_video", "personalize_page", "", str3, str3, false, threadData2.isJumpToFrsVideoTabPlay, true, threadData2.getFid());
    }
}
