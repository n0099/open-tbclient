package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewGroupKt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a87;
import com.baidu.tieba.d57;
import com.baidu.tieba.f57;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.g57;
import com.baidu.tieba.h57;
import com.baidu.tieba.m75;
import com.baidu.tieba.n97;
import com.baidu.tieba.q97;
import com.baidu.tieba.r97;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J(\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u000fJ&\u0010\"\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010#\u001a\u00020\u00132\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010%R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/tieba/feed/widget/AutoDegradeTagView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "curDegradeDataList", "", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "iconHeight", "", "intervalWidth", "onTagClickListener", "Lcom/baidu/tieba/feed/widget/AutoDegradeTagView$OnTagClickListener;", "textColorResId", "textSize", "autoCompressData", "", "insertIcon", "data", "Lcom/baidu/tieba/feed/data/EnableDegradeIconData;", "insertText", "Lcom/baidu/tieba/feed/data/EnableDegradeTextData;", "onChangeSkin", "onSizeChanged", "w", "h", "oldw", "oldh", "refreshView", "setOnTagClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTagConfig", "updateData", "list", "", "OnTagClickListener", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutoDegradeTagView extends LinearLayout implements a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public final List<f57> e;
    public a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(f57 f57Var, View view2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoDegradeTagView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes5.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ((AutoDegradeTagView) this.a).h();
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoDegradeTagView(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = vi.g(context, R.dimen.T_X07);
        this.b = vi.g(context, R.dimen.tbds39);
        this.c = vi.g(context, R.dimen.M_W_X002);
        this.d = R.color.CAM_X0105;
        this.e = new ArrayList();
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
    }

    public /* synthetic */ AutoDegradeTagView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i != i3) {
                h();
            }
        }
    }

    public final void setTagConfig(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static final void i(AutoDegradeTagView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.requestLayout();
        }
    }

    public final void j(List<? extends f57> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.e.clear();
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.e.addAll(list);
            }
            h();
        }
    }

    public final void setOnTagClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public static final void e(AutoDegradeTagView this$0, g57 data, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, data, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            a aVar = this$0.f;
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.a(data, it);
            }
        }
    }

    public static final void g(AutoDegradeTagView this$0, h57 data, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, this$0, data, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            a aVar = this$0.f;
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.a(data, it);
            }
        }
    }

    @Override // com.baidu.tieba.a87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (View view2 : ViewGroupKt.getChildren(this)) {
                if (view2 instanceof TextView) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090613);
                    if (tag instanceof d57) {
                        ((TextView) view2).setTextColor(n97.a.a((d57) tag));
                    } else {
                        m75.d(view2).w(this.d);
                    }
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getWidth() <= 0) {
            return;
        }
        c();
        removeAllViews();
        for (f57 f57Var : this.e) {
            if (f57Var instanceof g57) {
                d((g57) f57Var);
            } else if (f57Var instanceof h57) {
                f((h57) f57Var);
            }
        }
        post(new Runnable() { // from class: com.baidu.tieba.t97
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    AutoDegradeTagView.i(AutoDegradeTagView.this);
                }
            }
        });
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.e.isEmpty()) {
            return;
        }
        for (f57 f57Var : this.e) {
            f57Var.reset();
        }
        PriorityQueue priorityQueue = new PriorityQueue(this.e);
        while (true) {
            int i = 0;
            for (f57 f57Var2 : this.e) {
                if (f57Var2.E()) {
                    i += f57Var2.m(this.a, this.b) + this.c;
                }
            }
            if (i <= getWidth() || priorityQueue.isEmpty()) {
                return;
            }
            Object peek = priorityQueue.peek();
            Intrinsics.checkNotNull(peek);
            f57 f57Var3 = (f57) peek;
            if (f57Var3.D()) {
                if (f57Var3.Q()) {
                    priorityQueue.remove(f57Var3);
                    priorityQueue.add(f57Var3);
                }
            } else {
                f57Var3.hide();
                priorityQueue.remove(f57Var3);
            }
        }
    }

    public final void d(final g57 g57Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g57Var) != null) || !g57Var.c()) {
            return;
        }
        TbImageView tbImageView = new TbImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.b);
        layoutParams.gravity = 16;
        if (g57Var.d()) {
            if (g57Var.b()) {
                q97.a(tbImageView, g57Var.j());
                layoutParams.width = (int) ((this.b * g57Var.k()) / g57Var.h());
            } else {
                String f = g57Var.f();
                if (f == null) {
                    f = "";
                }
                q97.a(tbImageView, f);
                Integer g = g57Var.g();
                Intrinsics.checkNotNull(g);
                float intValue = this.b * g.intValue();
                Integer e = g57Var.e();
                Intrinsics.checkNotNull(e);
                layoutParams.width = (int) (intValue / e.intValue());
            }
        } else {
            q97.a(tbImageView, g57Var.j());
            layoutParams.width = (int) ((this.b * g57Var.k()) / g57Var.h());
        }
        layoutParams.rightMargin = this.c;
        String I = g57Var.I();
        if (I != null && I.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            tbImageView.setClickable(false);
            tbImageView.setOnClickListener(null);
        } else {
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.u97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.e(AutoDegradeTagView.this, g57Var, view2);
                    }
                }
            });
        }
        addView(tbImageView, layoutParams);
    }

    public final void f(final h57 h57Var) {
        Unit unit;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, h57Var) != null) || !h57Var.e()) {
            return;
        }
        TextView textView = new TextView(getContext());
        m75 d = m75.d(textView);
        d.w(this.d);
        d.C(R.string.F_X01);
        textView.setTextSize(0, this.a);
        textView.setSingleLine();
        textView.setIncludeFontPadding(false);
        textView.setText(h57Var.f());
        d57 g = h57Var.g();
        if (g != null) {
            textView.setTag(R.id.obfuscated_res_0x7f090613, g);
            textView.setTextColor(n97.a.a(g));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            textView.setTag(R.id.obfuscated_res_0x7f090613, null);
        }
        String I = h57Var.I();
        if (I != null && I.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            textView.setClickable(false);
            textView.setOnClickListener(null);
        } else {
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.y97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.g(AutoDegradeTagView.this, h57Var, view2);
                    }
                }
            });
        }
        String b2 = h57Var.b();
        if (b2 != null) {
            d.e(r97.a.a(b2));
        }
        String d2 = h57Var.d();
        if (d2 != null) {
            d.o(r97.a.a(d2));
        }
        d57 c = h57Var.c();
        if (c != null) {
            d.f(n97.a.a(c));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.c;
        layoutParams.gravity = 16;
        addView(textView, layoutParams);
    }
}
