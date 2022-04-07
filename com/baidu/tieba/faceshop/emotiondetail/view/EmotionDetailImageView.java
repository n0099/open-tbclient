package com.baidu.tieba.faceshop.emotiondetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fo;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class EmotionDetailImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final float d;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ProgressBar b;
    public int c;

    /* loaded from: classes3.dex */
    public class a extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailData a;
        public final /* synthetic */ EmotionDetailImageView b;

        public a(EmotionDetailImageView emotionDetailImageView, EmotionDetailData emotionDetailData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailImageView, emotionDetailData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionDetailImageView;
            this.a = emotionDetailData;
        }

        @Override // com.repackage.hg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.b.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, foVar, str, i) == null) {
                this.b.b.setVisibility(8);
                if (foVar != null) {
                    this.b.a = new TbMemeImageView(this.b.getContext());
                    ((TbMemeImageView) this.b.a).g(foVar);
                    EmotionDetailImageView emotionDetailImageView = this.b;
                    ImageView imageView = emotionDetailImageView.a;
                    EmotionDetailData.PicInfo picInfo = this.a.pic_info;
                    emotionDetailImageView.g(imageView, picInfo.width, picInfo.height, 200, 200);
                    EmotionDetailImageView emotionDetailImageView2 = this.b;
                    emotionDetailImageView2.addView(emotionDetailImageView2.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1641615534, "Lcom/baidu/tieba/faceshop/emotiondetail/view/EmotionDetailImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1641615534, "Lcom/baidu/tieba/faceshop/emotiondetail/view/EmotionDetailImageView;");
                return;
            }
        }
        d = oi.h(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16843399);
            this.b = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f97));
            layoutParams.gravity = 17;
            this.b.setLayoutParams(layoutParams);
            this.b.setIndeterminate(true);
            addView(this.b);
            this.c = oi.k(getContext());
        }
    }

    public void f(EmotionDetailData emotionDetailData, int i, boolean z) {
        EmotionDetailData.PicInfo picInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{emotionDetailData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || emotionDetailData == null || (picInfo = emotionDetailData.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        if (z) {
            GifView gifView = new GifView(getContext());
            this.a = gifView;
            gifView.setSupportNoImage(false);
            GifInfo gifInfo = new GifInfo();
            EmotionDetailData.PicInfo picInfo2 = emotionDetailData.pic_info;
            String str = picInfo2.thumbnail;
            gifInfo.mSharpText = str;
            String str2 = picInfo2.pic_url;
            gifInfo.mDynamicUrl = str2;
            gifInfo.mStaticUrl = str2;
            gifInfo.mGifWidth = picInfo2.width;
            gifInfo.mGifHeight = picInfo2.height;
            this.a.setTag(str);
            ((GifView) this.a).g0(gifInfo);
            ImageView imageView = this.a;
            EmotionDetailData.PicInfo picInfo3 = emotionDetailData.pic_info;
            g(imageView, picInfo3.width, picInfo3.height, 200, 200);
            addView(this.a);
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        ig.h().m(emotionDetailData.pic_info.pic_url, i, new a(this, emotionDetailData), null);
    }

    public final boolean g(ImageView imageView, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{imageView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i5 = this.c;
            if (i5 > 0) {
                i4 = (int) (i5 * 0.5f);
                i3 = i5;
            }
            int[] l = oi.l(i, i2, i3, i4);
            if (l == null) {
                return false;
            }
            int[] iArr = {l[0], l[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (i3 > i6) {
                float f = d;
                if (f > 1.0f) {
                    float f2 = i6;
                    float f3 = i3;
                    if (f2 * f > f3) {
                        i6 = i3 - (oi.f(getContext(), R.dimen.obfuscated_res_0x7f07020f) * 2);
                    } else {
                        float f4 = f3 * 0.68f;
                        i6 = f2 * f > f4 ? (int) f4 : (int) (f2 * f);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
            layoutParams.gravity = 17;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(layoutParams);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = null;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.b = null;
        e();
    }
}
