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
    private static a abw;
    private static Date abz = null;
    private static Handler mHandler = new b();
    private String abA;
    private String abB;
    private h aby;
    private int abp = 0;
    private int abq = 0;
    private int abr = 0;
    private int abt = 0;
    private int abu = 0;
    private int abv = 0;
    private h abx = new h();
    private final int[] abC = new int[10];
    private final Context abo = TbadkCoreApplication.m411getInst().getApp();

    public static a uZ() {
        if (abw == null) {
            abw = new a();
        }
        return abw;
    }

    private a() {
    }

    public void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("absmsg")) != null) {
            String optString = optJSONObject.optString("replyme");
            String optString2 = optJSONObject.optString("atme");
            if (!StringUtils.isNull(optString)) {
                this.abA = optString;
            }
            if (!StringUtils.isNull(optString2)) {
                this.abB = optString2;
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.abp || i2 != this.abq || i3 != this.abr || i4 != this.abu || i5 != this.abt || i6 != this.abv) {
            if (i > this.abp || i2 > this.abq || i3 > this.abr || i4 > this.abu || i5 > this.abt || i6 > this.abv) {
                i7 = 1;
            } else {
                i7 = (i < this.abp || i2 < this.abq) ? 2 : 0;
            }
            if (i > this.abp) {
                i8 = 1;
            } else {
                i8 = i < this.abp ? 2 : 0;
            }
            if (i2 > this.abq) {
                i9 = 1;
            } else {
                i9 = i2 < this.abq ? 2 : 0;
            }
            int i11 = i3 > this.abr ? 1 : 0;
            int i12 = i4 > this.abu ? 1 : 0;
            int i13 = i6 <= this.abv ? 0 : 1;
            this.abp = i;
            this.abq = i2;
            this.abr = i3;
            this.abu = i4;
            this.abt = i5;
            this.abv = i6;
            if (vt() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                vr();
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
        if (i != this.abp || i2 != this.abq || i3 != this.abr || i4 != this.abu || this.abv != i5) {
            this.abp = i;
            this.abq = i2;
            this.abr = i3;
            this.abu = i4;
            this.abv = i5;
            vr();
            if (vt() <= 0) {
                s(2, 16);
                s(2, 17);
            }
        }
    }

    public static boolean va() {
        if (abz == null) {
            abz = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - abz.getTime() < 10000) {
                return false;
            }
            abz = date;
        }
        return true;
    }

    public static boolean vb() {
        if (c.vw().vH()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.vw().vJ().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.vw().vK().split(":");
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
                    if (this.abv > 0) {
                        String format = String.format(this.abo.getString(y.notify_gift), String.valueOf(this.abv));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.abp > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.abp > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.abp));
                            sb.append(this.abo.getString(y.notify_unit));
                            sb.append("]");
                        }
                        if (this.abA != null) {
                            sb.append(this.abA);
                        } else {
                            sb.append(this.abo.getString(y.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.abq > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.abq > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.abq));
                            sb2.append(this.abo.getString(y.notify_unit));
                            sb2.append("]");
                        }
                        if (this.abB != null) {
                            sb2.append(this.abB);
                        } else {
                            sb2.append(this.abo.getString(y.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.abu > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.abu > 1) {
                            sb3.append(String.format(this.abo.getString(y.notify_fans_unit), Integer.valueOf(this.abu)));
                        }
                        sb3.append(this.abo.getString(y.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 != 16 && c.vw().vL()) {
                    c.vw().vz();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.abo, 16);
                NotificationHelper.cancelNotification(this.abo, 17);
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
        String wq;
        String wp;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.abv > 0) {
                            String format = String.format(this.abo.getString(y.notify_gift), String.valueOf(this.abv));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.abp > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.abp > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.abp));
                                sb.append(this.abo.getString(y.notify_unit));
                                sb.append("]");
                            }
                            if (this.abA != null) {
                                sb.append(this.abA);
                            } else {
                                sb.append(this.abo.getString(y.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.abq > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.abq > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.abq));
                                sb2.append(this.abo.getString(y.notify_unit));
                                sb2.append("]");
                            }
                            if (this.abB != null) {
                                sb2.append(this.abB);
                            } else {
                                sb2.append(this.abo.getString(y.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.abu > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.abu > 1) {
                                sb3.append(String.format(this.abo.getString(y.notify_fans_unit), Integer.valueOf(this.abu)));
                            }
                            sb3.append(this.abo.getString(y.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int wg = (!c.vw().vL() || c.vw().vz() <= 0) ? 0 : hVar.wg() - hVar.wn();
                        long wy = (!c.vw().vE() || c.vw().vz() <= 0) ? 0L : hVar.wy();
                        boolean z4 = wy > 0;
                        long j = wg + wy;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.abo.getString(y.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            hVar.wB();
                            hVar.wz();
                            if (wy == 1) {
                                wq = hVar.wB();
                                str = hVar.wz();
                                wp = String.valueOf(wq) + "：" + str;
                            } else if (wg == 1) {
                                wq = hVar.wq();
                                wp = hVar.wp();
                                str = wp;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.abo.getString(y.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(wp)) {
                                wp = str;
                            }
                            a(16, wq, str, wp, z4);
                        }
                    } else if (i2 == 19) {
                        List<i> wG = hVar.wG();
                        if (wG != null && wG.size() != 0) {
                            for (i iVar : wG) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.acT) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (c.vw().vL() && c.vw().vz() > 0) {
                        if (hVar.wh() + hVar.wj() > 0) {
                            if (hVar.wh() > 0 && !vi()) {
                                long wh = hVar.wh() - hVar.wi();
                                if (wh > 0) {
                                    stringBuffer.append(String.format(this.abo.getString(y.notify_updates), Long.valueOf(wh)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.wi() > 0) {
                                    z = true;
                                }
                                if (hVar.wj() > 0 || vh()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.abo.getString(y.notify_validate), Integer.valueOf(hVar.wj())));
                                } else {
                                    stringBuffer.append(String.format(this.abo.getString(y.notify_validate_1), Integer.valueOf(hVar.wj())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.ws(), hVar.wt(), hVar.wt());
                                }
                            }
                            z = false;
                            if (hVar.wj() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.wC() > 0 && !vj()) {
                            String format2 = String.format(this.abo.getString(y.notify_live), Integer.valueOf(hVar.wC()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.abo, 16);
                    NotificationHelper.cancelNotification(this.abo, 17);
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
            NotificationHelper.showNotification(this.abo, iVar.gid, iVar.title, iVar.content, iVar.acR, PendingIntent.getService(this.abo, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.abv > 0) {
            e = cA(i);
        } else if (i == 26 && this.abu > 0) {
            e = cB(i);
        } else if (i == 18) {
            e = vc();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.abo, i, str, str2, str3, PendingIntent.getService(this.abo, i, e, 134217728), false);
    }

    public Intent cA(int i) {
        Intent intent = new Intent(this.abo, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.abv);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cB(int i) {
        Intent intent = new Intent(this.abo, DealIntentService.class);
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
        Intent intent = new Intent(this.abo, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, iVar.gid);
        intent.putExtra("uname", iVar.acS);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, iVar.userType);
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.abx.wA().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.abo, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.abq);
        intent.putExtra("reply_me", this.abp);
        intent.putExtra("fans", this.abu);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.abx.wg() - this.abx.wn());
        intent.putExtra("group_msg_validate", this.abx.wj());
        intent.putExtra("group_msg_updates", this.abx.wh());
        intent.putExtra("live_notify_msg_updates", this.abx.wC());
        intent.putExtra("officialbar_msg", this.abx.wk());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent vc() {
        Intent intent = new Intent(this.abo, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.abx.wi());
        return intent;
    }

    public void vd() {
        NotificationHelper.cancelNotification(this.abo, 23);
        NotificationHelper.cancelNotification(this.abo, 24);
        NotificationHelper.cancelNotification(this.abo, 25);
        NotificationHelper.cancelNotification(this.abo, 26);
        NotificationHelper.cancelNotification(this.abo, 17);
        NotificationHelper.cancelNotification(this.abo, 15);
        NotificationHelper.cancelNotification(this.abo, 13);
        NotificationHelper.cancelNotification(this.abo, 12);
    }

    public void ve() {
        NotificationHelper.cancelNotification(this.abo, 16);
    }

    public void vf() {
        NotificationHelper.cancelNotification(this.abo, 19);
    }

    public void cC(int i) {
        NotificationHelper.cancelNotification(this.abo, i);
    }

    public int vg() {
        return this.abx.wy();
    }

    public void ds(String str) {
        if (TextUtils.isEmpty(str)) {
            ve();
            return;
        }
        h vu = vu();
        if (vu == null) {
            ve();
            return;
        }
        HashMap<String, String> wu = vu.wu();
        if (wu == null || wu.isEmpty()) {
            ve();
        } else if (wu.containsKey(str)) {
            ve();
        }
    }

    public void dt(String str) {
        if (TextUtils.isEmpty(str)) {
            ve();
            return;
        }
        h vu = vu();
        if (vu == null) {
            ve();
            return;
        }
        HashMap<String, String> wA = vu.wA();
        if (wA == null || wA.isEmpty()) {
            ve();
        } else if (wA.containsKey(str)) {
            ve();
        }
    }

    private boolean vh() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean vi() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean vj() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void vk() {
        NotificationHelper.cancelNotification(this.abo, 17);
    }

    public void cD(int i) {
        h vu = vu();
        if (vu == null) {
            vk();
        } else if (1 == i) {
            if (vu.wh() <= 0) {
                vk();
            }
        } else if (2 == i) {
            if (vu.wj() <= 0) {
                vk();
            }
        } else if (3 == i && vu.wC() <= 0) {
            NotificationHelper.cancelNotification(this.abo, 21);
        }
    }

    public void vl() {
        NotificationHelper.cancelNotification(this.abo, 18);
    }

    public void vm() {
        NotificationHelper.cancelNotification(this.abo, 26);
        NotificationHelper.cancelNotification(this.abo, 25);
        NotificationHelper.cancelNotification(this.abo, 24);
        NotificationHelper.cancelNotification(this.abo, 23);
        NotificationHelper.cancelNotification(this.abo, 16);
        NotificationHelper.cancelNotification(this.abo, 17);
    }

    public void vn() {
        NotificationHelper.cancelNotification(this.abo, 21);
        NotificationHelper.cancelNotification(this.abo, 17);
        NotificationHelper.cancelNotification(this.abo, 19);
        NotificationHelper.cancelNotification(this.abo, 16);
        NotificationHelper.cancelNotification(this.abo, 18);
    }

    public void vo() {
        NotificationHelper.cancelNotification(this.abo, 24);
    }

    public void vp() {
        NotificationHelper.cancelNotification(this.abo, 25);
    }

    public void vq() {
        NotificationHelper.cancelNotification(this.abo, 23);
    }

    public void vr() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(vs());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.abx.wy());
        newsNotifyMessage.setMsgStrangerChat(this.abx.wF());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.wy() + hVar.wg()) + hVar.wF()) + hVar.wE()) + hVar.wH()) - hVar.wn());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(hVar.wy());
            newsNotifyMessage.setMsgStrangerChat(hVar.wF());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.abp;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.abq, this.abr, this.abu, this.abt, this.abv);
        }
    }

    public int getMsgAtme() {
        return this.abq;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.abp, i, this.abr, this.abu, this.abt, this.abv);
        }
    }

    public int getMsgChat() {
        return this.abr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [940=5] */
    public int vs() {
        return ((((this.abx.wy() + this.abx.wg()) + this.abx.wF()) + this.abx.wE()) + this.abx.wH()) - this.abx.wn();
    }

    public int getMsgFans() {
        return this.abu;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.abp, this.abq, this.abr, i, this.abt, this.abv);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.abp, this.abq, i, this.abu, this.abt, this.abv);
        }
    }

    public int getMsgBookmark() {
        return this.abt;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.abp, this.abq, this.abr, this.abu, i, this.abv);
        }
    }

    public int getMsgGiftNum() {
        return this.abv;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.abv = i;
        }
    }

    public void ao(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.abp = 0;
        this.abq = 0;
        this.abr = 0;
        this.abu = 0;
        this.abt = 0;
    }

    public int vt() {
        return this.abp + this.abq + this.abr + this.abu + this.abv;
    }

    public void b(h hVar) {
        long j;
        int wk;
        int i = 0;
        if (hVar != null) {
            this.abx = hVar;
            this.abr = (hVar.wg() - hVar.wn()) + hVar.wy() + hVar.wE() + hVar.wH();
            a(hVar);
            if (hVar.wo()) {
                this.aby = null;
                mHandler.removeMessages(0);
            }
            if (hVar.wo()) {
                if (c.vw().vL() && c.vw().vz() > 0) {
                    i = hVar.wg() - hVar.wn();
                }
                if (c.vw().vE() && c.vw().vz() > 0) {
                    boolean vN = c.vw().vN();
                    boolean isProcessBackground = TbadkCoreApplication.m411getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m411getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.wy();
                    } else if (isFloatingWindowOpened) {
                        if (!vN || isProcessBackground) {
                            j = hVar.wy();
                        }
                    } else {
                        j = hVar.wy();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.wr() - hVar.wn() && i > 0) || j > hVar.wl())) {
                        a(1, 16, hVar);
                    }
                    wk = hVar.wk();
                    if (wk > 0 && wk > hVar.wx()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.wh() <= hVar.wv() || hVar.wj() > hVar.ww()) {
                        if (hVar.wh() > hVar.wv() || hVar.wj() != hVar.ww() || !vi()) {
                            if (hVar.wh() == hVar.wv() || hVar.wj() <= hVar.ww() || !vh()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.wC() <= hVar.wD() && !vj()) {
                        TiebaStatic.eventStat(this.abo, "message_broadcast_receive", "");
                        a(1, 21, hVar);
                        return;
                    }
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                wk = hVar.wk();
                if (wk > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.wh() <= hVar.wv()) {
                }
                if (hVar.wh() > hVar.wv()) {
                }
                if (hVar.wh() == hVar.wv()) {
                }
                a(1, 17, hVar);
                if (hVar.wC() <= hVar.wD()) {
                }
            }
        }
    }

    public h vu() {
        return this.abx;
    }

    public void c(h hVar) {
        this.abx = hVar;
    }

    public h vv() {
        return this.aby;
    }
}
