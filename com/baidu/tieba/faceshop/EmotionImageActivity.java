package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.s0.d1.t;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class EmotionImageActivity extends ProxyAdkBaseActivity<EmotionImageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f42745e;

    /* renamed from: f  reason: collision with root package name */
    public GifView f42746f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f42747g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42748h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42749i;

    /* renamed from: j  reason: collision with root package name */
    public String f42750j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionImageActivity f42751e;

        public a(EmotionImageActivity emotionImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42751e = emotionImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42751e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionImageActivity f42752e;

        public b(EmotionImageActivity emotionImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42752e = emotionImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f42752e.t;
                this.f42752e.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f42752e.getPageContext().getPageActivity(), this.f42752e.f42750j, false, i2 != 1 ? i2 != 2 ? i2 != 3 ? "emotion_image" : "faceshop_from_gchat_detail" : "faceshop_from_pchat_detail" : "faceshop_from_forum_detail")));
            }
        }
    }

    public EmotionImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0;
    }

    public final void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int i2 = (getResources().getDisplayMetrics().density > 1.5d ? 1 : (getResources().getDisplayMetrics().density == 1.5d ? 0 : -1));
            this.r = i2 < 0 ? 160 : 240;
            this.s = i2 >= 0 ? 240 : 160;
            if (bundle != null) {
                this.f42750j = bundle.getString("pid");
                this.k = bundle.getString("panme");
                this.l = bundle.getString("iconUrl");
                this.m = bundle.getString("gifUrl");
                this.n = bundle.getString("staticUrl");
                this.o = bundle.getString("sharpText");
                this.p = bundle.getInt("width");
                this.q = bundle.getInt("height");
            } else {
                Intent intent = getIntent();
                this.f42750j = intent.getStringExtra("pid");
                this.k = intent.getStringExtra("panme");
                this.l = intent.getStringExtra("iconUrl");
                this.m = intent.getStringExtra("gifUrl");
                this.n = intent.getStringExtra("staticUrl");
                this.o = intent.getStringExtra("sharpText");
                this.p = intent.getIntExtra("width", this.r);
                this.q = intent.getIntExtra("height", this.s);
            }
            this.t = getIntent().getIntExtra("from", 0);
        }
    }

    public final void i() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.f42745e = navigationBar;
            navigationBar.setTitleText(getString(R.string.emotion_image_title));
            this.f42745e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f42746f = (GifView) findViewById(R.id.gifview);
            if (this.p != 0 && this.q != 0) {
                layoutParams = new FrameLayout.LayoutParams(this.p, this.q, 17);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.r, this.s, 17);
            }
            this.f42746f.setLayoutParams(layoutParams);
            boolean f2 = t.f();
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.o;
            gifInfo.mGid = this.f42750j;
            gifInfo.mGifHeight = this.q;
            gifInfo.mGifWidth = this.p;
            if (f2) {
                gifInfo.mDynamicUrl = this.m;
            } else {
                gifInfo.mStaticUrl = this.n;
            }
            this.f42746f.startLoad(gifInfo);
            this.f42747g = (TbImageView) findViewById(R.id.emotion_icon);
            if (!TextUtils.isEmpty(this.l)) {
                this.f42747g.startLoad(this.l, 10, false);
            } else {
                Bitmap f3 = c.a.t0.z0.b.f(this.f42750j, "panel.png");
                if (f3 != null) {
                    new c.a.d.n.d.a(f3, false).h(this.f42747g);
                }
            }
            TextView textView = (TextView) findViewById(R.id.emotion_pname);
            this.f42748h = textView;
            textView.setText(this.k);
            TextView textView2 = (TextView) findViewById(R.id.emotion_detail);
            this.f42749i = textView2;
            textView2.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(findViewById(R.id.emotion_image_root));
            this.f42745e.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.emotion_activity);
            h(bundle);
            i();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("pid", this.f42750j);
            bundle.putString("panme", this.k);
            bundle.putString("iconUrl", this.l);
            bundle.putString("gifUrl", this.m);
            bundle.putString("staticUrl", this.n);
            bundle.putString("sharpText", this.o);
            bundle.putInt("width", this.p);
            bundle.putInt("height", this.q);
        }
    }
}
