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
import com.baidu.tieba.vm6;
import com.baidu.tieba.zm6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements zm6, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public int b;
    public int c;
    public boolean d;
    public vm6 e;
    public a f;
    public int g;
    public Drawable h;

    /* loaded from: classes4.dex */
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
        i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cb);
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
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.g = 0;
        c();
    }

    @Override // com.baidu.tieba.zm6
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2 instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view2;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.d) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.b));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.c));
            }
        }
    }

    @Override // com.baidu.tieba.zm6
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
            View view2 = this.a;
            if (view2 != null) {
                a(view2);
            }
            int i3 = this.g;
            if (i3 != 0) {
                this.h = SkinManager.getDrawable(i2, i3);
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
            if (this.d || (drawable = this.h) == null) {
                return;
            }
            drawable.setBounds(0, (height - i) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.h.draw(canvas);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = !this.d;
            a(this.a);
            vm6 vm6Var = this.e;
            if (vm6Var != null) {
                vm6Var.k(this.d);
                this.e.notifyDataSetChanged();
                invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.zm6
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

    @Override // com.baidu.tieba.zm6
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
    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
        vm6 vm6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (view2 == this.a) {
                vm6 vm6Var2 = this.e;
                if (vm6Var2 == null || !vm6Var2.h()) {
                    return;
                }
                e();
            } else if (this.f == null || (vm6Var = this.e) == null) {
            } else {
                int f = vm6Var.f(i2);
                this.e.j(f);
                this.f.a(f, this.e.getItem(i2));
            }
        }
    }

    public void setArrowResouceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.b = i2;
            this.c = i3;
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setExpandedBottomShadeResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.g = i2;
            if (i2 == 0) {
                this.h = SkinManager.getDrawable(i2);
            } else {
                this.h = null;
            }
        }
    }

    public void setFoldAdapter(vm6 vm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vm6Var) == null) {
            this.e = vm6Var;
            if (vm6Var != null) {
                vm6Var.i(this);
            }
            setAdapter((ListAdapter) vm6Var);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f = aVar;
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
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.g = 0;
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
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.g = 0;
        c();
    }
}
