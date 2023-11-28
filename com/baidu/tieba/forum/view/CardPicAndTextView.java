package com.baidu.tieba.forum.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.databinding.CardPicAndTextViewBinding;
import com.baidu.tieba.gb7;
import com.baidu.tieba.s77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J&\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/forum/view/CardPicAndTextView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CARD_HORIZONTAL_MARGIN", "HORIZONTAL_WIDTH", "SCREEN_WIDTH", "binding", "Lcom/baidu/tieba/forum/databinding/CardPicAndTextViewBinding;", "mHasRead", "", "initImageViewLayout", "", "onChangeSkin", "setData", "textBuilder", "Landroid/text/SpannableStringBuilder;", SocialConstants.PARAM_IMAGE, "", "Lcom/baidu/tieba/feed/data/PicData;", "hasRead", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CardPicAndTextView extends LinearLayout implements gb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardPicAndTextViewBinding a;
    public final int b;
    public final int c;
    public final int d;
    public boolean e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPicAndTextView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPicAndTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardPicAndTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        new LinkedHashMap();
        this.b = (BdUtilHelper.getDimens(context, R.dimen.M_W_X011) * 2) + BdUtilHelper.getDimens(context, R.dimen.tbds333);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        this.c = equipmentWidth;
        this.d = equipmentWidth - this.b;
        CardPicAndTextViewBinding b = CardPicAndTextViewBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b, "inflate(LayoutInflater.from(context), this)");
        this.a = b;
        a();
        f();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('+' char), (wrap: int : 0x0064: ARITH  (r6v3 int A[REMOVE]) = (wrap: int : 0x0060: INVOKE  (r6v2 int A[REMOVE]) = (r6v0 'pics' java.util.List<? extends com.baidu.tieba.s77>) type: INTERFACE call: java.util.List.size():int) - (1 int))] */
    public final void setData(SpannableStringBuilder spannableStringBuilder, List<? extends s77> pics, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, pics, z) == null) {
            Intrinsics.checkNotNullParameter(pics, "pics");
            if (pics.isEmpty()) {
                return;
            }
            this.e = z;
            ThreadCardUtils.cutAndSetTextByMaxLineForDotNew(this.a.d, spannableStringBuilder, 4, this.d);
            if (z) {
                EMManager.from(this.a.d).setTextColor(R.color.CAM_X0109);
            } else {
                EMManager.from(this.a.d).setTextColor(R.color.CAM_X0107);
            }
            this.a.b.startLoad(pics.get(0).a);
            if (pics.size() > 1) {
                TextView textView = this.a.c;
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(pics.size() - 1);
                textView.setText(sb.toString());
                this.a.c.setVisibility(0);
                return;
            }
            this.a.c.setVisibility(8);
        }
    }

    public /* synthetic */ CardPicAndTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.b.setPlaceHolder(2);
            this.a.b.setDrawCorner(true);
            this.a.b.setDrawBorder(true);
            this.a.b.setRadiusById(R.string.J_X05);
            this.a.b.setConrers(15);
            this.a.b.setForegroundColor(0);
            this.a.b.setBorderSurroundContent(true);
            this.a.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.b.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.L_X02));
        }
    }

    @Override // com.baidu.tieba.gb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.a.c).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
            this.a.d.setLineSpacing(getResources().getDimensionPixelSize(R.dimen.M_T_X001), 1.0f);
            if (this.e) {
                EMManager.from(this.a.d).setTextColor(R.color.CAM_X0109);
            } else {
                EMManager.from(this.a.d).setTextColor(R.color.CAM_X0107);
            }
        }
    }
}
