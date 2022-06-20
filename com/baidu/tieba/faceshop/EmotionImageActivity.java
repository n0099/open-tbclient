package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
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
import com.repackage.hc5;
import com.repackage.u76;
import com.repackage.ym;
/* loaded from: classes3.dex */
public class EmotionImageActivity extends BaseActivity<EmotionImageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public GifView b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageActivity a;

        public a(EmotionImageActivity emotionImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageActivity a;

        public b(EmotionImageActivity emotionImageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionImageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionImageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = this.a.p;
                this.a.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), this.a.f, false, i != 1 ? i != 2 ? i != 3 ? "emotion_image" : "faceshop_from_gchat_detail" : "faceshop_from_pchat_detail" : "faceshop_from_forum_detail")));
            }
        }
    }

    public EmotionImageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 0;
    }

    public final void C1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int i = (getResources().getDisplayMetrics().density > 1.5d ? 1 : (getResources().getDisplayMetrics().density == 1.5d ? 0 : -1));
            this.n = i < 0 ? 160 : 240;
            this.o = i >= 0 ? 240 : 160;
            if (bundle != null) {
                this.f = bundle.getString("pid");
                this.g = bundle.getString("panme");
                this.h = bundle.getString("iconUrl");
                this.i = bundle.getString("gifUrl");
                this.j = bundle.getString("staticUrl");
                this.k = bundle.getString("sharpText");
                this.l = bundle.getInt("width");
                this.m = bundle.getInt("height");
            } else {
                Intent intent = getIntent();
                this.f = intent.getStringExtra("pid");
                this.g = intent.getStringExtra("panme");
                this.h = intent.getStringExtra("iconUrl");
                this.i = intent.getStringExtra("gifUrl");
                this.j = intent.getStringExtra("staticUrl");
                this.k = intent.getStringExtra("sharpText");
                this.l = intent.getIntExtra("width", this.n);
                this.m = intent.getIntExtra("height", this.o);
            }
            this.p = getIntent().getIntExtra("from", 0);
        }
    }

    public final void D1() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914e4);
            this.a = navigationBar;
            navigationBar.setTitleText(getString(R.string.obfuscated_res_0x7f0f0546));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.b = (GifView) findViewById(R.id.obfuscated_res_0x7f090c69);
            if (this.l != 0 && this.m != 0) {
                layoutParams = new FrameLayout.LayoutParams(this.l, this.m, 17);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.n, this.o, 17);
            }
            this.b.setLayoutParams(layoutParams);
            boolean c = hc5.c();
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.k;
            gifInfo.mGid = this.f;
            gifInfo.mGifHeight = this.m;
            gifInfo.mGifWidth = this.l;
            if (c) {
                gifInfo.mDynamicUrl = this.i;
            } else {
                gifInfo.mStaticUrl = this.j;
            }
            this.b.i0(gifInfo);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090858);
            if (!TextUtils.isEmpty(this.h)) {
                this.c.J(this.h, 10, false);
            } else {
                Bitmap f = u76.f(this.f, "panel.png");
                if (f != null) {
                    new ym(f, false).h(this.c);
                }
            }
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09087b);
            this.d = textView;
            textView.setText(this.g);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090848);
            this.e = textView2;
            textView2.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(findViewById(R.id.obfuscated_res_0x7f090859));
            this.a.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0245);
            C1(bundle);
            D1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("pid", this.f);
            bundle.putString("panme", this.g);
            bundle.putString("iconUrl", this.h);
            bundle.putString("gifUrl", this.i);
            bundle.putString("staticUrl", this.j);
            bundle.putString("sharpText", this.k);
            bundle.putInt("width", this.l);
            bundle.putInt("height", this.m);
        }
    }
}
