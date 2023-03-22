package com.baidu.tieba;

import android.app.Activity;
import android.os.CountDownTimer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.xq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<wj0> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go5 a;

        /* renamed from: com.baidu.tieba.go5$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0275a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wj0 a;
            public final /* synthetic */ a b;

            public RunnableC0275a(a aVar, wj0 wj0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, wj0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = wj0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof ke9) && ((ke9) this.b.a.b).r0().m()) {
                        return;
                    }
                    this.b.a.s(this.a);
                }
            }
        }

        public a(go5 go5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.a.p();
                if (ListUtils.isEmpty(this.a.a)) {
                    return null;
                }
                TbSingleton.getInstance();
                if (TbSingleton.getExceptInsertAdDiaShow()) {
                    return null;
                }
                if ((this.a.b instanceof ke9) && ((ke9) this.a.b).r0().m()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    wj0 wj0Var = (wj0) it.next();
                    if (wj0Var != null && wj0Var.p != null && wj0Var.c == AdDownloadStatus.COMPLETED && this.a.n(wj0Var)) {
                        jg.a().post(new RunnableC0275a(this, wj0Var));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Comparator<wj0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(go5 go5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(wj0 wj0Var, wj0 wj0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wj0Var, wj0Var2)) == null) {
                long j = wj0Var.m;
                long j2 = wj0Var2.m;
                if (j > j2) {
                    return -1;
                }
                if (j < j2) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements xq5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj0 a;
        public final /* synthetic */ xq5 b;
        public final /* synthetic */ go5 c;

        public c(go5 go5Var, wj0 wj0Var, xq5 xq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go5Var, wj0Var, xq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = go5Var;
            this.a = wj0Var;
            this.b = xq5Var;
        }

        @Override // com.baidu.tieba.xq5.h
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    AdAppStateManager.instance().register(this.a);
                    this.c.l(this.a);
                    this.b.l();
                }
                this.c.k(this.a, i, System.currentTimeMillis() - this.c.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements xq5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go5 a;

        public d(go5 go5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go5Var;
        }

        @Override // com.baidu.tieba.xq5.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.cancel();
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xq5 a;
        public final /* synthetic */ go5 b;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(go5 go5Var, long j, long j2, xq5 xq5Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go5Var, Long.valueOf(j), Long.valueOf(j2), xq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go5Var;
            this.a = xq5Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
                this.b.c = null;
            }
        }
    }

    public go5(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.b = activity;
    }

    public final void l(wj0 wj0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj0Var) == null) && wj0Var != null && (file = wj0Var.h) != null) {
            UtilHelper.installApkFile(this.b, file);
        }
    }

    public final boolean m(wj0 wj0Var) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wj0Var)) == null) {
            if (wj0Var == null || (file = wj0Var.h) == null || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t(xq5 xq5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, xq5Var) == null) && this.c == null) {
            e eVar = new e(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, xq5Var);
            this.c = eVar;
            eVar.start();
        }
    }

    public final void q(xq5 xq5Var, wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, xq5Var, wj0Var) == null) {
            xq5Var.t(new c(this, wj0Var, xq5Var));
            xq5Var.q(new d(this));
        }
    }

    public final void k(wj0 wj0Var, int i, long j) {
        String str;
        ak0 ak0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{wj0Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str2 = null;
            if (wj0Var != null && (ak0Var = wj0Var.p) != null) {
                str2 = ak0Var.h;
                str = ak0Var.a;
            } else {
                str = null;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_CLICK);
            statisticItem.param("obj_source", str2).param("obj_type", i);
            TiebaStatic.log(statisticItem);
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (i == 1) {
                v.i(ClogBuilder.Area.INSTALL_NOW_BUTTON);
            } else if (i == 2) {
                v.i(ClogBuilder.Area.CLOSE_BTN);
            } else if (i == 3) {
                v.i(ClogBuilder.Area.HOTAREA);
            }
            v.k(String.valueOf(j));
            v.l(String.valueOf(5000L));
            if (!StringUtils.isNull(str)) {
                v.p(str);
            }
            k11.b(v);
        }
    }

    public final boolean n(wj0 wj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wj0Var)) == null) {
            if (wj0Var == null) {
                return false;
            }
            int n = m35.m().n("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(m35.m().o("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                m35.m().z("key_ad_retarget_tips_day_count", 0);
                n = 0;
            }
            if (n >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            if (m35.m().n("key_ad_retarget_tips_app_count_" + wj0Var.d, 0) >= TbSingleton.getInstance().mAdFloatTipsAppLimitCount || UtilHelper.isInstallApk(this.b, wj0Var.d) || !m(wj0Var)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new a(this).execute(new String[0]);
        }
    }

    public final void p() {
        HashMap<String, wj0> a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (a2 = nj0.b().a()) != null && a2.size() > 0) {
            ArrayList<wj0> arrayList = new ArrayList<>(a2.values());
            this.a = arrayList;
            u01.m(arrayList, new b(this));
        }
    }

    public final void r(wj0 wj0Var) {
        String str;
        ak0 ak0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wj0Var) == null) {
            String str2 = null;
            if (wj0Var != null && (ak0Var = wj0Var.p) != null) {
                str2 = ak0Var.h;
                str = ak0Var.a;
            } else {
                str = null;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_SHOW);
            statisticItem.param("obj_source", str2);
            TiebaStatic.log(statisticItem);
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (!StringUtils.isNull(str)) {
                v.p(str);
            }
            k11.b(v);
        }
    }

    public final void s(wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wj0Var) == null) {
            xq5 xq5Var = new xq5(this.b, 48);
            xq5Var.u(wj0Var.p.h);
            xq5Var.p(TbadkCoreApplication.getInst().getString(R.string.not_install_apk_tips));
            xq5Var.s(TbadkCoreApplication.getInst().getString(R.string.downloaded_install));
            xq5Var.r(wj0Var.p.g);
            xq5Var.o(8);
            if (xq5Var.v()) {
                this.d = System.currentTimeMillis();
                t(xq5Var);
                u(wj0Var);
                q(xq5Var, wj0Var);
                r(wj0Var);
            }
        }
    }

    public final void u(wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wj0Var) == null) {
            m35.m().z("key_ad_retarget_tips_day_count", m35.m().n("key_ad_retarget_tips_day_count", 0) + 1);
            m35.m().A("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + wj0Var.d;
            m35.m().z(str, m35.m().n(str, 0) + 1);
        }
    }
}
