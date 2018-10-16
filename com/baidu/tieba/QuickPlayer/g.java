package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.tieba.QuickPlayer.h;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.ITrackInfo;
import tv.danmaku.ijk.media.player.MediaInfo;
/* loaded from: classes5.dex */
public class g extends AbstractMediaPlayer {
    private MediaPlayer.OnPreparedListener btP = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.QuickPlayer.g.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            g.this.notifyOnPrepared();
        }
    };
    private MediaPlayer.OnCompletionListener btQ = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.QuickPlayer.g.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            g.this.notifyOnCompletion();
        }
    };
    private MediaPlayer.OnSeekCompleteListener btR = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.QuickPlayer.g.3
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            g.this.notifyOnSeekComplete();
        }
    };
    private MediaPlayer.OnVideoSizeChangedListener btS = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.QuickPlayer.g.4
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnVideoSizeChanged(i, i2, 0, 0);
        }
    };
    private MediaPlayer.OnErrorListener btT = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.QuickPlayer.g.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnError(-100, i, i2);
            return true;
        }
    };
    private MediaPlayer.OnInfoListener btU = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.QuickPlayer.g.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnInfo(i, i2);
            return true;
        }
    };
    private h.b btV = new h.b() { // from class: com.baidu.tieba.QuickPlayer.g.7
        @Override // com.baidu.tieba.QuickPlayer.h.b
        public void handleOppoError(String str) {
            g.this.notifyOppoError(str);
        }
    };
    private h btO = new h();

    public g() {
        this.btO.setOnPreparedListener(this.btP);
        this.btO.setOnCompletionListener(this.btQ);
        this.btO.setOnSeekCompleteListener(this.btR);
        this.btO.setOnVideoSizeChangedListener(this.btS);
        this.btO.setOnErrorListener(this.btT);
        this.btO.setOnInfoListener(this.btU);
        this.btO.a(this.btV);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.btO.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.btO.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.btO.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.btO.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.btO.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.btO.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        try {
            this.btO.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        try {
            this.btO.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        try {
            this.btO.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.btO.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.btO.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.btO.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.btO.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        try {
            this.btO.seekTo((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.btO.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.btO.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.btO.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.btO.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.btO.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.btO.getAudioSessionId();
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
        this.btO.setAudioStreamType(i);
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
        this.btO.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.btO.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.btO.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.btO.setSurface(surface);
    }
}
