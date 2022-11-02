package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class hi6 extends z26<di6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WrapLineLayout i;
    public List<a> j;
    public int k;

    @Override // com.baidu.tieba.z26
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d02c8 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public ImageView c;
        public final /* synthetic */ hi6 d;

        /* renamed from: com.baidu.tieba.hi6$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnLongClickListenerC0288a implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnLongClickListenerC0288a(a aVar, hi6 hi6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hi6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                    for (a aVar : this.a.d.j) {
                        if (aVar != null && aVar.b() != view2) {
                            aVar.d(false);
                        }
                    }
                    this.a.d(true);
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar, hi6 hi6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hi6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b.getText() != null && !StringUtils.isNull(this.a.b.getText().toString())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, this.a.b.getText().toString()));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar, hi6 hi6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hi6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b.getText() == null) {
                    return;
                }
                ci6.b(this.a.b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a(hi6 hi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hi6Var;
            View inflate = LayoutInflater.from(hi6Var.g().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02c9, (ViewGroup) null);
            this.a = inflate;
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906fa);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0907a0);
            c();
            this.b.setOnLongClickListener(new View$OnLongClickListenerC0288a(this, hi6Var));
            this.b.setOnClickListener(new b(this, hi6Var));
            this.c.setOnClickListener(new c(this, hi6Var));
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.c.setVisibility(0);
                    SkinManager.setImageResource(this.c, R.drawable.del_search_btn);
                    return;
                }
                this.c.setVisibility(4);
            }
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.b, R.drawable.search_history_item_bg);
                SkinManager.setImageResource(this.c, R.drawable.del_search_btn);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hi6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.k = 3;
        this.i = (WrapLineLayout) k();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z26
    /* renamed from: u */
    public void l(di6 di6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, di6Var) == null) && di6Var != null && !ListUtils.isEmpty(di6Var.c())) {
            t(di6Var.c().size());
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                a aVar = this.j.get(i);
                if (aVar != null) {
                    aVar.d(false);
                    aVar.b.setText(di6Var.c().get(i));
                }
            }
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || this.k == i) {
            return;
        }
        for (a aVar : this.j) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.k = i;
    }

    public final a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new a(this);
        }
        return (a) invokeV.objValue;
    }

    public final void t(int i) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (size = this.j.size()) == i) {
            return;
        }
        int i2 = 0;
        if (size < i) {
            int i3 = i - size;
            while (i2 < i3) {
                a s = s();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d4);
                marginLayoutParams.topMargin = g;
                marginLayoutParams.leftMargin = g;
                this.i.addView(s.b(), marginLayoutParams);
                this.j.add(s);
                i2++;
            }
        } else if (i == 0) {
            this.i.removeAllViews();
            this.j.clear();
        } else if (size > i) {
            int i4 = size - i;
            while (i2 < i4) {
                this.i.removeView(this.j.get(i2).b());
                this.j.remove(i2);
                i2++;
            }
        }
    }
}
