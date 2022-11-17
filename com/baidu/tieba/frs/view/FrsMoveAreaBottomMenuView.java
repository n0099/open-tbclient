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
import com.baidu.tieba.xi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes4.dex */
public class FrsMoveAreaBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TextView b;
    public TextView c;
    public View d;
    public FrsMoveAreaChooseView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaBottomMenuView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setMoveNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f0747);
            if (i > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
            }
            this.c.setText(string);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaBottomMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d033c, this);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090bd1);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090bd8);
            this.d = findViewById(R.id.obfuscated_res_0x7f090bd9);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            c();
            setClickable(true);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.e;
            if (frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.e.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
            this.e = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.b, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.c, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getTag() instanceof String) {
                d();
            } else if (view2 == this.b) {
                this.e = null;
                xi6.h().n();
            } else if (view2 == this.c) {
                if (this.a != null && this.e == null && !ListUtils.isEmpty(xi6.h().i())) {
                    FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.a);
                    this.e = frsMoveAreaChooseView;
                    frsMoveAreaChooseView.setOnClickListener(this);
                    ((ViewGroup) getParent()).addView(this.e, -1, -1);
                } else if (this.e == null && getContext() != null) {
                    BdTopToast bdTopToast = new BdTopToast(getContext());
                    bdTopToast.h(false);
                    bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0745));
                    bdTopToast.i((ViewGroup) getParent());
                }
            } else {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.e;
                if (frsMoveAreaChooseView2 != null && view2 == frsMoveAreaChooseView2) {
                    d();
                }
            }
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i2)));
            super.setVisibility(i);
        }
    }
}
