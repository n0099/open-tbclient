package com.baidu.tieba.im.biz.aibot.backgroundslice;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "bgView", "Landroid/view/View;", "(Landroid/view/View;)V", TaskUIData.keyBgUrl, "", "getBgView", "()Landroid/view/View;", "loadPicUrl", "", "backgroundUrl", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "tryReloadPicUrl", "FitTopTransformation", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BackgroundSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View j;
    public String k;

    /* loaded from: classes6.dex */
    public static final class a extends BitmapTransformation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final byte[] b;

        public a() {
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
            this.a = "com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice.FitTopTransformation";
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
            byte[] bytes = "com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice.FitTopTransformation".getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            this.b = bytes;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
        public Bitmap transform(BitmapPool pool, Bitmap toTransform, int i, int i2) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, pool, toTransform, i, i2)) == null) {
                Intrinsics.checkNotNullParameter(pool, "pool");
                Intrinsics.checkNotNullParameter(toTransform, "toTransform");
                Bitmap createBitmap = Bitmap.createBitmap(toTransform, 0, 0, i, i2);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(toTransform…, 0, outWidth, outHeight)");
                return createBitmap;
            }
            return (Bitmap) invokeLLII.objValue;
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageDigest) == null) {
                Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
                messageDigest.update(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomViewTarget<View, Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundSlice a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackgroundSlice backgroundSlice, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundSlice, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, resource, transition) == null) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                this.a.Y().setBackground(resource);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
                BdLog.e("图片加载失败");
            }
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
                this.a.Y().setBackground(null);
            }
        }
    }

    public BackgroundSlice(View bgView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bgView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bgView, "bgView");
        this.j = bgView;
    }

    public static final void a0(BackgroundSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void O(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.O(newConfig);
            this.j.postDelayed(new Runnable() { // from class: com.baidu.tieba.ub8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BackgroundSlice.a0(BackgroundSlice.this);
                    }
                }
            }, 25L);
        }
    }

    public final View Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public final void b0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String str = this.k;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String str2 = this.k;
                Intrinsics.checkNotNull(str2);
                this.k = null;
                Z(str2);
            }
        }
    }

    public final void Z(String backgroundUrl) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, backgroundUrl) == null) {
            Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
            if (backgroundUrl.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || this.k != null) {
                return;
            }
            this.k = backgroundUrl;
            RequestBuilder<Drawable> load = Glide.with(F()).load(backgroundUrl);
            Intrinsics.checkNotNullExpressionValue(load, "with(this.host).load(backgroundUrl)");
            if (UtilHelper.isFoldScreen() || UtilHelper.isLargeScreen(TbadkCoreApplication.getInst())) {
                Cloneable transform = load.transform(new a());
                Intrinsics.checkNotNullExpressionValue(transform, "builder.transform(FitTopTransformation())");
                load = (RequestBuilder) transform;
            }
            load.into((RequestBuilder<Drawable>) new b(this, this.j));
        }
    }
}
