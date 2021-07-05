package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.m.a;
/* loaded from: classes5.dex */
public class ConcernNotLoginLayout extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f16483e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16484f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16485g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f16486h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernNotLoginLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.concern_not_login_layout, (ViewGroup) this, true);
            this.f16483e = context;
            this.f16484f = (ImageView) inflate.findViewById(R.id.iv_concern_not_login_emotion_pic);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_concern_you_not_login);
            this.f16485g = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X06));
            this.f16486h = (TBSpecificationBtn) inflate.findViewById(R.id.tv_concern_login_and_see_more);
            a aVar = new a();
            this.f16486h.setText(context.getResources().getString(R.string.concern_login_and_see_more));
            this.f16486h.setTextSize(R.dimen.T_X05);
            this.f16486h.setTextHorizontalCenter(true);
            this.f16486h.setConfig(aVar);
            this.f16486h.setOnClickListener(this);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setImageResource(this.f16484f, R.drawable.new_pic_emotion_09);
            SkinManager.setViewTextColor(this.f16485g, R.color.CAM_X0107);
            TBSpecificationBtn tBSpecificationBtn = this.f16486h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view.getId() == R.id.tv_concern_login_and_see_more) {
            ViewHelper.checkUpIsLogin(this.f16483e);
            HomePageStatic.f16400a = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernNotLoginLayout(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
