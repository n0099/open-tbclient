package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public kga b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public int b;
        public int c;
        public int d;
        public eh9 e;

        public a(View contentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            this.a = contentView;
            this.d = 51;
        }

        public final dh9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new dh9(this);
            }
            return (dh9) invokeV.objValue;
        }

        public final View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public final eh9 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (eh9) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a h(eh9 eh9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eh9Var)) == null) {
                this.e = eh9Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public dh9(a builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = builder;
    }

    public static final void c(dh9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            eh9 d = this$0.a.d();
            if (d != null) {
                d.onShow();
            }
        }
    }

    public static final void d(dh9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            eh9 d = this$0.a.d();
            if (d != null) {
                d.onDismiss();
            }
        }
    }

    public final void a() {
        kga kgaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kgaVar = this.b) != null) {
            kgaVar.dismiss();
        }
    }

    public final void b() {
        Window window;
        Window window2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = this.a.b().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            kga kgaVar = new kga(context, R.style.obfuscated_res_0x7f1003cd);
            this.b = kgaVar;
            if (kgaVar != null && (window2 = kgaVar.getWindow()) != null) {
                window2.setWindowAnimations(R.style.obfuscated_res_0x7f1003ba);
            }
            kga kgaVar2 = this.b;
            if (kgaVar2 != null && (window = kgaVar2.getWindow()) != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    window.getDecorView().setSystemUiVisibility(1280);
                } else {
                    window.getDecorView().setSystemUiVisibility(9472);
                }
                window.addFlags(Integer.MIN_VALUE);
                window.addFlags(512);
                window.setType(1000);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -2;
                attributes.height = -2;
                attributes.x = this.a.e();
                attributes.y = this.a.f();
                attributes.gravity = this.a.c();
                window.setAttributes(attributes);
                kga kgaVar3 = this.b;
                if (kgaVar3 != null) {
                    kgaVar3.setContentView(this.a.b());
                }
                GreyUtil.grey(this.b);
                kga kgaVar4 = this.b;
                if (kgaVar4 != null) {
                    kgaVar4.setCancelable(true);
                }
                kga kgaVar5 = this.b;
                if (kgaVar5 != null) {
                    kgaVar5.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.bh9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                dh9.c(dh9.this, dialogInterface);
                            }
                        }
                    });
                }
                kga kgaVar6 = this.b;
                if (kgaVar6 != null) {
                    kgaVar6.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ch9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                dh9.d(dh9.this, dialogInterface);
                            }
                        }
                    });
                }
                kga kgaVar7 = this.b;
                if (kgaVar7 != null) {
                    kgaVar7.show();
                }
            }
        }
    }
}
