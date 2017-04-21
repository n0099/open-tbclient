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
    private static a aqd;
    private static Date aqg = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.c.e aqf;
    private String aqi;
    private String aqj;
    private int apW = 0;
    private int apX = 0;
    private int apY = 0;
    private int apZ = 0;
    private int aqa = 0;
    private int aqb = 0;
    private int aqc = 0;
    private com.baidu.tbadk.coreExtra.c.e aqe = new com.baidu.tbadk.coreExtra.c.e();
    private boolean aqh = true;
    private final int[] aqk = new int[10];
    private final Context apV = TbadkCoreApplication.m9getInst().getApp();

    public static a zj() {
        if (aqd == null) {
            aqd = new a();
        }
        return aqd;
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
                    this.aqi = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aqi = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aqj = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.apW || i2 != this.apX || i3 != this.apY || i4 != this.aqa || i5 != this.apZ || i6 != this.aqb) {
            if (i > this.apW || i2 > this.apX || i3 > this.apY || i4 > this.aqa || i5 > this.apZ || i6 > this.aqb) {
                i7 = 1;
            } else {
                i7 = (i < this.apW || i2 < this.apX) ? 2 : 0;
            }
            if (i > this.apW) {
                i8 = 1;
            } else {
                i8 = i < this.apW ? 2 : 0;
            }
            if (i2 > this.apX) {
                i9 = 1;
            } else {
                i9 = i2 < this.apX ? 2 : 0;
            }
            int i11 = i3 > this.apY ? 1 : 0;
            int i12 = i4 > this.aqa ? 1 : 0;
            int i13 = i6 <= this.aqb ? 0 : 1;
            this.apW = i;
            this.apX = i2;
            this.apY = i3;
            this.aqa = i4;
            this.apZ = i5;
            this.aqb = i6;
            if (zD() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zB();
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
        if (i != this.apW || i2 != this.apX || i3 != this.apY || i4 != this.aqa || this.aqb != i5) {
            this.apW = i;
            this.apX = i2;
            this.apY = i3;
            this.aqa = i4;
            this.aqb = i5;
            zB();
            if (zD() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean zk() {
        if (aqg == null) {
            aqg = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aqg.getTime() < 10000) {
                return false;
            }
            aqg = date;
        }
        return true;
    }

    public static boolean zl() {
        if (c.zG().zR()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.zG().zT().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.zG().zU().split(":");
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
                    if (this.aqb > 0) {
                        String format = String.format(this.apV.getString(w.l.notify_gift), String.valueOf(this.aqb));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.apW > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.apW > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.apW));
                            sb.append(this.apV.getString(w.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.aqi != null) {
                            sb.append(this.aqi);
                        } else {
                            sb.append(this.apV.getString(w.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.apX > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.apX > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.apX));
                            sb2.append(this.apV.getString(w.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aqj != null) {
                            sb2.append(this.aqj);
                        } else {
                            sb2.append(this.apV.getString(w.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aqa > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aqa > 1) {
                            sb3.append(String.format(this.apV.getString(w.l.notify_fans_unit), Integer.valueOf(this.aqa)));
                        }
                        sb3.append(this.apV.getString(w.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.zG().zV()) {
                    c.zG().zJ();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.apV, 16);
                NotificationHelper.cancelNotification(this.apV, 17);
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
        String AA;
        String Az;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aqb > 0) {
                            String format = String.format(this.apV.getString(w.l.notify_gift), String.valueOf(this.aqb));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.apW > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.apW > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.apW));
                                sb.append(this.apV.getString(w.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.aqi != null) {
                                sb.append(this.aqi);
                            } else {
                                sb.append(this.apV.getString(w.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.apX > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.apX > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.apX));
                                sb2.append(this.apV.getString(w.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aqj != null) {
                                sb2.append(this.aqj);
                            } else {
                                sb2.append(this.apV.getString(w.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aqa > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aqa > 1) {
                                sb3.append(String.format(this.apV.getString(w.l.notify_fans_unit), Integer.valueOf(this.aqa)));
                            }
                            sb3.append(this.apV.getString(w.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Aq = (!c.zG().zV() || c.zG().zJ() <= 0) ? 0 : eVar.Aq() - eVar.Ax();
                        long AI = (!c.zG().zO() || c.zG().zJ() <= 0) ? 0L : eVar.AI();
                        boolean z4 = AI > 0;
                        long j = Aq + AI;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.apV.getString(w.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.AL();
                            eVar.AJ();
                            if (AI == 1) {
                                AA = eVar.AL();
                                str = eVar.AJ();
                                Az = String.valueOf(AA) + "：" + str;
                            } else if (Aq == 1) {
                                AA = eVar.AA();
                                Az = eVar.Az();
                                str = Az;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.apV.getString(w.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Az)) {
                                Az = str;
                            }
                            c(16, AA, str, Az, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AS = eVar.AS();
                        if (AS != null && AS.size() != 0) {
                            for (e.b bVar : AS) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.arA != 0 && bVar.unReadCount > bVar.arB) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AT = eVar.AT();
                        if (AT != null && AT.size() != 0) {
                            for (e.a aVar : AT) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.arA != 0 && aVar.unReadCount > aVar.arB) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.zG().zV() && c.zG().zJ() > 0) {
                        if (eVar.Ar() + eVar.At() > 0) {
                            if (eVar.Ar() > 0 && !zs()) {
                                long Ar = eVar.Ar() - eVar.As();
                                if (Ar > 0) {
                                    stringBuffer.append(String.format(this.apV.getString(w.l.notify_updates), Long.valueOf(Ar)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.As() > 0) {
                                    z = true;
                                }
                                if (eVar.At() > 0 || zr()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.apV.getString(w.l.notify_validate), Integer.valueOf(eVar.At())));
                                } else {
                                    stringBuffer.append(String.format(this.apV.getString(w.l.notify_validate_1), Integer.valueOf(eVar.At())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.AC(), eVar.AD(), eVar.AD());
                                }
                            }
                            z = false;
                            if (eVar.At() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.AM() > 0 && !zt()) {
                            String format2 = String.format(this.apV.getString(w.l.notify_live), Integer.valueOf(eVar.AM()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.apV, 16);
                    NotificationHelper.cancelNotification(this.apV, 17);
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
            PendingIntent service = PendingIntent.getService(this.apV, bVar.arA, a, 134217728);
            G(dH(i), i);
            NotificationHelper.showNotification(this.apV, i, bVar.title, bVar.content, bVar.arC, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apV, aVar.arA, a, 134217728);
            G(dH(i), i);
            NotificationHelper.showNotification(this.apV, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aqh) {
            if (i == 23 && this.aqb > 0) {
                h = dD(i);
            } else if (i == 26 && this.aqa > 0) {
                h = dE(i);
            } else if (i == 18) {
                h = zm();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apV, i, h, 134217728);
            G(dH(i), i);
            NotificationHelper.showNotification(this.apV, i, str, str2, str3, service, false);
        }
    }

    public Intent dD(int i) {
        Intent intent = new Intent(this.apV, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aqb);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dE(int i) {
        Intent intent = new Intent(this.apV, DealIntentService.class);
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
        ImMessageCenterPojo Y = com.baidu.tieba.im.memorycache.b.atd().Y(new StringBuilder(String.valueOf(bVar.arA)).toString(), bVar.userType);
        if (Y == null || Y.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(Y.getLastContentRawData());
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
                    Intent intent = new Intent(this.apV, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.arA);
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
        Intent intent = new Intent(this.apV, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.arA);
        intent.putExtra("uname", bVar.arD);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.apV, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.arA));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aqe.AK().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.apV, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.apX);
        intent.putExtra("reply_me", this.apW);
        intent.putExtra("fans", this.aqa);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aqe.Aq() - this.aqe.Ax());
        intent.putExtra("group_msg_validate", this.aqe.At());
        intent.putExtra("group_msg_updates", this.aqe.Ar());
        intent.putExtra("live_notify_msg_updates", this.aqe.AM());
        intent.putExtra("officialbar_msg", this.aqe.Au());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zm() {
        Intent intent = new Intent(this.apV, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aqe.As());
        return intent;
    }

    public void zn() {
        NotificationHelper.cancelNotification(this.apV, 23);
        NotificationHelper.cancelNotification(this.apV, 24);
        NotificationHelper.cancelNotification(this.apV, 25);
        NotificationHelper.cancelNotification(this.apV, 26);
        NotificationHelper.cancelNotification(this.apV, 17);
        NotificationHelper.cancelNotification(this.apV, 15);
        NotificationHelper.cancelNotification(this.apV, 13);
        NotificationHelper.cancelNotification(this.apV, 12);
    }

    public void zo() {
        NotificationHelper.cancelNotification(this.apV, 16);
    }

    public void zp() {
        NotificationHelper.cancelNotification(this.apV, 19);
    }

    public void dF(int i) {
        NotificationHelper.cancelNotification(this.apV, i);
    }

    public int zq() {
        return this.aqe.AP();
    }

    public void el(String str) {
        if (TextUtils.isEmpty(str)) {
            zo();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e zE = zE();
        if (zE == null) {
            zo();
            return;
        }
        HashMap<String, String> AE = zE.AE();
        if (AE == null || AE.isEmpty()) {
            zo();
        } else if (AE.containsKey(str)) {
            zo();
        }
    }

    public void em(String str) {
        if (TextUtils.isEmpty(str)) {
            zo();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e zE = zE();
        if (zE == null) {
            zo();
            return;
        }
        HashMap<String, String> AK = zE.AK();
        if (AK == null || AK.isEmpty()) {
            zo();
        } else if (AK.containsKey(str)) {
            zo();
        }
    }

    private boolean zr() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zs() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean zt() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void zu() {
        NotificationHelper.cancelNotification(this.apV, 17);
    }

    public void dG(int i) {
        com.baidu.tbadk.coreExtra.c.e zE = zE();
        if (zE == null) {
            zu();
        } else if (1 == i) {
            if (zE.Ar() <= 0) {
                zu();
            }
        } else if (2 == i) {
            if (zE.At() <= 0) {
                zu();
            }
        } else if (3 == i && zE.AM() <= 0) {
            NotificationHelper.cancelNotification(this.apV, 21);
        }
    }

    public void zv() {
        NotificationHelper.cancelNotification(this.apV, 18);
    }

    public void zw() {
        NotificationHelper.cancelNotification(this.apV, 26);
        NotificationHelper.cancelNotification(this.apV, 25);
        NotificationHelper.cancelNotification(this.apV, 24);
        NotificationHelper.cancelNotification(this.apV, 23);
        NotificationHelper.cancelNotification(this.apV, 16);
        NotificationHelper.cancelNotification(this.apV, 17);
    }

    public void zx() {
        NotificationHelper.cancelNotification(this.apV, 21);
        NotificationHelper.cancelNotification(this.apV, 17);
        NotificationHelper.cancelNotification(this.apV, 19);
        NotificationHelper.cancelNotification(this.apV, 16);
        NotificationHelper.cancelNotification(this.apV, 18);
    }

    public void zy() {
        NotificationHelper.cancelNotification(this.apV, 24);
    }

    public void zz() {
        NotificationHelper.cancelNotification(this.apV, 25);
    }

    public void zA() {
        NotificationHelper.cancelNotification(this.apV, 23);
    }

    public void zB() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zC());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.aqe.AI());
        newsNotifyMessage.setMsgStrangerChat(this.aqe.AP());
        newsNotifyMessage.setMsgOfficialMerge(this.aqe.AO());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.AI() + eVar.Aq()) + eVar.AP()) + eVar.AO()) + eVar.AU()) - eVar.Ax());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.AI());
            newsNotifyMessage.setMsgStrangerChat(eVar.AP());
            newsNotifyMessage.setMsgOfficialMerge(eVar.AO());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.apW;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.apX, this.apY, this.aqa, this.apZ, this.aqb);
        }
    }

    public int getMsgAtme() {
        return this.apX;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.apW, i, this.apY, this.aqa, this.apZ, this.aqb);
        }
    }

    public int getMsgChat() {
        return this.apY;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1095=5] */
    public int zC() {
        return ((((this.aqe.AI() + this.aqe.Aq()) + this.aqe.AP()) + this.aqe.AO()) + this.aqe.AU()) - this.aqe.Ax();
    }

    public int getMsgFans() {
        return this.aqa;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.apW, this.apX, this.apY, i, this.apZ, this.aqb);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.apW, this.apX, i, this.aqa, this.apZ, this.aqb);
        }
    }

    public int getMsgBookmark() {
        return this.apZ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.apW, this.apX, this.apY, this.aqa, i, this.aqb);
        }
    }

    public int getMsgGiftNum() {
        return this.aqb;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aqb = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.aqc = i;
            zB();
        }
    }

    public int getMsgLiveVip() {
        return this.aqc;
    }

    public void aU(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.apW = 0;
        this.apX = 0;
        this.apY = 0;
        this.aqa = 0;
        this.apZ = 0;
    }

    public int zD() {
        return this.apW + this.apX + this.apY + this.aqa + this.aqb;
    }

    public void b(com.baidu.tbadk.coreExtra.c.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aqe = eVar;
            this.apY = (eVar.Aq() - eVar.Ax()) + eVar.AI() + eVar.AO() + eVar.AU();
            a(eVar);
            if (eVar.Ay()) {
                this.aqf = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ay()) {
                if (c.zG().zV() && c.zG().zJ() > 0) {
                    i = eVar.Aq() - eVar.Ax();
                }
                long AI = (!c.zG().zO() || c.zG().zJ() <= 0) ? 0L : eVar.AI();
                if ((i > 0 || AI > 0) && ((i > eVar.AB() - eVar.Ax() && i > 0) || AI > eVar.Av())) {
                    a(1, 16, eVar);
                }
                int Au = eVar.Au();
                if (Au > 0 && Au > eVar.AH()) {
                    a(1, 19, eVar);
                }
                if (eVar.Ar() > eVar.AF() || eVar.At() > eVar.AG()) {
                    if (eVar.Ar() <= eVar.AF() || eVar.At() != eVar.AG() || !zs()) {
                        if (eVar.Ar() != eVar.AF() || eVar.At() <= eVar.AG() || !zr()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.AM() > eVar.AN() && !zt()) {
                    a(1, 21, eVar);
                }
                if (eVar.AQ() > eVar.AR()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.c.e zE() {
        return this.aqe;
    }

    public void c(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.aqe = eVar;
    }

    public com.baidu.tbadk.coreExtra.c.e zF() {
        return this.aqf;
    }

    public int dH(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apV, 26, i2);
        }
    }
}
