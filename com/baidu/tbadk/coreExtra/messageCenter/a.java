package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.c.h;
import com.baidu.tbadk.coreExtra.c.i;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.z;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static a QY;
    public static boolean Rc;
    public static boolean Rd;
    public static boolean Re;
    private h Ra;
    private static Date Rb = null;
    private static Handler mHandler = new b();
    private int QS = 0;
    private int QT = 0;
    private int QU = 0;
    private int QV = 0;
    private int QW = 0;
    private int QX = 0;
    private h QZ = new h();
    private final int[] Rf = new int[10];
    private final Context QR = TbadkCoreApplication.m255getInst().getApp();

    public static a rI() {
        if (QY == null) {
            QY = new a();
        }
        return QY;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.QS || i2 != this.QT || i3 != this.QU || i4 != this.QW || i5 != this.QV || i6 != this.QX) {
            int i7 = 0;
            if (i > this.QS || i2 > this.QT || i3 > this.QU || i4 > this.QW || i5 > this.QV || i6 > this.QX) {
                i7 = 1;
            } else if (i < this.QS || i2 < this.QT) {
                i7 = 2;
            }
            this.QS = i;
            this.QT = i2;
            this.QU = i3;
            this.QW = i4;
            this.QV = i5;
            this.QX = i6;
            int i8 = sb() > 0 ? i7 : 2;
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                rZ();
                u(i8, 23);
                u(i8, 16);
                u(i8, 17);
                u(i8, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.QS || i2 != this.QT || i3 != this.QU || i4 != this.QW || this.QX != i5) {
            this.QS = i;
            this.QT = i2;
            this.QU = i3;
            this.QW = i4;
            this.QX = i5;
            rZ();
            if (sb() <= 0) {
                u(2, 16);
                u(2, 17);
                u(2, 11);
            }
        }
    }

    public static boolean rJ() {
        if (Rb == null) {
            Rb = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - Rb.getTime() < 10000) {
                return false;
            }
            Rb = date;
        }
        return true;
    }

    public static boolean rK() {
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        if (m255getInst.isNoDisturbOn()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = m255getInst.getNoDisturbStartTime().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = m255getInst.getNoDisturbEndTime().split(":");
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

    private void u(int i, int i2) {
        try {
            if (i == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 23) {
                    if (this.QX > 0) {
                        String format = String.format(this.QR.getString(z.notify_gift), String.valueOf(this.QX));
                        a(23, null, format, format);
                    }
                } else if (i2 == 11) {
                    if (this.QS > 0 || this.QT > 0 || this.QW > 0) {
                        int i3 = this.QS + this.QT;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.QR.getString(z.notify_msg));
                        }
                        if (this.QW > 0) {
                            stringBuffer.append(String.valueOf(this.QW));
                            stringBuffer.append(this.QR.getString(z.notify_fans));
                        }
                        stringBuffer.append(this.QR.getString(z.notify_click));
                        a(11, null, stringBuffer.toString(), stringBuffer.toString());
                    }
                } else if (i2 != 16 && TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                    TbadkCoreApplication.m255getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.QR, 11);
                NotificationHelper.cancelNotification(this.QR, 16);
                NotificationHelper.cancelNotification(this.QR, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x023b A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x0038, B:14:0x003c, B:16:0x0040, B:18:0x0044, B:20:0x004b, B:21:0x005d, B:23:0x0061, B:24:0x0075, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:34:0x00ba, B:36:0x00c6, B:38:0x00d0, B:42:0x00dc, B:44:0x00e4, B:47:0x0114, B:49:0x0122, B:50:0x0141, B:52:0x0147, B:53:0x0165, B:56:0x016c, B:58:0x0176, B:61:0x0184, B:63:0x018a, B:65:0x0190, B:66:0x0194, B:68:0x019a, B:70:0x01a2, B:72:0x01aa, B:74:0x01ae, B:76:0x01b4, B:77:0x01b8, B:79:0x01c2, B:81:0x01cc, B:83:0x01d7, B:85:0x01dd, B:87:0x01e3, B:89:0x01f3, B:90:0x020e, B:92:0x0214, B:95:0x021c, B:97:0x023b, B:99:0x024b, B:108:0x0293, B:105:0x028a, B:100:0x025c, B:102:0x0262, B:104:0x0268, B:111:0x02b4), top: B:117:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024b A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:12:0x0038, B:14:0x003c, B:16:0x0040, B:18:0x0044, B:20:0x004b, B:21:0x005d, B:23:0x0061, B:24:0x0075, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:34:0x00ba, B:36:0x00c6, B:38:0x00d0, B:42:0x00dc, B:44:0x00e4, B:47:0x0114, B:49:0x0122, B:50:0x0141, B:52:0x0147, B:53:0x0165, B:56:0x016c, B:58:0x0176, B:61:0x0184, B:63:0x018a, B:65:0x0190, B:66:0x0194, B:68:0x019a, B:70:0x01a2, B:72:0x01aa, B:74:0x01ae, B:76:0x01b4, B:77:0x01b8, B:79:0x01c2, B:81:0x01cc, B:83:0x01d7, B:85:0x01dd, B:87:0x01e3, B:89:0x01f3, B:90:0x020e, B:92:0x0214, B:95:0x021c, B:97:0x023b, B:99:0x024b, B:108:0x0293, B:105:0x028a, B:100:0x025c, B:102:0x0262, B:104:0x0268, B:111:0x02b4), top: B:117:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, h hVar) {
        boolean z;
        String sD;
        String sC;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23 && this.QX > 0) {
                        String format = String.format(this.QR.getString(z.notify_gift), String.valueOf(this.QX));
                        a(23, null, format, format);
                    }
                    if (i2 == 11) {
                        if (this.QS > 0 || this.QT > 0 || this.QW > 0) {
                            int i3 = this.QS + this.QT;
                            if (i3 > 0) {
                                stringBuffer.append(String.valueOf(i3));
                                stringBuffer.append(this.QR.getString(z.notify_msg));
                            }
                            if (this.QW > 0) {
                                stringBuffer.append(String.valueOf(this.QW));
                                stringBuffer.append(this.QR.getString(z.notify_fans));
                            }
                            stringBuffer.append(this.QR.getString(z.notify_click));
                            a(11, null, stringBuffer.toString(), stringBuffer.toString());
                        }
                    } else if (i2 == 16) {
                        int st = (!TbadkCoreApplication.m255getInst().isGroupMsgOn() || TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) ? 0 : hVar.st() - hVar.sA();
                        long j = 0;
                        if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                            j = hVar.sL();
                        }
                        boolean z4 = j > 0;
                        long j2 = st + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.QR.getString(z.notify_chat), Long.valueOf(j2)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            hVar.sO();
                            hVar.sM();
                            if (j == 1) {
                                sD = hVar.sO();
                                str = hVar.sM();
                                sC = String.valueOf(sD) + "：" + str;
                            } else if (st == 1) {
                                sD = hVar.sD();
                                sC = hVar.sC();
                                str = sC;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.QR.getString(z.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(sC)) {
                                sC = str;
                            }
                            a(16, sD, str, sC, z4);
                        }
                    } else if (i2 == 19) {
                        List<i> sT = hVar.sT();
                        if (sT != null && sT.size() != 0) {
                            for (i iVar : sT) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.Sh) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                        if (hVar.su() + hVar.sw() > 0) {
                            if (hVar.su() > 0 && !rR()) {
                                long su = hVar.su() - hVar.sv();
                                if (su > 0) {
                                    stringBuffer.append(String.format(this.QR.getString(z.notify_updates), Long.valueOf(su)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.sv() > 0) {
                                    z = true;
                                }
                                if (hVar.sw() > 0 || rQ()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.QR.getString(z.notify_validate), Integer.valueOf(hVar.sw())));
                                } else {
                                    stringBuffer.append(String.format(this.QR.getString(z.notify_validate_1), Integer.valueOf(hVar.sw())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.sF(), hVar.sG(), hVar.sG());
                                }
                            }
                            z = false;
                            if (hVar.sw() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.sP() > 0 && !rS()) {
                            String format2 = String.format(this.QR.getString(z.notify_live), Integer.valueOf(hVar.sP()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.QR, 11);
                    NotificationHelper.cancelNotification(this.QR, 16);
                    NotificationHelper.cancelNotification(this.QR, 17);
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
            NotificationHelper.showNotification(this.QR, iVar.gid, iVar.title, iVar.content, iVar.content, PendingIntent.getService(this.QR, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.QX > 0) {
            e = cu(i);
        } else if (i == 11 && this.QW > 0 && this.QS == 0 && this.QT == 0) {
            e = cv(i);
        } else if (i == 18) {
            e = rL();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.QR, i, str, str2, str3, PendingIntent.getService(this.QR, i, e, 134217728), false);
    }

    private Intent cu(int i) {
        Intent intent = new Intent(this.QR, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.QX);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    private Intent cv(int i) {
        Intent intent = new Intent(this.QR, DealIntentService.class);
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

    private Intent b(i iVar) {
        if (iVar == null) {
            return null;
        }
        Intent intent = new Intent(this.QR, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, iVar.gid);
        intent.putExtra("uname", iVar.Sg);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, iVar.userType);
        return intent;
    }

    private Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.QZ.sN().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.QR, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.QT);
        intent.putExtra("reply_me", this.QS);
        intent.putExtra("fans", this.QW);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.QZ.st() - this.QZ.sA());
        intent.putExtra("group_msg_validate", this.QZ.sw());
        intent.putExtra("group_msg_updates", this.QZ.su());
        intent.putExtra("live_notify_msg_updates", this.QZ.sP());
        intent.putExtra("officialbar_msg", this.QZ.sx());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent rL() {
        Intent intent = new Intent(this.QR, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.QZ.sv());
        return intent;
    }

    public void rM() {
        NotificationHelper.cancelNotification(this.QR, 11);
        NotificationHelper.cancelNotification(this.QR, 16);
        NotificationHelper.cancelNotification(this.QR, 17);
        NotificationHelper.cancelNotification(this.QR, 15);
        NotificationHelper.cancelNotification(this.QR, 13);
        NotificationHelper.cancelNotification(this.QR, 12);
    }

    public void rN() {
        NotificationHelper.cancelNotification(this.QR, 16);
    }

    public void rO() {
        NotificationHelper.cancelNotification(this.QR, 19);
    }

    public void cw(int i) {
        NotificationHelper.cancelNotification(this.QR, i);
    }

    public int rP() {
        return this.QZ.sL();
    }

    public void dm(String str) {
        if (TextUtils.isEmpty(str)) {
            rN();
            return;
        }
        h sc = sc();
        if (sc == null) {
            rN();
            return;
        }
        HashMap<String, String> sH = sc.sH();
        if (sH == null || sH.isEmpty()) {
            rN();
        } else if (sH.containsKey(str)) {
            rN();
        }
    }

    public void dn(String str) {
        if (TextUtils.isEmpty(str)) {
            rN();
            return;
        }
        h sc = sc();
        if (sc == null) {
            rN();
            return;
        }
        HashMap<String, String> sN = sc.sN();
        if (sN == null || sN.isEmpty()) {
            rN();
        } else if (sN.containsKey(str)) {
            rN();
        }
    }

    private boolean rQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return Rc;
    }

    private boolean rR() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return Rd;
    }

    private boolean rS() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return Re;
    }

    public void rT() {
        NotificationHelper.cancelNotification(this.QR, 17);
    }

    public void cx(int i) {
        h sc = sc();
        if (sc == null) {
            rT();
        } else if (1 == i) {
            if (sc.su() <= 0) {
                rT();
            }
        } else if (2 == i) {
            if (sc.sw() <= 0) {
                rT();
            }
        } else if (3 == i && sc.sP() <= 0) {
            NotificationHelper.cancelNotification(this.QR, 21);
        }
    }

    public void rU() {
        NotificationHelper.cancelNotification(this.QR, 18);
    }

    public void rV() {
        NotificationHelper.cancelNotification(this.QR, 11);
        NotificationHelper.cancelNotification(this.QR, 16);
        NotificationHelper.cancelNotification(this.QR, 17);
    }

    public void rW() {
        NotificationHelper.cancelNotification(this.QR, 21);
        NotificationHelper.cancelNotification(this.QR, 17);
        NotificationHelper.cancelNotification(this.QR, 19);
        NotificationHelper.cancelNotification(this.QR, 16);
        NotificationHelper.cancelNotification(this.QR, 18);
    }

    public void rX() {
        NotificationHelper.cancelNotification(this.QR, 11);
    }

    public void rY() {
        NotificationHelper.cancelNotification(this.QR, 23);
    }

    public void rZ() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(sa());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.QZ.sL());
        newsNotifyMessage.setMsgStrangerChat(this.QZ.sS());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.sL() + hVar.st()) + hVar.sS()) + hVar.sR()) + hVar.sU()) - hVar.sA());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(hVar.sL());
            newsNotifyMessage.setMsgStrangerChat(hVar.sS());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.QS;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.QT, this.QU, this.QW, this.QV, this.QX);
        }
    }

    public int getMsgAtme() {
        return this.QT;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.QS, i, this.QU, this.QW, this.QV, this.QX);
        }
    }

    public int getMsgChat() {
        return this.QU;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=5] */
    public int sa() {
        return ((((this.QZ.sL() + this.QZ.st()) + this.QZ.sS()) + this.QZ.sR()) + this.QZ.sU()) - this.QZ.sA();
    }

    public int getMsgFans() {
        return this.QW;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.QS, this.QT, this.QU, i, this.QV, this.QX);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.QS, this.QT, i, this.QW, this.QV, this.QX);
        }
    }

    public int getMsgBookmark() {
        return this.QV;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.QS, this.QT, this.QU, this.QW, i, this.QX);
        }
    }

    public int getMsgGiftNum() {
        return this.QX;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.QX = i;
        }
    }

    public void at(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.QS = 0;
        this.QT = 0;
        this.QU = 0;
        this.QW = 0;
        this.QV = 0;
    }

    public int sb() {
        return this.QS + this.QT + this.QU + this.QW + this.QX;
    }

    public void b(h hVar) {
        long j;
        int sx;
        int i = 0;
        if (hVar != null) {
            this.QZ = hVar;
            this.QU = (hVar.st() - hVar.sA()) + hVar.sL() + hVar.sR() + hVar.sU();
            a(hVar);
            if (hVar.sB()) {
                this.Ra = null;
                mHandler.removeMessages(0);
            }
            if (hVar.sB()) {
                if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    i = hVar.st() - hVar.sA();
                }
                if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    boolean chatFloatWindowLocked = TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
                    boolean isProcessBackground = TbadkCoreApplication.m255getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m255getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.sL();
                    } else if (isFloatingWindowOpened) {
                        if (!chatFloatWindowLocked || isProcessBackground) {
                            j = hVar.sL();
                        }
                    } else {
                        j = hVar.sL();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.sE() - hVar.sA() && i > 0) || j > hVar.sy())) {
                        a(1, 16, hVar);
                    }
                    sx = hVar.sx();
                    if (sx > 0 && sx > hVar.sK()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.su() <= hVar.sI() || hVar.sw() > hVar.sJ()) {
                        if (hVar.su() > hVar.sI() || hVar.sw() != hVar.sJ() || !rR()) {
                            if (hVar.su() == hVar.sI() || hVar.sw() <= hVar.sJ() || !rQ()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.sP() <= hVar.sQ() && !rS()) {
                        a(1, 21, hVar);
                        return;
                    }
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                sx = hVar.sx();
                if (sx > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.su() <= hVar.sI()) {
                }
                if (hVar.su() > hVar.sI()) {
                }
                if (hVar.su() == hVar.sI()) {
                }
                a(1, 17, hVar);
                if (hVar.sP() <= hVar.sQ()) {
                }
            }
        }
    }

    public h sc() {
        return this.QZ;
    }

    public void c(h hVar) {
        this.QZ = hVar;
    }

    public h sd() {
        return this.Ra;
    }
}
