package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.oy;
import com.baidu.tieba.pw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ex extends ww {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGridImageLayout h;
    public jw4 i;
    public int j;
    public String k;
    public int l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex a;

        public a(ex exVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = exVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ex exVar;
            pw.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (exVar = this.a).e) != null) {
                aVar.a(exVar.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex a;

        public b(ex exVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = exVar;
        }

        @Override // com.baidu.tieba.oy.b
        public boolean a(oy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.i != null && this.a.i.getThreadData() != null && !this.a.j().booleanValue()) {
                    jg6.a(this.a.i.getThreadData().getId());
                    jg6.l(this.a.h.b, this.a.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    jg6.l(this.a.h.c, this.a.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex(Context context) {
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
        this.j = 3;
        this.h = new NewGridImageLayout(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hx
    /* renamed from: y */
    public void a(jw4 jw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jw4Var) == null) {
            this.i = jw4Var;
            this.h.setFrom(this.k);
            this.h.setFromForPb(this.l);
            this.h.setTransmit(j().booleanValue());
            this.h.a(jw4Var);
            this.h.setJumpToPbListener(new a(this));
        }
    }

    public void A(int i) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (newGridImageLayout = this.h) != null) {
            newGridImageLayout.setCornerStyle(i);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.k = str;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.h.setFromCDN(z);
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.l = i;
        }
    }

    public void E(pw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h.setNeedFrsTabName(z);
        }
    }

    public void H(boolean z) {
        NewGridImageLayout newGridImageLayout;
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (newGridImageLayout = this.h) != null && (gridImageLayout = newGridImageLayout.f) != null) {
            gridImageLayout.setIsTransform(z);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.h.n = z;
        }
    }

    @Override // com.baidu.tieba.pw
    public void p(xg6<jw4> xg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, xg6Var) == null) {
            this.h.setSubClickListener(xg6Var);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h.setBackgroundColor(i);
        }
    }

    public void G(xf<ImageView> xfVar, xf<GifView> xfVar2) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, xfVar, xfVar2) == null) && (newGridImageLayout = this.h) != null) {
            newGridImageLayout.setObjectPool(xfVar, xfVar2);
        }
    }

    @Override // com.baidu.tieba.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i) == null) {
            if (this.j != i && j().booleanValue()) {
                SkinManager.setBackgroundColor(this.h, R.color.CAM_X0206);
            }
            NewGridImageLayout newGridImageLayout = this.h;
            if (newGridImageLayout != null) {
                newGridImageLayout.r(i);
            }
            this.j = i;
        }
    }

    public void I(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) && j().booleanValue()) {
            this.h.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.pw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pw
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(1, new b(this));
        }
    }
}
