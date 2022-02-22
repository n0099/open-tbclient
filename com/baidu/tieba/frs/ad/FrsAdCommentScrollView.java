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
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import c.a.u0.z3.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes12.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43457e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43458f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f43459g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f43460h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f43461i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f43462j;
    public List<j> k;
    public int l;
    public Runnable m;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f43463e;

        public a(FrsAdCommentScrollView frsAdCommentScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43463e = frsAdCommentScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43463e.l();
                this.f43463e.f43461i.postDelayed(this, 5000L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f43464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f43465f;

        public b(FrsAdCommentScrollView frsAdCommentScrollView, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43465f = frsAdCommentScrollView;
            this.f43464e = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f43465f.f43459g.setY(-floatValue);
                this.f43465f.f43460h.setY(this.f43464e - floatValue);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f43466e;

        public c(FrsAdCommentScrollView frsAdCommentScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdCommentScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43466e = frsAdCommentScrollView;
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
                FrsAdCommentScrollView.i(this.f43466e);
                if (this.f43466e.l == this.f43466e.k.size()) {
                    this.f43466e.l = 0;
                }
                FrameLayout frameLayout = this.f43466e.f43459g;
                FrsAdCommentScrollView frsAdCommentScrollView = this.f43466e;
                frsAdCommentScrollView.f43459g = frsAdCommentScrollView.f43460h;
                this.f43466e.f43460h = frameLayout;
                this.f43466e.f43460h.setY(this.f43466e.getContext().getResources().getDimensionPixelSize(d1.tbds99));
                this.f43466e.o();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43461i = new Handler();
        this.l = 0;
        this.m = new a(this);
        m();
    }

    public static /* synthetic */ int i(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i2 = frsAdCommentScrollView.l;
        frsAdCommentScrollView.l = i2 + 1;
        return i2;
    }

    public void bindData(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (ListUtils.getCount(list) <= 1) {
                this.f43461i.removeCallbacks(this.m);
                setVisibility(8);
                return;
            }
            this.k.clear();
            this.k.addAll(list);
            setVisibility(0);
            this.l = 0;
            o();
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            float y = this.f43460h.getY();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f43459g.getMeasuredHeight());
            this.f43462j = ofFloat;
            ofFloat.addUpdateListener(new b(this, y));
            this.f43462j.addListener(new c(this));
            this.f43462j.start();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = new LinkedList();
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(g1.frs_ad_comment_scroll_view, this);
            this.f43457e = (TextView) findViewById(f1.cur_display_view);
            this.f43458f = (TextView) findViewById(f1.next_display_view);
            FrameLayout frameLayout = (FrameLayout) findViewById(f1.cur_display_layout);
            this.f43459g = frameLayout;
            frameLayout.setTag(this.f43457e);
            FrameLayout frameLayout2 = (FrameLayout) findViewById(f1.next_display_layout);
            this.f43460h = frameLayout2;
            frameLayout2.setTag(this.f43458f);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f43461i.removeCallbacks(this.m);
            if (ListUtils.getCount(this.k) >= 2) {
                this.f43461i.postDelayed(this.m, 5000L);
            }
        }
    }

    public final void o() {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j jVar2 = (j) ListUtils.getItem(this.k, this.l);
            if (this.l + 1 >= this.k.size()) {
                jVar = (j) ListUtils.getItem(this.k, 0);
            } else {
                jVar = (j) ListUtils.getItem(this.k, this.l + 1);
            }
            if ((this.f43459g.getTag() instanceof TextView) && jVar2 != null) {
                String a2 = jVar2.a();
                if (jVar2.b()) {
                    a2 = getContext().getString(i1.frs_top_ad_lz_reply, a2);
                }
                ((TextView) this.f43459g.getTag()).setText(a2);
            }
            if (!(this.f43460h.getTag() instanceof TextView) || jVar == null) {
                return;
            }
            String a3 = jVar.a();
            if (jVar.b()) {
                a3 = getContext().getString(i1.frs_top_ad_lz_reply, a3);
            }
            ((TextView) this.f43460h.getTag()).setText(a3);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f43461i.removeCallbacks(this.m);
            ValueAnimator valueAnimator = this.f43462j;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && z) {
            n();
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
        this.f43461i = new Handler();
        this.l = 0;
        this.m = new a(this);
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f43461i = new Handler();
        this.l = 0;
        this.m = new a(this);
        m();
    }
}
