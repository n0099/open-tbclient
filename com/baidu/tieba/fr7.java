package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fr7 extends nr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener h;
    public final k9 i;
    public final k9 j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fr7 fr7Var, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yba)) {
                this.a.b((yba) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(fr7 fr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Boolean)) {
                ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends k9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr7 a;

        public c(fr7 fr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr7Var;
        }

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                } else {
                    z = false;
                }
                if (!z) {
                    this.a.b.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr7(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2001266);
        this.i = new b(this);
        this.j = new c(this);
        frsFragment.registerListener(this.h);
    }

    public final void b(yba ybaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ybaVar) != null) || ybaVar == null) {
            return;
        }
        FrsViewData c1 = this.b.c1();
        if (this.e != null && this.d != null && this.a != null && c1 != null && c1.getForum() != null && ybaVar.g() != null) {
            if (ybaVar.n() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (ybaVar.g().equals(c1.getForum().getId())) {
                c1.getForum().setLike(ybaVar.n());
                if (!StringUtils.isNULL(ybaVar.h())) {
                    c1.getForum().setLevelName(ybaVar.h());
                }
                if (ybaVar.m() >= 0) {
                    c1.getForum().setUser_level(ybaVar.m());
                }
                if (z) {
                    this.d.E0(c1, false);
                    TbadkCoreApplication.getInst().addLikeForum(this.b.v());
                    return;
                }
                eba.i().n(this.b.v(), false);
                c1.getForum().setLike(0);
                this.d.I0();
                TbadkCoreApplication.getInst().delLikeForum(this.b.v());
                return;
            }
            if (ybaVar.n() == 1) {
                c1.deleteLikeFeedForum(ybaVar.g());
                this.d.q0(c1);
                this.c.d(c1, this.e.q0());
            }
            if (c1.getForum().getBannerListData() != null) {
                c1.getForum().getBannerListData().setFeedForumLiked(ybaVar.g(), ybaVar.n());
            }
            this.a.Q0();
        }
    }
}
