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
import c.a.r0.y3.j;
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

    /* renamed from: e  reason: collision with root package name */
    public TextView f41860e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41861f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f41862g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f41863h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f41864i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f41865j;
    public List<j> k;
    public int l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f41866e;

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
            this.f41866e = frsAdCommentScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41866e.l();
                this.f41866e.f41864i.postDelayed(this, 5000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f41867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f41868f;

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
            this.f41868f = frsAdCommentScrollView;
            this.f41867e = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f41868f.f41862g.setY(-floatValue);
                this.f41868f.f41863h.setY(this.f41867e - floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsAdCommentScrollView f41869e;

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
            this.f41869e = frsAdCommentScrollView;
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
                FrsAdCommentScrollView.i(this.f41869e);
                if (this.f41869e.l == this.f41869e.k.size()) {
                    this.f41869e.l = 0;
                }
                FrameLayout frameLayout = this.f41869e.f41862g;
                FrsAdCommentScrollView frsAdCommentScrollView = this.f41869e;
                frsAdCommentScrollView.f41862g = frsAdCommentScrollView.f41863h;
                this.f41869e.f41863h = frameLayout;
                this.f41869e.f41863h.setY(this.f41869e.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                this.f41869e.o();
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
        this.f41864i = new Handler();
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
                this.f41864i.removeCallbacks(this.m);
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
            float y = this.f41863h.getY();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f41862g.getMeasuredHeight());
            this.f41865j = ofFloat;
            ofFloat.addUpdateListener(new b(this, y));
            this.f41865j.addListener(new c(this));
            this.f41865j.start();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = new LinkedList();
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
            this.f41860e = (TextView) findViewById(R.id.cur_display_view);
            this.f41861f = (TextView) findViewById(R.id.next_display_view);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.cur_display_layout);
            this.f41862g = frameLayout;
            frameLayout.setTag(this.f41860e);
            FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.next_display_layout);
            this.f41863h = frameLayout2;
            frameLayout2.setTag(this.f41861f);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41864i.removeCallbacks(this.m);
            if (ListUtils.getCount(this.k) >= 2) {
                this.f41864i.postDelayed(this.m, 5000L);
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
            if ((this.f41862g.getTag() instanceof TextView) && jVar2 != null) {
                String a2 = jVar2.a();
                if (jVar2.b()) {
                    a2 = getContext().getString(R.string.frs_top_ad_lz_reply, a2);
                }
                ((TextView) this.f41862g.getTag()).setText(a2);
            }
            if (!(this.f41863h.getTag() instanceof TextView) || jVar == null) {
                return;
            }
            String a3 = jVar.a();
            if (jVar.b()) {
                a3 = getContext().getString(R.string.frs_top_ad_lz_reply, a3);
            }
            ((TextView) this.f41863h.getTag()).setText(a3);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f41864i.removeCallbacks(this.m);
            ValueAnimator valueAnimator = this.f41865j;
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
        this.f41864i = new Handler();
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
        this.f41864i = new Handler();
        this.l = 0;
        this.m = new a(this);
        m();
    }
}
