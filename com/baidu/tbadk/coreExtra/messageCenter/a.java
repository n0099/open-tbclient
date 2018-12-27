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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
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
    private static a aPE;
    private e aPG;
    private String aPJ;
    private String aPK;
    private String aPL;
    public static boolean aPu = true;
    public static boolean aPv = false;
    private static Date aPH = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.HQ().b(a.HQ().In());
            }
        }
    };
    private final HashMap<Integer, HashSet> aPw = new HashMap<>();
    private int aPx = 0;
    private int aPy = 0;
    private int aPz = 0;
    private int aPA = 0;
    private int aPB = 0;
    private int aPC = 0;
    private int aPD = 0;
    private e aPF = new e();
    private boolean aPI = true;
    private final int[] aPM = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static a HQ() {
        if (aPE == null) {
            aPE = new a();
        }
        return aPE;
    }

    private a() {
    }

    public void F(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.aPK = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aPJ = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aPL = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aPx || i2 != this.aPy || i3 != this.aPz || i4 != this.aPA || i5 != this.aPC || i6 != this.aPB || i7 != this.aPD) {
            int i8 = 0;
            if (i > this.aPx || i2 > this.aPy || i3 > this.aPz || i4 > this.aPA || i5 > this.aPC || i6 > this.aPB || i7 > this.aPD) {
                i8 = 1;
            } else if (i < this.aPx || i2 < this.aPy || i3 < this.aPz) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aPx && c.Ix().IO()) {
                i9 = 1;
            } else if (i < this.aPx) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aPy && c.Ix().IE()) {
                i10 = 1;
            } else if (i2 < this.aPy) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aPz && c.Ix().IC()) {
                i11 = 1;
            } else if (i3 < this.aPz) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aPA) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aPC) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aPD) {
                i14 = 1;
            }
            this.aPx = i;
            this.aPy = i2;
            this.aPz = i3;
            this.aPA = i4;
            this.aPC = i5;
            this.aPB = i6;
            this.aPD = i7;
            if (Il() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Ii();
                I(i14, 23);
                I(i12, 16);
                I(i8, 17);
                I(i10, 24);
                I(i11, 25);
                I(i13, 26);
                I(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.aPx || i2 != this.aPy || i3 != this.aPz || i4 != this.aPA || i5 != this.aPC || this.aPD != i6) {
            this.aPx = i;
            this.aPy = i2;
            this.aPz = i3;
            this.aPA = i4;
            this.aPC = i5;
            this.aPD = i6;
            Ii();
            if (Il() <= 0) {
                I(2, 16);
                I(2, 17);
            }
        }
    }

    public static boolean HR() {
        if (aPH == null) {
            aPH = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aPH.getTime() < ErrDef.Feature.WEIGHT) {
                return false;
            }
            aPH = date;
        }
        return true;
    }

    public static boolean HS() {
        if (c.Ix().II()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Ix().IK().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Ix().IL().split(":");
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

    private void I(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.aPD > 0) {
                        String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aPD));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aPx > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(e.j.notify_agree), Integer.valueOf(this.aPx)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aPy > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aPy > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aPy));
                            sb2.append(this.appContext.getString(e.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aPK != null) {
                            sb2.append(this.aPK);
                        } else {
                            sb2.append(this.appContext.getString(e.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aPz > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aPz > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aPz));
                            sb3.append(this.appContext.getString(e.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aPL != null) {
                            sb3.append(this.aPL);
                        } else {
                            sb3.append(this.appContext.getString(e.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aPC > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(e.j.notify_fans), Integer.valueOf(this.aPC)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Ix().IN() || c.Ix().IA() > 0) {
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
        String Jw;
        String Jv;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aPD > 0) {
                            String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aPD));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aPx > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aPx > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aPx));
                                sb.append(this.appContext.getString(e.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.aPJ != null) {
                                sb.append(this.aPJ);
                            } else {
                                sb.append(this.appContext.getString(e.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aPy > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aPy > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aPy));
                                sb2.append(this.appContext.getString(e.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aPK != null) {
                                sb2.append(this.aPK);
                            } else {
                                sb2.append(this.appContext.getString(e.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aPz > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aPz > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aPz));
                                sb3.append(this.appContext.getString(e.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aPL != null) {
                                sb3.append(this.aPL);
                            } else {
                                sb3.append(this.appContext.getString(e.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aPC > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aPC > 1) {
                                sb4.append(String.format(this.appContext.getString(e.j.notify_fans_unit), Integer.valueOf(this.aPC)));
                            }
                            sb4.append(this.appContext.getString(e.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int Jm = (!c.Ix().IN() || c.Ix().IA() <= 0) ? 0 : eVar.Jm() - eVar.Jt();
                        long JE = (!c.Ix().IF() || c.Ix().IA() <= 0) ? 0L : eVar.JE();
                        boolean z4 = JE > 0;
                        long j = Jm + JE;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j)));
                            b(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.JH();
                            eVar.JF();
                            if (JE == 1) {
                                Jw = eVar.JH();
                                str = eVar.JF();
                                Jv = Jw + "：" + str;
                            } else if (Jm == 1) {
                                Jw = eVar.Jw();
                                Jv = eVar.Jv();
                                str = Jv;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Jv)) {
                                Jv = str;
                            }
                            b(16, Jw, str, Jv, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> JK = eVar.JK();
                        if (JK != null && JK.size() != 0) {
                            for (e.a aVar : JK) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ao.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aRB && aVar.aRC == null) {
                                    Io();
                                    if (Ip().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.Ix().IN() && c.Ix().IA() > 0 && eVar.Jn() + eVar.Jp() > 0) {
                        if (eVar.Jn() > 0 && !HZ()) {
                            long Jn = eVar.Jn() - eVar.Jo();
                            if (Jn > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_updates), Long.valueOf(Jn)));
                                z = false;
                                z2 = true;
                            } else if (eVar.Jo() > 0) {
                                z = true;
                            }
                            if (eVar.Jp() > 0 || HY()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate), Integer.valueOf(eVar.Jp())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate_1), Integer.valueOf(eVar.Jp())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.Jy(), eVar.Jz(), eVar.Jz());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.Jp() > 0) {
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
            d(eX(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.aRz, service, false);
        }
    }

    private void b(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aPI) {
            if (i == 23 && this.aPD > 0) {
                h = eS(i);
            } else if (i == 26 && this.aPC > 0) {
                h = eT(i);
            } else if (i == 18) {
                h = HT();
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
            d(eX(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent eS(int i) {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.aPD);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent eT(int i) {
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
        ImMessageCenterPojo ay = com.baidu.tieba.im.memorycache.b.aTA().ay(aVar.gid, aVar.userType);
        if (ay == null || ay.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = ay.getLastTaskId();
            jSONArray = new JSONArray(ay.getLastContentRawData());
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
        intent.putExtra("uname", aVar.aRA);
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
        HashMap<Integer, HashSet> Io = Io();
        String str = aVar.gid;
        if (Io != null && !ao.isEmpty(str)) {
            HashSet<String> Ip = Ip();
            HashSet<String> Iq = Iq();
            HashSet<String> Ir = Ir();
            if (Ip != null && Ip.contains(str)) {
                return b(aVar, 3);
            }
            if (Iq != null && Iq.contains(str)) {
                return b(aVar, 1);
            }
            if (Ir != null && Ir.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aPF.JG().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aPx);
        intent.putExtra("at_me", this.aPz);
        intent.putExtra("reply_me", this.aPy);
        intent.putExtra("fans", this.aPC);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aPF.Jm() - this.aPF.Jt());
        intent.putExtra("group_msg_validate", this.aPF.Jp());
        intent.putExtra("group_msg_updates", this.aPF.Jn());
        intent.putExtra("officialbar_msg", this.aPF.Jq());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent HT() {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aPF.Jo());
        return intent;
    }

    public void HU() {
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

    public void HV() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void HW() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void eU(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void HX() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void gK(String str) {
        if (TextUtils.isEmpty(str)) {
            HV();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e Im = Im();
        if (Im == null) {
            HV();
            return;
        }
        HashMap<String, String> JA = Im.JA();
        if (JA == null || JA.isEmpty()) {
            HV();
        } else if (JA.containsKey(str)) {
            HV();
        }
    }

    public void gL(String str) {
        if (TextUtils.isEmpty(str)) {
            HV();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e Im = Im();
        if (Im == null) {
            HV();
            return;
        }
        HashMap<String, String> JG = Im.JG();
        if (JG == null || JG.isEmpty()) {
            HV();
        } else if (JG.containsKey(str)) {
            HV();
        }
    }

    private boolean HY() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean HZ() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void Ia() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void eV(int i) {
        com.baidu.tbadk.coreExtra.model.e Im = Im();
        if (Im == null) {
            Ia();
        } else if (1 == i) {
            if (Im.Jn() <= 0) {
                Ia();
            }
        } else if (2 == i && Im.Jp() <= 0) {
            Ia();
        }
    }

    public void Ib() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void Ic() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void Id() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void Ie() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void If() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void Ig() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void Ih() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void Ii() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(Ij());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Ik());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aPF.JE());
        newsNotifyMessage.setMsgStrangerChat(this.aPF.JJ());
        newsNotifyMessage.setMsgOfficialMerge(this.aPF.JI());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(Ij());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.JE() + eVar.Jm()) + eVar.JJ()) + eVar.JI()) + eVar.JL()) - eVar.Jt());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.JE());
            newsNotifyMessage.setMsgStrangerChat(eVar.JJ());
            newsNotifyMessage.setMsgOfficialMerge(eVar.JI());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aPy;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aPx, i, this.aPz, this.aPA, this.aPC, this.aPB, this.aPD);
        }
    }

    public int getMsgAtme() {
        return this.aPz;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aPx, this.aPy, i, this.aPA, this.aPC, this.aPB, this.aPD);
        }
    }

    public int Ij() {
        return this.aPx;
    }

    public void eW(int i) {
        if (i >= 0) {
            a(i, this.aPy, this.aPz, this.aPA, this.aPC, this.aPB, this.aPD);
        }
    }

    public int getMsgChat() {
        return this.aPA;
    }

    public int Ik() {
        return ((((this.aPF.JE() + this.aPF.Jm()) + this.aPF.JJ()) + this.aPF.JI()) + this.aPF.JL()) - this.aPF.Jt();
    }

    public int getMsgFans() {
        return this.aPC;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aPx, this.aPy, this.aPz, this.aPA, i, this.aPB, this.aPD);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aPx, this.aPy, this.aPz, i, this.aPC, this.aPB, this.aPD);
        }
    }

    public int getMsgBookmark() {
        return this.aPB;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aPx, this.aPy, this.aPz, this.aPA, this.aPC, i, this.aPD);
        }
    }

    public int getMsgGiftNum() {
        return this.aPD;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aPD = i;
        }
    }

    public void bP(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aPx = 0;
        this.aPy = 0;
        this.aPz = 0;
        this.aPA = 0;
        this.aPC = 0;
        this.aPB = 0;
    }

    public int Il() {
        return this.aPx + this.aPy + this.aPz + this.aPA + this.aPC + this.aPD;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aPF = eVar;
            this.aPA = (eVar.Jm() - eVar.Jt()) + eVar.JE() + eVar.JI() + eVar.JL();
            a(eVar);
            if (eVar.Ju()) {
                this.aPG = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ju()) {
                if (c.Ix().IN() && c.Ix().IA() > 0) {
                    i = eVar.Jm() - eVar.Jt();
                }
                long JE = (!c.Ix().IF() || c.Ix().IA() <= 0) ? 0L : eVar.JE();
                if ((i > 0 || JE > 0) && ((i > eVar.Jx() - eVar.Jt() && i > 0) || JE > eVar.Jr())) {
                    a(1, 16, eVar);
                }
                int Jq = eVar.Jq();
                if (Jq > 0 && Jq > eVar.JD()) {
                    a(1, 19, eVar);
                }
                if (eVar.Jn() > eVar.JB() || eVar.Jp() > eVar.JC()) {
                    if (eVar.Jn() <= eVar.JB() || eVar.Jp() != eVar.JC() || !HZ()) {
                        if (eVar.Jn() != eVar.JB() || eVar.Jp() <= eVar.JC() || !HY()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e Im() {
        return this.aPF;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.aPF = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e In() {
        return this.aPG;
    }

    public int eX(int i) {
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

    public HashMap<Integer, HashSet> Io() {
        JSONArray jSONArray;
        if (!aPu && aPv) {
            return this.aPw;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aPw.get(0) == null) {
                this.aPw.put(0, new HashSet());
            }
            this.aPw.get(0).add("3222425470");
            return this.aPw;
        }
        if (this.aPw.get(0) != null) {
            this.aPw.get(0).clear();
        }
        if (this.aPw.get(1) != null) {
            this.aPw.get(1).clear();
        }
        if (this.aPw.get(2) != null) {
            this.aPw.get(2).clear();
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
                        if (this.aPw.get(0) == null) {
                            this.aPw.put(0, new HashSet());
                        }
                        this.aPw.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aPw.get(1) == null) {
                            this.aPw.put(1, new HashSet());
                        }
                        this.aPw.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aPw.get(2) == null) {
                            this.aPw.put(2, new HashSet());
                        }
                        this.aPw.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aPv = true;
        aPu = false;
        return this.aPw;
    }

    public HashSet<String> Ip() {
        Io();
        return this.aPw.get(0);
    }

    public HashSet<String> Iq() {
        Io();
        return this.aPw.get(1);
    }

    public HashSet<String> Ir() {
        Io();
        return this.aPw.get(2);
    }

    public String Is() {
        HashSet<String> Ip = Ip();
        if (Ip != null) {
            Iterator<String> it = Ip.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
