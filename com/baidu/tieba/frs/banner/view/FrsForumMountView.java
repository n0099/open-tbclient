package com.baidu.tieba.frs.banner.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.frs.banner.view.FrsForumMountView;
import com.baidu.tieba.frs.databinding.FrsHeaderForumMountViewBinding;
import com.baidu.tieba.iv7;
import com.baidu.tieba.mv7;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.IconUrlInfo;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rJ\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\u001a\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcom/baidu/tieba/frs/banner/view/FrsForumMountView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/frs/banner/IFrsBannerInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/frs/databinding/FrsHeaderForumMountViewBinding;", "data", "Lcom/baidu/tieba/frs/FrsBountyTaskData;", "headUrls", "", "", "mAdapter", "Lcom/baidu/tieba/view/TbImageAutoSwitch$Adapter;", "viewClickListener", "Landroid/view/View$OnClickListener;", "getViewClickListener", "()Landroid/view/View$OnClickListener;", "setViewClickListener", "(Landroid/view/View$OnClickListener;)V", "bindData", "", "bountyTaskData", "jumpBountyTaskPage", "url", "loadDayNightImg", "currentSkinType", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onPrimary", "isPrimary", "", "onResume", "setDescValueText", "withIcon", "desc", "setHeadersLayout", "showHead", "showJumpBtn", "urlList", "btnString", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsForumMountView extends FrameLayout implements iv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsHeaderForumMountViewBinding a;
    public List<String> b;
    public FrsBountyTaskData c;
    public View.OnClickListener d;
    public final TbImageAutoSwitch.b e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsForumMountView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsForumMountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.iv7
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.iv7
    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.iv7
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ FrsForumMountView b;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(Context context, FrsForumMountView frsForumMountView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, frsForumMountView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = frsForumMountView;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (view2 instanceof HeadImageView) {
                    ((HeadImageView) view2).startLoad((String) this.b.b.get(i), 12, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a);
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(FrsForumMountView.f, FrsForumMountView.f));
                headImageView.setBorderWidth(FrsForumMountView.h);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setIsRound(false);
                headImageView.setRadiusById(R.string.J_X05);
                headImageView.setConrers(15);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.b.size();
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-24115308, "Lcom/baidu/tieba/frs/banner/view/FrsForumMountView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-24115308, "Lcom/baidu/tieba/frs/banner/view/FrsForumMountView;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkApplication.getInst().getContext(), R.dimen.tbds501);
        f = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        g = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        i = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds38);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsForumMountView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = new ArrayList();
        this.e = new a(context, this);
        FrsHeaderForumMountViewBinding c = FrsHeaderForumMountViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
        this.a = c;
        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        TbImageView tbImageView = c.b;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setDrawCorner(true);
        tbImageView.setRadiusById(R.string.J_X06);
        tbImageView.setPlaceHolder(2);
        tbImageView.setConrers(15);
        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = this.a;
        if (frsHeaderForumMountViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            frsHeaderForumMountViewBinding2 = null;
        }
        GifView gifView = frsHeaderForumMountViewBinding2.f;
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        gifView.setShowStaticDrawable(false);
        gifView.setPlaceHolder(2);
        gifView.setDrawerType(1);
        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
        if (frsHeaderForumMountViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding3;
        }
        TbImageAutoSwitch tbImageAutoSwitch = frsHeaderForumMountViewBinding.e;
        int i5 = f;
        tbImageAutoSwitch.l(3, i5, i5, g);
        tbImageAutoSwitch.setAnimationDuration(500);
        tbImageAutoSwitch.setCarouselDelayPeriod(2000);
        tbImageAutoSwitch.setCarouselPeriod(2000);
        tbImageAutoSwitch.setAdapter(this.e);
    }

    public /* synthetic */ FrsForumMountView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void g(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                UrlManager.getInstance().dealOneLink(str);
            }
            View.OnClickListener onClickListener = this.d;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
    }

    public final void setViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public final View.OnClickListener getViewClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iv7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = this.a;
            if (frsHeaderForumMountViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding = null;
            }
            frsHeaderForumMountViewBinding.e.o();
        }
    }

    public static final void e(FrsForumMountView this$0, FrsBountyTaskData bountyTaskData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, this$0, bountyTaskData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(bountyTaskData, "$bountyTaskData");
            this$0.g(bountyTaskData.getJumpUrl());
        }
    }

    public static final void f(FrsForumMountView this$0, FrsBountyTaskData bountyTaskData, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, this$0, bountyTaskData, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(bountyTaskData, "$bountyTaskData");
            this$0.g(bountyTaskData.getJumpUrl());
        }
    }

    /* renamed from: setDescValueText$lambda-5  reason: not valid java name */
    public static final void m140setDescValueText$lambda5(FrsForumMountView this$0) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = this$0.a;
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = null;
            if (frsHeaderForumMountViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding = null;
            }
            Layout layout = frsHeaderForumMountViewBinding.d.getLayout();
            if (layout != null) {
                num = Integer.valueOf(layout.getEllipsisCount(0));
            } else {
                num = null;
            }
            if (num != null && num.intValue() > 0) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this$0.a;
                if (frsHeaderForumMountViewBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    frsHeaderForumMountViewBinding2 = frsHeaderForumMountViewBinding3;
                }
                frsHeaderForumMountViewBinding2.d.setVisibility(8);
                return;
            }
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this$0.a;
            if (frsHeaderForumMountViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                frsHeaderForumMountViewBinding2 = frsHeaderForumMountViewBinding4;
            }
            frsHeaderForumMountViewBinding2.d.setVisibility(0);
        }
    }

    public final void d(final FrsBountyTaskData bountyTaskData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bountyTaskData) == null) {
            Intrinsics.checkNotNullParameter(bountyTaskData, "bountyTaskData");
            this.c = bountyTaskData;
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = this.a;
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = null;
            if (frsHeaderForumMountViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding = null;
            }
            TextView textView = frsHeaderForumMountViewBinding.j;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.mountTitle");
            mv7.a(textView, bountyTaskData.getTitle());
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
            if (frsHeaderForumMountViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding3 = null;
            }
            TextView textView2 = frsHeaderForumMountViewBinding3.c;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.mountDesc");
            mv7.a(textView2, bountyTaskData.getSubTitle());
            String subTitleValue = bountyTaskData.getSubTitleValue();
            int awardType = bountyTaskData.getAwardType();
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this.a;
            if (frsHeaderForumMountViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding4 = null;
            }
            frsHeaderForumMountViewBinding4.d.setVisibility(4);
            if (awardType != 1) {
                if (awardType != 2) {
                    if (awardType != 3) {
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding5 = this.a;
                        if (frsHeaderForumMountViewBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding5 = null;
                        }
                        frsHeaderForumMountViewBinding5.d.setVisibility(8);
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding6 = this.a;
                        if (frsHeaderForumMountViewBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding6 = null;
                        }
                        frsHeaderForumMountViewBinding6.g.setVisibility(8);
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding7 = this.a;
                        if (frsHeaderForumMountViewBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding7 = null;
                        }
                        frsHeaderForumMountViewBinding7.e.setVisibility(8);
                    } else {
                        i(false, subTitleValue);
                        j(false, true, null, bountyTaskData.getBtnText());
                    }
                } else {
                    i(true, subTitleValue);
                    j(false, true, null, bountyTaskData.getBtnText());
                }
            } else {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding8 = this.a;
                if (frsHeaderForumMountViewBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    frsHeaderForumMountViewBinding8 = null;
                }
                frsHeaderForumMountViewBinding8.d.setVisibility(8);
                j(true, false, bountyTaskData.getGiftImgs(), null);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FrsForumMountView.e(FrsForumMountView.this, bountyTaskData, view2);
                    }
                }
            });
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding9 = this.a;
            if (frsHeaderForumMountViewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                frsHeaderForumMountViewBinding2 = frsHeaderForumMountViewBinding9;
            }
            frsHeaderForumMountViewBinding2.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        FrsForumMountView.f(FrsForumMountView.this, bountyTaskData, view2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.iv7
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = this.a;
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = null;
            if (frsHeaderForumMountViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding.b).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
            if (frsHeaderForumMountViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding3 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding3.j).setTextColor(R.color.CAM_X0105);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this.a;
            if (frsHeaderForumMountViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding4 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding4.c).setTextColor(R.color.CAM_X0109);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding5 = this.a;
            if (frsHeaderForumMountViewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding5 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding5.d).setTextColor(R.color.CAM_X0121);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding6 = this.a;
            if (frsHeaderForumMountViewBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding6 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding6.g).setTextColor(R.color.CAM_X0101);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding7 = this.a;
            if (frsHeaderForumMountViewBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding7 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding7.g).setCorner(R.string.J_X01).setGradientColor(new int[]{R.color.CAM_X0922, R.color.CAM_X0921}, Direction.LEFT);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding8 = this.a;
            if (frsHeaderForumMountViewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding8 = null;
            }
            EMManager.from(frsHeaderForumMountViewBinding8.h).setBackGroundColor(R.color.CAM_X0625);
            h(i2);
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding9 = this.a;
            if (frsHeaderForumMountViewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding9 = null;
            }
            if (!ListUtils.isEmpty(frsHeaderForumMountViewBinding9.e.getChildViews())) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding10 = this.a;
                if (frsHeaderForumMountViewBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    frsHeaderForumMountViewBinding2 = frsHeaderForumMountViewBinding10;
                }
                for (View view2 : frsHeaderForumMountViewBinding2.e.getChildViews()) {
                    if (view2 instanceof HeadImageView) {
                        ((HeadImageView) view2).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                    }
                }
            }
        }
    }

    public final void h(int i2) {
        FrsBountyTaskData frsBountyTaskData;
        IconUrlInfo iconUrlInfo;
        IconUrlInfo iconUrlInfo2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i2) != null) || (frsBountyTaskData = this.c) == null) {
            return;
        }
        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = null;
        if (frsBountyTaskData != null) {
            iconUrlInfo = frsBountyTaskData.getIcon();
        } else {
            iconUrlInfo = null;
        }
        FrsBountyTaskData frsBountyTaskData2 = this.c;
        if (frsBountyTaskData2 != null) {
            iconUrlInfo2 = frsBountyTaskData2.getContainerBg();
        } else {
            iconUrlInfo2 = null;
        }
        boolean z3 = true;
        if (i2 == 0) {
            if (iconUrlInfo != null) {
                String str = iconUrlInfo.day;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = this.a;
                    if (frsHeaderForumMountViewBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsHeaderForumMountViewBinding2 = null;
                    }
                    frsHeaderForumMountViewBinding2.f.q(iconUrlInfo.day, 38);
                }
            }
            if (iconUrlInfo2 != null) {
                String str2 = iconUrlInfo2.day;
                if (str2 != null && str2.length() != 0) {
                    z3 = false;
                }
                if (!z3) {
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
                    if (frsHeaderForumMountViewBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding3;
                    }
                    frsHeaderForumMountViewBinding.b.startLoad(iconUrlInfo2.day, 10, false);
                    return;
                }
                return;
            }
            return;
        }
        if (iconUrlInfo != null) {
            String str3 = iconUrlInfo.dark;
            if (str3 != null && str3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this.a;
                if (frsHeaderForumMountViewBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    frsHeaderForumMountViewBinding4 = null;
                }
                frsHeaderForumMountViewBinding4.f.q(iconUrlInfo.dark, 38);
            }
        }
        if (iconUrlInfo2 != null) {
            String str4 = iconUrlInfo2.dark;
            if (str4 != null && str4.length() != 0) {
                z3 = false;
            }
            if (!z3) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding5 = this.a;
                if (frsHeaderForumMountViewBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding5;
                }
                frsHeaderForumMountViewBinding.b.startLoad(iconUrlInfo2.dark, 10, false);
            }
        }
    }

    public final void i(boolean z, String str) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) {
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = null;
            if (z2) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = this.a;
                if (frsHeaderForumMountViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding2;
                }
                frsHeaderForumMountViewBinding.d.setVisibility(8);
                return;
            }
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
            if (frsHeaderForumMountViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                frsHeaderForumMountViewBinding3 = null;
            }
            frsHeaderForumMountViewBinding3.d.setText(str);
            if (z) {
                try {
                    Drawable drawable = getResources().getDrawable(R.drawable.obfuscated_res_0x7f0806e3);
                    if (drawable == null) {
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this.a;
                        if (frsHeaderForumMountViewBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding4 = null;
                        }
                        frsHeaderForumMountViewBinding4.d.setCompoundDrawables(null, null, null, null);
                    } else {
                        drawable.setBounds(0, 0, i, i);
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding5 = this.a;
                        if (frsHeaderForumMountViewBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding5 = null;
                        }
                        frsHeaderForumMountViewBinding5.d.setCompoundDrawablePadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X001));
                        FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding6 = this.a;
                        if (frsHeaderForumMountViewBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            frsHeaderForumMountViewBinding6 = null;
                        }
                        frsHeaderForumMountViewBinding6.d.setCompoundDrawables(drawable, null, null, null);
                    }
                } catch (Resources.NotFoundException unused) {
                    if (TbadkApplication.getInst().isDebugMode()) {
                        throw new Resources.NotFoundException();
                    }
                }
            } else {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding7 = this.a;
                if (frsHeaderForumMountViewBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    frsHeaderForumMountViewBinding7 = null;
                }
                frsHeaderForumMountViewBinding7.d.setCompoundDrawables(null, null, null, null);
            }
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding8 = this.a;
            if (frsHeaderForumMountViewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding8;
            }
            frsHeaderForumMountViewBinding.d.post(new Runnable() { // from class: com.baidu.tieba.jv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FrsForumMountView.m140setDescValueText$lambda5(FrsForumMountView.this);
                    }
                }
            });
        }
    }

    public final void j(boolean z, boolean z2, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), list, str}) == null) {
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding = null;
            if (z) {
                if (list != null && !list.isEmpty()) {
                    this.b.clear();
                    this.b.addAll(list);
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding2 = this.a;
                    if (frsHeaderForumMountViewBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsHeaderForumMountViewBinding2 = null;
                    }
                    frsHeaderForumMountViewBinding2.e.setVisibility(0);
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding3 = this.a;
                    if (frsHeaderForumMountViewBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsHeaderForumMountViewBinding3 = null;
                    }
                    frsHeaderForumMountViewBinding3.e.q();
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding4 = this.a;
                    if (frsHeaderForumMountViewBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsHeaderForumMountViewBinding4 = null;
                    }
                    frsHeaderForumMountViewBinding4.e.setFromCarousel(true);
                } else {
                    FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding5 = this.a;
                    if (frsHeaderForumMountViewBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        frsHeaderForumMountViewBinding5 = null;
                    }
                    frsHeaderForumMountViewBinding5.e.setVisibility(8);
                }
            } else {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding6 = this.a;
                if (frsHeaderForumMountViewBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    frsHeaderForumMountViewBinding6 = null;
                }
                frsHeaderForumMountViewBinding6.e.setVisibility(8);
            }
            if (z2) {
                FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding7 = this.a;
                if (frsHeaderForumMountViewBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding7;
                }
                TextView textView = frsHeaderForumMountViewBinding.g;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.mountJumpBtn");
                mv7.a(textView, str);
                return;
            }
            FrsHeaderForumMountViewBinding frsHeaderForumMountViewBinding8 = this.a;
            if (frsHeaderForumMountViewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                frsHeaderForumMountViewBinding = frsHeaderForumMountViewBinding8;
            }
            frsHeaderForumMountViewBinding.g.setVisibility(8);
        }
    }
}
