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
    private static a biT;
    private e biV;
    private String biY;
    private String biZ;
    private String bja;
    public static boolean biI = true;
    public static boolean biJ = false;
    private static Date biW = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.GI().b(a.GI().Hf());
            }
        }
    };
    private final HashMap<Integer, HashSet> biK = new HashMap<>();
    private int biM = 0;
    private int biN = 0;
    private int biO = 0;
    private int biP = 0;
    private int biQ = 0;
    private int biR = 0;
    private int biS = 0;
    private e biU = new e();
    private boolean biX = true;
    private final int[] bjb = new int[10];
    private final Context biL = TbadkCoreApplication.getInst().getApp();

    public static a GI() {
        if (biT == null) {
            biT = new a();
        }
        return biT;
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
                    this.biZ = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.biY = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.bja = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.biM || i2 != this.biN || i3 != this.biO || i4 != this.biP || i5 != this.biR || i6 != this.biQ || i7 != this.biS) {
            int i8 = 0;
            if (i > this.biM || i2 > this.biN || i3 > this.biO || i4 > this.biP || i5 > this.biR || i6 > this.biQ || i7 > this.biS) {
                i8 = 1;
            } else if (i < this.biM || i2 < this.biN || i3 < this.biO) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.biM && c.Hp().HF()) {
                i9 = 1;
            } else if (i < this.biM) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.biN && c.Hp().Hw()) {
                i10 = 1;
            } else if (i2 < this.biN) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.biO && c.Hp().Hu()) {
                i11 = 1;
            } else if (i3 < this.biO) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.biP) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.biR) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.biS) {
                i14 = 1;
            }
            this.biM = i;
            this.biN = i2;
            this.biO = i3;
            this.biP = i4;
            this.biR = i5;
            this.biQ = i6;
            this.biS = i7;
            if (Hd() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                Ha();
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
        if (i != this.biM || i2 != this.biN || i3 != this.biO || i4 != this.biP || i5 != this.biR || this.biS != i6) {
            this.biM = i;
            this.biN = i2;
            this.biO = i3;
            this.biP = i4;
            this.biR = i5;
            this.biS = i6;
            Ha();
            if (Hd() <= 0) {
                aD(2, 16);
                aD(2, 17);
            }
        }
    }

    public static boolean GJ() {
        if (biW == null) {
            biW = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - biW.getTime() < 10000) {
                return false;
            }
            biW = date;
        }
        return true;
    }

    public static boolean GK() {
        if (c.Hp().HA()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = c.Hp().HC().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = c.Hp().HD().split(":");
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
                    if (this.biS > 0) {
                        String format = String.format(this.biL.getString(d.j.notify_gift), String.valueOf(this.biS));
                        a(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.biM > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.biL.getString(d.j.notify_agree), Integer.valueOf(this.biM)));
                        a(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.biN > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.biN > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.biN));
                            sb2.append(this.biL.getString(d.j.notify_unit));
                            sb2.append("]");
                        }
                        if (this.biZ != null) {
                            sb2.append(this.biZ);
                        } else {
                            sb2.append(this.biL.getString(d.j.notify_reply));
                        }
                        a(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.biO > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.biO > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.biO));
                            sb3.append(this.biL.getString(d.j.notify_unit));
                            sb3.append("]");
                        }
                        if (this.bja != null) {
                            sb3.append(this.bja);
                        } else {
                            sb3.append(this.biL.getString(d.j.notify_at));
                        }
                        a(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.biR > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.biL.getString(d.j.notify_fans), Integer.valueOf(this.biR)));
                        a(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !c.Hp().HE() || c.Hp().Hs() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.biL, 16);
                NotificationHelper.cancelNotification(this.biL, 17);
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
        String Im;
        String Il;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.biS > 0) {
                            String format = String.format(this.biL.getString(d.j.notify_gift), String.valueOf(this.biS));
                            a(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.biM > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.biM > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.biM));
                                sb.append(this.biL.getString(d.j.notify_unit));
                                sb.append("]");
                            }
                            if (this.biY != null) {
                                sb.append(this.biY);
                            } else {
                                sb.append(this.biL.getString(d.j.notify_agree));
                            }
                            a(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.biN > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.biN > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.biN));
                                sb2.append(this.biL.getString(d.j.notify_unit));
                                sb2.append("]");
                            }
                            if (this.biZ != null) {
                                sb2.append(this.biZ);
                            } else {
                                sb2.append(this.biL.getString(d.j.notify_reply));
                            }
                            a(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.biO > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.biO > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.biO));
                                sb3.append(this.biL.getString(d.j.notify_unit));
                                sb3.append("]");
                            }
                            if (this.bja != null) {
                                sb3.append(this.bja);
                            } else {
                                sb3.append(this.biL.getString(d.j.notify_at));
                            }
                            a(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.biR > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.biR > 1) {
                                sb4.append(String.format(this.biL.getString(d.j.notify_fans_unit), Integer.valueOf(this.biR)));
                            }
                            sb4.append(this.biL.getString(d.j.notify_fans));
                            a(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int Ic = (!c.Hp().HE() || c.Hp().Hs() <= 0) ? 0 : eVar.Ic() - eVar.Ij();
                        long Iu = (!c.Hp().Hx() || c.Hp().Hs() <= 0) ? 0L : eVar.Iu();
                        boolean z4 = Iu > 0;
                        long j = Ic + Iu;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.biL.getString(d.j.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            eVar.Ix();
                            eVar.Iv();
                            if (Iu == 1) {
                                Im = eVar.Ix();
                                str = eVar.Iv();
                                Il = Im + "：" + str;
                            } else if (Ic == 1) {
                                Im = eVar.Im();
                                Il = eVar.Il();
                                str = Il;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.biL.getString(d.j.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(Il)) {
                                Il = str;
                            }
                            a(16, Im, str, Il, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> IA = eVar.IA();
                        if (IA != null && IA.size() != 0) {
                            for (e.a aVar : IA) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !am.isEmpty(aVar.gid) && aVar.unReadCount > aVar.bkI && aVar.bkJ == null) {
                                    a(aVar, 19);
                                }
                            }
                        }
                    } else if (c.Hp().HE() && c.Hp().Hs() > 0 && eVar.Id() + eVar.If() > 0) {
                        if (eVar.Id() > 0 && !GR()) {
                            long Id = eVar.Id() - eVar.Ie();
                            if (Id > 0) {
                                stringBuffer.append(String.format(this.biL.getString(d.j.notify_updates), Long.valueOf(Id)));
                                z = false;
                                z2 = true;
                            } else if (eVar.Ie() > 0) {
                                z = true;
                            }
                            if (eVar.If() > 0 || GQ()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.biL.getString(d.j.notify_validate), Integer.valueOf(eVar.If())));
                            } else {
                                stringBuffer.append(String.format(this.biL.getString(d.j.notify_validate_1), Integer.valueOf(eVar.If())));
                            }
                            if (z3) {
                                a(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                a(18, eVar.Io(), eVar.Ip(), eVar.Ip());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.If() > 0) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (!z) {
                        }
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.biL, 16);
                    NotificationHelper.cancelNotification(this.biL, 17);
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
            PendingIntent service = PendingIntent.getService(this.biL, 19, a, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.biL, i, aVar.title, aVar.content, aVar.bkG, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent w;
        if (this.biX) {
            if (i == 23 && this.biS > 0) {
                w = gQ(i);
            } else if (i == 26 && this.biR > 0) {
                w = gR(i);
            } else if (i == 18) {
                w = GL();
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
            PendingIntent service = PendingIntent.getService(this.biL, i, w, 134217728);
            aE(gV(i), i);
            NotificationHelper.showNotification(this.biL, i, str, str2, str3, service, false);
        }
    }

    public Intent gQ(int i) {
        Intent intent = new Intent(this.biL, DealIntentService.class);
        intent.putExtra("class", 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.biS);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent gR(int i) {
        Intent intent = new Intent(this.biL, DealIntentService.class);
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
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKA().an(aVar.gid, aVar.userType);
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
                    Intent intent = new Intent(this.biL, DealIntentService.class);
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
        ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKA().an(aVar.gid + "", aVar.userType);
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
                Intent intent = new Intent(this.biL, DealIntentService.class);
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
        Intent intent = new Intent(this.biL, DealIntentService.class);
        intent.putExtra("class", 27);
        intent.putExtra("uid", aVar.gid);
        intent.putExtra("uname", aVar.bkH);
        intent.putExtra("user_type", aVar.userType);
        return intent;
    }

    public Intent b(e.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        Intent intent = new Intent(this.biL, DealIntentService.class);
        intent.putExtra("class", 36);
        intent.putExtra(MyBookrackActivityConfig.TAB_ID, i);
        return intent;
    }

    public Intent d(e.a aVar) {
        HashMap<Integer, HashSet> Hg = Hg();
        String str = aVar.gid;
        if (Hg != null && !am.isEmpty(str)) {
            HashSet<String> Hh = Hh();
            HashSet<String> Hi = Hi();
            HashSet<String> Hj = Hj();
            if (Hh != null && Hh.contains(str)) {
                return b(aVar, 3);
            }
            if (Hi != null && Hi.contains(str)) {
                return b(aVar, 1);
            }
            if (Hj != null && Hj.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent w(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.biU.Iw().keySet();
            if (keySet.iterator().hasNext()) {
                str = keySet.iterator().next();
            }
        }
        Intent intent = new Intent(this.biL, DealIntentService.class);
        intent.putExtra("class", 5);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("agree_me", this.biM);
        intent.putExtra("at_me", this.biO);
        intent.putExtra("reply_me", this.biN);
        intent.putExtra("fans", this.biR);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.biU.Ic() - this.biU.Ij());
        intent.putExtra("group_msg_validate", this.biU.If());
        intent.putExtra("group_msg_updates", this.biU.Id());
        intent.putExtra("officialbar_msg", this.biU.Ig());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent GL() {
        Intent intent = new Intent(this.biL, DealIntentService.class);
        intent.putExtra("class", 14);
        intent.putExtra("group_msg_updates", this.biU.Ie());
        return intent;
    }

    public void GM() {
        NotificationHelper.cancelNotification(this.biL, 23);
        NotificationHelper.cancelNotification(this.biL, 24);
        NotificationHelper.cancelNotification(this.biL, 25);
        NotificationHelper.cancelNotification(this.biL, 29);
        NotificationHelper.cancelNotification(this.biL, 26);
        NotificationHelper.cancelNotification(this.biL, 17);
        NotificationHelper.cancelNotification(this.biL, 15);
        NotificationHelper.cancelNotification(this.biL, 13);
        NotificationHelper.cancelNotification(this.biL, 12);
    }

    public void GN() {
        NotificationHelper.cancelNotification(this.biL, 16);
    }

    public void GO() {
        NotificationHelper.cancelNotification(this.biL, 19);
    }

    public void gS(int i) {
        NotificationHelper.cancelNotification(this.biL, i);
    }

    public int GP() {
        return this.biU.Iz();
    }

    public void fo(String str) {
        if (TextUtils.isEmpty(str)) {
            GN();
            return;
        }
        e He = He();
        if (He == null) {
            GN();
            return;
        }
        HashMap<String, String> Iq = He.Iq();
        if (Iq == null || Iq.isEmpty()) {
            GN();
        } else if (Iq.containsKey(str)) {
            GN();
        }
    }

    public void fp(String str) {
        if (TextUtils.isEmpty(str)) {
            GN();
            return;
        }
        e He = He();
        if (He == null) {
            GN();
            return;
        }
        HashMap<String, String> Iw = He.Iw();
        if (Iw == null || Iw.isEmpty()) {
            GN();
        } else if (Iw.containsKey(str)) {
            GN();
        }
    }

    private boolean GQ() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean GR() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void GS() {
        NotificationHelper.cancelNotification(this.biL, 17);
    }

    public void gT(int i) {
        e He = He();
        if (He == null) {
            GS();
        } else if (1 == i) {
            if (He.Id() <= 0) {
                GS();
            }
        } else if (2 == i && He.If() <= 0) {
            GS();
        }
    }

    public void GT() {
        NotificationHelper.cancelNotification(this.biL, 18);
    }

    public void GU() {
        NotificationHelper.cancelNotification(this.biL, 26);
        NotificationHelper.cancelNotification(this.biL, 25);
        NotificationHelper.cancelNotification(this.biL, 24);
        NotificationHelper.cancelNotification(this.biL, 23);
        NotificationHelper.cancelNotification(this.biL, 16);
        NotificationHelper.cancelNotification(this.biL, 17);
        NotificationHelper.cancelNotification(this.biL, 29);
    }

    public void GV() {
        NotificationHelper.cancelNotification(this.biL, 17);
        NotificationHelper.cancelNotification(this.biL, 19);
        NotificationHelper.cancelNotification(this.biL, 16);
        NotificationHelper.cancelNotification(this.biL, 18);
    }

    public void GW() {
        NotificationHelper.cancelNotification(this.biL, 24);
    }

    public void GX() {
        NotificationHelper.cancelNotification(this.biL, 25);
    }

    public void GY() {
        NotificationHelper.cancelNotification(this.biL, 29);
    }

    public void GZ() {
        NotificationHelper.cancelNotification(this.biL, 23);
    }

    public void Ha() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(Hb());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(Hc());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.biU.Iu());
        newsNotifyMessage.setMsgStrangerChat(this.biU.Iz());
        newsNotifyMessage.setMsgOfficialMerge(this.biU.Iy());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(Hb());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.Iu() + eVar.Ic()) + eVar.Iz()) + eVar.Iy()) + eVar.IB()) - eVar.Ij());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.Iu());
            newsNotifyMessage.setMsgStrangerChat(eVar.Iz());
            newsNotifyMessage.setMsgOfficialMerge(eVar.Iy());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.biN;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.biM, i, this.biO, this.biP, this.biR, this.biQ, this.biS);
        }
    }

    public int getMsgAtme() {
        return this.biO;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.biM, this.biN, i, this.biP, this.biR, this.biQ, this.biS);
        }
    }

    public int Hb() {
        return this.biM;
    }

    public void gU(int i) {
        if (i >= 0) {
            a(i, this.biN, this.biO, this.biP, this.biR, this.biQ, this.biS);
        }
    }

    public int getMsgChat() {
        return this.biP;
    }

    public int Hc() {
        return ((((this.biU.Iu() + this.biU.Ic()) + this.biU.Iz()) + this.biU.Iy()) + this.biU.IB()) - this.biU.Ij();
    }

    public int getMsgFans() {
        return this.biR;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.biM, this.biN, this.biO, this.biP, i, this.biQ, this.biS);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.biM, this.biN, this.biO, i, this.biR, this.biQ, this.biS);
        }
    }

    public int getMsgBookmark() {
        return this.biQ;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.biM, this.biN, this.biO, this.biP, this.biR, i, this.biS);
        }
    }

    public int getMsgGiftNum() {
        return this.biS;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.biS = i;
        }
    }

    public void bE(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.biM = 0;
        this.biN = 0;
        this.biO = 0;
        this.biP = 0;
        this.biR = 0;
        this.biQ = 0;
    }

    public int Hd() {
        return this.biM + this.biN + this.biO + this.biP + this.biR + this.biS;
    }

    public void b(e eVar) {
        int i = 0;
        if (eVar != null) {
            this.biU = eVar;
            this.biP = (eVar.Ic() - eVar.Ij()) + eVar.Iu() + eVar.Iy() + eVar.IB();
            a(eVar);
            if (eVar.Ik()) {
                this.biV = null;
                mHandler.removeMessages(0);
            }
            if (eVar.Ik()) {
                if (c.Hp().HE() && c.Hp().Hs() > 0) {
                    i = eVar.Ic() - eVar.Ij();
                }
                long Iu = (!c.Hp().Hx() || c.Hp().Hs() <= 0) ? 0L : eVar.Iu();
                if ((i > 0 || Iu > 0) && ((i > eVar.In() - eVar.Ij() && i > 0) || Iu > eVar.Ih())) {
                    a(1, 16, eVar);
                }
                int Ig = eVar.Ig();
                if (Ig > 0 && Ig > eVar.It()) {
                    a(1, 19, eVar);
                }
                if (eVar.Id() > eVar.Ir() || eVar.If() > eVar.Is()) {
                    if (eVar.Id() <= eVar.Ir() || eVar.If() != eVar.Is() || !GR()) {
                        if (eVar.Id() != eVar.Ir() || eVar.If() <= eVar.Is() || !GQ()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public e He() {
        return this.biU;
    }

    public void c(e eVar) {
        this.biU = eVar;
    }

    public e Hf() {
        return this.biV;
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
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 16, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 17, i2);
        } else if (2 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 12, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 13, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 15, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 18, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 19, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 28, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 2000, i2);
        } else if (3 == i) {
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 29, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 23, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 24, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 25, i2);
            NotificationHelper.cancelNotificationExceptSpecific(this.biL, 26, i2);
        }
    }

    public HashMap<Integer, HashSet> Hg() {
        JSONArray jSONArray;
        if (!biI && biJ) {
            return this.biK;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_response_pull_pull_config_tab_uid", null);
        if (string == null) {
            if (this.biK.get(0) == null) {
                this.biK.put(0, new HashSet());
            }
            this.biK.get(0).add("3222425470");
            return this.biK;
        }
        if (this.biK.get(0) != null) {
            this.biK.get(0).clear();
        }
        if (this.biK.get(1) != null) {
            this.biK.get(1).clear();
        }
        if (this.biK.get(2) != null) {
            this.biK.get(2).clear();
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
                        if (this.biK.get(0) == null) {
                            this.biK.put(0, new HashSet());
                        }
                        this.biK.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.biK.get(1) == null) {
                            this.biK.put(1, new HashSet());
                        }
                        this.biK.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.biK.get(2) == null) {
                            this.biK.put(2, new HashSet());
                        }
                        this.biK.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        biJ = true;
        biI = false;
        return this.biK;
    }

    public HashSet<String> Hh() {
        Hg();
        return this.biK.get(0);
    }

    public HashSet<String> Hi() {
        Hg();
        return this.biK.get(1);
    }

    public HashSet<String> Hj() {
        Hg();
        return this.biK.get(2);
    }

    public String Hk() {
        HashSet<String> Hh = Hh();
        if (Hh != null) {
            Iterator<String> it = Hh.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
