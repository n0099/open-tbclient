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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.tieba.av4;
import com.baidu.tieba.du5;
import com.baidu.tieba.se8;
import com.baidu.tieba.te8;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;
    public TbPageContext c;
    public Context d;

    /* loaded from: classes6.dex */
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
        public av4<se8> j;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ se8 a;
            public final /* synthetic */ b b;

            public a(b bVar, se8 se8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, se8Var};
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
                this.a = se8Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    TopicListUtil.openWebTopicListPage();
                    if (this.b.j != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.j.b(view2, this.a, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0307b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ se8 a;
            public final /* synthetic */ b b;

            public View$OnClickListenerC0307b(b bVar, se8 se8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, se8Var};
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
                this.a = se8Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.a.a));
                    String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.a.b);
                    HotTopicStat.Locate locate = HotTopicStat.Locate.HOT_RANK;
                    if (this.a.a()) {
                        HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
                    }
                    du5.f(this.b.c(), tryFixDefaultValue, tryFixDefaultValue2);
                    if (this.b.j != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.j.b(view2, this.a, adapterPosition, adapterPosition);
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f09121a);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911a0);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09268b);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09248d);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09185e);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09185f);
            this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09185d);
        }

        public void e(av4<se8> av4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, av4Var) == null) {
                this.j = av4Var;
            }
        }

        public void f(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
                this.i = tbPageContext;
            }
        }

        public void b(se8 se8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, se8Var) == null) && se8Var != null) {
                if (se8Var.e) {
                    this.b.setVisibility(8);
                    this.f.setVisibility(0);
                    this.f.setOnClickListener(new a(this, se8Var));
                    return;
                }
                this.b.setVisibility(0);
                this.b.setOnClickListener(new View$OnClickListenerC0307b(this, se8Var));
                this.f.setVisibility(8);
                int i = se8Var.d;
                if (i > 0) {
                    this.c.setText(String.valueOf(i));
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                this.d.setText(se8Var.b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), se8Var.c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.e.setVisibility(8);
                    marginLayoutParams.rightMargin = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds22);
                    this.d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds74);
                    this.d.setLayoutParams(marginLayoutParams);
                    this.e.setVisibility(0);
                    this.e.setText(hotTopicTagStr);
                }
                EMManager.from(this.c).setCorner(R.string.J_X04).setBackGroundColor(TagTextHelper.getIndexTextColorRes(se8Var.d));
                EMManager.from(this.e).setCorner(R.string.J_X04).setAlpha(R.string.A_X12).setBackGroundColor(TagTextHelper.getHotTopicTagColorRes(se8Var.c));
            }
        }

        public TbPageContext c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.i;
            }
            return (TbPageContext) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a != i) {
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
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<se8> a;
        public av4<se8> b;
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<se8> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<se8> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i) == null) && (list = this.a) != null && list.size() > i) {
                se8 se8Var = list.get(i);
                bVar.b(se8Var);
                bVar.d(TbadkCoreApplication.getInst().getSkinType());
                av4<se8> av4Var = this.b;
                if (av4Var != null) {
                    av4Var.d(bVar.itemView, se8Var, i, i);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: n */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d043c, viewGroup, false));
                bVar.e(this.b);
                bVar.f(this.c);
                bVar.d(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void o(av4<se8> av4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, av4Var) == null) {
                this.b = av4Var;
            }
        }

        public void p(@NonNull List<se8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        public void q(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
                this.c = tbPageContext;
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
        b();
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
        b();
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
        b();
    }

    public void a(te8 te8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, te8Var) == null) && te8Var != null && te8Var.c() != null) {
            this.b.p(te8Var.c());
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a != i) {
            this.b.notifyDataSetChanged();
            this.a = i;
        }
    }

    public void setOnItemCoverListener(av4<se8> av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, av4Var) == null) {
            this.b.o(av4Var);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.c = tbPageContext;
            a aVar = this.b;
            if (aVar != null) {
                aVar.q(tbPageContext);
            }
        }
    }

    public final void b() {
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
            aVar.q(this.c);
            setAdapter(this.b);
        }
    }

    public TbPageContext getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (TbPageContext) invokeV.objValue;
    }
}
