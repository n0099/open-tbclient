package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "PrivacyPolicyDialogUtil")
/* loaded from: classes5.dex */
public final class f46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends e46 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                Context context = this.a;
                BrowserHelper.startExternWebActivity(context, TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/secretright.html");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends e46 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                BrowserHelper.startExternWebActivity(this.a, "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }
    }

    public static final s45 a(TbPageContext<?> tbPageContext, View.OnClickListener listener, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65536, null, tbPageContext, listener, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0821, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…olicy_guide_dialog, null)");
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09258f);
            eMTextView.setText(R.string.secret_hint_head);
            EMManager.from(eMTextView).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X05);
            EMTextView eMTextView2 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907c5);
            eMTextView2.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(contentTestResId)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.privacy_policy_text), tbPageContext.getString(R.string.user_protocol_text)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d = d(pageActivity, format);
            eMTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            eMTextView2.setText(d);
            EMManager.from(eMTextView2).setTextSize(R.dimen.T_X07);
            EMTextView eMTextView3 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090495);
            eMTextView3.setText(i2);
            EMManager.from(eMTextView3).setTextSize(R.dimen.T_X08);
            eMTextView3.setOnClickListener(listener);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f092aa2);
            tBSpecificationBtn.setText(tbPageContext.getString(R.string.secret_hint_agree_and_go_on));
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            ea5 ea5Var = new ea5();
            ea5Var.s(R.color.CAM_X0303, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(ea5Var);
            tBSpecificationBtn.setOnClickListener(listener);
            s45 s45Var = new s45(tbPageContext.getPageActivity());
            s45Var.setContentView(inflate);
            s45Var.setContentViewSize(8);
            s45Var.setAutoNight(false);
            s45Var.setCanceledOnTouchOutside(false);
            s45Var.setCancelable(false);
            s45Var.create(tbPageContext);
            return s45Var;
        }
        return (s45) invokeLLII.objValue;
    }

    public static final s45 b(TbPageContext<?> tbPageContext, View.OnClickListener listener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, listener)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0822, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…rivate_hint_dialog, null)");
            ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
            inflate.findViewById(R.id.protocol_layout).setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
            textView.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(R.string.secret_hint_format);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(…tring.secret_hint_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.secret_hint_footer), tbPageContext.getString(R.string.secret_hint_title), tbPageContext.getString(R.string.secret_hint_content_1), tbPageContext.getString(R.string.secret_hint_content_2), tbPageContext.getString(R.string.secret_hint_content_3), tbPageContext.getString(R.string.secret_hint_content_4), tbPageContext.getString(R.string.secret_hint_content_5)}, 7));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d = d(pageActivity, format);
            Matcher matcher = Pattern.compile("\n\n").matcher(format);
            while (matcher.find()) {
                d.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(d);
            TextView textView2 = (TextView) inflate.findViewById(R.id.private_no);
            textView2.setOnClickListener(listener);
            SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.private_yes);
            textView3.setOnClickListener(listener);
            EMManager.from(textView3).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            s45 s45Var = new s45(tbPageContext.getPageActivity());
            s45Var.setContentView(inflate);
            s45Var.setContentViewSize(7);
            s45Var.setCanceledOnTouchOutside(false);
            s45Var.setAutoNight(false);
            s45Var.setCancelable(false);
            s45Var.create(tbPageContext);
            return s45Var;
        }
        return (s45) invokeLL.objValue;
    }

    public static final int[] c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            String string = TbadkCoreApplication.getInst().getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(patternTextResId)");
            int[] iArr = {StringsKt__StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null), iArr[0] + string.length()};
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static final SpannableString d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            int[] c = c(str, R.string.privacy_policy_text);
            if (c[0] != -1) {
                spannableString.setSpan(new a(context), c[0], c[1], 18);
            }
            int[] c2 = c(str, R.string.user_protocol_text);
            if (c2[0] != -1) {
                spannableString.setSpan(new b(context), c2[0], c2[1], 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }
}
