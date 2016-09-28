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
import com.baidu.tieba.r;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a akN;
    private static Date akQ = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e akP;
    private String akS;
    private String akT;
    private int akG = 0;
    private int akH = 0;
    private int akI = 0;
    private int akJ = 0;
    private int akK = 0;
    private int akL = 0;
    private int akM = 0;
    private com.baidu.tbadk.coreExtra.d.e akO = new com.baidu.tbadk.coreExtra.d.e();
    private boolean akR = true;
    private final int[] akU = new int[10];
    private final Context akF = TbadkCoreApplication.m9getInst().getApp();

    public static a yD() {
        if (akN == null) {
            akN = new a();
        }
        return akN;
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
                    this.akS = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.akS = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.akT = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.akG || i2 != this.akH || i3 != this.akI || i4 != this.akK || i5 != this.akJ || i6 != this.akL) {
            if (i > this.akG || i2 > this.akH || i3 > this.akI || i4 > this.akK || i5 > this.akJ || i6 > this.akL) {
                i7 = 1;
            } else {
                i7 = (i < this.akG || i2 < this.akH) ? 2 : 0;
            }
            if (i > this.akG) {
                i8 = 1;
            } else {
                i8 = i < this.akG ? 2 : 0;
            }
            if (i2 > this.akH) {
                i9 = 1;
            } else {
                i9 = i2 < this.akH ? 2 : 0;
            }
            int i11 = i3 > this.akI ? 1 : 0;
            int i12 = i4 > this.akK ? 1 : 0;
            int i13 = i6 <= this.akL ? 0 : 1;
            this.akG = i;
            this.akH = i2;
            this.akI = i3;
            this.akK = i4;
            this.akJ = i5;
            this.akL = i6;
            if (yX() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yV();
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
        if (i != this.akG || i2 != this.akH || i3 != this.akI || i4 != this.akK || this.akL != i5) {
            this.akG = i;
            this.akH = i2;
            this.akI = i3;
            this.akK = i4;
            this.akL = i5;
            yV();
            if (yX() <= 0) {
                y(2, 16);
                y(2, 17);
            }
        }
    }

    public static boolean yE() {
        if (akQ == null) {
            akQ = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - akQ.getTime() < 10000) {
                return false;
            }
            akQ = date;
        }
        return true;
    }

    public static boolean yF() {
        if (c.za().zl()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.za().zn().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.za().zo().split(":");
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
                    if (this.akL > 0) {
                        String format = String.format(this.akF.getString(r.j.notify_gift), String.valueOf(this.akL));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.akG > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.akG > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.akG));
                            sb.append(this.akF.getString(r.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.akS != null) {
                            sb.append(this.akS);
                        } else {
                            sb.append(this.akF.getString(r.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.akH > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.akH > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.akH));
                            sb2.append(this.akF.getString(r.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.akT != null) {
                            sb2.append(this.akT);
                        } else {
                            sb2.append(this.akF.getString(r.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.akK > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.akK > 1) {
                            sb3.append(String.format(this.akF.getString(r.j.notify_fans_unit), Integer.valueOf(this.akK)));
                        }
                        sb3.append(this.akF.getString(r.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.za().zp()) {
                    c.za().zd();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.akF, 16);
                NotificationHelper.cancelNotification(this.akF, 17);
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
        String zV;
        String zU;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.akL > 0) {
                            String format = String.format(this.akF.getString(r.j.notify_gift), String.valueOf(this.akL));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.akG > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.akG > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.akG));
                                sb.append(this.akF.getString(r.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.akS != null) {
                                sb.append(this.akS);
                            } else {
                                sb.append(this.akF.getString(r.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.akH > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.akH > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.akH));
                                sb2.append(this.akF.getString(r.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.akT != null) {
                                sb2.append(this.akT);
                            } else {
                                sb2.append(this.akF.getString(r.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.akK > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.akK > 1) {
                                sb3.append(String.format(this.akF.getString(r.j.notify_fans_unit), Integer.valueOf(this.akK)));
                            }
                            sb3.append(this.akF.getString(r.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zL = (!c.za().zp() || c.za().zd() <= 0) ? 0 : eVar.zL() - eVar.zS();
                        long Ad = (!c.za().zi() || c.za().zd() <= 0) ? 0L : eVar.Ad();
                        boolean z4 = Ad > 0;
                        long j = zL + Ad;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.akF.getString(r.j.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ag();
                            eVar.Ae();
                            if (Ad == 1) {
                                zV = eVar.Ag();
                                str = eVar.Ae();
                                zU = String.valueOf(zV) + "：" + str;
                            } else if (zL == 1) {
                                zV = eVar.zV();
                                zU = eVar.zU();
                                str = zU;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.akF.getString(r.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zU)) {
                                zU = str;
                            }
                            c(16, zV, str, zU, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> An = eVar.An();
                        if (An != null && An.size() != 0) {
                            for (e.b bVar : An) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.amp != 0 && bVar.unReadCount > bVar.amq) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ao = eVar.Ao();
                        if (Ao != null && Ao.size() != 0) {
                            for (e.a aVar : Ao) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.amp != 0 && aVar.unReadCount > aVar.amq) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.za().zp() && c.za().zd() > 0) {
                        if (eVar.zM() + eVar.zO() > 0) {
                            if (eVar.zM() > 0 && !yM()) {
                                long zM = eVar.zM() - eVar.zN();
                                if (zM > 0) {
                                    stringBuffer.append(String.format(this.akF.getString(r.j.notify_updates), Long.valueOf(zM)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zN() > 0) {
                                    z = true;
                                }
                                if (eVar.zO() > 0 || yL()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.akF.getString(r.j.notify_validate), Integer.valueOf(eVar.zO())));
                                } else {
                                    stringBuffer.append(String.format(this.akF.getString(r.j.notify_validate_1), Integer.valueOf(eVar.zO())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.zX(), eVar.zY(), eVar.zY());
                                }
                            }
                            z = false;
                            if (eVar.zO() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ah() > 0 && !yN()) {
                            String format2 = String.format(this.akF.getString(r.j.notify_live), Integer.valueOf(eVar.Ah()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.akF, 16);
                    NotificationHelper.cancelNotification(this.akF, 17);
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
            PendingIntent service = PendingIntent.getService(this.akF, bVar.amp, a, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akF, i, bVar.title, bVar.content, bVar.amr, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akF, aVar.amp, a, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akF, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.akR) {
            if (i == 23 && this.akL > 0) {
                h = dA(i);
            } else if (i == 26 && this.akK > 0) {
                h = dB(i);
            } else if (i == 18) {
                h = yG();
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akF, i, h, 134217728);
            z(dE(i), i);
            NotificationHelper.showNotification(this.akF, i, str, str2, str3, service, false);
        }
    }

    public Intent dA(int i) {
        Intent intent = new Intent(this.akF, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.akL);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dB(int i) {
        Intent intent = new Intent(this.akF, DealIntentService.class);
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
        Intent intent = new Intent(this.akF, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.amp);
        intent.putExtra("uname", bVar.ams);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.akF, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.amp));
        return intent;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.akO.Af().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.akF, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.akH);
        intent.putExtra("reply_me", this.akG);
        intent.putExtra("fans", this.akK);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.akO.zL() - this.akO.zS());
        intent.putExtra("group_msg_validate", this.akO.zO());
        intent.putExtra("group_msg_updates", this.akO.zM());
        intent.putExtra("live_notify_msg_updates", this.akO.Ah());
        intent.putExtra("officialbar_msg", this.akO.zP());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yG() {
        Intent intent = new Intent(this.akF, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.akO.zN());
        return intent;
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.akF, 23);
        NotificationHelper.cancelNotification(this.akF, 24);
        NotificationHelper.cancelNotification(this.akF, 25);
        NotificationHelper.cancelNotification(this.akF, 26);
        NotificationHelper.cancelNotification(this.akF, 17);
        NotificationHelper.cancelNotification(this.akF, 15);
        NotificationHelper.cancelNotification(this.akF, 13);
        NotificationHelper.cancelNotification(this.akF, 12);
    }

    public void yI() {
        NotificationHelper.cancelNotification(this.akF, 16);
    }

    public void yJ() {
        NotificationHelper.cancelNotification(this.akF, 19);
    }

    public void dC(int i) {
        NotificationHelper.cancelNotification(this.akF, i);
    }

    public int yK() {
        return this.akO.Ak();
    }

    public void et(String str) {
        if (TextUtils.isEmpty(str)) {
            yI();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yY = yY();
        if (yY == null) {
            yI();
            return;
        }
        HashMap<String, String> zZ = yY.zZ();
        if (zZ == null || zZ.isEmpty()) {
            yI();
        } else if (zZ.containsKey(str)) {
            yI();
        }
    }

    public void eu(String str) {
        if (TextUtils.isEmpty(str)) {
            yI();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e yY = yY();
        if (yY == null) {
            yI();
            return;
        }
        HashMap<String, String> Af = yY.Af();
        if (Af == null || Af.isEmpty()) {
            yI();
        } else if (Af.containsKey(str)) {
            yI();
        }
    }

    private boolean yL() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yM() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yN() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.akF, 17);
    }

    public void dD(int i) {
        com.baidu.tbadk.coreExtra.d.e yY = yY();
        if (yY == null) {
            yO();
        } else if (1 == i) {
            if (yY.zM() <= 0) {
                yO();
            }
        } else if (2 == i) {
            if (yY.zO() <= 0) {
                yO();
            }
        } else if (3 == i && yY.Ah() <= 0) {
            NotificationHelper.cancelNotification(this.akF, 21);
        }
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.akF, 18);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.akF, 26);
        NotificationHelper.cancelNotification(this.akF, 25);
        NotificationHelper.cancelNotification(this.akF, 24);
        NotificationHelper.cancelNotification(this.akF, 23);
        NotificationHelper.cancelNotification(this.akF, 16);
        NotificationHelper.cancelNotification(this.akF, 17);
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.akF, 21);
        NotificationHelper.cancelNotification(this.akF, 17);
        NotificationHelper.cancelNotification(this.akF, 19);
        NotificationHelper.cancelNotification(this.akF, 16);
        NotificationHelper.cancelNotification(this.akF, 18);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.akF, 24);
    }

    public void yT() {
        NotificationHelper.cancelNotification(this.akF, 25);
    }

    public void yU() {
        NotificationHelper.cancelNotification(this.akF, 23);
    }

    public void yV() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yW());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.akO.Ad());
        newsNotifyMessage.setMsgStrangerChat(this.akO.Ak());
        newsNotifyMessage.setMsgOfficialMerge(this.akO.Aj());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Ad() + eVar.zL()) + eVar.Ak()) + eVar.Aj()) + eVar.Ap()) - eVar.zS());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Ad());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ak());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Aj());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.akG;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.akH, this.akI, this.akK, this.akJ, this.akL);
        }
    }

    public int getMsgAtme() {
        return this.akH;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.akG, i, this.akI, this.akK, this.akJ, this.akL);
        }
    }

    public int getMsgChat() {
        return this.akI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1035=5] */
    public int yW() {
        return ((((this.akO.Ad() + this.akO.zL()) + this.akO.Ak()) + this.akO.Aj()) + this.akO.Ap()) - this.akO.zS();
    }

    public int getMsgFans() {
        return this.akK;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.akG, this.akH, this.akI, i, this.akJ, this.akL);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.akG, this.akH, i, this.akK, this.akJ, this.akL);
        }
    }

    public int getMsgBookmark() {
        return this.akJ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.akG, this.akH, this.akI, this.akK, i, this.akL);
        }
    }

    public int getMsgGiftNum() {
        return this.akL;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.akL = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.akM = i;
            yV();
        }
    }

    public int getMsgLiveVip() {
        return this.akM;
    }

    public void aO(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.akG = 0;
        this.akH = 0;
        this.akI = 0;
        this.akK = 0;
        this.akJ = 0;
    }

    public int yX() {
        return this.akG + this.akH + this.akI + this.akK + this.akL;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int zP;
        int i = 0;
        if (eVar != null) {
            this.akO = eVar;
            this.akI = (eVar.zL() - eVar.zS()) + eVar.Ad() + eVar.Aj() + eVar.Ap();
            a(eVar);
            if (eVar.zT()) {
                this.akP = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zT()) {
                if (c.za().zp() && c.za().zd() > 0) {
                    i = eVar.zL() - eVar.zS();
                }
                if (c.za().zi() && c.za().zd() > 0) {
                    boolean zr = c.za().zr();
                    boolean isProcessBackground = TbadkCoreApplication.m9getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m9getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m9getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.Ad();
                    } else if (isFloatingWindowOpened) {
                        if (!zr || isProcessBackground) {
                            j = eVar.Ad();
                        }
                    } else {
                        j = eVar.Ad();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.zW() - eVar.zS() && i > 0) || j > eVar.zQ())) {
                        a(1, 16, eVar);
                    }
                    zP = eVar.zP();
                    if (zP > 0 && zP > eVar.Ac()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.zM() <= eVar.Aa() || eVar.zO() > eVar.Ab()) {
                        if (eVar.zM() > eVar.Aa() || eVar.zO() != eVar.Ab() || !yM()) {
                            if (eVar.zM() == eVar.Aa() || eVar.zO() <= eVar.Ab() || !yL()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.Ah() > eVar.Ai() && !yN()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.Al() <= eVar.Am()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                zP = eVar.zP();
                if (zP > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.zM() <= eVar.Aa()) {
                }
                if (eVar.zM() > eVar.Aa()) {
                }
                if (eVar.zM() == eVar.Aa()) {
                }
                a(1, 17, eVar);
                if (eVar.Ah() > eVar.Ai()) {
                    a(1, 21, eVar);
                }
                if (eVar.Al() <= eVar.Am()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e yY() {
        return this.akO;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.akO = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e yZ() {
        return this.akP;
    }

    public int dE(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akF, 26, i2);
        }
    }
}
