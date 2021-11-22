package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b.a.r0.a3.l0.g;
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
import java.io.File;
/* loaded from: classes8.dex */
public class SplashAdView extends BCAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.u.a.f.b f47687e;
    public boolean isVideoAd;
    public ScalableVideoView scalableVideoView;

    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f47688e;

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
            this.f47688e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f47688e.scalableVideoView.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f47689e;

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
            this.f47689e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                b.a.r0.u.a.j.a.a();
                this.f47689e.f47687e.f25415d = "";
                b.a.r0.u.a.j.a.h(this.f47689e.f47687e);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f47690e;

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
            this.f47690e = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f47691e;

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
            this.f47691e = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || b.a.r0.u.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = this.f47691e.mCacheAdInfo;
            if (adInfo.advisible != 0) {
                b.a.r0.a3.l0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "video"));
            }
            SplashAdView splashAdView = this.f47691e;
            if (splashAdView.mCallBack == null || TextUtils.isEmpty(splashAdView.f47687e.f25416e)) {
                return;
            }
            SplashAdView splashAdView2 = this.f47691e;
            splashAdView2.mCallBack.a(splashAdView2.f47687e.f25416e);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SplashAdView f47692e;

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
            this.f47692e = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || b.a.r0.u.a.j.a.f()) {
                return;
            }
            AdInfo adInfo = this.f47692e.mCacheAdInfo;
            if (adInfo.advisible != 0) {
                b.a.r0.a3.l0.e.b().d(g.k(adInfo.extraParam, 2, adInfo.placeId, "image"));
            }
            SplashAdView splashAdView = this.f47692e;
            if (splashAdView.mCallBack == null || TextUtils.isEmpty(splashAdView.f47687e.f25413b)) {
                return;
            }
            SplashAdView splashAdView2 = this.f47692e;
            splashAdView2.mCallBack.a(splashAdView2.f47687e.f25413b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i2, int i3, RedirectType redirectType) {
        super(tbPageContext, str, adType, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
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
        this.redirectType = redirectType;
        this.mSplashInfoCache = new b.a.r0.u.a.f.c(tbPageContext.getPageActivity());
        this.mCacheAdInfo = new AdInfo();
    }

    public b.a.r0.u.a.f.b getEntryInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47687e : (b.a.r0.u.a.f.b) invokeV.objValue;
    }

    public boolean isCanShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (System.currentTimeMillis() / 1000 < this.mCacheAdInfo.startShowTime || System.currentTimeMillis() / 1000 > this.mCacheAdInfo.endShowTime) {
                AdInfo adInfo = this.mCacheAdInfo;
                if (adInfo.startShowTime != 0 || adInfo.endShowTime != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isSplashAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            loadAd();
            AdInfo jsonToObject = AdInfo.jsonToObject(this.mSplashInfoCache.a());
            this.mCacheAdInfo = jsonToObject;
            String str = this.placeId;
            jsonToObject.placeId = str;
            if (jsonToObject.advisible == 0) {
                b.a.r0.a3.l0.e.b().d(g.j(jsonToObject.extraParam, 3, str));
            }
            b.a.r0.u.a.f.b b2 = b.a.r0.u.a.f.b.b(b.a.r0.u.a.j.a.d());
            this.f47687e = b2;
            if (b2.c()) {
                if (this.f47687e.d()) {
                    this.isVideoAd = true;
                    String str2 = this.f47687e.f25415d;
                    File file = new File(str2);
                    if (file.exists()) {
                        b.a.r0.u.a.j.a.b(file);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
                        ScalableVideoView scalableVideoView = new ScalableVideoView(this.mContext);
                        this.scalableVideoView = scalableVideoView;
                        scalableVideoView.setScalableType(ScalableType.CENTER_CROP);
                        try {
                            this.scalableVideoView.setDataSource(str2);
                            this.scalableVideoView.setVolume(0.0f, 0.0f);
                            this.scalableVideoView.prepareAsync(new a(this));
                            this.scalableVideoView.setOnErrorListener(new b(this));
                            this.scalableVideoView.setOnCompletionListener(new c(this));
                            this.scalableVideoView.setOnClickListener(new d(this));
                            addView(this.scalableVideoView, layoutParams);
                            AdInfo adInfo = this.mCacheAdInfo;
                            b.a.r0.a3.l0.e.b().d(g.k(adInfo.extraParam, 3, adInfo.placeId, "video"));
                            return true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            b.a.r0.u.a.j.a.a();
                            b.a.r0.u.a.f.b bVar = this.f47687e;
                            bVar.f25415d = "";
                            b.a.r0.u.a.j.a.h(bVar);
                            return false;
                        }
                    }
                    b.a.r0.u.a.j.a.a();
                    b.a.r0.u.a.f.b bVar2 = this.f47687e;
                    bVar2.f25415d = "";
                    b.a.r0.u.a.j.a.h(bVar2);
                    return false;
                } else if (!TextUtils.isEmpty(this.f47687e.f25412a)) {
                    if (this.mAdImageView != null) {
                        this.mAdImageView = null;
                    }
                    TbImageView tbImageView = new TbImageView(this.mContext);
                    this.mAdImageView = tbImageView;
                    tbImageView.setOnClickListener(new e(this));
                    this.mAdImageView.startLoad(this.mCacheAdInfo.adImgUrl, 10, false);
                    this.mAdImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    addView(this.mAdImageView, new RelativeLayout.LayoutParams(this.mWidth, this.mHeight));
                    AdInfo adInfo2 = this.mCacheAdInfo;
                    b.a.r0.a3.l0.e.b().d(g.k(adInfo2.extraParam, 3, adInfo2.placeId, "image"));
                    return true;
                } else {
                    b.a.r0.u.a.j.a.a();
                }
            } else {
                b.a.r0.u.a.j.a.c();
                b.a.r0.u.a.j.a.a();
            }
            return false;
        }
        return invokeV.booleanValue;
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
            ScalableVideoView scalableVideoView = this.scalableVideoView;
            if (scalableVideoView != null) {
                scalableVideoView.onDetachedFromWindow();
            }
        }
    }

    public String skipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdInfo adInfo = this.mCacheAdInfo;
            if (adInfo == null) {
                AdInfo adInfo2 = this.mRequestAdInfo;
                if (adInfo2 == null) {
                    return null;
                }
                return adInfo2.displayName;
            }
            return adInfo.displayName;
        }
        return (String) invokeV.objValue;
    }
}
