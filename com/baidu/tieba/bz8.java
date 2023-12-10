package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.under.common.uiliststyle.group.emjio.view.EmojiReplyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutTransition a;
    public EmojiReplyView b;
    public EmojiReplyView.AlignMode c;

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                View view2 = (View) ((ObjectAnimator) animator).getTarget();
                view2.setScaleX(1.0f);
                view2.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                View view2 = (View) ((ObjectAnimator) animator).getTarget();
                view2.setScaleX(1.0f);
                view2.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setAlpha(1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setAlpha(1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setRotationY(0.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setRotationY(0.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setRotationX(0.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(bz8 bz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ((View) ((ObjectAnimator) animator).getTarget()).setRotationX(0.0f);
            }
        }
    }

    public bz8(LayoutTransition layoutTransition, EmojiReplyView emojiReplyView, EmojiReplyView.AlignMode alignMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {layoutTransition, emojiReplyView, alignMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = layoutTransition;
        this.b = emojiReplyView;
        this.c = alignMode;
        emojiReplyView.setLayoutTransition(layoutTransition);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
            if (this.c == EmojiReplyView.AlignMode.LEFT) {
                h();
                j();
                d();
                f();
                return;
            }
            g();
            i();
            c();
            e();
        }
    }

    public final void b(boolean z) {
        LayoutTransition layoutTransition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (layoutTransition = this.a) != null) {
            if (z) {
                layoutTransition.enableTransitionType(2);
                this.a.enableTransitionType(3);
                this.a.enableTransitionType(0);
                this.a.enableTransitionType(1);
                return;
            }
            layoutTransition.disableTransitionType(2);
            this.a.disableTransitionType(3);
            this.a.disableTransitionType(0);
            this.a.disableTransitionType(1);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.0f, 1.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 1.0f);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 300.0f, 0.0f), ofFloat, ofFloat2, PropertyValuesHolder.ofFloat("pivotX", 1.0f), PropertyValuesHolder.ofFloat("pivotY", 0.5f), PropertyValuesHolder.ofKeyframe(Key.ALPHA, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, 0.5f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(this.a.getDuration(2));
            this.a.setAnimator(2, duration);
            duration.addListener(new e(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofInt("left", 1, 1), PropertyValuesHolder.ofInt("top", 1, 1), PropertyValuesHolder.ofInt("right", 1, 1), PropertyValuesHolder.ofInt("bottom", 1, 1), PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.0f, 1.0f)).setDuration(this.a.getDuration(1));
            this.a.setAnimator(1, duration);
            duration.addListener(new c(this));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.0f, 1.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 1.0f);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("pivotX", 0.0f), PropertyValuesHolder.ofFloat("pivotY", 0.5f), ofFloat, ofFloat2).setDuration(this.a.getDuration(2));
            this.a.setAnimator(2, duration);
            duration.addListener(new f(this));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 1.0f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("pivotX", 1.0f);
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("pivotY", 0.5f);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 0.0f, 300.0f), ofFloat3, ofFloat4).setDuration(this.a.getDuration(3));
            this.a.setAnimator(3, duration);
            duration.addListener(new g(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 0.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 1.0f);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("pivotX", 0.5f), PropertyValuesHolder.ofFloat("pivotY", 0.5f), ofFloat, ofFloat2).setDuration(this.a.getDuration(3));
            this.a.setAnimator(3, duration);
            duration.addListener(new h(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, Key.TRANSLATION_X, 0.0f, 1.0f, 0.0f).setDuration(this.a.getDuration(0));
            this.a.setAnimator(0, duration);
            duration.addListener(new b(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("left", 1, 1);
            PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("top", 1, 1);
            PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("right", 1, 1);
            PropertyValuesHolder ofInt4 = PropertyValuesHolder.ofInt("bottom", 1, 1);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 1.0f, 0.0f, 1.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("pivotX", 0.5f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("pivotY", 0.5f);
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, ofInt, ofInt2, ofInt3, ofInt4, ofFloat, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f, 1.0f), ofFloat2, ofFloat3).setDuration(this.a.getDuration(0));
            this.a.setAnimator(0, duration);
            duration.addListener(new a(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, 0.0f, 1.0f)).setDuration(this.a.getDuration(1));
            this.a.setAnimator(1, duration);
            duration.addListener(new d(this));
        }
    }
}
