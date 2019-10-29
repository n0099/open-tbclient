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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
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
    private static b cwH;
    private com.baidu.tbadk.coreExtra.model.e cwJ;
    private String cwM;
    private String cwN;
    private String cwO;
    public static boolean cwE = true;
    public static boolean cwF = false;
    private static Date cwK = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.aqt().b(b.aqt().aqQ());
            }
        }
    };
    private final HashMap<Integer, HashSet> cwG = new HashMap<>();
    private int mMsgAgreeme = 0;
    private int mMsgReplyme = 0;
    private int mMsgAtme = 0;
    private int mMsgChat = 0;
    private int mMsgBookmark = 0;
    private int mMsgFans = 0;
    private int mMsgGiftNum = 0;
    private com.baidu.tbadk.coreExtra.model.e cwI = new com.baidu.tbadk.coreExtra.model.e();
    private boolean cwL = true;
    private final int[] cwP = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b aqt() {
        if (cwH == null) {
            cwH = new b();
        }
        return cwH;
    }

    private b() {
    }

    public void by(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.cwN = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.cwM = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.cwO = optString2;
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i != this.mMsgAgreeme || i2 != this.mMsgReplyme || i3 != this.mMsgAtme || i4 != this.mMsgChat || i5 != this.mMsgFans || i6 != this.mMsgBookmark || i7 != this.mMsgGiftNum) {
            int i8 = 0;
            if (i > this.mMsgAgreeme || i2 > this.mMsgReplyme || i3 > this.mMsgAtme || i4 > this.mMsgChat || i5 > this.mMsgFans || i6 > this.mMsgBookmark || i7 > this.mMsgGiftNum) {
                i8 = 1;
            } else if (i < this.mMsgAgreeme || i2 < this.mMsgReplyme || i3 < this.mMsgAtme) {
                i8 = 2;
            }
            int i9 = 0;
            if (i > this.mMsgAgreeme && d.ara().arr()) {
                i9 = 1;
            } else if (i < this.mMsgAgreeme) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.mMsgReplyme && d.ara().arh()) {
                i10 = 1;
            } else if (i2 < this.mMsgReplyme) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.mMsgAtme && d.ara().arf()) {
                i11 = 1;
            } else if (i3 < this.mMsgAtme) {
                i11 = 2;
            }
            int i12 = 0;
            if (i4 > this.mMsgChat) {
                i12 = 1;
            }
            int i13 = 0;
            if (i5 > this.mMsgFans) {
                i13 = 1;
            }
            int i14 = 0;
            if (i7 > this.mMsgGiftNum) {
                i14 = 1;
            }
            this.mMsgAgreeme = i;
            this.mMsgReplyme = i2;
            this.mMsgAtme = i3;
            this.mMsgChat = i4;
            this.mMsgFans = i5;
            this.mMsgBookmark = i6;
            this.mMsgGiftNum = i7;
            if (aqO() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                aqL();
                al(i14, 23);
                al(i12, 16);
                al(i8, 17);
                al(i10, 24);
                al(i11, 25);
                al(i13, 26);
                al(i9, 29);
            }
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.mMsgAgreeme || i2 != this.mMsgReplyme || i3 != this.mMsgAtme || i4 != this.mMsgChat || i5 != this.mMsgFans || this.mMsgGiftNum != i6) {
            this.mMsgAgreeme = i;
            this.mMsgReplyme = i2;
            this.mMsgAtme = i3;
            this.mMsgChat = i4;
            this.mMsgFans = i5;
            this.mMsgGiftNum = i6;
            aqL();
            if (aqO() <= 0) {
                al(2, 16);
                al(2, 17);
            }
        }
    }

    public static boolean aqu() {
        if (cwK == null) {
            cwK = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - cwK.getTime() < 10000) {
                return false;
            }
            cwK = date;
        }
        return true;
    }

    public static boolean aqv() {
        if (d.ara().arl()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.ara().arn().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.ara().aro().split(":");
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

    private void al(int i, int i2) {
        try {
            if (i == 1) {
                if (i2 == 23) {
                    if (this.mMsgGiftNum > 0) {
                        String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.mMsgGiftNum));
                        d(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.mMsgAgreeme > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(this.appContext.getString(R.string.notify_agree), Integer.valueOf(this.mMsgAgreeme)));
                        d(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.mMsgReplyme > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.mMsgReplyme > 1) {
                            sb2.append("[");
                            sb2.append(String.valueOf(this.mMsgReplyme));
                            sb2.append(this.appContext.getString(R.string.notify_unit));
                            sb2.append("]");
                        }
                        if (this.cwN != null) {
                            sb2.append(this.cwN);
                        } else {
                            sb2.append(this.appContext.getString(R.string.notify_reply));
                        }
                        d(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.mMsgAtme > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.mMsgAtme > 1) {
                            sb3.append("[");
                            sb3.append(String.valueOf(this.mMsgAtme));
                            sb3.append(this.appContext.getString(R.string.notify_unit));
                            sb3.append("]");
                        }
                        if (this.cwO != null) {
                            sb3.append(this.cwO);
                        } else {
                            sb3.append(this.appContext.getString(R.string.notify_at));
                        }
                        d(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.mMsgFans > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.format(this.appContext.getString(R.string.notify_fans), Integer.valueOf(this.mMsgFans)));
                        d(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16 || !d.ara().arq() || d.ara().ard() > 0) {
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
        String groupMsgName;
        String latestSummary;
        String str;
        boolean z2 = false;
        boolean z3 = true;
        if (eVar != null) {
            try {
                if (i == 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (i2 == 23) {
                        if (this.mMsgGiftNum > 0) {
                            String format = String.format(this.appContext.getString(R.string.notify_gift), String.valueOf(this.mMsgGiftNum));
                            d(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.mMsgAgreeme > 0) {
                            StringBuilder sb = new StringBuilder();
                            if (this.mMsgAgreeme > 1) {
                                sb.append("[");
                                sb.append(String.valueOf(this.mMsgAgreeme));
                                sb.append(this.appContext.getString(R.string.notify_unit));
                                sb.append("]");
                            }
                            if (this.cwM != null) {
                                sb.append(this.cwM);
                            } else {
                                sb.append(this.appContext.getString(R.string.notify_agree));
                            }
                            d(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.mMsgReplyme > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.mMsgReplyme > 1) {
                                sb2.append("[");
                                sb2.append(String.valueOf(this.mMsgReplyme));
                                sb2.append(this.appContext.getString(R.string.notify_unit));
                                sb2.append("]");
                            }
                            if (this.cwN != null) {
                                sb2.append(this.cwN);
                            } else {
                                sb2.append(this.appContext.getString(R.string.notify_reply));
                            }
                            d(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.mMsgAtme > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.mMsgAtme > 1) {
                                sb3.append("[");
                                sb3.append(String.valueOf(this.mMsgAtme));
                                sb3.append(this.appContext.getString(R.string.notify_unit));
                                sb3.append("]");
                            }
                            if (this.cwO != null) {
                                sb3.append(this.cwO);
                            } else {
                                sb3.append(this.appContext.getString(R.string.notify_at));
                            }
                            d(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.mMsgFans > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            if (this.mMsgFans > 1) {
                                sb4.append(String.format(this.appContext.getString(R.string.notify_fans_unit), Integer.valueOf(this.mMsgFans)));
                            }
                            sb4.append(this.appContext.getString(R.string.notify_fans));
                            d(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 == 16) {
                        int unReadGroupMessage = (!d.ara().arq() || d.ara().ard() <= 0) ? 0 : eVar.getUnReadGroupMessage() - eVar.getUnReadGroupMessageNotNotify();
                        long j = 0;
                        if (d.ara().ari() && d.ara().ard() > 0) {
                            j = eVar.getUnReadPrivateMessageCount();
                        }
                        boolean z4 = j > 0;
                        long j2 = unReadGroupMessage + j;
                        if (j2 > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j2 == 1) {
                            eVar.getPrivateMsgUserName();
                            eVar.getLatestSummaryPrivateMessage();
                            if (j == 1) {
                                groupMsgName = eVar.getPrivateMsgUserName();
                                str = eVar.getLatestSummaryPrivateMessage();
                                latestSummary = groupMsgName + "：" + str;
                            } else if (unReadGroupMessage == 1) {
                                groupMsgName = eVar.getGroupMsgName();
                                latestSummary = eVar.getLatestSummary();
                                str = latestSummary;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j2))).toString();
                            }
                            if (TextUtils.isEmpty(latestSummary)) {
                                latestSummary = str;
                            }
                            a(16, groupMsgName, str, latestSummary, z4);
                        }
                    } else if (i2 == 19) {
                        List<e.a> officialNotificationListData = eVar.getOfficialNotificationListData();
                        if (officialNotificationListData != null && officialNotificationListData.size() != 0) {
                            for (e.a aVar : officialNotificationListData) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !aq.isEmpty(aVar.gid) && aVar.unReadCount > aVar.unReadPreCount && aVar.isShow == null) {
                                    aqR();
                                    if (aqS().contains(aVar.gid)) {
                                        a(aVar, 30);
                                    } else {
                                        a(aVar, 19);
                                    }
                                }
                            }
                        }
                    } else if (d.ara().arq() && d.ara().ard() > 0 && eVar.getUnReadGroupUpdates() + eVar.getUnReadGroupValidate() > 0) {
                        if (eVar.getUnReadGroupUpdates() > 0 && !aqC()) {
                            long unReadGroupUpdates = eVar.getUnReadGroupUpdates() - eVar.getUnReadGroupUpdatesEventCount();
                            if (unReadGroupUpdates > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(unReadGroupUpdates)));
                                z = false;
                                z2 = true;
                            } else if (eVar.getUnReadGroupUpdatesEventCount() > 0) {
                                z = true;
                            }
                            if (eVar.getUnReadGroupValidate() > 0 || aqB()) {
                                z3 = z2;
                            } else if (!z2) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(eVar.getUnReadGroupValidate())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(eVar.getUnReadGroupValidate())));
                            }
                            if (z3) {
                                d(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z) {
                                d(18, eVar.getGroupUpdatesEventTitle(), eVar.getGroupUpdatesEventContent(), eVar.getGroupUpdatesEventContent());
                                return;
                            }
                            return;
                        }
                        z = false;
                        if (eVar.getUnReadGroupValidate() > 0) {
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

    private void d(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, false);
    }

    private void a(e.a aVar, int i) {
        PendingIntent service;
        Intent a = a(aVar);
        if (a != null && a.getDataString() != null && a.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.tickerText, PendingIntent.getActivity(this.appContext, i, a, 134217728), false);
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
            h(jl(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.tickerText, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent v;
        PendingIntent service;
        if (this.cwL) {
            if (i == 23 && this.mMsgGiftNum > 0) {
                v = jg(i);
            } else if (i == 26 && this.mMsgFans > 0) {
                v = jh(i);
            } else if (i == 18) {
                v = aqw();
            } else if (i == 24) {
                v = v(i, z);
                v.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                v = v(i, z);
                v.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                v = v(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            v.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, v, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, v, 134217728);
            }
            h(jl(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent jg(int i) {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 24);
        intent.putExtra("KeyOfNotiId", i);
        intent.putExtra("gift_num", this.mMsgGiftNum);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
        if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
            intent.putExtra("un", currentAccount);
            intent.putExtra("name", currentAccountName);
        }
        return intent;
    }

    public Intent jh(int i) {
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
        ImMessageCenterPojo aN = com.baidu.tieba.im.memorycache.b.bCM().aN(aVar.gid, aVar.userType);
        if (aN == null || aN.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = aN.getLastTaskId();
            jSONArray = new JSONArray(aN.getLastContentRawData());
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
        intent.putExtra(BdStatsConstant.StatsKey.UNAME, aVar.gName);
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
        intent.putExtra("tab_id", i);
        return intent;
    }

    public Intent c(e.a aVar) {
        HashMap<Integer, HashSet> aqR = aqR();
        String str = aVar.gid;
        if (aqR != null && !aq.isEmpty(str)) {
            HashSet<String> aqS = aqS();
            HashSet<String> aqT = aqT();
            HashSet<String> aqU = aqU();
            if (aqS != null && aqS.contains(str)) {
                return b(aVar, 3);
            }
            if (aqT != null && aqT.contains(str)) {
                return b(aVar, 1);
            }
            if (aqU != null && aqU.contains(str)) {
                return b(aVar, 2);
            }
        }
        return null;
    }

    public Intent v(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.cwI.getPrivateGidName().keySet();
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
        intent.putExtra("agree_me", this.mMsgAgreeme);
        intent.putExtra("at_me", this.mMsgAtme);
        intent.putExtra("reply_me", this.mMsgReplyme);
        intent.putExtra("fans", this.mMsgFans);
        intent.putExtra("chat", getMsgChat());
        intent.putExtra("group_msg", this.cwI.getUnReadGroupMessage() - this.cwI.getUnReadGroupMessageNotNotify());
        intent.putExtra("group_msg_validate", this.cwI.getUnReadGroupValidate());
        intent.putExtra("group_msg_updates", this.cwI.getUnReadGroupUpdates());
        intent.putExtra("officialbar_msg", this.cwI.getUnReadOfficialMessageCount());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent aqw() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.cwI.getUnReadGroupUpdatesEventCount());
        return intent;
    }

    public void aqx() {
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

    public void aqy() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void aqz() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void ji(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void aqA() {
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void oO(String str) {
        if (TextUtils.isEmpty(str)) {
            aqy();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aqP = aqP();
        if (aqP == null) {
            aqy();
            return;
        }
        HashMap<String, String> groupGidName = aqP.getGroupGidName();
        if (groupGidName == null || groupGidName.isEmpty()) {
            aqy();
        } else if (groupGidName.containsKey(str)) {
            aqy();
        }
    }

    public void oP(String str) {
        if (TextUtils.isEmpty(str)) {
            aqy();
            return;
        }
        com.baidu.tbadk.coreExtra.model.e aqP = aqP();
        if (aqP == null) {
            aqy();
            return;
        }
        HashMap<String, String> privateGidName = aqP.getPrivateGidName();
        if (privateGidName == null || privateGidName.isEmpty()) {
            aqy();
        } else if (privateGidName.containsKey(str)) {
            aqy();
        }
    }

    private boolean aqB() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean aqC() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void aqD() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void jj(int i) {
        com.baidu.tbadk.coreExtra.model.e aqP = aqP();
        if (aqP == null) {
            aqD();
        } else if (1 == i) {
            if (aqP.getUnReadGroupUpdates() <= 0) {
                aqD();
            }
        } else if (2 == i && aqP.getUnReadGroupValidate() <= 0) {
            aqD();
        }
    }

    public void aqE() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void aqF() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void aqG() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void aqH() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void aqI() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void aqJ() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void aqK() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void aqL() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(aqM());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(aqN());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.cwI.getUnReadPrivateMessageCount());
        newsNotifyMessage.setMsgStrangerChat(this.cwI.getUnReadStrangerMergeCount());
        newsNotifyMessage.setMsgOfficialMerge(this.cwI.getUnReadOfficialMergeCount());
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.model.e eVar) {
        if (eVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(aqM());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((eVar.getUnReadPrivateMessageCount() + eVar.getUnReadGroupMessage()) + eVar.getUnReadStrangerMergeCount()) + eVar.getUnReadOfficialMergeCount()) + eVar.getUnReadOfficialAccountCount()) - eVar.getUnReadGroupMessageNotNotify());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(eVar.getUnReadPrivateMessageCount());
            newsNotifyMessage.setMsgStrangerChat(eVar.getUnReadStrangerMergeCount());
            newsNotifyMessage.setMsgOfficialMerge(eVar.getUnReadOfficialMergeCount());
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public int getMsgReplyme() {
        return this.mMsgReplyme;
    }

    public void setMsgReplyme(int i) {
        if (i >= 0) {
            a(this.mMsgAgreeme, i, this.mMsgAtme, this.mMsgChat, this.mMsgFans, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public int getMsgAtme() {
        return this.mMsgAtme;
    }

    public void setMsgAtme(int i) {
        if (i >= 0) {
            a(this.mMsgAgreeme, this.mMsgReplyme, i, this.mMsgChat, this.mMsgFans, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public int aqM() {
        return this.mMsgAgreeme;
    }

    public void jk(int i) {
        if (i >= 0) {
            a(i, this.mMsgReplyme, this.mMsgAtme, this.mMsgChat, this.mMsgFans, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public int getMsgChat() {
        return this.mMsgChat;
    }

    public int aqN() {
        return ((((this.cwI.getUnReadPrivateMessageCount() + this.cwI.getUnReadGroupMessage()) + this.cwI.getUnReadStrangerMergeCount()) + this.cwI.getUnReadOfficialMergeCount()) + this.cwI.getUnReadOfficialAccountCount()) - this.cwI.getUnReadGroupMessageNotNotify();
    }

    public int getMsgFans() {
        return this.mMsgFans;
    }

    public void setMsgFans(int i) {
        if (i >= 0) {
            a(this.mMsgAgreeme, this.mMsgReplyme, this.mMsgAtme, this.mMsgChat, i, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public void setMsgChat(int i) {
        if (i >= 0) {
            a(this.mMsgAgreeme, this.mMsgReplyme, this.mMsgAtme, i, this.mMsgFans, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public int getMsgBookmark() {
        return this.mMsgBookmark;
    }

    public void setMsgBookmark(int i) {
        if (i >= 0) {
            a(this.mMsgAgreeme, this.mMsgReplyme, this.mMsgAtme, this.mMsgChat, this.mMsgFans, i, this.mMsgGiftNum);
        }
    }

    public int getMsgGiftNum() {
        return this.mMsgGiftNum;
    }

    public void setMsgGiftNum(int i) {
        if (i >= 0) {
            this.mMsgGiftNum = i;
        }
    }

    public void ez(boolean z) {
        if (z) {
            a(0, 0, 0, 0, 0, 0, 0);
            return;
        }
        this.mMsgAgreeme = 0;
        this.mMsgReplyme = 0;
        this.mMsgAtme = 0;
        this.mMsgChat = 0;
        this.mMsgFans = 0;
        this.mMsgBookmark = 0;
    }

    public int aqO() {
        return this.mMsgAgreeme + this.mMsgReplyme + this.mMsgAtme + this.mMsgChat + this.mMsgFans + this.mMsgGiftNum;
    }

    public void b(com.baidu.tbadk.coreExtra.model.e eVar) {
        int i = 0;
        if (eVar != null) {
            this.cwI = eVar;
            this.mMsgChat = (eVar.getUnReadGroupMessage() - eVar.getUnReadGroupMessageNotNotify()) + eVar.getUnReadPrivateMessageCount() + eVar.getUnReadOfficialMergeCount() + eVar.getUnReadOfficialAccountCount();
            a(eVar);
            if (eVar.isShowInNotifyBar()) {
                this.cwJ = null;
                mHandler.removeMessages(0);
            }
            if (eVar.isShowInNotifyBar()) {
                if (d.ara().arq() && d.ara().ard() > 0) {
                    i = eVar.getUnReadGroupMessage() - eVar.getUnReadGroupMessageNotNotify();
                }
                long unReadPrivateMessageCount = (!d.ara().ari() || d.ara().ard() <= 0) ? 0L : eVar.getUnReadPrivateMessageCount();
                if ((i > 0 || unReadPrivateMessageCount > 0) && ((i > eVar.getUnReadGroupMessagePreCount() - eVar.getUnReadGroupMessageNotNotify() && i > 0) || unReadPrivateMessageCount > eVar.getUnReadPrivateMessagePreCount())) {
                    a(1, 16, eVar);
                }
                int unReadOfficialMessageCount = eVar.getUnReadOfficialMessageCount();
                if (unReadOfficialMessageCount > 0 && unReadOfficialMessageCount > eVar.getUnReadOfficialMessagePreCount()) {
                    a(1, 19, eVar);
                }
                if (eVar.getUnReadGroupUpdates() > eVar.getUnReadGroupUpdatesPre() || eVar.getUnReadGroupValidate() > eVar.getUnReadGroupValidatePre()) {
                    if (eVar.getUnReadGroupUpdates() <= eVar.getUnReadGroupUpdatesPre() || eVar.getUnReadGroupValidate() != eVar.getUnReadGroupValidatePre() || !aqC()) {
                        if (eVar.getUnReadGroupUpdates() != eVar.getUnReadGroupUpdatesPre() || eVar.getUnReadGroupValidate() <= eVar.getUnReadGroupValidatePre() || !aqB()) {
                            a(1, 17, eVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.e aqP() {
        return this.cwI;
    }

    public void c(com.baidu.tbadk.coreExtra.model.e eVar) {
        this.cwI = eVar;
    }

    public com.baidu.tbadk.coreExtra.model.e aqQ() {
        return this.cwJ;
    }

    public int jl(int i) {
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

    public void h(long j, int i) {
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

    public HashMap<Integer, HashSet> aqR() {
        JSONArray jSONArray;
        if (!cwE && cwF) {
            return this.cwG;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.KEY_RESPONSED_PULL_CONFIG_TAB_UID, null);
        if (string == null) {
            if (this.cwG.get(0) == null) {
                this.cwG.put(0, new HashSet());
            }
            this.cwG.get(0).add("3222425470");
            return this.cwG;
        }
        if (this.cwG.get(0) != null) {
            this.cwG.get(0).clear();
        }
        if (this.cwG.get(1) != null) {
            this.cwG.get(1).clear();
        }
        if (this.cwG.get(2) != null) {
            this.cwG.get(2).clear();
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
                int optInt = optJSONObject.optInt("tab_id");
                String optString = optJSONObject.optString("uid");
                switch (optInt) {
                    case 0:
                        if (this.cwG.get(0) == null) {
                            this.cwG.put(0, new HashSet());
                        }
                        this.cwG.get(0).add(optString);
                        continue;
                    case 1:
                        if (this.cwG.get(1) == null) {
                            this.cwG.put(1, new HashSet());
                        }
                        this.cwG.get(1).add(optString);
                        continue;
                    case 2:
                        if (this.cwG.get(2) == null) {
                            this.cwG.put(2, new HashSet());
                        }
                        this.cwG.get(2).add(optString);
                        continue;
                    default:
                        continue;
                }
            }
        }
        cwF = true;
        cwE = false;
        return this.cwG;
    }

    public HashSet<String> aqS() {
        aqR();
        return this.cwG.get(0);
    }

    public HashSet<String> aqT() {
        aqR();
        return this.cwG.get(1);
    }

    public HashSet<String> aqU() {
        aqR();
        return this.cwG.get(2);
    }

    public String aqV() {
        HashSet<String> aqS = aqS();
        if (aqS != null) {
            Iterator<String> it = aqS.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return null;
    }
}
