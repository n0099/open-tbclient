package com.baidu.tieba.enterForum.recforum.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RecommendForumInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;

    /* renamed from: b  reason: collision with root package name */
    public SingleLineEllipsizeTextView f31909b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31910c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31911d;

    /* renamed from: e  reason: collision with root package name */
    public FollowUserButton f31912e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31913f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumInfoView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            b(context);
            c();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0723, this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            setOrientation(0);
            setLayoutParams(layoutParams);
            setGravity(16);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BarImageView barImageView = (BarImageView) findViewById(R.id.obfuscated_res_0x7f091a06);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setShowInnerBorder(true);
            this.a.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f31909b = (SingleLineEllipsizeTextView) findViewById(R.id.obfuscated_res_0x7f091a07);
            this.f31910c = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c5);
            this.f31911d = (TextView) findViewById(R.id.obfuscated_res_0x7f091fbc);
            this.f31912e = (FollowUserButton) findViewById(R.id.obfuscated_res_0x7f09124e);
            e();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31913f : invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.d(this).f(R.color.CAM_X0201);
            c d2 = c.d(this.f31909b);
            d2.z(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            if (pureDrawable != null) {
                int f2 = n.f(getContext(), R.dimen.tbds39);
                pureDrawable.setBounds(0, 0, f2, f2);
                this.f31909b.setCompoundDrawables(null, null, pureDrawable, null);
                this.f31909b.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
            }
            c d3 = c.d(this.f31910c);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0109);
            c d4 = c.d(this.f31911d);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0109);
            this.f31912e.r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public Rect getBarVisibleRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                return null;
            }
            Rect rect = new Rect();
            this.a.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public Rect getForumNameVisibleRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f31909b == null) {
                return null;
            }
            Rect rect = new Rect();
            this.f31909b.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public FollowUserButton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31912e : (FollowUserButton) invokeV.objValue;
    }

    public void setData(String str, String str2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.J(str, 10, false);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f31909b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03c0), str2));
            }
            this.f31910c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f040e), StringHelper.numberUniformFormatExtra(i)));
            this.f31911d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f06a6), StringHelper.numberUniformFormatExtra(i2)));
            this.f31913f = z;
            this.f31912e.s(z);
        }
    }

    public void setLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f31913f = z;
            FollowUserButton followUserButton = this.f31912e;
            if (followUserButton != null) {
                followUserButton.s(z);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendForumInfoView(Context context, @Nullable AttributeSet attributeSet) {
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
    public RecommendForumInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.f31913f = false;
        a(context);
    }
}
