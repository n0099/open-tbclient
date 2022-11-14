package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.f75;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.k65;
import com.baidu.tieba.oz4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w65;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SendNoLaunchView extends FrameLayout implements w65 {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static int o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean[] c;
    public int[] d;
    public int e;
    public TBSpecificationBtn f;
    public ImageView g;
    public TalkableActivity h;
    public boolean i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendNoLaunchView a;

        public a(SendNoLaunchView sendNoLaunchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendNoLaunchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendNoLaunchView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K(new k65(8, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendNoLaunchView a;

        public b(SendNoLaunchView sendNoLaunchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendNoLaunchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendNoLaunchView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i) {
                    this.a.K(new k65(1, 3, null));
                    SendNoLaunchView sendNoLaunchView = this.a;
                    sendNoLaunchView.K(new k65(14, 0, Integer.valueOf(sendNoLaunchView.getToolId())));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.h);
                bdTopToast.h(false);
                bdTopToast.g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f00c1));
                bdTopToast.i((ViewGroup) this.a.getRootView());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522830895, "Lcom/baidu/tbadk/editortools/sendtool/SendNoLaunchView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(522830895, "Lcom/baidu/tbadk/editortools/sendtool/SendNoLaunchView;");
                return;
            }
        }
        j = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds39);
        k = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        l = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        m = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46);
        n = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds68);
        o = 1;
        p = 0;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = new TBSpecificationBtn(getContext());
            this.f.setLayoutParams(new FrameLayout.LayoutParams(yi.g(getContext(), R.dimen.tbds151) + j, yi.g(getContext(), R.dimen.tbds75) + (k * 2)));
            TBSpecificationBtn tBSpecificationBtn = this.f;
            int i = j;
            int i2 = k;
            tBSpecificationBtn.setPadding(i, i2, 0, i2);
            this.f.setEnabled(false);
            this.f.setTextSize(R.dimen.T_X08);
            this.f.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1160));
            addView(this.f);
            this.f.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(TalkableActivity talkableActivity) {
        this(talkableActivity, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {talkableActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TalkableActivity) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(TalkableActivity talkableActivity, AttributeSet attributeSet) {
        this(talkableActivity, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {talkableActivity, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TalkableActivity) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(TalkableActivity talkableActivity, AttributeSet attributeSet, int i) {
        super(talkableActivity, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {talkableActivity, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.c = new boolean[]{false, false, false, false, false};
        this.d = new int[]{0, 0};
        this.e = p;
        this.h = talkableActivity;
        init();
    }

    private void setSendVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.f;
            int i2 = 0;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setEnabled(z);
                TBSpecificationBtn tBSpecificationBtn2 = this.f;
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                tBSpecificationBtn2.setVisibility(i);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                if (z) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    @Override // com.baidu.tieba.w65
    public void K(k65 k65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k65Var) == null) && (editorTools = this.a) != null) {
            editorTools.A(k65Var);
        }
    }

    @Override // com.baidu.tieba.w65
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.f != null) {
                oz4 oz4Var = new oz4();
                oz4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
                this.f.setConfig(oz4Var);
            }
            WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f0809db, R.color.CAM_X0105, null);
        }
    }

    @Override // com.baidu.tieba.w65
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setIsFriend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.baidu.tieba.w65
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b = i;
        }
    }

    private void setSendBtnUseable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            if (i == p) {
                boolean[] zArr = this.c;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setSendVisibility(false);
                } else {
                    setSendVisibility(true);
                }
            } else if (i == o) {
                if (this.c[1]) {
                    setSendVisibility(true);
                } else {
                    setSendVisibility(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l65
    public void B(k65 k65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, k65Var) != null) || k65Var == null) {
            return;
        }
        int i = k65Var.a;
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
                            Object obj = k65Var.c;
                            if (!(obj instanceof f75)) {
                                return;
                            }
                            f75 f75Var = (f75) obj;
                            WriteImagesInfo writeImagesInfo = f75Var.a;
                            if (writeImagesInfo != null) {
                                if (writeImagesInfo.getChosedFiles() != null) {
                                    this.d[0] = f75Var.a.getChosedFiles().size();
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
            Object obj2 = k65Var.c;
            if (obj2 != null && (!(obj2 instanceof String) || !StringUtils.isNull((String) obj2))) {
                this.c[0] = true;
            } else {
                this.c[0] = false;
            }
        }
        setSendBtnUseable(this.e);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.setOnClickListener(new a(this));
            this.g.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.w65
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.w65
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.w65
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.w65
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e();
            d();
            c();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = new ImageView(getContext());
            int i = n;
            this.g.setLayoutParams(new FrameLayout.LayoutParams(l + i, i + (m * 2)));
            ImageView imageView = this.g;
            int i2 = l;
            int i3 = m;
            imageView.setPadding(i2, i3, 0, i3);
            addView(this.g);
            this.g.setVisibility(0);
        }
    }
}
