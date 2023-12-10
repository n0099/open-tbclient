package com.baidu.tieba.forum.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.e67;
import com.baidu.tieba.forum.component.CardStaggeredVideoTagView;
import com.baidu.tieba.jd7;
import com.baidu.tieba.l67;
import com.baidu.tieba.lb7;
import com.baidu.tieba.mb7;
import com.baidu.tieba.md7;
import com.baidu.tieba.n67;
import com.baidu.tieba.nd7;
import com.baidu.tieba.o67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\u001cH\u0016J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020\u001cH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/tieba/forum/component/CardStaggeredVideoTagView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconData", "Lcom/baidu/tieba/feed/data/EnableDegradeIconData;", "iconHeight", "", "iconImage", "Lcom/baidu/tbadk/widget/TbImageView;", "intervalWidth", "onTagClickListener", "Lcom/baidu/tieba/forum/component/CardStaggeredVideoTagView$OnTagClickListener;", "getOnTagClickListener", "()Lcom/baidu/tieba/forum/component/CardStaggeredVideoTagView$OnTagClickListener;", "setOnTagClickListener", "(Lcom/baidu/tieba/forum/component/CardStaggeredVideoTagView$OnTagClickListener;)V", "textColorResId", "textData", "Lcom/baidu/tieba/feed/data/EnableDegradeTextData;", "textSize", "textView", "Landroid/widget/TextView;", "autoCompressData", "", "doUpdateState", "onChangeSkin", "onSizeChanged", "w", "h", "oldw", "oldh", "updateData", "OnTagClickListener", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CardStaggeredVideoTagView extends LinearLayout implements lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public o67 e;
    public n67 f;
    public a g;
    public final TextView h;
    public final TbImageView i;

    /* loaded from: classes6.dex */
    public interface a {
        void a(o67 o67Var, TextView textView);

        void b(n67 n67Var, ImageView imageView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardStaggeredVideoTagView(Context context) {
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

    /* loaded from: classes6.dex */
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
            ((CardStaggeredVideoTagView) this.a).d();
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardStaggeredVideoTagView(Context context, AttributeSet attributeSet) {
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
        new LinkedHashMap();
        this.a = BdUtilHelper.getDimens(context, R.dimen.T_X09);
        this.b = BdUtilHelper.getDimens(context, R.dimen.tbds31);
        this.c = BdUtilHelper.getDimens(context, R.dimen.M_W_X001);
        this.d = R.color.CAM_X0109;
        this.h = new TextView(context);
        this.i = new TbImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.c;
        layoutParams.gravity = 16;
        addView(this.h, layoutParams);
        int i3 = this.b;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = this.c;
        addView(this.i, layoutParams2);
        getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
    }

    public /* synthetic */ CardStaggeredVideoTagView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i != i3) {
                d();
            }
        }
    }

    public static final void h(CardStaggeredVideoTagView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.h.requestLayout();
            this$0.i.requestLayout();
        }
    }

    public final void setOnTagClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public static final void e(CardStaggeredVideoTagView this$0, o67 textData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, textData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(textData, "$textData");
            a aVar = this$0.g;
            if (aVar != null) {
                aVar.a(textData, this$0.h);
            }
        }
    }

    public static final void g(CardStaggeredVideoTagView this$0, n67 iconData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, this$0, iconData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(iconData, "$iconData");
            a aVar = this$0.g;
            if (aVar != null) {
                aVar.b(iconData, this$0.i);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e != null && this.f != null) {
            ArrayList<l67> arrayList = new ArrayList();
            o67 o67Var = this.e;
            if (o67Var != null) {
                o67Var.reset();
                arrayList.add(o67Var);
            }
            n67 n67Var = this.f;
            if (n67Var != null) {
                n67Var.reset();
                arrayList.add(n67Var);
            }
            PriorityQueue priorityQueue = new PriorityQueue(arrayList);
            while (true) {
                int i = 0;
                for (l67 l67Var : arrayList) {
                    if (l67Var.F()) {
                        i += l67Var.k(this.a, this.b) + this.c;
                    }
                }
                if (i <= getWidth() || priorityQueue.isEmpty()) {
                    return;
                }
                Object peek = priorityQueue.peek();
                Intrinsics.checkNotNull(peek);
                l67 l67Var2 = (l67) peek;
                if (l67Var2.D()) {
                    if (l67Var2.M()) {
                        priorityQueue.remove(l67Var2);
                        priorityQueue.add(l67Var2);
                    }
                } else {
                    l67Var2.hide();
                    priorityQueue.remove(l67Var2);
                }
            }
        }
    }

    public final void c(o67 textData, n67 iconData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textData, iconData) == null) {
            Intrinsics.checkNotNullParameter(textData, "textData");
            Intrinsics.checkNotNullParameter(iconData, "iconData");
            this.e = textData;
            this.f = iconData;
            d();
        }
    }

    public final void d() {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getWidth() <= 0) {
            return;
        }
        b();
        final o67 o67Var = this.e;
        if (o67Var != null) {
            if (!o67Var.f()) {
                return;
            }
            EMManager textStyle = EMManager.from(this.h).setTextColor(this.d).setTextStyle(R.string.F_X01);
            this.h.setTextSize(0, this.a);
            this.h.setSingleLine();
            this.h.setIncludeFontPadding(false);
            this.h.setText(o67Var.g());
            String G = o67Var.G();
            if (G != null && G.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.h.setClickable(false);
                this.h.setOnClickListener(null);
            } else {
                this.h.setClickable(true);
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardStaggeredVideoTagView.e(CardStaggeredVideoTagView.this, o67Var, view2);
                        }
                    }
                });
            }
            String c = o67Var.c();
            if (c != null) {
                textStyle.setAlpha(nd7.a.a(c));
            }
            String e = o67Var.e();
            if (e != null) {
                textStyle.setCorner(nd7.a.a(e));
            }
            e67 d = o67Var.d();
            if (d != null) {
                textStyle.setBackGroundColor(jd7.a.a(d));
            }
        }
        final n67 n67Var = this.f;
        if (n67Var != null) {
            if (!n67Var.d()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            if (n67Var.e()) {
                if (n67Var.c()) {
                    md7.b(this.i, n67Var.l());
                    if (n67Var.i() > 0) {
                        layoutParams.width = (int) ((this.b * n67Var.m()) / n67Var.i());
                    }
                } else {
                    TbImageView tbImageView = this.i;
                    String g = n67Var.g();
                    if (g == null) {
                        g = "";
                    }
                    md7.b(tbImageView, g);
                    Integer f = n67Var.f();
                    if (f != null) {
                        i = f.intValue();
                    } else {
                        i = 0;
                    }
                    if (i > 0) {
                        float f2 = this.b;
                        Integer h = n67Var.h();
                        if (h != null) {
                            i2 = h.intValue();
                        } else {
                            i2 = 1;
                        }
                        float f3 = f2 * i2;
                        Integer f4 = n67Var.f();
                        if (f4 != null) {
                            i3 = f4.intValue();
                        } else {
                            i3 = 1;
                        }
                        layoutParams.width = (int) (f3 / i3);
                    }
                }
            } else {
                md7.b(this.i, n67Var.l());
                if (n67Var.i() > 0) {
                    layoutParams.width = (int) ((this.b * n67Var.m()) / n67Var.i());
                }
            }
            this.i.setLayoutParams(layoutParams);
            String G2 = n67Var.G();
            if (G2 != null && G2.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.i.setClickable(false);
                this.i.setOnClickListener(null);
            } else {
                this.i.setClickable(true);
                this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yf7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            CardStaggeredVideoTagView.g(CardStaggeredVideoTagView.this, n67Var, view2);
                        }
                    }
                });
            }
        }
        post(new Runnable() { // from class: com.baidu.tieba.tf7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    CardStaggeredVideoTagView.h(CardStaggeredVideoTagView.this);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || mb7.a(this)) {
            return;
        }
        d();
    }

    public final a getOnTagClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (a) invokeV.objValue;
    }
}
