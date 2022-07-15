package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ba6;
import com.repackage.ca6;
import com.repackage.x96;
/* loaded from: classes3.dex */
public class ForumEmotionEmptyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumEmotionEmptyView a;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca6 a;
        public final /* synthetic */ x96 b;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ca6 ca6Var, x96 x96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ca6Var, x96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca6Var;
            this.b = x96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ca6 ca6Var = this.a;
                ca6Var.c(!ca6Var.b());
                x96 x96Var = this.b;
                if (x96Var != null) {
                    x96Var.b();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca6 a;
        public final /* synthetic */ x96 b;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ca6 ca6Var, x96 x96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ca6Var, x96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca6Var;
            this.b = x96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(0);
                x96 x96Var = this.b;
                if (x96Var != null) {
                    x96Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca6 a;
        public final /* synthetic */ x96 b;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ca6 ca6Var, x96 x96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ca6Var, x96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca6Var;
            this.b = x96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(1);
                x96 x96Var = this.b;
                if (x96Var != null) {
                    x96Var.a(this.a.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
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
        this.a = (ForumEmotionEmptyView) view2;
    }

    public final void c(ca6 ca6Var, x96 x96Var) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ca6Var, x96Var) == null) {
            ViewGroup filterDropDownView = this.a.getFilterDropDownView();
            if (ca6Var != null) {
                Resources resources = this.a.getResources();
                TextView filterView = this.a.getFilterView();
                filterDropDownView.setVisibility(0);
                if (ca6Var.a() == 0) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f0669);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f066a);
                }
                filterView.setText(string);
                if (ca6Var.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, ca6Var, x96Var));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, ca6Var, x96Var));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, ca6Var, x96Var));
                }
            }
        }
    }

    public void d(ba6 ba6Var, int i, ca6 ca6Var, x96 x96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ba6Var, i, ca6Var, x96Var) == null) {
            c(ca6Var, x96Var);
        }
    }
}
