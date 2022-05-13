package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di8;
import com.repackage.j15;
import com.repackage.r15;
import com.repackage.w05;
/* loaded from: classes3.dex */
public class SendView extends TextView implements j15 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int f = 1;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean[] c;
    public int[] d;
    public int e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendView a;

        public a(SendView sendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g(new w05(8, -1, null));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1381963171, "Lcom/baidu/tbadk/editortools/sendtool/SendView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1381963171, "Lcom/baidu/tbadk/editortools/sendtool/SendView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new boolean[]{false, false, false, false, false};
        this.d = new int[]{0, 0};
        this.e = g;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025c), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
        setTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        setText(R.string.obfuscated_res_0x7f0f1102);
        setOnClickListener(new a(this));
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == g) {
                boolean[] zArr = this.c;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
            } else if (i == f) {
                if (this.c[1]) {
                    setEnabled(true);
                } else {
                    setEnabled(false);
                }
            }
        }
    }

    @Override // com.repackage.j15
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.repackage.j15
    public void g(w05 w05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w05Var) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(w05Var);
    }

    @Override // com.repackage.j15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.repackage.j15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.j15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setClickable(false);
        }
    }

    @Override // com.repackage.x05
    public void onAction(w05 w05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, w05Var) == null) || w05Var == null) {
            return;
        }
        int i = w05Var.a;
        if (i == 4) {
            Object obj = w05Var.c;
            if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
                this.c[0] = true;
            } else {
                this.c[0] = false;
            }
        } else if (i == 39 || i == 28) {
            this.c[3] = true;
        } else if (i != 29) {
            switch (i) {
                case 9:
                    boolean[] zArr = this.c;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.d;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    break;
                case 10:
                    this.c[2] = true;
                    break;
                case 11:
                    this.c[2] = false;
                    break;
                case 12:
                    Object obj2 = w05Var.c;
                    if (obj2 instanceof r15) {
                        r15 r15Var = (r15) obj2;
                        WriteImagesInfo writeImagesInfo = r15Var.a;
                        if (writeImagesInfo != null) {
                            if (writeImagesInfo.getChosedFiles() != null) {
                                this.d[0] = r15Var.a.getChosedFiles().size();
                            } else {
                                this.d[0] = 0;
                            }
                        }
                        if (this.d[0] > 0) {
                            this.c[1] = true;
                            break;
                        } else {
                            this.c[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr2 = this.d;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.c[1] = true;
                        break;
                    } else {
                        this.c[1] = false;
                        break;
                    }
            }
        } else {
            this.c[3] = false;
        }
        a(this.e);
    }

    @Override // com.repackage.j15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int color = SkinManager.getColor(i, (int) R.color.CAM_X0302);
            setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{di8.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), di8.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
        }
    }

    @Override // com.repackage.j15
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    @Override // com.repackage.j15
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e = i;
        }
    }
}
