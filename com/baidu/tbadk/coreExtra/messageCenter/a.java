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
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.ao;
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
    private static a aCM;
    private e aCO;
    private String aCR;
    private String aCS;
    private String aCT;
    public static boolean aCB = true;
    public static boolean aCC = false;
    private static Date aCP = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.CX().b(a.CX().Du());
            }
        }
    };
    private final HashMap<Integer, HashSet> aCD = new HashMap<>();
    private int aCF = 0;
    private int aCG = 0;
    private int aCH = 0;
    private int aCI = 0;
    private int aCJ = 0;
    private int aCK = 0;
    private int aCL = 0;
    private e aCN = new e();
    private boolean aCQ = true;
    private final int[] aCU = new int[10];
    private final Context aCE = TbadkCoreApplication.getInst().getApp();

    public static a CX() {
        if (aCM == null) {
            aCM = new a();
        }
        return aCM;
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
                    this.aCS = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aCR = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aCT = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aCF || i2 != this.aCG || i3 != this.aCH || i4 != this.aCI || i5 != this.aCK || i6 != this.aCJ || i7 != this.aCL) {
            int i8 = 0;
            if (i > this.aCF || i2 > this.aCG || i3 > this.aCH || i4 > this.aCI || i5 > this.aCK || i6 > this.aCJ || i7 > this.aCL) {
                i8 = 1;
            } else if (i < this.aCF || i2 < this.aCG || i3 < this.aCH) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aCF && c.DE().DU()) {
                i9 = 1;
            } else if (i < this.aCF) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aCG && c.DE().DL()) {
                i10 = 1;
            } else if (i2 < this.aCG) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aCH && c.DE().DJ()) {
                i11 = 1;
            } else if (i3 < this.aCH) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aCI) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aCK) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aCL) {
                i14 = 1;
            }
            this.aCF = i;
            this.aCG = i2;
            this.aCH = i3;
            this.aCI = i4;
            this.aCK = i5;
            this.aCJ = i6;
            this.aCL = i7;
            if (Ds() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Dp();
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
        if (i != this.aCF || i2 != this.aCG || i3 != this.aCH || i4 != this.aCI || i5 != this.aCK || this.aCL != i6) {
            this.aCF = i;
            this.aCG = i2;
            this.aCH = i3;
            this.aCI = i4;
            this.aCK = i5;
            this.aCL = i6;
            Dp();
            if (Ds() <= 0) {
                E(2, 16);
                E(2, 17);
            }
        }
    }

    public static boolean CY() {
        if (aCP == null) {
            aCP = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aCP.getTime() < 10000) {
                return false;
            }
            aCP = date;
        }
        return true;
    }

    public static boolean CZ() {
        if (c.DE().DP()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.DE().DR().split(SystemInfoUtil.COLON);
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.DE().DS().split(SystemInfoUtil.COLON);
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
                    if (this.aCL > 0) {
                        String format = String.format(this.aCE.getString(d.k.notify_gift), String.valueOf(this.aCL));
                        b(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aCF > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.aCE.getString(d.k.notify_agree), Integer.valueOf(this.aCF)));
                        b(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aCG > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aCG > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aCG));
                            sb2.append(this.aCE.getString(d.k.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aCS != null) {
                            sb2.append(this.aCS);
                        } else {
                            sb2.append(this.aCE.getString(d.k.notify_reply));
                        }
                        b(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aCH > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aCH > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aCH));
                            sb3.append(this.aCE.getString(d.k.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aCT != null) {
                            sb3.append(this.aCT);
                        } else {
                            sb3.append(this.aCE.getString(d.k.notify_at));
                        }
                        b(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aCK > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.aCE.getString(d.k.notify_fans), Integer.valueOf(this.aCK)));
                        b(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.DE().DT() || c.DE().DH() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aCE, 16);
                NotificationHelper.cancelNotification(this.aCE, 17);
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
        String EA;
        String Ez;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aCL > 0) {
                            String format = String.format(this.aCE.getString(d.k.notify_gift), String.valueOf(this.aCL));
                            b(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aCF > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aCF > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aCF));
                                sb.append(this.aCE.getString(d.k.notify_unit));
                                sb.append("]");
                            }
                            if (this.aCR != null) {
                                sb.append(this.aCR);
                            } else {
                                sb.append(this.aCE.getString(d.k.notify_agree));
                            }
                            b(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aCG > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aCG > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aCG));
                                sb2.append(this.aCE.getString(d.k.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aCS != null) {
                                sb2.append(this.aCS);
                            } else {
                                sb2.append(this.aCE.getString(d.k.notify_reply));
                            }
                            b(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aCH > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aCH > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aCH));
                                sb3.append(this.aCE.getString(d.k.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aCT != null) {
                                sb3.append(this.aCT);
                            } else {
                                sb3.append(this.aCE.getString(d.k.notify_at));
                            }
                            b(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aCK > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aCK > 1) {
                                sb4.append(String.format(this.aCE.getString(d.k.notify_fans_unit), Integer.valueOf(this.aCK)));
                            }
                            sb4.append(this.aCE.getString(d.k.notify_fans));
                            b(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int Eq = (!c.DE().DT() || c.DE().DH() <= 0) ? 0 : eVar.Eq() - eVar.Ex();
                        long EI = (!c.DE().DM() || c.DE().DH() <= 0) ? 0L : eVar.EI();
                        boolean z4 = EI > 0;
                        long j = Eq + EI;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aCE.getString(d.k.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.EL();
                            eVar.EJ();
                            if (EI == 1) {
                                EA = eVar.EL();
                                str = eVar.EJ();
                                Ez = EA + "：" + str;
                            } else if (Eq == 1) {
                                EA = eVar.EA();
                                Ez = eVar.Ez();
                                str = Ez;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aCE.getString(d.k.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Ez)) {
                                Ez = str;
                            }
                            a(16, EA, str, Ez, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> EO = eVar.EO();
                        if (EO != null && EO.size() != 0) {
                            for (e.a aVar : EO) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ao.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aEB && aVar.aEC == null) {
                                    Dv();
                                    if (Dw().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.DE().DT() && c.DE().DH() > 0 && eVar.Er() + eVar.Et() > 0) {
                        if (eVar.Er() > 0 && !Dg()) {
                            long Er = eVar.Er() - eVar.Es();
                            if (Er > 0) {
                                stringBuffer.append(String.format(this.aCE.getString(d.k.notify_updates), Long.valueOf(Er)));
                                z = false;
                                z2 = true;
                            } else if (eVar.Es() > 0) {
                                z = true;
                            }
                            if (eVar.Et() > 0 || Df()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.aCE.getString(d.k.notify_validate), Integer.valueOf(eVar.Et())));
                            } else {
                                stringBuffer.append(String.format(this.aCE.getString(d.k.notify_validate_1), Integer.valueOf(eVar.Et())));
                            }
                            if (z3) {
                                b(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                b(18, eVar.EC(), eVar.ED(), eVar.ED());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.Et() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aCE, 16);
                    NotificationHelper.cancelNotification(this.aCE, 17);
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
            PendingIntent service = PendingIntent.getService(this.aCE, i, a, 134217728);
            a(dW(i), i);
            NotificationHelper.showNotification(this.aCE, i, aVar.title, aVar.content, aVar.aEz, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent k;
        if (this.aCQ) {
            if (i == 23 && this.aCL > 0) {
                k = dR(i);
            } else if (i == 26 && this.aCK > 0) {
                k = dS(i);
            } else if (i == 18) {
                k = Da();
            } else if (i == 24) {
                k = k(i, z);
                k.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                k = k(i, z);
                k.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                k = k(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            k.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aCE, i, k, 134217728);
            a(dW(i), i);
            NotificationHelper.showNotification(this.aCE, i, str, str2, str3, service, false);
        }
    }

    public Intent dR(int i) {
        Intent intent = new Intent(this.aCE, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aCL);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dS(int i) {
        Intent intent = new Intent(this.aCE, DealIntentService.class);
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
        ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(aVar.gid, aVar.userType);
        if (as == null || as.getLast_content() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(as.getLastContentRawData());
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
                    Intent intent = new Intent(this.aCE, DealIntentService.class);
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
        ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(aVar.gid + "", aVar.userType);
        if (as == null || as.getLast_content() == null) {
            return null;
        }
        try {
            jSONArray = new JSONArray(as.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            if (optString.contains("mo/q/hotMessage")) {
                Intent intent = new Intent(this.aCE, DealIntentService.class);
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
        Intent intent = new Intent(this.aCE, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.aEA);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aCE, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> Dv = Dv();
        String str = aVar.gid;
        if (Dv != null && !ao.isEmpty(str)) {
            HashSet<String> Dw = Dw();
            HashSet<String> Dx = Dx();
            HashSet<String> Dy = Dy();
            if (Dw != null && Dw.contains(str)) {
                return b(aVar, 3);
            }
            if (Dx != null && Dx.contains(str)) {
                return b(aVar, 1);
            }
            if (Dy != null && Dy.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent k(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aCN.EK().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aCE, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aCF);
        intent.putExtra("at_me", this.aCH);
        intent.putExtra("reply_me", this.aCG);
        intent.putExtra("fans", this.aCK);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aCN.Eq() - this.aCN.Ex());
        intent.putExtra("group_msg_validate", this.aCN.Et());
        intent.putExtra("group_msg_updates", this.aCN.Er());
        intent.putExtra("officialbar_msg", this.aCN.Eu());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Da() {
        Intent intent = new Intent(this.aCE, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aCN.Es());
        return intent;
    }

    public void Db() {
        NotificationHelper.cancelNotification(this.aCE, 23);
        NotificationHelper.cancelNotification(this.aCE, 24);
        NotificationHelper.cancelNotification(this.aCE, 25);
        NotificationHelper.cancelNotification(this.aCE, 29);
        NotificationHelper.cancelNotification(this.aCE, 26);
        NotificationHelper.cancelNotification(this.aCE, 17);
        NotificationHelper.cancelNotification(this.aCE, 15);
        NotificationHelper.cancelNotification(this.aCE, 13);
        NotificationHelper.cancelNotification(this.aCE, 12);
    }

    public void Dc() {
        NotificationHelper.cancelNotification(this.aCE, 16);
    }

    public void Dd() {
        NotificationHelper.cancelNotification(this.aCE, 19);
    }

    public void dT(int i) {
        NotificationHelper.cancelNotification(this.aCE, i);
    }

    public void De() {
        NotificationHelper.cancelNotification(this.aCE, 30);
    }

    public void fD(String str) {
        if (TextUtils.isEmpty(str)) {
            Dc();
            return;
        }
        e Dt = Dt();
        if (Dt == null) {
            Dc();
            return;
        }
        HashMap<String, String> EE = Dt.EE();
        if (EE == null || EE.isEmpty()) {
            Dc();
        } else if (EE.containsKey(str)) {
            Dc();
        }
    }

    public void fE(String str) {
        if (TextUtils.isEmpty(str)) {
            Dc();
            return;
        }
        e Dt = Dt();
        if (Dt == null) {
            Dc();
            return;
        }
        HashMap<String, String> EK = Dt.EK();
        if (EK == null || EK.isEmpty()) {
            Dc();
        } else if (EK.containsKey(str)) {
            Dc();
        }
    }

    private boolean Df() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Dg() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void Dh() {
        NotificationHelper.cancelNotification(this.aCE, 17);
    }

    public void dU(int i) {
        e Dt = Dt();
        if (Dt == null) {
            Dh();
        } else if (1 == i) {
            if (Dt.Er() <= 0) {
                Dh();
            }
        } else if (2 == i && Dt.Et() <= 0) {
            Dh();
        }
    }

    public void Di() {
        NotificationHelper.cancelNotification(this.aCE, 18);
    }

    public void Dj() {
        NotificationHelper.cancelNotification(this.aCE, 26);
        NotificationHelper.cancelNotification(this.aCE, 25);
        NotificationHelper.cancelNotification(this.aCE, 24);
        NotificationHelper.cancelNotification(this.aCE, 23);
        NotificationHelper.cancelNotification(this.aCE, 16);
        NotificationHelper.cancelNotification(this.aCE, 17);
        NotificationHelper.cancelNotification(this.aCE, 29);
    }

    public void Dk() {
        NotificationHelper.cancelNotification(this.aCE, 17);
        NotificationHelper.cancelNotification(this.aCE, 19);
        NotificationHelper.cancelNotification(this.aCE, 16);
        NotificationHelper.cancelNotification(this.aCE, 18);
        NotificationHelper.cancelNotification(this.aCE, 30);
    }

    public void Dl() {
        NotificationHelper.cancelNotification(this.aCE, 24);
    }

    public void Dm() {
        NotificationHelper.cancelNotification(this.aCE, 25);
    }

    public void Dn() {
        NotificationHelper.cancelNotification(this.aCE, 29);
    }

    public void Do() {
        NotificationHelper.cancelNotification(this.aCE, 23);
    }

    public void Dp() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(Dq());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Dr());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aCN.EI());
        newsNotifyMessage.setMsgStrangerChat(this.aCN.EN());
        newsNotifyMessage.setMsgOfficialMerge(this.aCN.EM());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(Dq());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.EI() + eVar.Eq()) + eVar.EN()) + eVar.EM()) + eVar.EP()) - eVar.Ex());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.EI());
            newsNotifyMessage.setMsgStrangerChat(eVar.EN());
            newsNotifyMessage.setMsgOfficialMerge(eVar.EM());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aCG;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aCF, i, this.aCH, this.aCI, this.aCK, this.aCJ, this.aCL);
        }
    }

    public int getMsgAtme() {
        return this.aCH;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aCF, this.aCG, i, this.aCI, this.aCK, this.aCJ, this.aCL);
        }
    }

    public int Dq() {
        return this.aCF;
    }

    public void dV(int i) {
        if (i >= 0) {
            a(i, this.aCG, this.aCH, this.aCI, this.aCK, this.aCJ, this.aCL);
        }
    }

    public int getMsgChat() {
        return this.aCI;
    }

    public int Dr() {
        return ((((this.aCN.EI() + this.aCN.Eq()) + this.aCN.EN()) + this.aCN.EM()) + this.aCN.EP()) - this.aCN.Ex();
    }

    public int getMsgFans() {
        return this.aCK;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aCF, this.aCG, this.aCH, this.aCI, i, this.aCJ, this.aCL);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aCF, this.aCG, this.aCH, i, this.aCK, this.aCJ, this.aCL);
        }
    }

    public int getMsgBookmark() {
        return this.aCJ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aCF, this.aCG, this.aCH, this.aCI, this.aCK, i, this.aCL);
        }
    }

    public int getMsgGiftNum() {
        return this.aCL;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aCL = i;
        }
    }

    public void ba(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aCF = 0;
        this.aCG = 0;
        this.aCH = 0;
        this.aCI = 0;
        this.aCK = 0;
        this.aCJ = 0;
    }

    public int Ds() {
        return this.aCF + this.aCG + this.aCH + this.aCI + this.aCK + this.aCL;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aCN = eVar;
            this.aCI = (eVar.Eq() - eVar.Ex()) + eVar.EI() + eVar.EM() + eVar.EP();
            a(eVar);
            if (eVar.Ey()) {
                this.aCO = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ey()) {
                if (c.DE().DT() && c.DE().DH() > 0) {
                    i = eVar.Eq() - eVar.Ex();
                }
                long EI = (!c.DE().DM() || c.DE().DH() <= 0) ? 0L : eVar.EI();
                if ((i > 0 || EI > 0) && ((i > eVar.EB() - eVar.Ex() && i > 0) || EI > eVar.Ev())) {
                    a(1, 16, eVar);
                }
                int Eu = eVar.Eu();
                if (Eu > 0 && Eu > eVar.EH()) {
                    a(1, 19, eVar);
                }
                if (eVar.Er() > eVar.EF() || eVar.Et() > eVar.EG()) {
                    if (eVar.Er() <= eVar.EF() || eVar.Et() != eVar.EG() || !Dg()) {
                        if (eVar.Er() != eVar.EF() || eVar.Et() <= eVar.EG() || !Df()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e Dt() {
        return this.aCN;
    }

    public void c(e eVar) {
        this.aCN = eVar;
    }

    public e Du() {
        return this.aCO;
    }

    public int dW(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aCE, 26, i);
        }
    }

    public HashMap<Integer, HashSet> Dv() {
        JSONArray jSONArray;
        if (!aCB && aCC) {
            return this.aCD;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aCD.get(0) == null) {
                this.aCD.put(0, new HashSet());
            }
            this.aCD.get(0).add("3222425470");
            return this.aCD;
        }
        if (this.aCD.get(0) != null) {
            this.aCD.get(0).clear();
        }
        if (this.aCD.get(1) != null) {
            this.aCD.get(1).clear();
        }
        if (this.aCD.get(2) != null) {
            this.aCD.get(2).clear();
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
                        if (this.aCD.get(0) == null) {
                            this.aCD.put(0, new HashSet());
                        }
                        this.aCD.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aCD.get(1) == null) {
                            this.aCD.put(1, new HashSet());
                        }
                        this.aCD.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aCD.get(2) == null) {
                            this.aCD.put(2, new HashSet());
                        }
                        this.aCD.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aCC = true;
        aCB = false;
        return this.aCD;
    }

    public HashSet<String> Dw() {
        Dv();
        return this.aCD.get(0);
    }

    public HashSet<String> Dx() {
        Dv();
        return this.aCD.get(1);
    }

    public HashSet<String> Dy() {
        Dv();
        return this.aCD.get(2);
    }

    public String Dz() {
        HashSet<String> Dw = Dw();
        if (Dw != null) {
            Iterator<String> it = Dw.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
