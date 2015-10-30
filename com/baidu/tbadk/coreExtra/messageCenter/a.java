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
import com.baidu.tbadk.core.util.aq;
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
    private static a agR;
    private static Date agU = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e agT;
    private String agW;
    private String agX;
    private int agK = 0;
    private int agL = 0;
    private int agM = 0;
    private int agN = 0;
    private int agO = 0;
    private int agP = 0;
    private int agQ = 0;
    private com.baidu.tbadk.coreExtra.d.e agS = new com.baidu.tbadk.coreExtra.d.e();
    private boolean agV = true;
    private final int[] agY = new int[10];
    private final Context agJ = TbadkCoreApplication.m411getInst().getApp();

    public static a wH() {
        if (agR == null) {
            agR = new a();
        }
        return agR;
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
                this.agW = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.agW = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.agX = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.agK || i2 != this.agL || i3 != this.agM || i4 != this.agO || i5 != this.agN || i6 != this.agP) {
            if (i > this.agK || i2 > this.agL || i3 > this.agM || i4 > this.agO || i5 > this.agN || i6 > this.agP) {
                i7 = 1;
            } else {
                i7 = (i < this.agK || i2 < this.agL) ? 2 : 0;
            }
            if (i > this.agK) {
                i8 = 1;
            } else {
                i8 = i < this.agK ? 2 : 0;
            }
            if (i2 > this.agL) {
                i9 = 1;
            } else {
                i9 = i2 < this.agL ? 2 : 0;
            }
            int i11 = i3 > this.agM ? 1 : 0;
            int i12 = i4 > this.agO ? 1 : 0;
            int i13 = i6 <= this.agP ? 0 : 1;
            this.agK = i;
            this.agL = i2;
            this.agM = i3;
            this.agO = i4;
            this.agN = i5;
            this.agP = i6;
            if (xb() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                wZ();
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
        if (i != this.agK || i2 != this.agL || i3 != this.agM || i4 != this.agO || this.agP != i5) {
            this.agK = i;
            this.agL = i2;
            this.agM = i3;
            this.agO = i4;
            this.agP = i5;
            wZ();
            if (xb() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean wI() {
        if (agU == null) {
            agU = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - agU.getTime() < 10000) {
                return false;
            }
            agU = date;
        }
        return true;
    }

    public static boolean wJ() {
        if (c.xe().xp()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xe().xr().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xe().xs().split(":");
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
                    if (this.agP > 0) {
                        String format = String.format(this.agJ.getString(i.h.notify_gift), String.valueOf(this.agP));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.agK > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.agK > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.agK));
                            sb.append(this.agJ.getString(i.h.notify_unit));
                            sb.append("]");
                        }
                        if (this.agW != null) {
                            sb.append(this.agW);
                        } else {
                            sb.append(this.agJ.getString(i.h.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.agL > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.agL > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.agL));
                            sb2.append(this.agJ.getString(i.h.notify_unit));
                            sb2.append("]");
                        }
                        if (this.agX != null) {
                            sb2.append(this.agX);
                        } else {
                            sb2.append(this.agJ.getString(i.h.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.agO > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.agO > 1) {
                            sb3.append(String.format(this.agJ.getString(i.h.notify_fans_unit), Integer.valueOf(this.agO)));
                        }
                        sb3.append(this.agJ.getString(i.h.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xe().xt()) {
                    c.xe().xh();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.agJ, 16);
                NotificationHelper.cancelNotification(this.agJ, 17);
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
        String xY;
        String xX;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.agP > 0) {
                            String format = String.format(this.agJ.getString(i.h.notify_gift), String.valueOf(this.agP));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.agK > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.agK > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.agK));
                                sb.append(this.agJ.getString(i.h.notify_unit));
                                sb.append("]");
                            }
                            if (this.agW != null) {
                                sb.append(this.agW);
                            } else {
                                sb.append(this.agJ.getString(i.h.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.agL > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.agL > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.agL));
                                sb2.append(this.agJ.getString(i.h.notify_unit));
                                sb2.append("]");
                            }
                            if (this.agX != null) {
                                sb2.append(this.agX);
                            } else {
                                sb2.append(this.agJ.getString(i.h.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.agO > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.agO > 1) {
                                sb3.append(String.format(this.agJ.getString(i.h.notify_fans_unit), Integer.valueOf(this.agO)));
                            }
                            sb3.append(this.agJ.getString(i.h.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int xO = (!c.xe().xt() || c.xe().xh() <= 0) ? 0 : eVar.xO() - eVar.xV();
                        long yg = (!c.xe().xm() || c.xe().xh() <= 0) ? 0L : eVar.yg();
                        boolean z4 = yg > 0;
                        long j = xO + yg;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.agJ.getString(i.h.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.yj();
                            eVar.yh();
                            if (yg == 1) {
                                xY = eVar.yj();
                                str = eVar.yh();
                                xX = String.valueOf(xY) + "：" + str;
                            } else if (xO == 1) {
                                xY = eVar.xY();
                                xX = eVar.xX();
                                str = xX;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.agJ.getString(i.h.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(xX)) {
                                xX = str;
                            }
                            a(16, xY, str, xX, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> yq = eVar.yq();
                        if (yq != null && yq.size() != 0) {
                            for (e.b bVar : yq) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.aio) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> yr = eVar.yr();
                        if (yr != null && yr.size() != 0) {
                            for (e.a aVar : yr) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.aio) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.xe().xt() && c.xe().xh() > 0) {
                        if (eVar.xP() + eVar.xR() > 0) {
                            if (eVar.xP() > 0 && !wQ()) {
                                long xP = eVar.xP() - eVar.xQ();
                                if (xP > 0) {
                                    stringBuffer.append(String.format(this.agJ.getString(i.h.notify_updates), Long.valueOf(xP)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.xQ() > 0) {
                                    z = true;
                                }
                                if (eVar.xR() > 0 || wP()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.agJ.getString(i.h.notify_validate), Integer.valueOf(eVar.xR())));
                                } else {
                                    stringBuffer.append(String.format(this.agJ.getString(i.h.notify_validate_1), Integer.valueOf(eVar.xR())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.ya(), eVar.yb(), eVar.yb());
                                }
                            }
                            z = false;
                            if (eVar.xR() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yk() > 0 && !wR()) {
                            String format2 = String.format(this.agJ.getString(i.h.notify_live), Integer.valueOf(eVar.yk()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.agJ, 16);
                    NotificationHelper.cancelNotification(this.agJ, 17);
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
            NotificationHelper.showNotification(this.agJ, bVar.gid, bVar.title, bVar.content, bVar.aip, PendingIntent.getService(this.agJ, bVar.gid, b, 134217728), false);
            TiebaStatic.log(new aq("c10321").r("obj_type", 1).ae("obj_name", "show"));
        }
    }

    private void a(e.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.agJ, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.agJ, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.agV) {
            if (i == 23 && this.agP > 0) {
                e = cW(i);
            } else if (i == 26 && this.agO > 0) {
                e = cX(i);
            } else if (i == 18) {
                e = wK();
            } else {
                e = e(i, z);
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.agJ, i, str, str2, str3, PendingIntent.getService(this.agJ, i, e, 134217728), false);
        }
    }

    public Intent cW(int i) {
        Intent intent = new Intent(this.agJ, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.agP);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cX(int i) {
        Intent intent = new Intent(this.agJ, DealIntentService.class);
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
        Intent intent = new Intent(this.agJ, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.aiq);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.agJ, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.agS.yi().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.agJ, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.agL);
        intent.putExtra("reply_me", this.agK);
        intent.putExtra("fans", this.agO);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.agS.xO() - this.agS.xV());
        intent.putExtra("group_msg_validate", this.agS.xR());
        intent.putExtra("group_msg_updates", this.agS.xP());
        intent.putExtra("live_notify_msg_updates", this.agS.yk());
        intent.putExtra("officialbar_msg", this.agS.xS());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent wK() {
        Intent intent = new Intent(this.agJ, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.agS.xQ());
        return intent;
    }

    public void wL() {
        NotificationHelper.cancelNotification(this.agJ, 23);
        NotificationHelper.cancelNotification(this.agJ, 24);
        NotificationHelper.cancelNotification(this.agJ, 25);
        NotificationHelper.cancelNotification(this.agJ, 26);
        NotificationHelper.cancelNotification(this.agJ, 17);
        NotificationHelper.cancelNotification(this.agJ, 15);
        NotificationHelper.cancelNotification(this.agJ, 13);
        NotificationHelper.cancelNotification(this.agJ, 12);
    }

    public void wM() {
        NotificationHelper.cancelNotification(this.agJ, 16);
    }

    public void wN() {
        NotificationHelper.cancelNotification(this.agJ, 19);
    }

    public void cY(int i) {
        NotificationHelper.cancelNotification(this.agJ, i);
    }

    public int wO() {
        return this.agS.yg();
    }

    public void dW(String str) {
        if (TextUtils.isEmpty(str)) {
            wM();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xc = xc();
        if (xc == null) {
            wM();
            return;
        }
        HashMap<String, String> yc = xc.yc();
        if (yc == null || yc.isEmpty()) {
            wM();
        } else if (yc.containsKey(str)) {
            wM();
        }
    }

    public void dX(String str) {
        if (TextUtils.isEmpty(str)) {
            wM();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xc = xc();
        if (xc == null) {
            wM();
            return;
        }
        HashMap<String, String> yi = xc.yi();
        if (yi == null || yi.isEmpty()) {
            wM();
        } else if (yi.containsKey(str)) {
            wM();
        }
    }

    private boolean wP() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean wQ() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean wR() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void wS() {
        NotificationHelper.cancelNotification(this.agJ, 17);
    }

    public void cZ(int i) {
        com.baidu.tbadk.coreExtra.d.e xc = xc();
        if (xc == null) {
            wS();
        } else if (1 == i) {
            if (xc.xP() <= 0) {
                wS();
            }
        } else if (2 == i) {
            if (xc.xR() <= 0) {
                wS();
            }
        } else if (3 == i && xc.yk() <= 0) {
            NotificationHelper.cancelNotification(this.agJ, 21);
        }
    }

    public void wT() {
        NotificationHelper.cancelNotification(this.agJ, 18);
    }

    public void wU() {
        NotificationHelper.cancelNotification(this.agJ, 26);
        NotificationHelper.cancelNotification(this.agJ, 25);
        NotificationHelper.cancelNotification(this.agJ, 24);
        NotificationHelper.cancelNotification(this.agJ, 23);
        NotificationHelper.cancelNotification(this.agJ, 16);
        NotificationHelper.cancelNotification(this.agJ, 17);
    }

    public void wV() {
        NotificationHelper.cancelNotification(this.agJ, 21);
        NotificationHelper.cancelNotification(this.agJ, 17);
        NotificationHelper.cancelNotification(this.agJ, 19);
        NotificationHelper.cancelNotification(this.agJ, 16);
        NotificationHelper.cancelNotification(this.agJ, 18);
    }

    public void da(int i) {
        NotificationHelper.cancelNotification(this.agJ, i);
    }

    public void wW() {
        NotificationHelper.cancelNotification(this.agJ, 24);
    }

    public void wX() {
        NotificationHelper.cancelNotification(this.agJ, 25);
    }

    public void wY() {
        NotificationHelper.cancelNotification(this.agJ, 23);
    }

    public void wZ() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xa());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.agS.yg());
        newsNotifyMessage.setMsgStrangerChat(this.agS.yn());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yg() + eVar.xO()) + eVar.yn()) + eVar.ym()) + eVar.ys()) - eVar.xV());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yg());
            newsNotifyMessage.setMsgStrangerChat(eVar.yn());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.agK;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.agL, this.agM, this.agO, this.agN, this.agP);
        }
    }

    public int getMsgAtme() {
        return this.agL;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.agK, i, this.agM, this.agO, this.agN, this.agP);
        }
    }

    public int getMsgChat() {
        return this.agM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=5] */
    public int xa() {
        return ((((this.agS.yg() + this.agS.xO()) + this.agS.yn()) + this.agS.ym()) + this.agS.ys()) - this.agS.xV();
    }

    public int getMsgFans() {
        return this.agO;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.agK, this.agL, this.agM, i, this.agN, this.agP);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.agK, this.agL, i, this.agO, this.agN, this.agP);
        }
    }

    public int getMsgBookmark() {
        return this.agN;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.agK, this.agL, this.agM, this.agO, i, this.agP);
        }
    }

    public int getMsgGiftNum() {
        return this.agP;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.agP = i;
        }
    }

    public void db(int i) {
        if (i >= 0) {
            this.agQ += i;
            wZ();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.agQ = i;
            wZ();
        }
    }

    public int getMsgLiveVip() {
        return this.agQ;
    }

    public void ay(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.agK = 0;
        this.agL = 0;
        this.agM = 0;
        this.agO = 0;
        this.agN = 0;
    }

    public int xb() {
        return this.agK + this.agL + this.agM + this.agO + this.agP;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int xS;
        int i = 0;
        if (eVar != null) {
            this.agS = eVar;
            this.agM = (eVar.xO() - eVar.xV()) + eVar.yg() + eVar.ym() + eVar.ys();
            a(eVar);
            if (eVar.xW()) {
                this.agT = null;
                mHandler.removeMessages(0);
            }
            if (eVar.xW()) {
                if (c.xe().xt() && c.xe().xh() > 0) {
                    i = eVar.xO() - eVar.xV();
                }
                if (c.xe().xm() && c.xe().xh() > 0) {
                    boolean xv = c.xe().xv();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yg();
                    } else if (isFloatingWindowOpened) {
                        if (!xv || isProcessBackground) {
                            j = eVar.yg();
                        }
                    } else {
                        j = eVar.yg();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.xZ() - eVar.xV() && i > 0) || j > eVar.xT())) {
                        a(1, 16, eVar);
                    }
                    xS = eVar.xS();
                    if (xS > 0 && xS > eVar.yf()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.xP() <= eVar.yd() || eVar.xR() > eVar.ye()) {
                        if (eVar.xP() > eVar.yd() || eVar.xR() != eVar.ye() || !wQ()) {
                            if (eVar.xP() == eVar.yd() || eVar.xR() <= eVar.ye() || !wP()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yk() > eVar.yl() && !wR()) {
                        TiebaStatic.eventStat(this.agJ, "message_broadcast_receive", "");
                        a(1, 21, eVar);
                    }
                    if (eVar.yo() <= eVar.yp()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                xS = eVar.xS();
                if (xS > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.xP() <= eVar.yd()) {
                }
                if (eVar.xP() > eVar.yd()) {
                }
                if (eVar.xP() == eVar.yd()) {
                }
                a(1, 17, eVar);
                if (eVar.yk() > eVar.yl()) {
                    TiebaStatic.eventStat(this.agJ, "message_broadcast_receive", "");
                    a(1, 21, eVar);
                }
                if (eVar.yo() <= eVar.yp()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xc() {
        return this.agS;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.agS = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xd() {
        return this.agT;
    }
}
