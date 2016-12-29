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
    private static a ali;
    private static Date alm = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e alk;
    private String alo;
    private String alp;
    private int alb = 0;
    private int alc = 0;
    private int ald = 0;
    private int ale = 0;
    private int alf = 0;
    private int alg = 0;
    private int alh = 0;
    private com.baidu.tbadk.coreExtra.d.e alj = new com.baidu.tbadk.coreExtra.d.e();
    private boolean aln = true;
    private final int[] alq = new int[10];
    private final Context ala = TbadkCoreApplication.m9getInst().getApp();

    public static a yy() {
        if (ali == null) {
            ali = new a();
        }
        return ali;
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
                    this.alo = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.alo = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.alp = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.alb || i2 != this.alc || i3 != this.ald || i4 != this.alf || i5 != this.ale || i6 != this.alg) {
            if (i > this.alb || i2 > this.alc || i3 > this.ald || i4 > this.alf || i5 > this.ale || i6 > this.alg) {
                i7 = 1;
            } else {
                i7 = (i < this.alb || i2 < this.alc) ? 2 : 0;
            }
            if (i > this.alb) {
                i8 = 1;
            } else {
                i8 = i < this.alb ? 2 : 0;
            }
            if (i2 > this.alc) {
                i9 = 1;
            } else {
                i9 = i2 < this.alc ? 2 : 0;
            }
            int i11 = i3 > this.ald ? 1 : 0;
            int i12 = i4 > this.alf ? 1 : 0;
            int i13 = i6 <= this.alg ? 0 : 1;
            this.alb = i;
            this.alc = i2;
            this.ald = i3;
            this.alf = i4;
            this.ale = i5;
            this.alg = i6;
            if (yS() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yQ();
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
        if (i != this.alb || i2 != this.alc || i3 != this.ald || i4 != this.alf || this.alg != i5) {
            this.alb = i;
            this.alc = i2;
            this.ald = i3;
            this.alf = i4;
            this.alg = i5;
            yQ();
            if (yS() <= 0) {
                y(2, 16);
                y(2, 17);
            }
        }
    }

    public static boolean yz() {
        if (alm == null) {
            alm = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - alm.getTime() < 10000) {
                return false;
            }
            alm = date;
        }
        return true;
    }

    public static boolean yA() {
        if (c.yV().zg()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yV().zi().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yV().zj().split(":");
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
                    if (this.alg > 0) {
                        String format = String.format(this.ala.getString(r.j.notify_gift), String.valueOf(this.alg));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.alb > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.alb > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.alb));
                            sb.append(this.ala.getString(r.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.alo != null) {
                            sb.append(this.alo);
                        } else {
                            sb.append(this.ala.getString(r.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.alc > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.alc > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.alc));
                            sb2.append(this.ala.getString(r.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.alp != null) {
                            sb2.append(this.alp);
                        } else {
                            sb2.append(this.ala.getString(r.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.alf > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.alf > 1) {
                            sb3.append(String.format(this.ala.getString(r.j.notify_fans_unit), Integer.valueOf(this.alf)));
                        }
                        sb3.append(this.ala.getString(r.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yV().zk()) {
                    c.yV().yY();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ala, 16);
                NotificationHelper.cancelNotification(this.ala, 17);
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
        String zP;
        String zO;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.alg > 0) {
                            String format = String.format(this.ala.getString(r.j.notify_gift), String.valueOf(this.alg));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.alb > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.alb > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.alb));
                                sb.append(this.ala.getString(r.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.alo != null) {
                                sb.append(this.alo);
                            } else {
                                sb.append(this.ala.getString(r.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.alc > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.alc > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.alc));
                                sb2.append(this.ala.getString(r.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.alp != null) {
                                sb2.append(this.alp);
                            } else {
                                sb2.append(this.ala.getString(r.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.alf > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.alf > 1) {
                                sb3.append(String.format(this.ala.getString(r.j.notify_fans_unit), Integer.valueOf(this.alf)));
                            }
                            sb3.append(this.ala.getString(r.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zF = (!c.yV().zk() || c.yV().yY() <= 0) ? 0 : eVar.zF() - eVar.zM();
                        long zX = (!c.yV().zd() || c.yV().yY() <= 0) ? 0L : eVar.zX();
                        boolean z4 = zX > 0;
                        long j = zF + zX;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ala.getString(r.j.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Aa();
                            eVar.zY();
                            if (zX == 1) {
                                zP = eVar.Aa();
                                str = eVar.zY();
                                zO = String.valueOf(zP) + "：" + str;
                            } else if (zF == 1) {
                                zP = eVar.zP();
                                zO = eVar.zO();
                                str = zO;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ala.getString(r.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zO)) {
                                zO = str;
                            }
                            c(16, zP, str, zO, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Ah = eVar.Ah();
                        if (Ah != null && Ah.size() != 0) {
                            for (e.b bVar : Ah) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.amK != 0 && bVar.unReadCount > bVar.amL) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ai = eVar.Ai();
                        if (Ai != null && Ai.size() != 0) {
                            for (e.a aVar : Ai) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.amK != 0 && aVar.unReadCount > aVar.amL) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.yV().zk() && c.yV().yY() > 0) {
                        if (eVar.zG() + eVar.zI() > 0) {
                            if (eVar.zG() > 0 && !yH()) {
                                long zG = eVar.zG() - eVar.zH();
                                if (zG > 0) {
                                    stringBuffer.append(String.format(this.ala.getString(r.j.notify_updates), Long.valueOf(zG)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zH() > 0) {
                                    z = true;
                                }
                                if (eVar.zI() > 0 || yG()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ala.getString(r.j.notify_validate), Integer.valueOf(eVar.zI())));
                                } else {
                                    stringBuffer.append(String.format(this.ala.getString(r.j.notify_validate_1), Integer.valueOf(eVar.zI())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.zR(), eVar.zS(), eVar.zS());
                                }
                            }
                            z = false;
                            if (eVar.zI() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ab() > 0 && !yI()) {
                            String format2 = String.format(this.ala.getString(r.j.notify_live), Integer.valueOf(eVar.Ab()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ala, 16);
                    NotificationHelper.cancelNotification(this.ala, 17);
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
            PendingIntent service = PendingIntent.getService(this.ala, bVar.amK, a, 134217728);
            z(dI(i), i);
            NotificationHelper.showNotification(this.ala, i, bVar.title, bVar.content, bVar.amM, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ala, aVar.amK, a, 134217728);
            z(dI(i), i);
            NotificationHelper.showNotification(this.ala, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aln) {
            if (i == 23 && this.alg > 0) {
                h = dE(i);
            } else if (i == 26 && this.alf > 0) {
                h = dF(i);
            } else if (i == 18) {
                h = yB();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ala, i, h, 134217728);
            z(dI(i), i);
            NotificationHelper.showNotification(this.ala, i, str, str2, str3, service, false);
        }
    }

    public Intent dE(int i) {
        Intent intent = new Intent(this.ala, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.alg);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dF(int i) {
        Intent intent = new Intent(this.ala, DealIntentService.class);
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
        Intent intent = new Intent(this.ala, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.amK);
        intent.putExtra("uname", bVar.amN);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ala, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.amK));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.alj.zZ().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ala, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.alc);
        intent.putExtra("reply_me", this.alb);
        intent.putExtra("fans", this.alf);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.alj.zF() - this.alj.zM());
        intent.putExtra("group_msg_validate", this.alj.zI());
        intent.putExtra("group_msg_updates", this.alj.zG());
        intent.putExtra("live_notify_msg_updates", this.alj.Ab());
        intent.putExtra("officialbar_msg", this.alj.zJ());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yB() {
        Intent intent = new Intent(this.ala, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.alj.zH());
        return intent;
    }

    public void yC() {
        NotificationHelper.cancelNotification(this.ala, 23);
        NotificationHelper.cancelNotification(this.ala, 24);
        NotificationHelper.cancelNotification(this.ala, 25);
        NotificationHelper.cancelNotification(this.ala, 26);
        NotificationHelper.cancelNotification(this.ala, 17);
        NotificationHelper.cancelNotification(this.ala, 15);
        NotificationHelper.cancelNotification(this.ala, 13);
        NotificationHelper.cancelNotification(this.ala, 12);
    }

    public void yD() {
        NotificationHelper.cancelNotification(this.ala, 16);
    }

    public void yE() {
        NotificationHelper.cancelNotification(this.ala, 19);
    }

    public void dG(int i) {
        NotificationHelper.cancelNotification(this.ala, i);
    }

    public int yF() {
        return this.alj.Ae();
    }

    public void es(String str) {
        if (TextUtils.isEmpty(str)) {
            yD();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yT = yT();
        if (yT == null) {
            yD();
            return;
        }
        HashMap<String, String> zT = yT.zT();
        if (zT == null || zT.isEmpty()) {
            yD();
        } else if (zT.containsKey(str)) {
            yD();
        }
    }

    public void et(String str) {
        if (TextUtils.isEmpty(str)) {
            yD();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yT = yT();
        if (yT == null) {
            yD();
            return;
        }
        HashMap<String, String> zZ = yT.zZ();
        if (zZ == null || zZ.isEmpty()) {
            yD();
        } else if (zZ.containsKey(str)) {
            yD();
        }
    }

    private boolean yG() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yH() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yI() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yJ() {
        NotificationHelper.cancelNotification(this.ala, 17);
    }

    public void dH(int i) {
        com.baidu.tbadk.coreExtra.d.e yT = yT();
        if (yT == null) {
            yJ();
        } else if (1 == i) {
            if (yT.zG() <= 0) {
                yJ();
            }
        } else if (2 == i) {
            if (yT.zI() <= 0) {
                yJ();
            }
        } else if (3 == i && yT.Ab() <= 0) {
            NotificationHelper.cancelNotification(this.ala, 21);
        }
    }

    public void yK() {
        NotificationHelper.cancelNotification(this.ala, 18);
    }

    public void yL() {
        NotificationHelper.cancelNotification(this.ala, 26);
        NotificationHelper.cancelNotification(this.ala, 25);
        NotificationHelper.cancelNotification(this.ala, 24);
        NotificationHelper.cancelNotification(this.ala, 23);
        NotificationHelper.cancelNotification(this.ala, 16);
        NotificationHelper.cancelNotification(this.ala, 17);
    }

    public void yM() {
        NotificationHelper.cancelNotification(this.ala, 21);
        NotificationHelper.cancelNotification(this.ala, 17);
        NotificationHelper.cancelNotification(this.ala, 19);
        NotificationHelper.cancelNotification(this.ala, 16);
        NotificationHelper.cancelNotification(this.ala, 18);
    }

    public void yN() {
        NotificationHelper.cancelNotification(this.ala, 24);
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.ala, 25);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.ala, 23);
    }

    public void yQ() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yR());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.alj.zX());
        newsNotifyMessage.setMsgStrangerChat(this.alj.Ae());
        newsNotifyMessage.setMsgOfficialMerge(this.alj.Ad());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zX() + eVar.zF()) + eVar.Ae()) + eVar.Ad()) + eVar.Aj()) - eVar.zM());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zX());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ae());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ad());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.alb;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.alc, this.ald, this.alf, this.ale, this.alg);
        }
    }

    public int getMsgAtme() {
        return this.alc;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.alb, i, this.ald, this.alf, this.ale, this.alg);
        }
    }

    public int getMsgChat() {
        return this.ald;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1035=5] */
    public int yR() {
        return ((((this.alj.zX() + this.alj.zF()) + this.alj.Ae()) + this.alj.Ad()) + this.alj.Aj()) - this.alj.zM();
    }

    public int getMsgFans() {
        return this.alf;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.alb, this.alc, this.ald, i, this.ale, this.alg);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.alb, this.alc, i, this.alf, this.ale, this.alg);
        }
    }

    public int getMsgBookmark() {
        return this.ale;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.alb, this.alc, this.ald, this.alf, i, this.alg);
        }
    }

    public int getMsgGiftNum() {
        return this.alg;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.alg = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.alh = i;
            yQ();
        }
    }

    public int getMsgLiveVip() {
        return this.alh;
    }

    public void aT(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.alb = 0;
        this.alc = 0;
        this.ald = 0;
        this.alf = 0;
        this.ale = 0;
    }

    public int yS() {
        return this.alb + this.alc + this.ald + this.alf + this.alg;
    }

    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.alj = eVar;
            this.ald = (eVar.zF() - eVar.zM()) + eVar.zX() + eVar.Ad() + eVar.Aj();
            a(eVar);
            if (eVar.zN()) {
                this.alk = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zN()) {
                if (c.yV().zk() && c.yV().yY() > 0) {
                    i = eVar.zF() - eVar.zM();
                }
                long zX = (!c.yV().zd() || c.yV().yY() <= 0) ? 0L : eVar.zX();
                if ((i > 0 || zX > 0) && ((i > eVar.zQ() - eVar.zM() && i > 0) || zX > eVar.zK())) {
                    a(1, 16, eVar);
                }
                int zJ = eVar.zJ();
                if (zJ > 0 && zJ > eVar.zW()) {
                    a(1, 19, eVar);
                }
                if (eVar.zG() > eVar.zU() || eVar.zI() > eVar.zV()) {
                    if (eVar.zG() <= eVar.zU() || eVar.zI() != eVar.zV() || !yH()) {
                        if (eVar.zG() != eVar.zU() || eVar.zI() <= eVar.zV() || !yG()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Ab() > eVar.Ac() && !yI()) {
                    a(1, 21, eVar);
                }
                if (eVar.Af() > eVar.Ag()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e yT() {
        return this.alj;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.alj = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e yU() {
        return this.alk;
    }

    public int dI(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ala, 26, i2);
        }
    }
}
