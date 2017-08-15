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
    private static a ata;
    private static Date atd = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.yZ().b(a.yZ().zv());
            }
        }
    };
    private e atc;
    private String atf;
    private String atg;
    private int asT = 0;
    private int asU = 0;
    private int asV = 0;
    private int asW = 0;
    private int asX = 0;
    private int asY = 0;
    private int asZ = 0;
    private e atb = new e();
    private boolean ate = true;
    private final int[] ath = new int[10];
    private final Context asS = TbadkCoreApplication.getInst().getApp();

    public static a yZ() {
        if (ata == null) {
            ata = new a();
        }
        return ata;
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
                    this.atf = optString;
                } else if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.atf = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.atg = optString2;
                }
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10 = 2;
        if (i != this.asT || i2 != this.asU || i3 != this.asV || i4 != this.asX || i5 != this.asW || i6 != this.asY) {
            if (i > this.asT || i2 > this.asU || i3 > this.asV || i4 > this.asX || i5 > this.asW || i6 > this.asY) {
                i7 = 1;
            } else {
                i7 = (i < this.asT || i2 < this.asU) ? 2 : 0;
            }
            if (i > this.asT) {
                i8 = 1;
            } else {
                i8 = i < this.asT ? 2 : 0;
            }
            if (i2 > this.asU) {
                i9 = 1;
            } else {
                i9 = i2 < this.asU ? 2 : 0;
            }
            int i11 = i3 > this.asV ? 1 : 0;
            int i12 = i4 > this.asX ? 1 : 0;
            int i13 = i6 <= this.asY ? 0 : 1;
            this.asT = i;
            this.asU = i2;
            this.asV = i3;
            this.asX = i4;
            this.asW = i5;
            this.asY = i6;
            if (zt() <= 0) {
                i12 = 2;
                i11 = 2;
                i9 = 2;
                i8 = 2;
                i7 = 2;
            } else {
                i10 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                zr();
                F(i10, 23);
                F(i11, 16);
                F(i7, 17);
                F(i8, 24);
                F(i9, 25);
                F(i12, 26);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (i != this.asT || i2 != this.asU || i3 != this.asV || i4 != this.asX || this.asY != i5) {
            this.asT = i;
            this.asU = i2;
            this.asV = i3;
            this.asX = i4;
            this.asY = i5;
            zr();
            if (zt() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean za() {
        if (atd == null) {
            atd = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - atd.getTime() < 10000) {
                return false;
            }
            atd = date;
        }
        return true;
    }

    public static boolean zb() {
        if (b.zw().zH()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = b.zw().zJ().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = b.zw().zK().split(":");
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
                    if (this.asY > 0) {
                        String format = String.format(this.asS.getString(d.l.notify_gift), String.valueOf(this.asY));
                        a(23, null, format, format);
                    }
                } else if (i2 == 24) {
                    if (this.asT > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.asT > 1) {
                            sb.append("[");
                            sb.append(String.valueOf(this.asT));
                            sb.append(this.asS.getString(d.l.notify_unit));
                            sb.append("]");
                        }
                        if (this.atf != null) {
                            sb.append(this.atf);
                        } else {
                            sb.append(this.asS.getString(d.l.notify_reply));
                        }
                        a(24, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 25) {
                    if (this.asU > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.asU > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.asU));
                            sb2.append(this.asS.getString(d.l.notify_unit));
                            sb2.append("]");
                        }
                        if (this.atg != null) {
                            sb2.append(this.atg);
                        } else {
                            sb2.append(this.asS.getString(d.l.notify_at));
                        }
                        a(25, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 26) {
                    if (this.asX > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.asX > 1) {
                            sb3.append(String.format(this.asS.getString(d.l.notify_fans_unit), Integer.valueOf(this.asX)));
                        }
                        sb3.append(this.asS.getString(d.l.notify_fans));
                        a(26, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 16 || !b.zw().zL() || b.zw().zz() <= 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.asS, 16);
                NotificationHelper.cancelNotification(this.asS, 17);
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
        String As;
        String Ar;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.asY > 0) {
                            String format = String.format(this.asS.getString(d.l.notify_gift), String.valueOf(this.asY));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 24) {
                        if (this.asT > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.asT > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.asT));
                                sb.append(this.asS.getString(d.l.notify_unit));
                                sb.append("]");
                            }
                            if (this.atf != null) {
                                sb.append(this.atf);
                            } else {
                                sb.append(this.asS.getString(d.l.notify_reply));
                            }
                            a(24, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.asU > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.asU > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.asU));
                                sb2.append(this.asS.getString(d.l.notify_unit));
                                sb2.append("]");
                            }
                            if (this.atg != null) {
                                sb2.append(this.atg);
                            } else {
                                sb2.append(this.asS.getString(d.l.notify_at));
                            }
                            a(25, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.asX > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.asX > 1) {
                                sb3.append(String.format(this.asS.getString(d.l.notify_fans_unit), Integer.valueOf(this.asX)));
                            }
                            sb3.append(this.asS.getString(d.l.notify_fans));
                            a(26, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 16) {
                        int Ai = (!b.zw().zL() || b.zw().zz() <= 0) ? 0 : eVar.Ai() - eVar.Ap();
                        long AA = (!b.zw().zE() || b.zw().zz() <= 0) ? 0L : eVar.AA();
                        boolean z4 = AA > 0;
                        long j = Ai + AA;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.asS.getString(d.l.notify_chat), Long.valueOf(j)));
                            c(16, (String) null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.AD();
                            eVar.AB();
                            if (AA == 1) {
                                As = eVar.AD();
                                str = eVar.AB();
                                Ar = As + "：" + str;
                            } else if (Ai == 1) {
                                As = eVar.As();
                                Ar = eVar.Ar();
                                str = Ar;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.asS.getString(d.l.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ar)) {
                                Ar = str;
                            }
                            c(16, As, str, Ar, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.b> AK = eVar.AK();
                        if (AK != null && AK.size() != 0) {
                            for (e.b bVar : AK) {
                                if (bVar != null && !StringUtils.isNull(bVar.content) && bVar.auz != 0 && bVar.unReadCount > bVar.auA) {
                                    a(bVar, 19);
                                }
                            }
                        }
                    } else if (i2 == 27) {
                        List<e.a> AL = eVar.AL();
                        if (AL != null && AL.size() != 0) {
                            for (e.a aVar : AL) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && aVar.auz != 0 && aVar.unReadCount > aVar.auA) {
                                    a(aVar, 27);
                                }
                            }
                        }
                    } else if (b.zw().zL() && b.zw().zz() > 0) {
                        if (eVar.Aj() + eVar.Al() > 0) {
                            if (eVar.Aj() > 0 && !zi()) {
                                long Aj = eVar.Aj() - eVar.Ak();
                                if (Aj > 0) {
                                    stringBuffer.append(String.format(this.asS.getString(d.l.notify_updates), Long.valueOf(Aj)));
                                    z = false;
                                    z2 = true;
                                } else if (eVar.Ak() > 0) {
                                    z = true;
                                }
                                if (eVar.Al() > 0 || zh()) {
                                    z3 = z2;
                                } else if (!z2) {
                                    stringBuffer.append(String.format(this.asS.getString(d.l.notify_validate), Integer.valueOf(eVar.Al())));
                                } else {
                                    stringBuffer.append(String.format(this.asS.getString(d.l.notify_validate_1), Integer.valueOf(eVar.Al())));
                                }
                                if (z3) {
                                    a(17, null, stringBuffer.toString(), stringBuffer.toString());
                                }
                                if (z) {
                                    a(18, eVar.Au(), eVar.Av(), eVar.Av());
                                }
                            }
                            z = false;
                            if (eVar.Al() > 0) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (z) {
                            }
                        }
                        if (eVar.AE() > 0 && !zj()) {
                            String format2 = String.format(this.asS.getString(d.l.notify_live), Integer.valueOf(eVar.AE()));
                            a(21, null, format2, format2);
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.asS, 16);
                    NotificationHelper.cancelNotification(this.asS, 17);
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
            PendingIntent service = PendingIntent.getService(this.asS, bVar.auz, a, 134217728);
            G(dM(i), i);
            NotificationHelper.showNotification(this.asS, i, bVar.title, bVar.content, bVar.auB, service, false);
        }
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asS, aVar.auz, a, 134217728);
            G(dM(i), i);
            NotificationHelper.showNotification(this.asS, i, aVar.title, aVar.content, aVar.title, service, false);
        }
    }

    private void c(int i, String str, String str2, String str3, boolean z) {
        Intent i2;
        if (this.ate) {
            if (i == 23 && this.asY > 0) {
                i2 = dI(i);
            } else if (i == 26 && this.asX > 0) {
                i2 = dJ(i);
            } else if (i == 18) {
                i2 = zc();
            } else {
                i2 = i(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            i2.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.asS, i, i2, 134217728);
            G(dM(i), i);
            NotificationHelper.showNotification(this.asS, i, str, str2, str3, service, false);
        }
    }

    public Intent dI(int i) {
        Intent intent = new Intent(this.asS, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.asY);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dJ(int i) {
        Intent intent = new Intent(this.asS, DealIntentService.class);
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
        ImMessageCenterPojo aa = com.baidu.tieba.im.memorycache.b.axf().aa(bVar.auz + "", bVar.userType);
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
                    Intent intent = new Intent(this.asS, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("gid", bVar.auz);
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
        Intent intent = new Intent(this.asS, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra(SapiAccountManager.SESSION_UID, bVar.auz);
        intent.putExtra("uname", bVar.auC);
        intent.putExtra("user_type", bVar.userType);
        return intent;
    }

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.asS, DealIntentService.class);
        intent.putExtra("class", 17);
        intent.putExtra(InviteFriendListActivityConfig.GROUP_ID, String.valueOf(aVar.auz));
        return intent;
    }

    public Intent i(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.atb.AC().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.asS, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra(AddFriendActivityConfig.TYPE_AT_ME, this.asU);
        intent.putExtra("reply_me", this.asT);
        intent.putExtra("fans", this.asX);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.atb.Ai() - this.atb.Ap());
        intent.putExtra("group_msg_validate", this.atb.Al());
        intent.putExtra("group_msg_updates", this.atb.Aj());
        intent.putExtra("live_notify_msg_updates", this.atb.AE());
        intent.putExtra("officialbar_msg", this.atb.Am());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent zc() {
        Intent intent = new Intent(this.asS, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.atb.Ak());
        return intent;
    }

    public void zd() {
        NotificationHelper.cancelNotification(this.asS, 23);
        NotificationHelper.cancelNotification(this.asS, 24);
        NotificationHelper.cancelNotification(this.asS, 25);
        NotificationHelper.cancelNotification(this.asS, 26);
        NotificationHelper.cancelNotification(this.asS, 17);
        NotificationHelper.cancelNotification(this.asS, 15);
        NotificationHelper.cancelNotification(this.asS, 13);
        NotificationHelper.cancelNotification(this.asS, 12);
    }

    public void ze() {
        NotificationHelper.cancelNotification(this.asS, 16);
    }

    public void zf() {
        NotificationHelper.cancelNotification(this.asS, 19);
    }

    public void dK(int i) {
        NotificationHelper.cancelNotification(this.asS, i);
    }

    public int zg() {
        return this.atb.AH();
    }

    public void eM(String str) {
        if (TextUtils.isEmpty(str)) {
            ze();
            return;
        }
        e zu = zu();
        if (zu == null) {
            ze();
            return;
        }
        HashMap<String, String> Aw = zu.Aw();
        if (Aw == null || Aw.isEmpty()) {
            ze();
        } else if (Aw.containsKey(str)) {
            ze();
        }
    }

    public void eN(String str) {
        if (TextUtils.isEmpty(str)) {
            ze();
            return;
        }
        e zu = zu();
        if (zu == null) {
            ze();
            return;
        }
        HashMap<String, String> AC = zu.AC();
        if (AC == null || AC.isEmpty()) {
            ze();
        } else if (AC.containsKey(str)) {
            ze();
        }
    }

    private boolean zh() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean zi() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    private boolean zj() {
        return ChatStatusManager.getInst().getIsOpen(8);
    }

    public void zk() {
        NotificationHelper.cancelNotification(this.asS, 17);
    }

    public void dL(int i) {
        e zu = zu();
        if (zu == null) {
            zk();
        } else if (1 == i) {
            if (zu.Aj() <= 0) {
                zk();
            }
        } else if (2 == i) {
            if (zu.Al() <= 0) {
                zk();
            }
        } else if (3 == i && zu.AE() <= 0) {
            NotificationHelper.cancelNotification(this.asS, 21);
        }
    }

    public void zl() {
        NotificationHelper.cancelNotification(this.asS, 18);
    }

    public void zm() {
        NotificationHelper.cancelNotification(this.asS, 26);
        NotificationHelper.cancelNotification(this.asS, 25);
        NotificationHelper.cancelNotification(this.asS, 24);
        NotificationHelper.cancelNotification(this.asS, 23);
        NotificationHelper.cancelNotification(this.asS, 16);
        NotificationHelper.cancelNotification(this.asS, 17);
    }

    public void zn() {
        NotificationHelper.cancelNotification(this.asS, 21);
        NotificationHelper.cancelNotification(this.asS, 17);
        NotificationHelper.cancelNotification(this.asS, 19);
        NotificationHelper.cancelNotification(this.asS, 16);
        NotificationHelper.cancelNotification(this.asS, 18);
    }

    public void zo() {
        NotificationHelper.cancelNotification(this.asS, 24);
    }

    public void zp() {
        NotificationHelper.cancelNotification(this.asS, 25);
    }

    public void zq() {
        NotificationHelper.cancelNotification(this.asS, 23);
    }

    public void zr() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(zs());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
        newsNotifyMessage.setMsgPrivateChat(this.atb.AA());
        newsNotifyMessage.setMsgStrangerChat(this.atb.AH());
        newsNotifyMessage.setMsgOfficialMerge(this.atb.AG());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.AA() + eVar.Ai()) + eVar.AH()) + eVar.AG()) + eVar.AM()) - eVar.Ap());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgLiveVip(getMsgLiveVip());
            newsNotifyMessage.setMsgPrivateChat(eVar.AA());
            newsNotifyMessage.setMsgStrangerChat(eVar.AH());
            newsNotifyMessage.setMsgOfficialMerge(eVar.AG());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.asT;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            c(i, this.asU, this.asV, this.asX, this.asW, this.asY);
        }
    }

    public int getMsgAtme() {
        return this.asU;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            c(this.asT, i, this.asV, this.asX, this.asW, this.asY);
        }
    }

    public int getMsgChat() {
        return this.asV;
    }

    public int zs() {
        return ((((this.atb.AA() + this.atb.Ai()) + this.atb.AH()) + this.atb.AG()) + this.atb.AM()) - this.atb.Ap();
    }

    public int getMsgFans() {
        return this.asX;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            c(this.asT, this.asU, this.asV, i, this.asW, this.asY);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            c(this.asT, this.asU, i, this.asX, this.asW, this.asY);
        }
    }

    public int getMsgBookmark() {
        return this.asW;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            c(this.asT, this.asU, this.asV, this.asX, i, this.asY);
        }
    }

    public int getMsgGiftNum() {
        return this.asY;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.asY = i;
        }
    }

    public void setMsgLiveVip(int i) {
        if (i >= 0) {
            this.asZ = i;
            zr();
        }
    }

    public int getMsgLiveVip() {
        return this.asZ;
    }

    public void aU(boolean z) {
        if (z) {
            c(0, 0, 0, 0, 0, 0);
            return;
        }
        this.asT = 0;
        this.asU = 0;
        this.asV = 0;
        this.asX = 0;
        this.asW = 0;
    }

    public int zt() {
        return this.asT + this.asU + this.asV + this.asX + this.asY;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.atb = eVar;
            this.asV = (eVar.Ai() - eVar.Ap()) + eVar.AA() + eVar.AG() + eVar.AM();
            a(eVar);
            if (eVar.Aq()) {
                this.atc = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Aq()) {
                if (b.zw().zL() && b.zw().zz() > 0) {
                    i = eVar.Ai() - eVar.Ap();
                }
                long AA = (!b.zw().zE() || b.zw().zz() <= 0) ? 0L : eVar.AA();
                if ((i > 0 || AA > 0) && ((i > eVar.At() - eVar.Ap() && i > 0) || AA > eVar.An())) {
                    a(1, 16, eVar);
                }
                int Am = eVar.Am();
                if (Am > 0 && Am > eVar.Az()) {
                    a(1, 19, eVar);
                }
                if (eVar.Aj() > eVar.Ax() || eVar.Al() > eVar.Ay()) {
                    if (eVar.Aj() <= eVar.Ax() || eVar.Al() != eVar.Ay() || !zi()) {
                        if (eVar.Aj() != eVar.Ax() || eVar.Al() <= eVar.Ay() || !zh()) {
                            a(1, 17, eVar);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (eVar.AE() > eVar.AF() && !zj()) {
                    a(1, 21, eVar);
                }
                if (eVar.AI() > eVar.AJ()) {
                    a(1, 27, eVar);
                }
            }
        }
    }

    public e zu() {
        return this.atb;
    }

    public void c(e eVar) {
        this.atb = eVar;
    }

    public e zv() {
        return this.atc;
    }

    public int dM(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 20, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 21, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 22, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 27, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.asS, 26, i2);
        }
    }
}
