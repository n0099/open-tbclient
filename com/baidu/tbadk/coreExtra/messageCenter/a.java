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
    private static a arB;
    private static Date arE = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yv().b(a.yv().yR());
            }
        }
    };
    private e arD;
    private String arG;
    private String arH;
    private int aru = 0;
    private int arv = 0;
    private int arw = 0;
    private int arx = 0;
    private int ary = 0;
    private int arz = 0;
    private int arA = 0;
    private e arC = new e();
    private boolean arF = true;
    private final int[] arI = new int[10];
    private final Context art = TbadkCoreApplication.getInst().getApp();

    public static a yv() {
        if (arB == null) {
            arB = new a();
        }
        return arB;
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
                    this.arG = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.arG = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.arH = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.aru || i2 != this.arv || i3 != this.arw || i4 != this.ary || i5 != this.arx || i6 != this.arz) {
            if (i > this.aru || i2 > this.arv || i3 > this.arw || i4 > this.ary || i5 > this.arx || i6 > this.arz) {
                i7 = 1;
            } else {
                i7 = (i < this.aru || i2 < this.arv) ? 2 : 0;
            }
            if (i > this.aru) {
                i8 = 1;
            } else {
                i8 = i < this.aru ? 2 : 0;
            }
            if (i2 > this.arv) {
                i9 = 1;
            } else {
                i9 = i2 < this.arv ? 2 : 0;
            }
            int i11 = i3 > this.arw ? 1 : 0;
            int i12 = i4 > this.ary ? 1 : 0;
            int i13 = i6 <= this.arz ? 0 : 1;
            this.aru = i;
            this.arv = i2;
            this.arw = i3;
            this.ary = i4;
            this.arx = i5;
            this.arz = i6;
            if (yP() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                yN();
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
        if (i != this.aru || i2 != this.arv || i3 != this.arw || i4 != this.ary || this.arz != i5) {
            this.aru = i;
            this.arv = i2;
            this.arw = i3;
            this.ary = i4;
            this.arz = i5;
            yN();
            if (yP() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean yw() {
        if (arE == null) {
            arE = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - arE.getTime() < 10000) {
                return false;
            }
            arE = date;
        }
        return true;
    }

    public static boolean yx() {
        if (b.yS().zd()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.yS().zf().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.yS().zg().split(":");
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
                    if (this.arz > 0) {
                        String format = String.format(this.art.getString(d.l.notify_gift), String.valueOf(this.arz));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.aru > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.aru > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.aru));
                            sb.append(this.art.getString(d.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.arG != null) {
                            sb.append(this.arG);
                        } else {
                            sb.append(this.art.getString(d.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.arv > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.arv > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.arv));
                            sb2.append(this.art.getString(d.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.arH != null) {
                            sb2.append(this.arH);
                        } else {
                            sb2.append(this.art.getString(d.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.ary > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.ary > 1) {
                            sb3.append(String.format(this.art.getString(d.l.notify_fans_unit), Integer.valueOf(this.ary)));
                        }
                        sb3.append(this.art.getString(d.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.yS().zh() || b.yS().yV() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.art, 16);
                NotificationHelper.cancelNotification(this.art, 17);
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
        String zO;
        String zN;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.arz > 0) {
                            String format = String.format(this.art.getString(d.l.notify_gift), String.valueOf(this.arz));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.aru > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aru > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aru));
                                sb.append(this.art.getString(d.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.arG != null) {
                                sb.append(this.arG);
                            } else {
                                sb.append(this.art.getString(d.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.arv > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.arv > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.arv));
                                sb2.append(this.art.getString(d.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.arH != null) {
                                sb2.append(this.arH);
                            } else {
                                sb2.append(this.art.getString(d.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.ary > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.ary > 1) {
                                sb3.append(String.format(this.art.getString(d.l.notify_fans_unit), Integer.valueOf(this.ary)));
                            }
                            sb3.append(this.art.getString(d.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zE = (!b.yS().zh() || b.yS().yV() <= 0) ? 0 : eVar.zE() - eVar.zL();
                        long zW = (!b.yS().za() || b.yS().yV() <= 0) ? 0L : eVar.zW();
                        boolean z4 = zW > 0;
                        long j = zE + zW;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.art.getString(d.l.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.zZ();
                            eVar.zX();
                            if (zW == 1) {
                                zO = eVar.zZ();
                                str = eVar.zX();
                                zN = zO + "：" + str;
                            } else if (zE == 1) {
                                zO = eVar.zO();
                                zN = eVar.zN();
                                str = zN;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.art.getString(d.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(zN)) {
                                zN = str;
                            }
                            a(16, zO, str, zN, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Ag = eVar.Ag();
                        if (Ag != null && Ag.size() != 0) {
                            for (e.b bVar : Ag) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.ata != 0 && bVar.unReadCount > bVar.atb) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ah = eVar.Ah();
                        if (Ah != null && Ah.size() != 0) {
                            for (e.a aVar : Ah) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.ata != 0 && aVar.unReadCount > aVar.atb) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.yS().zh() && b.yS().yV() > 0) {
                        if (eVar.zF() + eVar.zH() > 0) {
                            if (eVar.zF() > 0 && !yE()) {
                                long zF = eVar.zF() - eVar.zG();
                                if (zF > 0) {
                                    stringBuffer.append(String.format(this.art.getString(d.l.notify_updates), Long.valueOf(zF)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zG() > 0) {
                                    z = true;
                                }
                                if (eVar.zH() > 0 || yD()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.art.getString(d.l.notify_validate), Integer.valueOf(eVar.zH())));
                                } else {
                                    stringBuffer.append(String.format(this.art.getString(d.l.notify_validate_1), Integer.valueOf(eVar.zH())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.zQ(), eVar.zR(), eVar.zR());
                                }
                            }
                            z = false;
                            if (eVar.zH() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Aa() > 0 && !yF()) {
                            String format2 = String.format(this.art.getString(d.l.notify_live), Integer.valueOf(eVar.Aa()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.art, 16);
                    NotificationHelper.cancelNotification(this.art, 17);
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
            PendingIntent service = PendingIntent.getService(this.art, bVar.ata, a, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.art, i, bVar.title, bVar.content, bVar.atc, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.art, aVar.ata, a, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.art, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.arF) {
            if (i == 23 && this.arz > 0) {
                g = dS(i);
            } else if (i == 26 && this.ary > 0) {
                g = dT(i);
            } else if (i == 18) {
                g = yy();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.art, i, g, 134217728);
            G(dW(i), i);
            NotificationHelper.showNotification(this.art, i, str, str2, str3, service, false);
        }
    }

    public Intent dS(int i) {
        Intent intent = new Intent(this.art, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.arz);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.art, DealIntentService.class);
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
        ImMessageCenterPojo Z = com.baidu.tieba.im.memorycache.b.axH().Z(bVar.ata + "", bVar.userType);
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
                    Intent intent = new Intent(this.art, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.ata);
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
        Intent intent = new Intent(this.art, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.ata);
        intent.putExtra("uname", bVar.atd);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.art, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.ata));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.arC.zY().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.art, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.arv);
        intent.putExtra("reply_me", this.aru);
        intent.putExtra("fans", this.ary);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.arC.zE() - this.arC.zL());
        intent.putExtra("group_msg_validate", this.arC.zH());
        intent.putExtra("group_msg_updates", this.arC.zF());
        intent.putExtra("live_notify_msg_updates", this.arC.Aa());
        intent.putExtra("officialbar_msg", this.arC.zI());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yy() {
        Intent intent = new Intent(this.art, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.arC.zG());
        return intent;
    }

    public void yz() {
        NotificationHelper.cancelNotification(this.art, 23);
        NotificationHelper.cancelNotification(this.art, 24);
        NotificationHelper.cancelNotification(this.art, 25);
        NotificationHelper.cancelNotification(this.art, 26);
        NotificationHelper.cancelNotification(this.art, 17);
        NotificationHelper.cancelNotification(this.art, 15);
        NotificationHelper.cancelNotification(this.art, 13);
        NotificationHelper.cancelNotification(this.art, 12);
    }

    public void yA() {
        NotificationHelper.cancelNotification(this.art, 16);
    }

    public void yB() {
        NotificationHelper.cancelNotification(this.art, 19);
    }

    public void dU(int i) {
        NotificationHelper.cancelNotification(this.art, i);
    }

    public int yC() {
        return this.arC.Ad();
    }

    public void eC(String str) {
        if (TextUtils.isEmpty(str)) {
            yA();
            return;
        }
        e yQ = yQ();
        if (yQ == null) {
            yA();
            return;
        }
        HashMap<String, String> zS = yQ.zS();
        if (zS == null || zS.isEmpty()) {
            yA();
        } else if (zS.containsKey(str)) {
            yA();
        }
    }

    public void eD(String str) {
        if (TextUtils.isEmpty(str)) {
            yA();
            return;
        }
        e yQ = yQ();
        if (yQ == null) {
            yA();
            return;
        }
        HashMap<String, String> zY = yQ.zY();
        if (zY == null || zY.isEmpty()) {
            yA();
        } else if (zY.containsKey(str)) {
            yA();
        }
    }

    private boolean yD() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yE() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yF() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yG() {
        NotificationHelper.cancelNotification(this.art, 17);
    }

    public void dV(int i) {
        e yQ = yQ();
        if (yQ == null) {
            yG();
        } else if (1 == i) {
            if (yQ.zF() <= 0) {
                yG();
            }
        } else if (2 == i) {
            if (yQ.zH() <= 0) {
                yG();
            }
        } else if (3 == i && yQ.Aa() <= 0) {
            NotificationHelper.cancelNotification(this.art, 21);
        }
    }

    public void yH() {
        NotificationHelper.cancelNotification(this.art, 18);
    }

    public void yI() {
        NotificationHelper.cancelNotification(this.art, 26);
        NotificationHelper.cancelNotification(this.art, 25);
        NotificationHelper.cancelNotification(this.art, 24);
        NotificationHelper.cancelNotification(this.art, 23);
        NotificationHelper.cancelNotification(this.art, 16);
        NotificationHelper.cancelNotification(this.art, 17);
    }

    public void yJ() {
        NotificationHelper.cancelNotification(this.art, 21);
        NotificationHelper.cancelNotification(this.art, 17);
        NotificationHelper.cancelNotification(this.art, 19);
        NotificationHelper.cancelNotification(this.art, 16);
        NotificationHelper.cancelNotification(this.art, 18);
    }

    public void yK() {
        NotificationHelper.cancelNotification(this.art, 24);
    }

    public void yL() {
        NotificationHelper.cancelNotification(this.art, 25);
    }

    public void yM() {
        NotificationHelper.cancelNotification(this.art, 23);
    }

    public void yN() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(yO());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.arC.zW());
        newsNotifyMessage.setMsgStrangerChat(this.arC.Ad());
        newsNotifyMessage.setMsgOfficialMerge(this.arC.Ac());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.zW() + eVar.zE()) + eVar.Ad()) + eVar.Ac()) + eVar.Ai()) - eVar.zL());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.zW());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ad());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Ac());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aru;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.arv, this.arw, this.ary, this.arx, this.arz);
        }
    }

    public int getMsgAtme() {
        return this.arv;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.aru, i, this.arw, this.ary, this.arx, this.arz);
        }
    }

    public int getMsgChat() {
        return this.arw;
    }

    public int yO() {
        return ((((this.arC.zW() + this.arC.zE()) + this.arC.Ad()) + this.arC.Ac()) + this.arC.Ai()) - this.arC.zL();
    }

    public int getMsgFans() {
        return this.ary;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.aru, this.arv, this.arw, i, this.arx, this.arz);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.aru, this.arv, i, this.ary, this.arx, this.arz);
        }
    }

    public int getMsgBookmark() {
        return this.arx;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.aru, this.arv, this.arw, this.ary, i, this.arz);
        }
    }

    public int getMsgGiftNum() {
        return this.arz;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.arz = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.arA = i;
            yN();
        }
    }

    public int getMsgLiveVip() {
        return this.arA;
    }

    public void aS(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.aru = 0;
        this.arv = 0;
        this.arw = 0;
        this.ary = 0;
        this.arx = 0;
    }

    public int yP() {
        return this.aru + this.arv + this.arw + this.ary + this.arz;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.arC = eVar;
            this.arw = (eVar.zE() - eVar.zL()) + eVar.zW() + eVar.Ac() + eVar.Ai();
            a(eVar);
            if (eVar.zM()) {
                this.arD = null;
                mHandler.removeMessages(0);
            }
            if (eVar.zM()) {
                if (b.yS().zh() && b.yS().yV() > 0) {
                    i = eVar.zE() - eVar.zL();
                }
                long zW = (!b.yS().za() || b.yS().yV() <= 0) ? 0L : eVar.zW();
                if ((i > 0 || zW > 0) && ((i > eVar.zP() - eVar.zL() && i > 0) || zW > eVar.zJ())) {
                    a(1, 16, eVar);
                }
                int zI = eVar.zI();
                if (zI > 0 && zI > eVar.zV()) {
                    a(1, 19, eVar);
                }
                if (eVar.zF() > eVar.zT() || eVar.zH() > eVar.zU()) {
                    if (eVar.zF() <= eVar.zT() || eVar.zH() != eVar.zU() || !yE()) {
                        if (eVar.zF() != eVar.zT() || eVar.zH() <= eVar.zU() || !yD()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Aa() > eVar.Ab() && !yF()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ae() > eVar.Af()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e yQ() {
        return this.arC;
    }

    public void c(e eVar) {
        this.arC = eVar;
    }

    public e yR() {
        return this.arD;
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
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.art, 26, i2);
        }
    }
}
