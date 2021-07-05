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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EnterForumAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f14794e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f14795f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f14796g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f14797h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14798i;
    public TbImageView j;
    public ViewEventCenter k;
    public BdUniqueId l;
    public int m;
    public boolean n;
    public boolean o;
    public d.a.s0.l0.d.b p;
    public c q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EnterForumAdView f14799e;

        public a(EnterForumAdView enterForumAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14799e = enterForumAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.c(this.f14799e.l, this.f14799e.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumAdView f14800a;

        public b(EnterForumAdView enterForumAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14800a = enterForumAdView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f14800a.f14798i = false;
                this.f14800a.invalidate();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onBackPressed();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14798i = false;
        this.n = false;
        this.o = false;
        d(context);
    }

    public static final void c(BdUniqueId bdUniqueId, Context context) {
        d.a.s0.l0.d.b B;
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bdUniqueId, context) == null) || (B = EnterForumDelegateStatic.f14630c.B()) == null) {
            return;
        }
        String str = EnterForumDelegateStatic.f14630c.B().f62777a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (context != null) {
            d.a.r0.l.a.l(context, str);
        }
        if (bdUniqueId == null || (l = d.a.s0.g3.a.l(true, "a025", "common_click", 3, 1, true, String.valueOf(B.f62778b), String.valueOf(B.f62778b), 5)) == null) {
            return;
        }
        d.a.s0.g3.c.g().c(bdUniqueId, l);
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setClipChildren(true);
            this.f14797h = new ColorDrawable(1241513984);
            this.f14794e = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
            this.f14795f = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
            this.f14796g = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
            setOnClickListener(new a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f14798i) {
                this.f14797h.draw(canvas);
            }
            this.f14794e.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && (cVar = this.q) != null) {
                cVar.onBackPressed();
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void g() {
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j == null) {
                TbImageView tbImageView = (TbImageView) findViewById(R.id.enter_forum_ad_image);
                this.j = tbImageView;
                tbImageView.setPlaceHolder(3);
                this.j.setEvent(new b(this));
            }
            d.a.s0.l0.d.b B = EnterForumDelegateStatic.f14630c.B();
            if (B != null && B.a()) {
                this.f14798i = true;
                this.j.M(B.f62779c, 38, false);
                invalidate();
                if (this.k != null) {
                    d.a.s0.l0.d.c cVar = new d.a.s0.l0.d.c();
                    cVar.f62780a = true;
                    cVar.f62781b = false;
                    cVar.f62782c = getBottom();
                    cVar.f62783d = this.m;
                    d.a.r0.g0.c.b bVar = new d.a.r0.g0.c.b(16, null, null, null);
                    bVar.h(cVar);
                    this.k.dispatchMvcEvent(bVar);
                }
                setVisibility(0);
                if (this.p != B && (l = d.a.s0.g3.a.l(false, "a025", "common_exp", 0, 1, true, String.valueOf(B.f62778b), String.valueOf(B.f62778b), 5)) != null) {
                    d.a.s0.g3.c g2 = d.a.s0.g3.c.g();
                    BdUniqueId bdUniqueId = this.l;
                    g2.d(bdUniqueId, d.a.s0.g3.a.a("" + B.f62778b), l);
                    d.a.s0.g3.c.g().h(this.l, false);
                }
            } else {
                if (this.k != null) {
                    d.a.s0.l0.d.c cVar2 = new d.a.s0.l0.d.c();
                    cVar2.f62780a = false;
                    cVar2.f62781b = false;
                    cVar2.f62782c = getBottom();
                    cVar2.f62783d = this.m;
                    d.a.r0.g0.c.b bVar2 = new d.a.r0.g0.c.b(16, null, null, null);
                    bVar2.h(cVar2);
                    this.k.dispatchMvcEvent(bVar2);
                }
                setVisibility(8);
            }
            this.p = B;
        }
    }

    public View getAdImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int i6 = -i3;
            this.f14794e.setBounds(0, i6, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260) + i6);
            if (!z || EnterForumDelegateStatic.f14630c.B() == null || this.k == null) {
                return;
            }
            d.a.s0.l0.d.c cVar = new d.a.s0.l0.d.c();
            cVar.f62780a = true;
            cVar.f62781b = false;
            cVar.f62782c = i5;
            cVar.f62783d = this.m;
            d.a.r0.g0.c.b bVar = new d.a.r0.g0.c.b(16, null, null, null);
            bVar.h(cVar);
            this.k.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f14797h.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.f14794e.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
            this.f14795f.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
            this.f14796g.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
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
            ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
            layoutParams2.height = getRootView().getHeight();
            this.j.setLayoutParams(layoutParams2);
        }
    }

    public void setAdViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewEventCenter) == null) {
            this.k = viewEventCenter;
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
            this.q = cVar;
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.n = z;
            invalidate();
        }
    }

    public void setRecentlyIsShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o = z;
            invalidate();
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.l = bdUniqueId;
        }
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
        this.f14798i = false;
        this.n = false;
        this.o = false;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f14798i = false;
        this.n = false;
        this.o = false;
        d(context);
    }
}
