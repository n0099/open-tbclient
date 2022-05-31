package com.baidu.tieba.advert.sdk.view;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
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
import com.repackage.mk5;
import com.repackage.rx0;
import com.repackage.uj5;
import com.repackage.vj5;
import java.io.File;
/* loaded from: classes3.dex */
public class SplashAdView extends BCAdView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uj5 m;
    public boolean n;
    public ScalableVideoView o;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;

        public a(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.o.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;

        public b(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                mk5.a();
                this.a.m.d = "";
                mk5.h(this.a.m);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;

        public c(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAdView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;

        public d(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || mk5.f()) {
                return;
            }
            if (this.a.f.advisible != 0) {
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.w(ClogBuilder.LogType.CLICK).t("HOMEPAGE").v(this.a.f.placeId).h("video").n(this.a.f.extraParam);
                rx0.c(clogBuilder);
            }
            SplashAdView splashAdView = this.a;
            if (splashAdView.a == null || TextUtils.isEmpty(splashAdView.m.e)) {
                return;
            }
            SplashAdView splashAdView2 = this.a;
            splashAdView2.a.a(splashAdView2.m.e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;

        public e(SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = splashAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || mk5.f()) {
                return;
            }
            if (this.a.f.advisible != 0) {
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.w(ClogBuilder.LogType.CLICK).t("HOMEPAGE").v(this.a.f.placeId).h("image").n(this.a.f.extraParam);
                rx0.c(clogBuilder);
            }
            SplashAdView splashAdView = this.a;
            if (splashAdView.a == null || TextUtils.isEmpty(splashAdView.m.b)) {
                return;
            }
            SplashAdView splashAdView2 = this.a;
            splashAdView2.a.a(splashAdView2.m.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2, RedirectType redirectType) {
        super(tbPageContext, str, adType, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, adType, Integer.valueOf(i), Integer.valueOf(i2), redirectType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (String) objArr2[1], (AdType) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new vj5(tbPageContext.getPageActivity());
        this.f = new AdInfo();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b();
            AdInfo jsonToObject = AdInfo.jsonToObject(this.l.a());
            this.f = jsonToObject;
            jsonToObject.placeId = this.h;
            if (jsonToObject.advisible == 0) {
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.w(ClogBuilder.LogType.SHOW).t("HOMEPAGE").v(this.f.placeId).n(this.f.extraParam);
                rx0.c(clogBuilder);
            }
            uj5 b2 = uj5.b(mk5.d());
            this.m = b2;
            if (b2.c()) {
                if (this.m.d()) {
                    this.n = true;
                    String str = this.m.d;
                    File file = new File(str);
                    if (file.exists()) {
                        mk5.b(file);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.j, this.i);
                        ScalableVideoView scalableVideoView = new ScalableVideoView(this.e);
                        this.o = scalableVideoView;
                        scalableVideoView.setScalableType(ScalableType.CENTER_CROP);
                        try {
                            this.o.setDataSource(str);
                            this.o.setVolume(0.0f, 0.0f);
                            this.o.c(new a(this));
                            this.o.setOnErrorListener(new b(this));
                            this.o.setOnCompletionListener(new c(this));
                            this.o.setOnClickListener(new d(this));
                            addView(this.o, layoutParams);
                            ClogBuilder clogBuilder2 = new ClogBuilder();
                            clogBuilder2.w(ClogBuilder.LogType.SHOW).t("HOMEPAGE").v(this.f.placeId).h("video").n(this.f.extraParam);
                            rx0.c(clogBuilder2);
                            return true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            mk5.a();
                            uj5 uj5Var = this.m;
                            uj5Var.d = "";
                            mk5.h(uj5Var);
                            return false;
                        }
                    }
                    mk5.a();
                    uj5 uj5Var2 = this.m;
                    uj5Var2.d = "";
                    mk5.h(uj5Var2);
                    return false;
                } else if (!TextUtils.isEmpty(this.m.a)) {
                    if (this.c != null) {
                        this.c = null;
                    }
                    TbImageView tbImageView = new TbImageView(this.e);
                    this.c = tbImageView;
                    tbImageView.setOnClickListener(new e(this));
                    this.c.K(this.f.adImgUrl, 10, false);
                    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    addView(this.c, new RelativeLayout.LayoutParams(this.j, this.i));
                    ClogBuilder clogBuilder3 = new ClogBuilder();
                    clogBuilder3.w(ClogBuilder.LogType.SHOW).t("HOMEPAGE").v(this.f.placeId).h("image").n(this.f.extraParam);
                    rx0.c(clogBuilder3);
                    return true;
                } else {
                    mk5.a();
                }
            } else {
                mk5.c();
                mk5.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdInfo adInfo = this.f;
            if (adInfo == null) {
                AdInfo adInfo2 = this.g;
                if (adInfo2 == null) {
                    return null;
                }
                return adInfo2.displayName;
            }
            return adInfo.displayName;
        }
        return (String) invokeV.objValue;
    }

    public uj5 getEntryInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (uj5) invokeV.objValue;
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
            ScalableVideoView scalableVideoView = this.o;
            if (scalableVideoView != null) {
                scalableVideoView.onDetachedFromWindow();
            }
        }
    }
}
