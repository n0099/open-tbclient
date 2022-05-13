package com.baidu.tieba.aiapps.apps.guide;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.in;
import com.repackage.mi;
/* loaded from: classes3.dex */
public class AiAppGuideActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GIF_HEIGHT = 828;
    public static final int GIF_WIDTH = 760;
    public transient /* synthetic */ FieldHolder $fh;
    public GifView mGifView;
    public ImageView mImgClose;
    public View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AiAppGuideActivity a;

        public a(AiAppGuideActivity aiAppGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiAppGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aiAppGuideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.closeActivity();
            }
        }
    }

    public AiAppGuideActivity() {
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
        this.mOnClickListener = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setImageResource(this.mImgClose, R.drawable.icon_use_close_n);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            setContentView(R.layout.obfuscated_res_0x7f0d0029);
            GifView gifView = (GifView) findViewById(R.id.obfuscated_res_0x7f0923f4);
            this.mGifView = gifView;
            gifView.setGifFile(in.b("aiapp_guide.gif"));
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eb1);
            this.mImgClose = imageView;
            imageView.setOnClickListener(this.mOnClickListener);
            int k = mi.k(getActivity()) - (mi.f(getActivity(), R.dimen.tbds44) * 2);
            ViewGroup.LayoutParams layoutParams = this.mGifView.getLayoutParams();
            layoutParams.width = k;
            layoutParams.height = (int) (((k * GIF_HEIGHT) * 1.0f) / 760.0f);
            this.mGifView.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
