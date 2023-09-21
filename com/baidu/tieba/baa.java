package com.baidu.tieba;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.ScreenLockSyncSwitch;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.ol8;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes5.dex */
public class baa {
    public static /* synthetic */ Interceptable $ic;
    public static baa m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<eaa> b;
    public eaa c;
    public final wsa d;
    public int e;
    public int f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }

        public a(baa baaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ baa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(baa baaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar, Integer.valueOf(i)};
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
            this.a = baaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                this.a.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ baa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(baa baaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar, Integer.valueOf(i)};
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
            this.a = baaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                this.a.r(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ baa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(baa baaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar, Integer.valueOf(i)};
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
            this.a = baaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ baa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(baa baaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar, Integer.valueOf(i)};
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
            this.a = baaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage instanceof RemindRecommendMessage) || !baa.n()) {
                return;
            }
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours >= 0 && hours <= 7) || hours >= 23) {
                return;
            }
            RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
            if (this.a.d.c()) {
                this.a.p(remindRecommendMessage);
            } else {
                this.a.o(remindRecommendMessage);
            }
            if (remindRecommendMessage.isLocal) {
                TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 2).param("obj_locate", 1));
            } else {
                TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 1).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ baa b;

        public f(baa baaVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baaVar;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (!bool.booleanValue() && this.a) {
                    this.b.u();
                    return null;
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ baa a;

        public g(baa baaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public baa() {
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
        this.b = new LinkedList();
        this.c = null;
        this.h = new a(this);
        this.i = new b(this, 0);
        this.j = new c(this, 0);
        this.k = new d(this, 2005016);
        this.l = new e(this, 2001355);
        this.a = TbadkApplication.getInst().getApp();
        MessageManager.getInstance().registerListener(2016004, this.i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012121, this.j);
        MessageManager.getInstance().registerListener(2012123, this.j);
        MessageManager.getInstance().registerListener(this.l);
        this.f = 0;
        this.d = new wsa();
    }

    public void u() {
        eaa eaaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<eaa> list = this.b;
            if ((list != null && list.size() != 0) || this.c != null) {
                if (!this.d.c() || this.f == 1) {
                    Activity currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        currentActivity.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                    this.h.postDelayed(new g(this), 1000L);
                    List<eaa> list2 = this.b;
                    if (list2 != null && list2.size() > 0 && (eaaVar = this.b.get(0)) != null) {
                        TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", eaaVar.m / 100).param("task_id", eaaVar.s));
                    }
                }
            }
        }
    }

    public static baa j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new baa();
            }
            return m;
        }
        return (baa) invokeV.objValue;
    }

    public eaa l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (eaa) invokeV.objValue;
    }

    public List<eaa> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.b);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.clear();
            this.c = null;
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TbadkSettings.getInst().loadInt(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_server_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (xe5.d().i() && xe5.d().z() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(eaa eaaVar) {
        List<eaa> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, eaaVar) != null) || (list = this.b) == null) {
            return;
        }
        list.add(eaaVar);
    }

    public void h(eaa eaaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, eaaVar) != null) || eaaVar == null) {
            return;
        }
        this.b.remove(eaaVar);
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            return matcher.group(1);
        }
        return (String) invokeL.objValue;
    }

    public void q(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            h(e(data));
        }
    }

    public boolean d(ChatMessage chatMessage) {
        InterceptResult invokeL;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (msgType = chatMessage.getMsgType()) != 6 && msgType != 22 && msgType != 23) {
                switch (msgType) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        if (!StringUtils.isNull(chatMessage.getContent()) && !StringUtils.isNull(chatMessage.getUserInfo().getUserName()) && !chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkCoreApplication.getCurrentAccountName())) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public eaa e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            eaa eaaVar = new eaa();
            if (imMessageCenterPojo == null) {
                return eaaVar;
            }
            eaaVar.i = imMessageCenterPojo.getUnread_count();
            eaaVar.j = imMessageCenterPojo.getGid();
            eaaVar.h = imMessageCenterPojo.getCustomGroupType();
            eaaVar.a = imMessageCenterPojo.getGroup_name();
            eaaVar.b = imMessageCenterPojo.getLast_user_name();
            eaaVar.c = imMessageCenterPojo.getNameShow();
            eaaVar.l = imMessageCenterPojo.getLast_content_time();
            eaaVar.e = imMessageCenterPojo.getLast_content();
            eaaVar.s = JavaTypesHelper.toLong(imMessageCenterPojo.getTaskId(), 0L);
            return eaaVar;
        }
        return (eaa) invokeL.objValue;
    }

    public eaa f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        ol8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            eaa eaaVar = new eaa();
            eaaVar.i = 0;
            chatMessage.getMsgType();
            eaaVar.h = i;
            eaaVar.b = chatMessage.getUserInfo().getUserName();
            eaaVar.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            eaaVar.m = chatMessage.getMsgId();
            boolean z = true;
            eaaVar.n = true;
            eaaVar.o = true;
            eaaVar.p = 1;
            eaaVar.s = chatMessage.getStatTaskId();
            eaaVar.t = chatMessage.getStatisticsServiceId();
            int i2 = eaaVar.h;
            if (i2 == 2) {
                eaaVar.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo h = kl8.n().h(eaaVar.j, 2);
                if (h != null) {
                    eaaVar.i = h.getUnread_count();
                    eaaVar.l = h.getLast_content_time();
                    if (h.getIsFriend() != 1) {
                        z = false;
                    }
                    eaaVar.o = z;
                    eaaVar.p = h.getFollowStatus();
                }
                eaaVar.a = chatMessage.getUserInfo().getUserName();
                eaaVar.e = bp8.F(chatMessage.getMsgType(), chatMessage.getContent());
                if (eaaVar.o) {
                    if (!xe5.d().w()) {
                        eaaVar.n = false;
                    } else {
                        eaaVar.n = lm8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), eaaVar.j);
                    }
                } else if (!xe5.d().w()) {
                    eaaVar.n = false;
                } else if (!xe5.d().G()) {
                    eaaVar.n = false;
                } else {
                    eaaVar.n = lm8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), eaaVar.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                eaaVar.j = userId;
                if (!"1501754229".equals(userId) && !"2807977073".equals(eaaVar.j)) {
                    return null;
                }
                ImMessageCenterPojo h2 = kl8.n().h(eaaVar.j, 4);
                if (h2 != null) {
                    eaaVar.i = h2.getUnread_count();
                    eaaVar.l = h2.getLast_content_time();
                    if (h2.getIsFriend() != 1) {
                        z = false;
                    }
                    eaaVar.o = z;
                    eaaVar.p = h2.getFollowStatus();
                }
                eaaVar.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<ol8.a> a2 = ol8.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        eaaVar.d = aVar.a;
                        eaaVar.e = aVar.b;
                        eaaVar.f = aVar.c;
                        eaaVar.q = aVar.d;
                        eaaVar.s = aVar.k;
                        eaaVar.t = aVar.l;
                    }
                } else {
                    eaaVar.e = bp8.F(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!xe5.d().o()) {
                    eaaVar.n = false;
                }
            }
            return eaaVar;
        }
        return (eaa) invokeLI.objValue;
    }

    public final Intent k(Context context, c35 c35Var, String str) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, c35Var, str)) == null) {
            if (context == null || c35Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            if (!str.startsWith(TbConfig.HTTP_PB_PREFIX) && !str.startsWith(TbConfig.HTTPS_PB_PREFIX)) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    String substring = str.substring(str.lastIndexOf(":") + 1);
                    intent.putExtra("class", 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra("class", 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra("class", 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra("class", 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith(NativeConstants.COMPONENT_VOTE)) {
                    intent.putExtra("class", 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra("class", 31);
                    String substring2 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring2.startsWith("pid=")) {
                        str2 = substring2.substring(substring2.lastIndexOf("pid=") + 4);
                    } else if (substring2.startsWith("http://")) {
                        str2 = substring2.substring(substring2.lastIndexOf("p/") + 2);
                    } else {
                        str2 = "";
                    }
                    if (StringUtils.isNull(str2)) {
                        return null;
                    }
                    intent.putExtra("tid", str2);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    return null;
                } else {
                    intent.putExtra("class", 0);
                    intent.putExtra("url", str);
                }
            } else {
                String substring3 = str.substring(str.lastIndexOf("/") + 1);
                intent.putExtra("class", 1);
                intent.putExtra("key_start_from", 7);
                intent.putExtra("id", substring3);
            }
            intent.putExtra("is_notify", true);
            intent.putExtra("link", str);
            intent.putExtra("message_id", c35Var.c());
            intent.putExtra("task_id", c35Var.e());
            if (!TextUtils.isEmpty(c35Var.d())) {
                intent.putExtra("stat", c35Var.d());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, remindRecommendMessage) != null) || remindRecommendMessage == null) {
            return;
        }
        eaa eaaVar = new eaa();
        eaaVar.i = 0;
        eaaVar.j = "-1";
        eaaVar.h = 4;
        String str = remindRecommendMessage.name;
        eaaVar.a = str;
        eaaVar.b = str;
        eaaVar.d = remindRecommendMessage.title;
        eaaVar.f = remindRecommendMessage.picture;
        eaaVar.q = remindRecommendMessage.url;
        eaaVar.l = System.currentTimeMillis();
        eaaVar.n = true;
        eaaVar.o = true;
        eaaVar.p = 1;
        eaaVar.s = 0L;
        if (remindRecommendMessage.isLocal) {
            eaaVar.r = "2";
        } else {
            eaaVar.r = "1";
        }
        c(eaaVar);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) && remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent k = k(this.a, new c35(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
            if (k == null) {
                return;
            }
            PendingIntent service = PendingIntent.getService(this.a, 0, k, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            Context context = this.a;
            String str2 = remindRecommendMessage.name;
            String str3 = remindRecommendMessage.title;
            NotificationHelper.showNotification(context, 2000, str2, str3, str3, service, false);
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    public List<ChatMessage> r(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) {
            if (!(responsedMessage instanceof GroupMsgData)) {
                return null;
            }
            GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
            int customType = groupMsgData.getGroupInfo().getCustomType();
            if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(groupMsgData.getListMessage());
            v(linkedList, customType);
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean t(ChatMessage chatMessage, eaa eaaVar) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, eaaVar)) == null) {
            if (eaaVar != null && !StringUtils.isNull(eaaVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(eaaVar.q))) != null && JavaTypesHelper.toInt(paramPair.get("lockWindow"), 0) == 1) {
                long j = eaaVar.s;
                String i = i(eaaVar.q);
                if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.d.c()) {
                    Activity currentActivity = BdActivityStack.getInst().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                        currentActivity.finish();
                    }
                    chatMessage.setHasRead(true);
                    NotificationHelper.cancelNotification(this.a, 19);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.a, j, i)));
                }
                TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void v(List<ChatMessage> list, int i) {
        eaa f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, list, i) == null) && list != null && !list.isEmpty()) {
            boolean z = false;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && d(chatMessage) && (f2 = f(chatMessage, i)) != null && f2.i > 0) {
                    if (!f2.n) {
                        h(f2);
                    } else {
                        if (i == 4) {
                            if (t(chatMessage, f2)) {
                                return;
                            }
                            c(f2);
                        } else {
                            this.c = f2;
                        }
                        arrayList.add(String.valueOf(chatMessage.getUserId()));
                        z = true;
                    }
                }
            }
            qp5.a.a().b(arrayList, new f(this, z));
        }
    }
}
