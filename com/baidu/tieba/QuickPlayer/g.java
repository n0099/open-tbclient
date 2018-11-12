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
    private h buB;
    private MediaPlayer.OnPreparedListener buC = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.QuickPlayer.g.1
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            g.this.notifyOnPrepared();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onPrepared");
        }
    };
    private MediaPlayer.OnCompletionListener buD = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.QuickPlayer.g.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            g.this.notifyOnCompletion();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onCompletion");
        }
    };
    private MediaPlayer.OnSeekCompleteListener buE = new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.tieba.QuickPlayer.g.3
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            g.this.notifyOnSeekComplete();
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onSeekComplete");
        }
    };
    private MediaPlayer.OnVideoSizeChangedListener buF = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.QuickPlayer.g.4
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnVideoSizeChanged(i, i2, 0, 0);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onVideoSizeChanged");
        }
    };
    private MediaPlayer.OnErrorListener buG = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.QuickPlayer.g.5
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnError(-100, i, i2);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onError#" + i + "#" + i2);
            return true;
        }
    };
    private MediaPlayer.OnInfoListener buH = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.QuickPlayer.g.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            g.this.notifyOnInfo(i, i2);
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_onInfo#" + i + "#" + i2);
            return true;
        }
    };
    private h.b buI = new h.b() { // from class: com.baidu.tieba.QuickPlayer.g.7
        @Override // com.baidu.tieba.QuickPlayer.h.b
        public void handleOppoError(String str) {
            MediaStatusCacheQueue.getInstance().insertData(g.this.hashCode(), "_handleOppoError#" + str);
            g.this.notifyOppoError(str);
        }
    };

    public g() {
        MediaStatusCacheQueue.getInstance().insertData(hashCode(), "SystemMediaPlayer@" + hashCode() + "_new");
        this.buB = new h();
        this.buB.setOnPreparedListener(this.buC);
        this.buB.setOnCompletionListener(this.buD);
        this.buB.setOnSeekCompleteListener(this.buE);
        this.buB.setOnVideoSizeChangedListener(this.buF);
        this.buB.setOnErrorListener(this.buG);
        this.buB.setOnInfoListener(this.buH);
        this.buB.a(this.buI);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.buB.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.buB.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.buB.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.buB.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.buB.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.buB.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException {
        try {
            this.buB.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        try {
            this.buB.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException {
        try {
            this.buB.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.buB.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.buB.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.buB.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.buB.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws IllegalStateException {
        try {
            this.buB.seekTo((int) j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.buB.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.buB.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.buB.release();
        MediaStatusCacheQueue.getInstance().removeData(hashCode());
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.buB.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.buB.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.buB.getAudioSessionId();
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
        this.buB.setAudioStreamType(i);
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
        this.buB.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.buB.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.buB.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.buB.setSurface(surface);
    }
}
