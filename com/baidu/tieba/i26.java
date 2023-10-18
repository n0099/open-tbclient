package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.c11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class i26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Dialog b;
    public final TextView c;
    public final RelativeLayout d;
    public final TextView e;
    public final RelativeLayout f;
    public final TextView g;
    public final RelativeLayout h;
    public boolean i;

    public i26(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0068, dg0.b().b(this.a), false);
        View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f09009b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.ad_back_alert_dialog_bg)");
        this.h = (RelativeLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ad_back_alert_dialog_description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a…alert_dialog_description)");
        this.c = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ad_back_alert_dialog_positive_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.a…t_dialog_positive_layout)");
        this.d = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.ad_back_alert_dialog_positive_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.a…t_dialog_positive_button)");
        this.e = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.ad_back_alert_dialog_negative_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.a…t_dialog_negative_layout)");
        this.f = (RelativeLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.ad_back_alert_dialog_negative_button);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.a…t_dialog_negative_button)");
        this.g = (TextView) findViewById6;
        Dialog dialog = new Dialog(this.a, R.style.obfuscated_res_0x7f100140);
        this.b = dialog;
        dialog.setContentView(inflate);
        Window window = this.b.getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = c11.c.e(this.a);
            window.setAttributes(attributes);
        }
        a();
    }

    public static final void f(i26 this$0, View.OnClickListener onClickListener, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, this$0, onClickListener, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b.dismiss();
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public static final void j(View.OnClickListener onClickListener, i26 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, onClickListener, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            this$0.b.dismiss();
        }
    }

    public static final boolean h(i26 this$0, DialogInterface.OnKeyListener onKeyListener, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{this$0, onKeyListener, dialogInterface, Integer.valueOf(i), keyEvent})) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.i) {
                z = true;
            } else {
                this$0.b.dismiss();
                if (onKeyListener != null) {
                    onKeyListener.onKey(dialogInterface, i, keyEvent);
                }
                z = false;
            }
            this$0.i = z;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EMManager.from(this.h).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0211);
            this.c.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public final i26 b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.b.setCancelable(z);
            return this;
        }
        return (i26) invokeZ.objValue;
    }

    public final i26 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.b.setCanceledOnTouchOutside(z);
            return this;
        }
        return (i26) invokeZ.objValue;
    }

    public final i26 e(final View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onClickListener)) == null) {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.g26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        i26.f(i26.this, onClickListener, view2);
                    }
                }
            });
            return this;
        }
        return (i26) invokeL.objValue;
    }

    public final i26 g(final DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onKeyListener)) == null) {
            this.b.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.f26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i26.h(i26.this, onKeyListener, dialogInterface, i, keyEvent) : invokeLIL.booleanValue;
                }
            });
            return this;
        }
        return (i26) invokeL.objValue;
    }

    public final i26 i(final View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onClickListener)) == null) {
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        i26.j(onClickListener, this, view2);
                    }
                }
            });
            return this;
        }
        return (i26) invokeL.objValue;
    }

    public final i26 d(ApkDownloadInfoData data) {
        InterceptResult invokeL;
        int indexOf$default;
        SpannableString spannableString;
        int i;
        boolean z;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            String appName = data.getApkName();
            if (TextUtils.equals(data.getBackAlertRemindType(), "reminded_type_un_open")) {
                this.e.setText(TbadkCoreApplication.getInst().getString(R.string.plugin_go_experience));
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eb9);
                Intrinsics.checkNotNullExpressionValue(string, "getInst()\n              …k_dialog_experience_text)");
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, "%s", 0, false, 6, (Object) null);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(string, Arrays.copyOf(new Object[]{appName}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                spannableString = new SpannableString(format);
            } else {
                this.e.setText(TbadkCoreApplication.getInst().getString(R.string.plugin_go_install));
                String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eba);
                Intrinsics.checkNotNullExpressionValue(string2, "getInst()\n              …back_dialog_install_text)");
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string2, "%s", 0, false, 6, (Object) null);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{appName}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                spannableString = new SpannableString(format2);
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            Intrinsics.checkNotNullExpressionValue(appName, "appName");
            int length = appName.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length) {
                if (!z3) {
                    i2 = i3;
                } else {
                    i2 = length;
                }
                if (Intrinsics.compare((int) appName.charAt(i2), 32) <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z3) {
                    if (!z2) {
                        z3 = true;
                    } else {
                        i3++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            if (!TextUtils.isEmpty(appName.subSequence(i3, length + 1).toString())) {
                int length2 = appName.length() - 1;
                int i4 = 0;
                boolean z4 = false;
                while (i4 <= length2) {
                    if (!z4) {
                        i = i4;
                    } else {
                        i = length2;
                    }
                    if (Intrinsics.compare((int) appName.charAt(i), 32) <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z4) {
                        if (!z) {
                            z4 = true;
                        } else {
                            i4++;
                        }
                    } else if (!z) {
                        break;
                    } else {
                        length2--;
                    }
                }
                int length3 = appName.subSequence(i4, length2 + 1).toString().length() + indexOf$default;
                if (spannableString.length() < length3) {
                    return this;
                }
                spannableString.setSpan(foregroundColorSpan, indexOf$default, length3, 18);
            }
            this.c.setText(spannableString);
            return this;
        }
        return (i26) invokeL.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hb.i(this.b, this.a);
        }
    }
}
