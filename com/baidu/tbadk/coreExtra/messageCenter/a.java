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
    private static a arH;
    private static Date arK = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yR().b(a.yR().zn());
            }
        }
    };
    private e arJ;
    private String arM;
    private String arN;
    private int arA = 0;
    private int arB = 0;
    private int arC = 0;
    private int arD = 0;
    private int arE = 0;
    private int arF = 0;
    private int arG = 0;
    private e arI = new e();
    private boolean arL = true;
    private final int[] arO = new int[10];
    private final Context arz = TbadkCoreApplication.getInst().getApp();

    public static a yR() {
        if (arH == null) {
            arH = new a();
        }
        return arH;
    }

    private a() {
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.arM = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.arM = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.arN = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.arA || i2 != this.arB || i3 != this.arC || i4 != this.arE || i5 != this.arD || i6 != this.arF) {
            if (i > this.arA || i2 > this.arB || i3 > this.arC || i4 > this.arE || i5 > this.arD || i6 > this.arF) {
                i7 = 1;
            } else {
                i7 = (i < this.arA || i2 < this.arB) ? 2 : 0;
            }
            if (i > this.arA) {
                i8 = 1;
            } else {
                i8 = i < this.arA ? 2 : 0;
            }
            if (i2 > this.arB) {
                i9 = 1;
            } else {
                i9 = i2 < this.arB ? 2 : 0;
            }
            int i11 = i3 > this.arC ? 1 : 0;
            int i12 = i4 > this.arE ? 1 : 0;
            int i13 = i6 <= this.arF ? 0 : 1;
            this.arA = i;
            this.arB = i2;
            this.arC = i3;
            this.arE = i4;
            this.arD = i5;
            this.arF = i6;
            if (zl() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zj();
                E(i10, 23);
                E(i11, 16);
                E(i7, 17);
                E(i8, 24);
                E(i9, 25);
                E(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.arA || i2 != this.arB || i3 != this.arC || i4 != this.arE || this.arF != i5) {
            this.arA = i;
            this.arB = i2;
            this.arC = i3;
            this.arE = i4;
            this.arF = i5;
            zj();
            if (zl() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean yS() {
        if (arK == null) {
            arK = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - arK.getTime() < 10000) {
                return false;
            }
            arK = date;
        }
        return true;
    }

    public static boolean yT() {
        if (b.zo().zz()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zo().zB().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zo().zC().split(":");
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

    private void E(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.arF > 0) {
                        String format = String.format(this.arz.getString(d.l.notify_gift), String.valueOf(this.arF));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.arA > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.arA > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.arA));
                            sb.append(this.arz.getString(d.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.arM != null) {
                            sb.append(this.arM);
                        } else {
                            sb.append(this.arz.getString(d.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.arB > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.arB > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.arB));
                            sb2.append(this.arz.getString(d.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.arN != null) {
                            sb2.append(this.arN);
                        } else {
                            sb2.append(this.arz.getString(d.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.arE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.arE > 1) {
                            sb3.append(String.format(this.arz.getString(d.l.notify_fans_unit), Integer.valueOf(this.arE)));
                        }
                        sb3.append(this.arz.getString(d.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zo().zD() || b.zo().zr() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.arz, 16);
                NotificationHelper.cancelNotification(this.arz, 17);
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
        String Ak;
        String Aj;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.arF > 0) {
                            String format = String.format(this.arz.getString(d.l.notify_gift), String.valueOf(this.arF));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.arA > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.arA > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.arA));
                                sb.append(this.arz.getString(d.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.arM != null) {
                                sb.append(this.arM);
                            } else {
                                sb.append(this.arz.getString(d.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.arB > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.arB > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.arB));
                                sb2.append(this.arz.getString(d.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.arN != null) {
                                sb2.append(this.arN);
                            } else {
                                sb2.append(this.arz.getString(d.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.arE > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.arE > 1) {
                                sb3.append(String.format(this.arz.getString(d.l.notify_fans_unit), Integer.valueOf(this.arE)));
                            }
                            sb3.append(this.arz.getString(d.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Aa = (!b.zo().zD() || b.zo().zr() <= 0) ? 0 : eVar.Aa() - eVar.Ah();
                        long As = (!b.zo().zw() || b.zo().zr() <= 0) ? 0L : eVar.As();
                        boolean z4 = As > 0;
                        long j = Aa + As;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.arz.getString(d.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Av();
                            eVar.At();
                            if (As == 1) {
                                Ak = eVar.Av();
                                str = eVar.At();
                                Aj = Ak + "：" + str;
                            } else if (Aa == 1) {
                                Ak = eVar.Ak();
                                Aj = eVar.Aj();
                                str = Aj;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.arz.getString(d.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Aj)) {
                                Aj = str;
                            }
                            c(16, Ak, str, Aj, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AC = eVar.AC();
                        if (AC != null && AC.size() != 0) {
                            for (e.b bVar : AC) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.atg != 0 && bVar.unReadCount > bVar.ath) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AD = eVar.AD();
                        if (AD != null && AD.size() != 0) {
                            for (e.a aVar : AD) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.atg != 0 && aVar.unReadCount > aVar.ath) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zo().zD() && b.zo().zr() > 0) {
                        if (eVar.Ab() + eVar.Ad() > 0) {
                            if (eVar.Ab() > 0 && !za()) {
                                long Ab = eVar.Ab() - eVar.Ac();
                                if (Ab > 0) {
                                    stringBuffer.append(String.format(this.arz.getString(d.l.notify_updates), Long.valueOf(Ab)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Ac() > 0) {
                                    z = true;
                                }
                                if (eVar.Ad() > 0 || yZ()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.arz.getString(d.l.notify_validate), Integer.valueOf(eVar.Ad())));
                                } else {
                                    stringBuffer.append(String.format(this.arz.getString(d.l.notify_validate_1), Integer.valueOf(eVar.Ad())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Am(), eVar.An(), eVar.An());
                                }
                            }
                            z = false;
                            if (eVar.Ad() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Aw() > 0 && !zb()) {
                            String format2 = String.format(this.arz.getString(d.l.notify_live), Integer.valueOf(eVar.Aw()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.arz, 16);
                    NotificationHelper.cancelNotification(this.arz, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        c(i, str, str2, str3, false);
    }

    private void a(e.b bVar, int i) {
        Intent a = a(bVar);
        if (a != null || (a = b(bVar)) != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arz, bVar.atg, a, 134217728);
            F(dK(i), i);
            NotificationHelper.showNotification(this.arz, i, bVar.title, bVar.content, bVar.ati, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arz, aVar.atg, a, 134217728);
            F(dK(i), i);
            NotificationHelper.showNotification(this.arz, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent i2;
        if (this.arL) {
            if (i == 23 && this.arF > 0) {
                i2 = dG(i);
            } else if (i == 26 && this.arE > 0) {
                i2 = dH(i);
            } else if (i == 18) {
                i2 = yU();
            } else {
                i2 = i(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            i2.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.arz, i, i2, 134217728);
            F(dK(i), i);
            NotificationHelper.showNotification(this.arz, i, str, str2, str3, service, false);
        }
    }

    public Intent dG(int i) {
        Intent intent = new Intent(this.arz, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.arF);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dH(int i) {
        Intent intent = new Intent(this.arz, DealIntentService.class);
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
        ImMessageCenterPojo aa = com.baidu.tieba.im.memorycache.b.awn().aa(bVar.atg + "", bVar.userType);
        if (aa == null || aa.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(aa.getLastContentRawData());
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
                    Intent intent = new Intent(this.arz, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.atg);
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
        Intent intent = new Intent(this.arz, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.atg);
        intent.putExtra("uname", bVar.atj);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.arz, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.atg));
        return intent;
    }

    public Intent i(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.arI.Au().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.arz, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.arB);
        intent.putExtra("reply_me", this.arA);
        intent.putExtra("fans", this.arE);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.arI.Aa() - this.arI.Ah());
        intent.putExtra("group_msg_validate", this.arI.Ad());
        intent.putExtra("group_msg_updates", this.arI.Ab());
        intent.putExtra("live_notify_msg_updates", this.arI.Aw());
        intent.putExtra("officialbar_msg", this.arI.Ae());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yU() {
        Intent intent = new Intent(this.arz, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.arI.Ac());
        return intent;
    }

    public void yV() {
        NotificationHelper.cancelNotification(this.arz, 23);
        NotificationHelper.cancelNotification(this.arz, 24);
        NotificationHelper.cancelNotification(this.arz, 25);
        NotificationHelper.cancelNotification(this.arz, 26);
        NotificationHelper.cancelNotification(this.arz, 17);
        NotificationHelper.cancelNotification(this.arz, 15);
        NotificationHelper.cancelNotification(this.arz, 13);
        NotificationHelper.cancelNotification(this.arz, 12);
    }

    public void yW() {
        NotificationHelper.cancelNotification(this.arz, 16);
    }

    public void yX() {
        NotificationHelper.cancelNotification(this.arz, 19);
    }

    public void dI(int i) {
        NotificationHelper.cancelNotification(this.arz, i);
    }

    public int yY() {
        return this.arI.Az();
    }

    public void eG(String str) {
        if (TextUtils.isEmpty(str)) {
            yW();
            return;
        }
        e zm = zm();
        if (zm == null) {
            yW();
            return;
        }
        HashMap<String, String> Ao = zm.Ao();
        if (Ao == null || Ao.isEmpty()) {
            yW();
        } else if (Ao.containsKey(str)) {
            yW();
        }
    }

    public void eH(String str) {
        if (TextUtils.isEmpty(str)) {
            yW();
            return;
        }
        e zm = zm();
        if (zm == null) {
            yW();
            return;
        }
        HashMap<String, String> Au = zm.Au();
        if (Au == null || Au.isEmpty()) {
            yW();
        } else if (Au.containsKey(str)) {
            yW();
        }
    }

    private boolean yZ() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean za() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean zb() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void zc() {
        NotificationHelper.cancelNotification(this.arz, 17);
    }

    public void dJ(int i) {
        e zm = zm();
        if (zm == null) {
            zc();
        } else if (1 == i) {
            if (zm.Ab() <= 0) {
                zc();
            }
        } else if (2 == i) {
            if (zm.Ad() <= 0) {
                zc();
            }
        } else if (3 == i && zm.Aw() <= 0) {
            NotificationHelper.cancelNotification(this.arz, 21);
        }
    }

    public void zd() {
        NotificationHelper.cancelNotification(this.arz, 18);
    }

    public void ze() {
        NotificationHelper.cancelNotification(this.arz, 26);
        NotificationHelper.cancelNotification(this.arz, 25);
        NotificationHelper.cancelNotification(this.arz, 24);
        NotificationHelper.cancelNotification(this.arz, 23);
        NotificationHelper.cancelNotification(this.arz, 16);
        NotificationHelper.cancelNotification(this.arz, 17);
    }

    public void zf() {
        NotificationHelper.cancelNotification(this.arz, 21);
        NotificationHelper.cancelNotification(this.arz, 17);
        NotificationHelper.cancelNotification(this.arz, 19);
        NotificationHelper.cancelNotification(this.arz, 16);
        NotificationHelper.cancelNotification(this.arz, 18);
    }

    public void zg() {
        NotificationHelper.cancelNotification(this.arz, 24);
    }

    public void zh() {
        NotificationHelper.cancelNotification(this.arz, 25);
    }

    public void zi() {
        NotificationHelper.cancelNotification(this.arz, 23);
    }

    public void zj() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zk());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.arI.As());
        newsNotifyMessage.setMsgStrangerChat(this.arI.Az());
        newsNotifyMessage.setMsgOfficialMerge(this.arI.Ay());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.As() + eVar.Aa()) + eVar.Az()) + eVar.Ay()) + eVar.AE()) - eVar.Ah());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.As());
            newsNotifyMessage.setMsgStrangerChat(eVar.Az());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ay());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.arA;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.arB, this.arC, this.arE, this.arD, this.arF);
        }
    }

    public int getMsgAtme() {
        return this.arB;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.arA, i, this.arC, this.arE, this.arD, this.arF);
        }
    }

    public int getMsgChat() {
        return this.arC;
    }

    public int zk() {
        return ((((this.arI.As() + this.arI.Aa()) + this.arI.Az()) + this.arI.Ay()) + this.arI.AE()) - this.arI.Ah();
    }

    public int getMsgFans() {
        return this.arE;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.arA, this.arB, this.arC, i, this.arD, this.arF);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.arA, this.arB, i, this.arE, this.arD, this.arF);
        }
    }

    public int getMsgBookmark() {
        return this.arD;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.arA, this.arB, this.arC, this.arE, i, this.arF);
        }
    }

    public int getMsgGiftNum() {
        return this.arF;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.arF = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.arG = i;
            zj();
        }
    }

    public int getMsgLiveVip() {
        return this.arG;
    }

    public void aU(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.arA = 0;
        this.arB = 0;
        this.arC = 0;
        this.arE = 0;
        this.arD = 0;
    }

    public int zl() {
        return this.arA + this.arB + this.arC + this.arE + this.arF;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.arI = eVar;
            this.arC = (eVar.Aa() - eVar.Ah()) + eVar.As() + eVar.Ay() + eVar.AE();
            a(eVar);
            if (eVar.Ai()) {
                this.arJ = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ai()) {
                if (b.zo().zD() && b.zo().zr() > 0) {
                    i = eVar.Aa() - eVar.Ah();
                }
                long As = (!b.zo().zw() || b.zo().zr() <= 0) ? 0L : eVar.As();
                if ((i > 0 || As > 0) && ((i > eVar.Al() - eVar.Ah() && i > 0) || As > eVar.Af())) {
                    a(1, 16, eVar);
                }
                int Ae = eVar.Ae();
                if (Ae > 0 && Ae > eVar.Ar()) {
                    a(1, 19, eVar);
                }
                if (eVar.Ab() > eVar.Ap() || eVar.Ad() > eVar.Aq()) {
                    if (eVar.Ab() <= eVar.Ap() || eVar.Ad() != eVar.Aq() || !za()) {
                        if (eVar.Ab() != eVar.Ap() || eVar.Ad() <= eVar.Aq() || !yZ()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Aw() > eVar.Ax() && !zb()) {
                    a(1, 21, eVar);
                }
                if (eVar.AA() > eVar.AB()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zm() {
        return this.arI;
    }

    public void c(e eVar) {
        this.arI = eVar;
    }

    public e zn() {
        return this.arJ;
    }

    public int dK(int i) {
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

    public void F(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.arz, 26, i2);
        }
    }
}
