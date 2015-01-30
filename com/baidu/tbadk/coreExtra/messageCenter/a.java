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
    private static a RB;
    public static boolean RG;
    public static boolean RH;
    public static boolean RI;
    private h RE;
    private static Date RF = null;
    private static Handler mHandler = new b();
    private int Rv = 0;
    private int Rw = 0;
    private int Rx = 0;
    private int Ry = 0;
    private int Rz = 0;
    private int RA = 0;
    private h RC = new h();
    private final int[] RJ = new int[10];
    private final Context Ru = TbadkCoreApplication.m255getInst().getApp();

    public static a rY() {
        if (RB == null) {
            RB = new a();
        }
        return RB;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.Rv || i2 != this.Rw || i3 != this.Rx || i4 != this.Rz || i5 != this.Ry || i6 != this.RA) {
            int i7 = 0;
            if (i > this.Rv || i2 > this.Rw || i3 > this.Rx || i4 > this.Rz || i5 > this.Ry || i6 > this.RA) {
                i7 = 1;
            } else if (i < this.Rv || i2 < this.Rw) {
                i7 = 2;
            }
            this.Rv = i;
            this.Rw = i2;
            this.Rx = i3;
            this.Rz = i4;
            this.Ry = i5;
            this.RA = i6;
            int i8 = sr() > 0 ? i7 : 2;
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                sp();
                u(i8, 23);
                u(i8, 16);
                u(i8, 17);
                u(i8, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.Rv || i2 != this.Rw || i3 != this.Rx || i4 != this.Rz || this.RA != i5) {
            this.Rv = i;
            this.Rw = i2;
            this.Rx = i3;
            this.Rz = i4;
            this.RA = i5;
            sp();
            if (sr() <= 0) {
                u(2, 16);
                u(2, 17);
                u(2, 11);
            }
        }
    }

    public static boolean rZ() {
        if (RF == null) {
            RF = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - RF.getTime() < 10000) {
                return false;
            }
            RF = date;
        }
        return true;
    }

    public static boolean sa() {
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
                    if (this.RA > 0) {
                        String format = String.format(this.Ru.getString(z.notify_gift), String.valueOf(this.RA));
                        a(23, null, format, format);
                    }
                } else if (i2 == 11) {
                    if (this.Rv > 0 || this.Rw > 0 || this.Rz > 0) {
                        int i3 = this.Rv + this.Rw;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.Ru.getString(z.notify_msg));
                        }
                        if (this.Rz > 0) {
                            stringBuffer.append(String.valueOf(this.Rz));
                            stringBuffer.append(this.Ru.getString(z.notify_fans));
                        }
                        stringBuffer.append(this.Ru.getString(z.notify_click));
                        a(11, null, stringBuffer.toString(), stringBuffer.toString());
                    }
                } else if (i2 != 16 && TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                    TbadkCoreApplication.m255getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.Ru, 11);
                NotificationHelper.cancelNotification(this.Ru, 16);
                NotificationHelper.cancelNotification(this.Ru, 17);
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
        String sU;
        String sT;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (hVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23 && this.RA > 0) {
                        String format = String.format(this.Ru.getString(z.notify_gift), String.valueOf(this.RA));
                        a(23, null, format, format);
                    }
                    if (i2 == 11) {
                        if (this.Rv > 0 || this.Rw > 0 || this.Rz > 0) {
                            int i3 = this.Rv + this.Rw;
                            if (i3 > 0) {
                                stringBuffer.append(String.valueOf(i3));
                                stringBuffer.append(this.Ru.getString(z.notify_msg));
                            }
                            if (this.Rz > 0) {
                                stringBuffer.append(String.valueOf(this.Rz));
                                stringBuffer.append(this.Ru.getString(z.notify_fans));
                            }
                            stringBuffer.append(this.Ru.getString(z.notify_click));
                            a(11, null, stringBuffer.toString(), stringBuffer.toString());
                        }
                    } else if (i2 == 16) {
                        int sK = (!TbadkCoreApplication.m255getInst().isGroupMsgOn() || TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) ? 0 : hVar.sK() - hVar.sR();
                        long j = 0;
                        if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                            j = hVar.tc();
                        }
                        boolean z4 = j > 0;
                        long j2 = sK + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.Ru.getString(z.notify_chat), Long.valueOf(j2)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            hVar.tf();
                            hVar.td();
                            if (j == 1) {
                                sU = hVar.tf();
                                str = hVar.td();
                                sT = String.valueOf(sU) + "：" + str;
                            } else if (sK == 1) {
                                sU = hVar.sU();
                                sT = hVar.sT();
                                str = sT;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.Ru.getString(z.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(sT)) {
                                sT = str;
                            }
                            a(16, sU, str, sT, z4);
                        }
                    } else if (i2 == 19) {
                        List<i> tk = hVar.tk();
                        if (tk != null && tk.size() != 0) {
                            for (i iVar : tk) {
                                if (iVar != null && !StringUtils.isNull(iVar.content) && iVar.gid != 0 && iVar.unReadCount > iVar.SL) {
                                    a(iVar);
                                }
                            }
                        }
                    } else if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                        if (hVar.sL() + hVar.sN() > 0) {
                            if (hVar.sL() > 0 && !sh()) {
                                long sL = hVar.sL() - hVar.sM();
                                if (sL > 0) {
                                    stringBuffer.append(String.format(this.Ru.getString(z.notify_updates), Long.valueOf(sL)));
                                    z = false;
                                    z2 = true;
                                } else if (hVar.sM() > 0) {
                                    z = true;
                                }
                                if (hVar.sN() > 0 || sg()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.Ru.getString(z.notify_validate), Integer.valueOf(hVar.sN())));
                                } else {
                                    stringBuffer.append(String.format(this.Ru.getString(z.notify_validate_1), Integer.valueOf(hVar.sN())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, hVar.sW(), hVar.sX(), hVar.sX());
                                }
                            }
                            z = false;
                            if (hVar.sN() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (hVar.tg() > 0 && !si()) {
                            String format2 = String.format(this.Ru.getString(z.notify_live), Integer.valueOf(hVar.tg()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.Ru, 11);
                    NotificationHelper.cancelNotification(this.Ru, 16);
                    NotificationHelper.cancelNotification(this.Ru, 17);
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
            NotificationHelper.showNotification(this.Ru, iVar.gid, iVar.title, iVar.content, iVar.content, PendingIntent.getService(this.Ru, iVar.gid, b, 134217728), false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent e;
        if (i == 23 && this.RA > 0) {
            e = cB(i);
        } else if (i == 11 && this.Rz > 0 && this.Rv == 0 && this.Rw == 0) {
            e = cC(i);
        } else if (i == 18) {
            e = sb();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.Ru, i, str, str2, str3, PendingIntent.getService(this.Ru, i, e, 134217728), false);
    }

    public Intent cB(int i) {
        Intent intent = new Intent(this.Ru, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.RA);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent cC(int i) {
        Intent intent = new Intent(this.Ru, DealIntentService.class);
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
        Intent intent = new Intent(this.Ru, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, iVar.gid);
        intent.putExtra("uname", iVar.SJ);
        intent.putExtra(OfficalBarChatActivityConfig.USER_TYPE, iVar.userType);
        return intent;
    }

    public Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.RC.te().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.Ru, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.Rw);
        intent.putExtra("reply_me", this.Rv);
        intent.putExtra("fans", this.Rz);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.RC.sK() - this.RC.sR());
        intent.putExtra("group_msg_validate", this.RC.sN());
        intent.putExtra("group_msg_updates", this.RC.sL());
        intent.putExtra("live_notify_msg_updates", this.RC.tg());
        intent.putExtra("officialbar_msg", this.RC.sO());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent sb() {
        Intent intent = new Intent(this.Ru, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.RC.sM());
        return intent;
    }

    public void sc() {
        NotificationHelper.cancelNotification(this.Ru, 11);
        NotificationHelper.cancelNotification(this.Ru, 16);
        NotificationHelper.cancelNotification(this.Ru, 17);
        NotificationHelper.cancelNotification(this.Ru, 15);
        NotificationHelper.cancelNotification(this.Ru, 13);
        NotificationHelper.cancelNotification(this.Ru, 12);
    }

    public void sd() {
        NotificationHelper.cancelNotification(this.Ru, 16);
    }

    public void se() {
        NotificationHelper.cancelNotification(this.Ru, 19);
    }

    public void cD(int i) {
        NotificationHelper.cancelNotification(this.Ru, i);
    }

    public int sf() {
        return this.RC.tc();
    }

    public void dl(String str) {
        if (TextUtils.isEmpty(str)) {
            sd();
            return;
        }
        h ss = ss();
        if (ss == null) {
            sd();
            return;
        }
        HashMap<String, String> sY = ss.sY();
        if (sY == null || sY.isEmpty()) {
            sd();
        } else if (sY.containsKey(str)) {
            sd();
        }
    }

    public void dm(String str) {
        if (TextUtils.isEmpty(str)) {
            sd();
            return;
        }
        h ss = ss();
        if (ss == null) {
            sd();
            return;
        }
        HashMap<String, String> te = ss.te();
        if (te == null || te.isEmpty()) {
            sd();
        } else if (te.containsKey(str)) {
            sd();
        }
    }

    private boolean sg() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return RG;
    }

    private boolean sh() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return RH;
    }

    private boolean si() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return RI;
    }

    public void sj() {
        NotificationHelper.cancelNotification(this.Ru, 17);
    }

    public void cE(int i) {
        h ss = ss();
        if (ss == null) {
            sj();
        } else if (1 == i) {
            if (ss.sL() <= 0) {
                sj();
            }
        } else if (2 == i) {
            if (ss.sN() <= 0) {
                sj();
            }
        } else if (3 == i && ss.tg() <= 0) {
            NotificationHelper.cancelNotification(this.Ru, 21);
        }
    }

    public void sk() {
        NotificationHelper.cancelNotification(this.Ru, 18);
    }

    public void sl() {
        NotificationHelper.cancelNotification(this.Ru, 11);
        NotificationHelper.cancelNotification(this.Ru, 16);
        NotificationHelper.cancelNotification(this.Ru, 17);
    }

    public void sm() {
        NotificationHelper.cancelNotification(this.Ru, 21);
        NotificationHelper.cancelNotification(this.Ru, 17);
        NotificationHelper.cancelNotification(this.Ru, 19);
        NotificationHelper.cancelNotification(this.Ru, 16);
        NotificationHelper.cancelNotification(this.Ru, 18);
    }

    public void sn() {
        NotificationHelper.cancelNotification(this.Ru, 11);
    }

    public void so() {
        NotificationHelper.cancelNotification(this.Ru, 23);
    }

    public void sp() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(sq());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.RC.tc());
        newsNotifyMessage.setMsgStrangerChat(this.RC.tj());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(h hVar) {
        if (hVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((hVar.tc() + hVar.sK()) + hVar.tj()) + hVar.ti()) + hVar.tl()) - hVar.sR());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(hVar.tc());
            newsNotifyMessage.setMsgStrangerChat(hVar.tj());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.Rv;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.Rw, this.Rx, this.Rz, this.Ry, this.RA);
        }
    }

    public int getMsgAtme() {
        return this.Rw;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.Rv, i, this.Rx, this.Rz, this.Ry, this.RA);
        }
    }

    public int getMsgChat() {
        return this.Rx;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=5] */
    public int sq() {
        return ((((this.RC.tc() + this.RC.sK()) + this.RC.tj()) + this.RC.ti()) + this.RC.tl()) - this.RC.sR();
    }

    public int getMsgFans() {
        return this.Rz;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.Rv, this.Rw, this.Rx, i, this.Ry, this.RA);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.Rv, this.Rw, i, this.Rz, this.Ry, this.RA);
        }
    }

    public int getMsgBookmark() {
        return this.Ry;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.Rv, this.Rw, this.Rx, this.Rz, i, this.RA);
        }
    }

    public int getMsgGiftNum() {
        return this.RA;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.RA = i;
        }
    }

    public void av(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.Rv = 0;
        this.Rw = 0;
        this.Rx = 0;
        this.Rz = 0;
        this.Ry = 0;
    }

    public int sr() {
        return this.Rv + this.Rw + this.Rx + this.Rz + this.RA;
    }

    public void b(h hVar) {
        long j;
        int sO;
        int i = 0;
        if (hVar != null) {
            this.RC = hVar;
            this.Rx = (hVar.sK() - hVar.sR()) + hVar.tc() + hVar.ti() + hVar.tl();
            a(hVar);
            if (hVar.sS()) {
                this.RE = null;
                mHandler.removeMessages(0);
            }
            if (hVar.sS()) {
                if (TbadkCoreApplication.m255getInst().isGroupMsgOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    i = hVar.sK() - hVar.sR();
                }
                if (TbadkCoreApplication.m255getInst().isMsgChatOn() && TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
                    boolean chatFloatWindowLocked = TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
                    boolean isProcessBackground = TbadkCoreApplication.m255getInst().isProcessBackground();
                    boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
                    boolean isFloatingWindowOpened = TbadkCoreApplication.m255getInst().isFloatingWindowOpened();
                    if (isMIUIRom) {
                        j = hVar.tc();
                    } else if (isFloatingWindowOpened) {
                        if (!chatFloatWindowLocked || isProcessBackground) {
                            j = hVar.tc();
                        }
                    } else {
                        j = hVar.tc();
                    }
                    if ((i <= 0 || j > 0) && ((i > hVar.sV() - hVar.sR() && i > 0) || j > hVar.sP())) {
                        a(1, 16, hVar);
                    }
                    sO = hVar.sO();
                    if (sO > 0 && sO > hVar.tb()) {
                        a(1, 19, hVar);
                    }
                    if (hVar.sL() <= hVar.sZ() || hVar.sN() > hVar.ta()) {
                        if (hVar.sL() > hVar.sZ() || hVar.sN() != hVar.ta() || !sh()) {
                            if (hVar.sL() == hVar.sZ() || hVar.sN() <= hVar.ta() || !sg()) {
                                a(1, 17, hVar);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (hVar.tg() <= hVar.th() && !si()) {
                        a(1, 21, hVar);
                        return;
                    }
                }
                j = 0;
                if (i <= 0) {
                }
                a(1, 16, hVar);
                sO = hVar.sO();
                if (sO > 0) {
                    a(1, 19, hVar);
                }
                if (hVar.sL() <= hVar.sZ()) {
                }
                if (hVar.sL() > hVar.sZ()) {
                }
                if (hVar.sL() == hVar.sZ()) {
                }
                a(1, 17, hVar);
                if (hVar.tg() <= hVar.th()) {
                }
            }
        }
    }

    public h ss() {
        return this.RC;
    }

    public void c(h hVar) {
        this.RC = hVar;
    }

    public h st() {
        return this.RE;
    }
}
