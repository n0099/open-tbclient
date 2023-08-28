package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.im.data.JsonMsgItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class df8 {
    public static /* synthetic */ Interceptable $ic;
    public static df8 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ArrayList<JsonMsgItem> b;
    public c c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947702739, "Lcom/baidu/tieba/df8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947702739, "Lcom/baidu/tieba/df8;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends TypeToken<List<JsonMsgItem>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(df8 df8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df8Var};
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
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JsonMsgItem a;
        public final /* synthetic */ df8 b;

        public b(df8 df8Var, JsonMsgItem jsonMsgItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df8Var, jsonMsgItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = df8Var;
            this.a = jsonMsgItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.c.a(this.a.getUrl());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.b.a.getResources().getColor(this.b.d(this.a.getColor())));
                textPaint.setUnderlineText(false);
            }
        }
    }

    public df8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.a = context;
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                if (this.b.get(i3) != null) {
                    i2 += this.b.get(i3).getText().length();
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int identifier = this.a.getResources().getIdentifier(str, "color", this.a.getPackageName());
            if (identifier == 0) {
                return this.a.getResources().getIdentifier("CAM_X0101", "color", this.a.getPackageName());
            }
            return identifier;
        }
        return invokeL.intValue;
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int identifier = this.a.getResources().getIdentifier(str, EMABTest.TYPE_DIMEN, this.a.getPackageName());
            if (identifier == 0) {
                return this.a.getResources().getIdentifier("T_X09", EMABTest.TYPE_DIMEN, this.a.getPackageName());
            }
            return identifier;
        }
        return invokeL.intValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!ugb.a(str)) {
                if (str.startsWith("{") && str.endsWith("}")) {
                    return true;
                }
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static df8 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                d = new df8(context);
            }
            return d;
        }
        return (df8) invokeL.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b = (ArrayList) new Gson().fromJson(str, new a(this).getType());
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public void h(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textView) == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.b.size(); i++) {
                JsonMsgItem jsonMsgItem = this.b.get(i);
                if (jsonMsgItem != null && !TextUtils.isEmpty(jsonMsgItem.getText())) {
                    SpannableString spannableString = new SpannableString(jsonMsgItem.getText());
                    spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(d(jsonMsgItem.getColor()))), 0, jsonMsgItem.getText().length(), 33);
                    spannableString.setSpan(new AbsoluteSizeSpan((int) this.a.getResources().getDimension(e(jsonMsgItem.getFont()))), 0, jsonMsgItem.getText().length(), 0);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    if (jsonMsgItem.getType().intValue() == 1) {
                        spannableStringBuilder.setSpan(new b(this, jsonMsgItem), c(i), c(i) + jsonMsgItem.getText().length(), 17);
                    }
                }
            }
            textView.setText(spannableStringBuilder);
        }
    }
}
