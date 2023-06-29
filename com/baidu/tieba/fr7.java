package com.baidu.tieba;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes5.dex */
public class fr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yk7 a;
    public er7 b;
    public gr7 c;
    public LongSparseArray<Integer> d;
    public FrsFragment e;
    public boolean f;
    public boolean g;
    public c3a h;
    public FrsSpriteGuideTipController i;
    public CustomMessageListener j;

    /* loaded from: classes5.dex */
    public class a implements FrsSpriteGuideTipController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ as7 c;
        public final /* synthetic */ fr7 d;

        public a(fr7 fr7Var, String str, String str2, as7 as7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr7Var, str, str2, as7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fr7Var;
            this.a = str;
            this.b = str2;
            this.c = as7Var;
        }

        @Override // com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.d(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ as7 c;
        public final /* synthetic */ fr7 d;

        public b(fr7 fr7Var, String str, String str2, as7 as7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr7Var, str, str2, as7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fr7Var;
            this.a = str;
            this.b = str2;
            this.c = as7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.d(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fr7 fr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr7Var, Integer.valueOf(i)};
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
            this.a = fr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.l(longValue) && this.a.c(longValue) >= 1) {
                    this.a.e(longValue);
                    this.a.f = true;
                }
            }
        }
    }

    public fr7(FrsFragment frsFragment, c3a c3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, c3aVar};
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
        this.j = new c(this, 2921498);
        this.c = new gr7();
        this.d = new LongSparseArray<>();
        this.e = frsFragment;
        this.h = c3aVar;
    }

    public boolean o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (k(str) && k(str2)) {
                if (TimeHelper.getDayDifference(System.currentTimeMillis(), this.c.b(str, str2)) < 1) {
                    DefaultLog.getInstance().b("FrsGuide", "显示frs吧关注引导失败: 一天内只出现一次");
                    return false;
                }
                return true;
            }
            ew8 defaultLog = DefaultLog.getInstance();
            defaultLog.b("FrsGuide", "显示frs吧关注引导失败: 不是有效id " + str + " " + str2);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public fr7(String str, String str2) {
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
        this.j = new c(this, 2921498);
        this.b = new er7(str, str2);
    }

    public int c(long j) {
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

    public final void d(String str, String str2, as7 as7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, as7Var) == null) {
            ew8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("FrsGuide", "吧关注弹窗按钮点击:吧Id：" + str + " 吧名：" + str2);
            if (as7Var != null) {
                as7Var.o(str2, str);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && j != 0) {
            this.d.remove(j);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!StringUtils.isNull(str) && !"0".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            c3a c3aVar = this.h;
            if (c3aVar == null || j == 0 || (forum = c3aVar.getForum()) == null || vg.g(forum.getId(), 0L) != j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.g = z;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yk7 yk7Var = this.a;
            if (yk7Var != null) {
                yk7Var.o();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.i;
            if (frsSpriteGuideTipController != null) {
                frsSpriteGuideTipController.g();
            }
        }
    }

    public gr7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (gr7) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        FrsSpriteGuideTipController frsSpriteGuideTipController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yk7 yk7Var = this.a;
            if ((yk7Var != null && yk7Var.p()) || ((frsSpriteGuideTipController = this.i) != null && frsSpriteGuideTipController.h())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(ForumData forumData) {
        c3a c3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumData) == null) {
            FrsFragment frsFragment = this.e;
            if (frsFragment != null && frsFragment.x0() != null) {
                if (forumData == null && (c3aVar = this.h) != null) {
                    forumData = c3aVar.getForum();
                }
                if (forumData != null && forumData.isLike() != 1) {
                    if (!this.g) {
                        DefaultLog.getInstance().c("FrsGuide", "显示frs吧关注引导失败: 当前页面不可见");
                        this.f = true;
                        return;
                    }
                    p(forumData.getName(), forumData.getId(), forumData.getImage_url(), false);
                    return;
                }
                return;
            }
            DefaultLog.getInstance().c("FrsGuide", "显示frs吧关注引导失败: headerView为空");
        }
    }

    public void n(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, activity, str, str2) == null) && activity != null && this.b.c()) {
            if (this.a == null) {
                this.a = new yk7(activity, R.id.obfuscated_res_0x7f090c9a);
            }
            this.a.s(str);
            this.a.u(str2);
            this.a.v();
        }
    }

    public final boolean p(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!o(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.e) == null || frsFragment.x0() == null) {
                return false;
            }
            this.f = false;
            q(this.e.getActivity(), str, str2, str3, this.e.x0().T());
            h().c(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void q(Activity activity, String str, String str2, String str3, as7 as7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048590, this, activity, str, str2, str3, as7Var) != null) || activity == null) {
            return;
        }
        if (nn5.d()) {
            ew8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("FrsGuide", "使用精灵动画吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            FrsSpriteGuideTipController frsSpriteGuideTipController = new FrsSpriteGuideTipController(activity);
            this.i = frsSpriteGuideTipController;
            frsSpriteGuideTipController.i(new a(this, str2, str, as7Var));
            x55.g(Collections.singletonList(new zk7(activity, null, this.i)));
        } else {
            ew8 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.c("FrsGuide", "使用线上吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            if (this.a == null) {
                this.a = new yk7(activity, R.id.obfuscated_res_0x7f090c9e);
            }
            if (!StringUtils.isNull(str3)) {
                this.a.q(str3);
            }
            this.a.r(new b(this, str2, str, as7Var));
            x55.g(Collections.singletonList(new zk7(activity, this.a, null)));
        }
        ew8 defaultLog3 = DefaultLog.getInstance();
        defaultLog3.c("FrsGuide", "吧关注弹窗曝光:吧Id：" + str2 + " 吧名：" + str);
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
