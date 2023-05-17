package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ef5;
import com.baidu.tieba.n75;
import com.baidu.tieba.nf5;
import com.baidu.tieba.ri;
import com.baidu.tieba.se5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SendViewBtnStyle extends TBSpecificationBtn implements ef5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int t = 1;
    public static int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools o;
    public int p;
    public boolean[] q;
    public int[] r;
    public int s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendViewBtnStyle a;

        public a(SendViewBtnStyle sendViewBtnStyle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendViewBtnStyle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendViewBtnStyle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H(new se5(8, -1, null));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-148956306, "Lcom/baidu/tbadk/editortools/sendtool/SendViewBtnStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-148956306, "Lcom/baidu/tbadk/editortools/sendtool/SendViewBtnStyle;");
                return;
            }
        }
        v = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds39);
        w = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendViewBtnStyle(Context context) {
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
        this.q = new boolean[]{false, false, false, false, false};
        this.r = new int[]{0, 0};
        this.s = u;
        setLayoutParams(new FrameLayout.LayoutParams(ri.g(getContext(), R.dimen.tbds151) + v, ri.g(getContext(), R.dimen.tbds75) + (w * 2)));
        int i3 = v;
        int i4 = w;
        setPadding(i3, i4, 0, i4);
        setEnabled(false);
        setTextSize(R.dimen.T_X08);
        setText(getContext().getString(R.string.send_msg));
        setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.te5
    public void C(se5 se5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, se5Var) != null) || se5Var == null) {
            return;
        }
        int i = se5Var.a;
        if (i != 4) {
            if (i != 39 && i != 28) {
                if (i != 29) {
                    switch (i) {
                        case 9:
                            boolean[] zArr = this.q;
                            zArr[0] = false;
                            zArr[1] = false;
                            zArr[2] = false;
                            zArr[3] = false;
                            zArr[4] = false;
                            int[] iArr = this.r;
                            iArr[0] = 0;
                            iArr[1] = 0;
                            break;
                        case 10:
                            this.q[2] = true;
                            break;
                        case 11:
                            this.q[2] = false;
                            break;
                        case 12:
                            Object obj = se5Var.c;
                            if (!(obj instanceof nf5)) {
                                return;
                            }
                            nf5 nf5Var = (nf5) obj;
                            WriteImagesInfo writeImagesInfo = nf5Var.a;
                            if (writeImagesInfo != null) {
                                if (writeImagesInfo.getChosedFiles() != null) {
                                    this.r[0] = nf5Var.a.getChosedFiles().size();
                                } else {
                                    this.r[0] = 0;
                                }
                            }
                            if (this.r[0] > 0) {
                                this.q[1] = true;
                                break;
                            } else {
                                this.q[1] = false;
                                break;
                            }
                        case 13:
                            int[] iArr2 = this.r;
                            iArr2[0] = iArr2[0] - 1;
                            if (iArr2[0] > 0) {
                                this.q[1] = true;
                                break;
                            } else {
                                this.q[1] = false;
                                break;
                            }
                    }
                } else {
                    this.q[3] = false;
                }
            } else {
                this.q[3] = true;
            }
        } else {
            Object obj2 = se5Var.c;
            if (obj2 != null && (!(obj2 instanceof String) || !StringUtils.isNull((String) obj2))) {
                this.q[0] = true;
            } else {
                this.q[0] = false;
            }
        }
        q(this.s);
    }

    @Override // com.baidu.tieba.ef5
    public void H(se5 se5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, se5Var) == null) && (editorTools = this.o) != null) {
            editorTools.C(se5Var);
        }
    }

    @Override // com.baidu.tieba.ef5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            n75 n75Var = new n75();
            n75Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
            setConfig(n75Var);
        }
    }

    @Override // com.baidu.tieba.ef5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorTools) == null) {
            this.o = editorTools;
        }
    }

    @Override // com.baidu.tieba.ef5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.p = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.ef5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ef5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ef5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ef5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setClickable(false);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i == u) {
                boolean[] zArr = this.q;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
            } else if (i == t) {
                if (this.q[1]) {
                    setEnabled(true);
                } else {
                    setEnabled(false);
                }
            }
        }
    }
}
