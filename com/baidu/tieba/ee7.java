package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.forum.ad.ForumAdVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ee7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final BdPageContextSupport<?> b;
    public final ViewGroup c;
    public final ForumAdVideoView d;
    public final AnimatorSet e;
    public final AnimatorSet f;
    public long g;
    public ForumData h;
    public fqa i;
    public Dialog j;
    public int k;
    public int l;
    public final n m;

    /* loaded from: classes5.dex */
    public interface n {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: classes5.dex */
    public interface o extends View.OnClickListener {
        void j(int i);
    }

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ ee7 f;

        public a(ee7 ee7Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ee7Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i - ((int) ((i - this.b) * floatValue));
                int i3 = this.c;
                int i4 = i3 - ((int) ((i3 - this.d) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 != layoutParams.width || i4 != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.e;
                    layoutParams2.width = i2;
                    layoutParams2.height = i4;
                    ee7 ee7Var = this.f;
                    ForumAdVideoView forumAdVideoView = ee7Var.d;
                    int i5 = this.f.k;
                    int i6 = this.f.l;
                    ViewGroup.LayoutParams layoutParams3 = this.e;
                    ee7Var.r(forumAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.c.getHeight());
                    this.f.d.setLayoutParams(this.e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        public b(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public c(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.d.setVisibility(8);
                xb.a(this.a.j, this.a.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public d(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // com.baidu.tieba.ee7.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji7.a("common_click", this.a.i, this.a.h, 2, "video");
            }
        }

        @Override // com.baidu.tieba.ee7.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ji7.f("common_exp", this.a.i, this.a.h, 2, "video");
            }
        }

        @Override // com.baidu.tieba.ee7.n
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ji7.a("common_click", this.a.i, this.a.h, 2, "frontpage");
            }
        }

        @Override // com.baidu.tieba.ee7.n
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ji7.c("c14592", this.a.i, this.a.h);
            }
        }

        @Override // com.baidu.tieba.ee7.n
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ji7.f("common_exp", this.a.i, this.a.h, 2, "frontpage");
            }
        }

        @Override // com.baidu.tieba.ee7.n
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                ji7.c("c14593", this.a.i, this.a.h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public e(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // com.baidu.tieba.ee7.o
        public void j(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 3) {
                this.a.k();
                this.a.m.f();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && !xx5.a(this.a.a, this.a.i.i())) {
                ji7.b((TbPageContext) a5.a(this.a.a), this.a.i.k(), this.a.i.q(), this.a.i.j());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public f(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (i == 4) {
                    this.a.m.f();
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                YunDialogManager.unMarkShowingDialogName("frsAd");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ ee7 f;

        public h(ee7 ee7Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ee7Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i + ((int) ((this.b - i) * floatValue));
                int i3 = this.c;
                int i4 = i3 + ((int) ((this.d - i3) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 != layoutParams.width || i4 != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.e;
                    layoutParams2.width = i2;
                    layoutParams2.height = i4;
                    ee7 ee7Var = this.f;
                    ForumAdVideoView forumAdVideoView = ee7Var.d;
                    int i5 = this.f.k;
                    int i6 = this.f.l;
                    ViewGroup.LayoutParams layoutParams3 = this.e;
                    ee7Var.r(forumAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.c.getHeight());
                    this.f.d.setLayoutParams(this.e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ee7 d;

        public i(ee7 ee7Var, ViewGroup.LayoutParams layoutParams, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, layoutParams, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ee7Var;
            this.a = layoutParams;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a;
                layoutParams.width = this.b;
                layoutParams.height = this.c;
                ee7 ee7Var = this.d;
                ForumAdVideoView forumAdVideoView = ee7Var.d;
                int i = this.d.k;
                int i2 = this.d.l;
                ViewGroup.LayoutParams layoutParams2 = this.a;
                ee7Var.r(forumAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.d.c.getHeight());
                this.d.d.setLayoutParams(this.a);
                this.d.d.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ViewGroup.LayoutParams c;
        public final /* synthetic */ ee7 d;

        public j(ee7 ee7Var, int i, int i2, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, Integer.valueOf(i), Integer.valueOf(i2), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ee7Var;
            this.a = i;
            this.b = i2;
            this.c = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int equipmentWidth = this.a + ((int) ((BdUtilHelper.getEquipmentWidth(this.d.a) - this.a) * floatValue));
                int height = this.b + ((int) ((this.d.c.getHeight() - this.b) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.c;
                if (equipmentWidth != layoutParams.width || height != layoutParams.height) {
                    ViewGroup.LayoutParams layoutParams2 = this.c;
                    layoutParams2.width = equipmentWidth;
                    layoutParams2.height = height;
                    ee7 ee7Var = this.d;
                    ForumAdVideoView forumAdVideoView = ee7Var.d;
                    int i = this.d.k;
                    int i2 = this.d.l;
                    ViewGroup.LayoutParams layoutParams3 = this.c;
                    ee7Var.r(forumAdVideoView, i, i2, layoutParams3.width, layoutParams3.height, this.d.c.getHeight());
                    this.d.d.setLayoutParams(this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        public k(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.d.z(1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            }
        }

        public l(ee7 ee7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var};
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
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ee7 b;

        public m(ee7 ee7Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee7Var;
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a;
                if (intValue != layoutParams.height) {
                    layoutParams.height = intValue;
                    ee7 ee7Var = this.b;
                    ForumAdVideoView forumAdVideoView = ee7Var.d;
                    int i = this.b.k;
                    int i2 = this.b.l;
                    ViewGroup.LayoutParams layoutParams2 = this.a;
                    ee7Var.r(forumAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.b.c.getHeight());
                    this.b.d.setLayoutParams(this.a);
                }
            }
        }
    }

    public ee7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new AnimatorSet();
        this.f = new AnimatorSet();
        this.m = new d(this);
        if (!(context instanceof BdPageContextSupport)) {
            this.a = null;
            this.c = null;
            this.d = null;
            this.b = null;
            return;
        }
        BdPageContextSupport<?> bdPageContextSupport = (BdPageContextSupport) context;
        this.b = bdPageContextSupport;
        Activity pageActivity = bdPageContextSupport.getPageContext().getPageActivity();
        this.a = pageActivity;
        this.c = (ViewGroup) pageActivity.findViewById(16908290);
        ForumAdVideoView forumAdVideoView = new ForumAdVideoView(this.a);
        this.d = forumAdVideoView;
        forumAdVideoView.setVisibility(8);
        this.d.setStateListener(new e(this));
        this.d.setFrsAdVideoStatisticListener(this.m);
    }

    public void k() {
        ForumAdVideoView forumAdVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.c != null && (forumAdVideoView = this.d) != null) {
            ViewGroup.LayoutParams layoutParams = forumAdVideoView.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(this.c.getHeight(), this.c.getWidth());
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new m(this, layoutParams));
            int width = this.c.getWidth();
            int width2 = (this.c.getWidth() * 3) / 4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new a(this, width, width2, this.c.getWidth(), width2 / 5, layoutParams));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(320L);
            ofFloat2.addListener(new b(this));
            ofFloat2.setStartDelay(640L);
            ofFloat2.start();
            this.f.addListener(new c(this));
            this.f.play(ofInt).before(ofFloat);
            this.f.start();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.s();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d.isPlayStarted()) {
            this.d.stopPlay();
        }
    }

    public void n(double d2, double d3, double d4, double d5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)}) == null) {
            this.k = (int) (d2 + (d4 / 2.0d));
            this.l = (int) (d3 + (d5 / 2.0d));
        }
    }

    public void o(fqa fqaVar, ForumData forumData, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{fqaVar, forumData, Long.valueOf(j2)}) == null) && this.a != null && this.c != null && this.d != null && fqaVar != null && !StringUtils.isNull(fqaVar.r())) {
            this.g = j2;
            this.h = forumData;
            this.i = fqaVar;
            this.d.setVideoData(fqaVar.r(), this.i.b());
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Dialog dialog = new Dialog(this.a, R.style.obfuscated_res_0x7f1003d6);
            this.j = dialog;
            dialog.requestWindowFeature(1);
            this.j.setContentView(this.d);
            this.j.setCancelable(true);
            this.j.setCanceledOnTouchOutside(true);
            if (this.j.getWindow() != null) {
                this.j.getWindow().getDecorView().setSystemUiVisibility(1280);
                this.j.getWindow().addFlags(Integer.MIN_VALUE);
                this.j.getWindow().setStatusBarColor(0);
                this.j.getWindow().setNavigationBarColor(0);
                WindowManager.LayoutParams attributes = this.j.getWindow().getAttributes();
                if (attributes != null) {
                    attributes.width = -1;
                    attributes.height = -1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        attributes.layoutInDisplayCutoutMode = 1;
                    }
                    this.j.getWindow().setAttributes(attributes);
                }
            }
            this.j.setOnKeyListener(new f(this));
            this.j.setOnDismissListener(new g(this));
            if (xb.i(this.j, this.a)) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putLong("key_frs_video_ad_last_show_time" + this.g, System.currentTimeMillis());
                this.m.e();
                YunDialogManager.markShowingDialogName("frsAd");
            }
        }
    }

    public void q() {
        ForumAdVideoView forumAdVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.c != null && (forumAdVideoView = this.d) != null && forumAdVideoView.getParent() == null && !this.a.isFinishing()) {
            p();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a) / 3;
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.a) / 9;
            int equipmentWidth2 = (BdUtilHelper.getEquipmentWidth(this.a) * 2) / 3;
            int equipmentWidth3 = (BdUtilHelper.getEquipmentWidth(this.a) * 2) / 3;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(180L);
            ofFloat.addUpdateListener(new h(this, equipmentWidth, equipmentWidth2, equipmentHeight, equipmentWidth3, layoutParams));
            ofFloat.addListener(new i(this, layoutParams, equipmentWidth, equipmentHeight));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(520L);
            ofFloat2.addUpdateListener(new j(this, equipmentWidth2, equipmentWidth3, layoutParams));
            this.e.addListener(new k(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setDuration(360L);
            ofFloat3.setStartDelay(240L);
            ofFloat3.addUpdateListener(new l(this));
            ofFloat3.start();
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat4.setDuration(1000L);
            this.e.setStartDelay(300L);
            this.e.play(ofFloat).before(ofFloat2).before(ofFloat4);
            this.e.start();
        }
    }

    public final void r(View view2, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = i2 - (i4 / 2);
            int max = Math.max(i3 - (i5 / 2), 0);
            if (max + i5 > i6) {
                max = i6 - i5;
            }
            float f2 = i7;
            if (view2.getX() != f2 || view2.getY() != max) {
                view2.setX(f2);
                view2.setY(max);
            }
        }
    }
}
