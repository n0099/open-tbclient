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
import c.a.d.f.p.n;
import c.a.d.f.p.w;
import c.a.o0.e1.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AnnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public float f31563d;

    /* renamed from: e  reason: collision with root package name */
    public Context f31564e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f31565f;

    /* loaded from: classes5.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AnnounceLayout f31566h;

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
            this.f31566h = announceLayout;
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31565f = (TextView) findViewById(R.id.obfuscated_res_0x7f09026f);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31564e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d011d, (ViewGroup) this, true);
            a();
        }
    }

    public final void c(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                int i = 2;
                if (!w.b(this.f31563d, this.f31565f.getPaint(), spannableStringBuilder.toString(), 2)) {
                    this.f31565f.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b7));
                spannableStringBuilder3.setSpan(new a(this, 2, null), 0, spannableStringBuilder3.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f31565f.getPaint(), (int) this.f31563d, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.f31563d;
                if (staticLayout.getLineCount() >= 2) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                    f2 = this.f31563d - staticLayout.getLineWidth(1);
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.f31565f.getPaint().measureText(spannableStringBuilder3.toString());
                while (measureText > this.f31565f.getPaint().measureText(subSequence.toString()) + f2) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
                }
                this.f31565f.setText(spannableStringBuilder);
                return;
            }
            this.f31565f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0555));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, c.a.p0.e0.b.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, fVar) == null) {
            super.setData(i, fVar);
            if (this.f31572b != null && this.f31573c != null && (i2 = this.a) >= 0) {
                if (i2 == c.a.p0.e0.e.a.f13757b) {
                    this.f31563d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds120) * 2);
                }
                int i3 = this.a;
                if (i3 == c.a.p0.e0.e.a.f13758c || i3 == c.a.p0.e0.e.a.f13759d) {
                    this.f31563d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds96) * 2);
                }
                c(new SpannableStringBuilder(this.f31573c.b()));
                return;
            }
            setVisibility(8);
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
        this.f31563d = n.q((Activity) getContext()).widthPixels - (n.f(getContext(), R.dimen.tbds90) * 2);
        b();
    }
}
