package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RTCCommStatesReport;
import com.baidu.rtc.RTCLoadManager;
import com.baidu.rtc.player.BRTCPlayer;
import com.baidu.rtc.player.BRTCPlayerEvents;
import com.baidu.rtc.player.PlayTimeStatistician;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.IPlayerViewable;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dl7 extends cl7 implements LivePlayer, IPlayerViewable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbBRTCPlayerView o;
    public boolean p;
    public BuildParams q;
    public RTCCommStatesReport r;
    public UniversalPlayerCallbackManager s;
    public String t;

    /* loaded from: classes3.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl7 a;

        /* renamed from: com.baidu.tieba.dl7$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0233a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0233a(a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.c.a.e) == null) {
                    return;
                }
                int i = this.a;
                iVideoPlayerCallback.onError(i, 0, this.b + this.c.a.t);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.a.a.e) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(904, 0);
                this.a.a.e.onInfo(3, 0);
                this.a.a.e.onInfo(910, 0);
                this.a.a.e.onInfo(702, 0);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ a c;

            public c(a aVar, int i, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.c.a.e) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(this.a, 0);
                if (this.a == 1003 && this.c.a.o.l()) {
                    Object obj = this.b;
                    if (obj instanceof RTCCommStatesReport) {
                        this.c.a.r = (RTCCommStatesReport) obj;
                    }
                    this.c.a.e.onInfo(910, 0);
                    return;
                }
                int i = this.a;
                if (i == 1004) {
                    this.c.a.e.onBufferStart();
                    this.c.a.e.onInfo(701, 0);
                } else if (i == 1005) {
                    this.c.a.e.onBufferEnd();
                    this.c.a.e.onInfo(702, 0);
                } else if (i == 1008) {
                    this.c.a.j(this.b);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public d(a aVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.c.a.e) == null) {
                    return;
                }
                iVideoPlayerCallback.onVideoSizeChanged(this.a, this.b);
            }
        }

        public a(dl7 dl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl7Var;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i, String str) {
            dl7 dl7Var;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || (tbBRTCPlayerView = (dl7Var = this.a).o) == null || dl7Var.e == null) {
                return;
            }
            tbBRTCPlayerView.post(new RunnableC0233a(this, i, str));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a("onFirstFrameRendered invoked");
                dl7 dl7Var = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = dl7Var.o;
                if (tbBRTCPlayerView == null || dl7Var.e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new b(this));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onInfoUpdated i= " + i + " s= " + obj);
                dl7 dl7Var2 = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = dl7Var2.o;
                if (tbBRTCPlayerView == null || dl7Var2.e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new c(this, i, obj));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onPlayerStateChanged " + playerState.name());
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onRemoteData " + byteBuffer);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onRemoteStreamStats hasVideo: " + z + "hasAudio: " + z2 + " handleID: " + bigInteger);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onResolutionChanged " + i + " " + i2);
                dl7 dl7Var2 = this.a;
                TbBRTCPlayerView tbBRTCPlayerView = dl7Var2.o;
                if (tbBRTCPlayerView == null || dl7Var2.e == null) {
                    return;
                }
                tbBRTCPlayerView.post(new d(this, i, i2));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
                dl7 dl7Var = this.a;
                dl7Var.f("onSEIRecv " + byteBuffer);
                this.a.e(10103, 0, byteBuffer);
            }
        }
    }

    public dl7(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buildParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = buildParams;
        this.s = new UniversalPlayerCallbackManager();
        k();
        l();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && TbadkCoreApplication.getInst().isMainProcess(false)) {
            RTCLoadManager.getInstance(TbadkCoreApplication.getInst().getContext()).loadLibraries("armeabi", null);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    public void attachKernelView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (view2 instanceof TbBRTCPlayerView) {
                this.o = (TbBRTCPlayerView) view2;
            }
            attachToContainer(this.i);
        }
    }

    @Override // com.baidu.tieba.cl7, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            a("attachToContainer " + viewGroup);
            super.attachToContainer(viewGroup);
            if (this.o == null) {
                c(viewGroup.getContext());
                TbBRTCPlayerView tbBRTCPlayerView = new TbBRTCPlayerView(viewGroup.getContext());
                this.o = tbBRTCPlayerView;
                tbBRTCPlayerView.setParams(this.q);
                this.o.setBRTCPlayerEvents(new a(this));
            }
            TbBRTCPlayerView tbBRTCPlayerView2 = this.o;
            if (tbBRTCPlayerView2 == null || tbBRTCPlayerView2.getParent() == viewGroup) {
                return;
            }
            this.o.f(viewGroup);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a("detachFromContainer ");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.h();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    @Nullable
    public View detachKernelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            detachFromContainer();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public Object getInfo(Object obj, @Nullable Object obj2, @Nullable LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, obj, obj2, infoCallback)) == null) {
            if ("video_fps".equals(obj)) {
                return Integer.valueOf(this.r.getVideoOutputFps());
            }
            if ("getUri".equals(obj)) {
                return getVideoUrl();
            }
            if ("player_id".equals(obj)) {
                TbBRTCPlayerView tbBRTCPlayerView = this.o;
                if (tbBRTCPlayerView != null) {
                    return Long.valueOf(tbBRTCPlayerView.getPlayerID());
                }
                return null;
            } else if ("firtFrameTimePart".equals(obj)) {
                return this.t;
            } else {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void getKernalScreenshot(@NonNull LivePlayer.KernalScreenshotListener kernalScreenshotListener, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048582, this, kernalScreenshotListener, f) == null) || kernalScreenshotListener == null) {
            return;
        }
        kernalScreenshotListener.onResult(null, 0, 0);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RTCCommStatesReport rTCCommStatesReport = this.r;
            return rTCCommStatesReport != null ? rTCCommStatesReport.getRemoteAddr() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            return tbBRTCPlayerView != null ? tbBRTCPlayerView.getVideoUrl() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            return tbBRTCPlayerView != null && tbBRTCPlayerView.l();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isUseCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isUseLivePreStartPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, obj) == null) && (obj instanceof PlayTimeStatistician)) {
            a("time statistic updated ${timeStatistician?.toString()}\nmap: ${timeStatistician?.getTimeStepsMap()}");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<PlayTimeStatistician.PlayStep, Long> entry : ((PlayTimeStatistician) obj).getTimeStepsMap().entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.t = jSONObject.toString();
            a("json ${firtFrameTimePart}");
        }
    }

    public final void k() {
        BuildParams buildParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (buildParams = this.q) == null) {
            return;
        }
        Object option = buildParams.getOption(BuildParams.K_DEBUG_LEVEL, 0);
        if (option instanceof Integer) {
            b(((Integer) option).intValue());
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            a("BRTCPlayer pause");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.m();
                IVideoPlayerCallback iVideoPlayerCallback = this.e;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onPause();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            a("pauseInternal isUserClick= " + z);
            this.p = z;
            pause();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            a("BRTCPlayer play");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.n(str);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.baidu.tieba.cl7, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.release();
            a("BRTCPlayer release");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                this.e = null;
                tbBRTCPlayerView.p();
                this.o = null;
            }
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.i = null;
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removePlayerListener(@Nullable IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iVideoPlayerCallback) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            a("resume isForce= $isForce");
            if (z) {
                resume();
            } else if (this.p) {
            } else {
                resume();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            a("BRTCPlayer resumeFromError");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.s();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        TbBRTCPlayerView tbBRTCPlayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (tbBRTCPlayerView = this.o) == null) {
            return;
        }
        tbBRTCPlayerView.r();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setAcceptVolumeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, hashMap) == null) {
        }
    }

    @Override // com.baidu.tieba.cl7, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.setOrientationLock(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iPlayerStyleSwitchHelper) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setUseLivePreStartPlayerState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, drawable) == null) || drawable == null || this.o == null) {
            return;
        }
        a("setVideoBackground: " + drawable);
        this.o.setBackground(drawable);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, hashMap) == null) {
            a("setVideoInfo${videoInfo?.map " + hashMap);
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.setVideoInfo(hashMap);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            a("BRTCPlayer setVideoUrl url= " + str);
            if (this.o == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.o.setVideoUrl(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            a("BRTCPlayer start");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.t();
                IVideoPlayerCallback iVideoPlayerCallback = this.e;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onStart();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            a("BRTCPlayer stop ");
            TbBRTCPlayerView tbBRTCPlayerView = this.o;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.u();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void updateVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hashMap) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && isPause()) {
            a("resume no force");
            this.o.r();
            IVideoPlayerCallback iVideoPlayerCallback = this.e;
            if (iVideoPlayerCallback != null) {
                iVideoPlayerCallback.onResume();
            }
        }
    }
}
