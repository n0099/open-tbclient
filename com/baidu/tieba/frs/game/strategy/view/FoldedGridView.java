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
import d.a.s0.u0.r1.a.e.e;
/* loaded from: classes5.dex */
public class FoldedGridView extends BdGridView implements e, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f15658e;

    /* renamed from: f  reason: collision with root package name */
    public int f15659f;

    /* renamed from: g  reason: collision with root package name */
    public int f15660g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15661h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.u0.r1.a.e.a f15662i;
    public a j;
    public int k;
    public Drawable l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, Object obj);
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
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
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
        this.f15659f = 0;
        this.f15660g = 0;
        this.f15661h = true;
        this.k = 0;
        c();
    }

    @Override // d.a.s0.u0.r1.a.e.e
    public void a(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.f15661h) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f15659f));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f15660g));
            }
        }
    }

    @Override // d.a.s0.u0.r1.a.e.e
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
            View view = this.f15658e;
            if (view != null) {
                a(view);
            }
            int i3 = this.k;
            if (i3 != 0) {
                this.l = SkinManager.getDrawable(i2, i3);
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
            if (this.f15661h || (drawable = this.l) == null) {
                return;
            }
            drawable.setBounds(0, (height - m) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.l.draw(canvas);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15661h = !this.f15661h;
            a(this.f15658e);
            d.a.s0.u0.r1.a.e.a aVar = this.f15662i;
            if (aVar != null) {
                aVar.k(this.f15661h);
                this.f15662i.notifyDataSetChanged();
                invalidate();
            }
        }
    }

    @Override // d.a.s0.u0.r1.a.e.e
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

    @Override // d.a.s0.u0.r1.a.e.e
    public View getArrowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f15658e == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                ImageView imageView = new ImageView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                frameLayout.addView(imageView, layoutParams);
                this.f15658e = frameLayout;
            }
            return this.f15658e;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        d.a.s0.u0.r1.a.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (view == this.f15658e) {
                d.a.s0.u0.r1.a.e.a aVar2 = this.f15662i;
                if (aVar2 == null || !aVar2.h()) {
                    return;
                }
                e();
            } else if (this.j == null || (aVar = this.f15662i) == null) {
            } else {
                int f2 = aVar.f(i2);
                this.f15662i.j(f2);
                this.j.a(f2, this.f15662i.getItem(i2));
            }
        }
    }

    public void setArrowResouceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f15659f = i2;
            this.f15660g = i3;
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setExpandedBottomShadeResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.k = i2;
            if (i2 == 0) {
                this.l = SkinManager.getDrawable(i2);
            } else {
                this.l = null;
            }
        }
    }

    public void setFoldAdapter(d.a.s0.u0.r1.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f15662i = aVar;
            if (aVar != null) {
                aVar.i(this);
            }
            setAdapter((ListAdapter) aVar);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.j = aVar;
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
        this.f15659f = 0;
        this.f15660g = 0;
        this.f15661h = true;
        this.k = 0;
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
        this.f15659f = 0;
        this.f15660g = 0;
        this.f15661h = true;
        this.k = 0;
        c();
    }
}
