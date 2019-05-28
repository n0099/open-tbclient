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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
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
    private static b cgK;
    private com.baidu.tbadk.coreExtra.model.e cgM;
    private String cgP;
    private String cgQ;
    private String cgR;
    public static boolean cgA = true;
    public static boolean cgB = false;
    private static Date cgN = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.amy().b(b.amy().amV());
            }
        }
    };
    private final HashMap<Integer, HashSet> cgC = new HashMap<>();
    private int cgD = 0;
    private int cgE = 0;
    private int cgF = 0;
    private int cgG = 0;
    private int cgH = 0;
    private int cgI = 0;
    private int cgJ = 0;
    private com.baidu.tbadk.coreExtra.model.e cgL = new com.baidu.tbadk.coreExtra.model.e();
    private boolean cgO = true;
    private final int[] cgS = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b amy() {
        if (cgK == null) {
            cgK = new b();
        }
        return cgK;
    }

    private b() {
    }

    public void bb(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.cgQ = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.cgP = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.cgR = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.cgD || i2 != this.cgE || i3 != this.cgF || i4 != this.cgG || i5 != this.cgI || i6 != this.cgH || i7 != this.cgJ) {
            int i8 = 0;
            if (i > this.cgD || i2 > this.cgE || i3 > this.cgF || i4 > this.cgG || i5 > this.cgI || i6 > this.cgH || i7 > this.cgJ) {
                i8 = 1;
            } else if (i < this.cgD || i2 < this.cgE || i3 < this.cgF) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.cgD && d.anf().anw()) {
                i9 = 1;
            } else if (i < this.cgD) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.cgE && d.anf().anm()) {
                i10 = 1;
            } else if (i2 < this.cgE) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.cgF && d.anf().ank()) {
                i11 = 1;
            } else if (i3 < this.cgF) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.cgG) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.cgI) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.cgJ) {
                i14 = 1;
            }
            this.cgD = i;
            this.cgE = i2;
            this.cgF = i3;
            this.cgG = i4;
            this.cgI = i5;
            this.cgH = i6;
            this.cgJ = i7;
            if (amT() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                amQ();
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
        if (i != this.cgD || i2 != this.cgE || i3 != this.cgF || i4 != this.cgG || i5 != this.cgI || this.cgJ != i6) {
            this.cgD = i;
            this.cgE = i2;
            this.cgF = i3;
            this.cgG = i4;
            this.cgI = i5;
            this.cgJ = i6;
            amQ();
            if (amT() <= 0) {
                ae(2, 16);
                ae(2, 17);
            }
        }
    }

    public static boolean amz() {
        if (cgN == null) {
            cgN = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - cgN.getTime() < 10000) {
                return false;
            }
            cgN = date;
        }
        return true;
    }

    public static boolean amA() {
        if (d.anf().anq()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.anf().ans().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.anf().ant().split(":");
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
                    if (this.cgJ > 0) {
                        String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.cgJ));
                        c(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.cgD > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(R.string.notify_agree), Integer.valueOf(this.cgD)));
                        c(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.cgE > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.cgE > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.cgE));
                            sb2.append(this.appContext.getString(R.string.notify_unit));
                            sb2.append("]");
                        }
                        if (this.cgQ != null) {
                            sb2.append(this.cgQ);
                        } else {
                            sb2.append(this.appContext.getString(R.string.notify_reply));
                        }
                        c(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.cgF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.cgF > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.cgF));
                            sb3.append(this.appContext.getString(R.string.notify_unit));
                            sb3.append("]");
                        }
                        if (this.cgR != null) {
                            sb3.append(this.cgR);
                        } else {
                            sb3.append(this.appContext.getString(R.string.notify_at));
                        }
                        c(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.cgI > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(R.string.notify_fans), Integer.valueOf(this.cgI)));
                        c(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.anf().anv() || d.anf().ani() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.appContext, 16);
                NotificationHelper.cancelNotification(this.appContext, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0356 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:6:0x0009, B:8:0x0012, B:10:0x0016, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x008a, B:28:0x009b, B:30:0x009f, B:32:0x00a8, B:33:0x00c9, B:35:0x00cd, B:36:0x00d2, B:37:0x00e2, B:40:0x00f3, B:42:0x00f7, B:44:0x0100, B:45:0x0121, B:47:0x0125, B:48:0x012a, B:49:0x013a, B:52:0x014b, B:54:0x014f, B:56:0x0158, B:57:0x0174, B:59:0x0192, B:61:0x019c, B:63:0x01a6, B:64:0x01b0, B:66:0x01bc, B:68:0x01c6, B:72:0x01d2, B:74:0x01da, B:77:0x020b, B:79:0x021a, B:80:0x023a, B:82:0x0240, B:83:0x025f, B:86:0x0266, B:88:0x0270, B:91:0x027e, B:93:0x0284, B:95:0x028a, B:96:0x028e, B:98:0x0294, B:100:0x029c, B:102:0x02a4, B:104:0x02ac, B:106:0x02b2, B:108:0x02b6, B:110:0x02c5, B:111:0x02cb, B:112:0x02d1, B:114:0x02db, B:116:0x02e5, B:118:0x02f0, B:120:0x02f6, B:122:0x02fc, B:124:0x030c, B:125:0x0328, B:127:0x032e, B:130:0x0336, B:132:0x0356, B:134:0x0366, B:138:0x0381, B:135:0x0379, B:141:0x03a3), top: B:147:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0366 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:6:0x0009, B:8:0x0012, B:10:0x0016, B:16:0x0043, B:18:0x0047, B:20:0x0050, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x008a, B:28:0x009b, B:30:0x009f, B:32:0x00a8, B:33:0x00c9, B:35:0x00cd, B:36:0x00d2, B:37:0x00e2, B:40:0x00f3, B:42:0x00f7, B:44:0x0100, B:45:0x0121, B:47:0x0125, B:48:0x012a, B:49:0x013a, B:52:0x014b, B:54:0x014f, B:56:0x0158, B:57:0x0174, B:59:0x0192, B:61:0x019c, B:63:0x01a6, B:64:0x01b0, B:66:0x01bc, B:68:0x01c6, B:72:0x01d2, B:74:0x01da, B:77:0x020b, B:79:0x021a, B:80:0x023a, B:82:0x0240, B:83:0x025f, B:86:0x0266, B:88:0x0270, B:91:0x027e, B:93:0x0284, B:95:0x028a, B:96:0x028e, B:98:0x0294, B:100:0x029c, B:102:0x02a4, B:104:0x02ac, B:106:0x02b2, B:108:0x02b6, B:110:0x02c5, B:111:0x02cb, B:112:0x02d1, B:114:0x02db, B:116:0x02e5, B:118:0x02f0, B:120:0x02f6, B:122:0x02fc, B:124:0x030c, B:125:0x0328, B:127:0x032e, B:130:0x0336, B:132:0x0356, B:134:0x0366, B:138:0x0381, B:135:0x0379, B:141:0x03a3), top: B:147:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.model.e eVar) {
        boolean z;
        String aog;
        String aof;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.cgJ > 0) {
                            String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.cgJ));
                            c(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.cgD > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.cgD > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.cgD));
                                sb.append(this.appContext.getString(R.string.notify_unit));
                                sb.append("]");
                            }
                            if (this.cgP != null) {
                                sb.append(this.cgP);
                            } else {
                                sb.append(this.appContext.getString(R.string.notify_agree));
                            }
                            c(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.cgE > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.cgE > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.cgE));
                                sb2.append(this.appContext.getString(R.string.notify_unit));
                                sb2.append("]");
                            }
                            if (this.cgQ != null) {
                                sb2.append(this.cgQ);
                            } else {
                                sb2.append(this.appContext.getString(R.string.notify_reply));
                            }
                            c(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.cgF > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.cgF > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.cgF));
                                sb3.append(this.appContext.getString(R.string.notify_unit));
                                sb3.append("]");
                            }
                            if (this.cgR != null) {
                                sb3.append(this.cgR);
                            } else {
                                sb3.append(this.appContext.getString(R.string.notify_at));
                            }
                            c(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.cgI > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.cgI > 1) {
                                sb4.append(String.format(this.appContext.getString(R.string.notify_fans_unit), Integer.valueOf(this.cgI)));
                            }
                            sb4.append(this.appContext.getString(R.string.notify_fans));
                            c(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int anW = (!d.anf().anv() || d.anf().ani() <= 0) ? 0 : eVar.anW() - eVar.aod();
                        long j = 0;
                        if (d.anf().ann() && d.anf().ani() > 0) {
                            j = eVar.aoo();
                        }
                        boolean z4 = j > 0;
                        long j2 = anW + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            eVar.aor();
                            eVar.aop();
                            if (j == 1) {
                                aog = eVar.aor();
                                str = eVar.aop();
                                aof = aog + "：" + str;
                            } else if (anW == 1) {
                                aog = eVar.aog();
                                aof = eVar.aof();
                                str = aof;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(aof)) {
                                aof = str;
                            }
                            a(16, aog, str, aof, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> aou = eVar.aou();
                        if (aou != null && aou.size() != 0) {
                            for (e.a aVar : aou) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !ap.isEmpty(aVar.gid) && aVar.unReadCount > aVar.ciL && aVar.ciM == null) {
                                    amW();
                                    if (amX().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.anf().anv() && d.anf().ani() > 0 && eVar.anX() + eVar.anZ() > 0) {
                        if (eVar.anX() > 0 && !amH()) {
                            long anX = eVar.anX() - eVar.anY();
                            if (anX > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(anX)));
                                z = false;
                                z2 = true;
                            } else if (eVar.anY() > 0) {
                                z = true;
                            }
                            if (eVar.anZ() > 0 || amG()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(eVar.anZ())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(eVar.anZ())));
                            }
                            if (z3) {
                                c(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                c(18, eVar.aoi(), eVar.aoj(), eVar.aoj());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.anZ() > 0) {
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
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.ciJ, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
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
            g(jq(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.ciJ, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent r;
        PendingIntent service;
        if (this.cgO) {
            if (i == 23 && this.cgJ > 0) {
                r = jl(i);
            } else if (i == 26 && this.cgI > 0) {
                r = jm(i);
            } else if (i == 18) {
                r = amB();
            } else if (i == 24) {
                r = r(i, z);
                r.putExtra(MyBookrackActivityConfig.TAB_ID, 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                r = r(i, z);
                r.putExtra(MyBookrackActivityConfig.TAB_ID, 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                r = r(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            r.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, r, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, r, 134217728);
            }
            g(jq(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent jl(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.cgJ);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent jm(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 35);
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
        ImMessageCenterPojo aP = com.baidu.tieba.im.memorycache.b.bCr().aP(aVar.gid, aVar.userType);
        if (aP == null || aP.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aP.getLastTaskId();
            jSONArray = new JSONArray(aP.getLastContentRawData());
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
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
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
                intent2.putExtra(DealIntentService.KEY_CLASS, 30);
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
                intent3.putExtra(DealIntentService.KEY_CLASS, 0);
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
        intent.putExtra(DealIntentService.KEY_CLASS, 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.ciK);
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
        intent.putExtra(DealIntentService.KEY_CLASS, 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> amW = amW();
        String str = aVar.gid;
        if (amW != null && !ap.isEmpty(str)) {
            HashSet<String> amX = amX();
            HashSet<String> amY = amY();
            HashSet<String> amZ = amZ();
            if (amX != null && amX.contains(str)) {
                return b(aVar, 3);
            }
            if (amY != null && amY.contains(str)) {
                return b(aVar, 1);
            }
            if (amZ != null && amZ.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent r(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.cgL.aoq().keySet();
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
        intent.putExtra(DealIntentService.KEY_CLASS, 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.cgD);
        intent.putExtra("at_me", this.cgF);
        intent.putExtra("reply_me", this.cgE);
        intent.putExtra("fans", this.cgI);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.cgL.anW() - this.cgL.aod());
        intent.putExtra("group_msg_validate", this.cgL.anZ());
        intent.putExtra("group_msg_updates", this.cgL.anX());
        intent.putExtra("officialbar_msg", this.cgL.aoa());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent amB() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.cgL.anY());
        return intent;
    }

    public void amC() {
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

    public void amD() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void amE() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void jn(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void amF() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void oU(String str) {
        if (TextUtils.isEmpty(str)) {
            amD();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e amU = amU();
        if (amU == null) {
            amD();
            return;
        }
        HashMap<String, String> aok = amU.aok();
        if (aok == null || aok.isEmpty()) {
            amD();
        } else if (aok.containsKey(str)) {
            amD();
        }
    }

    public void oV(String str) {
        if (TextUtils.isEmpty(str)) {
            amD();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e amU = amU();
        if (amU == null) {
            amD();
            return;
        }
        HashMap<String, String> aoq = amU.aoq();
        if (aoq == null || aoq.isEmpty()) {
            amD();
        } else if (aoq.containsKey(str)) {
            amD();
        }
    }

    private boolean amG() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean amH() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void amI() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void jo(int i) {
        com.baidu.tbadk.coreExtra.model.e amU = amU();
        if (amU == null) {
            amI();
        } else if (1 == i) {
            if (amU.anX() <= 0) {
                amI();
            }
        } else if (2 == i && amU.anZ() <= 0) {
            amI();
        }
    }

    public void amJ() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void amK() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void amL() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void amM() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void amN() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void amO() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void amP() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void amQ() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(amR());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(amS());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.cgL.aoo());
        newsNotifyMessage.setMsgStrangerChat(this.cgL.aot());
        newsNotifyMessage.setMsgOfficialMerge(this.cgL.aos());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(amR());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.aoo() + eVar.anW()) + eVar.aot()) + eVar.aos()) + eVar.aov()) - eVar.aod());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.aoo());
            newsNotifyMessage.setMsgStrangerChat(eVar.aot());
            newsNotifyMessage.setMsgOfficialMerge(eVar.aos());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.cgE;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.cgD, i, this.cgF, this.cgG, this.cgI, this.cgH, this.cgJ);
        }
    }

    public int getMsgAtme() {
        return this.cgF;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.cgD, this.cgE, i, this.cgG, this.cgI, this.cgH, this.cgJ);
        }
    }

    public int amR() {
        return this.cgD;
    }

    public void jp(int i) {
        if (i >= 0) {
            a(i, this.cgE, this.cgF, this.cgG, this.cgI, this.cgH, this.cgJ);
        }
    }

    public int getMsgChat() {
        return this.cgG;
    }

    public int amS() {
        return ((((this.cgL.aoo() + this.cgL.anW()) + this.cgL.aot()) + this.cgL.aos()) + this.cgL.aov()) - this.cgL.aod();
    }

    public int getMsgFans() {
        return this.cgI;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.cgD, this.cgE, this.cgF, this.cgG, i, this.cgH, this.cgJ);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.cgD, this.cgE, this.cgF, i, this.cgI, this.cgH, this.cgJ);
        }
    }

    public int getMsgBookmark() {
        return this.cgH;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.cgD, this.cgE, this.cgF, this.cgG, this.cgI, i, this.cgJ);
        }
    }

    public int getMsgGiftNum() {
        return this.cgJ;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.cgJ = i;
        }
    }

    public void ew(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.cgD = 0;
        this.cgE = 0;
        this.cgF = 0;
        this.cgG = 0;
        this.cgI = 0;
        this.cgH = 0;
    }

    public int amT() {
        return this.cgD + this.cgE + this.cgF + this.cgG + this.cgI + this.cgJ;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.cgL = eVar;
            this.cgG = (eVar.anW() - eVar.aod()) + eVar.aoo() + eVar.aos() + eVar.aov();
            a(eVar);
            if (eVar.aoe()) {
                this.cgM = null;
                mHandler.removeMessages(0);
            }
            if (eVar.aoe()) {
                if (d.anf().anv() && d.anf().ani() > 0) {
                    i = eVar.anW() - eVar.aod();
                }
                long aoo = (!d.anf().ann() || d.anf().ani() <= 0) ? 0L : eVar.aoo();
                if ((i > 0 || aoo > 0) && ((i > eVar.aoh() - eVar.aod() && i > 0) || aoo > eVar.aob())) {
                    a(1, 16, eVar);
                }
                int aoa = eVar.aoa();
                if (aoa > 0 && aoa > eVar.aon()) {
                    a(1, 19, eVar);
                }
                if (eVar.anX() > eVar.aol() || eVar.anZ() > eVar.aom()) {
                    if (eVar.anX() <= eVar.aol() || eVar.anZ() != eVar.aom() || !amH()) {
                        if (eVar.anX() != eVar.aol() || eVar.anZ() <= eVar.aom() || !amG()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e amU() {
        return this.cgL;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.cgL = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e amV() {
        return this.cgM;
    }

    public int jq(int i) {
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

    public void g(long j, int i) {
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

    public HashMap<Integer, HashSet> amW() {
        JSONArray jSONArray;
        if (!cgA && cgB) {
            return this.cgC;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.cgC.get(0) == null) {
                this.cgC.put(0, new HashSet());
            }
            this.cgC.get(0).add("3222425470");
            return this.cgC;
        }
        if (this.cgC.get(0) != null) {
            this.cgC.get(0).clear();
        }
        if (this.cgC.get(1) != null) {
            this.cgC.get(1).clear();
        }
        if (this.cgC.get(2) != null) {
            this.cgC.get(2).clear();
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
                        if (this.cgC.get(0) == null) {
                            this.cgC.put(0, new HashSet());
                        }
                        this.cgC.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.cgC.get(1) == null) {
                            this.cgC.put(1, new HashSet());
                        }
                        this.cgC.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.cgC.get(2) == null) {
                            this.cgC.put(2, new HashSet());
                        }
                        this.cgC.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        cgB = true;
        cgA = false;
        return this.cgC;
    }

    public HashSet<String> amX() {
        amW();
        return this.cgC.get(0);
    }

    public HashSet<String> amY() {
        amW();
        return this.cgC.get(1);
    }

    public HashSet<String> amZ() {
        amW();
        return this.cgC.get(2);
    }

    public String ana() {
        HashSet<String> amX = amX();
        if (amX != null) {
            Iterator<String> it = amX.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
