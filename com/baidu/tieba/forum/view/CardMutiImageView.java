package com.baidu.tieba.forum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f77;
import com.baidu.tieba.forum.databinding.CardMutiImageViewBinding;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/forum/view/CardMutiImageView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PIC_MAX_NUM", "binding", "Lcom/baidu/tieba/forum/databinding/CardMutiImageViewBinding;", "initImageViewLayout", "", "imageView", "Lcom/baidu/tbadk/widget/TbImageView;", "onChangeSkinType", "setData", SocialConstants.PARAM_IMAGE, "", "Lcom/baidu/tieba/feed/data/PicData;", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CardMutiImageView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CardMutiImageViewBinding a;
    public final int b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardMutiImageView(Context context) {
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
    public CardMutiImageView(Context context, AttributeSet attributeSet) {
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
    public CardMutiImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.b = 3;
        CardMutiImageViewBinding b = CardMutiImageViewBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b, "inflate(LayoutInflater.from(context), this)");
        this.a = b;
        TbImageView tbImageView = b.b;
        Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.imageOne");
        a(tbImageView);
        TbImageView tbImageView2 = this.a.d;
        Intrinsics.checkNotNullExpressionValue(tbImageView2, "binding.imageTwo");
        a(tbImageView2);
        TbImageView tbImageView3 = this.a.c;
        Intrinsics.checkNotNullExpressionValue(tbImageView3, "binding.imageThree");
        a(tbImageView3);
        b();
    }

    public /* synthetic */ CardMutiImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbImageView) == null) {
            tbImageView.setPlaceHolder(2);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setRadiusById(R.string.J_X05);
            tbImageView.setConrers(15);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.L_X02));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.a.e).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('+' char), (wrap: int : 0x00a0: ARITH  (r8v18 int A[REMOVE]) = (wrap: int : 0x009a: INVOKE  (r8v17 int A[REMOVE]) = (r8v0 'pics' java.util.List<? extends com.baidu.tieba.f77>) type: INTERFACE call: java.util.List.size():int) - (wrap: int : 0x009e: IGET  (r2v2 int A[REMOVE]) = (r7v0 'this' com.baidu.tieba.forum.view.CardMutiImageView A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.forum.view.CardMutiImageView.b int))] */
    public final void setData(List<? extends f77> pics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pics) == null) {
            Intrinsics.checkNotNullParameter(pics, "pics");
            if (pics.isEmpty()) {
                return;
            }
            int size = pics.size();
            if (size != 1) {
                if (size != 2) {
                    this.a.b.setVisibility(0);
                    this.a.b.startLoad(pics.get(0).a);
                    this.a.d.setVisibility(0);
                    this.a.d.startLoad(pics.get(1).a);
                    this.a.c.setVisibility(0);
                    this.a.c.startLoad(pics.get(2).a);
                    this.a.b.setRadiusById(R.string.J_X12);
                    this.a.d.setRadiusById(R.string.J_X02);
                    this.a.c.setRadiusById(R.string.J_X11);
                    if (pics.size() > this.b) {
                        this.a.e.setVisibility(0);
                        TextView textView = this.a.e;
                        StringBuilder sb = new StringBuilder();
                        sb.append('+');
                        sb.append(pics.size() - this.b);
                        textView.setText(sb.toString());
                        return;
                    }
                    return;
                }
                this.a.b.setVisibility(0);
                this.a.b.startLoad(pics.get(0).a);
                this.a.d.setVisibility(0);
                this.a.d.startLoad(pics.get(1).a);
                this.a.b.setRadiusById(R.string.J_X12);
                this.a.d.setRadiusById(R.string.J_X11);
                this.a.c.setVisibility(8);
                return;
            }
            this.a.b.setVisibility(0);
            this.a.b.startLoad(pics.get(0).a);
            this.a.d.setVisibility(8);
            this.a.c.setVisibility(8);
        }
    }
}
