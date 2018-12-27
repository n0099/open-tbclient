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
    private static final SparseArray<Integer> bIU = new SparseArray<>(32);

    static {
        bIU.put(10015, 2001);
        bIU.put(10013, 2002);
        bIU.put(904, 2003);
        bIU.put(10012, 2004);
        bIU.put(10004, 2006);
        bIU.put(701, 2007);
        bIU.put(10005, 2008);
        bIU.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        bIU.put(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, -2301);
        bIU.put(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, 2101);
        bIU.put(923, Integer.valueOf((int) SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR));
        bIU.put(10009, 2105);
        bIU.put(10010, Integer.valueOf((int) MsgField.IMSG_CLOUDAR_RECG_RESULT));
        bIU.put(10003, 2107);
        bIU.put(10011, 2108);
        bIU.put(10014, 3001);
        bIU.put(ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC, Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC));
        bIU.put(3003, 3003);
        bIU.put(3004, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_START));
    }

    public static int hY(int i) {
        if (bIU.indexOfKey(i) < 0) {
            return 100;
        }
        return bIU.get(i).intValue();
    }

    public static String hZ(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
