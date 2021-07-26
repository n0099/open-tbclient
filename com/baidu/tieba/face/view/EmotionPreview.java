package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.c;
import d.a.d.e.l.d;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class EmotionPreview extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14901e;

    /* renamed from: f  reason: collision with root package name */
    public int f14902f;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f14903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14904b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EmotionPreview f14905c;

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
            this.f14905c = emotionPreview;
            this.f14903a = str;
            this.f14904b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            if (aVar.t()) {
                this.f14905c.f14901e = new GifView(this.f14905c.getContext());
                ((GifView) this.f14905c.f14901e).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                String str2 = this.f14903a;
                gifInfo.mSharpText = str2;
                gifInfo.mDynamicUrl = str2;
                gifInfo.mStaticUrl = this.f14904b;
                this.f14905c.f14901e.setTag(gifInfo.mSharpText);
                ((GifView) this.f14905c.f14901e).k0(gifInfo);
            } else {
                this.f14905c.f14901e = new TbImageView(this.f14905c.getContext());
                ((TbImageView) this.f14905c.f14901e).setGifIconSupport(false);
                aVar.h(this.f14905c.f14901e);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f14905c.f14902f, this.f14905c.f14902f);
            layoutParams.gravity = 17;
            EmotionPreview emotionPreview = this.f14905c;
            emotionPreview.addView(emotionPreview.f14901e, layoutParams);
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
            int g2 = l.g(getContext(), R.dimen.ds20);
            setPadding(g2, g2, g2, l.g(getContext(), R.dimen.ds40));
            this.f14902f = l.g(getContext(), R.dimen.ds200);
        }
    }

    public void e(String str, String str2, boolean z, int i2) {
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
        this.f14901e = gifView;
        gifView.setSupportNoImage(false);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = str;
        gifInfo.mDynamicUrl = str;
        gifInfo.mStaticUrl = str2;
        this.f14901e.setTag(str);
        ((GifView) this.f14901e).k0(gifInfo);
        int i3 = this.f14902f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        addView(this.f14901e, layoutParams);
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
