package com.baidu.tbadk.editortools.meme.pan;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanStateType;", "", "(Ljava/lang/String;I)V", "UNINPUT_SHOW", "UNINPUT_HIDE", "INPUT_SHOW", "INPUT_HIDE", TornadoLiteRuntime.STATE_INIT, "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemePanStateType {
    public static final /* synthetic */ SpriteMemePanStateType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SpriteMemePanStateType INIT;
    public static final SpriteMemePanStateType INPUT_HIDE;
    public static final SpriteMemePanStateType INPUT_SHOW;
    public static final SpriteMemePanStateType UNINPUT_HIDE;
    public static final SpriteMemePanStateType UNINPUT_SHOW;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ SpriteMemePanStateType[] $values() {
        return new SpriteMemePanStateType[]{UNINPUT_SHOW, UNINPUT_HIDE, INPUT_SHOW, INPUT_HIDE, INIT};
    }

    public static SpriteMemePanStateType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SpriteMemePanStateType) Enum.valueOf(SpriteMemePanStateType.class, str) : (SpriteMemePanStateType) invokeL.objValue;
    }

    public static SpriteMemePanStateType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SpriteMemePanStateType[]) $VALUES.clone() : (SpriteMemePanStateType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1222435979, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanStateType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1222435979, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanStateType;");
                return;
            }
        }
        UNINPUT_SHOW = new SpriteMemePanStateType("UNINPUT_SHOW", 0);
        UNINPUT_HIDE = new SpriteMemePanStateType("UNINPUT_HIDE", 1);
        INPUT_SHOW = new SpriteMemePanStateType("INPUT_SHOW", 2);
        INPUT_HIDE = new SpriteMemePanStateType("INPUT_HIDE", 3);
        INIT = new SpriteMemePanStateType(TornadoLiteRuntime.STATE_INIT, 4);
        $VALUES = $values();
    }

    public SpriteMemePanStateType(String str, int i) {
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
