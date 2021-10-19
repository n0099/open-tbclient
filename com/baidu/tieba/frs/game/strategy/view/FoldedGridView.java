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
import c.a.r0.x0.s1.a.e.e;
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
/* loaded from: classes7.dex */
public class FoldedGridView extends BdGridView implements e, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f51227e;

    /* renamed from: f  reason: collision with root package name */
    public int f51228f;

    /* renamed from: g  reason: collision with root package name */
    public int f51229g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51230h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.x0.s1.a.e.a f51231i;

    /* renamed from: j  reason: collision with root package name */
    public a f51232j;
    public int k;
    public Drawable l;

    /* loaded from: classes7.dex */
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
        this.f51228f = 0;
        this.f51229g = 0;
        this.f51230h = true;
        this.k = 0;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setSelector(new ColorDrawable(0));
            setOnItemClickListener(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f51230h = !this.f51230h;
            configUI(this.f51227e);
            c.a.r0.x0.s1.a.e.a aVar = this.f51231i;
            if (aVar != null) {
                aVar.k(this.f51230h);
                this.f51231i.notifyDataSetChanged();
                invalidate();
            }
        }
    }

    @Override // c.a.r0.x0.s1.a.e.e
    public void configUI(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.f51230h) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f51228f));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f51229g));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            int height = getHeight();
            if (this.f51230h || (drawable = this.l) == null) {
                return;
            }
            drawable.setBounds(0, (height - m) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.l.draw(canvas);
        }
    }

    @Override // c.a.r0.x0.s1.a.e.e
    public int getArrowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isFoldedMode()) {
                return getNumColumns() - 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.x0.s1.a.e.e
    public View getArrowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f51227e == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                ImageView imageView = new ImageView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                frameLayout.addView(imageView, layoutParams);
                this.f51227e = frameLayout;
            }
            return this.f51227e;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.x0.s1.a.e.e
    public boolean isFoldedMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getNumColumns() > 0 : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            View view = this.f51227e;
            if (view != null) {
                configUI(view);
            }
            int i3 = this.k;
            if (i3 != 0) {
                this.l = SkinManager.getDrawable(i2, i3);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        c.a.r0.x0.s1.a.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (view == this.f51227e) {
                c.a.r0.x0.s1.a.e.a aVar2 = this.f51231i;
                if (aVar2 == null || !aVar2.h()) {
                    return;
                }
                b();
            } else if (this.f51232j == null || (aVar = this.f51231i) == null) {
            } else {
                int f2 = aVar.f(i2);
                this.f51231i.j(f2);
                this.f51232j.a(f2, this.f51231i.getItem(i2));
            }
        }
    }

    public void setArrowResouceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f51228f = i2;
            this.f51229g = i3;
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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

    public void setFoldAdapter(c.a.r0.x0.s1.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f51231i = aVar;
            if (aVar != null) {
                aVar.i(this);
            }
            setAdapter((ListAdapter) aVar);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f51232j = aVar;
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
        this.f51228f = 0;
        this.f51229g = 0;
        this.f51230h = true;
        this.k = 0;
        a();
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
        this.f51228f = 0;
        this.f51229g = 0;
        this.f51230h = true;
        this.k = 0;
        a();
    }
}
