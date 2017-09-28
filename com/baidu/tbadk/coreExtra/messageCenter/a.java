package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a arN;
    private static Date arQ = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yB().b(a.yB().yX());
            }
        }
    };
    private e arP;
    private String arS;
    private String arT;
    private int arG = 0;
    private int arH = 0;
    private int arI = 0;
    private int arJ = 0;
    private int arK = 0;
    private int arL = 0;
    private int arM = 0;
    private e arO = new e();
    private boolean arR = true;
    private final int[] arU = new int[10];
    private final Context arF = TbadkCoreApplication.getInst().getApp();

    public static a yB() {
        if (arN == null) {
            arN = new a();
        }
        return arN;
    }

    private a() {
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.arS = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.arS = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.arT = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.arG || i2 != this.arH || i3 != this.arI || i4 != this.arK || i5 != this.arJ || i6 != this.arL) {
            if (i > this.arG || i2 > this.arH || i3 > this.arI || i4 > this.arK || i5 > this.arJ || i6 > this.arL) {
                i7 = 1;
            } else {
                i7 = (i < this.arG || i2 < this.arH) ? 2 : 0;
            }
            if (i > this.arG) {
                i8 = 1;
            } else {
                i8 = i < this.arG ? 2 : 0;
            }
            if (i2 > this.arH) {
                i9 = 1;
            } else {
                i9 = i2 < this.arH ? 2 : 0;
            }
            int i11 = i3 > this.arI ? 1 : 0;
            int i12 = i4 > this.arK ? 1 : 0;
            int i13 = i6 <= this.arL ? 0 : 1;
            this.arG = i;
            this.arH = i2;
            this.arI = i3;
            this.arK = i4;
            this.arJ = i5;
            this.arL = i6;
            if (yV() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yT();
                F(i10, 23);
                F(i11, 16);
                F(i7, 17);
                F(i8, 24);
                F(i9, 25);
                F(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.arG || i2 != this.arH || i3 != this.arI || i4 != this.arK || this.arL != i5) {
            this.arG = i;
            this.arH = i2;
            this.arI = i3;
            this.arK = i4;
            this.arL = i5;
            yT();
            if (yV() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean yC() {
        if (arQ == null) {
            arQ = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - arQ.getTime() < 10000) {
                return false;
            }
            arQ = date;
        }
        return true;
    }

    public static boolean yD() {
        if (b.yY().zj()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.yY().zl().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.yY().zm().split(":");
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

    private void F(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.arL > 0) {
                        String format = String.format(this.arF.getString(d.l.notify_gift), String.valueOf(this.arL));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.arG > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.arG > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.arG));
                            sb.append(this.arF.getString(d.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.arS != null) {
                            sb.append(this.arS);
                        } else {
                            sb.append(this.arF.getString(d.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.arH > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.arH > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.arH));
                            sb2.append(this.arF.getString(d.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.arT != null) {
                            sb2.append(this.arT);
                        } else {
                            sb2.append(this.arF.getString(d.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.arK > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.arK > 1) {
                            sb3.append(String.format(this.arF.getString(d.l.notify_fans_unit), Integer.valueOf(this.arK)));
                        }
                        sb3.append(this.arF.getString(d.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.yY().zn() || b.yY().zb() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.arF, 16);
                NotificationHelper.cancelNotification(this.arF, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x030b A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x0117, B:47:0x0134, B:49:0x013e, B:51:0x0148, B:52:0x0152, B:54:0x015c, B:56:0x0166, B:60:0x0170, B:62:0x0178, B:65:0x01a8, B:67:0x01b7, B:68:0x01d7, B:70:0x01dd, B:71:0x01fb, B:74:0x0202, B:76:0x020c, B:79:0x021a, B:81:0x0220, B:83:0x0226, B:84:0x022a, B:86:0x0230, B:88:0x0238, B:90:0x0240, B:92:0x0244, B:94:0x024a, B:97:0x0254, B:99:0x025a, B:101:0x0260, B:102:0x0264, B:104:0x026a, B:106:0x0272, B:108:0x027a, B:110:0x027e, B:112:0x0284, B:113:0x028a, B:115:0x0294, B:117:0x029e, B:119:0x02a9, B:121:0x02af, B:123:0x02b5, B:125:0x02c3, B:126:0x02de, B:128:0x02e4, B:131:0x02ec, B:133:0x030b, B:135:0x031b, B:144:0x0363, B:141:0x035a, B:136:0x032c, B:138:0x0332, B:140:0x0338, B:147:0x0384), top: B:154:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x031b A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x0117, B:47:0x0134, B:49:0x013e, B:51:0x0148, B:52:0x0152, B:54:0x015c, B:56:0x0166, B:60:0x0170, B:62:0x0178, B:65:0x01a8, B:67:0x01b7, B:68:0x01d7, B:70:0x01dd, B:71:0x01fb, B:74:0x0202, B:76:0x020c, B:79:0x021a, B:81:0x0220, B:83:0x0226, B:84:0x022a, B:86:0x0230, B:88:0x0238, B:90:0x0240, B:92:0x0244, B:94:0x024a, B:97:0x0254, B:99:0x025a, B:101:0x0260, B:102:0x0264, B:104:0x026a, B:106:0x0272, B:108:0x027a, B:110:0x027e, B:112:0x0284, B:113:0x028a, B:115:0x0294, B:117:0x029e, B:119:0x02a9, B:121:0x02af, B:123:0x02b5, B:125:0x02c3, B:126:0x02de, B:128:0x02e4, B:131:0x02ec, B:133:0x030b, B:135:0x031b, B:144:0x0363, B:141:0x035a, B:136:0x032c, B:138:0x0332, B:140:0x0338, B:147:0x0384), top: B:154:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, e eVar) {
        boolean z;
        String zU;
        String zT;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.arL > 0) {
                            String format = String.format(this.arF.getString(d.l.notify_gift), String.valueOf(this.arL));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.arG > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.arG > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.arG));
                                sb.append(this.arF.getString(d.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.arS != null) {
                                sb.append(this.arS);
                            } else {
                                sb.append(this.arF.getString(d.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.arH > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.arH > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.arH));
                                sb2.append(this.arF.getString(d.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.arT != null) {
                                sb2.append(this.arT);
                            } else {
                                sb2.append(this.arF.getString(d.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.arK > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.arK > 1) {
                                sb3.append(String.format(this.arF.getString(d.l.notify_fans_unit), Integer.valueOf(this.arK)));
                            }
                            sb3.append(this.arF.getString(d.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zK = (!b.yY().zn() || b.yY().zb() <= 0) ? 0 : eVar.zK() - eVar.zR();
                        long Ac = (!b.yY().zg() || b.yY().zb() <= 0) ? 0L : eVar.Ac();
                        boolean z4 = Ac > 0;
                        long j = zK + Ac;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.arF.getString(d.l.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Af();
                            eVar.Ad();
                            if (Ac == 1) {
                                zU = eVar.Af();
                                str = eVar.Ad();
                                zT = zU + "：" + str;
                            } else if (zK == 1) {
                                zU = eVar.zU();
                                zT = eVar.zT();
                                str = zT;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.arF.getString(d.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zT)) {
                                zT = str;
                            }
                            a(16, zU, str, zT, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Am = eVar.Am();
                        if (Am != null && Am.size() != 0) {
                            for (e.b bVar : Am) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.atm != 0 && bVar.unReadCount > bVar.atn) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> An = eVar.An();
                        if (An != null && An.size() != 0) {
                            for (e.a aVar : An) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.atm != 0 && aVar.unReadCount > aVar.atn) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.yY().zn() && b.yY().zb() > 0) {
                        if (eVar.zL() + eVar.zN() > 0) {
                            if (eVar.zL() > 0 && !yK()) {
                                long zL = eVar.zL() - eVar.zM();
                                if (zL > 0) {
                                    stringBuffer.append(String.format(this.arF.getString(d.l.notify_updates), Long.valueOf(zL)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zM() > 0) {
                                    z = true;
                                }
                                if (eVar.zN() > 0 || yJ()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.arF.getString(d.l.notify_validate), Integer.valueOf(eVar.zN())));
                                } else {
                                    stringBuffer.append(String.format(this.arF.getString(d.l.notify_validate_1), Integer.valueOf(eVar.zN())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zW(), eVar.zX(), eVar.zX());
                                }
                            }
                            z = false;
                            if (eVar.zN() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ag() > 0 && !yL()) {
                            String format2 = String.format(this.arF.getString(d.l.notify_live), Integer.valueOf(eVar.Ag()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.arF, 16);
                    NotificationHelper.cancelNotification(this.arF, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null || (a = b(bVar)) != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arF, bVar.atm, a, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arF, i, bVar.title, bVar.content, bVar.ato, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arF, aVar.atm, a, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arF, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.arR) {
            if (i == 23 && this.arL > 0) {
                g = dT(i);
            } else if (i == 26 && this.arK > 0) {
                g = dU(i);
            } else if (i == 18) {
                g = yE();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arF, i, g, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arF, i, str, str2, str3, service, false);
        }
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.arL);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dU(int i) {
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 35);
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
        ImMessageCenterPojo Z = com.baidu.tieba.im.memorycache.b.axM().Z(bVar.atm + "", bVar.userType);
        if (Z == null || Z.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(Z.getLastContentRawData());
            if (jSONArray.length() == 1) {
                String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                if (StringUtils.isNull(optString)) {
                    return null;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (StringUtils.isNull(group)) {
                        return null;
                    }
                    Intent intent = new Intent(this.arF, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.atm);
                    return intent;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Intent b(e.b bVar) {
        if (bVar == null) {
            return null;
        }
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.atm);
        intent.putExtra("uname", bVar.atp);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.atm));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.arO.Ae().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.arH);
        intent.putExtra("reply_me", this.arG);
        intent.putExtra("fans", this.arK);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.arO.zK() - this.arO.zR());
        intent.putExtra("group_msg_validate", this.arO.zN());
        intent.putExtra("group_msg_updates", this.arO.zL());
        intent.putExtra("live_notify_msg_updates", this.arO.Ag());
        intent.putExtra("officialbar_msg", this.arO.zO());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yE() {
        Intent intent = new Intent(this.arF, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.arO.zM());
        return intent;
    }

    public void yF() {
        NotificationHelper.cancelNotification(this.arF, 23);
        NotificationHelper.cancelNotification(this.arF, 24);
        NotificationHelper.cancelNotification(this.arF, 25);
        NotificationHelper.cancelNotification(this.arF, 26);
        NotificationHelper.cancelNotification(this.arF, 17);
        NotificationHelper.cancelNotification(this.arF, 15);
        NotificationHelper.cancelNotification(this.arF, 13);
        NotificationHelper.cancelNotification(this.arF, 12);
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.arF, 16);
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.arF, 19);
    }

    public void dV(int i) {
        NotificationHelper.cancelNotification(this.arF, i);
    }

    public int yI() {
        return this.arO.Aj();
    }

    public void eD(String str) {
        if (TextUtils.isEmpty(str)) {
            yG();
            return;
        }
        e yW = yW();
        if (yW == null) {
            yG();
            return;
        }
        HashMap<String, String> zY = yW.zY();
        if (zY == null || zY.isEmpty()) {
            yG();
        } else if (zY.containsKey(str)) {
            yG();
        }
    }

    public void eE(String str) {
        if (TextUtils.isEmpty(str)) {
            yG();
            return;
        }
        e yW = yW();
        if (yW == null) {
            yG();
            return;
        }
        HashMap<String, String> Ae = yW.Ae();
        if (Ae == null || Ae.isEmpty()) {
            yG();
        } else if (Ae.containsKey(str)) {
            yG();
        }
    }

    private boolean yJ() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yK() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yL() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yM() {
        NotificationHelper.cancelNotification(this.arF, 17);
    }

    public void dW(int i) {
        e yW = yW();
        if (yW == null) {
            yM();
        } else if (1 == i) {
            if (yW.zL() <= 0) {
                yM();
            }
        } else if (2 == i) {
            if (yW.zN() <= 0) {
                yM();
            }
        } else if (3 == i && yW.Ag() <= 0) {
            NotificationHelper.cancelNotification(this.arF, 21);
        }
    }

    public void yN() {
        NotificationHelper.cancelNotification(this.arF, 18);
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.arF, 26);
        NotificationHelper.cancelNotification(this.arF, 25);
        NotificationHelper.cancelNotification(this.arF, 24);
        NotificationHelper.cancelNotification(this.arF, 23);
        NotificationHelper.cancelNotification(this.arF, 16);
        NotificationHelper.cancelNotification(this.arF, 17);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.arF, 21);
        NotificationHelper.cancelNotification(this.arF, 17);
        NotificationHelper.cancelNotification(this.arF, 19);
        NotificationHelper.cancelNotification(this.arF, 16);
        NotificationHelper.cancelNotification(this.arF, 18);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.arF, 24);
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.arF, 25);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.arF, 23);
    }

    public void yT() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yU());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.arO.Ac());
        newsNotifyMessage.setMsgStrangerChat(this.arO.Aj());
        newsNotifyMessage.setMsgOfficialMerge(this.arO.Ai());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Ac() + eVar.zK()) + eVar.Aj()) + eVar.Ai()) + eVar.Ao()) - eVar.zR());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Ac());
            newsNotifyMessage.setMsgStrangerChat(eVar.Aj());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ai());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.arG;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.arH, this.arI, this.arK, this.arJ, this.arL);
        }
    }

    public int getMsgAtme() {
        return this.arH;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.arG, i, this.arI, this.arK, this.arJ, this.arL);
        }
    }

    public int getMsgChat() {
        return this.arI;
    }

    public int yU() {
        return ((((this.arO.Ac() + this.arO.zK()) + this.arO.Aj()) + this.arO.Ai()) + this.arO.Ao()) - this.arO.zR();
    }

    public int getMsgFans() {
        return this.arK;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.arG, this.arH, this.arI, i, this.arJ, this.arL);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.arG, this.arH, i, this.arK, this.arJ, this.arL);
        }
    }

    public int getMsgBookmark() {
        return this.arJ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.arG, this.arH, this.arI, this.arK, i, this.arL);
        }
    }

    public int getMsgGiftNum() {
        return this.arL;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.arL = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.arM = i;
            yT();
        }
    }

    public int getMsgLiveVip() {
        return this.arM;
    }

    public void aT(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.arG = 0;
        this.arH = 0;
        this.arI = 0;
        this.arK = 0;
        this.arJ = 0;
    }

    public int yV() {
        return this.arG + this.arH + this.arI + this.arK + this.arL;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.arO = eVar;
            this.arI = (eVar.zK() - eVar.zR()) + eVar.Ac() + eVar.Ai() + eVar.Ao();
            a(eVar);
            if (eVar.zS()) {
                this.arP = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zS()) {
                if (b.yY().zn() && b.yY().zb() > 0) {
                    i = eVar.zK() - eVar.zR();
                }
                long Ac = (!b.yY().zg() || b.yY().zb() <= 0) ? 0L : eVar.Ac();
                if ((i > 0 || Ac > 0) && ((i > eVar.zV() - eVar.zR() && i > 0) || Ac > eVar.zP())) {
                    a(1, 16, eVar);
                }
                int zO = eVar.zO();
                if (zO > 0 && zO > eVar.Ab()) {
                    a(1, 19, eVar);
                }
                if (eVar.zL() > eVar.zZ() || eVar.zN() > eVar.Aa()) {
                    if (eVar.zL() <= eVar.zZ() || eVar.zN() != eVar.Aa() || !yK()) {
                        if (eVar.zL() != eVar.zZ() || eVar.zN() <= eVar.Aa() || !yJ()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Ag() > eVar.Ah() && !yL()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ak() > eVar.Al()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e yW() {
        return this.arO;
    }

    public void c(e eVar) {
        this.arO = eVar;
    }

    public e yX() {
        return this.arP;
    }

    public int dX(int i) {
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

    public void G(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arF, 26, i2);
        }
    }
}
