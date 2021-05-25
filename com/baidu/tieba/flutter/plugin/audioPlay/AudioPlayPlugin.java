package com.baidu.tieba.flutter.plugin.audioPlay;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto;
import d.a.n0.n0.a.a.i;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes4.dex */
public class AudioPlayPlugin implements FlutterPlugin, AudioPlayAuto.HostAudioPlay {
    public VoiceManagerWrapper vmWrapper = new VoiceManagerWrapper();

    /* loaded from: classes4.dex */
    public static class VoiceManagerWrapper implements VoiceManager.i {
        public VoiceManager manager;
        public String pageName;
        public VoiceData$VoiceModel voiceModel;

        public VoiceManagerWrapper() {
            this.pageName = "";
            this.manager = VoiceManager.instance();
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceManager.i getRealView() {
            return null;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceData$VoiceModel getVoiceModel() {
            return this.voiceModel;
        }

        public boolean isPlaying(VoiceData$VoiceModel voiceData$VoiceModel) {
            return this.manager.isPlaying(voiceData$VoiceModel);
        }

        public boolean isSamePage(String str) {
            String str2 = this.pageName;
            return str2 != null && str2.equals(str);
        }

        public boolean onCreate(TbPageContext tbPageContext, String str) {
            if (isSamePage(str)) {
                return false;
            }
            this.pageName = str;
            this.manager.onCreate(tbPageContext);
            return true;
        }

        public void onDestory(TbPageContext tbPageContext, String str) {
            if (isSamePage(str)) {
                this.manager.onDestory(tbPageContext);
                this.pageName = null;
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onPlayElapse(int i2) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onPlayPrepared() {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onShowErr(int i2, String str) {
        }

        public void resetVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
            this.voiceModel = voiceData$VoiceModel;
        }

        public void startPlaying() {
            this.manager.startPlay(this);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void create(AudioPlayAuto.CreateParam createParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            this.vmWrapper.onCreate(((TbPageContextSupport) currentActivity).getPageContext(), createParam.getPageName());
            audioResult.setResult(Boolean.TRUE);
        }
        result.success(audioResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void dispose(AudioPlayAuto.DisposeParam disposeParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            this.vmWrapper.onDestory(((TbPageContextSupport) currentActivity).getPageContext(), disposeParam.getPageName());
            audioResult.setResult(Boolean.TRUE);
        }
        result.success(audioResult);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        i.i(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        i.i(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void play(AudioPlayAuto.PlayParam playParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
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

    @Override // com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayAuto.HostAudioPlay
    public void stop(AudioPlayAuto.StopParam stopParam, AudioPlayAuto.Result<AudioPlayAuto.AudioResult> result) {
        this.vmWrapper.manager.stopPlay();
        AudioPlayAuto.AudioResult audioResult = new AudioPlayAuto.AudioResult();
        audioResult.setResult(Boolean.TRUE);
        result.success(audioResult);
    }
}
