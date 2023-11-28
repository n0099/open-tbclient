package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.re5;
import com.baidu.tieba.se5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbNewEditorTool extends re5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class InputShowType {
        public static final /* synthetic */ InputShowType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InputShowType REPLY;
        public static final InputShowType REPLY_BIG_IMAGE;
        public static final InputShowType REPLY_BIG_IMAGE_FLOOR;
        public static final InputShowType REPLY_FLOOR;
        public static final InputShowType REPLY_VIDEO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1638503652, "Lcom/baidu/tbadk/editortools/pb/PbNewEditorTool$InputShowType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1638503652, "Lcom/baidu/tbadk/editortools/pb/PbNewEditorTool$InputShowType;");
                    return;
                }
            }
            REPLY = new InputShowType("REPLY", 0);
            REPLY_FLOOR = new InputShowType("REPLY_FLOOR", 1);
            REPLY_VIDEO = new InputShowType("REPLY_VIDEO", 2);
            REPLY_BIG_IMAGE = new InputShowType("REPLY_BIG_IMAGE", 3);
            InputShowType inputShowType = new InputShowType("REPLY_BIG_IMAGE_FLOOR", 4);
            REPLY_BIG_IMAGE_FLOOR = inputShowType;
            $VALUES = new InputShowType[]{REPLY, REPLY_FLOOR, REPLY_VIDEO, REPLY_BIG_IMAGE, inputShowType};
        }

        public InputShowType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InputShowType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (InputShowType) Enum.valueOf(InputShowType.class, str);
            }
            return (InputShowType) invokeL.objValue;
        }

        public static InputShowType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (InputShowType[]) $VALUES.clone();
            }
            return (InputShowType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbNewEditorTool(Context context, boolean z, boolean z2, int i) {
        super(context, (String) null, 27);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.n = 3;
        PbNewInputContainer pbNewInputContainer = new PbNewInputContainer(context);
        this.m = pbNewInputContainer;
        pbNewInputContainer.setTransLink(!z);
        ((PbNewInputContainer) this.m).setmAtListRequestResponseCode(i);
        this.t = ((PbNewInputContainer) this.m).getInputView();
        ((PbNewInputContainer) this.m).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.m).g0(z2);
        this.p = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45, 70};
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, textWatcher) == null) {
            this.t.addTextChangedListener(textWatcher);
        }
    }

    public void j(int i) {
        se5 se5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (se5Var = this.m) != null) {
            ((PbNewInputContainer) se5Var).O(i);
        }
    }

    public void m(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textWatcher) == null) {
            this.t.removeTextChangedListener(textWatcher);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.m).setDefaultHint(str);
        }
    }

    public void o(InputShowType inputShowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inputShowType) == null) {
            se5 se5Var = this.m;
            if (se5Var instanceof PbNewInputContainer) {
                ((PbNewInputContainer) se5Var).setFromType(inputShowType);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.m).setHint(str);
        }
    }

    public void q(int i) {
        se5 se5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (se5Var = this.m) != null) {
            ((PbNewInputContainer) se5Var).setType(i);
        }
    }

    public EditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.t;
        }
        return (EditText) invokeV.objValue;
    }

    public void l() {
        se5 se5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (se5Var = this.m) != null) {
            ((PbNewInputContainer) se5Var).d0();
        }
    }
}
