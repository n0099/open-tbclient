package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w.n;
import c.a.r0.y3.c;
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
/* loaded from: classes5.dex */
public class SendView extends TextView implements n {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ALL = 0;
    public static int PICTURE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f39641e;

    /* renamed from: f  reason: collision with root package name */
    public int f39642f;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f39643g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f39644h;

    /* renamed from: i  reason: collision with root package name */
    public int f39645i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SendView f39646e;

        public a(SendView sendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39646e = sendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f39646e.sendAction(new c.a.q0.w.a(8, -1, null));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39643g = new boolean[]{false, false, false, false, false};
        this.f39644h = new int[]{0, 0};
        this.f39645i = ALL;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds17), context.getResources().getDimensionPixelSize(R.dimen.ds28), context.getResources().getDimensionPixelSize(R.dimen.ds10), context.getResources().getDimensionPixelSize(R.dimen.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        setTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        setText(R.string.send_post);
        setOnClickListener(new a(this));
    }

    public void applyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == ALL) {
                boolean[] zArr = this.f39643g;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setEnabled(false);
                } else {
                    setEnabled(true);
                }
            } else if (i2 == PICTURE) {
                if (this.f39643g[1]) {
                    setEnabled(true);
                } else {
                    setEnabled(false);
                }
            }
        }
    }

    @Override // c.a.q0.w.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // c.a.q0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39642f : invokeV.intValue;
    }

    @Override // c.a.q0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.q0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setClickable(false);
        }
    }

    @Override // c.a.q0.w.b
    public void onAction(c.a.q0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 4) {
            Object obj = aVar.f13989c;
            if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
                this.f39643g[0] = true;
            } else {
                this.f39643g[0] = false;
            }
        } else if (i2 == 39 || i2 == 28) {
            this.f39643g[3] = true;
        } else if (i2 != 29) {
            switch (i2) {
                case 9:
                    boolean[] zArr = this.f39643g;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.f39644h;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    break;
                case 10:
                    this.f39643g[2] = true;
                    break;
                case 11:
                    this.f39643g[2] = false;
                    break;
                case 12:
                    Object obj2 = aVar.f13989c;
                    if (obj2 instanceof c.a.q0.w.r.a) {
                        c.a.q0.w.r.a aVar2 = (c.a.q0.w.r.a) obj2;
                        WriteImagesInfo writeImagesInfo = aVar2.a;
                        if (writeImagesInfo != null) {
                            if (writeImagesInfo.getChosedFiles() != null) {
                                this.f39644h[0] = aVar2.a.getChosedFiles().size();
                            } else {
                                this.f39644h[0] = 0;
                            }
                        }
                        if (this.f39644h[0] > 0) {
                            this.f39643g[1] = true;
                            break;
                        } else {
                            this.f39643g[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr2 = this.f39644h;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.f39643g[1] = true;
                        break;
                    } else {
                        this.f39643g[1] = false;
                        break;
                    }
            }
        } else {
            this.f39643g[3] = false;
        }
        applyType(this.f39645i);
    }

    @Override // c.a.q0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int color = SkinManager.getColor(i2, (int) R.color.CAM_X0302);
            setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), c.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
        }
    }

    @Override // c.a.q0.w.n
    public void sendAction(c.a.q0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (editorTools = this.f39641e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.q0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorTools) == null) {
            this.f39641e = editorTools;
        }
    }

    @Override // c.a.q0.w.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f39642f = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f39645i = i2;
        }
    }
}
