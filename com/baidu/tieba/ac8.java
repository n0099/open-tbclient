package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ac8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends bg<rm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ EmotionGroupType d;
        public final /* synthetic */ ac8 e;

        public a(ac8 ac8Var, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac8Var, editText, spannableStringBuilder, Integer.valueOf(i), emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ac8Var;
            this.a = editText;
            this.b = spannableStringBuilder;
            this.c = i;
            this.d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                super.onLoaded((a) rmVar, str, i);
                if (rmVar != null) {
                    this.e.c(this.a, this.b, this.c, rmVar, this.d);
                }
            }
        }
    }

    public ac8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, b75 b75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdBaseActivity, editText, b75Var) == null) {
            if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
                Toast makeText = Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
                GreyUtil.grey(makeText);
                makeText.show();
                return;
            }
            String d = b75Var.d();
            EmotionGroupType type = b75Var.getType();
            if (d != null) {
                cg.h().k(d, 20, new a(this, editText, new SpannableStringBuilder(d), editText.getSelectionStart(), type), 0, 0, bdBaseActivity.getUniqueId(), null, d, Boolean.FALSE, null);
            }
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, rm rmVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{editText, spannableStringBuilder, Integer.valueOf(i), rmVar, emotionGroupType}) == null) {
            Bitmap p = rmVar.p();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            int width = p.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (width * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            editText.getText().insert(i, spannableStringBuilder);
        }
    }
}
