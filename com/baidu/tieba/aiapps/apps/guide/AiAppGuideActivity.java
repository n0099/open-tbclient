package com.baidu.tieba.aiapps.apps.guide;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AiAppGuideActivity extends BaseActivity {
    private ImageView cUv;
    private GifView clJ;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiAppGuideActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(R.layout.activity_aiapp_guide);
        this.clJ = (GifView) findViewById(R.id.view_gif);
        this.clJ.setGifRaw(R.raw.aiapp_guide);
        this.cUv = (ImageView) findViewById(R.id.img_close);
        this.cUv.setOnClickListener(this.mOnClickListener);
        int af = l.af(getActivity()) - (l.g(getActivity(), R.dimen.tbds44) * 2);
        ViewGroup.LayoutParams layoutParams = this.clJ.getLayoutParams();
        layoutParams.width = af;
        layoutParams.height = (int) (((af * 828) * 1.0f) / 760.0f);
        this.clJ.setLayoutParams(layoutParams);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.c(this.cUv, (int) R.drawable.icon_use_close_n);
    }
}
