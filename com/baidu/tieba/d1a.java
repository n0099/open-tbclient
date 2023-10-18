package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadDragView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdSimpleAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.u06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class d1a extends c1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout f;
    public AdImageView g;
    public TBSpecificationBtn h;
    public TextView i;
    public TextView j;
    public TextView k;
    public boolean l;
    public NadDragView m;
    public DragImageView.h n;
    public RelativeLayout o;
    public RelativeLayout p;
    public ImageView q;
    public FrameLayout r;
    public View s;
    public TBLottieAnimationView t;
    public Runnable u;
    public ApkDownloadView v;
    public VideoInfo w;
    public AdSimpleAppInfoView x;
    public final View.OnClickListener y;

    /* loaded from: classes5.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d1a a;

        public a(d1a d1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d1aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.resumeAnimation();
                this.a.t.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.t.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d1a a;

        public b(d1a d1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1a d1aVar;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frameLayout = (d1aVar = this.a).r) != null && d1aVar.t != null && frameLayout.getVisibility() == 0) {
                this.a.t.cancelAnimation();
                this.a.r.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NadDragView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d1a a;

        public c(d1a d1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d1aVar;
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.n != null) {
                    this.a.n.a();
                }
                this.a.i.setVisibility(8);
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.o.setVisibility(8);
                this.a.q.setVisibility(8);
                this.a.h.setVisibility(8);
                this.a.v.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.n != null) {
                this.a.n.b();
            }
        }

        @Override // com.baidu.nadcore.widget.NadDragView.a
        public void c() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.n != null) {
                    this.a.n.c();
                }
                this.a.i.setVisibility(0);
                this.a.j.setVisibility(0);
                this.a.k.setVisibility(0);
                this.a.o.setVisibility(0);
                this.a.x.setVisibility(0);
                d1a d1aVar = this.a;
                AdvertAppInfo advertAppInfo = d1aVar.b;
                if (advertAppInfo != null) {
                    ImageView imageView = d1aVar.q;
                    if (advertAppInfo.i()) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    imageView.setVisibility(i);
                    if (this.a.b.g()) {
                        this.a.h.setVisibility(0);
                    } else {
                        this.a.v.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d1a a;

        public d(d1a d1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d1aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int w;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                d1a d1aVar = this.a;
                if (d1aVar.b == null || d1aVar.a == null || d1aVar.l) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view2.getId() != R.id.obfuscated_res_0x7f09109b) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09045b) {
                        w = this.a.u();
                        str = "title";
                    } else {
                        w = this.a.w();
                        if (this.a.b.f()) {
                            str = "image";
                        } else {
                            str = "video";
                        }
                    }
                } else {
                    w = this.a.v(view2);
                    str = NativeConstants.ID_BUTTON;
                }
                hashMap.put("da_area", str);
                this.a.e.a(w, hashMap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements u06.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d1a a;

        public e(d1a d1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d1aVar;
        }

        @Override // com.baidu.tieba.u06.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                j06.a(this.a.a.getButtonCmdScheme());
                zy8.c(this.a.b);
                d1a d1aVar = this.a;
                if (d1aVar.c != null && uz9.g(d1aVar.a.getScheme()) && uz9.i(this.a.b.q)) {
                    d1a d1aVar2 = this.a;
                    Context context = d1aVar2.c;
                    String scheme = d1aVar2.a.getScheme();
                    String downloadId = this.a.b.getDownloadId();
                    d1a d1aVar3 = this.a;
                    uz9.a(context, scheme, downloadId, d1aVar3.b.g, d1aVar3.a.cmdScheme);
                    return true;
                } else if (this.a.c != null && !yx5.a().f() && !tda.a((Activity) this.a.c)) {
                    BdUtilHelper.showToast((Activity) this.a.c, (int) R.string.write_external_storage_permission_denied_fun_disable);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1a(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.u = null;
        this.y = new d(this);
    }

    public void E(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            this.n = hVar;
        }
    }

    public void F(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(onClickListener);
            }
            AdImageView adImageView = this.g;
            if (adImageView != null) {
                adImageView.setOnClickListener(onClickListener);
            }
            RelativeLayout relativeLayout = this.p;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(onClickListener);
            }
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
    }

    public final int v(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view2)) == null) {
            return A();
        }
        return invokeL.intValue;
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return uz9.a(this.c, this.a.getScheme(), this.a.getDownloadId(), this.b.g, this.a.cmdScheme);
        }
        return invokeV.intValue;
    }

    public final void B() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.b.i() && (videoInfo = this.w) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.a.getPicUrl();
            }
            this.g.s(picUrl);
        }
    }

    public void C() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (frameLayout = this.r) != null && this.t != null) {
            frameLayout.setVisibility(0);
            this.t.playAnimation();
            s();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.u != null) {
            SafeHandler.getInst().removeCallbacks(this.u);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.setDragToExitListener(new c(this));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.u = new b(this);
            SafeHandler.getInst().postDelayed(this.u, 10000L);
        }
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return A();
        }
        return invokeV.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.b.f()) {
                return A();
            }
            return x();
        }
        return invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.b != null && (adCard = this.a) != null && this.w != null) {
                return uz9.c(this.c, adCard.getScheme(), this.b, this.a.playCmdScheme);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.t;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            FrameLayout frameLayout = this.r;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.c1a
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.d == null) {
            return;
        }
        this.f = (RelativeLayout) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0072, (ViewGroup) null);
        AdImageView adImageView = new AdImageView(this.c);
        this.g = adImageView;
        adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setLayoutParams(layoutParams);
        this.g.setAdjustViewBounds(true);
        NadDragView nadDragView = (NadDragView) this.f.findViewById(R.id.obfuscated_res_0x7f09096a);
        this.m = nadDragView;
        nadDragView.setDragView(this.g);
        this.h = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f09109b);
        a55 a55Var = new a55();
        a55Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
        this.h.setConfig(a55Var);
        this.h.setTextHorizontalCenter(true);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090114);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0900a3);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09010c);
        this.o = (RelativeLayout) this.f.findViewById(R.id.ad_info_container);
        this.p = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09045b);
        ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0928b6);
        this.q = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.r = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0900ec);
        this.s = this.f.findViewById(R.id.obfuscated_res_0x7f090104);
        this.x = (AdSimpleAppInfoView) this.f.findViewById(R.id.app_info);
        EMManager.from(this.s).setGradientColor(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0900ed);
        this.t = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
        this.t.setRepeatCount(3);
        this.t.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.f.findViewById(R.id.obfuscated_res_0x7f0910a1);
        this.v = apkDownloadView;
        apkDownloadView.setTextSize(R.dimen.tbds39);
        this.v.setTextColorInitSkin(R.color.CAM_X0101);
        this.v.setBackgroundSkin(R.drawable.obfuscated_res_0x7f081233);
        this.v.b();
        F(this.y);
    }

    @Override // com.baidu.tieba.c1a
    public void e(AdCard adCard) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adCard) == null) {
            super.e(adCard);
            if (adCard == null) {
                return;
            }
            r();
            this.w = this.a.videoInfo;
            B();
            z(this.b, this.a);
            this.x.setAppInfo(adCard.appInfoModel);
            this.x.setAd(this.b);
            if (!TextUtils.isEmpty(this.b.m)) {
                this.j.setText(this.b.m);
                this.k.setText(this.c.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.i.setText(adCard.threadTitle);
            }
            ImageView imageView = this.q;
            if (this.b.i()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            F(this.y);
        }
    }

    public void z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, advertAppInfo, adCard) == null) && advertAppInfo != null && adCard != null) {
            this.b = advertAppInfo;
            this.a = adCard;
            if (advertAppInfo.g()) {
                this.h.setText(adCard.getButtonText());
                this.v.setVisibility(8);
                this.h.setVisibility(0);
                return;
            }
            this.v.setClickable(true);
            this.v.setInitText(adCard.getButtonText());
            this.v.setOnClickInterceptListener(new e(this));
            this.v.setVisibility(0);
            this.h.setVisibility(8);
            new t06(this.v, a1a.d(adCard));
        }
    }
}
