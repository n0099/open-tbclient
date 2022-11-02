package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ln8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public FrameLayout c;
    public FrameLayout d;
    public Handler e;
    public ValueAnimator f;
    public List<ln8> g;
    public int h;
    public Runnable i;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdCommentScrollView a;

        public a(FrsAdCommentScrollView frsAdCommentScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdCommentScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l();
            this.a.e.postDelayed(this, 5000L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;
        public final /* synthetic */ FrsAdCommentScrollView b;

        public b(FrsAdCommentScrollView frsAdCommentScrollView, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsAdCommentScrollView;
            this.a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.b.c.setY(-floatValue);
                this.b.d.setY(this.a - floatValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdCommentScrollView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public c(FrsAdCommentScrollView frsAdCommentScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdCommentScrollView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                FrsAdCommentScrollView.i(this.a);
                if (this.a.h == this.a.g.size()) {
                    this.a.h = 0;
                }
                FrameLayout frameLayout = this.a.c;
                FrsAdCommentScrollView frsAdCommentScrollView = this.a;
                frsAdCommentScrollView.c = frsAdCommentScrollView.d;
                this.a.d = frameLayout;
                this.a.d.setY(this.a.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                this.a.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAdCommentScrollView(Context context) {
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
        this.e = new Handler();
        this.h = 0;
        this.i = new a(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.e = new Handler();
        this.h = 0;
        this.i = new a(this);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = new Handler();
        this.h = 0;
        this.i = new a(this);
        n();
    }

    public static /* synthetic */ int i(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.h;
        frsAdCommentScrollView.h = i + 1;
        return i;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && z) {
            q();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float y = this.d.getY();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.c.getMeasuredHeight());
            this.f = ofFloat;
            ofFloat.addUpdateListener(new b(this, y));
            this.f.addListener(new c(this));
            this.f.start();
        }
    }

    public void m(List<ln8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (ListUtils.getCount(list) <= 1) {
                this.e.removeCallbacks(this.i);
                setVisibility(8);
                return;
            }
            this.g.clear();
            this.g.addAll(list);
            setVisibility(0);
            this.h = 0;
            r();
            q();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = new LinkedList();
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02f3, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090754);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0916ea);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090753);
            this.c = frameLayout;
            frameLayout.setTag(this.a);
            FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0916e9);
            this.d = frameLayout2;
            frameLayout2.setTag(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.removeCallbacks(this.i);
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.removeCallbacks(this.i);
            if (ListUtils.getCount(this.g) >= 2) {
                this.e.postDelayed(this.i, 5000L);
            }
        }
    }

    public final void r() {
        ln8 ln8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ln8 ln8Var2 = (ln8) ListUtils.getItem(this.g, this.h);
            if (this.h + 1 >= this.g.size()) {
                ln8Var = (ln8) ListUtils.getItem(this.g, 0);
            } else {
                ln8Var = (ln8) ListUtils.getItem(this.g, this.h + 1);
            }
            if ((this.c.getTag() instanceof TextView) && ln8Var2 != null) {
                String a2 = ln8Var2.a();
                if (ln8Var2.b()) {
                    a2 = getContext().getString(R.string.obfuscated_res_0x7f0f077a, a2);
                }
                ((TextView) this.c.getTag()).setText(a2);
            }
            if ((this.d.getTag() instanceof TextView) && ln8Var != null) {
                String a3 = ln8Var.a();
                if (ln8Var.b()) {
                    a3 = getContext().getString(R.string.obfuscated_res_0x7f0f077a, a3);
                }
                ((TextView) this.d.getTag()).setText(a3);
            }
        }
    }
}
