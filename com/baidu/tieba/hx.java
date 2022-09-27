package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.dz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hx extends gx<yq4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BjhArticleLayout f;
    public yq4 g;
    public View.OnClickListener h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx a;

        public a(hx hxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hx hxVar = this.a;
                hxVar.s(hxVar.a.j(), this.a.g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx a;

        public b(hx hxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hxVar;
        }

        @Override // com.baidu.tieba.dz.b
        public boolean a(dz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    t16.a(this.a.g.getThreadData().getId());
                    t16.l(this.a.f.getTitle(), this.a.g.getThreadData().getId(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx(Context context) {
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

    @Override // com.baidu.tieba.gx
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i();
            j(1, new b(this));
        }
    }

    @Override // com.baidu.tieba.gx
    public void m(i26<yq4> i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i26Var) == null) {
            super.m(i26Var);
            this.f.setSubClickListener(i26Var);
        }
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void s(View view2, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, cdo) == null) {
            yq4 yq4Var = this.g;
            if (((yq4Var instanceof s26) || (yq4Var instanceof ThreadData)) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (cdo instanceof s26) {
                    s26 s26Var = (s26) this.g;
                    s26Var.f = 1;
                    ThreadCardUtils.jumpToPB((yq4) s26Var, view2.getContext(), s26Var.a.isFromHomPage ? 2 : 1, false);
                    threadCardViewHolder.a().o(new dz.a(1));
                } else if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) this.g;
                    threadData.objType = 1;
                    ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), 3, false);
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wx
    /* renamed from: t */
    public void a(yq4 yq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yq4Var) == null) {
            this.g = yq4Var;
            this.f.a(yq4Var);
        }
    }
}
