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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.ap;
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
    private static a aDG;
    private e aDI;
    private String aDL;
    private String aDM;
    private String aDN;
    public static boolean aDv = true;
    public static boolean aDw = false;
    private static Date aDJ = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Dp().b(a.Dp().DM());
            }
        }
    };
    private final HashMap<Integer, HashSet> aDx = new HashMap<>();
    private int aDz = 0;
    private int aDA = 0;
    private int aDB = 0;
    private int aDC = 0;
    private int aDD = 0;
    private int aDE = 0;
    private int aDF = 0;
    private e aDH = new e();
    private boolean aDK = true;
    private final int[] aDO = new int[10];
    private final Context aDy = TbadkCoreApplication.getInst().getApp();

    public static a Dp() {
        if (aDG == null) {
            aDG = new a();
        }
        return aDG;
    }

    private a() {
    }

    public void s(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.aDM = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aDL = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aDN = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aDz || i2 != this.aDA || i3 != this.aDB || i4 != this.aDC || i5 != this.aDE || i6 != this.aDD || i7 != this.aDF) {
            int i8 = 0;
            if (i > this.aDz || i2 > this.aDA || i3 > this.aDB || i4 > this.aDC || i5 > this.aDE || i6 > this.aDD || i7 > this.aDF) {
                i8 = 1;
            } else if (i < this.aDz || i2 < this.aDA || i3 < this.aDB) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aDz && c.DW().Em()) {
                i9 = 1;
            } else if (i < this.aDz) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aDA && c.DW().Ed()) {
                i10 = 1;
            } else if (i2 < this.aDA) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aDB && c.DW().Eb()) {
                i11 = 1;
            } else if (i3 < this.aDB) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aDC) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aDE) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aDF) {
                i14 = 1;
            }
            this.aDz = i;
            this.aDA = i2;
            this.aDB = i3;
            this.aDC = i4;
            this.aDE = i5;
            this.aDD = i6;
            this.aDF = i7;
            if (DK() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                DH();
                E(i14, 23);
                E(i12, 16);
                E(i8, 17);
                E(i10, 24);
                E(i11, 25);
                E(i13, 26);
                E(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.aDz || i2 != this.aDA || i3 != this.aDB || i4 != this.aDC || i5 != this.aDE || this.aDF != i6) {
            this.aDz = i;
            this.aDA = i2;
            this.aDB = i3;
            this.aDC = i4;
            this.aDE = i5;
            this.aDF = i6;
            DH();
            if (DK() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean Dq() {
        if (aDJ == null) {
            aDJ = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aDJ.getTime() < 10000) {
                return false;
            }
            aDJ = date;
        }
        return true;
    }

    public static boolean Dr() {
        if (c.DW().Eh()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.DW().Ej().split(SystemInfoUtil.COLON);
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.DW().Ek().split(SystemInfoUtil.COLON);
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
                    if (this.aDF > 0) {
                        String format = String.format(this.aDy.getString(d.k.notify_gift), String.valueOf(this.aDF));
                        b(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aDz > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.aDy.getString(d.k.notify_agree), Integer.valueOf(this.aDz)));
                        b(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aDA > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aDA > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aDA));
                            sb2.append(this.aDy.getString(d.k.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aDM != null) {
                            sb2.append(this.aDM);
                        } else {
                            sb2.append(this.aDy.getString(d.k.notify_reply));
                        }
                        b(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aDB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aDB > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aDB));
                            sb3.append(this.aDy.getString(d.k.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aDN != null) {
                            sb3.append(this.aDN);
                        } else {
                            sb3.append(this.aDy.getString(d.k.notify_at));
                        }
                        b(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aDE > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.aDy.getString(d.k.notify_fans), Integer.valueOf(this.aDE)));
                        b(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.DW().El() || c.DW().DZ() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aDy, 16);
                NotificationHelper.cancelNotification(this.aDy, 17);
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
    private void a(int i, int i2, e eVar) {
        boolean z;
        String ES;
        String ER;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aDF > 0) {
                            String format = String.format(this.aDy.getString(d.k.notify_gift), String.valueOf(this.aDF));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aDz > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aDz > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aDz));
                                sb.append(this.aDy.getString(d.k.notify_unit));
                                sb.append("]");
                            }
                            if (this.aDL != null) {
                                sb.append(this.aDL);
                            } else {
                                sb.append(this.aDy.getString(d.k.notify_agree));
                            }
                            b(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aDA > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aDA > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aDA));
                                sb2.append(this.aDy.getString(d.k.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aDM != null) {
                                sb2.append(this.aDM);
                            } else {
                                sb2.append(this.aDy.getString(d.k.notify_reply));
                            }
                            b(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aDB > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aDB > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aDB));
                                sb3.append(this.aDy.getString(d.k.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aDN != null) {
                                sb3.append(this.aDN);
                            } else {
                                sb3.append(this.aDy.getString(d.k.notify_at));
                            }
                            b(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aDE > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aDE > 1) {
                                sb4.append(String.format(this.aDy.getString(d.k.notify_fans_unit), Integer.valueOf(this.aDE)));
                            }
                            sb4.append(this.aDy.getString(d.k.notify_fans));
                            b(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int EI = (!c.DW().El() || c.DW().DZ() <= 0) ? 0 : eVar.EI() - eVar.EP();
                        long Fa = (!c.DW().Ee() || c.DW().DZ() <= 0) ? 0L : eVar.Fa();
                        boolean z4 = Fa > 0;
                        long j = EI + Fa;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aDy.getString(d.k.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Fd();
                            eVar.Fb();
                            if (Fa == 1) {
                                ES = eVar.Fd();
                                str = eVar.Fb();
                                ER = ES + "：" + str;
                            } else if (EI == 1) {
                                ES = eVar.ES();
                                ER = eVar.ER();
                                str = ER;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aDy.getString(d.k.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(ER)) {
                                ER = str;
                            }
                            a(16, ES, str, ER, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> Fg = eVar.Fg();
                        if (Fg != null && Fg.size() != 0) {
                            for (e.a aVar : Fg) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ap.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aFv && aVar.aFw == null) {
                                    DN();
                                    if (DO().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.DW().El() && c.DW().DZ() > 0 && eVar.EJ() + eVar.EL() > 0) {
                        if (eVar.EJ() > 0 && !Dy()) {
                            long EJ = eVar.EJ() - eVar.EK();
                            if (EJ > 0) {
                                stringBuffer.append(String.format(this.aDy.getString(d.k.notify_updates), Long.valueOf(EJ)));
                                z = false;
                                z2 = true;
                            } else if (eVar.EK() > 0) {
                                z = true;
                            }
                            if (eVar.EL() > 0 || Dx()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.aDy.getString(d.k.notify_validate), Integer.valueOf(eVar.EL())));
                            } else {
                                stringBuffer.append(String.format(this.aDy.getString(d.k.notify_validate_1), Integer.valueOf(eVar.EL())));
                            }
                            if (z3) {
                                b(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                b(18, eVar.EU(), eVar.EV(), eVar.EV());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.EL() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aDy, 16);
                    NotificationHelper.cancelNotification(this.aDy, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void b(int i, String str, String str2, String str3) {
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
            a.putExtra("KeyOfNotiId", i);
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aDy, i, a, 134217728);
            a(dX(i), i);
            NotificationHelper.showNotification(this.aDy, i, aVar.title, aVar.content, aVar.aFt, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent i2;
        if (this.aDK) {
            if (i == 23 && this.aDF > 0) {
                i2 = dS(i);
            } else if (i == 26 && this.aDE > 0) {
                i2 = dT(i);
            } else if (i == 18) {
                i2 = Ds();
            } else if (i == 24) {
                i2 = i(i, z);
                i2.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                i2 = i(i, z);
                i2.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                i2 = i(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            i2.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aDy, i, i2, 134217728);
            a(dX(i), i);
            NotificationHelper.showNotification(this.aDy, i, str, str2, str3, service, false);
        }
    }

    public Intent dS(int i) {
        Intent intent = new Intent(this.aDy, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aDF);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dT(int i) {
        Intent intent = new Intent(this.aDy, DealIntentService.class);
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
        ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(aVar.gid, aVar.userType);
        if (ar == null || ar.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(ar.getLastContentRawData());
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
                    Intent intent = new Intent(this.aDy, DealIntentService.class);
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
        ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(aVar.gid + "", aVar.userType);
        if (ar == null || ar.getLast_content() == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(ar.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            if (optString.contains("mo/q/hotMessage")) {
                Intent intent = new Intent(this.aDy, DealIntentService.class);
                intent.putExtra("class", 30);
                intent.putExtra(BigdayActivityConfig.JUMP_URL, optString);
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
        Intent intent = new Intent(this.aDy, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.aFu);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aDy, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> DN = DN();
        String str = aVar.gid;
        if (DN != null && !ap.isEmpty(str)) {
            HashSet<String> DO = DO();
            HashSet<String> DP = DP();
            HashSet<String> DQ = DQ();
            if (DO != null && DO.contains(str)) {
                return b(aVar, 3);
            }
            if (DP != null && DP.contains(str)) {
                return b(aVar, 1);
            }
            if (DQ != null && DQ.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent i(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aDH.Fc().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aDy, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aDz);
        intent.putExtra("at_me", this.aDB);
        intent.putExtra("reply_me", this.aDA);
        intent.putExtra("fans", this.aDE);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aDH.EI() - this.aDH.EP());
        intent.putExtra("group_msg_validate", this.aDH.EL());
        intent.putExtra("group_msg_updates", this.aDH.EJ());
        intent.putExtra("officialbar_msg", this.aDH.EM());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Ds() {
        Intent intent = new Intent(this.aDy, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aDH.EK());
        return intent;
    }

    public void Dt() {
        NotificationHelper.cancelNotification(this.aDy, 23);
        NotificationHelper.cancelNotification(this.aDy, 24);
        NotificationHelper.cancelNotification(this.aDy, 25);
        NotificationHelper.cancelNotification(this.aDy, 29);
        NotificationHelper.cancelNotification(this.aDy, 26);
        NotificationHelper.cancelNotification(this.aDy, 17);
        NotificationHelper.cancelNotification(this.aDy, 15);
        NotificationHelper.cancelNotification(this.aDy, 13);
        NotificationHelper.cancelNotification(this.aDy, 12);
    }

    public void Du() {
        NotificationHelper.cancelNotification(this.aDy, 16);
    }

    public void Dv() {
        NotificationHelper.cancelNotification(this.aDy, 19);
    }

    public void dU(int i) {
        NotificationHelper.cancelNotification(this.aDy, i);
    }

    public void Dw() {
        NotificationHelper.cancelNotification(this.aDy, 30);
    }

    public void fH(String str) {
        if (TextUtils.isEmpty(str)) {
            Du();
            return;
        }
        e DL = DL();
        if (DL == null) {
            Du();
            return;
        }
        HashMap<String, String> EW = DL.EW();
        if (EW == null || EW.isEmpty()) {
            Du();
        } else if (EW.containsKey(str)) {
            Du();
        }
    }

    public void fI(String str) {
        if (TextUtils.isEmpty(str)) {
            Du();
            return;
        }
        e DL = DL();
        if (DL == null) {
            Du();
            return;
        }
        HashMap<String, String> Fc = DL.Fc();
        if (Fc == null || Fc.isEmpty()) {
            Du();
        } else if (Fc.containsKey(str)) {
            Du();
        }
    }

    private boolean Dx() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Dy() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void Dz() {
        NotificationHelper.cancelNotification(this.aDy, 17);
    }

    public void dV(int i) {
        e DL = DL();
        if (DL == null) {
            Dz();
        } else if (1 == i) {
            if (DL.EJ() <= 0) {
                Dz();
            }
        } else if (2 == i && DL.EL() <= 0) {
            Dz();
        }
    }

    public void DA() {
        NotificationHelper.cancelNotification(this.aDy, 18);
    }

    public void DB() {
        NotificationHelper.cancelNotification(this.aDy, 26);
        NotificationHelper.cancelNotification(this.aDy, 25);
        NotificationHelper.cancelNotification(this.aDy, 24);
        NotificationHelper.cancelNotification(this.aDy, 23);
        NotificationHelper.cancelNotification(this.aDy, 16);
        NotificationHelper.cancelNotification(this.aDy, 17);
        NotificationHelper.cancelNotification(this.aDy, 29);
    }

    public void DC() {
        NotificationHelper.cancelNotification(this.aDy, 17);
        NotificationHelper.cancelNotification(this.aDy, 19);
        NotificationHelper.cancelNotification(this.aDy, 16);
        NotificationHelper.cancelNotification(this.aDy, 18);
        NotificationHelper.cancelNotification(this.aDy, 30);
    }

    public void DD() {
        NotificationHelper.cancelNotification(this.aDy, 24);
    }

    public void DE() {
        NotificationHelper.cancelNotification(this.aDy, 25);
    }

    public void DF() {
        NotificationHelper.cancelNotification(this.aDy, 29);
    }

    public void DG() {
        NotificationHelper.cancelNotification(this.aDy, 23);
    }

    public void DH() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(DI());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(DJ());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aDH.Fa());
        newsNotifyMessage.setMsgStrangerChat(this.aDH.Ff());
        newsNotifyMessage.setMsgOfficialMerge(this.aDH.Fe());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(DI());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Fa() + eVar.EI()) + eVar.Ff()) + eVar.Fe()) + eVar.Fh()) - eVar.EP());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Fa());
            newsNotifyMessage.setMsgStrangerChat(eVar.Ff());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Fe());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aDA;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aDz, i, this.aDB, this.aDC, this.aDE, this.aDD, this.aDF);
        }
    }

    public int getMsgAtme() {
        return this.aDB;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aDz, this.aDA, i, this.aDC, this.aDE, this.aDD, this.aDF);
        }
    }

    public int DI() {
        return this.aDz;
    }

    public void dW(int i) {
        if (i >= 0) {
            a(i, this.aDA, this.aDB, this.aDC, this.aDE, this.aDD, this.aDF);
        }
    }

    public int getMsgChat() {
        return this.aDC;
    }

    public int DJ() {
        return ((((this.aDH.Fa() + this.aDH.EI()) + this.aDH.Ff()) + this.aDH.Fe()) + this.aDH.Fh()) - this.aDH.EP();
    }

    public int getMsgFans() {
        return this.aDE;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aDz, this.aDA, this.aDB, this.aDC, i, this.aDD, this.aDF);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aDz, this.aDA, this.aDB, i, this.aDE, this.aDD, this.aDF);
        }
    }

    public int getMsgBookmark() {
        return this.aDD;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aDz, this.aDA, this.aDB, this.aDC, this.aDE, i, this.aDF);
        }
    }

    public int getMsgGiftNum() {
        return this.aDF;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aDF = i;
        }
    }

    public void bd(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aDz = 0;
        this.aDA = 0;
        this.aDB = 0;
        this.aDC = 0;
        this.aDE = 0;
        this.aDD = 0;
    }

    public int DK() {
        return this.aDz + this.aDA + this.aDB + this.aDC + this.aDE + this.aDF;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aDH = eVar;
            this.aDC = (eVar.EI() - eVar.EP()) + eVar.Fa() + eVar.Fe() + eVar.Fh();
            a(eVar);
            if (eVar.EQ()) {
                this.aDI = null;
                mHandler.removeMessages(0);
            }
            if (eVar.EQ()) {
                if (c.DW().El() && c.DW().DZ() > 0) {
                    i = eVar.EI() - eVar.EP();
                }
                long Fa = (!c.DW().Ee() || c.DW().DZ() <= 0) ? 0L : eVar.Fa();
                if ((i > 0 || Fa > 0) && ((i > eVar.ET() - eVar.EP() && i > 0) || Fa > eVar.EN())) {
                    a(1, 16, eVar);
                }
                int EM = eVar.EM();
                if (EM > 0 && EM > eVar.EZ()) {
                    a(1, 19, eVar);
                }
                if (eVar.EJ() > eVar.EX() || eVar.EL() > eVar.EY()) {
                    if (eVar.EJ() <= eVar.EX() || eVar.EL() != eVar.EY() || !Dy()) {
                        if (eVar.EJ() != eVar.EX() || eVar.EL() <= eVar.EY() || !Dx()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e DL() {
        return this.aDH;
    }

    public void c(e eVar) {
        this.aDH = eVar;
    }

    public e DM() {
        return this.aDI;
    }

    public int dX(int i) {
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

    public void a(long j, int i) {
        if (1 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDy, 26, i);
        }
    }

    public HashMap<Integer, HashSet> DN() {
        JSONArray jSONArray;
        if (!aDv && aDw) {
            return this.aDx;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aDx.get(0) == null) {
                this.aDx.put(0, new HashSet());
            }
            this.aDx.get(0).add("3222425470");
            return this.aDx;
        }
        if (this.aDx.get(0) != null) {
            this.aDx.get(0).clear();
        }
        if (this.aDx.get(1) != null) {
            this.aDx.get(1).clear();
        }
        if (this.aDx.get(2) != null) {
            this.aDx.get(2).clear();
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
                        if (this.aDx.get(0) == null) {
                            this.aDx.put(0, new HashSet());
                        }
                        this.aDx.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aDx.get(1) == null) {
                            this.aDx.put(1, new HashSet());
                        }
                        this.aDx.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aDx.get(2) == null) {
                            this.aDx.put(2, new HashSet());
                        }
                        this.aDx.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aDw = true;
        aDv = false;
        return this.aDx;
    }

    public HashSet<String> DO() {
        DN();
        return this.aDx.get(0);
    }

    public HashSet<String> DP() {
        DN();
        return this.aDx.get(1);
    }

    public HashSet<String> DQ() {
        DN();
        return this.aDx.get(2);
    }

    public String DR() {
        HashSet<String> DO = DO();
        if (DO != null) {
            Iterator<String> it = DO.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
