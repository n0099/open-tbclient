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
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.r;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aks;
    private static Date akv = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e aku;
    private String akx;
    private String aky;
    private int akl = 0;
    private int akm = 0;
    private int akn = 0;
    private int ako = 0;
    private int akp = 0;
    private int akq = 0;
    private int akr = 0;
    private com.baidu.tbadk.coreExtra.d.e akt = new com.baidu.tbadk.coreExtra.d.e();
    private boolean akw = true;
    private final int[] akz = new int[10];
    private final Context akk = TbadkCoreApplication.m9getInst().getApp();

    public static a yt() {
        if (aks == null) {
            aks = new a();
        }
        return aks;
    }

    private a() {
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.akx = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.akx = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aky = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.akl || i2 != this.akm || i3 != this.akn || i4 != this.akp || i5 != this.ako || i6 != this.akq) {
            if (i > this.akl || i2 > this.akm || i3 > this.akn || i4 > this.akp || i5 > this.ako || i6 > this.akq) {
                i7 = 1;
            } else {
                i7 = (i < this.akl || i2 < this.akm) ? 2 : 0;
            }
            if (i > this.akl) {
                i8 = 1;
            } else {
                i8 = i < this.akl ? 2 : 0;
            }
            if (i2 > this.akm) {
                i9 = 1;
            } else {
                i9 = i2 < this.akm ? 2 : 0;
            }
            int i11 = i3 > this.akn ? 1 : 0;
            int i12 = i4 > this.akp ? 1 : 0;
            int i13 = i6 <= this.akq ? 0 : 1;
            this.akl = i;
            this.akm = i2;
            this.akn = i3;
            this.akp = i4;
            this.ako = i5;
            this.akq = i6;
            if (yN() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yL();
                z(i10, 23);
                z(i11, 16);
                z(i7, 17);
                z(i8, 24);
                z(i9, 25);
                z(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.akl || i2 != this.akm || i3 != this.akn || i4 != this.akp || this.akq != i5) {
            this.akl = i;
            this.akm = i2;
            this.akn = i3;
            this.akp = i4;
            this.akq = i5;
            yL();
            if (yN() <= 0) {
                z(2, 16);
                z(2, 17);
            }
        }
    }

    public static boolean yu() {
        if (akv == null) {
            akv = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - akv.getTime() < 10000) {
                return false;
            }
            akv = date;
        }
        return true;
    }

    public static boolean yv() {
        if (c.yQ().zb()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yQ().zd().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yQ().ze().split(":");
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

    private void z(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.akq > 0) {
                        String format = String.format(this.akk.getString(r.l.notify_gift), String.valueOf(this.akq));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.akl > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.akl > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.akl));
                            sb.append(this.akk.getString(r.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.akx != null) {
                            sb.append(this.akx);
                        } else {
                            sb.append(this.akk.getString(r.l.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.akm > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.akm > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.akm));
                            sb2.append(this.akk.getString(r.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aky != null) {
                            sb2.append(this.aky);
                        } else {
                            sb2.append(this.akk.getString(r.l.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.akp > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.akp > 1) {
                            sb3.append(String.format(this.akk.getString(r.l.notify_fans_unit), Integer.valueOf(this.akp)));
                        }
                        sb3.append(this.akk.getString(r.l.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yQ().zf()) {
                    c.yQ().yT();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.akk, 16);
                NotificationHelper.cancelNotification(this.akk, 17);
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
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.d.e eVar) {
        boolean z;
        String zK;
        String zJ;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.akq > 0) {
                            String format = String.format(this.akk.getString(r.l.notify_gift), String.valueOf(this.akq));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.akl > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.akl > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.akl));
                                sb.append(this.akk.getString(r.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.akx != null) {
                                sb.append(this.akx);
                            } else {
                                sb.append(this.akk.getString(r.l.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.akm > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.akm > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.akm));
                                sb2.append(this.akk.getString(r.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aky != null) {
                                sb2.append(this.aky);
                            } else {
                                sb2.append(this.akk.getString(r.l.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.akp > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.akp > 1) {
                                sb3.append(String.format(this.akk.getString(r.l.notify_fans_unit), Integer.valueOf(this.akp)));
                            }
                            sb3.append(this.akk.getString(r.l.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zA = (!c.yQ().zf() || c.yQ().yT() <= 0) ? 0 : eVar.zA() - eVar.zH();
                        long zS = (!c.yQ().yY() || c.yQ().yT() <= 0) ? 0L : eVar.zS();
                        boolean z4 = zS > 0;
                        long j = zA + zS;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.akk.getString(r.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.zV();
                            eVar.zT();
                            if (zS == 1) {
                                zK = eVar.zV();
                                str = eVar.zT();
                                zJ = String.valueOf(zK) + "：" + str;
                            } else if (zA == 1) {
                                zK = eVar.zK();
                                zJ = eVar.zJ();
                                str = zJ;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.akk.getString(r.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zJ)) {
                                zJ = str;
                            }
                            c(16, zK, str, zJ, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Ac = eVar.Ac();
                        if (Ac != null && Ac.size() != 0) {
                            for (e.b bVar : Ac) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.alQ != 0 && bVar.unReadCount > bVar.alR) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ad = eVar.Ad();
                        if (Ad != null && Ad.size() != 0) {
                            for (e.a aVar : Ad) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.alQ != 0 && aVar.unReadCount > aVar.alR) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.yQ().zf() && c.yQ().yT() > 0) {
                        if (eVar.zB() + eVar.zD() > 0) {
                            if (eVar.zB() > 0 && !yC()) {
                                long zB = eVar.zB() - eVar.zC();
                                if (zB > 0) {
                                    stringBuffer.append(String.format(this.akk.getString(r.l.notify_updates), Long.valueOf(zB)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zC() > 0) {
                                    z = true;
                                }
                                if (eVar.zD() > 0 || yB()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.akk.getString(r.l.notify_validate), Integer.valueOf(eVar.zD())));
                                } else {
                                    stringBuffer.append(String.format(this.akk.getString(r.l.notify_validate_1), Integer.valueOf(eVar.zD())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.zM(), eVar.zN(), eVar.zN());
                                }
                            }
                            z = false;
                            if (eVar.zD() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.zW() > 0 && !yD()) {
                            String format2 = String.format(this.akk.getString(r.l.notify_live), Integer.valueOf(eVar.zW()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.akk, 16);
                    NotificationHelper.cancelNotification(this.akk, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void b(int i, String str, String str2, String str3) {
        c(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akk, bVar.alQ, a, 134217728);
            A(dJ(i), i);
            NotificationHelper.showNotification(this.akk, i, bVar.title, bVar.content, bVar.alS, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akk, aVar.alQ, a, 134217728);
            A(dJ(i), i);
            NotificationHelper.showNotification(this.akk, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.akw) {
            if (i == 23 && this.akq > 0) {
                h = dF(i);
            } else if (i == 26 && this.akp > 0) {
                h = dG(i);
            } else if (i == 18) {
                h = yw();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akk, i, h, 134217728);
            A(dJ(i), i);
            NotificationHelper.showNotification(this.akk, i, str, str2, str3, service, false);
        }
    }

    public Intent dF(int i) {
        Intent intent = new Intent(this.akk, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.akq);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dG(int i) {
        Intent intent = new Intent(this.akk, DealIntentService.class);
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
        Intent intent = new Intent(this.akk, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.alQ);
        intent.putExtra("uname", bVar.alT);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.akk, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.alQ));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.akt.zU().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.akk, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.akm);
        intent.putExtra("reply_me", this.akl);
        intent.putExtra("fans", this.akp);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.akt.zA() - this.akt.zH());
        intent.putExtra("group_msg_validate", this.akt.zD());
        intent.putExtra("group_msg_updates", this.akt.zB());
        intent.putExtra("live_notify_msg_updates", this.akt.zW());
        intent.putExtra("officialbar_msg", this.akt.zE());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yw() {
        Intent intent = new Intent(this.akk, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.akt.zC());
        return intent;
    }

    public void yx() {
        NotificationHelper.cancelNotification(this.akk, 23);
        NotificationHelper.cancelNotification(this.akk, 24);
        NotificationHelper.cancelNotification(this.akk, 25);
        NotificationHelper.cancelNotification(this.akk, 26);
        NotificationHelper.cancelNotification(this.akk, 17);
        NotificationHelper.cancelNotification(this.akk, 15);
        NotificationHelper.cancelNotification(this.akk, 13);
        NotificationHelper.cancelNotification(this.akk, 12);
    }

    public void yy() {
        NotificationHelper.cancelNotification(this.akk, 16);
    }

    public void yz() {
        NotificationHelper.cancelNotification(this.akk, 19);
    }

    public void dH(int i) {
        NotificationHelper.cancelNotification(this.akk, i);
    }

    public int yA() {
        return this.akt.zZ();
    }

    public void eq(String str) {
        if (TextUtils.isEmpty(str)) {
            yy();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yO = yO();
        if (yO == null) {
            yy();
            return;
        }
        HashMap<String, String> zO = yO.zO();
        if (zO == null || zO.isEmpty()) {
            yy();
        } else if (zO.containsKey(str)) {
            yy();
        }
    }

    public void er(String str) {
        if (TextUtils.isEmpty(str)) {
            yy();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yO = yO();
        if (yO == null) {
            yy();
            return;
        }
        HashMap<String, String> zU = yO.zU();
        if (zU == null || zU.isEmpty()) {
            yy();
        } else if (zU.containsKey(str)) {
            yy();
        }
    }

    private boolean yB() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yC() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yD() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yE() {
        NotificationHelper.cancelNotification(this.akk, 17);
    }

    public void dI(int i) {
        com.baidu.tbadk.coreExtra.d.e yO = yO();
        if (yO == null) {
            yE();
        } else if (1 == i) {
            if (yO.zB() <= 0) {
                yE();
            }
        } else if (2 == i) {
            if (yO.zD() <= 0) {
                yE();
            }
        } else if (3 == i && yO.zW() <= 0) {
            NotificationHelper.cancelNotification(this.akk, 21);
        }
    }

    public void yF() {
        NotificationHelper.cancelNotification(this.akk, 18);
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.akk, 26);
        NotificationHelper.cancelNotification(this.akk, 25);
        NotificationHelper.cancelNotification(this.akk, 24);
        NotificationHelper.cancelNotification(this.akk, 23);
        NotificationHelper.cancelNotification(this.akk, 16);
        NotificationHelper.cancelNotification(this.akk, 17);
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.akk, 21);
        NotificationHelper.cancelNotification(this.akk, 17);
        NotificationHelper.cancelNotification(this.akk, 19);
        NotificationHelper.cancelNotification(this.akk, 16);
        NotificationHelper.cancelNotification(this.akk, 18);
    }

    public void yI() {
        NotificationHelper.cancelNotification(this.akk, 24);
    }

    public void yJ() {
        NotificationHelper.cancelNotification(this.akk, 25);
    }

    public void yK() {
        NotificationHelper.cancelNotification(this.akk, 23);
    }

    public void yL() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yM());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.akt.zS());
        newsNotifyMessage.setMsgStrangerChat(this.akt.zZ());
        newsNotifyMessage.setMsgOfficialMerge(this.akt.zY());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zS() + eVar.zA()) + eVar.zZ()) + eVar.zY()) + eVar.Ae()) - eVar.zH());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zS());
            newsNotifyMessage.setMsgStrangerChat(eVar.zZ());
            newsNotifyMessage.setMsgOfficialMerge(eVar.zY());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.akl;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.akm, this.akn, this.akp, this.ako, this.akq);
        }
    }

    public int getMsgAtme() {
        return this.akm;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.akl, i, this.akn, this.akp, this.ako, this.akq);
        }
    }

    public int getMsgChat() {
        return this.akn;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1035=5] */
    public int yM() {
        return ((((this.akt.zS() + this.akt.zA()) + this.akt.zZ()) + this.akt.zY()) + this.akt.Ae()) - this.akt.zH();
    }

    public int getMsgFans() {
        return this.akp;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.akl, this.akm, this.akn, i, this.ako, this.akq);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.akl, this.akm, i, this.akp, this.ako, this.akq);
        }
    }

    public int getMsgBookmark() {
        return this.ako;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.akl, this.akm, this.akn, this.akp, i, this.akq);
        }
    }

    public int getMsgGiftNum() {
        return this.akq;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.akq = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.akr = i;
            yL();
        }
    }

    public int getMsgLiveVip() {
        return this.akr;
    }

    public void aT(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.akl = 0;
        this.akm = 0;
        this.akn = 0;
        this.akp = 0;
        this.ako = 0;
    }

    public int yN() {
        return this.akl + this.akm + this.akn + this.akp + this.akq;
    }

    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.akt = eVar;
            this.akn = (eVar.zA() - eVar.zH()) + eVar.zS() + eVar.zY() + eVar.Ae();
            a(eVar);
            if (eVar.zI()) {
                this.aku = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zI()) {
                if (c.yQ().zf() && c.yQ().yT() > 0) {
                    i = eVar.zA() - eVar.zH();
                }
                long zS = (!c.yQ().yY() || c.yQ().yT() <= 0) ? 0L : eVar.zS();
                if ((i > 0 || zS > 0) && ((i > eVar.zL() - eVar.zH() && i > 0) || zS > eVar.zF())) {
                    a(1, 16, eVar);
                }
                int zE = eVar.zE();
                if (zE > 0 && zE > eVar.zR()) {
                    a(1, 19, eVar);
                }
                if (eVar.zB() > eVar.zP() || eVar.zD() > eVar.zQ()) {
                    if (eVar.zB() <= eVar.zP() || eVar.zD() != eVar.zQ() || !yC()) {
                        if (eVar.zB() != eVar.zP() || eVar.zD() <= eVar.zQ() || !yB()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.zW() > eVar.zX() && !yD()) {
                    a(1, 21, eVar);
                }
                if (eVar.Aa() > eVar.Ab()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e yO() {
        return this.akt;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.akt = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e yP() {
        return this.aku;
    }

    public int dJ(int i) {
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

    public void A(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akk, 26, i2);
        }
    }
}
