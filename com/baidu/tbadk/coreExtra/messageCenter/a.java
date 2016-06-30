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
import com.baidu.tieba.u;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ahn;
    private static Date ahq = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e ahp;
    private String ahs;
    private String aht;
    private int ahg = 0;
    private int ahh = 0;
    private int ahi = 0;
    private int ahj = 0;
    private int ahk = 0;
    private int ahl = 0;
    private int ahm = 0;
    private com.baidu.tbadk.coreExtra.d.e aho = new com.baidu.tbadk.coreExtra.d.e();
    private boolean ahr = true;
    private final int[] ahu = new int[10];
    private final Context ahf = TbadkCoreApplication.m9getInst().getApp();

    public static a xn() {
        if (ahn == null) {
            ahn = new a();
        }
        return ahn;
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
                    this.ahs = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.ahs = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aht = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.ahg || i2 != this.ahh || i3 != this.ahi || i4 != this.ahk || i5 != this.ahj || i6 != this.ahl) {
            if (i > this.ahg || i2 > this.ahh || i3 > this.ahi || i4 > this.ahk || i5 > this.ahj || i6 > this.ahl) {
                i7 = 1;
            } else {
                i7 = (i < this.ahg || i2 < this.ahh) ? 2 : 0;
            }
            if (i > this.ahg) {
                i8 = 1;
            } else {
                i8 = i < this.ahg ? 2 : 0;
            }
            if (i2 > this.ahh) {
                i9 = 1;
            } else {
                i9 = i2 < this.ahh ? 2 : 0;
            }
            int i11 = i3 > this.ahi ? 1 : 0;
            int i12 = i4 > this.ahk ? 1 : 0;
            int i13 = i6 <= this.ahl ? 0 : 1;
            this.ahg = i;
            this.ahh = i2;
            this.ahi = i3;
            this.ahk = i4;
            this.ahj = i5;
            this.ahl = i6;
            if (xH() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xF();
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
        if (i != this.ahg || i2 != this.ahh || i3 != this.ahi || i4 != this.ahk || this.ahl != i5) {
            this.ahg = i;
            this.ahh = i2;
            this.ahi = i3;
            this.ahk = i4;
            this.ahl = i5;
            xF();
            if (xH() <= 0) {
                w(2, 16);
                w(2, 17);
            }
        }
    }

    public static boolean xo() {
        if (ahq == null) {
            ahq = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - ahq.getTime() < 10000) {
                return false;
            }
            ahq = date;
        }
        return true;
    }

    public static boolean xp() {
        if (c.xK().xV()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xK().xX().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xK().xY().split(":");
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
                    if (this.ahl > 0) {
                        String format = String.format(this.ahf.getString(u.j.notify_gift), String.valueOf(this.ahl));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.ahg > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.ahg > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.ahg));
                            sb.append(this.ahf.getString(u.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.ahs != null) {
                            sb.append(this.ahs);
                        } else {
                            sb.append(this.ahf.getString(u.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ahh > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ahh > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ahh));
                            sb2.append(this.ahf.getString(u.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aht != null) {
                            sb2.append(this.aht);
                        } else {
                            sb2.append(this.ahf.getString(u.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ahk > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ahk > 1) {
                            sb3.append(String.format(this.ahf.getString(u.j.notify_fans_unit), Integer.valueOf(this.ahk)));
                        }
                        sb3.append(this.ahf.getString(u.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xK().xZ()) {
                    c.xK().xN();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ahf, 16);
                NotificationHelper.cancelNotification(this.ahf, 17);
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
        String yF;
        String yE;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ahl > 0) {
                            String format = String.format(this.ahf.getString(u.j.notify_gift), String.valueOf(this.ahl));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.ahg > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.ahg > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.ahg));
                                sb.append(this.ahf.getString(u.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.ahs != null) {
                                sb.append(this.ahs);
                            } else {
                                sb.append(this.ahf.getString(u.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ahh > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ahh > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ahh));
                                sb2.append(this.ahf.getString(u.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aht != null) {
                                sb2.append(this.aht);
                            } else {
                                sb2.append(this.ahf.getString(u.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ahk > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ahk > 1) {
                                sb3.append(String.format(this.ahf.getString(u.j.notify_fans_unit), Integer.valueOf(this.ahk)));
                            }
                            sb3.append(this.ahf.getString(u.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int yv = (!c.xK().xZ() || c.xK().xN() <= 0) ? 0 : eVar.yv() - eVar.yC();
                        long yN = (!c.xK().xS() || c.xK().xN() <= 0) ? 0L : eVar.yN();
                        boolean z4 = yN > 0;
                        long j = yv + yN;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ahf.getString(u.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.yQ();
                            eVar.yO();
                            if (yN == 1) {
                                yF = eVar.yQ();
                                str = eVar.yO();
                                yE = String.valueOf(yF) + "：" + str;
                            } else if (yv == 1) {
                                yF = eVar.yF();
                                yE = eVar.yE();
                                str = yE;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ahf.getString(u.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yE)) {
                                yE = str;
                            }
                            a(16, yF, str, yE, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> yX = eVar.yX();
                        if (yX != null && yX.size() != 0) {
                            for (e.b bVar : yX) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.aiN != 0 && bVar.unReadCount > bVar.aiO) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> yY = eVar.yY();
                        if (yY != null && yY.size() != 0) {
                            for (e.a aVar : yY) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.aiN != 0 && aVar.unReadCount > aVar.aiO) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.xK().xZ() && c.xK().xN() > 0) {
                        if (eVar.yw() + eVar.yy() > 0) {
                            if (eVar.yw() > 0 && !xw()) {
                                long yw = eVar.yw() - eVar.yx();
                                if (yw > 0) {
                                    stringBuffer.append(String.format(this.ahf.getString(u.j.notify_updates), Long.valueOf(yw)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.yx() > 0) {
                                    z = true;
                                }
                                if (eVar.yy() > 0 || xv()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ahf.getString(u.j.notify_validate), Integer.valueOf(eVar.yy())));
                                } else {
                                    stringBuffer.append(String.format(this.ahf.getString(u.j.notify_validate_1), Integer.valueOf(eVar.yy())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.yH(), eVar.yI(), eVar.yI());
                                }
                            }
                            z = false;
                            if (eVar.yy() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.yR() > 0 && !xx()) {
                            String format2 = String.format(this.ahf.getString(u.j.notify_live), Integer.valueOf(eVar.yR()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ahf, 16);
                    NotificationHelper.cancelNotification(this.ahf, 17);
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
            PendingIntent service = PendingIntent.getService(this.ahf, bVar.aiN, a, 134217728);
            x(dq(i), i);
            NotificationHelper.showNotification(this.ahf, i, bVar.title, bVar.content, bVar.aiP, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ahf, aVar.aiN, a, 134217728);
            x(dq(i), i);
            NotificationHelper.showNotification(this.ahf, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.ahr) {
            if (i == 23 && this.ahl > 0) {
                g = dm(i);
            } else if (i == 26 && this.ahk > 0) {
                g = dn(i);
            } else if (i == 18) {
                g = xq();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ahf, i, g, 134217728);
            x(dq(i), i);
            NotificationHelper.showNotification(this.ahf, i, str, str2, str3, service, false);
        }
    }

    public Intent dm(int i) {
        Intent intent = new Intent(this.ahf, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ahl);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dn(int i) {
        Intent intent = new Intent(this.ahf, DealIntentService.class);
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
        Intent intent = new Intent(this.ahf, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.aiN);
        intent.putExtra("uname", bVar.aiQ);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ahf, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.aiN));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aho.yP().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ahf, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.ahh);
        intent.putExtra("reply_me", this.ahg);
        intent.putExtra("fans", this.ahk);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aho.yv() - this.aho.yC());
        intent.putExtra("group_msg_validate", this.aho.yy());
        intent.putExtra("group_msg_updates", this.aho.yw());
        intent.putExtra("live_notify_msg_updates", this.aho.yR());
        intent.putExtra("officialbar_msg", this.aho.yz());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent xq() {
        Intent intent = new Intent(this.ahf, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aho.yx());
        return intent;
    }

    public void xr() {
        NotificationHelper.cancelNotification(this.ahf, 23);
        NotificationHelper.cancelNotification(this.ahf, 24);
        NotificationHelper.cancelNotification(this.ahf, 25);
        NotificationHelper.cancelNotification(this.ahf, 26);
        NotificationHelper.cancelNotification(this.ahf, 17);
        NotificationHelper.cancelNotification(this.ahf, 15);
        NotificationHelper.cancelNotification(this.ahf, 13);
        NotificationHelper.cancelNotification(this.ahf, 12);
    }

    public void xs() {
        NotificationHelper.cancelNotification(this.ahf, 16);
    }

    public void xt() {
        NotificationHelper.cancelNotification(this.ahf, 19);
    }

    /* renamed from: do  reason: not valid java name */
    public void m11do(int i) {
        NotificationHelper.cancelNotification(this.ahf, i);
    }

    public int xu() {
        return this.aho.yU();
    }

    public void eo(String str) {
        if (TextUtils.isEmpty(str)) {
            xs();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xI = xI();
        if (xI == null) {
            xs();
            return;
        }
        HashMap<String, String> yJ = xI.yJ();
        if (yJ == null || yJ.isEmpty()) {
            xs();
        } else if (yJ.containsKey(str)) {
            xs();
        }
    }

    public void ep(String str) {
        if (TextUtils.isEmpty(str)) {
            xs();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e xI = xI();
        if (xI == null) {
            xs();
            return;
        }
        HashMap<String, String> yP = xI.yP();
        if (yP == null || yP.isEmpty()) {
            xs();
        } else if (yP.containsKey(str)) {
            xs();
        }
    }

    private boolean xv() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xw() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xx() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xy() {
        NotificationHelper.cancelNotification(this.ahf, 17);
    }

    public void dp(int i) {
        com.baidu.tbadk.coreExtra.d.e xI = xI();
        if (xI == null) {
            xy();
        } else if (1 == i) {
            if (xI.yw() <= 0) {
                xy();
            }
        } else if (2 == i) {
            if (xI.yy() <= 0) {
                xy();
            }
        } else if (3 == i && xI.yR() <= 0) {
            NotificationHelper.cancelNotification(this.ahf, 21);
        }
    }

    public void xz() {
        NotificationHelper.cancelNotification(this.ahf, 18);
    }

    public void xA() {
        NotificationHelper.cancelNotification(this.ahf, 26);
        NotificationHelper.cancelNotification(this.ahf, 25);
        NotificationHelper.cancelNotification(this.ahf, 24);
        NotificationHelper.cancelNotification(this.ahf, 23);
        NotificationHelper.cancelNotification(this.ahf, 16);
        NotificationHelper.cancelNotification(this.ahf, 17);
    }

    public void xB() {
        NotificationHelper.cancelNotification(this.ahf, 21);
        NotificationHelper.cancelNotification(this.ahf, 17);
        NotificationHelper.cancelNotification(this.ahf, 19);
        NotificationHelper.cancelNotification(this.ahf, 16);
        NotificationHelper.cancelNotification(this.ahf, 18);
    }

    public void xC() {
        NotificationHelper.cancelNotification(this.ahf, 24);
    }

    public void xD() {
        NotificationHelper.cancelNotification(this.ahf, 25);
    }

    public void xE() {
        NotificationHelper.cancelNotification(this.ahf, 23);
    }

    public void xF() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xG());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.aho.yN());
        newsNotifyMessage.setMsgStrangerChat(this.aho.yU());
        newsNotifyMessage.setMsgOfficialMerge(this.aho.yT());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.yN() + eVar.yv()) + eVar.yU()) + eVar.yT()) + eVar.yZ()) - eVar.yC());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.yN());
            newsNotifyMessage.setMsgStrangerChat(eVar.yU());
            newsNotifyMessage.setMsgOfficialMerge(eVar.yT());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.ahg;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.ahh, this.ahi, this.ahk, this.ahj, this.ahl);
        }
    }

    public int getMsgAtme() {
        return this.ahh;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.ahg, i, this.ahi, this.ahk, this.ahj, this.ahl);
        }
    }

    public int getMsgChat() {
        return this.ahi;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1022=5] */
    public int xG() {
        return ((((this.aho.yN() + this.aho.yv()) + this.aho.yU()) + this.aho.yT()) + this.aho.yZ()) - this.aho.yC();
    }

    public int getMsgFans() {
        return this.ahk;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.ahg, this.ahh, this.ahi, i, this.ahj, this.ahl);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.ahg, this.ahh, i, this.ahk, this.ahj, this.ahl);
        }
    }

    public int getMsgBookmark() {
        return this.ahj;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.ahg, this.ahh, this.ahi, this.ahk, i, this.ahl);
        }
    }

    public int getMsgGiftNum() {
        return this.ahl;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ahl = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.ahm = i;
            xF();
        }
    }

    public int getMsgLiveVip() {
        return this.ahm;
    }

    public void aK(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.ahg = 0;
        this.ahh = 0;
        this.ahi = 0;
        this.ahk = 0;
        this.ahj = 0;
    }

    public int xH() {
        return this.ahg + this.ahh + this.ahi + this.ahk + this.ahl;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int yz;
        int i = 0;
        if (eVar != null) {
            this.aho = eVar;
            this.ahi = (eVar.yv() - eVar.yC()) + eVar.yN() + eVar.yT() + eVar.yZ();
            a(eVar);
            if (eVar.yD()) {
                this.ahp = null;
                mHandler.removeMessages(0);
            }
            if (eVar.yD()) {
                if (c.xK().xZ() && c.xK().xN() > 0) {
                    i = eVar.yv() - eVar.yC();
                }
                if (c.xK().xS() && c.xK().xN() > 0) {
                    boolean yb = c.xK().yb();
                    boolean isProcessBackground = TbadkCoreApplication.m9getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m9getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m9getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.yN();
                    } else if (isFloatingWindowOpened) {
                        if (!yb || isProcessBackground) {
                            j = eVar.yN();
                        }
                    } else {
                        j = eVar.yN();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.yG() - eVar.yC() && i > 0) || j > eVar.yA())) {
                        a(1, 16, eVar);
                    }
                    yz = eVar.yz();
                    if (yz > 0 && yz > eVar.yM()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.yw() <= eVar.yK() || eVar.yy() > eVar.yL()) {
                        if (eVar.yw() > eVar.yK() || eVar.yy() != eVar.yL() || !xw()) {
                            if (eVar.yw() == eVar.yK() || eVar.yy() <= eVar.yL() || !xv()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.yR() > eVar.yS() && !xx()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.yV() <= eVar.yW()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                yz = eVar.yz();
                if (yz > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.yw() <= eVar.yK()) {
                }
                if (eVar.yw() > eVar.yK()) {
                }
                if (eVar.yw() == eVar.yK()) {
                }
                a(1, 17, eVar);
                if (eVar.yR() > eVar.yS()) {
                    a(1, 21, eVar);
                }
                if (eVar.yV() <= eVar.yW()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e xI() {
        return this.aho;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.aho = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e xJ() {
        return this.ahp;
    }

    public int dq(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ahf, 26, i2);
        }
    }
}
