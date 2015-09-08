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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.f;
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
    private static a ahT;
    private static Date ahW = null;
    private static Handler mHandler = new b();
    private f ahV;
    private String ahY;
    private String ahZ;
    private int ahM = 0;
    private int ahN = 0;
    private int ahO = 0;
    private int ahP = 0;
    private int ahQ = 0;
    private int ahR = 0;
    private int ahS = 0;
    private f ahU = new f();
    private boolean ahX = true;
    private final int[] aia = new int[10];
    private final Context ahL = TbadkCoreApplication.m411getInst().getApp();

    public static a wZ() {
        if (ahT == null) {
            ahT = new a();
        }
        return ahT;
    }

    private a() {
    }

    public void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
            if (!StringUtils.isNull(optString)) {
                this.ahY = optString;
            } else if (!StringUtils.isNull(optString3)) {
                this.ahY = optString3;
            }
            if (!StringUtils.isNull(optString2)) {
                this.ahZ = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.ahM || i2 != this.ahN || i3 != this.ahO || i4 != this.ahQ || i5 != this.ahP || i6 != this.ahR) {
            if (i > this.ahM || i2 > this.ahN || i3 > this.ahO || i4 > this.ahQ || i5 > this.ahP || i6 > this.ahR) {
                i7 = 1;
            } else {
                i7 = (i < this.ahM || i2 < this.ahN) ? 2 : 0;
            }
            if (i > this.ahM) {
                i8 = 1;
            } else {
                i8 = i < this.ahM ? 2 : 0;
            }
            if (i2 > this.ahN) {
                i9 = 1;
            } else {
                i9 = i2 < this.ahN ? 2 : 0;
            }
            int i11 = i3 > this.ahO ? 1 : 0;
            int i12 = i4 > this.ahQ ? 1 : 0;
            int i13 = i6 <= this.ahR ? 0 : 1;
            this.ahM = i;
            this.ahN = i2;
            this.ahO = i3;
            this.ahQ = i4;
            this.ahP = i5;
            this.ahR = i6;
            if (xt() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                xr();
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
        if (i != this.ahM || i2 != this.ahN || i3 != this.ahO || i4 != this.ahQ || this.ahR != i5) {
            this.ahM = i;
            this.ahN = i2;
            this.ahO = i3;
            this.ahQ = i4;
            this.ahR = i5;
            xr();
            if (xt() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean xa() {
        if (ahW == null) {
            ahW = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - ahW.getTime() < 10000) {
                return false;
            }
            ahW = date;
        }
        return true;
    }

    public static boolean xb() {
        if (c.xw().xH()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.xw().xJ().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.xw().xK().split(":");
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
                    if (this.ahR > 0) {
                        String format = String.format(this.ahL.getString(i.h.notify_gift), String.valueOf(this.ahR));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.ahM > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.ahM > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.ahM));
                            sb.append(this.ahL.getString(i.h.notify_unit));
                            sb.append("]");
                        }
                        if (this.ahY != null) {
                            sb.append(this.ahY);
                        } else {
                            sb.append(this.ahL.getString(i.h.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.ahN > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.ahN > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.ahN));
                            sb2.append(this.ahL.getString(i.h.notify_unit));
                            sb2.append("]");
                        }
                        if (this.ahZ != null) {
                            sb2.append(this.ahZ);
                        } else {
                            sb2.append(this.ahL.getString(i.h.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ahQ > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ahQ > 1) {
                            sb3.append(String.format(this.ahL.getString(i.h.notify_fans_unit), Integer.valueOf(this.ahQ)));
                        }
                        sb3.append(this.ahL.getString(i.h.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.xw().xL()) {
                    c.xw().xz();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ahL, 16);
                NotificationHelper.cancelNotification(this.ahL, 17);
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
    private void a(int i, int i2, f fVar) {
        boolean z;
        String yr;
        String yq;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (fVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.ahR > 0) {
                            String format = String.format(this.ahL.getString(i.h.notify_gift), String.valueOf(this.ahR));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.ahM > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.ahM > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.ahM));
                                sb.append(this.ahL.getString(i.h.notify_unit));
                                sb.append("]");
                            }
                            if (this.ahY != null) {
                                sb.append(this.ahY);
                            } else {
                                sb.append(this.ahL.getString(i.h.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.ahN > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.ahN > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.ahN));
                                sb2.append(this.ahL.getString(i.h.notify_unit));
                                sb2.append("]");
                            }
                            if (this.ahZ != null) {
                                sb2.append(this.ahZ);
                            } else {
                                sb2.append(this.ahL.getString(i.h.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ahQ > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ahQ > 1) {
                                sb3.append(String.format(this.ahL.getString(i.h.notify_fans_unit), Integer.valueOf(this.ahQ)));
                            }
                            sb3.append(this.ahL.getString(i.h.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int yh = (!c.xw().xL() || c.xw().xz() <= 0) ? 0 : fVar.yh() - fVar.yo();
                        long yz = (!c.xw().xE() || c.xw().xz() <= 0) ? 0L : fVar.yz();
                        boolean z4 = yz > 0;
                        long j = yh + yz;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ahL.getString(i.h.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            fVar.yC();
                            fVar.yA();
                            if (yz == 1) {
                                yr = fVar.yC();
                                str = fVar.yA();
                                yq = String.valueOf(yr) + "：" + str;
                            } else if (yh == 1) {
                                yr = fVar.yr();
                                yq = fVar.yq();
                                str = yq;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ahL.getString(i.h.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(yq)) {
                                yq = str;
                            }
                            a(16, yr, str, yq, z4);
                        }
                    } else if (i2 == 19) {
                        List<f.b> yJ = fVar.yJ();
                        if (yJ != null && yJ.size() != 0) {
                            for (f.b bVar : yJ) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.gid != 0 && bVar.unReadCount > bVar.ajr) {
                                    a(bVar);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<f.a> yK = fVar.yK();
                        if (yK != null && yK.size() != 0) {
                            for (f.a aVar : yK) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.gid != 0 && aVar.unReadCount > aVar.ajr) {
                                    a(aVar);
                                }
                            }
                        }
                    } else if (c.xw().xL() && c.xw().xz() > 0) {
                        if (fVar.yi() + fVar.yk() > 0) {
                            if (fVar.yi() > 0 && !xi()) {
                                long yi = fVar.yi() - fVar.yj();
                                if (yi > 0) {
                                    stringBuffer.append(String.format(this.ahL.getString(i.h.notify_updates), Long.valueOf(yi)));
                                    z = false;
                                    z2 = true;
                                } else if (fVar.yj() > 0) {
                                    z = true;
                                }
                                if (fVar.yk() > 0 || xh()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ahL.getString(i.h.notify_validate), Integer.valueOf(fVar.yk())));
                                } else {
                                    stringBuffer.append(String.format(this.ahL.getString(i.h.notify_validate_1), Integer.valueOf(fVar.yk())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, fVar.yt(), fVar.yu(), fVar.yu());
                                }
                            }
                            z = false;
                            if (fVar.yk() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (fVar.yD() > 0 && !xj()) {
                            String format2 = String.format(this.ahL.getString(i.h.notify_live), Integer.valueOf(fVar.yD()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ahL, 16);
                    NotificationHelper.cancelNotification(this.ahL, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(f.b bVar) {
        Intent b = b(bVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.ahL, bVar.gid, bVar.title, bVar.content, bVar.ajs, PendingIntent.getService(this.ahL, bVar.gid, b, 134217728), false);
            TiebaStatic.log(new ao("c10321").r("obj_type", 1).af("obj_name", "show"));
        }
    }

    private void a(f.a aVar) {
        Intent b = b(aVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.ahL, aVar.gid, aVar.title, aVar.content, aVar.title, PendingIntent.getService(this.ahL, aVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (this.ahX) {
            if (i == 23 && this.ahR > 0) {
                e = cV(i);
            } else if (i == 26 && this.ahQ > 0) {
                e = cW(i);
            } else if (i == 18) {
                e = xc();
            } else {
                e = e(i, z);
            }
            e.setFlags(268435456);
            NotificationHelper.showNotification(this.ahL, i, str, str2, str3, PendingIntent.getService(this.ahL, i, e, 134217728), false);
        }
    }

    public Intent cV(int i) {
        Intent intent = new Intent(this.ahL, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.ahR);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cW(int i) {
        Intent intent = new Intent(this.ahL, DealIntentService.class);
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

    public Intent b(f.b bVar) {
        if (bVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ahL, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.gid);
        intent.putExtra("uname", bVar.ajt);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, bVar.userType);
        return intent;
    }

    public Intent b(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ahL, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.gid));
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.ahU.yB().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ahL, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.ahN);
        intent.putExtra("reply_me", this.ahM);
        intent.putExtra("fans", this.ahQ);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.ahU.yh() - this.ahU.yo());
        intent.putExtra("group_msg_validate", this.ahU.yk());
        intent.putExtra("group_msg_updates", this.ahU.yi());
        intent.putExtra("live_notify_msg_updates", this.ahU.yD());
        intent.putExtra("officialbar_msg", this.ahU.yl());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent xc() {
        Intent intent = new Intent(this.ahL, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.ahU.yj());
        return intent;
    }

    public void xd() {
        NotificationHelper.cancelNotification(this.ahL, 23);
        NotificationHelper.cancelNotification(this.ahL, 24);
        NotificationHelper.cancelNotification(this.ahL, 25);
        NotificationHelper.cancelNotification(this.ahL, 26);
        NotificationHelper.cancelNotification(this.ahL, 17);
        NotificationHelper.cancelNotification(this.ahL, 15);
        NotificationHelper.cancelNotification(this.ahL, 13);
        NotificationHelper.cancelNotification(this.ahL, 12);
    }

    public void xe() {
        NotificationHelper.cancelNotification(this.ahL, 16);
    }

    public void xf() {
        NotificationHelper.cancelNotification(this.ahL, 19);
    }

    public void cX(int i) {
        NotificationHelper.cancelNotification(this.ahL, i);
    }

    public int xg() {
        return this.ahU.yz();
    }

    public void dT(String str) {
        if (TextUtils.isEmpty(str)) {
            xe();
            return;
        }
        f xu = xu();
        if (xu == null) {
            xe();
            return;
        }
        HashMap<String, String> yv = xu.yv();
        if (yv == null || yv.isEmpty()) {
            xe();
        } else if (yv.containsKey(str)) {
            xe();
        }
    }

    public void dU(String str) {
        if (TextUtils.isEmpty(str)) {
            xe();
            return;
        }
        f xu = xu();
        if (xu == null) {
            xe();
            return;
        }
        HashMap<String, String> yB = xu.yB();
        if (yB == null || yB.isEmpty()) {
            xe();
        } else if (yB.containsKey(str)) {
            xe();
        }
    }

    private boolean xh() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean xi() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean xj() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void xk() {
        NotificationHelper.cancelNotification(this.ahL, 17);
    }

    public void cY(int i) {
        f xu = xu();
        if (xu == null) {
            xk();
        } else if (1 == i) {
            if (xu.yi() <= 0) {
                xk();
            }
        } else if (2 == i) {
            if (xu.yk() <= 0) {
                xk();
            }
        } else if (3 == i && xu.yD() <= 0) {
            NotificationHelper.cancelNotification(this.ahL, 21);
        }
    }

    public void xl() {
        NotificationHelper.cancelNotification(this.ahL, 18);
    }

    public void xm() {
        NotificationHelper.cancelNotification(this.ahL, 26);
        NotificationHelper.cancelNotification(this.ahL, 25);
        NotificationHelper.cancelNotification(this.ahL, 24);
        NotificationHelper.cancelNotification(this.ahL, 23);
        NotificationHelper.cancelNotification(this.ahL, 16);
        NotificationHelper.cancelNotification(this.ahL, 17);
    }

    public void xn() {
        NotificationHelper.cancelNotification(this.ahL, 21);
        NotificationHelper.cancelNotification(this.ahL, 17);
        NotificationHelper.cancelNotification(this.ahL, 19);
        NotificationHelper.cancelNotification(this.ahL, 16);
        NotificationHelper.cancelNotification(this.ahL, 18);
    }

    public void cZ(int i) {
        NotificationHelper.cancelNotification(this.ahL, i);
    }

    public void xo() {
        NotificationHelper.cancelNotification(this.ahL, 24);
    }

    public void xp() {
        NotificationHelper.cancelNotification(this.ahL, 25);
    }

    public void xq() {
        NotificationHelper.cancelNotification(this.ahL, 23);
    }

    public void xr() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(xs());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.ahU.yz());
        newsNotifyMessage.setMsgStrangerChat(this.ahU.yG());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(f fVar) {
        if (fVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((fVar.yz() + fVar.yh()) + fVar.yG()) + fVar.yF()) + fVar.yL()) - fVar.yo());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(fVar.yz());
            newsNotifyMessage.setMsgStrangerChat(fVar.yG());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.ahM;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.ahN, this.ahO, this.ahQ, this.ahP, this.ahR);
        }
    }

    public int getMsgAtme() {
        return this.ahN;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.ahM, i, this.ahO, this.ahQ, this.ahP, this.ahR);
        }
    }

    public int getMsgChat() {
        return this.ahO;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=5] */
    public int xs() {
        return ((((this.ahU.yz() + this.ahU.yh()) + this.ahU.yG()) + this.ahU.yF()) + this.ahU.yL()) - this.ahU.yo();
    }

    public int getMsgFans() {
        return this.ahQ;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.ahM, this.ahN, this.ahO, i, this.ahP, this.ahR);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.ahM, this.ahN, i, this.ahQ, this.ahP, this.ahR);
        }
    }

    public int getMsgBookmark() {
        return this.ahP;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.ahM, this.ahN, this.ahO, this.ahQ, i, this.ahR);
        }
    }

    public int getMsgGiftNum() {
        return this.ahR;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.ahR = i;
        }
    }

    public void da(int i) {
        if (i >= 0) {
            this.ahS += i;
            xr();
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.ahS = i;
            xr();
        }
    }

    public int getMsgLiveVip() {
        return this.ahS;
    }

    public void az(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.ahM = 0;
        this.ahN = 0;
        this.ahO = 0;
        this.ahQ = 0;
        this.ahP = 0;
    }

    public int xt() {
        return this.ahM + this.ahN + this.ahO + this.ahQ + this.ahR;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(f fVar) {
        long j;
        int yl;
        int i = 0;
        if (fVar != null) {
            this.ahU = fVar;
            this.ahO = (fVar.yh() - fVar.yo()) + fVar.yz() + fVar.yF() + fVar.yL();
            a(fVar);
            if (fVar.yp()) {
                this.ahV = null;
                mHandler.removeMessages(0);
            }
            if (fVar.yp()) {
                if (c.xw().xL() && c.xw().xz() > 0) {
                    i = fVar.yh() - fVar.yo();
                }
                if (c.xw().xE() && c.xw().xz() > 0) {
                    boolean xN = c.xw().xN();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = fVar.yz();
                    } else if (isFloatingWindowOpened) {
                        if (!xN || isProcessBackground) {
                            j = fVar.yz();
                        }
                    } else {
                        j = fVar.yz();
                    }
                    if ((i <= 0 || j > 0) && ((i > fVar.ys() - fVar.yo() && i > 0) || j > fVar.ym())) {
                        a(1, 16, fVar);
                    }
                    yl = fVar.yl();
                    if (yl > 0 && yl > fVar.yy()) {
                        a(1, 19, fVar);
                    }
                    if (fVar.yi() <= fVar.yw() || fVar.yk() > fVar.yx()) {
                        if (fVar.yi() > fVar.yw() || fVar.yk() != fVar.yx() || !xi()) {
                            if (fVar.yi() == fVar.yw() || fVar.yk() <= fVar.yx() || !xh()) {
                                a(1, 17, fVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (fVar.yD() > fVar.yE() && !xj()) {
                        TiebaStatic.eventStat(this.ahL, "message_broadcast_receive", "");
                        a(1, 21, fVar);
                    }
                    if (fVar.yH() <= fVar.yI()) {
                        a(1, 27, fVar);
                        return;
                    }
                    return;
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, fVar);
                yl = fVar.yl();
                if (yl > 0) {
                    a(1, 19, fVar);
                }
                if (fVar.yi() <= fVar.yw()) {
                }
                if (fVar.yi() > fVar.yw()) {
                }
                if (fVar.yi() == fVar.yw()) {
                }
                a(1, 17, fVar);
                if (fVar.yD() > fVar.yE()) {
                    TiebaStatic.eventStat(this.ahL, "message_broadcast_receive", "");
                    a(1, 21, fVar);
                }
                if (fVar.yH() <= fVar.yI()) {
                }
            }
        }
    }

    public f xu() {
        return this.ahU;
    }

    public void c(f fVar) {
        this.ahU = fVar;
    }

    public f xv() {
        return this.ahV;
    }
}
