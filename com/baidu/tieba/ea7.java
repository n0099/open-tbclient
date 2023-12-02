package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.feed.data.richtext.DrawableSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ea7 implements aa7, ha7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public la7 b;

    /* loaded from: classes5.dex */
    public static final class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DrawableSpan a;
        public final /* synthetic */ ea7 b;

        public a(DrawableSpan drawableSpan, ea7 ea7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawableSpan, ea7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = drawableSpan;
            this.b = ea7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String key, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (bdImage != null) {
                    TbImageMemoryCache.w().m(key, new BdImage(bdImage.getRawBitmap()));
                    this.a.i(new BitmapDrawable(bdImage.getRawBitmap()));
                    la7 la7Var = this.b.b;
                    if (la7Var != null) {
                        la7Var.onUpdate();
                    }
                }
            }
        }
    }

    public ea7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "m";
    }

    @Override // com.baidu.tieba.ha7
    public void a(la7 la7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, la7Var) == null) {
            this.b = la7Var;
        }
    }

    @Override // com.baidu.tieba.aa7
    public SpannableString b(Context context, b87 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            SpannableString spannableString = new SpannableString(this.a);
            spannableString.setSpan(d(richTextData), 0, this.a.length(), 33);
            spannableString.setSpan(clickableSpan, 0, this.a.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }

    public final ReplacementSpan d(b87 b87Var) {
        InterceptResult invokeL;
        DrawableSpan.IconType iconType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b87Var)) == null) {
            String b = kd7.a.b(b87Var.c());
            m77 a2 = kd7.a.a(b);
            if (a2 != null) {
                String h = a2.h();
                if (Intrinsics.areEqual(h, WebpUtils.TYPE_IMG_WEBP)) {
                    iconType = DrawableSpan.IconType.WEBP;
                } else if (Intrinsics.areEqual(h, "svg")) {
                    iconType = DrawableSpan.IconType.SVG;
                } else {
                    iconType = DrawableSpan.IconType.PIC;
                }
                DrawableSpan drawableSpan = new DrawableSpan(a2.c(), iconType, a2.a());
                drawableSpan.g(a2.f());
                drawableSpan.e(a2.d());
                drawableSpan.h(a2.g());
                drawableSpan.d(a2.i());
                drawableSpan.c(a2.b());
                drawableSpan.f(a2.e());
                return drawableSpan;
            }
            BdImage F = TbImageMemoryCache.w().F(b);
            if (F != null) {
                return new DrawableSpan(new BitmapDrawable(F.getRawBitmap()));
            }
            DrawableSpan drawableSpan2 = new DrawableSpan(null);
            BdResourceLoader.getInstance().loadResource(b, 10, new a(drawableSpan2, this), null);
            return drawableSpan2;
        }
        return (ReplacementSpan) invokeL.objValue;
    }
}
