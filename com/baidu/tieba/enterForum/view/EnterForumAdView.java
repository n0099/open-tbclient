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
/* loaded from: classes7.dex */
public class EnterForumAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f50073e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f50074f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f50075g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f50076h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50077i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f50078j;
    public ViewEventCenter k;
    public BdUniqueId l;
    public int m;
    public boolean n;
    public boolean o;
    public c.a.p0.m0.d.b p;
    public c q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EnterForumAdView f50079e;

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
            this.f50079e = enterForumAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.clickAd(this.f50079e.l, this.f50079e.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumAdView f50080a;

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
            this.f50080a = enterForumAdView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f50080a.f50077i = false;
                this.f50080a.invalidate();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f50077i = false;
        this.n = false;
        this.o = false;
        c(context);
    }

    public static final void clickAd(BdUniqueId bdUniqueId, Context context) {
        c.a.p0.m0.d.b B;
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bdUniqueId, context) == null) || (B = EnterForumDelegateStatic.f49895c.B()) == null) {
            return;
        }
        String str = EnterForumDelegateStatic.f49895c.B().f21583a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (context != null) {
            c.a.o0.m.a.l(context, str);
        }
        if (bdUniqueId == null || (l = c.a.p0.h3.a.l(true, "a025", "common_click", 3, 1, true, String.valueOf(B.f21584b), String.valueOf(B.f21584b), 5)) == null) {
            return;
        }
        c.a.p0.h3.c.g().c(bdUniqueId, l);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setClipChildren(true);
            this.f50076h = new ColorDrawable(1241513984);
            this.f50073e = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
            this.f50074f = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
            this.f50075g = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
            setOnClickListener(new a(this));
        }
    }

    public final void d() {
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f50078j == null) {
                TbImageView tbImageView = (TbImageView) findViewById(R.id.enter_forum_ad_image);
                this.f50078j = tbImageView;
                tbImageView.setPlaceHolder(3);
                this.f50078j.setEvent(new b(this));
            }
            c.a.p0.m0.d.b B = EnterForumDelegateStatic.f49895c.B();
            if (B != null && B.a()) {
                this.f50077i = true;
                this.f50078j.startLoad(B.f21585c, 38, false);
                invalidate();
                if (this.k != null) {
                    c.a.p0.m0.d.c cVar = new c.a.p0.m0.d.c();
                    cVar.f21586a = true;
                    cVar.f21587b = false;
                    cVar.f21588c = getBottom();
                    cVar.f21589d = this.m;
                    c.a.o0.i0.c.b bVar = new c.a.o0.i0.c.b(16, null, null, null);
                    bVar.h(cVar);
                    this.k.dispatchMvcEvent(bVar);
                }
                setVisibility(0);
                if (this.p != B && (l = c.a.p0.h3.a.l(false, "a025", "common_exp", 0, 1, true, String.valueOf(B.f21584b), String.valueOf(B.f21584b), 5)) != null) {
                    c.a.p0.h3.c g2 = c.a.p0.h3.c.g();
                    BdUniqueId bdUniqueId = this.l;
                    g2.d(bdUniqueId, c.a.p0.h3.a.a("" + B.f21584b), l);
                    c.a.p0.h3.c.g().h(this.l, false);
                }
            } else {
                if (this.k != null) {
                    c.a.p0.m0.d.c cVar2 = new c.a.p0.m0.d.c();
                    cVar2.f21586a = false;
                    cVar2.f21587b = false;
                    cVar2.f21588c = getBottom();
                    cVar2.f21589d = this.m;
                    c.a.o0.i0.c.b bVar2 = new c.a.o0.i0.c.b(16, null, null, null);
                    bVar2.h(cVar2);
                    this.k.dispatchMvcEvent(bVar2);
                }
                setVisibility(8);
            }
            this.p = B;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f50077i) {
                this.f50076h.draw(canvas);
            }
            this.f50073e.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && (cVar = this.q) != null) {
                cVar.onBackPressed();
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public View getAdImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50078j : (View) invokeV.objValue;
    }

    public boolean isRecentlyExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isRecentlyShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int i6 = -i3;
            this.f50073e.setBounds(0, i6, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260) + i6);
            if (!z || EnterForumDelegateStatic.f49895c.B() == null || this.k == null) {
                return;
            }
            c.a.p0.m0.d.c cVar = new c.a.p0.m0.d.c();
            cVar.f21586a = true;
            cVar.f21587b = false;
            cVar.f21588c = i5;
            cVar.f21589d = this.m;
            c.a.o0.i0.c.b bVar = new c.a.o0.i0.c.b(16, null, null, null);
            bVar.h(cVar);
            this.k.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f50076h.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.f50073e.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
            this.f50074f.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
            this.f50075g.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setAdData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d();
            ((ViewGroup) getRootView()).setClipChildren(false);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = getRootView().getHeight();
            setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f50078j.getLayoutParams();
            layoutParams2.height = getRootView().getHeight();
            this.f50078j.setLayoutParams(layoutParams2);
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
        this.f50077i = false;
        this.n = false;
        this.o = false;
        c(context);
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
        this.f50077i = false;
        this.n = false;
        this.o = false;
        c(context);
    }
}
