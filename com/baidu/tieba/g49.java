package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.nz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public abstract class g49 extends y49 implements e59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public TbAlphaVideo h;
    public Toast i;
    public final KeyEvent j;
    public z49 k;
    public h69 l;
    public k69 m;
    public s39 n;
    public final View.OnClickListener o;
    public final nz4.a p;
    public final TbFaceManager.a q;
    public final TextWatcher r;
    public final View.OnFocusChangeListener s;

    public void H(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
        }
    }

    public void I(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void J(j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, j15Var) == null) {
        }
    }

    public abstract void K(ArrayList arrayList);

    public abstract void L(ArrayList arrayList);

    public abstract ArrayList N();

    public abstract EditText O();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g49 a;

        public a(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g49Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int M;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.D(new l55(5, -1, null));
                }
                if (this.a.O() != null && this.a.O().getText() != null && (M = this.a.M()) >= 0 && M < this.a.O().getText().length()) {
                    this.a.O().setSelection(M);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nz4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g49 a;

        public b(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g49Var;
        }

        @Override // com.baidu.tieba.nz4.a
        public void e(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.e(i, z);
                this.a.b.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            pn pnVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), pn.class);
                if (runTask != null) {
                    pnVar = (pn) runTask.getData();
                } else {
                    pnVar = null;
                }
                if (pnVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(pnVar.p());
                int r = pnVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, pnVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new cy4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ g49 c;

        public d(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g49Var;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                EditText O = this.c.O();
                if (editable != null && O != null && O.getText() != null) {
                    int selectionEnd = O.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        O.setSelection(selectionEnd);
                        return;
                    }
                    this.a = O.getText().toString();
                    this.c.n.i(O, false);
                    this.c.H(editable);
                    if (this.c.b != null) {
                        this.c.b.i();
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                this.b = str;
                this.c.I(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                int i5 = 0;
                if (str != null) {
                    i4 = str.length();
                } else {
                    i4 = 0;
                }
                if (charSequence != null) {
                    i5 = charSequence.toString().length();
                }
                if (i5 > i4) {
                    this.c.m.c(charSequence, i, i3, "from_content");
                    this.c.m.b(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g49 a;

        public e(g49 g49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g49Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            g49 g49Var;
            z49 z49Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && (z49Var = (g49Var = this.a).k) != null) {
                z49Var.q(g49Var, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g49(TbPageContext tbPageContext, Class cls, s39 s39Var, k69 k69Var) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, s39Var, k69Var};
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
        this.j = new KeyEvent(0, 67);
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.n = s39Var;
        this.m = k69Var;
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void j(f59 f59Var) {
        int type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, f59Var) == null) {
            super.j(f59Var);
            WriteData writeData = this.e;
            if (writeData == null) {
                type = -1;
            } else {
                type = writeData.getType();
            }
            this.l = new h69(this.a, this, this.g, this.h, type);
        }
    }

    @Override // com.baidu.tieba.d59
    public void onChangeSkinType(int i) {
        h69 h69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (h69Var = this.l) != null) {
            h69Var.m();
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && O() != null) {
            this.m.f("");
            O().requestFocus();
            if (O().getText() != null && O().getText().length() + str.length() > 5000) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d48);
                return;
            }
            int selectionStart = O().getSelectionStart();
            Editable text = O().getText();
            if (text != null && selectionStart >= 0 && selectionStart <= text.length()) {
                text.insert(selectionStart, str);
            }
        }
    }

    public final void P(j15 j15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, j15Var) == null) && this.a.getPageActivity() != null && O() != null && O().getText() != null) {
            if (((ImageSpan[]) O().getText().getSpans(0, O().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.i == null) {
                    this.i = Toast.makeText(this.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1470, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.i.getView().isShown()) {
                    this.i.cancel();
                }
                this.i.show();
                return;
            }
            uc6.b(this.a.getPageActivity(), j15Var, O());
        }
    }

    public int M() {
        InterceptResult invokeV;
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (O() == null) {
                return -1;
            }
            int selectionEnd = O().getSelectionEnd();
            for (ImageSpan imageSpan : (ImageSpan[]) O().getText().getSpans(0, O().getText().length(), ImageSpan.class)) {
                int spanStart = O().getText().getSpanStart(imageSpan);
                int spanEnd = O().getText().getSpanEnd(imageSpan);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (O() == null || O().getText() == null || O().getText().length() < 5000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void m(Bundle bundle, Intent intent, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 12004) {
                    if (O() == null) {
                        return;
                    }
                    O().requestFocus();
                    f59 f59Var = this.b;
                    if (f59Var != null) {
                        f59Var.C();
                    }
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    this.m.e(arrayList);
                    int selectionStart = O().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (O().getText().toString().charAt(i3) == '@') {
                            O().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    L(arrayList);
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    O().getText().delete(O().getSelectionStart(), O().getSelectionEnd());
                    K(arrayList);
                } else if (i == 25004 && "from_content".equals(this.m.a())) {
                    G(this.m.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_content".equals(this.m.a())) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void r(l55 l55Var) {
        h69 h69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, l55Var) == null) {
            super.r(l55Var);
            int i = l55Var.a;
            if (i == 3) {
                if (O() != null && O().getText() != null && O().getSelectionStart() > 0) {
                    String substring = O().getText().toString().substring(0, O().getSelectionStart());
                    Matcher matcher = tc6.b.matcher(substring);
                    if (matcher.find()) {
                        O().getText().delete(O().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), O().getSelectionStart());
                    } else {
                        O().onKeyDown(67, this.j);
                    }
                }
            } else if (i == 16) {
                if (Q()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d48);
                    return;
                }
                ArrayList N = N();
                f59 f59Var = this.b;
                if (f59Var != null) {
                    f59Var.n(N);
                }
            } else if (i == 24) {
                if (!(l55Var.c instanceof j15)) {
                    return;
                }
                f59 f59Var2 = this.b;
                if (f59Var2 != null) {
                    f59Var2.c();
                }
                j15 j15Var = (j15) l55Var.c;
                if (EmotionGroupType.isSendAsPic(j15Var.getType())) {
                    J(j15Var);
                } else if (Q()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d48);
                } else {
                    P(j15Var);
                }
            } else if (i == 25 && (h69Var = this.l) != null) {
                h69Var.n(l55Var);
            }
        }
    }
}
