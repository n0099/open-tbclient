package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.t0.d1.a;
import c.a.t0.d1.c1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes12.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f43804e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43805f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43806g;

    /* renamed from: h  reason: collision with root package name */
    public View f43807h;

    /* renamed from: i  reason: collision with root package name */
    public FrsMoveAreaChooseView f43808i;

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
            LayoutInflater.from(getContext()).inflate(g1.frs_move_area_bottom_menu_layout, this);
            this.f43805f = (TextView) findViewById(f1.frs_move_area_cancel);
            this.f43806g = (TextView) findViewById(f1.frs_move_area_move);
            this.f43807h = findViewById(f1.frs_move_area_top_line);
            this.f43805f.setOnClickListener(this);
            this.f43806g.setOnClickListener(this);
            onChangeSkinType();
            setClickable(true);
        }
    }

    public boolean isChooseViewShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.f43808i;
            return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, c1.CAM_X0201);
            SkinManager.setViewTextColor(this.f43805f, c1.CAM_X0105);
            SkinManager.setBackgroundResource(this.f43805f, e1.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f43806g, c1.CAM_X0302);
            SkinManager.setBackgroundResource(this.f43806g, e1.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f43807h, c1.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getTag() instanceof String) {
                removeChooseView();
            } else if (view == this.f43805f) {
                this.f43808i = null;
                a.h().n();
            } else if (view == this.f43806g) {
                if (this.f43804e != null && this.f43808i == null && !ListUtils.isEmpty(a.h().i())) {
                    FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.f43804e);
                    this.f43808i = frsMoveAreaChooseView;
                    frsMoveAreaChooseView.setOnClickListener(this);
                    ((ViewGroup) getParent()).addView(this.f43808i, -1, -1);
                } else if (this.f43808i != null || getContext() == null) {
                } else {
                    new BdTopToast(getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(i1.frs_move_area_choose_empty)).show((ViewGroup) getParent());
                }
            } else {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f43808i;
                if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                    return;
                }
                removeChooseView();
            }
        }
    }

    public void removeChooseView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f43808i.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f43808i.getParent()).removeView(this.f43808i);
        this.f43808i = null;
    }

    public void setMoveNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            String string = getContext().getString(i1.frs_move_area_move);
            if (i2 > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
            }
            this.f43806g.setText(string);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f43804e = tbPageContext;
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
