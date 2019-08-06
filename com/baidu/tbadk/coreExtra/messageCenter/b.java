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
    private static b chX;
    private com.baidu.tbadk.coreExtra.model.e chZ;
    private String cic;
    private String cie;
    private String cif;
    public static boolean chN = true;
    public static boolean chO = false;
    private static Date cia = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.anF().b(b.anF().aoc());
            }
        }
    };
    private final HashMap<Integer, HashSet> chP = new HashMap<>();
    private int chQ = 0;
    private int chR = 0;
    private int chS = 0;
    private int chT = 0;
    private int chU = 0;
    private int chV = 0;
    private int chW = 0;
    private com.baidu.tbadk.coreExtra.model.e chY = new com.baidu.tbadk.coreExtra.model.e();
    private boolean cib = true;
    private final int[] cig = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b anF() {
        if (chX == null) {
            chX = new b();
        }
        return chX;
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
                    this.cie = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.cic = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.cif = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.chQ || i2 != this.chR || i3 != this.chS || i4 != this.chT || i5 != this.chV || i6 != this.chU || i7 != this.chW) {
            int i8 = 0;
            if (i > this.chQ || i2 > this.chR || i3 > this.chS || i4 > this.chT || i5 > this.chV || i6 > this.chU || i7 > this.chW) {
                i8 = 1;
            } else if (i < this.chQ || i2 < this.chR || i3 < this.chS) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.chQ && d.aom().aoD()) {
                i9 = 1;
            } else if (i < this.chQ) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.chR && d.aom().aot()) {
                i10 = 1;
            } else if (i2 < this.chR) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.chS && d.aom().aor()) {
                i11 = 1;
            } else if (i3 < this.chS) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.chT) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.chV) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.chW) {
                i14 = 1;
            }
            this.chQ = i;
            this.chR = i2;
            this.chS = i3;
            this.chT = i4;
            this.chV = i5;
            this.chU = i6;
            this.chW = i7;
            if (aoa() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                anX();
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
        if (i != this.chQ || i2 != this.chR || i3 != this.chS || i4 != this.chT || i5 != this.chV || this.chW != i6) {
            this.chQ = i;
            this.chR = i2;
            this.chS = i3;
            this.chT = i4;
            this.chV = i5;
            this.chW = i6;
            anX();
            if (aoa() <= 0) {
                ah(2, 16);
                ah(2, 17);
            }
        }
    }

    public static boolean anG() {
        if (cia == null) {
            cia = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - cia.getTime() < 10000) {
                return false;
            }
            cia = date;
        }
        return true;
    }

    public static boolean anH() {
        if (d.aom().aox()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.aom().aoz().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.aom().aoA().split(":");
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
                    if (this.chW > 0) {
                        String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.chW));
                        c(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.chQ > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(R.string.notify_agree), Integer.valueOf(this.chQ)));
                        c(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.chR > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.chR > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.chR));
                            sb2.append(this.appContext.getString(R.string.notify_unit));
                            sb2.append("]");
                        }
                        if (this.cie != null) {
                            sb2.append(this.cie);
                        } else {
                            sb2.append(this.appContext.getString(R.string.notify_reply));
                        }
                        c(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.chS > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.chS > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.chS));
                            sb3.append(this.appContext.getString(R.string.notify_unit));
                            sb3.append("]");
                        }
                        if (this.cif != null) {
                            sb3.append(this.cif);
                        } else {
                            sb3.append(this.appContext.getString(R.string.notify_at));
                        }
                        c(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.chV > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(R.string.notify_fans), Integer.valueOf(this.chV)));
                        c(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.aom().aoC() || d.aom().aop() > 0) {
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
        String apo;
        String apn;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.chW > 0) {
                            String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.chW));
                            c(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.chQ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.chQ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.chQ));
                                sb.append(this.appContext.getString(R.string.notify_unit));
                                sb.append("]");
                            }
                            if (this.cic != null) {
                                sb.append(this.cic);
                            } else {
                                sb.append(this.appContext.getString(R.string.notify_agree));
                            }
                            c(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.chR > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.chR > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.chR));
                                sb2.append(this.appContext.getString(R.string.notify_unit));
                                sb2.append("]");
                            }
                            if (this.cie != null) {
                                sb2.append(this.cie);
                            } else {
                                sb2.append(this.appContext.getString(R.string.notify_reply));
                            }
                            c(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.chS > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.chS > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.chS));
                                sb3.append(this.appContext.getString(R.string.notify_unit));
                                sb3.append("]");
                            }
                            if (this.cif != null) {
                                sb3.append(this.cif);
                            } else {
                                sb3.append(this.appContext.getString(R.string.notify_at));
                            }
                            c(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.chV > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.chV > 1) {
                                sb4.append(String.format(this.appContext.getString(R.string.notify_fans_unit), Integer.valueOf(this.chV)));
                            }
                            sb4.append(this.appContext.getString(R.string.notify_fans));
                            c(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int apd = (!d.aom().aoC() || d.aom().aop() <= 0) ? 0 : eVar.apd() - eVar.apl();
                        long j = 0;
                        if (d.aom().aou() && d.aom().aop() > 0) {
                            j = eVar.apw();
                        }
                        boolean z4 = j > 0;
                        long j2 = apd + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            eVar.apz();
                            eVar.apx();
                            if (j == 1) {
                                apo = eVar.apz();
                                str = eVar.apx();
                                apn = apo + "：" + str;
                            } else if (apd == 1) {
                                apo = eVar.apo();
                                apn = eVar.apn();
                                str = apn;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(apn)) {
                                apn = str;
                            }
                            a(16, apo, str, apn, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> apC = eVar.apC();
                        if (apC != null && apC.size() != 0) {
                            for (e.a aVar : apC) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !aq.isEmpty(aVar.gid) && aVar.unReadCount > aVar.cjY && aVar.cjZ == null) {
                                    aod();
                                    if (aoe().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.aom().aoC() && d.aom().aop() > 0 && eVar.ape() + eVar.apg() > 0) {
                        if (eVar.ape() > 0 && !anO()) {
                            long ape = eVar.ape() - eVar.apf();
                            if (ape > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(ape)));
                                z = false;
                                z2 = true;
                            } else if (eVar.apf() > 0) {
                                z = true;
                            }
                            if (eVar.apg() > 0 || anN()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(eVar.apg())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(eVar.apg())));
                            }
                            if (z3) {
                                c(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                c(18, eVar.apq(), eVar.apr(), eVar.apr());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.apg() > 0) {
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

    private void c(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.cjW, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
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
            g(jx(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.cjW, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        PendingIntent service;
        if (this.cib) {
            if (i == 23 && this.chW > 0) {
                r = js(i);
            } else if (i == 26 && this.chV > 0) {
                r = jt(i);
            } else if (i == 18) {
                r = anI();
            } else if (i == 24) {
                r = r(i, z);
                r.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                r = r(i, z);
                r.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                r = r(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            r.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, r, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, r, 134217728);
            }
            g(jx(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent js(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.chW);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent jt(int i) {
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
        ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bFn().aQ(aVar.gid, aVar.userType);
        if (aQ == null || aQ.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aQ.getLastTaskId();
            jSONArray = new JSONArray(aQ.getLastContentRawData());
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
        intent.putExtra("uname", aVar.cjX);
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
        HashMap<Integer, HashSet> aod = aod();
        String str = aVar.gid;
        if (aod != null && !aq.isEmpty(str)) {
            HashSet<String> aoe = aoe();
            HashSet<String> aof = aof();
            HashSet<String> aog = aog();
            if (aoe != null && aoe.contains(str)) {
                return b(aVar, 3);
            }
            if (aof != null && aof.contains(str)) {
                return b(aVar, 1);
            }
            if (aog != null && aog.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.chY.apy().keySet();
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
        intent.putExtra("agree_me", this.chQ);
        intent.putExtra("at_me", this.chS);
        intent.putExtra("reply_me", this.chR);
        intent.putExtra("fans", this.chV);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.chY.apd() - this.chY.apl());
        intent.putExtra("group_msg_validate", this.chY.apg());
        intent.putExtra("group_msg_updates", this.chY.ape());
        intent.putExtra("officialbar_msg", this.chY.aph());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent anI() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.chY.apf());
        return intent;
    }

    public void anJ() {
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

    public void anK() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void anL() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void ju(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void anM() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void pk(String str) {
        if (TextUtils.isEmpty(str)) {
            anK();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aob = aob();
        if (aob == null) {
            anK();
            return;
        }
        HashMap<String, String> aps = aob.aps();
        if (aps == null || aps.isEmpty()) {
            anK();
        } else if (aps.containsKey(str)) {
            anK();
        }
    }

    public void pl(String str) {
        if (TextUtils.isEmpty(str)) {
            anK();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aob = aob();
        if (aob == null) {
            anK();
            return;
        }
        HashMap<String, String> apy = aob.apy();
        if (apy == null || apy.isEmpty()) {
            anK();
        } else if (apy.containsKey(str)) {
            anK();
        }
    }

    private boolean anN() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean anO() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void anP() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void jv(int i) {
        com.baidu.tbadk.coreExtra.model.e aob = aob();
        if (aob == null) {
            anP();
        } else if (1 == i) {
            if (aob.ape() <= 0) {
                anP();
            }
        } else if (2 == i && aob.apg() <= 0) {
            anP();
        }
    }

    public void anQ() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void anR() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void anS() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void anT() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void anU() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void anV() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void anW() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void anX() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(anY());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(anZ());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.chY.apw());
        newsNotifyMessage.setMsgStrangerChat(this.chY.apB());
        newsNotifyMessage.setMsgOfficialMerge(this.chY.apA());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(anY());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.apw() + eVar.apd()) + eVar.apB()) + eVar.apA()) + eVar.apD()) - eVar.apl());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.apw());
            newsNotifyMessage.setMsgStrangerChat(eVar.apB());
            newsNotifyMessage.setMsgOfficialMerge(eVar.apA());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.chR;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.chQ, i, this.chS, this.chT, this.chV, this.chU, this.chW);
        }
    }

    public int getMsgAtme() {
        return this.chS;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.chQ, this.chR, i, this.chT, this.chV, this.chU, this.chW);
        }
    }

    public int anY() {
        return this.chQ;
    }

    public void jw(int i) {
        if (i >= 0) {
            a(i, this.chR, this.chS, this.chT, this.chV, this.chU, this.chW);
        }
    }

    public int getMsgChat() {
        return this.chT;
    }

    public int anZ() {
        return ((((this.chY.apw() + this.chY.apd()) + this.chY.apB()) + this.chY.apA()) + this.chY.apD()) - this.chY.apl();
    }

    public int getMsgFans() {
        return this.chV;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.chQ, this.chR, this.chS, this.chT, i, this.chU, this.chW);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.chQ, this.chR, this.chS, i, this.chV, this.chU, this.chW);
        }
    }

    public int getMsgBookmark() {
        return this.chU;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.chQ, this.chR, this.chS, this.chT, this.chV, i, this.chW);
        }
    }

    public int getMsgGiftNum() {
        return this.chW;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.chW = i;
        }
    }

    public void eA(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.chQ = 0;
        this.chR = 0;
        this.chS = 0;
        this.chT = 0;
        this.chV = 0;
        this.chU = 0;
    }

    public int aoa() {
        return this.chQ + this.chR + this.chS + this.chT + this.chV + this.chW;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.chY = eVar;
            this.chT = (eVar.apd() - eVar.apl()) + eVar.apw() + eVar.apA() + eVar.apD();
            a(eVar);
            if (eVar.apm()) {
                this.chZ = null;
                mHandler.removeMessages(0);
            }
            if (eVar.apm()) {
                if (d.aom().aoC() && d.aom().aop() > 0) {
                    i = eVar.apd() - eVar.apl();
                }
                long apw = (!d.aom().aou() || d.aom().aop() <= 0) ? 0L : eVar.apw();
                if ((i > 0 || apw > 0) && ((i > eVar.app() - eVar.apl() && i > 0) || apw > eVar.apj())) {
                    a(1, 16, eVar);
                }
                int aph = eVar.aph();
                if (aph > 0 && aph > eVar.apv()) {
                    a(1, 19, eVar);
                }
                if (eVar.ape() > eVar.apt() || eVar.apg() > eVar.apu()) {
                    if (eVar.ape() <= eVar.apt() || eVar.apg() != eVar.apu() || !anO()) {
                        if (eVar.ape() != eVar.apt() || eVar.apg() <= eVar.apu() || !anN()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e aob() {
        return this.chY;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.chY = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e aoc() {
        return this.chZ;
    }

    public int jx(int i) {
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

    public HashMap<Integer, HashSet> aod() {
        JSONArray jSONArray;
        if (!chN && chO) {
            return this.chP;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.chP.get(0) == null) {
                this.chP.put(0, new HashSet());
            }
            this.chP.get(0).add("3222425470");
            return this.chP;
        }
        if (this.chP.get(0) != null) {
            this.chP.get(0).clear();
        }
        if (this.chP.get(1) != null) {
            this.chP.get(1).clear();
        }
        if (this.chP.get(2) != null) {
            this.chP.get(2).clear();
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
                        if (this.chP.get(0) == null) {
                            this.chP.put(0, new HashSet());
                        }
                        this.chP.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.chP.get(1) == null) {
                            this.chP.put(1, new HashSet());
                        }
                        this.chP.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.chP.get(2) == null) {
                            this.chP.put(2, new HashSet());
                        }
                        this.chP.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        chO = true;
        chN = false;
        return this.chP;
    }

    public HashSet<String> aoe() {
        aod();
        return this.chP.get(0);
    }

    public HashSet<String> aof() {
        aod();
        return this.chP.get(1);
    }

    public HashSet<String> aog() {
        aod();
        return this.chP.get(2);
    }

    public String aoh() {
        HashSet<String> aoe = aoe();
        if (aoe != null) {
            Iterator<String> it = aoe.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
