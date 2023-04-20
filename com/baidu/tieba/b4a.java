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
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public abstract class b4a<D> extends t4a<D> implements z4a {
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
    public u4a k;
    @Nullable
    public c6a l;
    @NonNull
    public f6a m;
    @NonNull
    public n3a n;
    public final View.OnClickListener o;
    public final i65.a p;
    public final TbFaceManager.a q;
    public final TextWatcher r;
    public final View.OnFocusChangeListener s;

    public void L(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
        }
    }

    public void M(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void N(f85 f85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f85Var) == null) {
        }
    }

    public abstract void O(ArrayList<AtSelectData> arrayList);

    public abstract void P(ArrayList<AtSelectData> arrayList);

    @Nullable
    public abstract ArrayList<AtSelectData> R();

    @Nullable
    public abstract EditText S();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b4a a;

        public a(b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.D(new qc5(5, -1, null));
                }
                if (this.a.S() != null && this.a.S().getText() != null && (Q = this.a.Q()) >= 0 && Q < this.a.S().getText().length()) {
                    this.a.S().setSelection(Q);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i65.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b4a a;

        public b(b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b4aVar;
        }

        @Override // com.baidu.tieba.i65.a
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.d(i, z);
                this.a.b.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b4aVar};
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
            tm tmVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), tm.class);
                if (runTask != null) {
                    tmVar = (tm) runTask.getData();
                } else {
                    tmVar = null;
                }
                if (tmVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(tmVar.p());
                int r = tmVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, tmVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new x45(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ b4a c;

        public d(b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b4aVar;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                EditText S = this.c.S();
                if (editable != null && S != null && S.getText() != null) {
                    int selectionEnd = S.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        S.setSelection(selectionEnd);
                        return;
                    }
                    this.a = S.getText().toString();
                    this.c.n.i(S, false);
                    this.c.L(editable);
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
                this.c.M(charSequence, i, i2, i3);
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
                    b4a b4aVar = this.c;
                    b4aVar.m.e(b4aVar.R());
                    this.c.m.b(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b4a a;

        public e(b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b4aVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z && this.a.e != null && !ListUtils.isEmpty(this.a.e.getInputInsertAtList())) {
                    this.a.O(new ArrayList<>(this.a.e.getInputInsertAtList()));
                    this.a.e.setInputInsertAtList(new ArrayList<>());
                }
                b4a b4aVar = this.a;
                u4a u4aVar = b4aVar.k;
                if (u4aVar != null) {
                    u4aVar.q(b4aVar, z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4a(TbPageContext<?> tbPageContext, Class<D> cls, @NonNull n3a n3aVar, @NonNull f6a f6aVar) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, n3aVar, f6aVar};
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
        this.n = n3aVar;
        this.m = f6aVar;
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void j(@NonNull a5a a5aVar) {
        int type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, a5aVar) == null) {
            super.j(a5aVar);
            WriteData writeData = this.e;
            if (writeData == null) {
                type = -1;
            } else {
                type = writeData.getType();
            }
            this.l = new c6a(this.a, this, this.g, this.h, type);
        }
    }

    @Override // com.baidu.tieba.y4a
    public void onChangeSkinType(int i) {
        c6a c6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (c6aVar = this.l) != null) {
            c6aVar.m();
        }
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && S() != null) {
            this.m.f("");
            S().requestFocus();
            if (S().getText() != null && S().getText().length() + str.length() > 5000) {
                this.a.showToast((int) R.string.over_limit_tip);
                return;
            }
            int selectionStart = S().getSelectionStart();
            Editable text = S().getText();
            if (text != null && selectionStart >= 0 && selectionStart <= text.length()) {
                text.insert(selectionStart, str);
            }
        }
    }

    public final void T(f85 f85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, f85Var) == null) && this.a.getPageActivity() != null && S() != null && S().getText() != null) {
            if (((ImageSpan[]) S().getText().getSpans(0, S().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.i == null) {
                    this.i = Toast.makeText(this.a.getPageActivity(), (int) R.string.too_many_face, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.i.getView().isShown()) {
                    this.i.cancel();
                }
                GreyUtil.grey(this.i);
                this.i.show();
                return;
            }
            et6.b(this.a.getPageActivity(), f85Var, S());
        }
    }

    public int Q() {
        InterceptResult invokeV;
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (S() == null) {
                return -1;
            }
            int selectionEnd = S().getSelectionEnd();
            for (ImageSpan imageSpan : (ImageSpan[]) S().getText().getSpans(0, S().getText().length(), ImageSpan.class)) {
                int spanStart = S().getText().getSpanStart(imageSpan);
                int spanEnd = S().getText().getSpanEnd(imageSpan);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (S() == null || S().getText() == null || S().getText().length() < 5000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 12004) {
                    if (S() == null) {
                        return;
                    }
                    S().requestFocus();
                    a5a a5aVar = this.b;
                    if (a5aVar != null) {
                        a5aVar.B();
                    }
                    ArrayList<AtSelectData> arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    this.m.e(arrayList);
                    int selectionStart = S().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (S().getText().toString().charAt(i3) == '@') {
                            S().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    P(arrayList);
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    S().getText().delete(S().getSelectionStart(), S().getSelectionEnd());
                    O(arrayList);
                } else if (i == 25004 && "from_content".equals(this.m.a())) {
                    K(this.m.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_content".equals(this.m.a())) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.t4a, com.baidu.tieba.y4a
    public void r(qc5 qc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, qc5Var) == null) {
            super.r(qc5Var);
            int i = qc5Var.a;
            if (i == 3) {
                if (S() != null && S().getText() != null && S().getSelectionStart() > 0) {
                    String substring = S().getText().toString().substring(0, S().getSelectionStart());
                    Matcher matcher = dt6.b.matcher(substring);
                    if (matcher.find()) {
                        S().getText().delete(S().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), S().getSelectionStart());
                        return;
                    }
                    S().onKeyDown(67, this.j);
                }
            } else if (i == 16) {
                if (U()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                    return;
                }
                ArrayList<AtSelectData> R = R();
                a5a a5aVar = this.b;
                if (a5aVar != null) {
                    a5aVar.n(R);
                }
            } else if (i == 24) {
                Object obj = qc5Var.c;
                if (!(obj instanceof f85)) {
                    return;
                }
                f85 f85Var = (f85) obj;
                if (EmotionGroupType.isSendAsPic(f85Var.getType())) {
                    N(f85Var);
                    a5a a5aVar2 = this.b;
                    if (a5aVar2 != null) {
                        a5aVar2.e();
                    }
                } else if (U()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                } else {
                    T(f85Var);
                }
            } else if (i == 25) {
                c6a c6aVar = this.l;
                if (c6aVar != null) {
                    c6aVar.n(qc5Var);
                }
            } else if (i == 74 && S() != null) {
                S().setTag(R.id.obfuscated_res_0x7f0911a9, Boolean.TRUE);
            }
        }
    }
}
