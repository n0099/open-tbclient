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
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class cf9 extends lf9<dg9> implements nf9 {
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

    @Override // com.baidu.tieba.qf9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.qf9
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.qf9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf9 a;

        /* loaded from: classes4.dex */
        public class a implements wv4.e {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    cz4 l = cz4.l();
                    l.v(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    wv4Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.cf9$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0240b implements wv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0240b(b bVar) {
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

            @Override // com.baidu.tieba.wv4.e
            public void onClick(wv4 wv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                    cz4 l = cz4.l();
                    l.v(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    wv4Var.dismiss();
                }
            }
        }

        public b(cf9 cf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                if (((dg9) this.a.d).a) {
                    this.a.M();
                } else {
                    this.a.L();
                }
                cz4 l = cz4.l();
                if (!l.i(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) && ((dg9) this.a.d).a) {
                    wv4 wv4Var = new wv4(this.a.a.getPageActivity());
                    wv4Var.setNegativeTextColor(R.color.CAM_X0105);
                    wv4Var.setTitle("");
                    wv4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f0fca));
                    wv4Var.setContentViewSize(1);
                    wv4Var.setPositiveButton("同意", new a(this));
                    wv4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new C0240b(this));
                    wv4Var.create(this.a.a).show();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf9 a;

        public a(cf9 cf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf9Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                dh.i(this.a.j, this.a.a.getPageActivity());
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
    public class c implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf9 a;

        public c(cf9 cf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf9Var;
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
    public cf9(TbPageContext<?> tbPageContext) {
        super(tbPageContext, dg9.class);
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

    public final void N(List<ct4> list) {
        boolean z;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (ct4 ct4Var : list) {
                    if (ct4Var.b == 2) {
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

    @Override // com.baidu.tieba.nf9
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof vf9)) {
            vf9 vf9Var = (vf9) obj;
            int i = vf9Var.a;
            if (i == 1) {
                if (this.g != null && !ListUtils.isEmpty(vf9Var.b) && !ListUtils.isEmpty(vf9Var.c)) {
                    this.g.setVisibility(0);
                }
            } else if (i == 3) {
                N(vf9Var.e);
            }
        }
    }

    @Override // com.baidu.tieba.qf9
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
            eBusinessProtocolView.n(this.a.getString(R.string.obfuscated_res_0x7f0f0fcb));
            this.j.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f101d));
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
            cz4 l = cz4.l();
            if (l.i(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                L();
            } else {
                M();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((dg9) this.d).a = true;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f08087b, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((dg9) this.d).a = false;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a88, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null && linearLayout.getVisibility() == 0 && !((dg9) this.d).a) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0fd1));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qf9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04e7, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091b97);
            this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091b9c);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091b99);
            K();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
