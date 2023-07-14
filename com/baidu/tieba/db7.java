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
public final class db7 implements za7, gb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public jb7 b;

    /* loaded from: classes5.dex */
    public static final class a extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DrawableSpan a;
        public final /* synthetic */ db7 b;

        public a(DrawableSpan drawableSpan, db7 db7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawableSpan, db7Var};
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
            this.b = db7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String key, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (jnVar != null) {
                    TbImageMemoryCache.v().o(key, new jn(jnVar.p()));
                    this.a.d(new BitmapDrawable(jnVar.p()));
                    jb7 jb7Var = this.b.b;
                    if (jb7Var != null) {
                        jb7Var.onUpdate();
                    }
                }
            }
        }
    }

    public db7() {
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

    @Override // com.baidu.tieba.gb7
    public void a(jb7 jb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jb7Var) == null) {
            this.b = jb7Var;
        }
    }

    @Override // com.baidu.tieba.za7
    public SpannableString b(Context context, r97 richTextData, ClickableSpan clickableSpan) {
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

    public final ReplacementSpan d(r97 r97Var) {
        InterceptResult invokeL;
        DrawableSpan.IconType iconType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r97Var)) == null) {
            String b = ae7.a.b(r97Var.c());
            j97 a2 = ae7.a.a(b);
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
            jn E = TbImageMemoryCache.v().E(b);
            if (E != null) {
                return new DrawableSpan(new BitmapDrawable(E.p()));
            }
            DrawableSpan drawableSpan2 = new DrawableSpan(null);
            sg.h().m(b, 10, new a(drawableSpan2, this), null);
            return drawableSpan2;
        }
        return (ReplacementSpan) invokeL.objValue;
    }
}
