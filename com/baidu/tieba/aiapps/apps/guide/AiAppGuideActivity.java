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
/* loaded from: classes12.dex */
public class AiAppGuideActivity extends BaseActivity {
    private ImageView eKY;
    private GifView efO;
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
        this.efO = (GifView) findViewById(R.id.view_gif);
        this.efO.setGifRaw(R.raw.aiapp_guide);
        this.eKY = (ImageView) findViewById(R.id.img_close);
        this.eKY.setOnClickListener(this.mOnClickListener);
        int equipmentWidth = l.getEquipmentWidth(getActivity()) - (l.getDimens(getActivity(), R.dimen.tbds44) * 2);
        ViewGroup.LayoutParams layoutParams = this.efO.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (int) (((equipmentWidth * 828) * 1.0f) / 760.0f);
        this.efO.setLayoutParams(layoutParams);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setImageResource(this.eKY, R.drawable.icon_use_close_n);
    }
}
