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
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.an;
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
public class a {
    private static a auB;
    private e auD;
    private String auG;
    private String auH;
    private String auI;
    public static boolean auq = true;
    public static boolean aur = false;
    private static Date auE = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.zw().b(a.zw().zT());
            }
        }
    };
    private final HashMap<Integer, HashSet> aus = new HashMap<>();
    private int auu = 0;
    private int auv = 0;
    private int auw = 0;
    private int aux = 0;
    private int auy = 0;
    private int auz = 0;
    private int auA = 0;
    private e auC = new e();
    private boolean auF = true;
    private final int[] auJ = new int[10];
    private final Context aut = TbadkCoreApplication.getInst().getApp();

    public static a zw() {
        if (auB == null) {
            auB = new a();
        }
        return auB;
    }

    private a() {
    }

    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.auH = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.auG = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.auI = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.auu || i2 != this.auv || i3 != this.auw || i4 != this.aux || i5 != this.auz || i6 != this.auy || i7 != this.auA) {
            int i8 = 0;
            if (i > this.auu || i2 > this.auv || i3 > this.auw || i4 > this.aux || i5 > this.auz || i6 > this.auy || i7 > this.auA) {
                i8 = 1;
            } else if (i < this.auu || i2 < this.auv || i3 < this.auw) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.auu && c.Ad().At()) {
                i9 = 1;
            } else if (i < this.auu) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.auv && c.Ad().Ak()) {
                i10 = 1;
            } else if (i2 < this.auv) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.auw && c.Ad().Ai()) {
                i11 = 1;
            } else if (i3 < this.auw) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aux) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.auz) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.auA) {
                i14 = 1;
            }
            this.auu = i;
            this.auv = i2;
            this.auw = i3;
            this.aux = i4;
            this.auz = i5;
            this.auy = i6;
            this.auA = i7;
            if (zR() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zO();
                D(i14, 23);
                D(i12, 16);
                D(i8, 17);
                D(i10, 24);
                D(i11, 25);
                D(i13, 26);
                D(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.auu || i2 != this.auv || i3 != this.auw || i4 != this.aux || i5 != this.auz || this.auA != i6) {
            this.auu = i;
            this.auv = i2;
            this.auw = i3;
            this.aux = i4;
            this.auz = i5;
            this.auA = i6;
            zO();
            if (zR() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean zx() {
        if (auE == null) {
            auE = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - auE.getTime() < 10000) {
                return false;
            }
            auE = date;
        }
        return true;
    }

    public static boolean zy() {
        if (c.Ad().Ao()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Ad().Aq().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Ad().Ar().split(":");
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

    private void D(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.auA > 0) {
                        String format = String.format(this.aut.getString(d.k.notify_gift), String.valueOf(this.auA));
                        b(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.auu > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.aut.getString(d.k.notify_agree), Integer.valueOf(this.auu)));
                        b(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.auv > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.auv > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.auv));
                            sb2.append(this.aut.getString(d.k.notify_unit));
                            sb2.append("]");
                        }
                        if (this.auH != null) {
                            sb2.append(this.auH);
                        } else {
                            sb2.append(this.aut.getString(d.k.notify_reply));
                        }
                        b(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.auw > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.auw > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.auw));
                            sb3.append(this.aut.getString(d.k.notify_unit));
                            sb3.append("]");
                        }
                        if (this.auI != null) {
                            sb3.append(this.auI);
                        } else {
                            sb3.append(this.aut.getString(d.k.notify_at));
                        }
                        b(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.auz > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.aut.getString(d.k.notify_fans), Integer.valueOf(this.auz)));
                        b(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Ad().As() || c.Ad().Ag() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aut, 16);
                NotificationHelper.cancelNotification(this.aut, 17);
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
    private void a(int i, int i2, e eVar) {
        boolean z;
        String AZ;
        String AY;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.auA > 0) {
                            String format = String.format(this.aut.getString(d.k.notify_gift), String.valueOf(this.auA));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.auu > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.auu > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.auu));
                                sb.append(this.aut.getString(d.k.notify_unit));
                                sb.append("]");
                            }
                            if (this.auG != null) {
                                sb.append(this.auG);
                            } else {
                                sb.append(this.aut.getString(d.k.notify_agree));
                            }
                            b(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.auv > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.auv > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.auv));
                                sb2.append(this.aut.getString(d.k.notify_unit));
                                sb2.append("]");
                            }
                            if (this.auH != null) {
                                sb2.append(this.auH);
                            } else {
                                sb2.append(this.aut.getString(d.k.notify_reply));
                            }
                            b(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.auw > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.auw > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.auw));
                                sb3.append(this.aut.getString(d.k.notify_unit));
                                sb3.append("]");
                            }
                            if (this.auI != null) {
                                sb3.append(this.auI);
                            } else {
                                sb3.append(this.aut.getString(d.k.notify_at));
                            }
                            b(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.auz > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.auz > 1) {
                                sb4.append(String.format(this.aut.getString(d.k.notify_fans_unit), Integer.valueOf(this.auz)));
                            }
                            sb4.append(this.aut.getString(d.k.notify_fans));
                            b(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int AP = (!c.Ad().As() || c.Ad().Ag() <= 0) ? 0 : eVar.AP() - eVar.AW();
                        long Bh = (!c.Ad().Al() || c.Ad().Ag() <= 0) ? 0L : eVar.Bh();
                        boolean z4 = Bh > 0;
                        long j = AP + Bh;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aut.getString(d.k.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Bk();
                            eVar.Bi();
                            if (Bh == 1) {
                                AZ = eVar.Bk();
                                str = eVar.Bi();
                                AY = AZ + "：" + str;
                            } else if (AP == 1) {
                                AZ = eVar.AZ();
                                AY = eVar.AY();
                                str = AY;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aut.getString(d.k.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(AY)) {
                                AY = str;
                            }
                            a(16, AZ, str, AY, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> Bn = eVar.Bn();
                        if (Bn != null && Bn.size() != 0) {
                            for (e.a aVar : Bn) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !an.isEmpty(aVar.gid) && aVar.unReadCount > aVar.awq && aVar.awr == null) {
                                    zU();
                                    if (zV().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.Ad().As() && c.Ad().Ag() > 0 && eVar.AQ() + eVar.AS() > 0) {
                        if (eVar.AQ() > 0 && !zF()) {
                            long AQ = eVar.AQ() - eVar.AR();
                            if (AQ > 0) {
                                stringBuffer.append(String.format(this.aut.getString(d.k.notify_updates), Long.valueOf(AQ)));
                                z = false;
                                z2 = true;
                            } else if (eVar.AR() > 0) {
                                z = true;
                            }
                            if (eVar.AS() > 0 || zE()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.aut.getString(d.k.notify_validate), Integer.valueOf(eVar.AS())));
                            } else {
                                stringBuffer.append(String.format(this.aut.getString(d.k.notify_validate_1), Integer.valueOf(eVar.AS())));
                            }
                            if (z3) {
                                b(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                b(18, eVar.Bb(), eVar.Bc(), eVar.Bc());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.AS() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aut, 16);
                    NotificationHelper.cancelNotification(this.aut, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void b(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a == null) {
            a = b(aVar);
        }
        if (a == null) {
            a = d(aVar);
        }
        if (a == null) {
            a = c(aVar);
        }
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aut, i, a, 134217728);
            a(dU(i), i);
            NotificationHelper.showNotification(this.aut, i, aVar.title, aVar.content, aVar.awo, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent k;
        if (this.auF) {
            if (i == 23 && this.auA > 0) {
                k = dP(i);
            } else if (i == 26 && this.auz > 0) {
                k = dQ(i);
            } else if (i == 18) {
                k = zz();
            } else if (i == 24) {
                k = k(i, z);
                k.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                k = k(i, z);
                k.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                k = k(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            k.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aut, i, k, 134217728);
            a(dU(i), i);
            NotificationHelper.showNotification(this.aut, i, str, str2, str3, service, false);
        }
    }

    public Intent dP(int i) {
        Intent intent = new Intent(this.aut, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.auA);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dQ(int i) {
        Intent intent = new Intent(this.aut, DealIntentService.class);
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
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFw().ap(aVar.gid, aVar.userType);
        if (ap == null || ap.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(ap.getLastContentRawData());
            if (jSONArray.length() == 1) {
                String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                if (StringUtils.isNull(optString)) {
                    return null;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (StringUtils.isNull(group)) {
                        return null;
                    }
                    Intent intent = new Intent(this.aut, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", aVar.gid);
                    return intent;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Intent b(e.a aVar) {
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFw().ap(aVar.gid + "", aVar.userType);
        if (ap == null || ap.getLast_content() == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(ap.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            if (optString.contains("mo/q/hotMessage")) {
                Intent intent = new Intent(this.aut, DealIntentService.class);
                intent.putExtra("class", 30);
                intent.putExtra("jump_url", optString);
                return intent;
            }
            return null;
        }
        return null;
    }

    public Intent c(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aut, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.awp);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aut, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> zU = zU();
        String str = aVar.gid;
        if (zU != null && !an.isEmpty(str)) {
            HashSet<String> zV = zV();
            HashSet<String> zW = zW();
            HashSet<String> zX = zX();
            if (zV != null && zV.contains(str)) {
                return b(aVar, 3);
            }
            if (zW != null && zW.contains(str)) {
                return b(aVar, 1);
            }
            if (zX != null && zX.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent k(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.auC.Bj().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aut, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.auu);
        intent.putExtra("at_me", this.auw);
        intent.putExtra("reply_me", this.auv);
        intent.putExtra("fans", this.auz);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.auC.AP() - this.auC.AW());
        intent.putExtra("group_msg_validate", this.auC.AS());
        intent.putExtra("group_msg_updates", this.auC.AQ());
        intent.putExtra("officialbar_msg", this.auC.AT());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zz() {
        Intent intent = new Intent(this.aut, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.auC.AR());
        return intent;
    }

    public void zA() {
        NotificationHelper.cancelNotification(this.aut, 23);
        NotificationHelper.cancelNotification(this.aut, 24);
        NotificationHelper.cancelNotification(this.aut, 25);
        NotificationHelper.cancelNotification(this.aut, 29);
        NotificationHelper.cancelNotification(this.aut, 26);
        NotificationHelper.cancelNotification(this.aut, 17);
        NotificationHelper.cancelNotification(this.aut, 15);
        NotificationHelper.cancelNotification(this.aut, 13);
        NotificationHelper.cancelNotification(this.aut, 12);
    }

    public void zB() {
        NotificationHelper.cancelNotification(this.aut, 16);
    }

    public void zC() {
        NotificationHelper.cancelNotification(this.aut, 19);
    }

    public void dR(int i) {
        NotificationHelper.cancelNotification(this.aut, i);
    }

    public void zD() {
        NotificationHelper.cancelNotification(this.aut, 30);
    }

    public void fg(String str) {
        if (TextUtils.isEmpty(str)) {
            zB();
            return;
        }
        e zS = zS();
        if (zS == null) {
            zB();
            return;
        }
        HashMap<String, String> Bd = zS.Bd();
        if (Bd == null || Bd.isEmpty()) {
            zB();
        } else if (Bd.containsKey(str)) {
            zB();
        }
    }

    public void fh(String str) {
        if (TextUtils.isEmpty(str)) {
            zB();
            return;
        }
        e zS = zS();
        if (zS == null) {
            zB();
            return;
        }
        HashMap<String, String> Bj = zS.Bj();
        if (Bj == null || Bj.isEmpty()) {
            zB();
        } else if (Bj.containsKey(str)) {
            zB();
        }
    }

    private boolean zE() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zF() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void zG() {
        NotificationHelper.cancelNotification(this.aut, 17);
    }

    public void dS(int i) {
        e zS = zS();
        if (zS == null) {
            zG();
        } else if (1 == i) {
            if (zS.AQ() <= 0) {
                zG();
            }
        } else if (2 == i && zS.AS() <= 0) {
            zG();
        }
    }

    public void zH() {
        NotificationHelper.cancelNotification(this.aut, 18);
    }

    public void zI() {
        NotificationHelper.cancelNotification(this.aut, 26);
        NotificationHelper.cancelNotification(this.aut, 25);
        NotificationHelper.cancelNotification(this.aut, 24);
        NotificationHelper.cancelNotification(this.aut, 23);
        NotificationHelper.cancelNotification(this.aut, 16);
        NotificationHelper.cancelNotification(this.aut, 17);
        NotificationHelper.cancelNotification(this.aut, 29);
    }

    public void zJ() {
        NotificationHelper.cancelNotification(this.aut, 17);
        NotificationHelper.cancelNotification(this.aut, 19);
        NotificationHelper.cancelNotification(this.aut, 16);
        NotificationHelper.cancelNotification(this.aut, 18);
        NotificationHelper.cancelNotification(this.aut, 30);
    }

    public void zK() {
        NotificationHelper.cancelNotification(this.aut, 24);
    }

    public void zL() {
        NotificationHelper.cancelNotification(this.aut, 25);
    }

    public void zM() {
        NotificationHelper.cancelNotification(this.aut, 29);
    }

    public void zN() {
        NotificationHelper.cancelNotification(this.aut, 23);
    }

    public void zO() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(zP());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zQ());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.auC.Bh());
        newsNotifyMessage.setMsgStrangerChat(this.auC.Bm());
        newsNotifyMessage.setMsgOfficialMerge(this.auC.Bl());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(zP());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Bh() + eVar.AP()) + eVar.Bm()) + eVar.Bl()) + eVar.Bo()) - eVar.AW());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Bh());
            newsNotifyMessage.setMsgStrangerChat(eVar.Bm());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Bl());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.auv;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.auu, i, this.auw, this.aux, this.auz, this.auy, this.auA);
        }
    }

    public int getMsgAtme() {
        return this.auw;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.auu, this.auv, i, this.aux, this.auz, this.auy, this.auA);
        }
    }

    public int zP() {
        return this.auu;
    }

    public void dT(int i) {
        if (i >= 0) {
            a(i, this.auv, this.auw, this.aux, this.auz, this.auy, this.auA);
        }
    }

    public int getMsgChat() {
        return this.aux;
    }

    public int zQ() {
        return ((((this.auC.Bh() + this.auC.AP()) + this.auC.Bm()) + this.auC.Bl()) + this.auC.Bo()) - this.auC.AW();
    }

    public int getMsgFans() {
        return this.auz;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.auu, this.auv, this.auw, this.aux, i, this.auy, this.auA);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.auu, this.auv, this.auw, i, this.auz, this.auy, this.auA);
        }
    }

    public int getMsgBookmark() {
        return this.auy;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.auu, this.auv, this.auw, this.aux, this.auz, i, this.auA);
        }
    }

    public int getMsgGiftNum() {
        return this.auA;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.auA = i;
        }
    }

    public void aW(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.auu = 0;
        this.auv = 0;
        this.auw = 0;
        this.aux = 0;
        this.auz = 0;
        this.auy = 0;
    }

    public int zR() {
        return this.auu + this.auv + this.auw + this.aux + this.auz + this.auA;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.auC = eVar;
            this.aux = (eVar.AP() - eVar.AW()) + eVar.Bh() + eVar.Bl() + eVar.Bo();
            a(eVar);
            if (eVar.AX()) {
                this.auD = null;
                mHandler.removeMessages(0);
            }
            if (eVar.AX()) {
                if (c.Ad().As() && c.Ad().Ag() > 0) {
                    i = eVar.AP() - eVar.AW();
                }
                long Bh = (!c.Ad().Al() || c.Ad().Ag() <= 0) ? 0L : eVar.Bh();
                if ((i > 0 || Bh > 0) && ((i > eVar.Ba() - eVar.AW() && i > 0) || Bh > eVar.AU())) {
                    a(1, 16, eVar);
                }
                int AT = eVar.AT();
                if (AT > 0 && AT > eVar.Bg()) {
                    a(1, 19, eVar);
                }
                if (eVar.AQ() > eVar.Be() || eVar.AS() > eVar.Bf()) {
                    if (eVar.AQ() <= eVar.Be() || eVar.AS() != eVar.Bf() || !zF()) {
                        if (eVar.AQ() != eVar.Be() || eVar.AS() <= eVar.Bf() || !zE()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e zS() {
        return this.auC;
    }

    public void c(e eVar) {
        this.auC = eVar;
    }

    public e zT() {
        return this.auD;
    }

    public int dU(int i) {
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

    public void a(long j, int i) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aut, 26, i);
        }
    }

    public HashMap<Integer, HashSet> zU() {
        JSONArray jSONArray;
        if (!auq && aur) {
            return this.aus;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aus.get(0) == null) {
                this.aus.put(0, new HashSet());
            }
            this.aus.get(0).add("3222425470");
            return this.aus;
        }
        if (this.aus.get(0) != null) {
            this.aus.get(0).clear();
        }
        if (this.aus.get(1) != null) {
            this.aus.get(1).clear();
        }
        if (this.aus.get(2) != null) {
            this.aus.get(2).clear();
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
                        if (this.aus.get(0) == null) {
                            this.aus.put(0, new HashSet());
                        }
                        this.aus.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aus.get(1) == null) {
                            this.aus.put(1, new HashSet());
                        }
                        this.aus.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aus.get(2) == null) {
                            this.aus.put(2, new HashSet());
                        }
                        this.aus.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aur = true;
        auq = false;
        return this.aus;
    }

    public HashSet<String> zV() {
        zU();
        return this.aus.get(0);
    }

    public HashSet<String> zW() {
        zU();
        return this.aus.get(1);
    }

    public HashSet<String> zX() {
        zU();
        return this.aus.get(2);
    }

    public String zY() {
        HashSet<String> zV = zV();
        if (zV != null) {
            Iterator<String> it = zV.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
