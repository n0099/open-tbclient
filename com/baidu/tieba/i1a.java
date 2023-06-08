package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.clientConfig.ClientConfigModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.tblauncher.alarmRemind.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes6.dex */
public class i1a {
    public static /* synthetic */ Interceptable $ic;
    public static i1a g;
    public transient /* synthetic */ FieldHolder $fh;
    public ClientConfigModel a;
    public d b;
    public boolean c;
    public final zz4 d;
    public CustomMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes6.dex */
    public class a implements zz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i1a a;

        public a(i1a i1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i1aVar;
        }

        @Override // com.baidu.tieba.zz4
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.a.c = false;
        }

        @Override // com.baidu.tieba.zz4
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.c = false;
                if (obj != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    if (dataRes.local_dialog != null) {
                        String g = h1a.g(dataRes);
                        if (TextUtils.isEmpty(g)) {
                            return;
                        }
                        TbadkSettings.getInst().saveString(this.a.h("remind_recommend_info"), g);
                        TbadkSettings.getInst().saveInt(this.a.h("remind_recommend_server_switch"), dataRes.local_dialog.show.intValue());
                        TbadkSettings.getInst().saveString(this.a.h("remind_recommend_dialog_time"), dataRes.local_dialog.time);
                        this.a.k(true);
                        TbadkSettings.getInst().saveLong(this.a.h("remind_recommend_data_time"), System.currentTimeMillis());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i1a i1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError() || !BdNetTypeUtil.isNetWorkAvailable() || !this.a.f()) {
                return;
            }
            this.a.g();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i1a i1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.f()) {
                this.a.k(true);
                this.a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i1a i1aVar) {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && !data.booleanValue()) {
                n95.m().A("tieba_last_active_time", System.currentTimeMillis());
                if (this.a.f()) {
                    this.a.k(true);
                    this.a.g();
                }
            }
        }
    }

    public i1a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = new a(this);
        this.e = new b(this, 2000994);
        this.f = new c(this, 2005016);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!h1a.f(TbadkSettings.getInst().loadLong(h("remind_recommend_data_time"), 0L)) && !TbadkCoreApplication.getInst().checkInterrupt()) {
                j();
            }
        }
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + str;
        }
        return (String) invokeL.objValue;
    }

    public static i1a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (g == null) {
                synchronized (i1a.class) {
                    if (g == null) {
                        g = new i1a();
                    }
                }
            }
            return g;
        }
        return (i1a) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                k(false);
                return false;
            } else if (!h1a.e()) {
                k(false);
                return false;
            } else if (!h1a.d()) {
                k(false);
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        ClientConfigModel clientConfigModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (clientConfigModel = this.a) != null && !this.c) {
            this.c = true;
            clientConfigModel.Z("local_dialog");
        }
    }

    public void e(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseFragmentActivity) == null) {
            d dVar = new d(this);
            this.b = dVar;
            baseFragmentActivity.registerListener(dVar);
            baseFragmentActivity.registerListener(this.e);
            baseFragmentActivity.registerListener(this.f);
            this.a = new ClientConfigModel(baseFragmentActivity, this.d);
            n95.m().A("tieba_last_active_time", System.currentTimeMillis());
            if (f()) {
                k(true);
                g();
            }
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            AlarmManager alarmManager = (AlarmManager) TbadkCoreApplication.getInst().getApp().getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(TbadkCoreApplication.getInst().getApp(), 0, new Intent(TbadkCoreApplication.getInst().getApp(), AlarmReceiver.class), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            try {
                if (z) {
                    alarmManager.setRepeating(0, h1a.b() + 86400000, 86400000L, broadcast);
                } else {
                    alarmManager.cancel(broadcast);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
