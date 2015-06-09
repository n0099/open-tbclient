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
import com.baidu.tbadk.coreExtra.c.h;
import com.baidu.tbadk.coreExtra.c.i;
import com.baidu.tbadk.coreExtra.c.j;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.mention.FeedData;
import com.baidu.tieba.t;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a acB;
    private static Date acE = null;
    private static Handler mHandler = new b();
    private h acD;
    private String acF;
    private String acG;
    private int acu = 0;
    private int acv = 0;
    private int acw = 0;
    private int acx = 0;
    private int acy = 0;
    private int acz = 0;
    private int acA = 0;
    private h acC = new h();
    private final int[] acH = new int[10];
    private final Context acs = TbadkCoreApplication.m411getInst().getApp();

    public static a vJ() {
        if (acB == null) {
            acB = new a();
        }
        return acB;
    }

    private a() {
    }

    public void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
            if (!StringUtils.isNull(optString)) {
                this.acF = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.acF = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.acG = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.acu || i2 != this.acv || i3 != this.acw || i4 != this.acy || i5 != this.acx || i6 != this.acz) {
            if (i > this.acu || i2 > this.acv || i3 > this.acw || i4 > this.acy || i5 > this.acx || i6 > this.acz) {
                i7 = 1;
            } else {
                i7 = (i < this.acu || i2 < this.acv) ? 2 : 0;
            }
            if (i > this.acu) {
                i8 = 1;
            } else {
                i8 = i < this.acu ? 2 : 0;
            }
            if (i2 > this.acv) {
                i9 = 1;
            } else {
                i9 = i2 < this.acv ? 2 : 0;
            }
            int i11 = i3 > this.acw ? 1 : 0;
            int i12 = i4 > this.acy ? 1 : 0;
            int i13 = i6 <= this.acz ? 0 : 1;
            this.acu = i;
            this.acv = i2;
            this.acw = i3;
            this.acy = i4;
            this.acx = i5;
            this.acz = i6;
            if (wd() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                wb();
                t(i10, 23);
                t(i11, 16);
                t(i7, 17);
                t(i8, 24);
                t(i9, 25);
                t(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.acu || i2 != this.acv || i3 != this.acw || i4 != this.acy || this.acz != i5) {
            this.acu = i;
            this.acv = i2;
            this.acw = i3;
            this.acy = i4;
            this.acz = i5;
            wb();
            if (wd() <= 0) {
                t(2, 16);
                t(2, 17);
            }
        }
    }

    public static boolean vK() {
        if (acE == null) {
            acE = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - acE.getTime() < 10000) {
                return false;
            }
            acE = date;
        }
        return true;
    }

    public static boolean vL() {
        if (c.wg().wr()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.wg().wt().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.wg().wu().split(":");
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

    private void t(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.acz > 0) {
                        String format = String.format(this.acs.getString(t.notify_gift), String.valueOf(this.acz));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.acu > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.acu > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.acu));
                            sb.append(this.acs.getString(t.notify_unit));
                            sb.append("]");
                        }
                        if (this.acF != null) {
                            sb.append(this.acF);
                        } else {
                            sb.append(this.acs.getString(t.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.acv > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.acv > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.acv));
                            sb2.append(this.acs.getString(t.notify_unit));
                            sb2.append("]");
                        }
                        if (this.acG != null) {
                            sb2.append(this.acG);
                        } else {
                            sb2.append(this.acs.getString(t.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.acy > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.acy > 1) {
                            sb3.append(String.format(this.acs.getString(t.notify_fans_unit), Integer.valueOf(this.acy)));
                        }
                        sb3.append(this.acs.getString(t.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.wg().wv()) {
                    c.wg().wj();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.acs, 16);
                NotificationHelper.cancelNotification(this.acs, 17);
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
    private void a(int i, int i2, h hVar) {
        boolean z;
        String xb;
        String xa;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.acz > 0) {
                            String format = String.format(this.acs.getString(t.notify_gift), String.valueOf(this.acz));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.acu > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.acu > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.acu));
                                sb.append(this.acs.getString(t.notify_unit));
                                sb.append("]");
                            }
                            if (this.acF != null) {
                                sb.append(this.acF);
                            } else {
                                sb.append(this.acs.getString(t.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.acv > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.acv > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.acv));
                                sb2.append(this.acs.getString(t.notify_unit));
                                sb2.append("]");
                            }
                            if (this.acG != null) {
                                sb2.append(this.acG);
                            } else {
                                sb2.append(this.acs.getString(t.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.acy > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.acy > 1) {
                                sb3.append(String.format(this.acs.getString(t.notify_fans_unit), Integer.valueOf(this.acy)));
                            }
                            sb3.append(this.acs.getString(t.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int wR = (!c.wg().wv() || c.wg().wj() <= 0) ? 0 : hVar.wR() - hVar.wY();
                        long xj = (!c.wg().wo() || c.wg().wj() <= 0) ? 0L : hVar.xj();
                        boolean z4 = xj > 0;
                        long j = wR + xj;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.acs.getString(t.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            hVar.xm();
                            hVar.xk();
                            if (xj == 1) {
                                xb = hVar.xm();
                                str = hVar.xk();
                                xa = String.valueOf(xb) + "：" + str;
                            } else if (wR == 1) {
                                xb = hVar.xb();
                                xa = hVar.xa();
                                str = xa;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.acs.getString(t.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(xa)) {
                                xa = str;
                            }
                            a(16, xb, str, xa, z4);
                        }
                    } else if (i2 == 19) {
                        List<j> xt = hVar.xt();
                        if (xt != null && xt.size() != 0) {
                            for (j jVar : xt) {
                                if (jVar != null && !StringUtils.isNull(jVar.content) && jVar.gid != 0 && jVar.unReadCount > jVar.adZ) {
                                    a(jVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<i> xu = hVar.xu();
                        if (xu != null && xu.size() != 0) {
                            for (i iVar : xu) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.adZ) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (c.wg().wv() && c.wg().wj() > 0) {
                        if (hVar.wS() + hVar.wU() > 0) {
                            if (hVar.wS() > 0 && !vS()) {
                                long wS = hVar.wS() - hVar.wT();
                                if (wS > 0) {
                                    stringBuffer.append(String.format(this.acs.getString(t.notify_updates), Long.valueOf(wS)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.wT() > 0) {
                                    z = true;
                                }
                                if (hVar.wU() > 0 || vR()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.acs.getString(t.notify_validate), Integer.valueOf(hVar.wU())));
                                } else {
                                    stringBuffer.append(String.format(this.acs.getString(t.notify_validate_1), Integer.valueOf(hVar.wU())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.xd(), hVar.xe(), hVar.xe());
                                }
                            }
                            z = false;
                            if (hVar.wU() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.xn() > 0 && !vT()) {
                            String format2 = String.format(this.acs.getString(t.notify_live), Integer.valueOf(hVar.xn()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.acs, 16);
                    NotificationHelper.cancelNotification(this.acs, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(j jVar) {
        Intent b = b(jVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.acs, jVar.gid, jVar.title, jVar.content, jVar.aea, PendingIntent.getService(this.acs, jVar.gid, b, 134217728), false);
        }
    }

    private void a(i iVar) {
        Intent b = b(iVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.acs, iVar.gid, iVar.title, iVar.content, iVar.title, PendingIntent.getService(this.acs, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.acz > 0) {
            e = cF(i);
        } else if (i == 26 && this.acy > 0) {
            e = cG(i);
        } else if (i == 18) {
            e = vM();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.acs, i, str, str2, str3, PendingIntent.getService(this.acs, i, e, 134217728), false);
    }

    public Intent cF(int i) {
        Intent intent = new Intent(this.acs, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.acz);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cG(int i) {
        Intent intent = new Intent(this.acs, DealIntentService.class);
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

    public Intent b(j jVar) {
        if (jVar == null) {
            return null;
        }
        Intent intent = new Intent(this.acs, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", jVar.gid);
        intent.putExtra("uname", jVar.aeb);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, jVar.userType);
        return intent;
    }

    public Intent b(i iVar) {
        if (iVar == null) {
            return null;
        }
        Intent intent = new Intent(this.acs, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(iVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.acC.xl().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.acs, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.acv);
        intent.putExtra("reply_me", this.acu);
        intent.putExtra("fans", this.acy);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.acC.wR() - this.acC.wY());
        intent.putExtra("group_msg_validate", this.acC.wU());
        intent.putExtra("group_msg_updates", this.acC.wS());
        intent.putExtra("live_notify_msg_updates", this.acC.xn());
        intent.putExtra("officialbar_msg", this.acC.wV());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent vM() {
        Intent intent = new Intent(this.acs, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.acC.wT());
        return intent;
    }

    public void vN() {
        NotificationHelper.cancelNotification(this.acs, 23);
        NotificationHelper.cancelNotification(this.acs, 24);
        NotificationHelper.cancelNotification(this.acs, 25);
        NotificationHelper.cancelNotification(this.acs, 26);
        NotificationHelper.cancelNotification(this.acs, 17);
        NotificationHelper.cancelNotification(this.acs, 15);
        NotificationHelper.cancelNotification(this.acs, 13);
        NotificationHelper.cancelNotification(this.acs, 12);
    }

    public void vO() {
        NotificationHelper.cancelNotification(this.acs, 16);
    }

    public void vP() {
        NotificationHelper.cancelNotification(this.acs, 19);
    }

    public void cH(int i) {
        NotificationHelper.cancelNotification(this.acs, i);
    }

    public int vQ() {
        return this.acC.xj();
    }

    public void dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            vO();
            return;
        }
        h we = we();
        if (we == null) {
            vO();
            return;
        }
        HashMap<String, String> xf = we.xf();
        if (xf == null || xf.isEmpty()) {
            vO();
        } else if (xf.containsKey(str)) {
            vO();
        }
    }

    public void dK(String str) {
        if (TextUtils.isEmpty(str)) {
            vO();
            return;
        }
        h we = we();
        if (we == null) {
            vO();
            return;
        }
        HashMap<String, String> xl = we.xl();
        if (xl == null || xl.isEmpty()) {
            vO();
        } else if (xl.containsKey(str)) {
            vO();
        }
    }

    private boolean vR() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean vS() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean vT() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void vU() {
        NotificationHelper.cancelNotification(this.acs, 17);
    }

    public void cI(int i) {
        h we = we();
        if (we == null) {
            vU();
        } else if (1 == i) {
            if (we.wS() <= 0) {
                vU();
            }
        } else if (2 == i) {
            if (we.wU() <= 0) {
                vU();
            }
        } else if (3 == i && we.xn() <= 0) {
            NotificationHelper.cancelNotification(this.acs, 21);
        }
    }

    public void vV() {
        NotificationHelper.cancelNotification(this.acs, 18);
    }

    public void vW() {
        NotificationHelper.cancelNotification(this.acs, 26);
        NotificationHelper.cancelNotification(this.acs, 25);
        NotificationHelper.cancelNotification(this.acs, 24);
        NotificationHelper.cancelNotification(this.acs, 23);
        NotificationHelper.cancelNotification(this.acs, 16);
        NotificationHelper.cancelNotification(this.acs, 17);
    }

    public void vX() {
        NotificationHelper.cancelNotification(this.acs, 21);
        NotificationHelper.cancelNotification(this.acs, 17);
        NotificationHelper.cancelNotification(this.acs, 19);
        NotificationHelper.cancelNotification(this.acs, 16);
        NotificationHelper.cancelNotification(this.acs, 18);
    }

    public void cJ(int i) {
        NotificationHelper.cancelNotification(this.acs, i);
    }

    public void vY() {
        NotificationHelper.cancelNotification(this.acs, 24);
    }

    public void vZ() {
        NotificationHelper.cancelNotification(this.acs, 25);
    }

    public void wa() {
        NotificationHelper.cancelNotification(this.acs, 23);
    }

    public void wb() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(wc());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.acC.xj());
        newsNotifyMessage.setMsgStrangerChat(this.acC.xq());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.xj() + hVar.wR()) + hVar.xq()) + hVar.xp()) + hVar.xv()) - hVar.wY());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(hVar.xj());
            newsNotifyMessage.setMsgStrangerChat(hVar.xq());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.acu;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.acv, this.acw, this.acy, this.acx, this.acz);
        }
    }

    public int getMsgAtme() {
        return this.acv;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.acu, i, this.acw, this.acy, this.acx, this.acz);
        }
    }

    public int getMsgChat() {
        return this.acw;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [991=5] */
    public int wc() {
        return ((((this.acC.xj() + this.acC.wR()) + this.acC.xq()) + this.acC.xp()) + this.acC.xv()) - this.acC.wY();
    }

    public int getMsgFans() {
        return this.acy;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.acu, this.acv, this.acw, i, this.acx, this.acz);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.acu, this.acv, i, this.acy, this.acx, this.acz);
        }
    }

    public int getMsgBookmark() {
        return this.acx;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.acu, this.acv, this.acw, this.acy, i, this.acz);
        }
    }

    public int getMsgGiftNum() {
        return this.acz;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.acz = i;
        }
    }

    public void cK(int i) {
        if (i >= 0) {
            this.acA += i;
            wb();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.acA = i;
            wb();
        }
    }

    public int getMsgLiveVip() {
        return this.acA;
    }

    public void av(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.acu = 0;
        this.acv = 0;
        this.acw = 0;
        this.acy = 0;
        this.acx = 0;
    }

    public int wd() {
        return this.acu + this.acv + this.acw + this.acy + this.acz;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(h hVar) {
        long j;
        int wV;
        int i = 0;
        if (hVar != null) {
            this.acC = hVar;
            this.acw = (hVar.wR() - hVar.wY()) + hVar.xj() + hVar.xp() + hVar.xv();
            a(hVar);
            if (hVar.wZ()) {
                this.acD = null;
                mHandler.removeMessages(0);
            }
            if (hVar.wZ()) {
                if (c.wg().wv() && c.wg().wj() > 0) {
                    i = hVar.wR() - hVar.wY();
                }
                if (c.wg().wo() && c.wg().wj() > 0) {
                    boolean wx = c.wg().wx();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.xj();
                    } else if (isFloatingWindowOpened) {
                        if (!wx || isProcessBackground) {
                            j = hVar.xj();
                        }
                    } else {
                        j = hVar.xj();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.xc() - hVar.wY() && i > 0) || j > hVar.wW())) {
                        a(1, 16, hVar);
                    }
                    wV = hVar.wV();
                    if (wV > 0 && wV > hVar.xi()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.wS() <= hVar.xg() || hVar.wU() > hVar.xh()) {
                        if (hVar.wS() > hVar.xg() || hVar.wU() != hVar.xh() || !vS()) {
                            if (hVar.wS() == hVar.xg() || hVar.wU() <= hVar.xh() || !vR()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.xn() > hVar.xo() && !vT()) {
                        TiebaStatic.eventStat(this.acs, "message_broadcast_receive", "");
                        a(1, 21, hVar);
                    }
                    if (hVar.xr() <= hVar.xs()) {
                        a(1, 27, hVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                wV = hVar.wV();
                if (wV > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.wS() <= hVar.xg()) {
                }
                if (hVar.wS() > hVar.xg()) {
                }
                if (hVar.wS() == hVar.xg()) {
                }
                a(1, 17, hVar);
                if (hVar.xn() > hVar.xo()) {
                    TiebaStatic.eventStat(this.acs, "message_broadcast_receive", "");
                    a(1, 21, hVar);
                }
                if (hVar.xr() <= hVar.xs()) {
                }
            }
        }
    }

    public h we() {
        return this.acC;
    }

    public void c(h hVar) {
        this.acC = hVar;
    }

    public h wf() {
        return this.acD;
    }
}
