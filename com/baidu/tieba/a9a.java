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
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.IViewEventListener;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes3.dex */
public final class a9a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "BottomDialogManager";
    public static final a9a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ c9a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public a(PayDialogType payDialogType, c9a c9aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, c9aVar, dialog, iViewEventListener};
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
            this.b = c9aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a9a a9aVar = a9a.b;
                String str2 = a9a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("empty click payDialogType:");
                PayDialogType payDialogType = this.a;
                String str3 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(str2, sb.toString());
                c9a c9aVar = this.b;
                if (c9aVar != null) {
                    if (c9aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (c9aVar.b(this.c, CancelType.EMPTY_AREA_CLICK)) {
                        a9a a9aVar2 = a9a.b;
                        String str4 = a9a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("empty click intercept ");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str3 = payDialogType2.name();
                        }
                        sb2.append(str3);
                        RLog.info(str4, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.EMPTY_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    a9a a9aVar3 = a9a.b;
                    String str5 = a9a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("empty click onInterceptView ");
                    PayDialogType payDialogType3 = this.a;
                    if (payDialogType3 != null) {
                        str3 = payDialogType3.name();
                    }
                    sb3.append(str3);
                    RLog.info(str5, sb3.toString());
                    return;
                }
                c9a c9aVar2 = this.b;
                if (c9aVar2 != null) {
                    c9aVar2.a(CancelType.EMPTY_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ c9a b;
        public final /* synthetic */ Dialog c;
        public final /* synthetic */ IViewEventListener d;

        public b(PayDialogType payDialogType, c9a c9aVar, Dialog dialog, IViewEventListener iViewEventListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, c9aVar, dialog, iViewEventListener};
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
            this.b = c9aVar;
            this.c = dialog;
            this.d = iViewEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a9a a9aVar = a9a.b;
                String str2 = a9a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("btn close payDialogType:");
                PayDialogType payDialogType = this.a;
                String str3 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(str2, sb.toString());
                c9a c9aVar = this.b;
                if (c9aVar != null) {
                    if (c9aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (c9aVar.b(this.c, CancelType.BUTTOM_AREA_CLICK)) {
                        a9a a9aVar2 = a9a.b;
                        String str4 = a9a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("btn close intercept :");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str3 = payDialogType2.name();
                        }
                        sb2.append(str3);
                        RLog.info(str4, sb2.toString());
                        return;
                    }
                }
                PayViewInfo payViewInfo = new PayViewInfo();
                payViewInfo.clickArea = CancelType.BUTTOM_AREA_CLICK;
                payViewInfo.payDialogType = this.a;
                payViewInfo.viewDialog = this.c;
                IViewEventListener iViewEventListener = this.d;
                if (iViewEventListener != null && iViewEventListener.onInterceptView(payViewInfo)) {
                    a9a a9aVar3 = a9a.b;
                    String str5 = a9a.a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("btn close onInterceptView :");
                    PayDialogType payDialogType3 = this.a;
                    if (payDialogType3 != null) {
                        str3 = payDialogType3.name();
                    }
                    sb3.append(str3);
                    RLog.info(str5, sb3.toString());
                    return;
                }
                c9a c9aVar2 = this.b;
                if (c9aVar2 != null) {
                    c9aVar2.a(CancelType.BUTTOM_AREA_CLICK);
                }
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c9a a;
        public final /* synthetic */ f9a b;

        public c(c9a c9aVar, f9a f9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c9aVar, f9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c9aVar;
            this.b = f9aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                c9a c9aVar = this.a;
                if (c9aVar != null) {
                    c9aVar.a(CancelType.ON_DIALOG_DISMISS);
                }
                a9a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c9a a;
        public final /* synthetic */ f9a b;

        public d(c9a c9aVar, f9a f9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c9aVar, f9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c9aVar;
            this.b = f9aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                c9a c9aVar = this.a;
                if (c9aVar != null) {
                    c9aVar.a(CancelType.ON_DIALOG_CANCEL);
                }
                a9a.b.b(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayDialogType a;
        public final /* synthetic */ c9a b;

        public e(PayDialogType payDialogType, c9a c9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDialogType, c9aVar};
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
            this.b = c9aVar;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            String str;
            c9a c9aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                a9a a9aVar = a9a.b;
                String str2 = a9a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("onKey keyCode:");
                sb.append(i);
                sb.append(" dialogType:");
                PayDialogType payDialogType = this.a;
                String str3 = null;
                if (payDialogType != null) {
                    str = payDialogType.name();
                } else {
                    str = null;
                }
                sb.append(str);
                RLog.info(str2, sb.toString());
                if (keyEvent.getAction() == 0 && i == 4 && (c9aVar = this.b) != null) {
                    if (c9aVar == null) {
                        Intrinsics.throwNpe();
                    }
                    if (c9aVar.b(dialogInterface, CancelType.ON_DIALOG_CANCEL)) {
                        a9a a9aVar2 = a9a.b;
                        String str4 = a9a.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onKey intercept ");
                        PayDialogType payDialogType2 = this.a;
                        if (payDialogType2 != null) {
                            str3 = payDialogType2.name();
                        }
                        sb2.append(str3);
                        RLog.info(str4, sb2.toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947571392, "Lcom/baidu/tieba/a9a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947571392, "Lcom/baidu/tieba/a9a;");
                return;
            }
        }
        b = new a9a();
    }

    public a9a() {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, dialog) != null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ccd);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091047);
        if (viewGroup != null && imageView != null) {
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
    }

    public final void c(Context context, PayUIKitConfig payUIKitConfig, String str, View view2, c9a c9aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, Dialog dialog, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, payUIKitConfig, str, view2, c9aVar, iViewEventListener, payDialogType, dialog, Boolean.valueOf(z)}) == null) {
            Window window = dialog.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "bottomDialog.getWindow()");
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "window.getAttributes()");
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10014f);
            window.setContentView(R.layout.obfuscated_res_0x7f0d06b5);
            View findViewById = window.findViewById(R.id.obfuscated_res_0x7f092469);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "window.findViewById<TextView>(R.id.tv_title)");
            ((TextView) findViewById).setText(str);
            ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f0906eb);
            Button button = (Button) window.findViewById(R.id.obfuscated_res_0x7f090446);
            View findViewById2 = window.findViewById(R.id.obfuscated_res_0x7f091cb7);
            View findViewById3 = window.findViewById(R.id.obfuscated_res_0x7f091426);
            if (payUIKitConfig != null) {
                if (l8a.a.b(payUIKitConfig)) {
                    i = R.drawable.obfuscated_res_0x7f080ee1;
                } else {
                    i = R.drawable.obfuscated_res_0x7f080ee2;
                }
                findViewById3.setBackgroundResource(i);
            }
            findViewById2.setOnClickListener(new a(payDialogType, c9aVar, dialog, iViewEventListener));
            button.setOnClickListener(new b(payDialogType, c9aVar, dialog, iViewEventListener));
            if (z && context != null) {
                viewGroup.setBackgroundColor(context.getResources().getColor(R.color.obfuscated_res_0x7f0608ef));
                viewGroup.setPadding(0, 0, 0, 0);
            }
            viewGroup.addView(view2);
        }
    }

    public final Dialog d(Context context, String str, View view2, c9a c9aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, view2, c9aVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig})) == null) {
            return e(context, str, view2, c9aVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig, false);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog e(Context context, String str, View view2, c9a c9aVar, IViewEventListener iViewEventListener, PayDialogType payDialogType, PayFlowType payFlowType, PayUIKitConfig payUIKitConfig, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, view2, c9aVar, iViewEventListener, payDialogType, payFlowType, payUIKitConfig, Boolean.valueOf(z)})) == null) {
            if (!n8a.a.a(context)) {
                RLog.info(a, "showSimpleNumberInputDialog ActivityInvalid....");
                return null;
            }
            f9a f9aVar = new f9a(context, R.style.obfuscated_res_0x7f100153, payFlowType);
            f9aVar.setCancelable(true);
            f9aVar.setCanceledOnTouchOutside(true);
            f9aVar.show();
            f9aVar.setOnDismissListener(new c(c9aVar, f9aVar));
            f9aVar.setOnCancelListener(new d(c9aVar, f9aVar));
            f9aVar.setOnKeyListener(new e(payDialogType, c9aVar));
            c(context, payUIKitConfig, str, view2, c9aVar, iViewEventListener, payDialogType, f9aVar, z);
            return f9aVar;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final void f(Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, dialog) != null) || dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "dialog.getWindow()");
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.obfuscated_res_0x7f091ccd);
        ImageView imageView = (ImageView) window.findViewById(R.id.obfuscated_res_0x7f091047);
        if (viewGroup != null && imageView != null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i…le, \"rotation\", 0f, 360f)");
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            imageView.setTag(ofFloat);
            RLog.debug(a, "showDialogLoading mRotateAnimator start()");
        }
    }
}
