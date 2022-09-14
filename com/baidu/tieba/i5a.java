package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes4.dex */
public final class i5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";
    public static final i5a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ k5a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public a(PayDialogType payDialogType, k5a k5aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, k5aVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.b = k5aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                i5a i5aVar = i5a.b;
                String str = i5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("empty click payDialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                k5a k5aVar = this.b;
                if (k5aVar != null) {
                    if (k5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (k5aVar.b(this.c)) {
                        i5a i5aVar2 = i5a.b;
                        String str2 = i5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("empty click intercept ");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    i5a i5aVar3 = i5a.b;
                    String str3 = i5a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("empty click onInterceptView ");
                    PayDialogType payDialogType3 = this.a;
                    sb3.append(payDialogType3 != null ? payDialogType3.name() : null);
                    RLog.info(str3, sb3.toString());
                    return;
                }
                k5a k5aVar2 = this.b;
                if (k5aVar2 != null) {
                    k5aVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ k5a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public b(PayDialogType payDialogType, k5a k5aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, k5aVar, dialog, iViewEventListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.b = k5aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                i5a i5aVar = i5a.b;
                String str = i5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("btn close payDialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                k5a k5aVar = this.b;
                if (k5aVar != null) {
                    if (k5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (k5aVar.b(this.c)) {
                        i5a i5aVar2 = i5a.b;
                        String str2 = i5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("btn close intercept :");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    i5a i5aVar3 = i5a.b;
                    String str3 = i5a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("btn close onInterceptView :");
                    PayDialogType payDialogType3 = this.a;
                    sb3.append(payDialogType3 != null ? payDialogType3.name() : null);
                    RLog.info(str3, sb3.toString());
                    return;
                }
                k5a k5aVar2 = this.b;
                if (k5aVar2 != null) {
                    k5aVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k5a a;
        public final /* synthetic */ n5a b;

        public c(k5a k5aVar, n5a n5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k5aVar, n5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k5aVar;
            this.b = n5aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                k5a k5aVar = this.a;
                if (k5aVar != null) {
                    k5aVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                i5a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k5a a;
        public final /* synthetic */ n5a b;

        public d(k5a k5aVar, n5a n5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k5aVar, n5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k5aVar;
            this.b = n5aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                k5a k5aVar = this.a;
                if (k5aVar != null) {
                    k5aVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                i5a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ k5a b;

        public e(PayDialogType payDialogType, k5a k5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, k5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payDialogType;
            this.b = k5aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            k5a k5aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                i5a i5aVar = i5a.b;
                String str = i5a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("onKey keyCode:");
                sb.append(i);
                sb.append(" dialogType:");
                PayDialogType payDialogType = this.a;
                sb.append(payDialogType != null ? payDialogType.name() : null);
                RLog.info(str, sb.toString());
                if (keyEvent.getAction() == 0 && i == 4 && (k5aVar = this.b) != null) {
                    if (k5aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (k5aVar.b(dialogInterface)) {
                        i5a i5aVar2 = i5a.b;
                        String str2 = i5a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onKey intercept ");
                        PayDialogType payDialogType2 = this.a;
                        sb2.append(payDialogType2 != null ? payDialogType2.name() : null);
                        RLog.info(str2, sb2.toString());
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947805876, "Lcom/baidu/tieba/i5a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947805876, "Lcom/baidu/tieba/i5a;");
                return;
            }
        }
        b = new i5a();
    }

    public i5a() {
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

    public final void b(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091c7a);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091015);
        if (viewGroup == null || imageView == null) {
            return;
        }
        viewGroup.setVisibility(8);
        Object tag = imageView.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            RLog.debug(a, "hideDialogLoading oldRotateAnimator cancel()");
        }
    }

    public final void c(Context context, String str, View view2, k5a k5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, view2, k5aVar, iViewEventListener, payDialogType, dialog}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014f);
            window.setContentView(R.layout.obfuscated_res_0x7f0d069f);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f092417);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            window.findViewById(R.id.obfuscated_res_0x7f091c64).setOnClickListener(new a(payDialogType, k5aVar, dialog, iViewEventListener));
            ((Button) window.findViewById(R.id.obfuscated_res_0x7f09042f)).setOnClickListener(new b(payDialogType, k5aVar, dialog, iViewEventListener));
            ((ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906d3)).addView(view2);
        }
    }

    public final Dialog d(Context context, String str, View view2, k5a k5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, k5aVar, iViewEventListener, payDialogType, payFlowType})) == null) ? e(context, str, view2, k5aVar, iViewEventListener, payDialogType, payFlowType, null) : (Dialog) invokeCommon.objValue;
    }

    public final Dialog e(Context context, String str, View view2, k5a k5aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, o5a o5aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, view2, k5aVar, iViewEventListener, payDialogType, payFlowType, o5aVar})) == null) {
            if (!x4a.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            n5a n5aVar = new n5a(context, R.style.obfuscated_res_0x7f100153, payFlowType, o5aVar);
            n5aVar.setCancelable(true);
            n5aVar.setCanceledOnTouchOutside(true);
            n5aVar.show();
            n5aVar.setOnDismissListener(new c(k5aVar, n5aVar));
            n5aVar.setOnCancelListener(new d(k5aVar, n5aVar));
            n5aVar.setOnKeyListener(new e(payDialogType, k5aVar));
            c(context, str, view2, k5aVar, iViewEventListener, payDialogType, n5aVar);
            return n5aVar;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final void f(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dialog) == null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091c7a);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091015);
        if (viewGroup == null || imageView == null) {
            return;
        }
        Object tag = imageView.getTag();
        if (!(tag instanceof ObjectAnimator)) {
            tag = null;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) tag;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            RLog.debug(a, "showDialogLoading oldRotateAnimator cancel()");
        }
        viewGroup.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, 0.0f, 360.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
        RLog.debug(a, "showDialogLoading mRotateAnimator start()");
    }
}
