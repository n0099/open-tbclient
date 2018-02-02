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
    private static a bhb;
    private static Date bhe = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Gh().b(a.Gh().GD());
            }
        }
    };
    private e bhd;
    private String bhg;
    private String bhh;
    private int bgU = 0;
    private int bgV = 0;
    private int bgW = 0;
    private int bgX = 0;
    private int bgY = 0;
    private int bgZ = 0;
    private int bha = 0;
    private e bhc = new e();
    private boolean bhf = true;
    private final int[] bhi = new int[10];
    private final Context bgT = TbadkCoreApplication.getInst().getApp();

    public static a Gh() {
        if (bhb == null) {
            bhb = new a();
        }
        return bhb;
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
                    this.bhg = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bhg = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bhh = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.bgU || i2 != this.bgV || i3 != this.bgW || i4 != this.bgY || i5 != this.bgX || i6 != this.bgZ) {
            if (i > this.bgU || i2 > this.bgV || i3 > this.bgW || i4 > this.bgY || i5 > this.bgX || i6 > this.bgZ) {
                i7 = 1;
            } else {
                i7 = (i < this.bgU || i2 < this.bgV) ? 2 : 0;
            }
            if (i > this.bgU) {
                i8 = 1;
            } else {
                i8 = i < this.bgU ? 2 : 0;
            }
            if (i2 > this.bgV) {
                i9 = 1;
            } else {
                i9 = i2 < this.bgV ? 2 : 0;
            }
            int i11 = i3 > this.bgW ? 1 : 0;
            int i12 = i4 > this.bgY ? 1 : 0;
            int i13 = i6 <= this.bgZ ? 0 : 1;
            this.bgU = i;
            this.bgV = i2;
            this.bgW = i3;
            this.bgY = i4;
            this.bgX = i5;
            this.bgZ = i6;
            if (GB() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Gz();
                aD(i10, 23);
                aD(i11, 16);
                aD(i7, 17);
                aD(i8, 24);
                aD(i9, 25);
                aD(i12, 26);
            }
        }
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        if (i != this.bgU || i2 != this.bgV || i3 != this.bgW || i4 != this.bgY || this.bgZ != i5) {
            this.bgU = i;
            this.bgV = i2;
            this.bgW = i3;
            this.bgY = i4;
            this.bgZ = i5;
            Gz();
            if (GB() <= 0) {
                aD(2, 16);
                aD(2, 17);
            }
        }
    }

    public static boolean Gi() {
        if (bhe == null) {
            bhe = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bhe.getTime() < 10000) {
                return false;
            }
            bhe = date;
        }
        return true;
    }

    public static boolean Gj() {
        if (b.GE().GP()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.GE().GR().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.GE().GS().split(":");
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

    private void aD(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.bgZ > 0) {
                        String format = String.format(this.bgT.getString(d.j.notify_gift), String.valueOf(this.bgZ));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.bgU > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.bgU > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.bgU));
                            sb.append(this.bgT.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.bhg != null) {
                            sb.append(this.bhg);
                        } else {
                            sb.append(this.bgT.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bgV > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bgV > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bgV));
                            sb2.append(this.bgT.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bhh != null) {
                            sb2.append(this.bhh);
                        } else {
                            sb2.append(this.bgT.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bgY > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.bgT.getString(d.j.notify_fans), Integer.valueOf(this.bgY)));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.GE().GT() || b.GE().GH() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.bgT, 16);
                NotificationHelper.cancelNotification(this.bgT, 17);
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
        String HC;
        String HB;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bgZ > 0) {
                            String format = String.format(this.bgT.getString(d.j.notify_gift), String.valueOf(this.bgZ));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.bgU > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.bgU > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.bgU));
                                sb.append(this.bgT.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bhg != null) {
                                sb.append(this.bhg);
                            } else {
                                sb.append(this.bgT.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bgV > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bgV > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bgV));
                                sb2.append(this.bgT.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bhh != null) {
                                sb2.append(this.bhh);
                            } else {
                                sb2.append(this.bgT.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bgY > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bgY > 1) {
                                sb3.append(String.format(this.bgT.getString(d.j.notify_fans_unit), Integer.valueOf(this.bgY)));
                            }
                            sb3.append(this.bgT.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Hs = (!b.GE().GT() || b.GE().GH() <= 0) ? 0 : eVar.Hs() - eVar.Hz();
                        long HK = (!b.GE().GM() || b.GE().GH() <= 0) ? 0L : eVar.HK();
                        boolean z4 = HK > 0;
                        long j = Hs + HK;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.bgT.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.HN();
                            eVar.HL();
                            if (HK == 1) {
                                HC = eVar.HN();
                                str = eVar.HL();
                                HB = HC + "：" + str;
                            } else if (Hs == 1) {
                                HC = eVar.HC();
                                HB = eVar.HB();
                                str = HB;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.bgT.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(HB)) {
                                HB = str;
                            }
                            a(16, HC, str, HB, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> HU = eVar.HU();
                        if (HU != null && HU.size() != 0) {
                            for (e.b bVar : HU) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.biE != 0 && bVar.unReadCount > bVar.biF) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> HV = eVar.HV();
                        if (HV != null && HV.size() != 0) {
                            for (e.a aVar : HV) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.biE != 0 && aVar.unReadCount > aVar.biF) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.GE().GT() && b.GE().GH() > 0) {
                        if (eVar.Ht() + eVar.Hv() > 0) {
                            if (eVar.Ht() > 0 && !Gq()) {
                                long Ht = eVar.Ht() - eVar.Hu();
                                if (Ht > 0) {
                                    stringBuffer.append(String.format(this.bgT.getString(d.j.notify_updates), Long.valueOf(Ht)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Hu() > 0) {
                                    z = true;
                                }
                                if (eVar.Hv() > 0 || Gp()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.bgT.getString(d.j.notify_validate), Integer.valueOf(eVar.Hv())));
                                } else {
                                    stringBuffer.append(String.format(this.bgT.getString(d.j.notify_validate_1), Integer.valueOf(eVar.Hv())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.HE(), eVar.HF(), eVar.HF());
                                }
                            }
                            z = false;
                            if (eVar.Hv() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.HO() > 0 && !Gr()) {
                            String format2 = String.format(this.bgT.getString(d.j.notify_live), Integer.valueOf(eVar.HO()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.bgT, 16);
                    NotificationHelper.cancelNotification(this.bgT, 17);
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
            PendingIntent service = PendingIntent.getService(this.bgT, bVar.biE, a, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgT, i, bVar.title, bVar.content, bVar.biG, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgT, aVar.biE, a, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgT, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        if (this.bhf) {
            if (i == 23 && this.bgZ > 0) {
                r = gO(i);
            } else if (i == 26 && this.bgY > 0) {
                r = gP(i);
            } else if (i == 18) {
                r = Gk();
            } else {
                r = r(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            r.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgT, i, r, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgT, i, str, str2, str3, service, false);
        }
    }

    public Intent gO(int i) {
        Intent intent = new Intent(this.bgT, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bgZ);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent gP(int i) {
        Intent intent = new Intent(this.bgT, DealIntentService.class);
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
        ImMessageCenterPojo am = com.baidu.tieba.im.memorycache.b.aJa().am(bVar.biE + "", bVar.userType);
        if (am == null || am.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(am.getLastContentRawData());
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
                    Intent intent = new Intent(this.bgT, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", bVar.biE);
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
        Intent intent = new Intent(this.bgT, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.biE);
        intent.putExtra("uname", bVar.biH);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.bgT, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.biE));
        return intent;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bhc.HM().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.bgT, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.bgV);
        intent.putExtra("reply_me", this.bgU);
        intent.putExtra("fans", this.bgY);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bhc.Hs() - this.bhc.Hz());
        intent.putExtra("group_msg_validate", this.bhc.Hv());
        intent.putExtra("group_msg_updates", this.bhc.Ht());
        intent.putExtra("live_notify_msg_updates", this.bhc.HO());
        intent.putExtra("officialbar_msg", this.bhc.Hw());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Gk() {
        Intent intent = new Intent(this.bgT, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bhc.Hu());
        return intent;
    }

    public void Gl() {
        NotificationHelper.cancelNotification(this.bgT, 23);
        NotificationHelper.cancelNotification(this.bgT, 24);
        NotificationHelper.cancelNotification(this.bgT, 25);
        NotificationHelper.cancelNotification(this.bgT, 26);
        NotificationHelper.cancelNotification(this.bgT, 17);
        NotificationHelper.cancelNotification(this.bgT, 15);
        NotificationHelper.cancelNotification(this.bgT, 13);
        NotificationHelper.cancelNotification(this.bgT, 12);
    }

    public void Gm() {
        NotificationHelper.cancelNotification(this.bgT, 16);
    }

    public void Gn() {
        NotificationHelper.cancelNotification(this.bgT, 19);
    }

    public void gQ(int i) {
        NotificationHelper.cancelNotification(this.bgT, i);
    }

    public int Go() {
        return this.bhc.HR();
    }

    public void fd(String str) {
        if (TextUtils.isEmpty(str)) {
            Gm();
            return;
        }
        e GC = GC();
        if (GC == null) {
            Gm();
            return;
        }
        HashMap<String, String> HG = GC.HG();
        if (HG == null || HG.isEmpty()) {
            Gm();
        } else if (HG.containsKey(str)) {
            Gm();
        }
    }

    public void fe(String str) {
        if (TextUtils.isEmpty(str)) {
            Gm();
            return;
        }
        e GC = GC();
        if (GC == null) {
            Gm();
            return;
        }
        HashMap<String, String> HM = GC.HM();
        if (HM == null || HM.isEmpty()) {
            Gm();
        } else if (HM.containsKey(str)) {
            Gm();
        }
    }

    private boolean Gp() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Gq() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean Gr() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void Gs() {
        NotificationHelper.cancelNotification(this.bgT, 17);
    }

    public void gR(int i) {
        e GC = GC();
        if (GC == null) {
            Gs();
        } else if (1 == i) {
            if (GC.Ht() <= 0) {
                Gs();
            }
        } else if (2 == i) {
            if (GC.Hv() <= 0) {
                Gs();
            }
        } else if (3 == i && GC.HO() <= 0) {
            NotificationHelper.cancelNotification(this.bgT, 21);
        }
    }

    public void Gt() {
        NotificationHelper.cancelNotification(this.bgT, 18);
    }

    public void Gu() {
        NotificationHelper.cancelNotification(this.bgT, 26);
        NotificationHelper.cancelNotification(this.bgT, 25);
        NotificationHelper.cancelNotification(this.bgT, 24);
        NotificationHelper.cancelNotification(this.bgT, 23);
        NotificationHelper.cancelNotification(this.bgT, 16);
        NotificationHelper.cancelNotification(this.bgT, 17);
    }

    public void Gv() {
        NotificationHelper.cancelNotification(this.bgT, 21);
        NotificationHelper.cancelNotification(this.bgT, 17);
        NotificationHelper.cancelNotification(this.bgT, 19);
        NotificationHelper.cancelNotification(this.bgT, 16);
        NotificationHelper.cancelNotification(this.bgT, 18);
    }

    public void Gw() {
        NotificationHelper.cancelNotification(this.bgT, 24);
    }

    public void Gx() {
        NotificationHelper.cancelNotification(this.bgT, 25);
    }

    public void Gy() {
        NotificationHelper.cancelNotification(this.bgT, 23);
    }

    public void Gz() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(GA());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.bhc.HK());
        newsNotifyMessage.setMsgStrangerChat(this.bhc.HR());
        newsNotifyMessage.setMsgOfficialMerge(this.bhc.HQ());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.HK() + eVar.Hs()) + eVar.HR()) + eVar.HQ()) + eVar.HW()) - eVar.Hz());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.HK());
            newsNotifyMessage.setMsgStrangerChat(eVar.HR());
            newsNotifyMessage.setMsgOfficialMerge(eVar.HQ());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bgU;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.bgV, this.bgW, this.bgY, this.bgX, this.bgZ);
        }
    }

    public int getMsgAtme() {
        return this.bgV;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.bgU, i, this.bgW, this.bgY, this.bgX, this.bgZ);
        }
    }

    public int getMsgChat() {
        return this.bgW;
    }

    public int GA() {
        return ((((this.bhc.HK() + this.bhc.Hs()) + this.bhc.HR()) + this.bhc.HQ()) + this.bhc.HW()) - this.bhc.Hz();
    }

    public int getMsgFans() {
        return this.bgY;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.bgU, this.bgV, this.bgW, i, this.bgX, this.bgZ);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.bgU, this.bgV, i, this.bgY, this.bgX, this.bgZ);
        }
    }

    public int getMsgBookmark() {
        return this.bgX;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.bgU, this.bgV, this.bgW, this.bgY, i, this.bgZ);
        }
    }

    public int getMsgGiftNum() {
        return this.bgZ;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bgZ = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.bha = i;
            Gz();
        }
    }

    public int getMsgLiveVip() {
        return this.bha;
    }

    public void bz(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.bgU = 0;
        this.bgV = 0;
        this.bgW = 0;
        this.bgY = 0;
        this.bgX = 0;
    }

    public int GB() {
        return this.bgU + this.bgV + this.bgW + this.bgY + this.bgZ;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bhc = eVar;
            this.bgW = (eVar.Hs() - eVar.Hz()) + eVar.HK() + eVar.HQ() + eVar.HW();
            a(eVar);
            if (eVar.HA()) {
                this.bhd = null;
                mHandler.removeMessages(0);
            }
            if (eVar.HA()) {
                if (b.GE().GT() && b.GE().GH() > 0) {
                    i = eVar.Hs() - eVar.Hz();
                }
                long HK = (!b.GE().GM() || b.GE().GH() <= 0) ? 0L : eVar.HK();
                if ((i > 0 || HK > 0) && ((i > eVar.HD() - eVar.Hz() && i > 0) || HK > eVar.Hx())) {
                    a(1, 16, eVar);
                }
                int Hw = eVar.Hw();
                if (Hw > 0 && Hw > eVar.HJ()) {
                    a(1, 19, eVar);
                }
                if (eVar.Ht() > eVar.HH() || eVar.Hv() > eVar.HI()) {
                    if (eVar.Ht() <= eVar.HH() || eVar.Hv() != eVar.HI() || !Gq()) {
                        if (eVar.Ht() != eVar.HH() || eVar.Hv() <= eVar.HI() || !Gp()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.HO() > eVar.HP() && !Gr()) {
                    a(1, 21, eVar);
                }
                if (eVar.HS() > eVar.HT()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e GC() {
        return this.bhc;
    }

    public void c(e eVar) {
        this.bhc = eVar;
    }

    public e GD() {
        return this.bhd;
    }

    public int gS(int i) {
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

    public void aE(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgT, 26, i2);
        }
    }
}
