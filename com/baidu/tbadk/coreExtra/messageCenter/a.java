package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.t;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a alg;
    private static Date alj = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e ali;
    private String alm;
    private String aln;
    private int akZ = 0;
    private int ala = 0;
    private int alb = 0;
    private int alc = 0;
    private int ald = 0;
    private int ale = 0;
    private int alf = 0;
    private com.baidu.tbadk.coreExtra.d.e alh = new com.baidu.tbadk.coreExtra.d.e();
    private boolean alk = true;
    private final int[] alo = new int[10];
    private final Context akY = TbadkCoreApplication.m9getInst().getApp();

    public static a yA() {
        if (alg == null) {
            alg = new a();
        }
        return alg;
    }

    private a() {
    }

    public void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.alm = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.alm = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aln = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.akZ || i2 != this.ala || i3 != this.alb || i4 != this.ald || i5 != this.alc || i6 != this.ale) {
            if (i > this.akZ || i2 > this.ala || i3 > this.alb || i4 > this.ald || i5 > this.alc || i6 > this.ale) {
                i7 = 1;
            } else {
                i7 = (i < this.akZ || i2 < this.ala) ? 2 : 0;
            }
            if (i > this.akZ) {
                i8 = 1;
            } else {
                i8 = i < this.akZ ? 2 : 0;
            }
            if (i2 > this.ala) {
                i9 = 1;
            } else {
                i9 = i2 < this.ala ? 2 : 0;
            }
            int i11 = i3 > this.alb ? 1 : 0;
            int i12 = i4 > this.ald ? 1 : 0;
            int i13 = i6 <= this.ale ? 0 : 1;
            this.akZ = i;
            this.ala = i2;
            this.alb = i3;
            this.ald = i4;
            this.alc = i5;
            this.ale = i6;
            if (yU() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yS();
                y(i10, 23);
                y(i11, 16);
                y(i7, 17);
                y(i8, 24);
                y(i9, 25);
                y(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.akZ || i2 != this.ala || i3 != this.alb || i4 != this.ald || this.ale != i5) {
            this.akZ = i;
            this.ala = i2;
            this.alb = i3;
            this.ald = i4;
            this.ale = i5;
            yS();
            if (yU() <= 0) {
                y(2, 16);
                y(2, 17);
            }
        }
    }

    public static boolean yB() {
        if (alj == null) {
            alj = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - alj.getTime() < 10000) {
                return false;
            }
            alj = date;
        }
        return true;
    }

    public static boolean yC() {
        if (c.yX().zi()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yX().zk().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yX().zl().split(":");
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

    private void y(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.ale > 0) {
                        String format = String.format(this.akY.getString(t.j.notify_gift), String.valueOf(this.ale));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.akZ > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.akZ > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.akZ));
                            sb.append(this.akY.getString(t.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.alm != null) {
                            sb.append(this.alm);
                        } else {
                            sb.append(this.akY.getString(t.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ala > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ala > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ala));
                            sb2.append(this.akY.getString(t.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aln != null) {
                            sb2.append(this.aln);
                        } else {
                            sb2.append(this.akY.getString(t.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ald > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ald > 1) {
                            sb3.append(String.format(this.akY.getString(t.j.notify_fans_unit), Integer.valueOf(this.ald)));
                        }
                        sb3.append(this.akY.getString(t.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yX().zm()) {
                    c.yX().za();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.akY, 16);
                NotificationHelper.cancelNotification(this.akY, 17);
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
        String zS;
        String zR;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ale > 0) {
                            String format = String.format(this.akY.getString(t.j.notify_gift), String.valueOf(this.ale));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.akZ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.akZ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.akZ));
                                sb.append(this.akY.getString(t.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.alm != null) {
                                sb.append(this.alm);
                            } else {
                                sb.append(this.akY.getString(t.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ala > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ala > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ala));
                                sb2.append(this.akY.getString(t.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aln != null) {
                                sb2.append(this.aln);
                            } else {
                                sb2.append(this.akY.getString(t.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ald > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ald > 1) {
                                sb3.append(String.format(this.akY.getString(t.j.notify_fans_unit), Integer.valueOf(this.ald)));
                            }
                            sb3.append(this.akY.getString(t.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zI = (!c.yX().zm() || c.yX().za() <= 0) ? 0 : eVar.zI() - eVar.zP();
                        long Aa = (!c.yX().zf() || c.yX().za() <= 0) ? 0L : eVar.Aa();
                        boolean z4 = Aa > 0;
                        long j = zI + Aa;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.akY.getString(t.j.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ad();
                            eVar.Ab();
                            if (Aa == 1) {
                                zS = eVar.Ad();
                                str = eVar.Ab();
                                zR = String.valueOf(zS) + "：" + str;
                            } else if (zI == 1) {
                                zS = eVar.zS();
                                zR = eVar.zR();
                                str = zR;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.akY.getString(t.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zR)) {
                                zR = str;
                            }
                            c(16, zS, str, zR, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Ak = eVar.Ak();
                        if (Ak != null && Ak.size() != 0) {
                            for (e.b bVar : Ak) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.amH != 0 && bVar.unReadCount > bVar.amI) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Al = eVar.Al();
                        if (Al != null && Al.size() != 0) {
                            for (e.a aVar : Al) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.amH != 0 && aVar.unReadCount > aVar.amI) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.yX().zm() && c.yX().za() > 0) {
                        if (eVar.zJ() + eVar.zL() > 0) {
                            if (eVar.zJ() > 0 && !yJ()) {
                                long zJ = eVar.zJ() - eVar.zK();
                                if (zJ > 0) {
                                    stringBuffer.append(String.format(this.akY.getString(t.j.notify_updates), Long.valueOf(zJ)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zK() > 0) {
                                    z = true;
                                }
                                if (eVar.zL() > 0 || yI()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.akY.getString(t.j.notify_validate), Integer.valueOf(eVar.zL())));
                                } else {
                                    stringBuffer.append(String.format(this.akY.getString(t.j.notify_validate_1), Integer.valueOf(eVar.zL())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.zU(), eVar.zV(), eVar.zV());
                                }
                            }
                            z = false;
                            if (eVar.zL() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ae() > 0 && !yK()) {
                            String format2 = String.format(this.akY.getString(t.j.notify_live), Integer.valueOf(eVar.Ae()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.akY, 16);
                    NotificationHelper.cancelNotification(this.akY, 17);
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
            PendingIntent service = PendingIntent.getService(this.akY, bVar.amH, a, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akY, i, bVar.title, bVar.content, bVar.amJ, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akY, aVar.amH, a, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akY, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.alk) {
            if (i == 23 && this.ale > 0) {
                h = dA(i);
            } else if (i == 26 && this.ald > 0) {
                h = dB(i);
            } else if (i == 18) {
                h = yD();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akY, i, h, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akY, i, str, str2, str3, service, false);
        }
    }

    public Intent dA(int i) {
        Intent intent = new Intent(this.akY, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ale);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dB(int i) {
        Intent intent = new Intent(this.akY, DealIntentService.class);
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
        Intent intent = new Intent(this.akY, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.amH);
        intent.putExtra("uname", bVar.amK);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.akY, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.amH));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.alh.Ac().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.akY, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.ala);
        intent.putExtra("reply_me", this.akZ);
        intent.putExtra("fans", this.ald);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.alh.zI() - this.alh.zP());
        intent.putExtra("group_msg_validate", this.alh.zL());
        intent.putExtra("group_msg_updates", this.alh.zJ());
        intent.putExtra("live_notify_msg_updates", this.alh.Ae());
        intent.putExtra("officialbar_msg", this.alh.zM());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yD() {
        Intent intent = new Intent(this.akY, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.alh.zK());
        return intent;
    }

    public void yE() {
        NotificationHelper.cancelNotification(this.akY, 23);
        NotificationHelper.cancelNotification(this.akY, 24);
        NotificationHelper.cancelNotification(this.akY, 25);
        NotificationHelper.cancelNotification(this.akY, 26);
        NotificationHelper.cancelNotification(this.akY, 17);
        NotificationHelper.cancelNotification(this.akY, 15);
        NotificationHelper.cancelNotification(this.akY, 13);
        NotificationHelper.cancelNotification(this.akY, 12);
    }

    public void yF() {
        NotificationHelper.cancelNotification(this.akY, 16);
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.akY, 19);
    }

    public void dC(int i) {
        NotificationHelper.cancelNotification(this.akY, i);
    }

    public int yH() {
        return this.alh.Ah();
    }

    public void eq(String str) {
        if (TextUtils.isEmpty(str)) {
            yF();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yV = yV();
        if (yV == null) {
            yF();
            return;
        }
        HashMap<String, String> zW = yV.zW();
        if (zW == null || zW.isEmpty()) {
            yF();
        } else if (zW.containsKey(str)) {
            yF();
        }
    }

    public void er(String str) {
        if (TextUtils.isEmpty(str)) {
            yF();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yV = yV();
        if (yV == null) {
            yF();
            return;
        }
        HashMap<String, String> Ac = yV.Ac();
        if (Ac == null || Ac.isEmpty()) {
            yF();
        } else if (Ac.containsKey(str)) {
            yF();
        }
    }

    private boolean yI() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yJ() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yK() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yL() {
        NotificationHelper.cancelNotification(this.akY, 17);
    }

    public void dD(int i) {
        com.baidu.tbadk.coreExtra.d.e yV = yV();
        if (yV == null) {
            yL();
        } else if (1 == i) {
            if (yV.zJ() <= 0) {
                yL();
            }
        } else if (2 == i) {
            if (yV.zL() <= 0) {
                yL();
            }
        } else if (3 == i && yV.Ae() <= 0) {
            NotificationHelper.cancelNotification(this.akY, 21);
        }
    }

    public void yM() {
        NotificationHelper.cancelNotification(this.akY, 18);
    }

    public void yN() {
        NotificationHelper.cancelNotification(this.akY, 26);
        NotificationHelper.cancelNotification(this.akY, 25);
        NotificationHelper.cancelNotification(this.akY, 24);
        NotificationHelper.cancelNotification(this.akY, 23);
        NotificationHelper.cancelNotification(this.akY, 16);
        NotificationHelper.cancelNotification(this.akY, 17);
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.akY, 21);
        NotificationHelper.cancelNotification(this.akY, 17);
        NotificationHelper.cancelNotification(this.akY, 19);
        NotificationHelper.cancelNotification(this.akY, 16);
        NotificationHelper.cancelNotification(this.akY, 18);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.akY, 24);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.akY, 25);
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.akY, 23);
    }

    public void yS() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yT());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.alh.Aa());
        newsNotifyMessage.setMsgStrangerChat(this.alh.Ah());
        newsNotifyMessage.setMsgOfficialMerge(this.alh.Ag());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Aa() + eVar.zI()) + eVar.Ah()) + eVar.Ag()) + eVar.Am()) - eVar.zP());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Aa());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ah());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ag());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.akZ;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.ala, this.alb, this.ald, this.alc, this.ale);
        }
    }

    public int getMsgAtme() {
        return this.ala;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.akZ, i, this.alb, this.ald, this.alc, this.ale);
        }
    }

    public int getMsgChat() {
        return this.alb;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1035=5] */
    public int yT() {
        return ((((this.alh.Aa() + this.alh.zI()) + this.alh.Ah()) + this.alh.Ag()) + this.alh.Am()) - this.alh.zP();
    }

    public int getMsgFans() {
        return this.ald;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.akZ, this.ala, this.alb, i, this.alc, this.ale);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.akZ, this.ala, i, this.ald, this.alc, this.ale);
        }
    }

    public int getMsgBookmark() {
        return this.alc;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.akZ, this.ala, this.alb, this.ald, i, this.ale);
        }
    }

    public int getMsgGiftNum() {
        return this.ale;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ale = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.alf = i;
            yS();
        }
    }

    public int getMsgLiveVip() {
        return this.alf;
    }

    public void aP(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.akZ = 0;
        this.ala = 0;
        this.alb = 0;
        this.ald = 0;
        this.alc = 0;
    }

    public int yU() {
        return this.akZ + this.ala + this.alb + this.ald + this.ale;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int zM;
        int i = 0;
        if (eVar != null) {
            this.alh = eVar;
            this.alb = (eVar.zI() - eVar.zP()) + eVar.Aa() + eVar.Ag() + eVar.Am();
            a(eVar);
            if (eVar.zQ()) {
                this.ali = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zQ()) {
                if (c.yX().zm() && c.yX().za() > 0) {
                    i = eVar.zI() - eVar.zP();
                }
                if (c.yX().zf() && c.yX().za() > 0) {
                    boolean zo = c.yX().zo();
                    boolean isProcessBackground = TbadkCoreApplication.m9getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m9getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m9getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.Aa();
                    } else if (isFloatingWindowOpened) {
                        if (!zo || isProcessBackground) {
                            j = eVar.Aa();
                        }
                    } else {
                        j = eVar.Aa();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.zT() - eVar.zP() && i > 0) || j > eVar.zN())) {
                        a(1, 16, eVar);
                    }
                    zM = eVar.zM();
                    if (zM > 0 && zM > eVar.zZ()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.zJ() <= eVar.zX() || eVar.zL() > eVar.zY()) {
                        if (eVar.zJ() > eVar.zX() || eVar.zL() != eVar.zY() || !yJ()) {
                            if (eVar.zJ() == eVar.zX() || eVar.zL() <= eVar.zY() || !yI()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.Ae() > eVar.Af() && !yK()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.Ai() <= eVar.Aj()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                zM = eVar.zM();
                if (zM > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.zJ() <= eVar.zX()) {
                }
                if (eVar.zJ() > eVar.zX()) {
                }
                if (eVar.zJ() == eVar.zX()) {
                }
                a(1, 17, eVar);
                if (eVar.Ae() > eVar.Af()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ai() <= eVar.Aj()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e yV() {
        return this.alh;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.alh = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e yW() {
        return this.ali;
    }

    public int dE(int i) {
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

    public void z(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akY, 26, i2);
        }
    }
}
