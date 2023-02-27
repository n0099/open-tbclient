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
import com.baidu.tieba.d89;
import com.baidu.tieba.xs5;
import com.baidu.tieba.zs5;
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
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\r\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%J&\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0018J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00061"}, d2 = {"Lcom/baidu/tbadk/widget/image/TbImage;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/baidu/tbadk/widget/image/ITbImage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hierarchyBuilder", "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/baidu/tbadk/widget/image/TbImage$listener$1", "Lcom/baidu/tbadk/widget/image/TbImage$listener$1;", "checkOptionNonNull", "", "displayImage", "url", "", "preloadImage", "processAttrs", "setBorder", "borderWidth", "", "borderColor", "setCircle", "setCustomColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setImageURI", "uri", "Landroid/net/Uri;", "callerContext", "", "setPlaceHolderDrawable", ResourceManager.DRAWABLE, "Landroid/graphics/drawable/Drawable;", "setRadius", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "setScaleType", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "updateViewSize", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TbImage extends SimpleDraweeView implements xs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GenericDraweeHierarchyBuilder a;
    public final a b;

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
            this.a.e(imageInfo);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) == null) {
                this.a.e(imageInfo);
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
        this.b = new a(this);
        d(attributeSet);
    }

    public /* synthetic */ TbImage(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a == null) {
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            genericDraweeHierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            genericDraweeHierarchyBuilder.setFadeDuration(0);
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    public ImageView.ScaleType[] getSScaleTypeArr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return xs5.a.a(this);
        }
        return (ImageView.ScaleType[]) invokeV.objValue;
    }

    public final void setCircle() {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setRoundAsCircle(true);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.a;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    public void c(String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(url)) {
                setController(null);
                return;
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.a;
            if (genericDraweeHierarchyBuilder != null) {
                Intrinsics.checkNotNull(genericDraweeHierarchyBuilder);
                setHierarchy(genericDraweeHierarchyBuilder.build());
                setImageURI(url);
                return;
            }
            zs5.a.a().a(url, this);
        }
    }

    public final void d(AttributeSet attributeSet) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet) == null) && attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d89.TbFrescoImage);
            int resourceId = obtainStyledAttributes.getResourceId(3, 0);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = null;
            if (resourceId != 0) {
                b();
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder4 = this.a;
                if (genericDraweeHierarchyBuilder4 != null) {
                    genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder4.setPlaceholderImage(resourceId);
                } else {
                    genericDraweeHierarchyBuilder2 = null;
                }
                this.a = genericDraweeHierarchyBuilder2;
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId2 != 0) {
                b();
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder5 = this.a;
                if (genericDraweeHierarchyBuilder5 != null) {
                    genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder5.setFailureImage(resourceId2);
                } else {
                    genericDraweeHierarchyBuilder = null;
                }
                this.a = genericDraweeHierarchyBuilder;
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
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder6 = this.a;
            if (genericDraweeHierarchyBuilder6 != null) {
                genericDraweeHierarchyBuilder3 = genericDraweeHierarchyBuilder6.setRoundingParams(roundingParams);
            }
            this.a = genericDraweeHierarchyBuilder3;
            int i = obtainStyledAttributes.getInt(4, -1);
            if (i >= 0) {
                setScaleType(getSScaleTypeArr()[i]);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void e(ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, imageInfo) == null) && imageInfo != null) {
            setAspectRatio((imageInfo.getWidth() * 1.0f) / imageInfo.getHeight());
        }
    }

    public final void setCustomColorFilter(ColorFilter colorFilter) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, colorFilter) == null) {
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setActualImageColorFilter(colorFilter);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    public final void setPlaceHolderDrawable(Drawable drawable) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setPlaceholderImage(drawable);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    public final void setScaleType(ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder2.setActualImageScaleType(scaleType);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    public final void setBorder(float f, @ColorInt int i) {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setBorder(i, f);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.a;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView
    public void setImageURI(Uri uri, Object obj) {
        PipelineDraweeControllerBuilder newDraweeControllerBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, obj) == null) && (newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder()) != null) {
            newDraweeControllerBuilder.setControllerListener(this.b);
            newDraweeControllerBuilder.setAutoPlayAnimations(true);
            newDraweeControllerBuilder.setCallerContext(obj);
            newDraweeControllerBuilder.setUri(uri);
            newDraweeControllerBuilder.setOldController(getController());
            setController(newDraweeControllerBuilder.build());
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        RoundingParams roundingParams;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            b();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = this.a;
            if (genericDraweeHierarchyBuilder2 == null || (roundingParams = genericDraweeHierarchyBuilder2.getRoundingParams()) == null) {
                roundingParams = new RoundingParams();
            }
            roundingParams.setCornersRadii(f, f2, f3, f4);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = this.a;
            if (genericDraweeHierarchyBuilder3 != null) {
                genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder3.setRoundingParams(roundingParams);
            } else {
                genericDraweeHierarchyBuilder = null;
            }
            this.a = genericDraweeHierarchyBuilder;
        }
    }
}
