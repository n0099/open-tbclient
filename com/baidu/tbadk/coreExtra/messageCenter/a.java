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
    private static a alH;
    private static Date alK = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e alJ;
    private String alM;
    private String alN;
    private int alA = 0;
    private int alB = 0;
    private int alC = 0;
    private int alD = 0;
    private int alE = 0;
    private int alF = 0;
    private int alG = 0;
    private com.baidu.tbadk.coreExtra.d.e alI = new com.baidu.tbadk.coreExtra.d.e();
    private boolean alL = true;
    private final int[] alO = new int[10];
    private final Context alz = TbadkCoreApplication.m9getInst().getApp();

    public static a yK() {
        if (alH == null) {
            alH = new a();
        }
        return alH;
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
                    this.alM = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.alM = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.alN = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.alA || i2 != this.alB || i3 != this.alC || i4 != this.alE || i5 != this.alD || i6 != this.alF) {
            if (i > this.alA || i2 > this.alB || i3 > this.alC || i4 > this.alE || i5 > this.alD || i6 > this.alF) {
                i7 = 1;
            } else {
                i7 = (i < this.alA || i2 < this.alB) ? 2 : 0;
            }
            if (i > this.alA) {
                i8 = 1;
            } else {
                i8 = i < this.alA ? 2 : 0;
            }
            if (i2 > this.alB) {
                i9 = 1;
            } else {
                i9 = i2 < this.alB ? 2 : 0;
            }
            int i11 = i3 > this.alC ? 1 : 0;
            int i12 = i4 > this.alE ? 1 : 0;
            int i13 = i6 <= this.alF ? 0 : 1;
            this.alA = i;
            this.alB = i2;
            this.alC = i3;
            this.alE = i4;
            this.alD = i5;
            this.alF = i6;
            if (ze() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zc();
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
        if (i != this.alA || i2 != this.alB || i3 != this.alC || i4 != this.alE || this.alF != i5) {
            this.alA = i;
            this.alB = i2;
            this.alC = i3;
            this.alE = i4;
            this.alF = i5;
            zc();
            if (ze() <= 0) {
                y(2, 16);
                y(2, 17);
            }
        }
    }

    public static boolean yL() {
        if (alK == null) {
            alK = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - alK.getTime() < 10000) {
                return false;
            }
            alK = date;
        }
        return true;
    }

    public static boolean yM() {
        if (c.zh().zs()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.zh().zu().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.zh().zv().split(":");
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
                    if (this.alF > 0) {
                        String format = String.format(this.alz.getString(r.j.notify_gift), String.valueOf(this.alF));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.alA > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.alA > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.alA));
                            sb.append(this.alz.getString(r.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.alM != null) {
                            sb.append(this.alM);
                        } else {
                            sb.append(this.alz.getString(r.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.alB > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.alB > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.alB));
                            sb2.append(this.alz.getString(r.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.alN != null) {
                            sb2.append(this.alN);
                        } else {
                            sb2.append(this.alz.getString(r.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.alE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.alE > 1) {
                            sb3.append(String.format(this.alz.getString(r.j.notify_fans_unit), Integer.valueOf(this.alE)));
                        }
                        sb3.append(this.alz.getString(r.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.zh().zw()) {
                    c.zh().zk();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.alz, 16);
                NotificationHelper.cancelNotification(this.alz, 17);
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
        String Ac;
        String Ab;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.alF > 0) {
                            String format = String.format(this.alz.getString(r.j.notify_gift), String.valueOf(this.alF));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.alA > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.alA > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.alA));
                                sb.append(this.alz.getString(r.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.alM != null) {
                                sb.append(this.alM);
                            } else {
                                sb.append(this.alz.getString(r.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.alB > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.alB > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.alB));
                                sb2.append(this.alz.getString(r.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.alN != null) {
                                sb2.append(this.alN);
                            } else {
                                sb2.append(this.alz.getString(r.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.alE > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.alE > 1) {
                                sb3.append(String.format(this.alz.getString(r.j.notify_fans_unit), Integer.valueOf(this.alE)));
                            }
                            sb3.append(this.alz.getString(r.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zS = (!c.zh().zw() || c.zh().zk() <= 0) ? 0 : eVar.zS() - eVar.zZ();
                        long Ak = (!c.zh().zp() || c.zh().zk() <= 0) ? 0L : eVar.Ak();
                        boolean z4 = Ak > 0;
                        long j = zS + Ak;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.alz.getString(r.j.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.An();
                            eVar.Al();
                            if (Ak == 1) {
                                Ac = eVar.An();
                                str = eVar.Al();
                                Ab = String.valueOf(Ac) + "：" + str;
                            } else if (zS == 1) {
                                Ac = eVar.Ac();
                                Ab = eVar.Ab();
                                str = Ab;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.alz.getString(r.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ab)) {
                                Ab = str;
                            }
                            c(16, Ac, str, Ab, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Au = eVar.Au();
                        if (Au != null && Au.size() != 0) {
                            for (e.b bVar : Au) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.ani != 0 && bVar.unReadCount > bVar.anj) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Av = eVar.Av();
                        if (Av != null && Av.size() != 0) {
                            for (e.a aVar : Av) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.ani != 0 && aVar.unReadCount > aVar.anj) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.zh().zw() && c.zh().zk() > 0) {
                        if (eVar.zT() + eVar.zV() > 0) {
                            if (eVar.zT() > 0 && !yT()) {
                                long zT = eVar.zT() - eVar.zU();
                                if (zT > 0) {
                                    stringBuffer.append(String.format(this.alz.getString(r.j.notify_updates), Long.valueOf(zT)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zU() > 0) {
                                    z = true;
                                }
                                if (eVar.zV() > 0 || yS()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.alz.getString(r.j.notify_validate), Integer.valueOf(eVar.zV())));
                                } else {
                                    stringBuffer.append(String.format(this.alz.getString(r.j.notify_validate_1), Integer.valueOf(eVar.zV())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.Ae(), eVar.Af(), eVar.Af());
                                }
                            }
                            z = false;
                            if (eVar.zV() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ao() > 0 && !yU()) {
                            String format2 = String.format(this.alz.getString(r.j.notify_live), Integer.valueOf(eVar.Ao()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.alz, 16);
                    NotificationHelper.cancelNotification(this.alz, 17);
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
            PendingIntent service = PendingIntent.getService(this.alz, bVar.ani, a, 134217728);
            z(dG(i), i);
            NotificationHelper.showNotification(this.alz, i, bVar.title, bVar.content, bVar.ank, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.alz, aVar.ani, a, 134217728);
            z(dG(i), i);
            NotificationHelper.showNotification(this.alz, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.alL) {
            if (i == 23 && this.alF > 0) {
                h = dC(i);
            } else if (i == 26 && this.alE > 0) {
                h = dD(i);
            } else if (i == 18) {
                h = yN();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.alz, i, h, 134217728);
            z(dG(i), i);
            NotificationHelper.showNotification(this.alz, i, str, str2, str3, service, false);
        }
    }

    public Intent dC(int i) {
        Intent intent = new Intent(this.alz, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.alF);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dD(int i) {
        Intent intent = new Intent(this.alz, DealIntentService.class);
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
        Intent intent = new Intent(this.alz, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.ani);
        intent.putExtra("uname", bVar.anl);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.alz, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.ani));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.alI.Am().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.alz, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.alB);
        intent.putExtra("reply_me", this.alA);
        intent.putExtra("fans", this.alE);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.alI.zS() - this.alI.zZ());
        intent.putExtra("group_msg_validate", this.alI.zV());
        intent.putExtra("group_msg_updates", this.alI.zT());
        intent.putExtra("live_notify_msg_updates", this.alI.Ao());
        intent.putExtra("officialbar_msg", this.alI.zW());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yN() {
        Intent intent = new Intent(this.alz, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.alI.zU());
        return intent;
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.alz, 23);
        NotificationHelper.cancelNotification(this.alz, 24);
        NotificationHelper.cancelNotification(this.alz, 25);
        NotificationHelper.cancelNotification(this.alz, 26);
        NotificationHelper.cancelNotification(this.alz, 17);
        NotificationHelper.cancelNotification(this.alz, 15);
        NotificationHelper.cancelNotification(this.alz, 13);
        NotificationHelper.cancelNotification(this.alz, 12);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.alz, 16);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.alz, 19);
    }

    public void dE(int i) {
        NotificationHelper.cancelNotification(this.alz, i);
    }

    public int yR() {
        return this.alI.Ar();
    }

    public void ev(String str) {
        if (TextUtils.isEmpty(str)) {
            yP();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zf = zf();
        if (zf == null) {
            yP();
            return;
        }
        HashMap<String, String> Ag = zf.Ag();
        if (Ag == null || Ag.isEmpty()) {
            yP();
        } else if (Ag.containsKey(str)) {
            yP();
        }
    }

    public void ew(String str) {
        if (TextUtils.isEmpty(str)) {
            yP();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zf = zf();
        if (zf == null) {
            yP();
            return;
        }
        HashMap<String, String> Am = zf.Am();
        if (Am == null || Am.isEmpty()) {
            yP();
        } else if (Am.containsKey(str)) {
            yP();
        }
    }

    private boolean yS() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yT() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yU() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yV() {
        NotificationHelper.cancelNotification(this.alz, 17);
    }

    public void dF(int i) {
        com.baidu.tbadk.coreExtra.d.e zf = zf();
        if (zf == null) {
            yV();
        } else if (1 == i) {
            if (zf.zT() <= 0) {
                yV();
            }
        } else if (2 == i) {
            if (zf.zV() <= 0) {
                yV();
            }
        } else if (3 == i && zf.Ao() <= 0) {
            NotificationHelper.cancelNotification(this.alz, 21);
        }
    }

    public void yW() {
        NotificationHelper.cancelNotification(this.alz, 18);
    }

    public void yX() {
        NotificationHelper.cancelNotification(this.alz, 26);
        NotificationHelper.cancelNotification(this.alz, 25);
        NotificationHelper.cancelNotification(this.alz, 24);
        NotificationHelper.cancelNotification(this.alz, 23);
        NotificationHelper.cancelNotification(this.alz, 16);
        NotificationHelper.cancelNotification(this.alz, 17);
    }

    public void yY() {
        NotificationHelper.cancelNotification(this.alz, 21);
        NotificationHelper.cancelNotification(this.alz, 17);
        NotificationHelper.cancelNotification(this.alz, 19);
        NotificationHelper.cancelNotification(this.alz, 16);
        NotificationHelper.cancelNotification(this.alz, 18);
    }

    public void yZ() {
        NotificationHelper.cancelNotification(this.alz, 24);
    }

    public void za() {
        NotificationHelper.cancelNotification(this.alz, 25);
    }

    public void zb() {
        NotificationHelper.cancelNotification(this.alz, 23);
    }

    public void zc() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zd());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.alI.Ak());
        newsNotifyMessage.setMsgStrangerChat(this.alI.Ar());
        newsNotifyMessage.setMsgOfficialMerge(this.alI.Aq());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Ak() + eVar.zS()) + eVar.Ar()) + eVar.Aq()) + eVar.Aw()) - eVar.zZ());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Ak());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ar());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Aq());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.alA;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.alB, this.alC, this.alE, this.alD, this.alF);
        }
    }

    public int getMsgAtme() {
        return this.alB;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.alA, i, this.alC, this.alE, this.alD, this.alF);
        }
    }

    public int getMsgChat() {
        return this.alC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1035=5] */
    public int zd() {
        return ((((this.alI.Ak() + this.alI.zS()) + this.alI.Ar()) + this.alI.Aq()) + this.alI.Aw()) - this.alI.zZ();
    }

    public int getMsgFans() {
        return this.alE;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.alA, this.alB, this.alC, i, this.alD, this.alF);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.alA, this.alB, i, this.alE, this.alD, this.alF);
        }
    }

    public int getMsgBookmark() {
        return this.alD;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.alA, this.alB, this.alC, this.alE, i, this.alF);
        }
    }

    public int getMsgGiftNum() {
        return this.alF;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.alF = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.alG = i;
            zc();
        }
    }

    public int getMsgLiveVip() {
        return this.alG;
    }

    public void aS(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.alA = 0;
        this.alB = 0;
        this.alC = 0;
        this.alE = 0;
        this.alD = 0;
    }

    public int ze() {
        return this.alA + this.alB + this.alC + this.alE + this.alF;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int zW;
        int i = 0;
        if (eVar != null) {
            this.alI = eVar;
            this.alC = (eVar.zS() - eVar.zZ()) + eVar.Ak() + eVar.Aq() + eVar.Aw();
            a(eVar);
            if (eVar.Aa()) {
                this.alJ = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Aa()) {
                if (c.zh().zw() && c.zh().zk() > 0) {
                    i = eVar.zS() - eVar.zZ();
                }
                if (c.zh().zp() && c.zh().zk() > 0) {
                    boolean zy = c.zh().zy();
                    boolean isProcessBackground = TbadkCoreApplication.m9getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m9getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m9getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.Ak();
                    } else if (isFloatingWindowOpened) {
                        if (!zy || isProcessBackground) {
                            j = eVar.Ak();
                        }
                    } else {
                        j = eVar.Ak();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.Ad() - eVar.zZ() && i > 0) || j > eVar.zX())) {
                        a(1, 16, eVar);
                    }
                    zW = eVar.zW();
                    if (zW > 0 && zW > eVar.Aj()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.zT() <= eVar.Ah() || eVar.zV() > eVar.Ai()) {
                        if (eVar.zT() > eVar.Ah() || eVar.zV() != eVar.Ai() || !yT()) {
                            if (eVar.zT() == eVar.Ah() || eVar.zV() <= eVar.Ai() || !yS()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.Ao() > eVar.Ap() && !yU()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.As() <= eVar.At()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                zW = eVar.zW();
                if (zW > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.zT() <= eVar.Ah()) {
                }
                if (eVar.zT() > eVar.Ah()) {
                }
                if (eVar.zT() == eVar.Ah()) {
                }
                a(1, 17, eVar);
                if (eVar.Ao() > eVar.Ap()) {
                    a(1, 21, eVar);
                }
                if (eVar.As() <= eVar.At()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e zf() {
        return this.alI;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.alI = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e zg() {
        return this.alJ;
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

    public void z(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.alz, 26, i2);
        }
    }
}
