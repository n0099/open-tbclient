package com.baidu.tieba.QuickPlayer;

import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: classes2.dex */
public interface a {
    void addPlayer(IMediaPlayer iMediaPlayer);

    List<String> getMediaIDs();

    boolean isExistInRemote(IMediaPlayer iMediaPlayer);

    void removePlayer(IMediaPlayer iMediaPlayer);
}
