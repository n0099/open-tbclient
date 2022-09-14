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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.vy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public abstract class i39<D> extends y39<D> implements e49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public TbAlphaVideo h;
    @Nullable
    public Toast i;
    public final KeyEvent j;
    @Nullable
    public z39 k;
    @Nullable
    public b59 l;
    @NonNull
    public e59 m;
    @NonNull
    public x29 n;
    public final View.OnClickListener o;
    public final vy4.a p;
    public final TbFaceManager.a q;
    public final TextWatcher r;
    public final View.OnFocusChangeListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i39 a;

        public a(i39 i39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int K;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.D(new u45(5, -1, null));
                }
                if (this.a.M() == null || this.a.M().getText() == null || (K = this.a.K()) < 0 || K >= this.a.M().getText().length()) {
                    return;
                }
                this.a.M().setSelection(K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements vy4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i39 a;

        public b(i39 i39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i39Var;
        }

        @Override // com.baidu.tieba.vy4.a
        public void b(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || this.a.b == null) {
                return;
            }
            this.a.b.b(i, z);
            this.a.b.w();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(i39 i39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i39Var};
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), on.class);
                on onVar = runTask != null ? (on) runTask.getData() : null;
                if (onVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(onVar.p());
                int r = onVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, onVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new jx4(bitmapDrawable, 0);
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
        public final /* synthetic */ i39 c;

        public d(i39 i39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i39Var;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                EditText M = this.c.M();
                if (editable == null || M == null || M.getText() == null) {
                    return;
                }
                int selectionEnd = M.getSelectionEnd();
                String str = this.a;
                if (str != null && str.equals(editable.toString())) {
                    M.setSelection(selectionEnd);
                    return;
                }
                this.a = M.getText().toString();
                this.c.n.i(M, false);
                this.c.F(editable);
                if (this.c.b != null) {
                    this.c.b.h();
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
                this.c.G(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
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
        public final /* synthetic */ i39 a;

        public e(i39 i39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i39Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            i39 i39Var;
            z39 z39Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || (z39Var = (i39Var = this.a).k) == null) {
                return;
            }
            z39Var.q(i39Var, z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i39(TbPageContext<?> tbPageContext, Class<D> cls, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, x29Var, e59Var};
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
        this.n = x29Var;
        this.m = e59Var;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str) || M() == null) {
            return;
        }
        this.m.f("");
        M().requestFocus();
        if (M().getText() != null && M().getText().length() + str.length() > 5000) {
            this.a.showToast((int) R.string.obfuscated_res_0x7f0f0d37);
            return;
        }
        int selectionStart = M().getSelectionStart();
        Editable text = M().getText();
        if (text == null || selectionStart < 0 || selectionStart > text.length()) {
            return;
        }
        text.insert(selectionStart, str);
    }

    public void F(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
        }
    }

    public void G(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void H(r05 r05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r05Var) == null) {
        }
    }

    public abstract void I(ArrayList<AtSelectData> arrayList);

    public abstract void J(ArrayList<AtSelectData> arrayList);

    public int K() {
        InterceptResult invokeV;
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (M() == null) {
                return -1;
            }
            int selectionEnd = M().getSelectionEnd();
            for (ImageSpan imageSpan : (ImageSpan[]) M().getText().getSpans(0, M().getText().length(), ImageSpan.class)) {
                int spanStart = M().getText().getSpanStart(imageSpan);
                int spanEnd = M().getText().getSpanEnd(imageSpan);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public abstract ArrayList<AtSelectData> L();

    @Nullable
    public abstract EditText M();

    public final void N(r05 r05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, r05Var) == null) || this.a.getPageActivity() == null || M() == null || M().getText() == null) {
            return;
        }
        if (((ImageSpan[]) M().getText().getSpans(0, M().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.i == null) {
                this.i = Toast.makeText(this.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1456, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.i.getView().isShown()) {
                this.i.cancel();
            }
            this.i.show();
            return;
        }
        ac6.b(this.a.getPageActivity(), r05Var, M());
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (M() == null || M().getText() == null || M().getText().length() < 5000) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void h(@NonNull f49 f49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, f49Var) == null) {
            super.h(f49Var);
            WriteData writeData = this.e;
            this.l = new b59(this.a, this, this.g, this.h, writeData == null ? -1 : writeData.getType());
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void l(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.l(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                if (i2 == 0 && i == 25004 && "from_content".equals(this.m.a())) {
                    j();
                }
            } else if (i == 12004) {
                if (M() == null) {
                    return;
                }
                M().requestFocus();
                f49 f49Var = this.b;
                if (f49Var != null) {
                    f49Var.C();
                }
                ArrayList<AtSelectData> parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                this.m.e(parcelableArrayListExtra);
                int selectionStart = M().getSelectionStart();
                if (selectionStart > 0) {
                    int i3 = selectionStart - 1;
                    if (M().getText().toString().charAt(i3) == '@') {
                        M().getEditableText().delete(i3, selectionStart);
                    }
                }
                J(parcelableArrayListExtra);
                if (ListUtils.isEmpty(parcelableArrayListExtra)) {
                    return;
                }
                M().getText().delete(M().getSelectionStart(), M().getSelectionEnd());
                I(parcelableArrayListExtra);
            } else if (i == 25004 && "from_content".equals(this.m.a())) {
                E(this.m.d(intent));
            }
        }
    }

    @Override // com.baidu.tieba.d49
    public void onChangeSkinType(int i) {
        b59 b59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (b59Var = this.l) == null) {
            return;
        }
        b59Var.l();
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            this.n.f(M(), false);
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onSaveInstanceState(Bundle bundle) {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (M() == null || (obj = M().getEditableText().toString()) == null) {
                return;
            }
            M().setText(TbFaceManager.i().t(this.a.getPageActivity(), obj, this.q));
            M().setSelection(M().getText().length());
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void p(u45 u45Var) {
        b59 b59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, u45Var) == null) {
            super.p(u45Var);
            int i = u45Var.a;
            if (i == 3) {
                if (M() == null || M().getText() == null || M().getSelectionStart() <= 0) {
                    return;
                }
                String substring = M().getText().toString().substring(0, M().getSelectionStart());
                Matcher matcher = zb6.b.matcher(substring);
                if (matcher.find()) {
                    M().getText().delete(M().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), M().getSelectionStart());
                } else {
                    M().onKeyDown(67, this.j);
                }
            } else if (i == 16) {
                if (O()) {
                    this.a.showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                    return;
                }
                ArrayList<AtSelectData> L = L();
                f49 f49Var = this.b;
                if (f49Var != null) {
                    f49Var.n(L);
                }
            } else if (i != 24) {
                if (i != 25 || (b59Var = this.l) == null) {
                    return;
                }
                b59Var.m(u45Var);
            } else if (u45Var.c instanceof r05) {
                f49 f49Var2 = this.b;
                if (f49Var2 != null) {
                    f49Var2.c();
                }
                r05 r05Var = (r05) u45Var.c;
                if (EmotionGroupType.isSendAsPic(r05Var.getType())) {
                    H(r05Var);
                } else if (O()) {
                    this.a.showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                } else {
                    N(r05Var);
                }
            }
        }
    }
}
