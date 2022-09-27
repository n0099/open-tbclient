package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.qp4;
import com.baidu.tieba.vh5;
import com.baidu.tieba.wz6;
import com.baidu.tieba.xz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;
    public TbPageContext c;
    public Context d;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<wz6> a;
        public qp4<wz6> b;
        public TbPageContext c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<wz6> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i) == null) || (list = this.a) == null || list.size() <= i) {
                return;
            }
            wz6 wz6Var = list.get(i);
            bVar.b(wz6Var);
            bVar.d(TbadkCoreApplication.getInst().getSkinType());
            qp4<wz6> qp4Var = this.b;
            if (qp4Var != null) {
                qp4Var.d(bVar.itemView, wz6Var, i, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b2, viewGroup, false));
                bVar.e(this.b);
                bVar.f(this.c);
                bVar.d(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void f(qp4<wz6> qp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qp4Var) == null) {
                this.b = qp4Var;
            }
        }

        public void g(@NonNull List<wz6> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<wz6> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public void h(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
                this.c = tbPageContext;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;
        public TextView e;
        public View f;
        public TextView g;
        public ImageView h;
        public TbPageContext i;
        public qp4<wz6> j;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wz6 a;
            public final /* synthetic */ b b;

            public a(b bVar, wz6 wz6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, wz6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = wz6Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all").start();
                    if (this.b.j != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.j.c(view2, this.a, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0274b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wz6 a;
            public final /* synthetic */ b b;

            public View$OnClickListenerC0274b(b bVar, wz6 wz6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, wz6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = wz6Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.a.a));
                    String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.a.b);
                    HotTopicStat.Locate locate = HotTopicStat.Locate.HOT_RANK;
                    if (this.a.b()) {
                        HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
                    }
                    if (NewWebHotTopicPageSwitch.isOn()) {
                        vh5.e(this.b.c(), tryFixDefaultValue, tryFixDefaultValue2);
                    } else {
                        new HotTopicActivityConfig(view2.getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.a.a()), "3", locate).start();
                    }
                    if (this.b.j != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.j.c(view2, this.a, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090f8f);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f22);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09221e);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092033);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f091555);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091556);
            this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091554);
        }

        public void b(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, wz6Var) == null) || wz6Var == null) {
                return;
            }
            if (wz6Var.e) {
                this.b.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setOnClickListener(new a(this, wz6Var));
                return;
            }
            this.b.setVisibility(0);
            this.b.setOnClickListener(new View$OnClickListenerC0274b(this, wz6Var));
            this.f.setVisibility(8);
            int i = wz6Var.d;
            if (i > 0) {
                this.c.setText(String.valueOf(i));
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            this.d.setText(wz6Var.b);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), wz6Var.c);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.e.setVisibility(8);
                marginLayoutParams.rightMargin = ej.f(this.e.getContext(), R.dimen.tbds22);
                this.d.setLayoutParams(marginLayoutParams);
            } else {
                marginLayoutParams.rightMargin = ej.f(this.e.getContext(), R.dimen.tbds74);
                this.d.setLayoutParams(marginLayoutParams);
                this.e.setVisibility(0);
                this.e.setText(hotTopicTagStr);
            }
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(wz6Var.d);
            hv4 d = hv4.d(this.c);
            d.n(R.string.J_X04);
            d.f(indexTextColorRes);
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(wz6Var.c);
            hv4 d2 = hv4.d(this.e);
            d2.n(R.string.J_X04);
            d2.e(R.string.A_X12);
            d2.f(hotTopicTagColorRes);
        }

        public TbPageContext c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i : (TbPageContext) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
                return;
            }
            TBSelector.setViewBackgroundColorWithPressedState(this.b, R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.setViewBackgroundColorWithPressedState(this.f, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            if (this.f.getVisibility() == 0) {
                SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0304);
                int color = SkinManager.getColor(R.color.CAM_X0304);
                Drawable drawable = this.h.getDrawable();
                DrawableCompat.setTint(drawable, color);
                this.h.setImageDrawable(drawable);
            }
            this.a = i;
        }

        public void e(qp4<wz6> qp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, qp4Var) == null) {
                this.j = qp4Var;
            }
        }

        public void f(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
                this.i = tbPageContext;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context) {
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
        this.a = 3;
        this.d = context;
        c();
    }

    public void b(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xz6Var) == null) || xz6Var == null || xz6Var.c() == null) {
            return;
        }
        this.b.g(xz6Var.c());
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = this.d;
            if (context instanceof TbPageContextSupport) {
                this.c = ((TbPageContextSupport) context).getPageContext();
            }
            setLayoutManager(new GridLayoutManager(getContext(), 2));
            setOverScrollMode(2);
            a aVar = new a();
            this.b = aVar;
            aVar.h(this.c);
            setAdapter(this.b);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
            return;
        }
        this.b.notifyDataSetChanged();
        this.a = i;
    }

    public TbPageContext getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (TbPageContext) invokeV.objValue;
    }

    public void setOnItemCoverListener(qp4<wz6> qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qp4Var) == null) {
            this.b.f(qp4Var);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.c = tbPageContext;
            a aVar = this.b;
            if (aVar != null) {
                aVar.h(tbPageContext);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        c();
    }
}
