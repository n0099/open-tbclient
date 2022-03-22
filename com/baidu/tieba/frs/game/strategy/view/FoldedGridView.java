package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.u1.a.e.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FoldedGridView extends BdGridView implements e, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public int f32549b;

    /* renamed from: c  reason: collision with root package name */
    public int f32550c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32551d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.u1.a.e.a f32552e;

    /* renamed from: f  reason: collision with root package name */
    public a f32553f;

    /* renamed from: g  reason: collision with root package name */
    public int f32554g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f32555h;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2102135941, "Lcom/baidu/tieba/frs/game/strategy/view/FoldedGridView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2102135941, "Lcom/baidu/tieba/frs/game/strategy/view/FoldedGridView;");
                return;
            }
        }
        i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldedGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f32549b = 0;
        this.f32550c = 0;
        this.f32551d = true;
        this.f32554g = 0;
        c();
    }

    @Override // c.a.p0.f1.u1.a.e.e
    public void a(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.f32551d) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f32549b));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f32550c));
            }
        }
    }

    @Override // c.a.p0.f1.u1.a.e.e
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getNumColumns() > 0 : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setSelector(new ColorDrawable(0));
            setOnItemClickListener(this);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            View view = this.a;
            if (view != null) {
                a(view);
            }
            int i3 = this.f32554g;
            if (i3 != 0) {
                this.f32555h = SkinManager.getDrawable(i2, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
            int height = getHeight();
            if (this.f32551d || (drawable = this.f32555h) == null) {
                return;
            }
            drawable.setBounds(0, (height - i) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.f32555h.draw(canvas);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f32551d = !this.f32551d;
            a(this.a);
            c.a.p0.f1.u1.a.e.a aVar = this.f32552e;
            if (aVar != null) {
                aVar.k(this.f32551d);
                this.f32552e.notifyDataSetChanged();
                invalidate();
            }
        }
    }

    @Override // c.a.p0.f1.u1.a.e.e
    public int getArrowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (b()) {
                return getNumColumns() - 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.u1.a.e.e
    public View getArrowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                ImageView imageView = new ImageView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                frameLayout.addView(imageView, layoutParams);
                this.a = frameLayout;
            }
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        c.a.p0.f1.u1.a.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (view == this.a) {
                c.a.p0.f1.u1.a.e.a aVar2 = this.f32552e;
                if (aVar2 == null || !aVar2.h()) {
                    return;
                }
                e();
            } else if (this.f32553f == null || (aVar = this.f32552e) == null) {
            } else {
                int f2 = aVar.f(i2);
                this.f32552e.j(f2);
                this.f32553f.a(f2, this.f32552e.getItem(i2));
            }
        }
    }

    public void setArrowResouceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f32549b = i2;
            this.f32550c = i3;
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setExpandedBottomShadeResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f32554g = i2;
            if (i2 == 0) {
                this.f32555h = SkinManager.getDrawable(i2);
            } else {
                this.f32555h = null;
            }
        }
    }

    public void setFoldAdapter(c.a.p0.f1.u1.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f32552e = aVar;
            if (aVar != null) {
                aVar.i(this);
            }
            setAdapter((ListAdapter) aVar);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f32553f = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32549b = 0;
        this.f32550c = 0;
        this.f32551d = true;
        this.f32554g = 0;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldedGridView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32549b = 0;
        this.f32550c = 0;
        this.f32551d = true;
        this.f32554g = 0;
        c();
    }
}
