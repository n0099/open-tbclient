package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hk7 extends wo6<ik7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public RelativeLayout m;
    public ConstrainImageGroup n;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d033e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk7(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View h = h();
        this.i = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f0900fa);
        this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090113);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0900af);
        this.n = (ConstrainImageGroup) h.findViewById(R.id.obfuscated_res_0x7f0900c2);
        this.l = h.findViewById(R.id.item_divider);
        this.m = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f090c3b);
        h.setOnClickListener(this);
    }

    public void s(ng<TbImageView> ngVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ngVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setImageViewPool(ngVar);
        }
    }

    public void t(ng<ConstrainImageLayout> ngVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ngVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setConstrainLayoutPool(ngVar);
        }
    }

    public void u(double d) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d)}) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setSingleImageRatio(d);
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.a != i) {
            this.a = i;
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.m, R.drawable.ad_list_item_bg);
            this.n.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: r */
    public void i(ik7 ik7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ik7Var) != null) || ik7Var == null) {
            return;
        }
        this.i.setPlaceHolder(1);
        this.i.N(ik7Var.e(), 10, false);
        this.i.setRadius(yi.g(getContext(), R.dimen.tbds26));
        this.i.setDrawerType(1);
        this.i.setDrawBorder(true);
        this.i.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.i.setBorderWidth(yi.g(getContext(), R.dimen.tbds1));
        this.i.setDefaultResource(R.drawable.transparent_bg);
        this.i.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setText(ik7Var.d());
        this.k.setText(ik7Var.c());
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.m, R.drawable.ad_list_item_bg);
        if (ListUtils.getCount(ik7Var.h()) > 0) {
            b26 b26Var = new b26(3);
            b26Var.d(1.0d);
            this.n.setVisibility(0);
            this.n.setFromCDN(true);
            this.n.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.n.setImageProcessor(b26Var);
            this.n.setImageMediaList(ik7Var.h());
            if (!ik7Var.g()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, yi.g(getContext(), R.dimen.tbds16));
                layoutParams.addRule(12);
                this.l.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            return;
        }
        this.n.setVisibility(8);
        if (!ik7Var.g()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, yi.g(getContext(), R.dimen.tbds1));
            layoutParams2.addRule(12);
            this.l.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
