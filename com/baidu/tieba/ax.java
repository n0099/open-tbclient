package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ax extends zw<rr4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout f;
    public rr4 g;
    public View.OnClickListener h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ax a;

        public a(ax axVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {axVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = axVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ax axVar = this.a;
                axVar.v(axVar.a.j(), this.a.g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements yy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ax a;

        public b(ax axVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {axVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = axVar;
        }

        @Override // com.baidu.tieba.yy.b
        public boolean a(yy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    k36.a(this.a.g.getThreadData().getId());
                    k36.l(this.a.f.getTitle(), this.a.g.getThreadData().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(Context context) {
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

    @Override // com.baidu.tieba.zw
    public void p(z36<rr4> z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, z36Var) == null) {
            super.p(z36Var);
            this.f.setSubClickListener(z36Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rx
    /* renamed from: w */
    public void a(rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rr4Var) == null) {
            this.g = rr4Var;
            this.f.a(rr4Var);
        }
    }

    @Override // com.baidu.tieba.zw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zw
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.l();
            m(1, new b(this));
        }
    }

    @Override // com.baidu.tieba.sx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void v(View view2, wn wnVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, wnVar) == null) {
            rr4 rr4Var = this.g;
            if ((!(rr4Var instanceof j46) && !(rr4Var instanceof ThreadData)) || !(view2.getTag() instanceof ThreadCardViewHolder)) {
                return;
            }
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            if (wnVar instanceof j46) {
                j46 j46Var = (j46) this.g;
                j46Var.f = 1;
                Context context = view2.getContext();
                if (j46Var.a.isFromHomPage) {
                    i = 2;
                } else {
                    i = 1;
                }
                ThreadCardUtils.jumpToPB((rr4) j46Var, context, i, false);
                threadCardViewHolder.a().o(new yy.a(1));
            } else if (wnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) this.g;
                threadData.objType = 1;
                ThreadCardUtils.jumpToPB((rr4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }
}
