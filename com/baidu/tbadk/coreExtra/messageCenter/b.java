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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
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
    private static b bYJ;
    private com.baidu.tbadk.coreExtra.model.e bYL;
    private String bYO;
    private String bYP;
    private String bYQ;
    public static boolean bYz = true;
    public static boolean bYA = false;
    private static Date bYM = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.ahA().b(b.ahA().ahX());
            }
        }
    };
    private final HashMap<Integer, HashSet> bYB = new HashMap<>();
    private int bYC = 0;
    private int bYD = 0;
    private int bYE = 0;
    private int bYF = 0;
    private int bYG = 0;
    private int bYH = 0;
    private int bYI = 0;
    private com.baidu.tbadk.coreExtra.model.e bYK = new com.baidu.tbadk.coreExtra.model.e();
    private boolean bYN = true;
    private final int[] bYR = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b ahA() {
        if (bYJ == null) {
            bYJ = new b();
        }
        return bYJ;
    }

    private b() {
    }

    public void aP(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.bYP = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bYO = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bYQ = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.bYC || i2 != this.bYD || i3 != this.bYE || i4 != this.bYF || i5 != this.bYH || i6 != this.bYG || i7 != this.bYI) {
            int i8 = 0;
            if (i > this.bYC || i2 > this.bYD || i3 > this.bYE || i4 > this.bYF || i5 > this.bYH || i6 > this.bYG || i7 > this.bYI) {
                i8 = 1;
            } else if (i < this.bYC || i2 < this.bYD || i3 < this.bYE) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.bYC && d.aih().aiy()) {
                i9 = 1;
            } else if (i < this.bYC) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.bYD && d.aih().aio()) {
                i10 = 1;
            } else if (i2 < this.bYD) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.bYE && d.aih().aim()) {
                i11 = 1;
            } else if (i3 < this.bYE) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.bYF) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.bYH) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.bYI) {
                i14 = 1;
            }
            this.bYC = i;
            this.bYD = i2;
            this.bYE = i3;
            this.bYF = i4;
            this.bYH = i5;
            this.bYG = i6;
            this.bYI = i7;
            if (ahV() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                ahS();
                ae(i14, 23);
                ae(i12, 16);
                ae(i8, 17);
                ae(i10, 24);
                ae(i11, 25);
                ae(i13, 26);
                ae(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.bYC || i2 != this.bYD || i3 != this.bYE || i4 != this.bYF || i5 != this.bYH || this.bYI != i6) {
            this.bYC = i;
            this.bYD = i2;
            this.bYE = i3;
            this.bYF = i4;
            this.bYH = i5;
            this.bYI = i6;
            ahS();
            if (ahV() <= 0) {
                ae(2, 16);
                ae(2, 17);
            }
        }
    }

    public static boolean ahB() {
        if (bYM == null) {
            bYM = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bYM.getTime() < 10000) {
                return false;
            }
            bYM = date;
        }
        return true;
    }

    public static boolean ahC() {
        if (d.aih().ais()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.aih().aiu().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.aih().aiv().split(":");
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

    private void ae(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.bYI > 0) {
                        String format = String.format(this.appContext.getString(d.j.notify_gift), String.valueOf(this.bYI));
                        c(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.bYC > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(d.j.notify_agree), Integer.valueOf(this.bYC)));
                        c(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.bYD > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bYD > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bYD));
                            sb2.append(this.appContext.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bYP != null) {
                            sb2.append(this.bYP);
                        } else {
                            sb2.append(this.appContext.getString(d.j.notify_reply));
                        }
                        c(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bYE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.bYE > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.bYE));
                            sb3.append(this.appContext.getString(d.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.bYQ != null) {
                            sb3.append(this.bYQ);
                        } else {
                            sb3.append(this.appContext.getString(d.j.notify_at));
                        }
                        c(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bYH > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(d.j.notify_fans), Integer.valueOf(this.bYH)));
                        c(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.aih().aix() || d.aih().aik() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.appContext, 16);
                NotificationHelper.cancelNotification(this.appContext, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0344 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:110:0x02b7, B:111:0x02bd, B:112:0x02c3, B:114:0x02cd, B:116:0x02d7, B:118:0x02e2, B:120:0x02e8, B:122:0x02ee, B:124:0x02fc, B:125:0x0317, B:127:0x031d, B:130:0x0325, B:132:0x0344, B:134:0x0354, B:138:0x036f, B:135:0x0367, B:141:0x0390), top: B:148:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0354 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:110:0x02b7, B:111:0x02bd, B:112:0x02c3, B:114:0x02cd, B:116:0x02d7, B:118:0x02e2, B:120:0x02e8, B:122:0x02ee, B:124:0x02fc, B:125:0x0317, B:127:0x031d, B:130:0x0325, B:132:0x0344, B:134:0x0354, B:138:0x036f, B:135:0x0367, B:141:0x0390), top: B:148:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.model.e eVar) {
        boolean z;
        String ajj;
        String aji;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bYI > 0) {
                            String format = String.format(this.appContext.getString(d.j.notify_gift), String.valueOf(this.bYI));
                            c(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.bYC > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.bYC > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.bYC));
                                sb.append(this.appContext.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bYO != null) {
                                sb.append(this.bYO);
                            } else {
                                sb.append(this.appContext.getString(d.j.notify_agree));
                            }
                            c(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.bYD > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bYD > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bYD));
                                sb2.append(this.appContext.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bYP != null) {
                                sb2.append(this.bYP);
                            } else {
                                sb2.append(this.appContext.getString(d.j.notify_reply));
                            }
                            c(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bYE > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bYE > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.bYE));
                                sb3.append(this.appContext.getString(d.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.bYQ != null) {
                                sb3.append(this.bYQ);
                            } else {
                                sb3.append(this.appContext.getString(d.j.notify_at));
                            }
                            c(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bYH > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.bYH > 1) {
                                sb4.append(String.format(this.appContext.getString(d.j.notify_fans_unit), Integer.valueOf(this.bYH)));
                            }
                            sb4.append(this.appContext.getString(d.j.notify_fans));
                            c(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int aiZ = (!d.aih().aix() || d.aih().aik() <= 0) ? 0 : eVar.aiZ() - eVar.ajg();
                        long ajr = (!d.aih().aip() || d.aih().aik() <= 0) ? 0L : eVar.ajr();
                        boolean z4 = ajr > 0;
                        long j = aiZ + ajr;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(d.j.notify_chat), Long.valueOf(j)));
                            b(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.aju();
                            eVar.ajs();
                            if (ajr == 1) {
                                ajj = eVar.aju();
                                str = eVar.ajs();
                                aji = ajj + "：" + str;
                            } else if (aiZ == 1) {
                                ajj = eVar.ajj();
                                aji = eVar.aji();
                                str = aji;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(aji)) {
                                aji = str;
                            }
                            b(16, ajj, str, aji, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> ajx = eVar.ajx();
                        if (ajx != null && ajx.size() != 0) {
                            for (e.a aVar : ajx) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ap.isEmpty(aVar.gid) && aVar.unReadCount > aVar.caK && aVar.caL == null) {
                                    ahY();
                                    if (ahZ().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.aih().aix() && d.aih().aik() > 0 && eVar.aja() + eVar.ajc() > 0) {
                        if (eVar.aja() > 0 && !ahJ()) {
                            long aja = eVar.aja() - eVar.ajb();
                            if (aja > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_updates), Long.valueOf(aja)));
                                z = false;
                                z2 = true;
                            } else if (eVar.ajb() > 0) {
                                z = true;
                            }
                            if (eVar.ajc() > 0 || ahI()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_validate), Integer.valueOf(eVar.ajc())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_validate_1), Integer.valueOf(eVar.ajc())));
                            }
                            if (z3) {
                                c(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                c(18, eVar.ajl(), eVar.ajm(), eVar.ajm());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.ajc() > 0) {
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
        b(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.caI, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
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
            i(iD(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.caI, service, false);
        }
    }

    private void b(int i, String str, String str2, String str3, boolean z) {
        Intent n;
        PendingIntent service;
        if (this.bYN) {
            if (i == 23 && this.bYI > 0) {
                n = iy(i);
            } else if (i == 26 && this.bYH > 0) {
                n = iz(i);
            } else if (i == 18) {
                n = ahD();
            } else if (i == 24) {
                n = n(i, z);
                n.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                n = n(i, z);
                n.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                n = n(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            n.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, n, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, n, 134217728);
            }
            i(iD(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent iy(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bYI);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent iz(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 35);
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
        ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buF().aT(aVar.gid, aVar.userType);
        if (aT == null || aT.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aT.getLastTaskId();
            jSONArray = new JSONArray(aT.getLastContentRawData());
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
                    intent.putExtra("class", 1);
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
                intent2.putExtra("class", 30);
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
                intent3.putExtra("class", 0);
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
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.caJ);
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
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> ahY = ahY();
        String str = aVar.gid;
        if (ahY != null && !ap.isEmpty(str)) {
            HashSet<String> ahZ = ahZ();
            HashSet<String> aia = aia();
            HashSet<String> aib = aib();
            if (ahZ != null && ahZ.contains(str)) {
                return b(aVar, 3);
            }
            if (aia != null && aia.contains(str)) {
                return b(aVar, 1);
            }
            if (aib != null && aib.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent n(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bYK.ajt().keySet();
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
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.bYC);
        intent.putExtra("at_me", this.bYE);
        intent.putExtra("reply_me", this.bYD);
        intent.putExtra("fans", this.bYH);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bYK.aiZ() - this.bYK.ajg());
        intent.putExtra("group_msg_validate", this.bYK.ajc());
        intent.putExtra("group_msg_updates", this.bYK.aja());
        intent.putExtra("officialbar_msg", this.bYK.ajd());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent ahD() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bYK.ajb());
        return intent;
    }

    public void ahE() {
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

    public void ahF() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void ahG() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void iA(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void ahH() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void nJ(String str) {
        if (TextUtils.isEmpty(str)) {
            ahF();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e ahW = ahW();
        if (ahW == null) {
            ahF();
            return;
        }
        HashMap<String, String> ajn = ahW.ajn();
        if (ajn == null || ajn.isEmpty()) {
            ahF();
        } else if (ajn.containsKey(str)) {
            ahF();
        }
    }

    public void nK(String str) {
        if (TextUtils.isEmpty(str)) {
            ahF();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e ahW = ahW();
        if (ahW == null) {
            ahF();
            return;
        }
        HashMap<String, String> ajt = ahW.ajt();
        if (ajt == null || ajt.isEmpty()) {
            ahF();
        } else if (ajt.containsKey(str)) {
            ahF();
        }
    }

    private boolean ahI() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean ahJ() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void ahK() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void iB(int i) {
        com.baidu.tbadk.coreExtra.model.e ahW = ahW();
        if (ahW == null) {
            ahK();
        } else if (1 == i) {
            if (ahW.aja() <= 0) {
                ahK();
            }
        } else if (2 == i && ahW.ajc() <= 0) {
            ahK();
        }
    }

    public void ahL() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void ahM() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void ahN() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void ahO() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void ahP() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void ahQ() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void ahR() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void ahS() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(ahT());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(ahU());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.bYK.ajr());
        newsNotifyMessage.setMsgStrangerChat(this.bYK.ajw());
        newsNotifyMessage.setMsgOfficialMerge(this.bYK.ajv());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(ahT());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.ajr() + eVar.aiZ()) + eVar.ajw()) + eVar.ajv()) + eVar.ajy()) - eVar.ajg());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.ajr());
            newsNotifyMessage.setMsgStrangerChat(eVar.ajw());
            newsNotifyMessage.setMsgOfficialMerge(eVar.ajv());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bYD;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.bYC, i, this.bYE, this.bYF, this.bYH, this.bYG, this.bYI);
        }
    }

    public int getMsgAtme() {
        return this.bYE;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.bYC, this.bYD, i, this.bYF, this.bYH, this.bYG, this.bYI);
        }
    }

    public int ahT() {
        return this.bYC;
    }

    public void iC(int i) {
        if (i >= 0) {
            a(i, this.bYD, this.bYE, this.bYF, this.bYH, this.bYG, this.bYI);
        }
    }

    public int getMsgChat() {
        return this.bYF;
    }

    public int ahU() {
        return ((((this.bYK.ajr() + this.bYK.aiZ()) + this.bYK.ajw()) + this.bYK.ajv()) + this.bYK.ajy()) - this.bYK.ajg();
    }

    public int getMsgFans() {
        return this.bYH;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.bYC, this.bYD, this.bYE, this.bYF, i, this.bYG, this.bYI);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.bYC, this.bYD, this.bYE, i, this.bYH, this.bYG, this.bYI);
        }
    }

    public int getMsgBookmark() {
        return this.bYG;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.bYC, this.bYD, this.bYE, this.bYF, this.bYH, i, this.bYI);
        }
    }

    public int getMsgGiftNum() {
        return this.bYI;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bYI = i;
        }
    }

    public void dZ(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.bYC = 0;
        this.bYD = 0;
        this.bYE = 0;
        this.bYF = 0;
        this.bYH = 0;
        this.bYG = 0;
    }

    public int ahV() {
        return this.bYC + this.bYD + this.bYE + this.bYF + this.bYH + this.bYI;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bYK = eVar;
            this.bYF = (eVar.aiZ() - eVar.ajg()) + eVar.ajr() + eVar.ajv() + eVar.ajy();
            a(eVar);
            if (eVar.ajh()) {
                this.bYL = null;
                mHandler.removeMessages(0);
            }
            if (eVar.ajh()) {
                if (d.aih().aix() && d.aih().aik() > 0) {
                    i = eVar.aiZ() - eVar.ajg();
                }
                long ajr = (!d.aih().aip() || d.aih().aik() <= 0) ? 0L : eVar.ajr();
                if ((i > 0 || ajr > 0) && ((i > eVar.ajk() - eVar.ajg() && i > 0) || ajr > eVar.aje())) {
                    a(1, 16, eVar);
                }
                int ajd = eVar.ajd();
                if (ajd > 0 && ajd > eVar.ajq()) {
                    a(1, 19, eVar);
                }
                if (eVar.aja() > eVar.ajo() || eVar.ajc() > eVar.ajp()) {
                    if (eVar.aja() <= eVar.ajo() || eVar.ajc() != eVar.ajp() || !ahJ()) {
                        if (eVar.aja() != eVar.ajo() || eVar.ajc() <= eVar.ajp() || !ahI()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e ahW() {
        return this.bYK;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.bYK = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e ahX() {
        return this.bYL;
    }

    public int iD(int i) {
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

    public void i(long j, int i) {
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

    public HashMap<Integer, HashSet> ahY() {
        JSONArray jSONArray;
        if (!bYz && bYA) {
            return this.bYB;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.bYB.get(0) == null) {
                this.bYB.put(0, new HashSet());
            }
            this.bYB.get(0).add("3222425470");
            return this.bYB;
        }
        if (this.bYB.get(0) != null) {
            this.bYB.get(0).clear();
        }
        if (this.bYB.get(1) != null) {
            this.bYB.get(1).clear();
        }
        if (this.bYB.get(2) != null) {
            this.bYB.get(2).clear();
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
                        if (this.bYB.get(0) == null) {
                            this.bYB.put(0, new HashSet());
                        }
                        this.bYB.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.bYB.get(1) == null) {
                            this.bYB.put(1, new HashSet());
                        }
                        this.bYB.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.bYB.get(2) == null) {
                            this.bYB.put(2, new HashSet());
                        }
                        this.bYB.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        bYA = true;
        bYz = false;
        return this.bYB;
    }

    public HashSet<String> ahZ() {
        ahY();
        return this.bYB.get(0);
    }

    public HashSet<String> aia() {
        ahY();
        return this.bYB.get(1);
    }

    public HashSet<String> aib() {
        ahY();
        return this.bYB.get(2);
    }

    public String aic() {
        HashSet<String> ahZ = ahZ();
        if (ahZ != null) {
            Iterator<String> it = ahZ.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
