package com.baidu.tieba.ext.bdplayer.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.swan.games.utils.so.SoUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a extends UniversalPlayer {
    private String hEQ;

    public a(Context context, String str) {
        super(context);
        this.hEQ = str;
        chE();
    }

    public void chE() {
        setOption(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "true");
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, SoUtils.SO_EVENT_ID_DEFAULT);
        hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, this.hEQ);
        setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
    }

    public void b(int i, Map<String, String> map) {
        if (i == 1 && map != null) {
            map.put("type", "20487");
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, map);
        }
    }

    public void setDecodeMode(int i) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setDecodeMode(i);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    protected void onAudioFocusChanged(final int i) {
        Activity activity = getActivity();
        if (activity != null && !isPlayerMute()) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ext.bdplayer.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (i) {
                        case -2:
                        case -1:
                            if (a.this.isPlaying()) {
                                a.this.stop();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }
}
