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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.gv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g78 implements fv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f78 a;
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
    public av9 n;
    public int o;
    public gv9.a p;

    public g78(Context context, ViewGroup viewGroup) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a32, this.c, true);
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
                d85.d(textView).B(R.array.S_O_X001);
            }
            TextView textView2 = (TextView) this.c.findViewById(R.id.video_play_count);
            this.e = textView2;
            if (textView2 != null) {
                d85.d(textView2).B(R.array.S_O_X001);
            }
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.video_thumbnail);
            this.d = tbImageView;
            if (tbImageView != null) {
                tbImageView.s();
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
            f78 f78Var = new f78(this.b, this.c);
            this.a = f78Var;
            f78Var.setUniqueId(this.i);
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
                d85.d(textView).B(R.array.S_O_X001);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                d85.d(textView2).B(R.array.S_O_X001);
            }
        }
    }

    public void e() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (f78Var = this.a) != null) {
            f78Var.E0();
        }
    }

    @Override // com.baidu.tieba.fv9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fv9
    public View getMainView() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv9
    public boolean isPlaying() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv9
    public boolean onBackPress() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.onPrepared();
        }
    }

    @Override // com.baidu.tieba.fv9
    public void onScroll() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.fv9
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv9
    public void startPlay() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            b();
            if (this.g && (f78Var = this.a) != null) {
                f78Var.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void stopPlay() {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.g && (f78Var = this.a) != null) {
            f78Var.stopPlay();
        }
    }

    @Override // com.baidu.tieba.fv9
    public void changeRenderViewMode(int i) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.o = i;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.changeRenderViewMode(i);
            }
        }
    }

    public void d(gv9.a aVar) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.p = aVar;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.G0(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            b();
            if (this.g && (f78Var = this.a) != null) {
                f78Var.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setFrom(String str) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.j = str;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.l = onClickListener;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setStageType(String str) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.k = str;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setStatistic(av9 av9Var) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, av9Var) == null) {
            this.n = av9Var;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setStatistic(av9Var);
            }
        }
    }

    @Override // com.baidu.tieba.fv9
    public void setUniqueId(BdUniqueId bdUniqueId) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        f78 f78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048591, this, i, i2, obj)) == null) {
            if (this.g && (f78Var = this.a) != null) {
                return f78Var.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.fv9
    public void setData(ThreadData threadData) {
        f78 f78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.h = threadData;
            if (this.g && (f78Var = this.a) != null) {
                f78Var.setData(threadData);
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
                    this.d.N(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                } else if (!xi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                    this.d.N(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
                } else {
                    this.d.N(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                }
            }
        }
    }
}
