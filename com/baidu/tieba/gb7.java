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
/* loaded from: classes6.dex */
public final class gb7 implements cb7, jb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public mb7 b;

    /* loaded from: classes6.dex */
    public static final class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DrawableSpan a;
        public final /* synthetic */ gb7 b;

        public a(DrawableSpan drawableSpan, gb7 gb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawableSpan, gb7Var};
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
            this.b = gb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String key, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (bdImage != null) {
                    TbImageMemoryCache.A().n(key, new BdImage(bdImage.getRawBitmap()));
                    this.a.d(new BitmapDrawable(bdImage.getRawBitmap()));
                    mb7 mb7Var = this.b.b;
                    if (mb7Var != null) {
                        mb7Var.onUpdate();
                    }
                }
            }
        }
    }

    public gb7() {
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

    @Override // com.baidu.tieba.jb7
    public void a(mb7 mb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mb7Var) == null) {
            this.b = mb7Var;
        }
    }

    @Override // com.baidu.tieba.cb7
    public SpannableString b(Context context, t97 richTextData, ClickableSpan clickableSpan) {
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

    public final ReplacementSpan d(t97 t97Var) {
        InterceptResult invokeL;
        DrawableSpan.IconType iconType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t97Var)) == null) {
            String b = ee7.a.b(t97Var.c());
            l97 a2 = ee7.a.a(b);
            if (a2 != null) {
                String type = a2.getType();
                if (Intrinsics.areEqual(type, WebpUtils.TYPE_IMG_WEBP)) {
                    iconType = DrawableSpan.IconType.WEBP;
                } else if (Intrinsics.areEqual(type, "svg")) {
                    iconType = DrawableSpan.IconType.SVG;
                } else {
                    iconType = DrawableSpan.IconType.PIC;
                }
                DrawableSpan drawableSpan = new DrawableSpan(a2.b(), iconType, a2.a());
                drawableSpan.c(a2.c());
                return drawableSpan;
            }
            BdImage F = TbImageMemoryCache.A().F(b);
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
