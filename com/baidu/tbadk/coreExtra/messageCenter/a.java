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
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.e;
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
    private static a aGK;
    private e aGM;
    private String aGP;
    private String aGQ;
    private String aGR;
    public static boolean aGA = true;
    public static boolean aGB = false;
    private static Date aGN = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Ey().b(a.Ey().EV());
            }
        }
    };
    private final HashMap<Integer, HashSet> aGC = new HashMap<>();
    private int aGD = 0;
    private int aGE = 0;
    private int aGF = 0;
    private int aGG = 0;
    private int aGH = 0;
    private int aGI = 0;
    private int aGJ = 0;
    private e aGL = new e();
    private boolean aGO = true;
    private final int[] aGS = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static a Ey() {
        if (aGK == null) {
            aGK = new a();
        }
        return aGK;
    }

    private a() {
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.aGQ = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aGP = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aGR = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aGD || i2 != this.aGE || i3 != this.aGF || i4 != this.aGG || i5 != this.aGI || i6 != this.aGH || i7 != this.aGJ) {
            int i8 = 0;
            if (i > this.aGD || i2 > this.aGE || i3 > this.aGF || i4 > this.aGG || i5 > this.aGI || i6 > this.aGH || i7 > this.aGJ) {
                i8 = 1;
            } else if (i < this.aGD || i2 < this.aGE || i3 < this.aGF) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aGD && c.Ff().Fw()) {
                i9 = 1;
            } else if (i < this.aGD) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aGE && c.Ff().Fm()) {
                i10 = 1;
            } else if (i2 < this.aGE) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aGF && c.Ff().Fk()) {
                i11 = 1;
            } else if (i3 < this.aGF) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aGG) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aGI) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aGJ) {
                i14 = 1;
            }
            this.aGD = i;
            this.aGE = i2;
            this.aGF = i3;
            this.aGG = i4;
            this.aGI = i5;
            this.aGH = i6;
            this.aGJ = i7;
            if (ET() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                EQ();
                H(i14, 23);
                H(i12, 16);
                H(i8, 17);
                H(i10, 24);
                H(i11, 25);
                H(i13, 26);
                H(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.aGD || i2 != this.aGE || i3 != this.aGF || i4 != this.aGG || i5 != this.aGI || this.aGJ != i6) {
            this.aGD = i;
            this.aGE = i2;
            this.aGF = i3;
            this.aGG = i4;
            this.aGI = i5;
            this.aGJ = i6;
            EQ();
            if (ET() <= 0) {
                H(2, 16);
                H(2, 17);
            }
        }
    }

    public static boolean Ez() {
        if (aGN == null) {
            aGN = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aGN.getTime() < 10000) {
                return false;
            }
            aGN = date;
        }
        return true;
    }

    public static boolean EA() {
        if (c.Ff().Fq()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Ff().Fs().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Ff().Ft().split(":");
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

    private void H(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.aGJ > 0) {
                        String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aGJ));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aGD > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(e.j.notify_agree), Integer.valueOf(this.aGD)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aGE > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aGE > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aGE));
                            sb2.append(this.appContext.getString(e.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aGQ != null) {
                            sb2.append(this.aGQ);
                        } else {
                            sb2.append(this.appContext.getString(e.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aGF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aGF > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aGF));
                            sb3.append(this.appContext.getString(e.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aGR != null) {
                            sb3.append(this.aGR);
                        } else {
                            sb3.append(this.appContext.getString(e.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aGI > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(e.j.notify_fans), Integer.valueOf(this.aGI)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Ff().Fv() || c.Ff().Fi() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.appContext, 16);
                NotificationHelper.cancelNotification(this.appContext, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0344 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:110:0x02b7, B:111:0x02bd, B:112:0x02c3, B:114:0x02cd, B:116:0x02d7, B:118:0x02e2, B:120:0x02e8, B:122:0x02ee, B:124:0x02fc, B:125:0x0317, B:127:0x031d, B:130:0x0325, B:132:0x0344, B:134:0x0354, B:138:0x036f, B:135:0x0367, B:141:0x0390), top: B:148:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0354 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a8, B:66:0x01b2, B:68:0x01bc, B:72:0x01c6, B:74:0x01ce, B:77:0x01fe, B:79:0x020d, B:80:0x022d, B:82:0x0233, B:83:0x0251, B:86:0x0258, B:88:0x0262, B:91:0x0270, B:93:0x0276, B:95:0x027c, B:96:0x0280, B:98:0x0286, B:100:0x028e, B:102:0x0296, B:104:0x029e, B:106:0x02a4, B:108:0x02a8, B:110:0x02b7, B:111:0x02bd, B:112:0x02c3, B:114:0x02cd, B:116:0x02d7, B:118:0x02e2, B:120:0x02e8, B:122:0x02ee, B:124:0x02fc, B:125:0x0317, B:127:0x031d, B:130:0x0325, B:132:0x0344, B:134:0x0354, B:138:0x036f, B:135:0x0367, B:141:0x0390), top: B:148:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.model.e eVar) {
        boolean z;
        String Ge;
        String Gd;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aGJ > 0) {
                            String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aGJ));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aGD > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aGD > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aGD));
                                sb.append(this.appContext.getString(e.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.aGP != null) {
                                sb.append(this.aGP);
                            } else {
                                sb.append(this.appContext.getString(e.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aGE > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aGE > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aGE));
                                sb2.append(this.appContext.getString(e.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aGQ != null) {
                                sb2.append(this.aGQ);
                            } else {
                                sb2.append(this.appContext.getString(e.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aGF > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aGF > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aGF));
                                sb3.append(this.appContext.getString(e.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aGR != null) {
                                sb3.append(this.aGR);
                            } else {
                                sb3.append(this.appContext.getString(e.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aGI > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aGI > 1) {
                                sb4.append(String.format(this.appContext.getString(e.j.notify_fans_unit), Integer.valueOf(this.aGI)));
                            }
                            sb4.append(this.appContext.getString(e.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int FU = (!c.Ff().Fv() || c.Ff().Fi() <= 0) ? 0 : eVar.FU() - eVar.Gb();
                        long Gm = (!c.Ff().Fn() || c.Ff().Fi() <= 0) ? 0L : eVar.Gm();
                        boolean z4 = Gm > 0;
                        long j = FU + Gm;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j)));
                            b(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Gp();
                            eVar.Gn();
                            if (Gm == 1) {
                                Ge = eVar.Gp();
                                str = eVar.Gn();
                                Gd = Ge + "：" + str;
                            } else if (FU == 1) {
                                Ge = eVar.Ge();
                                Gd = eVar.Gd();
                                str = Gd;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Gd)) {
                                Gd = str;
                            }
                            b(16, Ge, str, Gd, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> Gs = eVar.Gs();
                        if (Gs != null && Gs.size() != 0) {
                            for (e.a aVar : Gs) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ao.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aII && aVar.aIJ == null) {
                                    EW();
                                    if (EX().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.Ff().Fv() && c.Ff().Fi() > 0 && eVar.FV() + eVar.FX() > 0) {
                        if (eVar.FV() > 0 && !EH()) {
                            long FV = eVar.FV() - eVar.FW();
                            if (FV > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_updates), Long.valueOf(FV)));
                                z = false;
                                z2 = true;
                            } else if (eVar.FW() > 0) {
                                z = true;
                            }
                            if (eVar.FX() > 0 || EG()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate), Integer.valueOf(eVar.FX())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate_1), Integer.valueOf(eVar.FX())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.Gg(), eVar.Gh(), eVar.Gh());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.FX() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.appContext, 16);
                    NotificationHelper.cancelNotification(this.appContext, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void a(int i, String str, String str2, String str3) {
        b(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        Intent a = a(aVar);
        if (a == null) {
            a = c(aVar);
        }
        if (a == null) {
            a = b(aVar);
        }
        if (a != null) {
            a.putExtra("KeyOfNotiId", i);
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.appContext, i, a, 134217728);
            d(el(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.aIG, service, false);
        }
    }

    private void b(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aGO) {
            if (i == 23 && this.aGJ > 0) {
                h = eg(i);
            } else if (i == 26 && this.aGI > 0) {
                h = eh(i);
            } else if (i == 18) {
                h = EB();
            } else if (i == 24) {
                h = h(i, z);
                h.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                h = h(i, z);
                h.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                h = h(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            h.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.appContext, i, h, 134217728);
            d(el(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent eg(int i) {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aGJ);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent eh(int i) {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0099 -> B:33:0x0005). Please submit an issue!!! */
    public Intent a(e.a aVar) {
        Intent intent;
        String lastTaskId;
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aOk().as(aVar.gid, aVar.userType);
        if (as == null || as.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = as.getLastTaskId();
            jSONArray = new JSONArray(as.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                intent = null;
            } else {
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (!StringUtils.isNull(group)) {
                        intent = new Intent(this.appContext, DealIntentService.class);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", group);
                        intent.putExtra("is_from_push", true);
                        intent.putExtra("key_start_from", 7);
                        intent.putExtra("gid", aVar.gid);
                        intent.putExtra("task_id", lastTaskId);
                    }
                    intent = null;
                } else if (optString.contains("mo/q/hotMessage")) {
                    intent = new Intent(this.appContext, DealIntentService.class);
                    intent.putExtra("class", 30);
                    intent.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                    intent.putExtra("task_id", lastTaskId);
                } else {
                    if (optString.contains("open_wb_view=1")) {
                        intent = new Intent(this.appContext, DealIntentService.class);
                        intent.putExtra("class", 0);
                        intent.putExtra("url", optString.trim());
                        intent.putExtra("task_id", lastTaskId);
                    }
                    intent = null;
                }
            }
        } else {
            intent = null;
        }
        return intent;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.aIH);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> EW = EW();
        String str = aVar.gid;
        if (EW != null && !ao.isEmpty(str)) {
            HashSet<String> EX = EX();
            HashSet<String> EY = EY();
            HashSet<String> EZ = EZ();
            if (EX != null && EX.contains(str)) {
                return b(aVar, 3);
            }
            if (EY != null && EY.contains(str)) {
                return b(aVar, 1);
            }
            if (EZ != null && EZ.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aGL.Go().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aGD);
        intent.putExtra("at_me", this.aGF);
        intent.putExtra("reply_me", this.aGE);
        intent.putExtra("fans", this.aGI);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aGL.FU() - this.aGL.Gb());
        intent.putExtra("group_msg_validate", this.aGL.FX());
        intent.putExtra("group_msg_updates", this.aGL.FV());
        intent.putExtra("officialbar_msg", this.aGL.FY());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent EB() {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aGL.FW());
        return intent;
    }

    public void EC() {
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 29);
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 15);
        NotificationHelper.cancelNotification(this.appContext, 13);
        NotificationHelper.cancelNotification(this.appContext, 12);
    }

    public void ED() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void EE() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void ei(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void EF() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void gb(String str) {
        if (TextUtils.isEmpty(str)) {
            ED();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e EU = EU();
        if (EU == null) {
            ED();
            return;
        }
        HashMap<String, String> Gi = EU.Gi();
        if (Gi == null || Gi.isEmpty()) {
            ED();
        } else if (Gi.containsKey(str)) {
            ED();
        }
    }

    public void gc(String str) {
        if (TextUtils.isEmpty(str)) {
            ED();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e EU = EU();
        if (EU == null) {
            ED();
            return;
        }
        HashMap<String, String> Go = EU.Go();
        if (Go == null || Go.isEmpty()) {
            ED();
        } else if (Go.containsKey(str)) {
            ED();
        }
    }

    private boolean EG() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean EH() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void EI() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void ej(int i) {
        com.baidu.tbadk.coreExtra.model.e EU = EU();
        if (EU == null) {
            EI();
        } else if (1 == i) {
            if (EU.FV() <= 0) {
                EI();
            }
        } else if (2 == i && EU.FX() <= 0) {
            EI();
        }
    }

    public void EJ() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void EK() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void EL() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void EM() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void EN() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void EO() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void EP() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void EQ() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(ER());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(ES());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aGL.Gm());
        newsNotifyMessage.setMsgStrangerChat(this.aGL.Gr());
        newsNotifyMessage.setMsgOfficialMerge(this.aGL.Gq());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(ER());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Gm() + eVar.FU()) + eVar.Gr()) + eVar.Gq()) + eVar.Gt()) - eVar.Gb());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Gm());
            newsNotifyMessage.setMsgStrangerChat(eVar.Gr());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Gq());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aGE;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aGD, i, this.aGF, this.aGG, this.aGI, this.aGH, this.aGJ);
        }
    }

    public int getMsgAtme() {
        return this.aGF;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aGD, this.aGE, i, this.aGG, this.aGI, this.aGH, this.aGJ);
        }
    }

    public int ER() {
        return this.aGD;
    }

    public void ek(int i) {
        if (i >= 0) {
            a(i, this.aGE, this.aGF, this.aGG, this.aGI, this.aGH, this.aGJ);
        }
    }

    public int getMsgChat() {
        return this.aGG;
    }

    public int ES() {
        return ((((this.aGL.Gm() + this.aGL.FU()) + this.aGL.Gr()) + this.aGL.Gq()) + this.aGL.Gt()) - this.aGL.Gb();
    }

    public int getMsgFans() {
        return this.aGI;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aGD, this.aGE, this.aGF, this.aGG, i, this.aGH, this.aGJ);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aGD, this.aGE, this.aGF, i, this.aGI, this.aGH, this.aGJ);
        }
    }

    public int getMsgBookmark() {
        return this.aGH;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aGD, this.aGE, this.aGF, this.aGG, this.aGI, i, this.aGJ);
        }
    }

    public int getMsgGiftNum() {
        return this.aGJ;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aGJ = i;
        }
    }

    public void bo(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aGD = 0;
        this.aGE = 0;
        this.aGF = 0;
        this.aGG = 0;
        this.aGI = 0;
        this.aGH = 0;
    }

    public int ET() {
        return this.aGD + this.aGE + this.aGF + this.aGG + this.aGI + this.aGJ;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aGL = eVar;
            this.aGG = (eVar.FU() - eVar.Gb()) + eVar.Gm() + eVar.Gq() + eVar.Gt();
            a(eVar);
            if (eVar.Gc()) {
                this.aGM = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Gc()) {
                if (c.Ff().Fv() && c.Ff().Fi() > 0) {
                    i = eVar.FU() - eVar.Gb();
                }
                long Gm = (!c.Ff().Fn() || c.Ff().Fi() <= 0) ? 0L : eVar.Gm();
                if ((i > 0 || Gm > 0) && ((i > eVar.Gf() - eVar.Gb() && i > 0) || Gm > eVar.FZ())) {
                    a(1, 16, eVar);
                }
                int FY = eVar.FY();
                if (FY > 0 && FY > eVar.Gl()) {
                    a(1, 19, eVar);
                }
                if (eVar.FV() > eVar.Gj() || eVar.FX() > eVar.Gk()) {
                    if (eVar.FV() <= eVar.Gj() || eVar.FX() != eVar.Gk() || !EH()) {
                        if (eVar.FV() != eVar.Gj() || eVar.FX() <= eVar.Gk() || !EG()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e EU() {
        return this.aGL;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.aGL = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e EV() {
        return this.aGM;
    }

    public int el(int i) {
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

    public void d(long j, int i) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.appContext, 26, i);
        }
    }

    public HashMap<Integer, HashSet> EW() {
        JSONArray jSONArray;
        if (!aGA && aGB) {
            return this.aGC;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aGC.get(0) == null) {
                this.aGC.put(0, new HashSet());
            }
            this.aGC.get(0).add("3222425470");
            return this.aGC;
        }
        if (this.aGC.get(0) != null) {
            this.aGC.get(0).clear();
        }
        if (this.aGC.get(1) != null) {
            this.aGC.get(1).clear();
        }
        if (this.aGC.get(2) != null) {
            this.aGC.get(2).clear();
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
                        if (this.aGC.get(0) == null) {
                            this.aGC.put(0, new HashSet());
                        }
                        this.aGC.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aGC.get(1) == null) {
                            this.aGC.put(1, new HashSet());
                        }
                        this.aGC.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aGC.get(2) == null) {
                            this.aGC.put(2, new HashSet());
                        }
                        this.aGC.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aGB = true;
        aGA = false;
        return this.aGC;
    }

    public HashSet<String> EX() {
        EW();
        return this.aGC.get(0);
    }

    public HashSet<String> EY() {
        EW();
        return this.aGC.get(1);
    }

    public HashSet<String> EZ() {
        EW();
        return this.aGC.get(2);
    }

    public String Fa() {
        HashSet<String> EX = EX();
        if (EX != null) {
            Iterator<String> it = EX.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
