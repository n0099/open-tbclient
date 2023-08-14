package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.zt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a58 implements yt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z48 a;
    public final Context b;
    public final ViewGroup c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public boolean g;
    public ThreadData h;
    public BdUniqueId i;
    public String j;
    public String k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public tt9 n;
    public int o;
    public zt9.a p;

    public a58(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = viewGroup;
        a();
    }

    public final void a() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (context = this.b) != null && this.c != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a3c, this.c, true);
            if (inflate != null) {
                inflate.setOnClickListener(this);
            }
            ImageView imageView = (ImageView) this.c.findViewById(R.id.video_play);
            if (imageView != null) {
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                imageView.setOnClickListener(this);
            }
            TextView textView = (TextView) this.c.findViewById(R.id.video_duration);
            this.f = textView;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = (TextView) this.c.findViewById(R.id.video_play_count);
            this.e = textView2;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.video_thumbnail);
            this.d = tbImageView;
            if (tbImageView != null) {
                tbImageView.clearCornerFlag();
                this.d.setDrawCorner(false);
                this.d.setPlaceHolder(3);
            }
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.g && (viewGroup = this.c) != null && this.b != null && this.h != null) {
            viewGroup.removeAllViews();
            z48 z48Var = new z48(this.b, this.c);
            this.a = z48Var;
            z48Var.setUniqueId(this.i);
            this.a.setFrom(this.j);
            this.a.setStageType(this.k);
            this.a.setData(this.h);
            if (this.h.getThreadVideoInfo() != null && this.h.getThreadVideoInfo().is_vertical.intValue() == 1) {
                this.a.changeRenderViewMode(this.o);
            }
            this.a.setJumpToPbClickListener(this.l);
            this.a.setAfterClickListener(this.m);
            this.a.setStatistic(this.n);
            this.a.G0(this.p);
            this.g = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = this.f;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
        }
    }

    public void e() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (z48Var = this.a) != null) {
            z48Var.E0();
        }
    }

    @Override // com.baidu.tieba.yt9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yt9
    public View getMainView() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yt9
    public boolean isPlaying() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yt9
    public boolean onBackPress() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.onPrepared();
        }
    }

    @Override // com.baidu.tieba.yt9
    public void onScroll() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.yt9
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yt9
    public void startPlay() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            b();
            if (this.g && (z48Var = this.a) != null) {
                z48Var.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void stopPlay() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.g && (z48Var = this.a) != null) {
            z48Var.stopPlay();
        }
    }

    @Override // com.baidu.tieba.yt9
    public void changeRenderViewMode(int i) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.o = i;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.changeRenderViewMode(i);
            }
        }
    }

    public void d(zt9.a aVar) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.p = aVar;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.G0(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            b();
            if (this.g && (z48Var = this.a) != null) {
                z48Var.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setFrom(String str) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.j = str;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.l = onClickListener;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setStageType(String str) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.k = str;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setStatistic(tt9 tt9Var) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tt9Var) == null) {
            this.n = tt9Var;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setStatistic(tt9Var);
            }
        }
    }

    @Override // com.baidu.tieba.yt9
    public void setUniqueId(BdUniqueId bdUniqueId) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048591, this, i, i2, obj)) == null) {
            if (this.g && (z48Var = this.a) != null) {
                return z48Var.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.yt9
    public void setData(ThreadData threadData) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.h = threadData;
            if (this.g && (z48Var = this.a) != null) {
                z48Var.setData(threadData);
                return;
            }
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            TextView textView = this.f;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(intValue));
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setText(String.format(this.b.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
            }
            if (this.d != null) {
                if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                    this.d.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                } else if (!bi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                    this.d.startLoad(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
                } else {
                    this.d.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                }
            }
        }
    }
}
