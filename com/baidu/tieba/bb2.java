package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.tieba.fa3;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bb2 extends fa3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View k;
    public TextView l;
    public SelectorTextView m;
    public c n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public a(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n.k != null) {
                this.a.n.k.onItemClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb2 a;

        public b(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n.j != null) {
                this.a.n.j.onItemClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends fa3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int g;
        public int h;
        public int i;
        public fa3.c j;
        public fa3.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
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
        }

        @Override // com.baidu.tieba.la3.a
        public /* bridge */ /* synthetic */ la3.a U(int i) {
            g0(i);
            return this;
        }

        public c e0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c g0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                super.U(i);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.baidu.tieba.la3.a
        public la3 h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                return new bb2(context);
            }
            return (la3) invokeL.objValue;
        }

        @Override // com.baidu.tieba.la3.a
        public /* bridge */ /* synthetic */ la3.a v(int i) {
            e0(i);
            return this;
        }

        @Override // com.baidu.tieba.fa3.b, com.baidu.tieba.la3.a
        public la3 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                bb2 bb2Var = (bb2) super.c();
                bb2Var.r(this);
                return bb2Var;
            }
            return (la3) invokeV.objValue;
        }

        public c f0(int i, fa3.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, cVar)) == null) {
                this.g = i;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb2(Context context) {
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
    }

    public void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.n = cVar;
        }
    }

    @Override // com.baidu.tieba.fa3
    public View k(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.g).inflate(R.layout.obfuscated_res_0x7f0d00d5, viewGroup, false);
            this.k = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09200f);
            this.l = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060461));
            SelectorTextView selectorTextView = (SelectorTextView) this.k.findViewById(R.id.obfuscated_res_0x7f092010);
            this.m = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060460));
            q();
            return this.k;
        }
        return (View) invokeL.objValue;
    }

    public final void q() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (cVar = this.n) == null) {
            return;
        }
        this.l.setText(this.g.getText(cVar.g));
        this.l.setOnClickListener(new a(this));
        if (this.n.h > 0) {
            this.m.setVisibility(0);
            this.m.setText(this.g.getText(this.n.h));
            this.m.setOnClickListener(new b(this));
        } else {
            this.m.setVisibility(8);
        }
        if (this.n.i > 0) {
            Drawable drawable = this.g.getResources().getDrawable(this.n.i);
            mo3.b(getContext(), drawable);
            drawable.setBounds(0, 0, yo3.f(this.g, 12.0f), yo3.f(this.g, 12.0f));
            this.m.setCompoundDrawables(drawable, null, null, null);
        }
    }
}
