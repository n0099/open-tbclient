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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.e.p.t;
import d.a.r0.b1.m.f;
/* loaded from: classes5.dex */
public class AnnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public float f14398h;

    /* renamed from: i  reason: collision with root package name */
    public Context f14399i;
    public TextView j;

    /* loaded from: classes5.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnnounceLayout l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnnounceLayout announceLayout, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {announceLayout, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = announceLayout;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.j = (TextView) findViewById(R.id.announce_content);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14399i = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.announce_layout, (ViewGroup) this, true);
            a();
        }
    }

    public final void c(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                int i2 = 2;
                if (!t.b(this.f14398h, this.j.getPaint(), spannableStringBuilder.toString(), 2)) {
                    this.j.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.detail));
                spannableStringBuilder3.setSpan(new a(this, 2, null), 0, spannableStringBuilder3.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.j.getPaint(), (int) this.f14398h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.f14398h;
                if (staticLayout.getLineCount() >= 2) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                    f2 = this.f14398h - staticLayout.getLineWidth(1);
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.j.getPaint().measureText(spannableStringBuilder3.toString());
                while (measureText > this.j.getPaint().measureText(subSequence.toString()) + f2) {
                    i2++;
                    if (spannableStringBuilder.length() - i2 < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i2, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i2 > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i2, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
                }
                this.j.setText(spannableStringBuilder);
                return;
            }
            this.j.setText(TbadkCoreApplication.getInst().getString(R.string.empty_announce));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, d.a.s0.x.b.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.f14404f != null && this.f14405g != null && (i3 = this.f14403e) >= 0) {
                if (i3 == d.a.s0.x.e.a.f69383b) {
                    this.f14398h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds120) * 2);
                }
                int i4 = this.f14403e;
                if (i4 == d.a.s0.x.e.a.f69384c || i4 == d.a.s0.x.e.a.f69385d) {
                    this.f14398h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
                }
                c(new SpannableStringBuilder(this.f14405g.b()));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14398h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds90) * 2);
        b();
    }
}
