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
import com.repackage.ms4;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class RecommendForumInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;
    public SingleLineEllipsizeTextView b;
    public TextView c;
    public TextView d;
    public FollowUserButton e;
    public boolean f;

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
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0755, this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            setOrientation(0);
            setLayoutParams(layoutParams);
            setGravity(16);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BarImageView barImageView = (BarImageView) findViewById(R.id.obfuscated_res_0x7f091b55);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setShowInnerBorder(true);
            this.a.setStrokeWith(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b = (SingleLineEllipsizeTextView) findViewById(R.id.obfuscated_res_0x7f091b56);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0902d8);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09214c);
            this.e = (FollowUserButton) findViewById(R.id.obfuscated_res_0x7f0912df);
            e();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ms4.d(this).f(R.color.CAM_X0201);
            ms4 d = ms4.d(this.b);
            d.z(R.dimen.T_X07);
            d.v(R.color.CAM_X0105);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            if (pureDrawable != null) {
                int f = qi.f(getContext(), R.dimen.tbds36);
                pureDrawable.setBounds(0, 0, f, f);
                this.b.setCompoundDrawables(null, null, pureDrawable, null);
                this.b.setCompoundDrawablePadding(qi.f(getContext(), R.dimen.M_W_X002));
            }
            ms4 d2 = ms4.d(this.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0109);
            ms4 d3 = ms4.d(this.d);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0109);
            this.e.r(TbadkCoreApplication.getInst().getSkinType());
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
            if (this.b == null) {
                return null;
            }
            Rect rect = new Rect();
            this.b.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public FollowUserButton getLikeButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (FollowUserButton) invokeV.objValue;
    }

    public void setData(String str, String str2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.K(str, 10, false);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.b.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f03d2), str2));
            }
            this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0424), StringHelper.numberUniformFormatExtra(i)));
            this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f06c3), StringHelper.numberUniformFormatExtra(i2)));
            this.f = z;
            this.e.s(z);
        }
    }

    public void setLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f = z;
            FollowUserButton followUserButton = this.e;
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
        this.f = false;
        a(context);
    }
}
