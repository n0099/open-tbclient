package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class e47 {
    public static /* synthetic */ Interceptable $ic;
    public static final KeyEvent a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface i {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    /* loaded from: classes5.dex */
    public static class a extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ yd5 b;

        public a(EditText editText, yd5 yd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, yd5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = yd5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) && jnVar != null) {
                int selectionStart = this.a.getSelectionStart();
                if (selectionStart < 0) {
                    selectionStart = 0;
                }
                e47.i(this.a, new SpannableStringBuilder(this.b.d()), selectionStart, jnVar, this.b.getType());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ EmotionGroupType c;

        public b(EditText editText, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, spannableStringBuilder, emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = spannableStringBuilder;
            this.c = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((b) jnVar, str, i);
                if (jnVar != null) {
                    int selectionStart = this.a.getSelectionStart();
                    if (selectionStart < 0) {
                        selectionStart = 0;
                    }
                    e47.i(this.a, this.b, selectionStart, jnVar, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ i e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((c) jnVar, str, i);
                if (jnVar != null && jnVar.p() != null) {
                    Bitmap p = jnVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * 0.4d);
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new fn(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0) {
                        this.e.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0) {
                    this.e.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int[] e;
        public final /* synthetic */ i f;

        public d(int i, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = spannableStringBuilder;
            this.c = i2;
            this.d = i3;
            this.e = iArr;
            this.f = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((d) jnVar, str, i);
                if (jnVar != null && jnVar.p() != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(jnVar.p());
                    int i2 = this.a;
                    bitmapDrawable.setBounds(0, 0, i2, i2);
                    bitmapDrawable.setGravity(119);
                    this.b.setSpan(new h47(bitmapDrawable, 1), this.c, this.d, 33);
                    int[] iArr = this.e;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 == 0) {
                        this.f.a(this.b);
                        return;
                    }
                    return;
                }
                this.b.setSpan("", this.c, this.d, 33);
                int[] iArr2 = this.e;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 == 0) {
                    this.f.a(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ i e;

        public e(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            i iVar;
            i iVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((e) jnVar, str, i);
                if (jnVar != null) {
                    Bitmap p = jnVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * 0.4d);
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new h47(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0 && (iVar2 = this.e) != null) {
                        iVar2.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0 && (iVar = this.e) != null) {
                    iVar.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ i e;

        public f(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            i iVar;
            Bitmap p;
            i iVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((f) jnVar, str, i);
                if (jnVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(jnVar.p());
                    int dimensionPixelSize = TbadkApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > yi.l(TbadkApplication.getInst()) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new ImageSpan(bitmapDrawable, 0), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0 && (iVar2 = this.e) != null) {
                        iVar2.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0 && (iVar = this.e) != null) {
                    iVar.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ i e;

        public g(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            i iVar;
            Bitmap p;
            i iVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((g) jnVar, str, i);
                if (jnVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(jnVar.p());
                    int dimensionPixelSize = TbadkApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > yi.l(TbadkApplication.getInst()) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new ImageSpan(bitmapDrawable, 0), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0 && (iVar2 = this.e) != null) {
                        iVar2.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0 && (iVar = this.e) != null) {
                    iVar.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ i e;

        public h(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            i iVar;
            i iVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((h) jnVar, str, i);
                if (jnVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(jnVar.p());
                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds54);
                    bitmapDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new fn(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0 && (iVar2 = this.e) != null) {
                        iVar2.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0 && (iVar = this.e) != null) {
                    iVar.a(this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684449, "Lcom/baidu/tieba/e47;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684449, "Lcom/baidu/tieba/e47;");
                return;
            }
        }
        a = new KeyEvent(0, 67);
    }

    public static void a(EditText editText) {
        Editable text;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, editText) != null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, a);
        }
        editText.onKeyDown(67, a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static ImageSpan b(jn jnVar, EmotionGroupType emotionGroupType, SpannableStringBuilder spannableStringBuilder, EditText editText) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, jnVar, emotionGroupType, spannableStringBuilder, editText)) == null) {
            if (jnVar == null) {
                return null;
            }
            Bitmap p = jnVar.p();
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, p);
            int width = p.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                int i2 = (int) (width * 0.4d);
                bitmapDrawable.setBounds(0, 0, i2, i2);
            } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || (!TextUtils.isEmpty(spannableStringBuilder) && spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX))) {
                int dimensionPixelSize = TbadkApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (editText != null && width2 > editText.getMeasuredWidth()) {
                    width2 = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
            }
            bitmapDrawable.setGravity(119);
            return new h47(bitmapDrawable, 1);
        }
        return (ImageSpan) invokeLLLL.objValue;
    }

    public static void c(Context context, yd5 yd5Var, EditText editText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, context, yd5Var, editText) == null) && yd5Var != null && editText != null && yd5Var.d() != null) {
            String d2 = yd5Var.d();
            EmotionGroupType type = yd5Var.getType();
            if (type != EmotionGroupType.LOCAL && type != EmotionGroupType.USER_COLLECT && !d2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                editText.getText().insert(editText.getSelectionStart(), d2);
            } else if (d2 != null) {
                sg.h().k(d2, 20, new b(editText, new SpannableStringBuilder(d2), type), 0, 0, BdUniqueId.gen(), null, d2, Boolean.FALSE, null);
            }
        }
    }

    public static void d(Context context, yd5 yd5Var, EditText editText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, yd5Var, editText) == null) && yd5Var != null && !TextUtils.isEmpty(yd5Var.d()) && !TextUtils.isEmpty(yd5Var.g()) && editText != null) {
            sg.h().k(yd5Var.g(), 10, new a(editText, yd5Var), 0, 0, BdUniqueId.gen(), new Object[0]);
        }
    }

    public static void e(Context context, CharSequence charSequence, int i2, i iVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65541, null, context, charSequence, i2, iVar) == null) && context != null && !TextUtils.isEmpty(charSequence) && iVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int[] iArr = {d47.a(charSequence)};
            if (iArr[0] <= 0) {
                iVar.a(spannableStringBuilder);
                return;
            }
            Matcher matcher = d47.a.matcher(spannableStringBuilder);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int end = matcher.end();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && runTask.getData() != null && ((Boolean) runTask.getData()).booleanValue()) {
                    sg.h().k(group, 20, new d(i2, spannableStringBuilder, start, end, iArr, iVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
                }
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, i iVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65542, null, context, charSequence, iVar) == null) && context != null && !TextUtils.isEmpty(charSequence) && iVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int[] iArr = {d47.a(charSequence)};
            if (iArr[0] <= 0) {
                if (iVar != null) {
                    iVar.a(spannableStringBuilder);
                    return;
                }
                return;
            }
            Matcher matcher = d47.a.matcher(spannableStringBuilder);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int end = matcher.end();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                    sg.h().k(group, 20, new h(spannableStringBuilder, start, end, iArr, iVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
                }
            }
        }
    }

    public static void g(Context context, CharSequence charSequence, i iVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, context, charSequence, iVar) == null) && context != null && !TextUtils.isEmpty(charSequence) && iVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int[] iArr = {d47.a(charSequence)};
            if (iArr[0] <= 0) {
                iVar.a(spannableStringBuilder);
                return;
            }
            Matcher matcher = d47.a.matcher(spannableStringBuilder);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int end = matcher.end();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && runTask.getData() != null && ((Boolean) runTask.getData()).booleanValue()) {
                    sg.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, iVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
                }
            }
        }
    }

    public static void h(Context context, CharSequence charSequence, i iVar) {
        String str;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, context, charSequence, iVar) == null) && context != null && !TextUtils.isEmpty(charSequence) && iVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int[] iArr = {d47.a(charSequence)};
            if (iArr[0] <= 0) {
                if (iVar != null) {
                    iVar.a(spannableStringBuilder);
                    return;
                }
                return;
            }
            Matcher matcher = d47.a.matcher(spannableStringBuilder);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int end = matcher.end();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                    sg.h().k(group, 20, new e(spannableStringBuilder, start, end, iArr, iVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
            while (true) {
                str = ",";
                if (!matcher2.find()) {
                    break;
                }
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5) {
                    sg.h().k(group2, 20, new f(spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, iVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
                }
            }
            Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
            while (matcher3.find()) {
                String[] split2 = matcher3.group().split(str);
                if (split2 != null && split2.length == 6) {
                    String str2 = str;
                    g gVar = new g(spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, iVar);
                    if (!TextUtils.isEmpty(split2[1])) {
                        sg.h().k(Uri.decode(split2[1].replace("net_", "")), 10, gVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                    }
                    str = str2;
                }
            }
        }
    }

    public static void i(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, jn jnVar, EmotionGroupType emotionGroupType) {
        ImageSpan b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{editText, spannableStringBuilder, Integer.valueOf(i2), jnVar, emotionGroupType}) == null) && editText != null && !TextUtils.isEmpty(spannableStringBuilder) && jnVar != null && (b2 = b(jnVar, emotionGroupType, spannableStringBuilder, editText)) != null) {
            spannableStringBuilder.setSpan(b2, 0, spannableStringBuilder.length(), 33);
            editText.getText().insert(i2, spannableStringBuilder);
        }
    }
}
