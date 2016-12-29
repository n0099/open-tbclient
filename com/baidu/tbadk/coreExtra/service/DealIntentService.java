package com.baidu.tbadk.coreExtra.service;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MessageAggregationActivityConfig;
import com.baidu.tbadk.core.d.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* loaded from: classes.dex */
public class DealIntentService extends BdBaseService {
    private static String ACTION_ON_POST_EXSIT = "TaskExsits";
    private static String ACTION_ON_POST_START = "TaskNeedsTobeStart";
    public static final int CLASS_TYPE_ENTER_OFFICIAL = 27;
    public static final int CLASS_TYPE_FRS = 2;
    public static final int CLASS_TYPE_GIFT_INFO = 24;
    public static final int CLASS_TYPE_GROUP_EVENT = 14;
    public static final int CLASS_TYPE_GROUP_INFO = 13;
    public static final int CLASS_TYPE_LIVE_GROUP = 17;
    public static final int CLASS_TYPE_LIVE_NOTIFY = 16;
    public static final int CLASS_TYPE_MAIN = 3;
    public static final int CLASS_TYPE_MESSAGE = 5;
    public static final int CLASS_TYPE_MESSAGE_NEW = 11;
    public static final int CLASS_TYPE_MESSAGE_NEW_MENTION = 21;
    public static final int CLASS_TYPE_MIDDLE_PAGE = 34;
    public static final int CLASS_TYPE_MY_COLLECT_UPDATE = 33;
    public static final int CLASS_TYPE_NATIVE_BUY_TBEAN = 25;
    public static final int CLASS_TYPE_NATIVE_JUMP = 30;
    public static final int CLASS_TYPE_NATIVE_PAY = 23;
    public static final int CLASS_TYPE_OFFICAL_BAR = 22;
    public static final int CLASS_TYPE_PAY = 15;
    public static final int CLASS_TYPE_PAYMENT_CONFIRM = 32;
    public static final int CLASS_TYPE_PB = 1;
    public static final int CLASS_TYPE_PERSON = 10;
    public static final int CLASS_TYPE_PERSON_LIST = 35;
    public static final int CLASS_TYPE_PERSON_NEW = 12;
    public static final int CLASS_TYPE_PHOTO_LIVE = 31;
    public static final int CLASS_TYPE_PK_AFTER = 7;
    public static final int CLASS_TYPE_PK_BEFORE = 6;
    public static final int CLASS_TYPE_PUSH_RECOMMEND_PB = 29;
    public static final int CLASS_TYPE_RECOMMEND_PB = 28;
    public static final int CLASS_TYPE_SIGN = 9;
    public static final int CLASS_TYPE_SINGLESQUARE_ACTIVITY = 19;
    public static final int CLASS_TYPE_SQUARESEARCH_ACTIVITY = 18;
    public static final int CLASS_TYPE_VOTE = 8;
    public static final int CLASS_TYPE_WEB = 0;
    private a mDealAsyncTask = null;

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            doDeal(intent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void doDeal(Intent intent) {
        if (this.mDealAsyncTask != null) {
            this.mDealAsyncTask.cancel();
            this.mDealAsyncTask = null;
        }
        this.mDealAsyncTask = new a(intent);
        this.mDealAsyncTask.setPriority(4);
        this.mDealAsyncTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private Intent intent;

        public a(Intent intent) {
            this.intent = null;
            this.intent = intent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            String string = this.intent.getExtras().getString("privateGid");
            if (!TextUtils.isEmpty(string)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.SEND_PV_TJ, string));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (this.intent == null || this.intent.getExtras() == null) {
                return null;
            }
            int i = this.intent.getExtras().getInt("class", -1);
            TiebaStatic.log("c11703");
            if (this.intent.getExtras().getBoolean("is_notify", false)) {
                ee(i);
            }
            String string = this.intent.getExtras().getString("stat");
            String stringExtra = this.intent.getStringExtra("link");
            long j = this.intent.getExtras().getLong(InterviewLiveActivityConfig.KEY_TASK_ID);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp().getApplicationContext(), "cl_push_noti:" + string, "taskId:" + j + ";link:" + stringExtra + ";uid:" + TbadkCoreApplication.getCurrentAccount());
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("activity")).getRunningTasks(500);
            String mentionActivityClassName = MessageAggregationActivityConfig.getMentionActivityClassName();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.baseActivity.getPackageName().equals(DealIntentService.this.getPackageName())) {
                    if (5 == this.intent.getIntExtra("class", -1)) {
                        if (!runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(b.tQ())) {
                            this.intent.putExtra("class", 11);
                        }
                        if (mentionActivityClassName != null && runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(mentionActivityClassName)) {
                            this.intent.putExtra("class", 21);
                        }
                    } else if (10 == this.intent.getIntExtra("class", -1)) {
                        this.intent.putExtra("class", 12);
                    }
                    return DealIntentService.ACTION_ON_POST_EXSIT;
                }
            }
            if (i == 27) {
                TiebaStatic.eventStat(DealIntentService.this, "open_push", IntentConfig.START, 1, new Object[0]);
            }
            if (this.intent.getExtras().getBoolean("is_notify", false)) {
                ed(i);
            }
            return DealIntentService.ACTION_ON_POST_START;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ew */
        public void onPostExecute(String str) {
            if (str != null) {
                if (!str.equals(DealIntentService.ACTION_ON_POST_EXSIT)) {
                    if (str.equals(DealIntentService.ACTION_ON_POST_START)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(DealIntentService.this, this.intent)));
                    }
                } else {
                    this.intent.addFlags(268435456);
                    CustomMessage customMessage = new CustomMessage(CmdConfigCustom.DEAL_INTENT);
                    customMessage.setData(this.intent);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
            }
            DealIntentService.this.stopSelf();
        }

        private void ed(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    return;
            }
        }

        private void ee(int i) {
            switch (i) {
                case 6:
                    TiebaStatic.eventStat(DealIntentService.this, "notify_to_pk_before", "click");
                    return;
                case 7:
                    TiebaStatic.eventStat(DealIntentService.this, "notify_to_pk_end", "click");
                    return;
                case 8:
                    TiebaStatic.eventStat(DealIntentService.this, "notify_to_vote_list", "click");
                    return;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    return;
                case 14:
                    TiebaStatic.log("notify_group_event_click");
                    return;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }
    }
}
