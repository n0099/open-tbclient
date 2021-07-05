package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.a;
import java.util.Locale;
/* loaded from: classes5.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16126e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16127f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16128g;

    /* renamed from: h  reason: collision with root package name */
    public View f16129h;

    /* renamed from: i  reason: collision with root package name */
    public FrsMoveAreaChooseView f16130i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaBottomMenuView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_bottom_menu_layout, this);
            this.f16127f = (TextView) findViewById(R.id.frs_move_area_cancel);
            this.f16128g = (TextView) findViewById(R.id.frs_move_area_move);
            this.f16129h = findViewById(R.id.frs_move_area_top_line);
            this.f16127f.setOnClickListener(this);
            this.f16128g.setOnClickListener(this);
            c();
            setClickable(true);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.f16130i;
            return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f16127f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f16127f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16128g, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f16128g, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f16129h, R.color.CAM_X0204);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f16130i.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f16130i.getParent()).removeView(this.f16130i);
        this.f16130i = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getTag() instanceof String) {
                d();
            } else if (view == this.f16127f) {
                this.f16130i = null;
                a.h().n();
            } else if (view == this.f16128g) {
                if (this.f16126e != null && this.f16130i == null && !ListUtils.isEmpty(a.h().i())) {
                    FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.f16126e);
                    this.f16130i = frsMoveAreaChooseView;
                    frsMoveAreaChooseView.setOnClickListener(this);
                    ((ViewGroup) getParent()).addView(this.f16130i, -1, -1);
                } else if (this.f16130i != null || getContext() == null) {
                } else {
                    BdTopToast bdTopToast = new BdTopToast(getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty));
                    bdTopToast.j((ViewGroup) getParent());
                }
            } else {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f16130i;
                if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                    return;
                }
                d();
            }
        }
    }

    public void setMoveNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            String string = getContext().getString(R.string.frs_move_area_move);
            if (i2 > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
            }
            this.f16128g.setText(string);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f16126e = tbPageContext;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i2 == 0 ? 0 : 1)));
            super.setVisibility(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
