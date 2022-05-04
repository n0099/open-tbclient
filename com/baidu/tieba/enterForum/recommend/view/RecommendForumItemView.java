package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h66;
import com.repackage.lu4;
import com.repackage.ni;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public a i;
    public h66 j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(h66 h66Var);

        void b(h66 h66Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
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
        b(context);
    }

    public final void a(h66 h66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h66Var) == null) || h66Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13374");
        statisticItem.param("obj_type", String.valueOf(h66Var.h));
        statisticItem.param("fid", h66Var.b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d071b, this);
            View rootView = getRootView();
            this.a = rootView.findViewById(R.id.obfuscated_res_0x7f0923bb);
            this.b = rootView.findViewById(R.id.obfuscated_res_0x7f092390);
            this.c = (BarImageView) rootView.findViewById(R.id.obfuscated_res_0x7f090a54);
            this.d = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a6a);
            this.e = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a24);
            this.f = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a92);
            this.g = (TextView) rootView.findViewById(R.id.obfuscated_res_0x7f090a58);
            this.h = (TBSpecificationBtn) rootView.findViewById(R.id.obfuscated_res_0x7f090a5d);
            lu4 lu4Var = new lu4();
            lu4Var.r(R.color.CAM_X0302);
            this.h.setConfig(lu4Var);
            this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029c));
            this.c.setPlaceHolder(1);
            this.c.setOnClickListener(this);
            this.h.setOnClickListener(this);
            rootView.setOnClickListener(this);
        }
    }

    public void c(h66 h66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h66Var) == null) || h66Var == null) {
            return;
        }
        this.j = h66Var;
        this.c.K(h66Var.a, 15, false);
        this.c.setStrokeColorResId(R.color.CAM_X0201);
        this.c.setStrokeWith(3);
        this.c.setShowOval(true);
        String str = h66Var.c;
        if (ni.isEmpty(str)) {
            str = "";
        }
        this.d.setText(str);
        String numFormatOverWan = StringHelper.numFormatOverWan(h66Var.e);
        TextView textView = this.e;
        textView.setText("关注 " + numFormatOverWan);
        String numFormatOverWan2 = StringHelper.numFormatOverWan((long) h66Var.f);
        TextView textView2 = this.f;
        textView2.setText("贴子 " + numFormatOverWan2);
        if (!ni.isEmpty(h66Var.g)) {
            this.g.setText(h66Var.g);
        } else {
            this.g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f47));
        }
        e(h66Var.d);
        DrawableSelector.make().tlRadius(oi.f(getContext(), R.dimen.tbds10)).trRadius(oi.f(getContext(), R.dimen.tbds10)).defaultColor(R.color.CAM_X0901).into(this.a);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(oi.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(oi.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(oi.f(getContext(), R.dimen.tbds5)).into(this.b);
        a(h66Var);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0107);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                lu4 lu4Var = new lu4();
                lu4Var.t(R.color.CAM_X0109);
                this.h.setConfig(lu4Var);
                this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6c));
                this.h.setClickState(false);
            } else {
                lu4 lu4Var2 = new lu4();
                lu4Var2.r(R.color.CAM_X0302);
                this.h.setConfig(lu4Var2);
                this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029c));
                this.h.setClickState(true);
            }
            this.j.d = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.h) {
                h66 h66Var = this.j;
                if (h66Var.d) {
                    this.i.b(h66Var);
                    return;
                } else {
                    this.i.a(h66Var);
                    return;
                }
            }
            this.i.b(this.j);
        }
    }

    public void setForumItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        this.i = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendForumItemView(Context context) {
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
        b(context);
    }
}
