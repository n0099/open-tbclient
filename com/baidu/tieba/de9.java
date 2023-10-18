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
public final class de9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public afa b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public int b;
        public int c;
        public int d;
        public ee9 e;

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

        public final de9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new de9(this);
            }
            return (de9) invokeV.objValue;
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

        public final ee9 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (ee9) invokeV.objValue;
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

        public final a h(ee9 ee9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ee9Var)) == null) {
                this.e = ee9Var;
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

    public de9(a builder) {
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

    public static final void c(de9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ee9 d = this$0.a.d();
            if (d != null) {
                d.onShow();
            }
        }
    }

    public static final void d(de9 this$0, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ee9 d = this$0.a.d();
            if (d != null) {
                d.onDismiss();
            }
        }
    }

    public final void a() {
        afa afaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (afaVar = this.b) != null) {
            afaVar.dismiss();
        }
    }

    public final void b() {
        Window window;
        Window window2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = this.a.b().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            afa afaVar = new afa(context, R.style.obfuscated_res_0x7f1003d4);
            this.b = afaVar;
            if (afaVar != null && (window2 = afaVar.getWindow()) != null) {
                window2.setWindowAnimations(R.style.obfuscated_res_0x7f1003bf);
            }
            afa afaVar2 = this.b;
            if (afaVar2 != null && (window = afaVar2.getWindow()) != null) {
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
                afa afaVar3 = this.b;
                if (afaVar3 != null) {
                    afaVar3.setContentView(this.a.b());
                }
                GreyUtil.grey(this.b);
                afa afaVar4 = this.b;
                if (afaVar4 != null) {
                    afaVar4.setCancelable(true);
                }
                afa afaVar5 = this.b;
                if (afaVar5 != null) {
                    afaVar5.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.be9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                de9.c(de9.this, dialogInterface);
                            }
                        }
                    });
                }
                afa afaVar6 = this.b;
                if (afaVar6 != null) {
                    afaVar6.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ce9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                de9.d(de9.this, dialogInterface);
                            }
                        }
                    });
                }
                afa afaVar7 = this.b;
                if (afaVar7 != null) {
                    afaVar7.show();
                }
            }
        }
    }
}
