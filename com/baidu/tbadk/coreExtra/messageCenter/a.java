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
    private static a ast;
    private static Date asw = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yM().b(a.yM().zi());
            }
        }
    };
    private e asv;
    private String asy;
    private String asz;
    private int asm = 0;
    private int asn = 0;
    private int aso = 0;
    private int asp = 0;
    private int asq = 0;
    private int asr = 0;
    private int ass = 0;
    private e asu = new e();
    private boolean asx = true;
    private final int[] asA = new int[10];
    private final Context asl = TbadkCoreApplication.getInst().getApp();

    public static a yM() {
        if (ast == null) {
            ast = new a();
        }
        return ast;
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
                    this.asy = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.asy = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.asz = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.asm || i2 != this.asn || i3 != this.aso || i4 != this.asq || i5 != this.asp || i6 != this.asr) {
            if (i > this.asm || i2 > this.asn || i3 > this.aso || i4 > this.asq || i5 > this.asp || i6 > this.asr) {
                i7 = 1;
            } else {
                i7 = (i < this.asm || i2 < this.asn) ? 2 : 0;
            }
            if (i > this.asm) {
                i8 = 1;
            } else {
                i8 = i < this.asm ? 2 : 0;
            }
            if (i2 > this.asn) {
                i9 = 1;
            } else {
                i9 = i2 < this.asn ? 2 : 0;
            }
            int i11 = i3 > this.aso ? 1 : 0;
            int i12 = i4 > this.asq ? 1 : 0;
            int i13 = i6 <= this.asr ? 0 : 1;
            this.asm = i;
            this.asn = i2;
            this.aso = i3;
            this.asq = i4;
            this.asp = i5;
            this.asr = i6;
            if (zg() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                ze();
                D(i10, 23);
                D(i11, 16);
                D(i7, 17);
                D(i8, 24);
                D(i9, 25);
                D(i12, 26);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (i != this.asm || i2 != this.asn || i3 != this.aso || i4 != this.asq || this.asr != i5) {
            this.asm = i;
            this.asn = i2;
            this.aso = i3;
            this.asq = i4;
            this.asr = i5;
            ze();
            if (zg() <= 0) {
                D(2, 16);
                D(2, 17);
            }
        }
    }

    public static boolean yN() {
        if (asw == null) {
            asw = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - asw.getTime() < 10000) {
                return false;
            }
            asw = date;
        }
        return true;
    }

    public static boolean yO() {
        if (b.zj().zu()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zj().zw().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zj().zx().split(":");
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

    private void D(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.asr > 0) {
                        String format = String.format(this.asl.getString(d.j.notify_gift), String.valueOf(this.asr));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.asm > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.asm > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.asm));
                            sb.append(this.asl.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.asy != null) {
                            sb.append(this.asy);
                        } else {
                            sb.append(this.asl.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.asn > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.asn > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.asn));
                            sb2.append(this.asl.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.asz != null) {
                            sb2.append(this.asz);
                        } else {
                            sb2.append(this.asl.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.asq > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.asl.getString(d.j.notify_fans), Integer.valueOf(this.asq)));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zj().zy() || b.zj().zm() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.asl, 16);
                NotificationHelper.cancelNotification(this.asl, 17);
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
        String Ah;
        String Ag;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.asr > 0) {
                            String format = String.format(this.asl.getString(d.j.notify_gift), String.valueOf(this.asr));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.asm > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.asm > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.asm));
                                sb.append(this.asl.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.asy != null) {
                                sb.append(this.asy);
                            } else {
                                sb.append(this.asl.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.asn > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.asn > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.asn));
                                sb2.append(this.asl.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.asz != null) {
                                sb2.append(this.asz);
                            } else {
                                sb2.append(this.asl.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.asq > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.asq > 1) {
                                sb3.append(String.format(this.asl.getString(d.j.notify_fans_unit), Integer.valueOf(this.asq)));
                            }
                            sb3.append(this.asl.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int zX = (!b.zj().zy() || b.zj().zm() <= 0) ? 0 : eVar.zX() - eVar.Ae();
                        long Ap = (!b.zj().zr() || b.zj().zm() <= 0) ? 0L : eVar.Ap();
                        boolean z4 = Ap > 0;
                        long j = zX + Ap;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.asl.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.As();
                            eVar.Aq();
                            if (Ap == 1) {
                                Ah = eVar.As();
                                str = eVar.Aq();
                                Ag = Ah + "：" + str;
                            } else if (zX == 1) {
                                Ah = eVar.Ah();
                                Ag = eVar.Ag();
                                str = Ag;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.asl.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ag)) {
                                Ag = str;
                            }
                            a(16, Ah, str, Ag, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> Az = eVar.Az();
                        if (Az != null && Az.size() != 0) {
                            for (e.b bVar : Az) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.atU != 0 && bVar.unReadCount > bVar.atV) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AA = eVar.AA();
                        if (AA != null && AA.size() != 0) {
                            for (e.a aVar : AA) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.atU != 0 && aVar.unReadCount > aVar.atV) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zj().zy() && b.zj().zm() > 0) {
                        if (eVar.zY() + eVar.Aa() > 0) {
                            if (eVar.zY() > 0 && !yV()) {
                                long zY = eVar.zY() - eVar.zZ();
                                if (zY > 0) {
                                    stringBuffer.append(String.format(this.asl.getString(d.j.notify_updates), Long.valueOf(zY)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.zZ() > 0) {
                                    z = true;
                                }
                                if (eVar.Aa() > 0 || yU()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.asl.getString(d.j.notify_validate), Integer.valueOf(eVar.Aa())));
                                } else {
                                    stringBuffer.append(String.format(this.asl.getString(d.j.notify_validate_1), Integer.valueOf(eVar.Aa())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Aj(), eVar.Ak(), eVar.Ak());
                                }
                            }
                            z = false;
                            if (eVar.Aa() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.At() > 0 && !yW()) {
                            String format2 = String.format(this.asl.getString(d.j.notify_live), Integer.valueOf(eVar.At()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.asl, 16);
                    NotificationHelper.cancelNotification(this.asl, 17);
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
            PendingIntent service = PendingIntent.getService(this.asl, bVar.atU, a, 134217728);
            E(dX(i), i);
            NotificationHelper.showNotification(this.asl, i, bVar.title, bVar.content, bVar.atW, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asl, aVar.atU, a, 134217728);
            E(dX(i), i);
            NotificationHelper.showNotification(this.asl, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent g;
        if (this.asx) {
            if (i == 23 && this.asr > 0) {
                g = dT(i);
            } else if (i == 26 && this.asq > 0) {
                g = dU(i);
            } else if (i == 18) {
                g = yP();
            } else {
                g = g(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            g.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asl, i, g, 134217728);
            E(dX(i), i);
            NotificationHelper.showNotification(this.asl, i, str, str2, str3, service, false);
        }
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.asl, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.asr);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dU(int i) {
        Intent intent = new Intent(this.asl, DealIntentService.class);
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
        ImMessageCenterPojo ah = com.baidu.tieba.im.memorycache.b.aBG().ah(bVar.atU + "", bVar.userType);
        if (ah == null || ah.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(ah.getLastContentRawData());
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
                    Intent intent = new Intent(this.asl, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", bVar.atU);
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
        Intent intent = new Intent(this.asl, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.atU);
        intent.putExtra("uname", bVar.atX);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.asl, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.atU));
        return intent;
    }

    public Intent g(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.asu.Ar().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.asl, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.asn);
        intent.putExtra("reply_me", this.asm);
        intent.putExtra("fans", this.asq);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.asu.zX() - this.asu.Ae());
        intent.putExtra("group_msg_validate", this.asu.Aa());
        intent.putExtra("group_msg_updates", this.asu.zY());
        intent.putExtra("live_notify_msg_updates", this.asu.At());
        intent.putExtra("officialbar_msg", this.asu.Ab());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent yP() {
        Intent intent = new Intent(this.asl, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.asu.zZ());
        return intent;
    }

    public void yQ() {
        NotificationHelper.cancelNotification(this.asl, 23);
        NotificationHelper.cancelNotification(this.asl, 24);
        NotificationHelper.cancelNotification(this.asl, 25);
        NotificationHelper.cancelNotification(this.asl, 26);
        NotificationHelper.cancelNotification(this.asl, 17);
        NotificationHelper.cancelNotification(this.asl, 15);
        NotificationHelper.cancelNotification(this.asl, 13);
        NotificationHelper.cancelNotification(this.asl, 12);
    }

    public void yR() {
        NotificationHelper.cancelNotification(this.asl, 16);
    }

    public void yS() {
        NotificationHelper.cancelNotification(this.asl, 19);
    }

    public void dV(int i) {
        NotificationHelper.cancelNotification(this.asl, i);
    }

    public int yT() {
        return this.asu.Aw();
    }

    public void eO(String str) {
        if (TextUtils.isEmpty(str)) {
            yR();
            return;
        }
        e zh = zh();
        if (zh == null) {
            yR();
            return;
        }
        HashMap<String, String> Al = zh.Al();
        if (Al == null || Al.isEmpty()) {
            yR();
        } else if (Al.containsKey(str)) {
            yR();
        }
    }

    public void eP(String str) {
        if (TextUtils.isEmpty(str)) {
            yR();
            return;
        }
        e zh = zh();
        if (zh == null) {
            yR();
            return;
        }
        HashMap<String, String> Ar = zh.Ar();
        if (Ar == null || Ar.isEmpty()) {
            yR();
        } else if (Ar.containsKey(str)) {
            yR();
        }
    }

    private boolean yU() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean yV() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean yW() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void yX() {
        NotificationHelper.cancelNotification(this.asl, 17);
    }

    public void dW(int i) {
        e zh = zh();
        if (zh == null) {
            yX();
        } else if (1 == i) {
            if (zh.zY() <= 0) {
                yX();
            }
        } else if (2 == i) {
            if (zh.Aa() <= 0) {
                yX();
            }
        } else if (3 == i && zh.At() <= 0) {
            NotificationHelper.cancelNotification(this.asl, 21);
        }
    }

    public void yY() {
        NotificationHelper.cancelNotification(this.asl, 18);
    }

    public void yZ() {
        NotificationHelper.cancelNotification(this.asl, 26);
        NotificationHelper.cancelNotification(this.asl, 25);
        NotificationHelper.cancelNotification(this.asl, 24);
        NotificationHelper.cancelNotification(this.asl, 23);
        NotificationHelper.cancelNotification(this.asl, 16);
        NotificationHelper.cancelNotification(this.asl, 17);
    }

    public void za() {
        NotificationHelper.cancelNotification(this.asl, 21);
        NotificationHelper.cancelNotification(this.asl, 17);
        NotificationHelper.cancelNotification(this.asl, 19);
        NotificationHelper.cancelNotification(this.asl, 16);
        NotificationHelper.cancelNotification(this.asl, 18);
    }

    public void zb() {
        NotificationHelper.cancelNotification(this.asl, 24);
    }

    public void zc() {
        NotificationHelper.cancelNotification(this.asl, 25);
    }

    public void zd() {
        NotificationHelper.cancelNotification(this.asl, 23);
    }

    public void ze() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zf());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.asu.Ap());
        newsNotifyMessage.setMsgStrangerChat(this.asu.Aw());
        newsNotifyMessage.setMsgOfficialMerge(this.asu.Av());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Ap() + eVar.zX()) + eVar.Aw()) + eVar.Av()) + eVar.AB()) - eVar.Ae());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.Ap());
            newsNotifyMessage.setMsgStrangerChat(eVar.Aw());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Av());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.asm;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.asn, this.aso, this.asq, this.asp, this.asr);
        }
    }

    public int getMsgAtme() {
        return this.asn;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.asm, i, this.aso, this.asq, this.asp, this.asr);
        }
    }

    public int getMsgChat() {
        return this.aso;
    }

    public int zf() {
        return ((((this.asu.Ap() + this.asu.zX()) + this.asu.Aw()) + this.asu.Av()) + this.asu.AB()) - this.asu.Ae();
    }

    public int getMsgFans() {
        return this.asq;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.asm, this.asn, this.aso, i, this.asp, this.asr);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.asm, this.asn, i, this.asq, this.asp, this.asr);
        }
    }

    public int getMsgBookmark() {
        return this.asp;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.asm, this.asn, this.aso, this.asq, i, this.asr);
        }
    }

    public int getMsgGiftNum() {
        return this.asr;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.asr = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.ass = i;
            ze();
        }
    }

    public int getMsgLiveVip() {
        return this.ass;
    }

    public void aR(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.asm = 0;
        this.asn = 0;
        this.aso = 0;
        this.asq = 0;
        this.asp = 0;
    }

    public int zg() {
        return this.asm + this.asn + this.aso + this.asq + this.asr;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.asu = eVar;
            this.aso = (eVar.zX() - eVar.Ae()) + eVar.Ap() + eVar.Av() + eVar.AB();
            a(eVar);
            if (eVar.Af()) {
                this.asv = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Af()) {
                if (b.zj().zy() && b.zj().zm() > 0) {
                    i = eVar.zX() - eVar.Ae();
                }
                long Ap = (!b.zj().zr() || b.zj().zm() <= 0) ? 0L : eVar.Ap();
                if ((i > 0 || Ap > 0) && ((i > eVar.Ai() - eVar.Ae() && i > 0) || Ap > eVar.Ac())) {
                    a(1, 16, eVar);
                }
                int Ab = eVar.Ab();
                if (Ab > 0 && Ab > eVar.Ao()) {
                    a(1, 19, eVar);
                }
                if (eVar.zY() > eVar.Am() || eVar.Aa() > eVar.An()) {
                    if (eVar.zY() <= eVar.Am() || eVar.Aa() != eVar.An() || !yV()) {
                        if (eVar.zY() != eVar.Am() || eVar.Aa() <= eVar.An() || !yU()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.At() > eVar.Au() && !yW()) {
                    a(1, 21, eVar);
                }
                if (eVar.Ax() > eVar.Ay()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zh() {
        return this.asu;
    }

    public void c(e eVar) {
        this.asu = eVar;
    }

    public e zi() {
        return this.asv;
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

    public void E(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asl, 26, i2);
        }
    }
}
