package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.gc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hc9 extends gc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc9 a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ hc9 d;

        public a(hc9 hc9Var, pc9 pc9Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc9Var, pc9Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hc9Var;
            this.a = pc9Var;
            this.b = bVar;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pc9 pc9Var = this.a;
                pc9Var.j(!pc9Var.e());
                hc9 hc9Var = this.d;
                b bVar = this.b;
                hc9Var.h(bVar.d, bVar.e, this.a);
                this.d.f(this.a);
                hc9 hc9Var2 = this.d;
                gc9.a aVar = hc9Var2.e;
                if (aVar != null) {
                    aVar.E1(hc9Var2.a);
                }
                if (this.a.e()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.c);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public HeadImageView b;
        public TextView c;
        public ImageView d;
        public View e;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091142);
            this.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091138);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091144);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092141);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f091139);
            int l = yi.l(TbadkCoreApplication.getInst()) / 5;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l, l);
            this.b.setLayoutParams(layoutParams);
            this.e.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                d85 d = d85.d(this.c);
                d.x(R.color.CAM_X0105);
                d.C(R.dimen.T_X06);
                this.b.setConrers(15);
                this.b.setIsRound(true);
                this.b.setDrawBorder(true);
                this.b.setPlaceHolder(3);
                this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.b.setBorderWidth(yi.g(context, R.dimen.L_X02));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc9(List<pc9> list, Context context) {
        super(list, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((List) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
            if (view2 != null && b()) {
                bVar = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d05ad, viewGroup, false);
                bVar = new b(view2);
                view2.setTag(bVar);
            }
            bVar.a(this.c);
            pc9 pc9Var = this.d.get(i);
            if (pc9Var == null) {
                return view2;
            }
            bVar.b.N(pc9Var.b(), 25, false);
            bVar.c.setText(pc9Var.a());
            h(bVar.d, bVar.e, pc9Var);
            view2.setOnClickListener(new a(this, pc9Var, bVar, i));
            if (i == this.d.size() - 1) {
                d(true);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(ImageView imageView, View view2, pc9 pc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, view2, pc9Var) == null) {
            if (pc9Var.e()) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0608).into(view2);
                return;
            }
            SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0601).into(view2);
        }
    }
}
