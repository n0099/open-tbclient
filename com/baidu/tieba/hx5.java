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
import com.baidu.tieba.c06;
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
/* loaded from: classes6.dex */
public class hx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<gm0> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx5 a;

        /* renamed from: com.baidu.tieba.hx5$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0328a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gm0 a;
            public final /* synthetic */ a b;

            public RunnableC0328a(a aVar, gm0 gm0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gm0Var};
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
                this.a = gm0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof hfa) && ((hfa) this.b.a.b).r0().t()) {
                        return;
                    }
                    this.b.a.s(this.a);
                }
            }
        }

        public a(hx5 hx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx5Var;
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
                if ((this.a.b instanceof hfa) && ((hfa) this.a.b).r0().t()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    gm0 gm0Var = (gm0) it.next();
                    if (gm0Var != null && gm0Var.p != null && gm0Var.c == AdDownloadStatus.COMPLETED && this.a.n(gm0Var)) {
                        zg.a().post(new RunnableC0328a(this, gm0Var));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Comparator<gm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(hx5 hx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx5Var};
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
        public int compare(gm0 gm0Var, gm0 gm0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gm0Var, gm0Var2)) == null) {
                long j = gm0Var.m;
                long j2 = gm0Var2.m;
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

    /* loaded from: classes6.dex */
    public class c implements c06.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm0 a;
        public final /* synthetic */ c06 b;
        public final /* synthetic */ hx5 c;

        public c(hx5 hx5Var, gm0 gm0Var, c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx5Var, gm0Var, c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx5Var;
            this.a = gm0Var;
            this.b = c06Var;
        }

        @Override // com.baidu.tieba.c06.h
        public void onClick(int i) {
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

    /* loaded from: classes6.dex */
    public class d implements c06.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx5 a;

        public d(hx5 hx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx5Var;
        }

        @Override // com.baidu.tieba.c06.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.cancel();
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;
        public final /* synthetic */ hx5 b;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(hx5 hx5Var, long j, long j2, c06 c06Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx5Var, Long.valueOf(j), Long.valueOf(j2), c06Var};
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
            this.b = hx5Var;
            this.a = c06Var;
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

    public hx5(Activity activity) {
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

    public final void l(gm0 gm0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm0Var) == null) && gm0Var != null && (file = gm0Var.h) != null) {
            UtilHelper.installApkFile(this.b, file);
        }
    }

    public final boolean m(gm0 gm0Var) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gm0Var)) == null) {
            if (gm0Var == null || (file = gm0Var.h) == null || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t(c06 c06Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, c06Var) == null) && this.c == null) {
            e eVar = new e(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, c06Var);
            this.c = eVar;
            eVar.start();
        }
    }

    public final void q(c06 c06Var, gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c06Var, gm0Var) == null) {
            c06Var.t(new c(this, gm0Var, c06Var));
            c06Var.q(new d(this));
        }
    }

    public final void k(gm0 gm0Var, int i, long j) {
        String str;
        km0 km0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gm0Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str2 = null;
            if (gm0Var != null && (km0Var = gm0Var.p) != null) {
                str2 = km0Var.h;
                str = km0Var.a;
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
            n41.e(v);
        }
    }

    public final boolean n(gm0 gm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gm0Var)) == null) {
            if (gm0Var == null) {
                return false;
            }
            int q = da5.p().q("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(da5.p().r("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                da5.p().F("key_ad_retarget_tips_day_count", 0);
                q = 0;
            }
            if (q >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            if (da5.p().q("key_ad_retarget_tips_app_count_" + gm0Var.d, 0) >= TbSingleton.getInstance().mAdFloatTipsAppLimitCount || UtilHelper.isInstallApk(this.b, gm0Var.d) || !m(gm0Var)) {
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
        HashMap<String, gm0> a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (a2 = xl0.b().a()) != null && a2.size() > 0) {
            ArrayList<gm0> arrayList = new ArrayList<>(a2.values());
            this.a = arrayList;
            x31.m(arrayList, new b(this));
        }
    }

    public final void r(gm0 gm0Var) {
        String str;
        km0 km0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gm0Var) == null) {
            String str2 = null;
            if (gm0Var != null && (km0Var = gm0Var.p) != null) {
                str2 = km0Var.h;
                str = km0Var.a;
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
            n41.e(v);
        }
    }

    public final void s(gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gm0Var) == null) {
            c06 c06Var = new c06(this.b, 48);
            c06Var.u(gm0Var.p.h);
            c06Var.p(TbadkCoreApplication.getInst().getString(R.string.not_install_apk_tips));
            c06Var.s(TbadkCoreApplication.getInst().getString(R.string.downloaded_install));
            c06Var.r(gm0Var.p.g);
            c06Var.o(8);
            if (c06Var.v()) {
                this.d = System.currentTimeMillis();
                t(c06Var);
                u(gm0Var);
                q(c06Var, gm0Var);
                r(gm0Var);
            }
        }
    }

    public final void u(gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gm0Var) == null) {
            da5.p().F("key_ad_retarget_tips_day_count", da5.p().q("key_ad_retarget_tips_day_count", 0) + 1);
            da5.p().H("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + gm0Var.d;
            da5.p().F(str, da5.p().q(str, 0) + 1);
        }
    }
}
