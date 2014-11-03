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
    private static boolean LA;
    private static boolean LB;
    private static boolean LC;
    private static a Lw;
    private static Date Lz = null;
    private static Handler mHandler = new b();
    private com.baidu.tbadk.coreExtra.b.c Ly;
    private int Lq = 0;
    private int Lr = 0;
    private int Ls = 0;
    private int Lt = 0;
    private int Lu = 0;
    private int Lv = 0;
    private com.baidu.tbadk.coreExtra.b.c Lx = new com.baidu.tbadk.coreExtra.b.c();
    private final int[] LD = new int[10];
    private final Context Lp = TbadkApplication.m251getInst().getApp();

    static {
        if (TbadkApplication.m251getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(new c(2008004));
            MessageManager.getInstance().registerListener(new d(2008005));
            MessageManager.getInstance().registerListener(new e(2008018));
        }
    }

    public static a oD() {
        if (Lw == null) {
            Lw = new a();
        }
        return Lw;
    }

    private a() {
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.Lq || i2 != this.Lr || i3 != this.Ls || i4 != this.Lu || i5 != this.Lt || i6 != this.Lv) {
            int i7 = 0;
            if (i > this.Lq || i2 > this.Lr || i3 > this.Ls || i4 > this.Lu || i5 > this.Lt || i6 > this.Lv) {
                i7 = 1;
            } else if (i < this.Lq || i2 < this.Lr) {
                i7 = 2;
            }
            this.Lq = i;
            this.Lr = i2;
            this.Ls = i3;
            this.Lu = i4;
            this.Lt = i5;
            this.Lv = i6;
            int i8 = oV() > 0 ? i7 : 2;
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
                oT();
                r(i8, 23);
                r(i8, 16);
                r(i8, 17);
                r(i8, 11);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.Lq || i2 != this.Lr || i3 != this.Ls || i4 != this.Lu || this.Lv != i5) {
            this.Lq = i;
            this.Lr = i2;
            this.Ls = i3;
            this.Lu = i4;
            this.Lv = i5;
            oT();
            if (oV() <= 0) {
                r(2, 16);
                r(2, 17);
                r(2, 11);
            }
        }
    }

    public static boolean oE() {
        if (Lz == null) {
            Lz = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - Lz.getTime() < 10000) {
                return false;
            }
            Lz = date;
        }
        return true;
    }

    public static boolean oF() {
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
                    if (this.Lv > 0) {
                        b(23, null, String.format(this.Lp.getString(y.notify_gift), String.valueOf(this.Lv)));
                    }
                } else if (i2 == 11) {
                    if (this.Lq > 0 || this.Lr > 0 || this.Lu > 0) {
                        int i3 = this.Lq + this.Lr;
                        if (i3 > 0) {
                            stringBuffer.append(String.valueOf(i3));
                            stringBuffer.append(this.Lp.getString(y.notify_msg));
                        }
                        if (this.Lu > 0) {
                            stringBuffer.append(String.valueOf(this.Lu));
                            stringBuffer.append(this.Lp.getString(y.notify_fans));
                        }
                        stringBuffer.append(this.Lp.getString(y.notify_click));
                        b(11, null, stringBuffer.toString());
                    }
                } else if (i2 != 16 && TbadkApplication.m251getInst().isGroupMsgOn()) {
                    TbadkApplication.m251getInst().getMsgFrequency();
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.Lp, 11);
                NotificationHelper.cancelNotification(this.Lp, 16);
                NotificationHelper.cancelNotification(this.Lp, 17);
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
        String pm;
        String pl;
        boolean z2 = false;
        boolean z3 = true;
        if (cVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23 && this.Lv > 0) {
                        b(23, null, String.format(this.Lp.getString(y.notify_gift), String.valueOf(this.Lv)));
                    }
                    if (i2 == 11) {
                        if (this.Lq > 0 || this.Lr > 0 || this.Lu > 0) {
                            int i3 = this.Lq + this.Lr;
                            if (i3 > 0) {
                                stringBuffer.append(String.valueOf(i3));
                                stringBuffer.append(this.Lp.getString(y.notify_msg));
                            }
                            if (this.Lu > 0) {
                                stringBuffer.append(String.valueOf(this.Lu));
                                stringBuffer.append(this.Lp.getString(y.notify_fans));
                            }
                            stringBuffer.append(this.Lp.getString(y.notify_click));
                            b(11, null, stringBuffer.toString());
                        }
                    } else if (i2 == 16) {
                        int pa = (!TbadkApplication.m251getInst().isGroupMsgOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) ? 0 : cVar.pa() - cVar.pj();
                        if (!TbadkApplication.m251getInst().isMsgChatOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) {
                            j = 0;
                        } else {
                            j = cVar.pu();
                        }
                        boolean z4 = j > 0;
                        long j2 = pa + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.Lp.getString(y.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            cVar.px();
                            cVar.pv();
                            if (j == 1) {
                                pm = cVar.px();
                                pl = cVar.pv();
                            } else if (pa == 1) {
                                pm = cVar.pm();
                                pl = cVar.pl();
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(pl)) {
                                pl = stringBuffer.append(String.format(this.Lp.getString(y.notify_chat), Long.valueOf(j2))).toString();
                            }
                            a(16, pm, pl, z4);
                        }
                    } else if (i2 == 19) {
                        long pe = cVar.pe();
                        if (pe > 1) {
                            stringBuffer.append(String.format(this.Lp.getString(y.notify_official_message), Long.valueOf(pe)));
                            b(19, null, stringBuffer.toString());
                        } else if (pe == 1) {
                            String ph = cVar.ph();
                            String pi = cVar.pi();
                            if (TextUtils.isEmpty(pi)) {
                                pi = stringBuffer.append(String.format(this.Lp.getString(y.notify_official_message), Long.valueOf(pe))).toString();
                            }
                            b(19, ph, pi);
                        }
                    } else if (TbadkApplication.m251getInst().isGroupMsgOn() && TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                        if (cVar.pb() + cVar.pd() > 0) {
                            if (cVar.pb() > 0 && !oL()) {
                                long pb = cVar.pb() - cVar.pc();
                                if (pb > 0) {
                                    stringBuffer.append(String.format(this.Lp.getString(y.notify_updates), Long.valueOf(pb)));
                                    z = false;
                                    z2 = true;
                                } else if (cVar.pc() > 0) {
                                    z = true;
                                }
                                if (cVar.pd() > 0 || oK()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.Lp.getString(y.notify_validate), Integer.valueOf(cVar.pd())));
                                } else {
                                    stringBuffer.append(String.format(this.Lp.getString(y.notify_validate_1), Integer.valueOf(cVar.pd())));
                                }
                                if (z3) {
                                    b(17, null, stringBuffer.toString());
                                }
                                if (z) {
                                    b(18, cVar.po(), cVar.pp());
                                }
                            }
                            z = false;
                            if (cVar.pd() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (cVar.py() > 0 && !oM()) {
                            b(21, null, String.format(this.Lp.getString(y.notify_live), Integer.valueOf(cVar.py())));
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.Lp, 11);
                    NotificationHelper.cancelNotification(this.Lp, 16);
                    NotificationHelper.cancelNotification(this.Lp, 17);
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
        if (i == 23 && this.Lv > 0) {
            e = bW(i);
        } else if (i == 11 && this.Lu > 0 && this.Lq == 0 && this.Lr == 0) {
            e = bX(i);
        } else if (i == 18) {
            e = oG();
        } else {
            e = e(i, z);
        }
        e.setFlags(268435456);
        NotificationHelper.showNotification(this.Lp, i, str, str2, str2, PendingIntent.getService(this.Lp, i, e, 134217728), false);
    }

    private Intent bW(int i) {
        Intent intent = new Intent(this.Lp, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.Lv);
        String currentAccount = TbadkApplication.getCurrentAccount();
        String currentAccountName = TbadkApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    private Intent bX(int i) {
        Intent intent = new Intent(this.Lp, DealIntentService.class);
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
            Set<String> keySet = this.Lx.pw().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.Lp, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.Lr);
        intent.putExtra("reply_me", this.Lq);
        intent.putExtra("fans", this.Lu);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.Lx.pa() - this.Lx.pj());
        intent.putExtra("group_msg_validate", this.Lx.pd());
        intent.putExtra("group_msg_updates", this.Lx.pb());
        intent.putExtra("live_notify_msg_updates", this.Lx.py());
        intent.putExtra("officialbar_msg", this.Lx.pe());
        intent.putExtra("privateGid", str);
        return intent;
    }

    private Intent oG() {
        Intent intent = new Intent(this.Lp, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.Lx.pc());
        return intent;
    }

    public void oH() {
        NotificationHelper.cancelNotification(this.Lp, 11);
        NotificationHelper.cancelNotification(this.Lp, 16);
        NotificationHelper.cancelNotification(this.Lp, 17);
        NotificationHelper.cancelNotification(this.Lp, 15);
        NotificationHelper.cancelNotification(this.Lp, 13);
        NotificationHelper.cancelNotification(this.Lp, 12);
    }

    public void oI() {
        NotificationHelper.cancelNotification(this.Lp, 16);
    }

    public void oJ() {
        NotificationHelper.cancelNotification(this.Lp, 19);
    }

    public void cq(String str) {
        if (TextUtils.isEmpty(str)) {
            oI();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c oW = oW();
        if (oW == null) {
            oI();
            return;
        }
        HashMap<String, String> pq = oW.pq();
        if (pq == null || pq.isEmpty()) {
            oI();
        } else if (pq.containsKey(str)) {
            oI();
        }
    }

    public void cr(String str) {
        if (TextUtils.isEmpty(str)) {
            oI();
            return;
        }
        com.baidu.tbadk.coreExtra.b.c oW = oW();
        if (oW == null) {
            oI();
            return;
        }
        HashMap<String, String> pw = oW.pw();
        if (pw == null || pw.isEmpty()) {
            oI();
        } else if (pw.containsKey(str)) {
            oI();
        }
    }

    private boolean oK() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008004));
        return LA;
    }

    private boolean oL() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008005));
        return LB;
    }

    private boolean oM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2008018));
        return LC;
    }

    public void oN() {
        NotificationHelper.cancelNotification(this.Lp, 17);
    }

    public void bY(int i) {
        com.baidu.tbadk.coreExtra.b.c oW = oW();
        if (oW == null) {
            oN();
        } else if (1 == i) {
            if (oW.pb() <= 0) {
                oN();
            }
        } else if (2 == i) {
            if (oW.pd() <= 0) {
                oN();
            }
        } else if (3 == i && oW.py() <= 0) {
            NotificationHelper.cancelNotification(this.Lp, 21);
        }
    }

    public void oO() {
        NotificationHelper.cancelNotification(this.Lp, 18);
    }

    public void oP() {
        NotificationHelper.cancelNotification(this.Lp, 11);
        NotificationHelper.cancelNotification(this.Lp, 16);
        NotificationHelper.cancelNotification(this.Lp, 17);
    }

    public void oQ() {
        NotificationHelper.cancelNotification(this.Lp, 21);
        NotificationHelper.cancelNotification(this.Lp, 17);
        NotificationHelper.cancelNotification(this.Lp, 19);
        NotificationHelper.cancelNotification(this.Lp, 16);
        NotificationHelper.cancelNotification(this.Lp, 18);
    }

    public void oR() {
        NotificationHelper.cancelNotification(this.Lp, 11);
    }

    public void oS() {
        NotificationHelper.cancelNotification(this.Lp, 23);
    }

    public void oT() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(oU());
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
            newsNotifyMessage.setMsgChat(((cVar.pu() + cVar.pa()) + cVar.pA()) - cVar.pj());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.Lq;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(i, this.Lr, this.Ls, this.Lu, this.Lt, this.Lv);
        }
    }

    public int getMsgAtme() {
        return this.Lr;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.Lq, i, this.Ls, this.Lu, this.Lt, this.Lv);
        }
    }

    public int getMsgChat() {
        return this.Ls;
    }

    public int oU() {
        return ((this.Lx.pu() + this.Lx.pa()) + this.Lx.pA()) - this.Lx.pj();
    }

    public int getMsgFans() {
        return this.Lu;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.Lq, this.Lr, this.Ls, i, this.Lt, this.Lv);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.Lq, this.Lr, i, this.Lu, this.Lt, this.Lv);
        }
    }

    public int getMsgBookmark() {
        return this.Lt;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.Lq, this.Lr, this.Ls, this.Lu, i, this.Lv);
        }
    }

    public int getMsgGiftNum() {
        return this.Lv;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.Lv = i;
        }
    }

    public void ac(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0);
            return;
        }
        this.Lq = 0;
        this.Lr = 0;
        this.Ls = 0;
        this.Lu = 0;
        this.Lt = 0;
    }

    public int oV() {
        return this.Lq + this.Lr + this.Ls + this.Lu + this.Lv;
    }

    public int bZ(int i) {
        return this.LD[i];
    }

    public void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        int i = 0;
        if (cVar != null) {
            this.Lx = cVar;
            this.Ls = (cVar.pa() - cVar.pj()) + cVar.pu() + cVar.pA();
            a(cVar);
            if (cVar.pk()) {
                this.Ly = null;
                mHandler.removeMessages(0);
            }
            if (cVar.pk()) {
                if (TbadkApplication.m251getInst().isGroupMsgOn() && TbadkApplication.m251getInst().getMsgFrequency() > 0) {
                    i = cVar.pa() - cVar.pj();
                }
                long pu = (!TbadkApplication.m251getInst().isMsgChatOn() || TbadkApplication.m251getInst().getMsgFrequency() <= 0) ? 0L : cVar.pu();
                if ((i > 0 || pu > 0) && ((i > cVar.pn() - cVar.pj() && i > 0) || pu > cVar.pf())) {
                    a(1, 16, cVar);
                }
                int pe = cVar.pe();
                if (pe > 0 && pe > cVar.pt()) {
                    a(1, 19, cVar);
                }
                if (cVar.pb() > cVar.pr() || cVar.pd() > cVar.ps()) {
                    if (cVar.pb() <= cVar.pr() || cVar.pd() != cVar.ps() || !oL()) {
                        if (cVar.pb() != cVar.pr() || cVar.pd() <= cVar.ps() || !oK()) {
                            a(1, 17, cVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (cVar.py() > cVar.pz() && !oM()) {
                    a(1, 21, cVar);
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.b.c oW() {
        return this.Lx;
    }

    public void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        this.Lx = cVar;
    }

    public com.baidu.tbadk.coreExtra.b.c oX() {
        return this.Ly;
    }
}
