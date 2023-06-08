package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
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
public final class d77 implements z67, g77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public j77 b;

    /* loaded from: classes5.dex */
    public static final class a extends og<gn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DrawableSpan a;
        public final /* synthetic */ d77 b;

        public a(DrawableSpan drawableSpan, d77 d77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawableSpan, d77Var};
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
            this.b = d77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        public void onLoaded(gn gnVar, String key, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, gnVar, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (gnVar != null) {
                    TbImageMemoryCache.u().m(key, new gn(gnVar.p()));
                    this.a.d(new BitmapDrawable(gnVar.p()));
                    j77 j77Var = this.b.b;
                    if (j77Var != null) {
                        j77Var.onUpdate();
                    }
                }
            }
        }
    }

    public d77() {
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

    @Override // com.baidu.tieba.g77
    public void a(j77 j77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j77Var) == null) {
            this.b = j77Var;
        }
    }

    @Override // com.baidu.tieba.z67
    public SpannableString b(Context context, a67 richTextData, ClickableSpan clickableSpan) {
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

    public final ReplacementSpan d(a67 a67Var) {
        InterceptResult invokeL;
        DrawableSpan.IconType iconType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a67Var)) == null) {
            String b = r97.a.b(a67Var.c());
            t57 a2 = r97.a.a(b);
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
            gn D = TbImageMemoryCache.u().D(b);
            if (D != null) {
                return new DrawableSpan(new BitmapDrawable(D.p()));
            }
            DrawableSpan drawableSpan2 = new DrawableSpan(null);
            pg.h().m(b, 10, new a(drawableSpan2, this), null);
            return drawableSpan2;
        }
        return (ReplacementSpan) invokeL.objValue;
    }
}
