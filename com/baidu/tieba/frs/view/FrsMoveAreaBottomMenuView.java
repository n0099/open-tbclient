package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.d1.a;
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
import java.util.Locale;
/* loaded from: classes5.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f42479e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42480f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42481g;

    /* renamed from: h  reason: collision with root package name */
    public View f42482h;

    /* renamed from: i  reason: collision with root package name */
    public FrsMoveAreaChooseView f42483i;

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
            this.f42480f = (TextView) findViewById(R.id.frs_move_area_cancel);
            this.f42481g = (TextView) findViewById(R.id.frs_move_area_move);
            this.f42482h = findViewById(R.id.frs_move_area_top_line);
            this.f42480f.setOnClickListener(this);
            this.f42481g.setOnClickListener(this);
            onChangeSkinType();
            setClickable(true);
        }
    }

    public boolean isChooseViewShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.f42483i;
            return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f42480f, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f42480f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f42481g, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f42481g, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f42482h, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getTag() instanceof String) {
                removeChooseView();
            } else if (view == this.f42480f) {
                this.f42483i = null;
                a.h().n();
            } else if (view == this.f42481g) {
                if (this.f42479e != null && this.f42483i == null && !ListUtils.isEmpty(a.h().i())) {
                    FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.f42479e);
                    this.f42483i = frsMoveAreaChooseView;
                    frsMoveAreaChooseView.setOnClickListener(this);
                    ((ViewGroup) getParent()).addView(this.f42483i, -1, -1);
                } else if (this.f42483i != null || getContext() == null) {
                } else {
                    new BdTopToast(getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_choose_empty)).show((ViewGroup) getParent());
                }
            } else {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f42483i;
                if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                    return;
                }
                removeChooseView();
            }
        }
    }

    public void removeChooseView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f42483i.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f42483i.getParent()).removeView(this.f42483i);
        this.f42483i = null;
    }

    public void setMoveNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            String string = getContext().getString(R.string.frs_move_area_move);
            if (i2 > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
            }
            this.f42481g.setText(string);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f42479e = tbPageContext;
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
