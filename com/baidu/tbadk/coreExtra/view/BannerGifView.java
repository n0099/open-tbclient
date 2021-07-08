package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.o0.m.c;
import d.a.o0.m.d;
/* loaded from: classes3.dex */
public class BannerGifView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GifView f12859e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f12860f;

    /* renamed from: g  reason: collision with root package name */
    public View f12861g;

    /* renamed from: h  reason: collision with root package name */
    public float f12862h;

    /* renamed from: i  reason: collision with root package name */
    public String f12863i;
    public String j;
    public boolean k;
    public c l;
    public d m;
    public final d n;
    public final View.OnClickListener o;

    /* loaded from: classes3.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BannerGifView f12864a;

        public a(BannerGifView bannerGifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerGifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12864a = bannerGifView;
        }

        @Override // d.a.o0.m.d
        public boolean a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f12864a.m == null || !this.f12864a.m.a(view)) {
                    this.f12864a.e();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BannerGifView f12865e;

        public b(BannerGifView bannerGifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerGifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12865e = bannerGifView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view == this.f12865e.f12860f) {
                this.f12865e.setCloseVisibility(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerGifView(Context context) {
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
        this.f12862h = 5.744f;
        this.k = false;
        this.n = new a(this);
        this.o = new b(this);
        f();
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = 0;
            boolean z = true;
            if (i2 != 1 && i2 != 4) {
                z = false;
            }
            this.f12861g.setVisibility((this.k && z) ? 8 : 8);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (TextUtils.isEmpty(this.j)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{this.j});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
            this.f12860f = (ImageView) inflate.findViewById(R.id.btn_close);
            this.f12861g = inflate.findViewById(R.id.image_mask);
            GifView gifView = (GifView) inflate.findViewById(R.id.image_gif);
            this.f12859e = gifView;
            gifView.setShowStaticDrawable(false);
            this.f12859e.setSupportNoImage(false);
            this.f12859e.setAutoPlay(true);
            this.f12860f.setOnClickListener(this.o);
            this.f12859e.setOnInterceptClickListener(this.n);
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f12861g, R.color.black_alpha30, i2);
            d(i2);
        }
    }

    public GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12859e : (GifView) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12863i : (String) invokeV.objValue;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getMode(i3);
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            View.MeasureSpec.getSize(i3);
            getPaddingBottom();
            getPaddingTop();
            float f2 = this.f12862h;
            if (f2 > 0.0f) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) ((size / f2) + 0.5f), 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.l != null) {
                this.l.a(this, i2 == 0, this.f12863i);
            }
        }
    }

    public void setCloseVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f12860f.setVisibility(z ? 0 : 8);
        }
    }

    public void setDefaultResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setImageResource(this.f12859e, i2);
        }
    }

    public void setErrorResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f12859e.setErrorResid(i2);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public void setNeedNightMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k = z;
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setOnClickEventListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.f12862h = f2;
            invalidate();
        }
    }
}
