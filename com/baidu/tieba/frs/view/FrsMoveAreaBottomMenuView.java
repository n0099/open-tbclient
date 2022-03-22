package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.p0.f1.a;
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
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32944b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32945c;

    /* renamed from: d  reason: collision with root package name */
    public View f32946d;

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f32947e;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0341, this);
            this.f32944b = (TextView) findViewById(R.id.obfuscated_res_0x7f090b89);
            this.f32945c = (TextView) findViewById(R.id.obfuscated_res_0x7f090b90);
            this.f32946d = findViewById(R.id.obfuscated_res_0x7f090b91);
            this.f32944b.setOnClickListener(this);
            this.f32945c.setOnClickListener(this);
            c();
            setClickable(true);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.f32947e;
            return frsMoveAreaChooseView != null && frsMoveAreaChooseView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f32944b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f32944b, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f32945c, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f32945c, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f32946d, R.color.CAM_X0204);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f32947e.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f32947e.getParent()).removeView(this.f32947e);
        this.f32947e = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view.getTag() instanceof String) {
                d();
            } else if (view == this.f32944b) {
                this.f32947e = null;
                a.h().n();
            } else if (view == this.f32945c) {
                if (this.a != null && this.f32947e == null && !ListUtils.isEmpty(a.h().i())) {
                    FrsMoveAreaChooseView frsMoveAreaChooseView = new FrsMoveAreaChooseView(this.a);
                    this.f32947e = frsMoveAreaChooseView;
                    frsMoveAreaChooseView.setOnClickListener(this);
                    ((ViewGroup) getParent()).addView(this.f32947e, -1, -1);
                } else if (this.f32947e != null || getContext() == null) {
                } else {
                    BdTopToast bdTopToast = new BdTopToast(getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0702));
                    bdTopToast.j((ViewGroup) getParent());
                }
            } else {
                FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f32947e;
                if (frsMoveAreaChooseView2 == null || view != frsMoveAreaChooseView2) {
                    return;
                }
                d();
            }
        }
    }

    public void setMoveNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f0704);
            if (i > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
            }
            this.f32945c.setText(string);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, Integer.valueOf(i == 0 ? 0 : 1)));
            super.setVisibility(i);
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
}
