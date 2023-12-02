package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cq0 implements aq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tp0 b;
    public xp0 c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements yq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq0 a;

        public b(cq0 cq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq0Var;
        }

        @Override // com.baidu.tieba.yq0
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.c != null) {
                this.a.c.a(i);
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a.c != null) {
                this.a.c.onEnd(i);
            }
        }

        public /* synthetic */ b(cq0 cq0Var, a aVar) {
            this(cq0Var);
        }

        @Override // com.baidu.tieba.yq0
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && this.a.c != null) {
                this.a.c.onInfo(i, i2);
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) && this.a.c != null) {
                this.a.c.onVideoSizeChanged(i, i2);
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onBufferEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.c != null) {
                this.a.c.onBufferEnd();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onBufferStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.c != null) {
                this.a.c.onBufferStart();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.c != null) {
                this.a.c.onPause();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.c != null) {
                this.a.c.onPrepared();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.c != null) {
                this.a.c.onResume();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a.c != null) {
                this.a.c.onSeekEnd();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a.c != null) {
                this.a.c.onStart();
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) && this.a.c != null) {
                this.a.c.onError(i, i2, str);
            }
        }

        @Override // com.baidu.tieba.yq0
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) && this.a.c != null) {
                this.a.c.onUpdateProgress(i, i2, i3);
            }
        }
    }

    public cq0(tp0 tp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tp0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tp0Var;
        tp0Var.w0(new b(this, null));
    }

    @Override // com.baidu.tieba.aq0
    public void a(xp0 xp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xp0Var) == null) {
            this.c = xp0Var;
        }
    }

    @Override // com.baidu.tieba.aq0
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.b.f(viewGroup);
        }
    }

    @Override // com.baidu.tieba.aq0
    public void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVideoUpdateStrategy) == null) {
            this.b.v1(iVideoUpdateStrategy);
        }
    }

    public final BdVideoAd f(nn0 nn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nn0Var)) == null) {
            if (nn0Var == null) {
                return null;
            }
            BdVideoAd.b bVar = new BdVideoAd.b();
            bVar.b(nn0Var);
            bVar.c(true);
            return bVar.a();
        }
        return (BdVideoAd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yp0
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.b.a0(z);
        }
    }

    @Override // com.baidu.tieba.yp0
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.b.t0(z);
        }
    }

    @Override // com.baidu.tieba.yp0
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.b.z0(i);
        }
    }

    @Override // com.baidu.tieba.wp0
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.E();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wp0
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.U();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wp0
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.W();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yp0
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.c0();
        }
    }

    @Override // com.baidu.tieba.aq0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.e0();
        }
    }

    @Override // com.baidu.tieba.yp0
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.j0();
        }
    }

    @Override // com.baidu.tieba.yp0
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.I0();
        }
    }

    @Override // com.baidu.tieba.aq0
    public void c(@NonNull ln0 ln0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ln0Var) == null) {
            BdVideoSeries c = j31.c(ln0Var.j);
            IVideoUpdateStrategy i1 = this.b.i1();
            if (c != null) {
                c.setVideoAd(f(ln0Var.i));
                if (i1.h()) {
                    i = 0;
                } else {
                    i = -1;
                }
                c.setStartPosition(i);
                c.setPlayLoop(i1.e());
                this.b.w1(c);
            } else if (!rp0.f()) {
            } else {
                throw new IllegalArgumentException("Invalid video info");
            }
        }
    }
}
