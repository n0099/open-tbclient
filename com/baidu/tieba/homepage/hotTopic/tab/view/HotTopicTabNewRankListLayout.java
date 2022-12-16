package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.lq4;
import com.baidu.tieba.rw4;
import com.baidu.tieba.y27;
import com.baidu.tieba.yi;
import com.baidu.tieba.yj5;
import com.baidu.tieba.z27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabNewRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TbPageContext g;
        public lq4<y27> h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y27 a;
            public final /* synthetic */ b b;

            public a(b bVar, y27 y27Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, y27Var};
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
                this.a = y27Var;
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
                        yj5.e(this.b.c(), tryFixDefaultValue, tryFixDefaultValue2);
                    } else {
                        new HotTopicActivityConfig(view2.getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.a.a()), "3", locate).start();
                    }
                    if (this.b.h != null) {
                        int adapterPosition = this.b.getAdapterPosition();
                        this.b.h.c(view2, this.a, adapterPosition, adapterPosition);
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f09101b);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fae);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922da);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920f9);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e3d);
        }

        public void e(lq4<y27> lq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, lq4Var) == null) {
                this.h = lq4Var;
            }
        }

        public void f(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
                this.g = tbPageContext;
            }
        }

        public void b(y27 y27Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, y27Var) == null) && y27Var != null) {
                this.b.setVisibility(0);
                this.b.setOnClickListener(new a(this, y27Var));
                int i = y27Var.d;
                if (i > 0) {
                    this.c.setText(String.valueOf(i));
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                this.d.setText(y27Var.b);
                this.f.setText(StringHelper.numberUniformOver1000Wan(y27Var.g));
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), y27Var.c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.e.setVisibility(8);
                    marginLayoutParams.rightMargin = yi.g(this.e.getContext(), R.dimen.tbds198);
                    this.d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = yi.g(this.e.getContext(), R.dimen.tbds250);
                    this.d.setLayoutParams(marginLayoutParams);
                    this.e.setVisibility(0);
                    this.e.setText(hotTopicTagStr);
                }
                int indexTextColorRes = TagTextHelper.getIndexTextColorRes(y27Var.d);
                rw4 d = rw4.d(this.c);
                d.n(R.string.J_X04);
                d.f(indexTextColorRes);
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(y27Var.c);
                rw4 d2 = rw4.d(this.e);
                d2.n(R.string.J_X04);
                d2.e(R.string.A_X12);
                d2.f(hotTopicTagColorRes);
            }
        }

        public TbPageContext c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.g;
            }
            return (TbPageContext) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a != i) {
                TBSelector.setViewBackgroundColorWithPressedState(this.b, R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
                this.a = i;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<y27> a;
        public lq4<y27> b;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<y27> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<y27> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, bVar, i) == null) && (list = this.a) != null && list.size() > i) {
                y27 y27Var = list.get(i);
                bVar.b(y27Var);
                bVar.d(TbadkCoreApplication.getInst().getSkinType());
                lq4<y27> lq4Var = this.b;
                if (lq4Var != null) {
                    lq4Var.d(bVar.itemView, y27Var, i, i);
                }
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
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03c3, viewGroup, false));
                bVar.e(this.b);
                bVar.f(this.c);
                bVar.d(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void f(lq4<y27> lq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq4Var) == null) {
                this.b = lq4Var;
            }
        }

        public void g(@NonNull List<y27> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        public void h(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
                this.c = tbPageContext;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabNewRankListLayout(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabNewRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
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
    public HotTopicTabNewRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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

    public void b(z27 z27Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, z27Var) == null) && z27Var != null && z27Var.c() != null) {
            this.b.g(z27Var.c());
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a != i) {
            this.b.notifyDataSetChanged();
            this.a = i;
        }
    }

    public void setOnItemCoverListener(lq4<y27> lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lq4Var) == null) {
            this.b.f(lq4Var);
        }
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) && (aVar = this.b) != null) {
            aVar.h(tbPageContext);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutManager(new LinearLayoutManager(getContext()));
            setOverScrollMode(2);
            a aVar = new a();
            this.b = aVar;
            setAdapter(aVar);
        }
    }
}
