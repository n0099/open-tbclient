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
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h37 a;
    public f87 b;
    public h87 c;
    public LongSparseArray<Integer> d;
    public FrsFragment e;
    public boolean f;
    public boolean g;
    public qa9 h;
    public CustomMessageListener i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b97 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(g87 g87Var, b97 b97Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, b97Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b97Var;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                b97 b97Var = this.a;
                if (b97Var != null) {
                    b97Var.o(this.b, this.c);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.j(longValue) && this.a.b(longValue) >= 1) {
                    this.a.c(longValue);
                    this.a.f = true;
                }
            }
        }
    }

    public g87(FrsFragment frsFragment, qa9 qa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, qa9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.f = false;
        this.g = false;
        this.i = new b(this, 2921498);
        this.c = new h87();
        this.d = new LongSparseArray<>();
        this.e = frsFragment;
        this.h = qa9Var;
    }

    public g87(String str, String str2) {
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
        this.c = null;
        this.f = false;
        this.g = false;
        this.i = new b(this, 2921498);
        this.b = new f87(str, str2);
    }

    public int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.d.get(j);
            if (num == null) {
                this.d.put(j, 1);
                return 1;
            }
            this.d.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void e(ForumData forumData) {
        FrsFragment frsFragment;
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) && (frsFragment = this.e) != null && frsFragment.s0() != null) {
            if (forumData == null && (qa9Var = this.h) != null) {
                forumData = qa9Var.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.g) {
                    this.f = true;
                } else {
                    n(forumData.getName(), forumData.getId(), forumData.getImage_url(), false);
                }
            }
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j != 0) {
            this.d.remove(j);
        }
    }

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!StringUtils.isNull(str) && !"0".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean j(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            qa9 qa9Var = this.h;
            if (qa9Var == null || j == 0 || (forum = qa9Var.getForum()) == null || gg.g(forum.getId(), 0L) != j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void d() {
        h37 h37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (h37Var = this.a) != null) {
            h37Var.n();
        }
    }

    public h87 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (h87) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h37 h37Var = this.a;
            if (h37Var != null && h37Var.o()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, activity, str, str2) == null) && activity != null && this.b.c()) {
            if (this.a == null) {
                this.a = new h37(activity, R.id.obfuscated_res_0x7f090c4d);
            }
            this.a.r(str);
            this.a.s(str2);
            this.a.t();
        }
    }

    public boolean m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (!i(str) || !i(str2)) {
                return false;
            }
            if (TimeHelper.getDayDifference(System.currentTimeMillis(), this.c.b(str, str2)) < 1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!m(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.e) == null || frsFragment.s0() == null) {
                return false;
            }
            this.f = false;
            o(this.e.getActivity(), str, str2, str3, this.e.s0().G());
            f().c(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void o(Activity activity, String str, String str2, String str3, b97 b97Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048589, this, activity, str, str2, str3, b97Var) != null) || activity == null) {
            return;
        }
        if (this.a == null) {
            this.a = new h37(activity, R.id.obfuscated_res_0x7f090c51);
        }
        if (!StringUtils.isNull(str3)) {
            this.a.p(str3);
        }
        this.a.q(new a(this, b97Var, str, str2));
        this.a.u();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
