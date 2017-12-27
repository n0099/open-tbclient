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
    private static a bgC;
    private static Date bgF = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Gm().b(a.Gm().GI());
            }
        }
    };
    private e bgE;
    private String bgH;
    private String bgI;
    private int bgv = 0;
    private int bgw = 0;
    private int bgx = 0;
    private int bgy = 0;
    private int bgz = 0;
    private int bgA = 0;
    private int bgB = 0;
    private e bgD = new e();
    private boolean bgG = true;
    private final int[] bgJ = new int[10];
    private final Context bgu = TbadkCoreApplication.getInst().getApp();

    public static a Gm() {
        if (bgC == null) {
            bgC = new a();
        }
        return bgC;
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
                    this.bgH = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bgH = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bgI = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.bgv || i2 != this.bgw || i3 != this.bgx || i4 != this.bgz || i5 != this.bgy || i6 != this.bgA) {
            if (i > this.bgv || i2 > this.bgw || i3 > this.bgx || i4 > this.bgz || i5 > this.bgy || i6 > this.bgA) {
                i7 = 1;
            } else {
                i7 = (i < this.bgv || i2 < this.bgw) ? 2 : 0;
            }
            if (i > this.bgv) {
                i8 = 1;
            } else {
                i8 = i < this.bgv ? 2 : 0;
            }
            if (i2 > this.bgw) {
                i9 = 1;
            } else {
                i9 = i2 < this.bgw ? 2 : 0;
            }
            int i11 = i3 > this.bgx ? 1 : 0;
            int i12 = i4 > this.bgz ? 1 : 0;
            int i13 = i6 <= this.bgA ? 0 : 1;
            this.bgv = i;
            this.bgw = i2;
            this.bgx = i3;
            this.bgz = i4;
            this.bgy = i5;
            this.bgA = i6;
            if (GG() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                GE();
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
        if (i != this.bgv || i2 != this.bgw || i3 != this.bgx || i4 != this.bgz || this.bgA != i5) {
            this.bgv = i;
            this.bgw = i2;
            this.bgx = i3;
            this.bgz = i4;
            this.bgA = i5;
            GE();
            if (GG() <= 0) {
                aD(2, 16);
                aD(2, 17);
            }
        }
    }

    public static boolean Gn() {
        if (bgF == null) {
            bgF = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bgF.getTime() < 10000) {
                return false;
            }
            bgF = date;
        }
        return true;
    }

    public static boolean Go() {
        if (b.GJ().GU()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.GJ().GW().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.GJ().GX().split(":");
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
                    if (this.bgA > 0) {
                        String format = String.format(this.bgu.getString(d.j.notify_gift), String.valueOf(this.bgA));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.bgv > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.bgv > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.bgv));
                            sb.append(this.bgu.getString(d.j.notify_unit));
                            sb.append("]");
                        }
                        if (this.bgH != null) {
                            sb.append(this.bgH);
                        } else {
                            sb.append(this.bgu.getString(d.j.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bgw > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bgw > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bgw));
                            sb2.append(this.bgu.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bgI != null) {
                            sb2.append(this.bgI);
                        } else {
                            sb2.append(this.bgu.getString(d.j.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bgz > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.format(this.bgu.getString(d.j.notify_fans), Integer.valueOf(this.bgz)));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.GJ().GY() || b.GJ().GM() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.bgu, 16);
                NotificationHelper.cancelNotification(this.bgu, 17);
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
        String HH;
        String HG;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bgA > 0) {
                            String format = String.format(this.bgu.getString(d.j.notify_gift), String.valueOf(this.bgA));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.bgv > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.bgv > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.bgv));
                                sb.append(this.bgu.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bgH != null) {
                                sb.append(this.bgH);
                            } else {
                                sb.append(this.bgu.getString(d.j.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bgw > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bgw > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bgw));
                                sb2.append(this.bgu.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bgI != null) {
                                sb2.append(this.bgI);
                            } else {
                                sb2.append(this.bgu.getString(d.j.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bgz > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bgz > 1) {
                                sb3.append(String.format(this.bgu.getString(d.j.notify_fans_unit), Integer.valueOf(this.bgz)));
                            }
                            sb3.append(this.bgu.getString(d.j.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Hx = (!b.GJ().GY() || b.GJ().GM() <= 0) ? 0 : eVar.Hx() - eVar.HE();
                        long HP = (!b.GJ().GR() || b.GJ().GM() <= 0) ? 0L : eVar.HP();
                        boolean z4 = HP > 0;
                        long j = Hx + HP;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.bgu.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.HS();
                            eVar.HQ();
                            if (HP == 1) {
                                HH = eVar.HS();
                                str = eVar.HQ();
                                HG = HH + "：" + str;
                            } else if (Hx == 1) {
                                HH = eVar.HH();
                                HG = eVar.HG();
                                str = HG;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.bgu.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(HG)) {
                                HG = str;
                            }
                            a(16, HH, str, HG, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> HZ = eVar.HZ();
                        if (HZ != null && HZ.size() != 0) {
                            for (e.b bVar : HZ) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.bie != 0 && bVar.unReadCount > bVar.bif) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> Ia = eVar.Ia();
                        if (Ia != null && Ia.size() != 0) {
                            for (e.a aVar : Ia) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.bie != 0 && aVar.unReadCount > aVar.bif) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.GJ().GY() && b.GJ().GM() > 0) {
                        if (eVar.Hy() + eVar.HA() > 0) {
                            if (eVar.Hy() > 0 && !Gv()) {
                                long Hy = eVar.Hy() - eVar.Hz();
                                if (Hy > 0) {
                                    stringBuffer.append(String.format(this.bgu.getString(d.j.notify_updates), Long.valueOf(Hy)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Hz() > 0) {
                                    z = true;
                                }
                                if (eVar.HA() > 0 || Gu()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.bgu.getString(d.j.notify_validate), Integer.valueOf(eVar.HA())));
                                } else {
                                    stringBuffer.append(String.format(this.bgu.getString(d.j.notify_validate_1), Integer.valueOf(eVar.HA())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.HJ(), eVar.HK(), eVar.HK());
                                }
                            }
                            z = false;
                            if (eVar.HA() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.HT() > 0 && !Gw()) {
                            String format2 = String.format(this.bgu.getString(d.j.notify_live), Integer.valueOf(eVar.HT()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.bgu, 16);
                    NotificationHelper.cancelNotification(this.bgu, 17);
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
            PendingIntent service = PendingIntent.getService(this.bgu, bVar.bie, a, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.bgu, i, bVar.title, bVar.content, bVar.bih, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgu, aVar.bie, a, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.bgu, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        if (this.bgG) {
            if (i == 23 && this.bgA > 0) {
                r = gR(i);
            } else if (i == 26 && this.bgz > 0) {
                r = gS(i);
            } else if (i == 18) {
                r = Gp();
            } else {
                r = r(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            r.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.bgu, i, r, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.bgu, i, str, str2, str3, service, false);
        }
    }

    public Intent gR(int i) {
        Intent intent = new Intent(this.bgu, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bgA);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent gS(int i) {
        Intent intent = new Intent(this.bgu, DealIntentService.class);
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
        ImMessageCenterPojo ak = com.baidu.tieba.im.memorycache.b.aIQ().ak(bVar.bie + "", bVar.userType);
        if (ak == null || ak.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(ak.getLastContentRawData());
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
                    Intent intent = new Intent(this.bgu, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", bVar.bie);
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
        Intent intent = new Intent(this.bgu, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", bVar.bie);
        intent.putExtra("uname", bVar.bii);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.bgu, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.bie));
        return intent;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bgD.HR().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.bgu, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("at_me", this.bgw);
        intent.putExtra("reply_me", this.bgv);
        intent.putExtra("fans", this.bgz);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bgD.Hx() - this.bgD.HE());
        intent.putExtra("group_msg_validate", this.bgD.HA());
        intent.putExtra("group_msg_updates", this.bgD.Hy());
        intent.putExtra("live_notify_msg_updates", this.bgD.HT());
        intent.putExtra("officialbar_msg", this.bgD.HB());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Gp() {
        Intent intent = new Intent(this.bgu, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bgD.Hz());
        return intent;
    }

    public void Gq() {
        NotificationHelper.cancelNotification(this.bgu, 23);
        NotificationHelper.cancelNotification(this.bgu, 24);
        NotificationHelper.cancelNotification(this.bgu, 25);
        NotificationHelper.cancelNotification(this.bgu, 26);
        NotificationHelper.cancelNotification(this.bgu, 17);
        NotificationHelper.cancelNotification(this.bgu, 15);
        NotificationHelper.cancelNotification(this.bgu, 13);
        NotificationHelper.cancelNotification(this.bgu, 12);
    }

    public void Gr() {
        NotificationHelper.cancelNotification(this.bgu, 16);
    }

    public void Gs() {
        NotificationHelper.cancelNotification(this.bgu, 19);
    }

    public void gT(int i) {
        NotificationHelper.cancelNotification(this.bgu, i);
    }

    public int Gt() {
        return this.bgD.HW();
    }

    public void eV(String str) {
        if (TextUtils.isEmpty(str)) {
            Gr();
            return;
        }
        e GH = GH();
        if (GH == null) {
            Gr();
            return;
        }
        HashMap<String, String> HL = GH.HL();
        if (HL == null || HL.isEmpty()) {
            Gr();
        } else if (HL.containsKey(str)) {
            Gr();
        }
    }

    public void eW(String str) {
        if (TextUtils.isEmpty(str)) {
            Gr();
            return;
        }
        e GH = GH();
        if (GH == null) {
            Gr();
            return;
        }
        HashMap<String, String> HR = GH.HR();
        if (HR == null || HR.isEmpty()) {
            Gr();
        } else if (HR.containsKey(str)) {
            Gr();
        }
    }

    private boolean Gu() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Gv() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean Gw() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void Gx() {
        NotificationHelper.cancelNotification(this.bgu, 17);
    }

    public void gU(int i) {
        e GH = GH();
        if (GH == null) {
            Gx();
        } else if (1 == i) {
            if (GH.Hy() <= 0) {
                Gx();
            }
        } else if (2 == i) {
            if (GH.HA() <= 0) {
                Gx();
            }
        } else if (3 == i && GH.HT() <= 0) {
            NotificationHelper.cancelNotification(this.bgu, 21);
        }
    }

    public void Gy() {
        NotificationHelper.cancelNotification(this.bgu, 18);
    }

    public void Gz() {
        NotificationHelper.cancelNotification(this.bgu, 26);
        NotificationHelper.cancelNotification(this.bgu, 25);
        NotificationHelper.cancelNotification(this.bgu, 24);
        NotificationHelper.cancelNotification(this.bgu, 23);
        NotificationHelper.cancelNotification(this.bgu, 16);
        NotificationHelper.cancelNotification(this.bgu, 17);
    }

    public void GA() {
        NotificationHelper.cancelNotification(this.bgu, 21);
        NotificationHelper.cancelNotification(this.bgu, 17);
        NotificationHelper.cancelNotification(this.bgu, 19);
        NotificationHelper.cancelNotification(this.bgu, 16);
        NotificationHelper.cancelNotification(this.bgu, 18);
    }

    public void GB() {
        NotificationHelper.cancelNotification(this.bgu, 24);
    }

    public void GC() {
        NotificationHelper.cancelNotification(this.bgu, 25);
    }

    public void GD() {
        NotificationHelper.cancelNotification(this.bgu, 23);
    }

    public void GE() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(GF());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.bgD.HP());
        newsNotifyMessage.setMsgStrangerChat(this.bgD.HW());
        newsNotifyMessage.setMsgOfficialMerge(this.bgD.HV());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.HP() + eVar.Hx()) + eVar.HW()) + eVar.HV()) + eVar.Ib()) - eVar.HE());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.HP());
            newsNotifyMessage.setMsgStrangerChat(eVar.HW());
            newsNotifyMessage.setMsgOfficialMerge(eVar.HV());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bgv;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.bgw, this.bgx, this.bgz, this.bgy, this.bgA);
        }
    }

    public int getMsgAtme() {
        return this.bgw;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.bgv, i, this.bgx, this.bgz, this.bgy, this.bgA);
        }
    }

    public int getMsgChat() {
        return this.bgx;
    }

    public int GF() {
        return ((((this.bgD.HP() + this.bgD.Hx()) + this.bgD.HW()) + this.bgD.HV()) + this.bgD.Ib()) - this.bgD.HE();
    }

    public int getMsgFans() {
        return this.bgz;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.bgv, this.bgw, this.bgx, i, this.bgy, this.bgA);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.bgv, this.bgw, i, this.bgz, this.bgy, this.bgA);
        }
    }

    public int getMsgBookmark() {
        return this.bgy;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.bgv, this.bgw, this.bgx, this.bgz, i, this.bgA);
        }
    }

    public int getMsgGiftNum() {
        return this.bgA;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bgA = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.bgB = i;
            GE();
        }
    }

    public int getMsgLiveVip() {
        return this.bgB;
    }

    public void by(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.bgv = 0;
        this.bgw = 0;
        this.bgx = 0;
        this.bgz = 0;
        this.bgy = 0;
    }

    public int GG() {
        return this.bgv + this.bgw + this.bgx + this.bgz + this.bgA;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bgD = eVar;
            this.bgx = (eVar.Hx() - eVar.HE()) + eVar.HP() + eVar.HV() + eVar.Ib();
            a(eVar);
            if (eVar.HF()) {
                this.bgE = null;
                mHandler.removeMessages(0);
            }
            if (eVar.HF()) {
                if (b.GJ().GY() && b.GJ().GM() > 0) {
                    i = eVar.Hx() - eVar.HE();
                }
                long HP = (!b.GJ().GR() || b.GJ().GM() <= 0) ? 0L : eVar.HP();
                if ((i > 0 || HP > 0) && ((i > eVar.HI() - eVar.HE() && i > 0) || HP > eVar.HC())) {
                    a(1, 16, eVar);
                }
                int HB = eVar.HB();
                if (HB > 0 && HB > eVar.HO()) {
                    a(1, 19, eVar);
                }
                if (eVar.Hy() > eVar.HM() || eVar.HA() > eVar.HN()) {
                    if (eVar.Hy() <= eVar.HM() || eVar.HA() != eVar.HN() || !Gv()) {
                        if (eVar.Hy() != eVar.HM() || eVar.HA() <= eVar.HN() || !Gu()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.HT() > eVar.HU() && !Gw()) {
                    a(1, 21, eVar);
                }
                if (eVar.HX() > eVar.HY()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e GH() {
        return this.bgD;
    }

    public void c(e eVar) {
        this.bgD = eVar;
    }

    public e GI() {
        return this.bgE;
    }

    public int gV(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.bgu, 26, i2);
        }
    }
}
