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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
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
public class b {
    private static b bYM;
    private com.baidu.tbadk.coreExtra.model.e bYO;
    private String bYR;
    private String bYS;
    private String bYT;
    public static boolean bYC = true;
    public static boolean bYD = false;
    private static Date bYP = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.ahx().b(b.ahx().ahU());
            }
        }
    };
    private final HashMap<Integer, HashSet> bYE = new HashMap<>();
    private int bYF = 0;
    private int bYG = 0;
    private int bYH = 0;
    private int bYI = 0;
    private int bYJ = 0;
    private int bYK = 0;
    private int bYL = 0;
    private com.baidu.tbadk.coreExtra.model.e bYN = new com.baidu.tbadk.coreExtra.model.e();
    private boolean bYQ = true;
    private final int[] bYU = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b ahx() {
        if (bYM == null) {
            bYM = new b();
        }
        return bYM;
    }

    private b() {
    }

    public void aP(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.bYS = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.bYR = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bYT = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.bYF || i2 != this.bYG || i3 != this.bYH || i4 != this.bYI || i5 != this.bYK || i6 != this.bYJ || i7 != this.bYL) {
            int i8 = 0;
            if (i > this.bYF || i2 > this.bYG || i3 > this.bYH || i4 > this.bYI || i5 > this.bYK || i6 > this.bYJ || i7 > this.bYL) {
                i8 = 1;
            } else if (i < this.bYF || i2 < this.bYG || i3 < this.bYH) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.bYF && d.aie().aiv()) {
                i9 = 1;
            } else if (i < this.bYF) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.bYG && d.aie().ail()) {
                i10 = 1;
            } else if (i2 < this.bYG) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.bYH && d.aie().aij()) {
                i11 = 1;
            } else if (i3 < this.bYH) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.bYI) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.bYK) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.bYL) {
                i14 = 1;
            }
            this.bYF = i;
            this.bYG = i2;
            this.bYH = i3;
            this.bYI = i4;
            this.bYK = i5;
            this.bYJ = i6;
            this.bYL = i7;
            if (ahS() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                ahP();
                ae(i14, 23);
                ae(i12, 16);
                ae(i8, 17);
                ae(i10, 24);
                ae(i11, 25);
                ae(i13, 26);
                ae(i9, 29);
            }
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.bYF || i2 != this.bYG || i3 != this.bYH || i4 != this.bYI || i5 != this.bYK || this.bYL != i6) {
            this.bYF = i;
            this.bYG = i2;
            this.bYH = i3;
            this.bYI = i4;
            this.bYK = i5;
            this.bYL = i6;
            ahP();
            if (ahS() <= 0) {
                ae(2, 16);
                ae(2, 17);
            }
        }
    }

    public static boolean ahy() {
        if (bYP == null) {
            bYP = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - bYP.getTime() < 10000) {
                return false;
            }
            bYP = date;
        }
        return true;
    }

    public static boolean ahz() {
        if (d.aie().aip()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.aie().air().split(Config.TRACE_TODAY_VISIT_SPLIT);
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.aie().ais().split(Config.TRACE_TODAY_VISIT_SPLIT);
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

    private void ae(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.bYL > 0) {
                        String format = String.format(this.appContext.getString(d.j.notify_gift), String.valueOf(this.bYL));
                        c(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.bYF > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(d.j.notify_agree), Integer.valueOf(this.bYF)));
                        c(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.bYG > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.bYG > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.bYG));
                            sb2.append(this.appContext.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.bYS != null) {
                            sb2.append(this.bYS);
                        } else {
                            sb2.append(this.appContext.getString(d.j.notify_reply));
                        }
                        c(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.bYH > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.bYH > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.bYH));
                            sb3.append(this.appContext.getString(d.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.bYT != null) {
                            sb3.append(this.bYT);
                        } else {
                            sb3.append(this.appContext.getString(d.j.notify_at));
                        }
                        c(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.bYK > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(d.j.notify_fans), Integer.valueOf(this.bYK)));
                        c(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.aie().aiu() || d.aie().aih() > 0) {
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
        String ajf;
        String aje;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.bYL > 0) {
                            String format = String.format(this.appContext.getString(d.j.notify_gift), String.valueOf(this.bYL));
                            c(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.bYF > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.bYF > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.bYF));
                                sb.append(this.appContext.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.bYR != null) {
                                sb.append(this.bYR);
                            } else {
                                sb.append(this.appContext.getString(d.j.notify_agree));
                            }
                            c(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.bYG > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.bYG > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.bYG));
                                sb2.append(this.appContext.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.bYS != null) {
                                sb2.append(this.bYS);
                            } else {
                                sb2.append(this.appContext.getString(d.j.notify_reply));
                            }
                            c(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.bYH > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.bYH > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.bYH));
                                sb3.append(this.appContext.getString(d.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.bYT != null) {
                                sb3.append(this.bYT);
                            } else {
                                sb3.append(this.appContext.getString(d.j.notify_at));
                            }
                            c(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.bYK > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.bYK > 1) {
                                sb4.append(String.format(this.appContext.getString(d.j.notify_fans_unit), Integer.valueOf(this.bYK)));
                            }
                            sb4.append(this.appContext.getString(d.j.notify_fans));
                            c(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int aiV = (!d.aie().aiu() || d.aie().aih() <= 0) ? 0 : eVar.aiV() - eVar.ajc();
                        long ajn = (!d.aie().aim() || d.aie().aih() <= 0) ? 0L : eVar.ajn();
                        boolean z4 = ajn > 0;
                        long j = aiV + ajn;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(d.j.notify_chat), Long.valueOf(j)));
                            b(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.ajq();
                            eVar.ajo();
                            if (ajn == 1) {
                                ajf = eVar.ajq();
                                str = eVar.ajo();
                                aje = ajf + "：" + str;
                            } else if (aiV == 1) {
                                ajf = eVar.ajf();
                                aje = eVar.aje();
                                str = aje;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(aje)) {
                                aje = str;
                            }
                            b(16, ajf, str, aje, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> ajt = eVar.ajt();
                        if (ajt != null && ajt.size() != 0) {
                            for (e.a aVar : ajt) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ap.isEmpty(aVar.gid) && aVar.unReadCount > aVar.caM && aVar.caN == null) {
                                    ahV();
                                    if (ahW().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.aie().aiu() && d.aie().aih() > 0 && eVar.aiW() + eVar.aiY() > 0) {
                        if (eVar.aiW() > 0 && !ahG()) {
                            long aiW = eVar.aiW() - eVar.aiX();
                            if (aiW > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_updates), Long.valueOf(aiW)));
                                z = false;
                                z2 = true;
                            } else if (eVar.aiX() > 0) {
                                z = true;
                            }
                            if (eVar.aiY() > 0 || ahF()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_validate), Integer.valueOf(eVar.aiY())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(d.j.notify_validate_1), Integer.valueOf(eVar.aiY())));
                            }
                            if (z3) {
                                c(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                c(18, eVar.ajh(), eVar.aji(), eVar.aji());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.aiY() > 0) {
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

    private void c(int i, String str, String str2, String str3) {
        b(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.caK, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
            return;
        }
        if (a == null) {
            a = c(aVar);
        }
        if (a == null) {
            a = b(aVar);
        }
        if (a != null) {
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, a, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, a, 134217728);
            }
            i(iC(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.caK, service, false);
        }
    }

    private void b(int i, String str, String str2, String str3, boolean z) {
        Intent n;
        PendingIntent service;
        if (this.bYQ) {
            if (i == 23 && this.bYL > 0) {
                n = ix(i);
            } else if (i == 26 && this.bYK > 0) {
                n = iy(i);
            } else if (i == 18) {
                n = ahA();
            } else if (i == 24) {
                n = n(i, z);
                n.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                n = n(i, z);
                n.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                n = n(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            n.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, n, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, n, 134217728);
            }
            i(iC(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent ix(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.bYL);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent iy(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
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
        String lastTaskId;
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo aT = com.baidu.tieba.im.memorycache.b.buC().aT(aVar.gid, aVar.userType);
        if (aT == null || aT.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aT.getLastTaskId();
            jSONArray = new JSONArray(aT.getLastContentRawData());
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (jSONArray.length() == 1) {
            String optString = ((JSONObject) jSONArray.get(0)).optString("url");
            if (StringUtils.isNull(optString)) {
                return null;
            }
            Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(optString);
            if (matcher.find()) {
                String group = matcher.group(1);
                if (!StringUtils.isNull(group)) {
                    Intent intent = new Intent();
                    if (UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.appContext, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.appContext, DealIntentService.class);
                    }
                    intent.putExtra("class", 1);
                    intent.putExtra("id", group);
                    intent.putExtra("is_from_push", true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", aVar.gid);
                    intent.putExtra("task_id", lastTaskId);
                    return intent;
                }
            } else if (optString.contains("mo/q/hotMessage") || optString.contains("mo/q/newtopic")) {
                Intent intent2 = new Intent();
                if (UtilHelper.isFlyMeOs()) {
                    intent2.setClass(this.appContext, DealIntentActivity.class);
                } else {
                    intent2.setClass(this.appContext, DealIntentService.class);
                }
                intent2.putExtra("class", 30);
                intent2.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                intent2.putExtra("task_id", lastTaskId);
                return intent2;
            } else if (optString.contains("open_wb_view=1")) {
                Intent intent3 = new Intent();
                if (UtilHelper.isFlyMeOs()) {
                    intent3.setClass(this.appContext, DealIntentActivity.class);
                } else {
                    intent3.setClass(this.appContext, DealIntentService.class);
                }
                intent3.putExtra("class", 0);
                intent3.putExtra("url", optString.trim());
                intent3.putExtra("task_id", lastTaskId);
                return intent3;
            } else if (optString.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                return Intent.parseUri(optString, 1);
            }
            return null;
        }
        return null;
    }

    public Intent b(e.a aVar) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.caL);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> ahV = ahV();
        String str = aVar.gid;
        if (ahV != null && !ap.isEmpty(str)) {
            HashSet<String> ahW = ahW();
            HashSet<String> ahX = ahX();
            HashSet<String> ahY = ahY();
            if (ahW != null && ahW.contains(str)) {
                return b(aVar, 3);
            }
            if (ahX != null && ahX.contains(str)) {
                return b(aVar, 1);
            }
            if (ahY != null && ahY.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent n(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.bYN.ajp().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.bYF);
        intent.putExtra("at_me", this.bYH);
        intent.putExtra("reply_me", this.bYG);
        intent.putExtra("fans", this.bYK);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.bYN.aiV() - this.bYN.ajc());
        intent.putExtra("group_msg_validate", this.bYN.aiY());
        intent.putExtra("group_msg_updates", this.bYN.aiW());
        intent.putExtra("officialbar_msg", this.bYN.aiZ());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent ahA() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.bYN.aiX());
        return intent;
    }

    public void ahB() {
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

    public void ahC() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void ahD() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void iz(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void ahE() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void nK(String str) {
        if (TextUtils.isEmpty(str)) {
            ahC();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e ahT = ahT();
        if (ahT == null) {
            ahC();
            return;
        }
        HashMap<String, String> ajj = ahT.ajj();
        if (ajj == null || ajj.isEmpty()) {
            ahC();
        } else if (ajj.containsKey(str)) {
            ahC();
        }
    }

    public void nL(String str) {
        if (TextUtils.isEmpty(str)) {
            ahC();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e ahT = ahT();
        if (ahT == null) {
            ahC();
            return;
        }
        HashMap<String, String> ajp = ahT.ajp();
        if (ajp == null || ajp.isEmpty()) {
            ahC();
        } else if (ajp.containsKey(str)) {
            ahC();
        }
    }

    private boolean ahF() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean ahG() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void ahH() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void iA(int i) {
        com.baidu.tbadk.coreExtra.model.e ahT = ahT();
        if (ahT == null) {
            ahH();
        } else if (1 == i) {
            if (ahT.aiW() <= 0) {
                ahH();
            }
        } else if (2 == i && ahT.aiY() <= 0) {
            ahH();
        }
    }

    public void ahI() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void ahJ() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void ahK() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void ahL() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void ahM() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void ahN() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void ahO() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void ahP() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(ahQ());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(ahR());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.bYN.ajn());
        newsNotifyMessage.setMsgStrangerChat(this.bYN.ajs());
        newsNotifyMessage.setMsgOfficialMerge(this.bYN.ajr());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(ahQ());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.ajn() + eVar.aiV()) + eVar.ajs()) + eVar.ajr()) + eVar.aju()) - eVar.ajc());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.ajn());
            newsNotifyMessage.setMsgStrangerChat(eVar.ajs());
            newsNotifyMessage.setMsgOfficialMerge(eVar.ajr());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.bYG;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.bYF, i, this.bYH, this.bYI, this.bYK, this.bYJ, this.bYL);
        }
    }

    public int getMsgAtme() {
        return this.bYH;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.bYF, this.bYG, i, this.bYI, this.bYK, this.bYJ, this.bYL);
        }
    }

    public int ahQ() {
        return this.bYF;
    }

    public void iB(int i) {
        if (i >= 0) {
            a(i, this.bYG, this.bYH, this.bYI, this.bYK, this.bYJ, this.bYL);
        }
    }

    public int getMsgChat() {
        return this.bYI;
    }

    public int ahR() {
        return ((((this.bYN.ajn() + this.bYN.aiV()) + this.bYN.ajs()) + this.bYN.ajr()) + this.bYN.aju()) - this.bYN.ajc();
    }

    public int getMsgFans() {
        return this.bYK;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.bYF, this.bYG, this.bYH, this.bYI, i, this.bYJ, this.bYL);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.bYF, this.bYG, this.bYH, i, this.bYK, this.bYJ, this.bYL);
        }
    }

    public int getMsgBookmark() {
        return this.bYJ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.bYF, this.bYG, this.bYH, this.bYI, this.bYK, i, this.bYL);
        }
    }

    public int getMsgGiftNum() {
        return this.bYL;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.bYL = i;
        }
    }

    public void dZ(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.bYF = 0;
        this.bYG = 0;
        this.bYH = 0;
        this.bYI = 0;
        this.bYK = 0;
        this.bYJ = 0;
    }

    public int ahS() {
        return this.bYF + this.bYG + this.bYH + this.bYI + this.bYK + this.bYL;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.bYN = eVar;
            this.bYI = (eVar.aiV() - eVar.ajc()) + eVar.ajn() + eVar.ajr() + eVar.aju();
            a(eVar);
            if (eVar.ajd()) {
                this.bYO = null;
                mHandler.removeMessages(0);
            }
            if (eVar.ajd()) {
                if (d.aie().aiu() && d.aie().aih() > 0) {
                    i = eVar.aiV() - eVar.ajc();
                }
                long ajn = (!d.aie().aim() || d.aie().aih() <= 0) ? 0L : eVar.ajn();
                if ((i > 0 || ajn > 0) && ((i > eVar.ajg() - eVar.ajc() && i > 0) || ajn > eVar.aja())) {
                    a(1, 16, eVar);
                }
                int aiZ = eVar.aiZ();
                if (aiZ > 0 && aiZ > eVar.ajm()) {
                    a(1, 19, eVar);
                }
                if (eVar.aiW() > eVar.ajk() || eVar.aiY() > eVar.ajl()) {
                    if (eVar.aiW() <= eVar.ajk() || eVar.aiY() != eVar.ajl() || !ahG()) {
                        if (eVar.aiW() != eVar.ajk() || eVar.aiY() <= eVar.ajl() || !ahF()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e ahT() {
        return this.bYN;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.bYN = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e ahU() {
        return this.bYO;
    }

    public int iC(int i) {
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

    public void i(long j, int i) {
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

    public HashMap<Integer, HashSet> ahV() {
        JSONArray jSONArray;
        if (!bYC && bYD) {
            return this.bYE;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.bYE.get(0) == null) {
                this.bYE.put(0, new HashSet());
            }
            this.bYE.get(0).add("3222425470");
            return this.bYE;
        }
        if (this.bYE.get(0) != null) {
            this.bYE.get(0).clear();
        }
        if (this.bYE.get(1) != null) {
            this.bYE.get(1).clear();
        }
        if (this.bYE.get(2) != null) {
            this.bYE.get(2).clear();
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
                        if (this.bYE.get(0) == null) {
                            this.bYE.put(0, new HashSet());
                        }
                        this.bYE.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.bYE.get(1) == null) {
                            this.bYE.put(1, new HashSet());
                        }
                        this.bYE.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.bYE.get(2) == null) {
                            this.bYE.put(2, new HashSet());
                        }
                        this.bYE.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        bYD = true;
        bYC = false;
        return this.bYE;
    }

    public HashSet<String> ahW() {
        ahV();
        return this.bYE.get(0);
    }

    public HashSet<String> ahX() {
        ahV();
        return this.bYE.get(1);
    }

    public HashSet<String> ahY() {
        ahV();
        return this.bYE.get(2);
    }

    public String ahZ() {
        HashSet<String> ahW = ahW();
        if (ahW != null) {
            Iterator<String> it = ahW.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
