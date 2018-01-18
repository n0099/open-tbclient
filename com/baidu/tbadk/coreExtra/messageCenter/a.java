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
    private static a bgT;
    private static Date bgW = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Gf().b(a.Gf().GB());
            }
        }
    };
    private e bgV;
    private String bgY;
    private String bgZ;
    private int bgM = 0;
    private int bgN = 0;
    private int bgO = 0;
    private int bgP = 0;
    private int bgQ = 0;
    private int bgR = 0;
    private int bgS = 0;
    private e bgU = new e();
    private boolean bgX = true;
    private final int[] bha = new int[10];
    private final Context bgL = TbadkCoreApplication.getInst().getApp();

    public static a Gf() {
        if (bgT == null) {
            bgT = new a();
        }
        return bgT;
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
                    this.bgY = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bgY = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bgZ = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.bgM || i2 != this.bgN || i3 != this.bgO || i4 != this.bgQ || i5 != this.bgP || i6 != this.bgR) {
            if (i > this.bgM || i2 > this.bgN || i3 > this.bgO || i4 > this.bgQ || i5 > this.bgP || i6 > this.bgR) {
                i7 = 1;
            } else {
                i7 = (i < this.bgM || i2 < this.bgN) ? 2 : 0;
            }
            if (i > this.bgM) {
                i8 = 1;
            } else {
                i8 = i < this.bgM ? 2 : 0;
            }
            if (i2 > this.bgN) {
                i9 = 1;
            } else {
                i9 = i2 < this.bgN ? 2 : 0;
            }
            int i11 = i3 > this.bgO ? 1 : 0;
            int i12 = i4 > this.bgQ ? 1 : 0;
            int i13 = i6 <= this.bgR ? 0 : 1;
            this.bgM = i;
            this.bgN = i2;
            this.bgO = i3;
            this.bgQ = i4;
            this.bgP = i5;
            this.bgR = i6;
            if (Gz() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Gx();
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
        if (i != this.bgM || i2 != this.bgN || i3 != this.bgO || i4 != this.bgQ || this.bgR != i5) {
            this.bgM = i;
            this.bgN = i2;
            this.bgO = i3;
            this.bgQ = i4;
            this.bgR = i5;
            Gx();
            if (Gz() <= 0) {
                aD(2, 16);
                aD(2, 17);
            }
        }
    }

    public static boolean Gg() {
        if (bgW == null) {
            bgW = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bgW.getTime() < 10000) {
                return false;
            }
            bgW = date;
        }
        return true;
    }

    public static boolean Gh() {
        if (b.GC().GN()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.GC().GP().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.GC().GQ().split(":");
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
                    if (this.bgR > 0) {
                        String format = String.format(this.bgL.getString(d.j.notify_gift), String.valueOf(this.bgR));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.bgM > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.bgM > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.bgM));
                            sb.append(this.bgL.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.bgY != null) {
                            sb.append(this.bgY);
                        } else {
                            sb.append(this.bgL.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bgN > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bgN > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bgN));
                            sb2.append(this.bgL.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bgZ != null) {
                            sb2.append(this.bgZ);
                        } else {
                            sb2.append(this.bgL.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bgQ > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.bgL.getString(d.j.notify_fans), Integer.valueOf(this.bgQ)));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.GC().GR() || b.GC().GF() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.bgL, 16);
                NotificationHelper.cancelNotification(this.bgL, 17);
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
        String HA;
        String Hz;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bgR > 0) {
                            String format = String.format(this.bgL.getString(d.j.notify_gift), String.valueOf(this.bgR));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.bgM > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.bgM > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.bgM));
                                sb.append(this.bgL.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bgY != null) {
                                sb.append(this.bgY);
                            } else {
                                sb.append(this.bgL.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bgN > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bgN > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bgN));
                                sb2.append(this.bgL.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bgZ != null) {
                                sb2.append(this.bgZ);
                            } else {
                                sb2.append(this.bgL.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bgQ > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bgQ > 1) {
                                sb3.append(String.format(this.bgL.getString(d.j.notify_fans_unit), Integer.valueOf(this.bgQ)));
                            }
                            sb3.append(this.bgL.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Hq = (!b.GC().GR() || b.GC().GF() <= 0) ? 0 : eVar.Hq() - eVar.Hx();
                        long HI = (!b.GC().GK() || b.GC().GF() <= 0) ? 0L : eVar.HI();
                        boolean z4 = HI > 0;
                        long j = Hq + HI;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.bgL.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.HL();
                            eVar.HJ();
                            if (HI == 1) {
                                HA = eVar.HL();
                                str = eVar.HJ();
                                Hz = HA + "：" + str;
                            } else if (Hq == 1) {
                                HA = eVar.HA();
                                Hz = eVar.Hz();
                                str = Hz;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.bgL.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Hz)) {
                                Hz = str;
                            }
                            a(16, HA, str, Hz, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> HS = eVar.HS();
                        if (HS != null && HS.size() != 0) {
                            for (e.b bVar : HS) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.biw != 0 && bVar.unReadCount > bVar.bix) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> HT = eVar.HT();
                        if (HT != null && HT.size() != 0) {
                            for (e.a aVar : HT) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.biw != 0 && aVar.unReadCount > aVar.bix) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.GC().GR() && b.GC().GF() > 0) {
                        if (eVar.Hr() + eVar.Ht() > 0) {
                            if (eVar.Hr() > 0 && !Go()) {
                                long Hr = eVar.Hr() - eVar.Hs();
                                if (Hr > 0) {
                                    stringBuffer.append(String.format(this.bgL.getString(d.j.notify_updates), Long.valueOf(Hr)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Hs() > 0) {
                                    z = true;
                                }
                                if (eVar.Ht() > 0 || Gn()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.bgL.getString(d.j.notify_validate), Integer.valueOf(eVar.Ht())));
                                } else {
                                    stringBuffer.append(String.format(this.bgL.getString(d.j.notify_validate_1), Integer.valueOf(eVar.Ht())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.HC(), eVar.HD(), eVar.HD());
                                }
                            }
                            z = false;
                            if (eVar.Ht() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.HM() > 0 && !Gp()) {
                            String format2 = String.format(this.bgL.getString(d.j.notify_live), Integer.valueOf(eVar.HM()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.bgL, 16);
                    NotificationHelper.cancelNotification(this.bgL, 17);
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
            PendingIntent service = PendingIntent.getService(this.bgL, bVar.biw, a, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgL, i, bVar.title, bVar.content, bVar.biy, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgL, aVar.biw, a, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgL, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        if (this.bgX) {
            if (i == 23 && this.bgR > 0) {
                r = gO(i);
            } else if (i == 26 && this.bgQ > 0) {
                r = gP(i);
            } else if (i == 18) {
                r = Gi();
            } else {
                r = r(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            r.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgL, i, r, 134217728);
            aE(gS(i), i);
            NotificationHelper.showNotification(this.bgL, i, str, str2, str3, service, false);
        }
    }

    public Intent gO(int i) {
        Intent intent = new Intent(this.bgL, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bgR);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent gP(int i) {
        Intent intent = new Intent(this.bgL, DealIntentService.class);
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
        ImMessageCenterPojo am = com.baidu.tieba.im.memorycache.b.aIV().am(bVar.biw + "", bVar.userType);
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
                    Intent intent = new Intent(this.bgL, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", bVar.biw);
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
        Intent intent = new Intent(this.bgL, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.biw);
        intent.putExtra("uname", bVar.biz);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.bgL, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.biw));
        return intent;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bgU.HK().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.bgL, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.bgN);
        intent.putExtra("reply_me", this.bgM);
        intent.putExtra("fans", this.bgQ);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bgU.Hq() - this.bgU.Hx());
        intent.putExtra("group_msg_validate", this.bgU.Ht());
        intent.putExtra("group_msg_updates", this.bgU.Hr());
        intent.putExtra("live_notify_msg_updates", this.bgU.HM());
        intent.putExtra("officialbar_msg", this.bgU.Hu());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Gi() {
        Intent intent = new Intent(this.bgL, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bgU.Hs());
        return intent;
    }

    public void Gj() {
        NotificationHelper.cancelNotification(this.bgL, 23);
        NotificationHelper.cancelNotification(this.bgL, 24);
        NotificationHelper.cancelNotification(this.bgL, 25);
        NotificationHelper.cancelNotification(this.bgL, 26);
        NotificationHelper.cancelNotification(this.bgL, 17);
        NotificationHelper.cancelNotification(this.bgL, 15);
        NotificationHelper.cancelNotification(this.bgL, 13);
        NotificationHelper.cancelNotification(this.bgL, 12);
    }

    public void Gk() {
        NotificationHelper.cancelNotification(this.bgL, 16);
    }

    public void Gl() {
        NotificationHelper.cancelNotification(this.bgL, 19);
    }

    public void gQ(int i) {
        NotificationHelper.cancelNotification(this.bgL, i);
    }

    public int Gm() {
        return this.bgU.HP();
    }

    public void eV(String str) {
        if (TextUtils.isEmpty(str)) {
            Gk();
            return;
        }
        e GA = GA();
        if (GA == null) {
            Gk();
            return;
        }
        HashMap<String, String> HE = GA.HE();
        if (HE == null || HE.isEmpty()) {
            Gk();
        } else if (HE.containsKey(str)) {
            Gk();
        }
    }

    public void eW(String str) {
        if (TextUtils.isEmpty(str)) {
            Gk();
            return;
        }
        e GA = GA();
        if (GA == null) {
            Gk();
            return;
        }
        HashMap<String, String> HK = GA.HK();
        if (HK == null || HK.isEmpty()) {
            Gk();
        } else if (HK.containsKey(str)) {
            Gk();
        }
    }

    private boolean Gn() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Go() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean Gp() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void Gq() {
        NotificationHelper.cancelNotification(this.bgL, 17);
    }

    public void gR(int i) {
        e GA = GA();
        if (GA == null) {
            Gq();
        } else if (1 == i) {
            if (GA.Hr() <= 0) {
                Gq();
            }
        } else if (2 == i) {
            if (GA.Ht() <= 0) {
                Gq();
            }
        } else if (3 == i && GA.HM() <= 0) {
            NotificationHelper.cancelNotification(this.bgL, 21);
        }
    }

    public void Gr() {
        NotificationHelper.cancelNotification(this.bgL, 18);
    }

    public void Gs() {
        NotificationHelper.cancelNotification(this.bgL, 26);
        NotificationHelper.cancelNotification(this.bgL, 25);
        NotificationHelper.cancelNotification(this.bgL, 24);
        NotificationHelper.cancelNotification(this.bgL, 23);
        NotificationHelper.cancelNotification(this.bgL, 16);
        NotificationHelper.cancelNotification(this.bgL, 17);
    }

    public void Gt() {
        NotificationHelper.cancelNotification(this.bgL, 21);
        NotificationHelper.cancelNotification(this.bgL, 17);
        NotificationHelper.cancelNotification(this.bgL, 19);
        NotificationHelper.cancelNotification(this.bgL, 16);
        NotificationHelper.cancelNotification(this.bgL, 18);
    }

    public void Gu() {
        NotificationHelper.cancelNotification(this.bgL, 24);
    }

    public void Gv() {
        NotificationHelper.cancelNotification(this.bgL, 25);
    }

    public void Gw() {
        NotificationHelper.cancelNotification(this.bgL, 23);
    }

    public void Gx() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Gy());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.bgU.HI());
        newsNotifyMessage.setMsgStrangerChat(this.bgU.HP());
        newsNotifyMessage.setMsgOfficialMerge(this.bgU.HO());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.HI() + eVar.Hq()) + eVar.HP()) + eVar.HO()) + eVar.HU()) - eVar.Hx());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.HI());
            newsNotifyMessage.setMsgStrangerChat(eVar.HP());
            newsNotifyMessage.setMsgOfficialMerge(eVar.HO());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bgM;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.bgN, this.bgO, this.bgQ, this.bgP, this.bgR);
        }
    }

    public int getMsgAtme() {
        return this.bgN;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.bgM, i, this.bgO, this.bgQ, this.bgP, this.bgR);
        }
    }

    public int getMsgChat() {
        return this.bgO;
    }

    public int Gy() {
        return ((((this.bgU.HI() + this.bgU.Hq()) + this.bgU.HP()) + this.bgU.HO()) + this.bgU.HU()) - this.bgU.Hx();
    }

    public int getMsgFans() {
        return this.bgQ;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.bgM, this.bgN, this.bgO, i, this.bgP, this.bgR);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.bgM, this.bgN, i, this.bgQ, this.bgP, this.bgR);
        }
    }

    public int getMsgBookmark() {
        return this.bgP;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.bgM, this.bgN, this.bgO, this.bgQ, i, this.bgR);
        }
    }

    public int getMsgGiftNum() {
        return this.bgR;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bgR = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.bgS = i;
            Gx();
        }
    }

    public int getMsgLiveVip() {
        return this.bgS;
    }

    public void by(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.bgM = 0;
        this.bgN = 0;
        this.bgO = 0;
        this.bgQ = 0;
        this.bgP = 0;
    }

    public int Gz() {
        return this.bgM + this.bgN + this.bgO + this.bgQ + this.bgR;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bgU = eVar;
            this.bgO = (eVar.Hq() - eVar.Hx()) + eVar.HI() + eVar.HO() + eVar.HU();
            a(eVar);
            if (eVar.Hy()) {
                this.bgV = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Hy()) {
                if (b.GC().GR() && b.GC().GF() > 0) {
                    i = eVar.Hq() - eVar.Hx();
                }
                long HI = (!b.GC().GK() || b.GC().GF() <= 0) ? 0L : eVar.HI();
                if ((i > 0 || HI > 0) && ((i > eVar.HB() - eVar.Hx() && i > 0) || HI > eVar.Hv())) {
                    a(1, 16, eVar);
                }
                int Hu = eVar.Hu();
                if (Hu > 0 && Hu > eVar.HH()) {
                    a(1, 19, eVar);
                }
                if (eVar.Hr() > eVar.HF() || eVar.Ht() > eVar.HG()) {
                    if (eVar.Hr() <= eVar.HF() || eVar.Ht() != eVar.HG() || !Go()) {
                        if (eVar.Hr() != eVar.HF() || eVar.Ht() <= eVar.HG() || !Gn()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.HM() > eVar.HN() && !Gp()) {
                    a(1, 21, eVar);
                }
                if (eVar.HQ() > eVar.HR()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e GA() {
        return this.bgU;
    }

    public void c(e eVar) {
        this.bgU = eVar;
    }

    public e GB() {
        return this.bgV;
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
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgL, 26, i2);
        }
    }
}
