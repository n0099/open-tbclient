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
import c.a.d.f.p.l;
import c.a.d.f.p.t;
import c.a.q0.f1.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AnnounceLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f43146e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43147f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43148g;

    /* loaded from: classes10.dex */
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
            this.f43148g = (TextView) findViewById(R.id.announce_content);
        }
    }

    public final void b(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                int i2 = 2;
                if (!t.b(this.f43146e, this.f43148g.getPaint(), spannableStringBuilder.toString(), 2)) {
                    this.f43148g.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    return;
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("...");
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.detail));
                spannableStringBuilder3.setSpan(new a(this, 2, null), 0, spannableStringBuilder3.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f43148g.getPaint(), (int) this.f43146e, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.f43146e;
                if (staticLayout.getLineCount() >= 2) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                    f2 = this.f43146e - staticLayout.getLineWidth(1);
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.f43148g.getPaint().measureText(spannableStringBuilder3.toString());
                while (measureText > this.f43148g.getPaint().measureText(subSequence.toString()) + f2) {
                    i2++;
                    if (spannableStringBuilder.length() - i2 < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i2, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i2 > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i2, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
                }
                this.f43148g.setText(spannableStringBuilder);
                return;
            }
            this.f43148g.setText(TbadkCoreApplication.getInst().getString(R.string.empty_announce));
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43147f = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setGravity(17);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.announce_layout, (ViewGroup) this, true);
            a();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.mElectionData == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f43148g, R.color.CAM_X0205, i2);
        if (TextUtils.isEmpty(this.mElectionData.b())) {
            SkinManager.setViewTextColor(this.f43148g, R.color.CAM_X0109, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.f43148g, R.color.CAM_X0105, 1, i2);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, c.a.r0.c0.b.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.mData != null && this.mElectionData != null && (i3 = this.status) >= 0) {
                if (i3 == c.a.r0.c0.e.a.f15016b) {
                    this.f43146e = l.q((Activity) getContext()).widthPixels - (l.f(getContext(), R.dimen.tbds120) * 2);
                }
                int i4 = this.status;
                if (i4 == c.a.r0.c0.e.a.f15017c || i4 == c.a.r0.c0.e.a.f15018d) {
                    this.f43146e = l.q((Activity) getContext()).widthPixels - (l.f(getContext(), R.dimen.tbds96) * 2);
                }
                b(new SpannableStringBuilder(this.mElectionData.b()));
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
        this.f43146e = l.q((Activity) getContext()).widthPixels - (l.f(getContext(), R.dimen.tbds90) * 2);
        initUI();
    }
}
