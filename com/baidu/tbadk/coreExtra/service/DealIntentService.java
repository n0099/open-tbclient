package com.baidu.tbadk.coreExtra.service;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.AdExtParam;
import d.b.c.a.b;
import d.b.c.e.p.k;
/* loaded from: classes3.dex */
public class DealIntentService extends BdBaseService {
    public static String ACTION_ON_POST_EXSIT = "TaskExsits";
    public static String ACTION_ON_POST_START = "TaskNeedsTobeStart";
    public static final int CLASS_TYPE_AI_APP = 37;
    public static final int CLASS_TYPE_AI_APP_GUIDE = 38;
    public static final int CLASS_TYPE_ENTER_OFFICIAL = 27;
    public static final int CLASS_TYPE_FRS = 2;
    public static final int CLASS_TYPE_GIFT_INFO = 24;
    public static final int CLASS_TYPE_GROUP_EVENT = 14;
    public static final int CLASS_TYPE_GROUP_INFO = 13;
    public static final int CLASS_TYPE_MAIN = 3;
    public static final int CLASS_TYPE_MESSAGE = 5;
    public static final int CLASS_TYPE_MESSAGE_CENTER = 36;
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
    public static final int CLASS_TYPE_SUB_PB = 39;
    public static final int CLASS_TYPE_VOTE = 8;
    public static final int CLASS_TYPE_WEB = 0;
    public static final String KEY_CLASS = "class";
    public a mDealAsyncTask = null;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public Intent f13379a;

        public a(Intent intent) {
            this.f13379a = null;
            this.f13379a = intent;
        }

        public final void b(int i) {
        }

        public final void c(int i) {
            if (i == 6) {
                TiebaStatic.eventStat(DealIntentService.this, "notify_to_pk_before", PrefetchEvent.STATE_CLICK);
            } else if (i == 7) {
                TiebaStatic.eventStat(DealIntentService.this, "notify_to_pk_end", PrefetchEvent.STATE_CLICK);
            } else if (i == 8) {
                TiebaStatic.eventStat(DealIntentService.this, "notify_to_vote_list", PrefetchEvent.STATE_CLICK);
            } else if (i != 14) {
            } else {
                TiebaStatic.log(TbadkCoreStatisticKey.NOTIFY_GROUP_EVENT_CLICK);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            String string = this.f13379a.getExtras().getString("privateGid");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2012110, string));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Intent intent = this.f13379a;
            if (intent == null || intent.getExtras() == null) {
                return null;
            }
            int i = this.f13379a.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
            String stringExtra = this.f13379a.getStringExtra("link");
            long j = this.f13379a.getExtras().getLong("task_id");
            long j2 = this.f13379a.getExtras().getLong("service_id");
            String stringExtra2 = this.f13379a.getStringExtra("task_id");
            if (!k.isEmpty(stringExtra2) && j == 0) {
                j = Long.parseLong(stringExtra2);
            }
            if (j > 0) {
                TbadkCoreApplication.getInst().setTaskId(String.valueOf(j));
            }
            if (i == 9) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_PUSH_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("service_id", j2).param(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, stringExtra).param("task_id", j).param("app_version", TbConfig.getVersion()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
            int i2 = this.f13379a.getExtras().getInt("is_live", -1);
            int i3 = this.f13379a.getExtras().getInt("is_live_lcs", -1);
            if (i2 >= 0) {
                param.param("is_live", i2);
            }
            if (i3 >= 0) {
                param.param("is_live_lcs", i3);
            }
            int i4 = this.f13379a.getExtras().getInt("KeyOfNotiId", -1);
            int i5 = (i4 == 16 || i4 == 17) ? 3 : i4 != 19 ? (i4 == 29 || i4 == 24 || i4 == 25) ? 1 : 0 : 2;
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("HotThreadList")) {
                i5 = 6;
            } else if ((!TextUtils.isEmpty(stringExtra) && stringExtra.contains("HotInteraction")) || (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("frs?kw="))) {
                i5 = 7;
            }
            param.param("obj_source", i5);
            TiebaStatic.log(param);
            if (this.f13379a.getExtras().getBoolean("is_notify", false)) {
                c(i);
            }
            String string = this.f13379a.getExtras().getString("stat");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "cl_push_noti:" + string, "taskId:" + j + ";link:" + stringExtra + ";uid:" + TbadkCoreApplication.getCurrentAccount());
            }
            if (b.f().b() != null) {
                if (5 == this.f13379a.getIntExtra(DealIntentService.KEY_CLASS, -1)) {
                    if (b.f().b().getClass().getName().equalsIgnoreCase(d.b.i0.r.a0.b.c())) {
                        this.f13379a.putExtra(DealIntentService.KEY_CLASS, 5);
                    } else {
                        this.f13379a.putExtra(DealIntentService.KEY_CLASS, 21);
                    }
                } else if (10 == this.f13379a.getIntExtra(DealIntentService.KEY_CLASS, -1)) {
                    this.f13379a.putExtra(DealIntentService.KEY_CLASS, 12);
                }
                return DealIntentService.ACTION_ON_POST_EXSIT;
            }
            if (i == 27) {
                TiebaStatic.eventStat(DealIntentService.this, "open_push", IntentConfig.START, 1, new Object[0]);
            }
            if (this.f13379a.getExtras().getBoolean("is_notify", false)) {
                b(i);
            }
            return DealIntentService.ACTION_ON_POST_START;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            if (str != null) {
                if (!str.equals(DealIntentService.ACTION_ON_POST_EXSIT)) {
                    if (str.equals(DealIntentService.ACTION_ON_POST_START)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(DealIntentService.this, this.f13379a)));
                    }
                } else {
                    this.f13379a.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    CustomMessage customMessage = new CustomMessage(2012000);
                    customMessage.setData(this.f13379a);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
            }
            DealIntentService.this.stopSelf();
        }
    }

    private void doDeal(Intent intent) {
        a aVar = this.mDealAsyncTask;
        if (aVar != null) {
            aVar.cancel();
            this.mDealAsyncTask = null;
        }
        a aVar2 = new a(intent);
        this.mDealAsyncTask = aVar2;
        aVar2.setPriority(4);
        this.mDealAsyncTask.execute(new String[0]);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent == null) {
            return;
        }
        doDeal(intent);
    }
}
