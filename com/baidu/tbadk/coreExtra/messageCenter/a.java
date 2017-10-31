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
    private static a arU;
    private static Date arX = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yC().b(a.yC().yY());
            }
        }
    };
    private e arW;
    private String arZ;
    private String asa;
    private int arN = 0;
    private int arO = 0;
    private int arP = 0;
    private int arQ = 0;
    private int arR = 0;
    private int arS = 0;
    private int arT = 0;
    private e arV = new e();
    private boolean arY = true;
    private final int[] asb = new int[10];
    private final Context arM = TbadkCoreApplication.getInst().getApp();

    public static a yC() {
        if (arU == null) {
            arU = new a();
        }
        return arU;
    }

    private a() {
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.arZ = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.arZ = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.asa = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.arN || i2 != this.arO || i3 != this.arP || i4 != this.arR || i5 != this.arQ || i6 != this.arS) {
            if (i > this.arN || i2 > this.arO || i3 > this.arP || i4 > this.arR || i5 > this.arQ || i6 > this.arS) {
                i7 = 1;
            } else {
                i7 = (i < this.arN || i2 < this.arO) ? 2 : 0;
            }
            if (i > this.arN) {
                i8 = 1;
            } else {
                i8 = i < this.arN ? 2 : 0;
            }
            if (i2 > this.arO) {
                i9 = 1;
            } else {
                i9 = i2 < this.arO ? 2 : 0;
            }
            int i11 = i3 > this.arP ? 1 : 0;
            int i12 = i4 > this.arR ? 1 : 0;
            int i13 = i6 <= this.arS ? 0 : 1;
            this.arN = i;
            this.arO = i2;
            this.arP = i3;
            this.arR = i4;
            this.arQ = i5;
            this.arS = i6;
            if (yW() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yU();
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
        if (i != this.arN || i2 != this.arO || i3 != this.arP || i4 != this.arR || this.arS != i5) {
            this.arN = i;
            this.arO = i2;
            this.arP = i3;
            this.arR = i4;
            this.arS = i5;
            yU();
            if (yW() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean yD() {
        if (arX == null) {
            arX = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - arX.getTime() < 10000) {
                return false;
            }
            arX = date;
        }
        return true;
    }

    public static boolean yE() {
        if (b.yZ().zk()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.yZ().zm().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.yZ().zn().split(":");
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
                    if (this.arS > 0) {
                        String format = String.format(this.arM.getString(d.j.notify_gift), String.valueOf(this.arS));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.arN > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.arN > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.arN));
                            sb.append(this.arM.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.arZ != null) {
                            sb.append(this.arZ);
                        } else {
                            sb.append(this.arM.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.arO > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.arO > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.arO));
                            sb2.append(this.arM.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.asa != null) {
                            sb2.append(this.asa);
                        } else {
                            sb2.append(this.arM.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.arR > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.arR > 1) {
                            sb3.append(String.format(this.arM.getString(d.j.notify_fans_unit), Integer.valueOf(this.arR)));
                        }
                        sb3.append(this.arM.getString(d.j.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.yZ().zo() || b.yZ().zc() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.arM, 16);
                NotificationHelper.cancelNotification(this.arM, 17);
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
        String zV;
        String zU;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.arS > 0) {
                            String format = String.format(this.arM.getString(d.j.notify_gift), String.valueOf(this.arS));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.arN > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.arN > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.arN));
                                sb.append(this.arM.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.arZ != null) {
                                sb.append(this.arZ);
                            } else {
                                sb.append(this.arM.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.arO > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.arO > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.arO));
                                sb2.append(this.arM.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.asa != null) {
                                sb2.append(this.asa);
                            } else {
                                sb2.append(this.arM.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.arR > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.arR > 1) {
                                sb3.append(String.format(this.arM.getString(d.j.notify_fans_unit), Integer.valueOf(this.arR)));
                            }
                            sb3.append(this.arM.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zL = (!b.yZ().zo() || b.yZ().zc() <= 0) ? 0 : eVar.zL() - eVar.zS();
                        long Ad = (!b.yZ().zh() || b.yZ().zc() <= 0) ? 0L : eVar.Ad();
                        boolean z4 = Ad > 0;
                        long j = zL + Ad;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.arM.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ag();
                            eVar.Ae();
                            if (Ad == 1) {
                                zV = eVar.Ag();
                                str = eVar.Ae();
                                zU = zV + "：" + str;
                            } else if (zL == 1) {
                                zV = eVar.zV();
                                zU = eVar.zU();
                                str = zU;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.arM.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zU)) {
                                zU = str;
                            }
                            a(16, zV, str, zU, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> An = eVar.An();
                        if (An != null && An.size() != 0) {
                            for (e.b bVar : An) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.att != 0 && bVar.unReadCount > bVar.atu) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ao = eVar.Ao();
                        if (Ao != null && Ao.size() != 0) {
                            for (e.a aVar : Ao) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.att != 0 && aVar.unReadCount > aVar.atu) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.yZ().zo() && b.yZ().zc() > 0) {
                        if (eVar.zM() + eVar.zO() > 0) {
                            if (eVar.zM() > 0 && !yL()) {
                                long zM = eVar.zM() - eVar.zN();
                                if (zM > 0) {
                                    stringBuffer.append(String.format(this.arM.getString(d.j.notify_updates), Long.valueOf(zM)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zN() > 0) {
                                    z = true;
                                }
                                if (eVar.zO() > 0 || yK()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.arM.getString(d.j.notify_validate), Integer.valueOf(eVar.zO())));
                                } else {
                                    stringBuffer.append(String.format(this.arM.getString(d.j.notify_validate_1), Integer.valueOf(eVar.zO())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zX(), eVar.zY(), eVar.zY());
                                }
                            }
                            z = false;
                            if (eVar.zO() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Ah() > 0 && !yM()) {
                            String format2 = String.format(this.arM.getString(d.j.notify_live), Integer.valueOf(eVar.Ah()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.arM, 16);
                    NotificationHelper.cancelNotification(this.arM, 17);
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
            PendingIntent service = PendingIntent.getService(this.arM, bVar.att, a, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arM, i, bVar.title, bVar.content, bVar.atv, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arM, aVar.att, a, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arM, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.arY) {
            if (i == 23 && this.arS > 0) {
                g = dT(i);
            } else if (i == 26 && this.arR > 0) {
                g = dU(i);
            } else if (i == 18) {
                g = yF();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arM, i, g, 134217728);
            G(dX(i), i);
            NotificationHelper.showNotification(this.arM, i, str, str2, str3, service, false);
        }
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.arM, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.arS);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dU(int i) {
        Intent intent = new Intent(this.arM, DealIntentService.class);
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
        ImMessageCenterPojo af = com.baidu.tieba.im.memorycache.b.aAc().af(bVar.att + "", bVar.userType);
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
                    Intent intent = new Intent(this.arM, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.att);
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
        Intent intent = new Intent(this.arM, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.att);
        intent.putExtra("uname", bVar.atw);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.arM, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.att));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.arV.Af().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.arM, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.arO);
        intent.putExtra("reply_me", this.arN);
        intent.putExtra("fans", this.arR);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.arV.zL() - this.arV.zS());
        intent.putExtra("group_msg_validate", this.arV.zO());
        intent.putExtra("group_msg_updates", this.arV.zM());
        intent.putExtra("live_notify_msg_updates", this.arV.Ah());
        intent.putExtra("officialbar_msg", this.arV.zP());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yF() {
        Intent intent = new Intent(this.arM, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.arV.zN());
        return intent;
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.arM, 23);
        NotificationHelper.cancelNotification(this.arM, 24);
        NotificationHelper.cancelNotification(this.arM, 25);
        NotificationHelper.cancelNotification(this.arM, 26);
        NotificationHelper.cancelNotification(this.arM, 17);
        NotificationHelper.cancelNotification(this.arM, 15);
        NotificationHelper.cancelNotification(this.arM, 13);
        NotificationHelper.cancelNotification(this.arM, 12);
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.arM, 16);
    }

    public void yI() {
        NotificationHelper.cancelNotification(this.arM, 19);
    }

    public void dV(int i) {
        NotificationHelper.cancelNotification(this.arM, i);
    }

    public int yJ() {
        return this.arV.Ak();
    }

    public void eJ(String str) {
        if (TextUtils.isEmpty(str)) {
            yH();
            return;
        }
        e yX = yX();
        if (yX == null) {
            yH();
            return;
        }
        HashMap<String, String> zZ = yX.zZ();
        if (zZ == null || zZ.isEmpty()) {
            yH();
        } else if (zZ.containsKey(str)) {
            yH();
        }
    }

    public void eK(String str) {
        if (TextUtils.isEmpty(str)) {
            yH();
            return;
        }
        e yX = yX();
        if (yX == null) {
            yH();
            return;
        }
        HashMap<String, String> Af = yX.Af();
        if (Af == null || Af.isEmpty()) {
            yH();
        } else if (Af.containsKey(str)) {
            yH();
        }
    }

    private boolean yK() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yL() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yM() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yN() {
        NotificationHelper.cancelNotification(this.arM, 17);
    }

    public void dW(int i) {
        e yX = yX();
        if (yX == null) {
            yN();
        } else if (1 == i) {
            if (yX.zM() <= 0) {
                yN();
            }
        } else if (2 == i) {
            if (yX.zO() <= 0) {
                yN();
            }
        } else if (3 == i && yX.Ah() <= 0) {
            NotificationHelper.cancelNotification(this.arM, 21);
        }
    }

    public void yO() {
        NotificationHelper.cancelNotification(this.arM, 18);
    }

    public void yP() {
        NotificationHelper.cancelNotification(this.arM, 26);
        NotificationHelper.cancelNotification(this.arM, 25);
        NotificationHelper.cancelNotification(this.arM, 24);
        NotificationHelper.cancelNotification(this.arM, 23);
        NotificationHelper.cancelNotification(this.arM, 16);
        NotificationHelper.cancelNotification(this.arM, 17);
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.arM, 21);
        NotificationHelper.cancelNotification(this.arM, 17);
        NotificationHelper.cancelNotification(this.arM, 19);
        NotificationHelper.cancelNotification(this.arM, 16);
        NotificationHelper.cancelNotification(this.arM, 18);
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.arM, 24);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.arM, 25);
    }

    public void yT() {
        NotificationHelper.cancelNotification(this.arM, 23);
    }

    public void yU() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yV());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.arV.Ad());
        newsNotifyMessage.setMsgStrangerChat(this.arV.Ak());
        newsNotifyMessage.setMsgOfficialMerge(this.arV.Aj());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Ad() + eVar.zL()) + eVar.Ak()) + eVar.Aj()) + eVar.Ap()) - eVar.zS());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Ad());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ak());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Aj());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.arN;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.arO, this.arP, this.arR, this.arQ, this.arS);
        }
    }

    public int getMsgAtme() {
        return this.arO;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.arN, i, this.arP, this.arR, this.arQ, this.arS);
        }
    }

    public int getMsgChat() {
        return this.arP;
    }

    public int yV() {
        return ((((this.arV.Ad() + this.arV.zL()) + this.arV.Ak()) + this.arV.Aj()) + this.arV.Ap()) - this.arV.zS();
    }

    public int getMsgFans() {
        return this.arR;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.arN, this.arO, this.arP, i, this.arQ, this.arS);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.arN, this.arO, i, this.arR, this.arQ, this.arS);
        }
    }

    public int getMsgBookmark() {
        return this.arQ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.arN, this.arO, this.arP, this.arR, i, this.arS);
        }
    }

    public int getMsgGiftNum() {
        return this.arS;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.arS = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.arT = i;
            yU();
        }
    }

    public int getMsgLiveVip() {
        return this.arT;
    }

    public void aQ(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.arN = 0;
        this.arO = 0;
        this.arP = 0;
        this.arR = 0;
        this.arQ = 0;
    }

    public int yW() {
        return this.arN + this.arO + this.arP + this.arR + this.arS;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.arV = eVar;
            this.arP = (eVar.zL() - eVar.zS()) + eVar.Ad() + eVar.Aj() + eVar.Ap();
            a(eVar);
            if (eVar.zT()) {
                this.arW = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zT()) {
                if (b.yZ().zo() && b.yZ().zc() > 0) {
                    i = eVar.zL() - eVar.zS();
                }
                long Ad = (!b.yZ().zh() || b.yZ().zc() <= 0) ? 0L : eVar.Ad();
                if ((i > 0 || Ad > 0) && ((i > eVar.zW() - eVar.zS() && i > 0) || Ad > eVar.zQ())) {
                    a(1, 16, eVar);
                }
                int zP = eVar.zP();
                if (zP > 0 && zP > eVar.Ac()) {
                    a(1, 19, eVar);
                }
                if (eVar.zM() > eVar.Aa() || eVar.zO() > eVar.Ab()) {
                    if (eVar.zM() <= eVar.Aa() || eVar.zO() != eVar.Ab() || !yL()) {
                        if (eVar.zM() != eVar.Aa() || eVar.zO() <= eVar.Ab() || !yK()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Ah() > eVar.Ai() && !yM()) {
                    a(1, 21, eVar);
                }
                if (eVar.Al() > eVar.Am()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e yX() {
        return this.arV;
    }

    public void c(e eVar) {
        this.arV = eVar;
    }

    public e yY() {
        return this.arW;
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
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arM, 26, i2);
        }
    }
}
