package com.baidu.tieba.aiapps.apps.media.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final SparseArray<Integer> dha = new SparseArray<>(32);

    static {
        dha.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        dha.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        dha.put(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 2003);
        dha.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        dha.put(10004, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
        dha.put(CyberPlayerManager.MEDIA_INFO_BUFFERING_START, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
        dha.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        dha.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        dha.put(10007, -2301);
        dha.put(10008, 2101);
        dha.put(CyberPlayerManager.MEDIA_INFO_NET_RECONNECTING, 2103);
        dha.put(10009, 2105);
        dha.put(CyberPlayerManager.MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE, 2106);
        dha.put(10003, 2107);
        dha.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        dha.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        dha.put(CyberPlayerManager.MEDIA_INFO_RTMP_CONNECT_SERVER_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_CONNECT_SERVER_FAIL));
        dha.put(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
        dha.put(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, 3005);
    }

    public static int mN(int i) {
        if (dha.indexOfKey(i) < 0) {
            if (DEBUG) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
            }
            return 100;
        }
        return dha.get(i).intValue();
    }

    public static String mO(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
