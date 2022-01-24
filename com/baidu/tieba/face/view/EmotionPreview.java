package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class EmotionPreview extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42731e;

    /* renamed from: f  reason: collision with root package name */
    public int f42732f;

    /* loaded from: classes12.dex */
    public class a extends c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42733b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EmotionPreview f42734c;

        public a(EmotionPreview emotionPreview, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionPreview, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42734c = emotionPreview;
            this.a = str;
            this.f42733b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            if (aVar.t()) {
                this.f42734c.f42731e = new GifView(this.f42734c.getContext());
                ((GifView) this.f42734c.f42731e).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                String str2 = this.a;
                gifInfo.mSharpText = str2;
                gifInfo.mDynamicUrl = str2;
                gifInfo.mStaticUrl = this.f42733b;
                this.f42734c.f42731e.setTag(gifInfo.mSharpText);
                ((GifView) this.f42734c.f42731e).startLoad(gifInfo);
            } else {
                this.f42734c.f42731e = new TbImageView(this.f42734c.getContext());
                ((TbImageView) this.f42734c.f42731e).setGifIconSupport(false);
                aVar.h(this.f42734c.f42731e);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f42734c.f42732f, this.f42734c.f42732f);
            layoutParams.gravity = 17;
            EmotionPreview emotionPreview = this.f42734c;
            emotionPreview.addView(emotionPreview.f42731e, layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionPreview(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundResource(R.drawable.bg_expression_bubble);
            int f2 = n.f(getContext(), R.dimen.ds20);
            setPadding(f2, f2, f2, n.f(getContext(), R.dimen.ds40));
            this.f42732f = n.f(getContext(), R.dimen.ds200);
        }
    }

    public void loadImage(String str, String str2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        removeAllViews();
        if (!z && i2 != 20) {
            d.h().m(str, 10, new a(this, str, str2), null);
            return;
        }
        GifView gifView = new GifView(getContext());
        this.f42731e = gifView;
        gifView.setSupportNoImage(false);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = str;
        gifInfo.mDynamicUrl = str;
        gifInfo.mStaticUrl = str2;
        this.f42731e.setTag(str);
        ((GifView) this.f42731e).startLoad(gifInfo);
        int i3 = this.f42732f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        addView(this.f42731e, layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d();
    }
}
