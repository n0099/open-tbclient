package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.ITrackInfo;
import tv.danmaku.ijk.media.player.MediaInfo;
/* loaded from: classes.dex */
public class v extends AbstractMediaPlayer {
    private MediaPlayer.OnPreparedListener aQS = new w(this);
    private MediaPlayer.OnCompletionListener aQT = new x(this);
    private MediaPlayer.OnSeekCompleteListener aQU = new y(this);
    private MediaPlayer.OnVideoSizeChangedListener aQV = new z(this);
    private MediaPlayer.OnErrorListener aQW = new aa(this);
    private MediaPlayer.OnInfoListener aQX = new ab(this);
    private MediaPlayer aQR = new MediaPlayer();

    public v() {
        this.aQR.setOnPreparedListener(this.aQS);
        this.aQR.setOnCompletionListener(this.aQT);
        this.aQR.setOnSeekCompleteListener(this.aQU);
        this.aQR.setOnVideoSizeChangedListener(this.aQV);
        this.aQR.setOnErrorListener(this.aQW);
        this.aQR.setOnInfoListener(this.aQX);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.aQR.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.aQR.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.aQR.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.aQR.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.aQR.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.aQR.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        try {
            this.aQR.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        try {
            this.aQR.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        try {
            this.aQR.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.aQR.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.aQR.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.aQR.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.aQR.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        try {
            this.aQR.seekTo((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.aQR.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.aQR.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.aQR.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.aQR.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.aQR.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.aQR.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.aQR.setAudioStreamType(i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
        this.aQR.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.aQR.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.aQR.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.aQR.setSurface(surface);
    }
}
