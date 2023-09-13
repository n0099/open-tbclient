package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bx extends ax<b15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout f;
    public b15 g;
    public View.OnClickListener h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx a;

        public a(bx bxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bx bxVar = this.a;
                bxVar.x(bxVar.a.k(), this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx a;

        public b(bx bxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bxVar;
        }

        @Override // com.baidu.tieba.zy.b
        public boolean a(zy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    xo6.a(this.a.g.getThreadData().getId());
                    xo6.l(this.a.f.getTitle(), this.a.g.getThreadData().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.f = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.h);
    }

    @Override // com.baidu.tieba.ax
    public void o(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp6Var) == null) {
            super.o(mp6Var);
            this.f.setSubClickListener(mp6Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: y */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b15Var) == null) {
            this.g = b15Var;
            this.f.onBindDataToView(b15Var);
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ax
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k();
            l(1, new b(this));
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void x(View view2, cn cnVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, cnVar) == null) {
            b15 b15Var = this.g;
            if ((!(b15Var instanceof xp6) && !(b15Var instanceof ThreadData)) || !(view2.getTag() instanceof ThreadCardViewHolder)) {
                return;
            }
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            if (cnVar instanceof xp6) {
                xp6 xp6Var = (xp6) this.g;
                xp6Var.f = 1;
                Context context = view2.getContext();
                if (xp6Var.a.isFromHomPage) {
                    i = 2;
                } else {
                    i = 1;
                }
                ThreadCardUtils.jumpToPB((b15) xp6Var, context, i, false);
                threadCardViewHolder.a().p(new zy.a(1));
            } else if (cnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) this.g;
                threadData.objType = 1;
                ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }
}
