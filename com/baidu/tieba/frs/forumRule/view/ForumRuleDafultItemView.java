package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.h1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ForumRuleDafultItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48526e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumRuleDafultItemView(Context context) {
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

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            EMTextView eMTextView = new EMTextView(this.f48526e);
            eMTextView.setText(str);
            addView(eMTextView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eMTextView.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(c1.M_H_X008);
            eMTextView.setLayoutParams(marginLayoutParams);
            EMTextView eMTextView2 = new EMTextView(this.f48526e);
            eMTextView2.setText(str2);
            addView(eMTextView2);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eMTextView2.getLayoutParams();
            marginLayoutParams2.topMargin = UtilHelper.getDimenPixelSize(c1.M_H_X005);
            eMTextView2.setLayoutParams(marginLayoutParams2);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(this.f48526e.getResources().getString(h1.forum_rule_defalt_one_title), this.f48526e.getResources().getString(h1.forum_rule_defalt_one_content));
            a(this.f48526e.getResources().getString(h1.forum_rule_defalt_two_title), this.f48526e.getResources().getString(h1.forum_rule_defalt_two_content));
            a(this.f48526e.getResources().getString(h1.forum_rule_defalt_three_title), this.f48526e.getResources().getString(h1.forum_rule_defalt_three_content));
            a(this.f48526e.getResources().getString(h1.forum_rule_defalt_four_title), this.f48526e.getResources().getString(h1.forum_rule_defalt_four_content));
        }
    }

    public void changeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || getChildCount() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            EMTextView eMTextView = (EMTextView) getChildAt(i3);
            if (i3 % 2 != 0) {
                c d2 = c.d(eMTextView);
                d2.v(b1.CAM_X0107);
                d2.w(c1.M_T_X003);
            } else {
                c d3 = c.d(eMTextView);
                d3.v(b1.CAM_X0107);
                d3.A(h1.F_X02);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet) {
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
    public ForumRuleDafultItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f48526e = context;
        setOrientation(1);
        b();
    }
}
