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
import c.a.p0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32386b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f32387c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f32388d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f32389e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f32390f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f32391g;

    /* renamed from: h  reason: collision with root package name */
    public int f32392h;
    public Runnable i;

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
                this.a.f32389e.postDelayed(this, 5000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f32393b;

        public b(FrsAdCommentScrollView frsAdCommentScrollView, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32393b = frsAdCommentScrollView;
            this.a = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f32393b.f32387c.setY(-floatValue);
                this.f32393b.f32388d.setY(this.a - floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdCommentScrollView a;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                FrsAdCommentScrollView.i(this.a);
                if (this.a.f32392h == this.a.f32391g.size()) {
                    this.a.f32392h = 0;
                }
                FrameLayout frameLayout = this.a.f32387c;
                FrsAdCommentScrollView frsAdCommentScrollView = this.a;
                frsAdCommentScrollView.f32387c = frsAdCommentScrollView.f32388d;
                this.a.f32388d = frameLayout;
                this.a.f32388d.setY(this.a.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                this.a.r();
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
        this.f32389e = new Handler();
        this.f32392h = 0;
        this.i = new a(this);
        n();
    }

    public static /* synthetic */ int i(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.f32392h;
        frsAdCommentScrollView.f32392h = i + 1;
        return i;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float y = this.f32388d.getY();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f32387c.getMeasuredHeight());
            this.f32390f = ofFloat;
            ofFloat.addUpdateListener(new b(this, y));
            this.f32390f.addListener(new c(this));
            this.f32390f.start();
        }
    }

    public void m(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (ListUtils.getCount(list) <= 1) {
                this.f32389e.removeCallbacks(this.i);
                setVisibility(8);
                return;
            }
            this.f32391g.clear();
            this.f32391g.addAll(list);
            setVisibility(0);
            this.f32392h = 0;
            r();
            q();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32391g = new LinkedList();
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02fc, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09072b);
            this.f32386b = (TextView) findViewById(R.id.obfuscated_res_0x7f091572);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09072a);
            this.f32387c = frameLayout;
            frameLayout.setTag(this.a);
            FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091571);
            this.f32388d = frameLayout2;
            frameLayout2.setTag(this.f32386b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f32389e.removeCallbacks(this.i);
            ValueAnimator valueAnimator = this.f32390f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && z) {
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f32389e.removeCallbacks(this.i);
            if (ListUtils.getCount(this.f32391g) >= 2) {
                this.f32389e.postDelayed(this.i, 5000L);
            }
        }
    }

    public final void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j jVar2 = (j) ListUtils.getItem(this.f32391g, this.f32392h);
            if (this.f32392h + 1 >= this.f32391g.size()) {
                jVar = (j) ListUtils.getItem(this.f32391g, 0);
            } else {
                jVar = (j) ListUtils.getItem(this.f32391g, this.f32392h + 1);
            }
            if ((this.f32387c.getTag() instanceof TextView) && jVar2 != null) {
                String a2 = jVar2.a();
                if (jVar2.b()) {
                    a2 = getContext().getString(R.string.obfuscated_res_0x7f0f0739, a2);
                }
                ((TextView) this.f32387c.getTag()).setText(a2);
            }
            if (!(this.f32388d.getTag() instanceof TextView) || jVar == null) {
                return;
            }
            String a3 = jVar.a();
            if (jVar.b()) {
                a3 = getContext().getString(R.string.obfuscated_res_0x7f0f0739, a3);
            }
            ((TextView) this.f32388d.getTag()).setText(a3);
        }
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
        this.f32389e = new Handler();
        this.f32392h = 0;
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
        this.f32389e = new Handler();
        this.f32392h = 0;
        this.i = new a(this);
        n();
    }
}
