package com.baidu.tieba.aiapps.apps.guide;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class AiAppGuideActivity extends BaseActivity {
    public static final int GIF_HEIGHT = 828;
    public static final int GIF_WIDTH = 760;
    public GifView mGifView;
    public ImageView mImgClose;
    public View.OnClickListener mOnClickListener = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiAppGuideActivity.this.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setImageResource(this.mImgClose, R.drawable.icon_use_close_n);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }
}
