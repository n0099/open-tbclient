package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.r.g0;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.l3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BannerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTERFORUM_BANNER = "enterforum_banner";
    public static final String FRS_BANNER = "frs_banner";
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView bannerView;

    /* renamed from: e  reason: collision with root package name */
    public String f41043e;

    /* renamed from: f  reason: collision with root package name */
    public String f41044f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f41045g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f41046h;

    /* renamed from: i  reason: collision with root package name */
    public View f41047i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41048j;
    public float k;
    public String l;
    public boolean m;
    public Button mClose;
    public g0 n;
    public String o;
    public b p;
    public View.OnClickListener q;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerView f41049e;

        public a(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41049e = bannerView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BannerView bannerView = this.f41049e;
                if (view == bannerView.mClose) {
                    if (!TextUtils.isEmpty(bannerView.f41044f)) {
                        TiebaStatic.log(this.f41049e.f41044f);
                    }
                    this.f41049e.f41048j = true;
                    this.f41049e.setVisibility(8);
                    if (this.f41049e.p != null) {
                        this.f41049e.p.a();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(bannerView.f41043e)) {
                    TiebaStatic.log(this.f41049e.f41043e);
                }
                if (this.f41049e.p == null) {
                    if (TextUtils.isEmpty(this.f41049e.l)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f41049e.f41045g, new String[]{this.f41049e.l});
                    if (!this.f41049e.l.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !BannerView.FRS_BANNER.equals(this.f41049e.o)) {
                        if (this.f41049e.l.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && BannerView.ENTERFORUM_BANNER.equals(this.f41049e.o)) {
                            TiebaStatic.eventStat(this.f41049e.f41045g.getPageActivity(), BannerView.ENTERFORUM_BANNER, "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    TiebaStatic.eventStat(this.f41049e.f41045g.getPageActivity(), BannerView.FRS_BANNER, "click", 1, "ref_id", "4000601", "ref_type", "603");
                    return;
                }
                this.f41049e.p.b();
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(Context context, AttributeSet attributeSet) {
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
        this.f41043e = "";
        this.f41044f = "";
        this.f41048j = false;
        this.k = 0.16875f;
        this.m = false;
        this.q = new a(this);
        h(context);
    }

    public TbImageView getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bannerView : (TbImageView) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(h.bannerview, this);
            Button button = (Button) findViewById(g.btn_close);
            this.mClose = button;
            button.setOnClickListener(this.q);
            TbImageView tbImageView = (TbImageView) findViewById(g.banner_image);
            this.bannerView = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.bannerView.setOnClickListener(this.q);
            this.f41046h = (TbImageView) findViewById(g.tv_advert);
            View findViewById = findViewById(g.banner_mask);
            this.f41047i = findViewById;
            SkinManager.setBackgroundColor(findViewById, d.black_alpha0);
        }
    }

    public boolean isBannerViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.bannerView.postInvalidate();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f41048j = false;
            this.m = false;
        }
    }

    public void setBannerData(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g0Var) == null) {
            this.n = g0Var;
            z.l(g0Var.f13863g, this.f41046h, g0Var.f13864h, n.f(getContext(), e.ds26));
        }
    }

    public void setBannerMaskColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f41047i.setBackgroundColor(i2);
        }
    }

    public void setBannerType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.o = str;
        }
    }

    public void setBannerViewClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setBannerViewEvent(TbImageView.g gVar) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || (tbImageView = this.bannerView) == null || gVar == null) {
            return;
        }
        tbImageView.setEvent(gVar);
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, tbPageContext, str, str2) == null) {
            this.f41045g = tbPageContext;
            this.l = str2;
            this.m = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
            setVisibility(8);
            if (!this.f41048j && this.m) {
                ViewGroup.LayoutParams layoutParams = this.bannerView.getLayoutParams();
                layoutParams.width = n.k(getContext());
                layoutParams.height = (int) ((n.k(getContext()) * this.k) + 0.5d);
                this.bannerView.setLayoutParams(layoutParams);
                this.bannerView.startLoad(str, 10, 640, 108, false);
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = layoutParams.height;
                    setLayoutParams(layoutParams2);
                }
                setVisibility(0);
            }
        }
    }

    public void setMtjInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        this.f41043e = str;
        this.f41044f = str2;
    }

    public void setTagViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f41046h.setVisibility(0);
            } else {
                this.f41046h.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, tbPageContext, str) == null) {
            setData(tbPageContext, str, "");
        }
    }
}
