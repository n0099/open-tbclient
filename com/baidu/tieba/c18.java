package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.itemtab.card.CardItemDetailListItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c18 extends os<j18> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public EMTextView g;
    public ArrayList<o18> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c18(Context context) {
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
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f == null) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01d5, (ViewGroup) null, true);
                this.f = inflate;
                this.g = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091227);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            EMManager.from(this.f).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.g).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            for (int i2 = 0; i2 < ((ViewGroup) this.f).getChildCount(); i2++) {
                if (((ViewGroup) this.f).getChildAt(i2) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.f).getChildAt(i2)).d();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: r */
    public void onBindDataToView(j18 j18Var) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, j18Var) == null) && j18Var != null && j18Var.d()) {
            ArrayList<o18> c = j18Var.c();
            if (ListUtils.getCount(c) != ListUtils.getCount(this.h)) {
                if (ListUtils.getCount(this.h) > 0) {
                    ((ViewGroup) this.f).removeViews(1, ListUtils.getCount(this.h));
                }
                z = true;
            } else {
                z = false;
            }
            if (c != null) {
                for (int i = 0; i < c.size(); i++) {
                    if (z) {
                        childAt = new CardItemDetailListItemLayout(this.b);
                        ((ViewGroup) this.f).addView(childAt, -1, -2);
                    } else {
                        childAt = ((ViewGroup) this.f).getChildAt(i + 1);
                    }
                    if (childAt instanceof CardItemDetailListItemLayout) {
                        ((CardItemDetailListItemLayout) childAt).setData(c.get(i));
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) this.f;
            int childCount = viewGroup.getChildCount() - 1;
            while (true) {
                if (childCount <= 0) {
                    break;
                }
                if ((viewGroup.getChildAt(childCount) instanceof CardItemDetailListItemLayout) && viewGroup.getChildAt(childCount).getVisibility() == 0) {
                    ((CardItemDetailListItemLayout) viewGroup.getChildAt(childCount)).setDividerVisible(false);
                    break;
                }
                childCount--;
            }
            this.h = c;
        }
    }
}
