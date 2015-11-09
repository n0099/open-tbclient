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
    private static a agX;
    private static Date aha = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e agZ;
    private String ahc;
    private String ahd;
    private int agQ = 0;
    private int agR = 0;
    private int agS = 0;
    private int agT = 0;
    private int agU = 0;
    private int agV = 0;
    private int agW = 0;
    private com.baidu.tbadk.coreExtra.d.e agY = new com.baidu.tbadk.coreExtra.d.e();
    private boolean ahb = true;
    private final int[] ahe = new int[10];
    private final Context agP = TbadkCoreApplication.m411getInst().getApp();

    public static a wM() {
        if (agX == null) {
            agX = new a();
        }
        return agX;
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
                this.ahc = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.ahc = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.ahd = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.agQ || i2 != this.agR || i3 != this.agS || i4 != this.agU || i5 != this.agT || i6 != this.agV) {
            if (i > this.agQ || i2 > this.agR || i3 > this.agS || i4 > this.agU || i5 > this.agT || i6 > this.agV) {
                i7 = 1;
            } else {
                i7 = (i < this.agQ || i2 < this.agR) ? 2 : 0;
            }
            if (i > this.agQ) {
                i8 = 1;
            } else {
                i8 = i < this.agQ ? 2 : 0;
            }
            if (i2 > this.agR) {
                i9 = 1;
            } else {
                i9 = i2 < this.agR ? 2 : 0;
            }
            int i11 = i3 > this.agS ? 1 : 0;
            int i12 = i4 > this.agU ? 1 : 0;
            int i13 = i6 <= this.agV ? 0 : 1;
            this.agQ = i;
            this.agR = i2;
            this.agS = i3;
            this.agU = i4;
            this.agT = i5;
            this.agV = i6;
            if (xg() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xe();
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
        if (i != this.agQ || i2 != this.agR || i3 != this.agS || i4 != this.agU || this.agV != i5) {
            this.agQ = i;
            this.agR = i2;
            this.agS = i3;
            this.agU = i4;
            this.agV = i5;
            xe();
            if (xg() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean wN() {
        if (aha == null) {
            aha = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aha.getTime() < 10000) {
                return false;
            }
            aha = date;
        }
        return true;
    }

    public static boolean wO() {
        if (c.xj().xu()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xj().xw().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xj().xx().split(":");
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
                    if (this.agV > 0) {
                        String format = String.format(this.agP.getString(i.h.notify_gift), String.valueOf(this.agV));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.agQ > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.agQ > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.agQ));
                            sb.append(this.agP.getString(i.h.notify_unit));
                            sb.append("]");
                        }
                        if (this.ahc != null) {
                            sb.append(this.ahc);
                        } else {
                            sb.append(this.agP.getString(i.h.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.agR > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.agR > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.agR));
                            sb2.append(this.agP.getString(i.h.notify_unit));
                            sb2.append("]");
                        }
                        if (this.ahd != null) {
                            sb2.append(this.ahd);
                        } else {
                            sb2.append(this.agP.getString(i.h.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.agU > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.agU > 1) {
                            sb3.append(String.format(this.agP.getString(i.h.notify_fans_unit), Integer.valueOf(this.agU)));
                        }
                        sb3.append(this.agP.getString(i.h.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xj().xy()) {
                    c.xj().xm();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.agP, 16);
                NotificationHelper.cancelNotification(this.agP, 17);
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
        String yd;
        String yc;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.agV > 0) {
                            String format = String.format(this.agP.getString(i.h.notify_gift), String.valueOf(this.agV));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.agQ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.agQ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.agQ));
                                sb.append(this.agP.getString(i.h.notify_unit));
                                sb.append("]");
                            }
                            if (this.ahc != null) {
                                sb.append(this.ahc);
                            } else {
                                sb.append(this.agP.getString(i.h.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.agR > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.agR > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.agR));
                                sb2.append(this.agP.getString(i.h.notify_unit));
                                sb2.append("]");
                            }
                            if (this.ahd != null) {
                                sb2.append(this.ahd);
                            } else {
                                sb2.append(this.agP.getString(i.h.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.agU > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.agU > 1) {
                                sb3.append(String.format(this.agP.getString(i.h.notify_fans_unit), Integer.valueOf(this.agU)));
                            }
                            sb3.append(this.agP.getString(i.h.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int xT = (!c.xj().xy() || c.xj().xm() <= 0) ? 0 : eVar.xT() - eVar.ya();
                        long yl = (!c.xj().xr() || c.xj().xm() <= 0) ? 0L : eVar.yl();
                        boolean z4 = yl > 0;
                        long j = xT + yl;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.agP.getString(i.h.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.yo();
                            eVar.ym();
                            if (yl == 1) {
                                yd = eVar.yo();
                                str = eVar.ym();
                                yc = String.valueOf(yd) + "：" + str;
                            } else if (xT == 1) {
                                yd = eVar.yd();
                                yc = eVar.yc();
                                str = yc;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.agP.getString(i.h.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yc)) {
                                yc = str;
                            }
                            a(16, yd, str, yc, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> yv = eVar.yv();
                        if (yv != null && yv.size() != 0) {
                            for (e.b bVar : yv) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.aiu) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> yw = eVar.yw();
                        if (yw != null && yw.size() != 0) {
                            for (e.a aVar : yw) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.aiu) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.xj().xy() && c.xj().xm() > 0) {
                        if (eVar.xU() + eVar.xW() > 0) {
                            if (eVar.xU() > 0 && !wV()) {
                                long xU = eVar.xU() - eVar.xV();
                                if (xU > 0) {
                                    stringBuffer.append(String.format(this.agP.getString(i.h.notify_updates), Long.valueOf(xU)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.xV() > 0) {
                                    z = true;
                                }
                                if (eVar.xW() > 0 || wU()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.agP.getString(i.h.notify_validate), Integer.valueOf(eVar.xW())));
                                } else {
                                    stringBuffer.append(String.format(this.agP.getString(i.h.notify_validate_1), Integer.valueOf(eVar.xW())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.yf(), eVar.yg(), eVar.yg());
                                }
                            }
                            z = false;
                            if (eVar.xW() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yp() > 0 && !wW()) {
                            String format2 = String.format(this.agP.getString(i.h.notify_live), Integer.valueOf(eVar.yp()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.agP, 16);
                    NotificationHelper.cancelNotification(this.agP, 17);
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
            NotificationHelper.showNotification(this.agP, bVar.gid, bVar.title, bVar.content, bVar.aiv, PendingIntent.getService(this.agP, bVar.gid, b, 134217728), false);
            TiebaStatic.log(new aq("c10321").r("obj_type", 1).ae("obj_name", "show"));
        }
    }

    private void a(e.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.agP, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.agP, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.ahb) {
            if (i == 23 && this.agV > 0) {
                e = cW(i);
            } else if (i == 26 && this.agU > 0) {
                e = cX(i);
            } else if (i == 18) {
                e = wP();
            } else {
                e = e(i, z);
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.agP, i, str, str2, str3, PendingIntent.getService(this.agP, i, e, 134217728), false);
        }
    }

    public Intent cW(int i) {
        Intent intent = new Intent(this.agP, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.agV);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cX(int i) {
        Intent intent = new Intent(this.agP, DealIntentService.class);
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
        Intent intent = new Intent(this.agP, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.aiw);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.agP, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.agY.yn().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.agP, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.agR);
        intent.putExtra("reply_me", this.agQ);
        intent.putExtra("fans", this.agU);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.agY.xT() - this.agY.ya());
        intent.putExtra("group_msg_validate", this.agY.xW());
        intent.putExtra("group_msg_updates", this.agY.xU());
        intent.putExtra("live_notify_msg_updates", this.agY.yp());
        intent.putExtra("officialbar_msg", this.agY.xX());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent wP() {
        Intent intent = new Intent(this.agP, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.agY.xV());
        return intent;
    }

    public void wQ() {
        NotificationHelper.cancelNotification(this.agP, 23);
        NotificationHelper.cancelNotification(this.agP, 24);
        NotificationHelper.cancelNotification(this.agP, 25);
        NotificationHelper.cancelNotification(this.agP, 26);
        NotificationHelper.cancelNotification(this.agP, 17);
        NotificationHelper.cancelNotification(this.agP, 15);
        NotificationHelper.cancelNotification(this.agP, 13);
        NotificationHelper.cancelNotification(this.agP, 12);
    }

    public void wR() {
        NotificationHelper.cancelNotification(this.agP, 16);
    }

    public void wS() {
        NotificationHelper.cancelNotification(this.agP, 19);
    }

    public void cY(int i) {
        NotificationHelper.cancelNotification(this.agP, i);
    }

    public int wT() {
        return this.agY.yl();
    }

    public void dW(String str) {
        if (TextUtils.isEmpty(str)) {
            wR();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xh = xh();
        if (xh == null) {
            wR();
            return;
        }
        HashMap<String, String> yh = xh.yh();
        if (yh == null || yh.isEmpty()) {
            wR();
        } else if (yh.containsKey(str)) {
            wR();
        }
    }

    public void dX(String str) {
        if (TextUtils.isEmpty(str)) {
            wR();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xh = xh();
        if (xh == null) {
            wR();
            return;
        }
        HashMap<String, String> yn = xh.yn();
        if (yn == null || yn.isEmpty()) {
            wR();
        } else if (yn.containsKey(str)) {
            wR();
        }
    }

    private boolean wU() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean wV() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean wW() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void wX() {
        NotificationHelper.cancelNotification(this.agP, 17);
    }

    public void cZ(int i) {
        com.baidu.tbadk.coreExtra.d.e xh = xh();
        if (xh == null) {
            wX();
        } else if (1 == i) {
            if (xh.xU() <= 0) {
                wX();
            }
        } else if (2 == i) {
            if (xh.xW() <= 0) {
                wX();
            }
        } else if (3 == i && xh.yp() <= 0) {
            NotificationHelper.cancelNotification(this.agP, 21);
        }
    }

    public void wY() {
        NotificationHelper.cancelNotification(this.agP, 18);
    }

    public void wZ() {
        NotificationHelper.cancelNotification(this.agP, 26);
        NotificationHelper.cancelNotification(this.agP, 25);
        NotificationHelper.cancelNotification(this.agP, 24);
        NotificationHelper.cancelNotification(this.agP, 23);
        NotificationHelper.cancelNotification(this.agP, 16);
        NotificationHelper.cancelNotification(this.agP, 17);
    }

    public void xa() {
        NotificationHelper.cancelNotification(this.agP, 21);
        NotificationHelper.cancelNotification(this.agP, 17);
        NotificationHelper.cancelNotification(this.agP, 19);
        NotificationHelper.cancelNotification(this.agP, 16);
        NotificationHelper.cancelNotification(this.agP, 18);
    }

    public void da(int i) {
        NotificationHelper.cancelNotification(this.agP, i);
    }

    public void xb() {
        NotificationHelper.cancelNotification(this.agP, 24);
    }

    public void xc() {
        NotificationHelper.cancelNotification(this.agP, 25);
    }

    public void xd() {
        NotificationHelper.cancelNotification(this.agP, 23);
    }

    public void xe() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xf());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.agY.yl());
        newsNotifyMessage.setMsgStrangerChat(this.agY.ys());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yl() + eVar.xT()) + eVar.ys()) + eVar.yr()) + eVar.yx()) - eVar.ya());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yl());
            newsNotifyMessage.setMsgStrangerChat(eVar.ys());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.agQ;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.agR, this.agS, this.agU, this.agT, this.agV);
        }
    }

    public int getMsgAtme() {
        return this.agR;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.agQ, i, this.agS, this.agU, this.agT, this.agV);
        }
    }

    public int getMsgChat() {
        return this.agS;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=5] */
    public int xf() {
        return ((((this.agY.yl() + this.agY.xT()) + this.agY.ys()) + this.agY.yr()) + this.agY.yx()) - this.agY.ya();
    }

    public int getMsgFans() {
        return this.agU;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.agQ, this.agR, this.agS, i, this.agT, this.agV);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.agQ, this.agR, i, this.agU, this.agT, this.agV);
        }
    }

    public int getMsgBookmark() {
        return this.agT;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.agQ, this.agR, this.agS, this.agU, i, this.agV);
        }
    }

    public int getMsgGiftNum() {
        return this.agV;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.agV = i;
        }
    }

    public void db(int i) {
        if (i >= 0) {
            this.agW += i;
            xe();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.agW = i;
            xe();
        }
    }

    public int getMsgLiveVip() {
        return this.agW;
    }

    public void ay(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.agQ = 0;
        this.agR = 0;
        this.agS = 0;
        this.agU = 0;
        this.agT = 0;
    }

    public int xg() {
        return this.agQ + this.agR + this.agS + this.agU + this.agV;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int xX;
        int i = 0;
        if (eVar != null) {
            this.agY = eVar;
            this.agS = (eVar.xT() - eVar.ya()) + eVar.yl() + eVar.yr() + eVar.yx();
            a(eVar);
            if (eVar.yb()) {
                this.agZ = null;
                mHandler.removeMessages(0);
            }
            if (eVar.yb()) {
                if (c.xj().xy() && c.xj().xm() > 0) {
                    i = eVar.xT() - eVar.ya();
                }
                if (c.xj().xr() && c.xj().xm() > 0) {
                    boolean xA = c.xj().xA();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yl();
                    } else if (isFloatingWindowOpened) {
                        if (!xA || isProcessBackground) {
                            j = eVar.yl();
                        }
                    } else {
                        j = eVar.yl();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.ye() - eVar.ya() && i > 0) || j > eVar.xY())) {
                        a(1, 16, eVar);
                    }
                    xX = eVar.xX();
                    if (xX > 0 && xX > eVar.yk()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.xU() <= eVar.yi() || eVar.xW() > eVar.yj()) {
                        if (eVar.xU() > eVar.yi() || eVar.xW() != eVar.yj() || !wV()) {
                            if (eVar.xU() == eVar.yi() || eVar.xW() <= eVar.yj() || !wU()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yp() > eVar.yq() && !wW()) {
                        TiebaStatic.eventStat(this.agP, "message_broadcast_receive", "");
                        a(1, 21, eVar);
                    }
                    if (eVar.yt() <= eVar.yu()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                xX = eVar.xX();
                if (xX > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.xU() <= eVar.yi()) {
                }
                if (eVar.xU() > eVar.yi()) {
                }
                if (eVar.xU() == eVar.yi()) {
                }
                a(1, 17, eVar);
                if (eVar.yp() > eVar.yq()) {
                    TiebaStatic.eventStat(this.agP, "message_broadcast_receive", "");
                    a(1, 21, eVar);
                }
                if (eVar.yt() <= eVar.yu()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xh() {
        return this.agY;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.agY = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xi() {
        return this.agZ;
    }
}
