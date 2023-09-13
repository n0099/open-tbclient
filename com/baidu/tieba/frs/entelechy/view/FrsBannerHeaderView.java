package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.util.ObjectUtilKt;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.cra;
import com.baidu.tieba.l06;
import com.baidu.tieba.m06;
import com.baidu.tieba.wh7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0006\u0010#\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0010J\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/baidu/tieba/frs/entelechy/view/FrsBannerHeaderView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBrandIcon", "Lcom/baidu/tbadk/widget/image/TbImage;", "mForumId", "", "mForumName", "mFrsBannerHeaderData", "Lcom/baidu/tbadk/core/data/FrsBannerHeaderData;", "mJumpTipsIcon", "mLeftIcon", "Lcom/baidu/tbadk/widget/TbImageView;", "mRightIcon", "Landroid/widget/ImageView;", "mRootView", "Landroid/view/View;", "mTvContent1", "Landroid/widget/TextView;", "mTvContent2", "mTvJumpTipsView", "fillBrandIcon", "", "fillDataOnWidget", "fillJumpTipIcon", "initView", "onClick", "v", "onSkinChanged", "setData", "data", "setForumInfo", "fId", "fName", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsBannerHeaderView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TbImage f;
    public TextView g;
    public TbImage h;
    public ImageView i;
    public FrsBannerHeaderData j;
    public String k;
    public String l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsBannerHeaderView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
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
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsBannerHeaderView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1700227908, "Lcom/baidu/tieba/frs/entelechy/view/FrsBannerHeaderView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1700227908, "Lcom/baidu/tieba/frs/entelechy/view/FrsBannerHeaderView;");
                return;
            }
        }
        m = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
    }

    public final void c() {
        FrsBannerHeaderData frsBannerHeaderData;
        IconUrlInfo brandIcon;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsBannerHeaderData = this.j) != null && (brandIcon = frsBannerHeaderData.getBrandIcon()) != null) {
            ObjectUtilKt.checkNull(brandIcon, new Function1<IconUrlInfo, Unit>(this) { // from class: com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView$fillBrandIcon$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsBannerHeaderView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IconUrlInfo iconUrlInfo) {
                    invoke2(iconUrlInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(IconUrlInfo it) {
                    String iconUrl;
                    TbImage tbImage;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (TbadkApplication.getInst().getSkinType() == 4) {
                            iconUrl = it.dark;
                        } else {
                            iconUrl = it.day;
                        }
                        tbImage = this.this$0.f;
                        if (tbImage != null) {
                            if (StringUtils.isNull(iconUrl)) {
                                tbImage.setVisibility(8);
                                return;
                            }
                            tbImage.setVisibility(0);
                            l06 a = m06.a.a();
                            Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
                            a.a(iconUrl, tbImage);
                        }
                    }
                }
            }, new Function0<Unit>(this) { // from class: com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView$fillBrandIcon$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsBannerHeaderView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.f;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    TbImage tbImage;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && tbImage != null) {
                        tbImage.setVisibility(8);
                    }
                }
            });
        }
    }

    public final void e() {
        FrsBannerHeaderData frsBannerHeaderData;
        IconUrlInfo jumpTipsIcon;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frsBannerHeaderData = this.j) != null && (jumpTipsIcon = frsBannerHeaderData.getJumpTipsIcon()) != null) {
            ObjectUtilKt.checkNull(jumpTipsIcon, new Function1<IconUrlInfo, Unit>(this) { // from class: com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView$fillJumpTipIcon$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsBannerHeaderView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IconUrlInfo iconUrlInfo) {
                    invoke2(iconUrlInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(IconUrlInfo it) {
                    String iconUrl;
                    TbImage tbImage;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (TbadkApplication.getInst().getSkinType() == 4) {
                            iconUrl = it.dark;
                        } else {
                            iconUrl = it.day;
                        }
                        tbImage = this.this$0.h;
                        if (tbImage != null) {
                            if (StringUtils.isNull(iconUrl)) {
                                tbImage.setVisibility(8);
                                return;
                            }
                            tbImage.setVisibility(0);
                            l06 a = m06.a.a();
                            Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
                            a.a(iconUrl, tbImage);
                        }
                    }
                }
            }, new Function0<Unit>(this) { // from class: com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView$fillJumpTipIcon$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrsBannerHeaderView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.h;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    TbImage tbImage;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && tbImage != null) {
                        tbImage.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsBannerHeaderView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.a = mContext;
        f();
    }

    public /* synthetic */ FrsBannerHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setData(FrsBannerHeaderData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.j = data;
            d();
            g();
        }
    }

    public final void d() {
        String str;
        boolean z;
        String str2;
        String str3;
        boolean z2;
        String str4;
        String str5;
        String iconUrl;
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrsBannerHeaderData frsBannerHeaderData = this.j;
            if (frsBannerHeaderData != null && (iconUrl = frsBannerHeaderData.getIconUrl()) != null && (tbImageView = this.c) != null) {
                tbImageView.startLoad(iconUrl, 10, false);
            }
            FrsBannerHeaderData frsBannerHeaderData2 = this.j;
            String str6 = null;
            if (frsBannerHeaderData2 != null) {
                str = frsBannerHeaderData2.getContent1();
            } else {
                str = null;
            }
            boolean z3 = true;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                TextView textView = this.d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.d;
                if (textView3 != null) {
                    FrsBannerHeaderData frsBannerHeaderData3 = this.j;
                    if (frsBannerHeaderData3 != null) {
                        str2 = frsBannerHeaderData3.getContent1();
                    } else {
                        str2 = null;
                    }
                    textView3.setText(str2);
                }
            }
            FrsBannerHeaderData frsBannerHeaderData4 = this.j;
            if (frsBannerHeaderData4 != null) {
                str3 = frsBannerHeaderData4.getContent2();
            } else {
                str3 = null;
            }
            if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                TextView textView4 = this.e;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            } else {
                TextView textView5 = this.e;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                TextView textView6 = this.e;
                if (textView6 != null) {
                    FrsBannerHeaderData frsBannerHeaderData5 = this.j;
                    if (frsBannerHeaderData5 != null) {
                        str4 = frsBannerHeaderData5.getContent2();
                    } else {
                        str4 = null;
                    }
                    textView6.setText(str4);
                }
            }
            FrsBannerHeaderData frsBannerHeaderData6 = this.j;
            if (frsBannerHeaderData6 != null) {
                str5 = frsBannerHeaderData6.getJumpTips();
            } else {
                str5 = null;
            }
            if (str5 != null && !StringsKt__StringsJVMKt.isBlank(str5)) {
                z3 = false;
            }
            if (z3) {
                TextView textView7 = this.g;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView8 = this.g;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            TextView textView9 = this.g;
            if (textView9 != null) {
                FrsBannerHeaderData frsBannerHeaderData7 = this.j;
                if (frsBannerHeaderData7 != null) {
                    str6 = frsBannerHeaderData7.getJumpTips();
                }
                textView9.setText(StringHelper.subString(str6, 20));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        ThemeColorInfo themeColorInfo;
        String str;
        String str2;
        boolean z;
        String[] strArr;
        FrsBannerHeaderData frsBannerHeaderData;
        ThemeColorInfo themeColorInfo2;
        FrsBannerHeaderData frsBannerHeaderData2;
        ThemeColorInfo themeColorInfo3;
        FrsBannerHeaderData frsBannerHeaderData3;
        ThemeColorInfo themeColorInfo4;
        TextView textView;
        TextView textView2;
        TextView textView3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrsBannerHeaderData frsBannerHeaderData4 = this.j;
            if (frsBannerHeaderData4 != null) {
                themeColorInfo = frsBannerHeaderData4.getBackgroundColor();
            } else {
                themeColorInfo = null;
            }
            if (themeColorInfo != null) {
                str2 = cra.d(themeColorInfo);
                str = cra.f(themeColorInfo);
            } else {
                str = null;
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    Intrinsics.checkNotNull(str2);
                    Intrinsics.checkNotNull(str);
                    strArr = new String[]{str2, str};
                    TBSelector.makeDrawableSelector().setShape(0).gradientLinear((String[]) Arrays.copyOf(strArr, strArr.length)).setGradientOrientation(DrawableSelector.LEFT_RIGHT).tlRadius(m).trRadius(m).into(this);
                    frsBannerHeaderData = this.j;
                    if (frsBannerHeaderData == null) {
                        themeColorInfo2 = frsBannerHeaderData.getContent1Color();
                    } else {
                        themeColorInfo2 = null;
                    }
                    if (themeColorInfo2 != null && (textView3 = this.d) != null) {
                        textView3.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo2, R.color.CAM_X0622));
                    }
                    frsBannerHeaderData2 = this.j;
                    if (frsBannerHeaderData2 == null) {
                        themeColorInfo3 = frsBannerHeaderData2.getContent2Color();
                    } else {
                        themeColorInfo3 = null;
                    }
                    if (themeColorInfo3 != null && (textView2 = this.e) != null) {
                        textView2.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo3, R.color.CAM_X0618));
                    }
                    frsBannerHeaderData3 = this.j;
                    if (frsBannerHeaderData3 == null) {
                        themeColorInfo4 = frsBannerHeaderData3.getJumpTipsColor();
                    } else {
                        themeColorInfo4 = null;
                    }
                    if (themeColorInfo4 != null && (textView = this.g) != null) {
                        textView.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo4, R.color.CAM_X0622));
                    }
                    WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
                    c();
                    e();
                }
            }
            strArr = new String[]{"#66000000", "#66000000"};
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear((String[]) Arrays.copyOf(strArr, strArr.length)).setGradientOrientation(DrawableSelector.LEFT_RIGHT).tlRadius(m).trRadius(m).into(this);
            frsBannerHeaderData = this.j;
            if (frsBannerHeaderData == null) {
            }
            if (themeColorInfo2 != null) {
                textView3.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo2, R.color.CAM_X0622));
            }
            frsBannerHeaderData2 = this.j;
            if (frsBannerHeaderData2 == null) {
            }
            if (themeColorInfo3 != null) {
                textView2.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo3, R.color.CAM_X0618));
            }
            frsBannerHeaderData3 = this.j;
            if (frsBannerHeaderData3 == null) {
            }
            if (themeColorInfo4 != null) {
                textView.setTextColor(SkinManager.getColorFromServerColor(themeColorInfo4, R.color.CAM_X0622));
            }
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            c();
            e();
        }
    }

    public final void f() {
        TbImageView tbImageView;
        TextView textView;
        TextView textView2;
        TbImage tbImage;
        TextView textView3;
        TbImage tbImage2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0353, (ViewGroup) this, true);
            this.b = inflate;
            ImageView imageView = null;
            if (inflate != null) {
                tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c6c);
            } else {
                tbImageView = null;
            }
            this.c = tbImageView;
            View view2 = this.b;
            if (view2 != null) {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c69);
            } else {
                textView = null;
            }
            this.d = textView;
            View view3 = this.b;
            if (view3 != null) {
                textView2 = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090c6a);
            } else {
                textView2 = null;
            }
            this.e = textView2;
            View view4 = this.b;
            if (view4 != null) {
                tbImage = (TbImage) view4.findViewById(R.id.obfuscated_res_0x7f090c67);
            } else {
                tbImage = null;
            }
            this.f = tbImage;
            View view5 = this.b;
            if (view5 != null) {
                textView3 = (TextView) view5.findViewById(R.id.obfuscated_res_0x7f090c6b);
            } else {
                textView3 = null;
            }
            this.g = textView3;
            View view6 = this.b;
            if (view6 != null) {
                tbImage2 = (TbImage) view6.findViewById(R.id.obfuscated_res_0x7f090c6f);
            } else {
                tbImage2 = null;
            }
            this.h = tbImage2;
            View view7 = this.b;
            if (view7 != null) {
                imageView = (ImageView) view7.findViewById(R.id.obfuscated_res_0x7f090c6d);
            }
            this.i = imageView;
            TbImageView tbImageView2 = this.c;
            if (tbImageView2 != null) {
                tbImageView2.setDefaultResource(17170445);
            }
            TbImageView tbImageView3 = this.c;
            if (tbImageView3 != null) {
                tbImageView3.setPlaceHolder(1);
            }
            View view8 = this.b;
            if (view8 != null) {
                view8.setOnClickListener(this);
            }
            TbImageView tbImageView4 = this.c;
            if (tbImageView4 != null) {
                tbImageView4.setDrawCorner(true);
                tbImageView4.setConrers(15);
                tbImageView4.setRadiusById(R.string.J_X05);
            }
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String str;
        boolean z;
        String type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (Intrinsics.areEqual(v, this.b) && (getContext() instanceof TbPageContextSupport)) {
                FrsBannerHeaderData frsBannerHeaderData = this.j;
                String str2 = null;
                if (frsBannerHeaderData != null) {
                    str = frsBannerHeaderData.getJumpLink();
                } else {
                    str = null;
                }
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    Context context = getContext();
                    if (context != null) {
                        TbPageContext<?> pageContext = ((TbPageContextSupport) context).getPageContext();
                        if (pageContext == null || wh7.f().i()) {
                            return;
                        }
                        UrlManager urlManager = UrlManager.getInstance();
                        String[] strArr = new String[1];
                        FrsBannerHeaderData frsBannerHeaderData2 = this.j;
                        if (frsBannerHeaderData2 != null) {
                            str2 = frsBannerHeaderData2.getJumpLink();
                        }
                        strArr[0] = str2;
                        urlManager.dealOneLink(pageContext, strArr);
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FRS_BANNER_HEADER_CLICK);
                        String str3 = this.k;
                        if (str3 != null) {
                            statisticItem.param("fid", str3);
                        }
                        String str4 = this.l;
                        if (str4 != null) {
                            statisticItem.param("fname", str4);
                        }
                        FrsBannerHeaderData frsBannerHeaderData3 = this.j;
                        if (frsBannerHeaderData3 != null && (type = frsBannerHeaderData3.getType()) != null) {
                            Intrinsics.checkNotNullExpressionValue(type, "type");
                            statisticItem.param("obj_type", type);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
                }
            }
        }
    }

    public final void setForumInfo(String fId, String fName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fId, fName) == null) {
            Intrinsics.checkNotNullParameter(fId, "fId");
            Intrinsics.checkNotNullParameter(fName, "fName");
            this.k = fId;
            this.l = fName;
        }
    }
}
