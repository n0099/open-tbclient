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
    private static a akF;
    private static Date akI = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.d.e akH;
    private String akK;
    private String akL;
    private int aky = 0;
    private int akz = 0;
    private int akA = 0;
    private int akB = 0;
    private int akC = 0;
    private int akD = 0;
    private int akE = 0;
    private com.baidu.tbadk.coreExtra.d.e akG = new com.baidu.tbadk.coreExtra.d.e();
    private boolean akJ = true;
    private final int[] akM = new int[10];
    private final Context akx = TbadkCoreApplication.m411getInst().getApp();

    public static a yN() {
        if (akF == null) {
            akF = new a();
        }
        return akF;
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
                    this.akK = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.akK = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.akL = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.aky || i2 != this.akz || i3 != this.akA || i4 != this.akC || i5 != this.akB || i6 != this.akD) {
            if (i > this.aky || i2 > this.akz || i3 > this.akA || i4 > this.akC || i5 > this.akB || i6 > this.akD) {
                i7 = 1;
            } else {
                i7 = (i < this.aky || i2 < this.akz) ? 2 : 0;
            }
            if (i > this.aky) {
                i8 = 1;
            } else {
                i8 = i < this.aky ? 2 : 0;
            }
            if (i2 > this.akz) {
                i9 = 1;
            } else {
                i9 = i2 < this.akz ? 2 : 0;
            }
            int i11 = i3 > this.akA ? 1 : 0;
            int i12 = i4 > this.akC ? 1 : 0;
            int i13 = i6 <= this.akD ? 0 : 1;
            this.aky = i;
            this.akz = i2;
            this.akA = i3;
            this.akC = i4;
            this.akB = i5;
            this.akD = i6;
            if (zh() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zf();
                z(i10, 23);
                z(i11, 16);
                z(i7, 17);
                z(i8, 24);
                z(i9, 25);
                z(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.aky || i2 != this.akz || i3 != this.akA || i4 != this.akC || this.akD != i5) {
            this.aky = i;
            this.akz = i2;
            this.akA = i3;
            this.akC = i4;
            this.akD = i5;
            zf();
            if (zh() <= 0) {
                z(2, 16);
                z(2, 17);
            }
        }
    }

    public static boolean yO() {
        if (akI == null) {
            akI = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - akI.getTime() < 10000) {
                return false;
            }
            akI = date;
        }
        return true;
    }

    public static boolean yP() {
        if (c.zk().zv()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.zk().zx().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.zk().zy().split(":");
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

    private void z(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.akD > 0) {
                        String format = String.format(this.akx.getString(t.j.notify_gift), String.valueOf(this.akD));
                        b(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.aky > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aky > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.aky));
                            sb.append(this.akx.getString(t.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.akK != null) {
                            sb.append(this.akK);
                        } else {
                            sb.append(this.akx.getString(t.j.notify_reply));
                        }
                        b(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.akz > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.akz > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.akz));
                            sb2.append(this.akx.getString(t.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.akL != null) {
                            sb2.append(this.akL);
                        } else {
                            sb2.append(this.akx.getString(t.j.notify_at));
                        }
                        b(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.akC > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.akC > 1) {
                            sb3.append(String.format(this.akx.getString(t.j.notify_fans_unit), Integer.valueOf(this.akC)));
                        }
                        sb3.append(this.akx.getString(t.j.notify_fans));
                        b(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.zk().zz()) {
                    c.zk().zn();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.akx, 16);
                NotificationHelper.cancelNotification(this.akx, 17);
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
        String Ad;
        String Ac;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.akD > 0) {
                            String format = String.format(this.akx.getString(t.j.notify_gift), String.valueOf(this.akD));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.aky > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aky > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aky));
                                sb.append(this.akx.getString(t.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.akK != null) {
                                sb.append(this.akK);
                            } else {
                                sb.append(this.akx.getString(t.j.notify_reply));
                            }
                            b(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.akz > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.akz > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.akz));
                                sb2.append(this.akx.getString(t.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.akL != null) {
                                sb2.append(this.akL);
                            } else {
                                sb2.append(this.akx.getString(t.j.notify_at));
                            }
                            b(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.akC > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.akC > 1) {
                                sb3.append(String.format(this.akx.getString(t.j.notify_fans_unit), Integer.valueOf(this.akC)));
                            }
                            sb3.append(this.akx.getString(t.j.notify_fans));
                            b(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zT = (!c.zk().zz() || c.zk().zn() <= 0) ? 0 : eVar.zT() - eVar.Aa();
                        long Al = (!c.zk().zs() || c.zk().zn() <= 0) ? 0L : eVar.Al();
                        boolean z4 = Al > 0;
                        long j = zT + Al;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.akx.getString(t.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ao();
                            eVar.Am();
                            if (Al == 1) {
                                Ad = eVar.Ao();
                                str = eVar.Am();
                                Ac = String.valueOf(Ad) + "：" + str;
                            } else if (zT == 1) {
                                Ad = eVar.Ad();
                                Ac = eVar.Ac();
                                str = Ac;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.akx.getString(t.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ac)) {
                                Ac = str;
                            }
                            a(16, Ad, str, Ac, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Av = eVar.Av();
                        if (Av != null && Av.size() != 0) {
                            for (e.b bVar : Av) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.amd != 0 && bVar.unReadCount > bVar.ame) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Aw = eVar.Aw();
                        if (Aw != null && Aw.size() != 0) {
                            for (e.a aVar : Aw) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.amd != 0 && aVar.unReadCount > aVar.ame) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (c.zk().zz() && c.zk().zn() > 0) {
                        if (eVar.zU() + eVar.zW() > 0) {
                            if (eVar.zU() > 0 && !yW()) {
                                long zU = eVar.zU() - eVar.zV();
                                if (zU > 0) {
                                    stringBuffer.append(String.format(this.akx.getString(t.j.notify_updates), Long.valueOf(zU)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zV() > 0) {
                                    z = true;
                                }
                                if (eVar.zW() > 0 || yV()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.akx.getString(t.j.notify_validate), Integer.valueOf(eVar.zW())));
                                } else {
                                    stringBuffer.append(String.format(this.akx.getString(t.j.notify_validate_1), Integer.valueOf(eVar.zW())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, eVar.Af(), eVar.Ag(), eVar.Ag());
                                }
                            }
                            z = false;
                            if (eVar.zW() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ap() > 0 && !yX()) {
                            String format2 = String.format(this.akx.getString(t.j.notify_live), Integer.valueOf(eVar.Ap()));
                            b(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.akx, 16);
                    NotificationHelper.cancelNotification(this.akx, 17);
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
            PendingIntent service = PendingIntent.getService(this.akx, bVar.amd, a, 134217728);
            A(dG(i), i);
            NotificationHelper.showNotification(this.akx, i, bVar.title, bVar.content, bVar.amf, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akx, aVar.amd, a, 134217728);
            A(dG(i), i);
            NotificationHelper.showNotification(this.akx, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.akJ) {
            if (i == 23 && this.akD > 0) {
                e = dC(i);
            } else if (i == 26 && this.akC > 0) {
                e = dD(i);
            } else if (i == 18) {
                e = yQ();
            } else {
                e = e(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            e.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.akx, i, e, 134217728);
            A(dG(i), i);
            NotificationHelper.showNotification(this.akx, i, str, str2, str3, service, false);
        }
    }

    public Intent dC(int i) {
        Intent intent = new Intent(this.akx, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.akD);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dD(int i) {
        Intent intent = new Intent(this.akx, DealIntentService.class);
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
        Intent intent = new Intent(this.akx, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.amd);
        intent.putExtra("uname", bVar.amg);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.akx, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.amd));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.akG.An().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.akx, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.akz);
        intent.putExtra("reply_me", this.aky);
        intent.putExtra("fans", this.akC);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.akG.zT() - this.akG.Aa());
        intent.putExtra("group_msg_validate", this.akG.zW());
        intent.putExtra("group_msg_updates", this.akG.zU());
        intent.putExtra("live_notify_msg_updates", this.akG.Ap());
        intent.putExtra("officialbar_msg", this.akG.zX());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yQ() {
        Intent intent = new Intent(this.akx, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.akG.zV());
        return intent;
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.akx, 23);
        NotificationHelper.cancelNotification(this.akx, 24);
        NotificationHelper.cancelNotification(this.akx, 25);
        NotificationHelper.cancelNotification(this.akx, 26);
        NotificationHelper.cancelNotification(this.akx, 17);
        NotificationHelper.cancelNotification(this.akx, 15);
        NotificationHelper.cancelNotification(this.akx, 13);
        NotificationHelper.cancelNotification(this.akx, 12);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.akx, 16);
    }

    public void yT() {
        NotificationHelper.cancelNotification(this.akx, 19);
    }

    public void dE(int i) {
        NotificationHelper.cancelNotification(this.akx, i);
    }

    public int yU() {
        return this.akG.As();
    }

    public void eg(String str) {
        if (TextUtils.isEmpty(str)) {
            yS();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zi = zi();
        if (zi == null) {
            yS();
            return;
        }
        HashMap<String, String> Ah = zi.Ah();
        if (Ah == null || Ah.isEmpty()) {
            yS();
        } else if (Ah.containsKey(str)) {
            yS();
        }
    }

    public void eh(String str) {
        if (TextUtils.isEmpty(str)) {
            yS();
            return;
        }
        com.baidu.tbadk.coreExtra.d.e zi = zi();
        if (zi == null) {
            yS();
            return;
        }
        HashMap<String, String> An = zi.An();
        if (An == null || An.isEmpty()) {
            yS();
        } else if (An.containsKey(str)) {
            yS();
        }
    }

    private boolean yV() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yW() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yX() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yY() {
        NotificationHelper.cancelNotification(this.akx, 17);
    }

    public void dF(int i) {
        com.baidu.tbadk.coreExtra.d.e zi = zi();
        if (zi == null) {
            yY();
        } else if (1 == i) {
            if (zi.zU() <= 0) {
                yY();
            }
        } else if (2 == i) {
            if (zi.zW() <= 0) {
                yY();
            }
        } else if (3 == i && zi.Ap() <= 0) {
            NotificationHelper.cancelNotification(this.akx, 21);
        }
    }

    public void yZ() {
        NotificationHelper.cancelNotification(this.akx, 18);
    }

    public void za() {
        NotificationHelper.cancelNotification(this.akx, 26);
        NotificationHelper.cancelNotification(this.akx, 25);
        NotificationHelper.cancelNotification(this.akx, 24);
        NotificationHelper.cancelNotification(this.akx, 23);
        NotificationHelper.cancelNotification(this.akx, 16);
        NotificationHelper.cancelNotification(this.akx, 17);
    }

    public void zb() {
        NotificationHelper.cancelNotification(this.akx, 21);
        NotificationHelper.cancelNotification(this.akx, 17);
        NotificationHelper.cancelNotification(this.akx, 19);
        NotificationHelper.cancelNotification(this.akx, 16);
        NotificationHelper.cancelNotification(this.akx, 18);
    }

    public void zc() {
        NotificationHelper.cancelNotification(this.akx, 24);
    }

    public void zd() {
        NotificationHelper.cancelNotification(this.akx, 25);
    }

    public void ze() {
        NotificationHelper.cancelNotification(this.akx, 23);
    }

    public void zf() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zg());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.akG.Al());
        newsNotifyMessage.setMsgStrangerChat(this.akG.As());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Al() + eVar.zT()) + eVar.As()) + eVar.Ar()) + eVar.Ax()) - eVar.Aa());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Al());
            newsNotifyMessage.setMsgStrangerChat(eVar.As());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aky;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.akz, this.akA, this.akC, this.akB, this.akD);
        }
    }

    public int getMsgAtme() {
        return this.akz;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aky, i, this.akA, this.akC, this.akB, this.akD);
        }
    }

    public int getMsgChat() {
        return this.akA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1020=5] */
    public int zg() {
        return ((((this.akG.Al() + this.akG.zT()) + this.akG.As()) + this.akG.Ar()) + this.akG.Ax()) - this.akG.Aa();
    }

    public int getMsgFans() {
        return this.akC;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aky, this.akz, this.akA, i, this.akB, this.akD);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aky, this.akz, i, this.akC, this.akB, this.akD);
        }
    }

    public int getMsgBookmark() {
        return this.akB;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aky, this.akz, this.akA, this.akC, i, this.akD);
        }
    }

    public int getMsgGiftNum() {
        return this.akD;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.akD = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.akE = i;
            zf();
        }
    }

    public int getMsgLiveVip() {
        return this.akE;
    }

    public void aB(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.aky = 0;
        this.akz = 0;
        this.akA = 0;
        this.akC = 0;
        this.akB = 0;
    }

    public int zh() {
        return this.aky + this.akz + this.akA + this.akC + this.akD;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.tbadk.coreExtra.d.e eVar) {
        long j;
        int zX;
        int i = 0;
        if (eVar != null) {
            this.akG = eVar;
            this.akA = (eVar.zT() - eVar.Aa()) + eVar.Al() + eVar.Ar() + eVar.Ax();
            a(eVar);
            if (eVar.Ab()) {
                this.akH = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ab()) {
                if (c.zk().zz() && c.zk().zn() > 0) {
                    i = eVar.zT() - eVar.Aa();
                }
                if (c.zk().zs() && c.zk().zn() > 0) {
                    boolean zB = c.zk().zB();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = eVar.Al();
                    } else if (isFloatingWindowOpened) {
                        if (!zB || isProcessBackground) {
                            j = eVar.Al();
                        }
                    } else {
                        j = eVar.Al();
                    }
                    if ((i <= 0 || j > 0) && ((i > eVar.Ae() - eVar.Aa() && i > 0) || j > eVar.zY())) {
                        a(1, 16, eVar);
                    }
                    zX = eVar.zX();
                    if (zX > 0 && zX > eVar.Ak()) {
                        a(1, 19, eVar);
                    }
                    if (eVar.zU() <= eVar.Ai() || eVar.zW() > eVar.Aj()) {
                        if (eVar.zU() > eVar.Ai() || eVar.zW() != eVar.Aj() || !yW()) {
                            if (eVar.zU() == eVar.Ai() || eVar.zW() <= eVar.Aj() || !yV()) {
                                a(1, 17, eVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (eVar.Ap() > eVar.Aq() && !yX()) {
                        a(1, 21, eVar);
                    }
                    if (eVar.At() <= eVar.Au()) {
                        a(1, 27, eVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, eVar);
                zX = eVar.zX();
                if (zX > 0) {
                    a(1, 19, eVar);
                }
                if (eVar.zU() <= eVar.Ai()) {
                }
                if (eVar.zU() > eVar.Ai()) {
                }
                if (eVar.zU() == eVar.Ai()) {
                }
                a(1, 17, eVar);
                if (eVar.Ap() > eVar.Aq()) {
                    a(1, 21, eVar);
                }
                if (eVar.At() <= eVar.Au()) {
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.d.e zi() {
        return this.akG;
    }

    public void c(com.baidu.tbadk.coreExtra.d.e eVar) {
        this.akG = eVar;
    }

    public com.baidu.tbadk.coreExtra.d.e zj() {
        return this.akH;
    }

    public int dG(int i) {
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

    public void A(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.akx, 26, i2);
        }
    }
}
