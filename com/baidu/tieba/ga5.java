package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.DealIntentActivity;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ChatSysNotifyPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.pa5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
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
/* loaded from: classes6.dex */
public class ga5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String v;
    public static ga5 w;
    public static Date x;
    public static Handler y;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public int b;
    public String c;
    public int d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public int j;
    public String k;
    public int l;
    public int m;
    public pa5 n;
    public pa5 o;
    public boolean p;
    public final List<ChatSysNotifyPojo> q;
    public String r;
    public String s;
    public String t;
    public String u;

    public int D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 12 || i == 13 || i == 28) {
                return 2;
            }
            if (i != 29) {
                if (i != 2000) {
                    switch (i) {
                        case 15:
                        case 18:
                        case 19:
                            return 2;
                        case 16:
                        case 17:
                            return 1;
                        default:
                            switch (i) {
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                    return 3;
                                default:
                                    return 0;
                            }
                    }
                }
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public final void W(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, newsNotifyMessage) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                ga5.p0().Y(ga5.p0().C());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947787214, "Lcom/baidu/tieba/ga5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947787214, "Lcom/baidu/tieba/ga5;");
                return;
            }
        }
        v = TbadkApplication.getInst().getString(R.string.not_received_new_msg);
        x = null;
        y = new a();
    }

    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (x == null) {
                x = new Date();
                return true;
            }
            Date date = new Date();
            if (date.getTime() - x.getTime() < 10000) {
                return false;
            }
            x = date;
            return true;
        }
        return invokeV.booleanValue;
    }

    public Intent N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra("class", 14);
            intent.putExtra("group_msg_updates", this.n.o());
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 19);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 18);
            NotificationHelper.cancelNotification(this.a, 30);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 16);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return ((((this.n.w() + this.n.j()) + this.n.y()) + this.n.t()) + this.n.s()) - this.n.l();
        }
        return invokeV.intValue;
    }

    public ga5() {
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
        this.b = 0;
        this.d = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.l = 0;
        this.m = 0;
        this.n = new pa5();
        this.p = true;
        this.q = new ArrayList();
        this.a = TbadkCoreApplication.getInst().getApp();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
            NotificationHelper.cancelNotification(this.a, 24);
            NotificationHelper.cancelNotification(this.a, 25);
            NotificationHelper.cancelNotification(this.a, 29);
            NotificationHelper.cancelNotification(this.a, 26);
            NotificationHelper.cancelNotification(this.a, 17);
            NotificationHelper.cancelNotification(this.a, 15);
            NotificationHelper.cancelNotification(this.a, 13);
            NotificationHelper.cancelNotification(this.a, 12);
        }
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!ia5.e().F()) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            int i = (calendar.get(11) * 60) + calendar.get(12);
            String[] split = ia5.e().i().split(":");
            int parseInt = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            String[] split2 = ia5.e().h().split(":");
            int parseInt2 = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
            if (parseInt < parseInt2) {
                if (i < parseInt || i > parseInt2) {
                    return false;
                }
            } else if (parseInt <= parseInt2) {
                return false;
            } else {
                if ((i < parseInt || i > 1439) && (i < 0 || i > parseInt2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
            newsNotifyMessage.setChatSysNotitys(t());
            newsNotifyMessage.setMsgAgree(u());
            newsNotifyMessage.setMsgAtme(v());
            newsNotifyMessage.setMsgBookmark(w());
            newsNotifyMessage.setMsgChat(s());
            newsNotifyMessage.setMsgFans(y());
            newsNotifyMessage.setMsgReplyme(B());
            newsNotifyMessage.setMsgGiftNum(z());
            newsNotifyMessage.setMsgInvitation(A());
            newsNotifyMessage.setMsgPrivateChat(this.n.w());
            newsNotifyMessage.setMsgStrangerChat(this.n.y());
            newsNotifyMessage.setMsgOfficialMerge(this.n.t());
            W(newsNotifyMessage);
            MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
        }
    }

    public static boolean P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!"3222425470".equals(str) && !"801001117".equals(str) && !"5044059141".equals(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public final String E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ChatSysNotifyPojo f = zt8.b().f(i);
            if (f != null) {
                return f.getContent();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final int F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ChatSysNotifyPojo f = zt8.b().f(i);
            if (f != null) {
                return f.getUnread();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                X(0, 0, 0, 0, 0, 0, 0);
                return;
            }
            this.b = 0;
            this.d = 0;
            this.f = 0;
            this.h = 0;
            this.j = 0;
            this.i = 0;
            this.m = 0;
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, str) == null) && !StringUtils.isNull(str)) {
            this.c = str;
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && !StringUtils.isNull(str)) {
            this.g = str;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && !StringUtils.isNull(str)) {
            this.k = str;
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && i >= 0) {
            X(i, this.d, this.f, this.h, this.j, this.i, this.l);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && i >= 0) {
            X(this.b, this.d, i, this.h, this.j, this.i, this.l);
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && i >= 0) {
            X(this.b, this.d, this.f, this.h, this.j, i, this.l);
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && i >= 0) {
            X(this.b, this.d, this.f, i, this.j, this.i, this.l);
        }
    }

    public void j0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i) == null) && i >= 0) {
            X(this.b, this.d, this.f, this.h, i, this.i, this.l);
        }
    }

    public void k0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && i >= 0) {
            this.l = i;
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && i >= 0) {
            this.m = i;
        }
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048624, this, i) == null) && i >= 0) {
            X(this.b, i, this.f, this.h, this.j, this.i, this.l);
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, str) == null) && !StringUtils.isNull(str)) {
            this.e = str;
        }
    }

    public void o0(pa5 pa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, pa5Var) == null) {
            this.n = pa5Var;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            NotificationHelper.cancelNotification(this.a, i);
        }
    }

    public static ga5 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (w == null) {
                w = new ga5();
            }
            return w;
        }
        return (ga5) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("msg_tab_entrance_invitation_answer_unread_num"), 0);
            this.m = i;
            return i;
        }
        return invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public pa5 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return (pa5) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b + this.d + this.f + this.h + this.j + this.l;
        }
        return invokeV.intValue;
    }

    public pa5 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (pa5) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.k = null;
            this.g = null;
            this.e = null;
            this.c = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            NotificationHelper.cancelNotification(this.a, 16);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            NotificationHelper.cancelNotification(this.a, 17);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            NotificationHelper.cancelNotification(this.a, 29);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            NotificationHelper.cancelNotification(this.a, 25);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            NotificationHelper.cancelNotification(this.a, 26);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            NotificationHelper.cancelNotification(this.a, 23);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            NotificationHelper.cancelNotification(this.a, 24);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            NotificationHelper.cancelNotification(this.a, 19);
        }
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return ChatStatusManager.getInst().getIsOpen(6);
        }
        return invokeV.booleanValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return ChatStatusManager.getInst().getIsOpen(7);
        }
        return invokeV.booleanValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent I(int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                Set<String> keySet = this.n.h().keySet();
                if (keySet.iterator().hasNext()) {
                    str = keySet.iterator().next();
                    Intent intent = new Intent();
                    if (!UtilHelper.isFlyMeOs()) {
                        intent.setClass(this.a, DealIntentActivity.class);
                    } else {
                        intent.setClass(this.a, DealIntentService.class);
                    }
                    intent.putExtra("class", 5);
                    intent.putExtra("KeyOfNotiId", i);
                    intent.putExtra("agree_me", this.b);
                    intent.putExtra("at_me", this.f);
                    intent.putExtra("reply_me", this.d);
                    intent.putExtra("fans", this.j);
                    intent.putExtra("chat", x());
                    intent.putExtra("group_msg", this.n.j() - this.n.l());
                    intent.putExtra("group_msg_validate", this.n.q());
                    intent.putExtra("group_msg_updates", this.n.n());
                    intent.putExtra("officialbar_msg", this.n.u());
                    intent.putExtra("privateGid", str);
                    intent.putExtra("replyme_jump_scheme", this.t);
                    return intent;
                }
            }
            str = "";
            Intent intent2 = new Intent();
            if (!UtilHelper.isFlyMeOs()) {
            }
            intent2.putExtra("class", 5);
            intent2.putExtra("KeyOfNotiId", i);
            intent2.putExtra("agree_me", this.b);
            intent2.putExtra("at_me", this.f);
            intent2.putExtra("reply_me", this.d);
            intent2.putExtra("fans", this.j);
            intent2.putExtra("chat", x());
            intent2.putExtra("group_msg", this.n.j() - this.n.l());
            intent2.putExtra("group_msg_validate", this.n.q());
            intent2.putExtra("group_msg_updates", this.n.n());
            intent2.putExtra("officialbar_msg", this.n.u());
            intent2.putExtra("privateGid", str);
            intent2.putExtra("replyme_jump_scheme", this.t);
            return intent2;
        }
        return (Intent) invokeCommon.objValue;
    }

    public Intent J(pa5.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra("class", 36);
            intent.putExtra("tab_id", -1);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            pa5 H = H();
            if (H == null) {
                c();
                return;
            }
            HashMap<String, String> a2 = H.a();
            if (a2 != null && !a2.isEmpty()) {
                if (a2.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            pa5 H = H();
            if (H == null) {
                e();
            } else if (1 == i) {
                if (H.n() <= 0) {
                    e();
                }
            } else if (2 == i && H.q() <= 0) {
                e();
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c();
                return;
            }
            pa5 H = H();
            if (H == null) {
                c();
                return;
            }
            HashMap<String, String> h = H.h();
            if (h != null && !h.isEmpty()) {
                if (h.containsKey(str)) {
                    c();
                    return;
                }
                return;
            }
            c();
        }
    }

    public Intent K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra("class", 24);
            intent.putExtra("KeyOfNotiId", i);
            intent.putExtra("gift_num", this.l);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(currentAccountName)) {
                intent.putExtra("un", currentAccount);
                intent.putExtra("name", currentAccountName);
            }
            return intent;
        }
        return (Intent) invokeI.objValue;
    }

    public Intent L(pa5.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
            }
            intent.putExtra("class", 27);
            intent.putExtra("uid", aVar.a);
            intent.putExtra("uname", aVar.e);
            intent.putExtra("user_type", aVar.f);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Intent M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            Intent intent = new Intent();
            if (UtilHelper.isFlyMeOs()) {
                intent.setClass(this.a, DealIntentActivity.class);
            } else {
                intent.setClass(this.a, DealIntentService.class);
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
        return (Intent) invokeI.objValue;
    }

    public final boolean Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (O()) {
                return false;
            }
            if (i == 24) {
                return ia5.e().B();
            }
            if (i == 29) {
                return ia5.e().E();
            }
            if (i == 26) {
                return ia5.e().z();
            }
            if (i == 25) {
                return ia5.e().w();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void s0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, jSONObject) == null) && jSONObject != null) {
            int optInt = jSONObject.optInt("replyme");
            int optInt2 = jSONObject.optInt("agree");
            JSONObject optJSONObject = jSONObject.optJSONObject("absmsg");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("replyme");
                String optString2 = optJSONObject.optString("replyme_jump_scheme");
                String optString3 = optJSONObject.optString("atme");
                String optString4 = optJSONObject.optString("agree");
                if (!StringUtils.isNull(optString) && optInt > 0) {
                    this.s = optString;
                    this.t = optString2;
                }
                if (!StringUtils.isNull(optString4) && optInt2 > 0) {
                    this.r = optString4;
                }
                if (!StringUtils.isNull(optString3)) {
                    this.u = optString3;
                }
            }
        }
    }

    public final void R(pa5.a aVar, int i) {
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048591, this, aVar, i) != null) || O()) {
            return;
        }
        Intent V = V(aVar);
        if (V != null && V.getDataString() != null && V.getDataString().contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            V.setFlags(276824064);
            NotificationHelper.showNotification(this.a, i, aVar.b, aVar.c, aVar.d, PendingIntent.getActivity(this.a, i, V, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), false);
            return;
        }
        if (V == null) {
            V = L(aVar);
        }
        if (V == null) {
            V = J(aVar);
        }
        if (V == null) {
            return;
        }
        if (UtilHelper.isFlyMeOs()) {
            service = PendingIntent.getActivity(this.a, i, V, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        } else {
            service = PendingIntent.getService(this.a, i, V, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        }
        i(D(i), i);
        NotificationHelper.showNotification(this.a, i, aVar.b, aVar.c, aVar.d, service, false);
    }

    public final void S(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            T(i, str, str2, str3, false);
        }
    }

    public final void T(int i, String str, String str2, String str3, boolean z) {
        Intent I;
        PendingIntent service;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, str2, str3, Boolean.valueOf(z)}) != null) || !this.p || !Q(i)) {
            return;
        }
        if (i == 23 && this.l > 0) {
            I = K(i);
        } else if (i == 26 && this.j > 0) {
            I = M(i);
        } else if (i == 18) {
            I = N();
        } else if (i == 24) {
            I = I(i, z);
            I.putExtra("tab_id", -1);
            WriteImageActivityConfig.isActivityInStack = true;
        } else if (i != 16 && i != 17 && i != 18) {
            I = I(i, z);
            WriteImageActivityConfig.isActivityInStack = true;
        } else {
            I = I(i, z);
            I.putExtra("tab_id", -2);
            WriteImageActivityConfig.isActivityInStack = true;
        }
        I.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (UtilHelper.isFlyMeOs()) {
            service = PendingIntent.getActivity(this.a, i, I, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        } else {
            service = PendingIntent.getService(this.a, i, I, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
        }
        i(D(i), i);
        NotificationHelper.showNotification(this.a, i, str, str2, str3, service, false);
    }

    public Intent V(pa5.a aVar) {
        InterceptResult invokeL;
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, aVar)) == null) {
            if (aVar != null && (h = ew8.n().h(aVar.a, aVar.f)) != null && h.getLast_content() != null) {
                try {
                    String lastTaskId = h.getLastTaskId();
                    String lastServiceId = h.getLastServiceId();
                    JSONArray jSONArray = new JSONArray(h.getLastContentRawData());
                    if (jSONArray.length() != 1) {
                        return null;
                    }
                    String optString = ((JSONObject) jSONArray.get(0)).optString("url");
                    if (StringUtils.isNull(optString)) {
                        return null;
                    }
                    Matcher matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(optString);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (!StringUtils.isNull(group)) {
                            Intent intent = new Intent();
                            if (UtilHelper.isFlyMeOs()) {
                                intent.setClass(this.a, DealIntentActivity.class);
                            } else {
                                intent.setClass(this.a, DealIntentService.class);
                            }
                            intent.putExtra("class", 1);
                            intent.putExtra("id", group);
                            intent.putExtra("is_from_push", true);
                            intent.putExtra("key_start_from", 7);
                            intent.putExtra(TbEnum.ParamKey.GID, aVar.a);
                            intent.putExtra("task_id", lastTaskId);
                            intent.putExtra("service_id", lastServiceId);
                            return intent;
                        }
                    } else {
                        if (!optString.contains("mo/q/hotMessage") && !optString.contains("mo/q/newtopic")) {
                            if (optString.contains("open_wb_view=1")) {
                                Intent intent2 = new Intent();
                                if (UtilHelper.isFlyMeOs()) {
                                    intent2.setClass(this.a, DealIntentActivity.class);
                                } else {
                                    intent2.setClass(this.a, DealIntentService.class);
                                }
                                intent2.putExtra("class", 0);
                                intent2.putExtra("url", optString.trim());
                                intent2.putExtra("task_id", lastTaskId);
                                intent2.putExtra("service_id", lastServiceId);
                                return intent2;
                            } else if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                                return Intent.parseUri(optString, 1);
                            } else {
                                if (optString.contains(UrlSchemaHelper.SCHEMA_TYPE_SUB_PB)) {
                                    Intent intent3 = new Intent();
                                    if (UtilHelper.isFlyMeOs()) {
                                        intent3.setClass(this.a, DealIntentActivity.class);
                                    } else {
                                        intent3.setClass(this.a, DealIntentService.class);
                                    }
                                    intent3.putExtra("class", 39);
                                    String paramStr = UrlManager.getParamStr(optString);
                                    if (!TextUtils.isEmpty(paramStr)) {
                                        Map<String, String> paramPair = UrlManager.getParamPair(paramStr);
                                        if (!paramPair.isEmpty()) {
                                            String str = paramPair.get("tid");
                                            String str2 = paramPair.get("pid");
                                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                                intent3.putExtra("thread_id", str);
                                                intent3.putExtra("post_id", str2);
                                                return intent3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Intent intent4 = new Intent();
                        if (UtilHelper.isFlyMeOs()) {
                            intent4.setClass(this.a, DealIntentActivity.class);
                        } else {
                            intent4.setClass(this.a, DealIntentService.class);
                        }
                        intent4.putExtra("class", 30);
                        intent4.putExtra(BigdayActivityConfig.JUMP_URL, optString);
                        intent4.putExtra("task_id", lastTaskId);
                        intent4.putExtra("service_id", lastServiceId);
                        return intent4;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public void X(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (i == this.b && i2 == this.d && i3 == this.f && i4 == this.h && i5 == this.j && i6 == this.i && i7 == this.l) {
                return;
            }
            int i16 = this.b;
            int i17 = 2;
            if (i <= i16 && i2 <= (i14 = this.d) && i3 <= (i15 = this.f) && i4 <= this.h && i5 <= this.j && i6 <= this.i && i7 <= this.l) {
                if (i >= i16 && i2 >= i14 && i3 >= i15) {
                    i8 = 0;
                } else {
                    i8 = 2;
                }
            } else {
                i8 = 1;
            }
            int i18 = this.b;
            int i19 = this.d;
            if (i2 > i19) {
                i9 = 1;
            } else if (i2 < i19) {
                i9 = 2;
            } else {
                i9 = 0;
            }
            int i20 = this.f;
            if (i3 > i20) {
                i10 = 1;
            } else if (i3 < i20) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            if (i4 > this.h) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (i5 > this.j) {
                i12 = 1;
            } else {
                i12 = 0;
            }
            if (i7 > this.l) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            this.b = i;
            this.d = i2;
            this.f = i3;
            this.h = i4;
            this.j = i5;
            this.i = i6;
            this.l = i7;
            if (G() <= 0) {
                i8 = 2;
                i9 = 2;
                i10 = 2;
                i11 = 2;
                i12 = 2;
            } else {
                i17 = i13;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0) {
                a();
                q0(i17, 23);
                q0(i11, 16);
                q0(i8, 17);
                q0(i9, 24);
                q0(i10, 25);
                q0(i12, 26);
            }
        }
    }

    public void Y(pa5 pa5Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, pa5Var) != null) || pa5Var == null) {
            return;
        }
        this.n = pa5Var;
        this.h = (pa5Var.j() - pa5Var.l()) + pa5Var.w() + pa5Var.t() + pa5Var.s();
        b(pa5Var);
        int i = 0;
        if (pa5Var.z()) {
            this.o = null;
            y.removeMessages(0);
        }
        if (pa5Var.z()) {
            if (ia5.e().v() && ia5.e().g() > 0) {
                i = pa5Var.j() - pa5Var.l();
            }
            if (ia5.e().x() && ia5.e().g() > 0) {
                j = pa5Var.w();
            } else {
                j = 0;
            }
            if ((i > 0 || j > 0) && ((i > pa5Var.m() - pa5Var.l() && i > 0) || j > pa5Var.x())) {
                r0(1, 16, pa5Var);
            }
            int u = pa5Var.u();
            if (u > 0 && u > pa5Var.v()) {
                r0(1, 19, pa5Var);
            }
            if (pa5Var.n() > pa5Var.p() || pa5Var.q() > pa5Var.r()) {
                if (pa5Var.n() > pa5Var.p() && pa5Var.q() == pa5Var.r() && t0()) {
                    return;
                }
                if (pa5Var.n() == pa5Var.p() && pa5Var.q() > pa5Var.r() && u0()) {
                    return;
                }
                r0(1, 17, pa5Var);
            }
        }
    }

    public void Z(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (i == this.b && i2 == this.d && i3 == this.f && i4 == this.h && i5 == this.j && this.l == i6) {
                return;
            }
            this.b = i;
            this.d = i2;
            this.f = i3;
            this.h = i4;
            this.j = i5;
            this.l = i6;
            a();
            if (G() <= 0) {
                q0(2, 16);
                q0(2, 17);
            }
        }
    }

    public void b(pa5 pa5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, pa5Var) != null) || pa5Var == null) {
            return;
        }
        NewsNotifyMessage newsNotifyMessage = new NewsNotifyMessage();
        newsNotifyMessage.setChatSysNotitys(t());
        newsNotifyMessage.setMsgAgree(u());
        newsNotifyMessage.setMsgAtme(v());
        newsNotifyMessage.setMsgBookmark(w());
        newsNotifyMessage.setMsgChat(((((pa5Var.w() + pa5Var.j()) + pa5Var.y()) + pa5Var.t()) + pa5Var.s()) - pa5Var.l());
        newsNotifyMessage.setMsgFans(y());
        newsNotifyMessage.setMsgReplyme(B());
        newsNotifyMessage.setMsgGiftNum(z());
        newsNotifyMessage.setMsgInvitation(A());
        newsNotifyMessage.setMsgPrivateChat(pa5Var.w());
        newsNotifyMessage.setMsgStrangerChat(pa5Var.y());
        newsNotifyMessage.setMsgOfficialMerge(pa5Var.t());
        W(newsNotifyMessage);
        MessageManager.getInstance().dispatchResponsedMessageToUI(newsNotifyMessage);
    }

    public void i(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            if (1 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 16, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 17, i);
            } else if (2 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 12, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 13, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 15, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 18, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 19, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 28, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 2000, i);
            } else if (3 == j) {
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 29, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 23, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 24, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 25, i);
                NotificationHelper.cancelNotificationExceptSpecific(this.a, 26, i);
            }
        }
    }

    public final void q0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i, i2) == null) {
            try {
                if (i == 1) {
                    if (i2 == 23) {
                        if (this.l > 0) {
                            String format = String.format(this.a.getString(R.string.notify_gift), String.valueOf(this.l));
                            S(23, null, format, format);
                        }
                    } else if (i2 == 29) {
                        if (this.b > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(String.format(this.a.getString(R.string.notify_agree), Integer.valueOf(this.b)));
                            S(29, null, sb.toString(), sb.toString());
                        }
                    } else if (i2 == 24) {
                        if (this.d > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.d > 1) {
                                sb2.append(PreferencesUtil.LEFT_MOUNT);
                                sb2.append(String.valueOf(this.d));
                                sb2.append(this.a.getString(R.string.notify_unit));
                                sb2.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                            if (this.s != null) {
                                sb2.append(this.s);
                            } else {
                                sb2.append(this.a.getString(R.string.notify_reply));
                            }
                            S(24, null, sb2.toString(), sb2.toString());
                        }
                    } else if (i2 == 25) {
                        if (this.f > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.f > 1) {
                                sb3.append(PreferencesUtil.LEFT_MOUNT);
                                sb3.append(String.valueOf(this.f));
                                sb3.append(this.a.getString(R.string.notify_unit));
                                sb3.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                            if (this.u != null) {
                                sb3.append(this.u);
                            } else {
                                sb3.append(this.a.getString(R.string.notify_at));
                            }
                            S(25, null, sb3.toString(), sb3.toString());
                        }
                    } else if (i2 == 26) {
                        if (this.j > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(String.format(this.a.getString(R.string.notify_fans), Integer.valueOf(this.j)));
                            S(26, null, sb4.toString(), sb4.toString());
                        }
                    } else if (i2 != 16 && ia5.e().v()) {
                        ia5.e().g();
                    }
                } else if (i == 2) {
                    NotificationHelper.cancelNotification(this.a, 16);
                    NotificationHelper.cancelNotification(this.a, 17);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02fd A[Catch: Exception -> 0x0361, TryCatch #0 {Exception -> 0x0361, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x015c, B:60:0x0179, B:62:0x0183, B:64:0x018d, B:66:0x0198, B:68:0x01a2, B:70:0x01ac, B:76:0x01ba, B:78:0x01c5, B:80:0x01ed, B:82:0x01f7, B:85:0x0222, B:87:0x0228, B:89:0x0244, B:93:0x024d, B:84:0x0218, B:97:0x025a, B:99:0x0260, B:102:0x0267, B:103:0x026b, B:105:0x0271, B:107:0x0279, B:109:0x0281, B:112:0x028a, B:114:0x0290, B:116:0x0294, B:118:0x0299, B:120:0x02a3, B:122:0x02ad, B:124:0x02b8, B:126:0x02be, B:128:0x02c4, B:130:0x02d2, B:136:0x02f7, B:138:0x02fd, B:141:0x0305, B:145:0x0342, B:147:0x034f, B:142:0x0322, B:131:0x02ec, B:152:0x0366), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0342 A[Catch: Exception -> 0x0361, TryCatch #0 {Exception -> 0x0361, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x015c, B:60:0x0179, B:62:0x0183, B:64:0x018d, B:66:0x0198, B:68:0x01a2, B:70:0x01ac, B:76:0x01ba, B:78:0x01c5, B:80:0x01ed, B:82:0x01f7, B:85:0x0222, B:87:0x0228, B:89:0x0244, B:93:0x024d, B:84:0x0218, B:97:0x025a, B:99:0x0260, B:102:0x0267, B:103:0x026b, B:105:0x0271, B:107:0x0279, B:109:0x0281, B:112:0x028a, B:114:0x0290, B:116:0x0294, B:118:0x0299, B:120:0x02a3, B:122:0x02ad, B:124:0x02b8, B:126:0x02be, B:128:0x02c4, B:130:0x02d2, B:136:0x02f7, B:138:0x02fd, B:141:0x0305, B:145:0x0342, B:147:0x034f, B:142:0x0322, B:131:0x02ec, B:152:0x0366), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x034f A[Catch: Exception -> 0x0361, TryCatch #0 {Exception -> 0x0361, blocks: (B:8:0x000e, B:10:0x0019, B:12:0x001d, B:16:0x0044, B:18:0x0048, B:20:0x0051, B:21:0x0069, B:23:0x006d, B:25:0x007f, B:24:0x0073, B:28:0x0090, B:30:0x0094, B:32:0x009d, B:33:0x00b5, B:35:0x00b9, B:37:0x00cb, B:36:0x00bf, B:40:0x00dc, B:42:0x00e0, B:44:0x00e9, B:45:0x0101, B:47:0x0105, B:49:0x0117, B:48:0x010b, B:52:0x0128, B:54:0x012c, B:56:0x0135, B:57:0x015c, B:60:0x0179, B:62:0x0183, B:64:0x018d, B:66:0x0198, B:68:0x01a2, B:70:0x01ac, B:76:0x01ba, B:78:0x01c5, B:80:0x01ed, B:82:0x01f7, B:85:0x0222, B:87:0x0228, B:89:0x0244, B:93:0x024d, B:84:0x0218, B:97:0x025a, B:99:0x0260, B:102:0x0267, B:103:0x026b, B:105:0x0271, B:107:0x0279, B:109:0x0281, B:112:0x028a, B:114:0x0290, B:116:0x0294, B:118:0x0299, B:120:0x02a3, B:122:0x02ad, B:124:0x02b8, B:126:0x02be, B:128:0x02c4, B:130:0x02d2, B:136:0x02f7, B:138:0x02fd, B:141:0x0305, B:145:0x0342, B:147:0x034f, B:142:0x0322, B:131:0x02ec, B:152:0x0366), top: B:159:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r0(int i, int i2, pa5 pa5Var) {
        boolean z;
        boolean z2;
        int i3;
        long j;
        boolean z3;
        String e;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048633, this, i, i2, pa5Var) != null) || pa5Var == null) {
            return;
        }
        boolean z4 = true;
        try {
            if (i == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == 23) {
                    if (this.l > 0) {
                        String format = String.format(this.a.getString(R.string.notify_gift), String.valueOf(this.l));
                        S(23, null, format, format);
                    }
                } else if (i2 == 29) {
                    if (this.b > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (this.b > 1) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(String.valueOf(this.b));
                            sb.append(this.a.getString(R.string.notify_unit));
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.r != null) {
                            sb.append(this.r);
                        } else {
                            sb.append(this.a.getString(R.string.notify_agree));
                        }
                        S(29, null, sb.toString(), sb.toString());
                    }
                } else if (i2 == 24) {
                    if (this.d > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.d > 1) {
                            sb2.append(PreferencesUtil.LEFT_MOUNT);
                            sb2.append(String.valueOf(this.d));
                            sb2.append(this.a.getString(R.string.notify_unit));
                            sb2.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.s != null) {
                            sb2.append(this.s);
                        } else {
                            sb2.append(this.a.getString(R.string.notify_reply));
                        }
                        S(24, null, sb2.toString(), sb2.toString());
                    }
                } else if (i2 == 25) {
                    if (this.f > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        if (this.f > 1) {
                            sb3.append(PreferencesUtil.LEFT_MOUNT);
                            sb3.append(String.valueOf(this.f));
                            sb3.append(this.a.getString(R.string.notify_unit));
                            sb3.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                        if (this.u != null) {
                            sb3.append(this.u);
                        } else {
                            sb3.append(this.a.getString(R.string.notify_at));
                        }
                        S(25, null, sb3.toString(), sb3.toString());
                    }
                } else if (i2 == 26) {
                    if (this.j > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        if (this.j > 1) {
                            sb4.append(String.format(this.a.getString(R.string.notify_fans_unit), this.j + ""));
                        }
                        sb4.append(this.a.getString(R.string.notify_fans));
                        S(26, null, sb4.toString(), sb4.toString());
                    }
                } else if (i2 == 16) {
                    if (ia5.e().v() && ia5.e().g() > 0) {
                        i3 = pa5Var.j() - pa5Var.l();
                    } else {
                        i3 = 0;
                    }
                    if (ia5.e().x() && ia5.e().g() > 0) {
                        j = pa5Var.w();
                    } else {
                        j = 0;
                    }
                    if (j > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    long j2 = i3 + j;
                    int i4 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                    if (i4 > 0) {
                        stringBuffer.append(String.format(this.a.getString(R.string.notify_chat), Long.valueOf(j2)));
                        T(16, null, stringBuffer.toString(), stringBuffer.toString(), z3);
                    } else if (i4 == 0) {
                        pa5Var.i();
                        pa5Var.f();
                        if (j == 1) {
                            String i5 = pa5Var.i();
                            e = pa5Var.f();
                            str2 = i5 + "：" + e;
                            str = i5;
                        } else if (i3 == 1) {
                            String b = pa5Var.b();
                            e = pa5Var.e();
                            str = b;
                            str2 = e;
                        } else {
                            return;
                        }
                        if (TextUtils.isEmpty(e)) {
                            stringBuffer.append(String.format(this.a.getString(R.string.notify_chat), Long.valueOf(j2)));
                            str3 = stringBuffer.toString();
                        } else {
                            str3 = e;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str4 = str3;
                        } else {
                            str4 = str2;
                        }
                        T(16, str, str3, str4, z3);
                    }
                } else if (i2 == 19) {
                    List<pa5.a> g = pa5Var.g();
                    if (g != null && g.size() != 0) {
                        for (pa5.a aVar : g) {
                            if (aVar != null && !StringUtils.isNull(aVar.c) && !rd.isEmpty(aVar.a) && aVar.g > aVar.h && aVar.i == null) {
                                R(aVar, 19);
                            }
                        }
                    }
                } else if (ia5.e().v() && ia5.e().g() > 0 && pa5Var.n() + pa5Var.q() > 0) {
                    if (pa5Var.n() > 0 && !t0()) {
                        long n = pa5Var.n() - pa5Var.o();
                        if (n > 0) {
                            stringBuffer.append(String.format(this.a.getString(R.string.notify_updates), Long.valueOf(n)));
                            z = true;
                            z2 = false;
                            if (pa5Var.q() <= 0 && !u0()) {
                                if (!z) {
                                    stringBuffer.append(String.format(this.a.getString(R.string.notify_validate), Integer.valueOf(pa5Var.q())));
                                } else {
                                    stringBuffer.append(String.format(this.a.getString(R.string.notify_validate_1), Integer.valueOf(pa5Var.q())));
                                }
                            } else {
                                z4 = z;
                            }
                            if (z4) {
                                S(17, null, stringBuffer.toString(), stringBuffer.toString());
                            }
                            if (z2) {
                                S(18, pa5Var.d(), pa5Var.c(), pa5Var.c());
                                return;
                            }
                            return;
                        } else if (pa5Var.o() > 0) {
                            z = false;
                            z2 = true;
                            if (pa5Var.q() <= 0) {
                            }
                            z4 = z;
                            if (z4) {
                            }
                            if (z2) {
                            }
                        }
                    }
                    z = false;
                    z2 = false;
                    if (pa5Var.q() <= 0) {
                    }
                    z4 = z;
                    if (z4) {
                    }
                    if (z2) {
                    }
                }
            } else if (i == 2) {
                NotificationHelper.cancelNotification(this.a, 16);
                NotificationHelper.cancelNotification(this.a, 17);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @NonNull
    public List<ChatSysNotifyPojo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            this.q.clear();
            ChatSysNotifyPojo chatSysNotifyPojo = new ChatSysNotifyPojo();
            chatSysNotifyPojo.setType(1);
            chatSysNotifyPojo.setUnread(this.b);
            if (StringUtils.isNull(this.c)) {
                String E = E(1);
                if (StringUtils.isNull(E)) {
                    chatSysNotifyPojo.setContent(v);
                } else {
                    this.c = E;
                    chatSysNotifyPojo.setContent(E);
                }
                int F = F(1);
                this.b = F;
                chatSysNotifyPojo.setUnread(F);
            } else {
                chatSysNotifyPojo.setContent(this.c);
            }
            ChatSysNotifyPojo chatSysNotifyPojo2 = new ChatSysNotifyPojo();
            chatSysNotifyPojo2.setType(2);
            chatSysNotifyPojo2.setUnread(this.d);
            if (StringUtils.isNull(this.e)) {
                String E2 = E(2);
                if (StringUtils.isNull(E2)) {
                    chatSysNotifyPojo2.setContent(v);
                } else {
                    this.e = E2;
                    chatSysNotifyPojo2.setContent(E2);
                }
                int F2 = F(2);
                this.d = F2;
                chatSysNotifyPojo2.setUnread(F2);
            } else {
                chatSysNotifyPojo2.setContent(this.e);
            }
            ChatSysNotifyPojo chatSysNotifyPojo3 = new ChatSysNotifyPojo();
            chatSysNotifyPojo3.setType(4);
            chatSysNotifyPojo3.setUnread(this.j);
            if (StringUtils.isNull(this.k)) {
                String E3 = E(4);
                if (StringUtils.isNull(E3)) {
                    chatSysNotifyPojo3.setContent(v);
                } else {
                    this.k = E3;
                    chatSysNotifyPojo3.setContent(E3);
                }
                int F3 = F(4);
                this.j = F3;
                chatSysNotifyPojo3.setUnread(F3);
            } else {
                chatSysNotifyPojo3.setContent(this.k);
            }
            ChatSysNotifyPojo chatSysNotifyPojo4 = new ChatSysNotifyPojo();
            chatSysNotifyPojo4.setType(3);
            chatSysNotifyPojo4.setUnread(this.f);
            if (StringUtils.isNull(this.g)) {
                String E4 = E(3);
                if (StringUtils.isNull(E4)) {
                    chatSysNotifyPojo4.setContent(v);
                } else {
                    this.g = E4;
                    chatSysNotifyPojo4.setContent(E4);
                }
                int F4 = F(3);
                this.f = F4;
                chatSysNotifyPojo4.setUnread(F4);
            } else {
                chatSysNotifyPojo4.setContent(this.g);
            }
            this.q.add(chatSysNotifyPojo);
            this.q.add(chatSysNotifyPojo2);
            this.q.add(chatSysNotifyPojo3);
            this.q.add(chatSysNotifyPojo4);
            return this.q;
        }
        return (List) invokeV.objValue;
    }
}
