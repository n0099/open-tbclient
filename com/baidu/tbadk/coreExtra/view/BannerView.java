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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.g0;
import d.a.s0.w2.x;
/* loaded from: classes4.dex */
public class BannerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f12849e;

    /* renamed from: f  reason: collision with root package name */
    public String f12850f;

    /* renamed from: g  reason: collision with root package name */
    public Button f12851g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f12852h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f12853i;
    public TbImageView j;
    public View k;
    public boolean l;
    public float m;
    public String n;
    public boolean o;
    public g0 p;
    public String q;
    public b r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerView f12854e;

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
            this.f12854e = bannerView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BannerView bannerView = this.f12854e;
                if (view == bannerView.f12851g) {
                    if (!TextUtils.isEmpty(bannerView.f12850f)) {
                        TiebaStatic.log(this.f12854e.f12850f);
                    }
                    this.f12854e.l = true;
                    this.f12854e.setVisibility(8);
                    if (this.f12854e.r != null) {
                        this.f12854e.r.a();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(bannerView.f12849e)) {
                    TiebaStatic.log(this.f12854e.f12849e);
                }
                if (this.f12854e.r == null) {
                    if (TextUtils.isEmpty(this.f12854e.n)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f12854e.f12853i, new String[]{this.f12854e.n});
                    if (!this.f12854e.n.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(this.f12854e.q)) {
                        if (this.f12854e.n.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(this.f12854e.q)) {
                            TiebaStatic.eventStat(this.f12854e.f12853i.getPageActivity(), "enterforum_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    TiebaStatic.eventStat(this.f12854e.f12853i.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                    return;
                }
                this.f12854e.r.b();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f12849e = "";
        this.f12850f = "";
        this.l = false;
        this.m = 0.16875f;
        this.o = false;
        this.s = new a(this);
        h(context);
    }

    public TbImageView getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12852h : (TbImageView) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.bannerview, this);
            Button button = (Button) findViewById(R.id.btn_close);
            this.f12851g = button;
            button.setOnClickListener(this.s);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.banner_image);
            this.f12852h = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.f12852h.setOnClickListener(this.s);
            this.j = (TbImageView) findViewById(R.id.tv_advert);
            View findViewById = findViewById(R.id.banner_mask);
            this.k = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.black_alpha0);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12852h.postInvalidate();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
            this.o = false;
        }
    }

    public void setBannerData(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g0Var) == null) {
            this.p = g0Var;
            x.k(g0Var.f55955g, this.j, g0Var.f55956h, l.g(getContext(), R.dimen.ds26));
        }
    }

    public void setBannerMaskColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.k.setBackgroundColor(i2);
        }
    }

    public void setBannerType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.q = str;
        }
    }

    public void setBannerViewClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void setBannerViewEvent(TbImageView.f fVar) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || (tbImageView = this.f12852h) == null || fVar == null) {
            return;
        }
        tbImageView.setEvent(fVar);
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, tbPageContext, str, str2) == null) {
            this.f12853i = tbPageContext;
            this.n = str2;
            this.o = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
            setVisibility(8);
            if (!this.l && this.o) {
                ViewGroup.LayoutParams layoutParams = this.f12852h.getLayoutParams();
                layoutParams.width = l.k(getContext());
                layoutParams.height = (int) ((l.k(getContext()) * this.m) + 0.5d);
                this.f12852h.setLayoutParams(layoutParams);
                this.f12852h.J(str, 10, 640, 108, false);
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
        this.f12849e = str;
        this.f12850f = str2;
    }

    public void setTagViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
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
