package com.baidu.tieba.im.biz.aibot.keyboardtool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;", "", "(Ljava/lang/String;I)V", "INPUT_KEYBOARD", "VOICE", "EXPRESSION", "PICTURE", HlsPlaylistParser.METHOD_NONE, "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PanelType {
    public static final /* synthetic */ PanelType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PanelType EXPRESSION;
    public static final PanelType INPUT_KEYBOARD;
    public static final PanelType NONE;
    public static final PanelType PICTURE;
    public static final PanelType VOICE;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ PanelType[] $values() {
        return new PanelType[]{INPUT_KEYBOARD, VOICE, EXPRESSION, PICTURE, NONE};
    }

    public static PanelType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PanelType) Enum.valueOf(PanelType.class, str) : (PanelType) invokeL.objValue;
    }

    public static PanelType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PanelType[]) $VALUES.clone() : (PanelType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-728749564, "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-728749564, "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;");
                return;
            }
        }
        INPUT_KEYBOARD = new PanelType("INPUT_KEYBOARD", 0);
        VOICE = new PanelType("VOICE", 1);
        EXPRESSION = new PanelType("EXPRESSION", 2);
        PICTURE = new PanelType("PICTURE", 3);
        NONE = new PanelType(HlsPlaylistParser.METHOD_NONE, 4);
        $VALUES = $values();
    }

    public PanelType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }
}
