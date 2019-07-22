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
    private static b chQ;
    private com.baidu.tbadk.coreExtra.model.e chS;
    private String chV;
    private String chW;
    private String chX;
    public static boolean chG = true;
    public static boolean chH = false;
    private static Date chT = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.anD().b(b.anD().aoa());
            }
        }
    };
    private final HashMap<Integer, HashSet> chI = new HashMap<>();
    private int chJ = 0;
    private int chK = 0;
    private int chL = 0;
    private int chM = 0;
    private int chN = 0;
    private int chO = 0;
    private int chP = 0;
    private com.baidu.tbadk.coreExtra.model.e chR = new com.baidu.tbadk.coreExtra.model.e();
    private boolean chU = true;
    private final int[] chY = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b anD() {
        if (chQ == null) {
            chQ = new b();
        }
        return chQ;
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
                    this.chW = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.chV = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.chX = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.chJ || i2 != this.chK || i3 != this.chL || i4 != this.chM || i5 != this.chO || i6 != this.chN || i7 != this.chP) {
            int i8 = 0;
            if (i > this.chJ || i2 > this.chK || i3 > this.chL || i4 > this.chM || i5 > this.chO || i6 > this.chN || i7 > this.chP) {
                i8 = 1;
            } else if (i < this.chJ || i2 < this.chK || i3 < this.chL) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.chJ && d.aok().aoB()) {
                i9 = 1;
            } else if (i < this.chJ) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.chK && d.aok().aor()) {
                i10 = 1;
            } else if (i2 < this.chK) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.chL && d.aok().aop()) {
                i11 = 1;
            } else if (i3 < this.chL) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.chM) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.chO) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.chP) {
                i14 = 1;
            }
            this.chJ = i;
            this.chK = i2;
            this.chL = i3;
            this.chM = i4;
            this.chO = i5;
            this.chN = i6;
            this.chP = i7;
            if (anY() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                anV();
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
        if (i != this.chJ || i2 != this.chK || i3 != this.chL || i4 != this.chM || i5 != this.chO || this.chP != i6) {
            this.chJ = i;
            this.chK = i2;
            this.chL = i3;
            this.chM = i4;
            this.chO = i5;
            this.chP = i6;
            anV();
            if (anY() <= 0) {
                ah(2, 16);
                ah(2, 17);
            }
        }
    }

    public static boolean anE() {
        if (chT == null) {
            chT = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - chT.getTime() < 10000) {
                return false;
            }
            chT = date;
        }
        return true;
    }

    public static boolean anF() {
        if (d.aok().aov()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.aok().aox().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.aok().aoy().split(":");
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
                    if (this.chP > 0) {
                        String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.chP));
                        c(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.chJ > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(R.string.notify_agree), Integer.valueOf(this.chJ)));
                        c(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.chK > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.chK > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.chK));
                            sb2.append(this.appContext.getString(R.string.notify_unit));
                            sb2.append("]");
                        }
                        if (this.chW != null) {
                            sb2.append(this.chW);
                        } else {
                            sb2.append(this.appContext.getString(R.string.notify_reply));
                        }
                        c(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.chL > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.chL > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.chL));
                            sb3.append(this.appContext.getString(R.string.notify_unit));
                            sb3.append("]");
                        }
                        if (this.chX != null) {
                            sb3.append(this.chX);
                        } else {
                            sb3.append(this.appContext.getString(R.string.notify_at));
                        }
                        c(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.chO > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(R.string.notify_fans), Integer.valueOf(this.chO)));
                        c(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.aok().aoA() || d.aok().aon() > 0) {
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
        String apm;
        String apl;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.chP > 0) {
                            String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.chP));
                            c(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.chJ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.chJ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.chJ));
                                sb.append(this.appContext.getString(R.string.notify_unit));
                                sb.append("]");
                            }
                            if (this.chV != null) {
                                sb.append(this.chV);
                            } else {
                                sb.append(this.appContext.getString(R.string.notify_agree));
                            }
                            c(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.chK > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.chK > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.chK));
                                sb2.append(this.appContext.getString(R.string.notify_unit));
                                sb2.append("]");
                            }
                            if (this.chW != null) {
                                sb2.append(this.chW);
                            } else {
                                sb2.append(this.appContext.getString(R.string.notify_reply));
                            }
                            c(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.chL > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.chL > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.chL));
                                sb3.append(this.appContext.getString(R.string.notify_unit));
                                sb3.append("]");
                            }
                            if (this.chX != null) {
                                sb3.append(this.chX);
                            } else {
                                sb3.append(this.appContext.getString(R.string.notify_at));
                            }
                            c(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.chO > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.chO > 1) {
                                sb4.append(String.format(this.appContext.getString(R.string.notify_fans_unit), Integer.valueOf(this.chO)));
                            }
                            sb4.append(this.appContext.getString(R.string.notify_fans));
                            c(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int apb = (!d.aok().aoA() || d.aok().aon() <= 0) ? 0 : eVar.apb() - eVar.apj();
                        long j = 0;
                        if (d.aok().aos() && d.aok().aon() > 0) {
                            j = eVar.apu();
                        }
                        boolean z4 = j > 0;
                        long j2 = apb + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            eVar.apx();
                            eVar.apv();
                            if (j == 1) {
                                apm = eVar.apx();
                                str = eVar.apv();
                                apl = apm + "：" + str;
                            } else if (apb == 1) {
                                apm = eVar.apm();
                                apl = eVar.apl();
                                str = apl;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(apl)) {
                                apl = str;
                            }
                            a(16, apm, str, apl, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> apA = eVar.apA();
                        if (apA != null && apA.size() != 0) {
                            for (e.a aVar : apA) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !aq.isEmpty(aVar.gid) && aVar.unReadCount > aVar.cjR && aVar.cjS == null) {
                                    aob();
                                    if (aoc().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.aok().aoA() && d.aok().aon() > 0 && eVar.apc() + eVar.ape() > 0) {
                        if (eVar.apc() > 0 && !anM()) {
                            long apc = eVar.apc() - eVar.apd();
                            if (apc > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(apc)));
                                z = false;
                                z2 = true;
                            } else if (eVar.apd() > 0) {
                                z = true;
                            }
                            if (eVar.ape() > 0 || anL()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(eVar.ape())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(eVar.ape())));
                            }
                            if (z3) {
                                c(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                c(18, eVar.apo(), eVar.app(), eVar.app());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.ape() > 0) {
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
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.cjP, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
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
            g(jw(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.cjP, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        PendingIntent service;
        if (this.chU) {
            if (i == 23 && this.chP > 0) {
                r = jr(i);
            } else if (i == 26 && this.chO > 0) {
                r = js(i);
            } else if (i == 18) {
                r = anG();
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
            g(jw(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent jr(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.chP);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent js(int i) {
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
        ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bEZ().aQ(aVar.gid, aVar.userType);
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
        intent.putExtra("uname", aVar.cjQ);
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
        HashMap<Integer, HashSet> aob = aob();
        String str = aVar.gid;
        if (aob != null && !aq.isEmpty(str)) {
            HashSet<String> aoc = aoc();
            HashSet<String> aod = aod();
            HashSet<String> aoe = aoe();
            if (aoc != null && aoc.contains(str)) {
                return b(aVar, 3);
            }
            if (aod != null && aod.contains(str)) {
                return b(aVar, 1);
            }
            if (aoe != null && aoe.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.chR.apw().keySet();
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
        intent.putExtra("agree_me", this.chJ);
        intent.putExtra("at_me", this.chL);
        intent.putExtra("reply_me", this.chK);
        intent.putExtra("fans", this.chO);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.chR.apb() - this.chR.apj());
        intent.putExtra("group_msg_validate", this.chR.ape());
        intent.putExtra("group_msg_updates", this.chR.apc());
        intent.putExtra("officialbar_msg", this.chR.apf());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent anG() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.chR.apd());
        return intent;
    }

    public void anH() {
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

    public void anI() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void anJ() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void jt(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void anK() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void pk(String str) {
        if (TextUtils.isEmpty(str)) {
            anI();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e anZ = anZ();
        if (anZ == null) {
            anI();
            return;
        }
        HashMap<String, String> apq = anZ.apq();
        if (apq == null || apq.isEmpty()) {
            anI();
        } else if (apq.containsKey(str)) {
            anI();
        }
    }

    public void pl(String str) {
        if (TextUtils.isEmpty(str)) {
            anI();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e anZ = anZ();
        if (anZ == null) {
            anI();
            return;
        }
        HashMap<String, String> apw = anZ.apw();
        if (apw == null || apw.isEmpty()) {
            anI();
        } else if (apw.containsKey(str)) {
            anI();
        }
    }

    private boolean anL() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean anM() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void anN() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void ju(int i) {
        com.baidu.tbadk.coreExtra.model.e anZ = anZ();
        if (anZ == null) {
            anN();
        } else if (1 == i) {
            if (anZ.apc() <= 0) {
                anN();
            }
        } else if (2 == i && anZ.ape() <= 0) {
            anN();
        }
    }

    public void anO() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void anP() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void anQ() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void anR() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void anS() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void anT() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void anU() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void anV() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(anW());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(anX());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.chR.apu());
        newsNotifyMessage.setMsgStrangerChat(this.chR.apz());
        newsNotifyMessage.setMsgOfficialMerge(this.chR.apy());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(anW());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.apu() + eVar.apb()) + eVar.apz()) + eVar.apy()) + eVar.apB()) - eVar.apj());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.apu());
            newsNotifyMessage.setMsgStrangerChat(eVar.apz());
            newsNotifyMessage.setMsgOfficialMerge(eVar.apy());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.chK;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.chJ, i, this.chL, this.chM, this.chO, this.chN, this.chP);
        }
    }

    public int getMsgAtme() {
        return this.chL;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.chJ, this.chK, i, this.chM, this.chO, this.chN, this.chP);
        }
    }

    public int anW() {
        return this.chJ;
    }

    public void jv(int i) {
        if (i >= 0) {
            a(i, this.chK, this.chL, this.chM, this.chO, this.chN, this.chP);
        }
    }

    public int getMsgChat() {
        return this.chM;
    }

    public int anX() {
        return ((((this.chR.apu() + this.chR.apb()) + this.chR.apz()) + this.chR.apy()) + this.chR.apB()) - this.chR.apj();
    }

    public int getMsgFans() {
        return this.chO;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.chJ, this.chK, this.chL, this.chM, i, this.chN, this.chP);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.chJ, this.chK, this.chL, i, this.chO, this.chN, this.chP);
        }
    }

    public int getMsgBookmark() {
        return this.chN;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.chJ, this.chK, this.chL, this.chM, this.chO, i, this.chP);
        }
    }

    public int getMsgGiftNum() {
        return this.chP;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.chP = i;
        }
    }

    public void eA(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.chJ = 0;
        this.chK = 0;
        this.chL = 0;
        this.chM = 0;
        this.chO = 0;
        this.chN = 0;
    }

    public int anY() {
        return this.chJ + this.chK + this.chL + this.chM + this.chO + this.chP;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.chR = eVar;
            this.chM = (eVar.apb() - eVar.apj()) + eVar.apu() + eVar.apy() + eVar.apB();
            a(eVar);
            if (eVar.apk()) {
                this.chS = null;
                mHandler.removeMessages(0);
            }
            if (eVar.apk()) {
                if (d.aok().aoA() && d.aok().aon() > 0) {
                    i = eVar.apb() - eVar.apj();
                }
                long apu = (!d.aok().aos() || d.aok().aon() <= 0) ? 0L : eVar.apu();
                if ((i > 0 || apu > 0) && ((i > eVar.apn() - eVar.apj() && i > 0) || apu > eVar.apg())) {
                    a(1, 16, eVar);
                }
                int apf = eVar.apf();
                if (apf > 0 && apf > eVar.apt()) {
                    a(1, 19, eVar);
                }
                if (eVar.apc() > eVar.apr() || eVar.ape() > eVar.aps()) {
                    if (eVar.apc() <= eVar.apr() || eVar.ape() != eVar.aps() || !anM()) {
                        if (eVar.apc() != eVar.apr() || eVar.ape() <= eVar.aps() || !anL()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e anZ() {
        return this.chR;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.chR = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e aoa() {
        return this.chS;
    }

    public int jw(int i) {
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

    public HashMap<Integer, HashSet> aob() {
        JSONArray jSONArray;
        if (!chG && chH) {
            return this.chI;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.chI.get(0) == null) {
                this.chI.put(0, new HashSet());
            }
            this.chI.get(0).add("3222425470");
            return this.chI;
        }
        if (this.chI.get(0) != null) {
            this.chI.get(0).clear();
        }
        if (this.chI.get(1) != null) {
            this.chI.get(1).clear();
        }
        if (this.chI.get(2) != null) {
            this.chI.get(2).clear();
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
                        if (this.chI.get(0) == null) {
                            this.chI.put(0, new HashSet());
                        }
                        this.chI.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.chI.get(1) == null) {
                            this.chI.put(1, new HashSet());
                        }
                        this.chI.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.chI.get(2) == null) {
                            this.chI.put(2, new HashSet());
                        }
                        this.chI.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        chH = true;
        chG = false;
        return this.chI;
    }

    public HashSet<String> aoc() {
        aob();
        return this.chI.get(0);
    }

    public HashSet<String> aod() {
        aob();
        return this.chI.get(1);
    }

    public HashSet<String> aoe() {
        aob();
        return this.chI.get(2);
    }

    public String aof() {
        HashSet<String> aoc = aoc();
        if (aoc != null) {
            Iterator<String> it = aoc.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
