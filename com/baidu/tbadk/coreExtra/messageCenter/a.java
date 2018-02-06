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
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a bjg;
    private e bji;
    private String bjl;
    private String bjm;
    private String bjn;
    public static boolean biV = true;
    public static boolean biW = false;
    private static Date bjj = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.GJ().b(a.GJ().Hg());
            }
        }
    };
    private final HashMap<Integer, HashSet> biX = new HashMap<>();
    private int biZ = 0;
    private int bja = 0;
    private int bjb = 0;
    private int bjc = 0;
    private int bjd = 0;
    private int bje = 0;
    private int bjf = 0;
    private e bjh = new e();
    private boolean bjk = true;
    private final int[] bjo = new int[10];
    private final Context biY = TbadkCoreApplication.getInst().getApp();

    public static a GJ() {
        if (bjg == null) {
            bjg = new a();
        }
        return bjg;
    }

    private a() {
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.bjm = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bjl = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bjn = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.biZ || i2 != this.bja || i3 != this.bjb || i4 != this.bjc || i5 != this.bje || i6 != this.bjd || i7 != this.bjf) {
            int i8 = 0;
            if (i > this.biZ || i2 > this.bja || i3 > this.bjb || i4 > this.bjc || i5 > this.bje || i6 > this.bjd || i7 > this.bjf) {
                i8 = 1;
            } else if (i < this.biZ || i2 < this.bja || i3 < this.bjb) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.biZ && c.Hq().HG()) {
                i9 = 1;
            } else if (i < this.biZ) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.bja && c.Hq().Hx()) {
                i10 = 1;
            } else if (i2 < this.bja) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.bjb && c.Hq().Hv()) {
                i11 = 1;
            } else if (i3 < this.bjb) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.bjc) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.bje) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.bjf) {
                i14 = 1;
            }
            this.biZ = i;
            this.bja = i2;
            this.bjb = i3;
            this.bjc = i4;
            this.bje = i5;
            this.bjd = i6;
            this.bjf = i7;
            if (He() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Hb();
                aD(i14, 23);
                aD(i12, 16);
                aD(i8, 17);
                aD(i10, 24);
                aD(i11, 25);
                aD(i13, 26);
                aD(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.biZ || i2 != this.bja || i3 != this.bjb || i4 != this.bjc || i5 != this.bje || this.bjf != i6) {
            this.biZ = i;
            this.bja = i2;
            this.bjb = i3;
            this.bjc = i4;
            this.bje = i5;
            this.bjf = i6;
            Hb();
            if (He() <= 0) {
                aD(2, 16);
                aD(2, 17);
            }
        }
    }

    public static boolean GK() {
        if (bjj == null) {
            bjj = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bjj.getTime() < 10000) {
                return false;
            }
            bjj = date;
        }
        return true;
    }

    public static boolean GL() {
        if (c.Hq().HB()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Hq().HD().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Hq().HE().split(":");
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
                    if (this.bjf > 0) {
                        String format = String.format(this.biY.getString(d.j.notify_gift), String.valueOf(this.bjf));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.biZ > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.biY.getString(d.j.notify_agree), Integer.valueOf(this.biZ)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.bja > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bja > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bja));
                            sb2.append(this.biY.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bjm != null) {
                            sb2.append(this.bjm);
                        } else {
                            sb2.append(this.biY.getString(d.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bjb > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.bjb > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.bjb));
                            sb3.append(this.biY.getString(d.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.bjn != null) {
                            sb3.append(this.bjn);
                        } else {
                            sb3.append(this.biY.getString(d.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bje > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.biY.getString(d.j.notify_fans), Integer.valueOf(this.bje)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Hq().HF() || c.Hq().Ht() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.biY, 16);
                NotificationHelper.cancelNotification(this.biY, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x032f A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:109:0x02ae, B:111:0x02b8, B:113:0x02c2, B:115:0x02cd, B:117:0x02d3, B:119:0x02d9, B:121:0x02e7, B:122:0x0302, B:124:0x0308, B:127:0x0310, B:129:0x032f, B:131:0x033f, B:135:0x035a, B:132:0x0352, B:138:0x037b), top: B:145:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033f A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:109:0x02ae, B:111:0x02b8, B:113:0x02c2, B:115:0x02cd, B:117:0x02d3, B:119:0x02d9, B:121:0x02e7, B:122:0x0302, B:124:0x0308, B:127:0x0310, B:129:0x032f, B:131:0x033f, B:135:0x035a, B:132:0x0352, B:138:0x037b), top: B:145:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, e eVar) {
        boolean z;
        String In;
        String Im;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bjf > 0) {
                            String format = String.format(this.biY.getString(d.j.notify_gift), String.valueOf(this.bjf));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.biZ > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.biZ > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.biZ));
                                sb.append(this.biY.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bjl != null) {
                                sb.append(this.bjl);
                            } else {
                                sb.append(this.biY.getString(d.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.bja > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bja > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bja));
                                sb2.append(this.biY.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bjm != null) {
                                sb2.append(this.bjm);
                            } else {
                                sb2.append(this.biY.getString(d.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bjb > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bjb > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.bjb));
                                sb3.append(this.biY.getString(d.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.bjn != null) {
                                sb3.append(this.bjn);
                            } else {
                                sb3.append(this.biY.getString(d.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bje > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.bje > 1) {
                                sb4.append(String.format(this.biY.getString(d.j.notify_fans_unit), Integer.valueOf(this.bje)));
                            }
                            sb4.append(this.biY.getString(d.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int Id = (!c.Hq().HF() || c.Hq().Ht() <= 0) ? 0 : eVar.Id() - eVar.Ik();
                        long Iv = (!c.Hq().Hy() || c.Hq().Ht() <= 0) ? 0L : eVar.Iv();
                        boolean z4 = Iv > 0;
                        long j = Id + Iv;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.biY.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Iy();
                            eVar.Iw();
                            if (Iv == 1) {
                                In = eVar.Iy();
                                str = eVar.Iw();
                                Im = In + "：" + str;
                            } else if (Id == 1) {
                                In = eVar.In();
                                Im = eVar.Im();
                                str = Im;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.biY.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Im)) {
                                Im = str;
                            }
                            a(16, In, str, Im, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> IB = eVar.IB();
                        if (IB != null && IB.size() != 0) {
                            for (e.a aVar : IB) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !am.isEmpty(aVar.gid) && aVar.unReadCount > aVar.bkV && aVar.bkW == null) {
                                    a(aVar, 19);
                                }
                            }
                        }
                    } else if (c.Hq().HF() && c.Hq().Ht() > 0 && eVar.Ie() + eVar.Ig() > 0) {
                        if (eVar.Ie() > 0 && !GS()) {
                            long Ie = eVar.Ie() - eVar.If();
                            if (Ie > 0) {
                                stringBuffer.append(String.format(this.biY.getString(d.j.notify_updates), Long.valueOf(Ie)));
                                z = false;
                                z2 = true;
                            } else if (eVar.If() > 0) {
                                z = true;
                            }
                            if (eVar.Ig() > 0 || GR()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.biY.getString(d.j.notify_validate), Integer.valueOf(eVar.Ig())));
                            } else {
                                stringBuffer.append(String.format(this.biY.getString(d.j.notify_validate_1), Integer.valueOf(eVar.Ig())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.Ip(), eVar.Iq(), eVar.Iq());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.Ig() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.biY, 16);
                    NotificationHelper.cancelNotification(this.biY, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a == null) {
            a = b(aVar);
        }
        if (a == null) {
            a = d(aVar);
        }
        if (a == null) {
            a = c(aVar);
        }
        if (a != null) {
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.biY, 19, a, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.biY, i, aVar.title, aVar.content, aVar.bkT, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent w;
        if (this.bjk) {
            if (i == 23 && this.bjf > 0) {
                w = gQ(i);
            } else if (i == 26 && this.bje > 0) {
                w = gR(i);
            } else if (i == 18) {
                w = GM();
            } else if (i == 24) {
                w = w(i, z);
                w.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                w = w(i, z);
                w.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                w = w(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            w.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.biY, i, w, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.biY, i, str, str2, str3, service, false);
        }
    }

    public Intent gQ(int i) {
        Intent intent = new Intent(this.biY, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bjf);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent gR(int i) {
        Intent intent = new Intent(this.biY, DealIntentService.class);
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

    public Intent a(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(aVar.gid, aVar.userType);
        if (an == null || an.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(an.getLastContentRawData());
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
                    Intent intent = new Intent(this.biY, DealIntentService.class);
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", aVar.gid);
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

    public Intent b(e.a aVar) {
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(aVar.gid + "", aVar.userType);
        if (an == null || an.getLast_content() == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(an.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            if (optString.contains("mo/q/hotMessage")) {
                Intent intent = new Intent(this.biY, DealIntentService.class);
                intent.putExtra("class", 30);
                intent.putExtra("jump_url", optString);
                return intent;
            }
            return null;
        }
        return null;
    }

    public Intent c(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.biY, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.bkU);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.biY, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> Hh = Hh();
        String str = aVar.gid;
        if (Hh != null && !am.isEmpty(str)) {
            HashSet<String> Hi = Hi();
            HashSet<String> Hj = Hj();
            HashSet<String> Hk = Hk();
            if (Hi != null && Hi.contains(str)) {
                return b(aVar, 3);
            }
            if (Hj != null && Hj.contains(str)) {
                return b(aVar, 1);
            }
            if (Hk != null && Hk.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent w(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bjh.Ix().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.biY, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.biZ);
        intent.putExtra("at_me", this.bjb);
        intent.putExtra("reply_me", this.bja);
        intent.putExtra("fans", this.bje);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bjh.Id() - this.bjh.Ik());
        intent.putExtra("group_msg_validate", this.bjh.Ig());
        intent.putExtra("group_msg_updates", this.bjh.Ie());
        intent.putExtra("officialbar_msg", this.bjh.Ih());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent GM() {
        Intent intent = new Intent(this.biY, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bjh.If());
        return intent;
    }

    public void GN() {
        NotificationHelper.cancelNotification(this.biY, 23);
        NotificationHelper.cancelNotification(this.biY, 24);
        NotificationHelper.cancelNotification(this.biY, 25);
        NotificationHelper.cancelNotification(this.biY, 29);
        NotificationHelper.cancelNotification(this.biY, 26);
        NotificationHelper.cancelNotification(this.biY, 17);
        NotificationHelper.cancelNotification(this.biY, 15);
        NotificationHelper.cancelNotification(this.biY, 13);
        NotificationHelper.cancelNotification(this.biY, 12);
    }

    public void GO() {
        NotificationHelper.cancelNotification(this.biY, 16);
    }

    public void GP() {
        NotificationHelper.cancelNotification(this.biY, 19);
    }

    public void gS(int i) {
        NotificationHelper.cancelNotification(this.biY, i);
    }

    public int GQ() {
        return this.bjh.IA();
    }

    public void fo(String str) {
        if (TextUtils.isEmpty(str)) {
            GO();
            return;
        }
        e Hf = Hf();
        if (Hf == null) {
            GO();
            return;
        }
        HashMap<String, String> Ir = Hf.Ir();
        if (Ir == null || Ir.isEmpty()) {
            GO();
        } else if (Ir.containsKey(str)) {
            GO();
        }
    }

    public void fp(String str) {
        if (TextUtils.isEmpty(str)) {
            GO();
            return;
        }
        e Hf = Hf();
        if (Hf == null) {
            GO();
            return;
        }
        HashMap<String, String> Ix = Hf.Ix();
        if (Ix == null || Ix.isEmpty()) {
            GO();
        } else if (Ix.containsKey(str)) {
            GO();
        }
    }

    private boolean GR() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean GS() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void GT() {
        NotificationHelper.cancelNotification(this.biY, 17);
    }

    public void gT(int i) {
        e Hf = Hf();
        if (Hf == null) {
            GT();
        } else if (1 == i) {
            if (Hf.Ie() <= 0) {
                GT();
            }
        } else if (2 == i && Hf.Ig() <= 0) {
            GT();
        }
    }

    public void GU() {
        NotificationHelper.cancelNotification(this.biY, 18);
    }

    public void GV() {
        NotificationHelper.cancelNotification(this.biY, 26);
        NotificationHelper.cancelNotification(this.biY, 25);
        NotificationHelper.cancelNotification(this.biY, 24);
        NotificationHelper.cancelNotification(this.biY, 23);
        NotificationHelper.cancelNotification(this.biY, 16);
        NotificationHelper.cancelNotification(this.biY, 17);
        NotificationHelper.cancelNotification(this.biY, 29);
    }

    public void GW() {
        NotificationHelper.cancelNotification(this.biY, 17);
        NotificationHelper.cancelNotification(this.biY, 19);
        NotificationHelper.cancelNotification(this.biY, 16);
        NotificationHelper.cancelNotification(this.biY, 18);
    }

    public void GX() {
        NotificationHelper.cancelNotification(this.biY, 24);
    }

    public void GY() {
        NotificationHelper.cancelNotification(this.biY, 25);
    }

    public void GZ() {
        NotificationHelper.cancelNotification(this.biY, 29);
    }

    public void Ha() {
        NotificationHelper.cancelNotification(this.biY, 23);
    }

    public void Hb() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(Hc());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Hd());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.bjh.Iv());
        newsNotifyMessage.setMsgStrangerChat(this.bjh.IA());
        newsNotifyMessage.setMsgOfficialMerge(this.bjh.Iz());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(Hc());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Iv() + eVar.Id()) + eVar.IA()) + eVar.Iz()) + eVar.IC()) - eVar.Ik());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Iv());
            newsNotifyMessage.setMsgStrangerChat(eVar.IA());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Iz());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bja;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.biZ, i, this.bjb, this.bjc, this.bje, this.bjd, this.bjf);
        }
    }

    public int getMsgAtme() {
        return this.bjb;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.biZ, this.bja, i, this.bjc, this.bje, this.bjd, this.bjf);
        }
    }

    public int Hc() {
        return this.biZ;
    }

    public void gU(int i) {
        if (i >= 0) {
            a(i, this.bja, this.bjb, this.bjc, this.bje, this.bjd, this.bjf);
        }
    }

    public int getMsgChat() {
        return this.bjc;
    }

    public int Hd() {
        return ((((this.bjh.Iv() + this.bjh.Id()) + this.bjh.IA()) + this.bjh.Iz()) + this.bjh.IC()) - this.bjh.Ik();
    }

    public int getMsgFans() {
        return this.bje;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.biZ, this.bja, this.bjb, this.bjc, i, this.bjd, this.bjf);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.biZ, this.bja, this.bjb, i, this.bje, this.bjd, this.bjf);
        }
    }

    public int getMsgBookmark() {
        return this.bjd;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.biZ, this.bja, this.bjb, this.bjc, this.bje, i, this.bjf);
        }
    }

    public int getMsgGiftNum() {
        return this.bjf;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bjf = i;
        }
    }

    public void bE(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.biZ = 0;
        this.bja = 0;
        this.bjb = 0;
        this.bjc = 0;
        this.bje = 0;
        this.bjd = 0;
    }

    public int He() {
        return this.biZ + this.bja + this.bjb + this.bjc + this.bje + this.bjf;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bjh = eVar;
            this.bjc = (eVar.Id() - eVar.Ik()) + eVar.Iv() + eVar.Iz() + eVar.IC();
            a(eVar);
            if (eVar.Il()) {
                this.bji = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Il()) {
                if (c.Hq().HF() && c.Hq().Ht() > 0) {
                    i = eVar.Id() - eVar.Ik();
                }
                long Iv = (!c.Hq().Hy() || c.Hq().Ht() <= 0) ? 0L : eVar.Iv();
                if ((i > 0 || Iv > 0) && ((i > eVar.Io() - eVar.Ik() && i > 0) || Iv > eVar.Ii())) {
                    a(1, 16, eVar);
                }
                int Ih = eVar.Ih();
                if (Ih > 0 && Ih > eVar.Iu()) {
                    a(1, 19, eVar);
                }
                if (eVar.Ie() > eVar.Is() || eVar.Ig() > eVar.It()) {
                    if (eVar.Ie() <= eVar.Is() || eVar.Ig() != eVar.It() || !GS()) {
                        if (eVar.Ie() != eVar.Is() || eVar.Ig() <= eVar.It() || !GR()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e Hf() {
        return this.bjh;
    }

    public void c(e eVar) {
        this.bjh = eVar;
    }

    public e Hg() {
        return this.bji;
    }

    public int gV(int i) {
        switch (i) {
            case 12:
            case 13:
            case 15:
            case 18:
            case 19:
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
            case 29:
                return 3;
            default:
                return 0;
        }
    }

    public void aE(int i, int i2) {
        if (1 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 29, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biY, 26, i2);
        }
    }

    public HashMap<Integer, HashSet> Hh() {
        JSONArray jSONArray;
        if (!biV && biW) {
            return this.biX;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.biX.get(0) == null) {
                this.biX.put(0, new HashSet());
            }
            this.biX.get(0).add("3222425470");
            return this.biX;
        }
        if (this.biX.get(0) != null) {
            this.biX.get(0).clear();
        }
        if (this.biX.get(1) != null) {
            this.biX.get(1).clear();
        }
        if (this.biX.get(2) != null) {
            this.biX.get(2).clear();
        }
        try {
            jSONArray = new JSONArray(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt(MyBookrackActivityConfig.TAB_ID);
                String optString = optJSONObject.optString("uid");
                switch (optInt) {
                    case 0:
                        if (this.biX.get(0) == null) {
                            this.biX.put(0, new HashSet());
                        }
                        this.biX.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.biX.get(1) == null) {
                            this.biX.put(1, new HashSet());
                        }
                        this.biX.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.biX.get(2) == null) {
                            this.biX.put(2, new HashSet());
                        }
                        this.biX.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        biW = true;
        biV = false;
        return this.biX;
    }

    public HashSet<String> Hi() {
        Hh();
        return this.biX.get(0);
    }

    public HashSet<String> Hj() {
        Hh();
        return this.biX.get(1);
    }

    public HashSet<String> Hk() {
        Hh();
        return this.biX.get(2);
    }

    public String Hl() {
        HashSet<String> Hi = Hi();
        if (Hi != null) {
            Iterator<String> it = Hi.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
