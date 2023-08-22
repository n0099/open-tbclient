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
import com.baidu.tieba.gea;
import com.baidu.tieba.mi5;
import com.baidu.tieba.vi5;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SendView extends TextView implements mi5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int f = 2;
    public static int g = 1;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean[] c;
    public int[] d;
    public int e;

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

    /* loaded from: classes4.dex */
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
                this.a.S(new zh5(8, -1, null));
            }
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
        this.e = h;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037f), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070359), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
        setTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        setText(R.string.send_post);
        setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.ai5
    public void E(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zh5Var) != null) || zh5Var == null) {
            return;
        }
        int i = zh5Var.a;
        if (i != 4) {
            if (i != 39 && i != 28) {
                if (i != 29) {
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
                            Object obj = zh5Var.c;
                            if (!(obj instanceof vi5)) {
                                return;
                            }
                            vi5 vi5Var = (vi5) obj;
                            WriteImagesInfo writeImagesInfo = vi5Var.a;
                            if (writeImagesInfo != null) {
                                if (writeImagesInfo.getChosedFiles() != null) {
                                    this.d[0] = vi5Var.a.getChosedFiles().size();
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
            } else {
                this.c[3] = true;
            }
        } else {
            Object obj2 = zh5Var.c;
            if (obj2 != null && (!(obj2 instanceof String) || !StringUtils.isNull((String) obj2))) {
                this.c[0] = true;
            } else {
                this.c[0] = false;
            }
        }
        a(this.e);
    }

    @Override // com.baidu.tieba.mi5
    public void S(zh5 zh5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh5Var) == null) && (editorTools = this.a) != null) {
            editorTools.D(zh5Var);
        }
    }

    @Override // com.baidu.tieba.mi5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    @Override // com.baidu.tieba.mi5
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i == h) {
                boolean[] zArr = this.c;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
            } else if (i == g) {
                if (this.c[1]) {
                    setEnabled(true);
                } else {
                    setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mi5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int color = SkinManager.getColor(i, (int) R.color.CAM_X0302);
            setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{gea.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), gea.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
        }
    }

    @Override // com.baidu.tieba.mi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.mi5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mi5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.mi5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setClickable(false);
        }
    }
}
