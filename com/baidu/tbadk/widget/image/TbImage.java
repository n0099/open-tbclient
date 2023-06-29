package com.baidu.tbadk.widget.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.k06;
import com.baidu.tieba.v6a;
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
import com.facebook.fresco.animation.drawable.AnimationListener;
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
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u001c\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010.\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001fJ\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\b\b\u0001\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020$J\u0006\u00107\u001a\u00020$J\u0010\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010:J\u001c\u0010;\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010!J\u0016\u0010A\u001a\u00020$2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#J\u0010\u0010B\u001a\u00020$2\b\u0010C\u001a\u0004\u0018\u00010\u000fJ&\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u0002042\u0006\u0010H\u001a\u000204J\u0010\u0010I\u001a\u00020$2\b\b\u0001\u0010J\u001a\u00020\bJ\u000e\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020$J\u0006\u0010O\u001a\u00020$J\u0012\u0010P\u001a\u00020$2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(¨\u0006S"}, d2 = {"Lcom/baidu/tbadk/widget/image/TbImage;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/baidu/tbadk/widget/image/ITbImage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animatedDrawable2", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "controlAnimatable", "Landroid/graphics/drawable/Animatable;", "curFrame", "Landroid/graphics/drawable/Drawable;", "draweeControllerBuilder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "getDraweeControllerBuilder", "()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "draweeControllerBuilder$delegate", "Lkotlin/Lazy;", "isLooping", "", "()Z", "setLooping", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/baidu/tbadk/widget/image/TbImage$listener$1", "Lcom/baidu/tbadk/widget/image/TbImage$listener$1;", "mAnimationListener", "Lcom/facebook/fresco/animation/drawable/AnimationListener;", "onResultListener", "Lcom/baidu/tbadk/widget/image/ILoadResultCallback;", "onWebpEndedListener", "Lkotlin/Function0;", "", "uriHierarchyBuilder", "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", "getUriHierarchyBuilder", "()Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", "uriHierarchyBuilder$delegate", "displayImage", "url", "", "preloadImage", "processAttrs", "setAnimatedDrawableListener", "setAnimationListener", "animationListener", "setBorder", "borderWidth", "", "borderColor", "setCircle", "setCurFrameToPLaceHolder", "setCustomColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setImageURI", "uri", "Landroid/net/Uri;", "callerContext", "", "setLoadResultListener", "setOnWebpEndedListener", "setPlaceHolderDrawable", ResourceManager.DRAWABLE, "setRadius", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "setRadiusById", "radiiStringId", "setScaleType", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "startPlay", "stopPlay", "updateViewSize", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TbImage extends SimpleDraweeView implements h06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimationListener a;
    public boolean b;
    public AnimatedDrawable2 c;
    public Function0<Unit> d;
    public g06 e;
    public Animatable f;
    public final Lazy g;
    public final Lazy h;
    public final a i;
    public Drawable j;

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

    /* loaded from: classes4.dex */
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
                g06 g06Var = this.a.e;
                if (g06Var != null) {
                    g06Var.b(str, th);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048579, this, str, imageInfo) != null) {
                return;
            }
            this.a.q(imageInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) != null) {
                return;
            }
            this.a.q(imageInfo);
            this.a.f = animatable;
            if (animatable instanceof AnimatedDrawable2) {
                this.a.c = (AnimatedDrawable2) animatable;
                this.a.n();
            }
            g06 g06Var = this.a.e;
            if (g06Var != null) {
                g06Var.a(str, imageInfo, animatable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends BaseAnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImage a;
        public final /* synthetic */ AnimatedDrawable2 b;

        public b(TbImage tbImage, AnimatedDrawable2 animatedDrawable2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImage, animatedDrawable2};
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
            this.b = animatedDrawable2;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, animatedDrawable2, i) == null) {
                super.onAnimationFrame(animatedDrawable2, i);
                this.a.j = this.b.getCurrent();
                AnimationListener animationListener = this.a.a;
                if (animationListener != null) {
                    animationListener.onAnimationFrame(animatedDrawable2, i);
                }
            }
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
            AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatedDrawable2) == null) && (animationListener = this.a.a) != null) {
                animationListener.onAnimationStart(animatedDrawable2);
            }
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatedDrawable2) == null) {
                super.onAnimationStop(animatedDrawable2);
                this.a.j = this.b.getCurrent();
                this.a.getUriHierarchyBuilder().setPlaceholderImage(this.b.getCurrent());
                Function0 function0 = this.a.d;
                if (function0 != null) {
                    function0.invoke();
                }
                AnimationListener animationListener = this.a.a;
                if (animationListener != null) {
                    animationListener.onAnimationStop(animatedDrawable2);
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
        this.b = true;
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<PipelineDraweeControllerBuilder>(this) { // from class: com.baidu.tbadk.widget.image.TbImage$draweeControllerBuilder$2
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
                    aVar = this.this$0.i;
                    newDraweeControllerBuilder.setControllerListener(aVar);
                    newDraweeControllerBuilder.setAutoPlayAnimations(true);
                    return newDraweeControllerBuilder;
                }
                return (PipelineDraweeControllerBuilder) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<GenericDraweeHierarchyBuilder>(this) { // from class: com.baidu.tbadk.widget.image.TbImage$uriHierarchyBuilder$2
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
        this.i = new a(this);
        m(attributeSet);
    }

    public /* synthetic */ TbImage(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void k(String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f = null;
            AnimatedDrawable2 animatedDrawable2 = this.c;
            if (animatedDrawable2 != null) {
                animatedDrawable2.setAnimationListener(null);
            }
            this.c = null;
            setImageURI(url);
        }
    }

    public void l(String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            k06.a.a().b(url);
        }
    }

    public final void q(ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, imageInfo) == null) && imageInfo != null) {
            setAspectRatio((imageInfo.getWidth() * 1.0f) / imageInfo.getHeight());
        }
    }

    public final void setAnimationListener(AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animationListener) == null) {
            Intrinsics.checkNotNullParameter(animationListener, "animationListener");
            this.a = animationListener;
        }
    }

    public final void setCustomColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            getUriHierarchyBuilder().setActualImageColorFilter(colorFilter);
        }
    }

    public final void setLoadResultListener(g06 g06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, g06Var) == null) {
            this.e = g06Var;
        }
    }

    public final void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b = z;
        }
    }

    public final void setOnWebpEndedListener(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, function0) == null) {
            this.d = function0;
            n();
        }
    }

    public final void setPlaceHolderDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            getUriHierarchyBuilder().setPlaceholderImage(drawable);
        }
    }

    public final void setRadiusById(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            RoundingParams roundingParams = getUriHierarchyBuilder().getRoundingParams();
            if (roundingParams == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setCornersRadii(BDImageView.h(i));
            getUriHierarchyBuilder().setRoundingParams(roundingParams);
        }
    }

    public final void setScaleType(ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            getUriHierarchyBuilder().setActualImageScaleType(scaleType);
        }
    }

    private final PipelineDraweeControllerBuilder getDraweeControllerBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Object value = this.g.getValue();
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
            return (GenericDraweeHierarchyBuilder) this.h.getValue();
        }
        return (GenericDraweeHierarchyBuilder) invokeV.objValue;
    }

    public ImageView.ScaleType[] getSScaleTypeArr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return h06.a.a(this);
        }
        return (ImageView.ScaleType[]) invokeV.objValue;
    }

    public final void n() {
        AnimatedDrawable2 animatedDrawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (animatedDrawable2 = this.c) != null) {
            animatedDrawable2.getFrameCount();
            animatedDrawable2.setAnimationListener(new b(this, animatedDrawable2));
            if (!this.b) {
                animatedDrawable2.setAnimationBackend(new i06(animatedDrawable2.getAnimationBackend(), 1));
            }
        }
    }

    public final void o() {
        Animatable animatable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (animatable = this.f) != null) {
            animatable.start();
        }
    }

    public final void p() {
        Animatable animatable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (animatable = this.f) != null) {
            animatable.stop();
        }
    }

    public final void setCircle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RoundingParams roundingParams = getUriHierarchyBuilder().getRoundingParams();
            if (roundingParams == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setRoundAsCircle(true);
            getUriHierarchyBuilder().setRoundingParams(roundingParams);
        }
    }

    public final void setCurFrameToPLaceHolder() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (drawable = this.j) != null) {
            getUriHierarchyBuilder().setPlaceholderImage(drawable);
        }
    }

    public final void m(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) && attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, v6a.TbFrescoImage);
            int resourceId = obtainStyledAttributes.getResourceId(3, 0);
            if (resourceId != 0) {
                getUriHierarchyBuilder().setPlaceholderImage(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId2 != 0) {
                getUriHierarchyBuilder().setFailureImage(resourceId2);
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
            getUriHierarchyBuilder().setRoundingParams(roundingParams);
            int i = obtainStyledAttributes.getInt(4, -1);
            if (i >= 0) {
                setScaleType(getSScaleTypeArr()[i]);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void setBorder(float f, @ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            RoundingParams roundingParams = getUriHierarchyBuilder().getRoundingParams();
            if (roundingParams == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setBorder(i, f);
            getUriHierarchyBuilder().setRoundingParams(roundingParams);
        }
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public void setImageURI(Uri uri, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, uri, obj) == null) {
            this.f = null;
            AnimatedDrawable2 animatedDrawable2 = this.c;
            if (animatedDrawable2 != null) {
                animatedDrawable2.setAnimationListener(null);
            }
            this.c = null;
            PipelineDraweeControllerBuilder draweeControllerBuilder = getDraweeControllerBuilder();
            draweeControllerBuilder.setCallerContext(obj);
            draweeControllerBuilder.setUri(uri);
            setHierarchy(getUriHierarchyBuilder().build());
            draweeControllerBuilder.setOldController(getController());
            setController(draweeControllerBuilder.build());
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            RoundingParams roundingParams = getUriHierarchyBuilder().getRoundingParams();
            if (roundingParams == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setCornersRadii(f, f2, f3, f4);
            getUriHierarchyBuilder().setRoundingParams(roundingParams);
        }
    }
}
