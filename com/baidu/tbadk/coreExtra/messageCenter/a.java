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
import com.baidu.tieba.f;
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
    private static a aDF;
    private e aDH;
    private String aDK;
    private String aDL;
    private String aDM;
    public static boolean aDu = true;
    public static boolean aDv = false;
    private static Date aDI = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.Dl().b(a.Dl().DI());
            }
        }
    };
    private final HashMap<Integer, HashSet> aDw = new HashMap<>();
    private int aDy = 0;
    private int aDz = 0;
    private int aDA = 0;
    private int aDB = 0;
    private int aDC = 0;
    private int aDD = 0;
    private int aDE = 0;
    private e aDG = new e();
    private boolean aDJ = true;
    private final int[] aDN = new int[10];
    private final Context aDx = TbadkCoreApplication.getInst().getApp();

    public static a Dl() {
        if (aDF == null) {
            aDF = new a();
        }
        return aDF;
    }

    private a() {
    }

    public void r(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.aDL = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aDK = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aDM = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aDy || i2 != this.aDz || i3 != this.aDA || i4 != this.aDB || i5 != this.aDD || i6 != this.aDC || i7 != this.aDE) {
            int i8 = 0;
            if (i > this.aDy || i2 > this.aDz || i3 > this.aDA || i4 > this.aDB || i5 > this.aDD || i6 > this.aDC || i7 > this.aDE) {
                i8 = 1;
            } else if (i < this.aDy || i2 < this.aDz || i3 < this.aDA) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aDy && c.DS().Ei()) {
                i9 = 1;
            } else if (i < this.aDy) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aDz && c.DS().DZ()) {
                i10 = 1;
            } else if (i2 < this.aDz) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aDA && c.DS().DX()) {
                i11 = 1;
            } else if (i3 < this.aDA) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aDB) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aDD) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aDE) {
                i14 = 1;
            }
            this.aDy = i;
            this.aDz = i2;
            this.aDA = i3;
            this.aDB = i4;
            this.aDD = i5;
            this.aDC = i6;
            this.aDE = i7;
            if (DG() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                DD();
                F(i14, 23);
                F(i12, 16);
                F(i8, 17);
                F(i10, 24);
                F(i11, 25);
                F(i13, 26);
                F(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.aDy || i2 != this.aDz || i3 != this.aDA || i4 != this.aDB || i5 != this.aDD || this.aDE != i6) {
            this.aDy = i;
            this.aDz = i2;
            this.aDA = i3;
            this.aDB = i4;
            this.aDD = i5;
            this.aDE = i6;
            DD();
            if (DG() <= 0) {
                F(2, 16);
                F(2, 17);
            }
        }
    }

    public static boolean Dm() {
        if (aDI == null) {
            aDI = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aDI.getTime() < 10000) {
                return false;
            }
            aDI = date;
        }
        return true;
    }

    public static boolean Dn() {
        if (c.DS().Ed()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.DS().Ef().split(SystemInfoUtil.COLON);
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.DS().Eg().split(SystemInfoUtil.COLON);
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
                    if (this.aDE > 0) {
                        String format = String.format(this.aDx.getString(f.j.notify_gift), String.valueOf(this.aDE));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aDy > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.aDx.getString(f.j.notify_agree), Integer.valueOf(this.aDy)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aDz > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aDz > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aDz));
                            sb2.append(this.aDx.getString(f.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aDL != null) {
                            sb2.append(this.aDL);
                        } else {
                            sb2.append(this.aDx.getString(f.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aDA > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aDA > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aDA));
                            sb3.append(this.aDx.getString(f.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aDM != null) {
                            sb3.append(this.aDM);
                        } else {
                            sb3.append(this.aDx.getString(f.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aDD > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.aDx.getString(f.j.notify_fans), Integer.valueOf(this.aDD)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.DS().Eh() || c.DS().DV() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.aDx, 16);
                NotificationHelper.cancelNotification(this.aDx, 17);
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
        String EO;
        String EN;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aDE > 0) {
                            String format = String.format(this.aDx.getString(f.j.notify_gift), String.valueOf(this.aDE));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aDy > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aDy > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aDy));
                                sb.append(this.aDx.getString(f.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.aDK != null) {
                                sb.append(this.aDK);
                            } else {
                                sb.append(this.aDx.getString(f.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aDz > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aDz > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aDz));
                                sb2.append(this.aDx.getString(f.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aDL != null) {
                                sb2.append(this.aDL);
                            } else {
                                sb2.append(this.aDx.getString(f.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aDA > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aDA > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aDA));
                                sb3.append(this.aDx.getString(f.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aDM != null) {
                                sb3.append(this.aDM);
                            } else {
                                sb3.append(this.aDx.getString(f.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aDD > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aDD > 1) {
                                sb4.append(String.format(this.aDx.getString(f.j.notify_fans_unit), Integer.valueOf(this.aDD)));
                            }
                            sb4.append(this.aDx.getString(f.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int EE = (!c.DS().Eh() || c.DS().DV() <= 0) ? 0 : eVar.EE() - eVar.EL();
                        long EW = (!c.DS().Ea() || c.DS().DV() <= 0) ? 0L : eVar.EW();
                        boolean z4 = EW > 0;
                        long j = EE + EW;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.aDx.getString(f.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.EZ();
                            eVar.EX();
                            if (EW == 1) {
                                EO = eVar.EZ();
                                str = eVar.EX();
                                EN = EO + "：" + str;
                            } else if (EE == 1) {
                                EO = eVar.EO();
                                EN = eVar.EN();
                                str = EN;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.aDx.getString(f.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(EN)) {
                                EN = str;
                            }
                            a(16, EO, str, EN, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> Fc = eVar.Fc();
                        if (Fc != null && Fc.size() != 0) {
                            for (e.a aVar : Fc) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ap.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aFu && aVar.aFv == null) {
                                    DJ();
                                    if (DK().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.DS().Eh() && c.DS().DV() > 0 && eVar.EF() + eVar.EH() > 0) {
                        if (eVar.EF() > 0 && !Du()) {
                            long EF = eVar.EF() - eVar.EG();
                            if (EF > 0) {
                                stringBuffer.append(String.format(this.aDx.getString(f.j.notify_updates), Long.valueOf(EF)));
                                z = false;
                                z2 = true;
                            } else if (eVar.EG() > 0) {
                                z = true;
                            }
                            if (eVar.EH() > 0 || Dt()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.aDx.getString(f.j.notify_validate), Integer.valueOf(eVar.EH())));
                            } else {
                                stringBuffer.append(String.format(this.aDx.getString(f.j.notify_validate_1), Integer.valueOf(eVar.EH())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.EQ(), eVar.ER(), eVar.ER());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.EH() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.aDx, 16);
                    NotificationHelper.cancelNotification(this.aDx, 17);
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
            a = c(aVar);
        }
        if (a == null) {
            a = b(aVar);
        }
        if (a != null) {
            a.putExtra("KeyOfNotiId", i);
            a.setFlags(268435456);
            PendingIntent service = PendingIntent.getService(this.aDx, i, a, 134217728);
            a(dZ(i), i);
            NotificationHelper.showNotification(this.aDx, i, aVar.title, aVar.content, aVar.aFs, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aDJ) {
            if (i == 23 && this.aDE > 0) {
                h = dU(i);
            } else if (i == 26 && this.aDD > 0) {
                h = dV(i);
            } else if (i == 18) {
                h = Do();
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
            PendingIntent service = PendingIntent.getService(this.aDx, i, h, 134217728);
            a(dZ(i), i);
            NotificationHelper.showNotification(this.aDx, i, str, str2, str3, service, false);
        }
    }

    public Intent dU(int i) {
        Intent intent = new Intent(this.aDx, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aDE);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent dV(int i) {
        Intent intent = new Intent(this.aDx, DealIntentService.class);
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
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLV().an(aVar.gid, aVar.userType);
        if (an == null || an.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = an.getLastTaskId();
            jSONArray = new JSONArray(an.getLastContentRawData());
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
                        intent = new Intent(this.aDx, DealIntentService.class);
                        intent.putExtra("class", 1);
                        intent.putExtra("id", group);
                        intent.putExtra("is_from_push", true);
                        intent.putExtra("key_start_from", 7);
                        intent.putExtra("gid", aVar.gid);
                        intent.putExtra("task_id", lastTaskId);
                    }
                    intent = null;
                } else if (optString.contains("mo/q/hotMessage")) {
                    intent = new Intent(this.aDx, DealIntentService.class);
                    intent.putExtra("class", 30);
                    intent.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                    intent.putExtra("task_id", lastTaskId);
                } else {
                    if (optString.contains("open_wb_view=1")) {
                        intent = new Intent(this.aDx, DealIntentService.class);
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
        Intent intent = new Intent(this.aDx, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.aFt);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.aDx, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> DJ = DJ();
        String str = aVar.gid;
        if (DJ != null && !ap.isEmpty(str)) {
            HashSet<String> DK = DK();
            HashSet<String> DL = DL();
            HashSet<String> DM = DM();
            if (DK != null && DK.contains(str)) {
                return b(aVar, 3);
            }
            if (DL != null && DL.contains(str)) {
                return b(aVar, 1);
            }
            if (DM != null && DM.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aDG.EY().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.aDx, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aDy);
        intent.putExtra("at_me", this.aDA);
        intent.putExtra("reply_me", this.aDz);
        intent.putExtra("fans", this.aDD);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aDG.EE() - this.aDG.EL());
        intent.putExtra("group_msg_validate", this.aDG.EH());
        intent.putExtra("group_msg_updates", this.aDG.EF());
        intent.putExtra("officialbar_msg", this.aDG.EI());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Do() {
        Intent intent = new Intent(this.aDx, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aDG.EG());
        return intent;
    }

    public void Dp() {
        NotificationHelper.cancelNotification(this.aDx, 23);
        NotificationHelper.cancelNotification(this.aDx, 24);
        NotificationHelper.cancelNotification(this.aDx, 25);
        NotificationHelper.cancelNotification(this.aDx, 29);
        NotificationHelper.cancelNotification(this.aDx, 26);
        NotificationHelper.cancelNotification(this.aDx, 17);
        NotificationHelper.cancelNotification(this.aDx, 15);
        NotificationHelper.cancelNotification(this.aDx, 13);
        NotificationHelper.cancelNotification(this.aDx, 12);
    }

    public void Dq() {
        NotificationHelper.cancelNotification(this.aDx, 16);
    }

    public void Dr() {
        NotificationHelper.cancelNotification(this.aDx, 19);
    }

    public void dW(int i) {
        NotificationHelper.cancelNotification(this.aDx, i);
    }

    public void Ds() {
        NotificationHelper.cancelNotification(this.aDx, 30);
    }

    public void fF(String str) {
        if (TextUtils.isEmpty(str)) {
            Dq();
            return;
        }
        e DH = DH();
        if (DH == null) {
            Dq();
            return;
        }
        HashMap<String, String> ES = DH.ES();
        if (ES == null || ES.isEmpty()) {
            Dq();
        } else if (ES.containsKey(str)) {
            Dq();
        }
    }

    public void fG(String str) {
        if (TextUtils.isEmpty(str)) {
            Dq();
            return;
        }
        e DH = DH();
        if (DH == null) {
            Dq();
            return;
        }
        HashMap<String, String> EY = DH.EY();
        if (EY == null || EY.isEmpty()) {
            Dq();
        } else if (EY.containsKey(str)) {
            Dq();
        }
    }

    private boolean Dt() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Du() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void Dv() {
        NotificationHelper.cancelNotification(this.aDx, 17);
    }

    public void dX(int i) {
        e DH = DH();
        if (DH == null) {
            Dv();
        } else if (1 == i) {
            if (DH.EF() <= 0) {
                Dv();
            }
        } else if (2 == i && DH.EH() <= 0) {
            Dv();
        }
    }

    public void Dw() {
        NotificationHelper.cancelNotification(this.aDx, 18);
    }

    public void Dx() {
        NotificationHelper.cancelNotification(this.aDx, 26);
        NotificationHelper.cancelNotification(this.aDx, 25);
        NotificationHelper.cancelNotification(this.aDx, 24);
        NotificationHelper.cancelNotification(this.aDx, 23);
        NotificationHelper.cancelNotification(this.aDx, 16);
        NotificationHelper.cancelNotification(this.aDx, 17);
        NotificationHelper.cancelNotification(this.aDx, 29);
    }

    public void Dy() {
        NotificationHelper.cancelNotification(this.aDx, 17);
        NotificationHelper.cancelNotification(this.aDx, 19);
        NotificationHelper.cancelNotification(this.aDx, 16);
        NotificationHelper.cancelNotification(this.aDx, 18);
        NotificationHelper.cancelNotification(this.aDx, 30);
    }

    public void Dz() {
        NotificationHelper.cancelNotification(this.aDx, 24);
    }

    public void DA() {
        NotificationHelper.cancelNotification(this.aDx, 25);
    }

    public void DB() {
        NotificationHelper.cancelNotification(this.aDx, 29);
    }

    public void DC() {
        NotificationHelper.cancelNotification(this.aDx, 23);
    }

    public void DD() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(DE());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(DF());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aDG.EW());
        newsNotifyMessage.setMsgStrangerChat(this.aDG.Fb());
        newsNotifyMessage.setMsgOfficialMerge(this.aDG.Fa());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(DE());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.EW() + eVar.EE()) + eVar.Fb()) + eVar.Fa()) + eVar.Fd()) - eVar.EL());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.EW());
            newsNotifyMessage.setMsgStrangerChat(eVar.Fb());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Fa());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aDz;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aDy, i, this.aDA, this.aDB, this.aDD, this.aDC, this.aDE);
        }
    }

    public int getMsgAtme() {
        return this.aDA;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aDy, this.aDz, i, this.aDB, this.aDD, this.aDC, this.aDE);
        }
    }

    public int DE() {
        return this.aDy;
    }

    public void dY(int i) {
        if (i >= 0) {
            a(i, this.aDz, this.aDA, this.aDB, this.aDD, this.aDC, this.aDE);
        }
    }

    public int getMsgChat() {
        return this.aDB;
    }

    public int DF() {
        return ((((this.aDG.EW() + this.aDG.EE()) + this.aDG.Fb()) + this.aDG.Fa()) + this.aDG.Fd()) - this.aDG.EL();
    }

    public int getMsgFans() {
        return this.aDD;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aDy, this.aDz, this.aDA, this.aDB, i, this.aDC, this.aDE);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aDy, this.aDz, this.aDA, i, this.aDD, this.aDC, this.aDE);
        }
    }

    public int getMsgBookmark() {
        return this.aDC;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aDy, this.aDz, this.aDA, this.aDB, this.aDD, i, this.aDE);
        }
    }

    public int getMsgGiftNum() {
        return this.aDE;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aDE = i;
        }
    }

    public void bc(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aDy = 0;
        this.aDz = 0;
        this.aDA = 0;
        this.aDB = 0;
        this.aDD = 0;
        this.aDC = 0;
    }

    public int DG() {
        return this.aDy + this.aDz + this.aDA + this.aDB + this.aDD + this.aDE;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aDG = eVar;
            this.aDB = (eVar.EE() - eVar.EL()) + eVar.EW() + eVar.Fa() + eVar.Fd();
            a(eVar);
            if (eVar.EM()) {
                this.aDH = null;
                mHandler.removeMessages(0);
            }
            if (eVar.EM()) {
                if (c.DS().Eh() && c.DS().DV() > 0) {
                    i = eVar.EE() - eVar.EL();
                }
                long EW = (!c.DS().Ea() || c.DS().DV() <= 0) ? 0L : eVar.EW();
                if ((i > 0 || EW > 0) && ((i > eVar.EP() - eVar.EL() && i > 0) || EW > eVar.EJ())) {
                    a(1, 16, eVar);
                }
                int EI = eVar.EI();
                if (EI > 0 && EI > eVar.EV()) {
                    a(1, 19, eVar);
                }
                if (eVar.EF() > eVar.ET() || eVar.EH() > eVar.EU()) {
                    if (eVar.EF() <= eVar.ET() || eVar.EH() != eVar.EU() || !Du()) {
                        if (eVar.EF() != eVar.ET() || eVar.EH() <= eVar.EU() || !Dt()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e DH() {
        return this.aDG;
    }

    public void c(e eVar) {
        this.aDG = eVar;
    }

    public e DI() {
        return this.aDH;
    }

    public int dZ(int i) {
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
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 16, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 17, i);
        } else if (2 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 12, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 13, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 15, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 18, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 19, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 28, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 2000, i);
        } else if (3 == j) {
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 29, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 23, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 24, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 25, i);
            NotificationHelper.cancelNotificationExceptSpecific(this.aDx, 26, i);
        }
    }

    public HashMap<Integer, HashSet> DJ() {
        JSONArray jSONArray;
        if (!aDu && aDv) {
            return this.aDw;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aDw.get(0) == null) {
                this.aDw.put(0, new HashSet());
            }
            this.aDw.get(0).add("3222425470");
            return this.aDw;
        }
        if (this.aDw.get(0) != null) {
            this.aDw.get(0).clear();
        }
        if (this.aDw.get(1) != null) {
            this.aDw.get(1).clear();
        }
        if (this.aDw.get(2) != null) {
            this.aDw.get(2).clear();
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
                        if (this.aDw.get(0) == null) {
                            this.aDw.put(0, new HashSet());
                        }
                        this.aDw.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aDw.get(1) == null) {
                            this.aDw.put(1, new HashSet());
                        }
                        this.aDw.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aDw.get(2) == null) {
                            this.aDw.put(2, new HashSet());
                        }
                        this.aDw.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aDv = true;
        aDu = false;
        return this.aDw;
    }

    public HashSet<String> DK() {
        DJ();
        return this.aDw.get(0);
    }

    public HashSet<String> DL() {
        DJ();
        return this.aDw.get(1);
    }

    public HashSet<String> DM() {
        DJ();
        return this.aDw.get(2);
    }

    public String DN() {
        HashSet<String> DK = DK();
        if (DK != null) {
            Iterator<String> it = DK.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
