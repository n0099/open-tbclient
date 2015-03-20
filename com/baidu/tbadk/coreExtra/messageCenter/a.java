package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.c.h;
import com.baidu.tbadk.coreExtra.c.i;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.y;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a abn;
    private static Date abq = null;
    private static Handler mHandler = new b();
    private h abp;
    private String abr;
    private String abt;
    private int abh = 0;
    private int abi = 0;
    private int abj = 0;
    private int abk = 0;
    private int abl = 0;
    private int abm = 0;
    private h abo = new h();
    private final int[] abu = new int[10];
    private final Context abg = TbadkCoreApplication.m411getInst().getApp();

    public static a uT() {
        if (abn == null) {
            abn = new a();
        }
        return abn;
    }

    private a() {
    }

    public void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            if (!StringUtils.isNull(optString)) {
                this.abr = optString;
            }
            if (!StringUtils.isNull(optString2)) {
                this.abt = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.abh || i2 != this.abi || i3 != this.abj || i4 != this.abl || i5 != this.abk || i6 != this.abm) {
            if (i > this.abh || i2 > this.abi || i3 > this.abj || i4 > this.abl || i5 > this.abk || i6 > this.abm) {
                i7 = 1;
            } else {
                i7 = (i < this.abh || i2 < this.abi) ? 2 : 0;
            }
            if (i > this.abh) {
                i8 = 1;
            } else {
                i8 = i < this.abh ? 2 : 0;
            }
            if (i2 > this.abi) {
                i9 = 1;
            } else {
                i9 = i2 < this.abi ? 2 : 0;
            }
            int i11 = i3 > this.abj ? 1 : 0;
            int i12 = i4 > this.abl ? 1 : 0;
            int i13 = i6 <= this.abm ? 0 : 1;
            this.abh = i;
            this.abi = i2;
            this.abj = i3;
            this.abl = i4;
            this.abk = i5;
            this.abm = i6;
            if (vn() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                vl();
                s(i10, 23);
                s(i11, 16);
                s(i7, 17);
                s(i8, 24);
                s(i9, 25);
                s(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.abh || i2 != this.abi || i3 != this.abj || i4 != this.abl || this.abm != i5) {
            this.abh = i;
            this.abi = i2;
            this.abj = i3;
            this.abl = i4;
            this.abm = i5;
            vl();
            if (vn() <= 0) {
                s(2, 16);
                s(2, 17);
            }
        }
    }

    public static boolean uU() {
        if (abq == null) {
            abq = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - abq.getTime() < 10000) {
                return false;
            }
            abq = date;
        }
        return true;
    }

    public static boolean uV() {
        if (c.vq().vB()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.vq().vD().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.vq().vE().split(":");
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

    private void s(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.abm > 0) {
                        String format = String.format(this.abg.getString(y.notify_gift), String.valueOf(this.abm));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.abh > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.abh > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.abh));
                            sb.append(this.abg.getString(y.notify_unit));
                            sb.append("]");
                        }
                        if (this.abr != null) {
                            sb.append(this.abr);
                        } else {
                            sb.append(this.abg.getString(y.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.abi > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.abi > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.abi));
                            sb2.append(this.abg.getString(y.notify_unit));
                            sb2.append("]");
                        }
                        if (this.abt != null) {
                            sb2.append(this.abt);
                        } else {
                            sb2.append(this.abg.getString(y.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.abl > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.abl > 1) {
                            sb3.append(String.format(this.abg.getString(y.notify_fans_unit), Integer.valueOf(this.abl)));
                        }
                        sb3.append(this.abg.getString(y.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.vq().vF()) {
                    c.vq().vt();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.abg, 16);
                NotificationHelper.cancelNotification(this.abg, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02c9 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:95:0x0248, B:97:0x0252, B:99:0x025c, B:101:0x0267, B:103:0x026d, B:105:0x0273, B:107:0x0281, B:108:0x029c, B:110:0x02a2, B:113:0x02aa, B:115:0x02c9, B:117:0x02d9, B:126:0x0321, B:123:0x0318, B:118:0x02ea, B:120:0x02f0, B:122:0x02f6, B:129:0x0342), top: B:136:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d9 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x006f, B:23:0x0073, B:24:0x0078, B:25:0x0087, B:28:0x0097, B:30:0x009b, B:32:0x00a4, B:33:0x00c2, B:35:0x00c6, B:36:0x00cb, B:37:0x00db, B:40:0x00eb, B:42:0x00ef, B:44:0x00f8, B:45:0x0113, B:47:0x0130, B:49:0x013a, B:51:0x0144, B:52:0x014e, B:54:0x0158, B:56:0x0162, B:60:0x016c, B:62:0x0174, B:65:0x01a4, B:67:0x01b2, B:68:0x01d1, B:70:0x01d7, B:71:0x01f5, B:74:0x01fc, B:76:0x0206, B:79:0x0214, B:81:0x021a, B:83:0x0220, B:84:0x0224, B:86:0x022a, B:88:0x0232, B:90:0x023a, B:92:0x023e, B:94:0x0244, B:95:0x0248, B:97:0x0252, B:99:0x025c, B:101:0x0267, B:103:0x026d, B:105:0x0273, B:107:0x0281, B:108:0x029c, B:110:0x02a2, B:113:0x02aa, B:115:0x02c9, B:117:0x02d9, B:126:0x0321, B:123:0x0318, B:118:0x02ea, B:120:0x02f0, B:122:0x02f6, B:129:0x0342), top: B:136:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, h hVar) {
        boolean z;
        String wk;
        String wj;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.abm > 0) {
                            String format = String.format(this.abg.getString(y.notify_gift), String.valueOf(this.abm));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.abh > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.abh > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.abh));
                                sb.append(this.abg.getString(y.notify_unit));
                                sb.append("]");
                            }
                            if (this.abr != null) {
                                sb.append(this.abr);
                            } else {
                                sb.append(this.abg.getString(y.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.abi > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.abi > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.abi));
                                sb2.append(this.abg.getString(y.notify_unit));
                                sb2.append("]");
                            }
                            if (this.abt != null) {
                                sb2.append(this.abt);
                            } else {
                                sb2.append(this.abg.getString(y.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.abl > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.abl > 1) {
                                sb3.append(String.format(this.abg.getString(y.notify_fans_unit), Integer.valueOf(this.abl)));
                            }
                            sb3.append(this.abg.getString(y.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int wa = (!c.vq().vF() || c.vq().vt() <= 0) ? 0 : hVar.wa() - hVar.wh();
                        long ws = (!c.vq().vy() || c.vq().vt() <= 0) ? 0L : hVar.ws();
                        boolean z4 = ws > 0;
                        long j = wa + ws;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.abg.getString(y.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            hVar.wv();
                            hVar.wt();
                            if (ws == 1) {
                                wk = hVar.wv();
                                str = hVar.wt();
                                wj = String.valueOf(wk) + "：" + str;
                            } else if (wa == 1) {
                                wk = hVar.wk();
                                wj = hVar.wj();
                                str = wj;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.abg.getString(y.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(wj)) {
                                wj = str;
                            }
                            a(16, wk, str, wj, z4);
                        }
                    } else if (i2 == 19) {
                        List<i> wA = hVar.wA();
                        if (wA != null && wA.size() != 0) {
                            for (i iVar : wA) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.acL) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (c.vq().vF() && c.vq().vt() > 0) {
                        if (hVar.wb() + hVar.wd() > 0) {
                            if (hVar.wb() > 0 && !vc()) {
                                long wb = hVar.wb() - hVar.wc();
                                if (wb > 0) {
                                    stringBuffer.append(String.format(this.abg.getString(y.notify_updates), Long.valueOf(wb)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.wc() > 0) {
                                    z = true;
                                }
                                if (hVar.wd() > 0 || vb()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.abg.getString(y.notify_validate), Integer.valueOf(hVar.wd())));
                                } else {
                                    stringBuffer.append(String.format(this.abg.getString(y.notify_validate_1), Integer.valueOf(hVar.wd())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.wm(), hVar.wn(), hVar.wn());
                                }
                            }
                            z = false;
                            if (hVar.wd() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.ww() > 0 && !vd()) {
                            String format2 = String.format(this.abg.getString(y.notify_live), Integer.valueOf(hVar.ww()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.abg, 16);
                    NotificationHelper.cancelNotification(this.abg, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(i iVar) {
        Intent b = b(iVar);
        if (b != null) {
            b.setFlags(268435456);
            NotificationHelper.showNotification(this.abg, iVar.gid, iVar.title, iVar.content, iVar.acJ, PendingIntent.getService(this.abg, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.abm > 0) {
            e = cA(i);
        } else if (i == 26 && this.abl > 0) {
            e = cB(i);
        } else if (i == 18) {
            e = uW();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.abg, i, str, str2, str3, PendingIntent.getService(this.abg, i, e, 134217728), false);
    }

    public Intent cA(int i) {
        Intent intent = new Intent(this.abg, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.abm);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cB(int i) {
        Intent intent = new Intent(this.abg, DealIntentService.class);
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

    public Intent b(i iVar) {
        if (iVar == null) {
            return null;
        }
        Intent intent = new Intent(this.abg, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, iVar.gid);
        intent.putExtra("uname", iVar.acK);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, iVar.userType);
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.abo.wu().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.abg, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.abi);
        intent.putExtra("reply_me", this.abh);
        intent.putExtra("fans", this.abl);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.abo.wa() - this.abo.wh());
        intent.putExtra("group_msg_validate", this.abo.wd());
        intent.putExtra("group_msg_updates", this.abo.wb());
        intent.putExtra("live_notify_msg_updates", this.abo.ww());
        intent.putExtra("officialbar_msg", this.abo.we());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent uW() {
        Intent intent = new Intent(this.abg, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.abo.wc());
        return intent;
    }

    public void uX() {
        NotificationHelper.cancelNotification(this.abg, 23);
        NotificationHelper.cancelNotification(this.abg, 24);
        NotificationHelper.cancelNotification(this.abg, 25);
        NotificationHelper.cancelNotification(this.abg, 26);
        NotificationHelper.cancelNotification(this.abg, 17);
        NotificationHelper.cancelNotification(this.abg, 15);
        NotificationHelper.cancelNotification(this.abg, 13);
        NotificationHelper.cancelNotification(this.abg, 12);
    }

    public void uY() {
        NotificationHelper.cancelNotification(this.abg, 16);
    }

    public void uZ() {
        NotificationHelper.cancelNotification(this.abg, 19);
    }

    public void cC(int i) {
        NotificationHelper.cancelNotification(this.abg, i);
    }

    public int va() {
        return this.abo.ws();
    }

    public void dp(String str) {
        if (TextUtils.isEmpty(str)) {
            uY();
            return;
        }
        h vo = vo();
        if (vo == null) {
            uY();
            return;
        }
        HashMap<String, String> wo = vo.wo();
        if (wo == null || wo.isEmpty()) {
            uY();
        } else if (wo.containsKey(str)) {
            uY();
        }
    }

    public void dq(String str) {
        if (TextUtils.isEmpty(str)) {
            uY();
            return;
        }
        h vo = vo();
        if (vo == null) {
            uY();
            return;
        }
        HashMap<String, String> wu = vo.wu();
        if (wu == null || wu.isEmpty()) {
            uY();
        } else if (wu.containsKey(str)) {
            uY();
        }
    }

    private boolean vb() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean vc() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean vd() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void ve() {
        NotificationHelper.cancelNotification(this.abg, 17);
    }

    public void cD(int i) {
        h vo = vo();
        if (vo == null) {
            ve();
        } else if (1 == i) {
            if (vo.wb() <= 0) {
                ve();
            }
        } else if (2 == i) {
            if (vo.wd() <= 0) {
                ve();
            }
        } else if (3 == i && vo.ww() <= 0) {
            NotificationHelper.cancelNotification(this.abg, 21);
        }
    }

    public void vf() {
        NotificationHelper.cancelNotification(this.abg, 18);
    }

    public void vg() {
        NotificationHelper.cancelNotification(this.abg, 26);
        NotificationHelper.cancelNotification(this.abg, 25);
        NotificationHelper.cancelNotification(this.abg, 24);
        NotificationHelper.cancelNotification(this.abg, 23);
        NotificationHelper.cancelNotification(this.abg, 16);
        NotificationHelper.cancelNotification(this.abg, 17);
    }

    public void vh() {
        NotificationHelper.cancelNotification(this.abg, 21);
        NotificationHelper.cancelNotification(this.abg, 17);
        NotificationHelper.cancelNotification(this.abg, 19);
        NotificationHelper.cancelNotification(this.abg, 16);
        NotificationHelper.cancelNotification(this.abg, 18);
    }

    public void vi() {
        NotificationHelper.cancelNotification(this.abg, 24);
    }

    public void vj() {
        NotificationHelper.cancelNotification(this.abg, 25);
    }

    public void vk() {
        NotificationHelper.cancelNotification(this.abg, 23);
    }

    public void vl() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(vm());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.abo.ws());
        newsNotifyMessage.setMsgStrangerChat(this.abo.wz());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.ws() + hVar.wa()) + hVar.wz()) + hVar.wy()) + hVar.wB()) - hVar.wh());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(hVar.ws());
            newsNotifyMessage.setMsgStrangerChat(hVar.wz());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.abh;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.abi, this.abj, this.abl, this.abk, this.abm);
        }
    }

    public int getMsgAtme() {
        return this.abi;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.abh, i, this.abj, this.abl, this.abk, this.abm);
        }
    }

    public int getMsgChat() {
        return this.abj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [940=5] */
    public int vm() {
        return ((((this.abo.ws() + this.abo.wa()) + this.abo.wz()) + this.abo.wy()) + this.abo.wB()) - this.abo.wh();
    }

    public int getMsgFans() {
        return this.abl;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.abh, this.abi, this.abj, i, this.abk, this.abm);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.abh, this.abi, i, this.abl, this.abk, this.abm);
        }
    }

    public int getMsgBookmark() {
        return this.abk;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.abh, this.abi, this.abj, this.abl, i, this.abm);
        }
    }

    public int getMsgGiftNum() {
        return this.abm;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.abm = i;
        }
    }

    public void ao(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.abh = 0;
        this.abi = 0;
        this.abj = 0;
        this.abl = 0;
        this.abk = 0;
    }

    public int vn() {
        return this.abh + this.abi + this.abj + this.abl + this.abm;
    }

    public void b(h hVar) {
        long j;
        int we;
        int i = 0;
        if (hVar != null) {
            this.abo = hVar;
            this.abj = (hVar.wa() - hVar.wh()) + hVar.ws() + hVar.wy() + hVar.wB();
            a(hVar);
            if (hVar.wi()) {
                this.abp = null;
                mHandler.removeMessages(0);
            }
            if (hVar.wi()) {
                if (c.vq().vF() && c.vq().vt() > 0) {
                    i = hVar.wa() - hVar.wh();
                }
                if (c.vq().vy() && c.vq().vt() > 0) {
                    boolean vH = c.vq().vH();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.ws();
                    } else if (isFloatingWindowOpened) {
                        if (!vH || isProcessBackground) {
                            j = hVar.ws();
                        }
                    } else {
                        j = hVar.ws();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.wl() - hVar.wh() && i > 0) || j > hVar.wf())) {
                        a(1, 16, hVar);
                    }
                    we = hVar.we();
                    if (we > 0 && we > hVar.wr()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.wb() <= hVar.wp() || hVar.wd() > hVar.wq()) {
                        if (hVar.wb() > hVar.wp() || hVar.wd() != hVar.wq() || !vc()) {
                            if (hVar.wb() == hVar.wp() || hVar.wd() <= hVar.wq() || !vb()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.ww() <= hVar.wx() && !vd()) {
                        TiebaStatic.eventStat(this.abg, "message_broadcast_receive", "");
                        a(1, 21, hVar);
                        return;
                    }
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                we = hVar.we();
                if (we > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.wb() <= hVar.wp()) {
                }
                if (hVar.wb() > hVar.wp()) {
                }
                if (hVar.wb() == hVar.wp()) {
                }
                a(1, 17, hVar);
                if (hVar.ww() <= hVar.wx()) {
                }
            }
        }
    }

    public h vo() {
        return this.abo;
    }

    public void c(h hVar) {
        this.abo = hVar;
    }

    public h vp() {
        return this.abp;
    }
}
