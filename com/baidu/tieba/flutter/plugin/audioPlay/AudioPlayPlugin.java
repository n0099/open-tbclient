package com.baidu.tieba.flutter.plugin.audioPlay;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.t0.a.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes7.dex */
public class AudioPlayPlugin implements FlutterPlugin, AudioPlayAuto.HostAudioPlay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManagerWrapper vmWrapper;

    /* renamed from: com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayPlugin$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public AudioPlayPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vmWrapper = new VoiceManagerWrapper(null);
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void create(AudioPlayAuto.CreateParam createParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, createParam, result) == null) {
            AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                this.vmWrapper.onCreate(((TbPageContextSupport) currentActivity).getPageContext(), createParam.getPageName());
                audioResult.setResult(Boolean.TRUE);
            }
            result.success(audioResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void dispose(AudioPlayAuto.DisposeParam disposeParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposeParam, result) == null) {
            AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                this.vmWrapper.onDestory(((TbPageContextSupport) currentActivity).getPageContext(), disposeParam.getPageName());
                audioResult.setResult(Boolean.TRUE);
            }
            result.success(audioResult);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterPluginBinding) == null) {
            i.i(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            i.i(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void play(AudioPlayAuto.PlayParam playParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, playParam, result) == null) {
            AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
            String url = playParam.getUrl();
            String duration = playParam.getDuration();
            VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
            voiceData$VoiceModel.voiceId = url;
            voiceData$VoiceModel.duration = Integer.valueOf(duration).intValue();
            if (!this.vmWrapper.isPlaying(voiceData$VoiceModel)) {
                this.vmWrapper.resetVoiceModel(voiceData$VoiceModel);
                this.vmWrapper.startPlaying();
                audioResult.setResult(Boolean.TRUE);
            }
            result.success(audioResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void stop(AudioPlayAuto.StopParam stopParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, stopParam, result) == null) {
            this.vmWrapper.manager.stopPlay();
            AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
            audioResult.setResult(Boolean.TRUE);
            result.success(audioResult);
        }
    }

    /* loaded from: classes7.dex */
    public static class VoiceManagerWrapper implements VoiceManager.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VoiceManager manager;
        public String pageName;
        public VoiceData$VoiceModel voiceModel;

        public VoiceManagerWrapper() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pageName = "";
            this.manager = VoiceManager.instance();
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceManager.i getRealView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (VoiceManager.i) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceData$VoiceModel getVoiceModel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.voiceModel : (VoiceData$VoiceModel) invokeV.objValue;
        }

        public boolean isPlaying(VoiceData$VoiceModel voiceData$VoiceModel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceData$VoiceModel)) == null) ? this.manager.isPlaying(voiceData$VoiceModel) : invokeL.booleanValue;
        }

        public boolean isSamePage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                String str2 = this.pageName;
                return str2 != null && str2.equals(str);
            }
            return invokeL.booleanValue;
        }

        public boolean onCreate(TbPageContext tbPageContext, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, tbPageContext, str)) == null) {
                if (isSamePage(str)) {
                    return false;
                }
                this.pageName = str;
                this.manager.onCreate(tbPageContext);
                return true;
            }
            return invokeLL.booleanValue;
        }

        public void onDestory(TbPageContext tbPageContext, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, str) == null) && isSamePage(str)) {
                this.manager.onDestory(tbPageContext);
                this.pageName = null;
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onPlayElapse(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onPlayPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceData$VoiceModel) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onShowErr(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            }
        }

        public void resetVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, voiceData$VoiceModel) == null) {
                this.voiceModel = voiceData$VoiceModel;
            }
        }

        public void startPlaying() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.manager.startPlay(this);
            }
        }

        public /* synthetic */ VoiceManagerWrapper(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
