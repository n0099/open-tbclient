package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.fl8;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class el8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a k;
    @JvmField
    public static int l;
    @JvmField
    public static int m;
    @JvmField
    public static int n;
    @JvmField
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ViewGroup c;
    public dl8 d;
    public bl8 e;
    public bl8 f;
    public fl8 g;
    public boolean h;
    public boolean i;
    public il8 j;

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-829257606, "Lcom/baidu/tieba/el8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-829257606, "Lcom/baidu/tieba/el8$b;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            iArr[PanelType.EXPRESSION.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947738296, "Lcom/baidu/tieba/el8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947738296, "Lcom/baidu/tieba/el8;");
                return;
            }
        }
        k = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements gl8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(el8 el8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements fl8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el8 a;

        public d(el8 el8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el8Var;
        }

        @Override // com.baidu.tieba.fl8.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i = false;
            dl8 dl8Var = this.a.d;
            if (dl8Var != null) {
                dl8Var.x();
            }
            il8 il8Var = this.a.j;
            if (il8Var != null) {
                il8Var.g();
            }
        }

        @Override // com.baidu.tieba.fl8.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.i = true;
                if (TbSingleton.getInstance().getKeyboardHeight() != 0) {
                    Context context = this.a.a;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    }
                    if (i > cl8.b(context) / 2) {
                        i = TbSingleton.getInstance().getKeyboardHeight();
                    }
                }
                a aVar = el8.k;
                el8.l = i;
                dl8 dl8Var = this.a.d;
                if (dl8Var != null) {
                    dl8Var.n();
                }
                il8 il8Var = this.a.j;
                if (il8Var != null) {
                    il8Var.b(i);
                }
                dl8 dl8Var2 = this.a.d;
                if (dl8Var2 != null) {
                    a aVar2 = el8.k;
                    el8.m = dl8Var2.q();
                }
                bl8 bl8Var = this.a.e;
                if (bl8Var != null) {
                    a aVar3 = el8.k;
                    el8.n = bl8Var.q();
                }
                bl8 bl8Var2 = this.a.f;
                if (bl8Var2 != null) {
                    a aVar4 = el8.k;
                    el8.o = bl8Var2.q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public el8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final el8 g(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (el8) invokeL.objValue;
    }

    public final <P extends dl8> el8 h(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            m = panel.q();
            panel.d2(new c(this));
            panel.y(new yjc() { // from class: com.baidu.tieba.zk8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yjc
                public final void b(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        el8.i(el8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (el8) invokeL.objValue;
    }

    public final el8 l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (el8) invokeL.objValue;
    }

    public final el8 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            l = i;
            if (m == 0) {
                m = i;
            }
            return this;
        }
        return (el8) invokeI.objValue;
    }

    public final el8 n(il8 il8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, il8Var)) == null) {
            this.j = il8Var;
            return this;
        }
        return (el8) invokeL.objValue;
    }

    public final el8 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (el8) invokeZ.objValue;
    }

    public static final void i(el8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, this$0, panelType, lastPanelType, fromValue, toValue) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(panelType, "panelType");
            Intrinsics.checkNotNullExpressionValue(lastPanelType, "lastPanelType");
            Intrinsics.checkNotNullExpressionValue(fromValue, "fromValue");
            float floatValue = fromValue.floatValue();
            Intrinsics.checkNotNullExpressionValue(toValue, "toValue");
            this$0.k(panelType, lastPanelType, floatValue, toValue.floatValue());
        }
    }

    public final el8 j(View rootLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rootLayout)) == null) {
            Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
            this.b = rootLayout;
            Context context = this.a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            fl8 fl8Var = new fl8(context, rootLayout);
            this.g = fl8Var;
            if (fl8Var != null) {
                fl8Var.b(new d(this));
            }
            return this;
        }
        return (el8) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    @SuppressLint({"ObjectAnimatorBinding"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(PanelType panelType, PanelType panelType2, float f, float f2) {
        int i;
        boolean z;
        boolean z2;
        float f3;
        float f4;
        PanelType panelType3;
        View view2;
        ObjectAnimator ofFloat;
        dl8 dl8Var;
        View view3;
        View view4;
        View view5;
        dl8 dl8Var2;
        Integer num;
        boolean z3;
        Integer num2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            dl8 dl8Var3 = this.d;
            if (dl8Var3 != null) {
                i = dl8Var3.A();
            } else {
                i = 0;
            }
            dl8 dl8Var4 = this.d;
            if (dl8Var4 != null) {
                dl8Var4.k2(panelType);
            }
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            View view6 = null;
            if (z) {
                if (f2 == 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    dl8 dl8Var5 = this.d;
                    if (dl8Var5 != null) {
                        num2 = Integer.valueOf(dl8Var5.h());
                    } else {
                        num2 = null;
                    }
                    Intrinsics.checkNotNull(num2);
                    if (num2.intValue() == 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        f4 = f;
                        f3 = f2;
                        panelType3 = PanelType.VOICE;
                        if (panelType != panelType3 && (panelType2 != panelType3 || panelType != PanelType.NONE)) {
                            dl8Var2 = this.d;
                            if (dl8Var2 == null) {
                                num = Integer.valueOf(dl8Var2.h());
                            } else {
                                num = null;
                            }
                            Intrinsics.checkNotNull(num);
                            f3 -= num.intValue();
                        }
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
                        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
                        if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
                            if (panelType2 != PanelType.INPUT_KEYBOARD && !this.i) {
                                if (panelType2 != PanelType.NONE && panelType2 != PanelType.VOICE) {
                                    if (panelType2 == PanelType.INPUTCHANGE) {
                                        dl8 dl8Var6 = this.d;
                                        if (dl8Var6 != null) {
                                            view5 = dl8Var6.C();
                                        } else {
                                            view5 = null;
                                        }
                                        ofFloat = ObjectAnimator.ofFloat(view5, Key.TRANSLATION_Y, f, 0.0f);
                                    } else {
                                        ofFloat = null;
                                    }
                                } else {
                                    dl8 dl8Var7 = this.d;
                                    if (dl8Var7 != null) {
                                        view4 = dl8Var7.C();
                                    } else {
                                        view4 = null;
                                    }
                                    ofFloat = ObjectAnimator.ofFloat(view4, Key.TRANSLATION_Y, f, f);
                                }
                            } else {
                                dl8 dl8Var8 = this.d;
                                if (dl8Var8 != null) {
                                    view3 = dl8Var8.C();
                                } else {
                                    view3 = null;
                                }
                                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, Key.TRANSLATION_Y, f, 0.0f);
                                ofFloat2 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3 + i);
                                Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(bodyLayout,\n    …lue\n                    )");
                                ofFloat = ofFloat3;
                            }
                        } else {
                            dl8 dl8Var9 = this.d;
                            if (dl8Var9 != null) {
                                view2 = dl8Var9.C();
                            } else {
                                view2 = null;
                            }
                            ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f, f2);
                        }
                        dl8Var = this.d;
                        if (dl8Var != null) {
                            view6 = dl8Var.o2();
                        }
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
                        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(0L);
                        animatorSet.setInterpolator(new DecelerateInterpolator());
                        if (this.h) {
                            if (panelType == PanelType.INPUT_KEYBOARD) {
                                if (panelType2 == PanelType.EXPRESSION) {
                                    animatorSet.play(ofFloat).with(ofFloat4).with(ofFloat2);
                                } else {
                                    animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat4);
                                }
                            } else if (panelType == PanelType.INPUTCHANGE) {
                                animatorSet.play(ofFloat2);
                            } else if (panelType == PanelType.EXPRESSION) {
                                animatorSet.play(ofFloat2).with(ofFloat);
                            } else {
                                animatorSet.play(ofFloat).with(ofFloat2);
                            }
                        } else {
                            animatorSet.play(ofFloat);
                        }
                        animatorSet.addListener(new e());
                        animatorSet.start();
                    }
                }
            }
            if (i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((z2 || panelType == PanelType.INPUTCHANGE) && panelType != PanelType.VOICE) {
                f3 = f2 + i;
                f4 = f;
                panelType3 = PanelType.VOICE;
                if (panelType != panelType3) {
                    dl8Var2 = this.d;
                    if (dl8Var2 == null) {
                    }
                    Intrinsics.checkNotNull(num);
                    f3 -= num.intValue();
                }
                ObjectAnimator ofFloat22 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
                Intrinsics.checkNotNullExpressionValue(ofFloat22, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
                if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
                }
                dl8Var = this.d;
                if (dl8Var != null) {
                }
                ObjectAnimator ofFloat42 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
                Intrinsics.checkNotNullExpressionValue(ofFloat42, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(0L);
                animatorSet2.setInterpolator(new DecelerateInterpolator());
                if (this.h) {
                }
                animatorSet2.addListener(new e());
                animatorSet2.start();
            }
            f4 = f + i;
            f3 = f2;
            panelType3 = PanelType.VOICE;
            if (panelType != panelType3) {
            }
            ObjectAnimator ofFloat222 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
            Intrinsics.checkNotNullExpressionValue(ofFloat222, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
            if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
            }
            dl8Var = this.d;
            if (dl8Var != null) {
            }
            ObjectAnimator ofFloat422 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat422, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
            AnimatorSet animatorSet22 = new AnimatorSet();
            animatorSet22.setDuration(0L);
            animatorSet22.setInterpolator(new DecelerateInterpolator());
            if (this.h) {
            }
            animatorSet22.addListener(new e());
            animatorSet22.start();
        }
    }
}
