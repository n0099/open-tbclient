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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.fm9;
import com.baidu.tieba.o25;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BannerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public Button c;
    public TbImageView d;
    public TbPageContext<?> e;
    public TbImageView f;
    public View g;
    public boolean h;
    public float i;
    public String j;
    public boolean k;
    public o25 l;
    public String m;
    public b n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BannerView a;

        public a(BannerView bannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bannerView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BannerView bannerView = this.a;
                if (view2 == bannerView.c) {
                    if (!TextUtils.isEmpty(bannerView.b)) {
                        TiebaStatic.log(this.a.b);
                    }
                    this.a.h = true;
                    this.a.setVisibility(8);
                    if (this.a.n != null) {
                        this.a.n.a();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(bannerView.a)) {
                    TiebaStatic.log(this.a.a);
                }
                if (this.a.n == null) {
                    if (!TextUtils.isEmpty(this.a.j)) {
                        UrlManager.getInstance().dealOneLink(this.a.e, new String[]{this.a.j});
                        if (this.a.j.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "frs_banner".equals(this.a.m)) {
                            TiebaStatic.eventStat(this.a.e.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                            return;
                        } else if (this.a.j.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(this.a.m)) {
                            TiebaStatic.eventStat(this.a.e.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                this.a.n.b();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.h = false;
        this.i = 0.16875f;
        this.k = false;
        this.o = new a(this);
        h(context);
    }

    public void setBannerData(o25 o25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o25Var) == null) {
            this.l = o25Var;
            fm9.f(o25Var.g, this.f, o25Var.h, vi.g(getContext(), R.dimen.obfuscated_res_0x7f0701f0));
        }
    }

    public void setBannerMaskColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g.setBackgroundColor(i);
        }
    }

    public void setBannerType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.m = str;
        }
    }

    public void setBannerViewClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void setBannerViewEvent(TbImageView.f fVar) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) && (tbImageView = this.d) != null && fVar != null) {
            tbImageView.setEvent(fVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, tbPageContext, str) == null) {
            setData(tbPageContext, str, "");
        }
    }

    public void setMtjInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && str != null && str2 != null) {
            this.a = str;
            this.b = str2;
        }
    }

    public TbImageView getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (TbImageView) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.postInvalidate();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h = false;
            this.k = false;
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d013d, this);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f0904ab);
            this.c = button;
            button.setOnClickListener(this.o);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.banner_image);
            this.d = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.d.setOnClickListener(this.o);
            this.f = (TbImageView) findViewById(R.id.tv_advert);
            View findViewById = findViewById(R.id.banner_mask);
            this.g = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.black_alpha0);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, tbPageContext, str, str2) == null) {
            this.e = tbPageContext;
            this.j = str2;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                z = true;
            } else {
                z = false;
            }
            this.k = z;
            setVisibility(8);
            if (!this.h && this.k) {
                ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                layoutParams.width = vi.l(getContext());
                layoutParams.height = (int) ((vi.l(getContext()) * this.i) + 0.5d);
                this.d.setLayoutParams(layoutParams);
                this.d.J(str, 10, 640, 108, false);
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = layoutParams.height;
                    setLayoutParams(layoutParams2);
                }
                setVisibility(0);
            }
        }
    }
}
