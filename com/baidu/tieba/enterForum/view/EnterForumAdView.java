package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.lq8;
import com.baidu.tieba.nq8;
import com.baidu.tieba.sp4;
import com.baidu.tieba.xd5;
import com.baidu.tieba.yb6;
import com.baidu.tieba.zb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable a;
    public Drawable b;
    public Drawable c;
    public Drawable d;
    public boolean e;
    public TbImageView f;
    public ViewEventCenter g;
    public BdUniqueId h;
    public int i;
    public boolean j;
    public boolean k;
    public yb6 l;
    public c m;

    /* loaded from: classes4.dex */
    public interface c {
        void onBackPressed();
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumAdView a;

        public a(EnterForumAdView enterForumAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                EnterForumAdView.c(this.a.h, this.a.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumAdView a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(EnterForumAdView enterForumAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumAdView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || !z) {
                return;
            }
            this.a.e = false;
            this.a.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumAdView(@NonNull Context context) {
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
        this.e = false;
        this.j = false;
        this.k = false;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.j = false;
        this.k = false;
        d(context);
    }

    public static final void c(BdUniqueId bdUniqueId, Context context) {
        yb6 L;
        StatisticItem i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, bdUniqueId, context) == null) && (L = EnterForumDelegateStatic.e.L()) != null) {
            String str = EnterForumDelegateStatic.e.L().a;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    sp4.o(context, str);
                }
                if (bdUniqueId != null && (i = lq8.i(true, "a025", "common_click", 3, 1, true, String.valueOf(L.b), String.valueOf(L.b), 5)) != null) {
                    nq8.g().c(bdUniqueId, i);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.d.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.a.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
            this.b.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
            this.c.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = false;
        this.j = false;
        this.k = false;
        d(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.e) {
                this.d.draw(canvas);
            }
            this.a.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && (cVar = this.m) != null) {
                cVar.onBackPressed();
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public void setAdViewHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i = i;
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewEventCenter) == null) {
            this.g = viewEventCenter;
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
        }
    }

    public void setOnBackPressedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j = z;
            invalidate();
        }
    }

    public void setRecentlyIsShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.k = z;
            invalidate();
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.h = bdUniqueId;
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setClipChildren(true);
            this.d = new ColorDrawable(1241513984);
            this.a = context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0804e4);
            this.b = context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0804e2);
            this.c = context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0804e3);
            setOnClickListener(new a(this));
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public View getAdImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final void g() {
        StatisticItem i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f == null) {
                TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090935);
                this.f = tbImageView;
                tbImageView.setPlaceHolder(3);
                this.f.setEvent(new b(this));
            }
            yb6 L = EnterForumDelegateStatic.e.L();
            if (L != null && L.a()) {
                this.e = true;
                this.f.K(L.c, 38, false);
                invalidate();
                if (this.g != null) {
                    zb6 zb6Var = new zb6();
                    zb6Var.a = true;
                    zb6Var.b = getBottom();
                    zb6Var.c = this.i;
                    xd5 xd5Var = new xd5(16, null, null, null);
                    xd5Var.h(zb6Var);
                    this.g.dispatchMvcEvent(xd5Var);
                }
                setVisibility(0);
                if (this.l != L && (i = lq8.i(false, "a025", "common_exp", 0, 1, true, String.valueOf(L.b), String.valueOf(L.b), 5)) != null) {
                    nq8 g = nq8.g();
                    BdUniqueId bdUniqueId = this.h;
                    g.d(bdUniqueId, lq8.a("" + L.b), i);
                    nq8.g().h(this.h, false);
                }
            } else {
                if (this.g != null) {
                    zb6 zb6Var2 = new zb6();
                    zb6Var2.a = false;
                    zb6Var2.b = getBottom();
                    zb6Var2.c = this.i;
                    xd5 xd5Var2 = new xd5(16, null, null, null);
                    xd5Var2.h(zb6Var2);
                    this.g.dispatchMvcEvent(xd5Var2);
                }
                setVisibility(8);
            }
            this.l = L;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = -i2;
            this.a.setBounds(0, i5, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260) + i5);
            if (z && EnterForumDelegateStatic.e.L() != null && this.g != null) {
                zb6 zb6Var = new zb6();
                zb6Var.a = true;
                zb6Var.b = i4;
                zb6Var.c = this.i;
                xd5 xd5Var = new xd5(16, null, null, null);
                xd5Var.h(zb6Var);
                this.g.dispatchMvcEvent(xd5Var);
            }
        }
    }

    public void setAdData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g();
            ((ViewGroup) getRootView()).setClipChildren(false);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = getRootView().getHeight();
            setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f.getLayoutParams();
            layoutParams2.height = getRootView().getHeight();
            this.f.setLayoutParams(layoutParams2);
        }
    }
}
