package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.y;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static a Lt;
    private static boolean Lx;
    private static boolean Ly;
    private static boolean Lz;
    private com.baidu.tbadk.coreExtra.b.c Lv;
    private static Date Lw = null;
    private static Handler mHandler = new b();
    private int Ln = 0;
    private int Lo = 0;
    private int Lp = 0;
    private int Lq = 0;
    private int Lr = 0;
    private int Ls = 0;
    private com.baidu.tbadk.coreExtra.b.c Lu = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] LA = new int[10];
    private final Context Lm = TbadkApplication.m251getInst().getApp();

    static {
        if (TbadkApplication.m251getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(new c(2008004));
            MessageManager.getInstance().registerListener(new d(2008005));
            MessageManager.getInstance().registerListener(new e(2008018));
        }
    }

    public static a oB() {
        if (Lt == null) {
            Lt = new a();
        }
        return Lt;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.Ln || i2 != this.Lo || i3 != this.Lp || i4 != this.Lr || i5 != this.Lq || i6 != this.Ls) {
            int i7 = 0;
            if (i > this.Ln || i2 > this.Lo || i3 > this.Lp || i4 > this.Lr || i5 > this.Lq || i6 > this.Ls) {
                i7 = 1;
            } else if (i < this.Ln || i2 < this.Lo) {
                i7 = 2;
            }
            this.Ln = i;
            this.Lo = i2;
            this.Lp = i3;
            this.Lr = i4;
            this.Lq = i5;
            this.Ls = i6;
            int i8 = oT() > 0 ? i7 : 2;
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
                oR();
                r(i8, 23);
                r(i8, 16);
                r(i8, 17);
                r(i8, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.Ln || i2 != this.Lo || i3 != this.Lp || i4 != this.Lr || this.Ls != i5) {
            this.Ln = i;
            this.Lo = i2;
            this.Lp = i3;
            this.Lr = i4;
            this.Ls = i5;
            oR();
            if (oT() <= 0) {
                r(2, 16);
                r(2, 17);
                r(2, 11);
            }
        }
    }

    public static boolean oC() {
        if (Lw == null) {
            Lw = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - Lw.getTime() < 10000) {
                return false;
            }
            Lw = date;
        }
        return true;
    }

    public static boolean oD() {
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        if (m251getInst.isNoDisturbOn()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = m251getInst.getNoDisturbStartTime().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = m251getInst.getNoDisturbEndTime().split(":");
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

    private void r(int i, int i2) {
        try {
            if (i == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 23) {
                    if (this.Ls > 0) {
                        b(23, null, String.format(this.Lm.getString(y.notify_gift), String.valueOf(this.Ls)));
                    }
                } else if (i2 == 11) {
                    if (this.Ln > 0 || this.Lo > 0 || this.Lr > 0) {
                        int i3 = this.Ln + this.Lo;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.Lm.getString(y.notify_msg));
                        }
                        if (this.Lr > 0) {
                            stringBuffer.append(String.valueOf(this.Lr));
                            stringBuffer.append(this.Lm.getString(y.notify_fans));
                        }
                        stringBuffer.append(this.Lm.getString(y.notify_click));
                        b(11, null, stringBuffer.toString());
                    }
                } else if (i2 != 16 && TbadkApplication.m251getInst().isGroupMsgOn()) {
                    TbadkApplication.m251getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.Lm, 11);
                NotificationHelper.cancelNotification(this.Lm, 16);
                NotificationHelper.cancelNotification(this.Lm, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x023e A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:13:0x003a, B:15:0x003e, B:17:0x0042, B:19:0x0046, B:21:0x004d, B:22:0x005f, B:24:0x0063, B:25:0x0077, B:30:0x009a, B:32:0x00a4, B:34:0x00ae, B:35:0x00b8, B:37:0x00c4, B:39:0x00ce, B:43:0x00db, B:45:0x00e1, B:48:0x010a, B:50:0x0114, B:51:0x011c, B:53:0x0122, B:54:0x0140, B:56:0x0149, B:59:0x0156, B:61:0x015f, B:64:0x0188, B:66:0x0196, B:67:0x01b4, B:68:0x01bb, B:70:0x01c5, B:72:0x01cf, B:74:0x01da, B:76:0x01e0, B:78:0x01e6, B:80:0x01f6, B:81:0x0211, B:83:0x0217, B:86:0x021f, B:88:0x023e, B:90:0x024a, B:99:0x028d, B:96:0x0285, B:91:0x0257, B:93:0x025d, B:95:0x0263, B:102:0x02ae), top: B:109:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x024a A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:13:0x003a, B:15:0x003e, B:17:0x0042, B:19:0x0046, B:21:0x004d, B:22:0x005f, B:24:0x0063, B:25:0x0077, B:30:0x009a, B:32:0x00a4, B:34:0x00ae, B:35:0x00b8, B:37:0x00c4, B:39:0x00ce, B:43:0x00db, B:45:0x00e1, B:48:0x010a, B:50:0x0114, B:51:0x011c, B:53:0x0122, B:54:0x0140, B:56:0x0149, B:59:0x0156, B:61:0x015f, B:64:0x0188, B:66:0x0196, B:67:0x01b4, B:68:0x01bb, B:70:0x01c5, B:72:0x01cf, B:74:0x01da, B:76:0x01e0, B:78:0x01e6, B:80:0x01f6, B:81:0x0211, B:83:0x0217, B:86:0x021f, B:88:0x023e, B:90:0x024a, B:99:0x028d, B:96:0x0285, B:91:0x0257, B:93:0x025d, B:95:0x0263, B:102:0x02ae), top: B:109:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.b.c cVar) {
        boolean z;
        long j;
        String pk;
        String pj;
        boolean z2 = false;
        boolean z3 = true;
        if (cVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23 && this.Ls > 0) {
                        b(23, null, String.format(this.Lm.getString(y.notify_gift), String.valueOf(this.Ls)));
                    }
                    if (i2 == 11) {
                        if (this.Ln > 0 || this.Lo > 0 || this.Lr > 0) {
                            int i3 = this.Ln + this.Lo;
                            if (i3 > 0) {
                                stringBuffer.append(String.valueOf(i3));
                                stringBuffer.append(this.Lm.getString(y.notify_msg));
                            }
                            if (this.Lr > 0) {
                                stringBuffer.append(String.valueOf(this.Lr));
                                stringBuffer.append(this.Lm.getString(y.notify_fans));
                            }
                            stringBuffer.append(this.Lm.getString(y.notify_click));
                            b(11, null, stringBuffer.toString());
                        }
                    } else if (i2 == 16) {
                        int oY = (!TbadkApplication.m251getInst().isGroupMsgOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) ? 0 : cVar.oY() - cVar.ph();
                        if (!TbadkApplication.m251getInst().isMsgChatOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) {
                            j = 0;
                        } else {
                            j = cVar.ps();
                        }
                        boolean z4 = j > 0;
                        long j2 = oY + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.Lm.getString(y.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            cVar.pv();
                            cVar.pt();
                            if (j == 1) {
                                pk = cVar.pv();
                                pj = cVar.pt();
                            } else if (oY == 1) {
                                pk = cVar.pk();
                                pj = cVar.pj();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(pj)) {
                                pj = stringBuffer.append(String.format(this.Lm.getString(y.notify_chat), Long.valueOf(j2))).toString();
                            }
                            a(16, pk, pj, z4);
                        }
                    } else if (i2 == 19) {
                        long pc = cVar.pc();
                        if (pc > 1) {
                            stringBuffer.append(String.format(this.Lm.getString(y.notify_official_message), Long.valueOf(pc)));
                            b(19, null, stringBuffer.toString());
                        } else if (pc == 1) {
                            String pf = cVar.pf();
                            String pg = cVar.pg();
                            if (TextUtils.isEmpty(pg)) {
                                pg = stringBuffer.append(String.format(this.Lm.getString(y.notify_official_message), Long.valueOf(pc))).toString();
                            }
                            b(19, pf, pg);
                        }
                    } else if (TbadkApplication.m251getInst().isGroupMsgOn() && TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                        if (cVar.oZ() + cVar.pb() > 0) {
                            if (cVar.oZ() > 0 && !oJ()) {
                                long oZ = cVar.oZ() - cVar.pa();
                                if (oZ > 0) {
                                    stringBuffer.append(String.format(this.Lm.getString(y.notify_updates), Long.valueOf(oZ)));
                                    z = false;
                                    z2 = true;
                                } else if (cVar.pa() > 0) {
                                    z = true;
                                }
                                if (cVar.pb() > 0 || oI()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.Lm.getString(y.notify_validate), Integer.valueOf(cVar.pb())));
                                } else {
                                    stringBuffer.append(String.format(this.Lm.getString(y.notify_validate_1), Integer.valueOf(cVar.pb())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, cVar.pm(), cVar.pn());
                                }
                            }
                            z = false;
                            if (cVar.pb() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (cVar.pw() > 0 && !oK()) {
                            b(21, null, String.format(this.Lm.getString(y.notify_live), Integer.valueOf(cVar.pw())));
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.Lm, 11);
                    NotificationHelper.cancelNotification(this.Lm, 16);
                    NotificationHelper.cancelNotification(this.Lm, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void b(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    private void a(int i, String str, String str2, boolean z) {
        Intent e;
        if (i == 23 && this.Ls > 0) {
            e = bW(i);
        } else if (i == 11 && this.Lr > 0 && this.Ln == 0 && this.Lo == 0) {
            e = bX(i);
        } else if (i == 18) {
            e = oE();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.Lm, i, str, str2, str2, PendingIntent.getService(this.Lm, i, e, 134217728), false);
    }

    private Intent bW(int i) {
        Intent intent = new Intent(this.Lm, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.Ls);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String currentAccountName = TbadkApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    private Intent bX(int i) {
        Intent intent = new Intent(this.Lm, DealIntentService.class);
        intent.putExtra("class", 10);
        intent.putExtra("KeyOfNotiId", i);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String currentAccountName = TbadkApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    private Intent e(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.Lu.pu().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.Lm, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.Lo);
        intent.putExtra("reply_me", this.Ln);
        intent.putExtra("fans", this.Lr);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.Lu.oY() - this.Lu.ph());
        intent.putExtra("group_msg_validate", this.Lu.pb());
        intent.putExtra("group_msg_updates", this.Lu.oZ());
        intent.putExtra("live_notify_msg_updates", this.Lu.pw());
        intent.putExtra("officialbar_msg", this.Lu.pc());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent oE() {
        Intent intent = new Intent(this.Lm, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.Lu.pa());
        return intent;
    }

    public void oF() {
        NotificationHelper.cancelNotification(this.Lm, 11);
        NotificationHelper.cancelNotification(this.Lm, 16);
        NotificationHelper.cancelNotification(this.Lm, 17);
        NotificationHelper.cancelNotification(this.Lm, 15);
        NotificationHelper.cancelNotification(this.Lm, 13);
        NotificationHelper.cancelNotification(this.Lm, 12);
    }

    public void oG() {
        NotificationHelper.cancelNotification(this.Lm, 16);
    }

    public void oH() {
        NotificationHelper.cancelNotification(this.Lm, 19);
    }

    public void cp(String str) {
        if (TextUtils.isEmpty(str)) {
            oG();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c oU = oU();
        if (oU == null) {
            oG();
            return;
        }
        HashMap<String, String> po = oU.po();
        if (po == null || po.isEmpty()) {
            oG();
        } else if (po.containsKey(str)) {
            oG();
        }
    }

    public void cq(String str) {
        if (TextUtils.isEmpty(str)) {
            oG();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c oU = oU();
        if (oU == null) {
            oG();
            return;
        }
        HashMap<String, String> pu = oU.pu();
        if (pu == null || pu.isEmpty()) {
            oG();
        } else if (pu.containsKey(str)) {
            oG();
        }
    }

    private boolean oI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return Lx;
    }

    private boolean oJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return Ly;
    }

    private boolean oK() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return Lz;
    }

    public void oL() {
        NotificationHelper.cancelNotification(this.Lm, 17);
    }

    public void bY(int i) {
        com.baidu.tbadk.coreExtra.b.c oU = oU();
        if (oU == null) {
            oL();
        } else if (1 == i) {
            if (oU.oZ() <= 0) {
                oL();
            }
        } else if (2 == i) {
            if (oU.pb() <= 0) {
                oL();
            }
        } else if (3 == i && oU.pw() <= 0) {
            NotificationHelper.cancelNotification(this.Lm, 21);
        }
    }

    public void oM() {
        NotificationHelper.cancelNotification(this.Lm, 18);
    }

    public void oN() {
        NotificationHelper.cancelNotification(this.Lm, 11);
        NotificationHelper.cancelNotification(this.Lm, 16);
        NotificationHelper.cancelNotification(this.Lm, 17);
    }

    public void oO() {
        NotificationHelper.cancelNotification(this.Lm, 21);
        NotificationHelper.cancelNotification(this.Lm, 17);
        NotificationHelper.cancelNotification(this.Lm, 19);
        NotificationHelper.cancelNotification(this.Lm, 16);
        NotificationHelper.cancelNotification(this.Lm, 18);
    }

    public void oP() {
        NotificationHelper.cancelNotification(this.Lm, 11);
    }

    public void oQ() {
        NotificationHelper.cancelNotification(this.Lm, 23);
    }

    public void oR() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(oS());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((cVar.ps() + cVar.oY()) + cVar.py()) - cVar.ph());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.Ln;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.Lo, this.Lp, this.Lr, this.Lq, this.Ls);
        }
    }

    public int getMsgAtme() {
        return this.Lo;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.Ln, i, this.Lp, this.Lr, this.Lq, this.Ls);
        }
    }

    public int getMsgChat() {
        return this.Lp;
    }

    public int oS() {
        return ((this.Lu.ps() + this.Lu.oY()) + this.Lu.py()) - this.Lu.ph();
    }

    public int getMsgFans() {
        return this.Lr;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.Ln, this.Lo, this.Lp, i, this.Lq, this.Ls);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.Ln, this.Lo, i, this.Lr, this.Lq, this.Ls);
        }
    }

    public int getMsgBookmark() {
        return this.Lq;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.Ln, this.Lo, this.Lp, this.Lr, i, this.Ls);
        }
    }

    public int getMsgGiftNum() {
        return this.Ls;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.Ls = i;
        }
    }

    public void ac(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.Ln = 0;
        this.Lo = 0;
        this.Lp = 0;
        this.Lr = 0;
        this.Lq = 0;
    }

    public int oT() {
        return this.Ln + this.Lo + this.Lp + this.Lr + this.Ls;
    }

    public int bZ(int i) {
        return this.LA[i];
    }

    public void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.Lu = cVar;
            this.Lp = (cVar.oY() - cVar.ph()) + cVar.ps() + cVar.py();
            a(cVar);
            if (cVar.pi()) {
                this.Lv = null;
                mHandler.removeMessages(0);
            }
            if (cVar.pi()) {
                if (TbadkApplication.m251getInst().isGroupMsgOn() && TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                    i = cVar.oY() - cVar.ph();
                }
                long ps = (!TbadkApplication.m251getInst().isMsgChatOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) ? 0L : cVar.ps();
                if ((i > 0 || ps > 0) && ((i > cVar.pl() - cVar.ph() && i > 0) || ps > cVar.pd())) {
                    a(1, 16, cVar);
                }
                int pc = cVar.pc();
                if (pc > 0 && pc > cVar.pr()) {
                    a(1, 19, cVar);
                }
                if (cVar.oZ() > cVar.pp() || cVar.pb() > cVar.pq()) {
                    if (cVar.oZ() <= cVar.pp() || cVar.pb() != cVar.pq() || !oJ()) {
                        if (cVar.oZ() != cVar.pp() || cVar.pb() <= cVar.pq() || !oI()) {
                            a(1, 17, cVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (cVar.pw() > cVar.px() && !oK()) {
                    a(1, 21, cVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.b.c oU() {
        return this.Lu;
    }

    public void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.Lu = cVar;
    }

    public com.baidu.tbadk.coreExtra.b.c oV() {
        return this.Lv;
    }
}
