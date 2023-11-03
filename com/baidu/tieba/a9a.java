package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.interfaces.INeuronSetupHelper;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.plugin.KernelAutoSwitchPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.ubc.CoreStatPlugin;
import com.baidu.searchbox.player.ubc.DurationStatPlugin;
import com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher;
import com.baidu.searchbox.player.utils.TraceUtil;
import com.baidu.tieba.sj0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a9a extends UniversalPlayer implements p8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public IUbcPlayerStatusFetcher b;

    @Override // com.baidu.searchbox.player.UniversalPlayer
    public void enableOrientationEventHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public int getPlayerStageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 24;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements IUbcPlayerStatusFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a9a a;

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        @NonNull
        public String getPlayErrorPart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        @NonNull
        public String getVideoInfoEnterFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public a(a9a a9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a9aVar;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.getPosition();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getKernelLogId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return TraceUtil.getLogId(this.a.getVideoSeries());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getLaunchSpeedScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return sj0.a.a().getLaunchSpeedScore();
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getPlayType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return invokeV.intValue;
            }
            return this.a.a;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.getVideoUrl();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getSessionId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return TraceUtil.getSessionId(this.a.getVideoSeries());
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getStaticDeviceScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return sj0.a.a().getStaticDeviceScore();
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getTraceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return TraceUtil.getTraceId(this.a.getVideoSeries());
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements INeuronSetupHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a9a a;

        public b(a9a a9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a9aVar;
        }

        @Override // com.baidu.searchbox.player.interfaces.INeuronSetupHelper
        public void setupInternalNeuron(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                this.a.addPlugin(new KernelAutoSwitchPlugin());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a9a(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.mLayerContainer.setClickable(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a9a(@Nullable Context context, @Nullable String str) {
        super(context, "", str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.mLayerContainer.setClickable(false);
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            BaseKernelLayer playerKernelLayer = getPlayerKernelLayer();
            if (playerKernelLayer != null) {
                str2 = playerKernelLayer.getVideoUrl();
            } else {
                str2 = null;
            }
            if (qd.isEquals(str, str2) && PlayerStatus.isActiveStatus(playerKernelLayer.getStatus())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupKernelLayer(@Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, baseKernelLayer) == null) {
            super.setupKernelLayer(c(this, baseKernelLayer));
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            this.mKernelLayer.setAcceptVolumeChange(false);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            super.setupPlugin(context);
            addPlugin(new CoreStatPlugin());
            addPlugin(new DurationStatPlugin());
        }
    }

    public final BaseKernelLayer c(BDVideoPlayer bDVideoPlayer, BaseKernelLayer baseKernelLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDVideoPlayer, baseKernelLayer)) == null) {
            if (baseKernelLayer == null) {
                baseKernelLayer = getReuseHelper().getValidCache(bDVideoPlayer, bDVideoPlayer.getKLayerCacheKey());
            }
            if (baseKernelLayer == null) {
                return new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER);
            }
            return baseKernelLayer;
        }
        return (BaseKernelLayer) invokeLL.objValue;
    }

    public boolean g(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, onSnapShotFrameListener, f)) == null) {
            try {
                if (this.mKernelLayer == null) {
                    return false;
                }
                return this.mKernelLayer.takeSnapshotAsync(onSnapShotFrameListener, f);
            } catch (OutOfMemoryError unused) {
                return false;
            }
        }
        return invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            super.setOption(str, str2);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setVideoSeries(@NonNull BasicVideoSeries basicVideoSeries, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, basicVideoSeries, z) == null) {
            super.setVideoSeries(basicVideoSeries, z);
        }
    }

    public void d() {
        PlayerEventTrigger playerEventTrigger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (playerEventTrigger = getPlayerEventTrigger()) != null) {
            playerEventTrigger.ignoreInfoEventFilter(true);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void doPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.doPlay();
            this.mProgressHelper.start();
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer
    @Nullable
    public INeuronSetupHelper getNeuronSetupHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new b(this);
        }
        return (INeuronSetupHelper) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer
    public void initHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mProgressHelper = new b9a(this);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView)) {
                return ((CyberVideoView) this.mKernelLayer.getContentView()).isPlaying();
            }
            return super.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onCompletion();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onSeekComplete();
            this.mProgressHelper.start();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.pause();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.release();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.resume();
            this.mProgressHelper.start();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (isPause()) {
                resume();
            } else {
                super.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.stop();
            this.mProgressHelper.cancel();
        }
    }

    public void e(e9a e9aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, e9aVar) != null) || e9aVar == null) {
            return;
        }
        this.a = e9aVar.f;
        updateStatisticsContent(new BDVideoPlayerUbcContent.Builder().extLog(e9aVar.a).url(e9aVar.b).id(e9aVar.c).from(e9aVar.d).page(e9aVar.e).playerStatusFetcher(this.b).build());
    }

    public void f(float f, float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            boolean z2 = true;
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0 && f2 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            setGlobalMuteMode(z);
            if (i == 0 && f2 == 0.0f) {
                abandonAudioFocus();
            } else {
                requestAudioFocus();
            }
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView) && ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer() != null) {
                ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer().setVolume(f, f2);
            } else {
                mute((i == 0 && f2 == 0.0f) ? false : false);
            }
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            this.mProgressHelper.cancel();
            return super.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }
}
