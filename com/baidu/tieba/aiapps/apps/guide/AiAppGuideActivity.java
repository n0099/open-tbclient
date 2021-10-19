package com.baidu.tieba.aiapps.apps.guide;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AiAppGuideActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GIF_HEIGHT = 828;
    public static final int GIF_WIDTH = 760;
    public transient /* synthetic */ FieldHolder $fh;
    public GifView mGifView;
    public ImageView mImgClose;
    public View.OnClickListener mOnClickListener;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AiAppGuideActivity f49371e;

        public a(AiAppGuideActivity aiAppGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiAppGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49371e = aiAppGuideActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49371e.closeActivity();
            }
        }
    }

    public AiAppGuideActivity() {
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
        this.mOnClickListener = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
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
            setContentView(R.layout.activity_aiapp_guide);
            GifView gifView = (GifView) findViewById(R.id.view_gif);
            this.mGifView = gifView;
            gifView.setGifRaw(R.raw.aiapp_guide);
            ImageView imageView = (ImageView) findViewById(R.id.img_close);
            this.mImgClose = imageView;
            imageView.setOnClickListener(this.mOnClickListener);
            int k = l.k(getActivity()) - (l.g(getActivity(), R.dimen.tbds44) * 2);
            ViewGroup.LayoutParams layoutParams = this.mGifView.getLayoutParams();
            layoutParams.width = k;
            layoutParams.height = (int) (((k * GIF_HEIGHT) * 1.0f) / 760.0f);
            this.mGifView.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
