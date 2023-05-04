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
import com.baidu.tieba.at8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class bt8 extends at8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt8 a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ bt8 d;

        public a(bt8 bt8Var, jt8 jt8Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt8Var, jt8Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = bt8Var;
            this.a = jt8Var;
            this.b = bVar;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jt8 jt8Var = this.a;
                jt8Var.j(!jt8Var.e());
                bt8 bt8Var = this.d;
                b bVar = this.b;
                bt8Var.h(bVar.d, bVar.e, this.a);
                this.d.f(this.a);
                bt8 bt8Var2 = this.d;
                at8.a aVar = bt8Var2.e;
                if (aVar != null) {
                    aVar.C1(bt8Var2.a);
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

    /* loaded from: classes3.dex */
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0910d4);
            this.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910c7);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910d6);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092019);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0910c8);
            int l = ii.l(TbadkCoreApplication.getInst()) / 5;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l, l);
            this.b.setLayoutParams(layoutParams);
            this.e.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                g35 d = g35.d(this.c);
                d.w(R.color.CAM_X0105);
                d.B(R.dimen.T_X06);
                this.b.setConrers(15);
                this.b.setIsRound(true);
                this.b.setDrawBorder(true);
                this.b.setPlaceHolder(3);
                this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.b.setBorderWidth(ii.g(context, R.dimen.L_X02));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt8(List<jt8> list, Context context) {
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
                view2 = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0575, viewGroup, false);
                bVar = new b(view2);
                view2.setTag(bVar);
            }
            bVar.a(this.c);
            jt8 jt8Var = this.d.get(i);
            if (jt8Var == null) {
                return view2;
            }
            bVar.b.N(jt8Var.b(), 25, false);
            bVar.c.setText(jt8Var.a());
            h(bVar.d, bVar.e, jt8Var);
            view2.setOnClickListener(new a(this, jt8Var, bVar, i));
            if (i == this.d.size() - 1) {
                d(true);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(ImageView imageView, View view2, jt8 jt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, view2, jt8Var) == null) {
            if (jt8Var.e()) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0608).into(view2);
                return;
            }
            SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0601).into(view2);
        }
    }
}
