package com.baidu.tieba.forum.secondfloor;

import android.content.Context;
import android.net.http.Headers;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.ei7;
import com.baidu.tieba.forum.controller.LinkageController;
import com.baidu.tieba.forum.databinding.LayoutAiSecondFloorBinding;
import com.baidu.tieba.forum.secondfloor.AISecondFloorView;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.im7;
import com.baidu.tieba.jm7;
import com.baidu.tieba.li7;
import com.baidu.tieba.lm7;
import com.baidu.tieba.mi7;
import com.baidu.tieba.mm7;
import com.baidu.tieba.ni7;
import com.baidu.tieba.pm7;
import com.baidu.tieba.ri7;
import com.baidu.tieba.xm7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u001a\u0010\u001a\u001a\u00020\u00162\b\b\u0001\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0014J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/tieba/forum/secondfloor/AISecondFloorView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/forum/secondfloor/ISecondFloorView;", "Lcom/baidu/tieba/forum/data/AiSecondFloorData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/forum/databinding/LayoutAiSecondFloorBinding;", "bizDelegates", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/forum/secondfloor/ISecondFloorBiz;", "Lkotlin/collections/ArrayList;", "botContainerBottomMargin", "data", "initBotContainerTranslationY", "", "addBizDelegates", "", "delegates", "", "bindData", "changeWithRatio", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "offset", "goToAiBotPage", "onAttachedToWindow", "onChangeSkin", "onCollapseCompletely", "onDetachedFromWindow", "onShowCompletely", "isDragging", "", Headers.REFRESH, "activity", "Landroidx/fragment/app/FragmentActivity;", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AISecondFloorView extends FrameLayout implements lm7<ni7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final LayoutAiSecondFloorBinding b;
    public float c;
    public ni7 d;
    public final ArrayList<jm7<ni7>> e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AISecondFloorView(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AISecondFloorView(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AISecondFloorView(Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds45);
        LayoutAiSecondFloorBinding b = LayoutAiSecondFloorBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b, "inflate(LayoutInflater.from(context), this)");
        this.b = b;
        this.e = new ArrayList<>();
    }

    public /* synthetic */ AISecondFloorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void i(AISecondFloorView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            float f = (-this$0.b.c.getHeight()) - this$0.a;
            this$0.c = f;
            this$0.b.c.setTranslationY(f);
        }
    }

    @Override // com.baidu.tieba.lm7
    public void d(List<? extends jm7<ni7>> delegates) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, delegates) == null) {
            Intrinsics.checkNotNullParameter(delegates, "delegates");
            this.e.addAll(delegates);
        }
    }

    @Override // com.baidu.tieba.lm7
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.b.d.setAlpha((1 - f) * 0.95f);
            this.b.c.setTranslationY(f2 + this.c);
            this.b.c.setAlpha(im7.a(f));
        }
    }

    @Override // com.baidu.tieba.lm7
    public void b(FragmentActivity activity) {
        mi7 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ri7 value = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).c().getValue();
            if (value == null || (a = value.a()) == null) {
                return;
            }
            a.h(SecondFloorVisitHelper.a.b(String.valueOf(value.e())));
            ni7 i = a.i();
            if (i != null) {
                e(i);
            }
        }
    }

    @Override // com.baidu.tieba.lm7
    public void c(boolean z) {
        LinkageController linkageController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                xm7.a(3);
            }
            this.b.c.setVisibility(8);
            ViewModelStoreOwner viewModelStoreOwner = null;
            ei7 ei7Var = null;
            if (!ViewHelper.checkUpIsLogin(getContext())) {
                Context context = getContext();
                if (context instanceof ei7) {
                    ei7Var = (ei7) context;
                }
                if (ei7Var != null && (linkageController = (LinkageController) ei7Var.j2(Reflection.getOrCreateKotlinClass(LinkageController.class))) != null) {
                    linkageController.K();
                    return;
                }
                return;
            }
            Context context2 = getContext();
            if (context2 instanceof ViewModelStoreOwner) {
                viewModelStoreOwner = (ViewModelStoreOwner) context2;
            }
            if (viewModelStoreOwner != null) {
                ((ForumViewModel) new ViewModelProvider(viewModelStoreOwner).get(ForumViewModel.class)).e().postValue(Boolean.FALSE);
            }
            j();
        }
    }

    @Override // com.baidu.tieba.lm7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.f.b();
        }
    }

    @Override // com.baidu.tieba.lm7
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.c.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            Iterator<T> it = this.e.iterator();
            while (it.hasNext()) {
                ((jm7) it.next()).c();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            Iterator<T> it = this.e.iterator();
            while (it.hasNext()) {
                ((jm7) it.next()).a();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm7
    /* renamed from: h */
    public void e(ni7 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.d = data;
            this.b.c.post(new Runnable() { // from class: com.baidu.tieba.hm7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AISecondFloorView.i(AISecondFloorView.this);
                    }
                }
            });
            List<li7> b = data.b();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(b, 10));
            for (li7 li7Var : b) {
                arrayList.add(li7Var.c());
            }
            li7 e = data.e();
            String d = data.d();
            String f = data.f();
            String c = data.c();
            if (!UtilHelper.isFoldScreen() && !UtilHelper.isLargeScreen(TbadkCoreApplication.getInst())) {
                TbImage tbImage = this.b.b;
                ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
                Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
                tbImage.setScaleType(CENTER_CROP);
            } else {
                this.b.b.setScaleType(mm7.a.a());
            }
            TbImage tbImage2 = this.b.b;
            String a = e.a();
            if (a == null) {
                a = "";
            }
            tbImage2.l(a);
            TbImage tbImage3 = this.b.d;
            ScalingUtils.ScaleType CENTER_CROP2 = ScalingUtils.ScaleType.CENTER_CROP;
            Intrinsics.checkNotNullExpressionValue(CENTER_CROP2, "CENTER_CROP");
            tbImage3.setScaleType(CENTER_CROP2);
            this.b.d.l(d);
            TbImage tbImage4 = this.b.e;
            ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
            tbImage4.setScaleType(FIT_XY);
            this.b.e.l(f);
            this.b.f.setTipText(c);
            this.b.f.d(CollectionsKt___CollectionsKt.take(arrayList, 2));
            this.b.f.setBackgroundGradientColor(R.color.CAM_X0302, R.color.CAM_X0341);
            Iterator<T> it = this.e.iterator();
            while (it.hasNext()) {
                ((jm7) it.next()).b(data);
            }
        }
    }

    public final void j() {
        ni7 ni7Var;
        ViewModelStoreOwner viewModelStoreOwner;
        ri7 value;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ni7Var = this.d) != null) {
            Context context = getContext();
            if (context instanceof ViewModelStoreOwner) {
                viewModelStoreOwner = (ViewModelStoreOwner) context;
            } else {
                viewModelStoreOwner = null;
            }
            if (viewModelStoreOwner != null && (value = ((ForumViewModel) new ViewModelProvider(viewModelStoreOwner).get(ForumViewModel.class)).c().getValue()) != null) {
                Intrinsics.checkNotNullExpressionValue(value, "ViewModelProvider(activi…     .value ?: return@run");
                pm7.a(getContext(), value, ni7Var);
            }
        }
    }
}
