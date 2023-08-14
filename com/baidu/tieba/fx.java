package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.cba;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.w45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class fx extends yw implements qx<ThreadData>, rx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FollowForumDecorView a;
    public LikeModel b;
    public cba c;
    public ThreadData d;
    public TbPageContext e;
    public u45 f;
    public float g;
    public int h;
    public int i;
    public View.OnClickListener j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        public a(fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.d.getForumData() != null) {
                if (this.a.d.getForumData().f()) {
                    this.a.u();
                } else {
                    this.a.l();
                }
                fx.o(this.a.d.getTid(), this.a.d.getFid(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fx fxVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar, Integer.valueOf(i)};
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
            this.a = fxVar;
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
                    if (!(customResponsedMessage.getData() instanceof AttentionBarData)) {
                        return;
                    }
                    AttentionBarData attentionBarData = (AttentionBarData) customResponsedMessage.getData();
                    if (!attentionBarData.isSuccess) {
                        return;
                    }
                    this.a.k(attentionBarData.forumId, true);
                } else if (customResponsedMessage.getCmd() != 2001266 || !(customResponsedMessage.getData() instanceof LikeReturnData)) {
                } else {
                    LikeReturnData likeReturnData = (LikeReturnData) customResponsedMessage.getData();
                    if (likeReturnData.isLike() != 0) {
                        return;
                    }
                    this.a.k(JavaTypesHelper.toLong(likeReturnData.getFid(), 0L), false);
                }
            } else if (!(customResponsedMessage.getData() instanceof Long)) {
            } else {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                fx fxVar = this.a;
                if (customResponsedMessage.getCmd() != 2001335) {
                    z = false;
                }
                fxVar.k(longValue, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        public c(fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fxVar;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.b.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.a.e.getContext(), this.a.e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.b.getErrorCode() != 0) {
                        BdUtilHelper.showToast(this.a.e.getContext(), this.a.b.getErrorString());
                        return;
                    }
                    if (this.a.a != null) {
                        this.a.a.q(true);
                    }
                    if (this.a.d != null && this.a.d.getForumData() != null) {
                        this.a.d.getForumData().n(true);
                        this.a.d.getForumData().o(true);
                        fx fxVar = this.a;
                        fxVar.s(true, fxVar.d.getFid());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements cba.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        public d(fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fxVar;
        }

        @Override // com.baidu.tieba.cba.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                BdUtilHelper.showToast(this.a.e.getContext(), this.a.e.getString(R.string.operation_failed));
            }
        }

        @Override // com.baidu.tieba.cba.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                if (this.a.a != null) {
                    this.a.a.q(false);
                }
                if (this.a.d != null && this.a.d.getForumData() != null) {
                    this.a.d.getForumData().n(false);
                    fx fxVar = this.a;
                    fxVar.s(false, fxVar.d.getFid());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements w45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        public e(fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fxVar;
        }

        @Override // com.baidu.tieba.w45.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
                jg.a(this.a.f, this.a.e.getPageActivity());
                fx.n(this.a.d.getTid(), this.a.d.getFid(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements w45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;

        public f(fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fxVar;
        }

        @Override // com.baidu.tieba.w45.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.f == null) {
                return;
            }
            jg.a(this.a.f, this.a.e.getPageActivity());
        }
    }

    public fx(TbPageContext tbPageContext) {
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
        this.g = 0.7f;
        this.h = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds166);
        this.i = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
        this.j = new a(this);
        this.k = new b(this, 0);
        this.e = tbPageContext;
        this.a = new FollowForumDecorView(tbPageContext.getPageActivity());
        setInsertIndex(-1);
        p();
        r();
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.setIsShowIcon(z);
        }
    }

    public static void n(String str, long j, boolean z) {
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

    public static void o(String str, long j, boolean z) {
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

    public final void k(long j, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && this.a != null && (threadData = this.d) != null && j != 0 && j == threadData.getFid()) {
            this.d.getForumData().n(z);
            this.d.getForumData().o(true);
            this.a.q(z);
            s(z, j);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.e.getContext(), this.e.getString(R.string.obfuscated_res_0x7f0f0e21));
                return;
            }
            ThreadData threadData = this.d;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || JavaTypesHelper.toInt(this.d.getForumData().b(), 0) <= 0 || !ViewHelper.checkUpIsLogin(this.e.getContext())) {
                return;
            }
            if (this.b == null) {
                LikeModel likeModel = new LikeModel(this.e);
                this.b = likeModel;
                likeModel.setLoadDataCallBack(new c(this));
            }
            if (bi.isForumName(this.d.getForumData().d())) {
                this.b.b0();
                this.b.f0(this.d.getForumData().d(), this.d.getForumData().b());
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                BdUtilHelper.showToast(this.e.getContext(), this.e.getString(R.string.obfuscated_res_0x7f0f0e21));
                return;
            }
            ThreadData threadData = this.d;
            if (threadData == null || StringUtils.isNull(threadData.getForumData().d()) || Integer.parseInt(this.d.getForumData().b()) <= 0 || !ViewHelper.checkUpIsLogin(this.e.getContext())) {
                return;
            }
            if (this.c == null) {
                cba cbaVar = new cba();
                this.c = cbaVar;
                cbaVar.b(new d(this));
            }
            this.c.c(this.d.getForumData().d(), Integer.parseInt(this.d.getForumData().b()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f == null) {
                w45 w45Var = new w45(this.e.getContext());
                w45Var.t(this.e.getString(R.string.confirm_unlike_forum));
                ArrayList arrayList = new ArrayList();
                s45 s45Var = new s45(this.e.getContext().getString(R.string.obfuscated_res_0x7f0f04c1), w45Var);
                s45Var.m(new e(this));
                arrayList.add(s45Var);
                w45Var.o(new f(this));
                w45Var.l(arrayList);
                u45 u45Var = new u45(this.e, w45Var);
                this.f = u45Var;
                u45Var.k(this.g);
            }
            jg.i(this.f, this.e.getPageActivity());
            n(this.d.getTid(), this.d.getFid(), false);
        }
    }

    @Override // com.baidu.tieba.rx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.a.onChangeSkinType(i);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.i = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds76);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.h, this.i);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            setLayoutParams(layoutParams);
            setDecorView(this.a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.setTag(this.e.getUniqueId());
            MessageManager.getInstance().registerListener(2001335, this.k);
            MessageManager.getInstance().registerListener(2001336, this.k);
            MessageManager.getInstance().registerListener(2001437, this.k);
            MessageManager.getInstance().registerListener(2001266, this.k);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qx
    /* renamed from: q */
    public void onBindDataToView(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                this.d = threadData;
                this.a.setVisibility(0);
                this.a.setData(threadData);
                this.a.setTag(threadData);
                this.a.setOnClickListener(this.j);
                o(this.d.getTid(), this.d.getFid(), false);
                return;
            }
            this.a.setVisibility(8);
        }
    }

    public final void s(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            jn6 jn6Var = new jn6();
            jn6Var.d(z);
            jn6Var.c(j);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921806, jn6Var));
        }
    }
}
