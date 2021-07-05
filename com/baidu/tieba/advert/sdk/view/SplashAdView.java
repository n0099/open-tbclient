package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableType;
import com.baidu.tieba.advert.sdk.widget.scalablevideoview.ScalableVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.i0.g;
import java.io.File;
/* loaded from: classes5.dex */
public class SplashAdView extends BCAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.t.a.f.b q;
    public boolean r;
    public ScalableVideoView s;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f13865e;

        public a(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13865e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f13865e.s.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f13866e;

        public b(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13866e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                d.a.s0.t.a.j.a.a();
                this.f13866e.q.f65483d = "";
                d.a.s0.t.a.j.a.h(this.f13866e.q);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f13867e;

        public c(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13867e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f13868e;

        public d(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13868e = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || d.a.s0.t.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = this.f13868e.j;
            if (adInfo.advisible != 0) {
                d.a.s0.w2.i0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "video"));
            }
            SplashAdView splashAdView = this.f13868e;
            if (splashAdView.f13856e == null || TextUtils.isEmpty(splashAdView.q.f65484e)) {
                return;
            }
            SplashAdView splashAdView2 = this.f13868e;
            splashAdView2.f13856e.a(splashAdView2.q.f65484e);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f13869e;

        public e(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13869e = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || d.a.s0.t.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = this.f13869e.j;
            if (adInfo.advisible != 0) {
                d.a.s0.w2.i0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "image"));
            }
            SplashAdView splashAdView = this.f13869e;
            if (splashAdView.f13856e == null || TextUtils.isEmpty(splashAdView.q.f65481b)) {
                return;
            }
            SplashAdView splashAdView2 = this.f13869e;
            splashAdView2.f13856e.a(splashAdView2.q.f65481b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3, RedirectType redirectType) {
        super(tbPageContext, str, adType, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, adType, Integer.valueOf(i2), Integer.valueOf(i3), redirectType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (String) objArr2[1], (AdType) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new d.a.s0.t.a.f.c(tbPageContext.getPageActivity());
        this.j = new AdInfo();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b();
            AdInfo jsonToObject = AdInfo.jsonToObject(this.p.a());
            this.j = jsonToObject;
            String str = this.l;
            jsonToObject.placeId = str;
            if (jsonToObject.advisible == 0) {
                d.a.s0.w2.i0.e.b().d(g.j(jsonToObject.extraParam, 3, str));
            }
            d.a.s0.t.a.f.b b2 = d.a.s0.t.a.f.b.b(d.a.s0.t.a.j.a.d());
            this.q = b2;
            if (b2.c()) {
                if (this.q.d()) {
                    this.r = true;
                    String str2 = this.q.f65483d;
                    File file = new File(str2);
                    if (file.exists()) {
                        d.a.s0.t.a.j.a.b(file);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.n, this.m);
                        ScalableVideoView scalableVideoView = new ScalableVideoView(this.f13860i);
                        this.s = scalableVideoView;
                        scalableVideoView.setScalableType(ScalableType.CENTER_CROP);
                        try {
                            this.s.setDataSource(str2);
                            this.s.setVolume(0.0f, 0.0f);
                            this.s.c(new a(this));
                            this.s.setOnErrorListener(new b(this));
                            this.s.setOnCompletionListener(new c(this));
                            this.s.setOnClickListener(new d(this));
                            addView(this.s, layoutParams);
                            AdInfo adInfo = this.j;
                            d.a.s0.w2.i0.e.b().d(g.k(adInfo.extraParam, 3, adInfo.placeId, "video"));
                            return true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            d.a.s0.t.a.j.a.a();
                            d.a.s0.t.a.f.b bVar = this.q;
                            bVar.f65483d = "";
                            d.a.s0.t.a.j.a.h(bVar);
                            return false;
                        }
                    }
                    d.a.s0.t.a.j.a.a();
                    d.a.s0.t.a.f.b bVar2 = this.q;
                    bVar2.f65483d = "";
                    d.a.s0.t.a.j.a.h(bVar2);
                    return false;
                } else if (!TextUtils.isEmpty(this.q.f65480a)) {
                    if (this.f13858g != null) {
                        this.f13858g = null;
                    }
                    TbImageView tbImageView = new TbImageView(this.f13860i);
                    this.f13858g = tbImageView;
                    tbImageView.setOnClickListener(new e(this));
                    this.f13858g.M(this.j.adImgUrl, 10, false);
                    this.f13858g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    addView(this.f13858g, new RelativeLayout.LayoutParams(this.n, this.m));
                    AdInfo adInfo2 = this.j;
                    d.a.s0.w2.i0.e.b().d(g.k(adInfo2.extraParam, 3, adInfo2.placeId, "image"));
                    return true;
                } else {
                    d.a.s0.t.a.j.a.a();
                }
            } else {
                d.a.s0.t.a.j.a.c();
                d.a.s0.t.a.j.a.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdInfo adInfo = this.j;
            if (adInfo == null) {
                AdInfo adInfo2 = this.k;
                if (adInfo2 == null) {
                    return null;
                }
                return adInfo2.displayName;
            }
            return adInfo.displayName;
        }
        return (String) invokeV.objValue;
    }

    public d.a.s0.t.a.f.b getEntryInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : (d.a.s0.t.a.f.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.advert.sdk.view.BCAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            ScalableVideoView scalableVideoView = this.s;
            if (scalableVideoView != null) {
                scalableVideoView.onDetachedFromWindow();
            }
        }
    }
}
