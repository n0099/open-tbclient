package com.baidu.tieba;

import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dh7 extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentActivity b;
    public nb5 c;
    public Map<String, Date> d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947704630, "Lcom/baidu/tieba/dh7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947704630, "Lcom/baidu/tieba/dh7;");
                return;
            }
        }
        f = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                    return PushOpenUtil.shouldShowPushOpenView(TbadkCoreApplication.getInst(), i);
                }
                return hba.d.a().b("forum_follow");
            }
            return invokeI.booleanValue;
        }
    }

    public dh7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.d = new HashMap();
    }

    @Override // com.baidu.tieba.pg7
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.m();
            o();
        }
    }

    public final void o() {
        nb5 nb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (nb5Var = this.c) != null) {
            Intrinsics.checkNotNull(nb5Var);
            nb5Var.q();
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            nb5 nb5Var = this.c;
            if (nb5Var != null) {
                Intrinsics.checkNotNull(nb5Var);
                if (nb5Var.t()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final Date r(String str) {
        InterceptResult invokeL;
        Map<String, Date> hasShowTip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.d == null) {
                hasShowTip = new HashMap<>();
            } else {
                hasShowTip = TbSingleton.getInstance().getHasShowTip();
            }
            this.d = hasShowTip;
            Date date = new Date(System.currentTimeMillis());
            Map<String, Date> map = this.d;
            if (map != null) {
                Intrinsics.checkNotNull(map);
                if (map.containsKey(str)) {
                    Map<String, Date> map2 = this.d;
                    Intrinsics.checkNotNull(map2);
                    if (TimeHelper.getDayDifference(map2.get(str), date) >= 1) {
                        this.e = true;
                    }
                    return date;
                }
            }
            this.e = true;
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public final void s(String fid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fid) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            if (!(this.b instanceof BaseFragmentActivity)) {
                return;
            }
            Date r = r(fid);
            int i = 0;
            i = (UbsABTestHelper.isPushPermissionForumFollowTestA() || UbsABTestHelper.isPushPermissionForumFollowTestB()) ? 11 : 11;
            if ((!NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !aa5.e().o()) && this.e && f.a(i)) {
                HashMap hashMap = new HashMap();
                nb5 nb5Var = this.c;
                if (nb5Var != null) {
                    Intrinsics.checkNotNull(nb5Var);
                    nb5Var.q();
                }
                nb5 showPushOpenView = PushOpenUtil.showPushOpenView(((BaseFragmentActivity) this.b).getPageContext(), "forum_follow", 2000L, hashMap);
                this.c = showPushOpenView;
                if (showPushOpenView != null) {
                    hba.d.a().h("forum_follow");
                }
                Map<String, Date> map = this.d;
                Intrinsics.checkNotNull(map);
                map.put(fid, r);
                TbSingleton.getInstance().setHasShowTip(this.d);
                return;
            }
            BdUtilHelper.showToastByTextCenter(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
        }
    }
}
