package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.personCenter.view.PersonOftenFuncItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bv9 extends no6<ju9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public LinearLayout j;
    public TextView k;
    public PersonOftenFuncItemView l;
    public PersonOftenFuncItemView m;

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e3 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv9(TbPageContext<?> tbPageContext) {
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
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        h.setPadding(dimens, 0, dimens, 0);
        this.i = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091a03);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091bdb);
        this.j = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091bdc);
        j(g(), this.a);
    }

    @Override // com.baidu.tieba.no6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            EMManager.from(this.i).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.k).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.j).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            int childCount = this.j.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.j.getChildAt(i2);
                if (childAt instanceof LinearLayout) {
                    int i3 = 0;
                    while (true) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        if (i3 < linearLayout.getChildCount()) {
                            View childAt2 = linearLayout.getChildAt(i3);
                            if (childAt2 instanceof PersonOftenFuncItemView) {
                                PersonOftenFuncItemView personOftenFuncItemView = (PersonOftenFuncItemView) childAt2;
                                SkinManager.setBackgroundColor(personOftenFuncItemView, R.color.CAM_X0205);
                                SkinManager.setViewTextColor(personOftenFuncItemView.b, (int) R.color.CAM_X0105);
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    public void onScroll() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PersonOftenFuncItemView personOftenFuncItemView = this.l;
            boolean z2 = true;
            if (personOftenFuncItemView != null) {
                if (!personOftenFuncItemView.d && !TbSingleton.getInstance().isMyTabClicked()) {
                    z = false;
                } else {
                    z = true;
                }
                personOftenFuncItemView.d = z;
                this.l.d();
            }
            PersonOftenFuncItemView personOftenFuncItemView2 = this.m;
            if (personOftenFuncItemView2 != null) {
                if (!personOftenFuncItemView2.d && !TbSingleton.getInstance().isMyTabClicked()) {
                    z2 = false;
                }
                personOftenFuncItemView2.d = z2;
                this.m.d();
            }
            TbSingleton.getInstance().setMyTabClicked(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.no6
    /* renamed from: r */
    public void i(ju9 ju9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ju9Var) == null) {
            if (ju9Var != null && ju9Var.c() != null && !ListUtils.isEmpty(ju9Var.c())) {
                this.j.removeAllViews();
                List<gu9> c = ju9Var.c();
                LinearLayout linearLayout = new LinearLayout(getContext());
                int i = 0;
                for (gu9 gu9Var : c) {
                    i++;
                    if (i % 4 == 1) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                        LinearLayout linearLayout2 = new LinearLayout(getContext());
                        linearLayout2.setOrientation(0);
                        linearLayout2.setLayoutParams(layoutParams);
                        this.j.addView(linearLayout2);
                        linearLayout = linearLayout2;
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                    PersonOftenFuncItemView personOftenFuncItemView = new PersonOftenFuncItemView(getContext());
                    personOftenFuncItemView.a(gu9Var);
                    personOftenFuncItemView.setLayoutParams(layoutParams2);
                    linearLayout.addView(personOftenFuncItemView);
                    int i2 = gu9Var.a;
                    if (i2 == 59) {
                        this.l = personOftenFuncItemView;
                    } else if (i2 == 63) {
                        this.m = personOftenFuncItemView;
                    }
                }
                if (c.size() != 0 && c.size() % 4 != 0) {
                    for (int i3 = 0; i3 < 4 - (c.size() % 4); i3++) {
                        PersonOftenFuncItemView personOftenFuncItemView2 = new PersonOftenFuncItemView(getContext());
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
                        layoutParams3.weight = 1.0f;
                        personOftenFuncItemView2.setLayoutParams(layoutParams3);
                        linearLayout.addView(personOftenFuncItemView2);
                    }
                }
                j(g(), this.a);
                return;
            }
            q(8);
        }
    }
}
