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
    public static boolean RC;
    public static boolean RE;
    public static boolean RF;
    private static a Ry;
    private h RA;
    private static Date RB = null;
    private static Handler mHandler = new b();
    private int Rs = 0;
    private int Rt = 0;
    private int Ru = 0;
    private int Rv = 0;
    private int Rw = 0;
    private int Rx = 0;
    private h Rz = new h();
    private final int[] RG = new int[10];
    private final Context Rr = TbadkCoreApplication.m255getInst().getApp();

    public static a rS() {
        if (Ry == null) {
            Ry = new a();
        }
        return Ry;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.Rs || i2 != this.Rt || i3 != this.Ru || i4 != this.Rw || i5 != this.Rv || i6 != this.Rx) {
            int i7 = 0;
            if (i > this.Rs || i2 > this.Rt || i3 > this.Ru || i4 > this.Rw || i5 > this.Rv || i6 > this.Rx) {
                i7 = 1;
            } else if (i < this.Rs || i2 < this.Rt) {
                i7 = 2;
            }
            this.Rs = i;
            this.Rt = i2;
            this.Ru = i3;
            this.Rw = i4;
            this.Rv = i5;
            this.Rx = i6;
            int i8 = sl() > 0 ? i7 : 2;
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                sj();
                u(i8, 23);
                u(i8, 16);
                u(i8, 17);
                u(i8, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.Rs || i2 != this.Rt || i3 != this.Ru || i4 != this.Rw || this.Rx != i5) {
            this.Rs = i;
            this.Rt = i2;
            this.Ru = i3;
            this.Rw = i4;
            this.Rx = i5;
            sj();
            if (sl() <= 0) {
                u(2, 16);
                u(2, 17);
                u(2, 11);
            }
        }
    }

    public static boolean rT() {
        if (RB == null) {
            RB = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - RB.getTime() < 10000) {
                return false;
            }
            RB = date;
        }
        return true;
    }

    public static boolean rU() {
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
                    if (this.Rx > 0) {
                        String format = String.format(this.Rr.getString(z.notify_gift), String.valueOf(this.Rx));
                        a(23, null, format, format);
                    }
                } else if (i2 == 11) {
                    if (this.Rs > 0 || this.Rt > 0 || this.Rw > 0) {
                        int i3 = this.Rs + this.Rt;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.Rr.getString(z.notify_msg));
                        }
                        if (this.Rw > 0) {
                            stringBuffer.append(String.valueOf(this.Rw));
                            stringBuffer.append(this.Rr.getString(z.notify_fans));
                        }
                        stringBuffer.append(this.Rr.getString(z.notify_click));
                        a(11, null, stringBuffer.toString(), stringBuffer.toString());
                    }
                } else if (i2 != 16 && TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                    TbadkCoreApplication.m255getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.Rr, 11);
                NotificationHelper.cancelNotification(this.Rr, 16);
                NotificationHelper.cancelNotification(this.Rr, 17);
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
        String sO;
        String sN;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23 && this.Rx > 0) {
                        String format = String.format(this.Rr.getString(z.notify_gift), String.valueOf(this.Rx));
                        a(23, null, format, format);
                    }
                    if (i2 == 11) {
                        if (this.Rs > 0 || this.Rt > 0 || this.Rw > 0) {
                            int i3 = this.Rs + this.Rt;
                            if (i3 > 0) {
                                stringBuffer.append(String.valueOf(i3));
                                stringBuffer.append(this.Rr.getString(z.notify_msg));
                            }
                            if (this.Rw > 0) {
                                stringBuffer.append(String.valueOf(this.Rw));
                                stringBuffer.append(this.Rr.getString(z.notify_fans));
                            }
                            stringBuffer.append(this.Rr.getString(z.notify_click));
                            a(11, null, stringBuffer.toString(), stringBuffer.toString());
                        }
                    } else if (i2 == 16) {
                        int sE = (!TbadkCoreApplication.m255getInst().isGroupMsgOn() || TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) ? 0 : hVar.sE() - hVar.sL();
                        long j = 0;
                        if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                            j = hVar.sW();
                        }
                        boolean z4 = j > 0;
                        long j2 = sE + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.Rr.getString(z.notify_chat), Long.valueOf(j2)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            hVar.sZ();
                            hVar.sX();
                            if (j == 1) {
                                sO = hVar.sZ();
                                str = hVar.sX();
                                sN = String.valueOf(sO) + "：" + str;
                            } else if (sE == 1) {
                                sO = hVar.sO();
                                sN = hVar.sN();
                                str = sN;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.Rr.getString(z.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(sN)) {
                                sN = str;
                            }
                            a(16, sO, str, sN, z4);
                        }
                    } else if (i2 == 19) {
                        List<i> te = hVar.te();
                        if (te != null && te.size() != 0) {
                            for (i iVar : te) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.SH) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                        if (hVar.sF() + hVar.sH() > 0) {
                            if (hVar.sF() > 0 && !sb()) {
                                long sF = hVar.sF() - hVar.sG();
                                if (sF > 0) {
                                    stringBuffer.append(String.format(this.Rr.getString(z.notify_updates), Long.valueOf(sF)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.sG() > 0) {
                                    z = true;
                                }
                                if (hVar.sH() > 0 || sa()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.Rr.getString(z.notify_validate), Integer.valueOf(hVar.sH())));
                                } else {
                                    stringBuffer.append(String.format(this.Rr.getString(z.notify_validate_1), Integer.valueOf(hVar.sH())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.sQ(), hVar.sR(), hVar.sR());
                                }
                            }
                            z = false;
                            if (hVar.sH() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.ta() > 0 && !sc()) {
                            String format2 = String.format(this.Rr.getString(z.notify_live), Integer.valueOf(hVar.ta()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.Rr, 11);
                    NotificationHelper.cancelNotification(this.Rr, 16);
                    NotificationHelper.cancelNotification(this.Rr, 17);
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
            NotificationHelper.showNotification(this.Rr, iVar.gid, iVar.title, iVar.content, iVar.content, PendingIntent.getService(this.Rr, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.Rx > 0) {
            e = cB(i);
        } else if (i == 11 && this.Rw > 0 && this.Rs == 0 && this.Rt == 0) {
            e = cC(i);
        } else if (i == 18) {
            e = rV();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.Rr, i, str, str2, str3, PendingIntent.getService(this.Rr, i, e, 134217728), false);
    }

    public Intent cB(int i) {
        Intent intent = new Intent(this.Rr, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.Rx);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cC(int i) {
        Intent intent = new Intent(this.Rr, DealIntentService.class);
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
        Intent intent = new Intent(this.Rr, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, iVar.gid);
        intent.putExtra("uname", iVar.SG);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, iVar.userType);
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.Rz.sY().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.Rr, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.Rt);
        intent.putExtra("reply_me", this.Rs);
        intent.putExtra("fans", this.Rw);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.Rz.sE() - this.Rz.sL());
        intent.putExtra("group_msg_validate", this.Rz.sH());
        intent.putExtra("group_msg_updates", this.Rz.sF());
        intent.putExtra("live_notify_msg_updates", this.Rz.ta());
        intent.putExtra("officialbar_msg", this.Rz.sI());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent rV() {
        Intent intent = new Intent(this.Rr, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.Rz.sG());
        return intent;
    }

    public void rW() {
        NotificationHelper.cancelNotification(this.Rr, 11);
        NotificationHelper.cancelNotification(this.Rr, 16);
        NotificationHelper.cancelNotification(this.Rr, 17);
        NotificationHelper.cancelNotification(this.Rr, 15);
        NotificationHelper.cancelNotification(this.Rr, 13);
        NotificationHelper.cancelNotification(this.Rr, 12);
    }

    public void rX() {
        NotificationHelper.cancelNotification(this.Rr, 16);
    }

    public void rY() {
        NotificationHelper.cancelNotification(this.Rr, 19);
    }

    public void cD(int i) {
        NotificationHelper.cancelNotification(this.Rr, i);
    }

    public int rZ() {
        return this.Rz.sW();
    }

    public void di(String str) {
        if (TextUtils.isEmpty(str)) {
            rX();
            return;
        }
        h sm = sm();
        if (sm == null) {
            rX();
            return;
        }
        HashMap<String, String> sS = sm.sS();
        if (sS == null || sS.isEmpty()) {
            rX();
        } else if (sS.containsKey(str)) {
            rX();
        }
    }

    public void dj(String str) {
        if (TextUtils.isEmpty(str)) {
            rX();
            return;
        }
        h sm = sm();
        if (sm == null) {
            rX();
            return;
        }
        HashMap<String, String> sY = sm.sY();
        if (sY == null || sY.isEmpty()) {
            rX();
        } else if (sY.containsKey(str)) {
            rX();
        }
    }

    private boolean sa() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return RC;
    }

    private boolean sb() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return RE;
    }

    private boolean sc() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return RF;
    }

    public void sd() {
        NotificationHelper.cancelNotification(this.Rr, 17);
    }

    public void cE(int i) {
        h sm = sm();
        if (sm == null) {
            sd();
        } else if (1 == i) {
            if (sm.sF() <= 0) {
                sd();
            }
        } else if (2 == i) {
            if (sm.sH() <= 0) {
                sd();
            }
        } else if (3 == i && sm.ta() <= 0) {
            NotificationHelper.cancelNotification(this.Rr, 21);
        }
    }

    public void se() {
        NotificationHelper.cancelNotification(this.Rr, 18);
    }

    public void sf() {
        NotificationHelper.cancelNotification(this.Rr, 11);
        NotificationHelper.cancelNotification(this.Rr, 16);
        NotificationHelper.cancelNotification(this.Rr, 17);
    }

    public void sg() {
        NotificationHelper.cancelNotification(this.Rr, 21);
        NotificationHelper.cancelNotification(this.Rr, 17);
        NotificationHelper.cancelNotification(this.Rr, 19);
        NotificationHelper.cancelNotification(this.Rr, 16);
        NotificationHelper.cancelNotification(this.Rr, 18);
    }

    public void sh() {
        NotificationHelper.cancelNotification(this.Rr, 11);
    }

    public void si() {
        NotificationHelper.cancelNotification(this.Rr, 23);
    }

    public void sj() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(sk());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.Rz.sW());
        newsNotifyMessage.setMsgStrangerChat(this.Rz.td());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.sW() + hVar.sE()) + hVar.td()) + hVar.tc()) + hVar.tf()) - hVar.sL());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(hVar.sW());
            newsNotifyMessage.setMsgStrangerChat(hVar.td());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.Rs;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.Rt, this.Ru, this.Rw, this.Rv, this.Rx);
        }
    }

    public int getMsgAtme() {
        return this.Rt;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.Rs, i, this.Ru, this.Rw, this.Rv, this.Rx);
        }
    }

    public int getMsgChat() {
        return this.Ru;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=5] */
    public int sk() {
        return ((((this.Rz.sW() + this.Rz.sE()) + this.Rz.td()) + this.Rz.tc()) + this.Rz.tf()) - this.Rz.sL();
    }

    public int getMsgFans() {
        return this.Rw;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.Rs, this.Rt, this.Ru, i, this.Rv, this.Rx);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.Rs, this.Rt, i, this.Rw, this.Rv, this.Rx);
        }
    }

    public int getMsgBookmark() {
        return this.Rv;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.Rs, this.Rt, this.Ru, this.Rw, i, this.Rx);
        }
    }

    public int getMsgGiftNum() {
        return this.Rx;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.Rx = i;
        }
    }

    public void av(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.Rs = 0;
        this.Rt = 0;
        this.Ru = 0;
        this.Rw = 0;
        this.Rv = 0;
    }

    public int sl() {
        return this.Rs + this.Rt + this.Ru + this.Rw + this.Rx;
    }

    public void b(h hVar) {
        long j;
        int sI;
        int i = 0;
        if (hVar != null) {
            this.Rz = hVar;
            this.Ru = (hVar.sE() - hVar.sL()) + hVar.sW() + hVar.tc() + hVar.tf();
            a(hVar);
            if (hVar.sM()) {
                this.RA = null;
                mHandler.removeMessages(0);
            }
            if (hVar.sM()) {
                if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    i = hVar.sE() - hVar.sL();
                }
                if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    boolean chatFloatWindowLocked = TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
                    boolean isProcessBackground = TbadkCoreApplication.m255getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m255getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.sW();
                    } else if (isFloatingWindowOpened) {
                        if (!chatFloatWindowLocked || isProcessBackground) {
                            j = hVar.sW();
                        }
                    } else {
                        j = hVar.sW();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.sP() - hVar.sL() && i > 0) || j > hVar.sJ())) {
                        a(1, 16, hVar);
                    }
                    sI = hVar.sI();
                    if (sI > 0 && sI > hVar.sV()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.sF() <= hVar.sT() || hVar.sH() > hVar.sU()) {
                        if (hVar.sF() > hVar.sT() || hVar.sH() != hVar.sU() || !sb()) {
                            if (hVar.sF() == hVar.sT() || hVar.sH() <= hVar.sU() || !sa()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.ta() <= hVar.tb() && !sc()) {
                        a(1, 21, hVar);
                        return;
                    }
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                sI = hVar.sI();
                if (sI > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.sF() <= hVar.sT()) {
                }
                if (hVar.sF() > hVar.sT()) {
                }
                if (hVar.sF() == hVar.sT()) {
                }
                a(1, 17, hVar);
                if (hVar.ta() <= hVar.tb()) {
                }
            }
        }
    }

    public h sm() {
        return this.Rz;
    }

    public void c(h hVar) {
        this.Rz = hVar;
    }

    public h sn() {
        return this.RA;
    }
}
