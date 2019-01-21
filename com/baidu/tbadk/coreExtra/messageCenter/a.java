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
    private static a aQj;
    private e aQl;
    private String aQo;
    private String aQp;
    private String aQq;
    public static boolean aPZ = true;
    public static boolean aQa = false;
    private static Date aQm = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.If().b(a.If().IC());
            }
        }
    };
    private final HashMap<Integer, HashSet> aQb = new HashMap<>();
    private int aQc = 0;
    private int aQd = 0;
    private int aQe = 0;
    private int aQf = 0;
    private int aQg = 0;
    private int aQh = 0;
    private int aQi = 0;
    private e aQk = new e();
    private boolean aQn = true;
    private final int[] aQr = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static a If() {
        if (aQj == null) {
            aQj = new a();
        }
        return aQj;
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
                    this.aQp = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.aQo = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.aQq = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.aQc || i2 != this.aQd || i3 != this.aQe || i4 != this.aQf || i5 != this.aQh || i6 != this.aQg || i7 != this.aQi) {
            int i8 = 0;
            if (i > this.aQc || i2 > this.aQd || i3 > this.aQe || i4 > this.aQf || i5 > this.aQh || i6 > this.aQg || i7 > this.aQi) {
                i8 = 1;
            } else if (i < this.aQc || i2 < this.aQd || i3 < this.aQe) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.aQc && c.IM().Jd()) {
                i9 = 1;
            } else if (i < this.aQc) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.aQd && c.IM().IT()) {
                i10 = 1;
            } else if (i2 < this.aQd) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.aQe && c.IM().IR()) {
                i11 = 1;
            } else if (i3 < this.aQe) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.aQf) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.aQh) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.aQi) {
                i14 = 1;
            }
            this.aQc = i;
            this.aQd = i2;
            this.aQe = i3;
            this.aQf = i4;
            this.aQh = i5;
            this.aQg = i6;
            this.aQi = i7;
            if (IA() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Ix();
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
        if (i != this.aQc || i2 != this.aQd || i3 != this.aQe || i4 != this.aQf || i5 != this.aQh || this.aQi != i6) {
            this.aQc = i;
            this.aQd = i2;
            this.aQe = i3;
            this.aQf = i4;
            this.aQh = i5;
            this.aQi = i6;
            Ix();
            if (IA() <= 0) {
                I(2, 16);
                I(2, 17);
            }
        }
    }

    public static boolean Ig() {
        if (aQm == null) {
            aQm = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - aQm.getTime() < ErrDef.Feature.WEIGHT) {
                return false;
            }
            aQm = date;
        }
        return true;
    }

    public static boolean Ih() {
        if (c.IM().IX()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.IM().IZ().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.IM().Ja().split(":");
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
                    if (this.aQi > 0) {
                        String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aQi));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.aQc > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(e.j.notify_agree), Integer.valueOf(this.aQc)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.aQd > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.aQd > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.aQd));
                            sb2.append(this.appContext.getString(e.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.aQp != null) {
                            sb2.append(this.aQp);
                        } else {
                            sb2.append(this.appContext.getString(e.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.aQe > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.aQe > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.aQe));
                            sb3.append(this.appContext.getString(e.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.aQq != null) {
                            sb3.append(this.aQq);
                        } else {
                            sb3.append(this.appContext.getString(e.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.aQh > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(e.j.notify_fans), Integer.valueOf(this.aQh)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.IM().Jc() || c.IM().IP() > 0) {
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
        String JL;
        String JK;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.aQi > 0) {
                            String format = String.format(this.appContext.getString(e.j.notify_gift), String.valueOf(this.aQi));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.aQc > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.aQc > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.aQc));
                                sb.append(this.appContext.getString(e.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.aQo != null) {
                                sb.append(this.aQo);
                            } else {
                                sb.append(this.appContext.getString(e.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.aQd > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.aQd > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.aQd));
                                sb2.append(this.appContext.getString(e.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.aQp != null) {
                                sb2.append(this.aQp);
                            } else {
                                sb2.append(this.appContext.getString(e.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.aQe > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.aQe > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.aQe));
                                sb3.append(this.appContext.getString(e.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.aQq != null) {
                                sb3.append(this.aQq);
                            } else {
                                sb3.append(this.appContext.getString(e.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.aQh > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.aQh > 1) {
                                sb4.append(String.format(this.appContext.getString(e.j.notify_fans_unit), Integer.valueOf(this.aQh)));
                            }
                            sb4.append(this.appContext.getString(e.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int JB = (!c.IM().Jc() || c.IM().IP() <= 0) ? 0 : eVar.JB() - eVar.JI();
                        long JT = (!c.IM().IU() || c.IM().IP() <= 0) ? 0L : eVar.JT();
                        boolean z4 = JT > 0;
                        long j = JB + JT;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j)));
                            b(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.JW();
                            eVar.JU();
                            if (JT == 1) {
                                JL = eVar.JW();
                                str = eVar.JU();
                                JK = JL + "：" + str;
                            } else if (JB == 1) {
                                JL = eVar.JL();
                                JK = eVar.JK();
                                str = JK;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(e.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(JK)) {
                                JK = str;
                            }
                            b(16, JL, str, JK, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> JZ = eVar.JZ();
                        if (JZ != null && JZ.size() != 0) {
                            for (e.a aVar : JZ) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ao.isEmpty(aVar.gid) && aVar.unReadCount > aVar.aSg && aVar.aSh == null) {
                                    ID();
                                    if (IE().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (c.IM().Jc() && c.IM().IP() > 0 && eVar.JC() + eVar.JE() > 0) {
                        if (eVar.JC() > 0 && !Io()) {
                            long JC = eVar.JC() - eVar.JD();
                            if (JC > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_updates), Long.valueOf(JC)));
                                z = false;
                                z2 = true;
                            } else if (eVar.JD() > 0) {
                                z = true;
                            }
                            if (eVar.JE() > 0 || In()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate), Integer.valueOf(eVar.JE())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(e.j.notify_validate_1), Integer.valueOf(eVar.JE())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.JN(), eVar.JO(), eVar.JO());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.JE() > 0) {
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
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.aSe, service, false);
        }
    }

    private void b(int i, String str, String str2, String str3, boolean z) {
        Intent h;
        if (this.aQn) {
            if (i == 23 && this.aQi > 0) {
                h = eS(i);
            } else if (i == 26 && this.aQh > 0) {
                h = eT(i);
            } else if (i == 18) {
                h = Ii();
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
        intent.putExtra("gift_num", this.aQi);
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
        ImMessageCenterPojo ay = com.baidu.tieba.im.memorycache.b.aUa().ay(aVar.gid, aVar.userType);
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
        intent.putExtra("uname", aVar.aSf);
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
        HashMap<Integer, HashSet> ID = ID();
        String str = aVar.gid;
        if (ID != null && !ao.isEmpty(str)) {
            HashSet<String> IE = IE();
            HashSet<String> IF = IF();
            HashSet<String> IG = IG();
            if (IE != null && IE.contains(str)) {
                return b(aVar, 3);
            }
            if (IF != null && IF.contains(str)) {
                return b(aVar, 1);
            }
            if (IG != null && IG.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent h(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.aQk.JV().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.aQc);
        intent.putExtra("at_me", this.aQe);
        intent.putExtra("reply_me", this.aQd);
        intent.putExtra("fans", this.aQh);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.aQk.JB() - this.aQk.JI());
        intent.putExtra("group_msg_validate", this.aQk.JE());
        intent.putExtra("group_msg_updates", this.aQk.JC());
        intent.putExtra("officialbar_msg", this.aQk.JF());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent Ii() {
        Intent intent = new Intent(this.appContext, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.aQk.JD());
        return intent;
    }

    public void Ij() {
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

    public void Ik() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void Il() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void eU(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void Im() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void gX(String str) {
        if (TextUtils.isEmpty(str)) {
            Ik();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e IB = IB();
        if (IB == null) {
            Ik();
            return;
        }
        HashMap<String, String> JP = IB.JP();
        if (JP == null || JP.isEmpty()) {
            Ik();
        } else if (JP.containsKey(str)) {
            Ik();
        }
    }

    public void gY(String str) {
        if (TextUtils.isEmpty(str)) {
            Ik();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e IB = IB();
        if (IB == null) {
            Ik();
            return;
        }
        HashMap<String, String> JV = IB.JV();
        if (JV == null || JV.isEmpty()) {
            Ik();
        } else if (JV.containsKey(str)) {
            Ik();
        }
    }

    private boolean In() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean Io() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void Ip() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void eV(int i) {
        com.baidu.tbadk.coreExtra.model.e IB = IB();
        if (IB == null) {
            Ip();
        } else if (1 == i) {
            if (IB.JC() <= 0) {
                Ip();
            }
        } else if (2 == i && IB.JE() <= 0) {
            Ip();
        }
    }

    public void Iq() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void Ir() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void Is() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void It() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void Iu() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void Iv() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void Iw() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void Ix() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(Iy());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Iz());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.aQk.JT());
        newsNotifyMessage.setMsgStrangerChat(this.aQk.JY());
        newsNotifyMessage.setMsgOfficialMerge(this.aQk.JX());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(Iy());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.JT() + eVar.JB()) + eVar.JY()) + eVar.JX()) + eVar.Ka()) - eVar.JI());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.JT());
            newsNotifyMessage.setMsgStrangerChat(eVar.JY());
            newsNotifyMessage.setMsgOfficialMerge(eVar.JX());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.aQd;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.aQc, i, this.aQe, this.aQf, this.aQh, this.aQg, this.aQi);
        }
    }

    public int getMsgAtme() {
        return this.aQe;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.aQc, this.aQd, i, this.aQf, this.aQh, this.aQg, this.aQi);
        }
    }

    public int Iy() {
        return this.aQc;
    }

    public void eW(int i) {
        if (i >= 0) {
            a(i, this.aQd, this.aQe, this.aQf, this.aQh, this.aQg, this.aQi);
        }
    }

    public int getMsgChat() {
        return this.aQf;
    }

    public int Iz() {
        return ((((this.aQk.JT() + this.aQk.JB()) + this.aQk.JY()) + this.aQk.JX()) + this.aQk.Ka()) - this.aQk.JI();
    }

    public int getMsgFans() {
        return this.aQh;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.aQc, this.aQd, this.aQe, this.aQf, i, this.aQg, this.aQi);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.aQc, this.aQd, this.aQe, i, this.aQh, this.aQg, this.aQi);
        }
    }

    public int getMsgBookmark() {
        return this.aQg;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.aQc, this.aQd, this.aQe, this.aQf, this.aQh, i, this.aQi);
        }
    }

    public int getMsgGiftNum() {
        return this.aQi;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.aQi = i;
        }
    }

    public void bQ(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.aQc = 0;
        this.aQd = 0;
        this.aQe = 0;
        this.aQf = 0;
        this.aQh = 0;
        this.aQg = 0;
    }

    public int IA() {
        return this.aQc + this.aQd + this.aQe + this.aQf + this.aQh + this.aQi;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.aQk = eVar;
            this.aQf = (eVar.JB() - eVar.JI()) + eVar.JT() + eVar.JX() + eVar.Ka();
            a(eVar);
            if (eVar.JJ()) {
                this.aQl = null;
                mHandler.removeMessages(0);
            }
            if (eVar.JJ()) {
                if (c.IM().Jc() && c.IM().IP() > 0) {
                    i = eVar.JB() - eVar.JI();
                }
                long JT = (!c.IM().IU() || c.IM().IP() <= 0) ? 0L : eVar.JT();
                if ((i > 0 || JT > 0) && ((i > eVar.JM() - eVar.JI() && i > 0) || JT > eVar.JG())) {
                    a(1, 16, eVar);
                }
                int JF = eVar.JF();
                if (JF > 0 && JF > eVar.JS()) {
                    a(1, 19, eVar);
                }
                if (eVar.JC() > eVar.JQ() || eVar.JE() > eVar.JR()) {
                    if (eVar.JC() <= eVar.JQ() || eVar.JE() != eVar.JR() || !Io()) {
                        if (eVar.JC() != eVar.JQ() || eVar.JE() <= eVar.JR() || !In()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e IB() {
        return this.aQk;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.aQk = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e IC() {
        return this.aQl;
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

    public HashMap<Integer, HashSet> ID() {
        JSONArray jSONArray;
        if (!aPZ && aQa) {
            return this.aQb;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.aQb.get(0) == null) {
                this.aQb.put(0, new HashSet());
            }
            this.aQb.get(0).add("3222425470");
            return this.aQb;
        }
        if (this.aQb.get(0) != null) {
            this.aQb.get(0).clear();
        }
        if (this.aQb.get(1) != null) {
            this.aQb.get(1).clear();
        }
        if (this.aQb.get(2) != null) {
            this.aQb.get(2).clear();
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
                        if (this.aQb.get(0) == null) {
                            this.aQb.put(0, new HashSet());
                        }
                        this.aQb.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.aQb.get(1) == null) {
                            this.aQb.put(1, new HashSet());
                        }
                        this.aQb.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.aQb.get(2) == null) {
                            this.aQb.put(2, new HashSet());
                        }
                        this.aQb.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        aQa = true;
        aPZ = false;
        return this.aQb;
    }

    public HashSet<String> IE() {
        ID();
        return this.aQb.get(0);
    }

    public HashSet<String> IF() {
        ID();
        return this.aQb.get(1);
    }

    public HashSet<String> IG() {
        ID();
        return this.aQb.get(2);
    }

    public String IH() {
        HashSet<String> IE = IE();
        if (IE != null) {
            Iterator<String> it = IE.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
