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
import com.baidu.tieba.ax6;
import com.baidu.tieba.bx6;
import com.baidu.tieba.cx6;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.i17;
import com.baidu.tieba.ii;
import com.baidu.tieba.l17;
import com.baidu.tieba.m17;
import com.baidu.tieba.r25;
import com.baidu.tieba.vz6;
import com.baidu.tieba.yw6;
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
/* loaded from: classes4.dex */
public final class AutoDegradeTagView extends LinearLayout implements vz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public final List<ax6> e;
    public a f;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ax6 ax6Var, View view2);
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

    /* loaded from: classes4.dex */
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
        this.a = ii.g(context, R.dimen.T_X07);
        this.b = ii.g(context, R.dimen.tbds39);
        this.c = ii.g(context, R.dimen.M_W_X002);
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

    public final void j(List<? extends ax6> list) {
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

    public static final void e(AutoDegradeTagView this$0, bx6 data, View it) {
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

    public static final void g(AutoDegradeTagView this$0, cx6 data, View it) {
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

    @Override // com.baidu.tieba.vz6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (View view2 : ViewGroupKt.getChildren(this)) {
                if (view2 instanceof TextView) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0905ef);
                    if (tag instanceof yw6) {
                        ((TextView) view2).setTextColor(i17.a.a((yw6) tag));
                    } else {
                        r25.d(view2).w(this.d);
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
        for (ax6 ax6Var : this.e) {
            if (ax6Var instanceof bx6) {
                d((bx6) ax6Var);
            } else if (ax6Var instanceof cx6) {
                f((cx6) ax6Var);
            }
        }
        post(new Runnable() { // from class: com.baidu.tieba.o17
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
        for (ax6 ax6Var : this.e) {
            ax6Var.reset();
        }
        PriorityQueue priorityQueue = new PriorityQueue(this.e);
        while (true) {
            int i = 0;
            for (ax6 ax6Var2 : this.e) {
                if (ax6Var2.E()) {
                    i += ax6Var2.l(this.a, this.b) + this.c;
                }
            }
            if (i - this.c <= getWidth() || priorityQueue.isEmpty()) {
                return;
            }
            Object peek = priorityQueue.peek();
            Intrinsics.checkNotNull(peek);
            ax6 ax6Var3 = (ax6) peek;
            if (ax6Var3.D()) {
                if (ax6Var3.M()) {
                    priorityQueue.remove(ax6Var3);
                    priorityQueue.add(ax6Var3);
                }
            } else {
                ax6Var3.hide();
                priorityQueue.remove(ax6Var3);
            }
        }
    }

    public final void d(final bx6 bx6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bx6Var) != null) || !bx6Var.c()) {
            return;
        }
        TbImageView tbImageView = new TbImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.b);
        if (bx6Var.d()) {
            if (bx6Var.b()) {
                l17.a(tbImageView, bx6Var.i());
                layoutParams.width = (int) ((this.b * bx6Var.j()) / bx6Var.h());
            } else {
                String f = bx6Var.f();
                if (f == null) {
                    f = "";
                }
                l17.a(tbImageView, f);
                Integer g = bx6Var.g();
                Intrinsics.checkNotNull(g);
                float intValue = this.b * g.intValue();
                Integer e = bx6Var.e();
                Intrinsics.checkNotNull(e);
                layoutParams.width = (int) (intValue / e.intValue());
            }
        } else {
            l17.a(tbImageView, bx6Var.i());
            layoutParams.width = (int) ((this.b * bx6Var.j()) / bx6Var.h());
        }
        layoutParams.rightMargin = this.c;
        String F = bx6Var.F();
        if (F != null && F.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            tbImageView.setClickable(false);
            tbImageView.setOnClickListener(null);
        } else {
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.p17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.e(AutoDegradeTagView.this, bx6Var, view2);
                    }
                }
            });
        }
        addView(tbImageView, layoutParams);
    }

    public final void f(final cx6 cx6Var) {
        Unit unit;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, cx6Var) != null) || !cx6Var.e()) {
            return;
        }
        TextView textView = new TextView(getContext());
        r25 d = r25.d(textView);
        d.w(this.d);
        d.C(R.string.F_X01);
        textView.setTextSize(0, this.a);
        textView.setSingleLine();
        textView.setIncludeFontPadding(false);
        textView.setText(cx6Var.f());
        yw6 g = cx6Var.g();
        if (g != null) {
            textView.setTag(R.id.obfuscated_res_0x7f0905ef, g);
            textView.setTextColor(i17.a.a(g));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            textView.setTag(R.id.obfuscated_res_0x7f0905ef, null);
        }
        String F = cx6Var.F();
        if (F != null && F.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            textView.setClickable(false);
            textView.setOnClickListener(null);
        } else {
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.t17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AutoDegradeTagView.g(AutoDegradeTagView.this, cx6Var, view2);
                    }
                }
            });
        }
        String b2 = cx6Var.b();
        if (b2 != null) {
            d.e(m17.a.a(b2));
        }
        String d2 = cx6Var.d();
        if (d2 != null) {
            d.o(m17.a.a(d2));
        }
        yw6 c = cx6Var.c();
        if (c != null) {
            d.f(i17.a.a(c));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.c;
        addView(textView, layoutParams);
    }
}
