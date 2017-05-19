package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.w;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aqf;
    private static Date aqi = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.c.e aqh;
    private String aqk;
    private String aql;
    private int apY = 0;
    private int apZ = 0;
    private int aqa = 0;
    private int aqb = 0;
    private int aqc = 0;
    private int aqd = 0;
    private int aqe = 0;
    private com.baidu.tbadk.coreExtra.c.e aqg = new com.baidu.tbadk.coreExtra.c.e();
    private boolean aqj = true;
    private final int[] aqm = new int[10];
    private final Context apX = TbadkCoreApplication.m9getInst().getApp();

    public static a yu() {
        if (aqf == null) {
            aqf = new a();
        }
        return aqf;
    }

    private a() {
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.aqk = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aqk = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aql = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.apY || i2 != this.apZ || i3 != this.aqa || i4 != this.aqc || i5 != this.aqb || i6 != this.aqd) {
            if (i > this.apY || i2 > this.apZ || i3 > this.aqa || i4 > this.aqc || i5 > this.aqb || i6 > this.aqd) {
                i7 = 1;
            } else {
                i7 = (i < this.apY || i2 < this.apZ) ? 2 : 0;
            }
            if (i > this.apY) {
                i8 = 1;
            } else {
                i8 = i < this.apY ? 2 : 0;
            }
            if (i2 > this.apZ) {
                i9 = 1;
            } else {
                i9 = i2 < this.apZ ? 2 : 0;
            }
            int i11 = i3 > this.aqa ? 1 : 0;
            int i12 = i4 > this.aqc ? 1 : 0;
            int i13 = i6 <= this.aqd ? 0 : 1;
            this.apY = i;
            this.apZ = i2;
            this.aqa = i3;
            this.aqc = i4;
            this.aqb = i5;
            this.aqd = i6;
            if (yO() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yM();
                F(i10, 23);
                F(i11, 16);
                F(i7, 17);
                F(i8, 24);
                F(i9, 25);
                F(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.apY || i2 != this.apZ || i3 != this.aqa || i4 != this.aqc || this.aqd != i5) {
            this.apY = i;
            this.apZ = i2;
            this.aqa = i3;
            this.aqc = i4;
            this.aqd = i5;
            yM();
            if (yO() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean yv() {
        if (aqi == null) {
            aqi = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aqi.getTime() < 10000) {
                return false;
            }
            aqi = date;
        }
        return true;
    }

    public static boolean yw() {
        if (c.yR().zc()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yR().ze().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yR().zf().split(":");
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

    private void F(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.aqd > 0) {
                        String format = String.format(this.apX.getString(w.l.notify_gift), String.valueOf(this.aqd));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.apY > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.apY > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.apY));
                            sb.append(this.apX.getString(w.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.aqk != null) {
                            sb.append(this.aqk);
                        } else {
                            sb.append(this.apX.getString(w.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.apZ > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.apZ > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.apZ));
                            sb2.append(this.apX.getString(w.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aql != null) {
                            sb2.append(this.aql);
                        } else {
                            sb2.append(this.apX.getString(w.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aqc > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aqc > 1) {
                            sb3.append(String.format(this.apX.getString(w.l.notify_fans_unit), Integer.valueOf(this.aqc)));
                        }
                        sb3.append(this.apX.getString(w.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yR().zg()) {
                    c.yR().yU();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.apX, 16);
                NotificationHelper.cancelNotification(this.apX, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0306 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d2, B:70:0x01d8, B:71:0x01f6, B:74:0x01fd, B:76:0x0207, B:79:0x0215, B:81:0x021b, B:83:0x0221, B:84:0x0225, B:86:0x022b, B:88:0x0233, B:90:0x023b, B:92:0x023f, B:94:0x0245, B:97:0x024f, B:99:0x0255, B:101:0x025b, B:102:0x025f, B:104:0x0265, B:106:0x026d, B:108:0x0275, B:110:0x0279, B:112:0x027f, B:113:0x0285, B:115:0x028f, B:117:0x0299, B:119:0x02a4, B:121:0x02aa, B:123:0x02b0, B:125:0x02be, B:126:0x02d9, B:128:0x02df, B:131:0x02e7, B:133:0x0306, B:135:0x0316, B:144:0x035e, B:141:0x0355, B:136:0x0327, B:138:0x032d, B:140:0x0333, B:147:0x037f), top: B:154:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0316 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d2, B:70:0x01d8, B:71:0x01f6, B:74:0x01fd, B:76:0x0207, B:79:0x0215, B:81:0x021b, B:83:0x0221, B:84:0x0225, B:86:0x022b, B:88:0x0233, B:90:0x023b, B:92:0x023f, B:94:0x0245, B:97:0x024f, B:99:0x0255, B:101:0x025b, B:102:0x025f, B:104:0x0265, B:106:0x026d, B:108:0x0275, B:110:0x0279, B:112:0x027f, B:113:0x0285, B:115:0x028f, B:117:0x0299, B:119:0x02a4, B:121:0x02aa, B:123:0x02b0, B:125:0x02be, B:126:0x02d9, B:128:0x02df, B:131:0x02e7, B:133:0x0306, B:135:0x0316, B:144:0x035e, B:141:0x0355, B:136:0x0327, B:138:0x032d, B:140:0x0333, B:147:0x037f), top: B:154:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.c.e eVar) {
        boolean z;
        String zL;
        String zK;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aqd > 0) {
                            String format = String.format(this.apX.getString(w.l.notify_gift), String.valueOf(this.aqd));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.apY > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.apY > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.apY));
                                sb.append(this.apX.getString(w.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.aqk != null) {
                                sb.append(this.aqk);
                            } else {
                                sb.append(this.apX.getString(w.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.apZ > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.apZ > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.apZ));
                                sb2.append(this.apX.getString(w.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aql != null) {
                                sb2.append(this.aql);
                            } else {
                                sb2.append(this.apX.getString(w.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aqc > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aqc > 1) {
                                sb3.append(String.format(this.apX.getString(w.l.notify_fans_unit), Integer.valueOf(this.aqc)));
                            }
                            sb3.append(this.apX.getString(w.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zB = (!c.yR().zg() || c.yR().yU() <= 0) ? 0 : eVar.zB() - eVar.zI();
                        long zT = (!c.yR().yZ() || c.yR().yU() <= 0) ? 0L : eVar.zT();
                        boolean z4 = zT > 0;
                        long j = zB + zT;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.apX.getString(w.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.zW();
                            eVar.zU();
                            if (zT == 1) {
                                zL = eVar.zW();
                                str = eVar.zU();
                                zK = String.valueOf(zL) + "：" + str;
                            } else if (zB == 1) {
                                zL = eVar.zL();
                                zK = eVar.zK();
                                str = zK;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.apX.getString(w.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zK)) {
                                zK = str;
                            }
                            c(16, zL, str, zK, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Ad = eVar.Ad();
                        if (Ad != null && Ad.size() != 0) {
                            for (e.b bVar : Ad) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.arC != 0 && bVar.unReadCount > bVar.arD) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ae = eVar.Ae();
                        if (Ae != null && Ae.size() != 0) {
                            for (e.a aVar : Ae) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.arC != 0 && aVar.unReadCount > aVar.arD) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.yR().zg() && c.yR().yU() > 0) {
                        if (eVar.zC() + eVar.zE() > 0) {
                            if (eVar.zC() > 0 && !yD()) {
                                long zC = eVar.zC() - eVar.zD();
                                if (zC > 0) {
                                    stringBuffer.append(String.format(this.apX.getString(w.l.notify_updates), Long.valueOf(zC)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zD() > 0) {
                                    z = true;
                                }
                                if (eVar.zE() > 0 || yC()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.apX.getString(w.l.notify_validate), Integer.valueOf(eVar.zE())));
                                } else {
                                    stringBuffer.append(String.format(this.apX.getString(w.l.notify_validate_1), Integer.valueOf(eVar.zE())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zN(), eVar.zO(), eVar.zO());
                                }
                            }
                            z = false;
                            if (eVar.zE() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.zX() > 0 && !yE()) {
                            String format2 = String.format(this.apX.getString(w.l.notify_live), Integer.valueOf(eVar.zX()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.apX, 16);
                    NotificationHelper.cancelNotification(this.apX, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        c(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null || (a = b(bVar)) != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apX, bVar.arC, a, 134217728);
            G(dF(i), i);
            NotificationHelper.showNotification(this.apX, i, bVar.title, bVar.content, bVar.arE, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apX, aVar.arC, a, 134217728);
            G(dF(i), i);
            NotificationHelper.showNotification(this.apX, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aqj) {
            if (i == 23 && this.aqd > 0) {
                h = dB(i);
            } else if (i == 26 && this.aqc > 0) {
                h = dC(i);
            } else if (i == 18) {
                h = yx();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apX, i, h, 134217728);
            G(dF(i), i);
            NotificationHelper.showNotification(this.apX, i, str, str2, str3, service, false);
        }
    }

    public Intent dB(int i) {
        Intent intent = new Intent(this.apX, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aqd);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dC(int i) {
        Intent intent = new Intent(this.apX, DealIntentService.class);
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

    public Intent a(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        ImMessageCenterPojo Z = com.baidu.tieba.im.memorycache.b.apX().Z(new StringBuilder(String.valueOf(bVar.arC)).toString(), bVar.userType);
        if (Z == null || Z.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(Z.getLastContentRawData());
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
                    Intent intent = new Intent(this.apX, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.arC);
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

    public Intent b(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        Intent intent = new Intent(this.apX, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.arC);
        intent.putExtra("uname", bVar.arF);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.apX, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.arC));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aqg.zV().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.apX, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.apZ);
        intent.putExtra("reply_me", this.apY);
        intent.putExtra("fans", this.aqc);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aqg.zB() - this.aqg.zI());
        intent.putExtra("group_msg_validate", this.aqg.zE());
        intent.putExtra("group_msg_updates", this.aqg.zC());
        intent.putExtra("live_notify_msg_updates", this.aqg.zX());
        intent.putExtra("officialbar_msg", this.aqg.zF());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yx() {
        Intent intent = new Intent(this.apX, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aqg.zD());
        return intent;
    }

    public void yy() {
        NotificationHelper.cancelNotification(this.apX, 23);
        NotificationHelper.cancelNotification(this.apX, 24);
        NotificationHelper.cancelNotification(this.apX, 25);
        NotificationHelper.cancelNotification(this.apX, 26);
        NotificationHelper.cancelNotification(this.apX, 17);
        NotificationHelper.cancelNotification(this.apX, 15);
        NotificationHelper.cancelNotification(this.apX, 13);
        NotificationHelper.cancelNotification(this.apX, 12);
    }

    public void yz() {
        NotificationHelper.cancelNotification(this.apX, 16);
    }

    public void yA() {
        NotificationHelper.cancelNotification(this.apX, 19);
    }

    public void dD(int i) {
        NotificationHelper.cancelNotification(this.apX, i);
    }

    public int yB() {
        return this.aqg.Aa();
    }

    public void ek(String str) {
        if (TextUtils.isEmpty(str)) {
            yz();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e yP = yP();
        if (yP == null) {
            yz();
            return;
        }
        HashMap<String, String> zP = yP.zP();
        if (zP == null || zP.isEmpty()) {
            yz();
        } else if (zP.containsKey(str)) {
            yz();
        }
    }

    public void el(String str) {
        if (TextUtils.isEmpty(str)) {
            yz();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e yP = yP();
        if (yP == null) {
            yz();
            return;
        }
        HashMap<String, String> zV = yP.zV();
        if (zV == null || zV.isEmpty()) {
            yz();
        } else if (zV.containsKey(str)) {
            yz();
        }
    }

    private boolean yC() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yD() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yE() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yF() {
        NotificationHelper.cancelNotification(this.apX, 17);
    }

    public void dE(int i) {
        com.baidu.tbadk.coreExtra.c.e yP = yP();
        if (yP == null) {
            yF();
        } else if (1 == i) {
            if (yP.zC() <= 0) {
                yF();
            }
        } else if (2 == i) {
            if (yP.zE() <= 0) {
                yF();
            }
        } else if (3 == i && yP.zX() <= 0) {
            NotificationHelper.cancelNotification(this.apX, 21);
        }
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.apX, 18);
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.apX, 26);
        NotificationHelper.cancelNotification(this.apX, 25);
        NotificationHelper.cancelNotification(this.apX, 24);
        NotificationHelper.cancelNotification(this.apX, 23);
        NotificationHelper.cancelNotification(this.apX, 16);
        NotificationHelper.cancelNotification(this.apX, 17);
    }

    public void yI() {
        NotificationHelper.cancelNotification(this.apX, 21);
        NotificationHelper.cancelNotification(this.apX, 17);
        NotificationHelper.cancelNotification(this.apX, 19);
        NotificationHelper.cancelNotification(this.apX, 16);
        NotificationHelper.cancelNotification(this.apX, 18);
    }

    public void yJ() {
        NotificationHelper.cancelNotification(this.apX, 24);
    }

    public void yK() {
        NotificationHelper.cancelNotification(this.apX, 25);
    }

    public void yL() {
        NotificationHelper.cancelNotification(this.apX, 23);
    }

    public void yM() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yN());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.aqg.zT());
        newsNotifyMessage.setMsgStrangerChat(this.aqg.Aa());
        newsNotifyMessage.setMsgOfficialMerge(this.aqg.zZ());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zT() + eVar.zB()) + eVar.Aa()) + eVar.zZ()) + eVar.Af()) - eVar.zI());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zT());
            newsNotifyMessage.setMsgStrangerChat(eVar.Aa());
            newsNotifyMessage.setMsgOfficialMerge(eVar.zZ());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.apY;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.apZ, this.aqa, this.aqc, this.aqb, this.aqd);
        }
    }

    public int getMsgAtme() {
        return this.apZ;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.apY, i, this.aqa, this.aqc, this.aqb, this.aqd);
        }
    }

    public int getMsgChat() {
        return this.aqa;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1095=5] */
    public int yN() {
        return ((((this.aqg.zT() + this.aqg.zB()) + this.aqg.Aa()) + this.aqg.zZ()) + this.aqg.Af()) - this.aqg.zI();
    }

    public int getMsgFans() {
        return this.aqc;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.apY, this.apZ, this.aqa, i, this.aqb, this.aqd);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.apY, this.apZ, i, this.aqc, this.aqb, this.aqd);
        }
    }

    public int getMsgBookmark() {
        return this.aqb;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.apY, this.apZ, this.aqa, this.aqc, i, this.aqd);
        }
    }

    public int getMsgGiftNum() {
        return this.aqd;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aqd = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.aqe = i;
            yM();
        }
    }

    public int getMsgLiveVip() {
        return this.aqe;
    }

    public void aU(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.apY = 0;
        this.apZ = 0;
        this.aqa = 0;
        this.aqc = 0;
        this.aqb = 0;
    }

    public int yO() {
        return this.apY + this.apZ + this.aqa + this.aqc + this.aqd;
    }

    public void b(com.baidu.tbadk.coreExtra.c.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aqg = eVar;
            this.aqa = (eVar.zB() - eVar.zI()) + eVar.zT() + eVar.zZ() + eVar.Af();
            a(eVar);
            if (eVar.zJ()) {
                this.aqh = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zJ()) {
                if (c.yR().zg() && c.yR().yU() > 0) {
                    i = eVar.zB() - eVar.zI();
                }
                long zT = (!c.yR().yZ() || c.yR().yU() <= 0) ? 0L : eVar.zT();
                if ((i > 0 || zT > 0) && ((i > eVar.zM() - eVar.zI() && i > 0) || zT > eVar.zG())) {
                    a(1, 16, eVar);
                }
                int zF = eVar.zF();
                if (zF > 0 && zF > eVar.zS()) {
                    a(1, 19, eVar);
                }
                if (eVar.zC() > eVar.zQ() || eVar.zE() > eVar.zR()) {
                    if (eVar.zC() <= eVar.zQ() || eVar.zE() != eVar.zR() || !yD()) {
                        if (eVar.zC() != eVar.zQ() || eVar.zE() <= eVar.zR() || !yC()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.zX() > eVar.zY() && !yE()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ab() > eVar.Ac()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.c.e yP() {
        return this.aqg;
    }

    public void c(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.aqg = eVar;
    }

    public com.baidu.tbadk.coreExtra.c.e yQ() {
        return this.aqh;
    }

    public int dF(int i) {
        switch (i) {
            case 12:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 27:
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
                return 3;
            default:
                return 0;
        }
    }

    public void G(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apX, 26, i2);
        }
    }
}
