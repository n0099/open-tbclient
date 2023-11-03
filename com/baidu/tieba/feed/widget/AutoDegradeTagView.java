package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.ha7;
import com.baidu.tieba.m57;
import com.baidu.tieba.qc7;
import com.baidu.tieba.sa7;
import com.baidu.tieba.t57;
import com.baidu.tieba.ta7;
import com.baidu.tieba.tc7;
import com.baidu.tieba.u57;
import com.baidu.tieba.uc7;
import com.baidu.tieba.v57;
import com.baidu.tieba.w57;
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
public final class AutoDegradeTagView extends LinearLayout implements sa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public final List<t57> e;
    public a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(t57 t57Var, View view2);
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
            ((AutoDegradeTagView) this.a).g();
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
        this.a = BdUtilHelper.getDimens(context, R.dimen.T_X07);
        this.b = BdUtilHelper.getDimens(context, R.dimen.tbds39);
        this.c = BdUtilHelper.getDimens(context, R.dimen.M_W_X002);
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
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i != i3) {
                g();
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

    public static final void h(AutoDegradeTagView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.requestLayout();
        }
    }

    public final void i(List<? extends t57> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.e.clear();
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.e.addAll(list);
            }
            g();
        }
    }

    public final void setOnTagClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public static final void d(AutoDegradeTagView this$0, v57 data, View it) {
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

    public static final void f(AutoDegradeTagView this$0, w57 data, View it) {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.e.isEmpty()) {
            return;
        }
        for (t57 t57Var : this.e) {
            t57Var.reset();
        }
        PriorityQueue priorityQueue = new PriorityQueue(this.e);
        while (true) {
            int i = 0;
            for (t57 t57Var2 : this.e) {
                if (t57Var2.F()) {
                    i += t57Var2.l(this.a, this.b) + this.c;
                }
            }
            if (i <= getWidth() || priorityQueue.isEmpty()) {
                return;
            }
            Object peek = priorityQueue.peek();
            Intrinsics.checkNotNull(peek);
            t57 t57Var3 = (t57) peek;
            if (t57Var3.D()) {
                if (t57Var3.M()) {
                    priorityQueue.remove(t57Var3);
                    priorityQueue.add(t57Var3);
                }
            } else {
                t57Var3.hide();
                priorityQueue.remove(t57Var3);
            }
        }
    }

    public final void c(final v57 v57Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v57Var) != null) || !v57Var.d()) {
            return;
        }
        TbImageView tbImageView = new TbImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.b);
        layoutParams.gravity = 16;
        if (v57Var.e()) {
            if (v57Var.c()) {
                tc7.b(tbImageView, v57Var.k());
                layoutParams.width = (int) ((this.b * v57Var.m()) / v57Var.i());
            } else {
                String g = v57Var.g();
                if (g == null) {
                    g = "";
                }
                tc7.b(tbImageView, g);
                Integer h = v57Var.h();
                Intrinsics.checkNotNull(h);
                float intValue = this.b * h.intValue();
                Integer f = v57Var.f();
                Intrinsics.checkNotNull(f);
                layoutParams.width = (int) (intValue / f.intValue());
            }
        } else {
            tc7.b(tbImageView, v57Var.k());
            layoutParams.width = (int) ((this.b * v57Var.m()) / v57Var.i());
        }
        layoutParams.rightMargin = this.c;
        String G = v57Var.G();
        if (G != null && G.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            tbImageView.setClickable(false);
            tbImageView.setOnClickListener(null);
        } else {
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yc7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.d(AutoDegradeTagView.this, v57Var, view2);
                    }
                }
            });
        }
        addView(tbImageView, layoutParams);
    }

    public final void e(final w57 w57Var) {
        Unit unit;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w57Var) != null) || !w57Var.f()) {
            return;
        }
        TextView textView = new TextView(getContext());
        EMManager textStyle = EMManager.from(textView).setTextColor(this.d).setTextStyle(R.string.F_X01);
        textView.setTextSize(0, this.a);
        textView.setSingleLine();
        textView.setIncludeFontPadding(false);
        textView.setText(w57Var.g());
        m57 h = w57Var.h();
        if (h != null) {
            textView.setTag(R.id.obfuscated_res_0x7f090661, h);
            textView.setTextColor(qc7.a.a(h));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            textView.setTag(R.id.obfuscated_res_0x7f090661, null);
        }
        String G = w57Var.G();
        if (G != null && G.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            textView.setClickable(false);
            textView.setOnClickListener(null);
        } else {
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.fd7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.f(AutoDegradeTagView.this, w57Var, view2);
                    }
                }
            });
        }
        String c = w57Var.c();
        if (c != null) {
            textStyle.setAlpha(uc7.a.a(c));
        }
        String e = w57Var.e();
        if (e != null) {
            textStyle.setCorner(uc7.a.a(e));
        }
        m57 d = w57Var.d();
        if (d != null) {
            textStyle.setBackGroundColor(qc7.a.a(d));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.c;
        layoutParams.gravity = 16;
        addView(textView, layoutParams);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getWidth() <= 0) {
            return;
        }
        b();
        removeAllViews();
        for (t57 t57Var : this.e) {
            if (t57Var instanceof v57) {
                c((v57) t57Var);
            } else if (t57Var instanceof w57) {
                e((w57) t57Var);
            } else if (t57Var instanceof u57) {
                ha7 ha7Var = ha7.a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ha7Var.a(context, this, (u57) t57Var, this.f);
            }
        }
        post(new Runnable() { // from class: com.baidu.tieba.xc7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    AutoDegradeTagView.h(AutoDegradeTagView.this);
                }
            }
        });
    }

    @Override // com.baidu.tieba.sa7
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || ta7.a(this)) {
            return;
        }
        g();
    }
}
