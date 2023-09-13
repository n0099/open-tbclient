package com.baidu.tieba;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class dmb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0328, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(12);
        r4.c("IS_CAN_USE_WRITE_EXTERNAL");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0344, code lost:
        if (r3.containsKey(13) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0346, code lost:
        r3 = (com.baidu.tieba.ulb) r3.get(13);
        r3.c("GET_DEV_OAID");
        r1.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0358, code lost:
        r13.d(r1);
        r13.b(1);
        r2.add(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        if (r4 != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (0 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        r5 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (r3.containsKey(1) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
        r1 = (com.baidu.tieba.ulb) r3.get(1);
        r1.c("SDK初始化");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        r1 = new com.baidu.tieba.ulb();
        r1.c("SDK初始化");
        r1.g("0");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
        if (r3.containsKey(2) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
        r1 = (com.baidu.tieba.ulb) r3.get(2);
        r1.c("代码混淆");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r1 = new com.baidu.tieba.ulb();
        r1.c("代码混淆");
        r1.g("0");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d4, code lost:
        if (r3.containsKey(3) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d6, code lost:
        r1 = (com.baidu.tieba.ulb) r3.get(3);
        r1.c("provider");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e7, code lost:
        r1 = new com.baidu.tieba.ulb();
        r1.c("provider");
        r1.g("0");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0101, code lost:
        if (r3.containsKey(14) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0103, code lost:
        r1 = (com.baidu.tieba.ulb) r3.get(14);
        r1.c("UseTextureView");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0114, code lost:
        r1 = new com.baidu.tieba.ulb();
        r1.c("UseTextureView");
        r1.g("0");
        r2.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0122, code lost:
        r1 = new com.baidu.tieba.ulb();
        r1.c("权限配置");
        r4 = new java.util.ArrayList();
        r6 = r13.getPackageManager();
        r7 = new com.baidu.tieba.ulb();
        r7.c("INTERNET");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x014b, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.a, r13.getPackageName()) != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x014d, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014f, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0150, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("READ_PHONE_STATE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016a, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.c, r13.getPackageName()) != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016c, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016e, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016f, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("ACCESS_NETWORK_STATE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0189, code lost:
        if (r6.checkPermission("android.permission.ACCESS_NETWORK_STATE", r13.getPackageName()) != 0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x018b, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x018d, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x018e, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("WRITE_EXTERNAL_STORAGE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a8, code lost:
        if (r6.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", r13.getPackageName()) != 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01aa, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ac, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ad, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("ACCESS_WIFI_STATE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c7, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.d, r13.getPackageName()) != 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c9, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01cb, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01cc, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("ACCESS_COARSE_LOCATION");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01e6, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.h, r13.getPackageName()) != 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e8, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ea, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01eb, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("REQUEST_INSTALL_PACKAGES");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0209, code lost:
        if (b(r13.getApplicationContext().getPackageResourcePath(), "android.permission.REQUEST_INSTALL_PACKAGES") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x020b, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020d, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x020e, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("GET_TASKS");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0228, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.e, r13.getPackageName()) != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x022a, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x022c, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x022d, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("ACCESS_FINE_LOCATION");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0247, code lost:
        if (r6.checkPermission(com.kuaishou.weapon.p0.h.g, r13.getPackageName()) != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0249, code lost:
        r8 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x024b, code lost:
        r8 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x024c, code lost:
        r7.g(r8);
        r4.add(r7);
        r7 = new com.baidu.tieba.ulb();
        r7.c("WAKE_LOCK");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0266, code lost:
        if (r6.checkPermission("android.permission.WAKE_LOCK", r13.getPackageName()) != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0268, code lost:
        r5 = "1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0269, code lost:
        r7.g(r5);
        r4.add(r7);
        r1.d(r4);
        r1.b(1);
        r2.add(r1);
        r13 = new com.baidu.tieba.ulb();
        r13.c("隐私配置");
        r1 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0290, code lost:
        if (r3.containsKey(7) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0292, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(7);
        r4.c("IS_CAN_USE_LOCATION");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02ae, code lost:
        if (r3.containsKey(8) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02b0, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(8);
        r4.c("GET_TT_LOCATION");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02cc, code lost:
        if (r3.containsKey(9) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02ce, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(9);
        r4.c("IS_CAN_USE_PHONESTATE");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02ea, code lost:
        if (r3.containsKey(10) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02ec, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(10);
        r4.c("GET_DEV_IMEI");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0308, code lost:
        if (r3.containsKey(11) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x030a, code lost:
        r4 = (com.baidu.tieba.ulb) r3.get(11);
        r4.c("IS_CAN_USE_WIFI_STATE");
        r1.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0326, code lost:
        if (r3.containsKey(12) == false) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<ulb> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context != null && context.getApplicationContext() != null) {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                Cursor cursor = null;
                try {
                    try {
                        cursor = bmb.b(context, "setting_global_info", new String[]{"_id", "value"}, null, null, null, null, null);
                        if (cursor == null) {
                            return arrayList;
                        }
                        while (cursor.moveToNext()) {
                            try {
                                int i = cursor.getInt(cursor.getColumnIndex("_id"));
                                String string = cursor.getString(cursor.getColumnIndex("value"));
                                ulb ulbVar = new ulb();
                                ulbVar.g(zlb.g(string));
                                hashMap.put(Integer.valueOf(i), ulbVar);
                            } catch (Exception unused) {
                            }
                        }
                    } finally {
                        if (0 != 0) {
                            cursor.close();
                        }
                    }
                } catch (Exception unused2) {
                }
            } else {
                return new ArrayList();
            }
        } else {
            return (List) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
        if (0 == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                XmlResourceParser xmlResourceParser = null;
                try {
                    AssetManager assetManager = (AssetManager) Class.forName("android.content.res.AssetManager").newInstance();
                    xmlResourceParser = assetManager.openXmlResourceParser(((Integer) assetManager.getClass().getMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(assetManager, str)).intValue(), "AndroidManifest.xml");
                    if (xmlResourceParser == null) {
                        if (xmlResourceParser != null) {
                            xmlResourceParser.close();
                        }
                        return false;
                    }
                    while (xmlResourceParser.next() != 1) {
                        if (xmlResourceParser.getEventType() == 2 && "uses-permission".equals(xmlResourceParser.getName()) && str2.equals(xmlResourceParser.getAttributeValue(0))) {
                            if (xmlResourceParser != null) {
                                xmlResourceParser.close();
                            }
                            return true;
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    if (0 != 0) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r3 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (0 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        return "pangolin.snssdk.com";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        InterceptResult invokeL;
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = bmb.b(context, "setting_global_info", new String[]{"_id", "value"}, null, null, null, null, null);
                    if (cursor == null) {
                        return "pangolin.snssdk.com";
                    }
                    while (cursor.moveToNext()) {
                        try {
                            i = cursor.getInt(cursor.getColumnIndex("_id"));
                            string = cursor.getString(cursor.getColumnIndex("value"));
                        } catch (Exception unused) {
                        }
                        if (i == 15) {
                            String g = zlb.g(string);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return g;
                        }
                        continue;
                    }
                } finally {
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Exception unused2) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r3 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (0 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        InterceptResult invokeL;
        int i;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = bmb.b(context, "setting_global_info", new String[]{"_id", "value"}, null, null, null, null, null);
                    if (cursor == null) {
                        return "";
                    }
                    while (cursor.moveToNext()) {
                        try {
                            i = cursor.getInt(cursor.getColumnIndex("_id"));
                            string = cursor.getString(cursor.getColumnIndex("value"));
                        } catch (Exception unused) {
                        }
                        if (i == 16) {
                            String g = zlb.g(string);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return g;
                        }
                        continue;
                    }
                } finally {
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Exception unused2) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
