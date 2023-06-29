package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowForumDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.r55;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class fy extends yx implements qy<ThreadData>, ry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FollowForumDecorView e;
    public LikeModel f;
    public x3a g;
    public ThreadData h;
    public TbPageContext i;
    public p55 j;
    public float k;
    public int l;
    public int m;
    public View.OnClickListener n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        public a(fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fyVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null && this.a.h.getForumData() != null) {
                if (this.a.h.getForumData().f()) {
                    this.a.G();
                } else {
                    this.a.x();
                }
                fy fyVar = this.a;
                fyVar.A(fyVar.h.getTid(), this.a.h.getFid(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fy fyVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar, Integer.valueOf(i)};
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
            this.a = fyVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            boolean z = true;
            if (customResponsedMessage.getCmd() != 2001335 && customResponsedMessage.getCmd() != 2001336) {
                if (customResponsedMessage.getCmd() == 2001437) {
                    if (!(customResponsedMessage.getData() instanceof n6a)) {
                        return;
                    }
                    n6a n6aVar = (n6a) customResponsedMessage.getData();
                    if (!n6aVar.b) {
                        return;
                    }
                    this.a.w(n6aVar.a, true);
                } else if (customResponsedMessage.getCmd() != 2001266 || !(customResponsedMessage.getData() instanceof n3a)) {
                } else {
                    n3a n3aVar = (n3a) customResponsedMessage.getData();
                    if (n3aVar.n() != 0) {
                        return;
                    }
                    this.a.w(vg.g(n3aVar.g(), 0L), false);
                }
            } else if (!(customResponsedMessage.getData() instanceof Long)) {
            } else {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                fy fyVar = this.a;
                if (customResponsedMessage.getCmd() != 2001335) {
                    z = false;
                }
                fyVar.w(longValue, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        public c(fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fyVar;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.f.getErrorCode() == 22) {
                    xi.Q(this.a.i.getContext(), this.a.i.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.f.getErrorCode() != 0) {
                        xi.Q(this.a.i.getContext(), this.a.f.getErrorString());
                        return;
                    }
                    if (this.a.e != null) {
                        this.a.e.q(true);
                    }
                    if (this.a.h != null && this.a.h.getForumData() != null) {
                        this.a.h.getForumData().n(true);
                        this.a.h.getForumData().o(true);
                        fy fyVar = this.a;
                        fyVar.E(true, fyVar.h.getFid());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements x3a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        public d(fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fyVar;
        }

        @Override // com.baidu.tieba.x3a.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                xi.Q(this.a.i.getContext(), this.a.i.getString(R.string.operation_failed));
            }
        }

        @Override // com.baidu.tieba.x3a.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                if (this.a.e != null) {
                    this.a.e.q(false);
                }
                if (this.a.h != null && this.a.h.getForumData() != null) {
                    this.a.h.getForumData().n(false);
                    fy fyVar = this.a;
                    fyVar.E(false, fyVar.h.getFid());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        public e(fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fyVar;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
                ah.a(this.a.j, this.a.i.getPageActivity());
                fy fyVar = this.a;
                fyVar.z(fyVar.h.getTid(), this.a.h.getFid(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements r55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;

        public f(fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fyVar;
        }

        @Override // com.baidu.tieba.r55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null) {
                return;
            }
            ah.a(this.a.j, this.a.i.getPageActivity());
        }
    }

    public fy(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0.7f;
        this.l = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.m = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        this.n = new a(this);
        this.o = new b(this, 0);
        this.i = tbPageContext;
        this.e = new FollowForumDecorView(tbPageContext.getPageActivity());
        h(-1);
        B();
        D();
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.e.setIsShowIcon(z);
        }
    }

    public final void A(String str, long j, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && j > 0) {
            if (z) {
                str2 = TbadkCoreStatisticKey.KEY_HOMEPAGE_CAR_HEAD_FORUM_ATTENTION_CLICK;
            } else {
                str2 = TbadkCoreStatisticKey.KEY_HOMEPAGE_CAR_HEAD_FORUM_ATTENTION_SHOW;
            }
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.addParam("fid", j);
            statisticItem.addParam("tid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(String str, long j, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && j > 0) {
            if (z) {
                str2 = TbadkCoreStatisticKey.KEY_HOMEPAGE_FORUM_UNATTENTION_WINDOW_CLICK;
            } else {
                str2 = TbadkCoreStatisticKey.KEY_HOMEPAGE_FORUM_UNATTENTION_WINDOW_SHOW;
            }
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.addParam("fid", j);
            statisticItem.addParam("tid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.m = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.l, this.m);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            layoutParams.rightMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            i(layoutParams);
            g(this.e);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.setTag(this.i.getUniqueId());
            MessageManager.getInstance().registerListener(2001335, this.o);
            MessageManager.getInstance().registerListener(2001336, this.o);
            MessageManager.getInstance().registerListener(2001437, this.o);
            MessageManager.getInstance().registerListener(2001266, this.o);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qy
    /* renamed from: C */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                this.h = threadData;
                this.e.setVisibility(0);
                this.e.setData(threadData);
                this.e.setTag(threadData);
                this.e.setOnClickListener(this.n);
                A(this.h.getTid(), this.h.getFid(), false);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public final void E(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            xo6 xo6Var = new xo6();
            xo6Var.d(z);
            xo6Var.c(j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921806, xo6Var));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.j == null) {
                r55 r55Var = new r55(this.i.getContext());
                r55Var.t(this.i.getString(R.string.confirm_unlike_forum));
                ArrayList arrayList = new ArrayList();
                n55 n55Var = new n55(this.i.getContext().getString(R.string.obfuscated_res_0x7f0f04be), r55Var);
                n55Var.m(new e(this));
                arrayList.add(n55Var);
                r55Var.o(new f(this));
                r55Var.l(arrayList);
                p55 p55Var = new p55(this.i, r55Var);
                this.j = p55Var;
                p55Var.k(this.k);
            }
            ah.i(this.j, this.i.getPageActivity());
            z(this.h.getTid(), this.h.getFid(), false);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!xi.F()) {
                xi.Q(this.i.getContext(), this.i.getString(R.string.obfuscated_res_0x7f0f0e0f));
                return;
            }
            ThreadData threadData = this.h;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || Integer.parseInt(this.h.getForumData().b()) <= 0 || !ViewHelper.checkUpIsLogin(this.i.getContext())) {
                return;
            }
            if (this.g == null) {
                x3a x3aVar = new x3a();
                this.g = x3aVar;
                x3aVar.b(new d(this));
            }
            this.g.c(this.h.getForumData().d(), Integer.parseInt(this.h.getForumData().b()));
        }
    }

    @Override // com.baidu.tieba.ry
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            this.e.onChangeSkinType(i);
        }
    }

    public final void w(long j, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && this.e != null && (threadData = this.h) != null && j != 0 && j == threadData.getFid()) {
            this.h.getForumData().n(z);
            this.h.getForumData().o(true);
            this.e.q(z);
            E(z, j);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!xi.F()) {
                xi.Q(this.i.getContext(), this.i.getString(R.string.obfuscated_res_0x7f0f0e0f));
                return;
            }
            ThreadData threadData = this.h;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || vg.e(this.h.getForumData().b(), 0) <= 0 || !ViewHelper.checkUpIsLogin(this.i.getContext())) {
                return;
            }
            if (this.f == null) {
                LikeModel likeModel = new LikeModel(this.i);
                this.f = likeModel;
                likeModel.setLoadDataCallBack(new c(this));
            }
            if (wi.isForumName(this.h.getForumData().d())) {
                this.f.i0();
                this.f.m0(this.h.getForumData().d(), this.h.getForumData().b());
            }
        }
    }
}
