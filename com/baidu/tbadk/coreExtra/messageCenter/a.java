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
    private static a aiJ;
    private static Date aiM = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e aiL;
    private String aiO;
    private String aiP;
    private int aiC = 0;
    private int aiD = 0;
    private int aiE = 0;
    private int aiF = 0;
    private int aiG = 0;
    private int aiH = 0;
    private int aiI = 0;
    private com.baidu.tbadk.coreExtra.d.e aiK = new com.baidu.tbadk.coreExtra.d.e();
    private boolean aiN = true;
    private final int[] aiQ = new int[10];
    private final Context aiB = TbadkCoreApplication.m411getInst().getApp();

    public static a xJ() {
        if (aiJ == null) {
            aiJ = new a();
        }
        return aiJ;
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
                    this.aiO = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aiO = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aiP = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.aiC || i2 != this.aiD || i3 != this.aiE || i4 != this.aiG || i5 != this.aiF || i6 != this.aiH) {
            if (i > this.aiC || i2 > this.aiD || i3 > this.aiE || i4 > this.aiG || i5 > this.aiF || i6 > this.aiH) {
                i7 = 1;
            } else {
                i7 = (i < this.aiC || i2 < this.aiD) ? 2 : 0;
            }
            if (i > this.aiC) {
                i8 = 1;
            } else {
                i8 = i < this.aiC ? 2 : 0;
            }
            if (i2 > this.aiD) {
                i9 = 1;
            } else {
                i9 = i2 < this.aiD ? 2 : 0;
            }
            int i11 = i3 > this.aiE ? 1 : 0;
            int i12 = i4 > this.aiG ? 1 : 0;
            int i13 = i6 <= this.aiH ? 0 : 1;
            this.aiC = i;
            this.aiD = i2;
            this.aiE = i3;
            this.aiG = i4;
            this.aiF = i5;
            this.aiH = i6;
            if (yd() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yb();
                E(i10, 23);
                E(i11, 16);
                E(i7, 17);
                E(i8, 24);
                E(i9, 25);
                E(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.aiC || i2 != this.aiD || i3 != this.aiE || i4 != this.aiG || this.aiH != i5) {
            this.aiC = i;
            this.aiD = i2;
            this.aiE = i3;
            this.aiG = i4;
            this.aiH = i5;
            yb();
            if (yd() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean xK() {
        if (aiM == null) {
            aiM = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aiM.getTime() < 10000) {
                return false;
            }
            aiM = date;
        }
        return true;
    }

    public static boolean xL() {
        if (c.yg().yr()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.yg().yt().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.yg().yu().split(":");
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

    private void E(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.aiH > 0) {
                        String format = String.format(this.aiB.getString(n.i.notify_gift), String.valueOf(this.aiH));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.aiC > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aiC > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.aiC));
                            sb.append(this.aiB.getString(n.i.notify_unit));
                            sb.append("]");
                        }
                        if (this.aiO != null) {
                            sb.append(this.aiO);
                        } else {
                            sb.append(this.aiB.getString(n.i.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aiD > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aiD > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aiD));
                            sb2.append(this.aiB.getString(n.i.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aiP != null) {
                            sb2.append(this.aiP);
                        } else {
                            sb2.append(this.aiB.getString(n.i.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aiG > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aiG > 1) {
                            sb3.append(String.format(this.aiB.getString(n.i.notify_fans_unit), Integer.valueOf(this.aiG)));
                        }
                        sb3.append(this.aiB.getString(n.i.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.yg().yv()) {
                    c.yg().yj();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aiB, 16);
                NotificationHelper.cancelNotification(this.aiB, 17);
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
        String yZ;
        String yY;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aiH > 0) {
                            String format = String.format(this.aiB.getString(n.i.notify_gift), String.valueOf(this.aiH));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.aiC > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aiC > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aiC));
                                sb.append(this.aiB.getString(n.i.notify_unit));
                                sb.append("]");
                            }
                            if (this.aiO != null) {
                                sb.append(this.aiO);
                            } else {
                                sb.append(this.aiB.getString(n.i.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aiD > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aiD > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aiD));
                                sb2.append(this.aiB.getString(n.i.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aiP != null) {
                                sb2.append(this.aiP);
                            } else {
                                sb2.append(this.aiB.getString(n.i.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aiG > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aiG > 1) {
                                sb3.append(String.format(this.aiB.getString(n.i.notify_fans_unit), Integer.valueOf(this.aiG)));
                            }
                            sb3.append(this.aiB.getString(n.i.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int yP = (!c.yg().yv() || c.yg().yj() <= 0) ? 0 : eVar.yP() - eVar.yW();
                        long zh = (!c.yg().yo() || c.yg().yj() <= 0) ? 0L : eVar.zh();
                        boolean z4 = zh > 0;
                        long j = yP + zh;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aiB.getString(n.i.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.zk();
                            eVar.zi();
                            if (zh == 1) {
                                yZ = eVar.zk();
                                str = eVar.zi();
                                yY = String.valueOf(yZ) + "：" + str;
                            } else if (yP == 1) {
                                yZ = eVar.yZ();
                                yY = eVar.yY();
                                str = yY;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aiB.getString(n.i.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yY)) {
                                yY = str;
                            }
                            a(16, yZ, str, yY, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> zr = eVar.zr();
                        if (zr != null && zr.size() != 0) {
                            for (e.b bVar : zr) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.akh) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> zs = eVar.zs();
                        if (zs != null && zs.size() != 0) {
                            for (e.a aVar : zs) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.akh) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.yg().yv() && c.yg().yj() > 0) {
                        if (eVar.yQ() + eVar.yS() > 0) {
                            if (eVar.yQ() > 0 && !xS()) {
                                long yQ = eVar.yQ() - eVar.yR();
                                if (yQ > 0) {
                                    stringBuffer.append(String.format(this.aiB.getString(n.i.notify_updates), Long.valueOf(yQ)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.yR() > 0) {
                                    z = true;
                                }
                                if (eVar.yS() > 0 || xR()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.aiB.getString(n.i.notify_validate), Integer.valueOf(eVar.yS())));
                                } else {
                                    stringBuffer.append(String.format(this.aiB.getString(n.i.notify_validate_1), Integer.valueOf(eVar.yS())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zb(), eVar.zc(), eVar.zc());
                                }
                            }
                            z = false;
                            if (eVar.yS() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.zl() > 0 && !xT()) {
                            String format2 = String.format(this.aiB.getString(n.i.notify_live), Integer.valueOf(eVar.zl()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aiB, 16);
                    NotificationHelper.cancelNotification(this.aiB, 17);
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
            NotificationHelper.showNotification(this.aiB, bVar.gid, bVar.title, bVar.content, bVar.aki, PendingIntent.getService(this.aiB, bVar.gid, b, 134217728), false);
        }
    }

    private void a(e.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.aiB, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.aiB, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.aiN) {
            if (i == 23 && this.aiH > 0) {
                e = dl(i);
            } else if (i == 26 && this.aiG > 0) {
                e = dm(i);
            } else if (i == 18) {
                e = xM();
            } else {
                e = e(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.aiB, i, str, str2, str3, PendingIntent.getService(this.aiB, i, e, 134217728), false);
        }
    }

    public Intent dl(int i) {
        Intent intent = new Intent(this.aiB, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aiH);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dm(int i) {
        Intent intent = new Intent(this.aiB, DealIntentService.class);
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
        Intent intent = new Intent(this.aiB, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.akj);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aiB, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aiK.zj().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aiB, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.aiD);
        intent.putExtra("reply_me", this.aiC);
        intent.putExtra("fans", this.aiG);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aiK.yP() - this.aiK.yW());
        intent.putExtra("group_msg_validate", this.aiK.yS());
        intent.putExtra("group_msg_updates", this.aiK.yQ());
        intent.putExtra("live_notify_msg_updates", this.aiK.zl());
        intent.putExtra("officialbar_msg", this.aiK.yT());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent xM() {
        Intent intent = new Intent(this.aiB, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aiK.yR());
        return intent;
    }

    public void xN() {
        NotificationHelper.cancelNotification(this.aiB, 23);
        NotificationHelper.cancelNotification(this.aiB, 24);
        NotificationHelper.cancelNotification(this.aiB, 25);
        NotificationHelper.cancelNotification(this.aiB, 26);
        NotificationHelper.cancelNotification(this.aiB, 17);
        NotificationHelper.cancelNotification(this.aiB, 15);
        NotificationHelper.cancelNotification(this.aiB, 13);
        NotificationHelper.cancelNotification(this.aiB, 12);
    }

    public void xO() {
        NotificationHelper.cancelNotification(this.aiB, 16);
    }

    public void xP() {
        NotificationHelper.cancelNotification(this.aiB, 19);
    }

    public void dn(int i) {
        NotificationHelper.cancelNotification(this.aiB, i);
    }

    public int xQ() {
        return this.aiK.zo();
    }

    public void ef(String str) {
        if (TextUtils.isEmpty(str)) {
            xO();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e ye = ye();
        if (ye == null) {
            xO();
            return;
        }
        HashMap<String, String> zd = ye.zd();
        if (zd == null || zd.isEmpty()) {
            xO();
        } else if (zd.containsKey(str)) {
            xO();
        }
    }

    public void eg(String str) {
        if (TextUtils.isEmpty(str)) {
            xO();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e ye = ye();
        if (ye == null) {
            xO();
            return;
        }
        HashMap<String, String> zj = ye.zj();
        if (zj == null || zj.isEmpty()) {
            xO();
        } else if (zj.containsKey(str)) {
            xO();
        }
    }

    private boolean xR() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xS() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xT() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xU() {
        NotificationHelper.cancelNotification(this.aiB, 17);
    }

    public void dp(int i) {
        com.baidu.tbadk.coreExtra.d.e ye = ye();
        if (ye == null) {
            xU();
        } else if (1 == i) {
            if (ye.yQ() <= 0) {
                xU();
            }
        } else if (2 == i) {
            if (ye.yS() <= 0) {
                xU();
            }
        } else if (3 == i && ye.zl() <= 0) {
            NotificationHelper.cancelNotification(this.aiB, 21);
        }
    }

    public void xV() {
        NotificationHelper.cancelNotification(this.aiB, 18);
    }

    public void xW() {
        NotificationHelper.cancelNotification(this.aiB, 26);
        NotificationHelper.cancelNotification(this.aiB, 25);
        NotificationHelper.cancelNotification(this.aiB, 24);
        NotificationHelper.cancelNotification(this.aiB, 23);
        NotificationHelper.cancelNotification(this.aiB, 16);
        NotificationHelper.cancelNotification(this.aiB, 17);
    }

    public void xX() {
        NotificationHelper.cancelNotification(this.aiB, 21);
        NotificationHelper.cancelNotification(this.aiB, 17);
        NotificationHelper.cancelNotification(this.aiB, 19);
        NotificationHelper.cancelNotification(this.aiB, 16);
        NotificationHelper.cancelNotification(this.aiB, 18);
    }

    public void dq(int i) {
        NotificationHelper.cancelNotification(this.aiB, i);
    }

    public void xY() {
        NotificationHelper.cancelNotification(this.aiB, 24);
    }

    public void xZ() {
        NotificationHelper.cancelNotification(this.aiB, 25);
    }

    public void ya() {
        NotificationHelper.cancelNotification(this.aiB, 23);
    }

    public void yb() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yc());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.aiK.zh());
        newsNotifyMessage.setMsgStrangerChat(this.aiK.zo());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zh() + eVar.yP()) + eVar.zo()) + eVar.zn()) + eVar.zt()) - eVar.yW());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zh());
            newsNotifyMessage.setMsgStrangerChat(eVar.zo());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aiC;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.aiD, this.aiE, this.aiG, this.aiF, this.aiH);
        }
    }

    public int getMsgAtme() {
        return this.aiD;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aiC, i, this.aiE, this.aiG, this.aiF, this.aiH);
        }
    }

    public int getMsgChat() {
        return this.aiE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1008=5] */
    public int yc() {
        return ((((this.aiK.zh() + this.aiK.yP()) + this.aiK.zo()) + this.aiK.zn()) + this.aiK.zt()) - this.aiK.yW();
    }

    public int getMsgFans() {
        return this.aiG;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aiC, this.aiD, this.aiE, i, this.aiF, this.aiH);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aiC, this.aiD, i, this.aiG, this.aiF, this.aiH);
        }
    }

    public int getMsgBookmark() {
        return this.aiF;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aiC, this.aiD, this.aiE, this.aiG, i, this.aiH);
        }
    }

    public int getMsgGiftNum() {
        return this.aiH;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aiH = i;
        }
    }

    public void dr(int i) {
        if (i >= 0) {
            this.aiI += i;
            yb();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.aiI = i;
            yb();
        }
    }

    public int getMsgLiveVip() {
        return this.aiI;
    }

    public void aD(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.aiC = 0;
        this.aiD = 0;
        this.aiE = 0;
        this.aiG = 0;
        this.aiF = 0;
    }

    public int yd() {
        return this.aiC + this.aiD + this.aiE + this.aiG + this.aiH;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int yT;
        int i = 0;
        if (eVar != null) {
            this.aiK = eVar;
            this.aiE = (eVar.yP() - eVar.yW()) + eVar.zh() + eVar.zn() + eVar.zt();
            a(eVar);
            if (eVar.yX()) {
                this.aiL = null;
                mHandler.removeMessages(0);
            }
            if (eVar.yX()) {
                if (c.yg().yv() && c.yg().yj() > 0) {
                    i = eVar.yP() - eVar.yW();
                }
                if (c.yg().yo() && c.yg().yj() > 0) {
                    boolean yx = c.yg().yx();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.zh();
                    } else if (isFloatingWindowOpened) {
                        if (!yx || isProcessBackground) {
                            j = eVar.zh();
                        }
                    } else {
                        j = eVar.zh();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.za() - eVar.yW() && i > 0) || j > eVar.yU())) {
                        a(1, 16, eVar);
                    }
                    yT = eVar.yT();
                    if (yT > 0 && yT > eVar.zg()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.yQ() <= eVar.ze() || eVar.yS() > eVar.zf()) {
                        if (eVar.yQ() > eVar.ze() || eVar.yS() != eVar.zf() || !xS()) {
                            if (eVar.yQ() == eVar.ze() || eVar.yS() <= eVar.zf() || !xR()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.zl() > eVar.zm() && !xT()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.zp() <= eVar.zq()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                yT = eVar.yT();
                if (yT > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.yQ() <= eVar.ze()) {
                }
                if (eVar.yQ() > eVar.ze()) {
                }
                if (eVar.yQ() == eVar.ze()) {
                }
                a(1, 17, eVar);
                if (eVar.zl() > eVar.zm()) {
                    a(1, 21, eVar);
                }
                if (eVar.zp() <= eVar.zq()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e ye() {
        return this.aiK;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.aiK = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e yf() {
        return this.aiL;
    }
}
