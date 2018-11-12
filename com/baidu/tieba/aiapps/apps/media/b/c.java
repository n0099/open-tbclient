package com.baidu.tieba.aiapps.apps.media.b;

import android.util.SparseArray;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    private static final SparseArray<Integer> bFo = new SparseArray<>(32);

    static {
        bFo.put(10015, 2001);
        bFo.put(10013, 2002);
        bFo.put(904, 2003);
        bFo.put(10012, 2004);
        bFo.put(10004, 2006);
        bFo.put(701, 2007);
        bFo.put(10005, 2008);
        bFo.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        bFo.put(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, -2301);
        bFo.put(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, 2101);
        bFo.put(923, Integer.valueOf((int) SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR));
        bFo.put(10009, 2105);
        bFo.put(10010, Integer.valueOf((int) MsgField.IMSG_CLOUDAR_RECG_RESULT));
        bFo.put(10003, 2107);
        bFo.put(10011, 2108);
        bFo.put(10014, 3001);
        bFo.put(ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC, Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC));
        bFo.put(3003, 3003);
        bFo.put(3004, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_START));
    }

    public static int hJ(int i) {
        if (bFo.indexOfKey(i) < 0) {
            return 100;
        }
        return bFo.get(i).intValue();
    }

    public static String hK(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
