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
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.i;
import com.baidu.tieba.mention.FeedData;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ahK;
    private static Date ahN = null;
    private static Handler mHandler = new b();
    private f ahM;
    private String ahP;
    private String ahQ;
    private int ahD = 0;
    private int ahE = 0;
    private int ahF = 0;
    private int ahG = 0;
    private int ahH = 0;
    private int ahI = 0;
    private int ahJ = 0;
    private f ahL = new f();
    private boolean ahO = true;
    private final int[] ahR = new int[10];
    private final Context ahC = TbadkCoreApplication.m411getInst().getApp();

    public static a wT() {
        if (ahK == null) {
            ahK = new a();
        }
        return ahK;
    }

    private a() {
    }

    public void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
            if (!StringUtils.isNull(optString)) {
                this.ahP = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.ahP = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.ahQ = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.ahD || i2 != this.ahE || i3 != this.ahF || i4 != this.ahH || i5 != this.ahG || i6 != this.ahI) {
            if (i > this.ahD || i2 > this.ahE || i3 > this.ahF || i4 > this.ahH || i5 > this.ahG || i6 > this.ahI) {
                i7 = 1;
            } else {
                i7 = (i < this.ahD || i2 < this.ahE) ? 2 : 0;
            }
            if (i > this.ahD) {
                i8 = 1;
            } else {
                i8 = i < this.ahD ? 2 : 0;
            }
            if (i2 > this.ahE) {
                i9 = 1;
            } else {
                i9 = i2 < this.ahE ? 2 : 0;
            }
            int i11 = i3 > this.ahF ? 1 : 0;
            int i12 = i4 > this.ahH ? 1 : 0;
            int i13 = i6 <= this.ahI ? 0 : 1;
            this.ahD = i;
            this.ahE = i2;
            this.ahF = i3;
            this.ahH = i4;
            this.ahG = i5;
            this.ahI = i6;
            if (xn() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xl();
                D(i10, 23);
                D(i11, 16);
                D(i7, 17);
                D(i8, 24);
                D(i9, 25);
                D(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.ahD || i2 != this.ahE || i3 != this.ahF || i4 != this.ahH || this.ahI != i5) {
            this.ahD = i;
            this.ahE = i2;
            this.ahF = i3;
            this.ahH = i4;
            this.ahI = i5;
            xl();
            if (xn() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean wU() {
        if (ahN == null) {
            ahN = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - ahN.getTime() < 10000) {
                return false;
            }
            ahN = date;
        }
        return true;
    }

    public static boolean wV() {
        if (c.xq().xB()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xq().xD().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xq().xE().split(":");
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
                    if (this.ahI > 0) {
                        String format = String.format(this.ahC.getString(i.C0057i.notify_gift), String.valueOf(this.ahI));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.ahD > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.ahD > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.ahD));
                            sb.append(this.ahC.getString(i.C0057i.notify_unit));
                            sb.append("]");
                        }
                        if (this.ahP != null) {
                            sb.append(this.ahP);
                        } else {
                            sb.append(this.ahC.getString(i.C0057i.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ahE > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ahE > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ahE));
                            sb2.append(this.ahC.getString(i.C0057i.notify_unit));
                            sb2.append("]");
                        }
                        if (this.ahQ != null) {
                            sb2.append(this.ahQ);
                        } else {
                            sb2.append(this.ahC.getString(i.C0057i.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ahH > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ahH > 1) {
                            sb3.append(String.format(this.ahC.getString(i.C0057i.notify_fans_unit), Integer.valueOf(this.ahH)));
                        }
                        sb3.append(this.ahC.getString(i.C0057i.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xq().xF()) {
                    c.xq().xt();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ahC, 16);
                NotificationHelper.cancelNotification(this.ahC, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0301 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:97:0x024c, B:99:0x0252, B:101:0x0258, B:102:0x025c, B:104:0x0262, B:106:0x026a, B:108:0x0272, B:110:0x0276, B:112:0x027c, B:113:0x0280, B:115:0x028a, B:117:0x0294, B:119:0x029f, B:121:0x02a5, B:123:0x02ab, B:125:0x02b9, B:126:0x02d4, B:128:0x02da, B:131:0x02e2, B:133:0x0301, B:135:0x0311, B:144:0x0359, B:141:0x0350, B:136:0x0322, B:138:0x0328, B:140:0x032e, B:147:0x037a), top: B:154:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0311 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:97:0x024c, B:99:0x0252, B:101:0x0258, B:102:0x025c, B:104:0x0262, B:106:0x026a, B:108:0x0272, B:110:0x0276, B:112:0x027c, B:113:0x0280, B:115:0x028a, B:117:0x0294, B:119:0x029f, B:121:0x02a5, B:123:0x02ab, B:125:0x02b9, B:126:0x02d4, B:128:0x02da, B:131:0x02e2, B:133:0x0301, B:135:0x0311, B:144:0x0359, B:141:0x0350, B:136:0x0322, B:138:0x0328, B:140:0x032e, B:147:0x037a), top: B:154:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, f fVar) {
        boolean z;
        String yk;
        String yj;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (fVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ahI > 0) {
                            String format = String.format(this.ahC.getString(i.C0057i.notify_gift), String.valueOf(this.ahI));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.ahD > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.ahD > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.ahD));
                                sb.append(this.ahC.getString(i.C0057i.notify_unit));
                                sb.append("]");
                            }
                            if (this.ahP != null) {
                                sb.append(this.ahP);
                            } else {
                                sb.append(this.ahC.getString(i.C0057i.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ahE > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ahE > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ahE));
                                sb2.append(this.ahC.getString(i.C0057i.notify_unit));
                                sb2.append("]");
                            }
                            if (this.ahQ != null) {
                                sb2.append(this.ahQ);
                            } else {
                                sb2.append(this.ahC.getString(i.C0057i.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ahH > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ahH > 1) {
                                sb3.append(String.format(this.ahC.getString(i.C0057i.notify_fans_unit), Integer.valueOf(this.ahH)));
                            }
                            sb3.append(this.ahC.getString(i.C0057i.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int ya = (!c.xq().xF() || c.xq().xt() <= 0) ? 0 : fVar.ya() - fVar.yh();
                        long ys = (!c.xq().xy() || c.xq().xt() <= 0) ? 0L : fVar.ys();
                        boolean z4 = ys > 0;
                        long j = ya + ys;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ahC.getString(i.C0057i.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            fVar.yv();
                            fVar.yt();
                            if (ys == 1) {
                                yk = fVar.yv();
                                str = fVar.yt();
                                yj = String.valueOf(yk) + "：" + str;
                            } else if (ya == 1) {
                                yk = fVar.yk();
                                yj = fVar.yj();
                                str = yj;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ahC.getString(i.C0057i.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yj)) {
                                yj = str;
                            }
                            a(16, yk, str, yj, z4);
                        }
                    } else if (i2 == 19) {
                        List<f.b> yC = fVar.yC();
                        if (yC != null && yC.size() != 0) {
                            for (f.b bVar : yC) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.aji) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<f.a> yD = fVar.yD();
                        if (yD != null && yD.size() != 0) {
                            for (f.a aVar : yD) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.aji) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.xq().xF() && c.xq().xt() > 0) {
                        if (fVar.yb() + fVar.yd() > 0) {
                            if (fVar.yb() > 0 && !xc()) {
                                long yb = fVar.yb() - fVar.yc();
                                if (yb > 0) {
                                    stringBuffer.append(String.format(this.ahC.getString(i.C0057i.notify_updates), Long.valueOf(yb)));
                                    z = false;
                                    z2 = true;
                                } else if (fVar.yc() > 0) {
                                    z = true;
                                }
                                if (fVar.yd() > 0 || xb()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ahC.getString(i.C0057i.notify_validate), Integer.valueOf(fVar.yd())));
                                } else {
                                    stringBuffer.append(String.format(this.ahC.getString(i.C0057i.notify_validate_1), Integer.valueOf(fVar.yd())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, fVar.ym(), fVar.yn(), fVar.yn());
                                }
                            }
                            z = false;
                            if (fVar.yd() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (fVar.yw() > 0 && !xd()) {
                            String format2 = String.format(this.ahC.getString(i.C0057i.notify_live), Integer.valueOf(fVar.yw()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ahC, 16);
                    NotificationHelper.cancelNotification(this.ahC, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(f.b bVar) {
        Intent b = b(bVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.ahC, bVar.gid, bVar.title, bVar.content, bVar.ajj, PendingIntent.getService(this.ahC, bVar.gid, b, 134217728), false);
        }
    }

    private void a(f.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.ahC, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.ahC, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.ahO) {
            if (i == 23 && this.ahI > 0) {
                e = cP(i);
            } else if (i == 26 && this.ahH > 0) {
                e = cQ(i);
            } else if (i == 18) {
                e = wW();
            } else {
                e = e(i, z);
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.ahC, i, str, str2, str3, PendingIntent.getService(this.ahC, i, e, 134217728), false);
        }
    }

    public Intent cP(int i) {
        Intent intent = new Intent(this.ahC, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ahI);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cQ(int i) {
        Intent intent = new Intent(this.ahC, DealIntentService.class);
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

    public Intent b(f.b bVar) {
        if (bVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ahC, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.ajk);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ahC, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.ahL.yu().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ahC, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.ahE);
        intent.putExtra("reply_me", this.ahD);
        intent.putExtra("fans", this.ahH);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.ahL.ya() - this.ahL.yh());
        intent.putExtra("group_msg_validate", this.ahL.yd());
        intent.putExtra("group_msg_updates", this.ahL.yb());
        intent.putExtra("live_notify_msg_updates", this.ahL.yw());
        intent.putExtra("officialbar_msg", this.ahL.ye());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent wW() {
        Intent intent = new Intent(this.ahC, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.ahL.yc());
        return intent;
    }

    public void wX() {
        NotificationHelper.cancelNotification(this.ahC, 23);
        NotificationHelper.cancelNotification(this.ahC, 24);
        NotificationHelper.cancelNotification(this.ahC, 25);
        NotificationHelper.cancelNotification(this.ahC, 26);
        NotificationHelper.cancelNotification(this.ahC, 17);
        NotificationHelper.cancelNotification(this.ahC, 15);
        NotificationHelper.cancelNotification(this.ahC, 13);
        NotificationHelper.cancelNotification(this.ahC, 12);
    }

    public void wY() {
        NotificationHelper.cancelNotification(this.ahC, 16);
    }

    public void wZ() {
        NotificationHelper.cancelNotification(this.ahC, 19);
    }

    public void cR(int i) {
        NotificationHelper.cancelNotification(this.ahC, i);
    }

    public int xa() {
        return this.ahL.ys();
    }

    public void dM(String str) {
        if (TextUtils.isEmpty(str)) {
            wY();
            return;
        }
        f xo = xo();
        if (xo == null) {
            wY();
            return;
        }
        HashMap<String, String> yo = xo.yo();
        if (yo == null || yo.isEmpty()) {
            wY();
        } else if (yo.containsKey(str)) {
            wY();
        }
    }

    public void dN(String str) {
        if (TextUtils.isEmpty(str)) {
            wY();
            return;
        }
        f xo = xo();
        if (xo == null) {
            wY();
            return;
        }
        HashMap<String, String> yu = xo.yu();
        if (yu == null || yu.isEmpty()) {
            wY();
        } else if (yu.containsKey(str)) {
            wY();
        }
    }

    private boolean xb() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xc() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xd() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xe() {
        NotificationHelper.cancelNotification(this.ahC, 17);
    }

    public void cS(int i) {
        f xo = xo();
        if (xo == null) {
            xe();
        } else if (1 == i) {
            if (xo.yb() <= 0) {
                xe();
            }
        } else if (2 == i) {
            if (xo.yd() <= 0) {
                xe();
            }
        } else if (3 == i && xo.yw() <= 0) {
            NotificationHelper.cancelNotification(this.ahC, 21);
        }
    }

    public void xf() {
        NotificationHelper.cancelNotification(this.ahC, 18);
    }

    public void xg() {
        NotificationHelper.cancelNotification(this.ahC, 26);
        NotificationHelper.cancelNotification(this.ahC, 25);
        NotificationHelper.cancelNotification(this.ahC, 24);
        NotificationHelper.cancelNotification(this.ahC, 23);
        NotificationHelper.cancelNotification(this.ahC, 16);
        NotificationHelper.cancelNotification(this.ahC, 17);
    }

    public void xh() {
        NotificationHelper.cancelNotification(this.ahC, 21);
        NotificationHelper.cancelNotification(this.ahC, 17);
        NotificationHelper.cancelNotification(this.ahC, 19);
        NotificationHelper.cancelNotification(this.ahC, 16);
        NotificationHelper.cancelNotification(this.ahC, 18);
    }

    public void cT(int i) {
        NotificationHelper.cancelNotification(this.ahC, i);
    }

    public void xi() {
        NotificationHelper.cancelNotification(this.ahC, 24);
    }

    public void xj() {
        NotificationHelper.cancelNotification(this.ahC, 25);
    }

    public void xk() {
        NotificationHelper.cancelNotification(this.ahC, 23);
    }

    public void xl() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xm());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.ahL.ys());
        newsNotifyMessage.setMsgStrangerChat(this.ahL.yz());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(f fVar) {
        if (fVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((fVar.ys() + fVar.ya()) + fVar.yz()) + fVar.yy()) + fVar.yE()) - fVar.yh());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(fVar.ys());
            newsNotifyMessage.setMsgStrangerChat(fVar.yz());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.ahD;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.ahE, this.ahF, this.ahH, this.ahG, this.ahI);
        }
    }

    public int getMsgAtme() {
        return this.ahE;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.ahD, i, this.ahF, this.ahH, this.ahG, this.ahI);
        }
    }

    public int getMsgChat() {
        return this.ahF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1000=5] */
    public int xm() {
        return ((((this.ahL.ys() + this.ahL.ya()) + this.ahL.yz()) + this.ahL.yy()) + this.ahL.yE()) - this.ahL.yh();
    }

    public int getMsgFans() {
        return this.ahH;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.ahD, this.ahE, this.ahF, i, this.ahG, this.ahI);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.ahD, this.ahE, i, this.ahH, this.ahG, this.ahI);
        }
    }

    public int getMsgBookmark() {
        return this.ahG;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.ahD, this.ahE, this.ahF, this.ahH, i, this.ahI);
        }
    }

    public int getMsgGiftNum() {
        return this.ahI;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ahI = i;
        }
    }

    public void cU(int i) {
        if (i >= 0) {
            this.ahJ += i;
            xl();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.ahJ = i;
            xl();
        }
    }

    public int getMsgLiveVip() {
        return this.ahJ;
    }

    public void az(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.ahD = 0;
        this.ahE = 0;
        this.ahF = 0;
        this.ahH = 0;
        this.ahG = 0;
    }

    public int xn() {
        return this.ahD + this.ahE + this.ahF + this.ahH + this.ahI;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(f fVar) {
        long j;
        int ye;
        int i = 0;
        if (fVar != null) {
            this.ahL = fVar;
            this.ahF = (fVar.ya() - fVar.yh()) + fVar.ys() + fVar.yy() + fVar.yE();
            a(fVar);
            if (fVar.yi()) {
                this.ahM = null;
                mHandler.removeMessages(0);
            }
            if (fVar.yi()) {
                if (c.xq().xF() && c.xq().xt() > 0) {
                    i = fVar.ya() - fVar.yh();
                }
                if (c.xq().xy() && c.xq().xt() > 0) {
                    boolean xH = c.xq().xH();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = fVar.ys();
                    } else if (isFloatingWindowOpened) {
                        if (!xH || isProcessBackground) {
                            j = fVar.ys();
                        }
                    } else {
                        j = fVar.ys();
                    }
                    if ((i <= 0 || j > 0) && ((i > fVar.yl() - fVar.yh() && i > 0) || j > fVar.yf())) {
                        a(1, 16, fVar);
                    }
                    ye = fVar.ye();
                    if (ye > 0 && ye > fVar.yr()) {
                        a(1, 19, fVar);
                    }
                    if (fVar.yb() <= fVar.yp() || fVar.yd() > fVar.yq()) {
                        if (fVar.yb() > fVar.yp() || fVar.yd() != fVar.yq() || !xc()) {
                            if (fVar.yb() == fVar.yp() || fVar.yd() <= fVar.yq() || !xb()) {
                                a(1, 17, fVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (fVar.yw() > fVar.yx() && !xd()) {
                        TiebaStatic.eventStat(this.ahC, "message_broadcast_receive", "");
                        a(1, 21, fVar);
                    }
                    if (fVar.yA() <= fVar.yB()) {
                        a(1, 27, fVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, fVar);
                ye = fVar.ye();
                if (ye > 0) {
                    a(1, 19, fVar);
                }
                if (fVar.yb() <= fVar.yp()) {
                }
                if (fVar.yb() > fVar.yp()) {
                }
                if (fVar.yb() == fVar.yp()) {
                }
                a(1, 17, fVar);
                if (fVar.yw() > fVar.yx()) {
                    TiebaStatic.eventStat(this.ahC, "message_broadcast_receive", "");
                    a(1, 21, fVar);
                }
                if (fVar.yA() <= fVar.yB()) {
                }
            }
        }
    }

    public f xo() {
        return this.ahL;
    }

    public void c(f fVar) {
        this.ahL = fVar;
    }

    public f xp() {
        return this.ahM;
    }
}
