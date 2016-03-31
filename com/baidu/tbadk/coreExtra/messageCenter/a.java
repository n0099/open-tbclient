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
import com.baidu.tieba.t;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a akW;
    private static Date akZ = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e akY;
    private String alb;
    private String alc;
    private int akP = 0;
    private int akQ = 0;
    private int akR = 0;
    private int akS = 0;
    private int akT = 0;
    private int akU = 0;
    private int akV = 0;
    private com.baidu.tbadk.coreExtra.d.e akX = new com.baidu.tbadk.coreExtra.d.e();
    private boolean ala = true;
    private final int[] ald = new int[10];
    private final Context akO = TbadkCoreApplication.m411getInst().getApp();

    public static a zp() {
        if (akW == null) {
            akW = new a();
        }
        return akW;
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
                    this.alb = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.alb = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.alc = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.akP || i2 != this.akQ || i3 != this.akR || i4 != this.akT || i5 != this.akS || i6 != this.akU) {
            if (i > this.akP || i2 > this.akQ || i3 > this.akR || i4 > this.akT || i5 > this.akS || i6 > this.akU) {
                i7 = 1;
            } else {
                i7 = (i < this.akP || i2 < this.akQ) ? 2 : 0;
            }
            if (i > this.akP) {
                i8 = 1;
            } else {
                i8 = i < this.akP ? 2 : 0;
            }
            if (i2 > this.akQ) {
                i9 = 1;
            } else {
                i9 = i2 < this.akQ ? 2 : 0;
            }
            int i11 = i3 > this.akR ? 1 : 0;
            int i12 = i4 > this.akT ? 1 : 0;
            int i13 = i6 <= this.akU ? 0 : 1;
            this.akP = i;
            this.akQ = i2;
            this.akR = i3;
            this.akT = i4;
            this.akS = i5;
            this.akU = i6;
            if (zJ() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zH();
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
        if (i != this.akP || i2 != this.akQ || i3 != this.akR || i4 != this.akT || this.akU != i5) {
            this.akP = i;
            this.akQ = i2;
            this.akR = i3;
            this.akT = i4;
            this.akU = i5;
            zH();
            if (zJ() <= 0) {
                w(2, 16);
                w(2, 17);
            }
        }
    }

    public static boolean zq() {
        if (akZ == null) {
            akZ = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - akZ.getTime() < 10000) {
                return false;
            }
            akZ = date;
        }
        return true;
    }

    public static boolean zr() {
        if (c.zM().zX()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.zM().zZ().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.zM().Aa().split(":");
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
                    if (this.akU > 0) {
                        String format = String.format(this.akO.getString(t.j.notify_gift), String.valueOf(this.akU));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.akP > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.akP > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.akP));
                            sb.append(this.akO.getString(t.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.alb != null) {
                            sb.append(this.alb);
                        } else {
                            sb.append(this.akO.getString(t.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.akQ > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.akQ > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.akQ));
                            sb2.append(this.akO.getString(t.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.alc != null) {
                            sb2.append(this.alc);
                        } else {
                            sb2.append(this.akO.getString(t.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.akT > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.akT > 1) {
                            sb3.append(String.format(this.akO.getString(t.j.notify_fans_unit), Integer.valueOf(this.akT)));
                        }
                        sb3.append(this.akO.getString(t.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.zM().Ab()) {
                    c.zM().zP();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.akO, 16);
                NotificationHelper.cancelNotification(this.akO, 17);
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
        String AG;
        String AF;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.akU > 0) {
                            String format = String.format(this.akO.getString(t.j.notify_gift), String.valueOf(this.akU));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.akP > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.akP > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.akP));
                                sb.append(this.akO.getString(t.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.alb != null) {
                                sb.append(this.alb);
                            } else {
                                sb.append(this.akO.getString(t.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.akQ > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.akQ > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.akQ));
                                sb2.append(this.akO.getString(t.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.alc != null) {
                                sb2.append(this.alc);
                            } else {
                                sb2.append(this.akO.getString(t.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.akT > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.akT > 1) {
                                sb3.append(String.format(this.akO.getString(t.j.notify_fans_unit), Integer.valueOf(this.akT)));
                            }
                            sb3.append(this.akO.getString(t.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Aw = (!c.zM().Ab() || c.zM().zP() <= 0) ? 0 : eVar.Aw() - eVar.AD();
                        long AO = (!c.zM().zU() || c.zM().zP() <= 0) ? 0L : eVar.AO();
                        boolean z4 = AO > 0;
                        long j = Aw + AO;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.akO.getString(t.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.AR();
                            eVar.AP();
                            if (AO == 1) {
                                AG = eVar.AR();
                                str = eVar.AP();
                                AF = String.valueOf(AG) + "：" + str;
                            } else if (Aw == 1) {
                                AG = eVar.AG();
                                AF = eVar.AF();
                                str = AF;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.akO.getString(t.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(AF)) {
                                AF = str;
                            }
                            a(16, AG, str, AF, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AY = eVar.AY();
                        if (AY != null && AY.size() != 0) {
                            for (e.b bVar : AY) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.amu != 0 && bVar.unReadCount > bVar.amv) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AZ = eVar.AZ();
                        if (AZ != null && AZ.size() != 0) {
                            for (e.a aVar : AZ) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.amu != 0 && aVar.unReadCount > aVar.amv) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.zM().Ab() && c.zM().zP() > 0) {
                        if (eVar.Ax() + eVar.Az() > 0) {
                            if (eVar.Ax() > 0 && !zy()) {
                                long Ax = eVar.Ax() - eVar.Ay();
                                if (Ax > 0) {
                                    stringBuffer.append(String.format(this.akO.getString(t.j.notify_updates), Long.valueOf(Ax)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Ay() > 0) {
                                    z = true;
                                }
                                if (eVar.Az() > 0 || zx()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.akO.getString(t.j.notify_validate), Integer.valueOf(eVar.Az())));
                                } else {
                                    stringBuffer.append(String.format(this.akO.getString(t.j.notify_validate_1), Integer.valueOf(eVar.Az())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.AI(), eVar.AJ(), eVar.AJ());
                                }
                            }
                            z = false;
                            if (eVar.Az() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.AS() > 0 && !zz()) {
                            String format2 = String.format(this.akO.getString(t.j.notify_live), Integer.valueOf(eVar.AS()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.akO, 16);
                    NotificationHelper.cancelNotification(this.akO, 17);
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
            PendingIntent service = PendingIntent.getService(this.akO, bVar.amu, a, 134217728);
            x(dJ(i), i);
            NotificationHelper.showNotification(this.akO, i, bVar.title, bVar.content, bVar.amw, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akO, aVar.amu, a, 134217728);
            x(dJ(i), i);
            NotificationHelper.showNotification(this.akO, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.ala) {
            if (i == 23 && this.akU > 0) {
                e = dF(i);
            } else if (i == 26 && this.akT > 0) {
                e = dG(i);
            } else if (i == 18) {
                e = zs();
            } else {
                e = e(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            e.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akO, i, e, 134217728);
            x(dJ(i), i);
            NotificationHelper.showNotification(this.akO, i, str, str2, str3, service, false);
        }
    }

    public Intent dF(int i) {
        Intent intent = new Intent(this.akO, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.akU);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dG(int i) {
        Intent intent = new Intent(this.akO, DealIntentService.class);
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
        Intent intent = new Intent(this.akO, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.amu);
        intent.putExtra("uname", bVar.amx);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.akO, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.amu));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.akX.AQ().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.akO, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.akQ);
        intent.putExtra("reply_me", this.akP);
        intent.putExtra("fans", this.akT);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.akX.Aw() - this.akX.AD());
        intent.putExtra("group_msg_validate", this.akX.Az());
        intent.putExtra("group_msg_updates", this.akX.Ax());
        intent.putExtra("live_notify_msg_updates", this.akX.AS());
        intent.putExtra("officialbar_msg", this.akX.AA());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zs() {
        Intent intent = new Intent(this.akO, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.akX.Ay());
        return intent;
    }

    public void zt() {
        NotificationHelper.cancelNotification(this.akO, 23);
        NotificationHelper.cancelNotification(this.akO, 24);
        NotificationHelper.cancelNotification(this.akO, 25);
        NotificationHelper.cancelNotification(this.akO, 26);
        NotificationHelper.cancelNotification(this.akO, 17);
        NotificationHelper.cancelNotification(this.akO, 15);
        NotificationHelper.cancelNotification(this.akO, 13);
        NotificationHelper.cancelNotification(this.akO, 12);
    }

    public void zu() {
        NotificationHelper.cancelNotification(this.akO, 16);
    }

    public void zv() {
        NotificationHelper.cancelNotification(this.akO, 19);
    }

    public void dH(int i) {
        NotificationHelper.cancelNotification(this.akO, i);
    }

    public int zw() {
        return this.akX.AV();
    }

    public void en(String str) {
        if (TextUtils.isEmpty(str)) {
            zu();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zK = zK();
        if (zK == null) {
            zu();
            return;
        }
        HashMap<String, String> AK = zK.AK();
        if (AK == null || AK.isEmpty()) {
            zu();
        } else if (AK.containsKey(str)) {
            zu();
        }
    }

    public void eo(String str) {
        if (TextUtils.isEmpty(str)) {
            zu();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zK = zK();
        if (zK == null) {
            zu();
            return;
        }
        HashMap<String, String> AQ = zK.AQ();
        if (AQ == null || AQ.isEmpty()) {
            zu();
        } else if (AQ.containsKey(str)) {
            zu();
        }
    }

    private boolean zx() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zy() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean zz() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void zA() {
        NotificationHelper.cancelNotification(this.akO, 17);
    }

    public void dI(int i) {
        com.baidu.tbadk.coreExtra.d.e zK = zK();
        if (zK == null) {
            zA();
        } else if (1 == i) {
            if (zK.Ax() <= 0) {
                zA();
            }
        } else if (2 == i) {
            if (zK.Az() <= 0) {
                zA();
            }
        } else if (3 == i && zK.AS() <= 0) {
            NotificationHelper.cancelNotification(this.akO, 21);
        }
    }

    public void zB() {
        NotificationHelper.cancelNotification(this.akO, 18);
    }

    public void zC() {
        NotificationHelper.cancelNotification(this.akO, 26);
        NotificationHelper.cancelNotification(this.akO, 25);
        NotificationHelper.cancelNotification(this.akO, 24);
        NotificationHelper.cancelNotification(this.akO, 23);
        NotificationHelper.cancelNotification(this.akO, 16);
        NotificationHelper.cancelNotification(this.akO, 17);
    }

    public void zD() {
        NotificationHelper.cancelNotification(this.akO, 21);
        NotificationHelper.cancelNotification(this.akO, 17);
        NotificationHelper.cancelNotification(this.akO, 19);
        NotificationHelper.cancelNotification(this.akO, 16);
        NotificationHelper.cancelNotification(this.akO, 18);
    }

    public void zE() {
        NotificationHelper.cancelNotification(this.akO, 24);
    }

    public void zF() {
        NotificationHelper.cancelNotification(this.akO, 25);
    }

    public void zG() {
        NotificationHelper.cancelNotification(this.akO, 23);
    }

    public void zH() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zI());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.akX.AO());
        newsNotifyMessage.setMsgStrangerChat(this.akX.AV());
        newsNotifyMessage.setMsgOfficialMerge(this.akX.AU());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.AO() + eVar.Aw()) + eVar.AV()) + eVar.AU()) + eVar.Ba()) - eVar.AD());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.AO());
            newsNotifyMessage.setMsgStrangerChat(eVar.AV());
            newsNotifyMessage.setMsgOfficialMerge(eVar.AU());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.akP;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.akQ, this.akR, this.akT, this.akS, this.akU);
        }
    }

    public int getMsgAtme() {
        return this.akQ;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.akP, i, this.akR, this.akT, this.akS, this.akU);
        }
    }

    public int getMsgChat() {
        return this.akR;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1022=5] */
    public int zI() {
        return ((((this.akX.AO() + this.akX.Aw()) + this.akX.AV()) + this.akX.AU()) + this.akX.Ba()) - this.akX.AD();
    }

    public int getMsgFans() {
        return this.akT;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.akP, this.akQ, this.akR, i, this.akS, this.akU);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.akP, this.akQ, i, this.akT, this.akS, this.akU);
        }
    }

    public int getMsgBookmark() {
        return this.akS;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.akP, this.akQ, this.akR, this.akT, i, this.akU);
        }
    }

    public int getMsgGiftNum() {
        return this.akU;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.akU = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.akV = i;
            zH();
        }
    }

    public int getMsgLiveVip() {
        return this.akV;
    }

    public void aG(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.akP = 0;
        this.akQ = 0;
        this.akR = 0;
        this.akT = 0;
        this.akS = 0;
    }

    public int zJ() {
        return this.akP + this.akQ + this.akR + this.akT + this.akU;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int AA;
        int i = 0;
        if (eVar != null) {
            this.akX = eVar;
            this.akR = (eVar.Aw() - eVar.AD()) + eVar.AO() + eVar.AU() + eVar.Ba();
            a(eVar);
            if (eVar.AE()) {
                this.akY = null;
                mHandler.removeMessages(0);
            }
            if (eVar.AE()) {
                if (c.zM().Ab() && c.zM().zP() > 0) {
                    i = eVar.Aw() - eVar.AD();
                }
                if (c.zM().zU() && c.zM().zP() > 0) {
                    boolean Ad = c.zM().Ad();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.AO();
                    } else if (isFloatingWindowOpened) {
                        if (!Ad || isProcessBackground) {
                            j = eVar.AO();
                        }
                    } else {
                        j = eVar.AO();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.AH() - eVar.AD() && i > 0) || j > eVar.AB())) {
                        a(1, 16, eVar);
                    }
                    AA = eVar.AA();
                    if (AA > 0 && AA > eVar.AN()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.Ax() <= eVar.AL() || eVar.Az() > eVar.AM()) {
                        if (eVar.Ax() > eVar.AL() || eVar.Az() != eVar.AM() || !zy()) {
                            if (eVar.Ax() == eVar.AL() || eVar.Az() <= eVar.AM() || !zx()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.AS() > eVar.AT() && !zz()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.AW() <= eVar.AX()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                AA = eVar.AA();
                if (AA > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.Ax() <= eVar.AL()) {
                }
                if (eVar.Ax() > eVar.AL()) {
                }
                if (eVar.Ax() == eVar.AL()) {
                }
                a(1, 17, eVar);
                if (eVar.AS() > eVar.AT()) {
                    a(1, 21, eVar);
                }
                if (eVar.AW() <= eVar.AX()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e zK() {
        return this.akX;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.akX = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e zL() {
        return this.akY;
    }

    public int dJ(int i) {
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

    public void x(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akO, 26, i2);
        }
    }
}
