package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.tbadk.MediaStatusCacheQueue;
import com.baidu.tieba.QuickPlayer.h;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.AbstractMediaPlayer;
import tv.danmaku.ijk.media.player.ITrackInfo;
import tv.danmaku.ijk.media.player.MediaInfo;
/* loaded from: classes5.dex */
public class g extends AbstractMediaPlayer {
    private h bxY;
    private MediaPlayer.OnPreparedListener bxZ = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.QuickPlayer.g.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            g.this.notifyOnPrepared();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onPrepared");
        }
    };
    private MediaPlayer.OnCompletionListener bya = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.QuickPlayer.g.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            g.this.notifyOnCompletion();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onCompletion");
        }
    };
    private MediaPlayer.OnSeekCompleteListener byb = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.QuickPlayer.g.3
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            g.this.notifyOnSeekComplete();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onSeekComplete");
        }
    };
    private MediaPlayer.OnVideoSizeChangedListener byc = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.QuickPlayer.g.4
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnVideoSizeChanged(i, i2, 0, 0);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onVideoSizeChanged");
        }
    };
    private MediaPlayer.OnErrorListener byd = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.QuickPlayer.g.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnError(-100, i, i2);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onError#" + i + "#" + i2);
            return true;
        }
    };
    private MediaPlayer.OnInfoListener bye = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.QuickPlayer.g.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnInfo(i, i2);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onInfo#" + i + "#" + i2);
            return true;
        }
    };
    private h.b byf = new h.b() { // from class: com.baidu.tieba.QuickPlayer.g.7
        @Override // com.baidu.tieba.QuickPlayer.h.b
        public void handleOppoError(String str) {
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_handleOppoError#" + str);
            g.this.notifyOppoError(str);
        }
    };

    public g() {
        MediaStatusCacheQueue.getInstance().insertData(hashCode(), "SystemMediaPlayer@" + hashCode() + "_new");
        this.bxY = new h();
        this.bxY.setOnPreparedListener(this.bxZ);
        this.bxY.setOnCompletionListener(this.bya);
        this.bxY.setOnSeekCompleteListener(this.byb);
        this.bxY.setOnVideoSizeChangedListener(this.byc);
        this.bxY.setOnErrorListener(this.byd);
        this.bxY.setOnInfoListener(this.bye);
        this.bxY.a(this.byf);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.bxY.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.bxY.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.bxY.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.bxY.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.bxY.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.bxY.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        try {
            this.bxY.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        try {
            this.bxY.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        try {
            this.bxY.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.bxY.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.bxY.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.bxY.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.bxY.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        try {
            this.bxY.seekTo((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.bxY.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.bxY.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.bxY.release();
        MediaStatusCacheQueue.getInstance().removeData(hashCode());
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.bxY.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.bxY.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.bxY.getAudioSessionId();
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
        this.bxY.setAudioStreamType(i);
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
        this.bxY.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.bxY.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.bxY.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.bxY.setSurface(surface);
    }
}
