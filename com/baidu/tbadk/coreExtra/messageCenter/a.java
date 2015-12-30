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
import com.baidu.tieba.n;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ajP;
    private static Date ajS = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e ajR;
    private String ajU;
    private String ajV;
    private int ajI = 0;
    private int ajJ = 0;
    private int ajK = 0;
    private int ajL = 0;
    private int ajM = 0;
    private int ajN = 0;
    private int ajO = 0;
    private com.baidu.tbadk.coreExtra.d.e ajQ = new com.baidu.tbadk.coreExtra.d.e();
    private boolean ajT = true;
    private final int[] ajW = new int[10];
    private final Context ajH = TbadkCoreApplication.m411getInst().getApp();

    public static a xv() {
        if (ajP == null) {
            ajP = new a();
        }
        return ajP;
    }

    private a() {
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.ajU = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.ajU = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.ajV = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.ajI || i2 != this.ajJ || i3 != this.ajK || i4 != this.ajM || i5 != this.ajL || i6 != this.ajN) {
            if (i > this.ajI || i2 > this.ajJ || i3 > this.ajK || i4 > this.ajM || i5 > this.ajL || i6 > this.ajN) {
                i7 = 1;
            } else {
                i7 = (i < this.ajI || i2 < this.ajJ) ? 2 : 0;
            }
            if (i > this.ajI) {
                i8 = 1;
            } else {
                i8 = i < this.ajI ? 2 : 0;
            }
            if (i2 > this.ajJ) {
                i9 = 1;
            } else {
                i9 = i2 < this.ajJ ? 2 : 0;
            }
            int i11 = i3 > this.ajK ? 1 : 0;
            int i12 = i4 > this.ajM ? 1 : 0;
            int i13 = i6 <= this.ajN ? 0 : 1;
            this.ajI = i;
            this.ajJ = i2;
            this.ajK = i3;
            this.ajM = i4;
            this.ajL = i5;
            this.ajN = i6;
            if (xP() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xN();
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
        if (i != this.ajI || i2 != this.ajJ || i3 != this.ajK || i4 != this.ajM || this.ajN != i5) {
            this.ajI = i;
            this.ajJ = i2;
            this.ajK = i3;
            this.ajM = i4;
            this.ajN = i5;
            xN();
            if (xP() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean xw() {
        if (ajS == null) {
            ajS = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - ajS.getTime() < 10000) {
                return false;
            }
            ajS = date;
        }
        return true;
    }

    public static boolean xx() {
        if (c.xS().yd()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xS().yf().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xS().yg().split(":");
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
                    if (this.ajN > 0) {
                        String format = String.format(this.ajH.getString(n.j.notify_gift), String.valueOf(this.ajN));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.ajI > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.ajI > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.ajI));
                            sb.append(this.ajH.getString(n.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.ajU != null) {
                            sb.append(this.ajU);
                        } else {
                            sb.append(this.ajH.getString(n.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ajJ > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ajJ > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ajJ));
                            sb2.append(this.ajH.getString(n.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.ajV != null) {
                            sb2.append(this.ajV);
                        } else {
                            sb2.append(this.ajH.getString(n.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ajM > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ajM > 1) {
                            sb3.append(String.format(this.ajH.getString(n.j.notify_fans_unit), Integer.valueOf(this.ajM)));
                        }
                        sb3.append(this.ajH.getString(n.j.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xS().yh()) {
                    c.xS().xV();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ajH, 16);
                NotificationHelper.cancelNotification(this.ajH, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0305 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:97:0x024e, B:99:0x0254, B:101:0x025a, B:102:0x025e, B:104:0x0264, B:106:0x026c, B:108:0x0274, B:110:0x0278, B:112:0x027e, B:113:0x0284, B:115:0x028e, B:117:0x0298, B:119:0x02a3, B:121:0x02a9, B:123:0x02af, B:125:0x02bd, B:126:0x02d8, B:128:0x02de, B:131:0x02e6, B:133:0x0305, B:135:0x0315, B:144:0x035d, B:141:0x0354, B:136:0x0326, B:138:0x032c, B:140:0x0332, B:147:0x037e), top: B:154:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0315 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:97:0x024e, B:99:0x0254, B:101:0x025a, B:102:0x025e, B:104:0x0264, B:106:0x026c, B:108:0x0274, B:110:0x0278, B:112:0x027e, B:113:0x0284, B:115:0x028e, B:117:0x0298, B:119:0x02a3, B:121:0x02a9, B:123:0x02af, B:125:0x02bd, B:126:0x02d8, B:128:0x02de, B:131:0x02e6, B:133:0x0305, B:135:0x0315, B:144:0x035d, B:141:0x0354, B:136:0x0326, B:138:0x032c, B:140:0x0332, B:147:0x037e), top: B:154:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.d.e eVar) {
        boolean z;
        String yL;
        String yK;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ajN > 0) {
                            String format = String.format(this.ajH.getString(n.j.notify_gift), String.valueOf(this.ajN));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.ajI > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.ajI > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.ajI));
                                sb.append(this.ajH.getString(n.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.ajU != null) {
                                sb.append(this.ajU);
                            } else {
                                sb.append(this.ajH.getString(n.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ajJ > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ajJ > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ajJ));
                                sb2.append(this.ajH.getString(n.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.ajV != null) {
                                sb2.append(this.ajV);
                            } else {
                                sb2.append(this.ajH.getString(n.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ajM > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ajM > 1) {
                                sb3.append(String.format(this.ajH.getString(n.j.notify_fans_unit), Integer.valueOf(this.ajM)));
                            }
                            sb3.append(this.ajH.getString(n.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int yB = (!c.xS().yh() || c.xS().xV() <= 0) ? 0 : eVar.yB() - eVar.yI();
                        long yT = (!c.xS().ya() || c.xS().xV() <= 0) ? 0L : eVar.yT();
                        boolean z4 = yT > 0;
                        long j = yB + yT;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ajH.getString(n.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.yW();
                            eVar.yU();
                            if (yT == 1) {
                                yL = eVar.yW();
                                str = eVar.yU();
                                yK = String.valueOf(yL) + "：" + str;
                            } else if (yB == 1) {
                                yL = eVar.yL();
                                yK = eVar.yK();
                                str = yK;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ajH.getString(n.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yK)) {
                                yK = str;
                            }
                            a(16, yL, str, yK, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> zd = eVar.zd();
                        if (zd != null && zd.size() != 0) {
                            for (e.b bVar : zd) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.aln) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> ze = eVar.ze();
                        if (ze != null && ze.size() != 0) {
                            for (e.a aVar : ze) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.aln) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.xS().yh() && c.xS().xV() > 0) {
                        if (eVar.yC() + eVar.yE() > 0) {
                            if (eVar.yC() > 0 && !xE()) {
                                long yC = eVar.yC() - eVar.yD();
                                if (yC > 0) {
                                    stringBuffer.append(String.format(this.ajH.getString(n.j.notify_updates), Long.valueOf(yC)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.yD() > 0) {
                                    z = true;
                                }
                                if (eVar.yE() > 0 || xD()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ajH.getString(n.j.notify_validate), Integer.valueOf(eVar.yE())));
                                } else {
                                    stringBuffer.append(String.format(this.ajH.getString(n.j.notify_validate_1), Integer.valueOf(eVar.yE())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.yN(), eVar.yO(), eVar.yO());
                                }
                            }
                            z = false;
                            if (eVar.yE() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yX() > 0 && !xF()) {
                            String format2 = String.format(this.ajH.getString(n.j.notify_live), Integer.valueOf(eVar.yX()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ajH, 16);
                    NotificationHelper.cancelNotification(this.ajH, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ajH, bVar.gid, a, 134217728);
            E(dk(i), i);
            NotificationHelper.showNotification(this.ajH, i, bVar.title, bVar.content, bVar.alo, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ajH, aVar.gid, a, 134217728);
            E(dk(i), i);
            NotificationHelper.showNotification(this.ajH, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.ajT) {
            if (i == 23 && this.ajN > 0) {
                e = de(i);
            } else if (i == 26 && this.ajM > 0) {
                e = df(i);
            } else if (i == 18) {
                e = xy();
            } else {
                e = e(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            e.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ajH, i, e, 134217728);
            E(dk(i), i);
            NotificationHelper.showNotification(this.ajH, i, str, str2, str3, service, false);
        }
    }

    public Intent de(int i) {
        Intent intent = new Intent(this.ajH, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ajN);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent df(int i) {
        Intent intent = new Intent(this.ajH, DealIntentService.class);
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
        Intent intent = new Intent(this.ajH, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.alp);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ajH, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.ajQ.yV().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ajH, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.ajJ);
        intent.putExtra("reply_me", this.ajI);
        intent.putExtra("fans", this.ajM);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.ajQ.yB() - this.ajQ.yI());
        intent.putExtra("group_msg_validate", this.ajQ.yE());
        intent.putExtra("group_msg_updates", this.ajQ.yC());
        intent.putExtra("live_notify_msg_updates", this.ajQ.yX());
        intent.putExtra("officialbar_msg", this.ajQ.yF());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent xy() {
        Intent intent = new Intent(this.ajH, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.ajQ.yD());
        return intent;
    }

    public void xz() {
        NotificationHelper.cancelNotification(this.ajH, 23);
        NotificationHelper.cancelNotification(this.ajH, 24);
        NotificationHelper.cancelNotification(this.ajH, 25);
        NotificationHelper.cancelNotification(this.ajH, 26);
        NotificationHelper.cancelNotification(this.ajH, 17);
        NotificationHelper.cancelNotification(this.ajH, 15);
        NotificationHelper.cancelNotification(this.ajH, 13);
        NotificationHelper.cancelNotification(this.ajH, 12);
    }

    public void xA() {
        NotificationHelper.cancelNotification(this.ajH, 16);
    }

    public void xB() {
        NotificationHelper.cancelNotification(this.ajH, 19);
    }

    public void dg(int i) {
        NotificationHelper.cancelNotification(this.ajH, i);
    }

    public int xC() {
        return this.ajQ.za();
    }

    public void ei(String str) {
        if (TextUtils.isEmpty(str)) {
            xA();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xQ = xQ();
        if (xQ == null) {
            xA();
            return;
        }
        HashMap<String, String> yP = xQ.yP();
        if (yP == null || yP.isEmpty()) {
            xA();
        } else if (yP.containsKey(str)) {
            xA();
        }
    }

    public void ej(String str) {
        if (TextUtils.isEmpty(str)) {
            xA();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xQ = xQ();
        if (xQ == null) {
            xA();
            return;
        }
        HashMap<String, String> yV = xQ.yV();
        if (yV == null || yV.isEmpty()) {
            xA();
        } else if (yV.containsKey(str)) {
            xA();
        }
    }

    private boolean xD() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xE() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xF() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xG() {
        NotificationHelper.cancelNotification(this.ajH, 17);
    }

    public void dh(int i) {
        com.baidu.tbadk.coreExtra.d.e xQ = xQ();
        if (xQ == null) {
            xG();
        } else if (1 == i) {
            if (xQ.yC() <= 0) {
                xG();
            }
        } else if (2 == i) {
            if (xQ.yE() <= 0) {
                xG();
            }
        } else if (3 == i && xQ.yX() <= 0) {
            NotificationHelper.cancelNotification(this.ajH, 21);
        }
    }

    public void xH() {
        NotificationHelper.cancelNotification(this.ajH, 18);
    }

    public void xI() {
        NotificationHelper.cancelNotification(this.ajH, 26);
        NotificationHelper.cancelNotification(this.ajH, 25);
        NotificationHelper.cancelNotification(this.ajH, 24);
        NotificationHelper.cancelNotification(this.ajH, 23);
        NotificationHelper.cancelNotification(this.ajH, 16);
        NotificationHelper.cancelNotification(this.ajH, 17);
    }

    public void xJ() {
        NotificationHelper.cancelNotification(this.ajH, 21);
        NotificationHelper.cancelNotification(this.ajH, 17);
        NotificationHelper.cancelNotification(this.ajH, 19);
        NotificationHelper.cancelNotification(this.ajH, 16);
        NotificationHelper.cancelNotification(this.ajH, 18);
    }

    public void di(int i) {
        NotificationHelper.cancelNotification(this.ajH, i);
    }

    public void xK() {
        NotificationHelper.cancelNotification(this.ajH, 24);
    }

    public void xL() {
        NotificationHelper.cancelNotification(this.ajH, 25);
    }

    public void xM() {
        NotificationHelper.cancelNotification(this.ajH, 23);
    }

    public void xN() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xO());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.ajQ.yT());
        newsNotifyMessage.setMsgStrangerChat(this.ajQ.za());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yT() + eVar.yB()) + eVar.za()) + eVar.yZ()) + eVar.zf()) - eVar.yI());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yT());
            newsNotifyMessage.setMsgStrangerChat(eVar.za());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.ajI;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.ajJ, this.ajK, this.ajM, this.ajL, this.ajN);
        }
    }

    public int getMsgAtme() {
        return this.ajJ;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.ajI, i, this.ajK, this.ajM, this.ajL, this.ajN);
        }
    }

    public int getMsgChat() {
        return this.ajK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1020=5] */
    public int xO() {
        return ((((this.ajQ.yT() + this.ajQ.yB()) + this.ajQ.za()) + this.ajQ.yZ()) + this.ajQ.zf()) - this.ajQ.yI();
    }

    public int getMsgFans() {
        return this.ajM;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.ajI, this.ajJ, this.ajK, i, this.ajL, this.ajN);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.ajI, this.ajJ, i, this.ajM, this.ajL, this.ajN);
        }
    }

    public int getMsgBookmark() {
        return this.ajL;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.ajI, this.ajJ, this.ajK, this.ajM, i, this.ajN);
        }
    }

    public int getMsgGiftNum() {
        return this.ajN;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ajN = i;
        }
    }

    public void dj(int i) {
        if (i >= 0) {
            this.ajO += i;
            xN();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.ajO = i;
            xN();
        }
    }

    public int getMsgLiveVip() {
        return this.ajO;
    }

    public void aA(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.ajI = 0;
        this.ajJ = 0;
        this.ajK = 0;
        this.ajM = 0;
        this.ajL = 0;
    }

    public int xP() {
        return this.ajI + this.ajJ + this.ajK + this.ajM + this.ajN;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int yF;
        int i = 0;
        if (eVar != null) {
            this.ajQ = eVar;
            this.ajK = (eVar.yB() - eVar.yI()) + eVar.yT() + eVar.yZ() + eVar.zf();
            a(eVar);
            if (eVar.yJ()) {
                this.ajR = null;
                mHandler.removeMessages(0);
            }
            if (eVar.yJ()) {
                if (c.xS().yh() && c.xS().xV() > 0) {
                    i = eVar.yB() - eVar.yI();
                }
                if (c.xS().ya() && c.xS().xV() > 0) {
                    boolean yj = c.xS().yj();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yT();
                    } else if (isFloatingWindowOpened) {
                        if (!yj || isProcessBackground) {
                            j = eVar.yT();
                        }
                    } else {
                        j = eVar.yT();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.yM() - eVar.yI() && i > 0) || j > eVar.yG())) {
                        a(1, 16, eVar);
                    }
                    yF = eVar.yF();
                    if (yF > 0 && yF > eVar.yS()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.yC() <= eVar.yQ() || eVar.yE() > eVar.yR()) {
                        if (eVar.yC() > eVar.yQ() || eVar.yE() != eVar.yR() || !xE()) {
                            if (eVar.yC() == eVar.yQ() || eVar.yE() <= eVar.yR() || !xD()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yX() > eVar.yY() && !xF()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.zb() <= eVar.zc()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                yF = eVar.yF();
                if (yF > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.yC() <= eVar.yQ()) {
                }
                if (eVar.yC() > eVar.yQ()) {
                }
                if (eVar.yC() == eVar.yQ()) {
                }
                a(1, 17, eVar);
                if (eVar.yX() > eVar.yY()) {
                    a(1, 21, eVar);
                }
                if (eVar.zb() <= eVar.zc()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xQ() {
        return this.ajQ;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.ajQ = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xR() {
        return this.ajR;
    }

    public int dk(int i) {
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

    public void E(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ajH, 26, i2);
        }
    }
}
