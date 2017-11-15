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
    private static a asa;
    private static Date asd = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yK().b(a.yK().zg());
            }
        }
    };
    private e asc;
    private String asf;
    private String asg;
    private int arT = 0;
    private int arU = 0;
    private int arV = 0;
    private int arW = 0;
    private int arX = 0;
    private int arY = 0;
    private int arZ = 0;
    private e asb = new e();
    private boolean ase = true;
    private final int[] ash = new int[10];
    private final Context arS = TbadkCoreApplication.getInst().getApp();

    public static a yK() {
        if (asa == null) {
            asa = new a();
        }
        return asa;
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
                    this.asf = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.asf = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.asg = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.arT || i2 != this.arU || i3 != this.arV || i4 != this.arX || i5 != this.arW || i6 != this.arY) {
            if (i > this.arT || i2 > this.arU || i3 > this.arV || i4 > this.arX || i5 > this.arW || i6 > this.arY) {
                i7 = 1;
            } else {
                i7 = (i < this.arT || i2 < this.arU) ? 2 : 0;
            }
            if (i > this.arT) {
                i8 = 1;
            } else {
                i8 = i < this.arT ? 2 : 0;
            }
            if (i2 > this.arU) {
                i9 = 1;
            } else {
                i9 = i2 < this.arU ? 2 : 0;
            }
            int i11 = i3 > this.arV ? 1 : 0;
            int i12 = i4 > this.arX ? 1 : 0;
            int i13 = i6 <= this.arY ? 0 : 1;
            this.arT = i;
            this.arU = i2;
            this.arV = i3;
            this.arX = i4;
            this.arW = i5;
            this.arY = i6;
            if (ze() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zc();
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
        if (i != this.arT || i2 != this.arU || i3 != this.arV || i4 != this.arX || this.arY != i5) {
            this.arT = i;
            this.arU = i2;
            this.arV = i3;
            this.arX = i4;
            this.arY = i5;
            zc();
            if (ze() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean yL() {
        if (asd == null) {
            asd = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - asd.getTime() < 10000) {
                return false;
            }
            asd = date;
        }
        return true;
    }

    public static boolean yM() {
        if (b.zh().zs()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zh().zu().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zh().zv().split(":");
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
                    if (this.arY > 0) {
                        String format = String.format(this.arS.getString(d.j.notify_gift), String.valueOf(this.arY));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.arT > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.arT > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.arT));
                            sb.append(this.arS.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.asf != null) {
                            sb.append(this.asf);
                        } else {
                            sb.append(this.arS.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.arU > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.arU > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.arU));
                            sb2.append(this.arS.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.asg != null) {
                            sb2.append(this.asg);
                        } else {
                            sb2.append(this.arS.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.arX > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.arX > 1) {
                            sb3.append(String.format(this.arS.getString(d.j.notify_fans_unit), Integer.valueOf(this.arX)));
                        }
                        sb3.append(this.arS.getString(d.j.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zh().zw() || b.zh().zk() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.arS, 16);
                NotificationHelper.cancelNotification(this.arS, 17);
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
                        if (this.arY > 0) {
                            String format = String.format(this.arS.getString(d.j.notify_gift), String.valueOf(this.arY));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.arT > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.arT > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.arT));
                                sb.append(this.arS.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.asf != null) {
                                sb.append(this.asf);
                            } else {
                                sb.append(this.arS.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.arU > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.arU > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.arU));
                                sb2.append(this.arS.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.asg != null) {
                                sb2.append(this.asg);
                            } else {
                                sb2.append(this.arS.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.arX > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.arX > 1) {
                                sb3.append(String.format(this.arS.getString(d.j.notify_fans_unit), Integer.valueOf(this.arX)));
                            }
                            sb3.append(this.arS.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zT = (!b.zh().zw() || b.zh().zk() <= 0) ? 0 : eVar.zT() - eVar.Aa();
                        long Al = (!b.zh().zp() || b.zh().zk() <= 0) ? 0L : eVar.Al();
                        boolean z4 = Al > 0;
                        long j = zT + Al;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.arS.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ao();
                            eVar.Am();
                            if (Al == 1) {
                                Ad = eVar.Ao();
                                str = eVar.Am();
                                Ac = Ad + "：" + str;
                            } else if (zT == 1) {
                                Ad = eVar.Ad();
                                Ac = eVar.Ac();
                                str = Ac;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.arS.getString(d.j.notify_chat), Long.valueOf(j))).toString();
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
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.atz != 0 && bVar.unReadCount > bVar.atA) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Aw = eVar.Aw();
                        if (Aw != null && Aw.size() != 0) {
                            for (e.a aVar : Aw) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.atz != 0 && aVar.unReadCount > aVar.atA) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zh().zw() && b.zh().zk() > 0) {
                        if (eVar.zU() + eVar.zW() > 0) {
                            if (eVar.zU() > 0 && !yT()) {
                                long zU = eVar.zU() - eVar.zV();
                                if (zU > 0) {
                                    stringBuffer.append(String.format(this.arS.getString(d.j.notify_updates), Long.valueOf(zU)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zV() > 0) {
                                    z = true;
                                }
                                if (eVar.zW() > 0 || yS()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.arS.getString(d.j.notify_validate), Integer.valueOf(eVar.zW())));
                                } else {
                                    stringBuffer.append(String.format(this.arS.getString(d.j.notify_validate_1), Integer.valueOf(eVar.zW())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Af(), eVar.Ag(), eVar.Ag());
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
                        if (eVar.Ap() > 0 && !yU()) {
                            String format2 = String.format(this.arS.getString(d.j.notify_live), Integer.valueOf(eVar.Ap()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.arS, 16);
                    NotificationHelper.cancelNotification(this.arS, 17);
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
            PendingIntent service = PendingIntent.getService(this.arS, bVar.atz, a, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.arS, i, bVar.title, bVar.content, bVar.atB, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arS, aVar.atz, a, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.arS, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.ase) {
            if (i == 23 && this.arY > 0) {
                g = dS(i);
            } else if (i == 26 && this.arX > 0) {
                g = dT(i);
            } else if (i == 18) {
                g = yN();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arS, i, g, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.arS, i, str, str2, str3, service, false);
        }
    }

    public Intent dS(int i) {
        Intent intent = new Intent(this.arS, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.arY);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.arS, DealIntentService.class);
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
        ImMessageCenterPojo af = com.baidu.tieba.im.memorycache.b.aAg().af(bVar.atz + "", bVar.userType);
        if (af == null || af.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(af.getLastContentRawData());
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
                    Intent intent = new Intent(this.arS, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.atz);
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
        Intent intent = new Intent(this.arS, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.atz);
        intent.putExtra("uname", bVar.atC);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.arS, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.atz));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.asb.An().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.arS, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.arU);
        intent.putExtra("reply_me", this.arT);
        intent.putExtra("fans", this.arX);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.asb.zT() - this.asb.Aa());
        intent.putExtra("group_msg_validate", this.asb.zW());
        intent.putExtra("group_msg_updates", this.asb.zU());
        intent.putExtra("live_notify_msg_updates", this.asb.Ap());
        intent.putExtra("officialbar_msg", this.asb.zX());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yN() {
        Intent intent = new Intent(this.arS, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.asb.zV());
        return intent;
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.arS, 23);
        NotificationHelper.cancelNotification(this.arS, 24);
        NotificationHelper.cancelNotification(this.arS, 25);
        NotificationHelper.cancelNotification(this.arS, 26);
        NotificationHelper.cancelNotification(this.arS, 17);
        NotificationHelper.cancelNotification(this.arS, 15);
        NotificationHelper.cancelNotification(this.arS, 13);
        NotificationHelper.cancelNotification(this.arS, 12);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.arS, 16);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.arS, 19);
    }

    public void dU(int i) {
        NotificationHelper.cancelNotification(this.arS, i);
    }

    public int yR() {
        return this.asb.As();
    }

    public void eJ(String str) {
        if (TextUtils.isEmpty(str)) {
            yP();
            return;
        }
        e zf = zf();
        if (zf == null) {
            yP();
            return;
        }
        HashMap<String, String> Ah = zf.Ah();
        if (Ah == null || Ah.isEmpty()) {
            yP();
        } else if (Ah.containsKey(str)) {
            yP();
        }
    }

    public void eK(String str) {
        if (TextUtils.isEmpty(str)) {
            yP();
            return;
        }
        e zf = zf();
        if (zf == null) {
            yP();
            return;
        }
        HashMap<String, String> An = zf.An();
        if (An == null || An.isEmpty()) {
            yP();
        } else if (An.containsKey(str)) {
            yP();
        }
    }

    private boolean yS() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yT() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yU() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yV() {
        NotificationHelper.cancelNotification(this.arS, 17);
    }

    public void dV(int i) {
        e zf = zf();
        if (zf == null) {
            yV();
        } else if (1 == i) {
            if (zf.zU() <= 0) {
                yV();
            }
        } else if (2 == i) {
            if (zf.zW() <= 0) {
                yV();
            }
        } else if (3 == i && zf.Ap() <= 0) {
            NotificationHelper.cancelNotification(this.arS, 21);
        }
    }

    public void yW() {
        NotificationHelper.cancelNotification(this.arS, 18);
    }

    public void yX() {
        NotificationHelper.cancelNotification(this.arS, 26);
        NotificationHelper.cancelNotification(this.arS, 25);
        NotificationHelper.cancelNotification(this.arS, 24);
        NotificationHelper.cancelNotification(this.arS, 23);
        NotificationHelper.cancelNotification(this.arS, 16);
        NotificationHelper.cancelNotification(this.arS, 17);
    }

    public void yY() {
        NotificationHelper.cancelNotification(this.arS, 21);
        NotificationHelper.cancelNotification(this.arS, 17);
        NotificationHelper.cancelNotification(this.arS, 19);
        NotificationHelper.cancelNotification(this.arS, 16);
        NotificationHelper.cancelNotification(this.arS, 18);
    }

    public void yZ() {
        NotificationHelper.cancelNotification(this.arS, 24);
    }

    public void za() {
        NotificationHelper.cancelNotification(this.arS, 25);
    }

    public void zb() {
        NotificationHelper.cancelNotification(this.arS, 23);
    }

    public void zc() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zd());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.asb.Al());
        newsNotifyMessage.setMsgStrangerChat(this.asb.As());
        newsNotifyMessage.setMsgOfficialMerge(this.asb.Ar());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
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
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ar());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.arT;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.arU, this.arV, this.arX, this.arW, this.arY);
        }
    }

    public int getMsgAtme() {
        return this.arU;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.arT, i, this.arV, this.arX, this.arW, this.arY);
        }
    }

    public int getMsgChat() {
        return this.arV;
    }

    public int zd() {
        return ((((this.asb.Al() + this.asb.zT()) + this.asb.As()) + this.asb.Ar()) + this.asb.Ax()) - this.asb.Aa();
    }

    public int getMsgFans() {
        return this.arX;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.arT, this.arU, this.arV, i, this.arW, this.arY);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.arT, this.arU, i, this.arX, this.arW, this.arY);
        }
    }

    public int getMsgBookmark() {
        return this.arW;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.arT, this.arU, this.arV, this.arX, i, this.arY);
        }
    }

    public int getMsgGiftNum() {
        return this.arY;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.arY = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.arZ = i;
            zc();
        }
    }

    public int getMsgLiveVip() {
        return this.arZ;
    }

    public void aR(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.arT = 0;
        this.arU = 0;
        this.arV = 0;
        this.arX = 0;
        this.arW = 0;
    }

    public int ze() {
        return this.arT + this.arU + this.arV + this.arX + this.arY;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.asb = eVar;
            this.arV = (eVar.zT() - eVar.Aa()) + eVar.Al() + eVar.Ar() + eVar.Ax();
            a(eVar);
            if (eVar.Ab()) {
                this.asc = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ab()) {
                if (b.zh().zw() && b.zh().zk() > 0) {
                    i = eVar.zT() - eVar.Aa();
                }
                long Al = (!b.zh().zp() || b.zh().zk() <= 0) ? 0L : eVar.Al();
                if ((i > 0 || Al > 0) && ((i > eVar.Ae() - eVar.Aa() && i > 0) || Al > eVar.zY())) {
                    a(1, 16, eVar);
                }
                int zX = eVar.zX();
                if (zX > 0 && zX > eVar.Ak()) {
                    a(1, 19, eVar);
                }
                if (eVar.zU() > eVar.Ai() || eVar.zW() > eVar.Aj()) {
                    if (eVar.zU() <= eVar.Ai() || eVar.zW() != eVar.Aj() || !yT()) {
                        if (eVar.zU() != eVar.Ai() || eVar.zW() <= eVar.Aj() || !yS()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Ap() > eVar.Aq() && !yU()) {
                    a(1, 21, eVar);
                }
                if (eVar.At() > eVar.Au()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zf() {
        return this.asb;
    }

    public void c(e eVar) {
        this.asb = eVar;
    }

    public e zg() {
        return this.asc;
    }

    public int dW(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arS, 26, i2);
        }
    }
}
