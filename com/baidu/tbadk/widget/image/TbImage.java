package com.baidu.tbadk.widget.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.ao9;
import com.baidu.tieba.jt5;
import com.baidu.tieba.lt5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u001c\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u00020 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010+\u001a\u00020 H\u0002J\u0018\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.2\b\b\u0001\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020 J\u0010\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u000103J\u001c\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0016\u00109\u001a\u00020 2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u0010\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010<J&\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020.J\u000e\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020 J\u0006\u0010F\u001a\u00020 J\u0012\u0010G\u001a\u00020 2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b\"\u0010#¨\u0006J"}, d2 = {"Lcom/baidu/tbadk/widget/image/TbImage;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/baidu/tbadk/widget/image/ITbImage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animatedDrawable2", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "controlAnimatable", "Landroid/graphics/drawable/Animatable;", "draweeControllerBuilder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "getDraweeControllerBuilder", "()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "draweeControllerBuilder$delegate", "Lkotlin/Lazy;", "hierarchyBuilder", "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", "isLooping", "", "()Z", "setLooping", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/baidu/tbadk/widget/image/TbImage$listener$1", "Lcom/baidu/tbadk/widget/image/TbImage$listener$1;", "onWebpEndedListener", "Lkotlin/Function0;", "", "uriHierarchyBuilder", "getUriHierarchyBuilder", "()Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", "uriHierarchyBuilder$delegate", "checkOptionNonNull", "displayImage", "url", "", "preloadImage", "processAttrs", "setAnimatedDrawableListener", "setBorder", "borderWidth", "", "borderColor", "setCircle", "setCustomColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setImageURI", "uri", "Landroid/net/Uri;", "callerContext", "", "setOnWebpEndedListener", "setPlaceHolderDrawable", ResourceManager.DRAWABLE, "Landroid/graphics/drawable/Drawable;", "setRadius", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "setScaleType", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "startPlay", "stopPlay", "updateViewSize", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TbImage extends SimpleDraweeView implements jt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public AnimatedDrawable2 b;
    public Function0<Unit> c;
    public Animatable d;
    public final Lazy e;
    public final Lazy f;
    public GenericDraweeHierarchyBuilder g;
    public final a h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbImage(Context context) {
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
    public TbImage(Context context, AttributeSet attributeSet) {
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

    /* loaded from: classes3.dex */
    public static final class a extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImage a;

        public a(TbImage tbImage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImage;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048579, this, str, imageInfo) != null) {
                return;
            }
            this.a.n(imageInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) != null) {
                return;
            }
            this.a.n(imageInfo);
            this.a.d = animatable;
            if (animatable instanceof AnimatedDrawable2) {
                this.a.b = (AnimatedDrawable2) animatable;
                this.a.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends BaseAnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImage a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AnimatedDrawable2 c;

        public b(TbImage tbImage, int i, AnimatedDrawable2 animatedDrawable2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImage, Integer.valueOf(i), animatedDrawable2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImage;
            this.b = i;
            this.c = animatedDrawable2;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, animatedDrawable2, i) == null) {
                super.onAnimationFrame(animatedDrawable2, i);
                if (!this.a.j() && i == this.b - 1) {
                    this.c.stop();
                    this.a.getUriHierarchyBuilder().setPlaceholderImage(this.c.getCurrent());
                    Function0 function0 = this.a.c;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbImage(Context context, AttributeSet attributeSet, int i) {
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
        this.a = true;
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<PipelineDraweeControllerBuilder>(this) { // from class: com.baidu.tbadk.widget.image.TbImage$draweeControllerBuilder$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbImage this$0;

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
            public final PipelineDraweeControllerBuilder invoke() {
                InterceptResult invokeV;
                TbImage.a aVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
                    aVar = this.this$0.h;
                    newDraweeControllerBuilder.setControllerListener(aVar);
                    newDraweeControllerBuilder.setAutoPlayAnimations(true);
                    return newDraweeControllerBuilder;
                }
                return (PipelineDraweeControllerBuilder) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<GenericDraweeHierarchyBuilder>(this) { // from class: com.baidu.tbadk.widget.image.TbImage$uriHierarchyBuilder$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbImage this$0;

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
            public final GenericDraweeHierarchyBuilder invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(this.this$0.getResources());
                    genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                    genericDraweeHierarchyBuilder.setFadeDuration(0);
                    return genericDraweeHierarchyBuilder;
                }
                return (GenericDraweeHierarchyBuilder) invokeV.objValue;
            }
        });
        this.h = new a(this);
        k(attributeSet);
    }

    public /* synthetic */ TbImage(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void n(ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, imageInfo) == null) && imageInfo != null) {
            setAspectRatio((imageInfo.getWidth() * 1.0f) / imageInfo.getHeight());
        }
    }

    public final void setCustomColorFilter(ColorFilter colorFilter) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, colorFilter) == null) {
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setActualImageColorFilter(colorFilter);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
        }
    }

    public final void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.a = z;
        }
    }

    public final void setOnWebpEndedListener(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, function0) == null) {
            this.c = function0;
            l();
        }
    }

    public final void setPlaceHolderDrawable(Drawable drawable) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setPlaceholderImage(drawable);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
        }
    }

    public final void setScaleType(ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setActualImageScaleType(scaleType);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
            getUriHierarchyBuilder().setActualImageScaleType(scaleType);
        }
    }

    private final PipelineDraweeControllerBuilder getDraweeControllerBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-draweeControllerBuilder>(...)");
            return (PipelineDraweeControllerBuilder) value;
        }
        return (PipelineDraweeControllerBuilder) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GenericDraweeHierarchyBuilder getUriHierarchyBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return (GenericDraweeHierarchyBuilder) this.f.getValue();
        }
        return (GenericDraweeHierarchyBuilder) invokeV.objValue;
    }

    public ImageView.ScaleType[] getSScaleTypeArr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return jt5.a.a(this);
        }
        return (ImageView.ScaleType[]) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.g == null) {
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            genericDraweeHierarchyBuilder.setFadeDuration(0);
            this.g = genericDraweeHierarchyBuilder;
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        AnimatedDrawable2 animatedDrawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (animatedDrawable2 = this.b) != null) {
            animatedDrawable2.setAnimationListener(new b(this, animatedDrawable2.getFrameCount(), animatedDrawable2));
        }
    }

    public final void m() {
        Animatable animatable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (animatable = this.d) != null) {
            animatable.stop();
        }
    }

    public final void setCircle() {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setRoundAsCircle(true);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.g;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
        }
    }

    public void i(String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.d = null;
            this.b = null;
            if (TextUtils.isEmpty(url)) {
                setController(null);
                return;
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.g;
            if (genericDraweeHierarchyBuilder != null) {
                Intrinsics.checkNotNull(genericDraweeHierarchyBuilder);
                setHierarchy(genericDraweeHierarchyBuilder.build());
                setImageURI(url);
                return;
            }
            lt5.a.a().a(url, this);
        }
    }

    public final void k(AttributeSet attributeSet) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) && attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, ao9.TbFrescoImage);
            int resourceId = obtainStyledAttributes.getResourceId(3, 0);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = null;
            if (resourceId != 0) {
                h();
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder4 = this.g;
                if (genericDraweeHierarchyBuilder4 != null) {
                    genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder4.setPlaceholderImage(resourceId);
                } else {
                    genericDraweeHierarchyBuilder2 = null;
                }
                this.g = genericDraweeHierarchyBuilder2;
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId2 != 0) {
                h();
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder5 = this.g;
                if (genericDraweeHierarchyBuilder5 != null) {
                    genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder5.setFailureImage(resourceId2);
                } else {
                    genericDraweeHierarchyBuilder = null;
                }
                this.g = genericDraweeHierarchyBuilder;
            }
            RoundingParams roundingParams = new RoundingParams();
            if (obtainStyledAttributes.getBoolean(0, false)) {
                roundingParams.setRoundAsCircle(true);
            } else {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                if (dimensionPixelSize > 0) {
                    roundingParams.setCornersRadius(dimensionPixelSize);
                } else {
                    roundingParams.setCornersRadii(obtainStyledAttributes.getDimensionPixelSize(6, 0), obtainStyledAttributes.getDimensionPixelSize(8, 0), obtainStyledAttributes.getDimensionPixelSize(7, 0), obtainStyledAttributes.getDimensionPixelSize(5, 0));
                }
                roundingParams.setRoundAsCircle(false);
            }
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder6 = this.g;
            if (genericDraweeHierarchyBuilder6 != null) {
                genericDraweeHierarchyBuilder3 = genericDraweeHierarchyBuilder6.setRoundingParams(roundingParams);
            }
            this.g = genericDraweeHierarchyBuilder3;
            int i = obtainStyledAttributes.getInt(4, -1);
            if (i >= 0) {
                setScaleType(getSScaleTypeArr()[i]);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void setBorder(float f, @ColorInt int i) {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setBorder(i, f);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.g;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
        }
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public void setImageURI(Uri uri, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, uri, obj) == null) {
            this.d = null;
            this.b = null;
            PipelineDraweeControllerBuilder draweeControllerBuilder = getDraweeControllerBuilder();
            draweeControllerBuilder.setCallerContext(obj);
            draweeControllerBuilder.setUri(uri);
            setHierarchy(getUriHierarchyBuilder().build());
            getUriHierarchyBuilder().setPlaceholderImage((Drawable) null);
            draweeControllerBuilder.setOldController(getController());
            setController(draweeControllerBuilder.build());
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            h();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.g;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setCornersRadii(f, f2, f3, f4);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.g;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.g = genericDraweeHierarchyBuilder;
        }
    }
}
