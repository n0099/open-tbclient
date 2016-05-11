package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
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
    private static a agJ;
    private static Date agM = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e agL;
    private String agO;
    private String agP;
    private int agC = 0;
    private int agD = 0;
    private int agE = 0;
    private int agF = 0;
    private int agG = 0;
    private int agH = 0;
    private int agI = 0;
    private com.baidu.tbadk.coreExtra.d.e agK = new com.baidu.tbadk.coreExtra.d.e();
    private boolean agN = true;
    private final int[] agQ = new int[10];
    private final Context agB = TbadkCoreApplication.m11getInst().getApp();

    public static a xi() {
        if (agJ == null) {
            agJ = new a();
        }
        return agJ;
    }

    private a() {
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.agO = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.agO = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.agP = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.agC || i2 != this.agD || i3 != this.agE || i4 != this.agG || i5 != this.agF || i6 != this.agH) {
            if (i > this.agC || i2 > this.agD || i3 > this.agE || i4 > this.agG || i5 > this.agF || i6 > this.agH) {
                i7 = 1;
            } else {
                i7 = (i < this.agC || i2 < this.agD) ? 2 : 0;
            }
            if (i > this.agC) {
                i8 = 1;
            } else {
                i8 = i < this.agC ? 2 : 0;
            }
            if (i2 > this.agD) {
                i9 = 1;
            } else {
                i9 = i2 < this.agD ? 2 : 0;
            }
            int i11 = i3 > this.agE ? 1 : 0;
            int i12 = i4 > this.agG ? 1 : 0;
            int i13 = i6 <= this.agH ? 0 : 1;
            this.agC = i;
            this.agD = i2;
            this.agE = i3;
            this.agG = i4;
            this.agF = i5;
            this.agH = i6;
            if (xC() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xA();
                w(i10, 23);
                w(i11, 16);
                w(i7, 17);
                w(i8, 24);
                w(i9, 25);
                w(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.agC || i2 != this.agD || i3 != this.agE || i4 != this.agG || this.agH != i5) {
            this.agC = i;
            this.agD = i2;
            this.agE = i3;
            this.agG = i4;
            this.agH = i5;
            xA();
            if (xC() <= 0) {
                w(2, 16);
                w(2, 17);
            }
        }
    }

    public static boolean xj() {
        if (agM == null) {
            agM = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - agM.getTime() < 10000) {
                return false;
            }
            agM = date;
        }
        return true;
    }

    public static boolean xk() {
        if (c.xF().xQ()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xF().xS().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xF().xT().split(":");
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

    private void w(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.agH > 0) {
                        String format = String.format(this.agB.getString(t.j.notify_gift), String.valueOf(this.agH));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.agC > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.agC > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.agC));
                            sb.append(this.agB.getString(t.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.agO != null) {
                            sb.append(this.agO);
                        } else {
                            sb.append(this.agB.getString(t.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.agD > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.agD > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.agD));
                            sb2.append(this.agB.getString(t.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.agP != null) {
                            sb2.append(this.agP);
                        } else {
                            sb2.append(this.agB.getString(t.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.agG > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.agG > 1) {
                            sb3.append(String.format(this.agB.getString(t.j.notify_fans_unit), Integer.valueOf(this.agG)));
                        }
                        sb3.append(this.agB.getString(t.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xF().xU()) {
                    c.xF().xI();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.agB, 16);
                NotificationHelper.cancelNotification(this.agB, 17);
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
        String yz;
        String yy;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.agH > 0) {
                            String format = String.format(this.agB.getString(t.j.notify_gift), String.valueOf(this.agH));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.agC > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.agC > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.agC));
                                sb.append(this.agB.getString(t.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.agO != null) {
                                sb.append(this.agO);
                            } else {
                                sb.append(this.agB.getString(t.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.agD > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.agD > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.agD));
                                sb2.append(this.agB.getString(t.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.agP != null) {
                                sb2.append(this.agP);
                            } else {
                                sb2.append(this.agB.getString(t.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.agG > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.agG > 1) {
                                sb3.append(String.format(this.agB.getString(t.j.notify_fans_unit), Integer.valueOf(this.agG)));
                            }
                            sb3.append(this.agB.getString(t.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int yp = (!c.xF().xU() || c.xF().xI() <= 0) ? 0 : eVar.yp() - eVar.yw();
                        long yH = (!c.xF().xN() || c.xF().xI() <= 0) ? 0L : eVar.yH();
                        boolean z4 = yH > 0;
                        long j = yp + yH;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.agB.getString(t.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.yK();
                            eVar.yI();
                            if (yH == 1) {
                                yz = eVar.yK();
                                str = eVar.yI();
                                yy = String.valueOf(yz) + "：" + str;
                            } else if (yp == 1) {
                                yz = eVar.yz();
                                yy = eVar.yy();
                                str = yy;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.agB.getString(t.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yy)) {
                                yy = str;
                            }
                            a(16, yz, str, yy, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> yR = eVar.yR();
                        if (yR != null && yR.size() != 0) {
                            for (e.b bVar : yR) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.aih != 0 && bVar.unReadCount > bVar.aii) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> yS = eVar.yS();
                        if (yS != null && yS.size() != 0) {
                            for (e.a aVar : yS) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.aih != 0 && aVar.unReadCount > aVar.aii) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.xF().xU() && c.xF().xI() > 0) {
                        if (eVar.yq() + eVar.ys() > 0) {
                            if (eVar.yq() > 0 && !xr()) {
                                long yq = eVar.yq() - eVar.yr();
                                if (yq > 0) {
                                    stringBuffer.append(String.format(this.agB.getString(t.j.notify_updates), Long.valueOf(yq)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.yr() > 0) {
                                    z = true;
                                }
                                if (eVar.ys() > 0 || xq()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.agB.getString(t.j.notify_validate), Integer.valueOf(eVar.ys())));
                                } else {
                                    stringBuffer.append(String.format(this.agB.getString(t.j.notify_validate_1), Integer.valueOf(eVar.ys())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.yB(), eVar.yC(), eVar.yC());
                                }
                            }
                            z = false;
                            if (eVar.ys() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yL() > 0 && !xs()) {
                            String format2 = String.format(this.agB.getString(t.j.notify_live), Integer.valueOf(eVar.yL()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.agB, 16);
                    NotificationHelper.cancelNotification(this.agB, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void b(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.agB, bVar.aih, a, 134217728);
            x(dp(i), i);
            NotificationHelper.showNotification(this.agB, i, bVar.title, bVar.content, bVar.aij, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.agB, aVar.aih, a, 134217728);
            x(dp(i), i);
            NotificationHelper.showNotification(this.agB, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.agN) {
            if (i == 23 && this.agH > 0) {
                g = dl(i);
            } else if (i == 26 && this.agG > 0) {
                g = dm(i);
            } else if (i == 18) {
                g = xl();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.agB, i, g, 134217728);
            x(dp(i), i);
            NotificationHelper.showNotification(this.agB, i, str, str2, str3, service, false);
        }
    }

    public Intent dl(int i) {
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.agH);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dm(int i) {
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 10);
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
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.aih);
        intent.putExtra("uname", bVar.aik);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.aih));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.agK.yJ().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.agD);
        intent.putExtra("reply_me", this.agC);
        intent.putExtra("fans", this.agG);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.agK.yp() - this.agK.yw());
        intent.putExtra("group_msg_validate", this.agK.ys());
        intent.putExtra("group_msg_updates", this.agK.yq());
        intent.putExtra("live_notify_msg_updates", this.agK.yL());
        intent.putExtra("officialbar_msg", this.agK.yt());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent xl() {
        Intent intent = new Intent(this.agB, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.agK.yr());
        return intent;
    }

    public void xm() {
        NotificationHelper.cancelNotification(this.agB, 23);
        NotificationHelper.cancelNotification(this.agB, 24);
        NotificationHelper.cancelNotification(this.agB, 25);
        NotificationHelper.cancelNotification(this.agB, 26);
        NotificationHelper.cancelNotification(this.agB, 17);
        NotificationHelper.cancelNotification(this.agB, 15);
        NotificationHelper.cancelNotification(this.agB, 13);
        NotificationHelper.cancelNotification(this.agB, 12);
    }

    public void xn() {
        NotificationHelper.cancelNotification(this.agB, 16);
    }

    public void xo() {
        NotificationHelper.cancelNotification(this.agB, 19);
    }

    public void dn(int i) {
        NotificationHelper.cancelNotification(this.agB, i);
    }

    public int xp() {
        return this.agK.yO();
    }

    public void ek(String str) {
        if (TextUtils.isEmpty(str)) {
            xn();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xD = xD();
        if (xD == null) {
            xn();
            return;
        }
        HashMap<String, String> yD = xD.yD();
        if (yD == null || yD.isEmpty()) {
            xn();
        } else if (yD.containsKey(str)) {
            xn();
        }
    }

    public void el(String str) {
        if (TextUtils.isEmpty(str)) {
            xn();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xD = xD();
        if (xD == null) {
            xn();
            return;
        }
        HashMap<String, String> yJ = xD.yJ();
        if (yJ == null || yJ.isEmpty()) {
            xn();
        } else if (yJ.containsKey(str)) {
            xn();
        }
    }

    private boolean xq() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xr() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xs() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xt() {
        NotificationHelper.cancelNotification(this.agB, 17);
    }

    /* renamed from: do  reason: not valid java name */
    public void m16do(int i) {
        com.baidu.tbadk.coreExtra.d.e xD = xD();
        if (xD == null) {
            xt();
        } else if (1 == i) {
            if (xD.yq() <= 0) {
                xt();
            }
        } else if (2 == i) {
            if (xD.ys() <= 0) {
                xt();
            }
        } else if (3 == i && xD.yL() <= 0) {
            NotificationHelper.cancelNotification(this.agB, 21);
        }
    }

    public void xu() {
        NotificationHelper.cancelNotification(this.agB, 18);
    }

    public void xv() {
        NotificationHelper.cancelNotification(this.agB, 26);
        NotificationHelper.cancelNotification(this.agB, 25);
        NotificationHelper.cancelNotification(this.agB, 24);
        NotificationHelper.cancelNotification(this.agB, 23);
        NotificationHelper.cancelNotification(this.agB, 16);
        NotificationHelper.cancelNotification(this.agB, 17);
    }

    public void xw() {
        NotificationHelper.cancelNotification(this.agB, 21);
        NotificationHelper.cancelNotification(this.agB, 17);
        NotificationHelper.cancelNotification(this.agB, 19);
        NotificationHelper.cancelNotification(this.agB, 16);
        NotificationHelper.cancelNotification(this.agB, 18);
    }

    public void xx() {
        NotificationHelper.cancelNotification(this.agB, 24);
    }

    public void xy() {
        NotificationHelper.cancelNotification(this.agB, 25);
    }

    public void xz() {
        NotificationHelper.cancelNotification(this.agB, 23);
    }

    public void xA() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xB());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.agK.yH());
        newsNotifyMessage.setMsgStrangerChat(this.agK.yO());
        newsNotifyMessage.setMsgOfficialMerge(this.agK.yN());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yH() + eVar.yp()) + eVar.yO()) + eVar.yN()) + eVar.yT()) - eVar.yw());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yH());
            newsNotifyMessage.setMsgStrangerChat(eVar.yO());
            newsNotifyMessage.setMsgOfficialMerge(eVar.yN());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.agC;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.agD, this.agE, this.agG, this.agF, this.agH);
        }
    }

    public int getMsgAtme() {
        return this.agD;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.agC, i, this.agE, this.agG, this.agF, this.agH);
        }
    }

    public int getMsgChat() {
        return this.agE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1022=5] */
    public int xB() {
        return ((((this.agK.yH() + this.agK.yp()) + this.agK.yO()) + this.agK.yN()) + this.agK.yT()) - this.agK.yw();
    }

    public int getMsgFans() {
        return this.agG;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.agC, this.agD, this.agE, i, this.agF, this.agH);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.agC, this.agD, i, this.agG, this.agF, this.agH);
        }
    }

    public int getMsgBookmark() {
        return this.agF;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.agC, this.agD, this.agE, this.agG, i, this.agH);
        }
    }

    public int getMsgGiftNum() {
        return this.agH;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.agH = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.agI = i;
            xA();
        }
    }

    public int getMsgLiveVip() {
        return this.agI;
    }

    public void aM(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.agC = 0;
        this.agD = 0;
        this.agE = 0;
        this.agG = 0;
        this.agF = 0;
    }

    public int xC() {
        return this.agC + this.agD + this.agE + this.agG + this.agH;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int yt;
        int i = 0;
        if (eVar != null) {
            this.agK = eVar;
            this.agE = (eVar.yp() - eVar.yw()) + eVar.yH() + eVar.yN() + eVar.yT();
            a(eVar);
            if (eVar.yx()) {
                this.agL = null;
                mHandler.removeMessages(0);
            }
            if (eVar.yx()) {
                if (c.xF().xU() && c.xF().xI() > 0) {
                    i = eVar.yp() - eVar.yw();
                }
                if (c.xF().xN() && c.xF().xI() > 0) {
                    boolean xW = c.xF().xW();
                    boolean isProcessBackground = TbadkCoreApplication.m11getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m11getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m11getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yH();
                    } else if (isFloatingWindowOpened) {
                        if (!xW || isProcessBackground) {
                            j = eVar.yH();
                        }
                    } else {
                        j = eVar.yH();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.yA() - eVar.yw() && i > 0) || j > eVar.yu())) {
                        a(1, 16, eVar);
                    }
                    yt = eVar.yt();
                    if (yt > 0 && yt > eVar.yG()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.yq() <= eVar.yE() || eVar.ys() > eVar.yF()) {
                        if (eVar.yq() > eVar.yE() || eVar.ys() != eVar.yF() || !xr()) {
                            if (eVar.yq() == eVar.yE() || eVar.ys() <= eVar.yF() || !xq()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yL() > eVar.yM() && !xs()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.yP() <= eVar.yQ()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                yt = eVar.yt();
                if (yt > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.yq() <= eVar.yE()) {
                }
                if (eVar.yq() > eVar.yE()) {
                }
                if (eVar.yq() == eVar.yE()) {
                }
                a(1, 17, eVar);
                if (eVar.yL() > eVar.yM()) {
                    a(1, 21, eVar);
                }
                if (eVar.yP() <= eVar.yQ()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xD() {
        return this.agK;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.agK = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xE() {
        return this.agL;
    }

    public int dp(int i) {
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
            case TbConfig.NOTIFY_FANS_NEW_ID /* 26 */:
                return 3;
            default:
                return 0;
        }
    }

    public void x(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.agB, 26, i2);
        }
    }
}
