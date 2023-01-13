package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.model.HistoryCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.fn0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes4.dex */
public class cz0 extends yy0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HistoryCache e;
    public transient /* synthetic */ FieldHolder $fh;
    public ky0 d;

    /* loaded from: classes4.dex */
    public static final class a implements fn0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdVideoSeries a;
        public final /* synthetic */ BdVideoSeries b;

        public a(BdVideoSeries bdVideoSeries, cz0 cz0Var, BdVideoSeries bdVideoSeries2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoSeries, cz0Var, bdVideoSeries2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdVideoSeries;
            this.b = bdVideoSeries2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947691920, "Lcom/baidu/tieba/cz0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947691920, "Lcom/baidu/tieba/cz0;");
                return;
            }
        }
        e = new HistoryCache();
    }

    public cz0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sv0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{4, 5, 7};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.m();
            this.d = null;
        }
    }

    public final void r() {
        yr0 i;
        BdVideoSeries videoSeries;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (i = i()) != null && (videoSeries = i.o1()) != null) {
            Intrinsics.checkNotNullExpressionValue(videoSeries, "videoSeries");
            jy0.b(videoSeries, 0, videoSeries.getDurationMs());
            y(videoSeries);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yy0
    /* renamed from: t */
    public yr0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            xr0 i = super.i();
            if (!(i instanceof yr0)) {
                i = null;
            }
            return (yr0) i;
        }
        return (yr0) invokeV.objValue;
    }

    public final void A(BdVideoSeries bdVideoSeries) {
        yr0 i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) && (i = i()) != null) {
            ny0 videoTask = i.K();
            Intrinsics.checkNotNullExpressionValue(videoTask, "videoTask");
            p(videoTask, bdVideoSeries);
            if (i.Z() || i.Y() || i.W()) {
                z(i);
            }
        }
    }

    @Override // com.baidu.tieba.yy0, com.baidu.tieba.az0
    public void g(ru0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.g(event);
            String c = event.c();
            int hashCode = c.hashCode();
            Object obj = null;
            if (hashCode != -1026415353) {
                if (hashCode == 1671611006 && c.equals("plugin_event_load_player_history")) {
                    Object f = event.f(1);
                    if (f instanceof BdVideoSeries) {
                        obj = f;
                    }
                    w((BdVideoSeries) obj);
                }
            } else if (c.equals("plugin_event_save_player_history")) {
                Object f2 = event.f(1);
                if (f2 instanceof BdVideoSeries) {
                    obj = f2;
                }
                BdVideoSeries bdVideoSeries = (BdVideoSeries) obj;
                if (bdVideoSeries != null) {
                    y(bdVideoSeries);
                }
            }
        }
    }

    public final void w(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bdVideoSeries) == null) && i() != null && bdVideoSeries != null) {
            if (v(bdVideoSeries)) {
                bdVideoSeries.setPosition(bdVideoSeries.getStartPosition());
                bdVideoSeries.setStartPosition(-1);
                A(bdVideoSeries);
                return;
            }
            String u = u(bdVideoSeries);
            ky0 findCache = e.findCache(u, bdVideoSeries.getVid());
            if (findCache != null) {
                x(findCache, bdVideoSeries);
                A(bdVideoSeries);
                return;
            }
            fn0.b.a().a(u, bdVideoSeries.getVid(), new a(bdVideoSeries, this, bdVideoSeries));
        }
    }

    public final void z(yr0 yr0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, yr0Var) == null) && yr0Var != null) {
            a01.a("seekToTarget(player@" + System.identityHashCode(yr0Var) + "),  position is " + yr0Var.K().f + " ms .[" + this + ']');
            if (yr0Var.K().f > 0) {
                yr0Var.p0(yr0Var.K().f);
            }
        }
    }

    @Override // com.baidu.tieba.yy0, com.baidu.tieba.sv0
    public void h(PlayerStatus status, PlayerStatus old) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, status, old) == null) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(old, "old");
            super.h(status, old);
            int i = bz0.$EnumSwitchMapping$0[status.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    r();
                    return;
                }
                return;
            }
            z(i());
        }
    }

    public final void p(ny0 ny0Var, BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ny0Var, bdVideoSeries) == null) {
            ny0Var.d = Math.max(0, bdVideoSeries.getPosition());
            ny0Var.f = Math.max(0, bdVideoSeries.getPositionMs());
            int max = Math.max(0, bdVideoSeries.getDuration());
            ny0Var.e = max;
            if (ny0Var.d > max) {
                ny0Var.e = 0;
                ny0Var.d = 0;
                ny0Var.f = 0;
            }
        }
    }

    public final boolean s(BdVideoSeries bdVideoSeries, String str) {
        InterceptResult invokeLL;
        String str2;
        ky0 ky0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries, str)) == null) {
            ky0 findCache = e.findCache(str, bdVideoSeries.getVid());
            int positionMs = bdVideoSeries.getPositionMs();
            if (findCache != null && positionMs == findCache.g()) {
                return true;
            }
            ky0 ky0Var2 = this.d;
            if (ky0Var2 != null) {
                str2 = ky0Var2.e();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, bdVideoSeries.getVid()) && (ky0Var = this.d) != null && ky0Var.g() == bdVideoSeries.getPositionMs()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public String u(BdVideoSeries videoSeries) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, videoSeries)) == null) {
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                str = selectedVideo.getSourceUrl();
            } else {
                str = null;
            }
            String a2 = ky0.a(str);
            if (a2 == null) {
                return "";
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    public final boolean v(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdVideoSeries)) == null) {
            if (bdVideoSeries.getStartPosition() >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x(ky0 info, BdVideoSeries videoSeries) {
        int i;
        int i2;
        Integer intOrNull;
        Integer intOrNull2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, info, videoSeries) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            String f = info.f();
            int i3 = 0;
            if (f != null && (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(f)) != null) {
                i = intOrNull2.intValue();
            } else {
                i = 0;
            }
            String h = info.h();
            if (h != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(h)) != null) {
                i2 = intOrNull.intValue();
            } else {
                i2 = 0;
            }
            if (videoSeries.getDuration() <= 0) {
                videoSeries.setDurationMs(i2 * 1000);
            }
            if (i > 0 && i == i2) {
                info.q("0");
            } else {
                i3 = i;
            }
            if (info.g() > 0) {
                videoSeries.setPositionMs(info.g());
            } else {
                videoSeries.setPositionMs(i3 * 1000);
            }
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                selectedVideo.setCurrentLength(info.f());
            }
            BdVideo selectedVideo2 = videoSeries.getSelectedVideo();
            if (selectedVideo2 != null) {
                selectedVideo2.setTotalLength(String.valueOf(videoSeries.getDuration()));
            }
        }
    }

    public final void y(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdVideoSeries) == null) {
            a01.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + ") begin, save history" + bdVideoSeries + ".[" + this + ']');
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                Intrinsics.checkNotNullExpressionValue(selectedVideo, "videoSeries.selectedVideo ?: return");
                String u = u(bdVideoSeries);
                if (Intrinsics.areEqual(selectedVideo.getCurrentLength(), "0")) {
                    a01.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), del when currentLength is 0,  history" + bdVideoSeries + ".[" + this + ']');
                    y41.b().b(u, bdVideoSeries.getVid());
                    e.removeCache(u, bdVideoSeries.getVid());
                } else if (s(bdVideoSeries, u)) {
                } else {
                    ky0 info = wu0.a(bdVideoSeries, selectedVideo, selectedVideo.getSourceUrl(), u);
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    if (!info.i()) {
                        return;
                    }
                    this.d = info;
                    String vid = bdVideoSeries.getVid();
                    Intrinsics.checkNotNullExpressionValue(vid, "videoSeries.vid");
                    if ((!StringsKt__StringsJVMKt.isBlank(vid)) || (!StringsKt__StringsJVMKt.isBlank(u))) {
                        e.add(info);
                    }
                    a01.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), info is {" + info + "}.[" + this + ']');
                    y41.b().a(ej0.b(), info, false);
                }
            }
        }
    }
}
