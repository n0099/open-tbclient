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
import com.baidu.tieba.q15;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class co9 extends lo9<dp9> implements no9 {
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

    @Override // com.baidu.tieba.qo9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.qo9
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.qo9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co9 a;

        /* loaded from: classes3.dex */
        public class a implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    b55 m = b55.m();
                    m.w(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    q15Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.co9$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0220b implements q15.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0220b(b bVar) {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    b55 m = b55.m();
                    m.w(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    q15Var.dismiss();
                }
            }
        }

        public b(co9 co9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = co9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                if (((dp9) this.a.d).a) {
                    this.a.M();
                } else {
                    this.a.L();
                }
                b55 m = b55.m();
                if (!m.i(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) && ((dp9) this.a.d).a) {
                    q15 q15Var = new q15(this.a.a.getPageActivity());
                    q15Var.setNegativeTextColor(R.color.CAM_X0105);
                    q15Var.setTitle("");
                    q15Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f1001));
                    q15Var.setContentViewSize(1);
                    q15Var.setPositiveButton("同意", new a(this));
                    q15Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new C0220b(this));
                    q15Var.create(this.a.a).show();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co9 a;

        public a(co9 co9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = co9Var;
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

    /* loaded from: classes3.dex */
    public class c implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co9 a;

        public c(co9 co9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = co9Var;
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.L();
                } else {
                    this.a.M();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co9(TbPageContext<?> tbPageContext) {
        super(tbPageContext, dp9.class);
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

    public final void N(List<wy4> list) {
        boolean z;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (wy4 wy4Var : list) {
                    if (wy4Var.b == 2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z && (linearLayout = this.g) != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.no9
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof vo9)) {
            vo9 vo9Var = (vo9) obj;
            int i = vo9Var.a;
            if (i == 1) {
                if (this.g != null && !ListUtils.isEmpty(vo9Var.b) && !ListUtils.isEmpty(vo9Var.c)) {
                    this.g.setVisibility(0);
                }
            } else if (i == 3) {
                N(vo9Var.e);
            }
        }
    }

    @Override // com.baidu.tieba.qo9
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this.a.getPageActivity(), EBusinessProtocolView.WindowType.PROTOCOL);
            this.j = eBusinessProtocolView;
            eBusinessProtocolView.n(this.a.getString(R.string.obfuscated_res_0x7f0f1002));
            this.j.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f1056));
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
            this.j.l(new c(this));
            b55 m = b55.m();
            if (m.i(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                L();
            } else {
                M();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((dp9) this.d).a = true;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080885, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((dp9) this.d).a = false;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a8f, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.lo9, com.baidu.tieba.qo9
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null && linearLayout.getVisibility() == 0 && !((dp9) this.d).a) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f1008));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qo9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04f9, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091c21);
            this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091c26);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091c23);
            K();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
