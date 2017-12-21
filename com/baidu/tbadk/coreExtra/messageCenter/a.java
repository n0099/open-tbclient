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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.model.e;
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
    private static a asB;
    private static Date asE = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yN().b(a.yN().zj());
            }
        }
    };
    private e asD;
    private String asG;
    private String asH;
    private int asu = 0;
    private int asv = 0;
    private int asw = 0;
    private int asx = 0;
    private int asy = 0;
    private int asz = 0;
    private int asA = 0;
    private e asC = new e();
    private boolean asF = true;
    private final int[] asI = new int[10];
    private final Context ast = TbadkCoreApplication.getInst().getApp();

    public static a yN() {
        if (asB == null) {
            asB = new a();
        }
        return asB;
    }

    private a() {
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt(FeedData.TYPE_ZAN);
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString(FeedData.TYPE_ZAN);
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.asG = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.asG = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.asH = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.asu || i2 != this.asv || i3 != this.asw || i4 != this.asy || i5 != this.asx || i6 != this.asz) {
            if (i > this.asu || i2 > this.asv || i3 > this.asw || i4 > this.asy || i5 > this.asx || i6 > this.asz) {
                i7 = 1;
            } else {
                i7 = (i < this.asu || i2 < this.asv) ? 2 : 0;
            }
            if (i > this.asu) {
                i8 = 1;
            } else {
                i8 = i < this.asu ? 2 : 0;
            }
            if (i2 > this.asv) {
                i9 = 1;
            } else {
                i9 = i2 < this.asv ? 2 : 0;
            }
            int i11 = i3 > this.asw ? 1 : 0;
            int i12 = i4 > this.asy ? 1 : 0;
            int i13 = i6 <= this.asz ? 0 : 1;
            this.asu = i;
            this.asv = i2;
            this.asw = i3;
            this.asy = i4;
            this.asx = i5;
            this.asz = i6;
            if (zh() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zf();
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
        if (i != this.asu || i2 != this.asv || i3 != this.asw || i4 != this.asy || this.asz != i5) {
            this.asu = i;
            this.asv = i2;
            this.asw = i3;
            this.asy = i4;
            this.asz = i5;
            zf();
            if (zh() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean yO() {
        if (asE == null) {
            asE = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - asE.getTime() < 10000) {
                return false;
            }
            asE = date;
        }
        return true;
    }

    public static boolean yP() {
        if (b.zk().zv()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zk().zx().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zk().zy().split(":");
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
                    if (this.asz > 0) {
                        String format = String.format(this.ast.getString(d.j.notify_gift), String.valueOf(this.asz));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.asu > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.asu > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.asu));
                            sb.append(this.ast.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.asG != null) {
                            sb.append(this.asG);
                        } else {
                            sb.append(this.ast.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.asv > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.asv > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.asv));
                            sb2.append(this.ast.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.asH != null) {
                            sb2.append(this.asH);
                        } else {
                            sb2.append(this.ast.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.asy > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.ast.getString(d.j.notify_fans), Integer.valueOf(this.asy)));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zk().zz() || b.zk().zn() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.ast, 16);
                NotificationHelper.cancelNotification(this.ast, 17);
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
        String Ai;
        String Ah;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.asz > 0) {
                            String format = String.format(this.ast.getString(d.j.notify_gift), String.valueOf(this.asz));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.asu > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.asu > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.asu));
                                sb.append(this.ast.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.asG != null) {
                                sb.append(this.asG);
                            } else {
                                sb.append(this.ast.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.asv > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.asv > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.asv));
                                sb2.append(this.ast.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.asH != null) {
                                sb2.append(this.asH);
                            } else {
                                sb2.append(this.ast.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.asy > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.asy > 1) {
                                sb3.append(String.format(this.ast.getString(d.j.notify_fans_unit), Integer.valueOf(this.asy)));
                            }
                            sb3.append(this.ast.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zY = (!b.zk().zz() || b.zk().zn() <= 0) ? 0 : eVar.zY() - eVar.Af();
                        long Aq = (!b.zk().zs() || b.zk().zn() <= 0) ? 0L : eVar.Aq();
                        boolean z4 = Aq > 0;
                        long j = zY + Aq;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.ast.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.At();
                            eVar.Ar();
                            if (Aq == 1) {
                                Ai = eVar.At();
                                str = eVar.Ar();
                                Ah = Ai + "：" + str;
                            } else if (zY == 1) {
                                Ai = eVar.Ai();
                                Ah = eVar.Ah();
                                str = Ah;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.ast.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ah)) {
                                Ah = str;
                            }
                            a(16, Ai, str, Ah, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AA = eVar.AA();
                        if (AA != null && AA.size() != 0) {
                            for (e.b bVar : AA) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.auc != 0 && bVar.unReadCount > bVar.aud) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AB = eVar.AB();
                        if (AB != null && AB.size() != 0) {
                            for (e.a aVar : AB) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.auc != 0 && aVar.unReadCount > aVar.aud) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zk().zz() && b.zk().zn() > 0) {
                        if (eVar.zZ() + eVar.Ab() > 0) {
                            if (eVar.zZ() > 0 && !yW()) {
                                long zZ = eVar.zZ() - eVar.Aa();
                                if (zZ > 0) {
                                    stringBuffer.append(String.format(this.ast.getString(d.j.notify_updates), Long.valueOf(zZ)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Aa() > 0) {
                                    z = true;
                                }
                                if (eVar.Ab() > 0 || yV()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.ast.getString(d.j.notify_validate), Integer.valueOf(eVar.Ab())));
                                } else {
                                    stringBuffer.append(String.format(this.ast.getString(d.j.notify_validate_1), Integer.valueOf(eVar.Ab())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Ak(), eVar.Al(), eVar.Al());
                                }
                            }
                            z = false;
                            if (eVar.Ab() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.Au() > 0 && !yX()) {
                            String format2 = String.format(this.ast.getString(d.j.notify_live), Integer.valueOf(eVar.Au()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.ast, 16);
                    NotificationHelper.cancelNotification(this.ast, 17);
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
            PendingIntent service = PendingIntent.getService(this.ast, bVar.auc, a, 134217728);
            F(dX(i), i);
            NotificationHelper.showNotification(this.ast, i, bVar.title, bVar.content, bVar.aue, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ast, aVar.auc, a, 134217728);
            F(dX(i), i);
            NotificationHelper.showNotification(this.ast, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.asF) {
            if (i == 23 && this.asz > 0) {
                g = dT(i);
            } else if (i == 26 && this.asy > 0) {
                g = dU(i);
            } else if (i == 18) {
                g = yQ();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.ast, i, g, 134217728);
            F(dX(i), i);
            NotificationHelper.showNotification(this.ast, i, str, str2, str3, service, false);
        }
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.ast, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.asz);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dU(int i) {
        Intent intent = new Intent(this.ast, DealIntentService.class);
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
        ImMessageCenterPojo ai = com.baidu.tieba.im.memorycache.b.aBP().ai(bVar.auc + "", bVar.userType);
        if (ai == null || ai.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(ai.getLastContentRawData());
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
                    Intent intent = new Intent(this.ast, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", bVar.auc);
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
        Intent intent = new Intent(this.ast, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.auc);
        intent.putExtra("uname", bVar.auf);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.ast, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.auc));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.asC.As().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.ast, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.asv);
        intent.putExtra("reply_me", this.asu);
        intent.putExtra("fans", this.asy);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.asC.zY() - this.asC.Af());
        intent.putExtra("group_msg_validate", this.asC.Ab());
        intent.putExtra("group_msg_updates", this.asC.zZ());
        intent.putExtra("live_notify_msg_updates", this.asC.Au());
        intent.putExtra("officialbar_msg", this.asC.Ac());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yQ() {
        Intent intent = new Intent(this.ast, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.asC.Aa());
        return intent;
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.ast, 23);
        NotificationHelper.cancelNotification(this.ast, 24);
        NotificationHelper.cancelNotification(this.ast, 25);
        NotificationHelper.cancelNotification(this.ast, 26);
        NotificationHelper.cancelNotification(this.ast, 17);
        NotificationHelper.cancelNotification(this.ast, 15);
        NotificationHelper.cancelNotification(this.ast, 13);
        NotificationHelper.cancelNotification(this.ast, 12);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.ast, 16);
    }

    public void yT() {
        NotificationHelper.cancelNotification(this.ast, 19);
    }

    public void dV(int i) {
        NotificationHelper.cancelNotification(this.ast, i);
    }

    public int yU() {
        return this.asC.Ax();
    }

    public void eO(String str) {
        if (TextUtils.isEmpty(str)) {
            yS();
            return;
        }
        e zi = zi();
        if (zi == null) {
            yS();
            return;
        }
        HashMap<String, String> Am = zi.Am();
        if (Am == null || Am.isEmpty()) {
            yS();
        } else if (Am.containsKey(str)) {
            yS();
        }
    }

    public void eP(String str) {
        if (TextUtils.isEmpty(str)) {
            yS();
            return;
        }
        e zi = zi();
        if (zi == null) {
            yS();
            return;
        }
        HashMap<String, String> As = zi.As();
        if (As == null || As.isEmpty()) {
            yS();
        } else if (As.containsKey(str)) {
            yS();
        }
    }

    private boolean yV() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yW() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yX() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yY() {
        NotificationHelper.cancelNotification(this.ast, 17);
    }

    public void dW(int i) {
        e zi = zi();
        if (zi == null) {
            yY();
        } else if (1 == i) {
            if (zi.zZ() <= 0) {
                yY();
            }
        } else if (2 == i) {
            if (zi.Ab() <= 0) {
                yY();
            }
        } else if (3 == i && zi.Au() <= 0) {
            NotificationHelper.cancelNotification(this.ast, 21);
        }
    }

    public void yZ() {
        NotificationHelper.cancelNotification(this.ast, 18);
    }

    public void za() {
        NotificationHelper.cancelNotification(this.ast, 26);
        NotificationHelper.cancelNotification(this.ast, 25);
        NotificationHelper.cancelNotification(this.ast, 24);
        NotificationHelper.cancelNotification(this.ast, 23);
        NotificationHelper.cancelNotification(this.ast, 16);
        NotificationHelper.cancelNotification(this.ast, 17);
    }

    public void zb() {
        NotificationHelper.cancelNotification(this.ast, 21);
        NotificationHelper.cancelNotification(this.ast, 17);
        NotificationHelper.cancelNotification(this.ast, 19);
        NotificationHelper.cancelNotification(this.ast, 16);
        NotificationHelper.cancelNotification(this.ast, 18);
    }

    public void zc() {
        NotificationHelper.cancelNotification(this.ast, 24);
    }

    public void zd() {
        NotificationHelper.cancelNotification(this.ast, 25);
    }

    public void ze() {
        NotificationHelper.cancelNotification(this.ast, 23);
    }

    public void zf() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zg());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.asC.Aq());
        newsNotifyMessage.setMsgStrangerChat(this.asC.Ax());
        newsNotifyMessage.setMsgOfficialMerge(this.asC.Aw());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Aq() + eVar.zY()) + eVar.Ax()) + eVar.Aw()) + eVar.AC()) - eVar.Af());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Aq());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ax());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Aw());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.asu;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.asv, this.asw, this.asy, this.asx, this.asz);
        }
    }

    public int getMsgAtme() {
        return this.asv;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.asu, i, this.asw, this.asy, this.asx, this.asz);
        }
    }

    public int getMsgChat() {
        return this.asw;
    }

    public int zg() {
        return ((((this.asC.Aq() + this.asC.zY()) + this.asC.Ax()) + this.asC.Aw()) + this.asC.AC()) - this.asC.Af();
    }

    public int getMsgFans() {
        return this.asy;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.asu, this.asv, this.asw, i, this.asx, this.asz);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.asu, this.asv, i, this.asy, this.asx, this.asz);
        }
    }

    public int getMsgBookmark() {
        return this.asx;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.asu, this.asv, this.asw, this.asy, i, this.asz);
        }
    }

    public int getMsgGiftNum() {
        return this.asz;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.asz = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.asA = i;
            zf();
        }
    }

    public int getMsgLiveVip() {
        return this.asA;
    }

    public void aS(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.asu = 0;
        this.asv = 0;
        this.asw = 0;
        this.asy = 0;
        this.asx = 0;
    }

    public int zh() {
        return this.asu + this.asv + this.asw + this.asy + this.asz;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.asC = eVar;
            this.asw = (eVar.zY() - eVar.Af()) + eVar.Aq() + eVar.Aw() + eVar.AC();
            a(eVar);
            if (eVar.Ag()) {
                this.asD = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ag()) {
                if (b.zk().zz() && b.zk().zn() > 0) {
                    i = eVar.zY() - eVar.Af();
                }
                long Aq = (!b.zk().zs() || b.zk().zn() <= 0) ? 0L : eVar.Aq();
                if ((i > 0 || Aq > 0) && ((i > eVar.Aj() - eVar.Af() && i > 0) || Aq > eVar.Ad())) {
                    a(1, 16, eVar);
                }
                int Ac = eVar.Ac();
                if (Ac > 0 && Ac > eVar.Ap()) {
                    a(1, 19, eVar);
                }
                if (eVar.zZ() > eVar.An() || eVar.Ab() > eVar.Ao()) {
                    if (eVar.zZ() <= eVar.An() || eVar.Ab() != eVar.Ao() || !yW()) {
                        if (eVar.zZ() != eVar.An() || eVar.Ab() <= eVar.Ao() || !yV()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.Au() > eVar.Av() && !yX()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ay() > eVar.Az()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zi() {
        return this.asC;
    }

    public void c(e eVar) {
        this.asC = eVar;
    }

    public e zj() {
        return this.asD;
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

    public void F(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.ast, 26, i2);
        }
    }
}
