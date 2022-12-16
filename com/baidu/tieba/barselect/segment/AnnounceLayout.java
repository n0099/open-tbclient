package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hj;
import com.baidu.tieba.m36;
import com.baidu.tieba.t36;
import com.baidu.tieba.tn5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AnnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float d;
    public Context e;
    public TextView f;

    /* loaded from: classes3.dex */
    public class a extends tn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnnounceLayout i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnnounceLayout announceLayout, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {announceLayout, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = announceLayout;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnounceLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = yi.t((Activity) getContext()).widthPixels - (yi.g(getContext(), R.dimen.tbds90) * 2);
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090294);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d011e, (ViewGroup) this, true);
            a();
        }
    }

    public final void c(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                int i = 2;
                if (!hj.b(this.d, this.f.getPaint(), spannableStringBuilder.toString(), 2)) {
                    this.f.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04eb));
                spannableStringBuilder3.setSpan(new a(this, 2, null), 0, spannableStringBuilder3.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f.getPaint(), (int) this.d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f = this.d;
                if (staticLayout.getLineCount() >= 2) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                    f = this.d - staticLayout.getLineWidth(1);
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.f.getPaint().measureText(spannableStringBuilder3.toString());
                while (measureText > this.f.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
                }
                this.f.setText(spannableStringBuilder);
                return;
            }
            this.f.setText(TbadkCoreApplication.getInst().getString(R.string.empty_announce));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, m36 m36Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, m36Var) == null) {
            super.setData(i, m36Var);
            if (this.b != null && this.c != null && (i2 = this.a) >= 0) {
                if (i2 == t36.b) {
                    this.d = yi.t((Activity) getContext()).widthPixels - (yi.g(getContext(), R.dimen.tbds120) * 2);
                }
                int i3 = this.a;
                if (i3 == t36.c || i3 == t36.d) {
                    this.d = yi.t((Activity) getContext()).widthPixels - (yi.g(getContext(), R.dimen.tbds96) * 2);
                }
                c(new SpannableStringBuilder(this.c.b()));
                return;
            }
            setVisibility(8);
        }
    }
}
