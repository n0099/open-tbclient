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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.du6;
import com.repackage.eu6;
import com.repackage.kl4;
import com.repackage.li;
import com.repackage.wq4;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<du6> a;
        public kl4<du6> b;

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
            List<du6> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i) == null) || (list = this.a) == null || list.size() <= i) {
                return;
            }
            du6 du6Var = list.get(i);
            bVar.b(du6Var);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            kl4<du6> kl4Var = this.b;
            if (kl4Var != null) {
                kl4Var.c(bVar.itemView, du6Var, i, i);
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
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ab, viewGroup, false));
                bVar.d(this.b);
                bVar.c(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void f(kl4<du6> kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kl4Var) == null) {
                this.b = kl4Var;
            }
        }

        public void g(@NonNull List<du6> list) {
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
                List<du6> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
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
        public kl4<du6> i;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ du6 a;
            public final /* synthetic */ b b;

            public a(b bVar, du6 du6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, du6Var};
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
                this.a = du6Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all").start();
                    if (this.b.i != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.i.a(view2, this.a, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0192b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ du6 a;
            public final /* synthetic */ b b;

            public View$OnClickListenerC0192b(b bVar, du6 du6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, du6Var};
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
                this.a = du6Var;
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
                    new HotTopicActivityConfig(view2.getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.a.a()), "3", locate).start();
                    if (this.b.i != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.i.a(view2, this.a, adapterPosition, adapterPosition);
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090f29);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ebf);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09201e);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e4b);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09140b);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09140c);
            this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09140a);
        }

        public void b(du6 du6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, du6Var) == null) || du6Var == null) {
                return;
            }
            if (du6Var.e) {
                this.b.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setOnClickListener(new a(this, du6Var));
                return;
            }
            this.b.setVisibility(0);
            this.b.setOnClickListener(new View$OnClickListenerC0192b(this, du6Var));
            this.f.setVisibility(8);
            int i = du6Var.d;
            if (i > 0) {
                this.c.setText(String.valueOf(i));
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            this.d.setText(du6Var.b);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), du6Var.c);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.e.setVisibility(8);
                marginLayoutParams.rightMargin = li.f(this.e.getContext(), R.dimen.tbds22);
                this.d.setLayoutParams(marginLayoutParams);
            } else {
                marginLayoutParams.rightMargin = li.f(this.e.getContext(), R.dimen.tbds74);
                this.d.setLayoutParams(marginLayoutParams);
                this.e.setVisibility(0);
                this.e.setText(hotTopicTagStr);
            }
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(du6Var.d);
            wq4 d = wq4.d(this.c);
            d.n(R.string.J_X04);
            d.f(indexTextColorRes);
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(du6Var.c);
            wq4 d2 = wq4.d(this.e);
            d2.n(R.string.J_X04);
            d2.e(R.string.A_X12);
            d2.f(hotTopicTagColorRes);
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == i) {
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

        public void d(kl4<du6> kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kl4Var) == null) {
                this.i = kl4Var;
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
        c();
    }

    public void b(eu6 eu6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eu6Var) == null) || eu6Var == null || eu6Var.e() == null) {
            return;
        }
        this.b.g(eu6Var.e());
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutManager(new GridLayoutManager(getContext(), 2));
            setOverScrollMode(2);
            a aVar = new a();
            this.b = aVar;
            setAdapter(aVar);
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

    public void setOnItemCoverListener(kl4<du6> kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kl4Var) == null) {
            this.b.f(kl4Var);
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
