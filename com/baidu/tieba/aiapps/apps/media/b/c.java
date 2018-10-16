package com.baidu.tieba.aiapps.apps.media.b;

import android.util.SparseArray;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    private static final SparseArray<Integer> bEC = new SparseArray<>(32);

    static {
        bEC.put(10015, 2001);
        bEC.put(10013, 2002);
        bEC.put(904, 2003);
        bEC.put(10012, 2004);
        bEC.put(10004, 2006);
        bEC.put(701, 2007);
        bEC.put(10005, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_TTS_RESUME));
        bEC.put(10006, 2009);
        bEC.put(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, -2301);
        bEC.put(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, 2101);
        bEC.put(923, Integer.valueOf((int) SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR));
        bEC.put(10009, 2105);
        bEC.put(10010, Integer.valueOf((int) MsgField.IMSG_CLOUDAR_RECG_RESULT));
        bEC.put(10003, 2107);
        bEC.put(10011, 2108);
        bEC.put(10014, 3001);
        bEC.put(ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC, Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC));
        bEC.put(3003, 3003);
        bEC.put(3004, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_START));
    }

    public static int hw(int i) {
        if (bEC.indexOfKey(i) < 0) {
            return 100;
        }
        return bEC.get(i).intValue();
    }

    public static String hx(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
