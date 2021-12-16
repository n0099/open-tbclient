package com.baidu.tieba.faceshop.emotiondetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import c.a.d.f.p.m;
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
/* loaded from: classes12.dex */
public class EmotionDetailImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final float f44391h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44392e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f44393f;

    /* renamed from: g  reason: collision with root package name */
    public int f44394g;

    /* loaded from: classes12.dex */
    public class a extends c<c.a.d.m.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionDetailData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionDetailImageView f44395b;

        public a(EmotionDetailImageView emotionDetailImageView, EmotionDetailData emotionDetailData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionDetailImageView, emotionDetailData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44395b = emotionDetailImageView;
            this.a = emotionDetailData;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f44395b.f44393f.setVisibility(8);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.f44395b.f44393f.setVisibility(8);
                if (aVar != null) {
                    this.f44395b.f44392e = new TbMemeImageView(this.f44395b.getContext());
                    ((TbMemeImageView) this.f44395b.f44392e).startLoad(aVar);
                    EmotionDetailImageView emotionDetailImageView = this.f44395b;
                    ImageView imageView = emotionDetailImageView.f44392e;
                    EmotionDetailData.PicInfo picInfo = this.a.pic_info;
                    emotionDetailImageView.f(imageView, picInfo.width, picInfo.height, 200, 200);
                    EmotionDetailImageView emotionDetailImageView2 = this.f44395b;
                    emotionDetailImageView2.addView(emotionDetailImageView2.f44392e);
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
        f44391h = m.h(TbadkCoreApplication.getInst());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44393f = null;
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ProgressBar progressBar = new ProgressBar(getContext(), null, 16843399);
            this.f44393f = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
            layoutParams.gravity = 17;
            this.f44393f.setLayoutParams(layoutParams);
            this.f44393f.setIndeterminate(true);
            addView(this.f44393f);
            this.f44394g = m.k(getContext());
        }
    }

    public final boolean f(ImageView imageView, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int i6 = this.f44394g;
            if (i6 > 0) {
                i5 = (int) (i6 * 0.5f);
                i4 = i6;
            }
            int[] l = m.l(i2, i3, i4, i5);
            if (l == null) {
                return false;
            }
            int[] iArr = {l[0], l[1]};
            int i7 = iArr[0];
            int i8 = iArr[1];
            if (i4 > i7) {
                float f2 = f44391h;
                if (f2 > 1.0f) {
                    float f3 = i7;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i7 = i4 - (m.f(getContext(), R.dimen.ds34) * 2);
                    } else {
                        float f5 = f4 * 0.68f;
                        i7 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i8 = (iArr[1] * i7) / iArr[0];
                    }
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
            layoutParams.gravity = 17;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(layoutParams);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void loadImage(EmotionDetailData emotionDetailData, int i2, boolean z) {
        EmotionDetailData.PicInfo picInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{emotionDetailData, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || emotionDetailData == null || (picInfo = emotionDetailData.pic_info) == null || TextUtils.isEmpty(picInfo.pic_url)) {
            return;
        }
        if (z) {
            GifView gifView = new GifView(getContext());
            this.f44392e = gifView;
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
            this.f44392e.setTag(str);
            ((GifView) this.f44392e).startLoad(gifInfo);
            ImageView imageView = this.f44392e;
            EmotionDetailData.PicInfo picInfo3 = emotionDetailData.pic_info;
            f(imageView, picInfo3.width, picInfo3.height, 200, 200);
            addView(this.f44392e);
            this.f44393f.setVisibility(8);
            return;
        }
        this.f44393f.setVisibility(0);
        d.h().m(emotionDetailData.pic_info.pic_url, i2, new a(this, emotionDetailData), null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44393f = null;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f44393f = null;
        e();
    }
}
