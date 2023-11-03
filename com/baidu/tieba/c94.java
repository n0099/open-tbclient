package com.baidu.tieba;

import android.graphics.Color;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
/* loaded from: classes5.dex */
public class c94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    @V8JavascriptField
    public String backgroundColor;
    @V8JavascriptField
    public String borderColor;
    @V8JavascriptField
    public double borderRadius;
    @V8JavascriptField
    public int borderWidth;
    @V8JavascriptField
    public String color;
    @V8JavascriptField
    public double fontSize;
    @V8JavascriptField
    public String fontWeight;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public boolean hidden;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int lineHeight;
    @V8JavascriptField
    public double opacity;
    @V8JavascriptField
    public String textAlign;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes5.dex */
    public interface a {
        void r();
    }

    public c94(@NonNull oy1 oy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontSize = 16.0d;
        this.opacity = 1.0d;
        a(oy1Var);
    }

    public static int c(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            int i2 = (16711680 & i) >> 16;
            int i3 = (65280 & i) >> 8;
            int i4 = i & 255;
            float f = (((-16777216) & i) >>> 24) / 255.0f;
            if (f > 0.0f) {
                return Color.argb(255, (int) ((i2 * f) + 0.5d), (int) ((i3 * f) + 0.5d), (int) ((i4 * f) + 0.5d));
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final void a(@NonNull oy1 oy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oy1Var) == null) {
            this.left = oy1Var.s("left", this.left);
            this.top = oy1Var.s("top", this.top);
            this.width = oy1Var.s("width", this.width);
            this.height = oy1Var.s("height", this.height);
            this.backgroundColor = oy1Var.D(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, this.backgroundColor);
            this.borderColor = oy1Var.D("borderColor", this.borderColor);
            this.borderRadius = oy1Var.o("borderRadius", this.borderRadius);
            this.borderWidth = oy1Var.s("borderWidth", this.borderWidth);
            this.fontSize = oy1Var.o(TtmlNode.ATTR_TTS_FONT_SIZE, this.fontSize);
            this.lineHeight = oy1Var.s("lineHeight", this.lineHeight);
            this.textAlign = oy1Var.D(TtmlNode.ATTR_TTS_TEXT_ALIGN, this.textAlign);
            this.fontWeight = oy1Var.D(TtmlNode.ATTR_TTS_FONT_WEIGHT, this.fontWeight);
            this.hidden = oy1Var.n("hidden", this.hidden);
            this.opacity = oy1Var.o(NativeConstants.OPACITY, this.opacity);
            this.color = oy1Var.D("color", this.color);
            if (rm1.a) {
                Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.a = aVar;
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (rm1.a) {
                Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.r();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
        }
        return (String) invokeV.objValue;
    }
}
