package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b0a;
import com.baidu.tieba.gy9;
import com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout;
import com.baidu.tieba.n8a;
import com.baidu.tieba.p75;
import com.baidu.tieba.qy;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010$\u001a\u00020%2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010&2\u0006\u0010'\u001a\u00020\bH\u0016J\u001a\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0018R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/homepage/concern/view/RecommendHotReplyLayout;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/card/IChangeSkinAble;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "Ltbclient/ThemeColorInfo;", "mAgreeView", "Lcom/baidu/tbadk/core/view/AgreeView;", "getMAgreeView", "()Lcom/baidu/tbadk/core/view/AgreeView;", "mAgreeView$delegate", "Lkotlin/Lazy;", "mHeadPhotoView", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getMHeadPhotoView", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "mHeadPhotoView$delegate", "mOutOnClickListener", "Landroid/view/View$OnClickListener;", "mRichTextView", "Landroid/widget/TextView;", "getMRichTextView", "()Landroid/widget/TextView;", "mRichTextView$delegate", "mRootLayout", "Landroid/widget/LinearLayout;", "getMRootLayout", "()Landroid/widget/LinearLayout;", "mRootLayout$delegate", "mSkinType", "onChangeSkinType", "", "Lcom/baidu/tbadk/TbPageContext;", WriteMulitImageActivityConfig.SKIN_TYPE, "setData", "data", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "postColor", "setOutOnClickListener", TTDownloadField.TT_ITEM_CLICK_LISTENER, "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RecommendHotReplyLayout extends RelativeLayout implements qy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;
    public ThemeColorInfo b;
    public int c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendHotReplyLayout(Context context) {
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
    public RecommendHotReplyLayout(Context context, AttributeSet attributeSet) {
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
    public RecommendHotReplyLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.c = 3;
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout$mRootLayout$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendHotReplyLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (LinearLayout) this.this$0.findViewById(R.id.obfuscated_res_0x7f090f79);
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<HeadImageView>(this) { // from class: com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout$mHeadPhotoView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendHotReplyLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HeadImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (HeadImageView) this.this$0.findViewById(R.id.obfuscated_res_0x7f090f7b);
                }
                return (HeadImageView) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout$mRichTextView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendHotReplyLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.obfuscated_res_0x7f090f7a);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<AgreeView>(this) { // from class: com.baidu.tieba.homepage.concern.view.RecommendHotReplyLayout$mAgreeView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendHotReplyLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AgreeView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (AgreeView) this.this$0.findViewById(R.id.obfuscated_res_0x7f090f78);
                }
                return (AgreeView) invokeV.objValue;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0825, (ViewGroup) this, true);
        getMHeadPhotoView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        getMHeadPhotoView().setPlaceHolder(1);
        getMHeadPhotoView().setIsRound(true);
        getMRichTextView().setMaxWidth(wi.l(context) - wi.g(context, R.dimen.tbds390));
        int g = wi.g(context, R.dimen.tbds72);
        getMAgreeView().setAgreeClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tw7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    RecommendHotReplyLayout.a(RecommendHotReplyLayout.this, view2);
                }
            }
        });
        getMAgreeView().v(g, g, 0, 0);
    }

    public /* synthetic */ RecommendHotReplyLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(RecommendHotReplyLayout this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View.OnClickListener onClickListener = this$0.a;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    private final AgreeView getMAgreeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Object value = this.g.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mAgreeView>(...)");
            return (AgreeView) value;
        }
        return (AgreeView) invokeV.objValue;
    }

    private final HeadImageView getMHeadPhotoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mHeadPhotoView>(...)");
            return (HeadImageView) value;
        }
        return (HeadImageView) invokeV.objValue;
    }

    private final TextView getMRichTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Object value = this.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mRichTextView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final LinearLayout getMRootLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mRootLayout>(...)");
            return (LinearLayout) value;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) && this.c != i) {
            int color = SkinManager.getColor(i, (int) R.color.CAM_X0301);
            int a = gy9.a(color, 0.06f);
            int a2 = gy9.a(color, 0.04f);
            ThemeColorInfo themeColorInfo = this.b;
            if (themeColorInfo != null) {
                String f = n8a.f(themeColorInfo);
                if (f.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    a2 = gy9.f(f);
                }
                String d = n8a.d(themeColorInfo);
                if (d.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    a = gy9.f(d);
                }
            }
            p75 d2 = p75.d(getMRootLayout());
            d2.o(R.string.J_X18);
            d2.r(new int[]{a, a2}, Direction.LEFT);
            p75 d3 = p75.d(getMRichTextView());
            d3.C(R.dimen.T_X12);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0105);
            this.c = i;
        }
    }

    public final void setData(b0a b0aVar, ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b0aVar, themeColorInfo) != null) || b0aVar == null) {
            return;
        }
        getMHeadPhotoView().N(b0aVar.q().getAvater(), 28, false);
        this.b = themeColorInfo;
        getMRichTextView().setText(b0aVar.e0().toString());
        getMAgreeView().setAgreeAlone(true);
        getMAgreeView().setData(b0aVar.o());
        onChangeSkinType(TbadkCoreApplication.getInst().getCurrentPageContext(getContext()), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void setOutOnClickListener(View.OnClickListener itemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemClickListener) == null) {
            Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.a = itemClickListener;
        }
    }
}
