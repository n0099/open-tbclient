package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b ciT;
    private com.baidu.tbadk.coreExtra.model.e ciV;
    private String ciY;
    private String ciZ;
    private String cja;
    public static boolean ciJ = true;
    public static boolean ciK = false;
    private static Date ciW = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.anR().b(b.anR().aoo());
            }
        }
    };
    private final HashMap<Integer, HashSet> ciL = new HashMap<>();
    private int ciM = 0;
    private int ciN = 0;
    private int ciO = 0;
    private int ciP = 0;
    private int ciQ = 0;
    private int ciR = 0;
    private int ciS = 0;
    private com.baidu.tbadk.coreExtra.model.e ciU = new com.baidu.tbadk.coreExtra.model.e();
    private boolean ciX = true;
    private final int[] cjb = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b anR() {
        if (ciT == null) {
            ciT = new b();
        }
        return ciT;
    }

    private b() {
    }

    public void bb(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.ciZ = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.ciY = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.cja = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.ciM || i2 != this.ciN || i3 != this.ciO || i4 != this.ciP || i5 != this.ciR || i6 != this.ciQ || i7 != this.ciS) {
            int i8 = 0;
            if (i > this.ciM || i2 > this.ciN || i3 > this.ciO || i4 > this.ciP || i5 > this.ciR || i6 > this.ciQ || i7 > this.ciS) {
                i8 = 1;
            } else if (i < this.ciM || i2 < this.ciN || i3 < this.ciO) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.ciM && d.aoy().aoP()) {
                i9 = 1;
            } else if (i < this.ciM) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.ciN && d.aoy().aoF()) {
                i10 = 1;
            } else if (i2 < this.ciN) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.ciO && d.aoy().aoD()) {
                i11 = 1;
            } else if (i3 < this.ciO) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.ciP) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.ciR) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.ciS) {
                i14 = 1;
            }
            this.ciM = i;
            this.ciN = i2;
            this.ciO = i3;
            this.ciP = i4;
            this.ciR = i5;
            this.ciQ = i6;
            this.ciS = i7;
            if (aom() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                aoj();
                ah(i14, 23);
                ah(i12, 16);
                ah(i8, 17);
                ah(i10, 24);
                ah(i11, 25);
                ah(i13, 26);
                ah(i9, 29);
            }
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.ciM || i2 != this.ciN || i3 != this.ciO || i4 != this.ciP || i5 != this.ciR || this.ciS != i6) {
            this.ciM = i;
            this.ciN = i2;
            this.ciO = i3;
            this.ciP = i4;
            this.ciR = i5;
            this.ciS = i6;
            aoj();
            if (aom() <= 0) {
                ah(2, 16);
                ah(2, 17);
            }
        }
    }

    public static boolean anS() {
        if (ciW == null) {
            ciW = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - ciW.getTime() < 10000) {
                return false;
            }
            ciW = date;
        }
        return true;
    }

    public static boolean anT() {
        if (d.aoy().aoJ()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.aoy().aoL().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.aoy().aoM().split(":");
            int parseInt2 = Integer.parseInt(split2[1]) + (Integer.parseInt(split2[0]) * 60);
            if (parseInt < parseInt2) {
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            } else if (parseInt > parseInt2) {
                if (i >= parseInt && i <= 1439) {
                    return true;
                }
                if (i >= 0 && i <= parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ah(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.ciS > 0) {
                        String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.ciS));
                        d(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.ciM > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(R.string.notify_agree), Integer.valueOf(this.ciM)));
                        d(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.ciN > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ciN > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ciN));
                            sb2.append(this.appContext.getString(R.string.notify_unit));
                            sb2.append("]");
                        }
                        if (this.ciZ != null) {
                            sb2.append(this.ciZ);
                        } else {
                            sb2.append(this.appContext.getString(R.string.notify_reply));
                        }
                        d(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ciO > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ciO > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.ciO));
                            sb3.append(this.appContext.getString(R.string.notify_unit));
                            sb3.append("]");
                        }
                        if (this.cja != null) {
                            sb3.append(this.cja);
                        } else {
                            sb3.append(this.appContext.getString(R.string.notify_at));
                        }
                        d(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ciR > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(R.string.notify_fans), Integer.valueOf(this.ciR)));
                        d(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.aoy().aoO() || d.aoy().aoB() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.appContext, 16);
                NotificationHelper.cancelNotification(this.appContext, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0356 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:6:0x0009, B:8:0x0012, B:10:0x0016, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x008a, B:28:0x009b, B:30:0x009f, B:32:0x00a8, B:33:0x00c9, B:35:0x00cd, B:36:0x00d2, B:37:0x00e2, B:40:0x00f3, B:42:0x00f7, B:44:0x0100, B:45:0x0121, B:47:0x0125, B:48:0x012a, B:49:0x013a, B:52:0x014b, B:54:0x014f, B:56:0x0158, B:57:0x0174, B:59:0x0192, B:61:0x019c, B:63:0x01a6, B:64:0x01b0, B:66:0x01bc, B:68:0x01c6, B:72:0x01d2, B:74:0x01da, B:77:0x020b, B:79:0x021a, B:80:0x023a, B:82:0x0240, B:83:0x025f, B:86:0x0266, B:88:0x0270, B:91:0x027e, B:93:0x0284, B:95:0x028a, B:96:0x028e, B:98:0x0294, B:100:0x029c, B:102:0x02a4, B:104:0x02ac, B:106:0x02b2, B:108:0x02b6, B:110:0x02c5, B:111:0x02cb, B:112:0x02d1, B:114:0x02db, B:116:0x02e5, B:118:0x02f0, B:120:0x02f6, B:122:0x02fc, B:124:0x030c, B:125:0x0328, B:127:0x032e, B:130:0x0336, B:132:0x0356, B:134:0x0366, B:138:0x0381, B:135:0x0379, B:141:0x03a3), top: B:147:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0366 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:6:0x0009, B:8:0x0012, B:10:0x0016, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x008a, B:28:0x009b, B:30:0x009f, B:32:0x00a8, B:33:0x00c9, B:35:0x00cd, B:36:0x00d2, B:37:0x00e2, B:40:0x00f3, B:42:0x00f7, B:44:0x0100, B:45:0x0121, B:47:0x0125, B:48:0x012a, B:49:0x013a, B:52:0x014b, B:54:0x014f, B:56:0x0158, B:57:0x0174, B:59:0x0192, B:61:0x019c, B:63:0x01a6, B:64:0x01b0, B:66:0x01bc, B:68:0x01c6, B:72:0x01d2, B:74:0x01da, B:77:0x020b, B:79:0x021a, B:80:0x023a, B:82:0x0240, B:83:0x025f, B:86:0x0266, B:88:0x0270, B:91:0x027e, B:93:0x0284, B:95:0x028a, B:96:0x028e, B:98:0x0294, B:100:0x029c, B:102:0x02a4, B:104:0x02ac, B:106:0x02b2, B:108:0x02b6, B:110:0x02c5, B:111:0x02cb, B:112:0x02d1, B:114:0x02db, B:116:0x02e5, B:118:0x02f0, B:120:0x02f6, B:122:0x02fc, B:124:0x030c, B:125:0x0328, B:127:0x032e, B:130:0x0336, B:132:0x0356, B:134:0x0366, B:138:0x0381, B:135:0x0379, B:141:0x03a3), top: B:147:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.model.e eVar) {
        boolean z;
        String apA;
        String apz;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ciS > 0) {
                            String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.ciS));
                            d(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.ciM > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.ciM > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.ciM));
                                sb.append(this.appContext.getString(R.string.notify_unit));
                                sb.append("]");
                            }
                            if (this.ciY != null) {
                                sb.append(this.ciY);
                            } else {
                                sb.append(this.appContext.getString(R.string.notify_agree));
                            }
                            d(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.ciN > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ciN > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ciN));
                                sb2.append(this.appContext.getString(R.string.notify_unit));
                                sb2.append("]");
                            }
                            if (this.ciZ != null) {
                                sb2.append(this.ciZ);
                            } else {
                                sb2.append(this.appContext.getString(R.string.notify_reply));
                            }
                            d(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ciO > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ciO > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.ciO));
                                sb3.append(this.appContext.getString(R.string.notify_unit));
                                sb3.append("]");
                            }
                            if (this.cja != null) {
                                sb3.append(this.cja);
                            } else {
                                sb3.append(this.appContext.getString(R.string.notify_at));
                            }
                            d(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ciR > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.ciR > 1) {
                                sb4.append(String.format(this.appContext.getString(R.string.notify_fans_unit), Integer.valueOf(this.ciR)));
                            }
                            sb4.append(this.appContext.getString(R.string.notify_fans));
                            d(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int apq = (!d.aoy().aoO() || d.aoy().aoB() <= 0) ? 0 : eVar.apq() - eVar.apx();
                        long j = 0;
                        if (d.aoy().aoG() && d.aoy().aoB() > 0) {
                            j = eVar.apI();
                        }
                        boolean z4 = j > 0;
                        long j2 = apq + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            eVar.apL();
                            eVar.apJ();
                            if (j == 1) {
                                apA = eVar.apL();
                                str = eVar.apJ();
                                apz = apA + "：" + str;
                            } else if (apq == 1) {
                                apA = eVar.apA();
                                apz = eVar.apz();
                                str = apz;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(apz)) {
                                apz = str;
                            }
                            a(16, apA, str, apz, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> apO = eVar.apO();
                        if (apO != null && apO.size() != 0) {
                            for (e.a aVar : apO) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !aq.isEmpty(aVar.gid) && aVar.unReadCount > aVar.ckT && aVar.ckU == null) {
                                    aop();
                                    if (aoq().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.aoy().aoO() && d.aoy().aoB() > 0 && eVar.apr() + eVar.apt() > 0) {
                        if (eVar.apr() > 0 && !aoa()) {
                            long apr = eVar.apr() - eVar.aps();
                            if (apr > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(apr)));
                                z = false;
                                z2 = true;
                            } else if (eVar.aps() > 0) {
                                z = true;
                            }
                            if (eVar.apt() > 0 || anZ()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(eVar.apt())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(eVar.apt())));
                            }
                            if (z3) {
                                d(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                d(18, eVar.apC(), eVar.apD(), eVar.apD());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.apt() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.appContext, 16);
                    NotificationHelper.cancelNotification(this.appContext, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void d(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.ckR, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
            return;
        }
        if (a == null) {
            a = c(aVar);
        }
        if (a == null) {
            a = b(aVar);
        }
        if (a != null) {
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, a, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, a, 134217728);
            }
            g(jA(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.ckR, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent t;
        PendingIntent service;
        if (this.ciX) {
            if (i == 23 && this.ciS > 0) {
                t = jv(i);
            } else if (i == 26 && this.ciR > 0) {
                t = jw(i);
            } else if (i == 18) {
                t = anU();
            } else if (i == 24) {
                t = t(i, z);
                t.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                t = t(i, z);
                t.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                t = t(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            t.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, t, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, t, 134217728);
            }
            g(jA(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent jv(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ciS);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent jw(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 35);
        intent.putExtra("KeyOfNotiId", i);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent a(e.a aVar) {
        String lastTaskId;
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo aS = com.baidu.tieba.im.memorycache.b.bGb().aS(aVar.gid, aVar.userType);
        if (aS == null || aS.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aS.getLastTaskId();
            jSONArray = new JSONArray(aS.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
            if (matcher.find()) {
                String group = matcher.group(1);
                if (!StringUtils.isNull(group)) {
                    Intent intent = new Intent();
                    if (UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.appContext, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.appContext, DealIntentService.class);
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", aVar.gid);
                    intent.putExtra("task_id", lastTaskId);
                    return intent;
                }
            } else if (optString.contains("mo/q/hotMessage") || optString.contains("mo/q/newtopic")) {
                Intent intent2 = new Intent();
                if (UtilHelper.isFlyMeOs()) {
                    intent2.setClass(this.appContext, DealIntentActivity.class);
                } else {
                    intent2.setClass(this.appContext, DealIntentService.class);
                }
                intent2.putExtra(DealIntentService.KEY_CLASS, 30);
                intent2.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                intent2.putExtra("task_id", lastTaskId);
                return intent2;
            } else if (optString.contains("open_wb_view=1")) {
                Intent intent3 = new Intent();
                if (UtilHelper.isFlyMeOs()) {
                    intent3.setClass(this.appContext, DealIntentActivity.class);
                } else {
                    intent3.setClass(this.appContext, DealIntentService.class);
                }
                intent3.putExtra(DealIntentService.KEY_CLASS, 0);
                intent3.putExtra("url", optString.trim());
                intent3.putExtra("task_id", lastTaskId);
                return intent3;
            } else if (optString.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                return Intent.parseUri(optString, 1);
            }
            return null;
        }
        return null;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.ckS);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> aop = aop();
        String str = aVar.gid;
        if (aop != null && !aq.isEmpty(str)) {
            HashSet<String> aoq = aoq();
            HashSet<String> aor = aor();
            HashSet<String> aos = aos();
            if (aoq != null && aoq.contains(str)) {
                return b(aVar, 3);
            }
            if (aor != null && aor.contains(str)) {
                return b(aVar, 1);
            }
            if (aos != null && aos.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent t(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.ciU.apK().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.ciM);
        intent.putExtra("at_me", this.ciO);
        intent.putExtra("reply_me", this.ciN);
        intent.putExtra("fans", this.ciR);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.ciU.apq() - this.ciU.apx());
        intent.putExtra("group_msg_validate", this.ciU.apt());
        intent.putExtra("group_msg_updates", this.ciU.apr());
        intent.putExtra("officialbar_msg", this.ciU.apu());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent anU() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.ciU.aps());
        return intent;
    }

    public void anV() {
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 29);
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 15);
        NotificationHelper.cancelNotification(this.appContext, 13);
        NotificationHelper.cancelNotification(this.appContext, 12);
    }

    public void anW() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void anX() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void jx(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void anY() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void pv(String str) {
        if (TextUtils.isEmpty(str)) {
            anW();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aon = aon();
        if (aon == null) {
            anW();
            return;
        }
        HashMap<String, String> apE = aon.apE();
        if (apE == null || apE.isEmpty()) {
            anW();
        } else if (apE.containsKey(str)) {
            anW();
        }
    }

    public void pw(String str) {
        if (TextUtils.isEmpty(str)) {
            anW();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aon = aon();
        if (aon == null) {
            anW();
            return;
        }
        HashMap<String, String> apK = aon.apK();
        if (apK == null || apK.isEmpty()) {
            anW();
        } else if (apK.containsKey(str)) {
            anW();
        }
    }

    private boolean anZ() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean aoa() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void aob() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void jy(int i) {
        com.baidu.tbadk.coreExtra.model.e aon = aon();
        if (aon == null) {
            aob();
        } else if (1 == i) {
            if (aon.apr() <= 0) {
                aob();
            }
        } else if (2 == i && aon.apt() <= 0) {
            aob();
        }
    }

    public void aoc() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void aod() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void aoe() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void aof() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void aog() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void aoh() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void aoi() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void aoj() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(aok());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(aol());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.ciU.apI());
        newsNotifyMessage.setMsgStrangerChat(this.ciU.apN());
        newsNotifyMessage.setMsgOfficialMerge(this.ciU.apM());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(aok());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.apI() + eVar.apq()) + eVar.apN()) + eVar.apM()) + eVar.apP()) - eVar.apx());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.apI());
            newsNotifyMessage.setMsgStrangerChat(eVar.apN());
            newsNotifyMessage.setMsgOfficialMerge(eVar.apM());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.ciN;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.ciM, i, this.ciO, this.ciP, this.ciR, this.ciQ, this.ciS);
        }
    }

    public int getMsgAtme() {
        return this.ciO;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.ciM, this.ciN, i, this.ciP, this.ciR, this.ciQ, this.ciS);
        }
    }

    public int aok() {
        return this.ciM;
    }

    public void jz(int i) {
        if (i >= 0) {
            a(i, this.ciN, this.ciO, this.ciP, this.ciR, this.ciQ, this.ciS);
        }
    }

    public int getMsgChat() {
        return this.ciP;
    }

    public int aol() {
        return ((((this.ciU.apI() + this.ciU.apq()) + this.ciU.apN()) + this.ciU.apM()) + this.ciU.apP()) - this.ciU.apx();
    }

    public int getMsgFans() {
        return this.ciR;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.ciM, this.ciN, this.ciO, this.ciP, i, this.ciQ, this.ciS);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.ciM, this.ciN, this.ciO, i, this.ciR, this.ciQ, this.ciS);
        }
    }

    public int getMsgBookmark() {
        return this.ciQ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.ciM, this.ciN, this.ciO, this.ciP, this.ciR, i, this.ciS);
        }
    }

    public int getMsgGiftNum() {
        return this.ciS;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ciS = i;
        }
    }

    public void eD(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.ciM = 0;
        this.ciN = 0;
        this.ciO = 0;
        this.ciP = 0;
        this.ciR = 0;
        this.ciQ = 0;
    }

    public int aom() {
        return this.ciM + this.ciN + this.ciO + this.ciP + this.ciR + this.ciS;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.ciU = eVar;
            this.ciP = (eVar.apq() - eVar.apx()) + eVar.apI() + eVar.apM() + eVar.apP();
            a(eVar);
            if (eVar.apy()) {
                this.ciV = null;
                mHandler.removeMessages(0);
            }
            if (eVar.apy()) {
                if (d.aoy().aoO() && d.aoy().aoB() > 0) {
                    i = eVar.apq() - eVar.apx();
                }
                long apI = (!d.aoy().aoG() || d.aoy().aoB() <= 0) ? 0L : eVar.apI();
                if ((i > 0 || apI > 0) && ((i > eVar.apB() - eVar.apx() && i > 0) || apI > eVar.apv())) {
                    a(1, 16, eVar);
                }
                int apu = eVar.apu();
                if (apu > 0 && apu > eVar.apH()) {
                    a(1, 19, eVar);
                }
                if (eVar.apr() > eVar.apF() || eVar.apt() > eVar.apG()) {
                    if (eVar.apr() <= eVar.apF() || eVar.apt() != eVar.apG() || !aoa()) {
                        if (eVar.apr() != eVar.apF() || eVar.apt() <= eVar.apG() || !anZ()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e aon() {
        return this.ciU;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.ciU = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e aoo() {
        return this.ciV;
    }

    public int jA(int i) {
        switch (i) {
            case 12:
            case 13:
            case 15:
            case 18:
            case 19:
            case 28:
            case 2000:
                return 2;
            case 16:
            case 17:
                return 1;
            case 23:
            case 24:
            case 25:
            case 26:
            case 29:
                return 3;
            default:
                return 0;
        }
    }

    public void g(long j, int i) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 26, i);
        }
    }

    public HashMap<Integer, HashSet> aop() {
        JSONArray jSONArray;
        if (!ciJ && ciK) {
            return this.ciL;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.ciL.get(0) == null) {
                this.ciL.put(0, new HashSet());
            }
            this.ciL.get(0).add("3222425470");
            return this.ciL;
        }
        if (this.ciL.get(0) != null) {
            this.ciL.get(0).clear();
        }
        if (this.ciL.get(1) != null) {
            this.ciL.get(1).clear();
        }
        if (this.ciL.get(2) != null) {
            this.ciL.get(2).clear();
        }
        try {
            jSONArray = new JSONArray(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt(MyBookrackActivityConfig.TAB_ID);
                String optString = optJSONObject.optString("uid");
                switch (optInt) {
                    case 0:
                        if (this.ciL.get(0) == null) {
                            this.ciL.put(0, new HashSet());
                        }
                        this.ciL.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.ciL.get(1) == null) {
                            this.ciL.put(1, new HashSet());
                        }
                        this.ciL.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.ciL.get(2) == null) {
                            this.ciL.put(2, new HashSet());
                        }
                        this.ciL.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        ciK = true;
        ciJ = false;
        return this.ciL;
    }

    public HashSet<String> aoq() {
        aop();
        return this.ciL.get(0);
    }

    public HashSet<String> aor() {
        aop();
        return this.ciL.get(1);
    }

    public HashSet<String> aos() {
        aop();
        return this.ciL.get(2);
    }

    public String aot() {
        HashSet<String> aoq = aoq();
        if (aoq != null) {
            Iterator<String> it = aoq.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
