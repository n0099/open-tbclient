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
    private static final SparseArray<Integer> bIR = new SparseArray<>(32);

    static {
        bIR.put(10015, 2001);
        bIR.put(10013, 2002);
        bIR.put(904, 2003);
        bIR.put(10012, 2004);
        bIR.put(10004, 2006);
        bIR.put(701, 2007);
        bIR.put(10005, 2008);
        bIR.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        bIR.put(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, -2301);
        bIR.put(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, 2101);
        bIR.put(923, Integer.valueOf((int) SubPackageAPSInfo.RESULT_APS_DOWNLOAD_ERROR));
        bIR.put(10009, 2105);
        bIR.put(10010, Integer.valueOf((int) MsgField.IMSG_CLOUDAR_RECG_RESULT));
        bIR.put(10003, 2107);
        bIR.put(10011, 2108);
        bIR.put(10014, 3001);
        bIR.put(ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC, Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_LUA_CALL_SDK_FUC));
        bIR.put(3003, 3003);
        bIR.put(3004, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_START));
    }

    public static int hX(int i) {
        if (bIR.indexOfKey(i) < 0) {
            return 100;
        }
        return bIR.get(i).intValue();
    }

    public static String hY(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
