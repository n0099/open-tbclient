package com.baidu.tieba.QuickPlayer;

import android.net.Uri;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: classes10.dex */
public interface a {
    void addPlayer(IMediaPlayer iMediaPlayer, Uri uri);

    List<String> getMediaIDs();

    IMediaPlayer getPlayer(Uri uri);

    boolean isExistInRemote(IMediaPlayer iMediaPlayer);

    void removePlayer(Uri uri);
}
