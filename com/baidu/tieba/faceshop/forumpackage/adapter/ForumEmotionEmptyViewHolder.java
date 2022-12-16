package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.bh6;
import com.baidu.tieba.ch6;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
import com.baidu.tieba.xg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumEmotionEmptyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumEmotionEmptyView a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;
        public final /* synthetic */ xg6 b;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ch6 ch6Var, xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ch6Var, xg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
            this.b = xg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ch6 ch6Var = this.a;
                ch6Var.c(!ch6Var.b());
                xg6 xg6Var = this.b;
                if (xg6Var != null) {
                    xg6Var.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;
        public final /* synthetic */ xg6 b;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ch6 ch6Var, xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ch6Var, xg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
            this.b = xg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(0);
                xg6 xg6Var = this.b;
                if (xg6Var != null) {
                    xg6Var.a(this.a.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;
        public final /* synthetic */ xg6 b;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, ch6 ch6Var, xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, ch6Var, xg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
            this.b = xg6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c(false);
                this.a.d(1);
                xg6 xg6Var = this.b;
                if (xg6Var != null) {
                    xg6Var.a(this.a.a());
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

    public final void a(ch6 ch6Var, xg6 xg6Var) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ch6Var, xg6Var) == null) {
            ViewGroup filterDropDownView = this.a.getFilterDropDownView();
            if (ch6Var != null) {
                Resources resources = this.a.getResources();
                TextView filterView = this.a.getFilterView();
                filterDropDownView.setVisibility(0);
                if (ch6Var.a() == 0) {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f069c);
                } else {
                    string = resources.getString(R.string.obfuscated_res_0x7f0f069d);
                }
                filterView.setText(string);
                if (ch6Var.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, ch6Var, xg6Var));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, ch6Var, xg6Var));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, ch6Var, xg6Var));
                }
            }
        }
    }

    public void b(bh6 bh6Var, int i, ch6 ch6Var, xg6 xg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh6Var, i, ch6Var, xg6Var) == null) {
            a(ch6Var, xg6Var);
        }
    }
}
