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
    private static a auA;
    private e auC;
    private String auF;
    private String auG;
    private String auH;
    public static boolean aup = true;
    public static boolean auq = false;
    private static Date auD = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.zx().b(a.zx().zU());
            }
        }
    };
    private final HashMap<Integer, HashSet> aur = new HashMap<>();
    private int aut = 0;
    private int auu = 0;
    private int auv = 0;
    private int auw = 0;
    private int aux = 0;
    private int auy = 0;
    private int auz = 0;
    private e auB = new e();
    private boolean auE = true;
    private final int[] auI = new int[10];
    private final Context aus = TbadkCoreApplication.getInst().getApp();

    public static a zx() {
        if (auA == null) {
            auA = new a();
        }
        return auA;
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
                    this.auG = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.auF = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.auH = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aut || i2 != this.auu || i3 != this.auv || i4 != this.auw || i5 != this.auy || i6 != this.aux || i7 != this.auz) {
            int i8 = 0;
            if (i > this.aut || i2 > this.auu || i3 > this.auv || i4 > this.auw || i5 > this.auy || i6 > this.aux || i7 > this.auz) {
                i8 = 1;
            } else if (i < this.aut || i2 < this.auu || i3 < this.auv) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aut && c.Ae().Au()) {
                i9 = 1;
            } else if (i < this.aut) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.auu && c.Ae().Al()) {
                i10 = 1;
            } else if (i2 < this.auu) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.auv && c.Ae().Aj()) {
                i11 = 1;
            } else if (i3 < this.auv) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.auw) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.auy) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.auz) {
                i14 = 1;
            }
            this.aut = i;
            this.auu = i2;
            this.auv = i3;
            this.auw = i4;
            this.auy = i5;
            this.aux = i6;
            this.auz = i7;
            if (zS() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zP();
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
        if (i != this.aut || i2 != this.auu || i3 != this.auv || i4 != this.auw || i5 != this.auy || this.auz != i6) {
            this.aut = i;
            this.auu = i2;
            this.auv = i3;
            this.auw = i4;
            this.auy = i5;
            this.auz = i6;
            zP();
            if (zS() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean zy() {
        if (auD == null) {
            auD = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - auD.getTime() < 10000) {
                return false;
            }
            auD = date;
        }
        return true;
    }

    public static boolean zz() {
        if (c.Ae().Ap()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Ae().Ar().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Ae().As().split(":");
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
                    if (this.auz > 0) {
                        String format = String.format(this.aus.getString(d.k.notify_gift), String.valueOf(this.auz));
                        b(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aut > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.aus.getString(d.k.notify_agree), Integer.valueOf(this.aut)));
                        b(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.auu > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.auu > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.auu));
                            sb2.append(this.aus.getString(d.k.notify_unit));
                            sb2.append("]");
                        }
                        if (this.auG != null) {
                            sb2.append(this.auG);
                        } else {
                            sb2.append(this.aus.getString(d.k.notify_reply));
                        }
                        b(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.auv > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.auv > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.auv));
                            sb3.append(this.aus.getString(d.k.notify_unit));
                            sb3.append("]");
                        }
                        if (this.auH != null) {
                            sb3.append(this.auH);
                        } else {
                            sb3.append(this.aus.getString(d.k.notify_at));
                        }
                        b(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.auy > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.aus.getString(d.k.notify_fans), Integer.valueOf(this.auy)));
                        b(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Ae().At() || c.Ae().Ah() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aus, 16);
                NotificationHelper.cancelNotification(this.aus, 17);
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
        String Bb;
        String Ba;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.auz > 0) {
                            String format = String.format(this.aus.getString(d.k.notify_gift), String.valueOf(this.auz));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aut > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aut > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aut));
                                sb.append(this.aus.getString(d.k.notify_unit));
                                sb.append("]");
                            }
                            if (this.auF != null) {
                                sb.append(this.auF);
                            } else {
                                sb.append(this.aus.getString(d.k.notify_agree));
                            }
                            b(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.auu > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.auu > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.auu));
                                sb2.append(this.aus.getString(d.k.notify_unit));
                                sb2.append("]");
                            }
                            if (this.auG != null) {
                                sb2.append(this.auG);
                            } else {
                                sb2.append(this.aus.getString(d.k.notify_reply));
                            }
                            b(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.auv > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.auv > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.auv));
                                sb3.append(this.aus.getString(d.k.notify_unit));
                                sb3.append("]");
                            }
                            if (this.auH != null) {
                                sb3.append(this.auH);
                            } else {
                                sb3.append(this.aus.getString(d.k.notify_at));
                            }
                            b(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.auy > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.auy > 1) {
                                sb4.append(String.format(this.aus.getString(d.k.notify_fans_unit), Integer.valueOf(this.auy)));
                            }
                            sb4.append(this.aus.getString(d.k.notify_fans));
                            b(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int AR = (!c.Ae().At() || c.Ae().Ah() <= 0) ? 0 : eVar.AR() - eVar.AY();
                        long Bj = (!c.Ae().Am() || c.Ae().Ah() <= 0) ? 0L : eVar.Bj();
                        boolean z4 = Bj > 0;
                        long j = AR + Bj;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aus.getString(d.k.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Bm();
                            eVar.Bk();
                            if (Bj == 1) {
                                Bb = eVar.Bm();
                                str = eVar.Bk();
                                Ba = Bb + "：" + str;
                            } else if (AR == 1) {
                                Bb = eVar.Bb();
                                Ba = eVar.Ba();
                                str = Ba;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aus.getString(d.k.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ba)) {
                                Ba = str;
                            }
                            a(16, Bb, str, Ba, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> Bp = eVar.Bp();
                        if (Bp != null && Bp.size() != 0) {
                            for (e.a aVar : Bp) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !an.isEmpty(aVar.gid) && aVar.unReadCount > aVar.awp && aVar.awq == null) {
                                    zV();
                                    if (zW().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.Ae().At() && c.Ae().Ah() > 0 && eVar.AS() + eVar.AU() > 0) {
                        if (eVar.AS() > 0 && !zG()) {
                            long AS = eVar.AS() - eVar.AT();
                            if (AS > 0) {
                                stringBuffer.append(String.format(this.aus.getString(d.k.notify_updates), Long.valueOf(AS)));
                                z = false;
                                z2 = true;
                            } else if (eVar.AT() > 0) {
                                z = true;
                            }
                            if (eVar.AU() > 0 || zF()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.aus.getString(d.k.notify_validate), Integer.valueOf(eVar.AU())));
                            } else {
                                stringBuffer.append(String.format(this.aus.getString(d.k.notify_validate_1), Integer.valueOf(eVar.AU())));
                            }
                            if (z3) {
                                b(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                b(18, eVar.Bd(), eVar.Be(), eVar.Be());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.AU() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aus, 16);
                    NotificationHelper.cancelNotification(this.aus, 17);
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
            PendingIntent service = PendingIntent.getService(this.aus, i, a, 134217728);
            a(dT(i), i);
            NotificationHelper.showNotification(this.aus, i, aVar.title, aVar.content, aVar.awn, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent k;
        if (this.auE) {
            if (i == 23 && this.auz > 0) {
                k = dO(i);
            } else if (i == 26 && this.auy > 0) {
                k = dP(i);
            } else if (i == 18) {
                k = zA();
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
            PendingIntent service = PendingIntent.getService(this.aus, i, k, 134217728);
            a(dT(i), i);
            NotificationHelper.showNotification(this.aus, i, str, str2, str3, service, false);
        }
    }

    public Intent dO(int i) {
        Intent intent = new Intent(this.aus, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.auz);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dP(int i) {
        Intent intent = new Intent(this.aus, DealIntentService.class);
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
        ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFy().ap(aVar.gid, aVar.userType);
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
                    Intent intent = new Intent(this.aus, DealIntentService.class);
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
        ImMessageCenterPojo ap = com.baidu.tieba.im.memorycache.b.aFy().ap(aVar.gid + "", aVar.userType);
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
                Intent intent = new Intent(this.aus, DealIntentService.class);
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
        Intent intent = new Intent(this.aus, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.awo);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aus, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> zV = zV();
        String str = aVar.gid;
        if (zV != null && !an.isEmpty(str)) {
            HashSet<String> zW = zW();
            HashSet<String> zX = zX();
            HashSet<String> zY = zY();
            if (zW != null && zW.contains(str)) {
                return b(aVar, 3);
            }
            if (zX != null && zX.contains(str)) {
                return b(aVar, 1);
            }
            if (zY != null && zY.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent k(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.auB.Bl().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aus, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aut);
        intent.putExtra("at_me", this.auv);
        intent.putExtra("reply_me", this.auu);
        intent.putExtra("fans", this.auy);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.auB.AR() - this.auB.AY());
        intent.putExtra("group_msg_validate", this.auB.AU());
        intent.putExtra("group_msg_updates", this.auB.AS());
        intent.putExtra("officialbar_msg", this.auB.AV());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zA() {
        Intent intent = new Intent(this.aus, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.auB.AT());
        return intent;
    }

    public void zB() {
        NotificationHelper.cancelNotification(this.aus, 23);
        NotificationHelper.cancelNotification(this.aus, 24);
        NotificationHelper.cancelNotification(this.aus, 25);
        NotificationHelper.cancelNotification(this.aus, 29);
        NotificationHelper.cancelNotification(this.aus, 26);
        NotificationHelper.cancelNotification(this.aus, 17);
        NotificationHelper.cancelNotification(this.aus, 15);
        NotificationHelper.cancelNotification(this.aus, 13);
        NotificationHelper.cancelNotification(this.aus, 12);
    }

    public void zC() {
        NotificationHelper.cancelNotification(this.aus, 16);
    }

    public void zD() {
        NotificationHelper.cancelNotification(this.aus, 19);
    }

    public void dQ(int i) {
        NotificationHelper.cancelNotification(this.aus, i);
    }

    public void zE() {
        NotificationHelper.cancelNotification(this.aus, 30);
    }

    public void fg(String str) {
        if (TextUtils.isEmpty(str)) {
            zC();
            return;
        }
        e zT = zT();
        if (zT == null) {
            zC();
            return;
        }
        HashMap<String, String> Bf = zT.Bf();
        if (Bf == null || Bf.isEmpty()) {
            zC();
        } else if (Bf.containsKey(str)) {
            zC();
        }
    }

    public void fh(String str) {
        if (TextUtils.isEmpty(str)) {
            zC();
            return;
        }
        e zT = zT();
        if (zT == null) {
            zC();
            return;
        }
        HashMap<String, String> Bl = zT.Bl();
        if (Bl == null || Bl.isEmpty()) {
            zC();
        } else if (Bl.containsKey(str)) {
            zC();
        }
    }

    private boolean zF() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zG() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void zH() {
        NotificationHelper.cancelNotification(this.aus, 17);
    }

    public void dR(int i) {
        e zT = zT();
        if (zT == null) {
            zH();
        } else if (1 == i) {
            if (zT.AS() <= 0) {
                zH();
            }
        } else if (2 == i && zT.AU() <= 0) {
            zH();
        }
    }

    public void zI() {
        NotificationHelper.cancelNotification(this.aus, 18);
    }

    public void zJ() {
        NotificationHelper.cancelNotification(this.aus, 26);
        NotificationHelper.cancelNotification(this.aus, 25);
        NotificationHelper.cancelNotification(this.aus, 24);
        NotificationHelper.cancelNotification(this.aus, 23);
        NotificationHelper.cancelNotification(this.aus, 16);
        NotificationHelper.cancelNotification(this.aus, 17);
        NotificationHelper.cancelNotification(this.aus, 29);
    }

    public void zK() {
        NotificationHelper.cancelNotification(this.aus, 17);
        NotificationHelper.cancelNotification(this.aus, 19);
        NotificationHelper.cancelNotification(this.aus, 16);
        NotificationHelper.cancelNotification(this.aus, 18);
        NotificationHelper.cancelNotification(this.aus, 30);
    }

    public void zL() {
        NotificationHelper.cancelNotification(this.aus, 24);
    }

    public void zM() {
        NotificationHelper.cancelNotification(this.aus, 25);
    }

    public void zN() {
        NotificationHelper.cancelNotification(this.aus, 29);
    }

    public void zO() {
        NotificationHelper.cancelNotification(this.aus, 23);
    }

    public void zP() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(zQ());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zR());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.auB.Bj());
        newsNotifyMessage.setMsgStrangerChat(this.auB.Bo());
        newsNotifyMessage.setMsgOfficialMerge(this.auB.Bn());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(zQ());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Bj() + eVar.AR()) + eVar.Bo()) + eVar.Bn()) + eVar.Bq()) - eVar.AY());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Bj());
            newsNotifyMessage.setMsgStrangerChat(eVar.Bo());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Bn());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.auu;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aut, i, this.auv, this.auw, this.auy, this.aux, this.auz);
        }
    }

    public int getMsgAtme() {
        return this.auv;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aut, this.auu, i, this.auw, this.auy, this.aux, this.auz);
        }
    }

    public int zQ() {
        return this.aut;
    }

    public void dS(int i) {
        if (i >= 0) {
            a(i, this.auu, this.auv, this.auw, this.auy, this.aux, this.auz);
        }
    }

    public int getMsgChat() {
        return this.auw;
    }

    public int zR() {
        return ((((this.auB.Bj() + this.auB.AR()) + this.auB.Bo()) + this.auB.Bn()) + this.auB.Bq()) - this.auB.AY();
    }

    public int getMsgFans() {
        return this.auy;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aut, this.auu, this.auv, this.auw, i, this.aux, this.auz);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aut, this.auu, this.auv, i, this.auy, this.aux, this.auz);
        }
    }

    public int getMsgBookmark() {
        return this.aux;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aut, this.auu, this.auv, this.auw, this.auy, i, this.auz);
        }
    }

    public int getMsgGiftNum() {
        return this.auz;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.auz = i;
        }
    }

    public void aW(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aut = 0;
        this.auu = 0;
        this.auv = 0;
        this.auw = 0;
        this.auy = 0;
        this.aux = 0;
    }

    public int zS() {
        return this.aut + this.auu + this.auv + this.auw + this.auy + this.auz;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.auB = eVar;
            this.auw = (eVar.AR() - eVar.AY()) + eVar.Bj() + eVar.Bn() + eVar.Bq();
            a(eVar);
            if (eVar.AZ()) {
                this.auC = null;
                mHandler.removeMessages(0);
            }
            if (eVar.AZ()) {
                if (c.Ae().At() && c.Ae().Ah() > 0) {
                    i = eVar.AR() - eVar.AY();
                }
                long Bj = (!c.Ae().Am() || c.Ae().Ah() <= 0) ? 0L : eVar.Bj();
                if ((i > 0 || Bj > 0) && ((i > eVar.Bc() - eVar.AY() && i > 0) || Bj > eVar.AW())) {
                    a(1, 16, eVar);
                }
                int AV = eVar.AV();
                if (AV > 0 && AV > eVar.Bi()) {
                    a(1, 19, eVar);
                }
                if (eVar.AS() > eVar.Bg() || eVar.AU() > eVar.Bh()) {
                    if (eVar.AS() <= eVar.Bg() || eVar.AU() != eVar.Bh() || !zG()) {
                        if (eVar.AS() != eVar.Bg() || eVar.AU() <= eVar.Bh() || !zF()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e zT() {
        return this.auB;
    }

    public void c(e eVar) {
        this.auB = eVar;
    }

    public e zU() {
        return this.auC;
    }

    public int dT(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aus, 26, i);
        }
    }

    public HashMap<Integer, HashSet> zV() {
        JSONArray jSONArray;
        if (!aup && auq) {
            return this.aur;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aur.get(0) == null) {
                this.aur.put(0, new HashSet());
            }
            this.aur.get(0).add("3222425470");
            return this.aur;
        }
        if (this.aur.get(0) != null) {
            this.aur.get(0).clear();
        }
        if (this.aur.get(1) != null) {
            this.aur.get(1).clear();
        }
        if (this.aur.get(2) != null) {
            this.aur.get(2).clear();
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
                        if (this.aur.get(0) == null) {
                            this.aur.put(0, new HashSet());
                        }
                        this.aur.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aur.get(1) == null) {
                            this.aur.put(1, new HashSet());
                        }
                        this.aur.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aur.get(2) == null) {
                            this.aur.put(2, new HashSet());
                        }
                        this.aur.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        auq = true;
        aup = false;
        return this.aur;
    }

    public HashSet<String> zW() {
        zV();
        return this.aur.get(0);
    }

    public HashSet<String> zX() {
        zV();
        return this.aur.get(1);
    }

    public HashSet<String> zY() {
        zV();
        return this.aur.get(2);
    }

    public String zZ() {
        HashSet<String> zW = zW();
        if (zW != null) {
            Iterator<String> it = zW.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
