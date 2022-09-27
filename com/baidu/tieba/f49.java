package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.nu4;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class f49 extends n49<d59> implements p49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinearLayout g;
    @Nullable
    public ImageView h;
    @Nullable
    public TextView i;
    @Nullable
    public EBusinessProtocolView j;

    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f49 a;

        public a(f49 f49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f49Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ih.i(this.a.j, this.a.a.getPageActivity());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f49 a;

        /* loaded from: classes4.dex */
        public class a implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    ox4 k = ox4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    nu4Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.f49$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0242b implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0242b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    ox4 k = ox4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    nu4Var.dismiss();
                }
            }
        }

        public b(f49 f49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f49Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.getPageActivity() == null || this.a.a.getPageActivity().isFinishing()) {
                return;
            }
            if (((d59) this.a.d).a) {
                this.a.K();
            } else {
                this.a.J();
            }
            ox4 k = ox4.k();
            if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !((d59) this.a.d).a) {
                return;
            }
            nu4 nu4Var = new nu4(this.a.a.getPageActivity());
            nu4Var.setNegativeTextColor(R.color.CAM_X0105);
            nu4Var.setTitle("");
            nu4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f0f50));
            nu4Var.setContentViewSize(1);
            nu4Var.setPositiveButton("同意", new a(this));
            nu4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new C0242b(this));
            nu4Var.create(this.a.a).show();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f49 a;

        public c(f49 f49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f49Var;
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.J();
                } else {
                    this.a.K();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, d59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this.a.getPageActivity(), EBusinessProtocolView.WindowType.PROTOCOL);
            this.j = eBusinessProtocolView;
            eBusinessProtocolView.o(this.a.getString(R.string.obfuscated_res_0x7f0f0f51));
            this.j.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f0fa0));
            spannableString.setSpan(new a(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            TextView textView = this.i;
            if (textView == null) {
                return;
            }
            textView.setText(spannableString);
            this.i.setMovementMethod(LinkMovementMethod.getInstance());
            ImageView imageView = this.h;
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(new b(this));
            this.j.m(new c(this));
            ox4 k = ox4.k();
            if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                J();
            } else {
                K();
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((d59) this.d).a = true;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f08083e, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((d59) this.d).a = false;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a31, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void L(List<vr4> list) {
        boolean z;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (vr4 vr4Var : list) {
                    if (vr4Var.b == 2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z || (linearLayout = this.g) == null) {
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout == null || linearLayout.getVisibility() != 0 || ((d59) this.d).a) {
                return true;
            }
            TbPageContext<?> tbPageContext = this.a;
            tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0f57));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tieba.p49
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof w49)) {
            w49 w49Var = (w49) obj;
            int i = w49Var.a;
            if (i != 1) {
                if (i == 3) {
                    L(w49Var.e);
                }
            } else if (this.g == null || ListUtils.isEmpty(w49Var.b) || ListUtils.isEmpty(w49Var.c)) {
            } else {
                this.g.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04ca, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091ad3);
            this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad8);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091ad5);
            I();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
