package com.baidu.tbadk.coreExtra.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ou4;
import com.baidu.tieba.qi;
import com.baidu.tieba.z8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DealIntentService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public a mDealAsyncTask;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Intent a;
        public final /* synthetic */ DealIntentService b;

        public a(DealIntentService dealIntentService, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dealIntentService, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dealIntentService;
            this.a = null;
            this.a = intent;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i == 6) {
                    TiebaStatic.eventStat(this.b, "notify_to_pk_before", "click");
                } else if (i == 7) {
                    TiebaStatic.eventStat(this.b, "notify_to_pk_end", "click");
                } else if (i == 8) {
                    TiebaStatic.eventStat(this.b, "notify_to_vote_list", "click");
                } else if (i != 14) {
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.NOTIFY_GROUP_EVENT_CLICK);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                super.onPreExecute();
                Intent intent = this.a;
                if (intent == null) {
                    return;
                }
                Bundle extras = intent.getExtras();
                String string = extras != null ? extras.getString("privateGid") : null;
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2012110, string));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
                Intent intent = this.a;
                if (intent == null || intent.getExtras() == null) {
                    return null;
                }
                int i = this.a.getExtras().getInt(DealIntentService.KEY_CLASS, -1);
                String stringExtra = this.a.getStringExtra("link");
                long j = this.a.getExtras().getLong("task_id");
                long j2 = this.a.getExtras().getLong("service_id");
                String stringExtra2 = this.a.getStringExtra("task_id");
                if (!qi.isEmpty(stringExtra2) && j == 0) {
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
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("service_id", j2).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, stringExtra).param("task_id", j).param("app_version", TbConfig.getVersion()).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1);
                int i2 = this.a.getExtras().getInt("is_live", -1);
                int i3 = this.a.getExtras().getInt("is_live_lcs", -1);
                if (i2 >= 0) {
                    param.param("is_live", i2);
                }
                if (i3 >= 0) {
                    param.param("is_live_lcs", i3);
                }
                int i4 = this.a.getExtras().getInt("KeyOfNotiId", -1);
                int i5 = (i4 == 16 || i4 == 17) ? 3 : i4 != 19 ? i4 != 29 ? i4 != 24 ? i4 != 25 ? 0 : 12 : 10 : 11 : 2;
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("HotThreadList")) {
                    i5 = 6;
                } else if ((!TextUtils.isEmpty(stringExtra) && stringExtra.contains("HotInteraction")) || (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("frs?kw="))) {
                    i5 = 7;
                } else if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("type=question_answer_invite")) {
                    i5 = 15;
                }
                param.param("obj_source", i5);
                TiebaStatic.log(param);
                if (this.a.getExtras().getBoolean("is_notify", false)) {
                    c(i);
                }
                String string = this.a.getExtras().getString("stat");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(stringExtra)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "cl_push_noti:" + string, "taskId:" + j + ";link:" + stringExtra + ";uid:" + TbadkCoreApplication.getCurrentAccount());
                }
                if (z8.g().b() != null) {
                    if (5 == this.a.getIntExtra(DealIntentService.KEY_CLASS, -1)) {
                        if (z8.g().b().getClass().getName().equalsIgnoreCase(ou4.c())) {
                            this.a.putExtra(DealIntentService.KEY_CLASS, 5);
                        } else {
                            this.a.putExtra(DealIntentService.KEY_CLASS, 21);
                        }
                    } else if (10 == this.a.getIntExtra(DealIntentService.KEY_CLASS, -1)) {
                        this.a.putExtra(DealIntentService.KEY_CLASS, 12);
                    }
                    return DealIntentService.ACTION_ON_POST_EXSIT;
                }
                if (i == 27) {
                    TiebaStatic.eventStat(this.b, "open_push", "start", 1, new Object[0]);
                }
                if (this.a.getExtras().getBoolean("is_notify", false)) {
                    b(i);
                }
                return DealIntentService.ACTION_ON_POST_START;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                if (str != null) {
                    if (!str.equals(DealIntentService.ACTION_ON_POST_EXSIT)) {
                        if (str.equals(DealIntentService.ACTION_ON_POST_START)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this.b, this.a)));
                        }
                    } else {
                        this.a.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        CustomMessage customMessage = new CustomMessage(2012000);
                        customMessage.setData(this.a);
                        MessageManager.getInstance().sendMessage(customMessage);
                    }
                }
                this.b.stopSelf();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(227709001, "Lcom/baidu/tbadk/coreExtra/service/DealIntentService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(227709001, "Lcom/baidu/tbadk/coreExtra/service/DealIntentService;");
        }
    }

    public DealIntentService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDealAsyncTask = null;
    }

    private void doDeal(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            a aVar = this.mDealAsyncTask;
            if (aVar != null) {
                aVar.cancel();
                this.mDealAsyncTask = null;
            }
            a aVar2 = new a(this, intent);
            this.mDealAsyncTask = aVar2;
            aVar2.setPriority(4);
            this.mDealAsyncTask.execute(new String[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, intent, i) == null) {
            super.onStart(intent, i);
            if (intent == null) {
                return;
            }
            doDeal(intent);
        }
    }
}
