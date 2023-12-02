package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f17;
import com.baidu.tieba.tt5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = this.a.p;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            str = "emotion_image";
                        } else {
                            str = "faceshop_from_gchat_detail";
                        }
                    } else {
                        str = "faceshop_from_pchat_detail";
                    }
                } else {
                    str = "faceshop_from_forum_detail";
                }
                this.a.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), this.a.f, false, str)));
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02a3);
            K0(bundle);
            L0();
        }
    }

    public final void K0(Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int i2 = 160;
            int i3 = (getResources().getDisplayMetrics().density > 1.5d ? 1 : (getResources().getDisplayMetrics().density == 1.5d ? 0 : -1));
            if (i3 < 0) {
                i = 160;
            } else {
                i = 240;
            }
            this.n = i;
            if (i3 >= 0) {
                i2 = 240;
            }
            this.o = i2;
            if (bundle != null) {
                this.f = bundle.getString("pid");
                this.g = bundle.getString("panme");
                this.h = bundle.getString(GameAssistConstKt.KEY_ICONURL);
                this.i = bundle.getString("gifUrl");
                this.j = bundle.getString("staticUrl");
                this.k = bundle.getString("sharpText");
                this.l = bundle.getInt("width");
                this.m = bundle.getInt("height");
            } else {
                Intent intent = getIntent();
                this.f = intent.getStringExtra("pid");
                this.g = intent.getStringExtra("panme");
                this.h = intent.getStringExtra(GameAssistConstKt.KEY_ICONURL);
                this.i = intent.getStringExtra("gifUrl");
                this.j = intent.getStringExtra("staticUrl");
                this.k = intent.getStringExtra("sharpText");
                this.l = intent.getIntExtra("width", this.n);
                this.m = intent.getIntExtra("height", this.o);
            }
            this.p = getIntent().getIntExtra("from", 0);
        }
    }

    public final void L0() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setTitleText(getString(R.string.obfuscated_res_0x7f0f065f));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.b = (GifView) findViewById(R.id.obfuscated_res_0x7f090ec0);
            if (this.l != 0 && this.m != 0) {
                layoutParams = new FrameLayout.LayoutParams(this.l, this.m, 17);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.n, this.o, 17);
            }
            this.b.setLayoutParams(layoutParams);
            boolean c = tt5.c();
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
            this.b.p(gifInfo);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090a10);
            if (!TextUtils.isEmpty(this.h)) {
                this.c.startLoad(this.h, 10, false);
            } else {
                Bitmap f = f17.f(this.f, "panel.png");
                if (f != null) {
                    new BdImage(f, false).drawImageTo(this.c);
                }
            }
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090a34);
            this.d = textView;
            textView.setText(this.g);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090a00);
            this.e = textView2;
            textView2.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(findViewById(R.id.obfuscated_res_0x7f090a11));
            this.a.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("pid", this.f);
            bundle.putString("panme", this.g);
            bundle.putString(GameAssistConstKt.KEY_ICONURL, this.h);
            bundle.putString("gifUrl", this.i);
            bundle.putString("staticUrl", this.j);
            bundle.putString("sharpText", this.k);
            bundle.putInt("width", this.l);
            bundle.putInt("height", this.m);
        }
    }
}
