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
import com.baidu.tieba.a05;
import com.baidu.tieba.cz4;
import com.baidu.tieba.l75;
import com.baidu.tieba.u75;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.yi;
import com.baidu.tieba.z65;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SendNoLaunchView extends FrameLayout implements l75 {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static int t;
    public static int u;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean[] c;
    public int[] d;
    public int e;
    public TBSpecificationBtn f;
    public ImageView g;
    public Context h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public boolean m;
    public boolean n;

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
                if (!this.a.j && this.a.m && !yi.isEmpty(this.a.l)) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.h);
                    bdTopToast.h(false);
                    bdTopToast.g(this.a.l);
                    bdTopToast.i((ViewGroup) this.a.getRootView());
                }
                this.a.J(new z65(8, -1, null));
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
                if (this.a.j && this.a.k) {
                    if (this.a.i) {
                        this.a.J(new z65(1, 3, null));
                        SendNoLaunchView sendNoLaunchView = this.a;
                        sendNoLaunchView.J(new z65(14, 0, Integer.valueOf(sendNoLaunchView.getToolId())));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(this.a.h);
                    bdTopToast.h(false);
                    bdTopToast.g(this.a.getResources().getString(R.string.add_friend_cannot_send));
                    bdTopToast.i((ViewGroup) this.a.getRootView());
                } else if (!cz4.l().i("key_group_chat_chatroom_picture_switch", true)) {
                    BdTopToast bdTopToast2 = new BdTopToast(this.a.h);
                    bdTopToast2.h(false);
                    bdTopToast2.g(this.a.l);
                    bdTopToast2.i((ViewGroup) this.a.getRootView());
                }
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
        o = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds39);
        p = zi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        q = zi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        r = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46);
        s = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds68);
        t = 1;
        u = 0;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f = new TBSpecificationBtn(getContext());
            this.f.setLayoutParams(new FrameLayout.LayoutParams(zi.g(getContext(), R.dimen.tbds151) + o, zi.g(getContext(), R.dimen.tbds75) + (p * 2)));
            TBSpecificationBtn tBSpecificationBtn = this.f;
            int i = o;
            int i2 = p;
            tBSpecificationBtn.setPadding(i, i2, 0, i2);
            this.f.setEnabled(false);
            this.f.setTextSize(R.dimen.T_X08);
            this.f.setText(getContext().getString(R.string.send_msg));
            addView(this.f);
            this.f.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.l75
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.f != null) {
                a05 a05Var = new a05();
                a05Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
                this.f.setConfig(a05Var);
            }
            if (this.j && this.k) {
                z = true;
            } else {
                z = false;
            }
            setPicIconResource(z);
        }
    }

    public void setSendVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.f;
            int i2 = 8;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setEnabled(z);
                if (this.n) {
                    z = true;
                }
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
                if (!z) {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendNoLaunchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
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
        this.e = u;
        this.j = true;
        this.k = true;
        this.n = false;
        this.h = context;
        init();
    }

    private void setPicIconResource(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            if (z) {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_post_image24, R.color.CAM_X0105, null);
            } else {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_post_image24, R.color.CAM_X0109, null);
            }
        }
    }

    @Override // com.baidu.tieba.l75
    public void J(z65 z65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z65Var) == null) && (editorTools = this.a) != null) {
            editorTools.C(z65Var);
        }
    }

    @Override // com.baidu.tieba.l75
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setIconEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.j = z;
            setEnabled(z);
            setPicIconResource(z);
        }
    }

    public void setIsFriend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.i = z;
        }
    }

    public void setIsSendIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.n = z;
        }
    }

    public void setPicIconEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.k = z;
            setPicIconResource(z);
        }
    }

    @Override // com.baidu.tieba.l75
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b = i;
        }
    }

    private void setSendBtnUseable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i) == null) {
            if (i == u) {
                boolean[] zArr = this.c;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    setSendVisibility(false);
                } else {
                    setSendVisibility(true);
                }
            } else if (i == t) {
                if (this.c[1]) {
                    setSendVisibility(true);
                } else {
                    setSendVisibility(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.a75
    public void A(z65 z65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, z65Var) != null) || z65Var == null) {
            return;
        }
        int i = z65Var.a;
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
                            Object obj = z65Var.c;
                            if (!(obj instanceof u75)) {
                                return;
                            }
                            u75 u75Var = (u75) obj;
                            WriteImagesInfo writeImagesInfo = u75Var.a;
                            if (writeImagesInfo != null) {
                                if (writeImagesInfo.getChosedFiles() != null) {
                                    this.d[0] = u75Var.a.getChosedFiles().size();
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
            Object obj2 = z65Var.c;
            if (obj2 != null && (!(obj2 instanceof String) || !StringUtils.isNull((String) obj2))) {
                this.c[0] = true;
            } else {
                this.c[0] = false;
            }
        }
        setSendBtnUseable(this.e);
    }

    @Override // com.baidu.tieba.l75
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.setOnClickListener(new a(this));
            this.g.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.l75
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l75
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.l75
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            i();
            h();
            g();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g = new ImageView(getContext());
            int i = s;
            this.g.setLayoutParams(new FrameLayout.LayoutParams(q + i, i + (r * 2)));
            ImageView imageView = this.g;
            int i2 = q;
            int i3 = r;
            imageView.setPadding(i2, i3, 0, i3);
            addView(this.g);
            this.g.setVisibility(0);
        }
    }

    public void setSendInterceptToastText(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            this.m = !z;
            this.l = str;
        }
    }
}
