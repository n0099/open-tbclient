package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.fo;
import com.repackage.jc5;
import com.repackage.z86;
/* loaded from: classes3.dex */
public class EmotionImageActivity extends BaseActivity<EmotionImageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int adviceHeight;
    public int adviceWidth;
    public int from;
    public String gifUrl;
    public int height;
    public String iconUrl;
    public TextView mDetail;
    public GifView mGifVew;
    public TbImageView mIcon;
    public NavigationBar mNavigationBar;
    public TextView mPName;
    public String pid;
    public String pname;
    public String sharpText;
    public String staticUrl;
    public int width;

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
                int i = this.a.from;
                this.a.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), this.a.pid, false, i != 1 ? i != 2 ? i != 3 ? "emotion_image" : "faceshop_from_gchat_detail" : "faceshop_from_pchat_detail" : "faceshop_from_forum_detail")));
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
        this.from = 0;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            int i = (getResources().getDisplayMetrics().density > 1.5d ? 1 : (getResources().getDisplayMetrics().density == 1.5d ? 0 : -1));
            this.adviceWidth = i < 0 ? 160 : 240;
            this.adviceHeight = i >= 0 ? 240 : 160;
            if (bundle != null) {
                this.pid = bundle.getString("pid");
                this.pname = bundle.getString("panme");
                this.iconUrl = bundle.getString("iconUrl");
                this.gifUrl = bundle.getString("gifUrl");
                this.staticUrl = bundle.getString("staticUrl");
                this.sharpText = bundle.getString("sharpText");
                this.width = bundle.getInt("width");
                this.height = bundle.getInt("height");
            } else {
                Intent intent = getIntent();
                this.pid = intent.getStringExtra("pid");
                this.pname = intent.getStringExtra("panme");
                this.iconUrl = intent.getStringExtra("iconUrl");
                this.gifUrl = intent.getStringExtra("gifUrl");
                this.staticUrl = intent.getStringExtra("staticUrl");
                this.sharpText = intent.getStringExtra("sharpText");
                this.width = intent.getIntExtra("width", this.adviceWidth);
                this.height = intent.getIntExtra("height", this.adviceHeight);
            }
            this.from = getIntent().getIntExtra("from", 0);
        }
    }

    private void initUI() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091515);
            this.mNavigationBar = navigationBar;
            navigationBar.setTitleText(getString(R.string.obfuscated_res_0x7f0f0545));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.mGifVew = (GifView) findViewById(R.id.obfuscated_res_0x7f090cc9);
            if (this.width != 0 && this.height != 0) {
                layoutParams = new FrameLayout.LayoutParams(this.width, this.height, 17);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.adviceWidth, this.adviceHeight, 17);
            }
            this.mGifVew.setLayoutParams(layoutParams);
            boolean f = jc5.f();
            GifInfo gifInfo = new GifInfo();
            gifInfo.mSharpText = this.sharpText;
            gifInfo.mGid = this.pid;
            gifInfo.mGifHeight = this.height;
            gifInfo.mGifWidth = this.width;
            if (f) {
                gifInfo.mDynamicUrl = this.gifUrl;
            } else {
                gifInfo.mStaticUrl = this.staticUrl;
            }
            this.mGifVew.g0(gifInfo);
            this.mIcon = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09088e);
            if (!TextUtils.isEmpty(this.iconUrl)) {
                this.mIcon.K(this.iconUrl, 10, false);
            } else {
                Bitmap f2 = z86.f(this.pid, "panel.png");
                if (f2 != null) {
                    new fo(f2, false).h(this.mIcon);
                }
            }
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0908b1);
            this.mPName = textView;
            textView.setText(this.pname);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09087e);
            this.mDetail = textView2;
            textView2.setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(findViewById(R.id.obfuscated_res_0x7f09088f));
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0255);
            initData(bundle);
            initUI();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("pid", this.pid);
            bundle.putString("panme", this.pname);
            bundle.putString("iconUrl", this.iconUrl);
            bundle.putString("gifUrl", this.gifUrl);
            bundle.putString("staticUrl", this.staticUrl);
            bundle.putString("sharpText", this.sharpText);
            bundle.putInt("width", this.width);
            bundle.putInt("height", this.height);
        }
    }
}
