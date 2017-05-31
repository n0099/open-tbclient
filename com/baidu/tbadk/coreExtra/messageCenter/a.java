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
    private static a apP;
    private static Date apS = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.c.e apR;
    private String apU;
    private String apV;
    private int apI = 0;
    private int apJ = 0;
    private int apK = 0;
    private int apL = 0;
    private int apM = 0;
    private int apN = 0;
    private int apO = 0;
    private com.baidu.tbadk.coreExtra.c.e apQ = new com.baidu.tbadk.coreExtra.c.e();
    private boolean apT = true;
    private final int[] apW = new int[10];
    private final Context apH = TbadkCoreApplication.m9getInst().getApp();

    public static a yn() {
        if (apP == null) {
            apP = new a();
        }
        return apP;
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
                    this.apU = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.apU = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.apV = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.apI || i2 != this.apJ || i3 != this.apK || i4 != this.apM || i5 != this.apL || i6 != this.apN) {
            if (i > this.apI || i2 > this.apJ || i3 > this.apK || i4 > this.apM || i5 > this.apL || i6 > this.apN) {
                i7 = 1;
            } else {
                i7 = (i < this.apI || i2 < this.apJ) ? 2 : 0;
            }
            if (i > this.apI) {
                i8 = 1;
            } else {
                i8 = i < this.apI ? 2 : 0;
            }
            if (i2 > this.apJ) {
                i9 = 1;
            } else {
                i9 = i2 < this.apJ ? 2 : 0;
            }
            int i11 = i3 > this.apK ? 1 : 0;
            int i12 = i4 > this.apM ? 1 : 0;
            int i13 = i6 <= this.apN ? 0 : 1;
            this.apI = i;
            this.apJ = i2;
            this.apK = i3;
            this.apM = i4;
            this.apL = i5;
            this.apN = i6;
            if (yH() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yF();
                E(i10, 23);
                E(i11, 16);
                E(i7, 17);
                E(i8, 24);
                E(i9, 25);
                E(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.apI || i2 != this.apJ || i3 != this.apK || i4 != this.apM || this.apN != i5) {
            this.apI = i;
            this.apJ = i2;
            this.apK = i3;
            this.apM = i4;
            this.apN = i5;
            yF();
            if (yH() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean yo() {
        if (apS == null) {
            apS = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - apS.getTime() < 10000) {
                return false;
            }
            apS = date;
        }
        return true;
    }

    public static boolean yp() {
        if (c.yK().yV()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yK().yX().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yK().yY().split(":");
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

    private void E(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.apN > 0) {
                        String format = String.format(this.apH.getString(w.l.notify_gift), String.valueOf(this.apN));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.apI > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.apI > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.apI));
                            sb.append(this.apH.getString(w.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.apU != null) {
                            sb.append(this.apU);
                        } else {
                            sb.append(this.apH.getString(w.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.apJ > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.apJ > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.apJ));
                            sb2.append(this.apH.getString(w.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.apV != null) {
                            sb2.append(this.apV);
                        } else {
                            sb2.append(this.apH.getString(w.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.apM > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.apM > 1) {
                            sb3.append(String.format(this.apH.getString(w.l.notify_fans_unit), Integer.valueOf(this.apM)));
                        }
                        sb3.append(this.apH.getString(w.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yK().yZ()) {
                    c.yK().yN();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.apH, 16);
                NotificationHelper.cancelNotification(this.apH, 17);
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
        String zE;
        String zD;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.apN > 0) {
                            String format = String.format(this.apH.getString(w.l.notify_gift), String.valueOf(this.apN));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.apI > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.apI > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.apI));
                                sb.append(this.apH.getString(w.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.apU != null) {
                                sb.append(this.apU);
                            } else {
                                sb.append(this.apH.getString(w.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.apJ > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.apJ > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.apJ));
                                sb2.append(this.apH.getString(w.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.apV != null) {
                                sb2.append(this.apV);
                            } else {
                                sb2.append(this.apH.getString(w.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.apM > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.apM > 1) {
                                sb3.append(String.format(this.apH.getString(w.l.notify_fans_unit), Integer.valueOf(this.apM)));
                            }
                            sb3.append(this.apH.getString(w.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zu = (!c.yK().yZ() || c.yK().yN() <= 0) ? 0 : eVar.zu() - eVar.zB();
                        long zM = (!c.yK().yS() || c.yK().yN() <= 0) ? 0L : eVar.zM();
                        boolean z4 = zM > 0;
                        long j = zu + zM;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.apH.getString(w.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.zP();
                            eVar.zN();
                            if (zM == 1) {
                                zE = eVar.zP();
                                str = eVar.zN();
                                zD = String.valueOf(zE) + "：" + str;
                            } else if (zu == 1) {
                                zE = eVar.zE();
                                zD = eVar.zD();
                                str = zD;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.apH.getString(w.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zD)) {
                                zD = str;
                            }
                            c(16, zE, str, zD, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> zW = eVar.zW();
                        if (zW != null && zW.size() != 0) {
                            for (e.b bVar : zW) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.arm != 0 && bVar.unReadCount > bVar.arn) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> zX = eVar.zX();
                        if (zX != null && zX.size() != 0) {
                            for (e.a aVar : zX) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.arm != 0 && aVar.unReadCount > aVar.arn) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.yK().yZ() && c.yK().yN() > 0) {
                        if (eVar.zv() + eVar.zx() > 0) {
                            if (eVar.zv() > 0 && !yw()) {
                                long zv = eVar.zv() - eVar.zw();
                                if (zv > 0) {
                                    stringBuffer.append(String.format(this.apH.getString(w.l.notify_updates), Long.valueOf(zv)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zw() > 0) {
                                    z = true;
                                }
                                if (eVar.zx() > 0 || yv()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.apH.getString(w.l.notify_validate), Integer.valueOf(eVar.zx())));
                                } else {
                                    stringBuffer.append(String.format(this.apH.getString(w.l.notify_validate_1), Integer.valueOf(eVar.zx())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zG(), eVar.zH(), eVar.zH());
                                }
                            }
                            z = false;
                            if (eVar.zx() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.zQ() > 0 && !yx()) {
                            String format2 = String.format(this.apH.getString(w.l.notify_live), Integer.valueOf(eVar.zQ()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.apH, 16);
                    NotificationHelper.cancelNotification(this.apH, 17);
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
            PendingIntent service = PendingIntent.getService(this.apH, bVar.arm, a, 134217728);
            F(dG(i), i);
            NotificationHelper.showNotification(this.apH, i, bVar.title, bVar.content, bVar.aro, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apH, aVar.arm, a, 134217728);
            F(dG(i), i);
            NotificationHelper.showNotification(this.apH, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.apT) {
            if (i == 23 && this.apN > 0) {
                h = dC(i);
            } else if (i == 26 && this.apM > 0) {
                h = dD(i);
            } else if (i == 18) {
                h = yq();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.apH, i, h, 134217728);
            F(dG(i), i);
            NotificationHelper.showNotification(this.apH, i, str, str2, str3, service, false);
        }
    }

    public Intent dC(int i) {
        Intent intent = new Intent(this.apH, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.apN);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dD(int i) {
        Intent intent = new Intent(this.apH, DealIntentService.class);
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
        ImMessageCenterPojo Z = com.baidu.tieba.im.memorycache.b.aqX().Z(new StringBuilder(String.valueOf(bVar.arm)).toString(), bVar.userType);
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
                    Intent intent = new Intent(this.apH, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.arm);
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
        Intent intent = new Intent(this.apH, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.arm);
        intent.putExtra("uname", bVar.arp);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.apH, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.arm));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.apQ.zO().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.apH, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.apJ);
        intent.putExtra("reply_me", this.apI);
        intent.putExtra("fans", this.apM);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.apQ.zu() - this.apQ.zB());
        intent.putExtra("group_msg_validate", this.apQ.zx());
        intent.putExtra("group_msg_updates", this.apQ.zv());
        intent.putExtra("live_notify_msg_updates", this.apQ.zQ());
        intent.putExtra("officialbar_msg", this.apQ.zy());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yq() {
        Intent intent = new Intent(this.apH, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.apQ.zw());
        return intent;
    }

    public void yr() {
        NotificationHelper.cancelNotification(this.apH, 23);
        NotificationHelper.cancelNotification(this.apH, 24);
        NotificationHelper.cancelNotification(this.apH, 25);
        NotificationHelper.cancelNotification(this.apH, 26);
        NotificationHelper.cancelNotification(this.apH, 17);
        NotificationHelper.cancelNotification(this.apH, 15);
        NotificationHelper.cancelNotification(this.apH, 13);
        NotificationHelper.cancelNotification(this.apH, 12);
    }

    public void ys() {
        NotificationHelper.cancelNotification(this.apH, 16);
    }

    public void yt() {
        NotificationHelper.cancelNotification(this.apH, 19);
    }

    public void dE(int i) {
        NotificationHelper.cancelNotification(this.apH, i);
    }

    public int yu() {
        return this.apQ.zT();
    }

    public void ei(String str) {
        if (TextUtils.isEmpty(str)) {
            ys();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e yI = yI();
        if (yI == null) {
            ys();
            return;
        }
        HashMap<String, String> zI = yI.zI();
        if (zI == null || zI.isEmpty()) {
            ys();
        } else if (zI.containsKey(str)) {
            ys();
        }
    }

    public void ej(String str) {
        if (TextUtils.isEmpty(str)) {
            ys();
            return;
        }
        com.baidu.tbadk.coreExtra.c.e yI = yI();
        if (yI == null) {
            ys();
            return;
        }
        HashMap<String, String> zO = yI.zO();
        if (zO == null || zO.isEmpty()) {
            ys();
        } else if (zO.containsKey(str)) {
            ys();
        }
    }

    private boolean yv() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yw() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yx() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yy() {
        NotificationHelper.cancelNotification(this.apH, 17);
    }

    public void dF(int i) {
        com.baidu.tbadk.coreExtra.c.e yI = yI();
        if (yI == null) {
            yy();
        } else if (1 == i) {
            if (yI.zv() <= 0) {
                yy();
            }
        } else if (2 == i) {
            if (yI.zx() <= 0) {
                yy();
            }
        } else if (3 == i && yI.zQ() <= 0) {
            NotificationHelper.cancelNotification(this.apH, 21);
        }
    }

    public void yz() {
        NotificationHelper.cancelNotification(this.apH, 18);
    }

    public void yA() {
        NotificationHelper.cancelNotification(this.apH, 26);
        NotificationHelper.cancelNotification(this.apH, 25);
        NotificationHelper.cancelNotification(this.apH, 24);
        NotificationHelper.cancelNotification(this.apH, 23);
        NotificationHelper.cancelNotification(this.apH, 16);
        NotificationHelper.cancelNotification(this.apH, 17);
    }

    public void yB() {
        NotificationHelper.cancelNotification(this.apH, 21);
        NotificationHelper.cancelNotification(this.apH, 17);
        NotificationHelper.cancelNotification(this.apH, 19);
        NotificationHelper.cancelNotification(this.apH, 16);
        NotificationHelper.cancelNotification(this.apH, 18);
    }

    public void yC() {
        NotificationHelper.cancelNotification(this.apH, 24);
    }

    public void yD() {
        NotificationHelper.cancelNotification(this.apH, 25);
    }

    public void yE() {
        NotificationHelper.cancelNotification(this.apH, 23);
    }

    public void yF() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yG());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.apQ.zM());
        newsNotifyMessage.setMsgStrangerChat(this.apQ.zT());
        newsNotifyMessage.setMsgOfficialMerge(this.apQ.zS());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zM() + eVar.zu()) + eVar.zT()) + eVar.zS()) + eVar.zY()) - eVar.zB());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zM());
            newsNotifyMessage.setMsgStrangerChat(eVar.zT());
            newsNotifyMessage.setMsgOfficialMerge(eVar.zS());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.apI;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.apJ, this.apK, this.apM, this.apL, this.apN);
        }
    }

    public int getMsgAtme() {
        return this.apJ;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.apI, i, this.apK, this.apM, this.apL, this.apN);
        }
    }

    public int getMsgChat() {
        return this.apK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1095=5] */
    public int yG() {
        return ((((this.apQ.zM() + this.apQ.zu()) + this.apQ.zT()) + this.apQ.zS()) + this.apQ.zY()) - this.apQ.zB();
    }

    public int getMsgFans() {
        return this.apM;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.apI, this.apJ, this.apK, i, this.apL, this.apN);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.apI, this.apJ, i, this.apM, this.apL, this.apN);
        }
    }

    public int getMsgBookmark() {
        return this.apL;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.apI, this.apJ, this.apK, this.apM, i, this.apN);
        }
    }

    public int getMsgGiftNum() {
        return this.apN;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.apN = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.apO = i;
            yF();
        }
    }

    public int getMsgLiveVip() {
        return this.apO;
    }

    public void aR(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.apI = 0;
        this.apJ = 0;
        this.apK = 0;
        this.apM = 0;
        this.apL = 0;
    }

    public int yH() {
        return this.apI + this.apJ + this.apK + this.apM + this.apN;
    }

    public void b(com.baidu.tbadk.coreExtra.c.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.apQ = eVar;
            this.apK = (eVar.zu() - eVar.zB()) + eVar.zM() + eVar.zS() + eVar.zY();
            a(eVar);
            if (eVar.zC()) {
                this.apR = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zC()) {
                if (c.yK().yZ() && c.yK().yN() > 0) {
                    i = eVar.zu() - eVar.zB();
                }
                long zM = (!c.yK().yS() || c.yK().yN() <= 0) ? 0L : eVar.zM();
                if ((i > 0 || zM > 0) && ((i > eVar.zF() - eVar.zB() && i > 0) || zM > eVar.zz())) {
                    a(1, 16, eVar);
                }
                int zy = eVar.zy();
                if (zy > 0 && zy > eVar.zL()) {
                    a(1, 19, eVar);
                }
                if (eVar.zv() > eVar.zJ() || eVar.zx() > eVar.zK()) {
                    if (eVar.zv() <= eVar.zJ() || eVar.zx() != eVar.zK() || !yw()) {
                        if (eVar.zv() != eVar.zJ() || eVar.zx() <= eVar.zK() || !yv()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.zQ() > eVar.zR() && !yx()) {
                    a(1, 21, eVar);
                }
                if (eVar.zU() > eVar.zV()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.c.e yI() {
        return this.apQ;
    }

    public void c(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.apQ = eVar;
    }

    public com.baidu.tbadk.coreExtra.c.e yJ() {
        return this.apR;
    }

    public int dG(int i) {
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

    public void F(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.apH, 26, i2);
        }
    }
}
