package com.baidu.tieba;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ct6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dt6 a;
    public LongSparseArray<Integer> b;
    public co6 c;
    public bt6 d;
    public Runnable e;
    public FrsFragment f;
    public boolean g;
    public boolean h;
    public zl8 i;
    public CustomMessageListener j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt6 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(ct6 ct6Var, vt6 vt6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct6Var, vt6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt6Var;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vt6 vt6Var = this.a;
                if (vt6Var != null) {
                    vt6Var.o(this.b, this.c);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumData a;
        public final /* synthetic */ ct6 b;

        public b(ct6 ct6Var, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct6Var, forumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ct6Var;
            this.a = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.h) {
                    this.b.q(this.a.getName(), this.a.getId(), this.a.getImage_url(), true);
                } else {
                    this.b.g = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ct6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ct6 ct6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct6Var, Integer.valueOf(i)};
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
            this.a = ct6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.a.i((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.l(longValue) && this.a.d(longValue) >= 3) {
                    this.a.e(longValue);
                    this.a.g = true;
                }
            }
        }
    }

    public ct6(FrsFragment frsFragment, zl8 zl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, zl8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.g = false;
        this.h = false;
        this.j = new c(this, 2921498);
        this.a = new dt6();
        this.b = new LongSparseArray<>();
        this.f = frsFragment;
        this.i = zl8Var;
    }

    public int d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.b.get(j);
            if (num == null) {
                this.b.put(j, 1);
                return 1;
            }
            this.b.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j == 0) {
            return;
        }
        this.b.remove(j);
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.b(str, str2);
        }
    }

    public void g() {
        co6 co6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (co6Var = this.c) == null) {
            return;
        }
        co6Var.m();
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, forumData) == null) || forumData == null) {
            return;
        }
        boolean z = false;
        if (q(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.e != null) {
                gh.a().removeCallbacks(this.e);
            }
            z = true;
        }
        if (z) {
            return;
        }
        Runnable runnable = this.e;
        if (runnable == null) {
            runnable = new b(this, forumData);
        }
        this.e = runnable;
        gh.a().postDelayed(this.e, 60000L);
    }

    public void i(ForumData forumData) {
        FrsFragment frsFragment;
        zl8 zl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumData) == null) || (frsFragment = this.f) == null || frsFragment.n0() == null) {
            return;
        }
        if (forumData == null && (zl8Var = this.i) != null) {
            forumData = zl8Var.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.h) {
            this.g = true;
        } else if (!q(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.e == null) {
        } else {
            gh.a().removeCallbacks(this.e);
        }
    }

    public dt6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (dt6) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean l(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            zl8 zl8Var = this.i;
            return (zl8Var == null || j == 0 || (forum = zl8Var.getForum()) == null || dh.g(forum.getId(), 0L) != j) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            gh.a().removeCallbacks(this.e);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h = z;
        }
    }

    public void o(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, activity, str, str2) == null) && activity != null && this.d.c()) {
            if (this.c == null) {
                this.c = new co6(activity, R.id.obfuscated_res_0x7f090b45);
            }
            this.c.p(str);
            this.c.q(str2);
            this.c.r();
        }
    }

    public boolean p(String str, String str2) {
        InterceptResult invokeLL;
        dt6 dt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (dt6Var = this.a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - dt6Var.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
                long c2 = this.a.c(str, str2);
                if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                    return this.a.d(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean q(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!p(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f) == null || frsFragment.n0() == null) {
                return false;
            }
            this.g = false;
            r(this.f.getActivity(), str, str2, str3, this.f.n0().C());
            j().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void r(Activity activity, String str, String str2, String str3, vt6 vt6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048590, this, activity, str, str2, str3, vt6Var) == null) || activity == null) {
            return;
        }
        if (this.c == null) {
            this.c = new co6(activity, R.id.obfuscated_res_0x7f090b49);
        }
        if (!StringUtils.isNull(str3)) {
            this.c.n(str3);
        }
        this.c.o(new a(this, vt6Var, str, str2));
        this.c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public ct6(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.g = false;
        this.h = false;
        this.j = new c(this, 2921498);
        this.d = new bt6(str, str2);
    }
}
