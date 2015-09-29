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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.d.e;
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
    private static a agQ;
    private static Date agT = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e agS;
    private String agV;
    private String agW;
    private int agJ = 0;
    private int agK = 0;
    private int agL = 0;
    private int agM = 0;
    private int agN = 0;
    private int agO = 0;
    private int agP = 0;
    private com.baidu.tbadk.coreExtra.d.e agR = new com.baidu.tbadk.coreExtra.d.e();
    private boolean agU = true;
    private final int[] agX = new int[10];
    private final Context agI = TbadkCoreApplication.m411getInst().getApp();

    public static a wK() {
        if (agQ == null) {
            agQ = new a();
        }
        return agQ;
    }

    private a() {
    }

    public void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
            if (!StringUtils.isNull(optString)) {
                this.agV = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.agV = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.agW = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.agJ || i2 != this.agK || i3 != this.agL || i4 != this.agN || i5 != this.agM || i6 != this.agO) {
            if (i > this.agJ || i2 > this.agK || i3 > this.agL || i4 > this.agN || i5 > this.agM || i6 > this.agO) {
                i7 = 1;
            } else {
                i7 = (i < this.agJ || i2 < this.agK) ? 2 : 0;
            }
            if (i > this.agJ) {
                i8 = 1;
            } else {
                i8 = i < this.agJ ? 2 : 0;
            }
            if (i2 > this.agK) {
                i9 = 1;
            } else {
                i9 = i2 < this.agK ? 2 : 0;
            }
            int i11 = i3 > this.agL ? 1 : 0;
            int i12 = i4 > this.agN ? 1 : 0;
            int i13 = i6 <= this.agO ? 0 : 1;
            this.agJ = i;
            this.agK = i2;
            this.agL = i3;
            this.agN = i4;
            this.agM = i5;
            this.agO = i6;
            if (xe() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xc();
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
        if (i != this.agJ || i2 != this.agK || i3 != this.agL || i4 != this.agN || this.agO != i5) {
            this.agJ = i;
            this.agK = i2;
            this.agL = i3;
            this.agN = i4;
            this.agO = i5;
            xc();
            if (xe() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean wL() {
        if (agT == null) {
            agT = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - agT.getTime() < 10000) {
                return false;
            }
            agT = date;
        }
        return true;
    }

    public static boolean wM() {
        if (c.xh().xs()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xh().xu().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xh().xv().split(":");
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
                    if (this.agO > 0) {
                        String format = String.format(this.agI.getString(i.h.notify_gift), String.valueOf(this.agO));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.agJ > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.agJ > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.agJ));
                            sb.append(this.agI.getString(i.h.notify_unit));
                            sb.append("]");
                        }
                        if (this.agV != null) {
                            sb.append(this.agV);
                        } else {
                            sb.append(this.agI.getString(i.h.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.agK > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.agK > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.agK));
                            sb2.append(this.agI.getString(i.h.notify_unit));
                            sb2.append("]");
                        }
                        if (this.agW != null) {
                            sb2.append(this.agW);
                        } else {
                            sb2.append(this.agI.getString(i.h.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.agN > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.agN > 1) {
                            sb3.append(String.format(this.agI.getString(i.h.notify_fans_unit), Integer.valueOf(this.agN)));
                        }
                        sb3.append(this.agI.getString(i.h.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xh().xw()) {
                    c.xh().xk();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.agI, 16);
                NotificationHelper.cancelNotification(this.agI, 17);
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
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.d.e eVar) {
        boolean z;
        String yb;
        String ya;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.agO > 0) {
                            String format = String.format(this.agI.getString(i.h.notify_gift), String.valueOf(this.agO));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.agJ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.agJ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.agJ));
                                sb.append(this.agI.getString(i.h.notify_unit));
                                sb.append("]");
                            }
                            if (this.agV != null) {
                                sb.append(this.agV);
                            } else {
                                sb.append(this.agI.getString(i.h.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.agK > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.agK > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.agK));
                                sb2.append(this.agI.getString(i.h.notify_unit));
                                sb2.append("]");
                            }
                            if (this.agW != null) {
                                sb2.append(this.agW);
                            } else {
                                sb2.append(this.agI.getString(i.h.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.agN > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.agN > 1) {
                                sb3.append(String.format(this.agI.getString(i.h.notify_fans_unit), Integer.valueOf(this.agN)));
                            }
                            sb3.append(this.agI.getString(i.h.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int xR = (!c.xh().xw() || c.xh().xk() <= 0) ? 0 : eVar.xR() - eVar.xY();
                        long yj = (!c.xh().xp() || c.xh().xk() <= 0) ? 0L : eVar.yj();
                        boolean z4 = yj > 0;
                        long j = xR + yj;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.agI.getString(i.h.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.ym();
                            eVar.yk();
                            if (yj == 1) {
                                yb = eVar.ym();
                                str = eVar.yk();
                                ya = String.valueOf(yb) + "：" + str;
                            } else if (xR == 1) {
                                yb = eVar.yb();
                                ya = eVar.ya();
                                str = ya;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.agI.getString(i.h.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(ya)) {
                                ya = str;
                            }
                            a(16, yb, str, ya, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> yt = eVar.yt();
                        if (yt != null && yt.size() != 0) {
                            for (e.b bVar : yt) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.ain) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> yu = eVar.yu();
                        if (yu != null && yu.size() != 0) {
                            for (e.a aVar : yu) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.ain) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.xh().xw() && c.xh().xk() > 0) {
                        if (eVar.xS() + eVar.xU() > 0) {
                            if (eVar.xS() > 0 && !wT()) {
                                long xS = eVar.xS() - eVar.xT();
                                if (xS > 0) {
                                    stringBuffer.append(String.format(this.agI.getString(i.h.notify_updates), Long.valueOf(xS)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.xT() > 0) {
                                    z = true;
                                }
                                if (eVar.xU() > 0 || wS()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.agI.getString(i.h.notify_validate), Integer.valueOf(eVar.xU())));
                                } else {
                                    stringBuffer.append(String.format(this.agI.getString(i.h.notify_validate_1), Integer.valueOf(eVar.xU())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.yd(), eVar.ye(), eVar.ye());
                                }
                            }
                            z = false;
                            if (eVar.xU() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yn() > 0 && !wU()) {
                            String format2 = String.format(this.agI.getString(i.h.notify_live), Integer.valueOf(eVar.yn()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.agI, 16);
                    NotificationHelper.cancelNotification(this.agI, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.b bVar) {
        Intent b = b(bVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.agI, bVar.gid, bVar.title, bVar.content, bVar.aio, PendingIntent.getService(this.agI, bVar.gid, b, 134217728), false);
            TiebaStatic.log(new ap("c10321").r("obj_type", 1).ae("obj_name", "show"));
        }
    }

    private void a(e.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.agI, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.agI, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.agU) {
            if (i == 23 && this.agO > 0) {
                e = cW(i);
            } else if (i == 26 && this.agN > 0) {
                e = cX(i);
            } else if (i == 18) {
                e = wN();
            } else {
                e = e(i, z);
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.agI, i, str, str2, str3, PendingIntent.getService(this.agI, i, e, 134217728), false);
        }
    }

    public Intent cW(int i) {
        Intent intent = new Intent(this.agI, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.agO);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cX(int i) {
        Intent intent = new Intent(this.agI, DealIntentService.class);
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

    public Intent b(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        Intent intent = new Intent(this.agI, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.aip);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.agI, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.agR.yl().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.agI, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.agK);
        intent.putExtra("reply_me", this.agJ);
        intent.putExtra("fans", this.agN);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.agR.xR() - this.agR.xY());
        intent.putExtra("group_msg_validate", this.agR.xU());
        intent.putExtra("group_msg_updates", this.agR.xS());
        intent.putExtra("live_notify_msg_updates", this.agR.yn());
        intent.putExtra("officialbar_msg", this.agR.xV());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent wN() {
        Intent intent = new Intent(this.agI, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.agR.xT());
        return intent;
    }

    public void wO() {
        NotificationHelper.cancelNotification(this.agI, 23);
        NotificationHelper.cancelNotification(this.agI, 24);
        NotificationHelper.cancelNotification(this.agI, 25);
        NotificationHelper.cancelNotification(this.agI, 26);
        NotificationHelper.cancelNotification(this.agI, 17);
        NotificationHelper.cancelNotification(this.agI, 15);
        NotificationHelper.cancelNotification(this.agI, 13);
        NotificationHelper.cancelNotification(this.agI, 12);
    }

    public void wP() {
        NotificationHelper.cancelNotification(this.agI, 16);
    }

    public void wQ() {
        NotificationHelper.cancelNotification(this.agI, 19);
    }

    public void cY(int i) {
        NotificationHelper.cancelNotification(this.agI, i);
    }

    public int wR() {
        return this.agR.yj();
    }

    public void dW(String str) {
        if (TextUtils.isEmpty(str)) {
            wP();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xf = xf();
        if (xf == null) {
            wP();
            return;
        }
        HashMap<String, String> yf = xf.yf();
        if (yf == null || yf.isEmpty()) {
            wP();
        } else if (yf.containsKey(str)) {
            wP();
        }
    }

    public void dX(String str) {
        if (TextUtils.isEmpty(str)) {
            wP();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xf = xf();
        if (xf == null) {
            wP();
            return;
        }
        HashMap<String, String> yl = xf.yl();
        if (yl == null || yl.isEmpty()) {
            wP();
        } else if (yl.containsKey(str)) {
            wP();
        }
    }

    private boolean wS() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean wT() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean wU() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void wV() {
        NotificationHelper.cancelNotification(this.agI, 17);
    }

    public void cZ(int i) {
        com.baidu.tbadk.coreExtra.d.e xf = xf();
        if (xf == null) {
            wV();
        } else if (1 == i) {
            if (xf.xS() <= 0) {
                wV();
            }
        } else if (2 == i) {
            if (xf.xU() <= 0) {
                wV();
            }
        } else if (3 == i && xf.yn() <= 0) {
            NotificationHelper.cancelNotification(this.agI, 21);
        }
    }

    public void wW() {
        NotificationHelper.cancelNotification(this.agI, 18);
    }

    public void wX() {
        NotificationHelper.cancelNotification(this.agI, 26);
        NotificationHelper.cancelNotification(this.agI, 25);
        NotificationHelper.cancelNotification(this.agI, 24);
        NotificationHelper.cancelNotification(this.agI, 23);
        NotificationHelper.cancelNotification(this.agI, 16);
        NotificationHelper.cancelNotification(this.agI, 17);
    }

    public void wY() {
        NotificationHelper.cancelNotification(this.agI, 21);
        NotificationHelper.cancelNotification(this.agI, 17);
        NotificationHelper.cancelNotification(this.agI, 19);
        NotificationHelper.cancelNotification(this.agI, 16);
        NotificationHelper.cancelNotification(this.agI, 18);
    }

    public void da(int i) {
        NotificationHelper.cancelNotification(this.agI, i);
    }

    public void wZ() {
        NotificationHelper.cancelNotification(this.agI, 24);
    }

    public void xa() {
        NotificationHelper.cancelNotification(this.agI, 25);
    }

    public void xb() {
        NotificationHelper.cancelNotification(this.agI, 23);
    }

    public void xc() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xd());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.agR.yj());
        newsNotifyMessage.setMsgStrangerChat(this.agR.yq());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yj() + eVar.xR()) + eVar.yq()) + eVar.yp()) + eVar.yv()) - eVar.xY());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yj());
            newsNotifyMessage.setMsgStrangerChat(eVar.yq());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.agJ;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.agK, this.agL, this.agN, this.agM, this.agO);
        }
    }

    public int getMsgAtme() {
        return this.agK;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.agJ, i, this.agL, this.agN, this.agM, this.agO);
        }
    }

    public int getMsgChat() {
        return this.agL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=5] */
    public int xd() {
        return ((((this.agR.yj() + this.agR.xR()) + this.agR.yq()) + this.agR.yp()) + this.agR.yv()) - this.agR.xY();
    }

    public int getMsgFans() {
        return this.agN;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.agJ, this.agK, this.agL, i, this.agM, this.agO);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.agJ, this.agK, i, this.agN, this.agM, this.agO);
        }
    }

    public int getMsgBookmark() {
        return this.agM;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.agJ, this.agK, this.agL, this.agN, i, this.agO);
        }
    }

    public int getMsgGiftNum() {
        return this.agO;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.agO = i;
        }
    }

    public void db(int i) {
        if (i >= 0) {
            this.agP += i;
            xc();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.agP = i;
            xc();
        }
    }

    public int getMsgLiveVip() {
        return this.agP;
    }

    public void ay(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.agJ = 0;
        this.agK = 0;
        this.agL = 0;
        this.agN = 0;
        this.agM = 0;
    }

    public int xe() {
        return this.agJ + this.agK + this.agL + this.agN + this.agO;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int xV;
        int i = 0;
        if (eVar != null) {
            this.agR = eVar;
            this.agL = (eVar.xR() - eVar.xY()) + eVar.yj() + eVar.yp() + eVar.yv();
            a(eVar);
            if (eVar.xZ()) {
                this.agS = null;
                mHandler.removeMessages(0);
            }
            if (eVar.xZ()) {
                if (c.xh().xw() && c.xh().xk() > 0) {
                    i = eVar.xR() - eVar.xY();
                }
                if (c.xh().xp() && c.xh().xk() > 0) {
                    boolean xy = c.xh().xy();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yj();
                    } else if (isFloatingWindowOpened) {
                        if (!xy || isProcessBackground) {
                            j = eVar.yj();
                        }
                    } else {
                        j = eVar.yj();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.yc() - eVar.xY() && i > 0) || j > eVar.xW())) {
                        a(1, 16, eVar);
                    }
                    xV = eVar.xV();
                    if (xV > 0 && xV > eVar.yi()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.xS() <= eVar.yg() || eVar.xU() > eVar.yh()) {
                        if (eVar.xS() > eVar.yg() || eVar.xU() != eVar.yh() || !wT()) {
                            if (eVar.xS() == eVar.yg() || eVar.xU() <= eVar.yh() || !wS()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yn() > eVar.yo() && !wU()) {
                        TiebaStatic.eventStat(this.agI, "message_broadcast_receive", "");
                        a(1, 21, eVar);
                    }
                    if (eVar.yr() <= eVar.ys()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                xV = eVar.xV();
                if (xV > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.xS() <= eVar.yg()) {
                }
                if (eVar.xS() > eVar.yg()) {
                }
                if (eVar.xS() == eVar.yg()) {
                }
                a(1, 17, eVar);
                if (eVar.yn() > eVar.yo()) {
                    TiebaStatic.eventStat(this.agI, "message_broadcast_receive", "");
                    a(1, 21, eVar);
                }
                if (eVar.yr() <= eVar.ys()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xf() {
        return this.agR;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.agR = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xg() {
        return this.agS;
    }
}
