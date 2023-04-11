package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class fa7 extends um<la7, ForumRuleDetailItemVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbRichText b;
    public List<hn> c;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fa7 b;

        public a(fa7 fa7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fa7Var;
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.b.c != null) {
                    hn hnVar = (hn) this.b.c.get(this.a);
                    if (hnVar instanceof la7) {
                        yh.a(TbRichTextView.c0(((la7) hnVar).b(), false).toString());
                        ii.P(this.b.a, R.string.obfuscated_res_0x7f0f070d);
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: u */
    public ForumRuleDetailItemVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.a, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02dc, viewGroup, false));
            this.viewholder = forumRuleDetailItemVH;
            return forumRuleDetailItemVH;
        }
        return (ForumRuleDetailItemVH) invokeL.objValue;
    }

    public void y(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.c = list;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.um
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, la7 la7Var, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        x(i, view2, viewGroup, la7Var, forumRuleDetailItemVH);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, la7 la7Var, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, la7Var, forumRuleDetailItemVH})) == null) {
            if (la7Var != null && this.a != null) {
                forumRuleDetailItemVH.c(la7Var.a());
                if (!StringUtils.isNull(la7Var.c())) {
                    z = true;
                    forumRuleDetailItemVH.c.setVisibility(0);
                    forumRuleDetailItemVH.c.setText(la7Var.c());
                } else {
                    forumRuleDetailItemVH.c.setVisibility(8);
                    z = false;
                }
                if (la7Var.b() != null && !StringUtils.isNull(la7Var.b().toString())) {
                    forumRuleDetailItemVH.d.setVisibility(0);
                    if (!z) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.d.getLayoutParams();
                        layoutParams.topMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                        forumRuleDetailItemVH.d.setLayoutParams(layoutParams);
                    }
                    TbRichText c0 = TbRichTextView.c0(la7Var.b(), false);
                    this.b = c0;
                    forumRuleDetailItemVH.d.setText(c0);
                } else {
                    forumRuleDetailItemVH.d.setVisibility(8);
                }
                forumRuleDetailItemVH.d.setOnLongClickListener(new a(this, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
