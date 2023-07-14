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
import com.baidu.tieba.a65;
import com.baidu.tieba.ica;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gy extends zx implements ry<ThreadData>, sy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FollowForumDecorView e;
    public LikeModel f;
    public ica g;
    public ThreadData h;
    public TbPageContext i;
    public y55 j;
    public float k;
    public int l;
    public int m;
    public View.OnClickListener n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        public a(gy gyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gyVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null && this.a.h.getForumData() != null) {
                if (this.a.h.getForumData().f()) {
                    this.a.E();
                } else {
                    this.a.v();
                }
                gy.y(this.a.h.getTid(), this.a.h.getFid(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gy gyVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar, Integer.valueOf(i)};
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
            this.a = gyVar;
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
                    if (!(customResponsedMessage.getData() instanceof yea)) {
                        return;
                    }
                    yea yeaVar = (yea) customResponsedMessage.getData();
                    if (!yeaVar.b) {
                        return;
                    }
                    this.a.u(yeaVar.a, true);
                } else if (customResponsedMessage.getCmd() != 2001266 || !(customResponsedMessage.getData() instanceof yba)) {
                } else {
                    yba ybaVar = (yba) customResponsedMessage.getData();
                    if (ybaVar.n() != 0) {
                        return;
                    }
                    this.a.u(wg.g(ybaVar.g(), 0L), false);
                }
            } else if (!(customResponsedMessage.getData() instanceof Long)) {
            } else {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                gy gyVar = this.a;
                if (customResponsedMessage.getCmd() != 2001335) {
                    z = false;
                }
                gyVar.u(longValue, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        public c(gy gyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gyVar;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.f.getErrorCode() == 22) {
                    yi.R(this.a.i.getContext(), this.a.i.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.f.getErrorCode() != 0) {
                        yi.R(this.a.i.getContext(), this.a.f.getErrorString());
                        return;
                    }
                    if (this.a.e != null) {
                        this.a.e.q(true);
                    }
                    if (this.a.h != null && this.a.h.getForumData() != null) {
                        this.a.h.getForumData().n(true);
                        this.a.h.getForumData().o(true);
                        gy gyVar = this.a;
                        gyVar.C(true, gyVar.h.getFid());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ica.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        public d(gy gyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gyVar;
        }

        @Override // com.baidu.tieba.ica.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                yi.R(this.a.i.getContext(), this.a.i.getString(R.string.operation_failed));
            }
        }

        @Override // com.baidu.tieba.ica.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                if (this.a.e != null) {
                    this.a.e.q(false);
                }
                if (this.a.h != null && this.a.h.getForumData() != null) {
                    this.a.h.getForumData().n(false);
                    gy gyVar = this.a;
                    gyVar.C(false, gyVar.h.getFid());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a65.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        public e(gy gyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gyVar;
        }

        @Override // com.baidu.tieba.a65.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
                bh.a(this.a.j, this.a.i.getPageActivity());
                gy.x(this.a.h.getTid(), this.a.h.getFid(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a65.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy a;

        public f(gy gyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gyVar;
        }

        @Override // com.baidu.tieba.a65.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null) {
                return;
            }
            bh.a(this.a.j, this.a.i.getPageActivity());
        }
    }

    public gy(TbPageContext tbPageContext) {
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
        this.l = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.m = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        this.n = new a(this);
        this.o = new b(this, 0);
        this.i = tbPageContext;
        this.e = new FollowForumDecorView(tbPageContext.getPageActivity());
        h(-1);
        z();
        B();
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e.setIsShowIcon(z);
        }
    }

    public static void x(String str, long j, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && j > 0) {
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

    public static void y(String str, long j, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && j > 0) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: A */
    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                this.h = threadData;
                this.e.setVisibility(0);
                this.e.setData(threadData);
                this.e.setTag(threadData);
                this.e.setOnClickListener(this.n);
                y(this.h.getTid(), this.h.getFid(), false);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.setTag(this.i.getUniqueId());
            MessageManager.getInstance().registerListener(2001335, this.o);
            MessageManager.getInstance().registerListener(2001336, this.o);
            MessageManager.getInstance().registerListener(2001437, this.o);
            MessageManager.getInstance().registerListener(2001266, this.o);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.m = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.l, this.m);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            layoutParams.rightMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            i(layoutParams);
            g(this.e);
        }
    }

    public final void C(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            bq6 bq6Var = new bq6();
            bq6Var.d(z);
            bq6Var.c(j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921806, bq6Var));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.j == null) {
                a65 a65Var = new a65(this.i.getContext());
                a65Var.t(this.i.getString(R.string.confirm_unlike_forum));
                ArrayList arrayList = new ArrayList();
                w55 w55Var = new w55(this.i.getContext().getString(R.string.obfuscated_res_0x7f0f04c1), a65Var);
                w55Var.m(new e(this));
                arrayList.add(w55Var);
                a65Var.o(new f(this));
                a65Var.l(arrayList);
                y55 y55Var = new y55(this.i, a65Var);
                this.j = y55Var;
                y55Var.k(this.k);
            }
            bh.i(this.j, this.i.getPageActivity());
            x(this.h.getTid(), this.h.getFid(), false);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!yi.G()) {
                yi.R(this.i.getContext(), this.i.getString(R.string.obfuscated_res_0x7f0f0e1f));
                return;
            }
            ThreadData threadData = this.h;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || Integer.parseInt(this.h.getForumData().b()) <= 0 || !ViewHelper.checkUpIsLogin(this.i.getContext())) {
                return;
            }
            if (this.g == null) {
                ica icaVar = new ica();
                this.g = icaVar;
                icaVar.b(new d(this));
            }
            this.g.c(this.h.getForumData().d(), Integer.parseInt(this.h.getForumData().b()));
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            this.e.onChangeSkinType(i);
        }
    }

    public final void u(long j, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && this.e != null && (threadData = this.h) != null && j != 0 && j == threadData.getFid()) {
            this.h.getForumData().n(z);
            this.h.getForumData().o(true);
            this.e.q(z);
            C(z, j);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!yi.G()) {
                yi.R(this.i.getContext(), this.i.getString(R.string.obfuscated_res_0x7f0f0e1f));
                return;
            }
            ThreadData threadData = this.h;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || wg.e(this.h.getForumData().b(), 0) <= 0 || !ViewHelper.checkUpIsLogin(this.i.getContext())) {
                return;
            }
            if (this.f == null) {
                LikeModel likeModel = new LikeModel(this.i);
                this.f = likeModel;
                likeModel.setLoadDataCallBack(new c(this));
            }
            if (xi.isForumName(this.h.getForumData().d())) {
                this.f.j0();
                this.f.n0(this.h.getForumData().d(), this.h.getForumData().b());
            }
        }
    }
}
