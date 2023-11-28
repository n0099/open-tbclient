package com.baidu.tieba.forum.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.feed.widget.HeadImageView;
import com.baidu.tieba.forum.databinding.TopCardItemViewBinding;
import com.baidu.tieba.forum.view.TopCardItemView;
import com.baidu.tieba.gb7;
import com.baidu.tieba.h67;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.u25;
import com.baidu.tieba.ua7;
import com.baidu.tieba.uua;
import com.baidu.tieba.v57;
import com.baidu.tieba.vm7;
import com.baidu.tieba.y77;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B'\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0015J\u000e\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0015J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0015H\u0002J\u0016\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0015J\u000e\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u0015J\u0016\u0010;\u001a\u00020(2\u0006\u0010/\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015J\u0010\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\u0015H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/baidu/tieba/forum/view/TopCardItemView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CARD_HORIZONTAL_MARGIN", "HORIZONTAL_WIDTH", "SCREEN_WIDTH", "binding", "Lcom/baidu/tieba/forum/databinding/TopCardItemViewBinding;", "cardPicAndTextView", "Lcom/baidu/tieba/forum/view/CardPicAndTextView;", "getCardPicAndTextView", "()Lcom/baidu/tieba/forum/view/CardPicAndTextView;", "hasRead", "", "isCompleteThread", "()Z", "setCompleteThread", "(Z)V", "mThemeColorInfo", "", "textView", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getTextView", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "tid", "getTid", "()Ljava/lang/String;", "setTid", "(Ljava/lang/String;)V", "topCardData", "Lcom/baidu/tieba/feed/data/TopCardData;", "initView", "", "onChangeSkin", "onClick", "v", "Landroid/view/View;", "setData", "data", "isShowComplete", "themeColorInfo", "isLiked", "setSplitViewVisible", "isVisible", "setTitleBold", "bold", "setViewStyle", "itemStyle", "showOneItem", "showCompleteCard", "showComplete", "updateAfterRead", "updateHasReadVisible", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TopCardItemView extends LinearLayout implements View.OnClickListener, gb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TopCardItemViewBinding a;
    public final int b;
    public final int c;
    public final int d;
    public e87 e;
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public final EMTextView j;
    public final CardPicAndTextView k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1313502124, "Lcom/baidu/tieba/forum/view/TopCardItemView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1313502124, "Lcom/baidu/tieba/forum/view/TopCardItemView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardItemView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
    }

    /* loaded from: classes6.dex */
    public static final class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopCardItemView a;

        public a(TopCardItemView topCardItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topCardItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topCardItemView;
        }

        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        public void a(h67 data, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, data, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(view2, "view");
                String G = data.G();
                if (G == null || G.length() == 0) {
                }
                TopCardItemView topCardItemView = this.a;
                ua7.c(topCardItemView.getContext(), data.G());
                e87 e87Var = topCardItemView.e;
                String str = null;
                if (e87Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                    e87Var = null;
                }
                y77 h = e87Var.h();
                if (h != null) {
                    str = Long.valueOf(h.d).toString();
                }
                vm7.b(str, topCardItemView.g, topCardItemView.e(), 2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopCardItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
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
        new LinkedHashMap();
        this.b = BdUtilHelper.getDimens(context, R.dimen.M_W_X011) * 2;
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(context);
        this.c = equipmentWidth;
        this.d = equipmentWidth - this.b;
        this.f = "#FF2B87FF";
        this.h = "";
        this.j = new EMTextView(context);
        this.k = new CardPicAndTextView(context, null, 0, 6, null);
        setOrientation(1);
        int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X005);
        setPadding(dimens, 0, dimens, 0);
        TopCardItemViewBinding b = TopCardItemViewBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b, "inflate(LayoutInflater.from(context), this)");
        this.a = b;
        c();
        f();
    }

    public /* synthetic */ TopCardItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setTitleBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            if (z) {
                EMManager.from(this.a.i).setTextStyle(R.string.F_X02);
            } else {
                EMManager.from(this.a.i).setTextStyle(R.string.F_X01);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (!z) {
                this.a.h.setVisibility(8);
            } else if (this.g) {
                this.a.h.setVisibility(8);
            } else {
                this.a.h.setVisibility(0);
            }
        }
    }

    public final void setCompleteThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    public final void setSplitViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.a.f.setVisibility(0);
            } else {
                this.a.f.setVisibility(8);
            }
        }
    }

    public final void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.h = str;
        }
    }

    public static final void d(TopCardItemView this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e87 e87Var = this$0.e;
            if (e87Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                e87Var = null;
            }
            y77 h = e87Var.h();
            vm7.b((h == null || (r5 = Long.valueOf(h.d).toString()) == null) ? "" : "", this$0.g, this$0.i, 3);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c.setTagConfig(BdUtilHelper.getDimens(getContext(), R.dimen.T_X09), BdUtilHelper.getDimens(getContext(), R.dimen.tbds39), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), R.color.CAM_X0109);
            this.a.b.setUseDynamicLikeRes();
            this.a.b.getImgAgree().setImageAssetsFolder("images");
            this.a.b.getImgAgree().setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
            this.a.b.getImgAgree().setAlpha(1.0f);
            this.a.b.setAgreeAlone(true);
            this.a.b.getAgreeNumView().setMaxLines(1);
            this.a.b.getAgreeNumView().setEllipsize(TextUtils.TruncateAt.END);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds124);
            this.a.b.v(dimens, dimens, 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds_30));
            this.a.b.setIsAgreeNumClick(true);
            this.a.b.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ko7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TopCardItemView.d(TopCardItemView.this, view2);
                    }
                }
            });
            this.a.e.setMaxLines(1);
            this.a.e.setEllipsize(TextUtils.TruncateAt.END);
            this.a.l.setOnClickListener(this);
            setOnClickListener(this);
            this.a.e.setOnClickListener(this);
            this.a.d.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.gb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int f = uua.f(this.f);
            this.j.invalidate();
            this.a.h.setTextColor(f);
            EMManager.from(this.a.h).setTextSize(R.dimen.T_X10).setCorner(R.string.J_X04).setBackGroundRealColor(uua.a(f, u25.b(R.string.A_X11)));
            EMManager.from(this.a.i).setTextSize(R.dimen.T_X06);
            if (this.g) {
                EMManager.from(this.a.i).setTextColor(R.color.CAM_X0109);
                EMManager.from(this.j).setTextColor(R.color.CAM_X0109);
            } else {
                EMManager.from(this.a.i).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.j).setTextColor(R.color.CAM_X0107);
            }
            WebPManager.setPureDrawable(this.a.d, R.drawable.icon_pure_card_comment18, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            this.a.b.P(TbadkApplication.getInst().getSkinType());
            EMManager.from(this.a.e).setTextColor(R.color.CAM_X0107);
            this.a.c.f();
            EMManager.from(this.a.f).setBackGroundColor(R.color.CAM_X0203);
            this.k.f();
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final CardPicAndTextView getCardPicAndTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (CardPicAndTextView) invokeV.objValue;
    }

    public final EMTextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            setTitleBold(z);
            if (!z) {
                this.a.g.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.f.setVisibility(8);
                int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds18);
                ViewGroup.LayoutParams layoutParams = this.a.j.getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = dimens;
                    layoutParams2.bottomMargin = dimens;
                    this.a.j.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            } else {
                this.a.g.setVisibility(0);
                this.a.k.setVisibility(0);
                this.a.f.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = this.a.j.getLayoutParams();
                if (layoutParams3 != null) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                    layoutParams4.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004);
                    this.a.j.setLayoutParams(layoutParams4);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            }
            requestLayout();
        }
    }

    public final void h(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.g = true;
            this.i = z;
            g(z);
            if (this.g) {
                EMManager.from(this.a.i).setTextColor(R.color.CAM_X0109);
                EMManager.from(this.j).setTextColor(R.color.CAM_X0109);
            } else {
                EMManager.from(this.a.i).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.j).setTextColor(R.color.CAM_X0107);
            }
            i(z2);
            requestLayout();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean areEqual;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            int i = 1;
            e87 e87Var = null;
            if (Intrinsics.areEqual(view2, this.a.l)) {
                Context context = getContext();
                e87 e87Var2 = this.e;
                if (e87Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                    e87Var2 = null;
                }
                v57 d = e87Var2.d();
                if (d != null) {
                    str2 = d.f();
                } else {
                    str2 = null;
                }
                ua7.c(context, str2);
                i = 2;
            } else {
                if (Intrinsics.areEqual(view2, this.a.d)) {
                    areEqual = true;
                } else {
                    areEqual = Intrinsics.areEqual(view2, this.a.e);
                }
                if (areEqual) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
                    e87 e87Var3 = this.e;
                    if (e87Var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                        e87Var3 = null;
                    }
                    y77 h = e87Var3.h();
                    if (h != null) {
                        str = h.c;
                    } else {
                        str = null;
                    }
                    pbActivityConfig.createNormalCfg(str, null, null);
                    pbActivityConfig.setIsTopThread(true);
                    pbActivityConfig.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    i = 4;
                } else {
                    Context context2 = getContext();
                    e87 e87Var4 = this.e;
                    if (e87Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                        e87Var4 = null;
                    }
                    ua7.c(context2, e87Var4.g());
                }
            }
            e87 e87Var5 = this.e;
            if (e87Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topCardData");
            } else {
                e87Var = e87Var5;
            }
            y77 h2 = e87Var.h();
            vm7.b((h2 == null || (r6 = Long.valueOf(h2.d).toString()) == null) ? "" : "", this.g, this.i, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setData(e87 data, boolean z, String themeColorInfo, boolean z2) {
        String str;
        long j;
        long j2;
        boolean z3;
        String str2;
        Long l;
        boolean z4;
        e87 e87Var;
        y77 h;
        String l2;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{data, Boolean.valueOf(z), themeColorInfo, Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(themeColorInfo, "themeColorInfo");
            this.f = themeColorInfo;
            this.i = z;
            g(z);
            this.e = data;
            y77 h2 = data.h();
            e87 e87Var2 = null;
            if (h2 != null) {
                str = h2.c;
            } else {
                str = null;
            }
            this.h = str.toString();
            this.g = data.c();
            i(z2);
            boolean z7 = true;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.a.i, data.i(), 1, getWidth());
            y77 h3 = data.h();
            long j3 = 0;
            if (h3 != null) {
                j = h3.b;
            } else {
                j = 0;
            }
            if (j <= 0) {
                this.a.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f127c));
            } else {
                y77 h4 = data.h();
                if (h4 != null) {
                    j2 = h4.b;
                } else {
                    j2 = 0;
                }
                this.a.e.setText(StringHelper.numFormatOverWan(j2));
            }
            v57 d = data.d();
            if (d != null) {
                HeadImageView headImageView = this.a.l;
                headImageView.j(d.c());
                if (d.b() == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                headImageView.m(z6);
                headImageView.i(d.a());
                headImageView.setCornerViewSize(BdUtilHelper.getDimens(headImageView.getContext(), R.dimen.tbds28));
            }
            AgreeData agreeData = new AgreeData();
            y77 h5 = data.h();
            if (h5 != null) {
                j3 = h5.g;
            }
            agreeData.agreeNum = j3;
            y77 h6 = data.h();
            if (h6 != null) {
                z3 = h6.f;
            } else {
                z3 = false;
            }
            agreeData.hasAgree = z3;
            y77 h7 = data.h();
            if (h7 != null) {
                str2 = h7.c;
            } else {
                str2 = null;
            }
            agreeData.threadId = str2;
            agreeData.agreeType = 2;
            agreeData.isInThread = true;
            y77 h8 = data.h();
            String str3 = "";
            if (h8 == null) {
                l = "";
            } else {
                l = Long.valueOf(h8.d);
            }
            agreeData.forumId = l.toString();
            this.a.b.setData(agreeData);
            this.a.c.j(data.e());
            this.a.c.setOnTagClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004);
            this.a.g.removeAllViews();
            if (data.f().isEmpty()) {
                String spannableStringBuilder = data.a().toString();
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "data.abstractBuilder.toString()");
                if (spannableStringBuilder.length() > 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    EMManager.from(this.j).setTextSize(R.dimen.T_X12);
                    if (data.c()) {
                        EMManager.from(this.j).setTextColor(R.color.CAM_X0109);
                    } else {
                        EMManager.from(this.j).setTextColor(R.color.CAM_X0107);
                    }
                    ThreadCardUtils.cutAndSetTextByMaxLineForDotNew(this.j, data.a(), 2, this.d);
                    this.j.setLineSpacing(getResources().getDimensionPixelSize(R.dimen.M_T_X001), 1.0f);
                    this.j.setPadding(0, 0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds3));
                    this.a.g.addView(this.j, layoutParams);
                    e87Var = this.e;
                    if (e87Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topCardData");
                    } else {
                        e87Var2 = e87Var;
                    }
                    h = e87Var2.h();
                    if (h != null && (l2 = Long.valueOf(h.d).toString()) != null) {
                        str3 = l2;
                    }
                    vm7.c(str3, this.g, this.i);
                    f();
                }
            }
            if (!data.f().isEmpty()) {
                String spannableStringBuilder2 = data.a().toString();
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "data.abstractBuilder.toString()");
                if (spannableStringBuilder2.length() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    this.k.setData(data.a(), data.f(), data.c());
                    this.a.g.addView(this.k, layoutParams);
                    e87Var = this.e;
                    if (e87Var == null) {
                    }
                    h = e87Var2.h();
                    if (h != null) {
                        str3 = l2;
                    }
                    vm7.c(str3, this.g, this.i);
                    f();
                }
            }
            if (!data.f().isEmpty()) {
                String spannableStringBuilder3 = data.a().toString();
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "data.abstractBuilder.toString()");
                if (spannableStringBuilder3.length() != 0) {
                    z7 = false;
                }
                if (z7) {
                    CardMutiImageView cardMutiImageView = new CardMutiImageView(getContext(), null, 0, 6, null);
                    cardMutiImageView.setData(data.f());
                    this.a.g.addView(cardMutiImageView, layoutParams);
                }
            }
            e87Var = this.e;
            if (e87Var == null) {
            }
            h = e87Var2.h();
            if (h != null) {
            }
            vm7.c(str3, this.g, this.i);
            f();
        }
    }

    public final void setViewStyle(String itemStyle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, itemStyle, z) == null) {
            Intrinsics.checkNotNullParameter(itemStyle, "itemStyle");
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.a.j.getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = 0;
                    layoutParams2.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds76);
                    if (!this.i) {
                        layoutParams2.bottomMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X005);
                    } else {
                        layoutParams2.bottomMargin = 0;
                    }
                    this.a.j.setLayoutParams(layoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            } else if (Intrinsics.areEqual(itemStyle, "top_card_view_style_first")) {
                this.a.f.setVisibility(8);
                ViewGroup.LayoutParams layoutParams3 = this.a.j.getLayoutParams();
                if (layoutParams3 != null) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                    layoutParams4.topMargin = 0;
                    layoutParams4.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds76);
                    this.a.j.setLayoutParams(layoutParams4);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            } else if (Intrinsics.areEqual(itemStyle, "top_card_view_style_last")) {
                ViewGroup.LayoutParams layoutParams5 = this.a.j.getLayoutParams();
                if (layoutParams5 != null) {
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                    if (!this.i) {
                        layoutParams6.bottomMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X005);
                    } else {
                        layoutParams6.bottomMargin = 0;
                    }
                    this.a.j.setLayoutParams(layoutParams6);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        }
    }
}
