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
    private static a asF;
    private static Date asI = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.zd().b(a.zd().zz());
            }
        }
    };
    private e asH;
    private String asK;
    private String asL;
    private int asy = 0;
    private int asz = 0;
    private int asA = 0;
    private int asB = 0;
    private int asC = 0;
    private int asD = 0;
    private int asE = 0;
    private e asG = new e();
    private boolean asJ = true;
    private final int[] asM = new int[10];
    private final Context asx = TbadkCoreApplication.getInst().getApp();

    public static a zd() {
        if (asF == null) {
            asF = new a();
        }
        return asF;
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
                    this.asK = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.asK = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.asL = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.asy || i2 != this.asz || i3 != this.asA || i4 != this.asC || i5 != this.asB || i6 != this.asD) {
            if (i > this.asy || i2 > this.asz || i3 > this.asA || i4 > this.asC || i5 > this.asB || i6 > this.asD) {
                i7 = 1;
            } else {
                i7 = (i < this.asy || i2 < this.asz) ? 2 : 0;
            }
            if (i > this.asy) {
                i8 = 1;
            } else {
                i8 = i < this.asy ? 2 : 0;
            }
            if (i2 > this.asz) {
                i9 = 1;
            } else {
                i9 = i2 < this.asz ? 2 : 0;
            }
            int i11 = i3 > this.asA ? 1 : 0;
            int i12 = i4 > this.asC ? 1 : 0;
            int i13 = i6 <= this.asD ? 0 : 1;
            this.asy = i;
            this.asz = i2;
            this.asA = i3;
            this.asC = i4;
            this.asB = i5;
            this.asD = i6;
            if (zx() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zv();
                E(i10, 23);
                E(i11, 16);
                E(i7, 17);
                E(i8, 24);
                E(i9, 25);
                E(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.asy || i2 != this.asz || i3 != this.asA || i4 != this.asC || this.asD != i5) {
            this.asy = i;
            this.asz = i2;
            this.asA = i3;
            this.asC = i4;
            this.asD = i5;
            zv();
            if (zx() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean ze() {
        if (asI == null) {
            asI = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - asI.getTime() < 10000) {
                return false;
            }
            asI = date;
        }
        return true;
    }

    public static boolean zf() {
        if (b.zA().zL()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zA().zN().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zA().zO().split(":");
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
                    if (this.asD > 0) {
                        String format = String.format(this.asx.getString(d.l.notify_gift), String.valueOf(this.asD));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.asy > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.asy > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.asy));
                            sb.append(this.asx.getString(d.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.asK != null) {
                            sb.append(this.asK);
                        } else {
                            sb.append(this.asx.getString(d.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.asz > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.asz > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.asz));
                            sb2.append(this.asx.getString(d.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.asL != null) {
                            sb2.append(this.asL);
                        } else {
                            sb2.append(this.asx.getString(d.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.asC > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.asC > 1) {
                            sb3.append(String.format(this.asx.getString(d.l.notify_fans_unit), Integer.valueOf(this.asC)));
                        }
                        sb3.append(this.asx.getString(d.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zA().zP() || b.zA().zD() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.asx, 16);
                NotificationHelper.cancelNotification(this.asx, 17);
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
        String Aw;
        String Av;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.asD > 0) {
                            String format = String.format(this.asx.getString(d.l.notify_gift), String.valueOf(this.asD));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.asy > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.asy > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.asy));
                                sb.append(this.asx.getString(d.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.asK != null) {
                                sb.append(this.asK);
                            } else {
                                sb.append(this.asx.getString(d.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.asz > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.asz > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.asz));
                                sb2.append(this.asx.getString(d.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.asL != null) {
                                sb2.append(this.asL);
                            } else {
                                sb2.append(this.asx.getString(d.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.asC > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.asC > 1) {
                                sb3.append(String.format(this.asx.getString(d.l.notify_fans_unit), Integer.valueOf(this.asC)));
                            }
                            sb3.append(this.asx.getString(d.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Am = (!b.zA().zP() || b.zA().zD() <= 0) ? 0 : eVar.Am() - eVar.At();
                        long AE = (!b.zA().zI() || b.zA().zD() <= 0) ? 0L : eVar.AE();
                        boolean z4 = AE > 0;
                        long j = Am + AE;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.asx.getString(d.l.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.AH();
                            eVar.AF();
                            if (AE == 1) {
                                Aw = eVar.AH();
                                str = eVar.AF();
                                Av = Aw + "：" + str;
                            } else if (Am == 1) {
                                Aw = eVar.Aw();
                                Av = eVar.Av();
                                str = Av;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.asx.getString(d.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Av)) {
                                Av = str;
                            }
                            a(16, Aw, str, Av, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AO = eVar.AO();
                        if (AO != null && AO.size() != 0) {
                            for (e.b bVar : AO) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.aue != 0 && bVar.unReadCount > bVar.auf) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AP = eVar.AP();
                        if (AP != null && AP.size() != 0) {
                            for (e.a aVar : AP) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.aue != 0 && aVar.unReadCount > aVar.auf) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zA().zP() && b.zA().zD() > 0) {
                        if (eVar.An() + eVar.Ap() > 0) {
                            if (eVar.An() > 0 && !zm()) {
                                long An = eVar.An() - eVar.Ao();
                                if (An > 0) {
                                    stringBuffer.append(String.format(this.asx.getString(d.l.notify_updates), Long.valueOf(An)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Ao() > 0) {
                                    z = true;
                                }
                                if (eVar.Ap() > 0 || zl()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.asx.getString(d.l.notify_validate), Integer.valueOf(eVar.Ap())));
                                } else {
                                    stringBuffer.append(String.format(this.asx.getString(d.l.notify_validate_1), Integer.valueOf(eVar.Ap())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Ay(), eVar.Az(), eVar.Az());
                                }
                            }
                            z = false;
                            if (eVar.Ap() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.AI() > 0 && !zn()) {
                            String format2 = String.format(this.asx.getString(d.l.notify_live), Integer.valueOf(eVar.AI()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.asx, 16);
                    NotificationHelper.cancelNotification(this.asx, 17);
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
            PendingIntent service = PendingIntent.getService(this.asx, bVar.aue, a, 134217728);
            F(dN(i), i);
            NotificationHelper.showNotification(this.asx, i, bVar.title, bVar.content, bVar.aug, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asx, aVar.aue, a, 134217728);
            F(dN(i), i);
            NotificationHelper.showNotification(this.asx, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.asJ) {
            if (i == 23 && this.asD > 0) {
                g = dJ(i);
            } else if (i == 26 && this.asC > 0) {
                g = dK(i);
            } else if (i == 18) {
                g = zg();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asx, i, g, 134217728);
            F(dN(i), i);
            NotificationHelper.showNotification(this.asx, i, str, str2, str3, service, false);
        }
    }

    public Intent dJ(int i) {
        Intent intent = new Intent(this.asx, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.asD);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dK(int i) {
        Intent intent = new Intent(this.asx, DealIntentService.class);
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
        ImMessageCenterPojo aa = com.baidu.tieba.im.memorycache.b.aza().aa(bVar.aue + "", bVar.userType);
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
                    Intent intent = new Intent(this.asx, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.aue);
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
        Intent intent = new Intent(this.asx, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.aue);
        intent.putExtra("uname", bVar.auh);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.asx, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.aue));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.asG.AG().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.asx, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.asz);
        intent.putExtra("reply_me", this.asy);
        intent.putExtra("fans", this.asC);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.asG.Am() - this.asG.At());
        intent.putExtra("group_msg_validate", this.asG.Ap());
        intent.putExtra("group_msg_updates", this.asG.An());
        intent.putExtra("live_notify_msg_updates", this.asG.AI());
        intent.putExtra("officialbar_msg", this.asG.Aq());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zg() {
        Intent intent = new Intent(this.asx, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.asG.Ao());
        return intent;
    }

    public void zh() {
        NotificationHelper.cancelNotification(this.asx, 23);
        NotificationHelper.cancelNotification(this.asx, 24);
        NotificationHelper.cancelNotification(this.asx, 25);
        NotificationHelper.cancelNotification(this.asx, 26);
        NotificationHelper.cancelNotification(this.asx, 17);
        NotificationHelper.cancelNotification(this.asx, 15);
        NotificationHelper.cancelNotification(this.asx, 13);
        NotificationHelper.cancelNotification(this.asx, 12);
    }

    public void zi() {
        NotificationHelper.cancelNotification(this.asx, 16);
    }

    public void zj() {
        NotificationHelper.cancelNotification(this.asx, 19);
    }

    public void dL(int i) {
        NotificationHelper.cancelNotification(this.asx, i);
    }

    public int zk() {
        return this.asG.AL();
    }

    public void eK(String str) {
        if (TextUtils.isEmpty(str)) {
            zi();
            return;
        }
        e zy = zy();
        if (zy == null) {
            zi();
            return;
        }
        HashMap<String, String> AA = zy.AA();
        if (AA == null || AA.isEmpty()) {
            zi();
        } else if (AA.containsKey(str)) {
            zi();
        }
    }

    public void eL(String str) {
        if (TextUtils.isEmpty(str)) {
            zi();
            return;
        }
        e zy = zy();
        if (zy == null) {
            zi();
            return;
        }
        HashMap<String, String> AG = zy.AG();
        if (AG == null || AG.isEmpty()) {
            zi();
        } else if (AG.containsKey(str)) {
            zi();
        }
    }

    private boolean zl() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zm() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean zn() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void zo() {
        NotificationHelper.cancelNotification(this.asx, 17);
    }

    public void dM(int i) {
        e zy = zy();
        if (zy == null) {
            zo();
        } else if (1 == i) {
            if (zy.An() <= 0) {
                zo();
            }
        } else if (2 == i) {
            if (zy.Ap() <= 0) {
                zo();
            }
        } else if (3 == i && zy.AI() <= 0) {
            NotificationHelper.cancelNotification(this.asx, 21);
        }
    }

    public void zp() {
        NotificationHelper.cancelNotification(this.asx, 18);
    }

    public void zq() {
        NotificationHelper.cancelNotification(this.asx, 26);
        NotificationHelper.cancelNotification(this.asx, 25);
        NotificationHelper.cancelNotification(this.asx, 24);
        NotificationHelper.cancelNotification(this.asx, 23);
        NotificationHelper.cancelNotification(this.asx, 16);
        NotificationHelper.cancelNotification(this.asx, 17);
    }

    public void zr() {
        NotificationHelper.cancelNotification(this.asx, 21);
        NotificationHelper.cancelNotification(this.asx, 17);
        NotificationHelper.cancelNotification(this.asx, 19);
        NotificationHelper.cancelNotification(this.asx, 16);
        NotificationHelper.cancelNotification(this.asx, 18);
    }

    public void zs() {
        NotificationHelper.cancelNotification(this.asx, 24);
    }

    public void zt() {
        NotificationHelper.cancelNotification(this.asx, 25);
    }

    public void zu() {
        NotificationHelper.cancelNotification(this.asx, 23);
    }

    public void zv() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zw());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.asG.AE());
        newsNotifyMessage.setMsgStrangerChat(this.asG.AL());
        newsNotifyMessage.setMsgOfficialMerge(this.asG.AK());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.AE() + eVar.Am()) + eVar.AL()) + eVar.AK()) + eVar.AQ()) - eVar.At());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.AE());
            newsNotifyMessage.setMsgStrangerChat(eVar.AL());
            newsNotifyMessage.setMsgOfficialMerge(eVar.AK());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.asy;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.asz, this.asA, this.asC, this.asB, this.asD);
        }
    }

    public int getMsgAtme() {
        return this.asz;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.asy, i, this.asA, this.asC, this.asB, this.asD);
        }
    }

    public int getMsgChat() {
        return this.asA;
    }

    public int zw() {
        return ((((this.asG.AE() + this.asG.Am()) + this.asG.AL()) + this.asG.AK()) + this.asG.AQ()) - this.asG.At();
    }

    public int getMsgFans() {
        return this.asC;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.asy, this.asz, this.asA, i, this.asB, this.asD);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.asy, this.asz, i, this.asC, this.asB, this.asD);
        }
    }

    public int getMsgBookmark() {
        return this.asB;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.asy, this.asz, this.asA, this.asC, i, this.asD);
        }
    }

    public int getMsgGiftNum() {
        return this.asD;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.asD = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.asE = i;
            zv();
        }
    }

    public int getMsgLiveVip() {
        return this.asE;
    }

    public void aU(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.asy = 0;
        this.asz = 0;
        this.asA = 0;
        this.asC = 0;
        this.asB = 0;
    }

    public int zx() {
        return this.asy + this.asz + this.asA + this.asC + this.asD;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.asG = eVar;
            this.asA = (eVar.Am() - eVar.At()) + eVar.AE() + eVar.AK() + eVar.AQ();
            a(eVar);
            if (eVar.Au()) {
                this.asH = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Au()) {
                if (b.zA().zP() && b.zA().zD() > 0) {
                    i = eVar.Am() - eVar.At();
                }
                long AE = (!b.zA().zI() || b.zA().zD() <= 0) ? 0L : eVar.AE();
                if ((i > 0 || AE > 0) && ((i > eVar.Ax() - eVar.At() && i > 0) || AE > eVar.Ar())) {
                    a(1, 16, eVar);
                }
                int Aq = eVar.Aq();
                if (Aq > 0 && Aq > eVar.AD()) {
                    a(1, 19, eVar);
                }
                if (eVar.An() > eVar.AB() || eVar.Ap() > eVar.AC()) {
                    if (eVar.An() <= eVar.AB() || eVar.Ap() != eVar.AC() || !zm()) {
                        if (eVar.An() != eVar.AB() || eVar.Ap() <= eVar.AC() || !zl()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.AI() > eVar.AJ() && !zn()) {
                    a(1, 21, eVar);
                }
                if (eVar.AM() > eVar.AN()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zy() {
        return this.asG;
    }

    public void c(e eVar) {
        this.asG = eVar;
    }

    public e zz() {
        return this.asH;
    }

    public int dN(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asx, 26, i2);
        }
    }
}
