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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b fuW;
    private static Date fuZ = null;
    private static Handler mHandler = new Handler() { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                b.bBd().b(b.bBd().bBA());
            }
        }
    };
    private com.baidu.tbadk.coreExtra.model.f fuY;
    private String fvb;
    private String fvc;
    private String fvd;
    private int mMsgAgreeme = 0;
    private int mMsgReplyme = 0;
    private int mMsgAtme = 0;
    private int mMsgChat = 0;
    private int mMsgBookmark = 0;
    private int mMsgFans = 0;
    private int mMsgGiftNum = 0;
    private com.baidu.tbadk.coreExtra.model.f fuX = new com.baidu.tbadk.coreExtra.model.f();
    private boolean fva = true;
    private final int[] fve = new int[10];
    private final Context appContext = TbadkCoreApplication.getInst().getApp();

    public static b bBd() {
        if (fuW == null) {
            fuW = new b();
        }
        return fuW;
    }

    private b() {
    }

    public void dw(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("atme");
                String optString3 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.fvc = optString;
                }
                if (!StringUtils.isNull(optString3) && optInt2 > 0) {
                    this.fvb = optString3;
                }
                if (!StringUtils.isNull(optString2)) {
                    this.fvd = optString2;
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
            if (i > this.mMsgAgreeme && d.bBG().bBX()) {
                i9 = 1;
            } else if (i < this.mMsgAgreeme) {
                i9 = 2;
            }
            int i10 = 0;
            if (i2 > this.mMsgReplyme && d.bBG().bBN()) {
                i10 = 1;
            } else if (i2 < this.mMsgReplyme) {
                i10 = 2;
            }
            int i11 = 0;
            if (i3 > this.mMsgAtme && d.bBG().bBL()) {
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
            if (bBy() <= 0) {
                i8 = 2;
                i14 = 2;
                i12 = 2;
                i10 = 2;
                i11 = 2;
                i13 = 2;
                i9 = 2;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                bBv();
                bd(i14, 23);
                bd(i12, 16);
                bd(i8, 17);
                bd(i10, 24);
                bd(i11, 25);
                bd(i13, 26);
                bd(i9, 29);
            }
        }
    }

    public void e(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i != this.mMsgAgreeme || i2 != this.mMsgReplyme || i3 != this.mMsgAtme || i4 != this.mMsgChat || i5 != this.mMsgFans || this.mMsgGiftNum != i6) {
            this.mMsgAgreeme = i;
            this.mMsgReplyme = i2;
            this.mMsgAtme = i3;
            this.mMsgChat = i4;
            this.mMsgFans = i5;
            this.mMsgGiftNum = i6;
            bBv();
            if (bBy() <= 0) {
                bd(2, 16);
                bd(2, 17);
            }
        }
    }

    public static boolean bBe() {
        if (fuZ == null) {
            fuZ = new Date();
        } else {
            Date date = new Date();
            if (date.getTime() - fuZ.getTime() < 10000) {
                return false;
            }
            fuZ = date;
        }
        return true;
    }

    public static boolean bBf() {
        if (d.bBG().bBR()) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            String[] split = d.bBG().bBT().split(":");
            int parseInt = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
            String[] split2 = d.bBG().bBU().split(":");
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

    private void bd(int i, int i2) {
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
                        if (this.fvc != null) {
                            sb2.append(this.fvc);
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
                        if (this.fvd != null) {
                            sb3.append(this.fvd);
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
                } else if (i2 == 16 || !d.bBG().bBW() || d.bBG().bBJ() > 0) {
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.appContext, 16);
                NotificationHelper.cancelNotification(this.appContext, 17);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0331 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a7, B:66:0x01b1, B:68:0x01bb, B:72:0x01c6, B:74:0x01cf, B:77:0x01ff, B:79:0x020e, B:80:0x022e, B:82:0x0234, B:83:0x0252, B:86:0x0259, B:88:0x0263, B:91:0x0272, B:93:0x0278, B:95:0x027e, B:96:0x0282, B:98:0x0288, B:100:0x0290, B:102:0x0298, B:104:0x02a0, B:106:0x02a6, B:108:0x02aa, B:109:0x02b0, B:111:0x02ba, B:113:0x02c4, B:115:0x02cf, B:117:0x02d5, B:119:0x02db, B:121:0x02e9, B:122:0x0304, B:124:0x030a, B:127:0x0312, B:129:0x0331, B:131:0x0341, B:135:0x035d, B:132:0x0354, B:138:0x037e), top: B:145:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0341 A[Catch: Exception -> 0x0037, TryCatch #0 {Exception -> 0x0037, blocks: (B:6:0x000b, B:8:0x0014, B:10:0x0018, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0071, B:23:0x0075, B:24:0x007a, B:25:0x0089, B:28:0x0099, B:30:0x009d, B:32:0x00a6, B:33:0x00c6, B:35:0x00ca, B:36:0x00cf, B:37:0x00df, B:40:0x00ef, B:42:0x00f3, B:44:0x00fc, B:45:0x011c, B:47:0x0120, B:48:0x0125, B:49:0x0135, B:52:0x0145, B:54:0x0149, B:56:0x0152, B:57:0x016d, B:59:0x018a, B:61:0x0194, B:63:0x019e, B:64:0x01a7, B:66:0x01b1, B:68:0x01bb, B:72:0x01c6, B:74:0x01cf, B:77:0x01ff, B:79:0x020e, B:80:0x022e, B:82:0x0234, B:83:0x0252, B:86:0x0259, B:88:0x0263, B:91:0x0272, B:93:0x0278, B:95:0x027e, B:96:0x0282, B:98:0x0288, B:100:0x0290, B:102:0x0298, B:104:0x02a0, B:106:0x02a6, B:108:0x02aa, B:109:0x02b0, B:111:0x02ba, B:113:0x02c4, B:115:0x02cf, B:117:0x02d5, B:119:0x02db, B:121:0x02e9, B:122:0x0304, B:124:0x030a, B:127:0x0312, B:129:0x0331, B:131:0x0341, B:135:0x035d, B:132:0x0354, B:138:0x037e), top: B:145:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2, com.baidu.tbadk.coreExtra.model.f fVar) {
        boolean z;
        boolean z2;
        String groupMsgName;
        String str;
        String str2;
        boolean z3 = true;
        if (fVar != null) {
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
                            if (this.fvb != null) {
                                sb.append(this.fvb);
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
                            if (this.fvc != null) {
                                sb2.append(this.fvc);
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
                            if (this.fvd != null) {
                                sb3.append(this.fvd);
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
                        int unReadGroupMessage = (!d.bBG().bBW() || d.bBG().bBJ() <= 0) ? 0 : fVar.getUnReadGroupMessage() - fVar.getUnReadGroupMessageNotNotify();
                        long unReadPrivateMessageCount = (!d.bBG().bBO() || d.bBG().bBJ() <= 0) ? 0L : fVar.getUnReadPrivateMessageCount();
                        boolean z4 = unReadPrivateMessageCount > 0;
                        long j = unReadPrivateMessageCount + unReadGroupMessage;
                        if (j > 1) {
                            stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j)));
                            a(16, null, stringBuffer.toString(), stringBuffer.toString(), z4);
                        } else if (j == 1) {
                            fVar.getPrivateMsgUserName();
                            fVar.getLatestSummaryPrivateMessage();
                            if (unReadPrivateMessageCount == 1) {
                                groupMsgName = fVar.getPrivateMsgUserName();
                                str2 = fVar.getLatestSummaryPrivateMessage();
                                str = groupMsgName + "：" + str2;
                            } else if (unReadGroupMessage == 1) {
                                groupMsgName = fVar.getGroupMsgName();
                                String latestSummary = fVar.getLatestSummary();
                                str = latestSummary;
                                str2 = latestSummary;
                            } else {
                                return;
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = stringBuffer.append(String.format(this.appContext.getString(R.string.notify_chat), Long.valueOf(j))).toString();
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = str2;
                            }
                            a(16, groupMsgName, str2, str, z4);
                        }
                    } else if (i2 == 19) {
                        List<f.a> officialNotificationListData = fVar.getOfficialNotificationListData();
                        if (officialNotificationListData != null && officialNotificationListData.size() != 0) {
                            for (f.a aVar : officialNotificationListData) {
                                if (aVar != null && !StringUtils.isNull(aVar.content) && !at.isEmpty(aVar.gid) && aVar.unReadCount > aVar.unReadPreCount && aVar.isShow == null) {
                                    a(aVar, 19);
                                }
                            }
                        }
                    } else if (d.bBG().bBW() && d.bBG().bBJ() > 0 && fVar.getUnReadGroupUpdates() + fVar.getUnReadGroupValidate() > 0) {
                        if (fVar.getUnReadGroupUpdates() > 0 && !bBl()) {
                            long unReadGroupUpdates = fVar.getUnReadGroupUpdates() - fVar.getUnReadGroupUpdatesEventCount();
                            if (unReadGroupUpdates > 0) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_updates), Long.valueOf(unReadGroupUpdates)));
                                z = true;
                                z2 = false;
                            } else if (fVar.getUnReadGroupUpdatesEventCount() > 0) {
                                z = false;
                                z2 = true;
                            }
                            if (fVar.getUnReadGroupValidate() > 0 || bBk()) {
                                z3 = z;
                            } else if (!z) {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate), Integer.valueOf(fVar.getUnReadGroupValidate())));
                            } else {
                                stringBuffer.append(String.format(this.appContext.getString(R.string.notify_validate_1), Integer.valueOf(fVar.getUnReadGroupValidate())));
                            }
                            if (z3) {
                                d(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (!z2) {
                                d(18, fVar.getGroupUpdatesEventTitle(), fVar.getGroupUpdatesEventContent(), fVar.getGroupUpdatesEventContent());
                                return;
                            }
                            return;
                        }
                        z = false;
                        z2 = false;
                        if (fVar.getUnReadGroupValidate() > 0) {
                        }
                        z3 = z;
                        if (z3) {
                        }
                        if (!z2) {
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

    private void a(f.a aVar, int i) {
        PendingIntent service;
        Intent a2 = a(aVar);
        if (a2 != null && a2.getDataString() != null && a2.getDataString().contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
            a2.setFlags(276824064);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.tickerText, PendingIntent.getActivity(this.appContext, i, a2, 134217728), false);
            return;
        }
        if (a2 == null) {
            a2 = b(aVar);
        }
        if (a2 == null) {
            a2 = c(aVar);
        }
        if (a2 != null) {
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, a2, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, a2, 134217728);
            }
            s(rU(i), i);
            NotificationHelper.showNotification(this.appContext, i, aVar.title, aVar.content, aVar.tickerText, service, false);
        }
    }

    private void a(int i, String str, String str2, String str3, boolean z) {
        Intent H;
        PendingIntent service;
        if (this.fva) {
            if (i == 23 && this.mMsgGiftNum > 0) {
                H = rP(i);
            } else if (i == 26 && this.mMsgFans > 0) {
                H = rQ(i);
            } else if (i == 18) {
                H = bBg();
            } else if (i == 24) {
                H = H(i, z);
                H.putExtra("tab_id", 1);
                WriteImageActivityConfig.isActivityInStack = true;
            } else if (i == 16 || i == 17 || i == 18) {
                H = H(i, z);
                H.putExtra("tab_id", 2);
                WriteImageActivityConfig.isActivityInStack = true;
            } else {
                H = H(i, z);
                WriteImageActivityConfig.isActivityInStack = true;
            }
            H.setFlags(268435456);
            if (UtilHelper.isFlyMeOs()) {
                service = PendingIntent.getActivity(this.appContext, i, H, 134217728);
            } else {
                service = PendingIntent.getService(this.appContext, i, H, 134217728);
            }
            s(rU(i), i);
            NotificationHelper.showNotification(this.appContext, i, str, str2, str3, service, false);
        }
    }

    public Intent rP(int i) {
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

    public Intent rQ(int i) {
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

    public Intent a(f.a aVar) {
        String lastTaskId;
        String lastServiceId;
        JSONArray jSONArray;
        if (aVar == null) {
            return null;
        }
        ImMessageCenterPojo br = com.baidu.tieba.im.memorycache.b.cYy().br(aVar.gid, aVar.userType);
        if (br == null || br.getLast_content() == null) {
            return null;
        }
        try {
            lastTaskId = br.getLastTaskId();
            lastServiceId = br.getLastServiceId();
            jSONArray = new JSONArray(br.getLastContentRawData());
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
                    intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("gid", aVar.gid);
                    intent.putExtra("task_id", lastTaskId);
                    intent.putExtra(Constants.EXTRA_SERVICE, lastServiceId);
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
                intent2.putExtra(Constants.EXTRA_SERVICE, lastServiceId);
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
                intent3.putExtra(Constants.EXTRA_SERVICE, lastServiceId);
                return intent3;
            } else if (optString.contains("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                return Intent.parseUri(optString, 1);
            } else {
                if (optString.contains("tieba.baidu.com/subp")) {
                    Intent intent4 = new Intent();
                    if (UtilHelper.isFlyMeOs()) {
                        intent4.setClass(this.appContext, DealIntentActivity.class);
                    } else {
                        intent4.setClass(this.appContext, DealIntentService.class);
                    }
                    intent4.putExtra(DealIntentService.KEY_CLASS, 39);
                    String paramStr = be.getParamStr(optString);
                    if (!TextUtils.isEmpty(paramStr)) {
                        Map<String, String> paramPair = be.getParamPair(paramStr);
                        if (!paramPair.isEmpty()) {
                            String str = paramPair.get("tid");
                            String str2 = paramPair.get("pid");
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                intent4.putExtra("thread_id", str);
                                intent4.putExtra("post_id", str2);
                                return intent4;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public Intent b(f.a aVar) {
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

    public Intent c(f.a aVar) {
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
        intent.putExtra("tab_id", 1);
        return intent;
    }

    public Intent H(int i, boolean z) {
        String str = "";
        if (z) {
            Set<String> keySet = this.fuX.getPrivateGidName().keySet();
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
        intent.putExtra("group_msg", this.fuX.getUnReadGroupMessage() - this.fuX.getUnReadGroupMessageNotNotify());
        intent.putExtra("group_msg_validate", this.fuX.getUnReadGroupValidate());
        intent.putExtra("group_msg_updates", this.fuX.getUnReadGroupUpdates());
        intent.putExtra("officialbar_msg", this.fuX.getUnReadOfficialMessageCount());
        intent.putExtra("privateGid", str);
        return intent;
    }

    public Intent bBg() {
        Intent intent = new Intent();
        if (UtilHelper.isFlyMeOs()) {
            intent.setClass(this.appContext, DealIntentActivity.class);
        } else {
            intent.setClass(this.appContext, DealIntentService.class);
        }
        intent.putExtra(DealIntentService.KEY_CLASS, 14);
        intent.putExtra("group_msg_updates", this.fuX.getUnReadGroupUpdatesEventCount());
        return intent;
    }

    public void bBh() {
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

    public void bBi() {
        NotificationHelper.cancelNotification(this.appContext, 16);
    }

    public void bBj() {
        NotificationHelper.cancelNotification(this.appContext, 19);
    }

    public void rR(int i) {
        NotificationHelper.cancelNotification(this.appContext, i);
    }

    public void CT(String str) {
        if (TextUtils.isEmpty(str)) {
            bBi();
            return;
        }
        com.baidu.tbadk.coreExtra.model.f bBz = bBz();
        if (bBz == null) {
            bBi();
            return;
        }
        HashMap<String, String> groupGidName = bBz.getGroupGidName();
        if (groupGidName == null || groupGidName.isEmpty()) {
            bBi();
        } else if (groupGidName.containsKey(str)) {
            bBi();
        }
    }

    public void CU(String str) {
        if (TextUtils.isEmpty(str)) {
            bBi();
            return;
        }
        com.baidu.tbadk.coreExtra.model.f bBz = bBz();
        if (bBz == null) {
            bBi();
            return;
        }
        HashMap<String, String> privateGidName = bBz.getPrivateGidName();
        if (privateGidName == null || privateGidName.isEmpty()) {
            bBi();
        } else if (privateGidName.containsKey(str)) {
            bBi();
        }
    }

    private boolean bBk() {
        return ChatStatusManager.getInst().getIsOpen(7);
    }

    private boolean bBl() {
        return ChatStatusManager.getInst().getIsOpen(6);
    }

    public void bBm() {
        NotificationHelper.cancelNotification(this.appContext, 17);
    }

    public void rS(int i) {
        com.baidu.tbadk.coreExtra.model.f bBz = bBz();
        if (bBz == null) {
            bBm();
        } else if (1 == i) {
            if (bBz.getUnReadGroupUpdates() <= 0) {
                bBm();
            }
        } else if (2 == i && bBz.getUnReadGroupValidate() <= 0) {
            bBm();
        }
    }

    public void bBn() {
        NotificationHelper.cancelNotification(this.appContext, 18);
    }

    public void bBo() {
        NotificationHelper.cancelNotification(this.appContext, 26);
        NotificationHelper.cancelNotification(this.appContext, 25);
        NotificationHelper.cancelNotification(this.appContext, 24);
        NotificationHelper.cancelNotification(this.appContext, 23);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void bBp() {
        NotificationHelper.cancelNotification(this.appContext, 17);
        NotificationHelper.cancelNotification(this.appContext, 19);
        NotificationHelper.cancelNotification(this.appContext, 16);
        NotificationHelper.cancelNotification(this.appContext, 18);
        NotificationHelper.cancelNotification(this.appContext, 30);
    }

    public void bBq() {
        NotificationHelper.cancelNotification(this.appContext, 24);
    }

    public void bBr() {
        NotificationHelper.cancelNotification(this.appContext, 25);
    }

    public void bBs() {
        NotificationHelper.cancelNotification(this.appContext, 29);
    }

    public void bBt() {
        NotificationHelper.cancelNotification(this.appContext, 26);
    }

    public void bBu() {
        NotificationHelper.cancelNotification(this.appContext, 23);
    }

    public void bBv() {
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setMsgAgree(bBw());
        newsNotifyMessage.setMsgAtme(getMsgAtme());
        newsNotifyMessage.setMsgBookmark(getMsgBookmark());
        newsNotifyMessage.setMsgChat(bBx());
        newsNotifyMessage.setMsgFans(getMsgFans());
        newsNotifyMessage.setMsgReplyme(getMsgReplyme());
        newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
        newsNotifyMessage.setMsgPrivateChat(this.fuX.getUnReadPrivateMessageCount());
        newsNotifyMessage.setMsgStrangerChat(this.fuX.getUnReadStrangerMergeCount());
        newsNotifyMessage.setMsgOfficialMerge(this.fuX.getUnReadOfficialMergeCount());
        a(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    private void a(NewsNotifyMessage newsNotifyMessage) {
    }

    public void a(com.baidu.tbadk.coreExtra.model.f fVar) {
        if (fVar != null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setMsgAgree(bBw());
            newsNotifyMessage.setMsgAtme(getMsgAtme());
            newsNotifyMessage.setMsgBookmark(getMsgBookmark());
            newsNotifyMessage.setMsgChat(((((fVar.getUnReadPrivateMessageCount() + fVar.getUnReadGroupMessage()) + fVar.getUnReadStrangerMergeCount()) + fVar.getUnReadOfficialMergeCount()) + fVar.getUnReadOfficialAccountCount()) - fVar.getUnReadGroupMessageNotNotify());
            newsNotifyMessage.setMsgFans(getMsgFans());
            newsNotifyMessage.setMsgReplyme(getMsgReplyme());
            newsNotifyMessage.setMsgGiftNum(getMsgGiftNum());
            newsNotifyMessage.setMsgPrivateChat(fVar.getUnReadPrivateMessageCount());
            newsNotifyMessage.setMsgStrangerChat(fVar.getUnReadStrangerMergeCount());
            newsNotifyMessage.setMsgOfficialMerge(fVar.getUnReadOfficialMergeCount());
            a(newsNotifyMessage);
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

    public int bBw() {
        return this.mMsgAgreeme;
    }

    public void rT(int i) {
        if (i >= 0) {
            a(i, this.mMsgReplyme, this.mMsgAtme, this.mMsgChat, this.mMsgFans, this.mMsgBookmark, this.mMsgGiftNum);
        }
    }

    public int getMsgChat() {
        return this.mMsgChat;
    }

    public int bBx() {
        return ((((this.fuX.getUnReadPrivateMessageCount() + this.fuX.getUnReadGroupMessage()) + this.fuX.getUnReadStrangerMergeCount()) + this.fuX.getUnReadOfficialMergeCount()) + this.fuX.getUnReadOfficialAccountCount()) - this.fuX.getUnReadGroupMessageNotNotify();
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

    public void kk(boolean z) {
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

    public int bBy() {
        return this.mMsgAgreeme + this.mMsgReplyme + this.mMsgAtme + this.mMsgChat + this.mMsgFans + this.mMsgGiftNum;
    }

    public void b(com.baidu.tbadk.coreExtra.model.f fVar) {
        int i = 0;
        if (fVar != null) {
            this.fuX = fVar;
            this.mMsgChat = (fVar.getUnReadGroupMessage() - fVar.getUnReadGroupMessageNotNotify()) + fVar.getUnReadPrivateMessageCount() + fVar.getUnReadOfficialMergeCount() + fVar.getUnReadOfficialAccountCount();
            a(fVar);
            if (fVar.isShowInNotifyBar()) {
                this.fuY = null;
                mHandler.removeMessages(0);
            }
            if (fVar.isShowInNotifyBar()) {
                if (d.bBG().bBW() && d.bBG().bBJ() > 0) {
                    i = fVar.getUnReadGroupMessage() - fVar.getUnReadGroupMessageNotNotify();
                }
                long unReadPrivateMessageCount = (!d.bBG().bBO() || d.bBG().bBJ() <= 0) ? 0L : fVar.getUnReadPrivateMessageCount();
                if ((i > 0 || unReadPrivateMessageCount > 0) && ((i > fVar.getUnReadGroupMessagePreCount() - fVar.getUnReadGroupMessageNotNotify() && i > 0) || unReadPrivateMessageCount > fVar.getUnReadPrivateMessagePreCount())) {
                    a(1, 16, fVar);
                }
                int unReadOfficialMessageCount = fVar.getUnReadOfficialMessageCount();
                if (unReadOfficialMessageCount > 0 && unReadOfficialMessageCount > fVar.getUnReadOfficialMessagePreCount()) {
                    a(1, 19, fVar);
                }
                if (fVar.getUnReadGroupUpdates() > fVar.getUnReadGroupUpdatesPre() || fVar.getUnReadGroupValidate() > fVar.getUnReadGroupValidatePre()) {
                    if (fVar.getUnReadGroupUpdates() <= fVar.getUnReadGroupUpdatesPre() || fVar.getUnReadGroupValidate() != fVar.getUnReadGroupValidatePre() || !bBl()) {
                        if (fVar.getUnReadGroupUpdates() != fVar.getUnReadGroupUpdatesPre() || fVar.getUnReadGroupValidate() <= fVar.getUnReadGroupValidatePre() || !bBk()) {
                            a(1, 17, fVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tbadk.coreExtra.model.f bBz() {
        return this.fuX;
    }

    public void c(com.baidu.tbadk.coreExtra.model.f fVar) {
        this.fuX = fVar;
    }

    public com.baidu.tbadk.coreExtra.model.f bBA() {
        return this.fuY;
    }

    public int rU(int i) {
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

    public void s(long j, int i) {
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

    public String bBB() {
        return "3222425470";
    }

    public boolean CV(String str) {
        return "3222425470".equals(str);
    }
}
